package com.spring.jdbc.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.domain.Customer;
import com.spring.jdbc.exception.InvalidInputException;
import com.spring.jdbc.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;

	public ICustomerRepository getCustomerRepository() {
		return customerRepository;
	}
	
	@Override
	public String saveCustomer(Customer customer) throws InvalidInputException {
		String message=null;
		if(customer !=null && (customer.getcId()>0) && StringUtils.isNotBlank(customer.getcName() ) &&  StringUtils.isNotBlank(customer.getcEmailId())){
			 message	= customerRepository.saveCustomer(customer);
		}else{
			throw new InvalidInputException("Invalid Customer Details  "+customer);
		}
		return message;
	}
	
}
