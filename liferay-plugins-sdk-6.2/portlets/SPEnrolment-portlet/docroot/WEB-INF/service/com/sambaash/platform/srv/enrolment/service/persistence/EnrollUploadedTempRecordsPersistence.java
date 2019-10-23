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

package com.sambaash.platform.srv.enrolment.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords;

/**
 * The persistence interface for the enroll uploaded temp records service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Baxture
 * @see EnrollUploadedTempRecordsPersistenceImpl
 * @see EnrollUploadedTempRecordsUtil
 * @generated
 */
public interface EnrollUploadedTempRecordsPersistence extends BasePersistence<EnrollUploadedTempRecords> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnrollUploadedTempRecordsUtil} to access the enroll uploaded temp records persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the enroll uploaded temp records where uploadTransactId = &#63; or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException} if it could not be found.
	*
	* @param uploadTransactId the upload transact ID
	* @return the matching enroll uploaded temp records
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a matching enroll uploaded temp records could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords findByUploadTransactId(
		java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException;

	/**
	* Returns the enroll uploaded temp records where uploadTransactId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uploadTransactId the upload transact ID
	* @return the matching enroll uploaded temp records, or <code>null</code> if a matching enroll uploaded temp records could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords fetchByUploadTransactId(
		java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enroll uploaded temp records where uploadTransactId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uploadTransactId the upload transact ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching enroll uploaded temp records, or <code>null</code> if a matching enroll uploaded temp records could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords fetchByUploadTransactId(
		java.lang.String uploadTransactId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the enroll uploaded temp records where uploadTransactId = &#63; from the database.
	*
	* @param uploadTransactId the upload transact ID
	* @return the enroll uploaded temp records that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords removeByUploadTransactId(
		java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException;

	/**
	* Returns the number of enroll uploaded temp recordses where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @return the number of matching enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUploadTransactId(java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the enroll uploaded temp records in the entity cache if it is enabled.
	*
	* @param enrollUploadedTempRecords the enroll uploaded temp records
	*/
	public void cacheResult(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords);

	/**
	* Caches the enroll uploaded temp recordses in the entity cache if it is enabled.
	*
	* @param enrollUploadedTempRecordses the enroll uploaded temp recordses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> enrollUploadedTempRecordses);

	/**
	* Creates a new enroll uploaded temp records with the primary key. Does not add the enroll uploaded temp records to the database.
	*
	* @param uploadedRecId the primary key for the new enroll uploaded temp records
	* @return the new enroll uploaded temp records
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords create(
		long uploadedRecId);

	/**
	* Removes the enroll uploaded temp records with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uploadedRecId the primary key of the enroll uploaded temp records
	* @return the enroll uploaded temp records that was removed
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a enroll uploaded temp records with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords remove(
		long uploadedRecId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException;

	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords updateImpl(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enroll uploaded temp records with the primary key or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException} if it could not be found.
	*
	* @param uploadedRecId the primary key of the enroll uploaded temp records
	* @return the enroll uploaded temp records
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a enroll uploaded temp records with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords findByPrimaryKey(
		long uploadedRecId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException;

	/**
	* Returns the enroll uploaded temp records with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uploadedRecId the primary key of the enroll uploaded temp records
	* @return the enroll uploaded temp records, or <code>null</code> if a enroll uploaded temp records with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords fetchByPrimaryKey(
		long uploadedRecId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enroll uploaded temp recordses.
	*
	* @return the enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enroll uploaded temp recordses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enroll uploaded temp recordses
	* @param end the upper bound of the range of enroll uploaded temp recordses (not inclusive)
	* @return the range of enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enroll uploaded temp recordses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enroll uploaded temp recordses
	* @param end the upper bound of the range of enroll uploaded temp recordses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enroll uploaded temp recordses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enroll uploaded temp recordses.
	*
	* @return the number of enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}