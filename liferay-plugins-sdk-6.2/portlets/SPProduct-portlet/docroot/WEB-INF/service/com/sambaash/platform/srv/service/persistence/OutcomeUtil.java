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

import com.sambaash.platform.srv.model.Outcome;

import java.util.List;

/**
 * The persistence utility for the outcome service. This utility wraps {@link OutcomePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see OutcomePersistence
 * @see OutcomePersistenceImpl
 * @generated
 */
public class OutcomeUtil {
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
	public static void clearCache(Outcome outcome) {
		getPersistence().clearCache(outcome);
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
	public static List<Outcome> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Outcome> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Outcome> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Outcome update(Outcome outcome) throws SystemException {
		return getPersistence().update(outcome);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Outcome update(Outcome outcome, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(outcome, serviceContext);
	}

	/**
	* Returns all the outcomes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last outcome in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome[] findByGroupId_PrevAndNext(
		long spOutcomeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spOutcomeId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the outcomes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of outcomes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the outcomes where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupId(
		long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryIdAndGroupId(countryId, groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome[] findByCountryIdAndGroupId_PrevAndNext(
		long spOutcomeId, long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByCountryIdAndGroupId_PrevAndNext(spOutcomeId,
			countryId, groupId, orderByComparator);
	}

	/**
	* Removes all the outcomes where countryId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of outcomes where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
			groupId, spCompetencyUnitId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
			groupId, spCompetencyUnitId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
			groupId, spCompetencyUnitId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupIdAndCompetencyUnitId_First(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndCompetencyUnitId_First(countryId,
			groupId, spCompetencyUnitId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupIdAndCompetencyUnitId_First(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupIdAndCompetencyUnitId_First(countryId,
			groupId, spCompetencyUnitId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome findByCountryIdAndGroupIdAndCompetencyUnitId_Last(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndCompetencyUnitId_Last(countryId,
			groupId, spCompetencyUnitId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome fetchByCountryIdAndGroupIdAndCompetencyUnitId_Last(
		long countryId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupIdAndCompetencyUnitId_Last(countryId,
			groupId, spCompetencyUnitId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome[] findByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutcomeId, long countryId, long groupId,
		long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(spOutcomeId,
			countryId, groupId, spCompetencyUnitId, orderByComparator);
	}

	/**
	* Removes all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCountryIdAndGroupIdAndCompetencyUnitId(countryId, groupId,
			spCompetencyUnitId);
	}

	/**
	* Returns the number of outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
			groupId, spCompetencyUnitId);
	}

	/**
	* Returns all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome findByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId_First(groupId,
			spCompetencyUnitId, orderByComparator);
	}

	/**
	* Returns the first outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCompetencyUnitId_First(groupId,
			spCompetencyUnitId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome findByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId_Last(groupId,
			spCompetencyUnitId, orderByComparator);
	}

	/**
	* Returns the last outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCompetencyUnitId_Last(groupId,
			spCompetencyUnitId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Outcome[] findByGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutcomeId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId_PrevAndNext(spOutcomeId,
			groupId, spCompetencyUnitId, orderByComparator);
	}

	/**
	* Removes all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId);
	}

	/**
	* Returns the number of outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the number of matching outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId);
	}

	/**
	* Caches the outcome in the entity cache if it is enabled.
	*
	* @param outcome the outcome
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Outcome outcome) {
		getPersistence().cacheResult(outcome);
	}

	/**
	* Caches the outcomes in the entity cache if it is enabled.
	*
	* @param outcomes the outcomes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Outcome> outcomes) {
		getPersistence().cacheResult(outcomes);
	}

	/**
	* Creates a new outcome with the primary key. Does not add the outcome to the database.
	*
	* @param spOutcomeId the primary key for the new outcome
	* @return the new outcome
	*/
	public static com.sambaash.platform.srv.model.Outcome create(
		long spOutcomeId) {
		return getPersistence().create(spOutcomeId);
	}

	/**
	* Removes the outcome with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome that was removed
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome remove(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence().remove(spOutcomeId);
	}

	public static com.sambaash.platform.srv.model.Outcome updateImpl(
		com.sambaash.platform.srv.model.Outcome outcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(outcome);
	}

	/**
	* Returns the outcome with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchOutcomeException} if it could not be found.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome
	* @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome findByPrimaryKey(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutcomeException {
		return getPersistence().findByPrimaryKey(spOutcomeId);
	}

	/**
	* Returns the outcome with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome, or <code>null</code> if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outcome fetchByPrimaryKey(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spOutcomeId);
	}

	/**
	* Returns all the outcomes.
	*
	* @return the outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Outcome> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the outcomes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of outcomes.
	*
	* @return the number of outcomes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OutcomePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OutcomePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					OutcomePersistence.class.getName());

			ReferenceRegistry.registerReference(OutcomeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OutcomePersistence persistence) {
	}

	private static OutcomePersistence _persistence;
}