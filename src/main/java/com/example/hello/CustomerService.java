package com.example.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> get() {
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}

	public Customer find(Long id) {
		return customerRepository.findOne(id);
	}

	public void store(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> findByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

	public List<Customer> findByLastName(String lastName) {
		return customerRepository.findByLastName(lastName);
	}
}
