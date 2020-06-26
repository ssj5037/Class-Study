-- D:\class\JDBCTest\jdbc.sql

create table tblAddress (

    seq number primary key,                 -- 번호(PK)
    name varchar2(30) not null,             -- 이름
    age number(3) NOT NULL,                 -- 나이
    tel varchar2(15) null,                  -- 전화
    address varchar2(300) not null,         -- 주소
    regdate date default sysdate not null   --등록시간
);

create sequence seqAddress;

insert into tblAddress (seq, name, age, tel, address, regdate) values (seqAddress.nextval, '홍길동', 20, '010-1234-5678', '서울시 강남구 역삼동', default);
    
commit;

select * from tbladdress;

select * from tblAAA;

select * from tblinsa order by ibsadate desc;

---------------------------- 6/9

select name, gender, age, address from tbladdressbook where replace(lower(address), ' ', '') like '%' || replace(lower('시강'), ' ','') || '%' order by address;

select distinct buseo from tblinsa;
select * from tblinsa where buseo = '기획부';

select * from tblinsa where buseo = '기획부' 
order by case
    when jikwi = '부장' then 1
    when jikwi = '과장' then 2
    when jikwi = '대리' then 3
    when jikwi = '사원' then 4
end, name;

select * from tbladdress;




-- CallableStatement + 프로시저
-- m1()
create or replace procedure procM1(
    pname varchar2,
    page number,
    ptel varchar2,
    paddress varchar2
)
is 
begin
    insert into tbladdress values (seqaddress.nextval, pname, page, ptel, paddress, default);
end;

-- m2()
-- 반환값(단일 레코드 or 다중 레코드(cursor))
create or replace procedure procM2(
    pnum number,
    pname out varchar2,
    pbuseo out varchar2,
    pjikwi out varchar2
)
is
begin
    select name, buseo, jikwi into pname, pbuseo, pjikwi from tblinsa where num = pnum;
end;

-- m3()
create or replace procedure procM3(
    pname varchar2, --남자 이름
    wname out varchar2, --여자 이름
    wage out number --여자 나이
)
is
begin
    select name, age into wname, wage from tblwomen
        where couple = (select name from tblMen where name = pname);
end;

-- m4()
create or replace procedure procM4(
    pbuseo varchar2,
    presult out sys_refcursor
)
is
begin
    open presult for
        select * from tblinsa where buseo = pbuseo;
end;

-- m5()
create or replace procedure procM5(
    presult out sys_refcursor
)
is
begin
    open presult for
        select * from tbladdress;
end;


----------------------------------- 6/10

select * from tblboard;
select * from tblcomment;

create or replace procedure procAddComment(
    -- 댓글쓰기 매개변수
)
is
begin

    --1. 카운트 증가
    update tblboard set commentcount = commentcount + 1
        where seq = 1;
    --2. 댓글 쓰기
    insert into tblcomment (seq, subject, pseq)
        values (1, '댓글', 1);
       
    commit;

exception
    when others then
        rollback;

-- 프로시저 안에 두 개 이상의 DML이 들어간 경우 트랜잭션 처리를 무조건 오라클에서 처리한다.
end;


