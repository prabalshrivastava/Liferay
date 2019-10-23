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
 * Provides the local service utility for SPMailCampaignSubscribers. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailCampaignSubscribersLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribersLocalService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailCampaignSubscribersLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailCampaignSubscribersLocalServiceImpl
 * @generated
 */
public class SPMailCampaignSubscribersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailCampaignSubscribersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p mail campaign subscribers to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers addSPMailCampaignSubscribers(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSPMailCampaignSubscribers(spMailCampaignSubscribers);
	}

	/**
	* Creates a new s p mail campaign subscribers with the primary key. Does not add the s p mail campaign subscribers to the database.
	*
	* @param spMailCampaignSubscribersId the primary key for the new s p mail campaign subscribers
	* @return the new s p mail campaign subscribers
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers createSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId) {
		return getService()
				   .createSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	/**
	* Deletes the s p mail campaign subscribers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was removed
	* @throws PortalException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers deleteSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	/**
	* Deletes the s p mail campaign subscribers from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers deleteSPMailCampaignSubscribers(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSPMailCampaignSubscribers(spMailCampaignSubscribers);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	/**
	* Returns the s p mail campaign subscribers with the primary key.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers
	* @throws PortalException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers getSPMailCampaignSubscribers(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSPMailCampaignSubscribers(spMailCampaignSubscribersId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> getSPMailCampaignSubscriberses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailCampaignSubscriberses(start, end);
	}

	/**
	* Returns the number of s p mail campaign subscriberses.
	*
	* @return the number of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPMailCampaignSubscribersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailCampaignSubscribersesCount();
	}

	/**
	* Updates the s p mail campaign subscribers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers updateSPMailCampaignSubscribers(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSPMailCampaignSubscribers(spMailCampaignSubscribers);
	}

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

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers addNewsLetterCampaignSubscriber(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email, boolean emailOnly, long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNewsLetterCampaignSubscriber(firstName, lastName, email,
			emailOnly, spMailCampaignId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform
	* .srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil} to access the s p mail campaign subscribers local
	* service.
	*/
	public static void clearCache() {
		getService().clearCache();
	}

	public static int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCampaignId(spMailCampaignId);
	}

	public static int countByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	public static int countByCampaignIdAndOpened(long spMailCampaignId,
		boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	public static int countByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened);
	}

	public static int countByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status);
	}

	public static java.util.List<java.lang.Object[]> countOpenedMailByCountry(
		long spMailCampaignId, int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countOpenedMailByCountry(spMailCampaignId, spMailType);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCampaignId(spMailCampaignId);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCampaignId(spMailCampaignId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdAndEmailAddress(spMailCampaignId,
			emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdAndFirstName(spMailCampaignId, firstName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdAndLastName(spMailCampaignId, lastName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdAndMailType(spMailCampaignId, spMailType,
			start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdAndOpened(spMailCampaignId, opened, start,
			end);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
			opened, emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdOpenedAndFirstName(spMailCampaignId,
			opened, firstName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService()
				   .findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEmailAddress(emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEmailAddress(emailAddress, start, end);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService().findByMessageId(messageId);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getService().findByUserId(userId);
	}

	public static int countByUserIdAndOpened(long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserIdAndOpened(userId, opened);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers updateSubscriber(
		long subscriberId, java.lang.String ipAddress,
		java.lang.String userAgent) {
		return getService().updateSubscriber(subscriberId, ipAddress, userAgent);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static void addSubscriber(long companyId, long createdBy,
		long spMailCampaignId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addSubscriber(companyId, createdBy, spMailCampaignId, firstName,
			lastName, emailAddress);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailCampaignSubscribersLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailCampaignSubscribersLocalService.class.getName());

			if (invokableLocalService instanceof SPMailCampaignSubscribersLocalService) {
				_service = (SPMailCampaignSubscribersLocalService)invokableLocalService;
			}
			else {
				_service = new SPMailCampaignSubscribersLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPMailCampaignSubscribersLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailCampaignSubscribersLocalService service) {
	}

	private static SPMailCampaignSubscribersLocalService _service;
}