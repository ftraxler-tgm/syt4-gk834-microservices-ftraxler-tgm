drop table T_User if exists;

create table T_User (ID bigint identity primary key, NUMBER varchar(9),
                        NAME varchar(50) not null, unique(NUMBER));
