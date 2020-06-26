-- ex31_plsql.sql

/*

PL/SQL
- Procedural Language Extensions to SQL

ANSI-SQL
- 비 절차성 언어(순서가 없고, 연속적이지 않다.) -> 문장 단위 구조
- ANSI-SQL + 절차적 기능 추가 -> 오라클 -> PL/SQL

SQL 처리 순서
1. ANSI-SQL
    : 클라이언트 구문 작성(select) -> 실행(Ctrl+Enter) -> 명령어가 오라클에게 전달
      -> 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 처리
    : 위의 구문(select)을 다시 실행 한다. -> 위의 과정을 처음~끝까지 동일하게 반복

2. PL/SQL
    : 클라이언트 구문 작성(select) -> 실행(Ctrl+Enter) -> 명령어가 오라클에게 전달
      -> 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 처리
    1. 처음 실행 : 위의 과정 처음~끝까지 실행
    2. 이후 반복 실행: '구문 분석(파싱) -> 컴파일' 생략됨
        : (저장)프로시저(=Stored Procedure)


프로시저, Procedure
- 메서드, 함수, 서브루틴 등..
- 순서가 있는 코드의 집합
1. 익명 프로시저 -> 1회용 코드 -> PL/SQL은 프로시저가 아니면 실행을 못한다.
2. 실명 프로시저 -> 반복 코드


PL/SQL 프로시저 블럭 구조

1. 4개의 키워드로 구성
    - declare
    - begin
    - exception
    - end

2. declare
    - 선언부
    - 프로시저에서 사용할 변수, 객체 등을 선언하는 영역
    - 생략 가능

3. begin
    - 실행부(begin ~ end)
    - 구현되는 코드를 가지는 영역(메서드 body 역할)
    - 생략 불가능
    - 연산, 제어 + ANSI-SQL 등으로 구성

4. exception
    - 예외 처리부
    - catch 역할
    - 예외 처리 코드를 작성
    - 생략 가능

5. end
    - begin 블럭의 종료 역할
    - 생략 불가능

6. PL/SQL 블럭 중첩

begin
    ANSI-SQL
    begin
        begin
        end;
    end;
end;


변수 + 자료형

자료형
- 오라클과 동일(유사->확장)

변수 선언하기
- 변수명 자료형 [not null][default 값]
- 변수는 질의의 결과나 인자를 저장하는 용도

대입 연산자
- 오라클과 동일
- 변수명 := 값(PL)
- 컬럼명 = 값(ANSI)

*/
SET SERVEROUTPUT ON;

DECLARE
    num    NUMBER;
    name   VARCHAR2(30);
    today  DATE;
BEGIN
    num := 10;
    dbms_output.put_line(num);
    name := '홍길동';
    dbms_output.put_line(name);
    today := sysdate;
    dbms_output.put_line(today);
    dbms_output.put_line(to_char(today, 'yyyy-mm-dd'));
END;

DECLARE
    num   NUMBER DEFAULT 100;
    num2  NUMBER NOT NULL DEFAULT 200;
BEGIN
    dbms_output.put_line(num);
    
    --num2 := 200;
    dbms_output.put_line(num2);
END;







/*
변수 -> 테이블 select 결과를 담는 용도
- 질의의 결과가 단일값이어야 한다.
    a. 결과셋이 1개의 레코드와 1개의 컬럼으로 구성(원자값) -> PK을 조건으로 하는 경우
    b. 집계함수의 결과값

select into 절
1. 1행 1열
2. 1행 N열

프로시저내에서는 select문을 그냥 사용 못한다. 
    -> 반드시 select의 결과를 PL/SQL 변수에 옮겨 담아야 한다.
*/

DECLARE
    vbuseo VARCHAR2(15);
BEGIN
    SELECT
        buseo
    INTO vbuseo
    FROM
        tblinsa
    WHERE
        name = '홍길동';

    dbms_output.put_line(vbuseo);
END;

DECLARE
    vbuseo  VARCHAR2(15);
    vname   VARCHAR2(15);
BEGIN
    vname := '홍길동';
    SELECT
        buseo
    INTO vbuseo
    FROM
        tblinsa
    WHERE
        name = vname;

    dbms_output.put_line(vbuseo);
END;

DECLARE
    vcnt NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO vcnt
    FROM
        tblinsa
    WHERE
        buseo = '기획부';

    dbms_output.put_line('기획부 직원수: '
                         || vcnt
                         || '명');
END;


-- 1행 N열

DECLARE
    vname   VARCHAR2(20);
    vbuseo  VARCHAR2(15);
    vjikwi  VARCHAR2(15);
BEGIN
    SELECT
        name,
        buseo,
        jikwi
    INTO
        vname,
        vbuseo,
        vjikwi
    FROM
        tblinsa
    WHERE
        num = '1001';

    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
END;


