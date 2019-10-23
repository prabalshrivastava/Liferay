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

package com.sambaash.platform.srv.feedback.service.base;

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

import com.sambaash.platform.srv.feedback.model.SPFeedback;
import com.sambaash.platform.srv.feedback.service.SPFeedbackLocalService;
import com.sambaash.platform.srv.feedback.service.persistence.SPFeedbackPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p feedback local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.feedback.service.impl.SPFeedbackLocalServiceImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.feedback.service.impl.SPFeedbackLocalServiceImpl
 * @see com.sambaash.platform.srv.feedback.service.SPFeedbackLocalServiceUtil
 * @generated
 */
public abstract class SPFeedbackLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SPFeedbackLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.feedback.service.SPFeedbackLocalServiceUtil} to access the s p feedback local service.
	 */

	/**
	 * Adds the s p feedback to the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFeedback the s p feedback
	 * @return the s p feedback that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPFeedback addSPFeedback(SPFeedback spFeedback)
		throws SystemException {
		spFeedback.setNew(true);

		return spFeedbackPersistence.update(spFeedback);
	}

	/**
	 * Creates a new s p feedback with the primary key. Does not add the s p feedback to the database.
	 *
	 * @param spFeedbackId the primary key for the new s p feedback
	 * @return the new s p feedback
	 */
	@Override
	public SPFeedback createSPFeedback(long spFeedbackId) {
		return spFeedbackPersistence.create(spFeedbackId);
	}

	/**
	 * Deletes the s p feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFeedbackId the primary key of the s p feedback
	 * @return the s p feedback that was removed
	 * @throws PortalException if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPFeedback deleteSPFeedback(long spFeedbackId)
		throws PortalException, SystemException {
		return spFeedbackPersistence.remove(spFeedbackId);
	}

	/**
	 * Deletes the s p feedback from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFeedback the s p feedback
	 * @return the s p feedback that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPFeedback deleteSPFeedback(SPFeedback spFeedback)
		throws SystemException {
		return spFeedbackPersistence.remove(spFeedback);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SPFeedback.class,
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
		return spFeedbackPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return spFeedbackPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return spFeedbackPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return spFeedbackPersistence.countWithDynamicQuery(dynamicQuery);
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
		return spFeedbackPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SPFeedback fetchSPFeedback(long spFeedbackId)
		throws SystemException {
		return spFeedbackPersistence.fetchByPrimaryKey(spFeedbackId);
	}

	/**
	 * Returns the s p feedback with the primary key.
	 *
	 * @param spFeedbackId the primary key of the s p feedback
	 * @return the s p feedback
	 * @throws PortalException if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback getSPFeedback(long spFeedbackId)
		throws PortalException, SystemException {
		return spFeedbackPersistence.findByPrimaryKey(spFeedbackId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return spFeedbackPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the s p feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p feedbacks
	 * @param end the upper bound of the range of s p feedbacks (not inclusive)
	 * @return the range of s p feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFeedback> getSPFeedbacks(int start, int end)
		throws SystemException {
		return spFeedbackPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of s p feedbacks.
	 *
	 * @return the number of s p feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSPFeedbacksCount() throws SystemException {
		return spFeedbackPersistence.countAll();
	}

	/**
	 * Updates the s p feedback in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param spFeedback the s p feedback
	 * @return the s p feedback that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPFeedback updateSPFeedback(SPFeedback spFeedback)
		throws SystemException {
		return spFeedbackPersistence.update(spFeedback);
	}

	/**
	 * Returns the s p feedback local service.
	 *
	 * @return the s p feedback local service
	 */
	public com.sambaash.platform.srv.feedback.service.SPFeedbackLocalService getSPFeedbackLocalService() {
		return spFeedbackLocalService;
	}

	/**
	 * Sets the s p feedback local service.
	 *
	 * @param spFeedbackLocalService the s p feedback local service
	 */
	public void setSPFeedbackLocalService(
		com.sambaash.platform.srv.feedback.service.SPFeedbackLocalService spFeedbackLocalService) {
		this.spFeedbackLocalService = spFeedbackLocalService;
	}

	/**
	 * Returns the s p feedback persistence.
	 *
	 * @return the s p feedback persistence
	 */
	public SPFeedbackPersistence getSPFeedbackPersistence() {
		return spFeedbackPersistence;
	}

	/**
	 * Sets the s p feedback persistence.
	 *
	 * @param spFeedbackPersistence the s p feedback persistence
	 */
	public void setSPFeedbackPersistence(
		SPFeedbackPersistence spFeedbackPersistence) {
		this.spFeedbackPersistence = spFeedbackPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.feedback.model.SPFeedback",
			spFeedbackLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.feedback.model.SPFeedback");
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
		return SPFeedback.class;
	}

	protected String getModelClassName() {
		return SPFeedback.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spFeedbackPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.feedback.service.SPFeedbackLocalService.class)
	protected com.sambaash.platform.srv.feedback.service.SPFeedbackLocalService spFeedbackLocalService;
	@BeanReference(type = SPFeedbackPersistence.class)
	protected SPFeedbackPersistence spFeedbackPersistence;
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
	private SPFeedbackLocalServiceClpInvoker _clpInvoker = new SPFeedbackLocalServiceClpInvoker();
}