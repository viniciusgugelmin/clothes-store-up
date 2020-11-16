package com.github.clothesstore.app;

import com.github.clothesstore.database.DB;

public class Programa {
	
	public static void main(String[] args) {
		
		Scenes.Address();
		Scenes.Genders();
		Scenes.Documents_types();
		Scenes.Users();
		Scenes.Address_users();
		Scenes.Payment_methods();
		Scenes.Payment_methods_data();
		Scenes.Users_payment_methods_data();
		
		DB.closeConnection();
	}
}