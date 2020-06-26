-- ex12_date_function.sql

/*

날짜 시간 함수
sysdate
- 현재 시스템의 시간을 반환
- date sysdate
- 자바 : Calendar.getInstance(), new Date()

*/

select sysdate from dual;   -- 20/05/25
-- 데이터베이스 - NLS - 날짜 형식 - RRRR-MM-DD HH24:MI:SS
-- 툴을 고치지 말고 코드를 고치는게 낫다.

select to_char(sysdate, 'RRRR-MM-DD HH24:MI:SS') as now from dual;


/*

날짜 시간 연산
- +, -
1. 시각 - 시각 = 시간(일)
2. 시각 + 시간 = 시각
3. 시각 - 시간 = 시각

*/

select
    name, ibsadate,
    round(sysdate - ibsadate) as 근무일수,   -- 일단위
    round((sysdate - ibsadate) / 365) as 근무년수,
    round((sysdate - ibsadate) * 24) as 근무시수,
    round((sysdate - ibsadate) * 24 * 60) as 근무분수
from tblInsa
where (sysdate - ibsadate) > 3650
order by sysdate - ibsadate desc;


-- 시각 + 시간(일) = 시각
-- 시각 - 시간(일) = 시각
select sysdate + 100 from dual; -- 20/09/02
select sysdate - 100 from dual; -- 20/02/15

select sysdate + (6 / 24) from dual;    -- 20/05/25


/*

last_day()
- 해당 시각이 포함된 달의 마지막 날짜
- date last_day(date)

*/

select sysdate, last_day(sysdate) from dual;
select last_day(sysdate) - sysdate from dual;
select (last_day(sysdate) - sysdate) * 24 from dual;


-- 시각 - 시각 = 시간(일) -> (환산) -> 시, 분, 초
-- 시각 - 시각 = 시간(월) or 시간(년)

-- 월 단위 계산
-- month_between()
-- number months_between(date, date) : 미래시간, 과거시간
select round(sysdate - ibsadate) as 일,
    round(months_between(sysdate, ibsadate)) as 개월,
    round(months_between(sysdate, ibsadate)/12) as 년
from tblInsa;


-- 시각 + 시간(일, 시, 분, 초) = 시각
-- 시각 + 시간(월, 년) = 시각

-- 월 더하기
-- add_month()
-- date add_months(date, number) : 기준날짜, 몇개월 뒤
select 
    sysdate,
    sysdate + 90,
    add_months(sysdate, 3),
    add_months(sysdate, 3 * 12)
from dual;

-- 시각 - 시각 = 일 -> 연산자
-- 시각 + 일 = 시각 -> 연산자
-- 시각 - 시각 = 월 -> months_between()
-- 시각 + 월 = 시각 -> add_months()
-- +last_day()
