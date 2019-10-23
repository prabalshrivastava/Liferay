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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;

import java.util.List;

/**
 * The persistence utility for the rsvp promo code service. This utility wraps {@link RsvpPromoCodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCodePersistence
 * @see RsvpPromoCodePersistenceImpl
 * @generated
 */
public class RsvpPromoCodeUtil {
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
	public static void clearCache(RsvpPromoCode rsvpPromoCode) {
		getPersistence().clearCache(rsvpPromoCode);
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
	public static List<RsvpPromoCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RsvpPromoCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RsvpPromoCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RsvpPromoCode update(RsvpPromoCode rsvpPromoCode)
		throws SystemException {
		return getPersistence().update(rsvpPromoCode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RsvpPromoCode update(RsvpPromoCode rsvpPromoCode,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rsvpPromoCode, serviceContext);
	}

	/**
	* Returns all the rsvp promo codes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByUuid_PrevAndNext(
		long rsvpPromoCodeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(rsvpPromoCodeId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the rsvp promo codes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of rsvp promo codes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the rsvp promo code where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp promo code that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of rsvp promo codes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByUuid_C_PrevAndNext(
		long rsvpPromoCodeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(rsvpPromoCodeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the rsvp promo codes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of rsvp promo codes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the rsvp promo codes where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrsvpId(rsvpId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrsvpId(rsvpId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrsvpId(rsvpId, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByrsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().findByrsvpId_First(rsvpId, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByrsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByrsvpId_First(rsvpId, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByrsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().findByrsvpId_Last(rsvpId, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByrsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByrsvpId_Last(rsvpId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByrsvpId_PrevAndNext(
		long rsvpPromoCodeId, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByrsvpId_PrevAndNext(rsvpPromoCodeId, rsvpId,
			orderByComparator);
	}

	/**
	* Removes all the rsvp promo codes where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByrsvpId(rsvpId);
	}

	/**
	* Returns the number of rsvp promo codes where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrsvpId(rsvpId);
	}

	/**
	* Returns all the rsvp promo codes where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @return the matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPromoCode(promoCode);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPromoCode(promoCode, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPromoCode(promoCode, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByPromoCode_First(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByPromoCode_First(promoCode, orderByComparator);
	}

	/**
	* Returns the first rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByPromoCode_First(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPromoCode_First(promoCode, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByPromoCode_Last(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByPromoCode_Last(promoCode, orderByComparator);
	}

	/**
	* Returns the last rsvp promo code in the ordered set where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByPromoCode_Last(
		java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPromoCode_Last(promoCode, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode[] findByPromoCode_PrevAndNext(
		long rsvpPromoCodeId, java.lang.String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence()
				   .findByPromoCode_PrevAndNext(rsvpPromoCodeId, promoCode,
			orderByComparator);
	}

	/**
	* Removes all the rsvp promo codes where promoCode = &#63; from the database.
	*
	* @param promoCode the promo code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPromoCode(java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPromoCode(promoCode);
	}

	/**
	* Returns the number of rsvp promo codes where promoCode = &#63;.
	*
	* @param promoCode the promo code
	* @return the number of matching rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPromoCode(java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPromoCode(promoCode);
	}

	/**
	* Caches the rsvp promo code in the entity cache if it is enabled.
	*
	* @param rsvpPromoCode the rsvp promo code
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode) {
		getPersistence().cacheResult(rsvpPromoCode);
	}

	/**
	* Caches the rsvp promo codes in the entity cache if it is enabled.
	*
	* @param rsvpPromoCodes the rsvp promo codes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> rsvpPromoCodes) {
		getPersistence().cacheResult(rsvpPromoCodes);
	}

	/**
	* Creates a new rsvp promo code with the primary key. Does not add the rsvp promo code to the database.
	*
	* @param rsvpPromoCodeId the primary key for the new rsvp promo code
	* @return the new rsvp promo code
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode create(
		long rsvpPromoCodeId) {
		return getPersistence().create(rsvpPromoCodeId);
	}

	/**
	* Removes the rsvp promo code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode remove(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().remove(rsvpPromoCodeId);
	}

	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rsvpPromoCode);
	}

	/**
	* Returns the rsvp promo code with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException} if it could not be found.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode findByPrimaryKey(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException {
		return getPersistence().findByPrimaryKey(rsvpPromoCodeId);
	}

	/**
	* Returns the rsvp promo code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code, or <code>null</code> if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchByPrimaryKey(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rsvpPromoCodeId);
	}

	/**
	* Returns all the rsvp promo codes.
	*
	* @return the rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rsvp promo codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rsvp promo codes.
	*
	* @return the number of rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RsvpPromoCodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RsvpPromoCodePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.rsvp.service.ClpSerializer.getServletContextName(),
					RsvpPromoCodePersistence.class.getName());

			ReferenceRegistry.registerReference(RsvpPromoCodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RsvpPromoCodePersistence persistence) {
	}

	private static RsvpPromoCodePersistence _persistence;
}