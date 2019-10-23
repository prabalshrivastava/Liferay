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

package com.sambaash.platform.srv.enrolment.service.base;

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

import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;
import com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalService;
import com.sambaash.platform.srv.enrolment.service.persistence.EnrollBatchUploadPersistence;
import com.sambaash.platform.srv.enrolment.service.persistence.EnrollUploadedTempRecordsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the enroll batch upload local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.enrolment.service.impl.EnrollBatchUploadLocalServiceImpl}.
 * </p>
 *
 * @author Baxture
 * @see com.sambaash.platform.srv.enrolment.service.impl.EnrollBatchUploadLocalServiceImpl
 * @see com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil
 * @generated
 */
public abstract class EnrollBatchUploadLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EnrollBatchUploadLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil} to access the enroll batch upload local service.
	 */

	/**
	 * Adds the enroll batch upload to the database. Also notifies the appropriate model listeners.
	 *
	 * @param enrollBatchUpload the enroll batch upload
	 * @return the enroll batch upload that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EnrollBatchUpload addEnrollBatchUpload(
		EnrollBatchUpload enrollBatchUpload) throws SystemException {
		enrollBatchUpload.setNew(true);

		return enrollBatchUploadPersistence.update(enrollBatchUpload);
	}

	/**
	 * Creates a new enroll batch upload with the primary key. Does not add the enroll batch upload to the database.
	 *
	 * @param uploadStatId the primary key for the new enroll batch upload
	 * @return the new enroll batch upload
	 */
	@Override
	public EnrollBatchUpload createEnrollBatchUpload(long uploadStatId) {
		return enrollBatchUploadPersistence.create(uploadStatId);
	}

	/**
	 * Deletes the enroll batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadStatId the primary key of the enroll batch upload
	 * @return the enroll batch upload that was removed
	 * @throws PortalException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EnrollBatchUpload deleteEnrollBatchUpload(long uploadStatId)
		throws PortalException, SystemException {
		return enrollBatchUploadPersistence.remove(uploadStatId);
	}

	/**
	 * Deletes the enroll batch upload from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enrollBatchUpload the enroll batch upload
	 * @return the enroll batch upload that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EnrollBatchUpload deleteEnrollBatchUpload(
		EnrollBatchUpload enrollBatchUpload) throws SystemException {
		return enrollBatchUploadPersistence.remove(enrollBatchUpload);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EnrollBatchUpload.class,
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
		return enrollBatchUploadPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return enrollBatchUploadPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return enrollBatchUploadPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return enrollBatchUploadPersistence.countWithDynamicQuery(dynamicQuery);
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
		return enrollBatchUploadPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public EnrollBatchUpload fetchEnrollBatchUpload(long uploadStatId)
		throws SystemException {
		return enrollBatchUploadPersistence.fetchByPrimaryKey(uploadStatId);
	}

	/**
	 * Returns the enroll batch upload with the primary key.
	 *
	 * @param uploadStatId the primary key of the enroll batch upload
	 * @return the enroll batch upload
	 * @throws PortalException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload getEnrollBatchUpload(long uploadStatId)
		throws PortalException, SystemException {
		return enrollBatchUploadPersistence.findByPrimaryKey(uploadStatId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return enrollBatchUploadPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the enroll batch uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enroll batch uploads
	 * @param end the upper bound of the range of enroll batch uploads (not inclusive)
	 * @return the range of enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> getEnrollBatchUploads(int start, int end)
		throws SystemException {
		return enrollBatchUploadPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of enroll batch uploads.
	 *
	 * @return the number of enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEnrollBatchUploadsCount() throws SystemException {
		return enrollBatchUploadPersistence.countAll();
	}

	/**
	 * Updates the enroll batch upload in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param enrollBatchUpload the enroll batch upload
	 * @return the enroll batch upload that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EnrollBatchUpload updateEnrollBatchUpload(
		EnrollBatchUpload enrollBatchUpload) throws SystemException {
		return enrollBatchUploadPersistence.update(enrollBatchUpload);
	}

	/**
	 * Returns the enroll batch upload local service.
	 *
	 * @return the enroll batch upload local service
	 */
	public com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalService getEnrollBatchUploadLocalService() {
		return enrollBatchUploadLocalService;
	}

	/**
	 * Sets the enroll batch upload local service.
	 *
	 * @param enrollBatchUploadLocalService the enroll batch upload local service
	 */
	public void setEnrollBatchUploadLocalService(
		com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalService enrollBatchUploadLocalService) {
		this.enrollBatchUploadLocalService = enrollBatchUploadLocalService;
	}

	/**
	 * Returns the enroll batch upload persistence.
	 *
	 * @return the enroll batch upload persistence
	 */
	public EnrollBatchUploadPersistence getEnrollBatchUploadPersistence() {
		return enrollBatchUploadPersistence;
	}

	/**
	 * Sets the enroll batch upload persistence.
	 *
	 * @param enrollBatchUploadPersistence the enroll batch upload persistence
	 */
	public void setEnrollBatchUploadPersistence(
		EnrollBatchUploadPersistence enrollBatchUploadPersistence) {
		this.enrollBatchUploadPersistence = enrollBatchUploadPersistence;
	}

	/**
	 * Returns the enroll uploaded temp records local service.
	 *
	 * @return the enroll uploaded temp records local service
	 */
	public com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalService getEnrollUploadedTempRecordsLocalService() {
		return enrollUploadedTempRecordsLocalService;
	}

	/**
	 * Sets the enroll uploaded temp records local service.
	 *
	 * @param enrollUploadedTempRecordsLocalService the enroll uploaded temp records local service
	 */
	public void setEnrollUploadedTempRecordsLocalService(
		com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalService enrollUploadedTempRecordsLocalService) {
		this.enrollUploadedTempRecordsLocalService = enrollUploadedTempRecordsLocalService;
	}

	/**
	 * Returns the enroll uploaded temp records persistence.
	 *
	 * @return the enroll uploaded temp records persistence
	 */
	public EnrollUploadedTempRecordsPersistence getEnrollUploadedTempRecordsPersistence() {
		return enrollUploadedTempRecordsPersistence;
	}

	/**
	 * Sets the enroll uploaded temp records persistence.
	 *
	 * @param enrollUploadedTempRecordsPersistence the enroll uploaded temp records persistence
	 */
	public void setEnrollUploadedTempRecordsPersistence(
		EnrollUploadedTempRecordsPersistence enrollUploadedTempRecordsPersistence) {
		this.enrollUploadedTempRecordsPersistence = enrollUploadedTempRecordsPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload",
			enrollBatchUploadLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload");
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
		return EnrollBatchUpload.class;
	}

	protected String getModelClassName() {
		return EnrollBatchUpload.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = enrollBatchUploadPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalService.class)
	protected com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalService enrollBatchUploadLocalService;
	@BeanReference(type = EnrollBatchUploadPersistence.class)
	protected EnrollBatchUploadPersistence enrollBatchUploadPersistence;
	@BeanReference(type = com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalService.class)
	protected com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalService enrollUploadedTempRecordsLocalService;
	@BeanReference(type = EnrollUploadedTempRecordsPersistence.class)
	protected EnrollUploadedTempRecordsPersistence enrollUploadedTempRecordsPersistence;
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
	private EnrollBatchUploadLocalServiceClpInvoker _clpInvoker = new EnrollBatchUploadLocalServiceClpInvoker();
}