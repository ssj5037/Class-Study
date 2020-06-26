-- ex28_account.sql

/*

계정
- DCL
- 계정 생성, 수정, 삭제
- 리소스 접근 권한 제어


사용자 계정 생성하기
- 시스템 권한을 가지고 있는 계정만 가능하다.
    - 관리자만 가능(system, 관리자 권한 부여받은 계정)
    - 계정 생성 권한을 가지는 일반 계정

create user 계정명 identified by 암호;

- 암호 변경/ 잠금언락, 락
alter user 계정명 identified by 암호;
alter user 계정명 account unlock;
alter user 계정명 account lock;

- 계정 삭제
drop user 계정명;

*/

-- system
create user test identified by java1234;

-- 계정 생성을 하면 접속 권한이 없어서 로그인 실패가 뜬다.
-- 계정 권한을 제어하는 방법
-- 1. grant 권한 to 계정명 : 권한 부여
-- 2. revoke 권한 to 계정명 : 권한 상실

grant create session to test; -- 로그인 권한(create session) 부여

-- connect, resource는 roll임.
-- 둘은 일반 계정이라면 가지고 있어야할 기본적인 권한들을 모아둔 롤이다.
grant connect, resource to test;

-- 프로젝트 진행
-- 1. 프로젝트 전용 계정 생성
create user project identified by java1234;

-- 2. 권한 부여
grant connect, resource to project;

-- 3. 권한 뺏기
revoke connect from project;
