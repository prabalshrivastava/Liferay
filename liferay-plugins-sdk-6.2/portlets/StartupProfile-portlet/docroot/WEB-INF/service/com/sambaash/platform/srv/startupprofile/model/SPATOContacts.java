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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the SPATOContacts service. Represents a row in the &quot;SPATOContacts&quot; database table, with each column mapped to a property of this class.
 *
 * @author pradeep
 * @see SPATOContactsModel
 * @see com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl
 * @generated
 */
public interface SPATOContacts extends SPATOContactsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public int getPrimaryTitleId();

	public void setPrimaryTitleId(int primaryTitleId);

	public java.lang.String getPrimaryJobTitle();

	public void setPrimaryJobTitle(java.lang.String primaryJobTitle);

	public java.lang.String getPrimaryMobile();

	public void setPrimaryMobile(java.lang.String primaryMobile);

	public int getSecondaryTitleId();

	public void setSecondaryTitleId(int secondaryTitleId);

	public java.lang.String getSecondaryJobTitle();

	public void setSecondaryJobTitle(java.lang.String secondaryJobTitle);

	public java.lang.String getSecondaryMobile();

	public void setSecondaryMobile(java.lang.String secondaryMobile);

	public java.lang.String getPrimaryPrincipalUserEmail();

	public void setPrimaryPrincipalUserEmail(
		java.lang.String primaryPrincipalUserEmail);

	public java.lang.String getPrimaryPrincipalUserFirstName();

	public void setPrimaryPrincipalUserFirstName(
		java.lang.String primaryPrincipalUserFirstName);

	public java.lang.String getPrimaryPrincipalUserLastName();

	public void setPrimaryPrincipalUserLastName(
		java.lang.String primaryPrincipalUserLastName);

	public java.lang.String getSecondaryPrincipalUserEmail();

	public void setSecondaryPrincipalUserEmail(
		java.lang.String secondaryPrincipalUserEmail);

	public java.lang.String getSecondaryPrincipalUserFirstName();

	public void setSecondaryPrincipalUserFirstName(
		java.lang.String secondaryPrincipalUserFirstName);

	public java.lang.String getSecondaryPrincipalUserLastName();

	public void setSecondaryPrincipalUserLastName(
		java.lang.String secondaryPrincipalUserLastName);
}