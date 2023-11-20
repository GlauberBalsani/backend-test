CREATE SEQUENCE address_id_sequence
START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE address (
    address_id BIGINT PRIMARY KEY DEFAULT nextval('address_id_sequence'),
    logradouro VARCHAR(255),
    numero VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(50) -- Considerando que UF é uma enumeração representada como String
);