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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPMailLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailLocalService
 * @generated
 */
public class SPMailLocalServiceWrapper implements SPMailLocalService,
	ServiceWrapper<SPMailLocalService> {
	public SPMailLocalServiceWrapper(SPMailLocalService spMailLocalService) {
		_spMailLocalService = spMailLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String appendTracker(java.lang.String content) {
		return _spMailLocalService.appendTracker(content);
	}

	@Override
	public java.lang.String decryptLink(java.lang.String link) {
		return _spMailLocalService.decryptLink(link);
	}

	@Override
	public java.lang.String encryptLink(java.lang.String link) {
		return _spMailLocalService.encryptLink(link);
	}

	@Override
	public java.lang.String[] getLinksFromHtml(java.lang.String content) {
		return _spMailLocalService.getLinksFromHtml(content);
	}

	@Override
	public java.lang.String getMailBody(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType) {
		return _spMailLocalService.getMailBody(spMailCampaign, spMailType);
	}

	@Override
	public java.lang.String getMailSubject(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType) {
		return _spMailLocalService.getMailSubject(spMailCampaign, spMailType);
	}

	@Override
	public java.lang.String getProcessedContent(java.lang.String content,
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		long subscriberId, long edmId) {
		return _spMailLocalService.getProcessedContent(content, campaign,
			subscriberId, edmId);
	}

	@Override
	public java.lang.String getWebversion(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber) {
		return _spMailLocalService.getWebversion(campaign, subscriber);
	}

	@Override
	public java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress) {
		return _spMailLocalService.processMailBodyParameters(subject, content,
			rsvpId, subscriber, fromName, fromAddress);
	}

	@Override
	public java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress,
		boolean webVersion) {
		return _spMailLocalService.processMailBodyParameters(subject, content,
			rsvpId, subscriber, fromName, fromAddress, webVersion);
	}

	@Override
	public java.lang.String sendMail(
		com.sambaash.platform.model.MailMessage mailMessage) {
		return _spMailLocalService.sendMail(mailMessage);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil} to
	* access the s p mail local service.
	*/
	@Override
	public java.lang.String sendMail(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.util.List<com.liferay.mail.model.FileAttachment> attachments,
		long scopeGroupId, boolean ccEmail) {
		return _spMailLocalService.sendMail(campaign, subscriber, attachments,
			scopeGroupId, ccEmail);
	}

	@Override
	public void testTemplate(long templateId) {
		_spMailLocalService.testTemplate(templateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailLocalService getWrappedSPMailLocalService() {
		return _spMailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailLocalService(
		SPMailLocalService spMailLocalService) {
		_spMailLocalService = spMailLocalService;
	}

	@Override
	public SPMailLocalService getWrappedService() {
		return _spMailLocalService;
	}

	@Override
	public void setWrappedService(SPMailLocalService spMailLocalService) {
		_spMailLocalService = spMailLocalService;
	}

	private SPMailLocalService _spMailLocalService;
}