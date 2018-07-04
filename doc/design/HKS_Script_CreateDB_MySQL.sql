create database hks default character set utf8;
create user 'hks'@'localhost' identified by 'Hks@123';
grant all on hks.* to hks@localhost;
