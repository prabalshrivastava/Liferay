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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.Validator;

import com.sambaash.platform.model.aws.Message;
import com.sambaash.platform.srv.mail.NoSuchBlackListException;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.model.SPMailBlackList;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailBlackListLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the s p mail black list local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailBlackListLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailBlackListLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil
 */
public class SPMailBlackListLocalServiceImpl extends SPMailBlackListLocalServiceBaseImpl {
	public void addBounce(String response, Message message) {

		try {
			SPMailBlackList spMailBlackList;

			try {
				spMailBlackList = spMailBlackListPersistence.findByEmailAddress(message.getBounce()
						.getBouncedRecipients().get(0).getEmailAddress());
			} catch (NoSuchBlackListException ne) {

				spMailBlackList = SPMailBlackListLocalServiceUtil.createSPMailBlackList(CounterLocalServiceUtil
						.increment("SPMailBlackList.class"));
			}

			SPMailCampaignSubscribers subscriber = null;

			try {
				subscriber = spMailCampaignSubscribersPersistence.findByMessageId(message.getMail().getMessageId());
			} catch (NoSuchCampaignSubscribersException ne) {
			}

			if (spMailBlackList != null) {
				SPMailCampaignSubscribers subscribers = null;

				try {
					subscribers = spMailCampaignSubscribersLocalService.findByMessageId(message.getMail()
							.getMessageId());
				} catch (Exception e) {
				}

				spMailBlackList.setEmailAddress(message.getBounce().getBouncedRecipients().get(0).getEmailAddress());

				if ("Permanent".equalsIgnoreCase(message.getBounce().getBounceType())) {
					spMailBlackList.setBounced(true);
				} else {
					spMailBlackList.setBounce_soft(true);
				}

				if (Validator.isNotNull(subscriber)) {
					spMailBlackList.setSpMailCampaignId(subscriber.getSpMailCampaignId());
					spMailBlackList.setUserId(subscriber.getUserId());
				}

				spMailBlackList.setMessage(response);
				spMailBlackList.setCreateDate(DateUtil.newDate());
				spMailBlackList.setMessageId(message.getMail().getMessageId());

				if (subscribers != null) {
					spMailBlackList.setUserId(subscribers.getUserId());
					spMailBlackList.setSpMailCampaignId(subscribers.getSpMailCampaignId());
				}

				spMailBlackListLocalService.updateSPMailBlackList(spMailBlackList);

			} else {
				_log.error("unable to create or find spMailBlackList : " + response);
			}
		} catch (Exception e) {
			_log.error(e);
			_log.error("Exception occured so displaying sns message : " + response);
		}
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil} to access the s p mail black list local
	 * service.
	 */

	public void addComplaint(String response, Message message) {

		try {
			SPMailBlackList spMailBlackList;

			try {
				spMailBlackList = spMailBlackListPersistence.findByEmailAddress(message.getComplaint()
						.getComplainedRecipients().get(0).getEmailAddress());
			} catch (NoSuchBlackListException ne) {
				spMailBlackList = spMailBlackListLocalService.createSPMailBlackList(CounterLocalServiceUtil
						.increment("SPMailBlackList.class"));
			}

			if (spMailBlackList != null) {
				SPMailCampaignSubscribers subscribers = null;
				try {
					subscribers = spMailCampaignSubscribersLocalService.findByMessageId(message.getMail()
							.getMessageId());
				} catch (Exception e) {
				}

				spMailBlackList.setEmailAddress(message.getComplaint().getComplainedRecipients().get(0)
						.getEmailAddress());
				spMailBlackList.setComplain(true);
				spMailBlackList.setMessage(response);
				spMailBlackList.setCreateDate(DateUtil.newDate());
				spMailBlackList.setMessageId(message.getMail().getMessageId());

				if (subscribers != null) {
					_log.error("Doesn't exist in subscriber table. Not part of campaign.");
					spMailBlackList.setUserId(subscribers.getUserId());
					spMailBlackList.setSpMailCampaignId(subscribers.getSpMailCampaignId());
				}

				spMailBlackListLocalService.updateSPMailBlackList(spMailBlackList);

			} else {
				_log.error("unable to create or find spMailBlackList : " + response);
			}
		} catch (Exception e) {
			_log.error("Exception occured so displaying sns message : " + response);
		}
	}

	public int countByCampaignIdAndBounced(long spMailCampaignId, boolean bounced) throws SystemException {
		return spMailBlackListPersistence.countByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

	public int countByCampaignIdAndBouncedSoft(long spMailCampaignId, boolean bounce_soft) throws SystemException {
		return spMailBlackListPersistence.countByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft);
	}

	public int countByCampaignIdAndComplain(long spMailCampaignId, boolean complain) throws SystemException {
		return spMailBlackListPersistence.countByCampaignIdAndComplain(spMailCampaignId, complain);
	}

	public List<SPMailBlackList> findByCampaignId(long spMailCampaignId) throws SystemException {
		return spMailBlackListPersistence.findByCampaignId(spMailCampaignId);
	}

	public List<SPMailBlackList> findByCampaignIdAndBounced(long spMailCampaignId, boolean bounced)
			throws SystemException {
		return spMailBlackListPersistence.findByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

	public List<SPMailBlackList> findByCampaignIdAndBouncedSoft(long spMailCampaignId, boolean bounce_soft)
			throws SystemException {
		return spMailBlackListPersistence.findByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft);
	}

	public List<SPMailBlackList> findByCampaignIdAndComplain(long spMailCampaignId, boolean complain)
			throws SystemException {
		return spMailBlackListPersistence.findByCampaignIdAndComplain(spMailCampaignId, complain);
	}

	public SPMailBlackList findByEmailAddress(String EmailAddress) throws NoSuchBlackListException, SystemException {
		return spMailBlackListPersistence.findByEmailAddress(EmailAddress);
	}

	private static Log _log = LogFactoryUtil.getLog(SPMailBlackListLocalServiceImpl.class);
}