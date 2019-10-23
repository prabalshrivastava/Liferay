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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig;

/**
 * The persistence interface for the s p analytics config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPAnalyticsConfigPersistenceImpl
 * @see SPAnalyticsConfigUtil
 * @generated
 */
public interface SPAnalyticsConfigPersistence extends BasePersistence<SPAnalyticsConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPAnalyticsConfigUtil} to access the s p analytics config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p analytics configs where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @return the matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarIdAndType_First(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarIdAndType_First(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarIdAndType_Last(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarIdAndType_Last(
		java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig[] findByWarIdAndType_PrevAndNext(
		long spAnalyticsConfigId, java.lang.String warId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Removes all the s p analytics configs where warId = &#63; and type = &#63; from the database.
	*
	* @param warId the war ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWarIdAndType(java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p analytics configs where warId = &#63; and type = &#63;.
	*
	* @param warId the war ID
	* @param type the type
	* @return the number of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByWarIdAndType(java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p analytics configs where warId = &#63;.
	*
	* @param warId the war ID
	* @return the matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarId_First(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Returns the first s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarId_First(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByWarId_Last(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Returns the last s p analytics config in the ordered set where warId = &#63;.
	*
	* @param warId the war ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByWarId_Last(
		java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig[] findByWarId_PrevAndNext(
		long spAnalyticsConfigId, java.lang.String warId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Removes all the s p analytics configs where warId = &#63; from the database.
	*
	* @param warId the war ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWarId(java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p analytics configs where warId = &#63;.
	*
	* @param warId the war ID
	* @return the number of matching s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByWarId(java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p analytics config in the entity cache if it is enabled.
	*
	* @param spAnalyticsConfig the s p analytics config
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig);

	/**
	* Caches the s p analytics configs in the entity cache if it is enabled.
	*
	* @param spAnalyticsConfigs the s p analytics configs
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> spAnalyticsConfigs);

	/**
	* Creates a new s p analytics config with the primary key. Does not add the s p analytics config to the database.
	*
	* @param spAnalyticsConfigId the primary key for the new s p analytics config
	* @return the new s p analytics config
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig create(
		long spAnalyticsConfigId);

	/**
	* Removes the s p analytics config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config that was removed
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig remove(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig updateImpl(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p analytics config with the primary key or throws a {@link com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException} if it could not be found.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config
	* @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig findByPrimaryKey(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;

	/**
	* Returns the s p analytics config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config, or <code>null</code> if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchByPrimaryKey(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p analytics configs.
	*
	* @return the s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p analytics configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p analytics configs.
	*
	* @return the number of s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}