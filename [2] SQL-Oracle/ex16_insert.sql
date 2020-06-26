-- ex16_insert.sql

/*

insert 문
- DML
- 데이터를 테이블에 추가하는 명령하기(행, 레코드)
- insert into 테이블명(컬럼리스트) values (값리스트);


*/

drop table tblMemo;
create table tblMemo
(
    seq number primary key,
    name varchar2(30) default '익명' not null,
    memo varchar2(1000)             not null,
    regdate date default sysdate    null
);

drop sequence seqMemo;
create sequence seqMemo;


-- 1. 표준: 원본 테이블에 정의된 컬럼 순서대로 컬럼리스트와 값리스트를 구성하는 방식
insert into tblMemo (seq, name, memo, regdate) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.', sysdate);

-- 2. 컬럼리스트의 순서와 값리스트의 순서는 반드시 일치해야 한다.
-- ORA-01841: (full) year must be between -4713 and +9999, and not be 0
insert into tblMemo (seq, memo, regdate, name) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.', sysdate);
        
-- 3. 원본 테이블의 정의된 컬럼 순서와 insert 컬럼 순서는 무관하다.
insert into tblMemo (seq, memo, regdate, name) 
        values (SEQMEMO.nextval, '메모입니다.', sysdate, '홍길동');

-- 4. 00947. 00000 -  "not enough values"
insert into tblMemo (seq, name, memo, regdate) 
        values (SEQMEMO.nextval, '홍길동', sysdate);

-- 5. 00913. 00000 -  "too many values"
insert into tblMemo (seq, name, regdate) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.', sysdate);

-- 6. null 컬럼 조작
-- 6-a. null 컬럼에 값을 명시적으로 대입 -> 값 들어감
insert into tblMemo (seq, name, memo, regdate) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.', sysdate);
-- 6-b. null 컬럼에 null을 명시적으로 대입 -> null 들어감
insert into tblMemo (seq, name, memo, regdate) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.', null);
-- 6-c. null 컬럼에 암시적으로 대입 -> null 대입 -> default 값 들어감, default가 없으면 null 들어감.
insert into tblMemo (seq, name, memo) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.');

-- 7. default
-- 7-a. 암시적
insert into tblMemo (seq, name, memo) 
        values (SEQMEMO.nextval, '홍길동', '메모입니다.');
insert into tblMemo (seq, memo) 
        values (SEQMEMO.nextval, '메모입니다.');
-- 7-b. 명시적 -> default상수 활용
-- 위 아래가 같은 코드지만, 컬럼에 뭐가 있는지 모르기 때문에 아래처럼 쓰는 것이 좋다.
insert into tblMemo (seq, name, memo, regdate) 
        values (SEQMEMO.nextval, default, '메모입니다.', default);

-- 8. 단축 표현법 -> 테이블 원본의 컬럼 리스트 순서+개수를 따른다.
insert into tblMemo values (SEQMEMO.nextval, '홍길동', '메모입니다.', sysdate);
insert into tblMemo values (SEQMEMO.nextval, '메모입니다.', '홍길동', sysdate);
insert into tblMemo values (SEQMEMO.nextval, '메모입니다.', sysdate, '홍길동'); --error
insert into tblMemo values (SEQMEMO.nextval, '메모입니다.', '홍길동');          --error
insert into tblMemo values (SEQMEMO.nextval, default, '메모입니다.', default);

select * from tblMemo;


-------------------------------------------------------------------------------------------

create table tblMemo2
(
    seq number primary key,
    name varchar2(30) default '익명' not null,
    memo varchar2(1000)             not null,
    regdate date default sysdate    null
);

select * from tblMemo2;

-- 서브 쿼리
-- 테이블을 한꺼번에 복사
insert into tblMemo2 select * from tblMemo;


-- create + insert  한꺼번에
-- 테이블의 제약 사항이 복사가 안된다. -> 개발용으로만 사용한다. (테스트용 더미데이터)
create table tblMemo3
as
select * from tblMemo;

select * from tblMemo3;

