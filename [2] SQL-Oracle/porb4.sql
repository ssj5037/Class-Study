--1. tblInsa. 입사년도별 남자와 여자 인원수를 가져오시오.(groupby+decode)
select
    to_char(ibsadate, 'yyyy') as 입사년도,
    count(decode(substr(ssn, 8, 1), 1, 1)) as 남자,
    count(decode(substr(ssn, 8, 1), 2, 1)) as 여자
from tblinsa
group by to_char(ibsadate, 'yyyy');

--2. tblInsa. 부서별 남,여 인원수 출력. 여자인원수가 5명 이상인 부서만 가져오시오.(groupby+having+decode)
select
    buseo,
    count(decode(substr(ssn, 8, 1), 1, 1)) as 남자,
    count(decode(substr(ssn, 8, 1), 2, 1)) as 여자
from tblinsa
group by buseo
having count(decode(substr(ssn, 8, 1), 2, 1)) >= 5;

--3. tblInsa. 입사월별 인원수 구하기. (월, 인원수)(groupby)
--출력결과
--월     인원수
--1월    10명
--2월    25명
select
    to_char(ibsadate, 'mm') as 월,
    count(*) as 인원수
from tblinsa
group by to_char(ibsadate, 'mm')
order by to_char(ibsadate, 'mm');

--------------------------- *** 확인필요 *** ---------------------------
--5. tblInsa. 아래 형식으로 지역별 인원수를 가져오시오(decode)
--전체 서울  인천  경기
--60    x     x     x
select distinct city from tblinsa;

select
    count(*) as 전체,
    count(decode(city, '서울', 1)) as 서울,
    count(decode(city, '충남', 1)) as 충남,
    count(decode(city, '인천', 1)) as 인천,
    count(decode(city, '부산', 1)) as 부산,
    count(decode(city, '제주', 1)) as 제주,
    count(decode(city, '전북', 1)) as 전북,
    count(decode(city, '강원', 1)) as 강원,
    count(decode(city, '경북', 1)) as 경북,
    count(decode(city, '전남', 1)) as 전남,
    count(decode(city, '경기', 1)) as 경기,
    count(decode(city, '경남', 1)) as 경남
from tblinsa;

--6. tblInsa. 부서별 기본급이 가장 높은 사람을 출력하시오.(이름, 부서, 기본급) 동급은 첫번째 사람만 출력하시오.(subquery+groupby)
select
    name, buseo, basicpay
from tblinsa
where (buseo, basicpay) in (
    select
        buseo, max(basicpay)
    from tblinsa
    group by buseo);

--7. tblInsa. 지역(city)별로 급여(기본급+수당) 1순위 직원만 출력하시오.(급여, 직원명,주민번호,입사일,지역,부서,직위)(groupby+subquery)
select
    basicpay + sudang as 급여,
    name, ssn, ibsadate, city, buseo, jikwi
from tblinsa
where (city, basicpay + sudang) in (
    select
        city, max(basicpay+sudang)
    from tblinsa
    group by city);
    
--------------------------- *** 확인필요 *** ---------------------------
--8. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)
select *
from(select buseo, count(*) as inwon 
    from tblinsa group by buseo order by count(*) desc)
where rownum = 1;

--9. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)
select
    *
from (select
            buseo, count(decode(substr(ssn, 8, 1), 2, 1)) as 여자
        from tblinsa
        group by buseo
        order by 여자 desc)
where rownum = 1;

--10. tblInsa. 지역(city)별 평균 급여(basicpay+sudang)가 가장 높은 지역 및 평균급여를 출력하시오(groupby+subquery)
select
    *
from (select
        city, avg(basicpay + sudang) as 급여
    from tblinsa
    group by city
    order by 급여 desc)
where rownum = 1;

--11. tblInsa. 이름, 부서, 출신도, 기본급, 수당, 기본급+수당, 세금, 실수령액 출력하시오.(case)
--- 세금: 총급여가 250만원 이상이면 2%, 200만원 이상이면 1%, 나머지 0.
--- 실수령액: 총급여-세금
select
    name, buseo, city, basicpay, sudang, (basicpay+sudang) as total,
    case
        when (basicpay+sudang) >= 2500000 then (basicpay+sudang) * 0.02
        when (basicpay+sudang) >= 2000000 and (basicpay+sudang) < 2500000 then (basicpay+sudang) * 0.01
        else 0
    end as 세금,
    case
        when (basicpay+sudang) >= 2500000 then (basicpay+sudang) * 0.98
        when (basicpay+sudang) >= 2000000 and (basicpay+sudang) < 2500000 then (basicpay+sudang) * 0.99
        else (basicpay+sudang)
    end as 실수령액
