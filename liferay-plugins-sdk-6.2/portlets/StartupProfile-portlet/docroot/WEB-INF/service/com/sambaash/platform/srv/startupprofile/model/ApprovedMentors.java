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
 * The extended model interface for the ApprovedMentors service. Represents a row in the &quot;SPMentors&quot; database table, with each column mapped to a property of this class.
 *
 * @author pradeep
 * @see ApprovedMentorsModel
 * @see com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl
 * @generated
 */
public interface ApprovedMentors extends ApprovedMentorsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public int getTitleId();

	public void setTitleId(int titleId);

	public java.lang.String getJobTitle();

	public void setJobTitle(java.lang.String jobTitle);

	public java.lang.String getMobile();

	public void setMobile(java.lang.String mobile);

	public java.lang.String getEmail();

	public void setEmail(java.lang.String email);

	public java.lang.String getFirstName();

	public void setFirstName(java.lang.String firstName);

	public java.lang.String getLastName();

	public void setLastName(java.lang.String lastName);
}