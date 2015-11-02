
DROP TABLE IF EXISTS CUSTOMER;

create table CUSTOMER( ID int primary key AUTO_INCREMENT NOT NULL, 
						firstName varchar(25),
						lastName varchar(25),
						age BIGINT,
						eyeColor varchar(25) 
					);