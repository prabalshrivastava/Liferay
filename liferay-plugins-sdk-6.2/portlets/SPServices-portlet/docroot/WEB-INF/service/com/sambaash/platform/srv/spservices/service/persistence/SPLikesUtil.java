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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spservices.model.SPLikes;

import java.util.List;

/**
 * The persistence utility for the s p likes service. This utility wraps {@link SPLikesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLikesPersistence
 * @see SPLikesPersistenceImpl
 * @generated
 */
public class SPLikesUtil {
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
	public static void clearCache(SPLikes spLikes) {
		getPersistence().clearCache(spLikes);
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
	public static List<SPLikes> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPLikes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPLikes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPLikes update(SPLikes spLikes) throws SystemException {
		return getPersistence().update(spLikes);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPLikes update(SPLikes spLikes, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spLikes, serviceContext);
	}

	/**
	* Returns all the s p likeses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p likeses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @return the range of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p likeses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p likes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p likes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p likes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p likes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p likeses before and after the current s p likes in the ordered set where uuid = &#63;.
	*
	* @param spLikesId the primary key of the current s p likes
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes[] findByUuid_PrevAndNext(
		long spLikesId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spLikesId, uuid, orderByComparator);
	}

	/**
	* Removes all the s p likeses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p likeses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p likes where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLikesException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p likes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p likes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p likes where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p likes that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p likeses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p likeses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the s p likeses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @return the range of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the s p likeses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the s p likeses before and after the current s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spLikesId the primary key of the current s p likes
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes[] findByUuid_C_PrevAndNext(
		long spLikesId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spLikesId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the s p likeses where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of s p likeses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @return the matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByClassNameAndClassPK(
		long companyId, long groupId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, className,
			classPK);
	}

	/**
	* Returns a range of all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @return the range of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByClassNameAndClassPK(
		long companyId, long groupId, java.lang.String className, long classPK,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, className,
			classPK, start, end);
	}

	/**
	* Returns an ordered range of all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findByClassNameAndClassPK(
		long companyId, long groupId, java.lang.String className, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, className,
			classPK, start, end, orderByComparator);
	}

	/**
	* Returns the first s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByClassNameAndClassPK_First(
		long companyId, long groupId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByClassNameAndClassPK_First(companyId, groupId,
			className, classPK, orderByComparator);
	}

	/**
	* Returns the first s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByClassNameAndClassPK_First(
		long companyId, long groupId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameAndClassPK_First(companyId, groupId,
			className, classPK, orderByComparator);
	}

	/**
	* Returns the last s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByClassNameAndClassPK_Last(
		long companyId, long groupId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByClassNameAndClassPK_Last(companyId, groupId,
			className, classPK, orderByComparator);
	}

	/**
	* Returns the last s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByClassNameAndClassPK_Last(
		long companyId, long groupId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameAndClassPK_Last(companyId, groupId,
			className, classPK, orderByComparator);
	}

	/**
	* Returns the s p likeses before and after the current s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param spLikesId the primary key of the current s p likes
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes[] findByClassNameAndClassPK_PrevAndNext(
		long spLikesId, long companyId, long groupId,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByClassNameAndClassPK_PrevAndNext(spLikesId, companyId,
			groupId, className, classPK, orderByComparator);
	}

	/**
	* Removes all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassNameAndClassPK(long companyId,
		long groupId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByClassNameAndClassPK(companyId, groupId, className, classPK);
	}

	/**
	* Returns the number of s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameAndClassPK(long companyId, long groupId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByClassNameAndClassPK(companyId, groupId, className,
			classPK);
	}

	/**
	* Returns the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLikesException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param className the class name
	* @param classPK the class p k
	* @return the matching s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByUserIdWithClassNameAndClassPK(
		long companyId, long groupId, long userId, java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .findByUserIdWithClassNameAndClassPK(companyId, groupId,
			userId, className, classPK);
	}

	/**
	* Returns the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param className the class name
	* @param classPK the class p k
	* @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUserIdWithClassNameAndClassPK(
		long companyId, long groupId, long userId, java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdWithClassNameAndClassPK(companyId, groupId,
			userId, className, classPK);
	}

	/**
	* Returns the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param className the class name
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByUserIdWithClassNameAndClassPK(
		long companyId, long groupId, long userId, java.lang.String className,
		long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdWithClassNameAndClassPK(companyId, groupId,
			userId, className, classPK, retrieveFromCache);
	}

	/**
	* Removes the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param className the class name
	* @param classPK the class p k
	* @return the s p likes that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes removeByUserIdWithClassNameAndClassPK(
		long companyId, long groupId, long userId, java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence()
				   .removeByUserIdWithClassNameAndClassPK(companyId, groupId,
			userId, className, classPK);
	}

	/**
	* Returns the number of s p likeses where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdWithClassNameAndClassPK(long companyId,
		long groupId, long userId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdWithClassNameAndClassPK(companyId, groupId,
			userId, className, classPK);
	}

	/**
	* Caches the s p likes in the entity cache if it is enabled.
	*
	* @param spLikes the s p likes
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes) {
		getPersistence().cacheResult(spLikes);
	}

	/**
	* Caches the s p likeses in the entity cache if it is enabled.
	*
	* @param spLikeses the s p likeses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> spLikeses) {
		getPersistence().cacheResult(spLikeses);
	}

	/**
	* Creates a new s p likes with the primary key. Does not add the s p likes to the database.
	*
	* @param spLikesId the primary key for the new s p likes
	* @return the new s p likes
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes create(
		long spLikesId) {
		return getPersistence().create(spLikesId);
	}

	/**
	* Removes the s p likes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLikesId the primary key of the s p likes
	* @return the s p likes that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes remove(
		long spLikesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence().remove(spLikesId);
	}

	public static com.sambaash.platform.srv.spservices.model.SPLikes updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spLikes);
	}

	/**
	* Returns the s p likes with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLikesException} if it could not be found.
	*
	* @param spLikesId the primary key of the s p likes
	* @return the s p likes
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes findByPrimaryKey(
		long spLikesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLikesException {
		return getPersistence().findByPrimaryKey(spLikesId);
	}

	/**
	* Returns the s p likes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLikesId the primary key of the s p likes
	* @return the s p likes, or <code>null</code> if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLikes fetchByPrimaryKey(
		long spLikesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spLikesId);
	}

	/**
	* Returns all the s p likeses.
	*
	* @return the s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p likeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @return the range of s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p likeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p likeses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p likeses.
	*
	* @return the number of s p likeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPLikesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPLikesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					SPLikesPersistence.class.getName());

			ReferenceRegistry.registerReference(SPLikesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPLikesPersistence persistence) {
	}

	private static SPLikesPersistence _persistence;
}