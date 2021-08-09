create database if not exists ebookshop;

use ebookshop;
drop table if exists books;

create table books(
id int, 
title varchar(50),
author varchar(50),
price float,
qty int,
primary key(id));

insert into books values(1001,'Java for dummies', 'Samarth Narula', 200, 20);
insert into books values(1002,'Kubernetes For Administrator', 'Abhishek Shah', 100, 30);
insert into books values(1003,'Kubernetes For Developers', 'Henil Mehta', 50, 10);

select * from books;
delete from ebookshop.books where id=5006;
truncate table ebookshop.books;