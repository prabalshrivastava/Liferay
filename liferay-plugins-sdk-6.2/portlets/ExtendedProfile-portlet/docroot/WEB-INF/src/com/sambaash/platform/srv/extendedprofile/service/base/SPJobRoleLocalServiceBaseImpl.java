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

package com.sambaash.platform.srv.extendedprofile.service.base;

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

import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;
import com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalService;
import com.sambaash.platform.srv.extendedprofile.service.persistence.SPCertificationPersistence;
import com.sambaash.platform.srv.extendedprofile.service.persistence.SPCompetencyPersistence;
import com.sambaash.platform.srv.extendedprofile.service.persistence.SPJobRolePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p job role local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.extendedprofile.service.impl.SPJobRoleLocalServiceImpl}.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.extendedprofile.service.impl.SPJobRoleLocalServiceImpl
 * @see com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil
 * @generated
 */
public abstract class SPJobRoleLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements SPJobRoleLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil} to access the s p job role local service.
	 */

	/**
	 * Adds the s p job role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobRole the s p job role
	 * @return the s p job role that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPJobRole addSPJobRole(SPJobRole spJobRole)
		throws SystemException {
		spJobRole.setNew(true);

		return spJobRolePersistence.update(spJobRole);
	}

	/**
	 * Creates a new s p job role with the primary key. Does not add the s p job role to the database.
	 *
	 * @param spJobRoleId the primary key for the new s p job role
	 * @return the new s p job role
	 */
	@Override
	public SPJobRole createSPJobRole(long spJobRoleId) {
		return spJobRolePersistence.create(spJobRoleId);
	}

	/**
	 * Deletes the s p job role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobRoleId the primary key of the s p job role
	 * @return the s p job role that was removed
	 * @throws PortalException if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPJobRole deleteSPJobRole(long spJobRoleId)
		throws PortalException, SystemException {
		return spJobRolePersistence.remove(spJobRoleId);
	}

	/**
	 * Deletes the s p job role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobRole the s p job role
	 * @return the s p job role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPJobRole deleteSPJobRole(SPJobRole spJobRole)
		throws SystemException {
		return spJobRolePersistence.remove(spJobRole);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SPJobRole.class,
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
		return spJobRolePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return spJobRolePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return spJobRolePersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return spJobRolePersistence.countWithDynamicQuery(dynamicQuery);
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
		return spJobRolePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SPJobRole fetchSPJobRole(long spJobRoleId) throws SystemException {
		return spJobRolePersistence.fetchByPrimaryKey(spJobRoleId);
	}

	/**
	 * Returns the s p job role with the primary key.
	 *
	 * @param spJobRoleId the primary key of the s p job role
	 * @return the s p job role
	 * @throws PortalException if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole getSPJobRole(long spJobRoleId)
		throws PortalException, SystemException {
		return spJobRolePersistence.findByPrimaryKey(spJobRoleId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return spJobRolePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the s p job roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job roles
	 * @param end the upper bound of the range of s p job roles (not inclusive)
	 * @return the range of s p job roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobRole> getSPJobRoles(int start, int end)
		throws SystemException {
		return spJobRolePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of s p job roles.
	 *
	 * @return the number of s p job roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSPJobRolesCount() throws SystemException {
		return spJobRolePersistence.countAll();
	}

	/**
	 * Updates the s p job role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param spJobRole the s p job role
	 * @return the s p job role that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPJobRole updateSPJobRole(SPJobRole spJobRole)
		throws SystemException {
		return spJobRolePersistence.update(spJobRole);
	}

	/**
	 * Returns the s p certification local service.
	 *
	 * @return the s p certification local service
	 */
	public com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalService getSPCertificationLocalService() {
		return spCertificationLocalService;
	}

	/**
	 * Sets the s p certification local service.
	 *
	 * @param spCertificationLocalService the s p certification local service
	 */
	public void setSPCertificationLocalService(
		com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalService spCertificationLocalService) {
		this.spCertificationLocalService = spCertificationLocalService;
	}

	/**
	 * Returns the s p certification persistence.
	 *
	 * @return the s p certification persistence
	 */
	public SPCertificationPersistence getSPCertificationPersistence() {
		return spCertificationPersistence;
	}

	/**
	 * Sets the s p certification persistence.
	 *
	 * @param spCertificationPersistence the s p certification persistence
	 */
	public void setSPCertificationPersistence(
		SPCertificationPersistence spCertificationPersistence) {
		this.spCertificationPersistence = spCertificationPersistence;
	}

	/**
	 * Returns the s p competency local service.
	 *
	 * @return the s p competency local service
	 */
	public com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalService getSPCompetencyLocalService() {
		return spCompetencyLocalService;
	}

	/**
	 * Sets the s p competency local service.
	 *
	 * @param spCompetencyLocalService the s p competency local service
	 */
	public void setSPCompetencyLocalService(
		com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalService spCompetencyLocalService) {
		this.spCompetencyLocalService = spCompetencyLocalService;
	}

	/**
	 * Returns the s p competency persistence.
	 *
	 * @return the s p competency persistence
	 */
	public SPCompetencyPersistence getSPCompetencyPersistence() {
		return spCompetencyPersistence;
	}

	/**
	 * Sets the s p competency persistence.
	 *
	 * @param spCompetencyPersistence the s p competency persistence
	 */
	public void setSPCompetencyPersistence(
		SPCompetencyPersistence spCompetencyPersistence) {
		this.spCompetencyPersistence = spCompetencyPersistence;
	}

	/**
	 * Returns the s p job role local service.
	 *
	 * @return the s p job role local service
	 */
	public com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalService getSPJobRoleLocalService() {
		return spJobRoleLocalService;
	}

	/**
	 * Sets the s p job role local service.
	 *
	 * @param spJobRoleLocalService the s p job role local service
	 */
	public void setSPJobRoleLocalService(
		com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalService spJobRoleLocalService) {
		this.spJobRoleLocalService = spJobRoleLocalService;
	}

	/**
	 * Returns the s p job role persistence.
	 *
	 * @return the s p job role persistence
	 */
	public SPJobRolePersistence getSPJobRolePersistence() {
		return spJobRolePersistence;
	}

	/**
	 * Sets the s p job role persistence.
	 *
	 * @param spJobRolePersistence the s p job role persistence
	 */
	public void setSPJobRolePersistence(
		SPJobRolePersistence spJobRolePersistence) {
		this.spJobRolePersistence = spJobRolePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.extendedprofile.model.SPJobRole",
			spJobRoleLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.extendedprofile.model.SPJobRole");
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
		return SPJobRole.class;
	}

	protected String getModelClassName() {
		return SPJobRole.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spJobRolePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalService.class)
	protected com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalService spCertificationLocalService;
	@BeanReference(type = SPCertificationPersistence.class)
	protected SPCertificationPersistence spCertificationPersistence;
	@BeanReference(type = com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalService.class)
	protected com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalService spCompetencyLocalService;
	@BeanReference(type = SPCompetencyPersistence.class)
	protected SPCompetencyPersistence spCompetencyPersistence;
	@BeanReference(type = com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalService.class)
	protected com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalService spJobRoleLocalService;
	@BeanReference(type = SPJobRolePersistence.class)
	protected SPJobRolePersistence spJobRolePersistence;
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
	private SPJobRoleLocalServiceClpInvoker _clpInvoker = new SPJobRoleLocalServiceClpInvoker();
}