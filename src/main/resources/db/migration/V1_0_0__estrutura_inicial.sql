CREATE DATABASE livraria OWNER postgres;

CREATE TABLE USUARIO (
                         id BIGINT NOT NULL DEFAULT nextval('usuario_seq'),
                         nome VARCHAR(255) NOT NULL,
                         cpf VARCHAR(11) NOT NULL UNIQUE,
                         login VARCHAR(255) NOT NULL,
                         senha VARCHAR(255) NOT NULL
);

CREATE SEQUENCE usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE USUARIO
    ALTER COLUMN id
        SET DEFAULT nextval('usuario_seq');

CREATE TABLE LIVRO (
                       id BIGINT NOT NULL DEFAULT nextval('livro_seq'),
                       titulo VARCHAR(255) NOT NULL,
                       autor VARCHAR(255) NOT NULL,
                       data_publicacao DATE NOT NULL,
                       editora VARCHAR(255) NOT NULL
);

CREATE SEQUENCE livro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE LIVRO
    ALTER COLUMN id
        SET DEFAULT nextval('livro_seq');