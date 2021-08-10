#### SQL66 牛客每个人最近的登录日期(一)

```sql
select user_id, max(date) d
from login
group by user_id
order by user_id
```

#### SQL67 牛客每个人最近的登录日期(二)

```sql
select user.name as u_n, client.name as c_n, date from login
inner join user on login.user_id = user.id
inner join client on login.client_id = client.id
where (user.id, date) in (
    select user_id, max(date) from login group by user_id
)
order by user.name
```

#### SQL67 牛客每个人最近的登录日期(三)

```sql
select round(
(
    select count(*) from (
        select distinct tb1.user_id
        from login as tb1 inner join login as tb2
        on tb1.user_id = tb2.user_id and tb1.date - tb2.date = 1
        order by tb1.user_id, tb2.date
    ) as tb3
) / (
    select count(distinct user_id) from login
)      
, 3)   
```

#### SQL67 牛客每个人最近的登录日期(四)

```sql
select tb3.date, ifnull(tb2.new, 0) from (
    select date, count(user_id) as new from (
        select user_id, date, row_number() over(partition by user_id) as rk from login
    ) tb1 where rk = 1
    group by date
) tb2 right join (
    select distinct date from login
    order by date
) tb3 on tb2.date = tb3.date
```

#### SQL67 牛客每个人最近的登录日期(五)

基本的思路就是

```sql
select tb4.date, case when tot_cnt = 0 then 0.000 else round(ifnull(cnt, 0) / tot_cnt, 3) end from (
    select date, sum(case when rk = 1 then 1 else 0 end) as tot_cnt from (
        select date, row_number() over(partition by user_id order by date) as rk from login
    ) as tb1 group by date
) tb4 left join (
    select tb2.date as date, count(tb2.user_id) as cnt from login as tb2
    inner join login as tb3
    on tb2.user_id = tb3.user_id and tb2.date + 1 = tb3.date
    group by tb2.date
) tb5 on tb4.date = tb5.date
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
