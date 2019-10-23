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

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.startupprofile.model.Person;
import com.sambaash.platform.srv.startupprofile.service.PersonLocalServiceUtil;

/**
 * The extended model base implementation for the Person service. Represents a row in the &quot;SPPerson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersonImpl}.
 * </p>
 *
 * @author pradeep
 * @see PersonImpl
 * @see com.sambaash.platform.srv.startupprofile.model.Person
 * @generated
 */
public abstract class PersonBaseImpl extends PersonModelImpl implements Person {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a person model instance should use the {@link Person} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PersonLocalServiceUtil.addPerson(this);
		}
		else {
			PersonLocalServiceUtil.updatePerson(this);
		}
	}
}