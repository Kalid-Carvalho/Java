-- documentação
-- criando o banco de dados dbinfox
create database dbinfox;

-- ativando o banco de dados para poder ser usado
use dbinfox;

-- criando tabela de usuarios para ser autenticada na aplicação
create table tbusuarios (
	id_user int primary key,
    usuario varchar(50) not null,
    fone varchar(15), 
    login varchar(15) not null unique,
    senha varchar(15) not null
);
-- inserindo valores para testar funcionamento
insert into tbusuarios(id_user,usuario,fone,login,senha) values(1,'Kalid','92 99192-3266', 'kcsilva','Masa2021');
insert into tbusuarios(id_user,usuario,fone,login,senha) values(2,'Administrador','99999-9999', 'admin','admin');
insert into tbusuarios(id_user,usuario,fone,login,senha) values(3,'Bil Gates','99999-9999', 'bill','123456');
-- retornando tuplas
select * from tbusuarios;
-- creando mais uma tabelas agora para registrar clientes
create table tbclientes(
	id_clientes int primary key auto_increment,
    nome_cliente varchar(50) not null,
    endereco_cliente varchar(100),
    fone_cliente varchar(15) not null,
    email_cliente varchar(50) 
);

-- criando tabela para registrar os(ordem de serviço) da aplicação
create table tbos(
	os int primary key auto_increment,
    data_os timestamp default current_timestamp,
    equipamento varchar(150) not null,
    defeito varchar(150) not null,
    servico varchar(150),
    tecnico varchar(30),
    valor decimal(10,2),
    id_clientes int not null,
    foreign key(id_clientes) references tbclientes(id_clientes)
);


