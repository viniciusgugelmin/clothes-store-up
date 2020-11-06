use clothes_store;

delete from `documents_types`;
alter table `documents_types` AUTO_INCREMENT = 1;
insert into `documents_types`(`type`) values
	('CPF'),
    ('CNPJ');

select * from documents_types;