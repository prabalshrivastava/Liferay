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

import com.sambaash.platform.srv.model.ProductSupervisor;

import java.util.List;

/**
 * The persistence utility for the product supervisor service. This utility wraps {@link ProductSupervisorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductSupervisorPersistence
 * @see ProductSupervisorPersistenceImpl
 * @generated
 */
public class ProductSupervisorUtil {
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
	public static void clearCache(ProductSupervisor productSupervisor) {
		getPersistence().clearCache(productSupervisor);
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
	public static List<ProductSupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductSupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductSupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProductSupervisor update(ProductSupervisor productSupervisor)
		throws SystemException {
		return getPersistence().update(productSupervisor);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProductSupervisor update(
		ProductSupervisor productSupervisor, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(productSupervisor, serviceContext);
	}

	/**
	* Caches the product supervisor in the entity cache if it is enabled.
	*
	* @param productSupervisor the product supervisor
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor) {
		getPersistence().cacheResult(productSupervisor);
	}

	/**
	* Caches the product supervisors in the entity cache if it is enabled.
	*
	* @param productSupervisors the product supervisors
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.ProductSupervisor> productSupervisors) {
		getPersistence().cacheResult(productSupervisors);
	}

	/**
	* Creates a new product supervisor with the primary key. Does not add the product supervisor to the database.
	*
	* @param spProductSupervisorId the primary key for the new product supervisor
	* @return the new product supervisor
	*/
	public static com.sambaash.platform.srv.model.ProductSupervisor create(
		long spProductSupervisorId) {
		return getPersistence().create(spProductSupervisorId);
	}

	/**
	* Removes the product supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spProductSupervisorId the primary key of the product supervisor
	* @return the product supervisor that was removed
	* @throws com.sambaash.platform.srv.NoSuchProductSupervisorException if a product supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ProductSupervisor remove(
		long spProductSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductSupervisorException {
		return getPersistence().remove(spProductSupervisorId);
	}

	public static com.sambaash.platform.srv.model.ProductSupervisor updateImpl(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productSupervisor);
	}

	/**
	* Returns the product supervisor with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchProductSupervisorException} if it could not be found.
	*
	* @param spProductSupervisorId the primary key of the product supervisor
	* @return the product supervisor
	* @throws com.sambaash.platform.srv.NoSuchProductSupervisorException if a product supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ProductSupervisor findByPrimaryKey(
		long spProductSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductSupervisorException {
		return getPersistence().findByPrimaryKey(spProductSupervisorId);
	}

	/**
	* Returns the product supervisor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spProductSupervisorId the primary key of the product supervisor
	* @return the product supervisor, or <code>null</code> if a product supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ProductSupervisor fetchByPrimaryKey(
		long spProductSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spProductSupervisorId);
	}

	/**
	* Returns all the product supervisors.
	*
	* @return the product supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ProductSupervisor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the product supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of product supervisors
	* @param end the upper bound of the range of product supervisors (not inclusive)
	* @return the range of product supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ProductSupervisor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the product supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of product supervisors
	* @param end the upper bound of the range of product supervisors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of product supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ProductSupervisor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the product supervisors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of product supervisors.
	*
	* @return the number of product supervisors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductSupervisorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductSupervisorPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					ProductSupervisorPersistence.class.getName());

			ReferenceRegistry.registerReference(ProductSupervisorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProductSupervisorPersistence persistence) {
	}

	private static ProductSupervisorPersistence _persistence;
}