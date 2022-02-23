-- DB de Desenvolvimento (Docker)

-- Três comandos INSERT para a tb_product.
insert into db_magalu.tb_product (product_id, name, price) values (1 ,'mesa', 500.00);
insert into db_magalu.tb_product (product_id, name, price) values (2 ,'geladeira', 1000.00);
insert into db_magalu.tb_product (product_id, name, price) values (3 ,'tv', 2000.00);

-- Três comandos INSERT para a tb_category.
insert into db_magalu.tb_category (category_id , name) values (1, 'moveis');
insert into db_magalu.tb_category (category_id , name) values (2, 'eletrodomesticos');
insert into db_magalu.tb_category (category_id , name) values (3, 'eletronicos');

-- Três comandos INSERT para a tb_product_category, assim criando um relacionamento entre produtos e categorias.

-- Um comando SELECT na tb_product com o objetivo de carregar produtos com preços superiores a R$ 100,00.
select * from db_magalu.tb_product tp where price > 100;

-- Um comando UPDATE com o objetivo de atualizar o nome de um dos três produtos, realizando a busca pelo id.
update db_magalu.tb_product tp set name = 'geladeira duplex', price = '3000' where product_id = 2;

-- Um comando DELETE com o objetivo de apagar um dos três produtos, realizando a busca pelo id.
delete from db_magalu.tb_product where product_id in (3);

                                            ----||----

-- DB de Produção (Heroku)

-- Três comandos INSERT para a tb_product.
insert into heroku_eec9f4eb2c48665.tb_product (product_id, name, price) values (1 ,'mesa', 500.00);
insert into heroku_eec9f4eb2c48665.tb_product (product_id, name, price) values (2 ,'geladeira', 1000.00);
insert into heroku_eec9f4eb2c48665.tb_product (product_id, name, price) values (3 ,'tv', 2000.00);

-- Três comandos INSERT para a tb_category.
insert into heroku_eec9f4eb2c48665.tb_category (category_id , name) values (1, 'moveis');
insert into heroku_eec9f4eb2c48665.tb_category (category_id , name) values (2, 'eletrodomesticos');
insert into heroku_eec9f4eb2c48665.tb_category (category_id , name) values (3, 'eletronicos');

-- Três comandos INSERT para a tb_product_category, assim criando um relacionamento entre produtos e categorias.

-- Um comando SELECT na tb_product com o objetivo de carregar produtos com preços superiores a R$ 100,00.
select * from heroku_eec9f4eb2c48665.tb_product tp where price > 100;

-- Um comando UPDATE com o objetivo de atualizar o nome de um dos três produtos, realizando a busca pelo id.
update heroku_eec9f4eb2c48665.tb_product tp set name = 'geladeira duplex', price = '3000' where product_id = 2;

-- Um comando DELETE com o objetivo de apagar um dos três produtos, realizando a busca pelo id.
delete from heroku_eec9f4eb2c48665.tb_product where product_id in (3);