CREATE DATABASE PARADISE;
use PARADISE;
CREATE TABLE Cliente (
Nome VARCHAR(50),
Celular VARCHAR(50),
Id_Cliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT
);

CREATE TABLE Destino (
Id_Destino INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Valor FLOAT,
Volta varchar(10),
Ida  VARCHAR(10)
);

CREATE TABLE Contato (
Nome_completo VARCHAR(50),
Mensagem VARCHAR(50),
Telefone VARCHAR(15),
Email VARCHAR(50),
Id_Contato INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Id_Cliente INT,
FOREIGN KEY(Id_Cliente) REFERENCES Cliente (Id_Cliente)
);

CREATE TABLE Compra (
Id_Destino INT,
Id_Cliente INT,
Id_Compra INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
FOREIGN KEY(Id_Cliente) REFERENCES Cliente (Id_Cliente),
FOREIGN KEY(Id_Destino) REFERENCES Destino (Id_Destino)
);

create view contato_cliente as 
select c.id_contato, c.Nome_Completo, c.Mensagem, c.Telefone, c.Email, u.* 
from contato c, cliente u
where c.id_cliente = u.id_cliente;


select c.id_contato, c.Nome_Completo, c.Mensagem, c.Telefone, c.Email, u.* 
from contato c, cliente u
where c.id_cliente = u.id_cliente;


