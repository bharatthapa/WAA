 
DROP TABLE IF EXISTS EMPLOYEE;

create table EMPLOYEE( ID int primary key AUTO_INCREMENT NOT NULL, 
						firstName varchar(25),
						lastName varchar(25),
						AGE BIGINT,
						EMPLOYEENUMBER BIGINT,
						title varchar(25)
					);