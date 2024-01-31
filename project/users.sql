create database project;
use project;
CREATE TABLE categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL
);
INSERT INTO categorias (nombre) VALUES ("Profesional"), ("Usuario"), ("Administrador");
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario VARCHAR(255) NOT NULL,
  contraseña VARCHAR(255) NOT NULL,
  categorias_id INT(255) NOT NULL FOREING KEY categorias_id REFERENCES categorias(id);
)
INSERT INTO usuarios (usuario, contraseña, categoría_id)
VALUES ("juanperez", "123456", 1),
("mariagarcia", "654321", 2),
("pedrolopez", "789012", 3);
