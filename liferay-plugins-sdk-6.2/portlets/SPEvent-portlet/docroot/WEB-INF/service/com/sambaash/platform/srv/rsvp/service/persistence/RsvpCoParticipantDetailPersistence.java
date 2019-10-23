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

import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;

/**
 * The persistence interface for the rsvp co participant detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpCoParticipantDetailPersistenceImpl
 * @see RsvpCoParticipantDetailUtil
 * @generated
 */
public interface RsvpCoParticipantDetailPersistence extends BasePersistence<RsvpCoParticipantDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RsvpCoParticipantDetailUtil} to access the rsvp co participant detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rsvp co participant details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp co participant details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @return the range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp co participant details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where uuid = &#63;.
	*
	* @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail[] findByUuid_PrevAndNext(
		long rsvpCoParticipantDetailId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Removes all the rsvp co participant details where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp co participant details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the rsvp co participant detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp co participant detail where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp co participant detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the number of rsvp co participant details where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp co participant details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp co participant details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @return the range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp co participant details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail[] findByUuid_C_PrevAndNext(
		long rsvpCoParticipantDetailId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Removes all the rsvp co participant details where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp co participant details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp co participant details where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @return the matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailId(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp co participant details where rsvpDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @return the range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailId(
		long rsvpDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp co participant details where rsvpDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailId(
		long rsvpDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByRsvpDetailId_First(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByRsvpDetailId_First(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByRsvpDetailId_Last(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByRsvpDetailId_Last(
		long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	*
	* @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	* @param rsvpDetailId the rsvp detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail[] findByRsvpDetailId_PrevAndNext(
		long rsvpCoParticipantDetailId, long rsvpDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Removes all the rsvp co participant details where rsvpDetailId = &#63; from the database.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRsvpDetailId(long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp co participant details where rsvpDetailId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @return the number of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countByRsvpDetailId(long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant detail where ticketNumber = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException} if it could not be found.
	*
	* @param ticketNumber the ticket number
	* @return the matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the rsvp co participant detail where ticketNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ticketNumber the ticket number
	* @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant detail where ticketNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ticketNumber the ticket number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByTicketNumber(
		java.lang.String ticketNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp co participant detail where ticketNumber = &#63; from the database.
	*
	* @param ticketNumber the ticket number
	* @return the rsvp co participant detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail removeByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the number of rsvp co participant details where ticketNumber = &#63;.
	*
	* @param ticketNumber the ticket number
	* @return the number of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countByTicketNumber(java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @return the matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @return the range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long rsvpPaymentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long rsvpPaymentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByRsvpDetailIdAndSPRsvpPaymentId_First(
		long rsvpDetailId, long rsvpPaymentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByRsvpDetailIdAndSPRsvpPaymentId_First(
		long rsvpDetailId, long rsvpPaymentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByRsvpDetailIdAndSPRsvpPaymentId_Last(
		long rsvpDetailId, long rsvpPaymentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByRsvpDetailIdAndSPRsvpPaymentId_Last(
		long rsvpDetailId, long rsvpPaymentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail[] findByRsvpDetailIdAndSPRsvpPaymentId_PrevAndNext(
		long rsvpCoParticipantDetailId, long rsvpDetailId, long rsvpPaymentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Removes all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63; from the database.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRsvpDetailIdAndSPRsvpPaymentId(long rsvpDetailId,
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	*
	* @param rsvpDetailId the rsvp detail ID
	* @param rsvpPaymentId the rsvp payment ID
	* @return the number of matching rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countByRsvpDetailIdAndSPRsvpPaymentId(long rsvpDetailId,
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rsvp co participant detail in the entity cache if it is enabled.
	*
	* @param rsvpCoParticipantDetail the rsvp co participant detail
	*/
	public void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail);

	/**
	* Caches the rsvp co participant details in the entity cache if it is enabled.
	*
	* @param rsvpCoParticipantDetails the rsvp co participant details
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> rsvpCoParticipantDetails);

	/**
	* Creates a new rsvp co participant detail with the primary key. Does not add the rsvp co participant detail to the database.
	*
	* @param rsvpCoParticipantDetailId the primary key for the new rsvp co participant detail
	* @return the new rsvp co participant detail
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail create(
		long rsvpCoParticipantDetailId);

	/**
	* Removes the rsvp co participant detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	* @return the rsvp co participant detail that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail remove(
		long rsvpCoParticipantDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp co participant detail with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException} if it could not be found.
	*
	* @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	* @return the rsvp co participant detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByPrimaryKey(
		long rsvpCoParticipantDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;

	/**
	* Returns the rsvp co participant detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	* @return the rsvp co participant detail, or <code>null</code> if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchByPrimaryKey(
		long rsvpCoParticipantDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp co participant details.
	*
	* @return the rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp co participant details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @return the range of rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp co participant details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rsvp co participant details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp co participant details.
	*
	* @return the number of rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}