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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for SPGroupUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author harini
 * @see SPGroupUserLocalServiceUtil
 * @see com.sambaash.platform.srv.spgroup.service.base.SPGroupUserLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spgroup.service.impl.SPGroupUserLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPGroupUserLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPGroupUserLocalServiceUtil} to access the s p group user local service. Add custom service methods to {@link com.sambaash.platform.srv.spgroup.service.impl.SPGroupUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the s p group user to the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUser the s p group user
	* @return the s p group user that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser addSPGroupUser(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new s p group user with the primary key. Does not add the s p group user to the database.
	*
	* @param spGroupUserPK the primary key for the new s p group user
	* @return the new s p group user
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser createSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK);

	/**
	* Deletes the s p group user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user that was removed
	* @throws PortalException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser deleteSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the s p group user from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUser the s p group user
	* @return the s p group user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser deleteSPGroupUser(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group user with the primary key.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user
	* @throws PortalException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser getSPGroupUser(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> getSPGroupUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users.
	*
	* @return the number of s p group users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSPGroupUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the s p group user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spGroupUser the s p group user
	* @return the s p group user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUser(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser addSPGroupUser(
		long spGroupId, long userId, int role, int status,
		java.lang.Long groupId, java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countBySPGroupId(long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySPGroupIdAndRole(long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySPGroupIdAndStatus(long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByUserIdAndGroupIdAndStatus(long userId, long spGroupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	public int countByUserIdAndStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteSPGroupUser(long spGroupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.service.SPGroupUserLocalServiceUtil} to
	* access the s p group user local service.
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupId_First(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupId_Last(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupId_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndStatus_First(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndStatus_Last(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupIdAndStatus_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findByUserId_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findByUserIdAndStatus_PrevAndNext(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK spGroupUserPK,
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUser(
		long spGroupId, long userId, int role, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUserRole(
		long spGroupId, long userId, int role)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateSPGroupUserStatus(
		long spGroupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}