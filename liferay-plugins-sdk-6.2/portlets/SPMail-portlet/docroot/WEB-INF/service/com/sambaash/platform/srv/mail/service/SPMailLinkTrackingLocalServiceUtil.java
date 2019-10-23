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
 * Provides the local service utility for SPMailLinkTracking. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailLinkTrackingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTrackingLocalService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailLinkTrackingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailLinkTrackingLocalServiceImpl
 * @generated
 */
public class SPMailLinkTrackingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailLinkTrackingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p mail link tracking to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTracking the s p mail link tracking
	* @return the s p mail link tracking that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking addSPMailLinkTracking(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPMailLinkTracking(spMailLinkTracking);
	}

	/**
	* Creates a new s p mail link tracking with the primary key. Does not add the s p mail link tracking to the database.
	*
	* @param spMailLinkTrackingId the primary key for the new s p mail link tracking
	* @return the new s p mail link tracking
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking createSPMailLinkTracking(
		long spMailLinkTrackingId) {
		return getService().createSPMailLinkTracking(spMailLinkTrackingId);
	}

	/**
	* Deletes the s p mail link tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking that was removed
	* @throws PortalException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking deleteSPMailLinkTracking(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailLinkTracking(spMailLinkTrackingId);
	}

	/**
	* Deletes the s p mail link tracking from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTracking the s p mail link tracking
	* @return the s p mail link tracking that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking deleteSPMailLinkTracking(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailLinkTracking(spMailLinkTracking);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchSPMailLinkTracking(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPMailLinkTracking(spMailLinkTrackingId);
	}

	/**
	* Returns the s p mail link tracking with the primary key.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking
	* @throws PortalException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking getSPMailLinkTracking(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailLinkTracking(spMailLinkTrackingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> getSPMailLinkTrackings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailLinkTrackings(start, end);
	}

	/**
	* Returns the number of s p mail link trackings.
	*
	* @return the number of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPMailLinkTrackingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailLinkTrackingsCount();
	}

	/**
	* Updates the s p mail link tracking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTracking the s p mail link tracking
	* @return the s p mail link tracking that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking updateSPMailLinkTracking(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPMailLinkTracking(spMailLinkTracking);
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

	public static java.util.List<java.lang.Object[]> countOpenedMailByLink(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countOpenedMailByLink(spMailCampaignId);
	}

	public static java.util.List<java.lang.Object[]> countOpenedMailByLink(
		long spMailCampaignId, long mailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countOpenedMailByLink(spMailCampaignId, mailType);
	}

	public static java.util.List<java.lang.Object[]> getMailLinkInteractionCount(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getMailLinkInteractionCount(spMailCampaignId,
			spMailCampaignSubscribersId);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long campaignId, long subscriberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdAndSubscribersId(campaignId, subscriberId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil} to access the s p mail link tracking
	* local service.
	*/
	public static void trackLink(long trackingId) {
		getService().trackLink(trackingId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailLinkTrackingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailLinkTrackingLocalService.class.getName());

			if (invokableLocalService instanceof SPMailLinkTrackingLocalService) {
				_service = (SPMailLinkTrackingLocalService)invokableLocalService;
			}
			else {
				_service = new SPMailLinkTrackingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPMailLinkTrackingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailLinkTrackingLocalService service) {
	}

	private static SPMailLinkTrackingLocalService _service;
}