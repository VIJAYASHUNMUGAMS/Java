--13th April
--No 39:
--171. List the emps whose Sal is more than Blake Sal.
SELECT * FROM EMP WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE')

--172. List the emps of Deptno 10 whose Jobs are same as any emp job of deptno 20.
--Option 1 : ( via JOIN )
SELECT DISTINCT E1.* fROM EMP E1 JOIN EMP E2 ON E1.JOB = E2.JOB WHERE E1.DEPTNO = 10 AND E2.DEPTNO = 20

--Option 2 : ( via Sub-query )
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 20)

--173. List the emps who are senior to Ward.
SELECT * FROM EMP WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'WARD')