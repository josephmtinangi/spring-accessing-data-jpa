package com.example.hello;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(Customer.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> index() {

		customerService.store(new Customer("John", "Doe"));
		customerService.store(new Customer("Jane", "Doe"));

		return customerService.get();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	public Customer show(@PathVariable Long id) {
		return customerService.find(id);
	}
}
