package com.sambaash.platform.model;

public enum RsvpStatus{
	WAITING(0),ATTENDING(1), NOT_ATTENDING(2), MAYBE_ATTENDING(3);

	private int value;

	private RsvpStatus(int value) {
	this.value = value;
	}
	
	
	public String getValue() {
		
		switch(value){
			case 0 : return "Waiting";
			case 1 : return "Attending";
			case 2 : return "Not Attending";
			case 3 : return "MayBe Attending";
			
		}
		return null;
	}
	
}
