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
 * Provides the local service utility for SPMailBlackList. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailBlackListLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPMailBlackListLocalService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailBlackListLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailBlackListLocalServiceImpl
 * @generated
 */
public class SPMailBlackListLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailBlackListLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p mail black list to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailBlackList the s p mail black list
	* @return the s p mail black list that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList addSPMailBlackList(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPMailBlackList(spMailBlackList);
	}

	/**
	* Creates a new s p mail black list with the primary key. Does not add the s p mail black list to the database.
	*
	* @param spMailBlackListId the primary key for the new s p mail black list
	* @return the new s p mail black list
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList createSPMailBlackList(
		long spMailBlackListId) {
		return getService().createSPMailBlackList(spMailBlackListId);
	}

	/**
	* Deletes the s p mail black list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list that was removed
	* @throws PortalException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList deleteSPMailBlackList(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailBlackList(spMailBlackListId);
	}

	/**
	* Deletes the s p mail black list from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailBlackList the s p mail black list
	* @return the s p mail black list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList deleteSPMailBlackList(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPMailBlackList(spMailBlackList);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchSPMailBlackList(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPMailBlackList(spMailBlackListId);
	}

	/**
	* Returns the s p mail black list with the primary key.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list
	* @throws PortalException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList getSPMailBlackList(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailBlackList(spMailBlackListId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail black lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @return the range of s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> getSPMailBlackLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailBlackLists(start, end);
	}

	/**
	* Returns the number of s p mail black lists.
	*
	* @return the number of s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPMailBlackListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPMailBlackListsCount();
	}

	/**
	* Updates the s p mail black list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailBlackList the s p mail black list
	* @return the s p mail black list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList updateSPMailBlackList(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPMailBlackList(spMailBlackList);
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

	public static void addBounce(java.lang.String response,
		com.sambaash.platform.model.aws.Message message) {
		getService().addBounce(response, message);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil} to access the s p mail black list local
	* service.
	*/
	public static void addComplaint(java.lang.String response,
		com.sambaash.platform.model.aws.Message message) {
		getService().addComplaint(response, message);
	}

	public static int countByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

	public static int countByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCampaignIdAndBouncedSoft(spMailCampaignId,
			bounce_soft);
	}

	public static int countByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCampaignIdAndComplain(spMailCampaignId, complain);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCampaignId(spMailCampaignId);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft);
	}

	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCampaignIdAndComplain(spMailCampaignId, complain);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByEmailAddress(
		java.lang.String EmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getService().findByEmailAddress(EmailAddress);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailBlackListLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailBlackListLocalService.class.getName());

			if (invokableLocalService instanceof SPMailBlackListLocalService) {
				_service = (SPMailBlackListLocalService)invokableLocalService;
			}
			else {
				_service = new SPMailBlackListLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPMailBlackListLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailBlackListLocalService service) {
	}

	private static SPMailBlackListLocalService _service;
}