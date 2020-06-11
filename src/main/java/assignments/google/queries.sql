SELECT emp.name,
       sup.name AS supervisor,
       bn.nbonus
FROM employees emp
LEFT OUTER JOIN employees sup ON emp.supervisor = sup.empid
LEFT OUTER JOIN bonus bn ON emp.empid = bn.empid
WHERE bn.nbonus > 1000;

SELECT *
FROM
  (SELECT emp.empid,
          emp.name,
          emp.location,
          emp.salary,
          bn.nbonus,
          (emp.salary + coalesce(bn.nbonus, 0)) AS total
   FROM employees emp
   LEFT OUTER JOIN bonus bn USING (empid)) main
INNER JOIN
  (SELECT emp.location,
          max(emp.salary + coalesce(bn.nbonus,0)) AS total
   FROM employees emp
   LEFT OUTER JOIN bonus bn USING(empid)
   GROUP BY emp.location) grouped ON main.location = grouped.location
AND main.total = grouped.total;

UPDATE employees emp
INNER JOIN
  (SELECT sup.empid,
          sup.supervisor
   FROM new_supervisor sup) AS usup using(empid)
SET emp.supervisor = usup.supervisor;
