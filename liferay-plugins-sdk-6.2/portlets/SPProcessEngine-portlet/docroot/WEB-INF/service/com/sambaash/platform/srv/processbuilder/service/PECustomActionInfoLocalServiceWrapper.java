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
 * Provides a wrapper for {@link PECustomActionInfoLocalService}.
 *
 * @author nareshchebolu
 * @see PECustomActionInfoLocalService
 * @generated
 */
public class PECustomActionInfoLocalServiceWrapper
	implements PECustomActionInfoLocalService,
		ServiceWrapper<PECustomActionInfoLocalService> {
	public PECustomActionInfoLocalServiceWrapper(
		PECustomActionInfoLocalService peCustomActionInfoLocalService) {
		_peCustomActionInfoLocalService = peCustomActionInfoLocalService;
	}

	/**
	* Adds the p e custom action info to the database. Also notifies the appropriate model listeners.
	*
	* @param peCustomActionInfo the p e custom action info
	* @return the p e custom action info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo addPECustomActionInfo(
		com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo peCustomActionInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.addPECustomActionInfo(peCustomActionInfo);
	}

	/**
	* Creates a new p e custom action info with the primary key. Does not add the p e custom action info to the database.
	*
	* @param spPEActionId the primary key for the new p e custom action info
	* @return the new p e custom action info
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo createPECustomActionInfo(
		long spPEActionId) {
		return _peCustomActionInfoLocalService.createPECustomActionInfo(spPEActionId);
	}

	/**
	* Deletes the p e custom action info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEActionId the primary key of the p e custom action info
	* @return the p e custom action info that was removed
	* @throws PortalException if a p e custom action info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo deletePECustomActionInfo(
		long spPEActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.deletePECustomActionInfo(spPEActionId);
	}

	/**
	* Deletes the p e custom action info from the database. Also notifies the appropriate model listeners.
	*
	* @param peCustomActionInfo the p e custom action info
	* @return the p e custom action info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo deletePECustomActionInfo(
		com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo peCustomActionInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.deletePECustomActionInfo(peCustomActionInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peCustomActionInfoLocalService.dynamicQuery();
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
		return _peCustomActionInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peCustomActionInfoLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peCustomActionInfoLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peCustomActionInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo fetchPECustomActionInfo(
		long spPEActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.fetchPECustomActionInfo(spPEActionId);
	}

	/**
	* Returns the p e custom action info with the matching UUID and company.
	*
	* @param uuid the p e custom action info's UUID
	* @param companyId the primary key of the company
	* @return the matching p e custom action info, or <code>null</code> if a matching p e custom action info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo fetchPECustomActionInfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.fetchPECustomActionInfoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e custom action info matching the UUID and group.
	*
	* @param uuid the p e custom action info's UUID
	* @param groupId the primary key of the group
	* @return the matching p e custom action info, or <code>null</code> if a matching p e custom action info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo fetchPECustomActionInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.fetchPECustomActionInfoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the p e custom action info with the primary key.
	*
	* @param spPEActionId the primary key of the p e custom action info
	* @return the p e custom action info
	* @throws PortalException if a p e custom action info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo getPECustomActionInfo(
		long spPEActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.getPECustomActionInfo(spPEActionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e custom action info with the matching UUID and company.
	*
	* @param uuid the p e custom action info's UUID
	* @param companyId the primary key of the company
	* @return the matching p e custom action info
	* @throws PortalException if a matching p e custom action info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo getPECustomActionInfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.getPECustomActionInfoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e custom action info matching the UUID and group.
	*
	* @param uuid the p e custom action info's UUID
	* @param groupId the primary key of the group
	* @return the matching p e custom action info
	* @throws PortalException if a matching p e custom action info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo getPECustomActionInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.getPECustomActionInfoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the p e custom action infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e custom action infos
	* @param end the upper bound of the range of p e custom action infos (not inclusive)
	* @return the range of p e custom action infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo> getPECustomActionInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.getPECustomActionInfos(start, end);
	}

	/**
	* Returns the number of p e custom action infos.
	*
	* @return the number of p e custom action infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPECustomActionInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.getPECustomActionInfosCount();
	}

	/**
	* Updates the p e custom action info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peCustomActionInfo the p e custom action info
	* @return the p e custom action info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo updatePECustomActionInfo(
		com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo peCustomActionInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfoLocalService.updatePECustomActionInfo(peCustomActionInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peCustomActionInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peCustomActionInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peCustomActionInfoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PECustomActionInfoLocalService getWrappedPECustomActionInfoLocalService() {
		return _peCustomActionInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPECustomActionInfoLocalService(
		PECustomActionInfoLocalService peCustomActionInfoLocalService) {
		_peCustomActionInfoLocalService = peCustomActionInfoLocalService;
	}

	@Override
	public PECustomActionInfoLocalService getWrappedService() {
		return _peCustomActionInfoLocalService;
	}

	@Override
	public void setWrappedService(
		PECustomActionInfoLocalService peCustomActionInfoLocalService) {
		_peCustomActionInfoLocalService = peCustomActionInfoLocalService;
	}

	private PECustomActionInfoLocalService _peCustomActionInfoLocalService;
}