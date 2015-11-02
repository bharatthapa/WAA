

DROP TABLE IF EXISTS PRODUCT;

create table PRODUCT( ID BIGINT PRIMARY KEY  AUTO_INCREMENT NOT NULL, 
						PRODUCTID varchar(20),
						name varchar(255),
						priceperunit DECIMAL,
						description varchar(255),
		 				manufacturer varchar(255),
		 				category varchar(40),
						unitsInStock BIGINT,
		 				unitsInOrder BIGINT,
						discontinued BOOLEAN,
		 				conditions varchar(100)
					);
					
DROP TABLE IF EXISTS CUSTOMER;

create table CUSTOMER( ID BIGINT primary key AUTO_INCREMENT NOT NULL, 
						firstName varchar(25),
						lastName varchar(25),
						age BIGINT,
						eyeColor varchar(25) 
					);
					

ALTER TABLE PRODUCT ADD  COLUMN customerId BIGINT;
ALTER TABLE PRODUCT ADD CONSTRAINT CUSTOMERREL FOREIGN KEY (customerId) REFERENCES CUSTOMER (id);
					
					