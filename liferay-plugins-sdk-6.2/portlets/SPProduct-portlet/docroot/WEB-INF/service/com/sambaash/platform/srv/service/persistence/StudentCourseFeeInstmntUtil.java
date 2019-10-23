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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.StudentCourseFeeInstmnt;

import java.util.List;

/**
 * The persistence utility for the student course fee instmnt service. This utility wraps {@link StudentCourseFeeInstmntPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmntPersistence
 * @see StudentCourseFeeInstmntPersistenceImpl
 * @generated
 */
public class StudentCourseFeeInstmntUtil {
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
	public static void clearCache(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		getPersistence().clearCache(studentCourseFeeInstmnt);
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
	public static List<StudentCourseFeeInstmnt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudentCourseFeeInstmnt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudentCourseFeeInstmnt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StudentCourseFeeInstmnt update(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws SystemException {
		return getPersistence().update(studentCourseFeeInstmnt);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StudentCourseFeeInstmnt update(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(studentCourseFeeInstmnt, serviceContext);
	}

	/**
	* Returns all the student course fee instmnts where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findByprocessStateId(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByprocessStateId(spPEProcessStateId);
	}

	/**
	* Returns a range of all the student course fee instmnts where spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of student course fee instmnts
	* @param end the upper bound of the range of student course fee instmnts (not inclusive)
	* @return the range of matching student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findByprocessStateId(
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByprocessStateId(spPEProcessStateId, start, end);
	}

	/**
	* Returns an ordered range of all the student course fee instmnts where spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of student course fee instmnts
	* @param end the upper bound of the range of student course fee instmnts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findByprocessStateId(
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByprocessStateId(spPEProcessStateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student course fee instmnt
	* @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt findByprocessStateId_First(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence()
				   .findByprocessStateId_First(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the first student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchByprocessStateId_First(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStateId_First(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the last student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student course fee instmnt
	* @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt findByprocessStateId_Last(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence()
				   .findByprocessStateId_Last(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the last student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchByprocessStateId_Last(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStateId_Last(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the student course fee instmnts before and after the current student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the current student course fee instmnt
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student course fee instmnt
	* @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt[] findByprocessStateId_PrevAndNext(
		long spStudentCourseFeeInstmntId, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence()
				   .findByprocessStateId_PrevAndNext(spStudentCourseFeeInstmntId,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Removes all the student course fee instmnts where spPEProcessStateId = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByprocessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByprocessStateId(spPEProcessStateId);
	}

	/**
	* Returns the number of student course fee instmnts where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByprocessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByprocessStateId(spPEProcessStateId);
	}

	/**
	* Returns the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException} if it could not be found.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param insmntNo the insmnt no
	* @return the matching student course fee instmnt
	* @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt findByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence()
				   .findByprocessStateIdInsmntNo(spPEProcessStateId, insmntNo);
	}

	/**
	* Returns the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param insmntNo the insmnt no
	* @return the matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStateIdInsmntNo(spPEProcessStateId, insmntNo);
	}

	/**
	* Returns the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param insmntNo the insmnt no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStateIdInsmntNo(spPEProcessStateId, insmntNo,
			retrieveFromCache);
	}

	/**
	* Removes the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param insmntNo the insmnt no
	* @return the student course fee instmnt that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt removeByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence()
				   .removeByprocessStateIdInsmntNo(spPEProcessStateId, insmntNo);
	}

	/**
	* Returns the number of student course fee instmnts where spPEProcessStateId = &#63; and insmntNo = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param insmntNo the insmnt no
	* @return the number of matching student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByprocessStateIdInsmntNo(long spPEProcessStateId,
		int insmntNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByprocessStateIdInsmntNo(spPEProcessStateId, insmntNo);
	}

	/**
	* Caches the student course fee instmnt in the entity cache if it is enabled.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		getPersistence().cacheResult(studentCourseFeeInstmnt);
	}

	/**
	* Caches the student course fee instmnts in the entity cache if it is enabled.
	*
	* @param studentCourseFeeInstmnts the student course fee instmnts
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> studentCourseFeeInstmnts) {
		getPersistence().cacheResult(studentCourseFeeInstmnts);
	}

	/**
	* Creates a new student course fee instmnt with the primary key. Does not add the student course fee instmnt to the database.
	*
	* @param spStudentCourseFeeInstmntId the primary key for the new student course fee instmnt
	* @return the new student course fee instmnt
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt create(
		long spStudentCourseFeeInstmntId) {
		return getPersistence().create(spStudentCourseFeeInstmntId);
	}

	/**
	* Removes the student course fee instmnt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt that was removed
	* @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt remove(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence().remove(spStudentCourseFeeInstmntId);
	}

	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt updateImpl(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(studentCourseFeeInstmnt);
	}

	/**
	* Returns the student course fee instmnt with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException} if it could not be found.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt
	* @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt findByPrimaryKey(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getPersistence().findByPrimaryKey(spStudentCourseFeeInstmntId);
	}

	/**
	* Returns the student course fee instmnt with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt, or <code>null</code> if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchByPrimaryKey(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spStudentCourseFeeInstmntId);
	}

	/**
	* Returns all the student course fee instmnts.
	*
	* @return the student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the student course fee instmnts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student course fee instmnts
	* @param end the upper bound of the range of student course fee instmnts (not inclusive)
	* @return the range of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the student course fee instmnts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student course fee instmnts
	* @param end the upper bound of the range of student course fee instmnts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the student course fee instmnts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of student course fee instmnts.
	*
	* @return the number of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudentCourseFeeInstmntPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudentCourseFeeInstmntPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					StudentCourseFeeInstmntPersistence.class.getName());

			ReferenceRegistry.registerReference(StudentCourseFeeInstmntUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StudentCourseFeeInstmntPersistence persistence) {
	}

	private static StudentCourseFeeInstmntPersistence _persistence;
}