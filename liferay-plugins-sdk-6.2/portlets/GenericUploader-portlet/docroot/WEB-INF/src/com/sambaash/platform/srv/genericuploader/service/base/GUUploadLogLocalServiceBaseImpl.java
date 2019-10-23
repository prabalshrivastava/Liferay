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

package com.sambaash.platform.srv.genericuploader.service.base;

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

import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;
import com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalService;
import com.sambaash.platform.srv.genericuploader.service.persistence.GUUploadLogPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the g u upload log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.genericuploader.service.impl.GUUploadLogLocalServiceImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.genericuploader.service.impl.GUUploadLogLocalServiceImpl
 * @see com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil
 * @generated
 */
public abstract class GUUploadLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements GUUploadLogLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil} to access the g u upload log local service.
	 */

	/**
	 * Adds the g u upload log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param guUploadLog the g u upload log
	 * @return the g u upload log that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GUUploadLog addGUUploadLog(GUUploadLog guUploadLog)
		throws SystemException {
		guUploadLog.setNew(true);

		return guUploadLogPersistence.update(guUploadLog);
	}

	/**
	 * Creates a new g u upload log with the primary key. Does not add the g u upload log to the database.
	 *
	 * @param SPGUUploadLogId the primary key for the new g u upload log
	 * @return the new g u upload log
	 */
	@Override
	public GUUploadLog createGUUploadLog(long SPGUUploadLogId) {
		return guUploadLogPersistence.create(SPGUUploadLogId);
	}

	/**
	 * Deletes the g u upload log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SPGUUploadLogId the primary key of the g u upload log
	 * @return the g u upload log that was removed
	 * @throws PortalException if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GUUploadLog deleteGUUploadLog(long SPGUUploadLogId)
		throws PortalException, SystemException {
		return guUploadLogPersistence.remove(SPGUUploadLogId);
	}

	/**
	 * Deletes the g u upload log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guUploadLog the g u upload log
	 * @return the g u upload log that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GUUploadLog deleteGUUploadLog(GUUploadLog guUploadLog)
		throws SystemException {
		return guUploadLogPersistence.remove(guUploadLog);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(GUUploadLog.class,
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
		return guUploadLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return guUploadLogPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return guUploadLogPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return guUploadLogPersistence.countWithDynamicQuery(dynamicQuery);
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
		return guUploadLogPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public GUUploadLog fetchGUUploadLog(long SPGUUploadLogId)
		throws SystemException {
		return guUploadLogPersistence.fetchByPrimaryKey(SPGUUploadLogId);
	}

	/**
	 * Returns the g u upload log with the primary key.
	 *
	 * @param SPGUUploadLogId the primary key of the g u upload log
	 * @return the g u upload log
	 * @throws PortalException if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog getGUUploadLog(long SPGUUploadLogId)
		throws PortalException, SystemException {
		return guUploadLogPersistence.findByPrimaryKey(SPGUUploadLogId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return guUploadLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the g u upload logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g u upload logs
	 * @param end the upper bound of the range of g u upload logs (not inclusive)
	 * @return the range of g u upload logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GUUploadLog> getGUUploadLogs(int start, int end)
		throws SystemException {
		return guUploadLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of g u upload logs.
	 *
	 * @return the number of g u upload logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getGUUploadLogsCount() throws SystemException {
		return guUploadLogPersistence.countAll();
	}

	/**
	 * Updates the g u upload log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param guUploadLog the g u upload log
	 * @return the g u upload log that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GUUploadLog updateGUUploadLog(GUUploadLog guUploadLog)
		throws SystemException {
		return guUploadLogPersistence.update(guUploadLog);
	}

	/**
	 * Returns the g u upload log local service.
	 *
	 * @return the g u upload log local service
	 */
	public com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalService getGUUploadLogLocalService() {
		return guUploadLogLocalService;
	}

	/**
	 * Sets the g u upload log local service.
	 *
	 * @param guUploadLogLocalService the g u upload log local service
	 */
	public void setGUUploadLogLocalService(
		com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalService guUploadLogLocalService) {
		this.guUploadLogLocalService = guUploadLogLocalService;
	}

	/**
	 * Returns the g u upload log remote service.
	 *
	 * @return the g u upload log remote service
	 */
	public com.sambaash.platform.srv.genericuploader.service.GUUploadLogService getGUUploadLogService() {
		return guUploadLogService;
	}

	/**
	 * Sets the g u upload log remote service.
	 *
	 * @param guUploadLogService the g u upload log remote service
	 */
	public void setGUUploadLogService(
		com.sambaash.platform.srv.genericuploader.service.GUUploadLogService guUploadLogService) {
		this.guUploadLogService = guUploadLogService;
	}

	/**
	 * Returns the g u upload log persistence.
	 *
	 * @return the g u upload log persistence
	 */
	public GUUploadLogPersistence getGUUploadLogPersistence() {
		return guUploadLogPersistence;
	}

	/**
	 * Sets the g u upload log persistence.
	 *
	 * @param guUploadLogPersistence the g u upload log persistence
	 */
	public void setGUUploadLogPersistence(
		GUUploadLogPersistence guUploadLogPersistence) {
		this.guUploadLogPersistence = guUploadLogPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.genericuploader.model.GUUploadLog",
			guUploadLogLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.genericuploader.model.GUUploadLog");
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
		return GUUploadLog.class;
	}

	protected String getModelClassName() {
		return GUUploadLog.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = guUploadLogPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalService.class)
	protected com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalService guUploadLogLocalService;
	@BeanReference(type = com.sambaash.platform.srv.genericuploader.service.GUUploadLogService.class)
	protected com.sambaash.platform.srv.genericuploader.service.GUUploadLogService guUploadLogService;
	@BeanReference(type = GUUploadLogPersistence.class)
	protected GUUploadLogPersistence guUploadLogPersistence;
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
	private GUUploadLogLocalServiceClpInvoker _clpInvoker = new GUUploadLogLocalServiceClpInvoker();
}