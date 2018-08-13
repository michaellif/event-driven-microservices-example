package com.edm.order.service;

import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.edm.common.events.IntrinsicEventProducer;
import com.edm.common.events.order.OrderCreated;
import com.edm.common.events.order.OrderStatus;
import com.edm.common.events.order.OrderStatusModifyed;
import com.edm.order.repo.OrderRepository;

@Named
public class OrderCommandService {

	@Inject
	IntrinsicEventProducer eventProducer;

	@Inject
	OrderRepository orderRepository;

	public void createOrder(UUID customerId, String description) {
		eventProducer.publish(new OrderCreated(UUID.randomUUID(), customerId, description, new Date()));
	}

	public void setOrderStatus(@NotNull UUID orderId, OrderStatus newOrderStatus) {
		eventProducer.publish(new OrderStatusModifyed(UUID.randomUUID(), newOrderStatus,
				orderRepository.findById(orderId).get().getOrderStatus()));
	}

}