/*
참조형
- 원본의 자료형을 몰라도 된다.
- 유지 보수성이 좋다.

1. %type
    - 사용하는 테이블의 특정 컬럼의 자료형을 그대로 참조해서 적용
    - 복사되는 정보
        a. 자료형
        b. 길이
        c. not null 제약
*/

DECLARE
    vname tblinsa.name%TYPE;
BEGIN
    SELECT
        name
    INTO vname
    FROM
        tblinsa
    WHERE
        num = '1001';

    dbms_output.put_line(vname);
END;

DECLARE
    vname   tblinsa.name%TYPE;
    vbuseo  tblinsa.buseo%TYPE;
    vjikwi  tblinsa.jikwi%TYPE;
BEGIN
    SELECT
        name,
        buseo,
        jikwi
    INTO
        vname,
        vbuseo,
        vjikwi
    FROM
        tblinsa
    WHERE
        num = '1001';

    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
END;

SELECT
    *
FROM
    tblinsa;

-- 직원 중 일부에게 보너스 지급 -> 내역 저장

CREATE TABLE tblbonus (
    seq    NUMBER PRIMARY KEY,
    name   VARCHAR2(15) NOT NULL,
    bonus  NUMBER NOT NULL
);

SELECT
    *
FROM
    tblinsa
WHERE
        city = '서울'
    AND jikwi = '부장'
    AND months_between(sysdate, ibsadate) / 12 >= 14;

DECLARE
    vname    tblinsa.name%TYPE;
    vsudang  tblinsa.sudang%TYPE;
BEGIN
    SELECT
        name,
        sudang * 3
    INTO
        vname,
        vsudang
    FROM
        tblinsa
    WHERE
            city = '서울'
        AND jikwi = '부장'
        AND months_between(sysdate, ibsadate) / 12 >= 14;

    dbms_output.put_line(vname);
    dbms_output.put_line(vsudang);
    INSERT INTO tblbonus (
        seq,
        name,
        bonus
    ) VALUES (
        1,
        vname,
        vsudang
    );

END;

INSERT INTO tblbonus (
    seq,
    name,
    bonus
) VALUES (
    1,
    (
        SELECT
            name
        FROM
            tblinsa
        WHERE
                city = '서울'
            AND jikwi = '부장'
            AND months_between(sysdate, ibsadate) / 12 >= 14
    ),
    ( (
        SELECT
            sudang * 3
        FROM
            tblinsa
        WHERE
                city = '서울'
            AND jikwi = '부장'
            AND months_between(sysdate, ibsadate) / 12 >= 14
    ) )
);

SELECT
    *
FROM
    tblbonus;



/*
참조형
1. %type
    - 컬럼을 참조
2. %rowtype
    - 행을 참조(여러개의 컬럼을 한번에 참조)
    - %type의 집합형
*/

DECLARE
    vrow tblinsa%rowtype; -- 행 참조 변수
BEGIN
--    select num, name, ssn, ibsadate, city, tel, buseo, jikiw, basicpay, sudang
--        into vnum, vname, vssn, vibsadate, vcity, vtel, vbuseo, vjikiw, vbasicpay, vsudang
--        from tblInsa
--            where num = '1001';
    SELECT
        *
    INTO vrow
    FROM
        tblinsa
    WHERE
        num = '1001';
    
    --dbms_output.put_line(vrow);

    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.jikwi);
    dbms_output.put_line(vrow.basicpay);
END;

-- ANSI-SQL + PL/SQL
-- 오라클은 키워드(구문)에서 대소문자를 구분하지 않는다.
-- 데이터의 대소문자는 구분한다.
-- 오라클은 컴파일 시 모든 키워드를 대문자로 변환 -> 저장
--     a. 사용자 쿼리 -> 구문만 대문자, 데이터 유지
--     b. 시스템 쿼리, DB 객체 생성 -> 모든 구문 대문자 변환
-- 데이터베이스 객체를 저장시에도 객체명이 대문자로 변환되어 저장(*****)

SELECT
    *
FROM
    tblinsa;

SELECT
    *
FROM
    tblinsa;

SELECT
    *
FROM
    employees
WHERE
    first_name = 'Steven';

SELECT
    *
FROM
    employees
WHERE
    first_name = 'steven';

SELECT
    *
FROM
    employees
WHERE
    first_name = 'STEVEN';

-- 시스템 테이블(오라클이 관리하는 정보를 저장하는 테이블)

SELECT
    *
FROM
    tabs
WHERE
    table_name = 'TBLINSA';


/**/

-- 제어문
-- 조건문

SET SERVEROUTPUT ON;

DECLARE
    vnum NUMBER := 10;
BEGIN
    IF vnum > 0 THEN
        dbms_output.put_line('양수');
    END IF;
END;

DECLARE
    vnum NUMBER := -11;
