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

package com.sambaash.platform.srv.processbuilder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.processbuilder.model.PESupervisor;

import java.util.List;

/**
 * The persistence utility for the p e supervisor service. This utility wraps {@link PESupervisorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PESupervisorPersistence
 * @see PESupervisorPersistenceImpl
 * @generated
 */
public class PESupervisorUtil {
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
	public static void clearCache(PESupervisor peSupervisor) {
		getPersistence().clearCache(peSupervisor);
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
	public static List<PESupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PESupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PESupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PESupervisor update(PESupervisor peSupervisor)
		throws SystemException {
		return getPersistence().update(peSupervisor);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PESupervisor update(PESupervisor peSupervisor,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(peSupervisor, serviceContext);
	}

	/**
	* Caches the p e supervisor in the entity cache if it is enabled.
	*
	* @param peSupervisor the p e supervisor
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor) {
		getPersistence().cacheResult(peSupervisor);
	}

	/**
	* Caches the p e supervisors in the entity cache if it is enabled.
	*
	* @param peSupervisors the p e supervisors
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> peSupervisors) {
		getPersistence().cacheResult(peSupervisors);
	}

	/**
	* Creates a new p e supervisor with the primary key. Does not add the p e supervisor to the database.
	*
	* @param spPESupervisorId the primary key for the new p e supervisor
	* @return the new p e supervisor
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PESupervisor create(
		long spPESupervisorId) {
		return getPersistence().create(spPESupervisorId);
	}

	/**
	* Removes the p e supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PESupervisor remove(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException {
		return getPersistence().remove(spPESupervisorId);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PESupervisor updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(peSupervisor);
	}

	/**
	* Returns the p e supervisor with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException} if it could not be found.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PESupervisor findByPrimaryKey(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException {
		return getPersistence().findByPrimaryKey(spPESupervisorId);
	}

	/**
	* Returns the p e supervisor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor, or <code>null</code> if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PESupervisor fetchByPrimaryKey(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spPESupervisorId);
	}

	/**
	* Returns all the p e supervisors.
	*
	* @return the p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p e supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e supervisors
	* @param end the upper bound of the range of p e supervisors (not inclusive)
	* @return the range of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p e supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e supervisors
	* @param end the upper bound of the range of p e supervisors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p e supervisors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p e supervisors.
	*
	* @return the number of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PESupervisorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PESupervisorPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.getServletContextName(),
					PESupervisorPersistence.class.getName());

			ReferenceRegistry.registerReference(PESupervisorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PESupervisorPersistence persistence) {
	}

	private static PESupervisorPersistence _persistence;
}