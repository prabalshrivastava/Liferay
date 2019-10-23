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

package com.sambaash.platform.srv.sprating.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.sprating.model.AttrRate;

import java.util.List;

/**
 * The persistence utility for the attr rate service. This utility wraps {@link AttrRatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see AttrRatePersistence
 * @see AttrRatePersistenceImpl
 * @generated
 */
public class AttrRateUtil {
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
	public static void clearCache(AttrRate attrRate) {
		getPersistence().clearCache(attrRate);
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
	public static List<AttrRate> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttrRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttrRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AttrRate update(AttrRate attrRate) throws SystemException {
		return getPersistence().update(attrRate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AttrRate update(AttrRate attrRate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(attrRate, serviceContext);
	}

	/**
	* Returns all the attr rates where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the attr rates where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the attr rates where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the attr rates before and after the current attr rate in the ordered set where uuid = &#63;.
	*
	* @param spAttrRateId the primary key of the current attr rate
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate[] findByUuid_PrevAndNext(
		long spAttrRateId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spAttrRateId, uuid, orderByComparator);
	}

	/**
	* Removes all the attr rates where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of attr rates where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the attr rate where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the attr rate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the attr rate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the attr rate where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the attr rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of attr rates where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the attr rates where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the attr rates where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the attr rates where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the attr rates before and after the current attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spAttrRateId the primary key of the current attr rate
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate[] findByUuid_C_PrevAndNext(
		long spAttrRateId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spAttrRateId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the attr rates where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of attr rates where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @return the matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUserIdClassNameIdObjId(
		long userId, long classNameId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdClassNameIdObjId(userId, classNameId, objId);
	}

	/**
	* Returns a range of all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUserIdClassNameIdObjId(
		long userId, long classNameId, java.lang.String objId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdClassNameIdObjId(userId, classNameId, objId,
			start, end);
	}

	/**
	* Returns an ordered range of all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUserIdClassNameIdObjId(
		long userId, long classNameId, java.lang.String objId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdClassNameIdObjId(userId, classNameId, objId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUserIdClassNameIdObjId_First(
		long userId, long classNameId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUserIdClassNameIdObjId_First(userId, classNameId,
			objId, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUserIdClassNameIdObjId_First(
		long userId, long classNameId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdClassNameIdObjId_First(userId, classNameId,
			objId, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUserIdClassNameIdObjId_Last(
		long userId, long classNameId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUserIdClassNameIdObjId_Last(userId, classNameId,
			objId, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUserIdClassNameIdObjId_Last(
		long userId, long classNameId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdClassNameIdObjId_Last(userId, classNameId,
			objId, orderByComparator);
	}

	/**
	* Returns the attr rates before and after the current attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param spAttrRateId the primary key of the current attr rate
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate[] findByUserIdClassNameIdObjId_PrevAndNext(
		long spAttrRateId, long userId, long classNameId,
		java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUserIdClassNameIdObjId_PrevAndNext(spAttrRateId,
			userId, classNameId, objId, orderByComparator);
	}

	/**
	* Removes all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63; from the database.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdClassNameIdObjId(long userId,
		long classNameId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByUserIdClassNameIdObjId(userId, classNameId, objId);
	}

	/**
	* Returns the number of attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param objId the obj ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdClassNameIdObjId(long userId,
		long classNameId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdClassNameIdObjId(userId, classNameId, objId);
	}

	/**
	* Returns the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUserIdClassNameIdRatingAttrIdObjId(
		long userId, long classNameId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUserIdClassNameIdRatingAttrIdObjId(userId,
			classNameId, ratingAttrId, objId);
	}

	/**
	* Returns the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUserIdClassNameIdRatingAttrIdObjId(
		long userId, long classNameId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdClassNameIdRatingAttrIdObjId(userId,
			classNameId, ratingAttrId, objId);
	}

	/**
	* Returns the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUserIdClassNameIdRatingAttrIdObjId(
		long userId, long classNameId, long ratingAttrId,
		java.lang.String objId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdClassNameIdRatingAttrIdObjId(userId,
			classNameId, ratingAttrId, objId, retrieveFromCache);
	}

	/**
	* Removes the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; from the database.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the attr rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate removeByUserIdClassNameIdRatingAttrIdObjId(
		long userId, long classNameId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .removeByUserIdClassNameIdRatingAttrIdObjId(userId,
			classNameId, ratingAttrId, objId);
	}

	/**
	* Returns the number of attr rates where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdClassNameIdRatingAttrIdObjId(long userId,
		long classNameId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdClassNameIdRatingAttrIdObjId(userId,
			classNameId, ratingAttrId, objId);
	}

	/**
	* Returns the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	*
	* @param userId the user ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUserIdRatingAttrIdObjId(
		long userId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId);
	}

	/**
	* Returns the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUserIdRatingAttrIdObjId(
		long userId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId);
	}

	/**
	* Returns the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByUserIdRatingAttrIdObjId(
		long userId, long ratingAttrId, java.lang.String objId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId,
			retrieveFromCache);
	}

	/**
	* Removes the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; from the database.
	*
	* @param userId the user ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the attr rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate removeByUserIdRatingAttrIdObjId(
		long userId, long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .removeByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId);
	}

	/**
	* Returns the number of attr rates where userId = &#63; and ratingAttrId = &#63; and objId = &#63;.
	*
	* @param userId the user ID
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdRatingAttrIdObjId(long userId,
		long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId);
	}

	/**
	* Returns all the attr rates where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrIdObjId(
		long ratingAttrId, java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRatingAttrIdObjId(ratingAttrId, objId);
	}

	/**
	* Returns a range of all the attr rates where ratingAttrId = &#63; and objId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrIdObjId(
		long ratingAttrId, java.lang.String objId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRatingAttrIdObjId(ratingAttrId, objId, start, end);
	}

	/**
	* Returns an ordered range of all the attr rates where ratingAttrId = &#63; and objId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrIdObjId(
		long ratingAttrId, java.lang.String objId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRatingAttrIdObjId(ratingAttrId, objId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByRatingAttrIdObjId_First(
		long ratingAttrId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByRatingAttrIdObjId_First(ratingAttrId, objId,
			orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByRatingAttrIdObjId_First(
		long ratingAttrId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRatingAttrIdObjId_First(ratingAttrId, objId,
			orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByRatingAttrIdObjId_Last(
		long ratingAttrId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByRatingAttrIdObjId_Last(ratingAttrId, objId,
			orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByRatingAttrIdObjId_Last(
		long ratingAttrId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRatingAttrIdObjId_Last(ratingAttrId, objId,
			orderByComparator);
	}

	/**
	* Returns the attr rates before and after the current attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param spAttrRateId the primary key of the current attr rate
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate[] findByRatingAttrIdObjId_PrevAndNext(
		long spAttrRateId, long ratingAttrId, java.lang.String objId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByRatingAttrIdObjId_PrevAndNext(spAttrRateId,
			ratingAttrId, objId, orderByComparator);
	}

	/**
	* Removes all the attr rates where ratingAttrId = &#63; and objId = &#63; from the database.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRatingAttrIdObjId(long ratingAttrId,
		java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRatingAttrIdObjId(ratingAttrId, objId);
	}

	/**
	* Returns the number of attr rates where ratingAttrId = &#63; and objId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param objId the obj ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRatingAttrIdObjId(long ratingAttrId,
		java.lang.String objId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRatingAttrIdObjId(ratingAttrId, objId);
	}

	/**
	* Returns all the attr rates where ratingAttrId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @return the matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrId(
		long ratingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRatingAttrId(ratingAttrId);
	}

	/**
	* Returns a range of all the attr rates where ratingAttrId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingAttrId the rating attr ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrId(
		long ratingAttrId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRatingAttrId(ratingAttrId, start, end);
	}

	/**
	* Returns an ordered range of all the attr rates where ratingAttrId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingAttrId the rating attr ID
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrId(
		long ratingAttrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRatingAttrId(ratingAttrId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where ratingAttrId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByRatingAttrId_First(
		long ratingAttrId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByRatingAttrId_First(ratingAttrId, orderByComparator);
	}

	/**
	* Returns the first attr rate in the ordered set where ratingAttrId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByRatingAttrId_First(
		long ratingAttrId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRatingAttrId_First(ratingAttrId, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where ratingAttrId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByRatingAttrId_Last(
		long ratingAttrId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByRatingAttrId_Last(ratingAttrId, orderByComparator);
	}

	/**
	* Returns the last attr rate in the ordered set where ratingAttrId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByRatingAttrId_Last(
		long ratingAttrId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRatingAttrId_Last(ratingAttrId, orderByComparator);
	}

	/**
	* Returns the attr rates before and after the current attr rate in the ordered set where ratingAttrId = &#63;.
	*
	* @param spAttrRateId the primary key of the current attr rate
	* @param ratingAttrId the rating attr ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate[] findByRatingAttrId_PrevAndNext(
		long spAttrRateId, long ratingAttrId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence()
				   .findByRatingAttrId_PrevAndNext(spAttrRateId, ratingAttrId,
			orderByComparator);
	}

	/**
	* Removes all the attr rates where ratingAttrId = &#63; from the database.
	*
	* @param ratingAttrId the rating attr ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRatingAttrId(long ratingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRatingAttrId(ratingAttrId);
	}

	/**
	* Returns the number of attr rates where ratingAttrId = &#63;.
	*
	* @param ratingAttrId the rating attr ID
	* @return the number of matching attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRatingAttrId(long ratingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRatingAttrId(ratingAttrId);
	}

	/**
	* Caches the attr rate in the entity cache if it is enabled.
	*
	* @param attrRate the attr rate
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate) {
		getPersistence().cacheResult(attrRate);
	}

	/**
	* Caches the attr rates in the entity cache if it is enabled.
	*
	* @param attrRates the attr rates
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> attrRates) {
		getPersistence().cacheResult(attrRates);
	}

	/**
	* Creates a new attr rate with the primary key. Does not add the attr rate to the database.
	*
	* @param spAttrRateId the primary key for the new attr rate
	* @return the new attr rate
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate create(
		long spAttrRateId) {
		return getPersistence().create(spAttrRateId);
	}

	/**
	* Removes the attr rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAttrRateId the primary key of the attr rate
	* @return the attr rate that was removed
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate remove(
		long spAttrRateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence().remove(spAttrRateId);
	}

	public static com.sambaash.platform.srv.sprating.model.AttrRate updateImpl(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(attrRate);
	}

	/**
	* Returns the attr rate with the primary key or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	*
	* @param spAttrRateId the primary key of the attr rate
	* @return the attr rate
	* @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate findByPrimaryKey(
		long spAttrRateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchAttrRateException {
		return getPersistence().findByPrimaryKey(spAttrRateId);
	}

	/**
	* Returns the attr rate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAttrRateId the primary key of the attr rate
	* @return the attr rate, or <code>null</code> if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchByPrimaryKey(
		long spAttrRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spAttrRateId);
	}

	/**
	* Returns all the attr rates.
	*
	* @return the attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the attr rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the attr rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the attr rates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attr rates.
	*
	* @return the number of attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AttrRatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AttrRatePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.sprating.service.ClpSerializer.getServletContextName(),
					AttrRatePersistence.class.getName());

			ReferenceRegistry.registerReference(AttrRateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AttrRatePersistence persistence) {
	}

	private static AttrRatePersistence _persistence;
}