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

package com.sambaash.platform.srv.spdynamicforms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;

import java.util.List;

/**
 * The persistence utility for the s p form storage service. This utility wraps {@link SPFormStoragePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author glenn
 * @see SPFormStoragePersistence
 * @see SPFormStoragePersistenceImpl
 * @generated
 */
public class SPFormStorageUtil {
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
	public static void clearCache(SPFormStorage spFormStorage) {
		getPersistence().clearCache(spFormStorage);
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
	public static List<SPFormStorage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPFormStorage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPFormStorage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPFormStorage update(SPFormStorage spFormStorage)
		throws SystemException {
		return getPersistence().update(spFormStorage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPFormStorage update(SPFormStorage spFormStorage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spFormStorage, serviceContext);
	}

	/**
	* Caches the s p form storage in the entity cache if it is enabled.
	*
	* @param spFormStorage the s p form storage
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage) {
		getPersistence().cacheResult(spFormStorage);
	}

	/**
	* Caches the s p form storages in the entity cache if it is enabled.
	*
	* @param spFormStorages the s p form storages
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> spFormStorages) {
		getPersistence().cacheResult(spFormStorages);
	}

	/**
	* Creates a new s p form storage with the primary key. Does not add the s p form storage to the database.
	*
	* @param formStorageId the primary key for the new s p form storage
	* @return the new s p form storage
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage create(
		long formStorageId) {
		return getPersistence().create(formStorageId);
	}

	/**
	* Removes the s p form storage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage that was removed
	* @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage remove(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException {
		return getPersistence().remove(formStorageId);
	}

	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage updateImpl(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spFormStorage);
	}

	/**
	* Returns the s p form storage with the primary key or throws a {@link com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException} if it could not be found.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage
	* @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage findByPrimaryKey(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException {
		return getPersistence().findByPrimaryKey(formStorageId);
	}

	/**
	* Returns the s p form storage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage, or <code>null</code> if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage fetchByPrimaryKey(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(formStorageId);
	}

	/**
	* Returns all the s p form storages.
	*
	* @return the s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p form storages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p form storages
	* @param end the upper bound of the range of s p form storages (not inclusive)
	* @return the range of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p form storages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p form storages
	* @param end the upper bound of the range of s p form storages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p form storages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p form storages.
	*
	* @return the number of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPFormStoragePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPFormStoragePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spdynamicforms.service.ClpSerializer.getServletContextName(),
					SPFormStoragePersistence.class.getName());

			ReferenceRegistry.registerReference(SPFormStorageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPFormStoragePersistence persistence) {
	}

	private static SPFormStoragePersistence _persistence;
}