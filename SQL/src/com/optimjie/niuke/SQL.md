#### SQL61 对于employees表中，给出奇数行的first_name
```sql
select first_name from employees where first_name in (
    select first_name from (
        select first_name, row_number() over(order by first_name) as rk from employees
    ) tb1 where rk % 2 = 1
) 
```

#### SQL62 出现三次以上相同积分的情况

```sql
select number from grade
group by number
having count(id) >= 3
```

#### SQL63 刷题通过的题目排名

```sql
select id, number, dense_rank() over(order by number desc) as t_rank from passing_number
```

#### SQL64 找到每个人的任务

```sql
select person.id, person.name, task.content from person left join task
on person.id = task.person_id
```

#### SQL65 异常的邮件概率

```sql
select date, round(sum(case when type = 'completed' then 0 else 1 end) / count(date), 3) as p from (
    select * from email 
    where send_id in (
        select id from user where is_blacklist = 0
    ) and receive_id in (    
        select id from user where is_blacklist = 0
    ) 
) tb1
group by date
order by date
```

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

#### SQL73 考试分数(二)

```sql
select tb1.* from grade as tb1
left join (
    select job, avg(score) as avg from grade group by job
) as tb2
on tb1.job = tb2.job
where score > avg
order by tb1.id
```

#### SQL73 考试分数(三)

```sql
select tb1.id, name, score from (
    select id, language_id, score, dense_rank() over(partition by language_id order by score desc) as rk from grade
) tb1  inner join language 
on tb1.language_id = language.id
where rk <= 2
order by name, score desc
```

#### SQL73 考试分数(四)

```sql
select 
job,
case when cnt % 2 = 1 then ceiling(cnt / 2) else ceiling(cnt / 2) end,
case when cnt % 2 = 1 then ceiling(cnt / 2) else ceiling(cnt / 2) + 1 end
from (
    select job, count(id) as cnt from grade
    group by job
) tb1
order by job
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
select tb1.job, first_year_month, first_year_cnt, second_year_month, second_year_cnt from (
    select job, date_format(date,'%Y-%m') as first_year_month, sum(num) as first_year_cnt
    from resume_info 
    where date between '2025-01-01' and '2025-12-31'
    group by first_year_month, job
    order by first_year_month desc, job desc
) tb1 inner join (
    select job, date_format(date,'%Y-%m') as second_year_month, sum(num) as second_year_cnt
    from resume_info 
    where date between '2026-01-01' and '2026-12-31'
    group by second_year_month, job
    order by second_year_month desc, job desc
) tb2
on (substr(tb2.second_year_month from 3 for 2) - substr(tb1.first_year_month from 3 for 2)) = 1
    and substr(tb2.second_year_month from 6 for 2) = substr(tb1.first_year_month from 6 for 2)
    and tb1.job = tb2.job
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
