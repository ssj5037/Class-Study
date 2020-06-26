-- ex03_select.sql

/*

select 문
- DML, DQL
- 사용 빈도가 가장 높다.
- 목적: 데이터베이스로부터 원하는 데이터를 가져오는 명령어(읽기)

select 컬럼리스트 from 테이블명 where 검색조건
- 자세한 내용: google 검색 > sql 11g select documentation

a. select 컬럼리스트 
b. from 테이블명 
c. where 검색조건

문장을 구성하는 각 절들은 실행 순서가 이미 정해져 있다.
1. from 테이블명
2. where 검색조건
3. select 컬럼리스트


1. select 절 : 해당 테이블에서 가져올 컬럼을 지정한다.
2. from 절 : 데이터를 가져올 테이블을 지정한다.


*/

select *        -- 2 
from employees; -- 1

-- 현재 접근 가능한 테이블 목록
select * from tabs;     -- tabs(tables) : 시스템 테이블
-- 모든 테이블은 사용자에게 종속되어있다. 사용자(scheme, 스키마)가 달라지면 영역이 바뀌기 때문에 접근 가능 테이블 목록도 달라진다.

select * from departments;      -- 본인 영역
select * from hr.departments;   -- 남의 영역
-- 권한을 받으면 내 소유가 아닌 테이블도 볼 수 있다. (관리자는 모두 볼 수 있음)
-- 소유주.해당테이블

-- scott
-- DEPT
-- EMP
-- BONUS
-- SALGRADE

-- select 컬럼리스트 유형
-- 1. *(all) : 모든 컬럼
select * from EMP;

-- 2. 컬럼명
select ename from emp;
select ename, job, hiredate from emp;
select ename, length(ename) from emp;

-- ORA-00904: "WEIGHT": invalid identifier
-- 모를 때 에러코드로 검색하는게 가장 빠르다. ORA-00904
select ename, weight from emp;

-- ORA-00942: table or view does not exist
select ename from empp;
select ename from emp;  -- 오타가 안났는데 오류가 나면, 접속 계정 확인하기

-- 정석 (근데 이렇게 잘 안씀, 다 생략한다)
select scott.emp.ename from scott.emp;

desc emp;   -- 테이블의 스키마를 보여준다.





