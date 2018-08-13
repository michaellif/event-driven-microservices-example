package com.edm.customer.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.edm.common.events.customer.ClubProgram;

@Entity
public class Customer {

	@Id
	private UUID customerId;

	private String firstName;

	private String lastName;

	private LocalDate fromDate;

	private ClubProgram clubProgram;

	public Customer() {
	}

	public Customer(UUID customerId, String firstName, String lastName, LocalDate fromDate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fromDate = fromDate;
		this.clubProgram = ClubProgram.GOLD;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public ClubProgram getClubProgram() {
		return clubProgram;
	}

	public void setClubProgram(ClubProgram clubProgram) {
		this.clubProgram = clubProgram;
	}

	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName();
	}
}
