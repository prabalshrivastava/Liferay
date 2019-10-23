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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.genericsearch.model.GSFavourite;

import java.util.List;

/**
 * The persistence utility for the g s favourite service. This utility wraps {@link GSFavouritePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see GSFavouritePersistence
 * @see GSFavouritePersistenceImpl
 * @generated
 */
public class GSFavouriteUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GSFavourite gsFavourite) {
		getPersistence().clearCache(gsFavourite);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GSFavourite> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GSFavourite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GSFavourite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GSFavourite update(GSFavourite gsFavourite)
		throws SystemException {
		return getPersistence().update(gsFavourite);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GSFavourite update(GSFavourite gsFavourite,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gsFavourite, serviceContext);
	}

	/**
	* Returns all the g s favourites where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedBy(
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatedBy(createdBy);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedBy(
		long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedBy(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatedBy(createdBy, start, end, orderByComparator);
	}

	/**
	* Returns the first g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedBy_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findBycreatedBy_First(createdBy, orderByComparator);
	}

	/**
	* Returns the first g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedBy_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatedBy_First(createdBy, orderByComparator);
	}

	/**
	* Returns the last g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedBy_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findBycreatedBy_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the last g s favourite in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedBy_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatedBy_Last(createdBy, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite[] findBycreatedBy_PrevAndNext(
		long SPGSFavouriteId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findBycreatedBy_PrevAndNext(SPGSFavouriteId, createdBy,
			orderByComparator);
	}

	/**
	* Removes all the g s favourites where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreatedBy(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycreatedBy(createdBy);
	}

	/**
	* Returns the number of g s favourites where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreatedBy(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycreatedBy(createdBy);
	}

	/**
	* Returns all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedByLayoutIdPermissionType_First(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findBycreatedByLayoutIdPermissionType_First(createdBy,
			layoutId, permissionType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedByLayoutIdPermissionType_First(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatedByLayoutIdPermissionType_First(createdBy,
			layoutId, permissionType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findBycreatedByLayoutIdPermissionType_Last(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findBycreatedByLayoutIdPermissionType_Last(createdBy,
			layoutId, permissionType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchBycreatedByLayoutIdPermissionType_Last(
		long createdBy, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatedByLayoutIdPermissionType_Last(createdBy,
			layoutId, permissionType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite[] findBycreatedByLayoutIdPermissionType_PrevAndNext(
		long SPGSFavouriteId, long createdBy, long layoutId,
		int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findBycreatedByLayoutIdPermissionType_PrevAndNext(SPGSFavouriteId,
			createdBy, layoutId, permissionType, orderByComparator);
	}

	/**
	* Removes all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63; from the database.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreatedByLayoutIdPermissionType(long createdBy,
		long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType);
	}

	/**
	* Returns the number of g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	*
	* @param createdBy the created by
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the number of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreatedByLayoutIdPermissionType(long createdBy,
		long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType);
	}

	/**
	* Returns all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByLayoutIdPermissionType(
		long layoutId, int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLayoutIdPermissionType(layoutId, permissionType);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByLayoutIdPermissionType(
		long layoutId, int permissionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLayoutIdPermissionType(layoutId, permissionType,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByLayoutIdPermissionType(
		long layoutId, int permissionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLayoutIdPermissionType(layoutId, permissionType,
			start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findByLayoutIdPermissionType_First(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findByLayoutIdPermissionType_First(layoutId,
			permissionType, orderByComparator);
	}

	/**
	* Returns the first g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchByLayoutIdPermissionType_First(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLayoutIdPermissionType_First(layoutId,
			permissionType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findByLayoutIdPermissionType_Last(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findByLayoutIdPermissionType_Last(layoutId, permissionType,
			orderByComparator);
	}

	/**
	* Returns the last g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchByLayoutIdPermissionType_Last(
		long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLayoutIdPermissionType_Last(layoutId,
			permissionType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite[] findByLayoutIdPermissionType_PrevAndNext(
		long SPGSFavouriteId, long layoutId, int permissionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence()
				   .findByLayoutIdPermissionType_PrevAndNext(SPGSFavouriteId,
			layoutId, permissionType, orderByComparator);
	}

	/**
	* Removes all the g s favourites where layoutId = &#63; and permissionType = &#63; from the database.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLayoutIdPermissionType(long layoutId,
		int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLayoutIdPermissionType(layoutId, permissionType);
	}

	/**
	* Returns the number of g s favourites where layoutId = &#63; and permissionType = &#63;.
	*
	* @param layoutId the layout ID
	* @param permissionType the permission type
	* @return the number of matching g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLayoutIdPermissionType(long layoutId,
		int permissionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLayoutIdPermissionType(layoutId, permissionType);
	}

	/**
	* Caches the g s favourite in the entity cache if it is enabled.
	*
	* @param gsFavourite the g s favourite
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite) {
		getPersistence().cacheResult(gsFavourite);
	}

	/**
	* Caches the g s favourites in the entity cache if it is enabled.
	*
	* @param gsFavourites the g s favourites
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> gsFavourites) {
		getPersistence().cacheResult(gsFavourites);
	}

	/**
	* Creates a new g s favourite with the primary key. Does not add the g s favourite to the database.
	*
	* @param SPGSFavouriteId the primary key for the new g s favourite
	* @return the new g s favourite
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite create(
		long SPGSFavouriteId) {
		return getPersistence().create(SPGSFavouriteId);
	}

	/**
	* Removes the g s favourite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite that was removed
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite remove(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence().remove(SPGSFavouriteId);
	}

	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite updateImpl(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gsFavourite);
	}

	/**
	* Returns the g s favourite with the primary key or throws a {@link com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException} if it could not be found.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite
	* @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite findByPrimaryKey(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException {
		return getPersistence().findByPrimaryKey(SPGSFavouriteId);
	}

	/**
	* Returns the g s favourite with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite, or <code>null</code> if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchByPrimaryKey(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(SPGSFavouriteId);
	}

	/**
	* Returns all the g s favourites.
	*
	* @return the g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g s favourites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g s favourites.
	*
	* @return the number of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GSFavouritePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GSFavouritePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.genericsearch.service.ClpSerializer.getServletContextName(),
					GSFavouritePersistence.class.getName());

			ReferenceRegistry.registerReference(GSFavouriteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GSFavouritePersistence persistence) {
	}

	private static GSFavouritePersistence _persistence;
}