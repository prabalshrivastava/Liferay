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
 * Provides a wrapper for {@link SPMailLinkTrackingLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTrackingLocalService
 * @generated
 */
public class SPMailLinkTrackingLocalServiceWrapper
	implements SPMailLinkTrackingLocalService,
		ServiceWrapper<SPMailLinkTrackingLocalService> {
	public SPMailLinkTrackingLocalServiceWrapper(
		SPMailLinkTrackingLocalService spMailLinkTrackingLocalService) {
		_spMailLinkTrackingLocalService = spMailLinkTrackingLocalService;
	}

	/**
	* Adds the s p mail link tracking to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTracking the s p mail link tracking
	* @return the s p mail link tracking that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking addSPMailLinkTracking(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.addSPMailLinkTracking(spMailLinkTracking);
	}

	/**
	* Creates a new s p mail link tracking with the primary key. Does not add the s p mail link tracking to the database.
	*
	* @param spMailLinkTrackingId the primary key for the new s p mail link tracking
	* @return the new s p mail link tracking
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking createSPMailLinkTracking(
		long spMailLinkTrackingId) {
		return _spMailLinkTrackingLocalService.createSPMailLinkTracking(spMailLinkTrackingId);
	}

	/**
	* Deletes the s p mail link tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking that was removed
	* @throws PortalException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking deleteSPMailLinkTracking(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.deleteSPMailLinkTracking(spMailLinkTrackingId);
	}

	/**
	* Deletes the s p mail link tracking from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTracking the s p mail link tracking
	* @return the s p mail link tracking that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking deleteSPMailLinkTracking(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.deleteSPMailLinkTracking(spMailLinkTracking);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailLinkTrackingLocalService.dynamicQuery();
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
		return _spMailLinkTrackingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailLinkTrackingLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailLinkTrackingLocalService.dynamicQuery(dynamicQuery,
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
		return _spMailLinkTrackingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spMailLinkTrackingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchSPMailLinkTracking(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.fetchSPMailLinkTracking(spMailLinkTrackingId);
	}

	/**
	* Returns the s p mail link tracking with the primary key.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking
	* @throws PortalException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking getSPMailLinkTracking(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.getSPMailLinkTracking(spMailLinkTrackingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail link trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail link trackings
	* @param end the upper bound of the range of s p mail link trackings (not inclusive)
	* @return the range of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> getSPMailLinkTrackings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.getSPMailLinkTrackings(start, end);
	}

	/**
	* Returns the number of s p mail link trackings.
	*
	* @return the number of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailLinkTrackingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.getSPMailLinkTrackingsCount();
	}

	/**
	* Updates the s p mail link tracking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTracking the s p mail link tracking
	* @return the s p mail link tracking that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking updateSPMailLinkTracking(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.updateSPMailLinkTracking(spMailLinkTracking);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailLinkTrackingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailLinkTrackingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailLinkTrackingLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.lang.Object[]> countOpenedMailByLink(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.countOpenedMailByLink(spMailCampaignId);
	}

	@Override
	public java.util.List<java.lang.Object[]> countOpenedMailByLink(
		long spMailCampaignId, long mailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.countOpenedMailByLink(spMailCampaignId,
			mailType);
	}

	@Override
	public java.util.List<java.lang.Object[]> getMailLinkInteractionCount(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.getMailLinkInteractionCount(spMailCampaignId,
			spMailCampaignSubscribersId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long campaignId, long subscriberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailLinkTrackingLocalService.findByCampaignIdAndSubscribersId(campaignId,
			subscriberId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil} to access the s p mail link tracking
	* local service.
	*/
	@Override
	public void trackLink(long trackingId) {
		_spMailLinkTrackingLocalService.trackLink(trackingId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailLinkTrackingLocalService getWrappedSPMailLinkTrackingLocalService() {
		return _spMailLinkTrackingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailLinkTrackingLocalService(
		SPMailLinkTrackingLocalService spMailLinkTrackingLocalService) {
		_spMailLinkTrackingLocalService = spMailLinkTrackingLocalService;
	}

	@Override
	public SPMailLinkTrackingLocalService getWrappedService() {
		return _spMailLinkTrackingLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailLinkTrackingLocalService spMailLinkTrackingLocalService) {
		_spMailLinkTrackingLocalService = spMailLinkTrackingLocalService;
	}

	private SPMailLinkTrackingLocalService _spMailLinkTrackingLocalService;
}