----------------------------------------------------------------------------------------------------
-- Tabla: Ciudades
----------------------------------------------------------------------------------------------------

CREATE TABLE ciudades (
    ciudadid NUMBER NOT NULL,
    nombreciudad NVARCHAR2(50) NOT NULL,

    -- Llave primaria
    CONSTRAINT ciudades_pk PRIMARY KEY (ciudadid),

    -- Columnas únicas
    CONSTRAINT ciudades_uq UNIQUE (nombreciudad)
);

-- Secuencia
CREATE SEQUENCE ciudades_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE ORDER;

-- Disparador
CREATE OR REPLACE TRIGGER ciudades_trg
    BEFORE INSERT ON ciudades FOR EACH ROW
BEGIN
    :new.ciudadid := ciudades_seq.nextval;
END;
/

----------------------------------------------------------------------------------------------------
-- Tabla: beneficiarios
----------------------------------------------------------------------------------------------------

CREATE TABLE beneficiarios (
    beneficiarioid NUMBER NOT NULL,
    nombre NVARCHAR2(75) NOT NULL,
    edad NUMBER NOT NULL,
    ciudadid NUMBER NOT NULL,

    -- Llave primaria
    CONSTRAINT beneficiarios_pk PRIMARY KEY (beneficiarioid),

    -- Llave foránea
    CONSTRAINT beneficiarios_fk FOREIGN KEY (ciudadid) REFERENCES ciudades (ciudadid) ON DELETE CASCADE
);

-- Secuencia
CREATE SEQUENCE beneficiarios_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE ORDER;

-- Disparador
CREATE OR REPLACE TRIGGER beneficiarios_trg
    BEFORE INSERT ON beneficiarios FOR EACH ROW
BEGIN
    :new.beneficiarioid := beneficiarios_seq.nextval;
END;
/

----------------------------------------------------------------------------------------------------
-- Tabla: Ayudas
----------------------------------------------------------------------------------------------------

CREATE TABLE ayudas (
    ayudaid NUMBER NOT NULL,
    monto NUMBER NOT NULL,
    motivo NVARCHAR2(25) NOT NULL,
    beneficiarioid NUMBER NOT NULL,

    -- Llave primaria
    CONSTRAINT ayudas_pk PRIMARY KEY (ayudaid),

    -- Llave foránea
    CONSTRAINT ayudas_fk FOREIGN KEY (beneficiarioid) REFERENCES beneficiarios (beneficiarioid) ON DELETE CASCADE
);

-- Secuencia
CREATE SEQUENCE ayudas_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE ORDER;

-- Disparador
CREATE OR REPLACE TRIGGER ayudas_trg
    BEFORE INSERT ON ayudas FOR EACH ROW
BEGIN
    :new.ayudaid := ayudas_seq.nextval;
END;
/

