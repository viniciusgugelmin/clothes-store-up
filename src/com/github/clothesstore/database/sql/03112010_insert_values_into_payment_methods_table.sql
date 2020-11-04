use clothes_store;

delete from `payment_methods`;
alter table `payment_methods` AUTO_INCREMENT = 1;
insert into `payment_methods`(`type`) values
	('BANK_SLIP'),
    ('CREDIT_CARD');