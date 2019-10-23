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
 * Provides a wrapper for {@link SPUserTypeLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPUserTypeLocalService
 * @generated
 */
public class SPUserTypeLocalServiceWrapper implements SPUserTypeLocalService,
	ServiceWrapper<SPUserTypeLocalService> {
	public SPUserTypeLocalServiceWrapper(
		SPUserTypeLocalService spUserTypeLocalService) {
		_spUserTypeLocalService = spUserTypeLocalService;
	}

	/**
	* Adds the s p user type to the database. Also notifies the appropriate model listeners.
	*
	* @param spUserType the s p user type
	* @return the s p user type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType addSPUserType(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.addSPUserType(spUserType);
	}

	/**
	* Creates a new s p user type with the primary key. Does not add the s p user type to the database.
	*
	* @param spUserTypeId the primary key for the new s p user type
	* @return the new s p user type
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType createSPUserType(
		long spUserTypeId) {
		return _spUserTypeLocalService.createSPUserType(spUserTypeId);
	}

	/**
	* Deletes the s p user type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type that was removed
	* @throws PortalException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType deleteSPUserType(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.deleteSPUserType(spUserTypeId);
	}

	/**
	* Deletes the s p user type from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserType the s p user type
	* @return the s p user type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType deleteSPUserType(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.deleteSPUserType(spUserType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spUserTypeLocalService.dynamicQuery();
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
		return _spUserTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spUserTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spUserTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spUserTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spUserTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchSPUserType(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.fetchSPUserType(spUserTypeId);
	}

	/**
	* Returns the s p user type with the matching UUID and company.
	*
	* @param uuid the s p user type's UUID
	* @param companyId the primary key of the company
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchSPUserTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.fetchSPUserTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p user type matching the UUID and group.
	*
	* @param uuid the s p user type's UUID
	* @param groupId the primary key of the group
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchSPUserTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.fetchSPUserTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the s p user type with the primary key.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type
	* @throws PortalException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType getSPUserType(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.getSPUserType(spUserTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p user type with the matching UUID and company.
	*
	* @param uuid the s p user type's UUID
	* @param companyId the primary key of the company
	* @return the matching s p user type
	* @throws PortalException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType getSPUserTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.getSPUserTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p user type matching the UUID and group.
	*
	* @param uuid the s p user type's UUID
	* @param groupId the primary key of the group
	* @return the matching s p user type
	* @throws PortalException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType getSPUserTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.getSPUserTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the s p user types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of s p user types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> getSPUserTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.getSPUserTypes(start, end);
	}

	/**
	* Returns the number of s p user types.
	*
	* @return the number of s p user types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPUserTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.getSPUserTypesCount();
	}

	/**
	* Updates the s p user type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spUserType the s p user type
	* @return the s p user type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType updateSPUserType(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.updateSPUserType(spUserType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spUserTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spUserTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spUserTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteId(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.findBySpSiteId(spSiteId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserTypeId(
		long spSiteId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserTypeLocalService.findBySpSiteIdAndUserTypeId(spSiteId,
			userTypeId);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserIdAndUserTypeId(
		long spSiteId, long userId, long userTypeId) {
		return _spUserTypeLocalService.findBySpSiteIdAndUserIdAndUserTypeId(spSiteId,
			userId, userTypeId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserId(
		long spSiteId, long userId) {
		return _spUserTypeLocalService.findBySpSiteIdAndUserId(spSiteId, userId);
	}

	@Override
	public void addSPSiteAndUserType(java.lang.String userType,
		java.lang.String virtualHostId, com.liferay.portal.model.User user,
		java.lang.String productTypeId, java.lang.String subProductTypeId,
		java.lang.String password) {
		_spUserTypeLocalService.addSPSiteAndUserType(userType, virtualHostId,
			user, productTypeId, subProductTypeId, password);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPUserTypeLocalService getWrappedSPUserTypeLocalService() {
		return _spUserTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPUserTypeLocalService(
		SPUserTypeLocalService spUserTypeLocalService) {
		_spUserTypeLocalService = spUserTypeLocalService;
	}

	@Override
	public SPUserTypeLocalService getWrappedService() {
		return _spUserTypeLocalService;
	}

	@Override
	public void setWrappedService(SPUserTypeLocalService spUserTypeLocalService) {
		_spUserTypeLocalService = spUserTypeLocalService;
	}

	private SPUserTypeLocalService _spUserTypeLocalService;
}