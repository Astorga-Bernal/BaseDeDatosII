-- Motor: Mysql

CREATE DATABASE /*!32312 IF NOT EXISTS*/ basec;
USE basec;

DROP TABLE IF EXISTS vehiculo;
CREATE TABLE vehiculo (
	patente INTEGER NOT NULL,
    marca VARCHAR(15),
    modelo VARCHAR(15),
    color VARCHAR(15),
    saldoActual FLOAT,
	CONSTRAINT pk_patente PRIMARY KEY (patente) 
);

DROP TABLE IF EXISTS persona;
CREATE TABLE persona (
	dni INTEGER NOT NULL,
    nombreYApellido VARCHAR(15),
    direccion VARCHAR(15),
    CONSTRAINT pk_dni PRIMARY KEY (dni) 
);