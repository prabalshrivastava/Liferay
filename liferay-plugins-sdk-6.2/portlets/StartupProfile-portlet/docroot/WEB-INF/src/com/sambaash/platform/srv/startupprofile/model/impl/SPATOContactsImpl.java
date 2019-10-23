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
 * The extended model implementation for the SPATOContacts service. Represents a row in the &quot;SPATOContacts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.startupprofile.model.SPATOContacts} interface.
 * </p>
 *
 * @author pradeep
 */
public class SPATOContactsImpl extends SPATOContactsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a s p a t o contacts model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.SPATOContacts} interface instead.
	 */
	String PrimaryPrincipalUserEmail;
	String PrimaryPrincipalUserFirstName;
	String PrimaryPrincipalUserLastName;
	String SecondaryPrincipalUserEmail;
	String SecondaryPrincipalUserFirstName;
	String SecondaryPrincipalUserLastName;
	
	
	int primaryTitleId;
	String primaryJobTitle;
	String primaryMobile;
	
	int secondaryTitleId;
	String secondaryJobTitle;
	String secondaryMobile;



	public int getPrimaryTitleId() {
		return primaryTitleId;
	}



	public void setPrimaryTitleId(int primaryTitleId) {
		this.primaryTitleId = primaryTitleId;
	}



	public String getPrimaryJobTitle() {
		return primaryJobTitle;
	}



	public void setPrimaryJobTitle(String primaryJobTitle) {
		this.primaryJobTitle = primaryJobTitle;
	}



	public String getPrimaryMobile() {
		return primaryMobile;
	}



	public void setPrimaryMobile(String primaryMobile) {
		this.primaryMobile = primaryMobile;
	}



	public int getSecondaryTitleId() {
		return secondaryTitleId;
	}



	public void setSecondaryTitleId(int secondaryTitleId) {
		this.secondaryTitleId = secondaryTitleId;
	}



	public String getSecondaryJobTitle() {
		return secondaryJobTitle;
	}



	public void setSecondaryJobTitle(String secondaryJobTitle) {
		this.secondaryJobTitle = secondaryJobTitle;
	}



	public String getSecondaryMobile() {
		return secondaryMobile;
	}



	public void setSecondaryMobile(String secondaryMobile) {
		this.secondaryMobile = secondaryMobile;
	}



	public String getPrimaryPrincipalUserEmail() {
		return PrimaryPrincipalUserEmail;
	}



	public void setPrimaryPrincipalUserEmail(String primaryPrincipalUserEmail) {
		PrimaryPrincipalUserEmail = primaryPrincipalUserEmail;
	}



	public String getPrimaryPrincipalUserFirstName() {
		return PrimaryPrincipalUserFirstName;
	}



	public void setPrimaryPrincipalUserFirstName(String primaryPrincipalUserFirstName) {
		PrimaryPrincipalUserFirstName = primaryPrincipalUserFirstName;
	}



	public String getPrimaryPrincipalUserLastName() {
		return PrimaryPrincipalUserLastName;
	}



	public void setPrimaryPrincipalUserLastName(String primaryPrincipalUserLastName) {
		PrimaryPrincipalUserLastName = primaryPrincipalUserLastName;
	}



	public String getSecondaryPrincipalUserEmail() {
		return SecondaryPrincipalUserEmail;
	}



	public void setSecondaryPrincipalUserEmail(String secondaryPrincipalUserEmail) {
		SecondaryPrincipalUserEmail = secondaryPrincipalUserEmail;
	}



	public String getSecondaryPrincipalUserFirstName() {
		return SecondaryPrincipalUserFirstName;
	}



	public void setSecondaryPrincipalUserFirstName(String secondaryPrincipalUserFirstName) {
		SecondaryPrincipalUserFirstName = secondaryPrincipalUserFirstName;
	}



	public String getSecondaryPrincipalUserLastName() {
		return SecondaryPrincipalUserLastName;
	}



	public void setSecondaryPrincipalUserLastName(String secondaryPrincipalUserLastName) {
		SecondaryPrincipalUserLastName = secondaryPrincipalUserLastName;
	}



	public SPATOContactsImpl() {
		PrimaryPrincipalUserEmail = StringPool.BLANK;
		PrimaryPrincipalUserFirstName =  StringPool.BLANK;
		PrimaryPrincipalUserLastName = StringPool.BLANK;
		SecondaryPrincipalUserEmail =  StringPool.BLANK;
		SecondaryPrincipalUserFirstName =  StringPool.BLANK;
		SecondaryPrincipalUserLastName =  StringPool.BLANK;		
	}
}