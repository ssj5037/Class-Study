-- ex21_join.sql

/*

테이블의 관계

ERD, Entity Relational Diagram
- 엔티티 관계도
- 테이블의 관계를 표시해놓은 도식(설계도)


조인, Join

- 직원 테이블
- 담당 프로젝트

*/

drop table tblStaff;
create table tblStaff
(
    seq number              primary key,    -- 직원번호(PK)
    name varchar2(30)       not null,       -- 직원명
    salary number           not null,       -- 급여
    address varchar2(300)   not null,       -- 거주지
    project varchar2(300)   null            -- 담당 프로젝트명
);

insert into tblStaff(seq, name, salary, address, project)
    values (1, '홍길동', 300, '서울시', '홍콩 수출');
insert into tblStaff(seq, name, salary, address, project)
    values (2, '아무개', 250, '인천시', 'TV 광고');
insert into tblStaff(seq, name, salary, address, project)
    values (3, '하하하', 350, '대전시', '매출 분석');

-- 홍길동에세 프로젝트 1건 추가하기
insert into tblStaff(seq, name, salary, address, project)
    values (4, '홍길동', 300, '서울시', '고객 관리');
insert into tblStaff(seq, name, salary, address, project)
    values (5, '홍길동', 300, '서울시', '자재 관리');
    
select * from tblStaff;

-------------------------------------------------------------------

drop table tblStaff;
create table tblStaff
(
    seq number              primary key,    -- 직원번호(PK)
    name varchar2(30)       not null,       -- 직원명
    salary number           not null,       -- 급여
    address varchar2(300)   not null        -- 거주지
);

drop table tblproject;
create table tblProject
(
    seq number              primary key,    -- 프로젝트 번호(PK)
    project varchar2(300)   not null,       -- 프로젝트명
    staff number            null            -- 직원번호
);

insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff(seq, name, salary, address) values (2, '아무개', 250, '인천시');
insert into tblStaff(seq, name, salary, address) values (3, '하하하', 350, '대전시');

insert into tblProject (seq, project, staff) values (1, '홍콩 수출', 1);
insert into tblProject (seq, project, staff) values (2, 'TV 광고', 2);
insert into tblProject (seq, project, staff) values (3, '매출 분석', 3);
insert into tblProject (seq, project, staff) values (4, '자재 관리', 1);
insert into tblProject (seq, project, staff) values (5, '대리점 분양', 2);

select * from tblStaff;
select * from tblProject;

select seq, project, (select name from tblStaff where tblStaff.seq = tblProject.staff) as staff from tblProject;


-- 상황 A.
-- 신입 사원 입사 -> 신규 프로젝트 담당

-- A-1. 신입 사원 추가하기(O)
insert into tblStaff(seq, name, salary, address) values (4, '호호호', 250, '서울시');

-- A-2. 신규 프로젝트 추가하기(O)
insert into tblProject (seq, project, staff) values (6, '고객 유치', 4);

-- A-3. 신규 프로젝트 추가하기(O)
-- ORA-02291: integrity constraint (HR.SYS_C007154) violated - parent key not found
insert into tblProject (seq, project, staff) values (7, '해외 수출', 5);


commit;
rollback;

-- 상황 B.
-- '홍길동' 퇴사

-- B-1. '홍길동' 삭제
-- ORA-02292: integrity constraint (HR.SYS_C007154) violated - child record found
delete from tblStaff where name = '홍길동';

-- B-2. '홍길동'의 모든 업무 -> 위임
update tblProject set staff = 2 where staff = 1;

-- B-3. '홍길동' 삭제
delete from tblStaff where name = '홍길동';

-------------------------------------------------------------------

drop table tblStaff;
drop table tblproject;

-- tblStaff부터 만들어야한다. 지울때는 자식테이블부터.

create table tblStaff   -- 부모 테이블
(
    seq number              primary key,    -- 직원번호(PK)
    name varchar2(30)       not null,       -- 직원명
    salary number           not null,       -- 급여
    address varchar2(300)   not null        -- 거주지
);

create table tblProject -- 자식 테이블(부모테이블의 PK를 FK와 엮어서 참조 관계를 만든다.)
(
    seq number              primary key,    -- 프로젝트 번호(PK)
    project varchar2(300)   not null,       -- 프로젝트명
    staff number            not null references tblStaff(seq) -- 직원번호(Foreign key)
);

insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff(seq, name, salary, address) values (2, '아무개', 250, '인천시');
insert into tblStaff(seq, name, salary, address) values (3, '하하하', 350, '대전시');

