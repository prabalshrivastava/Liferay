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

import com.sambaash.platform.srv.model.Framework;

import java.util.List;

/**
 * The persistence utility for the framework service. This utility wraps {@link FrameworkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FrameworkPersistence
 * @see FrameworkPersistenceImpl
 * @generated
 */
public class FrameworkUtil {
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
	public static void clearCache(Framework framework) {
		getPersistence().clearCache(framework);
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
	public static List<Framework> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Framework> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Framework> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Framework update(Framework framework)
		throws SystemException {
		return getPersistence().update(framework);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Framework update(Framework framework,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(framework, serviceContext);
	}

	/**
	* Returns all the frameworks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the frameworks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @return the range of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the frameworks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the frameworks before and after the current framework in the ordered set where groupId = &#63;.
	*
	* @param spFrameworkId the primary key of the current framework
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework[] findByGroupId_PrevAndNext(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spFrameworkId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the frameworks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of frameworks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the frameworks where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findByCountryIdAndGroupId(
		long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns a range of all the frameworks where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @return the range of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the frameworks where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first framework in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence()
				   .findByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first framework in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last framework in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence()
				   .findByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last framework in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the frameworks before and after the current framework in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the primary key of the current framework
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework[] findByCountryIdAndGroupId_PrevAndNext(
		long spFrameworkId, long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence()
				   .findByCountryIdAndGroupId_PrevAndNext(spFrameworkId,
			countryId, groupId, orderByComparator);
	}

	/**
	* Removes all the frameworks where countryId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of frameworks where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the number of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns the framework where frameworkName = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFrameworkException} if it could not be found.
	*
	* @param frameworkName the framework name
	* @param groupId the group ID
	* @return the matching framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByNameAndGroupId(
		java.lang.String frameworkName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().findByNameAndGroupId(frameworkName, groupId);
	}

	/**
	* Returns the framework where frameworkName = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param frameworkName the framework name
	* @param groupId the group ID
	* @return the matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByNameAndGroupId(
		java.lang.String frameworkName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndGroupId(frameworkName, groupId);
	}

	/**
	* Returns the framework where frameworkName = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param frameworkName the framework name
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByNameAndGroupId(
		java.lang.String frameworkName, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndGroupId(frameworkName, groupId,
			retrieveFromCache);
	}

	/**
	* Removes the framework where frameworkName = &#63; and groupId = &#63; from the database.
	*
	* @param frameworkName the framework name
	* @param groupId the group ID
	* @return the framework that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework removeByNameAndGroupId(
		java.lang.String frameworkName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().removeByNameAndGroupId(frameworkName, groupId);
	}

	/**
	* Returns the number of frameworks where frameworkName = &#63; and groupId = &#63;.
	*
	* @param frameworkName the framework name
	* @param groupId the group ID
	* @return the number of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndGroupId(java.lang.String frameworkName,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndGroupId(frameworkName, groupId);
	}

	/**
	* Returns the framework where frameworkCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFrameworkException} if it could not be found.
	*
	* @param frameworkCode the framework code
	* @return the matching framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByFrameworkCode(
		java.lang.String frameworkCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().findByFrameworkCode(frameworkCode);
	}

	/**
	* Returns the framework where frameworkCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param frameworkCode the framework code
	* @return the matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByFrameworkCode(
		java.lang.String frameworkCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFrameworkCode(frameworkCode);
	}

	/**
	* Returns the framework where frameworkCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param frameworkCode the framework code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching framework, or <code>null</code> if a matching framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByFrameworkCode(
		java.lang.String frameworkCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFrameworkCode(frameworkCode, retrieveFromCache);
	}

	/**
	* Removes the framework where frameworkCode = &#63; from the database.
	*
	* @param frameworkCode the framework code
	* @return the framework that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework removeByFrameworkCode(
		java.lang.String frameworkCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().removeByFrameworkCode(frameworkCode);
	}

	/**
	* Returns the number of frameworks where frameworkCode = &#63;.
	*
	* @param frameworkCode the framework code
	* @return the number of matching frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFrameworkCode(java.lang.String frameworkCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFrameworkCode(frameworkCode);
	}

	/**
	* Caches the framework in the entity cache if it is enabled.
	*
	* @param framework the framework
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Framework framework) {
		getPersistence().cacheResult(framework);
	}

	/**
	* Caches the frameworks in the entity cache if it is enabled.
	*
	* @param frameworks the frameworks
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Framework> frameworks) {
		getPersistence().cacheResult(frameworks);
	}

	/**
	* Creates a new framework with the primary key. Does not add the framework to the database.
	*
	* @param spFrameworkId the primary key for the new framework
	* @return the new framework
	*/
	public static com.sambaash.platform.srv.model.Framework create(
		long spFrameworkId) {
		return getPersistence().create(spFrameworkId);
	}

	/**
	* Removes the framework with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFrameworkId the primary key of the framework
	* @return the framework that was removed
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework remove(
		long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().remove(spFrameworkId);
	}

	public static com.sambaash.platform.srv.model.Framework updateImpl(
		com.sambaash.platform.srv.model.Framework framework)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(framework);
	}

	/**
	* Returns the framework with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFrameworkException} if it could not be found.
	*
	* @param spFrameworkId the primary key of the framework
	* @return the framework
	* @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework findByPrimaryKey(
		long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return getPersistence().findByPrimaryKey(spFrameworkId);
	}

	/**
	* Returns the framework with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spFrameworkId the primary key of the framework
	* @return the framework, or <code>null</code> if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Framework fetchByPrimaryKey(
		long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spFrameworkId);
	}

	/**
	* Returns all the frameworks.
	*
	* @return the frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the frameworks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @return the range of frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the frameworks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Framework> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the frameworks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of frameworks.
	*
	* @return the number of frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FrameworkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FrameworkPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					FrameworkPersistence.class.getName());

			ReferenceRegistry.registerReference(FrameworkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FrameworkPersistence persistence) {
	}

	private static FrameworkPersistence _persistence;
}