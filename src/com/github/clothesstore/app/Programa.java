package com.github.clothesstore.app;

import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBMigration;

public class Programa {
	
	public static void main(String[] args) {
		
		DBMigration.migrate("01112020_alter_tables_constraints", 2);
		DBMigration.migrate("02112020_create_database_and_tables", 4);

		Scenes.Address();
		Scenes.Genders();
		Scenes.Documents_types();
		Scenes.Users();
		Scenes.Address_users();
		Scenes.Payment_methods();
		Scenes.Payment_methods_data();
		Scenes.Users_payment_methods_data();
		Scenes.Products_types();
		Scenes.Products();

		DB.closeConnection();
	}
}