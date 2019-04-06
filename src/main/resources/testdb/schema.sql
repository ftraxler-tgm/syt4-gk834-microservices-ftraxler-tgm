drop table T_User if exists;

create table T_User (ID bigint identity primary key,
                        FNAME varchar(50) not null,LNAME varchar(50) not null, ROLE varchar(10) not null,PASSWORD varchar(20));
