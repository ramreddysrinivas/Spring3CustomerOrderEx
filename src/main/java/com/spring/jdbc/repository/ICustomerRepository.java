package com.spring.jdbc.repository;

import java.util.List;

import com.spring.jdbc.domain.Customer;

public interface ICustomerRepository {

 String saveCustomer(Customer customer);


List<Customer> getCustomersByName(String cName);


String updateCustomerBycId(Customer customer);





}
