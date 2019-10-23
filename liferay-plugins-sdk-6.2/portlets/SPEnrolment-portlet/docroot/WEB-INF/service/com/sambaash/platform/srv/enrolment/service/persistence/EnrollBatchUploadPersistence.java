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

import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;

/**
 * The persistence interface for the enroll batch upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Baxture
 * @see EnrollBatchUploadPersistenceImpl
 * @see EnrollBatchUploadUtil
 * @generated
 */
public interface EnrollBatchUploadPersistence extends BasePersistence<EnrollBatchUpload> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnrollBatchUploadUtil} to access the enroll batch upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the enroll batch uploads where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @return the matching enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findByUploadTransactId(
		java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enroll batch uploads where uploadTransactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uploadTransactId the upload transact ID
	* @param start the lower bound of the range of enroll batch uploads
	* @param end the upper bound of the range of enroll batch uploads (not inclusive)
	* @return the range of matching enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findByUploadTransactId(
		java.lang.String uploadTransactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enroll batch uploads where uploadTransactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uploadTransactId the upload transact ID
	* @param start the lower bound of the range of enroll batch uploads
	* @param end the upper bound of the range of enroll batch uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findByUploadTransactId(
		java.lang.String uploadTransactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload findByUploadTransactId_First(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException;

	/**
	* Returns the first enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enroll batch upload, or <code>null</code> if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload fetchByUploadTransactId_First(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload findByUploadTransactId_Last(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException;

	/**
	* Returns the last enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enroll batch upload, or <code>null</code> if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload fetchByUploadTransactId_Last(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enroll batch uploads before and after the current enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadStatId the primary key of the current enroll batch upload
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload[] findByUploadTransactId_PrevAndNext(
		long uploadStatId, java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException;

	/**
	* Removes all the enroll batch uploads where uploadTransactId = &#63; from the database.
	*
	* @param uploadTransactId the upload transact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUploadTransactId(java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enroll batch uploads where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @return the number of matching enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public int countByUploadTransactId(java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the enroll batch upload in the entity cache if it is enabled.
	*
	* @param enrollBatchUpload the enroll batch upload
	*/
	public void cacheResult(
		com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload enrollBatchUpload);

	/**
	* Caches the enroll batch uploads in the entity cache if it is enabled.
	*
	* @param enrollBatchUploads the enroll batch uploads
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> enrollBatchUploads);

	/**
	* Creates a new enroll batch upload with the primary key. Does not add the enroll batch upload to the database.
	*
	* @param uploadStatId the primary key for the new enroll batch upload
	* @return the new enroll batch upload
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload create(
		long uploadStatId);

	/**
	* Removes the enroll batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uploadStatId the primary key of the enroll batch upload
	* @return the enroll batch upload that was removed
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload remove(
		long uploadStatId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException;

	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload updateImpl(
		com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload enrollBatchUpload)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enroll batch upload with the primary key or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException} if it could not be found.
	*
	* @param uploadStatId the primary key of the enroll batch upload
	* @return the enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload findByPrimaryKey(
		long uploadStatId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException;

	/**
	* Returns the enroll batch upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uploadStatId the primary key of the enroll batch upload
	* @return the enroll batch upload, or <code>null</code> if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload fetchByPrimaryKey(
		long uploadStatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enroll batch uploads.
	*
	* @return the enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enroll batch uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enroll batch uploads
	* @param end the upper bound of the range of enroll batch uploads (not inclusive)
	* @return the range of enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enroll batch uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enroll batch uploads
	* @param end the upper bound of the range of enroll batch uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enroll batch uploads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enroll batch uploads.
	*
	* @return the number of enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}