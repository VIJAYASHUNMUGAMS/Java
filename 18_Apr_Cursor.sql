--Task - 18th April
--1. To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.
SET SERVEROUTPUT ON;
DECLARE
    emprec emp%rowtype;-- TableName%
    CURSOR mycur IS SELECT * FROM emp WHERE JOB = 'MANAGER' OR JOB = 'ANALYST';
BEGIN
    OPEN mycur;
    LOOP
    FETCH mycur INTO emprec;
    EXIT WHEN mycur%NOTFOUND;    
    dbms_output.put_line(emprec.ename || '    ' || emprec.deptno || '    ' || emprec.JOB); 
    END LOOP;
    CLOSE mycur;
END;
/

--2. Write PL/SQL code in Cursor to display employee names and salary
declare
    emprec emp%rowtype;-- TableName%
    cursor mycur is select * from emp;
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.ename || '    ' || emprec.deptno || '    ' || emprec.job); 
    end loop;
    close mycur;
end;
/
--3.Write PL/SQL code in Procedure to find the Reverse of the  number

declare
    X VARCHAR2(20);
    Y VARCHAR2(20);
    TEMP int;
    len int;
BEGIN
    X:=TO_CHAR('&Numbertoreverse');
    dbms_output.put_line(' Entered number : ' || X);
    len := length(X);
   loop
        Y:=Y||SUBSTR (X, len, 1);
        len:=len-1;
        if len=0 then exit;
        end if;        
   end loop;
   dbms_output.put_line('Reversed number : ' || Y);
END;

--4. To write a  Parametrized Cursor to display the list of employees who are Working as a Managers or Analyst.
SET SERVEROUTPUT ON;
DECLARE
    JOBROLE1 VARCHAR2(15);
    JOBROLE2 VARCHAR2(15);
    emprec emp%rowtype;-- TableName%type
    CURSOR mycur(JOBTYPE1 VARCHAR2,JOBTYPE2 VARCHAR2) IS SELECT * FROM emp WHERE JOB = JOBTYPE1 OR JOB = JOBTYPE2;
BEGIN
    JOBROLE1:='&JOB1';
    JOBROLE2:='&JOB2';
    OPEN mycur(JOBROLE1,JOBROLE2);
    LOOP
    FETCH mycur INTO emprec;
    EXIT WHEN mycur%NOTFOUND;    
    dbms_output.put_line(emprec.ename || '    ' || emprec.deptno || '    ' || emprec.JOB); 
    END LOOP;
    CLOSE mycur;
END;
/
