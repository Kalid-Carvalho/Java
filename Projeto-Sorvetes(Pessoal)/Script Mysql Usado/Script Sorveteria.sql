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
-- renomeando tabela do setor
rename table setor to tb_setor;
-- criando tabela para cadastro de clientes
create table tb_clientes(
	codigo_cliente int primary key auto_increment,
    nome_cliente varchar(50) not null,
    matricula varchar(4),
    codigo_setor int not null,
    foreign key(codigo_setor) references tb_setor(codigo_setor)
);
-- exclui tabela em cascata ignorando as chaves estrangeiras
drop table tb_clientes cascade;

alter table tb_clientes change id_clientes codigo_clientes int primary key auto_increment;

-- criando tabela que sera feito o cadastro dos sorvetes

create table tb_sorvetes(
	codigo_sorvete int primary key not null,
	descricao varchar(30) not null,
    preco decimal(10,2)
);
-- exclui uma tabela
drop table cadastro_sorvetes;

-- criando tabela onde sera feita a compra do sorvete

create table compra_sorvete (
	quantidade_sorvetes int not null,
    data_compra timestamp default current_timestamp,
    codigo_cliente int not null,
    codigo_sorvete int not null,
    foreign key(codigo_cliente) references tb_clientes(codigo_cliente),
    foreign key(codigo_sorvete) references tb_sorvetes(codigo_sorvete)
);

