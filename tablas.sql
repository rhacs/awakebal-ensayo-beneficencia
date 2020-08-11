----------------------------------------------------------------------------------------------------
-- Tabla: Ciudades
----------------------------------------------------------------------------------------------------

CREATE TABLE ciudades (
    ciudad_id NUMBER NOT NULL,
    nombre_ciudad NVARCHAR2(50) NOT NULL,

    -- Llave primaria
    CONSTRAINT ciudades_pk PRIMARY KEY (ciudad_id),

    -- Columnas únicas
    CONSTRAINT ciudades_uq UNIQUE (nombre_ciudad)
);

-- Secuencia
CREATE SEQUENCE ciudades_sq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE ORDER;

-- Disparador
CREATE OR REPLACE TRIGGER ciudades_tr
    BEFORE INSERT ON ciudades FOR EACH ROW
BEGIN
    :new.ciudad_id := ciudades_sq.nextval;
END;
/

----------------------------------------------------------------------------------------------------
-- Tabla: beneficiarios
----------------------------------------------------------------------------------------------------

CREATE TABLE beneficiarios (
    beneficiario_id NUMBER NOT NULL,
    nombre NVARCHAR2(75) NOT NULL,
    edad NUMBER NOT NULL,
    ciudad_id NUMBER NOT NULL,

    -- Llave primaria
    CONSTRAINT beneficiarios_pk PRIMARY KEY (beneficiario_id),

    -- Llave foránea
    CONSTRAINT beneficiarios_fk FOREIGN KEY (ciudad_id) REFERENCES ciudades (ciudad_id) ON DELETE CASCADE
);

-- Secuencia
CREATE SEQUENCE beneficiarios_sq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE ORDER;

-- Disparador
CREATE OR REPLACE TRIGGER beneficiarios_tr
    BEFORE INSERT ON beneficiarios FOR EACH ROW
BEGIN
	:new.beneficiario_id := beneficiarios_sq.nextval;
END;
/

----------------------------------------------------------------------------------------------------
-- Tabla: Ayudas
----------------------------------------------------------------------------------------------------

CREATE TABLE ayudas (
    ayuda_id NUMBER NOT NULL,
    monto NUMBER NOT NULL,
    motivo NVARCHAR2(25) NOT NULL,
    beneficiario_id NUMBER NOT NULL,

    -- Llave primaria
    CONSTRAINT ayudas_pk PRIMARY KEY (ayuda_id),

    -- Llave foránea
    CONSTRAINT ayudas_fk FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios (beneficiario_id) ON DELETE CASCADE
);

-- Secuencia
CREATE SEQUENCE ayudas_sq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE ORDER;

-- Disparador
CREATE OR REPLACE TRIGGER ayudas_tr
    BEFORE INSERT ON ayudas FOR EACH ROW
BEGIN
    :new.ayuda_id := ayudas_sq.nextval;
END;
/

