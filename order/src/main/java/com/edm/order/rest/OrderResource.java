package com.edm.order.rest;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.edm.common.events.order.OrderStatus;
import com.edm.order.domain.Order;
import com.edm.order.service.OrderCommandService;
import com.edm.order.service.OrderQueryService;

@Component
@Path("/customer")
public class OrderResource {

	@Inject
	private OrderQueryService queryService;

	@Inject
	private OrderCommandService commandService;

	@GET
	@Path("/{customerId}/order/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllOrders() {
		return queryService.getAllOrders();
	}

	@GET
	@Path("/{customerId}/order/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("orderId") @NotNull UUID orderId) {
		return queryService.getOrder(orderId);
	}

	@POST
	@Path("/{customerId}/order")
	public void createOrder(@PathParam("customerId") @NotNull UUID customerId,
			@QueryParam("description") String description) {
		commandService.createOrder(customerId, description);
	}

	@PUT
	@Path("/{customerId}/order/{orderId}/status")
	public void setOrderStatus(@PathParam("orderId") @NotNull UUID orderId,
			@QueryParam("status") OrderStatus orderStatus) {
		commandService.setOrderStatus(orderId, orderStatus);
	}

}
