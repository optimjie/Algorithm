#### SQL66 牛客每个人最近的登录日期(一)

```sql
select user_id, max(date) d
from login
group by user_id
order by user_id
```

#### SQL84 实习广场投递简历分析(一)
```sql
select job, sum(num) as cnt
from resume_info
where date between '2025-01-01' and '2025-12-31'
group by job
order by cnt desc
```

#### SQL85 实习广场投递简历分析(二)

```sql
select job, date_format(date, '%Y-%m') as mon, sum(num) as cnt from resume_info
where date between '2025-01-01' and '2025-12-31'
group by mon, job
order by mon desc, cnt desc
```

#### SQL86 实习广场投递简历分析(三)

```sql
SELECT tb1.job, first_year_month, first_year_cnt, second_year_month, second_year_cnt FROM (
	SELECT job, DATE_FORMAT(date,'%Y-%m') as first_year_month, SUM(num) AS first_year_cnt
	FROM resume_info 
	WHERE date BETWEEN '2025-01-01' AND '2025-12-31'
	GROUP BY first_year_month, job
	ORDER BY first_year_month DESC, job DESC
) tb1 INNER JOIN (
	SELECT job, DATE_FORMAT(date,'%Y-%m') as second_year_month, SUM(num) AS second_year_cnt
	FROM resume_info 
	WHERE date BETWEEN '2026-01-01' AND '2026-12-31'
	GROUP BY second_year_month, job
	ORDER BY second_year_month DESC, job DESC
) tb2
ON (SUBSTR(tb2.second_year_month FROM 3 FOR 2) - SUBSTR(tb1.first_year_month FROM 3 FOR 2)) = 1
	AND SUBSTR(tb2.second_year_month FROM 6 FOR 2) = SUBSTR(tb1.first_year_month FROM 6 FOR 2)
	AND tb1.job = tb2.job

```

#### SQL89 获得积分最多的人(一)

```sql
select user.name, sum(grade_num) as grade_sum
from user 
left join grade_info
on user.id = grade_info.user_id
group by user.id, user.name
order by grade_sum desc
limit 1
```

#### SQL90 获得积分最多的人(二)

```sql
select id, name, sum(grade_num) as grade_sum
from user
left join grade_info
on user.id = grade_info.user_id
group by user.id, user.name
having grade_sum = (
    select sum(grade_num) as grade_sum
    from user
    left join grade_info
    on user.id = grade_info.user_id
    group by user.id, user.name
    order by grade_sum desc
    limit 1
)
order by id
```

#### SQL91 获得积分最多的人(三)

```sql
select id, name, sum(case when type = 'add' then grade_num else (0 - grade_num) end) as grade_sum
from user 
left join grade_info
on user.id = grade_info.user_id
group by id
having grade_sum = (
    select sum(case when type = 'add' then grade_num else (0 - grade_num) end) as grade_sum
    from user 
    left join grade_info
    on user.id = grade_info.user_id
    group by id
    order by grade_sum desc
    limit 1
)
order by grade_sum desc
```
