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

package com.sambaash.platform.srv.spasset.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spasset.model.SPAssetType;

/**
 * The persistence interface for the s p asset type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPAssetTypePersistenceImpl
 * @see SPAssetTypeUtil
 * @generated
 */
public interface SPAssetTypePersistence extends BasePersistence<SPAssetType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPAssetTypeUtil} to access the s p asset type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p asset types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p asset types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @return the range of matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p asset types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p asset type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Returns the first s p asset type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p asset type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Returns the last s p asset type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p asset types before and after the current s p asset type in the ordered set where groupId = &#63;.
	*
	* @param spAssetTypeId the primary key of the current s p asset type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType[] findByGroupId_PrevAndNext(
		long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Removes all the s p asset types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p asset types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p asset types where status = &#63;.
	*
	* @param status the status
	* @return the matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p asset types where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @return the range of matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p asset types where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p asset type in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Returns the first s p asset type in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p asset type in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Returns the last s p asset type in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p asset types before and after the current s p asset type in the ordered set where status = &#63;.
	*
	* @param spAssetTypeId the primary key of the current s p asset type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType[] findBystatus_PrevAndNext(
		long spAssetTypeId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Removes all the s p asset types where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p asset types where status = &#63;.
	*
	* @param status the status
	* @return the number of matching s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p asset type in the entity cache if it is enabled.
	*
	* @param spAssetType the s p asset type
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType);

	/**
	* Caches the s p asset types in the entity cache if it is enabled.
	*
	* @param spAssetTypes the s p asset types
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> spAssetTypes);

	/**
	* Creates a new s p asset type with the primary key. Does not add the s p asset type to the database.
	*
	* @param spAssetTypeId the primary key for the new s p asset type
	* @return the new s p asset type
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType create(
		long spAssetTypeId);

	/**
	* Removes the s p asset type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetTypeId the primary key of the s p asset type
	* @return the s p asset type that was removed
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType remove(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	public com.sambaash.platform.srv.spasset.model.SPAssetType updateImpl(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p asset type with the primary key or throws a {@link com.sambaash.platform.srv.spasset.NoSuchTypeException} if it could not be found.
	*
	* @param spAssetTypeId the primary key of the s p asset type
	* @return the s p asset type
	* @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType findByPrimaryKey(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchTypeException;

	/**
	* Returns the s p asset type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAssetTypeId the primary key of the s p asset type
	* @return the s p asset type, or <code>null</code> if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetType fetchByPrimaryKey(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p asset types.
	*
	* @return the s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p asset types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @return the range of s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p asset types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p asset types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p asset types.
	*
	* @return the number of s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}