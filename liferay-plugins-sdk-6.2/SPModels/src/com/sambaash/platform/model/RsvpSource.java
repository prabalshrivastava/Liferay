package com.sambaash.platform.model;

public enum RsvpSource {
	BYINVITATION(1), BYMEMBER(2), BYADMINI(3);
	
	private int source;
	
	private  RsvpSource(int source){
		this.source = source;
	}
	public String getValue(){
		switch(source){
			case 1 : return "Registration by Invitation";
			case 2 : return "Registration by Member";
			case 3 : return "Registration by Administrator";
		}
		return null;
	}
	
	public int getSource() {
		return source;
	}
}
