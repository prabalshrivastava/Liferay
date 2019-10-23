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
 * Provides the local service utility for SPMailUnsubscribe. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailUnsubscribeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribeLocalService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailUnsubscribeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailUnsubscribeLocalServiceImpl
 * @generated
 */
public class SPMailUnsubscribeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailUnsubscribeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p mail unsubscribe to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	* @return the s p mail unsubscribe that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe addSPMailUnsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPMailUnsubscribe(spMailUnsubscribe);
	}

	/**
	* Creates a new s p mail unsubscribe with the primary key. Does not add the s p mail unsubscribe to the database.
	*
	* @param spMailUnsubscribeId the primary key for the new s p mail unsubscribe
	* @return the new s p mail unsubscribe
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe createSPMailUnsubscribe(
		long spMailUnsubscribeId) {
		return getService().createSPMailUnsubscribe(spMailUnsubscribeId);
	}

	/**
	* Deletes the s p mail unsubscribe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe that was removed
	* @throws PortalException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe deleteSPMailUnsubscribe(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailUnsubscribe(spMailUnsubscribeId);
	}

	/**
	* Deletes the s p mail unsubscribe from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe deleteSPMailUnsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailUnsubscribe(spMailUnsubscribe);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchSPMailUnsubscribe(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPMailUnsubscribe(spMailUnsubscribeId);
	}

	/**
	* Returns the s p mail unsubscribe with the primary key.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe
	* @throws PortalException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe getSPMailUnsubscribe(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailUnsubscribe(spMailUnsubscribeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> getSPMailUnsubscribes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailUnsubscribes(start, end);
	}

	/**
	* Returns the number of s p mail unsubscribes.
	*
	* @return the number of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPMailUnsubscribesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailUnsubscribesCount();
	}

	/**
	* Updates the s p mail unsubscribe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	* @return the s p mail unsubscribe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe updateSPMailUnsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPMailUnsubscribe(spMailUnsubscribe);
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

	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddress(
		java.lang.String emailAddress) {
		return getService().findByEmailAddress(emailAddress);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getService()
				   .findByEmailAddressAndCategoryId(emailAddress, categoryId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByUserId(
		long userId) {
		return getService().findByUserId(userId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil} to access the s p mail unsubscribe
	* local service.
	*/
	public static void unsubscribe(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign) {
		getService().unsubscribe(subscriber, campaign);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailUnsubscribeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailUnsubscribeLocalService.class.getName());

			if (invokableLocalService instanceof SPMailUnsubscribeLocalService) {
				_service = (SPMailUnsubscribeLocalService)invokableLocalService;
			}
			else {
				_service = new SPMailUnsubscribeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPMailUnsubscribeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailUnsubscribeLocalService service) {
	}

	private static SPMailUnsubscribeLocalService _service;
}