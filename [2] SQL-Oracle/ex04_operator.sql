-- ex04_operator.sql

/*

연산자, Operator

1. 산술 연산자
- +, -, *, /
- %(없음) -> 함수로 제공(mod())

2. 문자열 연산자
- concat
- +(X) -> ||(O)

3. 비교 연산자
- >, >=, <, <=
- =(==), <>(!=)
- 컬럼 리스트에서 사용 불가 > 조건절에서 사용
    (boolean이 없기 때문에where 뒤에 붙어서 조건을 검사할 때만 쓰인다.)

4. 논리 연산자
- and(&&), or(||), not(!)
- 컬럼 리스트에서 사용 불가 > 조건절에서 사용

5. 대입 연산자
- =
- 복합 연산자 (+=) X
- insert, update 문에서 주로 사용

6. 3항 연산자
- 없음 (제어문이 없기 때문에)
- 유사한 행동 함수가 있음

7. 증감 연산자
- 없음
- num++ -> num = num + 1 (select에서 못씀)

8. SQL 연산자(절)
- in, between, like, is, any, all 등...

*/

-- scott
select * from emp;
desc emp;

select ename, sal, sal+100, 100, 10 + 20, sal/3 from emp;
select 100 from emp;

-- ORA-01722: invalid number
select ename + job from emp;

select ename || ' : ' || job from emp;

-- ORA-00923: FROM keyword not found where expected
select empno, sal, empno > sal from emp;
select empno, sal from emp where empno > sal;



