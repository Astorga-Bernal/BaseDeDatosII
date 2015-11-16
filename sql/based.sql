-- Motor: Mysql

CREATE DATABASE /*!32312 IF NOT EXISTS*/ based;
USE based;

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
    nombreYApellido VARCHAR(25),
    CONSTRAINT pk_dni PRIMARY KEY (dni) 
);

DROP TABLE IF EXISTS propiedad;
CREATE TABLE propiedad (
	id_propiedad INTEGER NOT NULL,
    dni INTEGER NOT NULL,
    direccion VARCHAR(15),
    barrio VARCHAR(15),
    CONSTRAINT fk_dni FOREIGN KEY (dni) REFERENCES persona (dni), 
    CONSTRAINT pk_id_propiedad PRIMARY KEY (id_propiedad) 
);