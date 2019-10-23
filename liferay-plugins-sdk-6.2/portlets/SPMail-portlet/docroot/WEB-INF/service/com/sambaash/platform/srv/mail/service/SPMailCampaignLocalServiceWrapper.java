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
 * Provides a wrapper for {@link SPMailCampaignLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignLocalService
 * @generated
 */
public class SPMailCampaignLocalServiceWrapper
	implements SPMailCampaignLocalService,
		ServiceWrapper<SPMailCampaignLocalService> {
	public SPMailCampaignLocalServiceWrapper(
		SPMailCampaignLocalService spMailCampaignLocalService) {
		_spMailCampaignLocalService = spMailCampaignLocalService;
	}

	/**
	* Adds the s p mail campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaign the s p mail campaign
	* @return the s p mail campaign that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign addSPMailCampaign(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.addSPMailCampaign(spMailCampaign);
	}

	/**
	* Creates a new s p mail campaign with the primary key. Does not add the s p mail campaign to the database.
	*
	* @param spMailCampaignId the primary key for the new s p mail campaign
	* @return the new s p mail campaign
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign createSPMailCampaign(
		long spMailCampaignId) {
		return _spMailCampaignLocalService.createSPMailCampaign(spMailCampaignId);
	}

	/**
	* Deletes the s p mail campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign that was removed
	* @throws PortalException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign deleteSPMailCampaign(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.deleteSPMailCampaign(spMailCampaignId);
	}

	/**
	* Deletes the s p mail campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaign the s p mail campaign
	* @return the s p mail campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign deleteSPMailCampaign(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.deleteSPMailCampaign(spMailCampaign);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailCampaignLocalService.dynamicQuery();
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
		return _spMailCampaignLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailCampaignLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailCampaignLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _spMailCampaignLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spMailCampaignLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchSPMailCampaign(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.fetchSPMailCampaign(spMailCampaignId);
	}

	/**
	* Returns the s p mail campaign with the primary key.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign
	* @throws PortalException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign getSPMailCampaign(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.getSPMailCampaign(spMailCampaignId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaigns
	* @param end the upper bound of the range of s p mail campaigns (not inclusive)
	* @return the range of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> getSPMailCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.getSPMailCampaigns(start, end);
	}

	/**
	* Returns the number of s p mail campaigns.
	*
	* @return the number of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailCampaignsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.getSPMailCampaignsCount();
	}

	/**
	* Updates the s p mail campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaign the s p mail campaign
	* @return the s p mail campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign updateSPMailCampaign(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.updateSPMailCampaign(spMailCampaign);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailCampaignLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailCampaignLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailCampaignLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return _spMailCampaignLocalService.findByCampaignName(campaignName);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil} to access the s p mail campaign local
	* service.
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByrsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return _spMailCampaignLocalService.findByrsvpId(rsvpId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> getActiveCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignLocalService.getActiveCampaigns(start, end);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign getCampaign(
		long campaignId) {
		return _spMailCampaignLocalService.getCampaign(campaignId);
	}

	@Override
	public void subscribeToCampaign(java.lang.String email,
		java.lang.String firstName, java.lang.String lastName, long campaignId,
		java.lang.String portalUrl) {
		_spMailCampaignLocalService.subscribeToCampaign(email, firstName,
			lastName, campaignId, portalUrl);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailCampaignLocalService getWrappedSPMailCampaignLocalService() {
		return _spMailCampaignLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailCampaignLocalService(
		SPMailCampaignLocalService spMailCampaignLocalService) {
		_spMailCampaignLocalService = spMailCampaignLocalService;
	}

	@Override
	public SPMailCampaignLocalService getWrappedService() {
		return _spMailCampaignLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailCampaignLocalService spMailCampaignLocalService) {
		_spMailCampaignLocalService = spMailCampaignLocalService;
	}

	private SPMailCampaignLocalService _spMailCampaignLocalService;
}