package com.edm.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.edm.order.domain.Order;
import com.edm.order.repo.OrderRepository;

@Named
public class OrderQueryService {

	@Inject
	OrderRepository orderRepository;

	public Order getOrder(@NotNull UUID orderId) {
		return orderRepository.findById(orderId).get();
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

}
