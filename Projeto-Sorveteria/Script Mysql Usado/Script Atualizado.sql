-- criando banco de dados do aplicativo sorveteria.
CREATE DATABASE sorveteria;

drop database sorveteria;

-- acessando o banco de dados sorveteria
use sorveteria;

-- criando tabela para cadastro de usuarios para futuro login
create table tb_usuarios(
	id_usuario int primary key,
    nome varchar(50) not null,
    login varchar(30) not null,
    senha varchar(30) not null,
    perfil varchar(15) not null,
	fone varchar(20) 
);

select * from tb_usuarios;

-- criando tabela para cadastro de clientes
create table tb_clientes(
	codigo_cliente int primary key auto_increment,
    nome_cliente varchar(50) not null,
    setor varchar(20) not null
);

select * from tb_clientes;


-- criando tabela que sera feito o cadastro dos sorvetes
create table tb_sorvetes(
	codigo_sorvete int primary key auto_increment,
	descricao varchar(30) not null,
    preco decimal(10,2)
);


-- criando tabela onde sera feita a compra do sorvete
create table compra_sorvete (
	os int primary key auto_increment,	
    data_compra timestamp default current_timestamp,
    tipo varchar(15) not null,
    qtd_sorvetes int not null,
    valor decimal(10,2),
    situacao varchar(15) not null,
    codigo_cliente int not null,
    codigo_sorvete int not null,
    foreign key(codigo_cliente) references tb_clientes(codigo_cliente),
    foreign key(codigo_sorvete) references tb_sorvetes(codigo_sorvete)
);

SELECT
	C.nome_cliente as Nome,
	CS.os as OS, 
    CS.data_compra as Data Venda_venda, 
    CS.qtd_sorvetes as Quantidade, 
	CS.situacao as Situação,
    S.descricao as Sabor,
    CS.qtd_sorvetes*S.preco as Total
FROM compra_sorvete as CS
inner join tb_sorvetes as S on CS.codigo_sorvete = S.codigo_sorvete
inner join tb_clientes as C on CS.codigo_cliente = C.codigo_cliente;



desc tb_clientes;
desc tb_sorvetes;
desc compra_sorvete;


insert into tb_clientes(nome_cliente, matricula) values('Kalid',0395);
insert into tb_sorvetes(descricao,preco) values ('Doce de leite',2.00);
insert into compra_sorvete(quantidade_sorvetes, codigo_cliente, codigo_setor, codigo_sorvete) values(5,1,1,1); 

-- o código abaixo trás informações de três tabelas(vai ser usado provavelmente no relatorio)
select
C.nome_cliente as Cliente, C.matricula as Matricula, 
S.nome_setor as Setor, 
CS.quantidade_sorvetes as Quantidade_Sorvetes_Comprados,
CS.quantidade_sorvetes*TS.preco as Total
from compra_sorvete as CS
inner join tb_clientes as C on C.codigo_cliente = CS.codigo_cliente
inner join tb_sorvetes as TS on TS.codigo_sorvete = CS.codigo_sorvete
inner join tb_setor as S on CS.codigo_setor = S.codigo_setor;

-- visualizando as tabelas
select * from tb_sorvetes;
select * from tb_clientes;
select * from compra_sorvete;



