-- ex25_union.sql

/*

조인, join
- 테이블을 합치는 기술
- 횡(가로) 합치기

유니온, union
- 테이블을 합치는 기술
- 종(세로) 합치기
- union, union all, intersect,minus

*/

select * from tblMen;
select * from tblwomen;

-- 커플인 남녀 정보
select * from tblmen m
    inner join tblwomen w
        on m.name = w.couple;

-- 커플 + 남자 모두
select * from tblmen m
    left outer join tblwomen w
        on m.name = w.couple;

-- 커플 + 여자 모두
select * from tblmen m
    right outer join tblwomen w
        on m.name = w.couple;

-- 커플 + 남자 + 여자
select * from tblmen m
    full outer join tblwomen w
        on m.name = w.couple;

select * from tblmen 
union 
select * from tblwomen;


-- union 주의점
-- 1. 컬럼 개수
-- 2. 컬럼 타입
-- 3. 컬럼 성격(***)

desc tblmen;
select name, age, height from tblmen
union
select name, age, height from tblwomen;

-- union은 되지만 이렇게 하면 안된다.
select age from tblmen
union
select population from tblcountry;


select name, tel from tblinsa
union
select name, tel from tbladdressbook;


create table tbluniona
(
    name varchar2(30) not null
);

create table tblunionb
(
    name varchar2(30) not null
);

insert into tbluniona values ('사과');
insert into tbluniona values ('바나나');
insert into tbluniona values ('파인애플');
insert into tbluniona values ('망고');
insert into tbluniona values ('귤');

insert into tblunionb values ('자두');
insert into tblunionb values ('복숭아');
insert into tblunionb values ('포도');
insert into tblunionb values ('딸기');
insert into tblunionb values ('파인애플');

-- 합집합: 중복값이 존재하면 distinct 처리
select * from tbluniona
union
select * from tblunionb;

-- 중복값도 모두 보여줌
select * from tbluniona
union all
select * from tblunionb;

-- 교집합. 중복값을 보여줌
select * from tbluniona
intersect
select * from tblunionb;

-- 차집합: 순서 주의
-- a전체에서 b와의 중복값 제외 (a-b)
select * from tbluniona
minus
select * from tblunionb;
-- b전체에서 a와의 중복값 제외 (b-a)
select * from tblunionb
minus
select * from tbluniona;

