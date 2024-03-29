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

package com.sambaash.platform.srv.spgroup.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sambaash.platform.srv.spgroup.model.SPGroupPref;
import com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalService;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupPersistence;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupPrefPersistence;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p group pref local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.spgroup.service.impl.SPGroupPrefLocalServiceImpl}.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.spgroup.service.impl.SPGroupPrefLocalServiceImpl
 * @see com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalServiceUtil
 * @generated
 */
public abstract class SPGroupPrefLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SPGroupPrefLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalServiceUtil} to access the s p group pref local service.
	 */

	/**
	 * Adds the s p group pref to the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupPref the s p group pref
	 * @return the s p group pref that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPGroupPref addSPGroupPref(SPGroupPref spGroupPref)
		throws SystemException {
		spGroupPref.setNew(true);

		return spGroupPrefPersistence.update(spGroupPref);
	}

	/**
	 * Creates a new s p group pref with the primary key. Does not add the s p group pref to the database.
	 *
	 * @param spGroupPrefId the primary key for the new s p group pref
	 * @return the new s p group pref
	 */
	@Override
	public SPGroupPref createSPGroupPref(long spGroupPrefId) {
		return spGroupPrefPersistence.create(spGroupPrefId);
	}

	/**
	 * Deletes the s p group pref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupPrefId the primary key of the s p group pref
	 * @return the s p group pref that was removed
	 * @throws PortalException if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPGroupPref deleteSPGroupPref(long spGroupPrefId)
		throws PortalException, SystemException {
		return spGroupPrefPersistence.remove(spGroupPrefId);
	}

	/**
	 * Deletes the s p group pref from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupPref the s p group pref
	 * @return the s p group pref that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPGroupPref deleteSPGroupPref(SPGroupPref spGroupPref)
		throws SystemException {
		return spGroupPrefPersistence.remove(spGroupPref);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SPGroupPref.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return spGroupPrefPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return spGroupPrefPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return spGroupPrefPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return spGroupPrefPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return spGroupPrefPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SPGroupPref fetchSPGroupPref(long spGroupPrefId)
		throws SystemException {
		return spGroupPrefPersistence.fetchByPrimaryKey(spGroupPrefId);
	}

	/**
	 * Returns the s p group pref with the primary key.
	 *
	 * @param spGroupPrefId the primary key of the s p group pref
	 * @return the s p group pref
	 * @throws PortalException if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref getSPGroupPref(long spGroupPrefId)
		throws PortalException, SystemException {
		return spGroupPrefPersistence.findByPrimaryKey(spGroupPrefId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return spGroupPrefPersistence.findByPrimaryKey(primaryKeyObj);
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
	@Override
	public List<SPGroupPref> getSPGroupPrefs(int start, int end)
		throws SystemException {
		return spGroupPrefPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of s p group prefs.
	 *
	 * @return the number of s p group prefs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSPGroupPrefsCount() throws SystemException {
		return spGroupPrefPersistence.countAll();
	}

	/**
	 * Updates the s p group pref in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupPref the s p group pref
	 * @return the s p group pref that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPGroupPref updateSPGroupPref(SPGroupPref spGroupPref)
		throws SystemException {
		return spGroupPrefPersistence.update(spGroupPref);
	}

	/**
	 * Returns the s p group local service.
	 *
	 * @return the s p group local service
	 */
	public com.sambaash.platform.srv.spgroup.service.SPGroupLocalService getSPGroupLocalService() {
		return spGroupLocalService;
	}

	/**
	 * Sets the s p group local service.
	 *
	 * @param spGroupLocalService the s p group local service
	 */
	public void setSPGroupLocalService(
		com.sambaash.platform.srv.spgroup.service.SPGroupLocalService spGroupLocalService) {
		this.spGroupLocalService = spGroupLocalService;
	}

	/**
	 * Returns the s p group persistence.
	 *
	 * @return the s p group persistence
	 */
	public SPGroupPersistence getSPGroupPersistence() {
		return spGroupPersistence;
	}

	/**
	 * Sets the s p group persistence.
	 *
	 * @param spGroupPersistence the s p group persistence
	 */
	public void setSPGroupPersistence(SPGroupPersistence spGroupPersistence) {
		this.spGroupPersistence = spGroupPersistence;
	}

	/**
	 * Returns the s p group pref local service.
	 *
	 * @return the s p group pref local service
	 */
	public com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalService getSPGroupPrefLocalService() {
		return spGroupPrefLocalService;
	}

	/**
	 * Sets the s p group pref local service.
	 *
	 * @param spGroupPrefLocalService the s p group pref local service
	 */
	public void setSPGroupPrefLocalService(
		com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalService spGroupPrefLocalService) {
		this.spGroupPrefLocalService = spGroupPrefLocalService;
	}

	/**
	 * Returns the s p group pref persistence.
	 *
	 * @return the s p group pref persistence
	 */
	public SPGroupPrefPersistence getSPGroupPrefPersistence() {
		return spGroupPrefPersistence;
	}

	/**
	 * Sets the s p group pref persistence.
	 *
	 * @param spGroupPrefPersistence the s p group pref persistence
	 */
	public void setSPGroupPrefPersistence(
		SPGroupPrefPersistence spGroupPrefPersistence) {
		this.spGroupPrefPersistence = spGroupPrefPersistence;
	}

	/**
	 * Returns the s p group user local service.
	 *
	 * @return the s p group user local service
	 */
	public com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalService getSPGroupUserLocalService() {
		return spGroupUserLocalService;
	}

	/**
	 * Sets the s p group user local service.
	 *
	 * @param spGroupUserLocalService the s p group user local service
	 */
	public void setSPGroupUserLocalService(
		com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalService spGroupUserLocalService) {
		this.spGroupUserLocalService = spGroupUserLocalService;
	}

	/**
	 * Returns the s p group user persistence.
	 *
	 * @return the s p group user persistence
	 */
	public SPGroupUserPersistence getSPGroupUserPersistence() {
		return spGroupUserPersistence;
	}

	/**
	 * Sets the s p group user persistence.
	 *
	 * @param spGroupUserPersistence the s p group user persistence
	 */
	public void setSPGroupUserPersistence(
		SPGroupUserPersistence spGroupUserPersistence) {
		this.spGroupUserPersistence = spGroupUserPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.spgroup.model.SPGroupPref",
			spGroupPrefLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.spgroup.model.SPGroupPref");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SPGroupPref.class;
	}

	protected String getModelClassName() {
		return SPGroupPref.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spGroupPrefPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.spgroup.service.SPGroupLocalService.class)
	protected com.sambaash.platform.srv.spgroup.service.SPGroupLocalService spGroupLocalService;
	@BeanReference(type = SPGroupPersistence.class)
	protected SPGroupPersistence spGroupPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalService.class)
	protected com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalService spGroupPrefLocalService;
	@BeanReference(type = SPGroupPrefPersistence.class)
	protected SPGroupPrefPersistence spGroupPrefPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalService.class)
	protected com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalService spGroupUserLocalService;
	@BeanReference(type = SPGroupUserPersistence.class)
	protected SPGroupUserPersistence spGroupUserPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SPGroupPrefLocalServiceClpInvoker _clpInvoker = new SPGroupPrefLocalServiceClpInvoker();
}