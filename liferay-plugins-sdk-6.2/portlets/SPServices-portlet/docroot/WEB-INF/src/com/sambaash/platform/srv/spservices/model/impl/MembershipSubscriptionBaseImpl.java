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

import com.sambaash.platform.srv.spservices.model.MembershipSubscription;
import com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalServiceUtil;

/**
 * The extended model base implementation for the MembershipSubscription service. Represents a row in the &quot;SPMembershipSubscription&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MembershipSubscriptionImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionImpl
 * @see com.sambaash.platform.srv.spservices.model.MembershipSubscription
 * @generated
 */
public abstract class MembershipSubscriptionBaseImpl
	extends MembershipSubscriptionModelImpl implements MembershipSubscription {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a membership subscription model instance should use the {@link MembershipSubscription} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipSubscriptionLocalServiceUtil.addMembershipSubscription(this);
		}
		else {
			MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(this);
		}
	}
}