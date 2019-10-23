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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;

import java.util.List;

/**
 * The persistence utility for the enroll batch upload service. This utility wraps {@link EnrollBatchUploadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Baxture
 * @see EnrollBatchUploadPersistence
 * @see EnrollBatchUploadPersistenceImpl
 * @generated
 */
public class EnrollBatchUploadUtil {
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
	public static void clearCache(EnrollBatchUpload enrollBatchUpload) {
		getPersistence().clearCache(enrollBatchUpload);
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
	public static List<EnrollBatchUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EnrollBatchUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EnrollBatchUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EnrollBatchUpload update(EnrollBatchUpload enrollBatchUpload)
		throws SystemException {
		return getPersistence().update(enrollBatchUpload);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EnrollBatchUpload update(
		EnrollBatchUpload enrollBatchUpload, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(enrollBatchUpload, serviceContext);
	}

	/**
	* Returns all the enroll batch uploads where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @return the matching enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findByUploadTransactId(
		java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUploadTransactId(uploadTransactId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findByUploadTransactId(
		java.lang.String uploadTransactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUploadTransactId(uploadTransactId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findByUploadTransactId(
		java.lang.String uploadTransactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUploadTransactId(uploadTransactId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload findByUploadTransactId_First(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException {
		return getPersistence()
				   .findByUploadTransactId_First(uploadTransactId,
			orderByComparator);
	}

	/**
	* Returns the first enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enroll batch upload, or <code>null</code> if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload fetchByUploadTransactId_First(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUploadTransactId_First(uploadTransactId,
			orderByComparator);
	}

	/**
	* Returns the last enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload findByUploadTransactId_Last(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException {
		return getPersistence()
				   .findByUploadTransactId_Last(uploadTransactId,
			orderByComparator);
	}

	/**
	* Returns the last enroll batch upload in the ordered set where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enroll batch upload, or <code>null</code> if a matching enroll batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload fetchByUploadTransactId_Last(
		java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUploadTransactId_Last(uploadTransactId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload[] findByUploadTransactId_PrevAndNext(
		long uploadStatId, java.lang.String uploadTransactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException {
		return getPersistence()
				   .findByUploadTransactId_PrevAndNext(uploadStatId,
			uploadTransactId, orderByComparator);
	}

	/**
	* Removes all the enroll batch uploads where uploadTransactId = &#63; from the database.
	*
	* @param uploadTransactId the upload transact ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUploadTransactId(
		java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUploadTransactId(uploadTransactId);
	}

	/**
	* Returns the number of enroll batch uploads where uploadTransactId = &#63;.
	*
	* @param uploadTransactId the upload transact ID
	* @return the number of matching enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUploadTransactId(java.lang.String uploadTransactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUploadTransactId(uploadTransactId);
	}

	/**
	* Caches the enroll batch upload in the entity cache if it is enabled.
	*
	* @param enrollBatchUpload the enroll batch upload
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload enrollBatchUpload) {
		getPersistence().cacheResult(enrollBatchUpload);
	}

	/**
	* Caches the enroll batch uploads in the entity cache if it is enabled.
	*
	* @param enrollBatchUploads the enroll batch uploads
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> enrollBatchUploads) {
		getPersistence().cacheResult(enrollBatchUploads);
	}

	/**
	* Creates a new enroll batch upload with the primary key. Does not add the enroll batch upload to the database.
	*
	* @param uploadStatId the primary key for the new enroll batch upload
	* @return the new enroll batch upload
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload create(
		long uploadStatId) {
		return getPersistence().create(uploadStatId);
	}

	/**
	* Removes the enroll batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uploadStatId the primary key of the enroll batch upload
	* @return the enroll batch upload that was removed
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload remove(
		long uploadStatId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException {
		return getPersistence().remove(uploadStatId);
	}

	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload updateImpl(
		com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload enrollBatchUpload)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enrollBatchUpload);
	}

	/**
	* Returns the enroll batch upload with the primary key or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException} if it could not be found.
	*
	* @param uploadStatId the primary key of the enroll batch upload
	* @return the enroll batch upload
	* @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload findByPrimaryKey(
		long uploadStatId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException {
		return getPersistence().findByPrimaryKey(uploadStatId);
	}

	/**
	* Returns the enroll batch upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uploadStatId the primary key of the enroll batch upload
	* @return the enroll batch upload, or <code>null</code> if a enroll batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload fetchByPrimaryKey(
		long uploadStatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(uploadStatId);
	}

	/**
	* Returns all the enroll batch uploads.
	*
	* @return the enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enroll batch uploads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enroll batch uploads.
	*
	* @return the number of enroll batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnrollBatchUploadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnrollBatchUploadPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.enrolment.service.ClpSerializer.getServletContextName(),
					EnrollBatchUploadPersistence.class.getName());

			ReferenceRegistry.registerReference(EnrollBatchUploadUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EnrollBatchUploadPersistence persistence) {
	}

	private static EnrollBatchUploadPersistence _persistence;
}