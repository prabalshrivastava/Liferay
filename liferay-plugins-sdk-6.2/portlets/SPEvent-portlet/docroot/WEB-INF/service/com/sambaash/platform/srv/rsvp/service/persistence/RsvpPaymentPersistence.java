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

import com.sambaash.platform.srv.rsvp.model.RsvpPayment;

/**
 * The persistence interface for the rsvp payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPaymentPersistenceImpl
 * @see RsvpPaymentUtil
 * @generated
 */
public interface RsvpPaymentPersistence extends BasePersistence<RsvpPayment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RsvpPaymentUtil} to access the rsvp payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rsvp payments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByUuid_PrevAndNext(
		long rsvpPaymentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Removes all the rsvp payments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp payments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp payment where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the rsvp payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp payment where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp payment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the number of rsvp payments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp payments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the first rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the last rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByUuid_C_PrevAndNext(
		long rsvpPaymentId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Removes all the rsvp payments where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp payments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp payments where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailId_First(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailId_First(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailId_Last(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailId_Last(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByRsvpDetailId_PrevAndNext(
		long rsvpPaymentId, long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Removes all the rsvp payments where rsvpDetailId = &#63; from the database.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRsvpDetailId(long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp payments where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countByRsvpDetailId(long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp payment where ticketNumber = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	*
	* @param ticketNumber the ticket number
	* @return the matching rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the rsvp payment where ticketNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ticketNumber the ticket number
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp payment where ticketNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ticketNumber the ticket number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByTicketNumber(
		java.lang.String ticketNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp payment where ticketNumber = &#63; from the database.
	*
	* @param ticketNumber the ticket number
	* @return the rsvp payment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment removeByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the number of rsvp payments where ticketNumber = &#63;.
	*
	* @param ticketNumber the ticket number
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countByTicketNumber(java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @return the matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailIdTransactionStatus_First(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailIdTransactionStatus_First(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByRsvpDetailIdTransactionStatus_Last(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByRsvpDetailIdTransactionStatus_Last(
		long rsvpDetailId, java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment[] findByRsvpDetailIdTransactionStatus_PrevAndNext(
		long rsvpPaymentId, long rsvpDetailId,
		java.lang.String transactionStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Removes all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63; from the database.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRsvpDetailIdTransactionStatus(long rsvpDetailId,
		java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param transactionStatus the transaction status
	* @return the number of matching rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countByRsvpDetailIdTransactionStatus(long rsvpDetailId,
		java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rsvp payment in the entity cache if it is enabled.
	*
	* @param rsvpPayment the rsvp payment
	*/
	public void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment);

	/**
	* Caches the rsvp payments in the entity cache if it is enabled.
	*
	* @param rsvpPayments the rsvp payments
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> rsvpPayments);

	/**
	* Creates a new rsvp payment with the primary key. Does not add the rsvp payment to the database.
	*
	* @param rsvpPaymentId the primary key for the new rsvp payment
	* @return the new rsvp payment
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment create(
		long rsvpPaymentId);

	/**
	* Removes the rsvp payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment remove(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	public com.sambaash.platform.srv.rsvp.model.RsvpPayment updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp payment with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByPrimaryKey(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;

	/**
	* Returns the rsvp payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment, or <code>null</code> if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchByPrimaryKey(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp payments.
	*
	* @return the rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rsvp payments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp payments.
	*
	* @return the number of rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}