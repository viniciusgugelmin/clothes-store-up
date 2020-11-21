use `clothes_store`;

alter table `users` drop constraint fk_users_genders, drop constraint fk_users_documents_types;
alter table `address_users` drop constraint fk_address_users_users, drop constraint fk_address_users_address;
alter table `payment_methods_data` drop constraint fk_payment_methods_data_payment_methods;
alter table `users_payment_methods_data` drop constraint fk_users_payment_methods_data_payment_methods_data, drop constraint fk_users_payment_methods_data_users;
alter table `products_types` drop constraint fk_products_types_genders;
alter table `products` drop constraint fk_products_products_types;
alter table `sales` drop constraint fk_sales_products;
alter table `sales` drop constraint fk_sales_users_payment_methods_data;