CREATE SEQUENCE user_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE users (
    user_id BIGINT PRIMARY KEY DEFAULT nextval('user_id_sequence'),
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    email VARCHAR(255),
    address_id BIGINT REFERENCES address (address_id)
);
