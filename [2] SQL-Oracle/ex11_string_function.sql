-- ex11_string_function.sql

/*

문자열 함수
- upper(), lower(), initcap()
- varchar2 upper(대상컬럼)

*/

select
    first_name, last_name,
    upper(first_name), upper(last_name),
    lower(first_name), lower(last_name)
from employees;

select initcap('abc') from dual;

-- 이름 -> 'de'
select
    first_name
from employees
where first_name like '%de%' or first_name like '%De%' 
    or first_name like '%dE%' or first_name like '%DE%';

select
    first_name
from employees
where upper(first_name) like upper('%de%');

select
    first_name
from employees
where upper(first_name) like '%' || upper('de') || '%';


/*

substr()
- 문자열 추출함수
- varchar2 substr(대상 컬럼, 시작위치, 문자개수)
- varchar2 substr(대상 컬럼, 시작위치) : 시작위치부터 끝까지 추출
-- SQL은 서수를 1부터 시작한다.

*/

select
    '가나다라마바사아자차카타파하',
    substr('가나다라마바사아자차카타파하', 3, 5)  -- 다라마바사
from dual;

select * from tblInsa where ssn like '%-1%' or ssn like '%-3%';
select * from tblInsa where substr(ssn, 8, 1) in ('1', '3');

select
    name,
    '19' || substr(ssn, 1, 2)
from tblInsa;

select
    name,
    case
        when substr(ssn, 8, 1) in ('1', '2') then '19'
        when substr(ssn, 8, 1) in ('3', '4') then '20'
    end || substr(ssn, 1, 2)
from tblInsa;

-- 서울 + 80년대 + 여직원 -> 몇명?
select
    *
from tblInsa
where city = '서울'
    and substr(ssn, 1, 1) = '8'
    and substr(ssn, 8, 1) = '2';

select
    count(distinct substr(name, 1, 1))
from tblInsa;

-- 김, 이, 박, 최, 정 씨 몇 명씩 + 기타 몇 명?
select
    count(case
        when substr(name, 1, 1) = '김' then 1
    end) as 김,
    count(case
        when substr(name, 1, 1) = '이' then 1
    end) as 이,
    count(case
        when substr(name, 1, 1) = '박' then 1
    end) as 박,
    count(case
        when substr(name, 1, 1) = '최' then 1
    end) as 최,
    count(case
        when substr(name, 1, 1) = '정' then 1
    end) as 정,
    count(case
        when substr(name, 1, 1) not in ('김', '이', '박', '최', '정') then 1
    end) as 기타
from tblInsa;

select
    *
from tblInsa
order by substr(ssn, 1, 6) asc;


/*

length()
- 문자열 길이
- number length(대상 컬럼)

*/

-- 컬럼 리스트
select name, length(name) from tblCountry;

-- where절
select 
    name,
    length(name) 
from tblCountry 
where length(name) > 3;

-- order by절
select 
    name,
    length(name) 
from tblCountry 
where length(name) > 3 
order by length(name) desc;

select
    title,
    case
        when length(title) >= 8 then substr(title, 1, 8) || '...'
        else title
    end as 제목
from tblTodo;

/*

instr()
(= indexOf())
- 검색어의 위치 반환
- number instr(대상 컬럼, 검색어)
- number instr(대상 컬럼, 검색어, 시작위치)

*/

select
    title,
    case
        when instr(title, '하기') > 0 then 'O'
        when instr(title, '하기') = 0 then 'X'
    end as 하기
from tblTodo;


/*

trim(), rtrim(), ltrim()
- varchar2 trim(대상 컬럼)

*/

select '     홍길동     ' from dual;
select trim('     홍길동     ') from dual;
select rtrim('     홍길동     ') from dual;
select ltrim('     홍길동     ') from dual;


/*

replace()
- 문자열 치환 함수
- varchar2 replace(대상 컬럼, 찾을 문자열, 바꿀 문자열)

*/

select replace('홍길동', '홍', '김'), replace('홍길동', '이', '김') from dual;

select
    name, ssn, substr(ssn, 8, 1)
from tblInsa;

