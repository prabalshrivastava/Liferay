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

package com.sambaash.platform.srv.legalandcontract.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.legalandcontract.model.Agency;

import java.util.List;

/**
 * The persistence utility for the agency service. This utility wraps {@link AgencyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see AgencyPersistence
 * @see AgencyPersistenceImpl
 * @generated
 */
public class AgencyUtil {
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
	public static void clearCache(Agency agency) {
		getPersistence().clearCache(agency);
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
	public static List<Agency> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Agency> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Agency> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Agency update(Agency agency) throws SystemException {
		return getPersistence().update(agency);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Agency update(Agency agency, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(agency, serviceContext);
	}

	/**
	* Returns all the agencies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the agencies where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the agencies where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the agencies before and after the current agency in the ordered set where uuid = &#63;.
	*
	* @param spAgencyId the primary key of the current agency
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency[] findByUuid_PrevAndNext(
		long spAgencyId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spAgencyId, uuid, orderByComparator);
	}

	/**
	* Removes all the agencies where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of agencies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the agency where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the agency where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the agency where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the agency where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of agencies where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the agencies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the agencies where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the agencies where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the agencies before and after the current agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spAgencyId the primary key of the current agency
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency[] findByUuid_C_PrevAndNext(
		long spAgencyId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spAgencyId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the agencies where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of agencies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the agency where number = &#63; and country = &#63; and version = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence()
				   .findByNumberCountryVersion(number, country, version);
	}

	/**
	* Returns the agency where number = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumberCountryVersion(number, country, version);
	}

	/**
	* Returns the agency where number = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumberCountryVersion(number, country, version,
			retrieveFromCache);
	}

	/**
	* Removes the agency where number = &#63; and country = &#63; and version = &#63; from the database.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency removeByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence()
				   .removeByNumberCountryVersion(number, country, version);
	}

	/**
	* Returns the number of agencies where number = &#63; and country = &#63; and version = &#63;.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNumberCountryVersion(java.lang.String number,
		java.lang.String country, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNumberCountryVersion(number, country, version);
	}

	/**
	* Returns the agency where number = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param number the number
	* @param country the country
	* @return the matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByNumberCountry(
		java.lang.String number, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().findByNumberCountry(number, country);
	}

	/**
	* Returns the agency where number = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param number the number
	* @param country the country
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountry(
		java.lang.String number, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNumberCountry(number, country);
	}

	/**
	* Returns the agency where number = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param number the number
	* @param country the country
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountry(
		java.lang.String number, java.lang.String country,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumberCountry(number, country, retrieveFromCache);
	}

	/**
	* Removes the agency where number = &#63; and country = &#63; from the database.
	*
	* @param number the number
	* @param country the country
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency removeByNumberCountry(
		java.lang.String number, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().removeByNumberCountry(number, country);
	}

	/**
	* Returns the number of agencies where number = &#63; and country = &#63;.
	*
	* @param number the number
	* @param country the country
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNumberCountry(java.lang.String number,
		java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNumberCountry(number, country);
	}

	/**
	* Caches the agency in the entity cache if it is enabled.
	*
	* @param agency the agency
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency) {
		getPersistence().cacheResult(agency);
	}

	/**
	* Caches the agencies in the entity cache if it is enabled.
	*
	* @param agencies the agencies
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> agencies) {
		getPersistence().cacheResult(agencies);
	}

	/**
	* Creates a new agency with the primary key. Does not add the agency to the database.
	*
	* @param spAgencyId the primary key for the new agency
	* @return the new agency
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency create(
		long spAgencyId) {
		return getPersistence().create(spAgencyId);
	}

	/**
	* Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency remove(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().remove(spAgencyId);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Agency updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(agency);
	}

	/**
	* Returns the agency with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByPrimaryKey(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException {
		return getPersistence().findByPrimaryKey(spAgencyId);
	}

	/**
	* Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency, or <code>null</code> if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchByPrimaryKey(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spAgencyId);
	}

	/**
	* Returns all the agencies.
	*
	* @return the agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the agencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the agencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the agencies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of agencies.
	*
	* @return the number of agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AgencyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AgencyPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.getServletContextName(),
					AgencyPersistence.class.getName());

			ReferenceRegistry.registerReference(AgencyUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AgencyPersistence persistence) {
	}

	private static AgencyPersistence _persistence;
}