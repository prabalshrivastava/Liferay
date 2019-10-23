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

import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;

/**
 * The persistence interface for the class master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see ClassMasterPersistenceImpl
 * @see ClassMasterUtil
 * @generated
 */
public interface ClassMasterPersistence extends BasePersistence<ClassMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClassMasterUtil} to access the class master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the class masters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the class masters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @return the range of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the class masters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first class master in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the first class master in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last class master in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the last class master in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class masters before and after the current class master in the ordered set where uuid = &#63;.
	*
	* @param spClassId the primary key of the current class master
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster[] findByUuid_PrevAndNext(
		long spClassId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Removes all the class masters where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of class masters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class master where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the class master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the class master where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the class master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the number of class masters where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the class masters where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the class masters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @return the range of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the class masters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first class master in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the first class master in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last class master in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the last class master in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class masters before and after the current class master in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spClassId the primary key of the current class master
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster[] findByUuid_C_PrevAndNext(
		long spClassId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Removes all the class masters where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of class masters where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class master where code = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException} if it could not be found.
	*
	* @param code the code
	* @param country the country
	* @return the matching class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByCodeCountry(
		java.lang.String code, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the class master where code = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @param country the country
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByCodeCountry(
		java.lang.String code, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class master where code = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param country the country
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByCodeCountry(
		java.lang.String code, java.lang.String country,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the class master where code = &#63; and country = &#63; from the database.
	*
	* @param code the code
	* @param country the country
	* @return the class master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster removeByCodeCountry(
		java.lang.String code, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the number of class masters where code = &#63; and country = &#63;.
	*
	* @param code the code
	* @param country the country
	* @return the number of matching class masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByCodeCountry(java.lang.String code,
		java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the class master in the entity cache if it is enabled.
	*
	* @param classMaster the class master
	*/
	public void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster);

	/**
	* Caches the class masters in the entity cache if it is enabled.
	*
	* @param classMasters the class masters
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> classMasters);

	/**
	* Creates a new class master with the primary key. Does not add the class master to the database.
	*
	* @param spClassId the primary key for the new class master
	* @return the new class master
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster create(
		long spClassId);

	/**
	* Removes the class master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spClassId the primary key of the class master
	* @return the class master that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster remove(
		long spClassId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the class master with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException} if it could not be found.
	*
	* @param spClassId the primary key of the class master
	* @return the class master
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByPrimaryKey(
		long spClassId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;

	/**
	* Returns the class master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spClassId the primary key of the class master
	* @return the class master, or <code>null</code> if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchByPrimaryKey(
		long spClassId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the class masters.
	*
	* @return the class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the class masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @return the range of class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the class masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of class masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the class masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of class masters.
	*
	* @return the number of class masters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}