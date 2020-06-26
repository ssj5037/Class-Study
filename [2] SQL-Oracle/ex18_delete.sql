-- ex18_delete.sql

-- select
-- insert
-- update
-- delete

-- 셀을 지우는 행위. 지운다고 하진 않고 update라고 한다.
update tblInsa set
    buseo = null
    where num = 1001;


/*

delete문
- DML
- (레코드) 데이터를 삭제하는 명령어
- delete [from] 테이블명 [where 절]

*/

select * from tblCountry;

delete from tblCountry where continent = 'AS';

delete from tblCountry; -- 테이블 초기화

rollback;