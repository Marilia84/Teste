CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL
);

CREATE TABLE secretaria (
    id_secretaria SERIAL PRIMARY KEY,
    id_usuario INT UNIQUE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE aluno (
    id_aluno SERIAL PRIMARY KEY,
    id_usuario INT UNIQUE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE professor (
    id_professor SERIAL PRIMARY KEY,
    id_usuario INT UNIQUE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

select * from professor
select * from aluno
select * from secretaria
select * from usuario