from tblinsa;

--12. tblInsa. 부서별 평균 급여를 출력하되, A, B, C 등급으로 나눠서 출력.
--- 200만원 초과 - A등급
--- 150~200만원 - B등급
--- 150만원 미만 - C등급
select
    buseo,
    case
        when avg(basicpay) > 2000000 then 'A등급'
        when avg(basicpay) between 1500000 and 2000000 then 'B등급'
        when avg(basicpay) < 1500000 then 'C등급'
    end as 등급
from tblinsa
group by buseo;

--13. lotto_detail. 역대 로또 1등 당첨금(1인 당첨금)이 가장 많은 순으로 5개를 가져오시오.(subquery)
select *
from (
    select *
    from lotto_detail
    order by 
        case
            when win_person_no > 0 then (win_money / win_person_no)
            else 0
        end desc)
where rownum <=5;

--14. lotto_master. 로또 번호(1~45) 중 가장 많이 나온 숫자를 6개 가져오시오.(bonus 숫자 포함)(union+groupby+subquery)
select *
from (
    select
        num1 as 번호,
        count(*) as 개수
    from(select num1 from lotto_master
        union all
        select num2 from lotto_master
        union all
        select num3 from lotto_master
        union all
        select num4 from lotto_master
        union all
        select num5 from lotto_master
        union all
        select num6 from lotto_master
        union all
        select bonus from lotto_master)
    group by num1
    order by 개수 desc)
where rownum = 1;

--------------------------- *** ㅅㅂ *** ---------------------------
--15. tblSubway. 승차 인원의 합보다 하차 인원의 합이 더 많은 역들을 가져오시오.(groupby+having+case+sum)
select * from tblsubway;
select
    stationname,
    case
        when gubun = '승차' then sum(passengernum)
    end as 승차,
    case
        when gubun = '하차' then sum(passengernum)
    end as 하차
from tblsubway
group by stationname
--having 승차 < 하차
order by stationname;

--16. traffic_accident. 년도별(10년단위,1차그룹)+교통수단별(2차그룹) 총 사고 인원수와 사망자수를 가져오시오.(groupby)
desc traffic_accident;
select
    substr(to_char(year),1,3) || '0년대' as 년도별, trans_type as 교통수단별,
    sum(total_acct_num) as 총사고인원수, sum(death_person_num) as 총사망자수
from traffic_accident
group by substr(to_char(year),1,3), trans_type
order by 년도별, 교통수단별;

--17. traffic_accident. 발생 년도와 상관없이 사고당 평균 사망자수가 가장 많은 교통 수단은 무엇인가?(groupby+subquery)
select *
from (
    select
        trans_type,
        round(avg(death_person_num)) as 평균사망자수
    from traffic_accident
    group by trans_type
    order by 평균사망자수 desc)
where rownum = 1;

--18. tblAddressbook. BMI(체중(kg)/키(m)^2) 지수가 30이 넘는 사람들 중 가장 많은 직업은?(subquery+groupby)
select *
from (
    select
        job, count(*) as 인원수
    from (select 
            job,
            round(weight / ((height * 0.01) * (height * 0.01)), 1) as bmi 
        from tbladdressbook
        where round(weight / ((height * 0.01) * (height * 0.01)), 1) > 30.0) a
    group by a.job
    order by 인원수 desc)
where rownum = 1;

--19. tblHousekeeping. 가장 과소비를 한 날짜(Top 3)와 그 날짜에 구매한 물품 명단과 총금액을 가져오시오.(subquery+groupby+listagg)
select * from tblhousekeeping;
select 
    buydate,
    sum((price * qty)) as 총금액,
    listagg(item, ', ')
        within group(order by seq asc) as items
from tblhousekeeping
group by buydate
having buydate in (
    select *
    from (
        select
            buydate
        from tblhousekeeping
        group by buydate
        order by sum(price * qty) desc)
    where rownum <= 3);

--20. tblAddressBook. 고향(hometown)을 떠나 거주(address)하는 사람들 중에서 동명이인인 사람들이 어떤 직업들을 가지고 있는가?(subquery+groupby+listagg)
select
    name,
    listagg(job, ', ')
        within group(order by name) as 직업
from tbladdressbook
where address not like '%' || hometown || '%'
group by name
having count(name) > 1;
