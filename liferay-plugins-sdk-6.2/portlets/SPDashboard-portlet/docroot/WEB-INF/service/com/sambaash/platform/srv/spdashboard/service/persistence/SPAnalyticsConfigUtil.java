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

package com.sambaash.platform.srv.spdashboard.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig;

import java.util.List;

/**
 * The persistence utility for the s p analytics config service. This utility wraps {@link SPAnalyticsConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPAnalyticsConfigPersistence
 * @see SPAnalyticsConfigPersistenceImpl
 * @generated
 */
public class SPAnalyticsConfigUtil {
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
	public static void clearCache(SPAnalyticsConfig spAnalyticsConfig) {
		getPersistence().clearCache(spAnalyticsConfig);
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
	public static List<SPAnalyticsConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPAnalyticsConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPAnalyticsConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPAnalyticsConfig update(SPAnalyticsConfig spAnalyticsConfig)
		throws SystemException {
		return getPersistence().update(spAnalyticsConfig);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPAnalyticsConfig update(
		SPAnalyticsConfig spAnalyticsConfig, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spAnalyticsConfig, serviceContext);
	}

	/**
	* Returns all the s p analytics configs where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @return the matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWarIdAndType(warId, type);
	}

	/**
	* Returns a range of all the s p analytics configs where warId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param warId the war ID
	* @param type the type
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @return the range of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWarIdAndType(warId, type, start, end);
	}

	/**
	* Returns an ordered range of all the s p analytics configs where warId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param warId the war ID
	* @param type the type
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWarIdAndType(warId, type, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarIdAndType_First(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence()
				   .findByWarIdAndType_First(warId, type, orderByComparator);
	}

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarIdAndType_First(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWarIdAndType_First(warId, type, orderByComparator);
	}

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarIdAndType_Last(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence()
				   .findByWarIdAndType_Last(warId, type, orderByComparator);
	}

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarIdAndType_Last(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWarIdAndType_Last(warId, type, orderByComparator);
	}

	/**
	* Returns the s p analytics configs before and after the current s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param spAnalyticsConfigId the primary key of the current s p analytics config
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig[] findByWarIdAndType_PrevAndNext(
		long spAnalyticsConfigId, java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence()
				   .findByWarIdAndType_PrevAndNext(spAnalyticsConfigId, warId,
			type, orderByComparator);
	}

	/**
	* Removes all the s p analytics configs where warId = &#63; and type = &#63; from the database.
	*
	* @param warId the war ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWarIdAndType(java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWarIdAndType(warId, type);
	}

	/**
	* Returns the number of s p analytics configs where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @return the number of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWarIdAndType(java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWarIdAndType(warId, type);
	}

	/**
	* Returns all the s p analytics configs where warId = &#63;.
	*
	* @param warId the war ID
	* @return the matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWarId(warId);
	}

	/**
	* Returns a range of all the s p analytics configs where warId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param warId the war ID
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @return the range of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWarId(warId, start, end);
	}

	/**
	* Returns an ordered range of all the s p analytics configs where warId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param warId the war ID
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWarId(warId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarId_First(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence().findByWarId_First(warId, orderByComparator);
	}

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarId_First(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWarId_First(warId, orderByComparator);
	}

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarId_Last(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence().findByWarId_Last(warId, orderByComparator);
	}

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarId_Last(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWarId_Last(warId, orderByComparator);
	}

	/**
	* Returns the s p analytics configs before and after the current s p analytics config in the ordered set where warId = &#63;.
	*
	* @param spAnalyticsConfigId the primary key of the current s p analytics config
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig[] findByWarId_PrevAndNext(
		long spAnalyticsConfigId, java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence()
				   .findByWarId_PrevAndNext(spAnalyticsConfigId, warId,
			orderByComparator);
	}

	/**
	* Removes all the s p analytics configs where warId = &#63; from the database.
	*
	* @param warId the war ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWarId(java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWarId(warId);
	}

	/**
	* Returns the number of s p analytics configs where warId = &#63;.
	*
	* @param warId the war ID
	* @return the number of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWarId(java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWarId(warId);
	}

	/**
	* Caches the s p analytics config in the entity cache if it is enabled.
	*
	* @param spAnalyticsConfig the s p analytics config
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig) {
		getPersistence().cacheResult(spAnalyticsConfig);
	}

	/**
	* Caches the s p analytics configs in the entity cache if it is enabled.
	*
	* @param spAnalyticsConfigs the s p analytics configs
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> spAnalyticsConfigs) {
		getPersistence().cacheResult(spAnalyticsConfigs);
	}

	/**
	* Creates a new s p analytics config with the primary key. Does not add the s p analytics config to the database.
	*
	* @param spAnalyticsConfigId the primary key for the new s p analytics config
	* @return the new s p analytics config
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig create(
		long spAnalyticsConfigId) {
		return getPersistence().create(spAnalyticsConfigId);
	}

	/**
	* Removes the s p analytics config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config that was removed
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig remove(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence().remove(spAnalyticsConfigId);
	}

	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig updateImpl(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spAnalyticsConfig);
	}

	/**
	* Returns the s p analytics config with the primary key or throws a {@link com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException} if it could not be found.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByPrimaryKey(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException {
		return getPersistence().findByPrimaryKey(spAnalyticsConfigId);
	}

	/**
	* Returns the s p analytics config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config, or <code>null</code> if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByPrimaryKey(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spAnalyticsConfigId);
	}

	/**
	* Returns all the s p analytics configs.
	*
	* @return the s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p analytics configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @return the range of s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p analytics configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p analytics configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p analytics configs.
	*
	* @return the number of s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPAnalyticsConfigPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPAnalyticsConfigPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spdashboard.service.ClpSerializer.getServletContextName(),
					SPAnalyticsConfigPersistence.class.getName());

			ReferenceRegistry.registerReference(SPAnalyticsConfigUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPAnalyticsConfigPersistence persistence) {
	}

	private static SPAnalyticsConfigPersistence _persistence;
}