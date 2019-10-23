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

import com.sambaash.platform.srv.spservices.model.ServiceComponents;

import java.util.List;

/**
 * The persistence utility for the service components service. This utility wraps {@link ServiceComponentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentsPersistence
 * @see ServiceComponentsPersistenceImpl
 * @generated
 */
public class ServiceComponentsUtil {
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
	public static void clearCache(ServiceComponents serviceComponents) {
		getPersistence().clearCache(serviceComponents);
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
	public static List<ServiceComponents> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceComponents> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceComponents> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ServiceComponents update(ServiceComponents serviceComponents)
		throws SystemException {
		return getPersistence().update(serviceComponents);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ServiceComponents update(
		ServiceComponents serviceComponents, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(serviceComponents, serviceContext);
	}

	/**
	* Returns all the service componentses where name = &#63;.
	*
	* @param name the name
	* @return the matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentsName(name);
	}

	/**
	* Returns a range of all the service componentses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @return the range of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentsName(name, start, end);
	}

	/**
	* Returns an ordered range of all the service componentses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceComponentsName(name, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByServiceComponentsName_First(name, orderByComparator);
	}

	/**
	* Returns the first service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentsName_First(name, orderByComparator);
	}

	/**
	* Returns the last service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByServiceComponentsName_Last(name, orderByComparator);
	}

	/**
	* Returns the last service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentsName_Last(name, orderByComparator);
	}

	/**
	* Returns the service componentses before and after the current service components in the ordered set where name = &#63;.
	*
	* @param scId the primary key of the current service components
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents[] findByServiceComponentsName_PrevAndNext(
		long scId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByServiceComponentsName_PrevAndNext(scId, name,
			orderByComparator);
	}

	/**
	* Removes all the service componentses where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceComponentsName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceComponentsName(name);
	}

	/**
	* Returns the number of service componentses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceComponentsName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceComponentsName(name);
	}

	/**
	* Returns all the service componentses where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @return the matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsScgId(
		long scgId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentsScgId(scgId);
	}

	/**
	* Returns a range of all the service componentses where scgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scgId the scg ID
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @return the range of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsScgId(
		long scgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceComponentsScgId(scgId, start, end);
	}

	/**
	* Returns an ordered range of all the service componentses where scgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scgId the scg ID
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsScgId(
		long scgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceComponentsScgId(scgId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsScgId_First(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByServiceComponentsScgId_First(scgId, orderByComparator);
	}

	/**
	* Returns the first service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsScgId_First(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentsScgId_First(scgId, orderByComparator);
	}

	/**
	* Returns the last service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsScgId_Last(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByServiceComponentsScgId_Last(scgId, orderByComparator);
	}

	/**
	* Returns the last service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsScgId_Last(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceComponentsScgId_Last(scgId, orderByComparator);
	}

	/**
	* Returns the service componentses before and after the current service components in the ordered set where scgId = &#63;.
	*
	* @param scId the primary key of the current service components
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents[] findByServiceComponentsScgId_PrevAndNext(
		long scId, long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByServiceComponentsScgId_PrevAndNext(scId, scgId,
			orderByComparator);
	}

	/**
	* Removes all the service componentses where scgId = &#63; from the database.
	*
	* @param scgId the scg ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceComponentsScgId(long scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceComponentsScgId(scgId);
	}

	/**
	* Returns the number of service componentses where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @return the number of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceComponentsScgId(long scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceComponentsScgId(scgId);
	}

	/**
	* Returns all the service componentses where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @return the matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByTechnologyComponent(
		java.lang.String technologyComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTechnologyComponent(technologyComponent);
	}

	/**
	* Returns a range of all the service componentses where technologyComponent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param technologyComponent the technology component
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @return the range of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByTechnologyComponent(
		java.lang.String technologyComponent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTechnologyComponent(technologyComponent, start, end);
	}

	/**
	* Returns an ordered range of all the service componentses where technologyComponent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param technologyComponent the technology component
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByTechnologyComponent(
		java.lang.String technologyComponent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTechnologyComponent(technologyComponent, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByTechnologyComponent_First(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByTechnologyComponent_First(technologyComponent,
			orderByComparator);
	}

	/**
	* Returns the first service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByTechnologyComponent_First(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTechnologyComponent_First(technologyComponent,
			orderByComparator);
	}

	/**
	* Returns the last service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByTechnologyComponent_Last(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByTechnologyComponent_Last(technologyComponent,
			orderByComparator);
	}

	/**
	* Returns the last service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByTechnologyComponent_Last(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTechnologyComponent_Last(technologyComponent,
			orderByComparator);
	}

	/**
	* Returns the service componentses before and after the current service components in the ordered set where technologyComponent = &#63;.
	*
	* @param scId the primary key of the current service components
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents[] findByTechnologyComponent_PrevAndNext(
		long scId, java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence()
				   .findByTechnologyComponent_PrevAndNext(scId,
			technologyComponent, orderByComparator);
	}

	/**
	* Removes all the service componentses where technologyComponent = &#63; from the database.
	*
	* @param technologyComponent the technology component
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTechnologyComponent(
		java.lang.String technologyComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTechnologyComponent(technologyComponent);
	}

	/**
	* Returns the number of service componentses where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @return the number of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTechnologyComponent(
		java.lang.String technologyComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTechnologyComponent(technologyComponent);
	}

	/**
	* Caches the service components in the entity cache if it is enabled.
	*
	* @param serviceComponents the service components
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents) {
		getPersistence().cacheResult(serviceComponents);
	}

	/**
	* Caches the service componentses in the entity cache if it is enabled.
	*
	* @param serviceComponentses the service componentses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> serviceComponentses) {
		getPersistence().cacheResult(serviceComponentses);
	}

	/**
	* Creates a new service components with the primary key. Does not add the service components to the database.
	*
	* @param scId the primary key for the new service components
	* @return the new service components
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents create(
		long scId) {
		return getPersistence().create(scId);
	}

	/**
	* Removes the service components with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scId the primary key of the service components
	* @return the service components that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents remove(
		long scId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence().remove(scId);
	}

	public static com.sambaash.platform.srv.spservices.model.ServiceComponents updateImpl(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serviceComponents);
	}

	/**
	* Returns the service components with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException} if it could not be found.
	*
	* @param scId the primary key of the service components
	* @return the service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents findByPrimaryKey(
		long scId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException {
		return getPersistence().findByPrimaryKey(scId);
	}

	/**
	* Returns the service components with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scId the primary key of the service components
	* @return the service components, or <code>null</code> if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByPrimaryKey(
		long scId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scId);
	}

	/**
	* Returns all the service componentses.
	*
	* @return the service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service componentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @return the range of service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service componentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service componentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service componentses.
	*
	* @return the number of service componentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServiceComponentsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServiceComponentsPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					ServiceComponentsPersistence.class.getName());

			ReferenceRegistry.registerReference(ServiceComponentsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ServiceComponentsPersistence persistence) {
	}

	private static ServiceComponentsPersistence _persistence;
}