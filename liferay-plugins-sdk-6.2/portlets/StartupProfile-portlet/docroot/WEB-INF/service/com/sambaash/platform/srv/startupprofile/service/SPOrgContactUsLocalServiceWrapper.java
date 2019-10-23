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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPOrgContactUsLocalService}.
 *
 * @author pradeep
 * @see SPOrgContactUsLocalService
 * @generated
 */
public class SPOrgContactUsLocalServiceWrapper
	implements SPOrgContactUsLocalService,
		ServiceWrapper<SPOrgContactUsLocalService> {
	public SPOrgContactUsLocalServiceWrapper(
		SPOrgContactUsLocalService spOrgContactUsLocalService) {
		_spOrgContactUsLocalService = spOrgContactUsLocalService;
	}

	/**
	* Adds the s p org contact us to the database. Also notifies the appropriate model listeners.
	*
	* @param spOrgContactUs the s p org contact us
	* @return the s p org contact us that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs addSPOrgContactUs(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.addSPOrgContactUs(spOrgContactUs);
	}

	/**
	* Creates a new s p org contact us with the primary key. Does not add the s p org contact us to the database.
	*
	* @param spContactUsId the primary key for the new s p org contact us
	* @return the new s p org contact us
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs createSPOrgContactUs(
		long spContactUsId) {
		return _spOrgContactUsLocalService.createSPOrgContactUs(spContactUsId);
	}

	/**
	* Deletes the s p org contact us with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spContactUsId the primary key of the s p org contact us
	* @return the s p org contact us that was removed
	* @throws PortalException if a s p org contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs deleteSPOrgContactUs(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.deleteSPOrgContactUs(spContactUsId);
	}

	/**
	* Deletes the s p org contact us from the database. Also notifies the appropriate model listeners.
	*
	* @param spOrgContactUs the s p org contact us
	* @return the s p org contact us that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs deleteSPOrgContactUs(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.deleteSPOrgContactUs(spOrgContactUs);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spOrgContactUsLocalService.dynamicQuery();
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
		return _spOrgContactUsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spOrgContactUsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spOrgContactUsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spOrgContactUsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spOrgContactUsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs fetchSPOrgContactUs(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.fetchSPOrgContactUs(spContactUsId);
	}

	/**
	* Returns the s p org contact us with the primary key.
	*
	* @param spContactUsId the primary key of the s p org contact us
	* @return the s p org contact us
	* @throws PortalException if a s p org contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs getSPOrgContactUs(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.getSPOrgContactUs(spContactUsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p org contact uses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p org contact uses
	* @param end the upper bound of the range of s p org contact uses (not inclusive)
	* @return the range of s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> getSPOrgContactUses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.getSPOrgContactUses(start, end);
	}

	/**
	* Returns the number of s p org contact uses.
	*
	* @return the number of s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPOrgContactUsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.getSPOrgContactUsesCount();
	}

	/**
	* Updates the s p org contact us in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spOrgContactUs the s p org contact us
	* @return the s p org contact us that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs updateSPOrgContactUs(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUsLocalService.updateSPOrgContactUs(spOrgContactUs);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spOrgContactUsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spOrgContactUsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spOrgContactUsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findByOrganizationId(
		long organizationId) {
		return _spOrgContactUsLocalService.findByOrganizationId(organizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPOrgContactUsLocalService getWrappedSPOrgContactUsLocalService() {
		return _spOrgContactUsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPOrgContactUsLocalService(
		SPOrgContactUsLocalService spOrgContactUsLocalService) {
		_spOrgContactUsLocalService = spOrgContactUsLocalService;
	}

	@Override
	public SPOrgContactUsLocalService getWrappedService() {
		return _spOrgContactUsLocalService;
	}

	@Override
	public void setWrappedService(
		SPOrgContactUsLocalService spOrgContactUsLocalService) {
		_spOrgContactUsLocalService = spOrgContactUsLocalService;
	}

	private SPOrgContactUsLocalService _spOrgContactUsLocalService;
}