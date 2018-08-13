package com.edm.order.service;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.edm.common.events.customer.CustomerCreated;
import com.edm.common.events.customer.CustomerInfoModifyed;
import com.edm.common.events.order.OrderCreated;
import com.edm.order.domain.Customer;
import com.edm.order.domain.Order;
import com.edm.order.repo.CustomerRepository;
import com.edm.order.repo.OrderRepository;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

@Named
public class OrderEventListener {

	@Inject
	Logger logger;

	@Inject
	EventBus eventBus;

	@Inject
	OrderRepository orderRepository;

	@Inject
	CustomerRepository customerRepository;

	@PostConstruct
	public void init() {
		eventBus.register(this);
	}

	@Subscribe
	public void apply(CustomerCreated event) {
		customerRepository.save(new Customer(event.getCustomerId(), event.getFirstName(), event.getLastName()));
	}

	@Subscribe
	public void apply(CustomerInfoModifyed event) {
		Customer customer = customerRepository.findById(event.getCustomerId()).get();
		customer.setFirstName(event.getFirstName());
		customer.setLastName(event.getLastName());
		customerRepository.save(customer);
	}

	@Subscribe
	public void apply(OrderCreated event) {
		orderRepository.save(new Order(event.getOrderId(), customerRepository.findById(event.getCustomerId()).get(),
				event.getDescription(), event.getCreationDate()));
	}

}
