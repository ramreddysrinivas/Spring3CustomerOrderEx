package com.spring.jdbc.service;

import java.util.List;

import com.spring.jdbc.domain.Customer;
import com.spring.jdbc.exception.InvalidInputException;

public interface ICustomerService {

	String saveCustomer(Customer customer) throws InvalidInputException;

	List<Customer> getCustomersByName(String cName) throws InvalidInputException;
	

}
