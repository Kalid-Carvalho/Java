-- criando banco de dados do aplicativo sorveteria.
create database sorveteria;
-- acessando o banco de dados sorveteria
use sorveteria;
-- creando tabela para cadastro de usuarios para futuro login
create table tb_usuarios(
	id_usuario int primary key,
    nome varchar(50) not null,
    login varchar(30) not null,
    senha varchar(30) not null
);
-- creando tabela setor
create table setor(
	codigo_setor int primary key auto_increment,
    nome_setor varchar(30)
);

rename table setor to tb_setor;
create table tb_clientes(
	id_clientes int primary key auto_increment,
    nome_cliente varchar(50) not null,
    matricula varchar(4),
    codigo_setor int not null,
    foreign key(codigo_setor) references tb_setor(codigo_setor)
);