BEGIN
    IF vnum > 0 THEN
        dbms_output.put_line('양수');
    ELSE
        dbms_output.put_line('음수');
    END IF;
END;

DECLARE
    vnum NUMBER := 0;
BEGIN
    IF vnum > 0 THEN
        dbms_output.put_line('양수');
    ELSIF vnum < 0 THEN -- else if, elseif, elsif 등.. 언어마다 모두 다름
        dbms_output.put_line('음수');
    ELSE
        dbms_output.put_line('영');
    END IF;
END;

DECLARE
    vgender CHAR(1); -- 성별
BEGIN
    SELECT
        substr(ssn, 8, 1)
    INTO vgender
    FROM
        tblinsa
    WHERE
        num = '1003';

    IF vgender = '1' THEN
        -- 남자 직원 업무 추가(select, insert...)
        dbms_output.put_line('남자 업무 추가');
    ELSE
        -- 여자 직원 업무 추가(select, insert...)
        dbms_output.put_line('여자 업무 추가');
    END IF;

END;

COMMIT;

ROLLBACK;

DECLARE
    -- %type
    -- %rowtype
    vrow  tblinsa%rowtype;
    --vnum number(5);
    vnum  tblinsa.num%TYPE;
BEGIN
    vnum := 1001;
    SELECT
        *
    INTO vrow
    FROM
        tblinsa
    WHERE
        num = vnum;

    IF
        vrow.basicpay > 2000000 AND substr(vrow.ssn, 1, 2) = '87'
    THEN
        UPDATE tblinsa
        SET
            sudang = 1000000
        WHERE
            num = vnum;
       -- dbms_output.put_line('처리O');

    ELSE
        DELETE FROM tblinsa
        WHERE
            num = vnum;
        --dbms_output.put_line('처리X');

    END IF;

END;

SELECT
    *
FROM
    tblinsa
WHERE
    num = '1001';


-- case문
-- 자바의 switch case문과 유사
-- ANSI-SQL의 case와는 다른 구문

DECLARE
    vname        tblcountry.name%TYPE;
    vcontinent   tblcountry.continent%TYPE;
    vpopulation  tblcountry.population%TYPE;
    vresult      VARCHAR2(30);
BEGIN
    SELECT
        name,
        continent,
        population
    INTO
        vname,
        vcontinent,
        vpopulation
    FROM
        tblcountry
    WHERE
        name = '대한민국';

    IF vcontinent = 'AS' THEN
        vresult := '아시아';
    ELSIF vcontinent = 'EU' THEN
        vresult := '유럽';
    ELSE
        vresult := '기타';
    END IF;

    dbms_output.put_line(vresult);
    
    -- case end, case when
    CASE vcontinent
        WHEN 'AS' THEN
            vresult := '아시아';
        WHEN 'EU' THEN
            vresult := '유럽';
        ELSE
            vresult := '기타'; --ansi-sql: default
    END CASE;

    dbms_output.put_line(vresult);
    
    -- 범위 비교
    CASE
        WHEN vpopulation > 10000 THEN
            vresult := '너무 많음';
        WHEN vpopulation > 5000 THEN
            vresult := '조금 많음';
        WHEN vpopulation > 1000 THEN
            vresult := '적당함';
        ELSE
            vresult := '모자람';
    END CASE;

    dbms_output.put_line(vresult);
END;

/*

반복문

1. loop
    - 조건 반복
2. for loop
    - 지정 횟수 반복(자바의 for)
3. while loop
    - 조건 반복(자바의 while)

*/

-- 무한 루프

BEGIN
    LOOP
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
    END LOOP;
END;

-- 무한 루프 + 조건 탈출

DECLARE
    vnum NUMBER := 1;
BEGIN
    LOOP
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        --exit; --break문
        vnum := vnum + 1;
        EXIT WHEN vnum > 10;
    END LOOP;
END;

