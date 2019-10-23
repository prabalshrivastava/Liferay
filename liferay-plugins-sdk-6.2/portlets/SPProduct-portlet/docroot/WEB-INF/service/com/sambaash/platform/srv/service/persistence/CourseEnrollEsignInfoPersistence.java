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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;

/**
 * The persistence interface for the course enroll esign info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollEsignInfoPersistenceImpl
 * @see CourseEnrollEsignInfoUtil
 * @generated
 */
public interface CourseEnrollEsignInfoPersistence extends BasePersistence<CourseEnrollEsignInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseEnrollEsignInfoUtil} to access the course enroll esign info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the course enroll esign info where signerId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	*
	* @param signerId the signer ID
	* @return the matching course enroll esign info
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findBySignerId(
		java.lang.String signerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the course enroll esign info where signerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param signerId the signer ID
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchBySignerId(
		java.lang.String signerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where signerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param signerId the signer ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchBySignerId(
		java.lang.String signerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course enroll esign info where signerId = &#63; from the database.
	*
	* @param signerId the signer ID
	* @return the course enroll esign info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo removeBySignerId(
		java.lang.String signerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the number of course enroll esign infos where signerId = &#63;.
	*
	* @param signerId the signer ID
	* @return the number of matching course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public int countBySignerId(java.lang.String signerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where packageId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	*
	* @param packageId the package ID
	* @return the matching course enroll esign info
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByPackageId(
		java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the course enroll esign info where packageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param packageId the package ID
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByPackageId(
		java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where packageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param packageId the package ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByPackageId(
		java.lang.String packageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course enroll esign info where packageId = &#63; from the database.
	*
	* @param packageId the package ID
	* @return the course enroll esign info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo removeByPackageId(
		java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the number of course enroll esign infos where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the number of matching course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByPackageId(java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where documentId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	*
	* @param documentId the document ID
	* @return the matching course enroll esign info
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByDocumentId(
		java.lang.String documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the course enroll esign info where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param documentId the document ID
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByDocumentId(
		java.lang.String documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param documentId the document ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByDocumentId(
		java.lang.String documentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course enroll esign info where documentId = &#63; from the database.
	*
	* @param documentId the document ID
	* @return the course enroll esign info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo removeByDocumentId(
		java.lang.String documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the number of course enroll esign infos where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the number of matching course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByDocumentId(java.lang.String documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where spPEProcessStateId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching course enroll esign info
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByProcessStateId(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the course enroll esign info where spPEProcessStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByProcessStateId(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info where spPEProcessStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByProcessStateId(
		long spPEProcessStateId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course enroll esign info where spPEProcessStateId = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the course enroll esign info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo removeByProcessStateId(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the number of course enroll esign infos where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByProcessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course enroll esign info in the entity cache if it is enabled.
	*
	* @param courseEnrollEsignInfo the course enroll esign info
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo);

	/**
	* Caches the course enroll esign infos in the entity cache if it is enabled.
	*
	* @param courseEnrollEsignInfos the course enroll esign infos
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> courseEnrollEsignInfos);

	/**
	* Creates a new course enroll esign info with the primary key. Does not add the course enroll esign info to the database.
	*
	* @param spEsignInfoId the primary key for the new course enroll esign info
	* @return the new course enroll esign info
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo create(
		long spEsignInfoId);

	/**
	* Removes the course enroll esign info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spEsignInfoId the primary key of the course enroll esign info
	* @return the course enroll esign info that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a course enroll esign info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo remove(
		long spEsignInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo updateImpl(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course enroll esign info with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	*
	* @param spEsignInfoId the primary key of the course enroll esign info
	* @return the course enroll esign info
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a course enroll esign info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByPrimaryKey(
		long spEsignInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;

	/**
	* Returns the course enroll esign info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spEsignInfoId the primary key of the course enroll esign info
	* @return the course enroll esign info, or <code>null</code> if a course enroll esign info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchByPrimaryKey(
		long spEsignInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course enroll esign infos.
	*
	* @return the course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course enroll esign infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course enroll esign infos
	* @param end the upper bound of the range of course enroll esign infos (not inclusive)
	* @return the range of course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course enroll esign infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course enroll esign infos
	* @param end the upper bound of the range of course enroll esign infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course enroll esign infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course enroll esign infos.
	*
	* @return the number of course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}