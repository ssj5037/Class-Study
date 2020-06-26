-- p72~p126

-- ex07_column.sql

/*

distinct
- 컬럼 리스트에서 사용
- 중복값 제거
- distinct 컬럼명

*/

-- 이 테이블에는 어떤 부서들이 있습니까?
select buseo from tblInsa;
select distinct buseo from tblInsa;

select distinct city from tblInsa;

select distinct continent from tblCountry;

select distinct * from tblInsa;
select distinct name from tblInsa;

select distinct city, name from tblInsa;    -- *** 주의
-- distinct는 모든 column값을 중복제거함.

select distinct city, buseo from tblInsa;


/*

case
- 컬럼리스트에서 사용 + 조건절에서 사용
- 자바의 if or switch 역할
    case
        when 조건 then 반환값
        ...
        else 반환값
    end
- 조건을 만족하지 못하면 null 반환(******)

*/

select
    last || first as name,
    case
        when gender = 'm' then '남자'
        when gender = 'f' then '여자'
    end as genderName,
    gender
from tblComedian;

select
    name,
    case
        when continent = 'AS' then '아시아'
        when continent = 'SA' then '아메리카'
        when continent = 'EU' then '유럽'
        --when continent = 'AF' then '아프리카'
        --when continent = 'AU' then '호주'
        --else '기타'
        --else continent
        --else capital --XXX, 논리오류: 같은 의미의 데이터를 반환해주자
        --else area --XXX, 물리오류: 다른 자료형
    end as korean,
    continent
from tblCountry;

select
    distinct    -- 가공 데이터 중복값 제거도 가능함
    case
        when continent = 'AS' then '아시아'
        when continent = 'SA' then '아메리카'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        when continent = 'AU' then '호주'
    end as continent
from tblCountry;

select
    last || first as name,
    weight,
    case
        when weight > 100 then '과체중'
        when weight > 50 then '정상체중'
        when weight > 0 then '저체중'
    end as state
from tblComedian;

select
    --title,
    case
        when completedate is not null then title
        when completedate is null then '[*]' || title
    end as title,
    case
        when completedate is not null then '완료한 일'
        when completedate is null then '해야 할 일'
    end as state
from tblTodo;

select
    name,
    buseo,
    jikwi,
    case
        when ibsadate > '2016-10-23' then '주니어'
        when ibsadate between '2012-10-23' and '2016-10-22' then '시니어'
        when ibsadate <= '2012-10-23' then '익스퍼트'
    end as lv
from tblInsa;

-- tblMen.couple
select 
    name,
    case
        when couple is null then '솔로'
        when couple is not null then '커플'
    end as state
from tblMen;
