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

package com.sambaash.platform.srv.mail.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPMail. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author gauravvijayvergia
 * @see SPMailLocalServiceUtil
 * @see com.sambaash.platform.srv.mail.service.base.SPMailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPMailLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailLocalServiceUtil} to access the s p mail local service. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.lang.String appendTracker(java.lang.String content);

	public java.lang.String decryptLink(java.lang.String link);

	public java.lang.String encryptLink(java.lang.String link);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String[] getLinksFromHtml(java.lang.String content);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getMailBody(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getMailSubject(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getProcessedContent(java.lang.String content,
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		long subscriberId, long edmId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getWebversion(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber);

	public java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress);

	public java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress,
		boolean webVersion);

	public java.lang.String sendMail(
		com.sambaash.platform.model.MailMessage mailMessage);

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil} to
	* access the s p mail local service.
	*/
	public java.lang.String sendMail(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.util.List<com.liferay.mail.model.FileAttachment> attachments,
		long scopeGroupId, boolean ccEmail);

	public void testTemplate(long templateId);
}