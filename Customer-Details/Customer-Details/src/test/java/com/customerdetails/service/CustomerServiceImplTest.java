package com.customerdetails.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.customerdetails.models.Customer;

class CustomerServiceImplTest {

	CustomerServiceImpl customerServiceImplMock = mock(CustomerServiceImpl.class);

	@Test
	@DisplayName("Find customer by Name")
	void findByName() {
		Customer customer = new Customer(1, "a", "pass", "address", "suv", "email", "CUSTOMER");
		when(customerServiceImplMock.findByName("customer")).thenReturn(customer);
	}
	
	@Test
	@DisplayName("Add customer")
	void addCustomer() {
		Customer customer = new Customer(1, "a", "pass", "address", "suv", "email", "CUSTOMER");
		when(customerServiceImplMock.addNewCustomer(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImplMock.addNewCustomer(customer));
	
	}

	@Test
	void updateProfile() {
		Customer customer = new Customer(1, "a", "pass", "address", "suv", "email", "CUSTOMER");
		when(customerServiceImplMock.updateProfile(customer, 1)).thenReturn(customer);
		assertEquals(customer, customerServiceImplMock.updateProfile(customer, 1));
		
	}
}
