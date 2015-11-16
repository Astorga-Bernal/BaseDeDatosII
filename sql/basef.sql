-- Motor: Mysql

CREATE DATABASE /*!32312 IF NOT EXISTS*/ basef;
USE basef;

DROP TABLE IF EXISTS propietario;
CREATE TABLE propietario (
	dni VARCHAR(10),
	nombre VARCHAR(6),
    apellido VARCHAR(25),
	CONSTRAINT pk_dni PRIMARY KEY (dni) 
);

DROP TABLE IF EXISTS casa;
CREATE TABLE casa (
	dni VARCHAR(10),
	direccion VARCHAR(6),
    color VARCHAR(25),
    CONSTRAINT fk_dni FOREIGN KEY (dni) REFERENCES propietario(dni), 
	CONSTRAINT pk_direccion PRIMARY KEY (direccion) 
);

