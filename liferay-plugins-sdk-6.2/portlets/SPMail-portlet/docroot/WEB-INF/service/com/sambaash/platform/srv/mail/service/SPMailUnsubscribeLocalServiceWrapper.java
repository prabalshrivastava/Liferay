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
 * Provides a wrapper for {@link SPMailUnsubscribeLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribeLocalService
 * @generated
 */
public class SPMailUnsubscribeLocalServiceWrapper
	implements SPMailUnsubscribeLocalService,
		ServiceWrapper<SPMailUnsubscribeLocalService> {
	public SPMailUnsubscribeLocalServiceWrapper(
		SPMailUnsubscribeLocalService spMailUnsubscribeLocalService) {
		_spMailUnsubscribeLocalService = spMailUnsubscribeLocalService;
	}

	/**
	* Adds the s p mail unsubscribe to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	* @return the s p mail unsubscribe that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe addSPMailUnsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.addSPMailUnsubscribe(spMailUnsubscribe);
	}

	/**
	* Creates a new s p mail unsubscribe with the primary key. Does not add the s p mail unsubscribe to the database.
	*
	* @param spMailUnsubscribeId the primary key for the new s p mail unsubscribe
	* @return the new s p mail unsubscribe
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe createSPMailUnsubscribe(
		long spMailUnsubscribeId) {
		return _spMailUnsubscribeLocalService.createSPMailUnsubscribe(spMailUnsubscribeId);
	}

	/**
	* Deletes the s p mail unsubscribe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe that was removed
	* @throws PortalException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe deleteSPMailUnsubscribe(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.deleteSPMailUnsubscribe(spMailUnsubscribeId);
	}

	/**
	* Deletes the s p mail unsubscribe from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe deleteSPMailUnsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.deleteSPMailUnsubscribe(spMailUnsubscribe);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailUnsubscribeLocalService.dynamicQuery();
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
		return _spMailUnsubscribeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailUnsubscribeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailUnsubscribeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spMailUnsubscribeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spMailUnsubscribeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchSPMailUnsubscribe(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.fetchSPMailUnsubscribe(spMailUnsubscribeId);
	}

	/**
	* Returns the s p mail unsubscribe with the primary key.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe
	* @throws PortalException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe getSPMailUnsubscribe(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.getSPMailUnsubscribe(spMailUnsubscribeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail unsubscribes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail unsubscribes
	* @param end the upper bound of the range of s p mail unsubscribes (not inclusive)
	* @return the range of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> getSPMailUnsubscribes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.getSPMailUnsubscribes(start, end);
	}

	/**
	* Returns the number of s p mail unsubscribes.
	*
	* @return the number of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailUnsubscribesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.getSPMailUnsubscribesCount();
	}

	/**
	* Updates the s p mail unsubscribe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	* @return the s p mail unsubscribe that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe updateSPMailUnsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribeLocalService.updateSPMailUnsubscribe(spMailUnsubscribe);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailUnsubscribeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailUnsubscribeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailUnsubscribeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddress(
		java.lang.String emailAddress) {
		return _spMailUnsubscribeLocalService.findByEmailAddress(emailAddress);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return _spMailUnsubscribeLocalService.findByEmailAddressAndCategoryId(emailAddress,
			categoryId);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByUserId(
		long userId) {
		return _spMailUnsubscribeLocalService.findByUserId(userId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil} to access the s p mail unsubscribe
	* local service.
	*/
	@Override
	public void unsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign) {
		_spMailUnsubscribeLocalService.unsubscribe(subscriber, campaign);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailUnsubscribeLocalService getWrappedSPMailUnsubscribeLocalService() {
		return _spMailUnsubscribeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailUnsubscribeLocalService(
		SPMailUnsubscribeLocalService spMailUnsubscribeLocalService) {
		_spMailUnsubscribeLocalService = spMailUnsubscribeLocalService;
	}

	@Override
	public SPMailUnsubscribeLocalService getWrappedService() {
		return _spMailUnsubscribeLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailUnsubscribeLocalService spMailUnsubscribeLocalService) {
		_spMailUnsubscribeLocalService = spMailUnsubscribeLocalService;
	}

	private SPMailUnsubscribeLocalService _spMailUnsubscribeLocalService;
}