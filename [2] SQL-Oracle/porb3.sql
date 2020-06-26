

--1. tblInsa. 80년대생 남자 직원들의 평균 월급(basicpay)보다 더 많이 받는 80년대생 여직원들을 출력하시오.(subquery)
--6
select * from tblInsa
where substr(ssn, 8, 1) = 2 and substr(ssn, 1, 2) between 80 and 89
and basicpay > (select avg(basicpay) from tblInsa where substr(ssn, 8, 1) = 1);

--2. tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 출력하시오.(join)
select * from tblstaff s
    inner join tblproject p
        on s.seq = p.staff;
        
select * from tblstaff;
select * from tblproject;

--3. tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름?(join)
--신숙주
select m.name from tblrent r
    inner join tblvideo v
        on r.video = v.seq
    inner join tblmember m
        on r.member = m.seq
where v.name = '뽀뽀할까요' ;

select * from tblvideo;
select * from tblrent;
select * from tblmember;

--4. tblInsa. 평균 이상의 월급을 받는 직원들?(subquery)
--27
select * 
from tblinsa
where basicpay >= (select avg(basicpay) from tblInsa);

select * from tblInsa;

--5. tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급?(join)
--250
select s.salary from tblstaff s
    inner join tblproject p
        on s.seq = p.staff
where p.project = 'TV 광고';
 
select * from tblstaff;
select * from tblproject;

--6. tblMember. 가장 나이가 많은 회원의 주소? (bYear)(subquery)
--조선 APT 1012호
select address
from tblmember
where byear = (select max(byear) from tblmember);

select * from tblmember;

--7. tblVideo. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름?(join)
--유관순, 이율곡
select m.name from tblvideo v
    inner join tblrent r
        on v.seq = r.video
    inner join tblmember m
        on m.seq = r.member
where v.name = '털미네이터';

select * from tblvideo;
select * from tblrent;
select * from tblmember;

--8. tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 출력하시오.(join) 
select * from tblstaff s
    inner join tblproject p
        on s.seq = p.staff
where s.address != '서울시';

select * from tblstaff;
select * from tblproject;

--9. tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량 출력하시오.(join)
select c.tel, c.name, s.item, s.qty from tblsales s
    inner join tblcustomer c
        on s.cseq = c.seq
where qty >= 2;

select * from tblcustomer;
select * from tblsales;

--10. tblVideo. 모든 비디오 제목, 보유수량, 대여가격을 출력하시오.(join)
select v.name, v.qty, g.price from tblvideo v
    inner join tblgenre g
        on v.genre = g.seq;

select * from tblgenre;
select * from tblvideo;

--11. tblVideo. 2007년 2월에 대여된 구매내역을 출력하시오. 회원명, 비디오명, 언제, 대여가격을 가져오시오.(join)
select m.name, v.name, r.rentdate, g.price from tblvideo v
    inner join tblrent r
        on v.seq = r.video
    inner join tblmember m
        on m.seq = r.member
    inner join tblgenre g
        on g.seq = v.genre
where to_char(r.rentdate, 'yy-mm') = '07-02';

select * from tblvideo;
select * from tblrent;
select * from tblmember;
select * from tblgenre;

--12. tblVideo. 현재 반납을 안한 회원명과 비디오명, 대여날짜 출력하시오.(join)
select m.name, v.name, r.rentdate from tblvideo v
    inner join tblrent r
        on v.seq = r.video
    inner join tblmember m
        on m.seq = r.member
where retdate is null;

select * from tblvideo;
select * from tblrent;
select * from tblmember;

-------------------------------------------------- ***** 주의 ***** --------------------------------------------------
--13. tblInsa. basicpay+sudang가 100만원 미만, 100만원 이상~200만원 미만, 200만원 이상인 직원들의 수 출력하시오.(groupby)
select
    case
        when basicpay + sudang < 1000000 then '100만원 미만'
        when basicpay + sudang >= 1000000 and basicpay + sudang < 2000000 then '100~200만원'
        when basicpay + sudang >= 2000000 then '200만원 이상'
    end as 분류,
    count(*)
from tblInsa
group by
    case
        when basicpay + sudang < 1000000 then '100만원 미만'
        when basicpay + sudang >= 1000000 and basicpay + sudang < 2000000 then '100~200만원'
        when basicpay + sudang >= 2000000 then '200만원 이상'
    end;

-------------------------------------------------- ***** 선생님 코드 ***** --------------------------------------------------
select 
    decode(floor((basicpay+sudang) / 1000000), 0, '100만원 미만', 1, '100만원 이상 ~ 200만원 미만', 2, '200만원 이상') as 급여,
    count(*) as 인원수 
from tblInsa
group by floor((basicpay+sudang) / 1000000)
order by floor((basicpay+sudang) / 1000000) asc;
----------------------------------------------------------------------------------------------------------------------------

select * from tblInsa;

--14. tblInsa. 주민번호를 가지고 생년월일의 년도별 직원수 출력하시오.(group by)
select substr(ssn, 1, 2) as 년도, count(*) as 직원수
from tblInsa
group by substr(ssn, 1, 2)
order by substr(ssn, 1, 2);

select * from tblInsa;

