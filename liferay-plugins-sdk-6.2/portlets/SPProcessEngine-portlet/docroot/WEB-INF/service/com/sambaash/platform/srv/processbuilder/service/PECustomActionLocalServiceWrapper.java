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
 * Provides a wrapper for {@link PECustomActionLocalService}.
 *
 * @author nareshchebolu
 * @see PECustomActionLocalService
 * @generated
 */
public class PECustomActionLocalServiceWrapper
	implements PECustomActionLocalService,
		ServiceWrapper<PECustomActionLocalService> {
	public PECustomActionLocalServiceWrapper(
		PECustomActionLocalService peCustomActionLocalService) {
		_peCustomActionLocalService = peCustomActionLocalService;
	}

	/**
	* Adds the p e custom action to the database. Also notifies the appropriate model listeners.
	*
	* @param peCustomAction the p e custom action
	* @return the p e custom action that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction addPECustomAction(
		com.sambaash.platform.srv.processbuilder.model.PECustomAction peCustomAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.addPECustomAction(peCustomAction);
	}

	/**
	* Creates a new p e custom action with the primary key. Does not add the p e custom action to the database.
	*
	* @param spPEActionId the primary key for the new p e custom action
	* @return the new p e custom action
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction createPECustomAction(
		long spPEActionId) {
		return _peCustomActionLocalService.createPECustomAction(spPEActionId);
	}

	/**
	* Deletes the p e custom action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEActionId the primary key of the p e custom action
	* @return the p e custom action that was removed
	* @throws PortalException if a p e custom action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction deletePECustomAction(
		long spPEActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.deletePECustomAction(spPEActionId);
	}

	/**
	* Deletes the p e custom action from the database. Also notifies the appropriate model listeners.
	*
	* @param peCustomAction the p e custom action
	* @return the p e custom action that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction deletePECustomAction(
		com.sambaash.platform.srv.processbuilder.model.PECustomAction peCustomAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.deletePECustomAction(peCustomAction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peCustomActionLocalService.dynamicQuery();
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
		return _peCustomActionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peCustomActionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peCustomActionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _peCustomActionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peCustomActionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction fetchPECustomAction(
		long spPEActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.fetchPECustomAction(spPEActionId);
	}

	/**
	* Returns the p e custom action with the matching UUID and company.
	*
	* @param uuid the p e custom action's UUID
	* @param companyId the primary key of the company
	* @return the matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction fetchPECustomActionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.fetchPECustomActionByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e custom action matching the UUID and group.
	*
	* @param uuid the p e custom action's UUID
	* @param groupId the primary key of the group
	* @return the matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction fetchPECustomActionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.fetchPECustomActionByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the p e custom action with the primary key.
	*
	* @param spPEActionId the primary key of the p e custom action
	* @return the p e custom action
	* @throws PortalException if a p e custom action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction getPECustomAction(
		long spPEActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.getPECustomAction(spPEActionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e custom action with the matching UUID and company.
	*
	* @param uuid the p e custom action's UUID
	* @param companyId the primary key of the company
	* @return the matching p e custom action
	* @throws PortalException if a matching p e custom action could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction getPECustomActionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.getPECustomActionByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e custom action matching the UUID and group.
	*
	* @param uuid the p e custom action's UUID
	* @param groupId the primary key of the group
	* @return the matching p e custom action
	* @throws PortalException if a matching p e custom action could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction getPECustomActionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.getPECustomActionByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the p e custom actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e custom actions
	* @param end the upper bound of the range of p e custom actions (not inclusive)
	* @return the range of p e custom actions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PECustomAction> getPECustomActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.getPECustomActions(start, end);
	}

	/**
	* Returns the number of p e custom actions.
	*
	* @return the number of p e custom actions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPECustomActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.getPECustomActionsCount();
	}

	/**
	* Updates the p e custom action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peCustomAction the p e custom action
	* @return the p e custom action that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction updatePECustomAction(
		com.sambaash.platform.srv.processbuilder.model.PECustomAction peCustomAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionLocalService.updatePECustomAction(peCustomAction);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peCustomActionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peCustomActionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peCustomActionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PECustomActionLocalService getWrappedPECustomActionLocalService() {
		return _peCustomActionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPECustomActionLocalService(
		PECustomActionLocalService peCustomActionLocalService) {
		_peCustomActionLocalService = peCustomActionLocalService;
	}

	@Override
	public PECustomActionLocalService getWrappedService() {
		return _peCustomActionLocalService;
	}

	@Override
	public void setWrappedService(
		PECustomActionLocalService peCustomActionLocalService) {
		_peCustomActionLocalService = peCustomActionLocalService;
	}

	private PECustomActionLocalService _peCustomActionLocalService;
}