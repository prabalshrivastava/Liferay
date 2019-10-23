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

import com.sambaash.platform.srv.rsvp.model.RsvpDetail;

/**
 * The persistence interface for the rsvp detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDetailPersistenceImpl
 * @see RsvpDetailUtil
 * @generated
 */
public interface RsvpDetailPersistence extends BasePersistence<RsvpDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RsvpDetailUtil} to access the rsvp detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rsvp details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByUuid_PrevAndNext(
		long rsvpDetailId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the rsvp detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rsvp detail where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the number of rsvp details where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByUuid_C_PrevAndNext(
		long rsvpDetailId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByRsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByRsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByRsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByRsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByRsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddressAndRsvpId_First(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddressAndRsvpId_First(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddressAndRsvpId_Last(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddressAndRsvpId_Last(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByemailAddressAndRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where rsvpId = &#63; and emailAddress = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemailAddressAndRsvpId(long rsvpId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByemailAddressAndRsvpId(long rsvpId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findBynameAndRsvpId_First(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchBynameAndRsvpId_First(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findBynameAndRsvpId_Last(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchBynameAndRsvpId_Last(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findBynameAndRsvpId_PrevAndNext(
		long rsvpDetailId, java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where firstName = &#63; and rsvpId = &#63; from the database.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBynameAndRsvpId(java.lang.String firstName, long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countBynameAndRsvpId(java.lang.String firstName, long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByemailAddress_PrevAndNext(
		long rsvpDetailId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpStatusAndRsvpId_First(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpStatusAndRsvpId_First(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpStatusAndRsvpId_Last(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpStatusAndRsvpId_Last(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByrsvpStatusAndRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where rsvpId = &#63; and source = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where rsvpId = &#63; and source = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndSource_First(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndSource_First(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndSource_Last(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndSource_Last(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByrsvpIdAndSource_PrevAndNext(
		long rsvpDetailId, long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where rsvpId = &#63; and source = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrsvpIdAndSource(long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByrsvpIdAndSource(long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndAttendance_First(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndAttendance_First(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndAttendance_Last(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndAttendance_Last(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpDetailId the primary key of the current rsvp detail
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByrsvpIdAndAttendance_PrevAndNext(
		long rsvpDetailId, long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Removes all the rsvp details where rsvpId = &#63; and attendance = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrsvpIdAndAttendance(long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countByrsvpIdAndAttendance(long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rsvp detail in the entity cache if it is enabled.
	*
	* @param rsvpDetail the rsvp detail
	*/
	public void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail);

	/**
	* Caches the rsvp details in the entity cache if it is enabled.
	*
	* @param rsvpDetails the rsvp details
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> rsvpDetails);

	/**
	* Creates a new rsvp detail with the primary key. Does not add the rsvp detail to the database.
	*
	* @param rsvpDetailId the primary key for the new rsvp detail
	* @return the new rsvp detail
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail create(
		long rsvpDetailId);

	/**
	* Removes the rsvp detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail remove(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	public com.sambaash.platform.srv.rsvp.model.RsvpDetail updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rsvp detail with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException} if it could not be found.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail findByPrimaryKey(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;

	/**
	* Returns the rsvp detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail, or <code>null</code> if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByPrimaryKey(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rsvp details.
	*
	* @return the rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rsvp details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rsvp details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rsvp details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rsvp details.
	*
	* @return the number of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}