select
    name, ssn,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender,
    replace('1', '2', '0')
from tblInsa;

select
    name,
    continent,
    case
        when continent = 'AS' then '아시아'
        when continent = 'SA' then '아메리카'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        when continent = 'AU' then '호주'
    end as 대륙명,
    replace(replace(replace(replace(replace(continent, 'AS', '아시아')
        ,'SA', '아메리카'), 'EU', '유럽'), 'AF', '아프리카'), 'AU', '호주') as rpl
from tblCountry;


/*

decode()
- 문자열 치환함수 (replace()와 유사)
- varchar2 decode(대상 컬럼, 찾을 문자열, 바꿀 문자열, 찾을 문자열, 바꿀 문자열...)
- replace 중첩 작업 시 decode 사용을 권장
- ** 못찾으면 null 반환 -> count() (집계 함수) 자주 사용

*/

select
    name, ssn,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender,
    replace(replace(substr(ssn, 8, 1), '1', '남자'), '2', '여자'),
    decode(substr(ssn, 8, 1), '1', '남자', '2', '여자')
from tblInsa;

select
    name,
    continent,
    case
        when continent = 'AS' then '아시아'
        when continent = 'SA' then '아메리카'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        when continent = 'AU' then '호주'
    end as 대륙명,
    replace(replace(replace(replace(replace(continent, 'AS', '아시아')
        ,'SA', '아메리카'), 'EU', '유럽'), 'AF', '아프리카'), 'AU', '호주') as replace,
    decode(continent, 'AS', '아시아', 'SA', '아메리카', 'EU', '유럽', 'AF', '아프리카', 'AU', '호주') as decode
from tblCountry;

--tblComedian. 남자 몇 명? 여자 몇 명?
select last || first as name, gender from tblComedian;

-- ORA-00937: not a single-group group function
select
    --last || first as name,
    count(case
        when gender = 'm' then 1
    end) as male,
    count(case
        when gender = 'f' then 1
    end) as female
from tblComedian;

select
    count(decode(gender, 'm', 1)) as male,
    count(decode(gender, 'f', 1)) as female
from tblComedian;

-- tblInsa. 부장 몇 명? 과장 몇 명? 대리 몇 명? 사원 몇 명? -> 1개 결과셋
select
    count(decode(jikwi, '부장', 1))as 부장,
    count(decode(jikwi, '과장', 1))as 과장,
    count(decode(jikwi, '대리', 1))as 대리,
    count(decode(jikwi, '사원', 1))as 사원
from tblInsa;

-- tblInsa. 부장+과장 몇 명? 대리+사원 몇 명? -> 1개 결과셋
select
    count(decode(jikwi, '부장', 1))+ count(decode(jikwi, '과장', 1))as 부장과장,
    count(decode(jikwi, '대리', 1))+ count(decode(jikwi, '사원', 1))as 대리사원
from tblInsa;

select
    count(decode(jikwi, '부장', 1, '과장', 2)) as 장급,
    count(decode(jikwi, '대리', 1, '사원', 2)) as 사원급
from tblInsa;


-- job. 학생 몇 명? 건물주 몇 명?
select
    count(decode(job, '학생', 1)) as 학생수,
    count(decode(job, '건물주', 1)) as 건물주
from tblAddressBook
order by seq asc;


-- 강동구 몇 명? 마포구 몇 명?
select
    count(case
        when instr(address, '강동구') > 0 then 1
    end) as 강동구,
    count(case
        when instr(address, '마포구') > 0 then 1
    end) as 마포구
from tblAddressBook
order by seq asc;

select
    count(*) - count(decode(instr(address, '강동구'), 0, 1)) as 강동구,
    -- instr(address, '강동구') > 강동구가 들어가지 않은 주소는 0이 들어간다.
    -- 따라서 강동구가 아닌 사람만 1로 바꾸고, 강동구에 사는 사람들은 (null)이 들어가게 된다.
    -- 전체 인원에서 강동구에 살지 않은 사람을 빼주는 것..
    count(*) - count(decode(instr(address, '마포구'), 0, 1)) as 마포구
from tblAddressBook;
