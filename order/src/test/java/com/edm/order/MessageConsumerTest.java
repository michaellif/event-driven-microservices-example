package com.edm.order;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edm.common.events.ExtrinsicEventConsumer;
import com.edm.common.events.IntrinsicEventConsumer;
import com.edm.common.events.IntrinsicEventProducer;
import com.edm.common.events.customer.CustomerCreated;
import com.edm.common.events.order.OrderCreated;
import com.edm.order.domain.Order;
import com.google.common.eventbus.EventBus;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageConsumerTest {

	@MockBean
	IntrinsicEventConsumer intrinsicEventConsumer;

	@MockBean
	IntrinsicEventProducer intrinsicEventProducer;

	@MockBean
	ExtrinsicEventConsumer extrinsicEventProducer;

	@Inject
	EventBus eventBus;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() {
		eventBus.post(new CustomerCreated(UUID.fromString("e4d284f0-2545-4368-ae80-8278c33edf16"), "John", "Doe",
				LocalDate.now()));
		eventBus.post(new CustomerCreated(UUID.fromString("e4d284f0-2545-4368-ae80-8278c33edf17"), "Jane", "Roe",
				LocalDate.now()));
		eventBus.post(new OrderCreated(UUID.fromString("e4d284f0-2545-4368-ae80-8278c33edf18"),
				UUID.fromString("e4d284f0-2545-4368-ae80-8278c33edf17"), "Item A", new Date()));
	}

	@Test
	public void testOne() throws Exception {
		ResponseEntity<List<Order>> response = restTemplate.exchange(
				"/customer/e4d284f0-2545-4368-ae80-8278c33edf16/order/list", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Order>>() {
				});
		List<Order> body = response.getBody();
		assertEquals("e4d284f0-2545-4368-ae80-8278c33edf18", body.get(0).getOrderId().toString());
	}

	@Test
	public void testTwo() throws Exception {

	}
}
