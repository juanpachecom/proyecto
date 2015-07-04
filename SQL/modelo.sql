START TRANSACTION WITH CONSISTENT SNAPSHOT;

DROP TABLE IF EXISTS pedidos CASCADE;
DROP TABLE IF EXISTS obras CASCADE;
DROP TABLE IF EXISTS usuarios CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS muebles_materiales;
DROP TABLE IF EXISTS muebles CASCADE;
DROP TABLE IF EXISTS materiales CASCADE;
DROP TABLE IF EXISTS clientes CASCADE;
DROP TABLE IF EXISTS comunas CASCADE;
DROP TABLE IF EXISTS provincias CASCADE;
DROP TABLE IF EXISTS regiones CASCADE;

--
-- Name: regiones
--
CREATE TABLE regiones (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    corfo varchar(255) NOT NULL,
    codigo varchar(5) NOT NULL,
    numero int NOT NULL,
    UNIQUE (nombre),
    UNIQUE (codigo),
    UNIQUE (numero),
    PRIMARY KEY (id)
);


--
-- Name: provincias
--
CREATE TABLE provincias (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    region_id int NOT NULL,
    FOREIGN KEY (region_id) REFERENCES regiones(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (nombre, region_id),
    PRIMARY KEY (id)
);

--
-- Name: comunas
--
CREATE TABLE comunas (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    provincia_id int NOT NULL,
    FOREIGN KEY (provincia_id) REFERENCES provincias(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (nombre, provincia_id),
    PRIMARY KEY (id)
);



CREATE TABLE clientes (
    id bigint NOT NULL AUTO_INCREMENT,
    rut int NOT NULL,
    nombres varchar(255),
    apellidos varchar(255),
    direccion varchar(255),
    comuna_id int NOT NULL,
    FOREIGN KEY (comuna_id) REFERENCES comunas(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (rut),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
CREATE INDEX clientes_comunaid_idx ON clientes(comuna_id);




CREATE TABLE materiales (
    id bigint NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    precio_compra numeric,
    cantidad bigint DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;




CREATE TABLE muebles (
    id bigint NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    precio_venta numeric,
    UNIQUE(nombre),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;




CREATE TABLE muebles_materiales (
    id bigint NOT NULL AUTO_INCREMENT,
    mueble_id bigint NOT NULL,
    material_id bigint NOT NULL,
    FOREIGN KEY (mueble_id) REFERENCES muebles(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (material_id) REFERENCES materiales(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE(mueble_id, material_id),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;




CREATE TABLE roles (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    descripcion text,
    UNIQUE (nombre),
    PRIMARY KEY (id)
);



CREATE TABLE usuarios (
    id bigint NOT NULL AUTO_INCREMENT,
    rut int NOT NULL,
    nombres varchar(255) NOT NULL,
    apellidos varchar(255) NOT NULL,
    telefono bigint,
    rol_id int NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (rut),
    UNIQUE (nombres, apellidos, telefono, rol_id),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;





CREATE TABLE obras (
    id bigint NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    encargado_id bigint NOT NULL,
    telefono bigint,
    direccion varchar(255),
    comuna_id int NOT NULL,
    FOREIGN KEY (encargado_id) REFERENCES usuarios(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (comuna_id) REFERENCES comunas(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (nombre),
    UNIQUE (nombre, encargado_id, direccion, comuna_id),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;




CREATE TABLE pedidos (
    id bigint NOT NULL AUTO_INCREMENT,
    obra_id bigint NOT NULL,
    mueble_id bigint NOT NULL,
    cantidad bigint NOT NULL,
    FOREIGN KEY (obra_id) REFERENCES obras(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (mueble_id) REFERENCES muebles(id) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (obra_id, mueble_id),
    PRIMARY KEY (id)
);

COMMIT;
