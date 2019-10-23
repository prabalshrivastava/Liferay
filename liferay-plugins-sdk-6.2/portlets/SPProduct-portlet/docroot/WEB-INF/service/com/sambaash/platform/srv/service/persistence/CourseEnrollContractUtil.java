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

import com.sambaash.platform.srv.model.CourseEnrollContract;

import java.util.List;

/**
 * The persistence utility for the course enroll contract service. This utility wraps {@link CourseEnrollContractPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollContractPersistence
 * @see CourseEnrollContractPersistenceImpl
 * @generated
 */
public class CourseEnrollContractUtil {
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
	public static void clearCache(CourseEnrollContract courseEnrollContract) {
		getPersistence().clearCache(courseEnrollContract);
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
	public static List<CourseEnrollContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseEnrollContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseEnrollContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CourseEnrollContract update(
		CourseEnrollContract courseEnrollContract) throws SystemException {
		return getPersistence().update(courseEnrollContract);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CourseEnrollContract update(
		CourseEnrollContract courseEnrollContract, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(courseEnrollContract, serviceContext);
	}

	/**
	* Returns all the course enroll contracts where countryId = &#63; and courseType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @return the matching course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> findBycountryIdCourseType(
		java.lang.String countryId, long courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycountryIdCourseType(countryId, courseType);
	}

	/**
	* Returns a range of all the course enroll contracts where countryId = &#63; and courseType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param start the lower bound of the range of course enroll contracts
	* @param end the upper bound of the range of course enroll contracts (not inclusive)
	* @return the range of matching course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> findBycountryIdCourseType(
		java.lang.String countryId, long courseType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycountryIdCourseType(countryId, courseType, start, end);
	}

	/**
	* Returns an ordered range of all the course enroll contracts where countryId = &#63; and courseType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param start the lower bound of the range of course enroll contracts
	* @param end the upper bound of the range of course enroll contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> findBycountryIdCourseType(
		java.lang.String countryId, long courseType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycountryIdCourseType(countryId, courseType, start,
			end, orderByComparator);
	}

	/**
	* Returns the first course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course enroll contract
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract findBycountryIdCourseType_First(
		java.lang.String countryId, long courseType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence()
				   .findBycountryIdCourseType_First(countryId, courseType,
			orderByComparator);
	}

	/**
	* Returns the first course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract fetchBycountryIdCourseType_First(
		java.lang.String countryId, long courseType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycountryIdCourseType_First(countryId, courseType,
			orderByComparator);
	}

	/**
	* Returns the last course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course enroll contract
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract findBycountryIdCourseType_Last(
		java.lang.String countryId, long courseType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence()
				   .findBycountryIdCourseType_Last(countryId, courseType,
			orderByComparator);
	}

	/**
	* Returns the last course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract fetchBycountryIdCourseType_Last(
		java.lang.String countryId, long courseType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycountryIdCourseType_Last(countryId, courseType,
			orderByComparator);
	}

	/**
	* Returns the course enroll contracts before and after the current course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	*
	* @param spCourseContractId the primary key of the current course enroll contract
	* @param countryId the country ID
	* @param courseType the course type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course enroll contract
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract[] findBycountryIdCourseType_PrevAndNext(
		long spCourseContractId, java.lang.String countryId, long courseType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence()
				   .findBycountryIdCourseType_PrevAndNext(spCourseContractId,
			countryId, courseType, orderByComparator);
	}

	/**
	* Removes all the course enroll contracts where countryId = &#63; and courseType = &#63; from the database.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycountryIdCourseType(java.lang.String countryId,
		long courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycountryIdCourseType(countryId, courseType);
	}

	/**
	* Returns the number of course enroll contracts where countryId = &#63; and courseType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @return the number of matching course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycountryIdCourseType(java.lang.String countryId,
		long courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycountryIdCourseType(countryId, courseType);
	}

	/**
	* Returns the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollContractException} if it could not be found.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param docType the doc type
	* @return the matching course enroll contract
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract findBycountryIdCourseTypeDocType(
		java.lang.String countryId, long courseType, java.lang.String docType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence()
				   .findBycountryIdCourseTypeDocType(countryId, courseType,
			docType);
	}

	/**
	* Returns the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param docType the doc type
	* @return the matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract fetchBycountryIdCourseTypeDocType(
		java.lang.String countryId, long courseType, java.lang.String docType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycountryIdCourseTypeDocType(countryId, courseType,
			docType);
	}

	/**
	* Returns the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param docType the doc type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract fetchBycountryIdCourseTypeDocType(
		java.lang.String countryId, long courseType, java.lang.String docType,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycountryIdCourseTypeDocType(countryId, courseType,
			docType, retrieveFromCache);
	}

	/**
	* Removes the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; from the database.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param docType the doc type
	* @return the course enroll contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract removeBycountryIdCourseTypeDocType(
		java.lang.String countryId, long courseType, java.lang.String docType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence()
				   .removeBycountryIdCourseTypeDocType(countryId, courseType,
			docType);
	}

	/**
	* Returns the number of course enroll contracts where countryId = &#63; and courseType = &#63; and docType = &#63;.
	*
	* @param countryId the country ID
	* @param courseType the course type
	* @param docType the doc type
	* @return the number of matching course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycountryIdCourseTypeDocType(
		java.lang.String countryId, long courseType, java.lang.String docType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBycountryIdCourseTypeDocType(countryId, courseType,
			docType);
	}

	/**
	* Caches the course enroll contract in the entity cache if it is enabled.
	*
	* @param courseEnrollContract the course enroll contract
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.CourseEnrollContract courseEnrollContract) {
		getPersistence().cacheResult(courseEnrollContract);
	}

	/**
	* Caches the course enroll contracts in the entity cache if it is enabled.
	*
	* @param courseEnrollContracts the course enroll contracts
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> courseEnrollContracts) {
		getPersistence().cacheResult(courseEnrollContracts);
	}

	/**
	* Creates a new course enroll contract with the primary key. Does not add the course enroll contract to the database.
	*
	* @param spCourseContractId the primary key for the new course enroll contract
	* @return the new course enroll contract
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract create(
		long spCourseContractId) {
		return getPersistence().create(spCourseContractId);
	}

	/**
	* Removes the course enroll contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseContractId the primary key of the course enroll contract
	* @return the course enroll contract that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract remove(
		long spCourseContractId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence().remove(spCourseContractId);
	}

	public static com.sambaash.platform.srv.model.CourseEnrollContract updateImpl(
		com.sambaash.platform.srv.model.CourseEnrollContract courseEnrollContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseEnrollContract);
	}

	/**
	* Returns the course enroll contract with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollContractException} if it could not be found.
	*
	* @param spCourseContractId the primary key of the course enroll contract
	* @return the course enroll contract
	* @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract findByPrimaryKey(
		long spCourseContractId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollContractException {
		return getPersistence().findByPrimaryKey(spCourseContractId);
	}

	/**
	* Returns the course enroll contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseContractId the primary key of the course enroll contract
	* @return the course enroll contract, or <code>null</code> if a course enroll contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseEnrollContract fetchByPrimaryKey(
		long spCourseContractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spCourseContractId);
	}

	/**
	* Returns all the course enroll contracts.
	*
	* @return the course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the course enroll contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course enroll contracts
	* @param end the upper bound of the range of course enroll contracts (not inclusive)
	* @return the range of course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the course enroll contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course enroll contracts
	* @param end the upper bound of the range of course enroll contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseEnrollContract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course enroll contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course enroll contracts.
	*
	* @return the number of course enroll contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseEnrollContractPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseEnrollContractPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					CourseEnrollContractPersistence.class.getName());

			ReferenceRegistry.registerReference(CourseEnrollContractUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CourseEnrollContractPersistence persistence) {
	}

	private static CourseEnrollContractPersistence _persistence;
}