insert into tblProject (seq, project, staff) values (1, '홍콩 수출', 1);
insert into tblProject (seq, project, staff) values (2, 'TV 광고', 2);
insert into tblProject (seq, project, staff) values (3, '매출 분석', 3);
insert into tblProject (seq, project, staff) values (4, '자재 관리', 1);
insert into tblProject (seq, project, staff) values (5, '대리점 분양', 2);

select * from tblStaff;
select * from tblProject;

select seq, project, (select name from tblStaff where tblStaff.seq = tblProject.staff) as staff from tblProject;

-- => 위의 시나리오 다시 실행

/*

관계를 맺고 있는 2개의 테이블을 조작할 때 발생하는 일
- 이 관계 규칙이 깨지면 데이터 무결성(유효성)이 깨진다. -> 데이터 가치 상실
- 반드시 지켜야 할 상황

1. 부모 테이블 조작(tblStaff)
    a. 행 추가(insert): 아무 영향 없음
    b. 행 수정(update): 아무 영향 없음
    c. 행 삭제(delete): 자식 테이블에 자신을 참조하는 행이 존재하는지 반드시 사전 체크 > FK

2. 자식 테이블 조작(tblProject)
    a. 행 추가(insert): 자신이 참조하는 대상이 실제로 존재하는지 반드시 사전 체크 > FK
    b. 행 수정(update): 자신이 참조하는 대상이 실제로 존재하는지 반드시 사전 체크 > FK
    c. 행 삭제(delete): 아무 영향 업슴

*/


-- 고객 테이블
create table tblCustomer
(
    seq number              primary key,  -- 고객번호(PK)
    name varchar2(30)       not null,     -- 고객명
    tel varchar2(15)        not null,     -- 전화
    address varchar2(100)   not null      -- 주소
);

-- 판매 테이블
drop table tblSales;
create table tblSales
(
    seq number              primary key,  -- 판매번호(PK)
    item varchar2(30)       not null,     -- 제품명
    qty number              not null,     -- 수량
    regdate date default sysdate not null,-- 판매날짜
    cseq number             not null references tblCustomer(seq)    -- 고객번호(FK)
);

select * from tblCustomer;
select * from tblSales;

-- 장르 테이블
create table tblGenre
(
    seq number          primary key,    -- 장르번호(PK)
    name varchar2(30)   not null,       -- 장르명
    price number        not null,       -- 대여 가격(원)
    period number       not null        -- 대여 기간(일)
);

create sequence genreSeq;

-- 비디오 테이블
create table tblVideo
(
    seq number              primary key,    -- 비디오번호(PK)
    name varchar2(100)      not null,       -- 제목
    qty number              not null,       -- 보유수량
    company varchar2(50)    null,           -- 제작사
    director varchar2(50)   null,          -- 감독
    major varchar2(50)      null,           -- 주연배우
    genre number            not null references tblGenre(seq) -- 대여 기간(일)
);

create sequence videoSeq;

-- 회원 테이블
create table tblMember
(
    seq number              primary key,    -- 회원번호(PK)
    name varchar2(30)       not null,       -- 회원명
    grade number(1)         not null,       -- 회원등급(1,2,3)
    byear number(4)         not null,       -- 생년
    tel varchar2(15)        not null,       -- 연락처
    address varchar2(300)   null,           -- 주소
    money number            not null        -- 예치금
);

create sequence memberSeq;

-- 대여 테이블
create table tblRent
(
    seq number              primary key,    -- 대여번호(PK)
    member number           not null references tblMember(seq), -- 회원번호(FK)
    video number            not null references tblVideo(seq),  -- 비디오번호(FK)
    rentdate date default sysdate not null,           -- 대여시각
    retdate date            null,       -- 반납 시각
    remart varchar2(500)    null        -- 비고
);

create sequence rentSeq;

select * from tblgenre;     --6
select * from tblvideo;     --11
select * from tblmember;    --10
select * from tblrent;      --6


/*

조인, join
- (서로 관계를 맺은) 2개(1개) 이상의 테이블의 내용을 가져와서 1개의 결과셋으로 만드는 작업

조인의 종류(ANSI)
1. 단순 조인, cross join
2. 내부 조인, inner join
3. 외부 조인, outer join
4. 셀프 조인, self join
5. 전체 외부 조인, full outer join

*/

-- 1. 단순 조인
select * from tblCustomer;  --3
select * from tblSales;     --9

-- 3명 x 9건 = 27
select * from tblCustomer cross join tblSales;  -- ANSI SQL
select * from tblCustomer, tblSales;            -- Oracle
-- 테스트용 더미데이터를 만들 때만 쓰인다.

------------------------------------------------------------------------------
-- 2. 내부 조인, inner join
-- 단순 조인에서 유효한 레코드만 추출하는 조인
-- 테이블 적어야하는 순서는 정해져있지 않지만 관습적으로 부모테이블을 먼저 씀.

