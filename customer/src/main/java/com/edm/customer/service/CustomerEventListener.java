package com.edm.customer.service;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.edm.common.events.customer.CustomerCreated;
import com.edm.common.events.customer.CustomerInfoModifyed;
import com.edm.customer.domain.Customer;
import com.edm.customer.repo.CustomerRepository;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

@Named
public class CustomerEventListener {

	@Inject
	Logger logger;

	@Inject
	EventBus eventBus;

	@Inject
	CustomerRepository customerRepository;

	@PostConstruct
	public void init() {
		eventBus.register(this);
	}

	@Subscribe
	public void apply(CustomerCreated event) {
		customerRepository.save(
				new Customer(event.getCustomerId(), event.getFirstName(), event.getLastName(), event.getFromDate()));
	}

	@Subscribe
	public void apply(CustomerInfoModifyed event) {
		Customer customer = customerRepository.findById(event.getCustomerId()).get();
		customer.setFirstName(event.getFirstName());
		customer.setLastName(event.getLastName());
		customerRepository.save(customer);
	}

}
