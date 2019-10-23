package com.sambaash.platform.portlet.spmp.bean;

import java.io.Serializable;
public class MembershipPackageRole implements Serializable
{

	public String getName() {
		return name;
	}

	public long getPrimaryKey() {
		return primaryKey;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrimaryKey(long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	private static final long serialVersionUID = 1L;

	private String name;
	private long primaryKey;
	private long roleId;

}