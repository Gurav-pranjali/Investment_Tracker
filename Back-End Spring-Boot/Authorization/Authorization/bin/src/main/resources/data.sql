drop table if exists userrecord;
create table userrecord(user_id int primary key ,user_name varchar(30),user_password varchar(20));


INSERT INTO userrecord (user_id,user_name,user_password) VALUES (101,'Pranjali','1234');
