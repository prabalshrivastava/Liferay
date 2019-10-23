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

package com.sambaash.platform.srv.processbuilder.service.base;

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

import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalService;
import com.sambaash.platform.srv.processbuilder.service.persistence.PECustomActionInfoPersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEDummyEntityPersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessAuditPersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessPersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStagePersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStateFinder;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStatePersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStatusTypePersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PERulePersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PERuleSetPersistence;
import com.sambaash.platform.srv.processbuilder.service.persistence.PESupervisorPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the p e process stage local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.processbuilder.service.impl.PEProcessStageLocalServiceImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEProcessStageLocalServiceImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil
 * @generated
 */
public abstract class PEProcessStageLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements PEProcessStageLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil} to access the p e process stage local service.
	 */

	/**
	 * Adds the p e process stage to the database. Also notifies the appropriate model listeners.
	 *
	 * @param peProcessStage the p e process stage
	 * @return the p e process stage that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PEProcessStage addPEProcessStage(PEProcessStage peProcessStage)
		throws SystemException {
		peProcessStage.setNew(true);

		return peProcessStagePersistence.update(peProcessStage);
	}

	/**
	 * Creates a new p e process stage with the primary key. Does not add the p e process stage to the database.
	 *
	 * @param spPEProcessStageId the primary key for the new p e process stage
	 * @return the new p e process stage
	 */
	@Override
	public PEProcessStage createPEProcessStage(long spPEProcessStageId) {
		return peProcessStagePersistence.create(spPEProcessStageId);
	}

	/**
	 * Deletes the p e process stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEProcessStageId the primary key of the p e process stage
	 * @return the p e process stage that was removed
	 * @throws PortalException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PEProcessStage deletePEProcessStage(long spPEProcessStageId)
		throws PortalException, SystemException {
		return peProcessStagePersistence.remove(spPEProcessStageId);
	}

	/**
	 * Deletes the p e process stage from the database. Also notifies the appropriate model listeners.
	 *
	 * @param peProcessStage the p e process stage
	 * @return the p e process stage that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PEProcessStage deletePEProcessStage(PEProcessStage peProcessStage)
		throws SystemException {
		return peProcessStagePersistence.remove(peProcessStage);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(PEProcessStage.class,
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
		return peProcessStagePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return peProcessStagePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return peProcessStagePersistence.findWithDynamicQuery(dynamicQuery,
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
		return peProcessStagePersistence.countWithDynamicQuery(dynamicQuery);
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
		return peProcessStagePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public PEProcessStage fetchPEProcessStage(long spPEProcessStageId)
		throws SystemException {
		return peProcessStagePersistence.fetchByPrimaryKey(spPEProcessStageId);
	}

	/**
	 * Returns the p e process stage with the matching UUID and company.
	 *
	 * @param uuid the p e process stage's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchPEProcessStageByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return peProcessStagePersistence.fetchByUuid_C_First(uuid, companyId,
			null);
	}

	/**
	 * Returns the p e process stage matching the UUID and group.
	 *
	 * @param uuid the p e process stage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchPEProcessStageByUuidAndGroupId(String uuid,
		long groupId) throws SystemException {
		return peProcessStagePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the p e process stage with the primary key.
	 *
	 * @param spPEProcessStageId the primary key of the p e process stage
	 * @return the p e process stage
	 * @throws PortalException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage getPEProcessStage(long spPEProcessStageId)
		throws PortalException, SystemException {
		return peProcessStagePersistence.findByPrimaryKey(spPEProcessStageId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return peProcessStagePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the p e process stage with the matching UUID and company.
	 *
	 * @param uuid the p e process stage's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching p e process stage
	 * @throws PortalException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage getPEProcessStageByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return peProcessStagePersistence.findByUuid_C_First(uuid, companyId,
			null);
	}

	/**
	 * Returns the p e process stage matching the UUID and group.
	 *
	 * @param uuid the p e process stage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching p e process stage
	 * @throws PortalException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage getPEProcessStageByUuidAndGroupId(String uuid,
		long groupId) throws PortalException, SystemException {
		return peProcessStagePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the p e process stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @return the range of p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> getPEProcessStages(int start, int end)
		throws SystemException {
		return peProcessStagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of p e process stages.
	 *
	 * @return the number of p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getPEProcessStagesCount() throws SystemException {
		return peProcessStagePersistence.countAll();
	}

	/**
	 * Updates the p e process stage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param peProcessStage the p e process stage
	 * @return the p e process stage that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PEProcessStage updatePEProcessStage(PEProcessStage peProcessStage)
		throws SystemException {
		return peProcessStagePersistence.update(peProcessStage);
	}

	/**
	 * Returns the form builder local service.
	 *
	 * @return the form builder local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalService getFormBuilderLocalService() {
		return formBuilderLocalService;
	}

	/**
	 * Sets the form builder local service.
	 *
	 * @param formBuilderLocalService the form builder local service
	 */
	public void setFormBuilderLocalService(
		com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalService formBuilderLocalService) {
		this.formBuilderLocalService = formBuilderLocalService;
	}

	/**
	 * Returns the form builder remote service.
	 *
	 * @return the form builder remote service
	 */
	public com.sambaash.platform.srv.processbuilder.service.FormBuilderService getFormBuilderService() {
		return formBuilderService;
	}

	/**
	 * Sets the form builder remote service.
	 *
	 * @param formBuilderService the form builder remote service
	 */
	public void setFormBuilderService(
		com.sambaash.platform.srv.processbuilder.service.FormBuilderService formBuilderService) {
		this.formBuilderService = formBuilderService;
	}

	/**
	 * Returns the p e custom action info local service.
	 *
	 * @return the p e custom action info local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalService getPECustomActionInfoLocalService() {
		return peCustomActionInfoLocalService;
	}

	/**
	 * Sets the p e custom action info local service.
	 *
	 * @param peCustomActionInfoLocalService the p e custom action info local service
	 */
	public void setPECustomActionInfoLocalService(
		com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalService peCustomActionInfoLocalService) {
		this.peCustomActionInfoLocalService = peCustomActionInfoLocalService;
	}

	/**
	 * Returns the p e custom action info persistence.
	 *
	 * @return the p e custom action info persistence
	 */
	public PECustomActionInfoPersistence getPECustomActionInfoPersistence() {
		return peCustomActionInfoPersistence;
	}

	/**
	 * Sets the p e custom action info persistence.
	 *
	 * @param peCustomActionInfoPersistence the p e custom action info persistence
	 */
	public void setPECustomActionInfoPersistence(
		PECustomActionInfoPersistence peCustomActionInfoPersistence) {
		this.peCustomActionInfoPersistence = peCustomActionInfoPersistence;
	}

	/**
	 * Returns the p e dummy entity local service.
	 *
	 * @return the p e dummy entity local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalService getPEDummyEntityLocalService() {
		return peDummyEntityLocalService;
	}

	/**
	 * Sets the p e dummy entity local service.
	 *
	 * @param peDummyEntityLocalService the p e dummy entity local service
	 */
	public void setPEDummyEntityLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalService peDummyEntityLocalService) {
		this.peDummyEntityLocalService = peDummyEntityLocalService;
	}

	/**
	 * Returns the p e dummy entity persistence.
	 *
	 * @return the p e dummy entity persistence
	 */
	public PEDummyEntityPersistence getPEDummyEntityPersistence() {
		return peDummyEntityPersistence;
	}

	/**
	 * Sets the p e dummy entity persistence.
	 *
	 * @param peDummyEntityPersistence the p e dummy entity persistence
	 */
	public void setPEDummyEntityPersistence(
		PEDummyEntityPersistence peDummyEntityPersistence) {
		this.peDummyEntityPersistence = peDummyEntityPersistence;
	}

	/**
	 * Returns the p e engine local service.
	 *
	 * @return the p e engine local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEEngineLocalService getPEEngineLocalService() {
		return peEngineLocalService;
	}

	/**
	 * Sets the p e engine local service.
	 *
	 * @param peEngineLocalService the p e engine local service
	 */
	public void setPEEngineLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEEngineLocalService peEngineLocalService) {
		this.peEngineLocalService = peEngineLocalService;
	}

	/**
	 * Returns the p e engine remote service.
	 *
	 * @return the p e engine remote service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEEngineService getPEEngineService() {
		return peEngineService;
	}

	/**
	 * Sets the p e engine remote service.
	 *
	 * @param peEngineService the p e engine remote service
	 */
	public void setPEEngineService(
		com.sambaash.platform.srv.processbuilder.service.PEEngineService peEngineService) {
		this.peEngineService = peEngineService;
	}

	/**
	 * Returns the p e process local service.
	 *
	 * @return the p e process local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService getPEProcessLocalService() {
		return peProcessLocalService;
	}

	/**
	 * Sets the p e process local service.
	 *
	 * @param peProcessLocalService the p e process local service
	 */
	public void setPEProcessLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService peProcessLocalService) {
		this.peProcessLocalService = peProcessLocalService;
	}

	/**
	 * Returns the p e process persistence.
	 *
	 * @return the p e process persistence
	 */
	public PEProcessPersistence getPEProcessPersistence() {
		return peProcessPersistence;
	}

	/**
	 * Sets the p e process persistence.
	 *
	 * @param peProcessPersistence the p e process persistence
	 */
	public void setPEProcessPersistence(
		PEProcessPersistence peProcessPersistence) {
		this.peProcessPersistence = peProcessPersistence;
	}

	/**
	 * Returns the p e process audit local service.
	 *
	 * @return the p e process audit local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalService getPEProcessAuditLocalService() {
		return peProcessAuditLocalService;
	}

	/**
	 * Sets the p e process audit local service.
	 *
	 * @param peProcessAuditLocalService the p e process audit local service
	 */
	public void setPEProcessAuditLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalService peProcessAuditLocalService) {
		this.peProcessAuditLocalService = peProcessAuditLocalService;
	}

	/**
	 * Returns the p e process audit persistence.
	 *
	 * @return the p e process audit persistence
	 */
	public PEProcessAuditPersistence getPEProcessAuditPersistence() {
		return peProcessAuditPersistence;
	}

	/**
	 * Sets the p e process audit persistence.
	 *
	 * @param peProcessAuditPersistence the p e process audit persistence
	 */
	public void setPEProcessAuditPersistence(
		PEProcessAuditPersistence peProcessAuditPersistence) {
		this.peProcessAuditPersistence = peProcessAuditPersistence;
	}

	/**
	 * Returns the p e process stage local service.
	 *
	 * @return the p e process stage local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalService getPEProcessStageLocalService() {
		return peProcessStageLocalService;
	}

	/**
	 * Sets the p e process stage local service.
	 *
	 * @param peProcessStageLocalService the p e process stage local service
	 */
	public void setPEProcessStageLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalService peProcessStageLocalService) {
		this.peProcessStageLocalService = peProcessStageLocalService;
	}

	/**
	 * Returns the p e process stage persistence.
	 *
	 * @return the p e process stage persistence
	 */
	public PEProcessStagePersistence getPEProcessStagePersistence() {
		return peProcessStagePersistence;
	}

	/**
	 * Sets the p e process stage persistence.
	 *
	 * @param peProcessStagePersistence the p e process stage persistence
	 */
	public void setPEProcessStagePersistence(
		PEProcessStagePersistence peProcessStagePersistence) {
		this.peProcessStagePersistence = peProcessStagePersistence;
	}

	/**
	 * Returns the p e process state local service.
	 *
	 * @return the p e process state local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalService getPEProcessStateLocalService() {
		return peProcessStateLocalService;
	}

	/**
	 * Sets the p e process state local service.
	 *
	 * @param peProcessStateLocalService the p e process state local service
	 */
	public void setPEProcessStateLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalService peProcessStateLocalService) {
		this.peProcessStateLocalService = peProcessStateLocalService;
	}

	/**
	 * Returns the p e process state persistence.
	 *
	 * @return the p e process state persistence
	 */
	public PEProcessStatePersistence getPEProcessStatePersistence() {
		return peProcessStatePersistence;
	}

	/**
	 * Sets the p e process state persistence.
	 *
	 * @param peProcessStatePersistence the p e process state persistence
	 */
	public void setPEProcessStatePersistence(
		PEProcessStatePersistence peProcessStatePersistence) {
		this.peProcessStatePersistence = peProcessStatePersistence;
	}

	/**
	 * Returns the p e process state finder.
	 *
	 * @return the p e process state finder
	 */
	public PEProcessStateFinder getPEProcessStateFinder() {
		return peProcessStateFinder;
	}

	/**
	 * Sets the p e process state finder.
	 *
	 * @param peProcessStateFinder the p e process state finder
	 */
	public void setPEProcessStateFinder(
		PEProcessStateFinder peProcessStateFinder) {
		this.peProcessStateFinder = peProcessStateFinder;
	}

	/**
	 * Returns the p e process status type local service.
	 *
	 * @return the p e process status type local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalService getPEProcessStatusTypeLocalService() {
		return peProcessStatusTypeLocalService;
	}

	/**
	 * Sets the p e process status type local service.
	 *
	 * @param peProcessStatusTypeLocalService the p e process status type local service
	 */
	public void setPEProcessStatusTypeLocalService(
		com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalService peProcessStatusTypeLocalService) {
		this.peProcessStatusTypeLocalService = peProcessStatusTypeLocalService;
	}

	/**
	 * Returns the p e process status type persistence.
	 *
	 * @return the p e process status type persistence
	 */
	public PEProcessStatusTypePersistence getPEProcessStatusTypePersistence() {
		return peProcessStatusTypePersistence;
	}

	/**
	 * Sets the p e process status type persistence.
	 *
	 * @param peProcessStatusTypePersistence the p e process status type persistence
	 */
	public void setPEProcessStatusTypePersistence(
		PEProcessStatusTypePersistence peProcessStatusTypePersistence) {
		this.peProcessStatusTypePersistence = peProcessStatusTypePersistence;
	}

	/**
	 * Returns the p e rule local service.
	 *
	 * @return the p e rule local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PERuleLocalService getPERuleLocalService() {
		return peRuleLocalService;
	}

	/**
	 * Sets the p e rule local service.
	 *
	 * @param peRuleLocalService the p e rule local service
	 */
	public void setPERuleLocalService(
		com.sambaash.platform.srv.processbuilder.service.PERuleLocalService peRuleLocalService) {
		this.peRuleLocalService = peRuleLocalService;
	}

	/**
	 * Returns the p e rule persistence.
	 *
	 * @return the p e rule persistence
	 */
	public PERulePersistence getPERulePersistence() {
		return peRulePersistence;
	}

	/**
	 * Sets the p e rule persistence.
	 *
	 * @param peRulePersistence the p e rule persistence
	 */
	public void setPERulePersistence(PERulePersistence peRulePersistence) {
		this.peRulePersistence = peRulePersistence;
	}

	/**
	 * Returns the p e rule set local service.
	 *
	 * @return the p e rule set local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalService getPERuleSetLocalService() {
		return peRuleSetLocalService;
	}

	/**
	 * Sets the p e rule set local service.
	 *
	 * @param peRuleSetLocalService the p e rule set local service
	 */
	public void setPERuleSetLocalService(
		com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalService peRuleSetLocalService) {
		this.peRuleSetLocalService = peRuleSetLocalService;
	}

	/**
	 * Returns the p e rule set persistence.
	 *
	 * @return the p e rule set persistence
	 */
	public PERuleSetPersistence getPERuleSetPersistence() {
		return peRuleSetPersistence;
	}

	/**
	 * Sets the p e rule set persistence.
	 *
	 * @param peRuleSetPersistence the p e rule set persistence
	 */
	public void setPERuleSetPersistence(
		PERuleSetPersistence peRuleSetPersistence) {
		this.peRuleSetPersistence = peRuleSetPersistence;
	}

	/**
	 * Returns the p e supervisor local service.
	 *
	 * @return the p e supervisor local service
	 */
	public com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalService getPESupervisorLocalService() {
		return peSupervisorLocalService;
	}

	/**
	 * Sets the p e supervisor local service.
	 *
	 * @param peSupervisorLocalService the p e supervisor local service
	 */
	public void setPESupervisorLocalService(
		com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalService peSupervisorLocalService) {
		this.peSupervisorLocalService = peSupervisorLocalService;
	}

	/**
	 * Returns the p e supervisor persistence.
	 *
	 * @return the p e supervisor persistence
	 */
	public PESupervisorPersistence getPESupervisorPersistence() {
		return peSupervisorPersistence;
	}

	/**
	 * Sets the p e supervisor persistence.
	 *
	 * @param peSupervisorPersistence the p e supervisor persistence
	 */
	public void setPESupervisorPersistence(
		PESupervisorPersistence peSupervisorPersistence) {
		this.peSupervisorPersistence = peSupervisorPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.processbuilder.model.PEProcessStage",
			peProcessStageLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.processbuilder.model.PEProcessStage");
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
		return PEProcessStage.class;
	}

	protected String getModelClassName() {
		return PEProcessStage.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = peProcessStagePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalService formBuilderLocalService;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.FormBuilderService.class)
	protected com.sambaash.platform.srv.processbuilder.service.FormBuilderService formBuilderService;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalService peCustomActionInfoLocalService;
	@BeanReference(type = PECustomActionInfoPersistence.class)
	protected PECustomActionInfoPersistence peCustomActionInfoPersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalService peDummyEntityLocalService;
	@BeanReference(type = PEDummyEntityPersistence.class)
	protected PEDummyEntityPersistence peDummyEntityPersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEEngineLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEEngineLocalService peEngineLocalService;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEEngineService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEEngineService peEngineService;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService peProcessLocalService;
	@BeanReference(type = PEProcessPersistence.class)
	protected PEProcessPersistence peProcessPersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalService peProcessAuditLocalService;
	@BeanReference(type = PEProcessAuditPersistence.class)
	protected PEProcessAuditPersistence peProcessAuditPersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalService peProcessStageLocalService;
	@BeanReference(type = PEProcessStagePersistence.class)
	protected PEProcessStagePersistence peProcessStagePersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalService peProcessStateLocalService;
	@BeanReference(type = PEProcessStatePersistence.class)
	protected PEProcessStatePersistence peProcessStatePersistence;
	@BeanReference(type = PEProcessStateFinder.class)
	protected PEProcessStateFinder peProcessStateFinder;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalService peProcessStatusTypeLocalService;
	@BeanReference(type = PEProcessStatusTypePersistence.class)
	protected PEProcessStatusTypePersistence peProcessStatusTypePersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PERuleLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PERuleLocalService peRuleLocalService;
	@BeanReference(type = PERulePersistence.class)
	protected PERulePersistence peRulePersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalService peRuleSetLocalService;
	@BeanReference(type = PERuleSetPersistence.class)
	protected PERuleSetPersistence peRuleSetPersistence;
	@BeanReference(type = com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalService.class)
	protected com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalService peSupervisorLocalService;
	@BeanReference(type = PESupervisorPersistence.class)
	protected PESupervisorPersistence peSupervisorPersistence;
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
	private PEProcessStageLocalServiceClpInvoker _clpInvoker = new PEProcessStageLocalServiceClpInvoker();
}