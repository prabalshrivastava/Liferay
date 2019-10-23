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

package com.sambaash.platform.srv.validation.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult;

import java.util.List;

/**
 * The persistence utility for the s p student programme result service. This utility wraps {@link SPStudentProgrammeResultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeResultPersistence
 * @see SPStudentProgrammeResultPersistenceImpl
 * @generated
 */
public class SPStudentProgrammeResultUtil {
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
		SPStudentProgrammeResult spStudentProgrammeResult) {
		getPersistence().clearCache(spStudentProgrammeResult);
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
	public static List<SPStudentProgrammeResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPStudentProgrammeResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPStudentProgrammeResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPStudentProgrammeResult update(
		SPStudentProgrammeResult spStudentProgrammeResult)
		throws SystemException {
		return getPersistence().update(spStudentProgrammeResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPStudentProgrammeResult update(
		SPStudentProgrammeResult spStudentProgrammeResult,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spStudentProgrammeResult, serviceContext);
	}

	/**
	* Returns all the s p student programme results where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @return the matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNricAndProgramme(nric, programme);
	}

	/**
	* Returns a range of all the s p student programme results where nric = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nric the nric
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNricAndProgramme(nric, programme, start, end);
	}

	/**
	* Returns an ordered range of all the s p student programme results where nric = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nric the nric
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNricAndProgramme(nric, programme, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByNricAndProgramme_First(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence()
				   .findByNricAndProgramme_First(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the first s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByNricAndProgramme_First(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNricAndProgramme_First(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the last s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByNricAndProgramme_Last(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence()
				   .findByNricAndProgramme_Last(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the last s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByNricAndProgramme_Last(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNricAndProgramme_Last(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the s p student programme results before and after the current s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param spStudentProgrammeResultId the primary key of the current s p student programme result
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult[] findByNricAndProgramme_PrevAndNext(
		long spStudentProgrammeResultId, java.lang.String nric,
		java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence()
				   .findByNricAndProgramme_PrevAndNext(spStudentProgrammeResultId,
			nric, programme, orderByComparator);
	}

	/**
	* Removes all the s p student programme results where nric = &#63; and programme = &#63; from the database.
	*
	* @param nric the nric
	* @param programme the programme
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNricAndProgramme(java.lang.String nric,
		java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNricAndProgramme(nric, programme);
	}

	/**
	* Returns the number of s p student programme results where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @return the number of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNricAndProgramme(java.lang.String nric,
		java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNricAndProgramme(nric, programme);
	}

	/**
	* Returns all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @return the matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddressAndProgramme(emailAddress, programme);
	}

	/**
	* Returns a range of all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddressAndProgramme(emailAddress, programme,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddressAndProgramme(emailAddress, programme,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByEmailAddressAndProgramme_First(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence()
				   .findByEmailAddressAndProgramme_First(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the first s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByEmailAddressAndProgramme_First(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndProgramme_First(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the last s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByEmailAddressAndProgramme_Last(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence()
				   .findByEmailAddressAndProgramme_Last(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the last s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByEmailAddressAndProgramme_Last(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndProgramme_Last(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the s p student programme results before and after the current s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param spStudentProgrammeResultId the primary key of the current s p student programme result
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult[] findByEmailAddressAndProgramme_PrevAndNext(
		long spStudentProgrammeResultId, java.lang.String emailAddress,
		java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence()
				   .findByEmailAddressAndProgramme_PrevAndNext(spStudentProgrammeResultId,
			emailAddress, programme, orderByComparator);
	}

	/**
	* Removes all the s p student programme results where emailAddress = &#63; and programme = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByEmailAddressAndProgramme(emailAddress, programme);
	}

	/**
	* Returns the number of s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @return the number of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEmailAddressAndProgramme(emailAddress, programme);
	}

	/**
	* Caches the s p student programme result in the entity cache if it is enabled.
	*
	* @param spStudentProgrammeResult the s p student programme result
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult) {
		getPersistence().cacheResult(spStudentProgrammeResult);
	}

	/**
	* Caches the s p student programme results in the entity cache if it is enabled.
	*
	* @param spStudentProgrammeResults the s p student programme results
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> spStudentProgrammeResults) {
		getPersistence().cacheResult(spStudentProgrammeResults);
	}

	/**
	* Creates a new s p student programme result with the primary key. Does not add the s p student programme result to the database.
	*
	* @param spStudentProgrammeResultId the primary key for the new s p student programme result
	* @return the new s p student programme result
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult create(
		long spStudentProgrammeResultId) {
		return getPersistence().create(spStudentProgrammeResultId);
	}

	/**
	* Removes the s p student programme result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result that was removed
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult remove(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence().remove(spStudentProgrammeResultId);
	}

	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult updateImpl(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spStudentProgrammeResult);
	}

	/**
	* Returns the s p student programme result with the primary key or throws a {@link com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException} if it could not be found.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByPrimaryKey(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException {
		return getPersistence().findByPrimaryKey(spStudentProgrammeResultId);
	}

	/**
	* Returns the s p student programme result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result, or <code>null</code> if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByPrimaryKey(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spStudentProgrammeResultId);
	}

	/**
	* Returns all the s p student programme results.
	*
	* @return the s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p student programme results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p student programme results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p student programme results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p student programme results.
	*
	* @return the number of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPStudentProgrammeResultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPStudentProgrammeResultPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.validation.service.ClpSerializer.getServletContextName(),
					SPStudentProgrammeResultPersistence.class.getName());

			ReferenceRegistry.registerReference(SPStudentProgrammeResultUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPStudentProgrammeResultPersistence persistence) {
	}

	private static SPStudentProgrammeResultPersistence _persistence;
}