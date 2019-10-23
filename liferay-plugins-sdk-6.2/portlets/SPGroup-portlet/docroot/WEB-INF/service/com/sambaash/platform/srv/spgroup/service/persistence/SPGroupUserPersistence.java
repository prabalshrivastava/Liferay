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

package com.sambaash.platform.srv.spgroup.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spgroup.model.SPGroupUser;

/**
 * The persistence interface for the s p group user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPGroupUserPersistenceImpl
 * @see SPGroupUserUtil
 * @generated
 */
public interface SPGroupUserPersistence extends BasePersistence<SPGroupUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPGroupUserUtil} to access the s p group user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p group users where spGroupId = &#63;.
	*
	* @param spGroupId the sp group ID
	* @return the matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p group users where spGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spGroupId the sp group ID
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @return the range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p group users where spGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spGroupId the sp group ID
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupId(
		long spGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group user in the ordered set where spGroupId = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupId_First(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the first s p group user in the ordered set where spGroupId = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchBySPGroupId_First(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group user in the ordered set where spGroupId = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupId_Last(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the last s p group user in the ordered set where spGroupId = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchBySPGroupId_Last(
		long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group users before and after the current s p group user in the ordered set where spGroupId = &#63;.
	*
	* @param spGroupUserPK the primary key of the current s p group user
	* @param spGroupId the sp group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupId_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long spGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Removes all the s p group users where spGroupId = &#63; from the database.
	*
	* @param spGroupId the sp group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySPGroupId(long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users where spGroupId = &#63;.
	*
	* @param spGroupId the sp group ID
	* @return the number of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countBySPGroupId(long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p group users where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @return the matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p group users where spGroupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @return the range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p group users where spGroupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndStatus(
		long spGroupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndStatus_First(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the first s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchBySPGroupIdAndStatus_First(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndStatus_Last(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the last s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchBySPGroupIdAndStatus_Last(
		long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group users before and after the current s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupUserPK the primary key of the current s p group user
	* @param spGroupId the sp group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupIdAndStatus_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long spGroupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Removes all the s p group users where spGroupId = &#63; and status = &#63; from the database.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySPGroupIdAndStatus(long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users where spGroupId = &#63; and status = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param status the status
	* @return the number of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countBySPGroupIdAndStatus(long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p group users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p group users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @return the range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p group users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the first s p group user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the last s p group user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group users before and after the current s p group user in the ordered set where userId = &#63;.
	*
	* @param spGroupUserPK the primary key of the current s p group user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findByUserId_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Removes all the s p group users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p group users where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p group users where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @return the range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p group users where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findByUserIdAndStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group user in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the first s p group user in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group user in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the last s p group user in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group users before and after the current s p group user in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param spGroupUserPK the primary key of the current s p group user
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findByUserIdAndStatus_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Removes all the s p group users where userId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p group users where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @return the matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p group users where spGroupId = &#63; and role = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @return the range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p group users where spGroupId = &#63; and role = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findBySPGroupIdAndRole(
		long spGroupId, int role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndRole_First(
		long spGroupId, int role,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the first s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchBySPGroupIdAndRole_First(
		long spGroupId, int role,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findBySPGroupIdAndRole_Last(
		long spGroupId, int role,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the last s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchBySPGroupIdAndRole_Last(
		long spGroupId, int role,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group users before and after the current s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupUserPK the primary key of the current s p group user
	* @param spGroupId the sp group ID
	* @param role the role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser[] findBySPGroupIdAndRole_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long spGroupId, int role,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Removes all the s p group users where spGroupId = &#63; and role = &#63; from the database.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySPGroupIdAndRole(long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users where spGroupId = &#63; and role = &#63;.
	*
	* @param spGroupId the sp group ID
	* @param role the role
	* @return the number of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countBySPGroupIdAndRole(long spGroupId, int role)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchUserException} if it could not be found.
	*
	* @param userId the user ID
	* @param spGroupId the sp group ID
	* @param status the status
	* @return the matching s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param spGroupId the sp group ID
	* @param status the status
	* @return the matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param spGroupId the sp group ID
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p group user, or <code>null</code> if a matching s p group user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param spGroupId the sp group ID
	* @param status the status
	* @return the s p group user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser removeByUserIdAndGroupIdAndStatus(
		long userId, long spGroupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the number of s p group users where userId = &#63; and spGroupId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param spGroupId the sp group ID
	* @param status the status
	* @return the number of matching s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndGroupIdAndStatus(long userId, long spGroupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p group user in the entity cache if it is enabled.
	*
	* @param spGroupUser the s p group user
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser);

	/**
	* Caches the s p group users in the entity cache if it is enabled.
	*
	* @param spGroupUsers the s p group users
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> spGroupUsers);

	/**
	* Creates a new s p group user with the primary key. Does not add the s p group user to the database.
	*
	* @param spGroupUserPK the primary key for the new s p group user
	* @return the new s p group user
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser create(
		SPGroupUserPK spGroupUserPK);

	/**
	* Removes the s p group user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user that was removed
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser remove(
		SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	public com.sambaash.platform.srv.spgroup.model.SPGroupUser updateImpl(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group user with the primary key or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchUserException} if it could not be found.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user
	* @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser findByPrimaryKey(
		SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchUserException;

	/**
	* Returns the s p group user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spGroupUserPK the primary key of the s p group user
	* @return the s p group user, or <code>null</code> if a s p group user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser fetchByPrimaryKey(
		SPGroupUserPK spGroupUserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p group users.
	*
	* @return the s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p group users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p group users
	* @param end the upper bound of the range of s p group users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p group users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p group users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p group users.
	*
	* @return the number of s p group users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}