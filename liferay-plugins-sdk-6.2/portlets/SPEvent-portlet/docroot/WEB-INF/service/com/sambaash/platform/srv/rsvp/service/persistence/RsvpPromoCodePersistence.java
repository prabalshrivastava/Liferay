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

import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;

/**
 * The persistence interface for the rsvp promo code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCodePersistenceImpl
 * @see RsvpPromoCodeUtil
 * @generated
 */
public interface RsvpPromoCodePersistence extends BasePersistence<RsvpPromoCode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RsvpPromoCodeUtil} to access the rsvp promo code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rsvp promo codes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp promo codes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @return the range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp promo codes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param rsvpPromoCodeId the primary key of the current rsvp promo code
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByUuid_PrevAndNext(
		long rsvpPromoCodeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Removes all the rsvp promo codes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp promo codes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp promo code where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp promo code that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the number of rsvp promo codes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @return the range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param rsvpPromoCodeId the primary key of the current rsvp promo code
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByUuid_C_PrevAndNext(
		long rsvpPromoCodeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Removes all the rsvp promo codes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp promo codes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp promo codes where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp promo codes where rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @return the range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp promo codes where rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByrsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the first rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByrsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByrsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the last rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByrsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpPromoCodeId the primary key of the current rsvp promo code
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByrsvpId_PrevAndNext(
		long rsvpPromoCodeId, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Removes all the rsvp promo codes where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp promo codes where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public int countByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp promo codes where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp promo codes where promoCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param promoCode the promo code
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @return the range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp promo codes where promoCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param promoCode the promo code
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByPromoCode_First(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the first rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByPromoCode_First(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByPromoCode_Last(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the last rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByPromoCode_Last(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param rsvpPromoCodeId the primary key of the current rsvp promo code
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByPromoCode_PrevAndNext(
		long rsvpPromoCodeId, java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Removes all the rsvp promo codes where promoCode = &#63; from the database.
	*
	* @param promoCode the promo code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPromoCode(java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp promo codes where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public int countByPromoCode(java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rsvp promo code in the entity cache if it is enabled.
	*
	* @param rsvpPromoCode the rsvp promo code
	*/
	public void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode);

	/**
	* Caches the rsvp promo codes in the entity cache if it is enabled.
	*
	* @param rsvpPromoCodes the rsvp promo codes
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> rsvpPromoCodes);

	/**
	* Creates a new rsvp promo code with the primary key. Does not add the rsvp promo code to the database.
	*
	* @param rsvpPromoCodeId the primary key for the new rsvp promo code
	* @return the new rsvp promo code
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode create(
		long rsvpPromoCodeId);

	/**
	* Removes the rsvp promo code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode remove(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp promo code with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException} if it could not be found.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByPrimaryKey(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;

	/**
	* Returns the rsvp promo code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code, or <code>null</code> if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByPrimaryKey(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp promo codes.
	*
	* @return the rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp promo codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @return the range of rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp promo codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rsvp promo codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp promo codes.
	*
	* @return the number of rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}