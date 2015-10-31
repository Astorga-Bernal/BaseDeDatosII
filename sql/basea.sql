-- Databases: "baseA - Base de Datos II 2015"
-- Motor: Mysql    

CREATE DATABASE /*!32312 IF NOT EXISTS*/ baseA;
USE baseA;


-- Table "Cliente"
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  nro_cliente int(10) unsigned NOT NULL auto_increment, 
  nombre varchar(45) NOT NULL default '', 
  apellido varchar(45) NOT NULL default '', 
  dereccion varchar(45) NOT NULL default '', 
  telefono int(20),
  CONSTRAINT pk_nro_cliente PRIMARY KEY (nro_cliente) 
);


-- Insercion de datos a tabla "Cliente"
INSERT INTO cliente (nro_cliente,nombre,apellido,dereccion,telefono) VALUES 
			(1,'Maria Marta','Juarez','La Falda',35898763),
		  (2,'Ruben Cufre','Juarez','La Falda',35898763),
		  (3,'Abel Pintos','Juarez','La Falda',35898763),
			(4,'Luciano Rodriguez','Perez','La Falda',35898763);