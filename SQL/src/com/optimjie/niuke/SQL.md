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