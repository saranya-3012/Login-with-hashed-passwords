use bangtandb;

# SESSION BASED LOGIN MODULE
create table Sessionlogin(
     Username varchar(20),
     Password varchar(15)
);

select * from Sessionlogin;

create table SessionId(
	Session_ID varchar(300),
	Username varchar(20) 
);

select * from SessionId;

insert into Sessionlogin (Username, Password) values ("Saranya", "Saran@123");