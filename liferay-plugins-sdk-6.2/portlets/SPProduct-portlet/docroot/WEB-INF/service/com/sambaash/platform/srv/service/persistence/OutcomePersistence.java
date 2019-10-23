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

import com.sambaash.platform.srv.model.Outcome;

/**
 * The persistence interface for the outcome service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see OutcomePersistenceImpl
 * @see OutcomeUtil
 * @generated
 */
public interface OutcomePersistence extends BasePersistence<Outcome> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OutcomeUtil} to access the outcome persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the outcomes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the outcomes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @return the range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the outcomes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the first outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the last outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the outcomes before and after the current outcome in the ordered set where groupId = &#63;.
	*
	* @param spOutcomeId the primary key of the current outcome
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome[] findByGroupId_PrevAndNext(
		long spOutcomeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Removes all the outcomes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outcomes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outcomes where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupId(
		long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the outcomes where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @return the range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the outcomes where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the outcomes before and after the current outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param spOutcomeId the primary key of the current outcome
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome[] findByCountryIdAndGroupId_PrevAndNext(
		long spOutcomeId, long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Removes all the outcomes where countryId = &#63; and groupId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outcomes where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @return the range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupIdAndCompetencyUnitId_First(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupIdAndCompetencyUnitId_First(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupIdAndCompetencyUnitId_Last(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupIdAndCompetencyUnitId_Last(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the outcomes before and after the current outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param spOutcomeId the primary key of the current outcome
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome[] findByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutcomeId, long countryId, long groupId,
		long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Removes all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryIdAndGroupIdAndCompetencyUnitId(long countryId,
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryIdAndGroupIdAndCompetencyUnitId(long countryId,
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @return the range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the first outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the last outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the outcomes before and after the current outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param spOutcomeId the primary key of the current outcome
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome[] findByGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutcomeId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Removes all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the outcome in the entity cache if it is enabled.
	*
	* @param outcome the outcome
	*/
	public void cacheResult(com.sambaash.platform.srv.model.Outcome outcome);

	/**
	* Caches the outcomes in the entity cache if it is enabled.
	*
	* @param outcomes the outcomes
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Outcome> outcomes);

	/**
	* Creates a new outcome with the primary key. Does not add the outcome to the database.
	*
	* @param spOutcomeId the primary key for the new outcome
	* @return the new outcome
	*/
	public com.sambaash.platform.srv.model.Outcome create(long spOutcomeId);

	/**
	* Removes the outcome with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome that was removed
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome remove(long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	public com.sambaash.platform.srv.model.Outcome updateImpl(
		com.sambaash.platform.srv.model.Outcome outcome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the outcome with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchOutcomeException} if it could not be found.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome findByPrimaryKey(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException;

	/**
	* Returns the outcome with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome, or <code>null</code> if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outcome fetchByPrimaryKey(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outcomes.
	*
	* @return the outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the outcomes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @return the range of outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the outcomes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of outcomes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the outcomes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outcomes.
	*
	* @return the number of outcomes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}