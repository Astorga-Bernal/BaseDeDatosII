-- Motor: Mysql
CREATE DATABASE /*!32312 IF NOT EXISTS*/ basea;
USE basea;

-- Table "Cliente"
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  nro_cliente int(10) unsigned NOT NULL auto_increment, -- Considero que el nro sea positivo y autoincrementado
  dni varchar(45) NOT NULL UNIQUE,
  nombre varchar(45) NOT NULL default '', -- Considero que el nombre sea Varchar y por defecto vacio
  apellido varchar(45) NOT NULL default '', -- Considero que el apellido sea Varchar y por defecto vacio
  dereccion varchar(45) NOT NULL default '', -- Considero que la direccion sea Varchar y por defecto vacio
  telefono int(20), -- Considero que el telefono contiene una longitud de 20 numeros
  
  CONSTRAINT pk_nro_cliente PRIMARY KEY (nro_cliente,nombre)
);
-- Insercion de datos a tabla "Cliente"
INSERT INTO cliente (nro_cliente,dni,nombre,apellido,dereccion,telefono) 
	VALUES 
			(1,'1','Maria Marta','Juarez','La Falda',35898763),
		    (2,'2','Ruben Cufre','Juarez','La Falda',35898763),
		    (3,'3','Abel Pintos','Juarez','La Falda',35898763),
			(4,'4','Luciano Rodriguez','Perez','La Falda',35898763);


-- Table "Factura"
DROP TABLE IF EXISTS factura;
CREATE TABLE factura (
    nro_factura INT(10) UNSIGNED,
    nro_cliente INT(10) UNSIGNED,
    fecha DATE,
    monto DECIMAL(5,2),
    cantidadMaxItems INTEGER, -- cantidad maÌ�xima de iÌ�tems permitidos.
    CONSTRAINT pk_nro_factura PRIMARY KEY (nro_factura),
    CONSTRAINT fk_nro_cliente FOREIGN KEY (nro_cliente) REFERENCES cliente (nro_cliente) on delete cascade
);
-- Insercion de datos a tabla "Factura"
INSERT INTO factura (nro_factura,nro_cliente,fecha,monto,cantidadMaxItems) 
	VALUES 
			(1,1,'2014-03-19',23.90,3),
			(2,2,'2014-03-19',90.56,5),
            (3,3,'2014-03-19',90.56,4);

-- Table "Producto"
DROP TABLE IF EXISTS producto;
CREATE TABLE producto(
  cod_producto int(10) unsigned NOT NULL auto_increment, 
  descripcion varchar(45) NOT NULL default '',
  precio decimal(5,2),
  stock_minimo INTEGER,
  stock_maximo INTEGER,
  cantidad int(100),
  CONSTRAINT pk_cod_producto PRIMARY KEY (cod_producto) -- Clave primaria en (Mysql)
);
-- Insercion de datos a la tabla "Producto"
-- Como en Mysql no se imlementan los dominion hago una insercion de datos:
INSERT INTO producto (cod_producto,descripcion,precio,stock_minimo,stock_maximo,cantidad) 
	VALUES 
		 (1,'Cristales','274.56',10,200,50),
		 (2,'Cristales2','236.86',10,200,50),
		 (3,'Cristales3','231.76',10,200,50),
		 (4,'Cristales4','224.56',10,200,50);

-- Table "ItemFactura"
DROP TABLE IF EXISTS itemFactura;
CREATE TABLE itemFactura(
	cod_producto int(10) unsigned,
    nro_factura int(10) unsigned,
    cantidad int(50),
    precio decimal(5,2),
	CONSTRAINT fk_cod_producto FOREIGN KEY (cod_producto) REFERENCES producto(cod_producto) on delete restrict,
    CONSTRAINT fk_nro_factura FOREIGN KEY (nro_factura) REFERENCES factura(nro_factura)
);

-- Procedure para ver si supera o no la cantidad 
-- En postgres en necesario crear un procedimiento y luego llamarlo en el trigger, el trigger
-- solo lo llama me parece
-- En mysql no es necesario el procedimiento, puedo hacerlo directamente en el trigger
-- (Trigger para ver si insertar o no en la tabla)
-- Controlar que la base de datos no acepte que una factura tenga maÌ�s iÌ�tems que la cantidad de iÌ�tems permitidos por esta.

DELIMITER //
 CREATE TRIGGER Chequeo
 BEFORE INSERT ON itemFactura FOR EACH ROW
	BEGIN 
		
		DECLARE cantMaxItems,cantidadDeitemFactura INT;
		SELECT cantidadMaxItems INTO cantMaxItems FROM factura;
		SELECT nro_factura INTO cantidadDeitemFactura FROM itemFactura;
        
		if cantidadDeitemFactura > cantMaxItems
		then SET @VARERROR = 'NO RESPETA! cantidad de items permitidos';
		end if;
		
	END//
DELIMITER ;


delimiter //
CREATE PROCEDURE simpleproc (OUT param1 INT)
BEGIN
	SELECT COUNT(*) INTO param1 FROM t;
END//

CREATE FUNCTION hello (s CHAR(20))
 RETURNS CHAR(50) DETERMINISTIC
 RETURN CONCAT('Hello, ',s,'!');

-- SELECT hello('world');
