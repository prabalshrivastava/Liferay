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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PEProcessStageLocalService}.
 *
 * @author nareshchebolu
 * @see PEProcessStageLocalService
 * @generated
 */
public class PEProcessStageLocalServiceWrapper
	implements PEProcessStageLocalService,
		ServiceWrapper<PEProcessStageLocalService> {
	public PEProcessStageLocalServiceWrapper(
		PEProcessStageLocalService peProcessStageLocalService) {
		_peProcessStageLocalService = peProcessStageLocalService;
	}

	/**
	* Adds the p e process stage to the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessStage the p e process stage
	* @return the p e process stage that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage addPEProcessStage(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.addPEProcessStage(peProcessStage);
	}

	/**
	* Creates a new p e process stage with the primary key. Does not add the p e process stage to the database.
	*
	* @param spPEProcessStageId the primary key for the new p e process stage
	* @return the new p e process stage
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage createPEProcessStage(
		long spPEProcessStageId) {
		return _peProcessStageLocalService.createPEProcessStage(spPEProcessStageId);
	}

	/**
	* Deletes the p e process stage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStageId the primary key of the p e process stage
	* @return the p e process stage that was removed
	* @throws PortalException if a p e process stage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage deletePEProcessStage(
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.deletePEProcessStage(spPEProcessStageId);
	}

	/**
	* Deletes the p e process stage from the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessStage the p e process stage
	* @return the p e process stage that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage deletePEProcessStage(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.deletePEProcessStage(peProcessStage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peProcessStageLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.dynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchPEProcessStage(
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.fetchPEProcessStage(spPEProcessStageId);
	}

	/**
	* Returns the p e process stage with the matching UUID and company.
	*
	* @param uuid the p e process stage's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchPEProcessStageByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.fetchPEProcessStageByUuidAndCompanyId(uuid,
			companyId);
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
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchPEProcessStageByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.fetchPEProcessStageByUuidAndGroupId(uuid,
			groupId);
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
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage getPEProcessStage(
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.getPEProcessStage(spPEProcessStageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e process stage with the matching UUID and company.
	*
	* @param uuid the p e process stage's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process stage
	* @throws PortalException if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage getPEProcessStageByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.getPEProcessStageByUuidAndCompanyId(uuid,
			companyId);
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
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage getPEProcessStageByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.getPEProcessStageByUuidAndGroupId(uuid,
			groupId);
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
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> getPEProcessStages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.getPEProcessStages(start, end);
	}

	/**
	* Returns the number of p e process stages.
	*
	* @return the number of p e process stages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPEProcessStagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.getPEProcessStagesCount();
	}

	/**
	* Updates the p e process stage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peProcessStage the p e process stage
	* @return the p e process stage that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage updatePEProcessStage(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStageLocalService.updatePEProcessStage(peProcessStage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peProcessStageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peProcessStageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peProcessStageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PEProcessStageLocalService getWrappedPEProcessStageLocalService() {
		return _peProcessStageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPEProcessStageLocalService(
		PEProcessStageLocalService peProcessStageLocalService) {
		_peProcessStageLocalService = peProcessStageLocalService;
	}

	@Override
	public PEProcessStageLocalService getWrappedService() {
		return _peProcessStageLocalService;
	}

	@Override
	public void setWrappedService(
		PEProcessStageLocalService peProcessStageLocalService) {
		_peProcessStageLocalService = peProcessStageLocalService;
	}

	private PEProcessStageLocalService _peProcessStageLocalService;
}