-- ex24_pseudo.sql

/*

의사 컬럼, Pseudo Column
- 실제 컬럼이 아닌데 컬럼처럼 행동하는 객체
- 오라클 전용. My-SQL(top), MySQL(limit)
- rownum
- rownum은 from절이 실행된 직후 호출(+계산)이 된다. > 하나의 select from에서 단 한번만 실행

*/

select name, buseo, jikwi, rownum from tblInsa;

-- 질문의 조건에 1행이 포함이 되면 O, 포함이 안되면 X (가져오지 못한다.)
select name, buseo, jikwi, rownum from tblInsa where rownum = 1;
select name, buseo, jikwi, rownum from tblInsa where rownum <= 5;
select name, buseo, jikwi, rownum from tblInsa where rownum = 10;
select name, buseo, jikwi, rownum from tblInsa where rownum >= 5 and rownum <=10;

select name, buseo, jikwi, rownum from tblInsa order by name;


-- tblInsa. 급여를 가장 많이 받는 직원. Top 5
select name, buseo, jikwi, basicpay from tblInsa order by basicpay desc;

-- 원하는 정렬을 한 후 -> 제대로 된 rownum을 얻는 방법 -> 서브 쿼리 사용
select name, buseo, jikwi, basicpay, rownum
    from (select name, buseo, jikwi, basicpay from tblInsa order by basicpay desc)
    where rownum <= 5;

-- tblInsa. 급여를 가장 많이 받는 직원. Top 6 ~ 10
-- 특정 테이블 -> 내가 원하는 정렬(첫 서브쿼리) + 내가 원하는 범위 추출(두번째 서브쿼리) -> 최소 서브쿼리 2개 이상
select name, buseo, jikwi, basicpay, rnum, rownum 
    from (select name, buseo, jikwi, basicpay, rownum as rnum
        from (select name, buseo, jikwi, basicpay from tblInsa order by basicpay desc))
    where rnum between 6 and 10;

create or replace view vwbasicpay
as
select name, buseo, jikwi, basicpay, rownum as rnum
        from (select name, buseo, jikwi, basicpay from tblInsa order by basicpay desc);

select * from vwbasicpay where rnum =3;


select * from tbladdressbook;

-- 지역별(hometown) 거주자가 가장 많은 순서 Top3
select a.*, rownum 
from (
    select
        hometown, count(*) as cnt
    from tbladdressbook
    group by hometown
    order by count(*) desc) a
    where rownum <= 3;

-- 지역별(hometown) 거주자가 가장 많은 순서 Top4 ~ 6
select b.*, rownum
from(
    select a.*, rownum as rnum 
    from (
        select
            hometown, count(*) as cnt
        from tbladdressbook
        group by hometown
        order by count(*) desc) a) b
where rnum between 4 and 6;

-- 1. 원하는 대로 정렬한다
-- 2. 서브쿼리를 만들어서 원하는 정렬의 rownum을 가져온다
-- 3. 1이 포함된 범위는 바로 확인가능
-- 4. 1이 포함되지 않은 범위를 확인하기 위해서는 서브쿼리를 한번 더 만들면 확인가능!


-- tblInsa. 부서별 인원수가 가장 많은 2번째 부서?
select b.*, rownum
from(
    select a.*, rownum as rnum
    from(
        select buseo, count(*) as cnt 
        from tblInsa 
        group by buseo 
        order by cnt desc) a) b
where rnum = 2;





