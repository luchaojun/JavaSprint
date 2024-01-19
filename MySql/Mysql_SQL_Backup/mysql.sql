drop procedure if exists user_cursor;
create procedure user_cursor(out res varchar(1000))
begin
    declare emp_username varchar(20);
    declare emp_name varchar(10);
    declare emp_entrydate date;
    declare i int default 0;
    declare string varchar(100);
    declare count int default 0;
    declare MyCursor cursor for select username, name, entrydate from tb_emp;
    select count(*) into count from tb_emp;
    open MyCursor;
    while i<count do
    	fetch MyCursor into emp_username, emp_name, emp_entrydate;
    	set i=i+1;
    	select concat_ws('#', emp_username, emp_name, emp_entrydate) into string;
    	set res=concat_ws(',', res, string);
    end while;
    close MyCursor;
end;

set @temp="";
call user_cursor(@temp);
select @temp from dual;
 
