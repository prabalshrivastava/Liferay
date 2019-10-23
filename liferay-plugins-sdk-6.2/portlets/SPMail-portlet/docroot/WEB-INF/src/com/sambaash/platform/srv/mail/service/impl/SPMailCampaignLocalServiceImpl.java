/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv.mail.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.portlet.spmail.util.MailSchedularHelper;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailCampaignLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the s p mail campaign local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailCampaignLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailCampaignLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil
 */
public class SPMailCampaignLocalServiceImpl extends SPMailCampaignLocalServiceBaseImpl {
	public SPMailCampaign findByCampaignName(String campaignName)
			throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return spMailCampaignPersistence.findByCampaignName(campaignName);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil} to access the s p mail campaign local
	 * service.
	 */
	public SPMailCampaign findByrsvpId(long rsvpId) throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return spMailCampaignPersistence.findByrsvpId(rsvpId);
	}

	public List<SPMailCampaign> getActiveCampaigns(int start, int end) throws SystemException {
		return spMailCampaignPersistence.findByArchive(false, start, end);
	}

	public SPMailCampaign getCampaign(long campaignId) {
		SPMailCampaign spMailCampaign = null;

		try {
			spMailCampaign = spMailCampaignPersistence.fetchByPrimaryKey(campaignId);
		} catch (Exception e) {
		}

		return spMailCampaign;
	}

public void subscribeToCampaign(String email, String firstName,
			String lastName, long campaignId,String portalUrl) {
	
		try {
			_log.error("Subscription process started for " + email);
			SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil
					.fetchSPMailCampaign(campaignId);
			_log.error("campaign " + spMailCampaign);
			MailSchedularHelper.createCampaignSubscriber(email, firstName,
					lastName, spMailCampaign, spMailCampaign.getCreateBy());
			MailSchedularHelper.scheduleCampaignForSubscriber(spMailCampaign.getCompanyId(),spMailCampaign.getGroupId(),spMailCampaign.getCreateBy(),spMailCampaign, email,portalUrl);
		} catch (SystemException e) {
			_log.error(e);
		}
		catch (PortalException e) {
			_log.error(e);
		}

		// schedule all edms
	}

	private static final Log _log = LogFactoryUtil.getLog(SPMailCampaignLocalServiceImpl.class);
}
