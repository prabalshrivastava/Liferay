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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPMail. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPMailLocalService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl
 * @generated
 */
public class SPMailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.lang.String appendTracker(java.lang.String content) {
		return getService().appendTracker(content);
	}

	public static java.lang.String decryptLink(java.lang.String link) {
		return getService().decryptLink(link);
	}

	public static java.lang.String encryptLink(java.lang.String link) {
		return getService().encryptLink(link);
	}

	public static java.lang.String[] getLinksFromHtml(java.lang.String content) {
		return getService().getLinksFromHtml(content);
	}

	public static java.lang.String getMailBody(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType) {
		return getService().getMailBody(spMailCampaign, spMailType);
	}

	public static java.lang.String getMailSubject(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType) {
		return getService().getMailSubject(spMailCampaign, spMailType);
	}

	public static java.lang.String getProcessedContent(
		java.lang.String content,
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		long subscriberId, long edmId) {
		return getService()
				   .getProcessedContent(content, campaign, subscriberId, edmId);
	}

	public static java.lang.String getWebversion(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber) {
		return getService().getWebversion(campaign, subscriber);
	}

	public static java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress) {
		return getService()
				   .processMailBodyParameters(subject, content, rsvpId,
			subscriber, fromName, fromAddress);
	}

	public static java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress,
		boolean webVersion) {
		return getService()
				   .processMailBodyParameters(subject, content, rsvpId,
			subscriber, fromName, fromAddress, webVersion);
	}

	public static java.lang.String sendMail(
		com.sambaash.platform.model.MailMessage mailMessage) {
		return getService().sendMail(mailMessage);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil} to
	* access the s p mail local service.
	*/
	public static java.lang.String sendMail(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.util.List<com.liferay.mail.model.FileAttachment> attachments,
		long scopeGroupId, boolean ccEmail) {
		return getService()
				   .sendMail(campaign, subscriber, attachments, scopeGroupId,
			ccEmail);
	}

	public static void testTemplate(long templateId) {
		getService().testTemplate(templateId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailLocalService.class.getName());

			if (invokableLocalService instanceof SPMailLocalService) {
				_service = (SPMailLocalService)invokableLocalService;
			}
			else {
				_service = new SPMailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPMailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailLocalService service) {
	}

	private static SPMailLocalService _service;
}