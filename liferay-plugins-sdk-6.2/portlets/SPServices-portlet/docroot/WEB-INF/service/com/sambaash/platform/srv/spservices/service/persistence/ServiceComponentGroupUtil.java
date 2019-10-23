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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spservices.model.ServiceComponentGroup;

import java.util.List;

/**
 * The persistence utility for the service component group service. This utility wraps {@link ServiceComponentGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentGroupPersistence
 * @see ServiceComponentGroupPersistenceImpl
 * @generated
 */
public class ServiceComponentGroupUtil {
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
	public static void clearCache(ServiceComponentGroup serviceComponentGroup) {
		getPersistence().clearCache(serviceComponentGroup);
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
	public static List<ServiceComponentGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceComponentGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceComponentGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ServiceComponentGroup update(
		ServiceComponentGroup serviceComponentGroup) throws SystemException {
		return getPersistence().update(serviceComponentGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ServiceComponentGroup update(
		ServiceComponentGroup serviceComponentGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(serviceComponentGroup, serviceContext);
	}

	/**
	* Returns all the service component groups where name = &#63;.
	*
	* @param name the name
	* @return the matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findByServiceComponentGroupName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentGroupName(name);
	}

	/**
	* Returns a range of all the service component groups where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @return the range of matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findByServiceComponentGroupName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentGroupName(name, start, end);
	}

	/**
	* Returns an ordered range of all the service component groups where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findByServiceComponentGroupName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceComponentGroupName(name, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service component group in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup findByServiceComponentGroupName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence()
				   .findByServiceComponentGroupName_First(name,
			orderByComparator);
	}

	/**
	* Returns the first service component group in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service component group, or <code>null</code> if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup fetchByServiceComponentGroupName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentGroupName_First(name,
			orderByComparator);
	}

	/**
	* Returns the last service component group in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup findByServiceComponentGroupName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence()
				   .findByServiceComponentGroupName_Last(name, orderByComparator);
	}

	/**
	* Returns the last service component group in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service component group, or <code>null</code> if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup fetchByServiceComponentGroupName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentGroupName_Last(name,
			orderByComparator);
	}

	/**
	* Returns the service component groups before and after the current service component group in the ordered set where name = &#63;.
	*
	* @param scgId the primary key of the current service component group
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup[] findByServiceComponentGroupName_PrevAndNext(
		long scgId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence()
				   .findByServiceComponentGroupName_PrevAndNext(scgId, name,
			orderByComparator);
	}

	/**
	* Removes all the service component groups where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceComponentGroupName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceComponentGroupName(name);
	}

	/**
	* Returns the number of service component groups where name = &#63;.
	*
	* @param name the name
	* @return the number of matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceComponentGroupName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceComponentGroupName(name);
	}

	/**
	* Returns all the service component groups where extra1 LIKE &#63;.
	*
	* @param extra1 the extra1
	* @return the matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findByServiceComponentGroupExtra1Like(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentGroupExtra1Like(extra1);
	}

	/**
	* Returns a range of all the service component groups where extra1 LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @return the range of matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findByServiceComponentGroupExtra1Like(
		java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceComponentGroupExtra1Like(extra1, start, end);
	}

	/**
	* Returns an ordered range of all the service component groups where extra1 LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findByServiceComponentGroupExtra1Like(
		java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceComponentGroupExtra1Like(extra1, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service component group in the ordered set where extra1 LIKE &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup findByServiceComponentGroupExtra1Like_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence()
				   .findByServiceComponentGroupExtra1Like_First(extra1,
			orderByComparator);
	}

	/**
	* Returns the first service component group in the ordered set where extra1 LIKE &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service component group, or <code>null</code> if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup fetchByServiceComponentGroupExtra1Like_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentGroupExtra1Like_First(extra1,
			orderByComparator);
	}

	/**
	* Returns the last service component group in the ordered set where extra1 LIKE &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup findByServiceComponentGroupExtra1Like_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence()
				   .findByServiceComponentGroupExtra1Like_Last(extra1,
			orderByComparator);
	}

	/**
	* Returns the last service component group in the ordered set where extra1 LIKE &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service component group, or <code>null</code> if a matching service component group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup fetchByServiceComponentGroupExtra1Like_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentGroupExtra1Like_Last(extra1,
			orderByComparator);
	}

	/**
	* Returns the service component groups before and after the current service component group in the ordered set where extra1 LIKE &#63;.
	*
	* @param scgId the primary key of the current service component group
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup[] findByServiceComponentGroupExtra1Like_PrevAndNext(
		long scgId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence()
				   .findByServiceComponentGroupExtra1Like_PrevAndNext(scgId,
			extra1, orderByComparator);
	}

	/**
	* Removes all the service component groups where extra1 LIKE &#63; from the database.
	*
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceComponentGroupExtra1Like(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceComponentGroupExtra1Like(extra1);
	}

	/**
	* Returns the number of service component groups where extra1 LIKE &#63;.
	*
	* @param extra1 the extra1
	* @return the number of matching service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceComponentGroupExtra1Like(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceComponentGroupExtra1Like(extra1);
	}

	/**
	* Caches the service component group in the entity cache if it is enabled.
	*
	* @param serviceComponentGroup the service component group
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup) {
		getPersistence().cacheResult(serviceComponentGroup);
	}

	/**
	* Caches the service component groups in the entity cache if it is enabled.
	*
	* @param serviceComponentGroups the service component groups
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> serviceComponentGroups) {
		getPersistence().cacheResult(serviceComponentGroups);
	}

	/**
	* Creates a new service component group with the primary key. Does not add the service component group to the database.
	*
	* @param scgId the primary key for the new service component group
	* @return the new service component group
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup create(
		long scgId) {
		return getPersistence().create(scgId);
	}

	/**
	* Removes the service component group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scgId the primary key of the service component group
	* @return the service component group that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup remove(
		long scgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence().remove(scgId);
	}

	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup updateImpl(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serviceComponentGroup);
	}

	/**
	* Returns the service component group with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException} if it could not be found.
	*
	* @param scgId the primary key of the service component group
	* @return the service component group
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup findByPrimaryKey(
		long scgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException {
		return getPersistence().findByPrimaryKey(scgId);
	}

	/**
	* Returns the service component group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scgId the primary key of the service component group
	* @return the service component group, or <code>null</code> if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponentGroup fetchByPrimaryKey(
		long scgId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scgId);
	}

	/**
	* Returns all the service component groups.
	*
	* @return the service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service component groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @return the range of service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service component groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service component groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service component groups.
	*
	* @return the number of service component groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServiceComponentGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServiceComponentGroupPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					ServiceComponentGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(ServiceComponentGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ServiceComponentGroupPersistence persistence) {
	}

	private static ServiceComponentGroupPersistence _persistence;
}