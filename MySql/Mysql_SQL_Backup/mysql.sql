drop function if exists test;

create function test(emp_id int)
returns varchar(100)
reads sql data
begin
    declare name varchar(20);
    select username into name from tb_emp where id=emp_id;
    return name;
end;

select test(1);
select test(2);
select test(3);
