-- not in
select
Request_at as Day,
round(sum(case when Status <> 'completed' then 1 else 0 end) / count(Id), 2) as 'Cancellation Rate'
from Trips
where Client_Id not in (
    select Users_Id from Users
    where Banned = 'Yes' and Role = 'client'
) and Driver_Id not in (
    select Users_Id from Users
    where Banned = 'Yes' and Role = 'driver'
) and Request_at between '2013-10-01' and '2013-10-03'
group by Request_at

-- join
select
Request_at as 'Day',
round(sum(case when Status <> 'completed' then 1 else 0 end) / count(Id), 2) as 'Cancellation Rate'
from Trips as tb1
inner join Users as tb2
on tb1.Client_Id = tb2.Users_Id and tb2.Banned = 'No'
inner join Users as tb3
on tb1.Driver_Id = tb3.Users_Id and tb3.Banned = 'No'
where Request_at between '2013-10-01' and '2013-10-03'
group by Request_at
order by Request_at