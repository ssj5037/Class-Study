-- ex28-1_account-test.sql

-- 계정을 막 생성하면 table 아무것도 없음.
select * from tabs;

-- table 생성 권한도 없다.
-- 기본적인 권한들을 일일히 부여해주어야 한다.
-- system 계정으로 (grant connect, resource to test;)를 이용하여 권한 부여를 한 후 사용 가능.
create table tblTest
(
    seq number primary key
);