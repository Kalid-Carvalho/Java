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

drop table tb_setor cascade;

-- criando tabela para cadastro de clientes
create table tb_clientes(
	codigo_cliente int primary key auto_increment,
    nome_cliente varchar(50) not null,
    matricula varchar(4),
    codigo_setor int not null,
    foreign key(codigo_setor) references tb_setor(codigo_setor)
);
-- comando para excluir foreign key(caso esteja dando erro, va em esquema e foreing key e procure o nome da chave estrangeira certa.
alter table tb_clientes drop foreign key tb_clientes_ibfk_1;

alter table tb_clientes modify codigo_setor int not null;

-- exclui tabela em cascata ignorando as chaves estrangeiras
drop table tb_clientes cascade;

-- altera uma tabela(não consegui alterar :/)
alter table tb_clientes change id_clientes codigo_clientes int primary key auto_increment;

-- criando tabela que sera feito o cadastro dos sorvetes
create table tb_sorvetes(
	codigo_sorvete int primary key auto_increment,
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


insert into tb_setor(nome_setor) values('TI');
insert into tb_clientes(nome_cliente, matricula, codigo_setor) values('Kalid',0395,1);
insert into tb_sorvetes(descricao,preco) values ('Doce de leite',2.00);
insert into compra_sorvete(quantidade_sorvetes, codigo_cliente, codigo_sorvete) values('2',1,1); 

-- o código abaixo trás informações de três tabelas

select
C.nome_cliente as Cliente, C.matricula as Matricula, 
S.nome_setor as Setor, 
CS.quantidade_sorvetes as Quantidade_Sorvetes_Comprados,
TS.descricao as Sabor_vendido
from compra_sorvete as TS
inner join tb_clientes as C on S.codigo_setor = C.codigo_setor
inner join tb_sorvetes as TS on 


