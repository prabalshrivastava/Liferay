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

package com.sambaash.platform.srv.genericsearch.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.genericsearch.model.GSFavourite;

/**
 * The persistence interface for the g s favourite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see GSFavouritePersistenceImpl
 * @see GSFavouriteUtil
 * @generated
 */
public interface GSFavouritePersistence extends BasePersistence<GSFavourite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GSFavouriteUtil} to access the g s favourite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g s favourites where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedBy(
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g s favourites where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @return the range of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedBy(
		long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g s favourites where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedBy(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedBy_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the first g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedBy_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedBy_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the last g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedBy_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g s favourites before and after the current g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param SPGSFavouriteId the primary key of the current g s favourite
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite[] findBycreatedBy_PrevAndNext(
		long SPGSFavouriteId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Removes all the g s favourites where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreatedBy(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g s favourites where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreatedBy(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @return the range of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedByLayoutIdPermissionType_First(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the first g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedByLayoutIdPermissionType_First(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedByLayoutIdPermissionType_Last(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the last g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedByLayoutIdPermissionType_Last(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g s favourites before and after the current g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param SPGSFavouriteId the primary key of the current g s favourite
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite[] findBycreatedByLayoutIdPermissionType_PrevAndNext(
		long SPGSFavouriteId, long createdBy, long layoutId,
		int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Removes all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63; from the database.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreatedByLayoutIdPermissionType(long createdBy,
		long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the number of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreatedByLayoutIdPermissionType(long createdBy,
		long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByLayoutIdPermissionType(
		long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @return the range of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByLayoutIdPermissionType(
		long layoutId, int permissionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByLayoutIdPermissionType(
		long layoutId, int permissionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findByLayoutIdPermissionType_First(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the first g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchByLayoutIdPermissionType_First(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findByLayoutIdPermissionType_Last(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the last g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchByLayoutIdPermissionType_Last(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g s favourites before and after the current g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param SPGSFavouriteId the primary key of the current g s favourite
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite[] findByLayoutIdPermissionType_PrevAndNext(
		long SPGSFavouriteId, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Removes all the g s favourites where layoutId = &#63; and permissionType = &#63; from the database.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLayoutIdPermissionType(long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g s favourites where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the number of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public int countByLayoutIdPermissionType(long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g s favourite in the entity cache if it is enabled.
	*
	* @param gsFavourite the g s favourite
	*/
	public void cacheResult(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite);

	/**
	* Caches the g s favourites in the entity cache if it is enabled.
	*
	* @param gsFavourites the g s favourites
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> gsFavourites);

	/**
	* Creates a new g s favourite with the primary key. Does not add the g s favourite to the database.
	*
	* @param SPGSFavouriteId the primary key for the new g s favourite
	* @return the new g s favourite
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite create(
		long SPGSFavouriteId);

	/**
	* Removes the g s favourite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite that was removed
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite remove(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	public com.sambaash.platform.srv.genericsearch.model.GSFavourite updateImpl(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g s favourite with the primary key or throws a {@link com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException} if it could not be found.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite findByPrimaryKey(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;

	/**
	* Returns the g s favourite with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite, or <code>null</code> if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchByPrimaryKey(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g s favourites.
	*
	* @return the g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g s favourites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @return the range of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g s favourites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g s favourites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g s favourites.
	*
	* @return the number of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}