/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringPool;

/**
 * The extended model implementation for the ApprovedMentors service. Represents a row in the &quot;ApprovedMentors&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.startupprofile.model.ApprovedMentors} interface.
 * </p>
 *
 * @author pradeep
 */
public class ApprovedMentorsImpl extends ApprovedMentorsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a approved mentors model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.ApprovedMentors} interface instead.
	 */
	String email;
	String firstName;
	String lastName;
	
	int titleId;
	String jobTitle;
	String mobile;
	
	

	public int getTitleId() {
		return titleId;
	}



	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ApprovedMentorsImpl() {
		this.email = StringPool.BLANK;
		this.firstName = StringPool.BLANK;
		this.lastName = StringPool.BLANK;
		
	}
	
	

	
}