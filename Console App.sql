use bangtandb;

create table ConsoleApp(
     Name varchar(20),
     Email varchar(20),
     Phone varchar(20),
     Password varchar(300)
     );
     
select * from Users;

alter table ConsoleApp rename to Users; 

drop table Users;