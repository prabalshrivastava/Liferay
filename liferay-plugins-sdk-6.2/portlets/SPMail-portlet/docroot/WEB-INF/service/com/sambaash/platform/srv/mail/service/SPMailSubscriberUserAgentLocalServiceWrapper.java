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
 * Provides a wrapper for {@link SPMailSubscriberUserAgentLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailSubscriberUserAgentLocalService
 * @generated
 */
public class SPMailSubscriberUserAgentLocalServiceWrapper
	implements SPMailSubscriberUserAgentLocalService,
		ServiceWrapper<SPMailSubscriberUserAgentLocalService> {
	public SPMailSubscriberUserAgentLocalServiceWrapper(
		SPMailSubscriberUserAgentLocalService spMailSubscriberUserAgentLocalService) {
		_spMailSubscriberUserAgentLocalService = spMailSubscriberUserAgentLocalService;
	}

	/**
	* Adds the s p mail subscriber user agent to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailSubscriberUserAgent the s p mail subscriber user agent
	* @return the s p mail subscriber user agent that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent addSPMailSubscriberUserAgent(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.addSPMailSubscriberUserAgent(spMailSubscriberUserAgent);
	}

	/**
	* Creates a new s p mail subscriber user agent with the primary key. Does not add the s p mail subscriber user agent to the database.
	*
	* @param spMailSubscriberUserAgentId the primary key for the new s p mail subscriber user agent
	* @return the new s p mail subscriber user agent
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent createSPMailSubscriberUserAgent(
		long spMailSubscriberUserAgentId) {
		return _spMailSubscriberUserAgentLocalService.createSPMailSubscriberUserAgent(spMailSubscriberUserAgentId);
	}

	/**
	* Deletes the s p mail subscriber user agent with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	* @return the s p mail subscriber user agent that was removed
	* @throws PortalException if a s p mail subscriber user agent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent deleteSPMailSubscriberUserAgent(
		long spMailSubscriberUserAgentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.deleteSPMailSubscriberUserAgent(spMailSubscriberUserAgentId);
	}

	/**
	* Deletes the s p mail subscriber user agent from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailSubscriberUserAgent the s p mail subscriber user agent
	* @return the s p mail subscriber user agent that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent deleteSPMailSubscriberUserAgent(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.deleteSPMailSubscriberUserAgent(spMailSubscriberUserAgent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailSubscriberUserAgentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent fetchSPMailSubscriberUserAgent(
		long spMailSubscriberUserAgentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.fetchSPMailSubscriberUserAgent(spMailSubscriberUserAgentId);
	}

	/**
	* Returns the s p mail subscriber user agent with the primary key.
	*
	* @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	* @return the s p mail subscriber user agent
	* @throws PortalException if a s p mail subscriber user agent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent getSPMailSubscriberUserAgent(
		long spMailSubscriberUserAgentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.getSPMailSubscriberUserAgent(spMailSubscriberUserAgentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail subscriber user agents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail subscriber user agents
	* @param end the upper bound of the range of s p mail subscriber user agents (not inclusive)
	* @return the range of s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent> getSPMailSubscriberUserAgents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.getSPMailSubscriberUserAgents(start,
			end);
	}

	/**
	* Returns the number of s p mail subscriber user agents.
	*
	* @return the number of s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailSubscriberUserAgentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.getSPMailSubscriberUserAgentsCount();
	}

	/**
	* Updates the s p mail subscriber user agent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailSubscriberUserAgent the s p mail subscriber user agent
	* @return the s p mail subscriber user agent that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent updateSPMailSubscriberUserAgent(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.updateSPMailSubscriberUserAgent(spMailSubscriberUserAgent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailSubscriberUserAgentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailSubscriberUserAgentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailSubscriberUserAgentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalServiceUtil} to access the s p mail
	* subscriber user agent local service.
	*/
	@Override
	public void addUserAgent(long spMailCampaignId,
		long spMailCampaignSubscribersId, java.lang.String userAgent)
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailSubscriberUserAgentLocalService.addUserAgent(spMailCampaignId,
			spMailCampaignSubscribersId, userAgent);
	}

	@Override
	public java.util.List<java.lang.Object[]> countMailSubscriberByDeviceCatogory(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.countMailSubscriberByDeviceCatogory(spMailCampaignId);
	}

	@Override
	public java.util.List<java.lang.Object[]> countMailSubscriberByFamily(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.countMailSubscriberByFamily(spMailCampaignId);
	}

	@Override
	public java.util.List<java.lang.Object[]> countMailSubscriberByName(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.countMailSubscriberByName(spMailCampaignId);
	}

	@Override
	public java.util.List<java.lang.Object[]> countMailSubscriberByOS(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.countMailSubscriberByOS(spMailCampaignId);
	}

	@Override
	public java.util.List<java.lang.Object[]> countMailSubscriberByType(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.countMailSubscriberByType(spMailCampaignId);
	}

	@Override
	public java.util.List<java.lang.Object[]> countMailSubscriberByTypeName(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailSubscriberUserAgentLocalService.countMailSubscriberByTypeName(spMailCampaignId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailSubscriberUserAgentLocalService getWrappedSPMailSubscriberUserAgentLocalService() {
		return _spMailSubscriberUserAgentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailSubscriberUserAgentLocalService(
		SPMailSubscriberUserAgentLocalService spMailSubscriberUserAgentLocalService) {
		_spMailSubscriberUserAgentLocalService = spMailSubscriberUserAgentLocalService;
	}

	@Override
	public SPMailSubscriberUserAgentLocalService getWrappedService() {
		return _spMailSubscriberUserAgentLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailSubscriberUserAgentLocalService spMailSubscriberUserAgentLocalService) {
		_spMailSubscriberUserAgentLocalService = spMailSubscriberUserAgentLocalService;
	}

	private SPMailSubscriberUserAgentLocalService _spMailSubscriberUserAgentLocalService;
}