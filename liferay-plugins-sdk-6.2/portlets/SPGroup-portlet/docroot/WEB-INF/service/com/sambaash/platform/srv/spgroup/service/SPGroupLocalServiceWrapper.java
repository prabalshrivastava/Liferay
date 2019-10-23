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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPGroupLocalService}.
 *
 * @author harini
 * @see SPGroupLocalService
 * @generated
 */
public class SPGroupLocalServiceWrapper implements SPGroupLocalService,
	ServiceWrapper<SPGroupLocalService> {
	public SPGroupLocalServiceWrapper(SPGroupLocalService spGroupLocalService) {
		_spGroupLocalService = spGroupLocalService;
	}

	/**
	* Adds the s p group to the database. Also notifies the appropriate model listeners.
	*
	* @param spGroup the s p group
	* @return the s p group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup addSPGroup(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.addSPGroup(spGroup);
	}

	/**
	* Creates a new s p group with the primary key. Does not add the s p group to the database.
	*
	* @param spGroupId the primary key for the new s p group
	* @return the new s p group
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup createSPGroup(
		long spGroupId) {
		return _spGroupLocalService.createSPGroup(spGroupId);
	}

	/**
	* Deletes the s p group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group that was removed
	* @throws PortalException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup deleteSPGroup(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.deleteSPGroup(spGroupId);
	}

	/**
	* Deletes the s p group from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroup the s p group
	* @return the s p group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup deleteSPGroup(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.deleteSPGroup(spGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spGroupLocalService.dynamicQuery();
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
		return _spGroupLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _spGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spGroupLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchSPGroup(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.fetchSPGroup(spGroupId);
	}

	/**
	* Returns the s p group with the matching UUID and company.
	*
	* @param uuid the s p group's UUID
	* @param companyId the primary key of the company
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchSPGroupByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.fetchSPGroupByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p group matching the UUID and group.
	*
	* @param uuid the s p group's UUID
	* @param groupId the primary key of the group
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchSPGroupByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.fetchSPGroupByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p group with the primary key.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group
	* @throws PortalException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup getSPGroup(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.getSPGroup(spGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup getSPGroupByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.getSPGroupByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup getSPGroupByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.getSPGroupByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> getSPGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.getSPGroups(start, end);
	}

	/**
	* Returns the number of s p groups.
	*
	* @return the number of s p groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.getSPGroupsCount();
	}

	/**
	* Updates the s p group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spGroup the s p group
	* @return the s p group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup updateSPGroup(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.updateSPGroup(spGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spGroupLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.findByUserIdAndStatus(userId, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.findByUserIdAndStatus(userId, status,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.findByUserIdAndStatus(userId, status,
			start, end, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByUserIdAndStatus_First(userId, status,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByUserIdAndStatus_Last(userId, status,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByUserIdAndStatus_PrevAndNext(
		long spGroupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByUserIdAndStatus_PrevAndNext(spGroupId,
			userId, status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByURLTitleAndGroupId(groupId, urlTitle);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.fetchByURLTitleAndGroupId(groupId, urlTitle);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.fetchByURLTitleAndGroupId(groupId,
			urlTitle, retrieveFromCache);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.findByTypeAndStatus(type, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.findByTypeAndStatus(type, status, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.findByTypeAndStatus(type, status, start,
			end, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByTypeAndStatus_First(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByTypeAndStatus_First(type, status,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByTypeAndStatus_Last(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByTypeAndStatus_Last(type, status,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByTypeAndStatus_PrevAndNext(
		long spGroupId, int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException {
		return _spGroupLocalService.findByTypeAndStatus_PrevAndNext(spGroupId,
			type, status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup addSPGroup(
		long userId, int type, java.lang.String title,
		java.lang.String description, int status,
		java.lang.String imageFileName, java.io.InputStream imageInputStream,
		long imageMaxSize, java.lang.String[] imageExtensions,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.addSPGroup(userId, type, title,
			description, status, imageFileName, imageInputStream, imageMaxSize,
			imageExtensions, serviceContext);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup updateSPGroup(
		long userId, long spGroupId, int type, java.lang.String title,
		java.lang.String description, int status,
		java.lang.String imageFileName, java.io.InputStream imageInputStream,
		long imageMaxSize, java.lang.String[] imageExtensions,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupLocalService.updateSPGroup(userId, spGroupId, type,
			title, description, status, imageFileName, imageInputStream,
			imageMaxSize, imageExtensions, serviceContext);
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spGroupLocalService.updateAsset(userId, spGroup, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public void sendSoicalNetworkInvitation(java.lang.String[] snIdArray,
		java.lang.String body)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spGroupLocalService.sendSoicalNetworkInvitation(snIdArray, body);
	}

	@Override
	public java.lang.String pushRealtimeActivityFeed(
		com.sambaash.platform.model.notification.NotificationForm notificationForm) {
		return _spGroupLocalService.pushRealtimeActivityFeed(notificationForm);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPGroupLocalService getWrappedSPGroupLocalService() {
		return _spGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPGroupLocalService(
		SPGroupLocalService spGroupLocalService) {
		_spGroupLocalService = spGroupLocalService;
	}

	@Override
	public SPGroupLocalService getWrappedService() {
		return _spGroupLocalService;
	}

	@Override
	public void setWrappedService(SPGroupLocalService spGroupLocalService) {
		_spGroupLocalService = spGroupLocalService;
	}

	private SPGroupLocalService _spGroupLocalService;
}