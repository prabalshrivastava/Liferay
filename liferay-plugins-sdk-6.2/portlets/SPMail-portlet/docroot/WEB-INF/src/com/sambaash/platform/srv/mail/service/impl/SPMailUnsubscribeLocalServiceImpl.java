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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;

import com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.SPMailUnsubscribe;
import com.sambaash.platform.srv.mail.service.base.SPMailUnsubscribeLocalServiceBaseImpl;

/**
 * The implementation of the s p mail unsubscribe local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailUnsubscribeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil
 */
public class SPMailUnsubscribeLocalServiceImpl extends SPMailUnsubscribeLocalServiceBaseImpl {
	public SPMailUnsubscribe findByEmailAddress(String emailAddress) {
		try {
			return spMailUnsubscribePersistence.findByEmailAddress(emailAddress);
		} catch (NoSuchUnsubscribeException e) {
			_log.error("User not yet unsubscribed.");
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public SPMailUnsubscribe findByEmailAddressAndCategoryId(String emailAddress, long categoryId)
			throws NoSuchUnsubscribeException, SystemException {
		return spMailUnsubscribePersistence.findByEmailAddressAndCategoryId(emailAddress, categoryId);
	}

	public SPMailUnsubscribe findByUserId(long userId) {
		try {
			return spMailUnsubscribePersistence.findByUserId(userId);
		} catch (NoSuchUnsubscribeException e) {
			_log.error("User not yet unsubscribed.");
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil} to access the s p mail unsubscribe
	 * local service.
	 */

	public void unsubscribe(SPMailCampaignSubscribers subscriber, SPMailCampaign campaign) {
		try {
			SPMailUnsubscribe unsubscribe = null;
			long spMailUnsubscribeId = counterLocalService.increment("SPMailUnsubscribe.class");
			try {
				unsubscribe = findByEmailAddressAndCategoryId(subscriber.getEmailAddress(), campaign.getCategoryId());
			} catch (NoSuchUnsubscribeException e) {
				unsubscribe = spMailUnsubscribeLocalService.createSPMailUnsubscribe(spMailUnsubscribeId);
				unsubscribe.setEmailAddress(subscriber.getEmailAddress());
				unsubscribe.setUserId(subscriber.getUserId());
				unsubscribe.setUnsubscribeDate(DateUtil.newDate());
				unsubscribe.setCategoryId(campaign.getCategoryId());
				spMailUnsubscribeLocalService.updateSPMailUnsubscribe(unsubscribe);
			}
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPMailUnsubscribeLocalServiceImpl.class);

}