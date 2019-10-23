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

package com.sambaash.platform.srv.mail.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sambaash.platform.srv.mail.service.SPMailLocalService;
import com.sambaash.platform.srv.mail.service.persistence.SPEMailAuditPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailBlackListPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailCampaignEDMPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailCampaignPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailCampaignSubscribersPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailLinkTrackingPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailSubscriberUserAgentPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailTemplateAttachmentPersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailTemplatePersistence;
import com.sambaash.platform.srv.mail.service.persistence.SPMailUnsubscribePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p mail local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailLocalServiceImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil
 * @generated
 */
public abstract class SPMailLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements SPMailLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil} to access the s p mail local service.
	 */

	/**
	 * Returns the s p e mail audit local service.
	 *
	 * @return the s p e mail audit local service
	 */
	public com.sambaash.platform.srv.mail.service.SPEMailAuditLocalService getSPEMailAuditLocalService() {
		return speMailAuditLocalService;
	}

	/**
	 * Sets the s p e mail audit local service.
	 *
	 * @param speMailAuditLocalService the s p e mail audit local service
	 */
	public void setSPEMailAuditLocalService(
		com.sambaash.platform.srv.mail.service.SPEMailAuditLocalService speMailAuditLocalService) {
		this.speMailAuditLocalService = speMailAuditLocalService;
	}

	/**
	 * Returns the s p e mail audit persistence.
	 *
	 * @return the s p e mail audit persistence
	 */
	public SPEMailAuditPersistence getSPEMailAuditPersistence() {
		return speMailAuditPersistence;
	}

	/**
	 * Sets the s p e mail audit persistence.
	 *
	 * @param speMailAuditPersistence the s p e mail audit persistence
	 */
	public void setSPEMailAuditPersistence(
		SPEMailAuditPersistence speMailAuditPersistence) {
		this.speMailAuditPersistence = speMailAuditPersistence;
	}

	/**
	 * Returns the s p mail local service.
	 *
	 * @return the s p mail local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailLocalService getSPMailLocalService() {
		return spMailLocalService;
	}

	/**
	 * Sets the s p mail local service.
	 *
	 * @param spMailLocalService the s p mail local service
	 */
	public void setSPMailLocalService(
		com.sambaash.platform.srv.mail.service.SPMailLocalService spMailLocalService) {
		this.spMailLocalService = spMailLocalService;
	}

	/**
	 * Returns the s p mail black list local service.
	 *
	 * @return the s p mail black list local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailBlackListLocalService getSPMailBlackListLocalService() {
		return spMailBlackListLocalService;
	}

	/**
	 * Sets the s p mail black list local service.
	 *
	 * @param spMailBlackListLocalService the s p mail black list local service
	 */
	public void setSPMailBlackListLocalService(
		com.sambaash.platform.srv.mail.service.SPMailBlackListLocalService spMailBlackListLocalService) {
		this.spMailBlackListLocalService = spMailBlackListLocalService;
	}

	/**
	 * Returns the s p mail black list persistence.
	 *
	 * @return the s p mail black list persistence
	 */
	public SPMailBlackListPersistence getSPMailBlackListPersistence() {
		return spMailBlackListPersistence;
	}

	/**
	 * Sets the s p mail black list persistence.
	 *
	 * @param spMailBlackListPersistence the s p mail black list persistence
	 */
	public void setSPMailBlackListPersistence(
		SPMailBlackListPersistence spMailBlackListPersistence) {
		this.spMailBlackListPersistence = spMailBlackListPersistence;
	}

	/**
	 * Returns the s p mail campaign local service.
	 *
	 * @return the s p mail campaign local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailCampaignLocalService getSPMailCampaignLocalService() {
		return spMailCampaignLocalService;
	}

	/**
	 * Sets the s p mail campaign local service.
	 *
	 * @param spMailCampaignLocalService the s p mail campaign local service
	 */
	public void setSPMailCampaignLocalService(
		com.sambaash.platform.srv.mail.service.SPMailCampaignLocalService spMailCampaignLocalService) {
		this.spMailCampaignLocalService = spMailCampaignLocalService;
	}

	/**
	 * Returns the s p mail campaign persistence.
	 *
	 * @return the s p mail campaign persistence
	 */
	public SPMailCampaignPersistence getSPMailCampaignPersistence() {
		return spMailCampaignPersistence;
	}

	/**
	 * Sets the s p mail campaign persistence.
	 *
	 * @param spMailCampaignPersistence the s p mail campaign persistence
	 */
	public void setSPMailCampaignPersistence(
		SPMailCampaignPersistence spMailCampaignPersistence) {
		this.spMailCampaignPersistence = spMailCampaignPersistence;
	}

	/**
	 * Returns the s p mail campaign e d m local service.
	 *
	 * @return the s p mail campaign e d m local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalService getSPMailCampaignEDMLocalService() {
		return spMailCampaignEDMLocalService;
	}

	/**
	 * Sets the s p mail campaign e d m local service.
	 *
	 * @param spMailCampaignEDMLocalService the s p mail campaign e d m local service
	 */
	public void setSPMailCampaignEDMLocalService(
		com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalService spMailCampaignEDMLocalService) {
		this.spMailCampaignEDMLocalService = spMailCampaignEDMLocalService;
	}

	/**
	 * Returns the s p mail campaign e d m persistence.
	 *
	 * @return the s p mail campaign e d m persistence
	 */
	public SPMailCampaignEDMPersistence getSPMailCampaignEDMPersistence() {
		return spMailCampaignEDMPersistence;
	}

	/**
	 * Sets the s p mail campaign e d m persistence.
	 *
	 * @param spMailCampaignEDMPersistence the s p mail campaign e d m persistence
	 */
	public void setSPMailCampaignEDMPersistence(
		SPMailCampaignEDMPersistence spMailCampaignEDMPersistence) {
		this.spMailCampaignEDMPersistence = spMailCampaignEDMPersistence;
	}

	/**
	 * Returns the s p mail campaign subscribers local service.
	 *
	 * @return the s p mail campaign subscribers local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalService getSPMailCampaignSubscribersLocalService() {
		return spMailCampaignSubscribersLocalService;
	}

	/**
	 * Sets the s p mail campaign subscribers local service.
	 *
	 * @param spMailCampaignSubscribersLocalService the s p mail campaign subscribers local service
	 */
	public void setSPMailCampaignSubscribersLocalService(
		com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalService spMailCampaignSubscribersLocalService) {
		this.spMailCampaignSubscribersLocalService = spMailCampaignSubscribersLocalService;
	}

	/**
	 * Returns the s p mail campaign subscribers persistence.
	 *
	 * @return the s p mail campaign subscribers persistence
	 */
	public SPMailCampaignSubscribersPersistence getSPMailCampaignSubscribersPersistence() {
		return spMailCampaignSubscribersPersistence;
	}

	/**
	 * Sets the s p mail campaign subscribers persistence.
	 *
	 * @param spMailCampaignSubscribersPersistence the s p mail campaign subscribers persistence
	 */
	public void setSPMailCampaignSubscribersPersistence(
		SPMailCampaignSubscribersPersistence spMailCampaignSubscribersPersistence) {
		this.spMailCampaignSubscribersPersistence = spMailCampaignSubscribersPersistence;
	}

	/**
	 * Returns the s p mail link tracking local service.
	 *
	 * @return the s p mail link tracking local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalService getSPMailLinkTrackingLocalService() {
		return spMailLinkTrackingLocalService;
	}

	/**
	 * Sets the s p mail link tracking local service.
	 *
	 * @param spMailLinkTrackingLocalService the s p mail link tracking local service
	 */
	public void setSPMailLinkTrackingLocalService(
		com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalService spMailLinkTrackingLocalService) {
		this.spMailLinkTrackingLocalService = spMailLinkTrackingLocalService;
	}

	/**
	 * Returns the s p mail link tracking persistence.
	 *
	 * @return the s p mail link tracking persistence
	 */
	public SPMailLinkTrackingPersistence getSPMailLinkTrackingPersistence() {
		return spMailLinkTrackingPersistence;
	}

	/**
	 * Sets the s p mail link tracking persistence.
	 *
	 * @param spMailLinkTrackingPersistence the s p mail link tracking persistence
	 */
	public void setSPMailLinkTrackingPersistence(
		SPMailLinkTrackingPersistence spMailLinkTrackingPersistence) {
		this.spMailLinkTrackingPersistence = spMailLinkTrackingPersistence;
	}

	/**
	 * Returns the s p mail subscriber user agent local service.
	 *
	 * @return the s p mail subscriber user agent local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalService getSPMailSubscriberUserAgentLocalService() {
		return spMailSubscriberUserAgentLocalService;
	}

	/**
	 * Sets the s p mail subscriber user agent local service.
	 *
	 * @param spMailSubscriberUserAgentLocalService the s p mail subscriber user agent local service
	 */
	public void setSPMailSubscriberUserAgentLocalService(
		com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalService spMailSubscriberUserAgentLocalService) {
		this.spMailSubscriberUserAgentLocalService = spMailSubscriberUserAgentLocalService;
	}

	/**
	 * Returns the s p mail subscriber user agent persistence.
	 *
	 * @return the s p mail subscriber user agent persistence
	 */
	public SPMailSubscriberUserAgentPersistence getSPMailSubscriberUserAgentPersistence() {
		return spMailSubscriberUserAgentPersistence;
	}

	/**
	 * Sets the s p mail subscriber user agent persistence.
	 *
	 * @param spMailSubscriberUserAgentPersistence the s p mail subscriber user agent persistence
	 */
	public void setSPMailSubscriberUserAgentPersistence(
		SPMailSubscriberUserAgentPersistence spMailSubscriberUserAgentPersistence) {
		this.spMailSubscriberUserAgentPersistence = spMailSubscriberUserAgentPersistence;
	}

	/**
	 * Returns the s p mail template local service.
	 *
	 * @return the s p mail template local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailTemplateLocalService getSPMailTemplateLocalService() {
		return spMailTemplateLocalService;
	}

	/**
	 * Sets the s p mail template local service.
	 *
	 * @param spMailTemplateLocalService the s p mail template local service
	 */
	public void setSPMailTemplateLocalService(
		com.sambaash.platform.srv.mail.service.SPMailTemplateLocalService spMailTemplateLocalService) {
		this.spMailTemplateLocalService = spMailTemplateLocalService;
	}

	/**
	 * Returns the s p mail template remote service.
	 *
	 * @return the s p mail template remote service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailTemplateService getSPMailTemplateService() {
		return spMailTemplateService;
	}

	/**
	 * Sets the s p mail template remote service.
	 *
	 * @param spMailTemplateService the s p mail template remote service
	 */
	public void setSPMailTemplateService(
		com.sambaash.platform.srv.mail.service.SPMailTemplateService spMailTemplateService) {
		this.spMailTemplateService = spMailTemplateService;
	}

	/**
	 * Returns the s p mail template persistence.
	 *
	 * @return the s p mail template persistence
	 */
	public SPMailTemplatePersistence getSPMailTemplatePersistence() {
		return spMailTemplatePersistence;
	}

	/**
	 * Sets the s p mail template persistence.
	 *
	 * @param spMailTemplatePersistence the s p mail template persistence
	 */
	public void setSPMailTemplatePersistence(
		SPMailTemplatePersistence spMailTemplatePersistence) {
		this.spMailTemplatePersistence = spMailTemplatePersistence;
	}

	/**
	 * Returns the s p mail template attachment local service.
	 *
	 * @return the s p mail template attachment local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalService getSPMailTemplateAttachmentLocalService() {
		return spMailTemplateAttachmentLocalService;
	}

	/**
	 * Sets the s p mail template attachment local service.
	 *
	 * @param spMailTemplateAttachmentLocalService the s p mail template attachment local service
	 */
	public void setSPMailTemplateAttachmentLocalService(
		com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalService spMailTemplateAttachmentLocalService) {
		this.spMailTemplateAttachmentLocalService = spMailTemplateAttachmentLocalService;
	}

	/**
	 * Returns the s p mail template attachment persistence.
	 *
	 * @return the s p mail template attachment persistence
	 */
	public SPMailTemplateAttachmentPersistence getSPMailTemplateAttachmentPersistence() {
		return spMailTemplateAttachmentPersistence;
	}

	/**
	 * Sets the s p mail template attachment persistence.
	 *
	 * @param spMailTemplateAttachmentPersistence the s p mail template attachment persistence
	 */
	public void setSPMailTemplateAttachmentPersistence(
		SPMailTemplateAttachmentPersistence spMailTemplateAttachmentPersistence) {
		this.spMailTemplateAttachmentPersistence = spMailTemplateAttachmentPersistence;
	}

	/**
	 * Returns the s p mail unsubscribe local service.
	 *
	 * @return the s p mail unsubscribe local service
	 */
	public com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalService getSPMailUnsubscribeLocalService() {
		return spMailUnsubscribeLocalService;
	}

	/**
	 * Sets the s p mail unsubscribe local service.
	 *
	 * @param spMailUnsubscribeLocalService the s p mail unsubscribe local service
	 */
	public void setSPMailUnsubscribeLocalService(
		com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalService spMailUnsubscribeLocalService) {
		this.spMailUnsubscribeLocalService = spMailUnsubscribeLocalService;
	}

	/**
	 * Returns the s p mail unsubscribe persistence.
	 *
	 * @return the s p mail unsubscribe persistence
	 */
	public SPMailUnsubscribePersistence getSPMailUnsubscribePersistence() {
		return spMailUnsubscribePersistence;
	}

	/**
	 * Sets the s p mail unsubscribe persistence.
	 *
	 * @param spMailUnsubscribePersistence the s p mail unsubscribe persistence
	 */
	public void setSPMailUnsubscribePersistence(
		SPMailUnsubscribePersistence spMailUnsubscribePersistence) {
		this.spMailUnsubscribePersistence = spMailUnsubscribePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPEMailAuditLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPEMailAuditLocalService speMailAuditLocalService;
	@BeanReference(type = SPEMailAuditPersistence.class)
	protected SPEMailAuditPersistence speMailAuditPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailLocalService spMailLocalService;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailBlackListLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailBlackListLocalService spMailBlackListLocalService;
	@BeanReference(type = SPMailBlackListPersistence.class)
	protected SPMailBlackListPersistence spMailBlackListPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailCampaignLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailCampaignLocalService spMailCampaignLocalService;
	@BeanReference(type = SPMailCampaignPersistence.class)
	protected SPMailCampaignPersistence spMailCampaignPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalService spMailCampaignEDMLocalService;
	@BeanReference(type = SPMailCampaignEDMPersistence.class)
	protected SPMailCampaignEDMPersistence spMailCampaignEDMPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalService spMailCampaignSubscribersLocalService;
	@BeanReference(type = SPMailCampaignSubscribersPersistence.class)
	protected SPMailCampaignSubscribersPersistence spMailCampaignSubscribersPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalService spMailLinkTrackingLocalService;
	@BeanReference(type = SPMailLinkTrackingPersistence.class)
	protected SPMailLinkTrackingPersistence spMailLinkTrackingPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalService spMailSubscriberUserAgentLocalService;
	@BeanReference(type = SPMailSubscriberUserAgentPersistence.class)
	protected SPMailSubscriberUserAgentPersistence spMailSubscriberUserAgentPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailTemplateLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailTemplateLocalService spMailTemplateLocalService;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailTemplateService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailTemplateService spMailTemplateService;
	@BeanReference(type = SPMailTemplatePersistence.class)
	protected SPMailTemplatePersistence spMailTemplatePersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalService spMailTemplateAttachmentLocalService;
	@BeanReference(type = SPMailTemplateAttachmentPersistence.class)
	protected SPMailTemplateAttachmentPersistence spMailTemplateAttachmentPersistence;
	@BeanReference(type = com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalService.class)
	protected com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalService spMailUnsubscribeLocalService;
	@BeanReference(type = SPMailUnsubscribePersistence.class)
	protected SPMailUnsubscribePersistence spMailUnsubscribePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SPMailLocalServiceClpInvoker _clpInvoker = new SPMailLocalServiceClpInvoker();
}