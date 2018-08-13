package com.edm.customer.service;

import java.time.LocalDate;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.edm.common.events.IntrinsicEventProducer;
import com.edm.common.events.customer.ClubProgram;
import com.edm.common.events.customer.ClubProgramAssigned;
import com.edm.common.events.customer.CustomerCreated;
import com.edm.common.events.customer.CustomerInfoModifyed;

@Named
public class CustomerCommandService {

	@Inject
	IntrinsicEventProducer eventProducer;

	public void createCustomer(String firstName, String lastName) {
		eventProducer.publish(new CustomerCreated(UUID.randomUUID(), firstName, lastName, LocalDate.now()));

	}

	public void modifyCustomer(UUID customerId, String firstName, String lastName) {
		eventProducer.publish(new CustomerInfoModifyed(customerId, firstName, lastName));
	}

	public void assignClubProgram(@NotNull UUID customerId, ClubProgram clubProgram) {
		eventProducer.publish(new ClubProgramAssigned(customerId, clubProgram));
	}

}
