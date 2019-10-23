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

import com.sambaash.platform.srv.model.CompetencyUnit;

/**
 * The persistence interface for the competency unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CompetencyUnitPersistenceImpl
 * @see CompetencyUnitUtil
 * @generated
 */
public interface CompetencyUnitPersistence extends BasePersistence<CompetencyUnit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompetencyUnitUtil} to access the competency unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the competency units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the first competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the last competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit[] findByGroupId_PrevAndNext(
		long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Removes all the competency units where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of competency units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the competency units where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupId(
		long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit[] findByCountryIdAndGroupId_PrevAndNext(
		long spCompetencyUnitId, long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Removes all the competency units where countryId = &#63; and groupId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of competency units where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @return the matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupIdAndFrameworkId_First(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupIdAndFrameworkId_First(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit findByCountryIdAndGroupIdAndFrameworkId_Last(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByCountryIdAndGroupIdAndFrameworkId_Last(
		long countryId, long groupId, long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.CompetencyUnit[] findByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(
		long spCompetencyUnitId, long countryId, long groupId,
		long spFrameworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Removes all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryIdAndGroupIdAndFrameworkId(long countryId,
		long groupId, long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spFrameworkId the sp framework ID
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryIdAndGroupIdAndFrameworkId(long countryId,
		long groupId, long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the competency unit where competencyUnitCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCompetencyUnitException} if it could not be found.
	*
	* @param competencyUnitCode the competency unit code
	* @return the matching competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit findByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the competency unit where competencyUnitCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param competencyUnitCode the competency unit code
	* @return the matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the competency unit where competencyUnitCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param competencyUnitCode the competency unit code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching competency unit, or <code>null</code> if a matching competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByCompetencyUnitCode(
		java.lang.String competencyUnitCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the competency unit where competencyUnitCode = &#63; from the database.
	*
	* @param competencyUnitCode the competency unit code
	* @return the competency unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit removeByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the number of competency units where competencyUnitCode = &#63;.
	*
	* @param competencyUnitCode the competency unit code
	* @return the number of matching competency units
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompetencyUnitCode(java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the competency unit in the entity cache if it is enabled.
	*
	* @param competencyUnit the competency unit
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit);

	/**
	* Caches the competency units in the entity cache if it is enabled.
	*
	* @param competencyUnits the competency units
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> competencyUnits);

	/**
	* Creates a new competency unit with the primary key. Does not add the competency unit to the database.
	*
	* @param spCompetencyUnitId the primary key for the new competency unit
	* @return the new competency unit
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit create(
		long spCompetencyUnitId);

	/**
	* Removes the competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit that was removed
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit remove(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	public com.sambaash.platform.srv.model.CompetencyUnit updateImpl(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the competency unit with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCompetencyUnitException} if it could not be found.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit
	* @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit findByPrimaryKey(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException;

	/**
	* Returns the competency unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit, or <code>null</code> if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CompetencyUnit fetchByPrimaryKey(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the competency units.
	*
	* @return the competency units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the competency units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of competency units.
	*
	* @return the number of competency units
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}