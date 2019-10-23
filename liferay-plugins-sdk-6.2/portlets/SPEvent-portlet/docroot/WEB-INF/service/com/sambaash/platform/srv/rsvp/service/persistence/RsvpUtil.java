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

import com.sambaash.platform.srv.rsvp.model.Rsvp;

import java.util.List;

/**
 * The persistence utility for the rsvp service. This utility wraps {@link RsvpPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPersistence
 * @see RsvpPersistenceImpl
 * @generated
 */
public class RsvpUtil {
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
	public static void clearCache(Rsvp rsvp) {
		getPersistence().clearCache(rsvp);
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
	public static List<Rsvp> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Rsvp> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Rsvp> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Rsvp update(Rsvp rsvp) throws SystemException {
		return getPersistence().update(rsvp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Rsvp update(Rsvp rsvp, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(rsvp, serviceContext);
	}

	/**
	* Returns all the rsvps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the rsvps where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @return the range of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the rsvps where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first rsvp in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the rsvps before and after the current rsvp in the ordered set where uuid = &#63;.
	*
	* @param rsvpId the primary key of the current rsvp
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp[] findByUuid_PrevAndNext(
		long rsvpId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence()
				   .findByUuid_PrevAndNext(rsvpId, uuid, orderByComparator);
	}

	/**
	* Removes all the rsvps where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of rsvps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the rsvp where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the rsvp where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of rsvps where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the rsvps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the rsvps where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @return the range of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the rsvps where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the rsvps before and after the current rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param rsvpId the primary key of the current rsvp
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp[] findByUuid_C_PrevAndNext(
		long rsvpId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(rsvpId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the rsvps where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of rsvps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the rsvp where eventId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	*
	* @param eventId the event ID
	* @return the matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByeventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().findByeventId(eventId);
	}

	/**
	* Returns the rsvp where eventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eventId the event ID
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByeventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByeventId(eventId);
	}

	/**
	* Returns the rsvp where eventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eventId the event ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByeventId(
		long eventId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByeventId(eventId, retrieveFromCache);
	}

	/**
	* Removes the rsvp where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	* @return the rsvp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp removeByeventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().removeByeventId(eventId);
	}

	/**
	* Returns the number of rsvps where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByeventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByeventId(eventId);
	}

	/**
	* Returns the rsvp where spAssetTypeId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	*
	* @param spAssetTypeId the sp asset type ID
	* @return the matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByspAssetTypeId(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().findByspAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the rsvp where spAssetTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spAssetTypeId the sp asset type ID
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByspAssetTypeId(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByspAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the rsvp where spAssetTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByspAssetTypeId(
		long spAssetTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByspAssetTypeId(spAssetTypeId, retrieveFromCache);
	}

	/**
	* Removes the rsvp where spAssetTypeId = &#63; from the database.
	*
	* @param spAssetTypeId the sp asset type ID
	* @return the rsvp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp removeByspAssetTypeId(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().removeByspAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the number of rsvps where spAssetTypeId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @return the number of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByspAssetTypeId(long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByspAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the rsvp where eventId = &#63; and spAssetTypeId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	*
	* @param eventId the event ID
	* @param spAssetTypeId the sp asset type ID
	* @return the matching rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByeventIdAndSpAssetTypeId(
		long eventId, long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence()
				   .findByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);
	}

	/**
	* Returns the rsvp where eventId = &#63; and spAssetTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eventId the event ID
	* @param spAssetTypeId the sp asset type ID
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByeventIdAndSpAssetTypeId(
		long eventId, long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);
	}

	/**
	* Returns the rsvp where eventId = &#63; and spAssetTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eventId the event ID
	* @param spAssetTypeId the sp asset type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByeventIdAndSpAssetTypeId(
		long eventId, long spAssetTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByeventIdAndSpAssetTypeId(eventId, spAssetTypeId,
			retrieveFromCache);
	}

	/**
	* Removes the rsvp where eventId = &#63; and spAssetTypeId = &#63; from the database.
	*
	* @param eventId the event ID
	* @param spAssetTypeId the sp asset type ID
	* @return the rsvp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp removeByeventIdAndSpAssetTypeId(
		long eventId, long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence()
				   .removeByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);
	}

	/**
	* Returns the number of rsvps where eventId = &#63; and spAssetTypeId = &#63;.
	*
	* @param eventId the event ID
	* @param spAssetTypeId the sp asset type ID
	* @return the number of matching rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByeventIdAndSpAssetTypeId(long eventId,
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);
	}

	/**
	* Caches the rsvp in the entity cache if it is enabled.
	*
	* @param rsvp the rsvp
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.rsvp.model.Rsvp rsvp) {
		getPersistence().cacheResult(rsvp);
	}

	/**
	* Caches the rsvps in the entity cache if it is enabled.
	*
	* @param rsvps the rsvps
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> rsvps) {
		getPersistence().cacheResult(rsvps);
	}

	/**
	* Creates a new rsvp with the primary key. Does not add the rsvp to the database.
	*
	* @param rsvpId the primary key for the new rsvp
	* @return the new rsvp
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp create(long rsvpId) {
		return getPersistence().create(rsvpId);
	}

	/**
	* Removes the rsvp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpId the primary key of the rsvp
	* @return the rsvp that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp remove(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().remove(rsvpId);
	}

	public static com.sambaash.platform.srv.rsvp.model.Rsvp updateImpl(
		com.sambaash.platform.srv.rsvp.model.Rsvp rsvp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rsvp);
	}

	/**
	* Returns the rsvp with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	*
	* @param rsvpId the primary key of the rsvp
	* @return the rsvp
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp findByPrimaryKey(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getPersistence().findByPrimaryKey(rsvpId);
	}

	/**
	* Returns the rsvp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpId the primary key of the rsvp
	* @return the rsvp, or <code>null</code> if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.Rsvp fetchByPrimaryKey(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rsvpId);
	}

	/**
	* Returns all the rsvps.
	*
	* @return the rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rsvps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @return the range of rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rsvps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rsvps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rsvps.
	*
	* @return the number of rsvps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RsvpPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RsvpPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.rsvp.service.ClpSerializer.getServletContextName(),
					RsvpPersistence.class.getName());

			ReferenceRegistry.registerReference(RsvpUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RsvpPersistence persistence) {
	}

	private static RsvpPersistence _persistence;
}