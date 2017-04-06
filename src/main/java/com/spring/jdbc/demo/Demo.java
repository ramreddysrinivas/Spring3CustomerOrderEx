package com.spring.jdbc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.domain.Customer;
import com.spring.jdbc.exception.InvalidInputException;
import com.spring.jdbc.repository.CustomerRepository;
import com.spring.jdbc.repository.ICustomerRepository;
import com.spring.jdbc.service.CustomerService;

public class Demo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans.xml");

		CustomerService customerServiceobj = (CustomerService) context
				.getBean("customerService");
	   ICustomerRepository customerRepository =customerServiceobj.getCustomerRepository();
	   
	 Customer customer = demo.prepareCustomer(1234,"name2","ramreddy2@gmail.com");
	// demo.saveCustomer(customer,customerServiceobj);
		
		
		
		System.out.println("customerServiceobj = " + customerServiceobj);
		System.out.println("customerrepository = " + customerRepository);

		
	}

	private void saveCustomer(Customer customer,CustomerService customerServiceobj) {
		String message=null;
		try {
			message = customerServiceobj.saveCustomer(customer);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(message);
	}

	private Customer prepareCustomer(int cId, String cName,String cEmailId) {
		Customer customer=new Customer();
		customer.setcId(cId);
		customer.setcName(cName);
		customer.setcEmailId(cEmailId);
		return customer;
	}

}
