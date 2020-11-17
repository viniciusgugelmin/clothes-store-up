drop database if exists `clothes_store`;
create database `clothes_store`;
use `clothes_store`;

drop table if exists `address`;
create table `address` (
	`id` int auto_increment not null,
    `street` varchar(100) not null,
    `district` varchar(100) not null,
    `number` int unsigned not null,
    `note` varchar(100),
    primary key(`id`)
);

drop table if exists `genders`;
create table `genders` (
	`gender` char(1) not null,
    primary key(`gender`)
);

drop table if exists `documents_types`;
create table `documents_types` (
	`id` int auto_increment not null,
    `type` varchar(50) not null,
    primary key(`id`)
);

drop table if exists `users`;
create table `users` (
	`document` varchar(14) not null,
    `document_id` int not null,
    `name` varchar(254) not null,
	`email` varchar(254) not null,
    `ddi` varchar(4) not null,
    `ddd` char(2) not null,
    `phone` varchar(20) not null,
    `password` varchar(100) not null,
    `gender` char(1) not null,
    primary key(`document`),
    foreign key(`gender`) references `genders`(`gender`),
    foreign key(`document_id`) references `documents_types`(`id`)
);

drop table if exists `address_users`;
create table `address_users` (
	`id_address` int not null,
    `document_user` varchar(14) not null,
    primary key(`id_address`, `document_user`),
    foreign key(`document_user`) references `users`(`document`),
    foreign key(`id_address`) references `address`(`id`)
);

drop table if exists `payment_methods`;
create table `payment_methods` (
	`id` int auto_increment not null,
    `type` varchar(50) not null,
    primary key(`id`)
);

drop table if exists `payment_methods_data`;
create table `payment_methods_data` (
	`id` int not null,
    `payment_method_type` int not null,
    `card_number` varchar(19),
    `expiry_date` char(7),
    `cvc` char(3),
    primary key(`id`),
    foreign key(`payment_method_type`) references `payment_methods`(`id`)
);

drop table if exists `users_payment_methods_data`;
create table `users_payment_methods_data` (
	`id` int auto_increment not null,
	`payment_method_data_id` int not null,
    `user_document` varchar(14) not null,
    primary key(`id`, `payment_method_data_id`, `user_document`),
    foreign key(`payment_method_data_id`) references `payment_methods_data`(`id`),
    foreign key(`user_document`) references `users`(`document`)
);
    
drop table if exists `products_types`;
create table `products_types` (
	`id` int auto_increment not null,
    `type` varchar(50) not null,
    `gender` char(1) not null,
    `size` char(3) not null,
    primary key(`id`, `type`, `gender`, `size`),
    foreign key(`gender`) references `genders`(`gender`)
);

drop table if exists `products`;
create table `products` (
	`id` int auto_increment not null,
    `type_id` int not null,
    `name` varchar(100) not null,
    `brand` varchar(100) not null,
    `price` numeric(5,2) unsigned not null,
    `discount` float unsigned,
    `quantity_stock` int unsigned not null, 
    primary key(`id`),
    foreign key(`type_id`) references `products_types`(`id`)
);

drop table if exists `sales`;
create table `sales` (
	`product_id` int not null,
    `buyer_id` int not null,
    `created_at` datetime not null,
    foreign key(`buyer_id`) references `users_payment_methods_data`(`id`)
);

delete from `documents_types`;
alter table `documents_types` AUTO_INCREMENT = 1;
insert into `documents_types`(`type`) values
	('CPF'),
    ('CNPJ');

select * from `documents_types`;

delete from `payment_methods`;
alter table `payment_methods` AUTO_INCREMENT = 1;
insert into `payment_methods`(`type`) values
	('BANK_SLIP'),
    ('CREDIT_CARD');

select * from `payment_methods`;