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

package com.sambaash.platform.srv.mail.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;

/**
 * The extended model base implementation for the SPMailCampaignSubscribers service. Represents a row in the &quot;SPMailCampaignSubscribers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SPMailCampaignSubscribersImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribersImpl
 * @see com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers
 * @generated
 */
public abstract class SPMailCampaignSubscribersBaseImpl
	extends SPMailCampaignSubscribersModelImpl
	implements SPMailCampaignSubscribers {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s p mail campaign subscribers model instance should use the {@link SPMailCampaignSubscribers} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailCampaignSubscribersLocalServiceUtil.addSPMailCampaignSubscribers(this);
		}
		else {
			SPMailCampaignSubscribersLocalServiceUtil.updateSPMailCampaignSubscribers(this);
		}
	}
}