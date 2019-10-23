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
 * Provides a wrapper for {@link SPMailCampaignSubscribersLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribersLocalService
 * @generated
 */
public class SPMailCampaignSubscribersLocalServiceWrapper
	implements SPMailCampaignSubscribersLocalService,
		ServiceWrapper<SPMailCampaignSubscribersLocalService> {
	public SPMailCampaignSubscribersLocalServiceWrapper(
		SPMailCampaignSubscribersLocalService spMailCampaignSubscribersLocalService) {
		_spMailCampaignSubscribersLocalService = spMailCampaignSubscribersLocalService;
	}

	/**
	* Adds the s p mail campaign subscribers to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers addSPMailCampaignSubscribers(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.addSPMailCampaignSubscribers(spMailCampaignSubscribers);
	}

	/**
	* Creates a new s p mail campaign subscribers with the primary key. Does not add the s p mail campaign subscribers to the database.
	*
	* @param spMailCampaignSubscribersId the primary key for the new s p mail campaign subscribers
	* @return the new s p mail campaign subscribers
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers createSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId) {
		return _spMailCampaignSubscribersLocalService.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	/**
	* Deletes the s p mail campaign subscribers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was removed
	* @throws PortalException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers deleteSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.deleteSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	/**
	* Deletes the s p mail campaign subscribers from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers deleteSPMailCampaignSubscribers(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.deleteSPMailCampaignSubscribers(spMailCampaignSubscribers);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailCampaignSubscribersLocalService.dynamicQuery();
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
		return _spMailCampaignSubscribersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailCampaignSubscribersLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailCampaignSubscribersLocalService.dynamicQuery(dynamicQuery,
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
		return _spMailCampaignSubscribersLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spMailCampaignSubscribersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.fetchSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	/**
	* Returns the s p mail campaign subscribers with the primary key.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers
	* @throws PortalException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers getSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.getSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> getSPMailCampaignSubscriberses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.getSPMailCampaignSubscriberses(start,
			end);
	}

	/**
	* Returns the number of s p mail campaign subscriberses.
	*
	* @return the number of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailCampaignSubscribersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.getSPMailCampaignSubscribersesCount();
	}

	/**
	* Updates the s p mail campaign subscribers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers updateSPMailCampaignSubscribers(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.updateSPMailCampaignSubscribers(spMailCampaignSubscribers);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailCampaignSubscribersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailCampaignSubscribersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailCampaignSubscribersLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers addNewsLetterCampaignSubscriber(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email, boolean emailOnly, long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.addNewsLetterCampaignSubscriber(firstName,
			lastName, email, emailOnly, spMailCampaignId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform
	* .srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil} to access the s p mail campaign subscribers local
	* service.
	*/
	@Override
	public void clearCache() {
		_spMailCampaignSubscribersLocalService.clearCache();
	}

	@Override
	public int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countByCampaignId(spMailCampaignId);
	}

	@Override
	public int countByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countByCampaignIdAndMailType(spMailCampaignId,
			spMailType);
	}

	@Override
	public int countByCampaignIdAndOpened(long spMailCampaignId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countByCampaignIdAndOpened(spMailCampaignId,
			opened);
	}

	@Override
	public int countByCampaignIdMailTypeAndOpened(long spMailCampaignId,
		int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened);
	}

	@Override
	public int countByCampaignIdMailTypeAndStatus(long spMailCampaignId,
		int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status);
	}

	@Override
	public java.util.List<java.lang.Object[]> countOpenedMailByCountry(
		long spMailCampaignId, int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countOpenedMailByCountry(spMailCampaignId,
			spMailType);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignId(spMailCampaignId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignId(spMailCampaignId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndEmailAddress(spMailCampaignId,
			emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndFirstName(spMailCampaignId,
			firstName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndLastName(spMailCampaignId,
			lastName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndMailType(spMailCampaignId,
			spMailType);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndMailType(spMailCampaignId,
			spMailType, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndOpened(spMailCampaignId,
			opened);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdAndOpened(spMailCampaignId,
			opened, start, end);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
			opened, emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdOpenedAndFirstName(spMailCampaignId,
			opened, firstName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByCampaignIdOpenedAndLastName(spMailCampaignId,
			opened, lastName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByEmailAddress(emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.findByEmailAddress(emailAddress,
			start, end);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByMessageId(messageId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return _spMailCampaignSubscribersLocalService.findByUserId(userId);
	}

	@Override
	public int countByUserIdAndOpened(long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.countByUserIdAndOpened(userId,
			opened);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers updateSubscriber(
		long subscriberId, java.lang.String ipAddress,
		java.lang.String userAgent) {
		return _spMailCampaignSubscribersLocalService.updateSubscriber(subscriberId,
			ipAddress, userAgent);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribersLocalService.create();
	}

	@Override
	public void addSubscriber(long companyId, long createdBy,
		long spMailCampaignId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailCampaignSubscribersLocalService.addSubscriber(companyId,
			createdBy, spMailCampaignId, firstName, lastName, emailAddress);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailCampaignSubscribersLocalService getWrappedSPMailCampaignSubscribersLocalService() {
		return _spMailCampaignSubscribersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailCampaignSubscribersLocalService(
		SPMailCampaignSubscribersLocalService spMailCampaignSubscribersLocalService) {
		_spMailCampaignSubscribersLocalService = spMailCampaignSubscribersLocalService;
	}

	@Override
	public SPMailCampaignSubscribersLocalService getWrappedService() {
		return _spMailCampaignSubscribersLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailCampaignSubscribersLocalService spMailCampaignSubscribersLocalService) {
		_spMailCampaignSubscribersLocalService = spMailCampaignSubscribersLocalService;
	}

	private SPMailCampaignSubscribersLocalService _spMailCampaignSubscribersLocalService;
}