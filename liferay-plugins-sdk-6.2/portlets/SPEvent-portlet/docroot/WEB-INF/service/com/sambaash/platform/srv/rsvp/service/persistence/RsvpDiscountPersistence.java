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

package com.sambaash.platform.srv.rsvp.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.rsvp.model.RsvpDiscount;

/**
 * The persistence interface for the rsvp discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDiscountPersistenceImpl
 * @see RsvpDiscountUtil
 * @generated
 */
public interface RsvpDiscountPersistence extends BasePersistence<RsvpDiscount> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RsvpDiscountUtil} to access the rsvp discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rsvp discounts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp discounts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @return the range of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp discounts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp discount in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the first rsvp discount in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp discount in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the last rsvp discount in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp discounts before and after the current rsvp discount in the ordered set where uuid = &#63;.
	*
	* @param rsvpDiscountId the primary key of the current rsvp discount
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount[] findByUuid_PrevAndNext(
		long rsvpDiscountId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Removes all the rsvp discounts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp discounts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp discount where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the rsvp discount where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp discount where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp discount where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp discount that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the number of rsvp discounts where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp discounts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp discounts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @return the range of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp discounts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the first rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the last rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp discounts before and after the current rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param rsvpDiscountId the primary key of the current rsvp discount
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount[] findByUuid_C_PrevAndNext(
		long rsvpDiscountId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Removes all the rsvp discounts where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp discounts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp discounts where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp discounts where rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @return the range of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByrsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp discounts where rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findByrsvpId(
		long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp discount in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByrsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the first rsvp discount in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByrsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp discount in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByrsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the last rsvp discount in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByrsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp discounts before and after the current rsvp discount in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpDiscountId the primary key of the current rsvp discount
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount[] findByrsvpId_PrevAndNext(
		long rsvpDiscountId, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Removes all the rsvp discounts where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp discounts where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rsvp discount in the entity cache if it is enabled.
	*
	* @param rsvpDiscount the rsvp discount
	*/
	public void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpDiscount rsvpDiscount);

	/**
	* Caches the rsvp discounts in the entity cache if it is enabled.
	*
	* @param rsvpDiscounts the rsvp discounts
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> rsvpDiscounts);

	/**
	* Creates a new rsvp discount with the primary key. Does not add the rsvp discount to the database.
	*
	* @param rsvpDiscountId the primary key for the new rsvp discount
	* @return the new rsvp discount
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount create(
		long rsvpDiscountId);

	/**
	* Removes the rsvp discount with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDiscountId the primary key of the rsvp discount
	* @return the rsvp discount that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount remove(
		long rsvpDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpDiscount rsvpDiscount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp discount with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException} if it could not be found.
	*
	* @param rsvpDiscountId the primary key of the rsvp discount
	* @return the rsvp discount
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount findByPrimaryKey(
		long rsvpDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;

	/**
	* Returns the rsvp discount with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpDiscountId the primary key of the rsvp discount
	* @return the rsvp discount, or <code>null</code> if a rsvp discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount fetchByPrimaryKey(
		long rsvpDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp discounts.
	*
	* @return the rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp discounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @return the range of rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp discounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp discounts
	* @param end the upper bound of the range of rsvp discounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rsvp discounts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp discounts.
	*
	* @return the number of rsvp discounts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}