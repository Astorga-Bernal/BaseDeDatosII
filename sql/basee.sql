-- Motor: Mysql

CREATE DATABASE /*!32312 IF NOT EXISTS*/ basee;
USE basee;


DROP TABLE IF EXISTS casa;
CREATE TABLE casa (
	direccion VARCHAR(6),
    color VARCHAR(25),
	CONSTRAINT pk_direccion PRIMARY KEY (direccion) 
);

