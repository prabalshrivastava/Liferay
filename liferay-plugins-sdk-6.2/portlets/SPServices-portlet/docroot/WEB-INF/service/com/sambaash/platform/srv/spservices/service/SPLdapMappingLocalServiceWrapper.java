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
 * Provides a wrapper for {@link SPLdapMappingLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPLdapMappingLocalService
 * @generated
 */
public class SPLdapMappingLocalServiceWrapper
	implements SPLdapMappingLocalService,
		ServiceWrapper<SPLdapMappingLocalService> {
	public SPLdapMappingLocalServiceWrapper(
		SPLdapMappingLocalService spLdapMappingLocalService) {
		_spLdapMappingLocalService = spLdapMappingLocalService;
	}

	/**
	* Adds the s p ldap mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param spLdapMapping the s p ldap mapping
	* @return the s p ldap mapping that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping addSPLdapMapping(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.addSPLdapMapping(spLdapMapping);
	}

	/**
	* Creates a new s p ldap mapping with the primary key. Does not add the s p ldap mapping to the database.
	*
	* @param spLdapMappingId the primary key for the new s p ldap mapping
	* @return the new s p ldap mapping
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping createSPLdapMapping(
		long spLdapMappingId) {
		return _spLdapMappingLocalService.createSPLdapMapping(spLdapMappingId);
	}

	/**
	* Deletes the s p ldap mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLdapMappingId the primary key of the s p ldap mapping
	* @return the s p ldap mapping that was removed
	* @throws PortalException if a s p ldap mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping deleteSPLdapMapping(
		long spLdapMappingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.deleteSPLdapMapping(spLdapMappingId);
	}

	/**
	* Deletes the s p ldap mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param spLdapMapping the s p ldap mapping
	* @return the s p ldap mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping deleteSPLdapMapping(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.deleteSPLdapMapping(spLdapMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spLdapMappingLocalService.dynamicQuery();
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
		return _spLdapMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spLdapMappingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spLdapMappingLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spLdapMappingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spLdapMappingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping fetchSPLdapMapping(
		long spLdapMappingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.fetchSPLdapMapping(spLdapMappingId);
	}

	/**
	* Returns the s p ldap mapping with the primary key.
	*
	* @param spLdapMappingId the primary key of the s p ldap mapping
	* @return the s p ldap mapping
	* @throws PortalException if a s p ldap mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping getSPLdapMapping(
		long spLdapMappingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.getSPLdapMapping(spLdapMappingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p ldap mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p ldap mappings
	* @param end the upper bound of the range of s p ldap mappings (not inclusive)
	* @return the range of s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapMapping> getSPLdapMappings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.getSPLdapMappings(start, end);
	}

	/**
	* Returns the number of s p ldap mappings.
	*
	* @return the number of s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPLdapMappingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.getSPLdapMappingsCount();
	}

	/**
	* Updates the s p ldap mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spLdapMapping the s p ldap mapping
	* @return the s p ldap mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping updateSPLdapMapping(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMappingLocalService.updateSPLdapMapping(spLdapMapping);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spLdapMappingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spLdapMappingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spLdapMappingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping getEsnLdapMapping(
		java.lang.String country, java.lang.String department,
		java.lang.String company)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException {
		return _spLdapMappingLocalService.getEsnLdapMapping(country,
			department, company);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping findByCountryDepartmentAndLegalEntity(
		java.lang.String country, java.lang.String department,
		java.lang.String company) {
		return _spLdapMappingLocalService.findByCountryDepartmentAndLegalEntity(country,
			department, company);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPLdapMappingLocalService getWrappedSPLdapMappingLocalService() {
		return _spLdapMappingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPLdapMappingLocalService(
		SPLdapMappingLocalService spLdapMappingLocalService) {
		_spLdapMappingLocalService = spLdapMappingLocalService;
	}

	@Override
	public SPLdapMappingLocalService getWrappedService() {
		return _spLdapMappingLocalService;
	}

	@Override
	public void setWrappedService(
		SPLdapMappingLocalService spLdapMappingLocalService) {
		_spLdapMappingLocalService = spLdapMappingLocalService;
	}

	private SPLdapMappingLocalService _spLdapMappingLocalService;
}