CREATE TABLE tblloop (
    seq   NUMBER PRIMARY KEY,
    data  VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE loopseq;

-- 데이터 x 1000건
-- 데이터1 > 데이터2 > 데이터3 ... > loop

DECLARE
    vnum NUMBER := 1;
BEGIN
    LOOP
        INSERT INTO tblloop (
            seq,
            data
        ) VALUES (
            loopseq.NEXTVAL,
            '데이터' || vnum
        );

        vnum := vnum + 1;
        EXIT WHEN vnum = 1001;
    END LOOP;
END;

SELECT
    COUNT(*)
FROM
    tblloop;


/*

2. for loop
    - 지정횟수 반복

*/

BEGIN
    -- i : 루프 변수
    -- 1 : 초깃값
    -- 10 : 최댓값
    -- .. : 증가
    FOR i IN 1..10 LOOP
        dbms_output.put_line('숫자: ' || i);
    END LOOP;
END;

CREATE TABLE tblgugudan (
    seq     NUMBER PRIMARY KEY,
    dan     NUMBER NOT NULL,
    num     NUMBER NOT NULL,
    result  NUMBER NOT NULL
);

CREATE SEQUENCE gugudanseq;

DECLARE
    vdan     NUMBER;
    vnum     NUMBER;
    vresult  NUMBER;
BEGIN
    FOR dan IN 2..9 LOOP
        FOR num IN 1..9 LOOP
            INSERT INTO tblgugudan VALUES (
                gugudanseq.NEXTVAL,
                dan,
                num,
                dan * num
            );

        END LOOP;
    END LOOP;
END;

SELECT
    *
FROM
    tblgugudan;


/*

3. while loop

*/

DECLARE
    vnum NUMBER := 1;
BEGIN
    WHILE vnum <= 10 LOOP
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    END LOOP;
END;


/*

select 실행 > 데이터 가져오기 > PL/SQL 변수에 대입

1. select into 절 사용하기
    - 결과셋의 레코드가 1개일 때만 사용이 가능하다.
    
2. cursor 사용하기
    - 결과셋의 레코드가 0개 이상일 때 사용이 가능하다.

declare
    변수 선언;
    커서 선언; -- 결과셋 참조 객체
begin
    커서 열기;
        loop
            데이터 접근(레코드 접근) + 커서 사용
        end loop;
    커서 닫기;
end;


*/

DECLARE
    vname tblinsa.name%TYPE;
BEGIN WHILE vname
    select name into vname from tblinsa;
    dbms_output.put_line(vname);
end;


-- 다중행 + 단일 컬럼
-- 직원명 60개 가져오기
declare
    vname tblinsa.name%type;
    cursor vcursor is select name from tblinsa order by name asc; --커서 선언
begin
    open vcursor; -- 커서 열기
        loop -- 한바퀴 = 레코드 1줄 접근하기
            fetch vcursor into vname; -- 현재 커서가 가리키는 레코드의 컬럼값 가져오기 + 변수 복사
            exit when vcursor%notfound; -- 읽을게 있으면 false, 없으면 true
            dbms_output.put_line(vname);
        end loop;
    close vcursor;
end;


commit;

-- 다중행 + 다중 컬럼
select * from tblinsa where buseo = '기획부';
select * from tblinsa;

declare
    --vname tblinsa.name%type;
    --vsudang tblinsa.sudang%type;
    vrow tblinsa%rowtype;
    vseq number;

    cursor vcursor
    is select * from tblinsa where buseo = '기획부';
begin
    open vcursor;
        loop
            fetch vcursor into vrow;
            
            exit when vcursor%notfound;
            
            -- 기획부 직원에게 보너스 지급 > insert
            select max(seq) + 1 into vseq from tblbonus; -- sequence 만드는 법
            
            insert into tblbonus values (vseq, vrow.name, vrow.sudang * 3);
        end loop;
    close vcursor;
end;

select * from tblbonus;

-- 커서 탐색
-- 1. 커서 + loop
-- 2. 커서 + for loop
-- 커서 탐색을 단순화 시켜놓은 방법

declare
    cursor vcursor
        is select * from tblinsa;
   -- vrow tblinsa%rowtype;
begin
    --open vcursor;
    --loop
    for vrow in vcursor loop -- loop + fetch + exit
        --fetch vcursor into vrow;
        --exit when vcursor%notfound;
        
        -- 업무 영역
        dbms_output.put_line(vrow.name || ':' || vrow.buseo);
    end loop;
    --close vcursor;
end;


-- 단순 쿼리 용도 O, 복잡한 쿼리 용도 X
begin
    for vrow in (select * from tblinsa) loop
        dbms_output.put_line(vrow.name);
    end loop;
end;


-- 예외 처리부
-- - 실행부에서 발생하는 예외를 처리하는 블럭
declare
    vdata number;
begin
    dbms_output.put_line('시작');
    
    select name into vdata from tblinsa where num = 1001;
    
    dbms_output.put_line('끝');
exception
    -- 예외처리부
    when others then
        dbms_output.put_line('예외 처리');
end;


drop table tbllog;
create table tbllog
( seq NUMBER PRIMARY KEY,
        code     VARCHAR(7) NOT NULL CHECK ( code IN (
            'AAA0001',
            'AAA0002',
            'AAA0003'
        ) ),
    message  VARCHAR2(1000) NOT NULL,
    regdate  DATE DEFAULT sysdate NOT NULL
);
CREATE SEQUENCE logseq;

DECLARE
    vcnt   NUMBER;
    vname  VARCHAR2(30);
BEGIN
    SELECT
        COUNT(*)
    INTO vcnt
    FROM
        tblcountry;
--    select name into vname from tblinsa where num = 1000;

    dbms_output.put_line(100 / vcnt);
    dbms_output.put_line(vname);
EXCEPTION
    WHEN zero_divide THEN
        INSERT INTO tbllog VALUES (
            logseq.NEXTVAL,
            'AAA0002',
            'tblcountry 테이블에 데이터가 없습니다.', DEFAULT
        );

    WHEN no_data_found THEN
        INSERT INTO tbllog VALUES (
            logseq.NEXTVAL,
            'AAA0003',
            'tblinsa에서 가져온 데이터가 없습니다.', DEFAULT
        );

    WHEN OTHERS THEN
        INSERT INTO tbllog VALUES (
            logseq.NEXTVAL,
            'AAA0001',
            '에러 발생', DEFAULT
        );

END;

DELETE FROM tblcountry;

SELECT
    *
FROM
    tbllog;

-- 예외처리
-- https://docs.oracle.com/cd/E11882_01/timesten.112/e21639/exceptions.htm#TTPLS196



-- 익명 프로시저
-- 실명 프로시저(저장 프로시저)

-- 저장 프로시저
-- 1. 저장 프로시저, Stored Procedure
-- 2. 저장 함수, Stored Function

/*

[declare
    변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리;]
end;
-> 익명 프로시저


create [or replace] procedure 프로시저명
is(as)  --declare 역할을 한다.
    [변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리;]
end [프로시저명];
-> 저장 프로시저


*/

SET SERVEROUTPUT ON;

DECLARE
    vnum NUMBER;
BEGIN
    vnum := 100;
    dbms_output.put_line('num: ' || vnum);
END;

CREATE OR REPLACE PROCEDURE proctest IS
    vnum NUMBER;
BEGIN
    vnum := 100;
    dbms_output.put_line('num: ' || vnum);
END proctest;


/*

저장 프로시저를 호출하는 방법

1. PL/SQL 블럭에서 호출하기

2. 스크립트 환경에서 호출하기(ANSI-SQL 환경)

*/

SELECT
    *
FROM
    tblinsa; -- 2번

BEGIN
    SELECT
        *
    FROM
        tblinsa; -- 1번

END;


-- 1. PL/SQL 블럭에서 프로시저 호출하기(FM)
-- 반복 작업이 가능하다는 장점.

BEGIN
    proctest; -- 프로시저 호출
    proctest;
    proctest;
    proctest;
    proctest;
END;

-- 2. 스크립트에서 호출하기(비권장)

EXECUTE proctest;

EXEC proctest;

CALL proctest; -- *** 뒤에 수업에서 사용


-- 프로시저 = 메서드
-- - 매개변수 or 반환값 의 존재

-- 1. 매개변수가 있는 프로시저

CREATE OR REPLACE PROCEDURE proctest (
    pnum NUMBER
) IS
    -- 선언부에서 선언한 변수는 해당 프로시저 전체에서 사용이 가능한 전역 변수
    vsum NUMBER := 0;
BEGIN
    vsum := pnum + 100;
    dbms_output.put_line(vsum);
END protest;

BEGIN
    proctest(100);
END;

CREATE OR REPLACE PROCEDURE proctest (
    width   NUMBER,
    height  NUMBER
) IS
    vresult NUMBER := 0;
BEGIN
    vresult := width * height;
    dbms_output.put_line(vresult);
END proctest;


BEGIN
    proctest(100,200);
END;




CREATE OR REPLACE PROCEDURE proctest (
    width   NUMBER,
    height  NUMBER default 10
) IS
    vresult NUMBER := 0;
BEGIN
    vresult := width * height;
    dbms_output.put_line(vresult);
END proctest;

BEGIN
    proctest(100);
END;


/*

매개변수 모드(*****)
- 매개변수의 값을 전달하는 방법

1. in 모드(기본값)
2. out 모드
3. in out 모드

*/

create or replace procedure proctest(
    vnum1 in number,
    vnum2 in number,
    vresult out number, -- 반환값
    vresult2 out number
)
is
begin
    vresult := vnum1 + vnum2;
    vresult2 := vnum1 * vnum2;
end;

declare
    vresult number;
    vresult2 number;
begin
    --dbms_output.put_line(proctest(10,20));
    proctest(10, 20, vresult, vresult2);
    dbms_output.put_line(vresult);
    dbms_output.put_line(vresult2);
end;


-- 직원 번호 전달 -> 이름, 나이, 부서, 직위 반환 프로시저
create or replace procedure procGetInsa(
    pnum in number,    -- 직원 번호
    pname out varchar2, -- 매개변수는 길이를 표현할 수 없다.
    page out number,
    pbuseo out varchar2,
    pjikwi out varchar2
)
is
begin
    select
        name,
        floor(months_between(sysdate, to_date(case
            when substr(ssn, 8, 1) in ('1','2') then '19' || substr(ssn,1, 6) 
            when substr(ssn, 8, 1) in ('3','4') then '20' || substr(ssn,1, 6)
        end, 'yyyymmdd')) / 12),
        buseo, jikwi into pname, page, pbuseo, pjikwi
    from tblinsa
    where num = pnum;
end procGetInsa;

select 
    -- 19951010 or 20011010
    floor(months_between(sysdate, to_date(case
        when substr(ssn, 8, 1) in ('1','2') then '19' || substr(ssn,1, 6) 
        when substr(ssn, 8, 1) in ('3','4') then '20' || substr(ssn,1, 6)
    end, 'yyyymmdd')) / 12)
from tblinsa;

select * from tblinsa;

declare
    vnum tblinsa.num%type;
    vname tblinsa.name%type;
    vage number;
    vbuseo tblinsa.buseo%type;
    vjikwi tblinsa.jikwi%type;
begin
    vnum := 1050;
    procGetInsa(vnum, vname, vage, vbuseo, vjikwi);
    dbms_output.put_line(vname);
    dbms_output.put_line(vage);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;


-- 직원 추가
insert into tblinsa(num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang)
    values ((select max(num) + 1 from tblinsa), '', '', ?, '' , '', '', '', 0, 0);
    
insert into tblinsa(num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang)
    values ((select max(num) + 1 from tblinsa), '하하하', '901010-1010101',
        sysdate, '서울' , '010-1234-5678', '영업부', '대리', 2500000, 10000);


create or replace procedure procAddInsa(
    pname varchar2,
    pssn varchar2,
    pyear varchar2,
    pmonth varchar2,
    pdate varchar2,
    pcity varchar2,
    ptel varchar2,
    pbuseo varchar2,
    pjikwi varchar2,
    pbasicpay number,
    psudang number,
    presult out number -- 1 or 0
)
is
begin
    --insert
    insert into tblinsa(num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang)
        values ((select max(num) + 1 from tblinsa), pname, pssn,
        to_date(pyear||pmonth||pdate, 'yyyymmdd'), pcity , ptel, pbuseo, pjikwi, pbasicpay, psudang);
    
    presult := 1;
exception
    when others then
        presult := 0;
end procaddinsa;


declare
    vresult number;
begin
    procaddinsa('아무개', '920115-1023456', '2003', '05', '20', '서울',
        '010-4123-5678', '영업부', '대리', 2500000, 10000, vresult);
    if vresult = 1 then
        dbms_output.put_line('추가 성공');
    else
        dbms_output.put_line('추가 실패');
    end if;
    
end;

select * from tblinsa;


------------------------------------- check (6/4) ----------------------------------------

--프로시저(인자값+반환값)

select * from tblStaff; --직원
select * from tblProject; --프로젝트

--퇴사 프로시저
-- 1. 퇴사직원 업무 위임 -> 2. 퇴사 처리
create or replace procedure procDeleteStaff(
    pseq number, --퇴사할 직원번호(PK)
    pstaff number, --위임받을 직원번호
    presult out number  --성공(1) or 실패(0)
)
is
    --변수?
    vcnt number;
begin
    
    -- 1. 해당 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff = pseq;
    
    -- 2. 담당업무가 있는지? 조건
    if vcnt > 0 then
        -- 3. 위임 후 퇴사
        update tblProject set
            staff = pstaff --위임자
                where staff = pseq; --퇴사자
    else
        -- 3. 퇴사
        null; --빈 블럭 표시 용도
    end if;
    
    delete from tblStaff where seq = pseq;
    
    presult := 1;
    
    commit;

exception
    when others then
        presult := 0;
        rollback;

end;

set serveroutput on;

declare
    vresult number; --성공유무
begin
    procDeleteStaff(3, 4, vresult);
    if vresult = 1 then
        dbms_output.put_line('퇴사 성공');
    else
        dbms_output.put_line('퇴사 실패');
    end if;
end;

select * from tblStaff;
select * from tblProject;


-- DML
-- 요구 분석 > 모든 업무 > 질의 > select, insert, update, delete -> SQL 작성 -> Text SQL
-- 위의 Text SQL 
-- -> 1. 크기 큰 SQL, 2. 복잡한 SQL, 3. 자주 반복 SQL, 4. 여러 쿼리 + 하나의 업무 -> 프로시저,함수 작성
-- -> 그 중 select -> 뷰 작성
-- -> 트리거 or 인덱스 생성 + 적용

-- DB 결과 + (JDBC) + 자바





-- 함수, Function
-- - 실행 후 결과값을 1개만 반환하는 프로그램
-- - 함수에서도 out 매개변수를 사용할 수 있다. -> 사용하면 안된다. -> return 을 사용해야 한다.

--public int fnSum(int num1, int num2)
create or replace function fnSum(
    pnum1 number, 
    pnum2 number
) return number
is

begin
    return pnum1 + pnum2;
end;

declare
    vresult number;
begin
    vresult := fnSum(100, 200);
    dbms_output.put_line(vresult);
end;

-- 함수와 프로시저의 차이점
-- - 함수는 ANSI-SQL와 같이 사용이 가능하다.

select basicpay, sudang, fnSum(basicpay, sudang) from tblInsa;

create or replace view vwInsa
as
select name, 
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblInsa;

select * from vwInsa;


create or replace function fnGender (
    pssn varchar2
) return varchar2
is
begin
    return case
        when substr(pssn, 8, 1) = '1' then '남자'
        when substr(pssn, 8, 1) = '2' then '여자'
    end;
end;


select name, ssn, fnGender(ssn) from tblInsa;



/*
Trigger, 트리거
- 프로시저
- 특정 사건이 발생하면 자동으로 실행되는 프로시저(예약)
- 특정 테이블 목표 -> 감시 -> insert or update or delete -> 미리 준비해놓은 프로시저를 호출
- 트리거가 많아지면 시스템 속도가 느려진다.

트리거 구문

create or replace trigger 트리거명
    --트리거 옵션
    before|after
    insert|update|delete on 테이블명
    for each row
declare
    선언부;
begin
    실행부;
end;

*/
-- tblStaff -> 직원 퇴사
-- 특정 요일(목)에는 tblStaff의 데이터 조작(delete)을 못하게 금지한다.
create or replace trigger trgStaff
    before
    delete on tblStaff
begin
    --dbms_output.put_line('트리거가 실행되었습니다.');
    if to_char(sysdate, 'dy') = '목' then
        --현재 진행하려던 업무를 없었던 일로 처리하기 -> 강제 에러 발생 throw Exception()
        -- -20000 ~ -29999
        raise_application_error(-20001, '목요일에는 퇴사가 불가능합니다.');        
    end if;
end;

rollback;
update tblProject set staff = 4 where staff = 2;
delete from tblStaff where seq = 2;

insert into tblStaff values (5, '홍길동', 300, '서울시');
delete from tblStaff where seq = 5;


drop trigger trgStaff;



-- 로그
-- tblStaff 테이블에 변화가 발생하면 기록을 남기자
create table tblLogStaff (
    seq number primary key,
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence seqLogStaff;

create or replace trigger trgLogStaff
    after
    insert or update or delete on tblStaff
declare
    vmessage varchar(1000);
begin
    
    if inserting then
        vmessage := '새 직원이 추가되었습니다.';
    elsif updating then
        vmessage := '직원 정보가 수정되었습니다.';
    elsif deleting then
        vmessage := '직원이 삭제되었습니다.';
    end if;
    
    insert into tblLogStaff values (seqLogStaff.nextVal, vmessage, default);
    
end;


select * from tblLogStaff;

------------------------------------------ (6/4) ----------------------------------------------

-- 트리거
-- 1. for each roe 표현 O : 행 단위 트리거 -> 트리거 실행이 반복
--      -> 감시하는 작업이 발생한 레코드의 수만큼 트리거 실행
--  : 적용되는 레코드의 정보가 중요한 경우 -> 변경이 발생된 데이터를 참조 가능

-- 2. for each row 표현 X : 문장 단위 트리거 -> 트리거 실행이 1회
--      -> 감시하는 작업이 발생한 레코드의 수에 상관없이 트리거는 1번 실행
--  : 적용되는 레코드의 정보는 중요하지 않음. 사건만 중요한 경우

select * from tblComedian;

set serveroutput on;

create or replace trigger trgComedian
    after
    update on tblComedian
    for each row
--declare
begin
    dbms_output.put_line('코미디언 정보가 수정되었습니다.');
end;

update tblComedian set
    weight = weight * 1.1
where first = '재석' and last = '유'; -- 업데이트 행의 갯수 -> 1개

update tblComedian set
    weight = weight * 1.1
where gender = 'm';


/*

for each row를 사용하는 경우
- 상관 관계(:old, :new)를 사용한다.

1. insert
    - 트리거내에서 방금 insert된 레코드의 컬럼값들을 참조할 수 있다.
    - :new = 방금 추가된 행
    - :new.컬럼명 = 방금 추가된 행의 컬럼
    - after 트리거에서 사용
    
2. update
    - 트리거내에서 방금 update된 레코드의 전후 컬럼값들을 참조할 수 있다.
    - :new = 방금 수정후 행
    - :old = 방금 수정전 행

3. delete
    - 트리거 내에서 방금 삭제된 레코드를 참조할 수 있다.
    - :old = 방금 삭제된 행
    - before 트리거에서 사용

insert + after -> :new
update + after -> :new + :old
delete + before -> :old

*/

create or replace trigger trgComedian
    before
    update on tblComedian
    for each row
begin
    dbms_output.put_line('코미디언 정보가 수정되었습니다.');
    dbms_output.put_line('이전 몸무게 : ' || :old.weight);
    dbms_output.put_line('현재 몸무게 : ' || :new.weight);
end;

select * from tblstaff;
select * from tblproject;

insert into tblstaff values(5, '홍길동', 300, '서울시');
update tblproject set staff = 5 where seq in (1, 3, 6);

delete from tblstaff where seq = 5; -- 바로 실행 가능하게 만들자!

-- 업무 인수 인계 트리거
create or replace trigger trgDeleteStaff
    before
    delete on tblstaff
    for each row
declare
begin
    update tblproject set
        staff = 4
    where staff = :old.seq;
end;

rollback;


-- 게시판 + 댓글
-- 테이블 삭제 -> 자식 테이블? -> 찾아내는 방법
-- 1. 강제 삭제(FK 제약 강제 삭제) -> 부모 테이블 삭제
-- drop table 테이블명 cascade constraints purge;
-- 2. 관계있는 테이블들 목록 조회
SELECT fk.owner, fk.constraint_name , fk.table_name
  FROM all_constraints fk, all_constraints pk
 WHERE fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME
   AND fk.CONSTRAINT_TYPE = 'R'
   AND pk.TABLE_NAME = 'TBLBOARD'   -- 대문자
 ORDER BY fk.TABLE_NAME;
-- 3. 관계있는 테이블들 목록 조회(ERD) : 역공학


drop table tblboard;

create table tblboard (
    seq number primary key,                 -- 글번호(PK)
    subject varchar2(1000) not null,        -- 글제목
    commentCount number default 0 not null  -- 댓글 수
);

create table tblcomment (
    seq number primary key,                          -- 댓글번호(PK)
    subject varchar2(1000) not null,                 -- 댓글제목
    pseq number not null references tblboard(seq)   --부모글번호(FK)
);

select * from tblboard;
select * from tblcomment;

-- 글쓰기
insert into tblboard values (1, '게시판입니다', default);
insert into tblboard values (2, '안녕하세요~ 홍길동입니다.', default);
insert into tblboard values (3, '오라클 수업중입니다.', default);

-- 댓글쓰기
insert into tblcomment values (1, '1번글에 대한 댓글입니다.', 1);
update tblboard set commentcount = commentcount + 1 where seq = 1;

insert into tblcomment values (1, '1번글에 대한 댓글입니다.', 1);
insert into tblcomment values (1, '1번글에 대한 댓글입니다.', 1);


-- 댓글 갯수 바로바로 업데이트 하는 방법
-- 1. 프로시저로 묶기(개인적으로 권장하는 방법)
create or replace procedure procAddComment (
    pseq number,
    psubject varchar2,
    ppseq number
)
is
begin
    insert into tblcomment values (pseq, psubject, ppseq);
    update tblboard set commentcount = commentcount + 1 where seq = ppseq;
end;

begin
    procAddComment(2, '2번에 다는 댓글입니다.', 2);
end;

select * from tblboard;
select * from tblcomment;

-- 2. 트리거 사용
create or replace trigger trgAddComment
    after
    insert on tblComment
    for each row
begin
    update tblboard set commentcount = commentcount + 1 where seq = :new.pseq;
end;

insert into tblComment values (3, '1번 두번째 댓글입니다.', 1);



/*

Text Query
1. 단일 문장
    - 프로시저
    - 뷰

2. 다중 문장
    - 프로시저

1+2. 결과 테이블 반환
-- 어떤 강의실의 학생 목록을 확인할 수 있다.
a. Text SQL -> select
b. Procedure 

*/

-- 커서(결과셋)를 반환하는 프로시저 만들기
select * from tblInsa where buseo = '영업부';

create or replace procedure procBuseo(
    pbuseo varchar2
)
is
    cursor vcursor is select * from tblInsa where buseo = pbuseo;
    vrow tblinsa%rowtype;
begin
    open vcursor;
    loop
        fetch vcursor into vrow;    -- 레코드 1개 가져와서 변수에 복사
        exit when vcursor%notfound;
        dbms_output.put_line(vrow.name);
    end loop;
    close vcursor;
end;

begin
    procBuseo('영업부');
end;


create or replace procedure procBuseo(
    pbuseo varchar2,
    presult out sys_refcursor   -- 반환값으로 커서를 사용할 때 사용하는 자료형
)
is
begin
    open presult
        for select * from tblInsa where buseo = pbuseo;
end;

-- 커서를 반환한 프로시저를 호출하기
declare
    vresult sys_refcursor;
    vrow tblinsa%rowtype;
begin
    procBuseo('영업부', vresult);
    loop
        fetch vresult into vrow;    -- 레코드 1개 가져와서 변수에 복사
        exit when vresult%notfound;
        dbms_output.put_line(vrow.name);
    end loop;
end;

set serveroutput on;