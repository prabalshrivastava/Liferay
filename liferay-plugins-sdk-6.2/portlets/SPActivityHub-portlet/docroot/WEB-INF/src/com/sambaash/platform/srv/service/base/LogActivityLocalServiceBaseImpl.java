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

package com.sambaash.platform.srv.service.base;

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

import com.sambaash.platform.srv.model.LogActivity;
import com.sambaash.platform.srv.service.LogActivityLocalService;
import com.sambaash.platform.srv.service.persistence.ConversationPersistence;
import com.sambaash.platform.srv.service.persistence.ConversationUserPersistence;
import com.sambaash.platform.srv.service.persistence.LogActivityPersistence;
import com.sambaash.platform.srv.service.persistence.NotePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the log activity local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.service.impl.LogActivityLocalServiceImpl}.
 * </p>
 *
 * @author aishwarya
 * @see com.sambaash.platform.srv.service.impl.LogActivityLocalServiceImpl
 * @see com.sambaash.platform.srv.service.LogActivityLocalServiceUtil
 * @generated
 */
public abstract class LogActivityLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements LogActivityLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.service.LogActivityLocalServiceUtil} to access the log activity local service.
	 */

	/**
	 * Adds the log activity to the database. Also notifies the appropriate model listeners.
	 *
	 * @param logActivity the log activity
	 * @return the log activity that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LogActivity addLogActivity(LogActivity logActivity)
		throws SystemException {
		logActivity.setNew(true);

		return logActivityPersistence.update(logActivity);
	}

	/**
	 * Creates a new log activity with the primary key. Does not add the log activity to the database.
	 *
	 * @param spLogActivityId the primary key for the new log activity
	 * @return the new log activity
	 */
	@Override
	public LogActivity createLogActivity(long spLogActivityId) {
		return logActivityPersistence.create(spLogActivityId);
	}

	/**
	 * Deletes the log activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLogActivityId the primary key of the log activity
	 * @return the log activity that was removed
	 * @throws PortalException if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LogActivity deleteLogActivity(long spLogActivityId)
		throws PortalException, SystemException {
		return logActivityPersistence.remove(spLogActivityId);
	}

	/**
	 * Deletes the log activity from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logActivity the log activity
	 * @return the log activity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LogActivity deleteLogActivity(LogActivity logActivity)
		throws SystemException {
		return logActivityPersistence.remove(logActivity);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(LogActivity.class,
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
		return logActivityPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return logActivityPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return logActivityPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return logActivityPersistence.countWithDynamicQuery(dynamicQuery);
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
		return logActivityPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public LogActivity fetchLogActivity(long spLogActivityId)
		throws SystemException {
		return logActivityPersistence.fetchByPrimaryKey(spLogActivityId);
	}

	/**
	 * Returns the log activity with the primary key.
	 *
	 * @param spLogActivityId the primary key of the log activity
	 * @return the log activity
	 * @throws PortalException if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity getLogActivity(long spLogActivityId)
		throws PortalException, SystemException {
		return logActivityPersistence.findByPrimaryKey(spLogActivityId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return logActivityPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the log activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log activities
	 * @param end the upper bound of the range of log activities (not inclusive)
	 * @return the range of log activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogActivity> getLogActivities(int start, int end)
		throws SystemException {
		return logActivityPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of log activities.
	 *
	 * @return the number of log activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getLogActivitiesCount() throws SystemException {
		return logActivityPersistence.countAll();
	}

	/**
	 * Updates the log activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param logActivity the log activity
	 * @return the log activity that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LogActivity updateLogActivity(LogActivity logActivity)
		throws SystemException {
		return logActivityPersistence.update(logActivity);
	}

	/**
	 * Returns the conversation local service.
	 *
	 * @return the conversation local service
	 */
	public com.sambaash.platform.srv.service.ConversationLocalService getConversationLocalService() {
		return conversationLocalService;
	}

	/**
	 * Sets the conversation local service.
	 *
	 * @param conversationLocalService the conversation local service
	 */
	public void setConversationLocalService(
		com.sambaash.platform.srv.service.ConversationLocalService conversationLocalService) {
		this.conversationLocalService = conversationLocalService;
	}

	/**
	 * Returns the conversation persistence.
	 *
	 * @return the conversation persistence
	 */
	public ConversationPersistence getConversationPersistence() {
		return conversationPersistence;
	}

	/**
	 * Sets the conversation persistence.
	 *
	 * @param conversationPersistence the conversation persistence
	 */
	public void setConversationPersistence(
		ConversationPersistence conversationPersistence) {
		this.conversationPersistence = conversationPersistence;
	}

	/**
	 * Returns the conversation user local service.
	 *
	 * @return the conversation user local service
	 */
	public com.sambaash.platform.srv.service.ConversationUserLocalService getConversationUserLocalService() {
		return conversationUserLocalService;
	}

	/**
	 * Sets the conversation user local service.
	 *
	 * @param conversationUserLocalService the conversation user local service
	 */
	public void setConversationUserLocalService(
		com.sambaash.platform.srv.service.ConversationUserLocalService conversationUserLocalService) {
		this.conversationUserLocalService = conversationUserLocalService;
	}

	/**
	 * Returns the conversation user persistence.
	 *
	 * @return the conversation user persistence
	 */
	public ConversationUserPersistence getConversationUserPersistence() {
		return conversationUserPersistence;
	}

	/**
	 * Sets the conversation user persistence.
	 *
	 * @param conversationUserPersistence the conversation user persistence
	 */
	public void setConversationUserPersistence(
		ConversationUserPersistence conversationUserPersistence) {
		this.conversationUserPersistence = conversationUserPersistence;
	}

	/**
	 * Returns the log activity local service.
	 *
	 * @return the log activity local service
	 */
	public com.sambaash.platform.srv.service.LogActivityLocalService getLogActivityLocalService() {
		return logActivityLocalService;
	}

	/**
	 * Sets the log activity local service.
	 *
	 * @param logActivityLocalService the log activity local service
	 */
	public void setLogActivityLocalService(
		com.sambaash.platform.srv.service.LogActivityLocalService logActivityLocalService) {
		this.logActivityLocalService = logActivityLocalService;
	}

	/**
	 * Returns the log activity persistence.
	 *
	 * @return the log activity persistence
	 */
	public LogActivityPersistence getLogActivityPersistence() {
		return logActivityPersistence;
	}

	/**
	 * Sets the log activity persistence.
	 *
	 * @param logActivityPersistence the log activity persistence
	 */
	public void setLogActivityPersistence(
		LogActivityPersistence logActivityPersistence) {
		this.logActivityPersistence = logActivityPersistence;
	}

	/**
	 * Returns the note local service.
	 *
	 * @return the note local service
	 */
	public com.sambaash.platform.srv.service.NoteLocalService getNoteLocalService() {
		return noteLocalService;
	}

	/**
	 * Sets the note local service.
	 *
	 * @param noteLocalService the note local service
	 */
	public void setNoteLocalService(
		com.sambaash.platform.srv.service.NoteLocalService noteLocalService) {
		this.noteLocalService = noteLocalService;
	}

	/**
	 * Returns the note persistence.
	 *
	 * @return the note persistence
	 */
	public NotePersistence getNotePersistence() {
		return notePersistence;
	}

	/**
	 * Sets the note persistence.
	 *
	 * @param notePersistence the note persistence
	 */
	public void setNotePersistence(NotePersistence notePersistence) {
		this.notePersistence = notePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.model.LogActivity",
			logActivityLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.model.LogActivity");
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
		return LogActivity.class;
	}

	protected String getModelClassName() {
		return LogActivity.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = logActivityPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.service.ConversationLocalService.class)
	protected com.sambaash.platform.srv.service.ConversationLocalService conversationLocalService;
	@BeanReference(type = ConversationPersistence.class)
	protected ConversationPersistence conversationPersistence;
	@BeanReference(type = com.sambaash.platform.srv.service.ConversationUserLocalService.class)
	protected com.sambaash.platform.srv.service.ConversationUserLocalService conversationUserLocalService;
	@BeanReference(type = ConversationUserPersistence.class)
	protected ConversationUserPersistence conversationUserPersistence;
	@BeanReference(type = com.sambaash.platform.srv.service.LogActivityLocalService.class)
	protected com.sambaash.platform.srv.service.LogActivityLocalService logActivityLocalService;
	@BeanReference(type = LogActivityPersistence.class)
	protected LogActivityPersistence logActivityPersistence;
	@BeanReference(type = com.sambaash.platform.srv.service.NoteLocalService.class)
	protected com.sambaash.platform.srv.service.NoteLocalService noteLocalService;
	@BeanReference(type = NotePersistence.class)
	protected NotePersistence notePersistence;
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
	private LogActivityLocalServiceClpInvoker _clpInvoker = new LogActivityLocalServiceClpInvoker();
}