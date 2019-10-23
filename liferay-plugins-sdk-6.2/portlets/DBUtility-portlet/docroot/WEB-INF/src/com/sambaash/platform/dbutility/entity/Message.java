package com.sambaash.platform.dbutility.entity;

public class Message {
	private String userid;
	private String data;

	public Message(String userid, String data) {
		this.userid = userid;
		this.data = data;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
