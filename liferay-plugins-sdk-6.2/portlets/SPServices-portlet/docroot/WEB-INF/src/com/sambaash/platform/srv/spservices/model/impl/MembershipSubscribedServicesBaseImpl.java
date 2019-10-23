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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices;
import com.sambaash.platform.srv.spservices.service.MembershipSubscribedServicesLocalServiceUtil;

/**
 * The extended model base implementation for the MembershipSubscribedServices service. Represents a row in the &quot;SPMembershipSubscribedServices&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MembershipSubscribedServicesImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServicesImpl
 * @see com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices
 * @generated
 */
public abstract class MembershipSubscribedServicesBaseImpl
	extends MembershipSubscribedServicesModelImpl
	implements MembershipSubscribedServices {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a membership subscribed services model instance should use the {@link MembershipSubscribedServices} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipSubscribedServicesLocalServiceUtil.addMembershipSubscribedServices(this);
		}
		else {
			MembershipSubscribedServicesLocalServiceUtil.updateMembershipSubscribedServices(this);
		}
	}
}