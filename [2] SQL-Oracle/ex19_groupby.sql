-- ex19_groupby.sql

/*

group by 절
- 레코드를 특정 컬럼값(1개 or 그 이상)에 맞춰서 그룹을 나누는 역할
- 그룹을 왜 나누는지? -> 각각의 나눠진 그룹을 대상 -> 집계함수를 적용하기 위해서(***)
- group by 컬럼명

select 컬럼리스트
from 테이블
where 조건
group by 절
order by 컬럼

1. from 테이블
2. where 조건
3. group by 절
4. select 컬럼리스트
5. order by 컬럼

*/

-- 부서별 그룹
select count(*), buseo from tblInsa group by buseo;

-- 부서별 평균 급여?
select * from tblInsa;
select round(avg(basicpay)) from tblInsa;   --155만원
select distinct buseo from tblInsa;

select round(avg(basicpay)) from tblInsa where buseo = '총무부'; --171
select round(avg(basicpay)) from tblInsa where buseo = '개발부'; --138
select round(avg(basicpay)) from tblInsa where buseo = '영업부'; --160
select round(avg(basicpay)) from tblInsa where buseo = '기획부'; --185
select round(avg(basicpay)) from tblInsa where buseo = '인사부'; --153
select round(avg(basicpay)) from tblInsa where buseo = '자재부'; --141
select round(avg(basicpay)) from tblInsa where buseo = '홍보부'; --145

select round(avg(basicpay)) as 평균급여, count(*), buseo from tblInsa group by buseo;

select
    round(avg(basicpay)) as 평균급여,
    decode(substr(ssn, 8, 1), 1, '남성', 2, '여성') as 성별
from tblInsa
group by substr(ssn, 8, 1);


select * from tblComedian;
select
    count(decode(gender, 'm', 1)) as 남성,
    count(decode(gender, 'f', 1)) as 여성
from tblComedian;
select
    count(*) as 인원,
    decode(gender, 'm', '남성', 'f', '여성') as 성별
from tblComedian
group by gender;


select
    job, count(*)
from tblAddressbook
group by job
order by count(*) desc;


-- 다중, 다차원 그룹
select
    city, buseo, count(*)
from tblInsa
group by buseo, city
order by buseo, city;


-- group by + 집계 함수
select
    hometown as 지역,
    count(*) as "지역별 인구수",
    round(avg(weight), 1) as "지역별 평균 몸무게",
    max(weight) as "지역별 최고 몸무게",
    min(weight) as "지역별 최저 몸무게",
    sum(weight) as "지역별 몸무게 총 합"
from tblAddressBook
group by hometown;


select
    nvl2(completedate,'o','x') as 내역,
    count(*) as 개수
from tbltodo
group by nvl2(completedate,'o','x');


/*

having 절
- 조건절

select 컬럼리스트
from 테이블
where 조건
group by 절
having 절
order by 컬럼

1. from 테이블
2. where 조건
3. group by 절
4. having 절
5. select 컬럼리스트
6. order by 컬럼

from절 -> where절 : 개인에 대한 질문(조건)
group by절 -> having절 : 그룸(집계 함수 결과)에 대한 질문(조건)

*/


select
    buseo, count(*)
from tblInsa
--where count(*) >= 10 (where 절에는 집계함수를 쓸 수 없다.)
group by buseo
having count(*) >= 10;


select
    buseo, round(avg(basicpay))
from tblInsa
--where basicpay >= 1550000
group by buseo
having avg(basicpay) >= 1550000;


-- 날짜
select * from tblhousekeeping;
select
    to_char(buydate, 'dd') as 날짜,
    count(*) as 구매횟수,
    sum(qty) as 구매개수,
    max(price) as 최대단가,
    min(price) as 최소단가,
    sum(qty * price) as 총구입액
from tblhousekeeping
group by to_char(buydate, 'dd')
order by to_char(buydate, 'dd') asc;

select
    case
        when price >= 0 and price < 3000 then '저가'
        when price >= 3000 and price < 10000 then '중가'
        when price >= 10000 then '고가'
    end as 분류,
    count(*) as 개수
from tblhousekeeping
group by 
    case
        when price >= 0 and price < 3000 then '저가'
        when price >= 3000 and price < 10000 then '중가'
        when price >= 10000 then '고가'
    end;


-- tblInsa. 부서별 직급의 인원수 가져오기
select
    buseo as 부서,
    count(*) as 인원,
    count(decode(jikwi, '부장', 1)) as 부장,
    count(decode(jikwi, '과장', 1)) as 과장,
    count(decode(jikwi, '대리', 1)) as 대리,
    count(decode(jikwi, '사원', 1)) as 사원
from tblInsa
group by buseo;


-- group by 결과를 좀 더 자세하게 출력하는 함수
-- rollup(), cube() : summary
-- rollup() : 2차로 정렬, 그담에 1차로 정렬한 통계를 내 준다.
-- cube() : rollup과 달리 2차 정렬만으로도 통계를 내 준다.
select
    buseo,
    count(*)
from tblInsa
group by rollup(buseo);

select
    buseo,
    count(*),
    sum(basicpay),
    round(avg(basicpay)),
    max(basicpay),
    min(basicpay)
from tblInsa
group by rollup(buseo);

select
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa
group by rollup(buseo, jikwi, city)
order by buseo, jikwi, city;

select
    buseo,
    count(*)
from tblInsa
group by cube(buseo)
order by buseo;

select
    buseo,
    jikwi,
    count(*)
from tblInsa
group by cube(buseo, jikwi)
order by buseo, jikwi;


-- listagg
-- 11g 이후 버전에서만 사용 가능
select
    buseo,
    count(*),
    listagg(name, ', ') within group(order by name asc) as name
from tblInsa
group by buseo
order by buseo;


desc tblhousekeeping
select
    buydate,
    count(*),
    listagg(item, ', ') within group(order by item asc) as item,
    sum(qty * price) as totalprice
from tblhousekeeping
group by buydate
order by buydate;
