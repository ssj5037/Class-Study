-- ex09_aggregation_function.sql

/*

메서드, 함수, 서브루틴, 프로시저 등...
-> 다 같은 것들이다.
(객체 안에 들어간 함수를 메서드라고 한다.)

집계함수, Aggregation Function
- 다량의 데이터를 대상으로 통계값을 구하는 함수

1. count()
2. sum()
3. average()
4. max()
5. min()


1. count()
- select > 결과셋의 레코드 수를 반환한다.
- number count(대상컬럼)
- 매개변수에는 단 1개의 컬럼명을 넣을 수 있다.
- 예외로 *을 넣을 수 있다.
    (특정 컬럼을 넣은 경우 null이 있는지 없는지 파악이 불가능하다.)
    (부분적으로 null값이 있더라도 행 전체를 하나의 데이터로 보기 때문에 빠지는 행 없이 셀 수 있어서 *을 사용한다.)
- null은 제외한다. (***)

*/

select name from tblCountry;
select count(name) from tblCountry;

select name from tblInsa;
select count(name) from tblInsa where city in ('서울', '인천');
select count(name) from tblInsa where ssn like '%-2%';
select count(name) from tblInsa where ssn like '%-1%';

select count(*) from tblCountry;
-- ORA-00909: invalid number of arguments
select count(name, capital) from tblCountry;

select population from tblCountry;          --14
select count(population) from tblCountry;   --13
-- 값 하나가 null이었음

select count(*) from tblCountry;
select count(*) from tblCountry;


select * from tblTodo;
select count(*) from tblTodo;

-- 한 일 갯수? 안한 일 갯수?
select count(*) from tblTodo where completedate is not null;    -- 12
select count(*) from tblTodo where completedate is null;        -- 8

select count(*), count(completedate), count(*) - count(completedate) from tblTodo;

-- tblInsa. 총인원수? 연락처O?, 연락처X?
select 
    count(*) as total,
    count(tel) as telO, 
    count(*)-count(tel) as telX 
from tblInsa;

-- tblComedian. 남자 몇 명? 여자 몇 명?
select * from tblComedian;
select count(*) from tblComedian where gender = 'm';
select count(*) from tblComedian where gender = 'f';
select
    count(*) as 전체,
    count(case
        when gender = 'm' then 1
    end) as 남자,
    count(case
        when gender = 'f' then 1
    end) as 여자
from tblComedian;


-- 모든 집계 함수 사용 시 주의점 > 에러 발생
-- 1. ORA-00937: not a single-group group function
-- 컬럼 리스트에 집계 함수(집합)와 단일 컬럼(객체)은 동시에 사용할 수 없다.
select count(*), name from tblInsa;

-- 1. ORA-00934: group function is not allowed here
-- where절에는 집계 함수를 사용할 수 없다.
-- where절은 개인에 대한 질문 -> 집합값 사용 불가능
select avg(basicpay) from tblInsa;
select * from tblInsa where basicpay > avg(basicpay);


-- 상수컬럼도 읽어줌
select count(100) from tblInsa; -- 60


/*

2. sum()
- number sum(대상컬럼)
- 해당 컬럼값의 총합을 구한다.
- 숫자형에만 사용 가능(문자형X, 날짜형X)

*/

select sum(weight) from tblComedian;
select sum(first) from tblComedian; -- 문자열 ORA-01722: invalid number
select sum(ibsadate) from tblInsa;  -- 날짜시간 ORA-00932: inconsistent datatypes: expected NUMBER got DATE    

select
    sum(basicpay),
    sum(sudang),
    sum(basicpay) + sum(sudang),
    sum(basicpay + sudang)
from tblInsa;

select
    count(case
        when gender = 'm' then 1    -- 1: 의미 없는 값. 존재의의
    end),
    sum(case
        when gender = 'm' then 1    -- 1: 의미 있는 값
    end)
from tblComedian;


/*

3. avg()
- number avg(대상컬럼)
- 해당 컬럼값의 평균값을 반환한다.
- 숫자형만 가능하다.

*/

select
    avg(basicpay),
    sum(basicpay) / count(*)
from tblInsa;

select
    avg(population),                    -- 15588
    sum(population) / count(*),         -- 14475
    sum(population) / count(population) -- 15588
from tblCountry;

-- 회사 성과급 지급
-- 1. 균등 지급 : 총 지급액 / 모든 팀원수 = sum() / count(*)
-- 2. 차등 지급 : 총 지급액 / 참여 팀원수 = sum() / count(참여팀원) -> avg()


/*

4. max()
5. min()
- object max(대상컬럼) : 최댓값 반환
- object min(대상컬럼) : 최솟값 반환
- 모든 자료형에 사용 가능

*/

select max(height), min(weight) from tblcomedian;   -- 숫자형
select max(name), min(name) from tblInsa;           -- 문자형
select max(ibsadate), min(ibsadate) from tblInsa;   -- 날짜시간형



select
    count(*) as "총 직원 수",
    sum(basicpay) as "총 급여 합",
    avg(basicpay) as "평균 급여",
    max(basicpay) as "최대 급여",
    min(basicpay) as "최소 급여"
from tblInsa;



---------------------- Question ----------------------

-- sum()
-- tblCountry
-- 1. 유럽과 아프리카에 속한 나라의 인구 수의 총 합? 14,198
select
    sum(population) as 총인구
from tblCountry
where continent in ('EU', 'AF');

-- employees
-- 2. 매니저(108)이 관리하고 있는 직원들의 급여 총 합? 39,600
select * from employees;
select
    sum(salary) as 급여총합
from employees
where manager_id = 108;

-- 3. 직업(ST_CLERK, SH_CLERK)을 가지고있는 직원들의 급여 총 합? 120,000
select
    sum(salary) as 급여총합
from employees
where job_id in ('ST_CLERK', 'SH_CLERK');

-- tblInsa
-- 4. 서울에 있는 직원들의 급여합 (basicpay + sudang) 33,812,400
select
    sum(basicpay + sudang) as 급여합
from tblInsa
where city = '서울';

-- 5. 장급(부장, 과장)들의 급여 총 합? 36,289,000
select
    sum(basicpay) as 급여합
from tblInsa
where jikwi in ('부장', '과장');


-- avg()
-- tblCountry
-- 1. 아시아에 속한 국가의 평균 인구 수? 39,165
select
    avg(population) as "평균 인구 수"
from tblCountry
where continent = 'AS';

-- tblInsa
-- 2. 장급(부장, 과장)의 평균 급여? 2,419,266
select
    avg(basicpay) as 평균급여
from tblInsa
where jikwi in ('부장', '과장');

-- 3. 장급(부장, 과장)의 평균 급여와 사원급(대리,사원)의 평균 급여 차액? 1,150,320
select
    avg(case
        when jikwi in ('부장', '과장') then basicpay
    end) -
    avg(case
        when jikwi in ('대리', '사원') then basicpay
    end) as "평균 급여 차액"
from tblInsa;


-- max(), min()
-- tblCountry
-- 1. 면적이 가장 넓은 나라의 면적? 959
select
    max(area) as "면적이 가장 넓은 나라"
from tblCountry;

-- tblInsa
-- 2. 급여(basicpay + sudang)가 가장 적은 직원은 얼마를 받는지? 988,000
select
    min(basicpay + sudang) as "급여가 가장 적은 직원"
from tblInsa;


