drop table if EXISTS teacher;
create table teacher(
	stu_name varchar(20) character set utf8mb4 collate utf8mb4_general_ci primary key,
	tea_name varchar(20)
);

drop table if EXISTS student;
create table student(
	id int primary key,
	name varchar(20) character set utf8mb4 collate utf8mb4_0900_ai_ci not null,
	CONSTRAINT `name_stu_name_fk` FOREIGN KEY(name) REFERENCES teacher(stu_name)
);

insert into teacher values('chaojun1', 'hefang1'), ('chaojun2', 'hefang2');

insert into student values(1, 'chaojun1'), (2, 'chaojun2');
 
