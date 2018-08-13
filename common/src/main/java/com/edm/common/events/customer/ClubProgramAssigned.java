package com.edm.common.events.customer;

import java.util.UUID;

import com.edm.common.events.Event;

public class ClubProgramAssigned extends Event {

	private UUID customerId;

	private ClubProgram clubProgram;

	public ClubProgramAssigned() {
	}

	public ClubProgramAssigned(UUID customerId, ClubProgram clubProgram) {
		this.customerId = customerId;
		this.clubProgram = clubProgram;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public ClubProgram getClubProgram() {
		return clubProgram;
	}

	public void setClubProgram(ClubProgram clubProgram) {
		this.clubProgram = clubProgram;
	}
}
