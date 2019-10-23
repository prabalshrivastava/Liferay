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

import com.sambaash.platform.srv.rsvp.model.RsvpDetail;

import java.util.List;

/**
 * The persistence utility for the rsvp detail service. This utility wraps {@link RsvpDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDetailPersistence
 * @see RsvpDetailPersistenceImpl
 * @generated
 */
public class RsvpDetailUtil {
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
	public static void clearCache(RsvpDetail rsvpDetail) {
		getPersistence().clearCache(rsvpDetail);
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
	public static List<RsvpDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RsvpDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RsvpDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RsvpDetail update(RsvpDetail rsvpDetail)
		throws SystemException {
		return getPersistence().update(rsvpDetail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RsvpDetail update(RsvpDetail rsvpDetail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rsvpDetail, serviceContext);
	}

	/**
	* Returns all the rsvp details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByUuid_PrevAndNext(
		long rsvpDetailId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByUuid_PrevAndNext(rsvpDetailId, uuid, orderByComparator);
	}

	/**
	* Removes all the rsvp details where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of rsvp details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the rsvp detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rsvp detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the rsvp detail where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rsvp detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of rsvp details where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the rsvp details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByUuid_C_PrevAndNext(
		long rsvpDetailId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(rsvpDetailId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the rsvp details where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of rsvp details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the rsvp details where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRsvpId(rsvpId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRsvpId(rsvpId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRsvpId(rsvpId, start, end, orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByRsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().findByRsvpId_First(rsvpId, orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByRsvpId_First(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRsvpId_First(rsvpId, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByRsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().findByRsvpId_Last(rsvpId, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByRsvpId_Last(
		long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRsvpId_Last(rsvpId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByRsvpId_PrevAndNext(rsvpDetailId, rsvpId,
			orderByComparator);
	}

	/**
	* Removes all the rsvp details where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRsvpId(rsvpId);
	}

	/**
	* Returns the number of rsvp details where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRsvpId(rsvpId);
	}

	/**
	* Returns all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemailAddressAndRsvpId(rsvpId, emailAddress);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemailAddressAndRsvpId(rsvpId, emailAddress, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemailAddressAndRsvpId(rsvpId, emailAddress, start,
			end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddressAndRsvpId_First(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByemailAddressAndRsvpId_First(rsvpId, emailAddress,
			orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddressAndRsvpId_First(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemailAddressAndRsvpId_First(rsvpId, emailAddress,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddressAndRsvpId_Last(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByemailAddressAndRsvpId_Last(rsvpId, emailAddress,
			orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddressAndRsvpId_Last(
		long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemailAddressAndRsvpId_Last(rsvpId, emailAddress,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByemailAddressAndRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByemailAddressAndRsvpId_PrevAndNext(rsvpDetailId,
			rsvpId, emailAddress, orderByComparator);
	}

	/**
	* Removes all the rsvp details where rsvpId = &#63; and emailAddress = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemailAddressAndRsvpId(long rsvpId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemailAddressAndRsvpId(rsvpId, emailAddress);
	}

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param emailAddress the email address
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemailAddressAndRsvpId(long rsvpId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByemailAddressAndRsvpId(rsvpId, emailAddress);
	}

	/**
	* Returns all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBynameAndRsvpId(firstName, rsvpId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynameAndRsvpId(firstName, rsvpId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynameAndRsvpId(firstName, rsvpId, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findBynameAndRsvpId_First(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findBynameAndRsvpId_First(firstName, rsvpId,
			orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchBynameAndRsvpId_First(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynameAndRsvpId_First(firstName, rsvpId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findBynameAndRsvpId_Last(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findBynameAndRsvpId_Last(firstName, rsvpId,
			orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchBynameAndRsvpId_Last(
		java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynameAndRsvpId_Last(firstName, rsvpId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findBynameAndRsvpId_PrevAndNext(
		long rsvpDetailId, java.lang.String firstName, long rsvpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findBynameAndRsvpId_PrevAndNext(rsvpDetailId, firstName,
			rsvpId, orderByComparator);
	}

	/**
	* Removes all the rsvp details where firstName = &#63; and rsvpId = &#63; from the database.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBynameAndRsvpId(java.lang.String firstName,
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBynameAndRsvpId(firstName, rsvpId);
	}

	/**
	* Returns the number of rsvp details where firstName = &#63; and rsvpId = &#63;.
	*
	* @param firstName the first name
	* @param rsvpId the rsvp ID
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countBynameAndRsvpId(java.lang.String firstName,
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBynameAndRsvpId(firstName, rsvpId);
	}

	/**
	* Returns all the rsvp details where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemailAddress(emailAddress);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemailAddress(emailAddress, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemailAddress(emailAddress, start, end,
			orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByemailAddress_First(emailAddress, orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemailAddress_First(emailAddress, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByemailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByemailAddress_Last(emailAddress, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByemailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemailAddress_Last(emailAddress, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByemailAddress_PrevAndNext(
		long rsvpDetailId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByemailAddress_PrevAndNext(rsvpDetailId, emailAddress,
			orderByComparator);
	}

	/**
	* Removes all the rsvp details where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemailAddress(emailAddress);
	}

	/**
	* Returns the number of rsvp details where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemailAddress(emailAddress);
	}

	/**
	* Returns all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpStatusAndRsvpId_First(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpStatusAndRsvpId_First(rsvpId, rsvpStatus,
			orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpStatusAndRsvpId_First(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrsvpStatusAndRsvpId_First(rsvpId, rsvpStatus,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpStatusAndRsvpId_Last(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpStatusAndRsvpId_Last(rsvpId, rsvpStatus,
			orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpStatusAndRsvpId_Last(
		long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrsvpStatusAndRsvpId_Last(rsvpId, rsvpStatus,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByrsvpStatusAndRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId, int rsvpStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpStatusAndRsvpId_PrevAndNext(rsvpDetailId, rsvpId,
			rsvpStatus, orderByComparator);
	}

	/**
	* Removes all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByrsvpStatusAndRsvpId(rsvpId, rsvpStatus);
	}

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param rsvpStatus the rsvp status
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrsvpStatusAndRsvpId(rsvpId, rsvpStatus);
	}

	/**
	* Returns all the rsvp details where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrsvpIdAndSource(rsvpId, source);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrsvpIdAndSource(rsvpId, source, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrsvpIdAndSource(rsvpId, source, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndSource_First(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpIdAndSource_First(rsvpId, source,
			orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndSource_First(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrsvpIdAndSource_First(rsvpId, source,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndSource_Last(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpIdAndSource_Last(rsvpId, source, orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndSource_Last(
		long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrsvpIdAndSource_Last(rsvpId, source,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByrsvpIdAndSource_PrevAndNext(
		long rsvpDetailId, long rsvpId, int source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpIdAndSource_PrevAndNext(rsvpDetailId, rsvpId,
			source, orderByComparator);
	}

	/**
	* Removes all the rsvp details where rsvpId = &#63; and source = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByrsvpIdAndSource(long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByrsvpIdAndSource(rsvpId, source);
	}

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and source = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param source the source
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrsvpIdAndSource(long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrsvpIdAndSource(rsvpId, source);
	}

	/**
	* Returns all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @return the matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrsvpIdAndAttendance(rsvpId, attendance);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrsvpIdAndAttendance(rsvpId, attendance, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrsvpIdAndAttendance(rsvpId, attendance, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndAttendance_First(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpIdAndAttendance_First(rsvpId, attendance,
			orderByComparator);
	}

	/**
	* Returns the first rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndAttendance_First(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrsvpIdAndAttendance_First(rsvpId, attendance,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByrsvpIdAndAttendance_Last(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpIdAndAttendance_Last(rsvpId, attendance,
			orderByComparator);
	}

	/**
	* Returns the last rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByrsvpIdAndAttendance_Last(
		long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrsvpIdAndAttendance_Last(rsvpId, attendance,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail[] findByrsvpIdAndAttendance_PrevAndNext(
		long rsvpDetailId, long rsvpId, int attendance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence()
				   .findByrsvpIdAndAttendance_PrevAndNext(rsvpDetailId, rsvpId,
			attendance, orderByComparator);
	}

	/**
	* Removes all the rsvp details where rsvpId = &#63; and attendance = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByrsvpIdAndAttendance(long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByrsvpIdAndAttendance(rsvpId, attendance);
	}

	/**
	* Returns the number of rsvp details where rsvpId = &#63; and attendance = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @param attendance the attendance
	* @return the number of matching rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrsvpIdAndAttendance(long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrsvpIdAndAttendance(rsvpId, attendance);
	}

	/**
	* Caches the rsvp detail in the entity cache if it is enabled.
	*
	* @param rsvpDetail the rsvp detail
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail) {
		getPersistence().cacheResult(rsvpDetail);
	}

	/**
	* Caches the rsvp details in the entity cache if it is enabled.
	*
	* @param rsvpDetails the rsvp details
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> rsvpDetails) {
		getPersistence().cacheResult(rsvpDetails);
	}

	/**
	* Creates a new rsvp detail with the primary key. Does not add the rsvp detail to the database.
	*
	* @param rsvpDetailId the primary key for the new rsvp detail
	* @return the new rsvp detail
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail create(
		long rsvpDetailId) {
		return getPersistence().create(rsvpDetailId);
	}

	/**
	* Removes the rsvp detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail that was removed
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail remove(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().remove(rsvpDetailId);
	}

	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rsvpDetail);
	}

	/**
	* Returns the rsvp detail with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException} if it could not be found.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail
	* @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail findByPrimaryKey(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getPersistence().findByPrimaryKey(rsvpDetailId);
	}

	/**
	* Returns the rsvp detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail, or <code>null</code> if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchByPrimaryKey(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rsvpDetailId);
	}

	/**
	* Returns all the rsvp details.
	*
	* @return the rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rsvp details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rsvp details.
	*
	* @return the number of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RsvpDetailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RsvpDetailPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.rsvp.service.ClpSerializer.getServletContextName(),
					RsvpDetailPersistence.class.getName());

			ReferenceRegistry.registerReference(RsvpDetailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RsvpDetailPersistence persistence) {
	}

	private static RsvpDetailPersistence _persistence;
}