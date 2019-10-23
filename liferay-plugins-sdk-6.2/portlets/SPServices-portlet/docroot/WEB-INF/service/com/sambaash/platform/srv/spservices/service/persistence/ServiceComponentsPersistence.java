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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spservices.model.ServiceComponents;

/**
 * The persistence interface for the service components service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentsPersistenceImpl
 * @see ServiceComponentsUtil
 * @generated
 */
public interface ServiceComponentsPersistence extends BasePersistence<ServiceComponents> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceComponentsUtil} to access the service components persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service componentses where name = &#63;.
	*
	* @param name the name
	* @return the matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the first service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the last service components in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.ServiceComponents[] findByServiceComponentsName_PrevAndNext(
		long scId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Removes all the service componentses where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceComponentsName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service componentses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceComponentsName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service componentses where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @return the matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsScgId(
		long scgId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsScgId(
		long scgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByServiceComponentsScgId(
		long scgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsScgId_First(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the first service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsScgId_First(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByServiceComponentsScgId_Last(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the last service components in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByServiceComponentsScgId_Last(
		long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.ServiceComponents[] findByServiceComponentsScgId_PrevAndNext(
		long scId, long scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Removes all the service componentses where scgId = &#63; from the database.
	*
	* @param scgId the scg ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceComponentsScgId(long scgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service componentses where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @return the number of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceComponentsScgId(long scgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service componentses where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @return the matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByTechnologyComponent(
		java.lang.String technologyComponent)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByTechnologyComponent(
		java.lang.String technologyComponent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findByTechnologyComponent(
		java.lang.String technologyComponent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByTechnologyComponent_First(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the first service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByTechnologyComponent_First(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByTechnologyComponent_Last(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the last service components in the ordered set where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service components, or <code>null</code> if a matching service components could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByTechnologyComponent_Last(
		java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.ServiceComponents[] findByTechnologyComponent_PrevAndNext(
		long scId, java.lang.String technologyComponent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Removes all the service componentses where technologyComponent = &#63; from the database.
	*
	* @param technologyComponent the technology component
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTechnologyComponent(
		java.lang.String technologyComponent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service componentses where technologyComponent = &#63;.
	*
	* @param technologyComponent the technology component
	* @return the number of matching service componentses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTechnologyComponent(java.lang.String technologyComponent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service components in the entity cache if it is enabled.
	*
	* @param serviceComponents the service components
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents);

	/**
	* Caches the service componentses in the entity cache if it is enabled.
	*
	* @param serviceComponentses the service componentses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> serviceComponentses);

	/**
	* Creates a new service components with the primary key. Does not add the service components to the database.
	*
	* @param scId the primary key for the new service components
	* @return the new service components
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents create(
		long scId);

	/**
	* Removes the service components with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scId the primary key of the service components
	* @return the service components that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents remove(
		long scId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	public com.sambaash.platform.srv.spservices.model.ServiceComponents updateImpl(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service components with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException} if it could not be found.
	*
	* @param scId the primary key of the service components
	* @return the service components
	* @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents findByPrimaryKey(
		long scId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;

	/**
	* Returns the service components with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scId the primary key of the service components
	* @return the service components, or <code>null</code> if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchByPrimaryKey(
		long scId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service componentses.
	*
	* @return the service componentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service componentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service componentses.
	*
	* @return the number of service componentses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}