package com.edm.order.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edm.common.events.order.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	private UUID orderId;

	@ManyToOne(optional = false)
	private Customer customer;

	private String description;

	private Date creationDate;

	private OrderStatus orderStatus;

	public Order() {
	}

	public Order(UUID orderId, Customer customer, String description, Date creationDate) {
		this.orderId = orderId;
		this.customer = customer;
		this.description = description;
		this.creationDate = creationDate;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return getCustomer() + " - " + getDescription();
	}
}
