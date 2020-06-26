-- ex02_datatype.sql
/*

ANSI-SQL 자료형
- 오라클 자료형

1. 숫자형
    a. number
        - 정수 + 실수
        - (유효자리)38자리 이하의 숫자를 표현하는 자료형
        - 5~22byte
        - number(precision, scale)
            1. precision: 소수 이하를 포함한 전체 자릿수(1~38)
            2. scale: 소수점 이하 자릿수(0~127)
        - ex) number : 유효자리 38자리 유지한 모든 숫자(정수+실수)
        - ex) number(3) : 3자리까지 표현 가능한 정수 (-999 ~ 999)
        - ex) number(4,2) : 4자리까지 표현 가능한 숫자 + 소수 이하는 2자리까지 표현(-99.99 ~ 99.99)

2. 문자형
    - 문자형 + 문자열
    - 자바의 String과 유사
    a. char
        - 고정 자릿수 문자열
            (데이터 크기가 얼마인지 상관 없이 정해진 크기만큼 공간이 잡힌다.)
        - char(n) : n > 자릿수 문자열, n(바이트)
        - 최소 크기 : 1바이트
        - 최대 크기 : 2000바이트
        - ex) char(3) : 최대 3바이트짜리 문자열을 저장. 영어(3자), 한글(1자)
        - ex) char(10) : 최대 10바이트짜리 문자열을 저장. 영어(10자), 한글(3자)
        - ex) char(2000) : 최대 2000바이트짜리 문자열을 저장. 영어(2000자), 한글(666자)
        - ex) char(3) : 최대 3바이트짜리 문자열을 저장
    b. nchar
        - n: National > 유니코드 지원 > UTF-16 동작 > 모든 문자 2바이트 저장
        - nchar(n) : n자리 문자열, n(문자)
        - 최소 크기 : 1글자(2바이트)
        - 최대크기 : 1000글자(2000바이트)
    c. varchar2 (*****)
        - 가변 자릿수 문자열
            (데이터가 있는 크기 만큼 공간이 잡힌다.)
        - varchar2(n) : n자리 문자열, n(바이트)
        - 최소 크기 : 1바이트
        - 최대 크기 : 4000바이트
    d. nvarchar2
        - n: National > 유니코드 지원 > UTF-16 동작 > 모든 문자 2바이트 저장
        - nvarchar2(n) : n자리 문자열, n(문자)
        - 최소 크기 : 1글자
        - 최대 크기 : 1000글자
    e. 비교
        - char vs varchar2 : 저장 길이
        - char vs nchar : 문자 길이

3. 날짜/시간형
    - 자바 Calendar, Date
    a. date (*****)
        - 년월일시분초
        - 7byte
        - 기원전 4712년 1월 1일 ~ 9999년 12월 31일
        - 0000-00-00
    b. timestamp
        - 년월일시분초 + 밀리초(나노초)
    c. interval > number 대치
        - 시간
        - 틱값
4. 이진 데이터 자료형
    - 비 텍스트 데이터 > 파일(하드 직접 저장) + DB(파일명) -> '터미네이터.mp4'
        (사진을 첨부해도 사진을 DB에 저장하는 것이 아닌 사진의 이름을 DB에 저장함. 잘 안씀)
    - 이미지, 영상, 음악 등..
    a. blob
        - 최대 128TB

*/

drop table tblType;

create table tblType
(
    -- 컬럼 구성
    -- 컬럼명 자료형
    -- num number
    -- num number(3)
    -- num number(4,2)
    
    -- txt char(30),
    -- txt2 varchar2(30)
    
    txt nchar(3)
);

-- 데이터 추가하기(행 추가)
insert into tblType (num) values (100);     -- 정수
insert into tblType (num) values (3.14);    -- 실수
insert into tblType (num) values (12345678901234567890123456789012345678);
insert into tblType (num) values (123456789012345678901234567890123456789);
insert into tblType (num) values (1234567890123456789012345678901234567890123456);

insert into tblType (num) values (999);
insert into tblType (num) values (1000);
insert into tblType (num) values (-999);

insert into tblType (num) values (99.99);
insert into tblType (num) values (-99.99);
insert into tblType (num) values (0);

insert into tblType (txt) values (100);     -- 암시적 형변환 발생 (숫자 > 문자)

-- SQL 문자 리터럴 표현법 > '문자열' (쌍따옴표(") 안씀)
insert into tblType (txt) values ('100');   -- 정석
insert into tblType (txt) values ('abc');
insert into tblType (txt) values ('abcd');  -- value too large for column
insert into tblType (txt) values ('100');
insert into tblType (txt) values ('100');

insert into tblType (txt, txt2) values ('abc', 'abc');

insert into tblType (txt) values ('가');
insert into tblType (txt) values ('가나');
insert into tblType (txt) values ('가나다');
insert into tblType (txt) values ('가나다라');
insert into tblType (txt) values ('abc');
insert into tblType (txt) values ('abcd');

-- 데이터 가져오기
select * from tblType;



create table tblType2
(
    name varchar2(10),  -- 이름
    age number(3),      -- 나이
    birthday date       -- 생일
);

insert into tblType2 (name, age, birthday) values ('홍길동', 20, '1995-01-20');

select * from tblType2;     -- 95/01/20 (client tool의 출력 옵션임. 나중에 문법을 통해 다르게 출력할 수 있음.)






