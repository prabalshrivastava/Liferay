package com.sambaash.platform.model;

public enum RsvpAttendance {
	ATTENDING(0),NOT_ATTENDING(1);
	private int attendance;
	private RsvpAttendance(int attendance){
		this.attendance = attendance;
	}
	
	public String getValue(){
		switch(attendance){
			case 0 : return "Attending";
			case 1 : return "Not Attending";
		}
		return null;
	}
}
