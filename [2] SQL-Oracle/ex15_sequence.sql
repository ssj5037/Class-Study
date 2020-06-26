-- ex15_sequence.sql

/*

시퀀스, sequence
- 데이터베이스 객체 중 하나
- 식별자 생성 도구

시퀀스 객체 생성하기
- create sequence 시퀀스명;

시퀀스 객체 삭제하기
- drop sequence 시퀀스명;

시퀀스 객체 사용하기
1. 시퀀스명.nextVal
2. 시퀀스명.currVal

*/

select * from tblTodo;
select max(seq)+1 from tblTodo;

create sequence seqNum;

-- 1, 2, 3, 4, 5, ... 일련번호
select seqNum.nextVal from dual;

-- 'A001', 'A002', 'A003', ... 쇼핑몰 상품 번호
select 'A' || seqNum.nextVal from dual;
select 'A' || trim(to_char(seqNum.nextVal, '000')) from dual;


drop table tblMemo;
create table tblMemo
(
    seq number primary key,
    name varchar2(30),
    memo varchar2(1000),
    regdate date default sysdate
);

create sequence seqMemo;

insert into tblMemo (seq, name, memo) values (SEQMEMO.nextval, '홍길동', '메모입니다.');
-- 중간에 번호가 띄엄띄엄 띄어져있는 것들은 중요하지 않음. 중복값이 없다는 것에 의의가 있을 뿐이다.

select * from tblMemo;

-- ORA-08002: sequence SEQMEMO.CURRVAL is not yet defined in this session
-- 종료 후 접속했을 때, 한번이라도 nextVal을 써야지만 currVal을 쓸 수 있다.
-- => 이빠짐이 발생할 수 밖에 없다!
select seqMemo.currVal from dual;   -- 확인은 하지만 증가X -> peek()
select seqMemo.nextVal from dual;   -- 확인 할 때 마다 1씩 증가 -> pop()



-- 개발 중... > 서비스 오픈 > 번호 초기화(= 시퀀스 객체 리셋)
select seqMemo.nextVal from dual;

select * from tblMemo;

-- A. 
drop sequence seqMemo;
create sequence seqMemo 
    increment by 1  -- 시퀀스 증감치 지정(양수, 음수)
    start with 1    -- 시작값(seed)
    --maxvalue 10     -- 최댓값
    --minvalue 1      -- 최솟값
    --cycle           -- 최솟값~최댓값 루프
    cache 20
    ;

/*

시퀀스 객체 생성하기
create sequence 시퀀스명;
create sequence 시퀀스명
            increment by N  (*)
            start with N    (*)
            maxvalue N
            minvalue N
            cycle
            cache N;

정상종료시에는 디스크에 제대로 된 번호를 저장하지만,
예기치 못한 종료는 백업할 시간이 없어서 캐시값을 저장한다.
(개발자들은 보통 기본값을 쓴다.)

*/