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

package com.sambaash.platform.srv.spshopping.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spshopping.model.SPDiscount;

/**
 * The persistence interface for the s p discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPDiscountPersistenceImpl
 * @see SPDiscountUtil
 * @generated
 */
public interface SPDiscountPersistence extends BasePersistence<SPDiscount> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPDiscountUtil} to access the s p discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p discounts where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findBypackageId(
		long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p discounts where packageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param packageId the package ID
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @return the range of matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findBypackageId(
		long packageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p discounts where packageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param packageId the package ID
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findBypackageId(
		long packageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p discount in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount findBypackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Returns the first s p discount in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p discount, or <code>null</code> if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount fetchBypackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p discount in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount findBypackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Returns the last s p discount in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p discount, or <code>null</code> if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount fetchBypackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p discounts before and after the current s p discount in the ordered set where packageId = &#63;.
	*
	* @param spDiscountId the primary key of the current s p discount
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount[] findBypackageId_PrevAndNext(
		long spDiscountId, long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Removes all the s p discounts where packageId = &#63; from the database.
	*
	* @param packageId the package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypackageId(long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p discounts where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the number of matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countBypackageId(long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p discounts where active = &#63;.
	*
	* @param active the active
	* @return the matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findByactive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p discounts where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @return the range of matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p discounts where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p discount in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount findByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Returns the first s p discount in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p discount, or <code>null</code> if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount fetchByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p discount in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount findByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Returns the last s p discount in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p discount, or <code>null</code> if a matching s p discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount fetchByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p discounts before and after the current s p discount in the ordered set where active = &#63;.
	*
	* @param spDiscountId the primary key of the current s p discount
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount[] findByactive_PrevAndNext(
		long spDiscountId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Removes all the s p discounts where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByactive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p discounts where active = &#63;.
	*
	* @param active the active
	* @return the number of matching s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByactive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p discount in the entity cache if it is enabled.
	*
	* @param spDiscount the s p discount
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount);

	/**
	* Caches the s p discounts in the entity cache if it is enabled.
	*
	* @param spDiscounts the s p discounts
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> spDiscounts);

	/**
	* Creates a new s p discount with the primary key. Does not add the s p discount to the database.
	*
	* @param spDiscountId the primary key for the new s p discount
	* @return the new s p discount
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount create(
		long spDiscountId);

	/**
	* Removes the s p discount with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spDiscountId the primary key of the s p discount
	* @return the s p discount that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount remove(
		long spDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	public com.sambaash.platform.srv.spshopping.model.SPDiscount updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p discount with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException} if it could not be found.
	*
	* @param spDiscountId the primary key of the s p discount
	* @return the s p discount
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount findByPrimaryKey(
		long spDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;

	/**
	* Returns the s p discount with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spDiscountId the primary key of the s p discount
	* @return the s p discount, or <code>null</code> if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPDiscount fetchByPrimaryKey(
		long spDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p discounts.
	*
	* @return the s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p discounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @return the range of s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p discounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p discounts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p discounts.
	*
	* @return the number of s p discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}