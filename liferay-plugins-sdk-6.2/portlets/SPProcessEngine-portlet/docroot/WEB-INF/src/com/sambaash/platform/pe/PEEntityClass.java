package com.sambaash.platform.pe;

public class PEEntityClass {
	public String getDisplayName() {
		return displayName;
	}

	public long getId() {
		return id;
	}

	public Class getUtilClass() {
		return utilClass;
	}

	public void setDisplayName(String displayname) {
		this.displayName = displayname;
	}

	public void setId(long id) {
		this.id = id;
	} public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUtilClass(Class utilClass) {
		this.utilClass = utilClass;
	}
	
	public String getServerCall() {
		return serverCall;
	}

	public String getApiUsed() {
		return apiUsed;
	}

	private String displayName;
	private long id;
	private String name;
	private Class utilClass;
	private String serverCall;
	private String apiUsed;
	
	public void setServerCall(String serverCall) {
		this.serverCall = serverCall;
		
	}

	public void setApiUsed(String apiUsed) {
		this.apiUsed = apiUsed;
		
	}

}
