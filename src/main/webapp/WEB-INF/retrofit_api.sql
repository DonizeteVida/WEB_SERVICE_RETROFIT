CREATE DATABASE retrofit_api;

USE retrofit_api;

CREATE TABLE usuario(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) UNIQUE,
    senha VARCHAR(100)
);

    
    SELECT * FROM usuario;
    
CREATE TABLE produto(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) UNIQUE,
    preco FLOAT
);

	INSERT INTO produto(nome, preco) VALUES ("Teste", 5.95);
    
    SELECT * FROM produto;

CREATE TABLE terc(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_usuario INTEGER NOT NULL,
    id_produto INTEGER NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);
	INSERT INTO terc VALUES (0,2,1);

	SELECT t.id, p.nome, p.preco FROM produto AS p
    INNER JOIN terc AS t ON t.id_produto = p.id
    WHERE t.id_usuario = 1 ORDER BY t.id;
    
    SELECT * FROM terc;