--15. tblInsa. 주민번호를 기준으로 월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(이름, 주민번호) . SUBSTR() 함수 이용.(orderby)
select * from tblInsa
order by substr(ssn, 3, 2) asc, substr(ssn,1,2) desc;

select * from tblInsa;

--16. tblInsa. 입사일을 기준으로  월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(orderby)
select * from tblInsa
order by to_char(ibsadate, 'mm'), to_char(ibsadate, 'yy') desc;

select * from tblInsa;

--17. tblInsa. 전체인원수, 남자인원수, 여자인원수를 동시 출력하시오.(count+decode)
select
    count(*) as 전체인원수,
    count(decode(substr(ssn,8,1), 1, 1)) as 남자인원수,
    count(decode(substr(ssn,8,1), 2, 1)) as 여자인원수
from tblInsa;

select * from tblInsa;

--18. tblInsa. 개발부, 영업부, 총무부 인원수 출력하시오.(count+decode)
select
    count(decode(buseo, '개발부', 1)) as 개발부,
    count(decode(buseo, '영업부', 1)) as 영업부,
    count(decode(buseo, '총무부', 1)) as 총무부
from tblInsa;

select * from tblInsa;

--19. tblInsa. 서울 사람의 남자와 여자의 기본급합을 출력하시오.(decode+group by)
select
    case
        when substr(ssn, 8, 1) = 1 then '서울남자'
        when substr(ssn, 8, 1) = 2 then '서울여자'
    end as 분류,
    sum(basicpay) as 기본급합
from tblInsa
where city = '서울'
group by substr(ssn, 8, 1);

select * from tblInsa;

--20. tblInsa. 부서별 남자와 여자 인원수를 출력하시오.(decode+group by)
select
    buseo,
    count(decode(substr(ssn,8,1),1,1)) as 남자,
    count(decode(substr(ssn,8,1),2,1)) as 여자
from tblInsa
group by buseo;

--------------------------------------------- ***** 다르게 푼 것 같음 ***** ---------------------------------------------
--21. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.(groupby+subquery)
select 
    --count(select * from employees),
    count(decode(to_char(hire_date, 'yy'),03,1)) as "2003년",
    count(decode(to_char(hire_date, 'yy'),04,1)) as "2004년",
    count(decode(to_char(hire_date, 'yy'),05,1)) as "2005년",
    count(decode(to_char(hire_date, 'yy'),06,1)) as "2006년",
    count(*) 총사원수
from employees;

-------------------------------------------------- ***** 선생님 코드 ***** --------------------------------------------------
select 
    (select count(*) from hr.employees), 
    to_char(hire_date, 'yyyy'), 
    count(*) 
from hr.employees
	group by to_char(hire_date, 'yyyy');
----------------------------------------------------------------------------------------------------------------------------

select * from employees;

--22. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)
select
    name, buseo, jikwi,
    salary, rownum
from
    (select
        name, buseo, jikwi,
        basicpay + sudang as salary
    from tblinsa 
    where substr(ssn, 8, 1) = 1
    order by salary desc);

--23. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)
select
    name, buseo, jikwi,
    salary, rownum
from
    (select
        name, buseo, jikwi,
        basicpay + sudang as salary
    from tblinsa 
    where substr(ssn, 8, 1) = 2
    order by salary desc);
    
--24. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.(rownum+subquery+groupby)
select
    buseo, 인원
from
    (select
        buseo,
        count(*) as 인원
    from tblinsa
    where substr(ssn, 8, 1) = 2
    group by buseo
    order by count(*) desc) a
where rownum = 1;

--25. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)(subquery+groupby)
select
    city, 인원
from
    (select
        city,
        count(*) as 인원
    from tblinsa
    group by city
    order by count(*) desc) a;

--26. tblInsa. 부서별 인원수가 가장 많은 부서 및원수 출력하시오.(rownum+subquery+groupby)
select
    buseo, 인원
from
    (select
        buseo,
        count(*) as 인원
    from tblinsa
    group by buseo
    order by count(*) desc) a
where rownum = 1;

--27. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery+groupby)
select
    b.*, rownum
from(
    select
        a.*, rownum as rnum
    from
        (select
            name, buseo, jikwi, basicpay+sudang as salary
        from tblinsa
        where substr(ssn, 8, 1) = 1
        order by salary desc) a) b
where rnum between 3 and 5;

--28. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.(rownum+subquery)
select
    a.*
from
    (select *
    from tblinsa
    order by ibsadate) a
where rownum <= 5;

--29. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.(rownum+subquery)
select
    a.*, rownum
from (
    select * 
    from tblhousekeeping
    order by price * qty desc)a
where rownum <= 3;

--30. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.(rownum+subquery+groupby)
select *
from tblinsa
where buseo = (
    select
        buseo
    from (
        select
            buseo, rownum as rnum
        from(
            select
                buseo,
                avg(basicpay) as avgpay
            from tblinsa
            group by buseo
            order by avg(basicpay) desc) a)
    where rnum = 2);

--31. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.(rownum+subquery)
select 
    a.*
from (
    select * 
    from tbltodo
    order by completedate - adddate) a
where rownum <= 5;

--32. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?
select
    a.*, rownum as rnum
from (
    select
        basicpay
    from tblinsa
    where substr(ssn, 8, 1) = 1
    order by basicpay desc) a;
