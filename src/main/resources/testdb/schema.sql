<<<<<<< HEAD
drop table T_User if exists;

create table T_User (ID bigint identity primary key, NUMBER varchar(9),
                        NAME varchar(50) not null, unique(NUMBER));
=======
drop table T_ACCOUNT if exists;

create table T_ACCOUNT (ID bigint identity primary key, NUMBER varchar(9),
                        NAME varchar(50) not null, BALANCE decimal(8,2), unique(NUMBER));
                        
ALTER TABLE T_ACCOUNT ALTER COLUMN BALANCE SET DEFAULT 0.0;
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2
