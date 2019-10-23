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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPSiteSetupLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPSiteSetupLocalService
 * @generated
 */
public class SPSiteSetupLocalServiceWrapper implements SPSiteSetupLocalService,
	ServiceWrapper<SPSiteSetupLocalService> {
	public SPSiteSetupLocalServiceWrapper(
		SPSiteSetupLocalService spSiteSetupLocalService) {
		_spSiteSetupLocalService = spSiteSetupLocalService;
	}

	/**
	* Adds the s p site setup to the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteSetup the s p site setup
	* @return the s p site setup that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup addSPSiteSetup(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.addSPSiteSetup(spSiteSetup);
	}

	/**
	* Creates a new s p site setup with the primary key. Does not add the s p site setup to the database.
	*
	* @param spSiteSetupId the primary key for the new s p site setup
	* @return the new s p site setup
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup createSPSiteSetup(
		long spSiteSetupId) {
		return _spSiteSetupLocalService.createSPSiteSetup(spSiteSetupId);
	}

	/**
	* Deletes the s p site setup with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteSetupId the primary key of the s p site setup
	* @return the s p site setup that was removed
	* @throws PortalException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup deleteSPSiteSetup(
		long spSiteSetupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.deleteSPSiteSetup(spSiteSetupId);
	}

	/**
	* Deletes the s p site setup from the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteSetup the s p site setup
	* @return the s p site setup that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup deleteSPSiteSetup(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.deleteSPSiteSetup(spSiteSetup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSiteSetupLocalService.dynamicQuery();
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
		return _spSiteSetupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSiteSetupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSiteSetupLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spSiteSetupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSiteSetupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchSPSiteSetup(
		long spSiteSetupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.fetchSPSiteSetup(spSiteSetupId);
	}

	/**
	* Returns the s p site setup with the matching UUID and company.
	*
	* @param uuid the s p site setup's UUID
	* @param companyId the primary key of the company
	* @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchSPSiteSetupByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.fetchSPSiteSetupByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p site setup matching the UUID and group.
	*
	* @param uuid the s p site setup's UUID
	* @param groupId the primary key of the group
	* @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchSPSiteSetupByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.fetchSPSiteSetupByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the s p site setup with the primary key.
	*
	* @param spSiteSetupId the primary key of the s p site setup
	* @return the s p site setup
	* @throws PortalException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup getSPSiteSetup(
		long spSiteSetupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.getSPSiteSetup(spSiteSetupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p site setup with the matching UUID and company.
	*
	* @param uuid the s p site setup's UUID
	* @param companyId the primary key of the company
	* @return the matching s p site setup
	* @throws PortalException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup getSPSiteSetupByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.getSPSiteSetupByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p site setup matching the UUID and group.
	*
	* @param uuid the s p site setup's UUID
	* @param groupId the primary key of the group
	* @return the matching s p site setup
	* @throws PortalException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup getSPSiteSetupByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.getSPSiteSetupByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the s p site setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of s p site setups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> getSPSiteSetups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.getSPSiteSetups(start, end);
	}

	/**
	* Returns the number of s p site setups.
	*
	* @return the number of s p site setups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSiteSetupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.getSPSiteSetupsCount();
	}

	/**
	* Updates the s p site setup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSiteSetup the s p site setup
	* @return the s p site setup that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup updateSPSiteSetup(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.updateSPSiteSetup(spSiteSetup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSiteSetupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSiteSetupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSiteSetupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductId(
		long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.findBySubProductId(subProductId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductId(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.findByProductId(productId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByVirtualHostId(
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.findByVirtualHostId(virtualHostId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByBackOfficeVirtualHostId(
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.findByBackOfficeVirtualHostId(virtualHostId);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByProductIdAndSubProductId(
		long productId, long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteSetupLocalService.findByProductIdAndSubProductId(productId,
			subProductId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSiteSetupLocalService getWrappedSPSiteSetupLocalService() {
		return _spSiteSetupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSiteSetupLocalService(
		SPSiteSetupLocalService spSiteSetupLocalService) {
		_spSiteSetupLocalService = spSiteSetupLocalService;
	}

	@Override
	public SPSiteSetupLocalService getWrappedService() {
		return _spSiteSetupLocalService;
	}

	@Override
	public void setWrappedService(
		SPSiteSetupLocalService spSiteSetupLocalService) {
		_spSiteSetupLocalService = spSiteSetupLocalService;
	}

	private SPSiteSetupLocalService _spSiteSetupLocalService;
}