create database student_code_gym;
use student_code_gym;
create table student (
id_student int primary key,
name_student varchar(255) not null,
gender bit(1) not null,
score_student int not null
);
insert into student values
(1,"Trung",1,50),
(2,"Nhat",1,80),
(3,"Hoang",1,100),
(4,"Thuy",0,75);


select * from student;