create procedure test1(IN a int, IN b int, OUT c int)
BEGIN
    set c = a + b;
END;
set @total = 0;
call test1(2, 4, @total);

select @total from dual;

