create table pessoas (
id varchar(255) not null,
nome varchar(255) not null,
email varchar(255) not null,
cpf char(11) not null primary key,
idade integer not null,
cargo varchar(55),
salario decimal,
bonus_cargo decimal
);

create table produtos(
id varchar(255) not null,
nome varchar(255) not null primary key,
quantidade integer not null,
valor decimal not null, 
categoria varchar(55)
);

create table pedidos(
id varchar(255) not null primary key,
pessoa_cpf varchar(255) not null references pessoas(cpf),
descricao varchar(255),
valor_total decimal not null
);

create table pedido_produtos (
id varchar(255) not null primary key,
pedido_id varchar(255) not null references pedidos(id),
produto_nome varchar(255) not null references produtos(nome),
quantidade_produto integer not null,
valor_produto decimal not null
);