drop procedure if exists test;

create procedure test(in a int,inout x int)
begin
	set x = a + x + 100;
end;

set @total = 3;

call test(2, @total);

select @total from dual;

