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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.legalandcontract.model.Agency;

/**
 * The persistence interface for the agency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see AgencyPersistenceImpl
 * @see AgencyUtil
 * @generated
 */
public interface AgencyPersistence extends BasePersistence<Agency> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgencyUtil} to access the agency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the agencies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the first agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the last agency in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.Agency[] findByUuid_PrevAndNext(
		long spAgencyId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Removes all the agencies where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of agencies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agency where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the agency where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agency where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the agency where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the number of agencies where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the agencies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the first agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the last agency in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.Agency[] findByUuid_C_PrevAndNext(
		long spAgencyId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Removes all the agencies where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of agencies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the agency where number = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the agency where number = &#63; and country = &#63; and version = &#63; from the database.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency removeByNumberCountryVersion(
		java.lang.String number, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the number of agencies where number = &#63; and country = &#63; and version = &#63;.
	*
	* @param number the number
	* @param country the country
	* @param version the version
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByNumberCountryVersion(java.lang.String number,
		java.lang.String country, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agency where number = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param number the number
	* @param country the country
	* @return the matching agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByNumberCountry(
		java.lang.String number, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the agency where number = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param number the number
	* @param country the country
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountry(
		java.lang.String number, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agency where number = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param number the number
	* @param country the country
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByNumberCountry(
		java.lang.String number, java.lang.String country,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the agency where number = &#63; and country = &#63; from the database.
	*
	* @param number the number
	* @param country the country
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency removeByNumberCountry(
		java.lang.String number, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the number of agencies where number = &#63; and country = &#63;.
	*
	* @param number the number
	* @param country the country
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByNumberCountry(java.lang.String number,
		java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the agency in the entity cache if it is enabled.
	*
	* @param agency the agency
	*/
	public void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency);

	/**
	* Caches the agencies in the entity cache if it is enabled.
	*
	* @param agencies the agencies
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> agencies);

	/**
	* Creates a new agency with the primary key. Does not add the agency to the database.
	*
	* @param spAgencyId the primary key for the new agency
	* @return the new agency
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency create(
		long spAgencyId);

	/**
	* Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency remove(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	public com.sambaash.platform.srv.legalandcontract.model.Agency updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agency with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByPrimaryKey(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;

	/**
	* Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency, or <code>null</code> if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchByPrimaryKey(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the agencies.
	*
	* @return the agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the agencies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of agencies.
	*
	* @return the number of agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}