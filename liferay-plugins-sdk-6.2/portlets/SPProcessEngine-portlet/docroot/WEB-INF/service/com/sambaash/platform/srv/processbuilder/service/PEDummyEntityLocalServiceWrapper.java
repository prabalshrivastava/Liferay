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
 * Provides a wrapper for {@link PEDummyEntityLocalService}.
 *
 * @author nareshchebolu
 * @see PEDummyEntityLocalService
 * @generated
 */
public class PEDummyEntityLocalServiceWrapper
	implements PEDummyEntityLocalService,
		ServiceWrapper<PEDummyEntityLocalService> {
	public PEDummyEntityLocalServiceWrapper(
		PEDummyEntityLocalService peDummyEntityLocalService) {
		_peDummyEntityLocalService = peDummyEntityLocalService;
	}

	/**
	* Adds the p e dummy entity to the database. Also notifies the appropriate model listeners.
	*
	* @param peDummyEntity the p e dummy entity
	* @return the p e dummy entity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity addPEDummyEntity(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.addPEDummyEntity(peDummyEntity);
	}

	/**
	* Creates a new p e dummy entity with the primary key. Does not add the p e dummy entity to the database.
	*
	* @param spPEDummyEntityId the primary key for the new p e dummy entity
	* @return the new p e dummy entity
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity createPEDummyEntity(
		long spPEDummyEntityId) {
		return _peDummyEntityLocalService.createPEDummyEntity(spPEDummyEntityId);
	}

	/**
	* Deletes the p e dummy entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEDummyEntityId the primary key of the p e dummy entity
	* @return the p e dummy entity that was removed
	* @throws PortalException if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity deletePEDummyEntity(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.deletePEDummyEntity(spPEDummyEntityId);
	}

	/**
	* Deletes the p e dummy entity from the database. Also notifies the appropriate model listeners.
	*
	* @param peDummyEntity the p e dummy entity
	* @return the p e dummy entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity deletePEDummyEntity(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.deletePEDummyEntity(peDummyEntity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peDummyEntityLocalService.dynamicQuery();
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
		return _peDummyEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peDummyEntityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peDummyEntityLocalService.dynamicQuery(dynamicQuery, start,
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
		return _peDummyEntityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peDummyEntityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchPEDummyEntity(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.fetchPEDummyEntity(spPEDummyEntityId);
	}

	/**
	* Returns the p e dummy entity with the matching UUID and company.
	*
	* @param uuid the p e dummy entity's UUID
	* @param companyId the primary key of the company
	* @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchPEDummyEntityByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.fetchPEDummyEntityByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e dummy entity matching the UUID and group.
	*
	* @param uuid the p e dummy entity's UUID
	* @param groupId the primary key of the group
	* @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchPEDummyEntityByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.fetchPEDummyEntityByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the p e dummy entity with the primary key.
	*
	* @param spPEDummyEntityId the primary key of the p e dummy entity
	* @return the p e dummy entity
	* @throws PortalException if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity getPEDummyEntity(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEDummyEntity(spPEDummyEntityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e dummy entity with the matching UUID and company.
	*
	* @param uuid the p e dummy entity's UUID
	* @param companyId the primary key of the company
	* @return the matching p e dummy entity
	* @throws PortalException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity getPEDummyEntityByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEDummyEntityByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e dummy entity matching the UUID and group.
	*
	* @param uuid the p e dummy entity's UUID
	* @param groupId the primary key of the group
	* @return the matching p e dummy entity
	* @throws PortalException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity getPEDummyEntityByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEDummyEntityByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the p e dummy entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @return the range of p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> getPEDummyEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEDummyEntities(start, end);
	}

	/**
	* Returns the number of p e dummy entities.
	*
	* @return the number of p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPEDummyEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEDummyEntitiesCount();
	}

	/**
	* Updates the p e dummy entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peDummyEntity the p e dummy entity
	* @return the p e dummy entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity updatePEDummyEntity(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.updatePEDummyEntity(peDummyEntity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peDummyEntityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peDummyEntityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peDummyEntityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.pe.PEEntity getPEEntity(java.lang.Long classPk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEEntity(classPk);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity getDummyEntityByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getDummyEntityByName(name);
	}

	@Override
	public java.util.List<com.sambaash.platform.pe.PEEntity> getPEEntityList(
		java.lang.Integer start, java.lang.Integer end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEEntityList(start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.pe.PEEntity> getPEEntityList(
		java.util.List<java.lang.Long> entityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEEntityList(entityIds);
	}

	@Override
	public com.sambaash.platform.pe.PEEntity getEntity(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity) {
		return _peDummyEntityLocalService.getEntity(peDummyEntity);
	}

	@Override
	public java.util.List<com.sambaash.platform.pe.PEEntityField> getPEEntityFields() {
		return _peDummyEntityLocalService.getPEEntityFields();
	}

	@Override
	public java.lang.String getPEEntityFieldValue(java.lang.Long entityId,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntityLocalService.getPEEntityFieldValue(entityId,
			fieldId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PEDummyEntityLocalService getWrappedPEDummyEntityLocalService() {
		return _peDummyEntityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPEDummyEntityLocalService(
		PEDummyEntityLocalService peDummyEntityLocalService) {
		_peDummyEntityLocalService = peDummyEntityLocalService;
	}

	@Override
	public PEDummyEntityLocalService getWrappedService() {
		return _peDummyEntityLocalService;
	}

	@Override
	public void setWrappedService(
		PEDummyEntityLocalService peDummyEntityLocalService) {
		_peDummyEntityLocalService = peDummyEntityLocalService;
	}

	private PEDummyEntityLocalService _peDummyEntityLocalService;
}