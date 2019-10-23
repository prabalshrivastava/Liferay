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

package com.sambaash.platform.srv.legalandcontract.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RDLLocalService}.
 *
 * @author nareshchebolu
 * @see RDLLocalService
 * @generated
 */
public class RDLLocalServiceWrapper implements RDLLocalService,
	ServiceWrapper<RDLLocalService> {
	public RDLLocalServiceWrapper(RDLLocalService rdlLocalService) {
		_rdlLocalService = rdlLocalService;
	}

	/**
	* Adds the r d l to the database. Also notifies the appropriate model listeners.
	*
	* @param rdl the r d l
	* @return the r d l that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL addRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.addRDL(rdl);
	}

	/**
	* Creates a new r d l with the primary key. Does not add the r d l to the database.
	*
	* @param spRdlId the primary key for the new r d l
	* @return the new r d l
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL createRDL(
		long spRdlId) {
		return _rdlLocalService.createRDL(spRdlId);
	}

	/**
	* Deletes the r d l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l that was removed
	* @throws PortalException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL deleteRDL(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.deleteRDL(spRdlId);
	}

	/**
	* Deletes the r d l from the database. Also notifies the appropriate model listeners.
	*
	* @param rdl the r d l
	* @return the r d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL deleteRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.deleteRDL(rdl);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rdlLocalService.dynamicQuery();
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
		return _rdlLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rdlLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rdlLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _rdlLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rdlLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchRDL(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.fetchRDL(spRdlId);
	}

	/**
	* Returns the r d l with the matching UUID and company.
	*
	* @param uuid the r d l's UUID
	* @param companyId the primary key of the company
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchRDLByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.fetchRDLByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the r d l matching the UUID and group.
	*
	* @param uuid the r d l's UUID
	* @param groupId the primary key of the group
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchRDLByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.fetchRDLByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the r d l with the primary key.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l
	* @throws PortalException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL getRDL(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getRDL(spRdlId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the r d l with the matching UUID and company.
	*
	* @param uuid the r d l's UUID
	* @param companyId the primary key of the company
	* @return the matching r d l
	* @throws PortalException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL getRDLByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getRDLByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the r d l matching the UUID and group.
	*
	* @param uuid the r d l's UUID
	* @param groupId the primary key of the group
	* @return the matching r d l
	* @throws PortalException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL getRDLByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getRDLByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the r d ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @return the range of r d ls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> getRDLs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getRDLs(start, end);
	}

	/**
	* Returns the number of r d ls.
	*
	* @return the number of r d ls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRDLsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getRDLsCount();
	}

	/**
	* Updates the r d l in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rdl the r d l
	* @return the r d l that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL updateRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.updateRDL(rdl);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rdlLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rdlLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rdlLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long litigationId) {
		return _rdlLocalService.findBylitigationId(litigationId);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL getNewRDL()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdlLocalService.getNewRDL();
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL addRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl, long userId,
		long[] assetCategoryIds) throws java.lang.Exception {
		return _rdlLocalService.addRDL(rdl, userId, assetCategoryIds);
	}

	@Override
	public void reIndex(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl) {
		_rdlLocalService.reIndex(rdl);
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_rdlLocalService.updateAsset(userId, rdl, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RDLLocalService getWrappedRDLLocalService() {
		return _rdlLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRDLLocalService(RDLLocalService rdlLocalService) {
		_rdlLocalService = rdlLocalService;
	}

	@Override
	public RDLLocalService getWrappedService() {
		return _rdlLocalService;
	}

	@Override
	public void setWrappedService(RDLLocalService rdlLocalService) {
		_rdlLocalService = rdlLocalService;
	}

	private RDLLocalService _rdlLocalService;
}