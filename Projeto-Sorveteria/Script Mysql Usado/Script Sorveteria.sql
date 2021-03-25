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
create table tb_setor(
	codigo_setor int primary key auto_increment,
    nome_setor varchar(30)
);


-- criando tabela para cadastro de clientes
create table tb_clientes(
	codigo_cliente int primary key auto_increment,
    nome_cliente varchar(50) not null,
    matricula int
);


-- criando tabela que sera feito o cadastro dos sorvetes
create table tb_sorvetes(
	codigo_sorvete int primary key auto_increment,
	descricao varchar(30) not null,
    preco decimal(10,2)
);


-- criando tabela onde sera feita a compra do sorvete
create table compra_sorvete (
	codigo_compra int primary key auto_increment,
	quantidade_sorvetes int not null,
    data_compra timestamp default current_timestamp,
    codigo_cliente int not null,
    codigo_sorvete int not null,
    codigo_setor int not null,
    foreign key(codigo_cliente) references tb_clientes(codigo_cliente),
    foreign key(codigo_sorvete) references tb_sorvetes(codigo_sorvete),
    foreign key(codigo_setor) references tb_setor(codigo_setor)
);

desc tb_setor;
desc tb_clientes;
desc tb_sorvetes;
desc compra_sorvete;


insert into tb_setor(nome_setor) values('TI');
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
select * from tb_setor;
select * from tb_sorvetes;
select * from tb_clientes;
select * from compra_sorvete;



