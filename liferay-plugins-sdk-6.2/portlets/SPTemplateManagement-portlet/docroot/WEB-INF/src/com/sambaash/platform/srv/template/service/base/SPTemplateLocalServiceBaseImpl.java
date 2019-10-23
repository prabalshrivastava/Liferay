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

package com.sambaash.platform.srv.template.service.base;

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

import com.sambaash.platform.srv.template.model.SPTemplate;
import com.sambaash.platform.srv.template.service.SPTemplateLocalService;
import com.sambaash.platform.srv.template.service.persistence.SPComponentTemplatePersistence;
import com.sambaash.platform.srv.template.service.persistence.SPTemplateFinder;
import com.sambaash.platform.srv.template.service.persistence.SPTemplatePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p template local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.template.service.impl.SPTemplateLocalServiceImpl}.
 * </p>
 *
 * @author WattabyteIT
 * @see com.sambaash.platform.srv.template.service.impl.SPTemplateLocalServiceImpl
 * @see com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil
 * @generated
 */
public abstract class SPTemplateLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SPTemplateLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil} to access the s p template local service.
	 */

	/**
	 * Adds the s p template to the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTemplate the s p template
	 * @return the s p template that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPTemplate addSPTemplate(SPTemplate spTemplate)
		throws SystemException {
		spTemplate.setNew(true);

		return spTemplatePersistence.update(spTemplate);
	}

	/**
	 * Creates a new s p template with the primary key. Does not add the s p template to the database.
	 *
	 * @param spTemplateId the primary key for the new s p template
	 * @return the new s p template
	 */
	@Override
	public SPTemplate createSPTemplate(long spTemplateId) {
		return spTemplatePersistence.create(spTemplateId);
	}

	/**
	 * Deletes the s p template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTemplateId the primary key of the s p template
	 * @return the s p template that was removed
	 * @throws PortalException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPTemplate deleteSPTemplate(long spTemplateId)
		throws PortalException, SystemException {
		return spTemplatePersistence.remove(spTemplateId);
	}

	/**
	 * Deletes the s p template from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTemplate the s p template
	 * @return the s p template that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPTemplate deleteSPTemplate(SPTemplate spTemplate)
		throws SystemException {
		return spTemplatePersistence.remove(spTemplate);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SPTemplate.class,
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
		return spTemplatePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return spTemplatePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return spTemplatePersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return spTemplatePersistence.countWithDynamicQuery(dynamicQuery);
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
		return spTemplatePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SPTemplate fetchSPTemplate(long spTemplateId)
		throws SystemException {
		return spTemplatePersistence.fetchByPrimaryKey(spTemplateId);
	}

	/**
	 * Returns the s p template with the matching UUID and company.
	 *
	 * @param uuid the s p template's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchSPTemplateByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return spTemplatePersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the s p template matching the UUID and group.
	 *
	 * @param uuid the s p template's UUID
	 * @param groupId the primary key of the group
	 * @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchSPTemplateByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return spTemplatePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the s p template with the primary key.
	 *
	 * @param spTemplateId the primary key of the s p template
	 * @return the s p template
	 * @throws PortalException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate getSPTemplate(long spTemplateId)
		throws PortalException, SystemException {
		return spTemplatePersistence.findByPrimaryKey(spTemplateId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return spTemplatePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the s p template with the matching UUID and company.
	 *
	 * @param uuid the s p template's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching s p template
	 * @throws PortalException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate getSPTemplateByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return spTemplatePersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the s p template matching the UUID and group.
	 *
	 * @param uuid the s p template's UUID
	 * @param groupId the primary key of the group
	 * @return the matching s p template
	 * @throws PortalException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate getSPTemplateByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return spTemplatePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the s p templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @return the range of s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> getSPTemplates(int start, int end)
		throws SystemException {
		return spTemplatePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of s p templates.
	 *
	 * @return the number of s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSPTemplatesCount() throws SystemException {
		return spTemplatePersistence.countAll();
	}

	/**
	 * Updates the s p template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param spTemplate the s p template
	 * @return the s p template that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPTemplate updateSPTemplate(SPTemplate spTemplate)
		throws SystemException {
		return spTemplatePersistence.update(spTemplate);
	}

	/**
	 * Returns the s p component template local service.
	 *
	 * @return the s p component template local service
	 */
	public com.sambaash.platform.srv.template.service.SPComponentTemplateLocalService getSPComponentTemplateLocalService() {
		return spComponentTemplateLocalService;
	}

	/**
	 * Sets the s p component template local service.
	 *
	 * @param spComponentTemplateLocalService the s p component template local service
	 */
	public void setSPComponentTemplateLocalService(
		com.sambaash.platform.srv.template.service.SPComponentTemplateLocalService spComponentTemplateLocalService) {
		this.spComponentTemplateLocalService = spComponentTemplateLocalService;
	}

	/**
	 * Returns the s p component template persistence.
	 *
	 * @return the s p component template persistence
	 */
	public SPComponentTemplatePersistence getSPComponentTemplatePersistence() {
		return spComponentTemplatePersistence;
	}

	/**
	 * Sets the s p component template persistence.
	 *
	 * @param spComponentTemplatePersistence the s p component template persistence
	 */
	public void setSPComponentTemplatePersistence(
		SPComponentTemplatePersistence spComponentTemplatePersistence) {
		this.spComponentTemplatePersistence = spComponentTemplatePersistence;
	}

	/**
	 * Returns the s p template local service.
	 *
	 * @return the s p template local service
	 */
	public com.sambaash.platform.srv.template.service.SPTemplateLocalService getSPTemplateLocalService() {
		return spTemplateLocalService;
	}

	/**
	 * Sets the s p template local service.
	 *
	 * @param spTemplateLocalService the s p template local service
	 */
	public void setSPTemplateLocalService(
		com.sambaash.platform.srv.template.service.SPTemplateLocalService spTemplateLocalService) {
		this.spTemplateLocalService = spTemplateLocalService;
	}

	/**
	 * Returns the s p template persistence.
	 *
	 * @return the s p template persistence
	 */
	public SPTemplatePersistence getSPTemplatePersistence() {
		return spTemplatePersistence;
	}

	/**
	 * Sets the s p template persistence.
	 *
	 * @param spTemplatePersistence the s p template persistence
	 */
	public void setSPTemplatePersistence(
		SPTemplatePersistence spTemplatePersistence) {
		this.spTemplatePersistence = spTemplatePersistence;
	}

	/**
	 * Returns the s p template finder.
	 *
	 * @return the s p template finder
	 */
	public SPTemplateFinder getSPTemplateFinder() {
		return spTemplateFinder;
	}

	/**
	 * Sets the s p template finder.
	 *
	 * @param spTemplateFinder the s p template finder
	 */
	public void setSPTemplateFinder(SPTemplateFinder spTemplateFinder) {
		this.spTemplateFinder = spTemplateFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.template.model.SPTemplate",
			spTemplateLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.template.model.SPTemplate");
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
		return SPTemplate.class;
	}

	protected String getModelClassName() {
		return SPTemplate.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spTemplatePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.template.service.SPComponentTemplateLocalService.class)
	protected com.sambaash.platform.srv.template.service.SPComponentTemplateLocalService spComponentTemplateLocalService;
	@BeanReference(type = SPComponentTemplatePersistence.class)
	protected SPComponentTemplatePersistence spComponentTemplatePersistence;
	@BeanReference(type = com.sambaash.platform.srv.template.service.SPTemplateLocalService.class)
	protected com.sambaash.platform.srv.template.service.SPTemplateLocalService spTemplateLocalService;
	@BeanReference(type = SPTemplatePersistence.class)
	protected SPTemplatePersistence spTemplatePersistence;
	@BeanReference(type = SPTemplateFinder.class)
	protected SPTemplateFinder spTemplateFinder;
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
	private SPTemplateLocalServiceClpInvoker _clpInvoker = new SPTemplateLocalServiceClpInvoker();
}