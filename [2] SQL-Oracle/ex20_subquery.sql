-- ex20_subquery.sql

/*

Main Query, 메인 쿼리
- 하나의 쿼리(select, insert, update, delete)로만 되어 있는 쿼리

Sub Query, 서브 쿼리
- 여러개의 select를 사용하는 쿼리
- 하나의 쿼리(select, insert, update, delete) 안에 또 다른 select가 들어있는 쿼리
- 삽입 위치: select절, from절, where절, order by절 등...

*/

-- tblCountry. 인구수가 가장 많은 나라의 인구수? > 국가명?
select name, population from tblCountry;

select max(population) from tblCountry; --120660
select name from tblCountry where population = 120660;

-- where절에 집계함수 X
select name from tblCountry where population = max(population); --XX

select name from tblCountry where population = (select max(population) from tblCountry);

-- tblComedian. 체중이 가장 많이 나가는 사람의 이름?
select last || first from tblComedian where weight=(select max(weight) from tblcomedian);
-- tblInsa. 급여를 가장 적게 받는 직원명?
desc tblInsa;
select name from tblInsa where basicpay = (select min(basicpay) from tblInsa);
-- tblInsa. 평균 급여보다 더 많이 받는 직원 명단?
select name from tblInsa where basicpay > (select avg(basicpay) from tblInsa);
-- tblInsa. '홍길동'과 같은 부서에서 근무하는 직원 명단?
select * from tblInsa where buseo = (select buseo from tblInsa where name = '홍길동');
-- tblMen, tblWomen. 키(166) + 몸무게(55) 남자 -> 여자친구 나이?
select name from tblMen where height = 166 and weight = 55;
select name, age from tblwomen where couple = (select name from tblMen where height = 166 and weight = 55);


/*

서브쿼리의 용도

1. 조건절에서 비교값으로 사용
    a. 반환값이 1행 1열 > 스칼라 쿼리 > 연산자를 사용해서 비교한다.
    b. 반환값이 N행 1열 > in 연산자를 사용해서 비교한다.
    c. 반환값이 1행 N열 > 스칼라 쿼리 > 연산자를 사용해서 비교한다.
        (열이름, 열이름, ...) = (select문)
    d. 반환값이 N행 N열 > b + c 조합 (잘 안쓰임)
        (열이름, 열이름, ...) in (select문)

2. 컬럼리스트에서 사용
    a. 반드시 1행 1열의 결과만 사용 가능하다. > 상수 1개의 역할을 하기 때문에
    b. 컬럼리스트에서 사용되는 서브쿼리 종류
        1. 정적 쿼리(바깥쪽 테이블의 모든 행에 대해 동일한 값을 가지는 경우)
        2. 상관 서브 쿼리(바깥쪽 테이블의 결과를 서브 쿼리에 연동했을 때)

3. from절에서 사용
    - 서브 쿼리의 결과셋을 독립적인 하나의 테이블이라고 생각하고 from절에서 사용
    - 인라인 뷰(Inline View)
    - alias 주의!!!! (별명이 아니라 개명한 것)
    
4. order by, group by, having 등등..

*/

----------------------- 1. 조건절에서 비교값으로 사용 -----------------------
select * from tblInsa
    where basicpay = (select max(basicpay) from tblInsa);

-- 급여가 250만원 이상 받는 직원? > 같은 부서 직원 명단?
-- ORA-01427: single-row subquery returns more than one row
select * from tblInsa
    where buseo in (select buseo from tblInsa where basicpay >= 2500000);
    -- where buseo = ('기획부', '개발부', ...);

-- '홍길동'과 같은 지역 + 같은 직위
select * from tblInsa
    where city = (select city from tblInsa where name = '홍길동')
        and jikwi = (select jikwi from tblInsa where name = '홍길동'); -- XXXXX 이렇게 안짠다.
select * from tblInsa
    where (city, jikwi) = (select city, jikwi from tblInsa where name = '홍길동');

-- 급여 260만원 이상 받는 직원의 부서 + 지역 -> 두 조건 일치하는 직원 명단
select * from tblInsa
    where (buseo, city) in (select buseo, city from tblInsa where basicpay >= 2600000);


----------------------- 2. 컬럼리스트에서 사용 -----------------------

select avg(basicpay) from tblInsa;
select name, buseo, jikwi, basicpay, avg(basicpay) from tblInsa;
select 
    name, buseo, jikwi, basicpay, 
    (select round(avg(basicpay)) from tblInsa) as 전체평균 
from tblInsa;

select 
    name, buseo, jikwi, basicpay, 
    (select city from tblInsa where num = 1001) as 전체평균 
from tblInsa;

select 
    name, buseo, jikwi, basicpay, 
    (select round(avg(basicpay)) from tblInsa where buseo = a.buseo)
from tblInsa a;

select name, age, couple,(select age from tblWomen where name = tblMen.couple) from tblMen;


----------------------- 3. from절에서 사용 -----------------------
-- select 자체가 테이블 일 수 있다.
select * 
from (select num as 번호, name, jikwi, city from tblInsa where buseo = '기획부')
where 번호 = 1001;
