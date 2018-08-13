package com.edm.order.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.edm.order.domain.Order;

public interface OrderRepository extends CrudRepository<Order, UUID> {

	// TODO List<Order> findByCustomerLastName(String lastName);
}
