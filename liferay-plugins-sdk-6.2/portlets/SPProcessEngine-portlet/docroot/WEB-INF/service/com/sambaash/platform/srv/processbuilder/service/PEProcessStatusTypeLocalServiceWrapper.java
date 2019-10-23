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
 * Provides a wrapper for {@link PEProcessStatusTypeLocalService}.
 *
 * @author nareshchebolu
 * @see PEProcessStatusTypeLocalService
 * @generated
 */
public class PEProcessStatusTypeLocalServiceWrapper
	implements PEProcessStatusTypeLocalService,
		ServiceWrapper<PEProcessStatusTypeLocalService> {
	public PEProcessStatusTypeLocalServiceWrapper(
		PEProcessStatusTypeLocalService peProcessStatusTypeLocalService) {
		_peProcessStatusTypeLocalService = peProcessStatusTypeLocalService;
	}

	/**
	* Adds the p e process status type to the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessStatusType the p e process status type
	* @return the p e process status type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType addPEProcessStatusType(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.addPEProcessStatusType(peProcessStatusType);
	}

	/**
	* Creates a new p e process status type with the primary key. Does not add the p e process status type to the database.
	*
	* @param spPEProcessStatusTypeId the primary key for the new p e process status type
	* @return the new p e process status type
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType createPEProcessStatusType(
		long spPEProcessStatusTypeId) {
		return _peProcessStatusTypeLocalService.createPEProcessStatusType(spPEProcessStatusTypeId);
	}

	/**
	* Deletes the p e process status type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStatusTypeId the primary key of the p e process status type
	* @return the p e process status type that was removed
	* @throws PortalException if a p e process status type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType deletePEProcessStatusType(
		long spPEProcessStatusTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.deletePEProcessStatusType(spPEProcessStatusTypeId);
	}

	/**
	* Deletes the p e process status type from the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessStatusType the p e process status type
	* @return the p e process status type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType deletePEProcessStatusType(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.deletePEProcessStatusType(peProcessStatusType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peProcessStatusTypeLocalService.dynamicQuery();
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
		return _peProcessStatusTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peProcessStatusTypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peProcessStatusTypeLocalService.dynamicQuery(dynamicQuery,
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
		return _peProcessStatusTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peProcessStatusTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType fetchPEProcessStatusType(
		long spPEProcessStatusTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.fetchPEProcessStatusType(spPEProcessStatusTypeId);
	}

	/**
	* Returns the p e process status type with the matching UUID and company.
	*
	* @param uuid the p e process status type's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType fetchPEProcessStatusTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.fetchPEProcessStatusTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e process status type matching the UUID and group.
	*
	* @param uuid the p e process status type's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType fetchPEProcessStatusTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.fetchPEProcessStatusTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the p e process status type with the primary key.
	*
	* @param spPEProcessStatusTypeId the primary key of the p e process status type
	* @return the p e process status type
	* @throws PortalException if a p e process status type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType getPEProcessStatusType(
		long spPEProcessStatusTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.getPEProcessStatusType(spPEProcessStatusTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e process status type with the matching UUID and company.
	*
	* @param uuid the p e process status type's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process status type
	* @throws PortalException if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType getPEProcessStatusTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.getPEProcessStatusTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e process status type matching the UUID and group.
	*
	* @param uuid the p e process status type's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process status type
	* @throws PortalException if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType getPEProcessStatusTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.getPEProcessStatusTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the p e process status types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process status types
	* @param end the upper bound of the range of p e process status types (not inclusive)
	* @return the range of p e process status types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> getPEProcessStatusTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.getPEProcessStatusTypes(start,
			end);
	}

	/**
	* Returns the number of p e process status types.
	*
	* @return the number of p e process status types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPEProcessStatusTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.getPEProcessStatusTypesCount();
	}

	/**
	* Updates the p e process status type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peProcessStatusType the p e process status type
	* @return the p e process status type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType updatePEProcessStatusType(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.updatePEProcessStatusType(peProcessStatusType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peProcessStatusTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peProcessStatusTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peProcessStatusTypeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform
	* .srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil} to
	* access the p e process status type local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> findByProcessId(
		long processId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.findByProcessId(processId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> findByProcessIds(
		long[] processIdsArr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.findByProcessIds(processIdsArr);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusTypeLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PEProcessStatusTypeLocalService getWrappedPEProcessStatusTypeLocalService() {
		return _peProcessStatusTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPEProcessStatusTypeLocalService(
		PEProcessStatusTypeLocalService peProcessStatusTypeLocalService) {
		_peProcessStatusTypeLocalService = peProcessStatusTypeLocalService;
	}

	@Override
	public PEProcessStatusTypeLocalService getWrappedService() {
		return _peProcessStatusTypeLocalService;
	}

	@Override
	public void setWrappedService(
		PEProcessStatusTypeLocalService peProcessStatusTypeLocalService) {
		_peProcessStatusTypeLocalService = peProcessStatusTypeLocalService;
	}

	private PEProcessStatusTypeLocalService _peProcessStatusTypeLocalService;
}