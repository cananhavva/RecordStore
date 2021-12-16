package com.canan.main;

import com.canan.controller.CustomerController;
import com.canan.entity.CustomerEntity;

public class MainTest {
	
	public static void main(String[] args) {
		
		// Create
		for (long i = 0; i < 2; i++) {
			CustomerEntity CustomerEntity = new CustomerEntity("Canan" + (i + 1), "Arslan" + (i + 1), "12345" + (i + 1),
					null);
			CustomerController customerController1 = new CustomerController();
			customerController1.create(CustomerEntity);
		}
		
		//// find
		// CustomerController customerController2 = new CustomerController();
		// int id = 1;
		// customerController2.find(id);
		
		// // delete
		// CustomerController CustomerController3 = new CustomerController();
		// CustomerEntity CustomerEntity3 = new CustomerEntity();
		// CustomerEntity3.setId(2);
		// CustomerController3.delete(CustomerEntity3);
		
		// // update
		// CustomerEntity customerEntity4 = new CustomerEntity("canan", "arslan");
		// customerEntity4.setId(1);
		// CustomerController customerController4 = new CustomerController();
		// customerController4.update(customerEntity4);
		
		//// list
		// CustomerController customerController4 = new CustomerController();
		// for (CustomerEntity temp : customerController4.list()) {
		// System.out.println(temp);
		// }
		
	}
	
}
