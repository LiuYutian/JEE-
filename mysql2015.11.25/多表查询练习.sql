/* 1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。*/

SELECT d.*, z1.cut
FROM dept d, (SELECT deptno, COUNT(*) cut FROM emp GROUP BY deptno) z1
WHERE d.deptno=z1.deptno;

/*3. 列出所有员工的姓名及其直接上级的姓名。*/

SELECT e1.ename 职员, IFNULL(e2.ename, 'BOSS') 领导
FROM emp e1 LEFT OUTER JOIN emp e2 
ON e1.mgr=e2.empno;

/*4. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。*/

SELECT e1.empno, e1.ename, d.dname
FROM emp e1, emp e2, dept d
WHERE e1.mgr=e2.empno AND e1.hiredate<e2.hiredate AND d.deptno=e1.deptno;

/*5. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。*/

SELECT e.*, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno=d.deptno

/*7. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。*/
SELECT e.job, COUNT(*)
FROM emp e
GROUP BY e.job
HAVING MIN(e.sal) > 15000

/*8. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。*/

SELECT e.ename
FROM emp e
WHERE e.deptno=(SELECT d.deptno FROM dept d WHERE d.dname='销售部')

/*9. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。*/

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

/*未加左外链接*/
SELECT e.*, d.dname, m.ename, s.grade
FROM emp e, dept d, emp m, salgrade s
WHERE e.sal>(SELECT AVG(sal) FROM emp) 
	AND e.deptno=d.deptno 
	AND e.mgr=m.empno 
	AND e.sal BETWEEN s.losal AND s.hisal;
	
/*加左外链接*/
SELECT e.*, d.dname, m.ename, s.grade
FROM emp e LEFT OUTER JOIN dept d ON e.deptno=d.deptno
	LEFT OUTER JOIN emp m ON e.mgr=m.empno
	LEFT OUTER JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.sal>(SELECT AVG(sal) FROM emp);

/*10.列出与庞统从事相同工作的所有员工及部门名称。*/

SELECT e.*, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno AND job=(SELECT job FROM emp WHERE ename='庞统')

/*11.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。*/
/*列： e.ename, e.sal
表：emp e, dept d
条件：sal>(30部门薪金)
*/

SELECT e.ename, e.sal, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno AND sal > ALL (SELECT sal FROM emp WHERE deptno=30);

/*
13.查出年份、利润、年度增长比
2. 列出薪金比关羽高的所有员工。
6. 列出所有文员的姓名及其部门名称，部门的人数。
12.列出每个部门的员工数量、平均工资。
*/









































































































