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

package com.sambaash.platform.srv.spgroup.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spgroup.model.SPGroupPref;

import java.util.List;

/**
 * The persistence utility for the s p group pref service. This utility wraps {@link SPGroupPrefPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPGroupPrefPersistence
 * @see SPGroupPrefPersistenceImpl
 * @generated
 */
public class SPGroupPrefUtil {
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
	public static void clearCache(SPGroupPref spGroupPref) {
		getPersistence().clearCache(spGroupPref);
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
	public static List<SPGroupPref> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPGroupPref> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPGroupPref> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPGroupPref update(SPGroupPref spGroupPref)
		throws SystemException {
		return getPersistence().update(spGroupPref);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPGroupPref update(SPGroupPref spGroupPref,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spGroupPref, serviceContext);
	}

	/**
	* Caches the s p group pref in the entity cache if it is enabled.
	*
	* @param spGroupPref the s p group pref
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spgroup.model.SPGroupPref spGroupPref) {
		getPersistence().cacheResult(spGroupPref);
	}

	/**
	* Caches the s p group prefs in the entity cache if it is enabled.
	*
	* @param spGroupPrefs the s p group prefs
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupPref> spGroupPrefs) {
		getPersistence().cacheResult(spGroupPrefs);
	}

	/**
	* Creates a new s p group pref with the primary key. Does not add the s p group pref to the database.
	*
	* @param spGroupPrefId the primary key for the new s p group pref
	* @return the new s p group pref
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroupPref create(
		long spGroupPrefId) {
		return getPersistence().create(spGroupPrefId);
	}

	/**
	* Removes the s p group pref with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupPrefId the primary key of the s p group pref
	* @return the s p group pref that was removed
	* @throws com.sambaash.platform.srv.spgroup.NoSuchPrefException if a s p group pref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroupPref remove(
		long spGroupPrefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchPrefException {
		return getPersistence().remove(spGroupPrefId);
	}

	public static com.sambaash.platform.srv.spgroup.model.SPGroupPref updateImpl(
		com.sambaash.platform.srv.spgroup.model.SPGroupPref spGroupPref)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spGroupPref);
	}

	/**
	* Returns the s p group pref with the primary key or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchPrefException} if it could not be found.
	*
	* @param spGroupPrefId the primary key of the s p group pref
	* @return the s p group pref
	* @throws com.sambaash.platform.srv.spgroup.NoSuchPrefException if a s p group pref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroupPref findByPrimaryKey(
		long spGroupPrefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchPrefException {
		return getPersistence().findByPrimaryKey(spGroupPrefId);
	}

	/**
	* Returns the s p group pref with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spGroupPrefId the primary key of the s p group pref
	* @return the s p group pref, or <code>null</code> if a s p group pref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spgroup.model.SPGroupPref fetchByPrimaryKey(
		long spGroupPrefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spGroupPrefId);
	}

	/**
	* Returns all the s p group prefs.
	*
	* @return the s p group prefs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupPref> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p group prefs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p group prefs
	* @param end the upper bound of the range of s p group prefs (not inclusive)
	* @return the range of s p group prefs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupPref> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p group prefs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p group prefs
	* @param end the upper bound of the range of s p group prefs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p group prefs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroupPref> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p group prefs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p group prefs.
	*
	* @return the number of s p group prefs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPGroupPrefPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPGroupPrefPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spgroup.service.ClpSerializer.getServletContextName(),
					SPGroupPrefPersistence.class.getName());

			ReferenceRegistry.registerReference(SPGroupPrefUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPGroupPrefPersistence persistence) {
	}

	private static SPGroupPrefPersistence _persistence;
}