drop table USER if exists;

create table USER (ID bigint identity primary key, NUMBER varchar(9),USERNAME varchar(50) not null,PASSWORD varchar(20) not null , unique(NUMBER));
                        
ALTER TABLE USER ALTER COLUMN BALANCE SET DEFAULT 0.0;