-- ORA-00918: column ambiguously defined
-- 두 테이블 모두에 seq가 있기 때문에.
select * from tblCustomer inner join tblSales on seq = cseq;
select * from tblCustomer inner join tblSales on tblCustomer.seq = cseq;
-- alias
-- join에서는 모든 column 앞에 테이블명을 붙여주는 것이 관습이다.
select s.seq, s.item, s.qty, s.regdate, c.name from tblCustomer c 
    inner join tblSales s 
        on c.seq = s.cseq; 
-- 부모테이블(PK) = 자식테이블(FK) : 두 테이블의 관계를 이것으로 맺어놨기 때문에 거의 100% 이렇게 씀


select * from tblGenre; -- 부모
select * from tblVideo; -- 자식

select v.name, v.director, v.major, g.price, g.name, g.period from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre;


select s.name, s.salary, p.project from tblStaff s
    inner join tblProject p
        on s.seq = p.staff
order by s.name;

-- 두 테이블 간에 아무런 관계도 없는데 조인하지 말기.
-- join은 잘 되긴 하지만 하면 안됨..
select * from tbltodo;
select * from tblsales;

select * from tbltodo t
    inner join tblsales s
        on t.seq = s.seq;


-- tblgenre + tblvideo
select * from tblgenre g
    inner join tblvideo v
        on g.seq = v.seq;

-- tblgenre + tblvideo + tblrent
select * from tblgenre g
    inner join tblvideo v
        on g.seq = v.genre
    inner join tblrent r
        on v.seq = r.video;

-- tblgenre + tblvideo + tblrent + tblmember
select m.name, v.name, r.rentdate, g.period from tblgenre g
    inner join tblvideo v
        on g.seq = v.genre
    inner join tblrent r
        on v.seq = r.video
    inner join tblmember m
        on m.seq = r.member ;

------------------------------------------------------------------------------
-- 3. 외부 조인, outer join
-- 내부 조인 기반 + 부모 테이블(나머지 레코드)
select * from tblCustomer;
select * from tblsales;

insert into tblcustomer values(4, '호호호', '010-1234-5678', '서울시');

-- 내부 조인:: (구매 이력이 1건 이상인) 고객의 정보와 함께 구매 정보를 가져오시오.
select * from tblcustomer c
    inner join tblsales s
        on c.seq = s.cseq
order by c.seq asc;

-- 내부 조인:: (구매 이력과 상관없이) 고객의 정보와 함께 구매 정보를 가져오시오.
-- left: tblcustomer를 가리킴
-- right: tblsales를 가리킴
select * from tblcustomer c
    ㄷleft outer join tblsales s
        on c.seq = s.cseq
order by c.seq asc;

-- tblstaff + tblproject
-- 내부조인 : 프로젝트를 1건 이상 담당한 직원의 정보 + 프로젝트 정보
-- 외부조인 : 프로젝트 담당 유무와 상관없이 모든 직원 정보 + 프로젝트 정보

select * from tblmember;    --10
select * from tblrent;      --6

select * from tblmember m
    inner join tblrent r
        on m.seq = r.member;    -- 자식 테이블의 레코드 수 == 내부 조인 결과

select * from tblmember m
    left outer join tblrent r
        on m.seq = r.member;
        
------------------------------------------------------------------------------
-- 4. 셀프 조인, self join
-- 1개의 테이블을 사용해서 조인
-- 단순 조인, 내부 조인, 외부 조인 <> 셀프 조인
-- 단순 조인 + 셀프 조인, 내부 조인 + 셀프 조인, 외부 조인 + 셀프 조인

-- 직원 테이블
create table tblself
(
    seq number              primary key,    -- 직원 번호(PK)
    name varchar2(30)       not null,       -- 직원명
    department varchar2(50) null,           -- 부서명
    super number            null references tblself(seq)    -- 상사번호(FK)
);

insert into tblself values (1, '홍사장', null, null);

insert into tblself values (2, '김부장', '영업부', 1);
insert into tblself values (3, '이과장', '영업부', 2);
insert into tblself values (4, '정대리', '영업부', 3);
insert into tblself values (5, '최사원', '영업부', 4);

insert into tblself values (6, '박부장', '개발부', 1);
insert into tblself values (7, '하과장', '개발부', 6);

select 
    s1.name as 직원명,
    s1. department as 부서명,
    s2. name as 상사명
from tblself s1
    inner join tblself s2
        on s1.super = s2.seq;

select 
    s1.name as 직원명,
    s1. department as 부서명,
    s2. name as 상사명
from tblself s1
    left outer join tblself s2
        on s1.super = s2.seq;

