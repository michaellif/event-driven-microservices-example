package com.edm.common.events;

import com.edm.common.events.customer.ClubProgramAssigned;
import com.edm.common.events.customer.CustomerCreated;
import com.edm.common.events.customer.CustomerInfoModifyed;
import com.edm.common.events.order.OrderCreated;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = CustomerCreated.class, name = "CustomerCreated"),
		@JsonSubTypes.Type(value = CustomerInfoModifyed.class, name = "CustomerInfoModifyed"),
		@JsonSubTypes.Type(value = ClubProgramAssigned.class, name = "ClubProgramAssigned"),
		@JsonSubTypes.Type(value = OrderCreated.class, name = "OrderCreated") })
public abstract class Event {

}
