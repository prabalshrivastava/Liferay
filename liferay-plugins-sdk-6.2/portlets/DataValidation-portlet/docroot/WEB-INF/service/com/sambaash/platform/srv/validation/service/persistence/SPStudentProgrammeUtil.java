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

import com.sambaash.platform.srv.validation.model.SPStudentProgramme;

import java.util.List;

/**
 * The persistence utility for the s p student programme service. This utility wraps {@link SPStudentProgrammePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammePersistence
 * @see SPStudentProgrammePersistenceImpl
 * @generated
 */
public class SPStudentProgrammeUtil {
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
	public static void clearCache(SPStudentProgramme spStudentProgramme) {
		getPersistence().clearCache(spStudentProgramme);
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
	public static List<SPStudentProgramme> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPStudentProgramme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPStudentProgramme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPStudentProgramme update(
		SPStudentProgramme spStudentProgramme) throws SystemException {
		return getPersistence().update(spStudentProgramme);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPStudentProgramme update(
		SPStudentProgramme spStudentProgramme, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spStudentProgramme, serviceContext);
	}

	/**
	* Returns all the s p student programmes where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @return the matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNricAndProgramme(nric, programme);
	}

	/**
	* Returns a range of all the s p student programmes where nric = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nric the nric
	* @param programme the programme
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @return the range of matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNricAndProgramme(nric, programme, start, end);
	}

	/**
	* Returns an ordered range of all the s p student programmes where nric = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nric the nric
	* @param programme the programme
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNricAndProgramme(nric, programme, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme findByNricAndProgramme_First(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence()
				   .findByNricAndProgramme_First(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the first s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme fetchByNricAndProgramme_First(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNricAndProgramme_First(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the last s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme findByNricAndProgramme_Last(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence()
				   .findByNricAndProgramme_Last(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the last s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme fetchByNricAndProgramme_Last(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNricAndProgramme_Last(nric, programme,
			orderByComparator);
	}

	/**
	* Returns the s p student programmes before and after the current s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param spStudentCourseId the primary key of the current s p student programme
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme[] findByNricAndProgramme_PrevAndNext(
		long spStudentCourseId, java.lang.String nric,
		java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence()
				   .findByNricAndProgramme_PrevAndNext(spStudentCourseId, nric,
			programme, orderByComparator);
	}

	/**
	* Removes all the s p student programmes where nric = &#63; and programme = &#63; from the database.
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
	* Returns the number of s p student programmes where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @return the number of matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNricAndProgramme(java.lang.String nric,
		java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNricAndProgramme(nric, programme);
	}

	/**
	* Returns all the s p student programmes where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @return the matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddressAndProgramme(emailAddress, programme);
	}

	/**
	* Returns a range of all the s p student programmes where emailAddress = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @return the range of matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddressAndProgramme(emailAddress, programme,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p student programmes where emailAddress = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddressAndProgramme(emailAddress, programme,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme findByEmailAddressAndProgramme_First(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence()
				   .findByEmailAddressAndProgramme_First(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the first s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme fetchByEmailAddressAndProgramme_First(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndProgramme_First(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the last s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme findByEmailAddressAndProgramme_Last(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence()
				   .findByEmailAddressAndProgramme_Last(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the last s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme fetchByEmailAddressAndProgramme_Last(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndProgramme_Last(emailAddress,
			programme, orderByComparator);
	}

	/**
	* Returns the s p student programmes before and after the current s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param spStudentCourseId the primary key of the current s p student programme
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme[] findByEmailAddressAndProgramme_PrevAndNext(
		long spStudentCourseId, java.lang.String emailAddress,
		java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence()
				   .findByEmailAddressAndProgramme_PrevAndNext(spStudentCourseId,
			emailAddress, programme, orderByComparator);
	}

	/**
	* Removes all the s p student programmes where emailAddress = &#63; and programme = &#63; from the database.
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
	* Returns the number of s p student programmes where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @return the number of matching s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEmailAddressAndProgramme(emailAddress, programme);
	}

	/**
	* Caches the s p student programme in the entity cache if it is enabled.
	*
	* @param spStudentProgramme the s p student programme
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme) {
		getPersistence().cacheResult(spStudentProgramme);
	}

	/**
	* Caches the s p student programmes in the entity cache if it is enabled.
	*
	* @param spStudentProgrammes the s p student programmes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> spStudentProgrammes) {
		getPersistence().cacheResult(spStudentProgrammes);
	}

	/**
	* Creates a new s p student programme with the primary key. Does not add the s p student programme to the database.
	*
	* @param spStudentCourseId the primary key for the new s p student programme
	* @return the new s p student programme
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme create(
		long spStudentCourseId) {
		return getPersistence().create(spStudentCourseId);
	}

	/**
	* Removes the s p student programme with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseId the primary key of the s p student programme
	* @return the s p student programme that was removed
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme remove(
		long spStudentCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence().remove(spStudentCourseId);
	}

	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme updateImpl(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spStudentProgramme);
	}

	/**
	* Returns the s p student programme with the primary key or throws a {@link com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException} if it could not be found.
	*
	* @param spStudentCourseId the primary key of the s p student programme
	* @return the s p student programme
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme findByPrimaryKey(
		long spStudentCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException {
		return getPersistence().findByPrimaryKey(spStudentCourseId);
	}

	/**
	* Returns the s p student programme with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spStudentCourseId the primary key of the s p student programme
	* @return the s p student programme, or <code>null</code> if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.validation.model.SPStudentProgramme fetchByPrimaryKey(
		long spStudentCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spStudentCourseId);
	}

	/**
	* Returns all the s p student programmes.
	*
	* @return the s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p student programmes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @return the range of s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p student programmes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p student programmes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p student programmes.
	*
	* @return the number of s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPStudentProgrammePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPStudentProgrammePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.validation.service.ClpSerializer.getServletContextName(),
					SPStudentProgrammePersistence.class.getName());

			ReferenceRegistry.registerReference(SPStudentProgrammeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPStudentProgrammePersistence persistence) {
	}

	private static SPStudentProgrammePersistence _persistence;
}