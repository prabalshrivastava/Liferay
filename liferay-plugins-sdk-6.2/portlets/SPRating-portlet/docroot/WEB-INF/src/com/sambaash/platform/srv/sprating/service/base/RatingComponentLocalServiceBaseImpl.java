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

package com.sambaash.platform.srv.sprating.service.base;

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

import com.sambaash.platform.srv.sprating.model.RatingComponent;
import com.sambaash.platform.srv.sprating.service.RatingComponentLocalService;
import com.sambaash.platform.srv.sprating.service.persistence.AttrRatePersistence;
import com.sambaash.platform.srv.sprating.service.persistence.RatingAttrPersistence;
import com.sambaash.platform.srv.sprating.service.persistence.RatingComponentPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the rating component local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.sprating.service.impl.RatingComponentLocalServiceImpl}.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.sprating.service.impl.RatingComponentLocalServiceImpl
 * @see com.sambaash.platform.srv.sprating.service.RatingComponentLocalServiceUtil
 * @generated
 */
public abstract class RatingComponentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements RatingComponentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.sprating.service.RatingComponentLocalServiceUtil} to access the rating component local service.
	 */

	/**
	 * Adds the rating component to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ratingComponent the rating component
	 * @return the rating component that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RatingComponent addRatingComponent(RatingComponent ratingComponent)
		throws SystemException {
		ratingComponent.setNew(true);

		return ratingComponentPersistence.update(ratingComponent);
	}

	/**
	 * Creates a new rating component with the primary key. Does not add the rating component to the database.
	 *
	 * @param spRatingComponentId the primary key for the new rating component
	 * @return the new rating component
	 */
	@Override
	public RatingComponent createRatingComponent(long spRatingComponentId) {
		return ratingComponentPersistence.create(spRatingComponentId);
	}

	/**
	 * Deletes the rating component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spRatingComponentId the primary key of the rating component
	 * @return the rating component that was removed
	 * @throws PortalException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RatingComponent deleteRatingComponent(long spRatingComponentId)
		throws PortalException, SystemException {
		return ratingComponentPersistence.remove(spRatingComponentId);
	}

	/**
	 * Deletes the rating component from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ratingComponent the rating component
	 * @return the rating component that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RatingComponent deleteRatingComponent(
		RatingComponent ratingComponent) throws SystemException {
		return ratingComponentPersistence.remove(ratingComponent);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(RatingComponent.class,
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
		return ratingComponentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return ratingComponentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return ratingComponentPersistence.findWithDynamicQuery(dynamicQuery,
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
		return ratingComponentPersistence.countWithDynamicQuery(dynamicQuery);
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
		return ratingComponentPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public RatingComponent fetchRatingComponent(long spRatingComponentId)
		throws SystemException {
		return ratingComponentPersistence.fetchByPrimaryKey(spRatingComponentId);
	}

	/**
	 * Returns the rating component with the matching UUID and company.
	 *
	 * @param uuid the rating component's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchRatingComponentByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return ratingComponentPersistence.fetchByUuid_C_First(uuid, companyId,
			null);
	}

	/**
	 * Returns the rating component matching the UUID and group.
	 *
	 * @param uuid the rating component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchRatingComponentByUuidAndGroupId(String uuid,
		long groupId) throws SystemException {
		return ratingComponentPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rating component with the primary key.
	 *
	 * @param spRatingComponentId the primary key of the rating component
	 * @return the rating component
	 * @throws PortalException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent getRatingComponent(long spRatingComponentId)
		throws PortalException, SystemException {
		return ratingComponentPersistence.findByPrimaryKey(spRatingComponentId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return ratingComponentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the rating component with the matching UUID and company.
	 *
	 * @param uuid the rating component's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching rating component
	 * @throws PortalException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent getRatingComponentByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return ratingComponentPersistence.findByUuid_C_First(uuid, companyId,
			null);
	}

	/**
	 * Returns the rating component matching the UUID and group.
	 *
	 * @param uuid the rating component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rating component
	 * @throws PortalException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent getRatingComponentByUuidAndGroupId(String uuid,
		long groupId) throws PortalException, SystemException {
		return ratingComponentPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the rating components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @return the range of rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> getRatingComponents(int start, int end)
		throws SystemException {
		return ratingComponentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of rating components.
	 *
	 * @return the number of rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getRatingComponentsCount() throws SystemException {
		return ratingComponentPersistence.countAll();
	}

	/**
	 * Updates the rating component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ratingComponent the rating component
	 * @return the rating component that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RatingComponent updateRatingComponent(
		RatingComponent ratingComponent) throws SystemException {
		return ratingComponentPersistence.update(ratingComponent);
	}

	/**
	 * Returns the attr rate local service.
	 *
	 * @return the attr rate local service
	 */
	public com.sambaash.platform.srv.sprating.service.AttrRateLocalService getAttrRateLocalService() {
		return attrRateLocalService;
	}

	/**
	 * Sets the attr rate local service.
	 *
	 * @param attrRateLocalService the attr rate local service
	 */
	public void setAttrRateLocalService(
		com.sambaash.platform.srv.sprating.service.AttrRateLocalService attrRateLocalService) {
		this.attrRateLocalService = attrRateLocalService;
	}

	/**
	 * Returns the attr rate persistence.
	 *
	 * @return the attr rate persistence
	 */
	public AttrRatePersistence getAttrRatePersistence() {
		return attrRatePersistence;
	}

	/**
	 * Sets the attr rate persistence.
	 *
	 * @param attrRatePersistence the attr rate persistence
	 */
	public void setAttrRatePersistence(AttrRatePersistence attrRatePersistence) {
		this.attrRatePersistence = attrRatePersistence;
	}

	/**
	 * Returns the rating attr local service.
	 *
	 * @return the rating attr local service
	 */
	public com.sambaash.platform.srv.sprating.service.RatingAttrLocalService getRatingAttrLocalService() {
		return ratingAttrLocalService;
	}

	/**
	 * Sets the rating attr local service.
	 *
	 * @param ratingAttrLocalService the rating attr local service
	 */
	public void setRatingAttrLocalService(
		com.sambaash.platform.srv.sprating.service.RatingAttrLocalService ratingAttrLocalService) {
		this.ratingAttrLocalService = ratingAttrLocalService;
	}

	/**
	 * Returns the rating attr persistence.
	 *
	 * @return the rating attr persistence
	 */
	public RatingAttrPersistence getRatingAttrPersistence() {
		return ratingAttrPersistence;
	}

	/**
	 * Sets the rating attr persistence.
	 *
	 * @param ratingAttrPersistence the rating attr persistence
	 */
	public void setRatingAttrPersistence(
		RatingAttrPersistence ratingAttrPersistence) {
		this.ratingAttrPersistence = ratingAttrPersistence;
	}

	/**
	 * Returns the rating component local service.
	 *
	 * @return the rating component local service
	 */
	public com.sambaash.platform.srv.sprating.service.RatingComponentLocalService getRatingComponentLocalService() {
		return ratingComponentLocalService;
	}

	/**
	 * Sets the rating component local service.
	 *
	 * @param ratingComponentLocalService the rating component local service
	 */
	public void setRatingComponentLocalService(
		com.sambaash.platform.srv.sprating.service.RatingComponentLocalService ratingComponentLocalService) {
		this.ratingComponentLocalService = ratingComponentLocalService;
	}

	/**
	 * Returns the rating component persistence.
	 *
	 * @return the rating component persistence
	 */
	public RatingComponentPersistence getRatingComponentPersistence() {
		return ratingComponentPersistence;
	}

	/**
	 * Sets the rating component persistence.
	 *
	 * @param ratingComponentPersistence the rating component persistence
	 */
	public void setRatingComponentPersistence(
		RatingComponentPersistence ratingComponentPersistence) {
		this.ratingComponentPersistence = ratingComponentPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.sprating.model.RatingComponent",
			ratingComponentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.sprating.model.RatingComponent");
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
		return RatingComponent.class;
	}

	protected String getModelClassName() {
		return RatingComponent.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ratingComponentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.sprating.service.AttrRateLocalService.class)
	protected com.sambaash.platform.srv.sprating.service.AttrRateLocalService attrRateLocalService;
	@BeanReference(type = AttrRatePersistence.class)
	protected AttrRatePersistence attrRatePersistence;
	@BeanReference(type = com.sambaash.platform.srv.sprating.service.RatingAttrLocalService.class)
	protected com.sambaash.platform.srv.sprating.service.RatingAttrLocalService ratingAttrLocalService;
	@BeanReference(type = RatingAttrPersistence.class)
	protected RatingAttrPersistence ratingAttrPersistence;
	@BeanReference(type = com.sambaash.platform.srv.sprating.service.RatingComponentLocalService.class)
	protected com.sambaash.platform.srv.sprating.service.RatingComponentLocalService ratingComponentLocalService;
	@BeanReference(type = RatingComponentPersistence.class)
	protected RatingComponentPersistence ratingComponentPersistence;
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
	private RatingComponentLocalServiceClpInvoker _clpInvoker = new RatingComponentLocalServiceClpInvoker();
}