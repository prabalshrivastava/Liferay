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
 * Provides a wrapper for {@link PEProcessStateLocalService}.
 *
 * @author nareshchebolu
 * @see PEProcessStateLocalService
 * @generated
 */
public class PEProcessStateLocalServiceWrapper
	implements PEProcessStateLocalService,
		ServiceWrapper<PEProcessStateLocalService> {
	public PEProcessStateLocalServiceWrapper(
		PEProcessStateLocalService peProcessStateLocalService) {
		_peProcessStateLocalService = peProcessStateLocalService;
	}

	/**
	* Adds the p e process state to the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessState the p e process state
	* @return the p e process state that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState addPEProcessState(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.addPEProcessState(peProcessState);
	}

	/**
	* Creates a new p e process state with the primary key. Does not add the p e process state to the database.
	*
	* @param spPEProcessStateId the primary key for the new p e process state
	* @return the new p e process state
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState createPEProcessState(
		long spPEProcessStateId) {
		return _peProcessStateLocalService.createPEProcessState(spPEProcessStateId);
	}

	/**
	* Deletes the p e process state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state that was removed
	* @throws PortalException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState deletePEProcessState(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.deletePEProcessState(spPEProcessStateId);
	}

	/**
	* Deletes the p e process state from the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessState the p e process state
	* @return the p e process state that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState deletePEProcessState(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.deletePEProcessState(peProcessState);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peProcessStateLocalService.dynamicQuery();
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
		return _peProcessStateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peProcessStateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peProcessStateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _peProcessStateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peProcessStateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchPEProcessState(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.fetchPEProcessState(spPEProcessStateId);
	}

	/**
	* Returns the p e process state with the matching UUID and company.
	*
	* @param uuid the p e process state's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchPEProcessStateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.fetchPEProcessStateByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e process state matching the UUID and group.
	*
	* @param uuid the p e process state's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchPEProcessStateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.fetchPEProcessStateByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the p e process state with the primary key.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state
	* @throws PortalException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState getPEProcessState(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getPEProcessState(spPEProcessStateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e process state with the matching UUID and company.
	*
	* @param uuid the p e process state's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process state
	* @throws PortalException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState getPEProcessStateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getPEProcessStateByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e process state matching the UUID and group.
	*
	* @param uuid the p e process state's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process state
	* @throws PortalException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState getPEProcessStateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getPEProcessStateByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the p e process states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of p e process states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> getPEProcessStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getPEProcessStates(start, end);
	}

	/**
	* Returns the number of p e process states.
	*
	* @return the number of p e process states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPEProcessStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getPEProcessStatesCount();
	}

	/**
	* Updates the p e process state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peProcessState the p e process state
	* @return the p e process state that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState updatePEProcessState(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.updatePEProcessState(peProcessState);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peProcessStateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peProcessStateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peProcessStateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil}
	* to access the p e process state local service.
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState createWithPrimaryKeyZero()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.createWithPrimaryKeyZero();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.create();
	}

	@Override
	public long getNewPrimaryKey()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getNewPrimaryKey();
	}

	@Override
	public java.util.List<java.lang.Object> getOfflineFinancereport(
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date startDate1, java.util.Date endDate1,
		java.util.Date startDate2, java.util.Date endDate2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getOfflineFinancereport(startDate,
			endDate, startDate1, endDate1, startDate2, endDate2);
	}

	@Override
	public java.util.List<java.lang.Object> getOnlineFinancereport(
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date startDate1, java.util.Date endDate1,
		java.util.Date startDate2, java.util.Date endDate2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getOnlineFinancereport(startDate,
			endDate, startDate1, endDate1, startDate2, endDate2);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPEProcessStatePK(
		long userIdProcess, long processId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return _peProcessStateLocalService.findByPEProcessStatePK(userIdProcess,
			processId, classPK);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUserIdProcessAndPEProcessId(
		long userIdProcess, long processId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return _peProcessStateLocalService.findByUserIdProcessAndPEProcessId(userIdProcess,
			processId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessId(
		long processId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByProcessId(processId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userId, long processId, long entityClassId, long entityId,
		int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userId,
			processId, entityClassId, entityId, activeStatus);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState clearCacheAndGetProcessState(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return _peProcessStateLocalService.clearCacheAndGetProcessState(processState);
	}

	@Override
	public java.util.List getDistinctEntityIdClasseIdProcessIdList() {
		return _peProcessStateLocalService.getDistinctEntityIdClasseIdProcessIdList();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] processIds, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByProcessStateLead(processIds,
			userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] processIds, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByProcessStateOpportunity(processIds,
			userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByuserIdProcess(userIdProcess);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId);
	}

	@Override
	public int findByuserIdProcessPEProcessStageIdCount(long userIdProcess,
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByuserIdProcessPEProcessStageIdCount(userIdProcess,
			spPEProcessStageId);
	}

	@Override
	public java.util.List<java.lang.Object> getOfflineFinancereport()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getOfflineFinancereport();
	}

	@Override
	public java.util.List<java.lang.Object> getOnlineFinancereport()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getOnlineFinancereport();
	}

	@Override
	public java.util.List<java.lang.Object> getOfflineFinancereport(
		java.util.Date arg0, java.util.Date arg1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getOfflineFinancereport(arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.Object> getOnlineFinancereport(
		java.util.Date arg0, java.util.Date arg1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.getOnlineFinancereport(arg0, arg1);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject checkForPreviousSubmissions(
		long loggedInUserId, java.lang.String emailAddress, long processId,
		long entityClassId, long entityId) {
		return _peProcessStateLocalService.checkForPreviousSubmissions(loggedInUserId,
			emailAddress, processId, entityClassId, entityId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndEntityClassIdAndEntityIdAndActiveStatus(
		long userId, long processId, long entityClassId, long entityId,
		int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStateLocalService.findByuserIdProcessAndPEProcessIdAndEntityClassIdAndEntityIdAndActiveStatus(userId,
			processId, entityClassId, entityId, activeStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PEProcessStateLocalService getWrappedPEProcessStateLocalService() {
		return _peProcessStateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPEProcessStateLocalService(
		PEProcessStateLocalService peProcessStateLocalService) {
		_peProcessStateLocalService = peProcessStateLocalService;
	}

	@Override
	public PEProcessStateLocalService getWrappedService() {
		return _peProcessStateLocalService;
	}

	@Override
	public void setWrappedService(
		PEProcessStateLocalService peProcessStateLocalService) {
		_peProcessStateLocalService = peProcessStateLocalService;
	}

	private PEProcessStateLocalService _peProcessStateLocalService;
}