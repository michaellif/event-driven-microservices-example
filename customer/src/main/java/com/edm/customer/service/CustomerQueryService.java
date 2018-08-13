package com.edm.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.edm.customer.domain.Customer;
import com.edm.customer.repo.CustomerRepository;

@Named
public class CustomerQueryService {

	@Inject
	CustomerRepository customerRepository;

	public Customer getCustomer(@NotNull UUID customerId) {
		return customerRepository.findById(customerId).get();
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}

}
