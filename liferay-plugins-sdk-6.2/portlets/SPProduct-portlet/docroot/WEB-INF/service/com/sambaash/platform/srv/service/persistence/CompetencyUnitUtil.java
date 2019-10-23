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

import com.sambaash.platform.srv.model.CompetencyUnit;

import java.util.List;

/**
 * The persistence utility for the competency unit service. This utility wraps {@link CompetencyUnitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CompetencyUnitPersistence
 * @see CompetencyUnitPersistenceImpl
 * @generated
 */
public class CompetencyUnitUtil {
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
	public static void clearCache(CompetencyUnit competencyUnit) {
		getPersistence().clearCache(competencyUnit);
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
	public static List<CompetencyUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompetencyUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompetencyUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CompetencyUnit update(CompetencyUnit competencyUnit)
		throws SystemException {
		return getPersistence().update(competencyUnit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CompetencyUnit update(CompetencyUnit competencyUnit,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(competencyUnit, serviceContext);
	}

	/**
	* Returns all the competency units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the competency units where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @return the range of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the competency units where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the competency units before and after the current competency unit in the ordered set where groupId = &#63;.
	*
	* @param spCompetencyUnitId the primary key of the current competency unit
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit[] findByGroupId_PrevAndNext(
		long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spCompetencyUnitId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the competency units where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of competency units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the competency units where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupId(
		long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns a range of all the competency units where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @return the range of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the competency units where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the competency units before and after the current competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the primary key of the current competency unit
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit[] findByCountryIdAndGroupId_PrevAndNext(
		long spCompetencyUnitId, long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByCountryIdAndGroupId_PrevAndNext(spCompetencyUnitId,
			countryId, groupId, orderByComparator);
	}

	/**
	* Removes all the competency units where countryId = &#63; and groupId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns the number of competency units where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @return the matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndFrameworkId(countryId, groupId,
			spFrameworkId);
	}

	/**
	* Returns a range of all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @return the range of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndFrameworkId(countryId, groupId,
			spFrameworkId, start, end);
	}

	/**
	* Returns an ordered range of all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndFrameworkId(countryId, groupId,
			spFrameworkId, start, end, orderByComparator);
	}

	/**
	* Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupIdAndFrameworkId_First(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndFrameworkId_First(countryId,
			groupId, spFrameworkId, orderByComparator);
	}

	/**
	* Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupIdAndFrameworkId_First(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupIdAndFrameworkId_First(countryId,
			groupId, spFrameworkId, orderByComparator);
	}

	/**
	* Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupIdAndFrameworkId_Last(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndFrameworkId_Last(countryId,
			groupId, spFrameworkId, orderByComparator);
	}

	/**
	* Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupIdAndFrameworkId_Last(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupIdAndFrameworkId_Last(countryId,
			groupId, spFrameworkId, orderByComparator);
	}

	/**
	* Returns the competency units before and after the current competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param spCompetencyUnitId the primary key of the current competency unit
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit[] findByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(
		long spCompetencyUnitId, long countryId, long groupId,
		long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(spCompetencyUnitId,
			countryId, groupId, spFrameworkId, orderByComparator);
	}

	/**
	* Removes all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCountryIdAndGroupIdAndFrameworkId(countryId, groupId,
			spFrameworkId);
	}

	/**
	* Returns the number of competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupIdAndFrameworkId(long countryId,
		long groupId, long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryIdAndGroupIdAndFrameworkId(countryId,
			groupId, spFrameworkId);
	}

	/**
	* Returns the competency unit where competencyUnitCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCompetencyUnitException} if it could not be found.
	*
	* @param competencyUnitCode the competency unit code
	* @return the matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence().findByCompetencyUnitCode(competencyUnitCode);
	}

	/**
	* Returns the competency unit where competencyUnitCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param competencyUnitCode the competency unit code
	* @return the matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompetencyUnitCode(competencyUnitCode);
	}

	/**
	* Returns the competency unit where competencyUnitCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param competencyUnitCode the competency unit code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByCompetencyUnitCode(
		java.lang.String competencyUnitCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyUnitCode(competencyUnitCode,
			retrieveFromCache);
	}

	/**
	* Removes the competency unit where competencyUnitCode = &#63; from the database.
	*
	* @param competencyUnitCode the competency unit code
	* @return the competency unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit removeByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence().removeByCompetencyUnitCode(competencyUnitCode);
	}

	/**
	* Returns the number of competency units where competencyUnitCode = &#63;.
	*
	* @param competencyUnitCode the competency unit code
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompetencyUnitCode(competencyUnitCode);
	}

	/**
	* Caches the competency unit in the entity cache if it is enabled.
	*
	* @param competencyUnit the competency unit
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit) {
		getPersistence().cacheResult(competencyUnit);
	}

	/**
	* Caches the competency units in the entity cache if it is enabled.
	*
	* @param competencyUnits the competency units
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> competencyUnits) {
		getPersistence().cacheResult(competencyUnits);
	}

	/**
	* Creates a new competency unit with the primary key. Does not add the competency unit to the database.
	*
	* @param spCompetencyUnitId the primary key for the new competency unit
	* @return the new competency unit
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit create(
		long spCompetencyUnitId) {
		return getPersistence().create(spCompetencyUnitId);
	}

	/**
	* Removes the competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit that was removed
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit remove(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence().remove(spCompetencyUnitId);
	}

	public static com.sambaash.platform.srv.model.CompetencyUnit updateImpl(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(competencyUnit);
	}

	/**
	* Returns the competency unit with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCompetencyUnitException} if it could not be found.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit findByPrimaryKey(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return getPersistence().findByPrimaryKey(spCompetencyUnitId);
	}

	/**
	* Returns the competency unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit, or <code>null</code> if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CompetencyUnit fetchByPrimaryKey(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spCompetencyUnitId);
	}

	/**
	* Returns all the competency units.
	*
	* @return the competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the competency units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @return the range of competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the competency units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the competency units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of competency units.
	*
	* @return the number of competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CompetencyUnitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CompetencyUnitPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					CompetencyUnitPersistence.class.getName());

			ReferenceRegistry.registerReference(CompetencyUnitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CompetencyUnitPersistence persistence) {
	}

	private static CompetencyUnitPersistence _persistence;
}