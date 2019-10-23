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
 * Provides a wrapper for {@link SPGroupUserLocalService}.
 *
 * @author harini
 * @see SPGroupUserLocalService
 * @generated
 */
public class SPGroupUserLocalServiceWrapper implements SPGroupUserLocalService,
	ServiceWrapper<SPGroupUserLocalService> {
	public SPGroupUserLocalServiceWrapper(
		SPGroupUserLocalService spGroupUserLocalService) {
		_spGroupUserLocalService = spGroupUserLocalService;
	}

	/**
	* Adds the s p group user to the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUser the s p group user
	* @return the s p group user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser addSPGroupUser(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.addSPGroupUser(spGroupUser);
	}

	/**
	* Creates a new s p group user with the primary key. Does not add the s p group user to the database.
	*
	* @param spGroupUserPK the primary key for the new s p group user
	* @return the new s p group user
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser createSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK) {
		return _spGroupUserLocalService.createSPGroupUser(spGroupUserPK);
	}

	/**
	* Deletes the s p group user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user that was removed
	* @throws PortalException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser deleteSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.deleteSPGroupUser(spGroupUserPK);
	}

	/**
	* Deletes the s p group user from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUser the s p group user
	* @return the s p group user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser deleteSPGroupUser(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.deleteSPGroupUser(spGroupUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spGroupUserLocalService.dynamicQuery();
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
		return _spGroupUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spGroupUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spGroupUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spGroupUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spGroupUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.fetchSPGroupUser(spGroupUserPK);
	}

	/**
	* Returns the s p group user with the primary key.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user
	* @throws PortalException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser getSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.getSPGroupUser(spGroupUserPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p group users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @return the range of s p group users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> getSPGroupUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.getSPGroupUsers(start, end);
	}

	/**
	* Returns the number of s p group users.
	*
	* @return the number of s p group users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPGroupUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.getSPGroupUsersCount();
	}

	/**
	* Updates the s p group user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spGroupUser the s p group user
	* @return the s p group user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUser(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.updateSPGroupUser(spGroupUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spGroupUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spGroupUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spGroupUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser addSPGroupUser(
		long spGroupId, long userId, int role, int status,
		java.lang.Long groupId, java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.addSPGroupUser(spGroupId, userId, role,
			status, groupId, companyId);
	}

	@Override
	public int countBySPGroupId(long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.countBySPGroupId(spGroupId);
	}

	@Override
	public int countBySPGroupIdAndRole(long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.countBySPGroupIdAndRole(spGroupId, role);
	}

	@Override
	public int countBySPGroupIdAndStatus(long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.countBySPGroupIdAndStatus(spGroupId,
			status);
	}

	@Override
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.countByUserId(userId);
	}

	@Override
	public int countByUserIdAndGroupIdAndStatus(long userId, long spGroupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.countByUserIdAndGroupIdAndStatus(userId,
			spGroupId, status);
	}

	@Override
	public int countByUserIdAndStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.countByUserIdAndStatus(userId, status);
	}

	@Override
	public void deleteSPGroupUser(long spGroupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spGroupUserLocalService.deleteSPGroupUser(spGroupId, userId);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.fetchByUserIdAndGroupIdAndStatus(userId,
			spGroupId, status);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.fetchByUserIdAndGroupIdAndStatus(userId,
			spGroupId, status, retrieveFromCache);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.service.SPGroupUserLocalServiceUtil} to
	* access the s p group user local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupId(spGroupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupId(spGroupId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupId(spGroupId, start, end,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupId_First(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findBySPGroupId_First(spGroupId,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupId_Last(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findBySPGroupId_Last(spGroupId,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupId_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findBySPGroupId_PrevAndNext(spGroupUserPK,
			spGroupId, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupIdAndRole(spGroupId, role);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupIdAndRole(spGroupId, role,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupIdAndRole(spGroupId, role,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupIdAndStatus(spGroupId,
			status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupIdAndStatus(spGroupId,
			status, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findBySPGroupIdAndStatus(spGroupId,
			status, start, end, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndStatus_First(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findBySPGroupIdAndStatus_First(spGroupId,
			status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndStatus_Last(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findBySPGroupIdAndStatus_Last(spGroupId,
			status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupIdAndStatus_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findBySPGroupIdAndStatus_PrevAndNext(spGroupUserPK,
			spGroupId, status, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findByUserId(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findByUserId(userId, start, end,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserId_First(userId,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserId_Last(userId,
			orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findByUserId_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserId_PrevAndNext(spGroupUserPK,
			userId, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserIdAndGroupIdAndStatus(userId,
			spGroupId, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findByUserIdAndStatus(userId, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findByUserIdAndStatus(userId, status,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.findByUserIdAndStatus(userId, status,
			start, end, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserIdAndStatus_First(userId,
			status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserIdAndStatus_Last(userId,
			status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findByUserIdAndStatus_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException {
		return _spGroupUserLocalService.findByUserIdAndStatus_PrevAndNext(spGroupUserPK,
			userId, status, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUser(
		long spGroupId, long userId, int role, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.updateSPGroupUser(spGroupId, userId,
			role, status);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUserRole(
		long spGroupId, long userId, int role)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.updateSPGroupUserRole(spGroupId,
			userId, role);
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUserStatus(
		long spGroupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUserLocalService.updateSPGroupUserStatus(spGroupId,
			userId, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPGroupUserLocalService getWrappedSPGroupUserLocalService() {
		return _spGroupUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPGroupUserLocalService(
		SPGroupUserLocalService spGroupUserLocalService) {
		_spGroupUserLocalService = spGroupUserLocalService;
	}

	@Override
	public SPGroupUserLocalService getWrappedService() {
		return _spGroupUserLocalService;
	}

	@Override
	public void setWrappedService(
		SPGroupUserLocalService spGroupUserLocalService) {
		_spGroupUserLocalService = spGroupUserLocalService;
	}

	private SPGroupUserLocalService _spGroupUserLocalService;
}