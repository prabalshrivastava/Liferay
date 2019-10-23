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

import com.sambaash.platform.srv.rsvp.model.RsvpPayment;

import java.util.List;

/**
 * The persistence utility for the rsvp payment service. This utility wraps {@link RsvpPaymentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPaymentPersistence
 * @see RsvpPaymentPersistenceImpl
 * @generated
 */
public class RsvpPaymentUtil {
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
	public static void clearCache(RsvpPayment rsvpPayment) {
		getPersistence().clearCache(rsvpPayment);
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
	public static List<RsvpPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RsvpPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RsvpPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RsvpPayment update(RsvpPayment rsvpPayment)
		throws SystemException {
		return getPersistence().update(rsvpPayment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RsvpPayment update(RsvpPayment rsvpPayment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rsvpPayment, serviceContext);
	}

	/**
	* Returns all the rsvp payments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the rsvp payments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @return the range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the rsvp payments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the rsvp payments before and after the current rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param rsvpPaymentId the primary key of the current rsvp payment
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByUuid_PrevAndNext(
		long rsvpPaymentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(rsvpPaymentId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the rsvp payments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of rsvp payments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the rsvp payment where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the rsvp payment where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp payment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of rsvp payments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the rsvp payments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the rsvp payments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @return the range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the rsvp payments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the rsvp payments before and after the current rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param rsvpPaymentId the primary key of the current rsvp payment
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByUuid_C_PrevAndNext(
		long rsvpPaymentId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(rsvpPaymentId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the rsvp payments where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of rsvp payments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the rsvp payments where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns a range of all the rsvp payments where rsvpDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @return the range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRsvpDetailId(rsvpDetailId, start, end);
	}

	/**
	* Returns an ordered range of all the rsvp payments where rsvpDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRsvpDetailId(rsvpDetailId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailId_First(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByRsvpDetailId_First(rsvpDetailId, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailId_First(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRsvpDetailId_First(rsvpDetailId, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailId_Last(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByRsvpDetailId_Last(rsvpDetailId, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailId_Last(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRsvpDetailId_Last(rsvpDetailId, orderByComparator);
	}

	/**
	* Returns the rsvp payments before and after the current rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpPaymentId the primary key of the current rsvp payment
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByRsvpDetailId_PrevAndNext(
		long rsvpPaymentId, long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByRsvpDetailId_PrevAndNext(rsvpPaymentId, rsvpDetailId,
			orderByComparator);
	}

	/**
	* Removes all the rsvp payments where rsvpDetailId = &#63; from the database.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRsvpDetailId(long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns the number of rsvp payments where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRsvpDetailId(long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns the rsvp payment where ticketNumber = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	*
	* @param ticketNumber the ticket number
	* @return the matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().findByTicketNumber(ticketNumber);
	}

	/**
	* Returns the rsvp payment where ticketNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ticketNumber the ticket number
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTicketNumber(ticketNumber);
	}

	/**
	* Returns the rsvp payment where ticketNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ticketNumber the ticket number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByTicketNumber(
		java.lang.String ticketNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTicketNumber(ticketNumber, retrieveFromCache);
	}

	/**
	* Removes the rsvp payment where ticketNumber = &#63; from the database.
	*
	* @param ticketNumber the ticket number
	* @return the rsvp payment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment removeByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().removeByTicketNumber(ticketNumber);
	}

	/**
	* Returns the number of rsvp payments where ticketNumber = &#63;.
	*
	* @param ticketNumber the ticket number
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTicketNumber(java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTicketNumber(ticketNumber);
	}

	/**
	* Returns all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus);
	}

	/**
	* Returns a range of all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @return the range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus, start, end);
	}

	/**
	* Returns an ordered range of all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailIdTransactionStatus_First(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByRsvpDetailIdTransactionStatus_First(rsvpDetailId,
			transactionStatus, orderByComparator);
	}

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailIdTransactionStatus_First(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRsvpDetailIdTransactionStatus_First(rsvpDetailId,
			transactionStatus, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailIdTransactionStatus_Last(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByRsvpDetailIdTransactionStatus_Last(rsvpDetailId,
			transactionStatus, orderByComparator);
	}

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailIdTransactionStatus_Last(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRsvpDetailIdTransactionStatus_Last(rsvpDetailId,
			transactionStatus, orderByComparator);
	}

	/**
	* Returns the rsvp payments before and after the current rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpPaymentId the primary key of the current rsvp payment
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByRsvpDetailIdTransactionStatus_PrevAndNext(
		long rsvpPaymentId, long rsvpDetailId,
		java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence()
				   .findByRsvpDetailIdTransactionStatus_PrevAndNext(rsvpPaymentId,
			rsvpDetailId, transactionStatus, orderByComparator);
	}

	/**
	* Removes all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63; from the database.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus);
	}

	/**
	* Returns the number of rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRsvpDetailIdTransactionStatus(long rsvpDetailId,
		java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus);
	}

	/**
	* Caches the rsvp payment in the entity cache if it is enabled.
	*
	* @param rsvpPayment the rsvp payment
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment) {
		getPersistence().cacheResult(rsvpPayment);
	}

	/**
	* Caches the rsvp payments in the entity cache if it is enabled.
	*
	* @param rsvpPayments the rsvp payments
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> rsvpPayments) {
		getPersistence().cacheResult(rsvpPayments);
	}

	/**
	* Creates a new rsvp payment with the primary key. Does not add the rsvp payment to the database.
	*
	* @param rsvpPaymentId the primary key for the new rsvp payment
	* @return the new rsvp payment
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment create(
		long rsvpPaymentId) {
		return getPersistence().create(rsvpPaymentId);
	}

	/**
	* Removes the rsvp payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment remove(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().remove(rsvpPaymentId);
	}

	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rsvpPayment);
	}

	/**
	* Returns the rsvp payment with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment findByPrimaryKey(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return getPersistence().findByPrimaryKey(rsvpPaymentId);
	}

	/**
	* Returns the rsvp payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment, or <code>null</code> if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByPrimaryKey(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rsvpPaymentId);
	}

	/**
	* Returns all the rsvp payments.
	*
	* @return the rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rsvp payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @return the range of rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rsvp payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rsvp payments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rsvp payments.
	*
	* @return the number of rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RsvpPaymentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RsvpPaymentPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.rsvp.service.ClpSerializer.getServletContextName(),
					RsvpPaymentPersistence.class.getName());

			ReferenceRegistry.registerReference(RsvpPaymentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RsvpPaymentPersistence persistence) {
	}

	private static RsvpPaymentPersistence _persistence;
}