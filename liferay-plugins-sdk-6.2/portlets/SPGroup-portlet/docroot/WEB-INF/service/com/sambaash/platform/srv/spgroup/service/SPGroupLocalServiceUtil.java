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

package com.sambaash.platform.srv.spgroup.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPGroup. This utility wraps
 * {@link com.sambaash.platform.srv.spgroup.service.impl.SPGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see SPGroupLocalService
 * @see com.sambaash.platform.srv.spgroup.service.base.SPGroupLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spgroup.service.impl.SPGroupLocalServiceImpl
 * @generated
 */
public class SPGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spgroup.service.impl.SPGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p group to the database. Also notifies the appropriate model listeners.
	*
	* @param spGroup the s p group
	* @return the s p group that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup addSPGroup(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPGroup(spGroup);
	}

	/**
	* Creates a new s p group with the primary key. Does not add the s p group to the database.
	*
	* @param spGroupId the primary key for the new s p group
	* @return the new s p group
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup createSPGroup(
		long spGroupId) {
		return getService().createSPGroup(spGroupId);
	}

	/**
	* Deletes the s p group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group that was removed
	* @throws PortalException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup deleteSPGroup(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPGroup(spGroupId);
	}

	/**
	* Deletes the s p group from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroup the s p group
	* @return the s p group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup deleteSPGroup(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPGroup(spGroup);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spgroup.model.SPGroup fetchSPGroup(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPGroup(spGroupId);
	}

	/**
	* Returns the s p group with the matching UUID and company.
	*
	* @param uuid the s p group's UUID
	* @param companyId the primary key of the company
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup fetchSPGroupByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPGroupByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p group matching the UUID and group.
	*
	* @param uuid the s p group's UUID
	* @param groupId the primary key of the group
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup fetchSPGroupByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPGroupByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p group with the primary key.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group
	* @throws PortalException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup getSPGroup(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPGroup(spGroupId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p group with the matching UUID and company.
	*
	* @param uuid the s p group's UUID
	* @param companyId the primary key of the company
	* @return the matching s p group
	* @throws PortalException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup getSPGroupByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPGroupByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p group matching the UUID and group.
	*
	* @param uuid the s p group's UUID
	* @param groupId the primary key of the group
	* @return the matching s p group
	* @throws PortalException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup getSPGroupByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPGroupByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of s p groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> getSPGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPGroups(start, end);
	}

	/**
	* Returns the number of s p groups.
	*
	* @return the number of s p groups
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPGroupsCount();
	}

	/**
	* Updates the s p group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spGroup the s p group
	* @return the s p group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroup updateSPGroup(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPGroup(spGroup);
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

	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserIdAndStatus(userId, status);
	}

	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserIdAndStatus(userId, status, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserIdAndStatus(userId, status, start, end,
			orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup findByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService()
				   .findByUserIdAndStatus_First(userId, status,
			orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup findByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService()
				   .findByUserIdAndStatus_Last(userId, status, orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup[] findByUserIdAndStatus_PrevAndNext(
		long spGroupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService()
				   .findByUserIdAndStatus_PrevAndNext(spGroupId, userId,
			status, orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup findByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService().findByURLTitleAndGroupId(groupId, urlTitle);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup fetchByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByURLTitleAndGroupId(groupId, urlTitle);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup fetchByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchByURLTitleAndGroupId(groupId, urlTitle,
			retrieveFromCache);
	}

	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndStatus(type, status);
	}

	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndStatus(type, status, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByTypeAndStatus(type, status, start, end,
			orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup findByTypeAndStatus_First(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService()
				   .findByTypeAndStatus_First(type, status, orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup findByTypeAndStatus_Last(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService()
				   .findByTypeAndStatus_Last(type, status, orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup[] findByTypeAndStatus_PrevAndNext(
		long spGroupId, int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return getService()
				   .findByTypeAndStatus_PrevAndNext(spGroupId, type, status,
			orderByComparator);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup addSPGroup(
		long userId, int type, java.lang.String title,
		java.lang.String description, int status,
		java.lang.String imageFileName, java.io.InputStream imageInputStream,
		long imageMaxSize, java.lang.String[] imageExtensions,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSPGroup(userId, type, title, description, status,
			imageFileName, imageInputStream, imageMaxSize, imageExtensions,
			serviceContext);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroup updateSPGroup(
		long userId, long spGroupId, int type, java.lang.String title,
		java.lang.String description, int status,
		java.lang.String imageFileName, java.io.InputStream imageInputStream,
		long imageMaxSize, java.lang.String[] imageExtensions,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSPGroup(userId, spGroupId, type, title, description,
			status, imageFileName, imageInputStream, imageMaxSize,
			imageExtensions, serviceContext);
	}

	public static void updateAsset(long userId,
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, spGroup, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static void sendSoicalNetworkInvitation(
		java.lang.String[] snIdArray, java.lang.String body)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().sendSoicalNetworkInvitation(snIdArray, body);
	}

	public static java.lang.String pushRealtimeActivityFeed(
		com.sambaash.platform.model.notification.NotificationForm notificationForm) {
		return getService().pushRealtimeActivityFeed(notificationForm);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPGroupLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPGroupLocalService.class.getName());

			if (invokableLocalService instanceof SPGroupLocalService) {
				_service = (SPGroupLocalService)invokableLocalService;
			}
			else {
				_service = new SPGroupLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPGroupLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPGroupLocalService service) {
	}

	private static SPGroupLocalService _service;
}