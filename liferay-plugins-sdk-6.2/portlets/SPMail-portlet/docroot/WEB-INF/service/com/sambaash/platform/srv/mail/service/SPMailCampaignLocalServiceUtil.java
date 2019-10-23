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
 * Provides the local service utility for SPMailCampaign. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailCampaignLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignLocalService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailCampaignLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailCampaignLocalServiceImpl
 * @generated
 */
public class SPMailCampaignLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailCampaignLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p mail campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaign the s p mail campaign
	* @return the s p mail campaign that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign addSPMailCampaign(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPMailCampaign(spMailCampaign);
	}

	/**
	* Creates a new s p mail campaign with the primary key. Does not add the s p mail campaign to the database.
	*
	* @param spMailCampaignId the primary key for the new s p mail campaign
	* @return the new s p mail campaign
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign createSPMailCampaign(
		long spMailCampaignId) {
		return getService().createSPMailCampaign(spMailCampaignId);
	}

	/**
	* Deletes the s p mail campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign that was removed
	* @throws PortalException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign deleteSPMailCampaign(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailCampaign(spMailCampaignId);
	}

	/**
	* Deletes the s p mail campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaign the s p mail campaign
	* @return the s p mail campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign deleteSPMailCampaign(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailCampaign(spMailCampaign);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchSPMailCampaign(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPMailCampaign(spMailCampaignId);
	}

	/**
	* Returns the s p mail campaign with the primary key.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign
	* @throws PortalException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign getSPMailCampaign(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailCampaign(spMailCampaignId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> getSPMailCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailCampaigns(start, end);
	}

	/**
	* Returns the number of s p mail campaigns.
	*
	* @return the number of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPMailCampaignsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailCampaignsCount();
	}

	/**
	* Updates the s p mail campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaign the s p mail campaign
	* @return the s p mail campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign updateSPMailCampaign(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPMailCampaign(spMailCampaign);
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

	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getService().findByCampaignName(campaignName);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil} to access the s p mail campaign local
	* service.
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByrsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getService().findByrsvpId(rsvpId);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> getActiveCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveCampaigns(start, end);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaign getCampaign(
		long campaignId) {
		return getService().getCampaign(campaignId);
	}

	public static void subscribeToCampaign(java.lang.String email,
		java.lang.String firstName, java.lang.String lastName, long campaignId,
		java.lang.String portalUrl) {
		getService()
			.subscribeToCampaign(email, firstName, lastName, campaignId,
			portalUrl);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailCampaignLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailCampaignLocalService.class.getName());

			if (invokableLocalService instanceof SPMailCampaignLocalService) {
				_service = (SPMailCampaignLocalService)invokableLocalService;
			}
			else {
				_service = new SPMailCampaignLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPMailCampaignLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailCampaignLocalService service) {
	}

	private static SPMailCampaignLocalService _service;
}