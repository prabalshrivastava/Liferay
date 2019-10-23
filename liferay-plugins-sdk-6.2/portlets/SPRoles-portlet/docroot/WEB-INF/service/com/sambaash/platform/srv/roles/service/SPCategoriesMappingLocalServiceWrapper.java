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

package com.sambaash.platform.srv.roles.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPCategoriesMappingLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPCategoriesMappingLocalService
 * @generated
 */
public class SPCategoriesMappingLocalServiceWrapper
	implements SPCategoriesMappingLocalService,
		ServiceWrapper<SPCategoriesMappingLocalService> {
	public SPCategoriesMappingLocalServiceWrapper(
		SPCategoriesMappingLocalService spCategoriesMappingLocalService) {
		_spCategoriesMappingLocalService = spCategoriesMappingLocalService;
	}

	/**
	* Adds the s p categories mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param spCategoriesMapping the s p categories mapping
	* @return the s p categories mapping that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping addSPCategoriesMapping(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.addSPCategoriesMapping(spCategoriesMapping);
	}

	/**
	* Creates a new s p categories mapping with the primary key. Does not add the s p categories mapping to the database.
	*
	* @param spCategoryMappingId the primary key for the new s p categories mapping
	* @return the new s p categories mapping
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping createSPCategoriesMapping(
		long spCategoryMappingId) {
		return _spCategoriesMappingLocalService.createSPCategoriesMapping(spCategoryMappingId);
	}

	/**
	* Deletes the s p categories mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCategoryMappingId the primary key of the s p categories mapping
	* @return the s p categories mapping that was removed
	* @throws PortalException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping deleteSPCategoriesMapping(
		long spCategoryMappingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.deleteSPCategoriesMapping(spCategoryMappingId);
	}

	/**
	* Deletes the s p categories mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param spCategoriesMapping the s p categories mapping
	* @return the s p categories mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping deleteSPCategoriesMapping(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.deleteSPCategoriesMapping(spCategoriesMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spCategoriesMappingLocalService.dynamicQuery();
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
		return _spCategoriesMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spCategoriesMappingLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spCategoriesMappingLocalService.dynamicQuery(dynamicQuery,
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
		return _spCategoriesMappingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spCategoriesMappingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchSPCategoriesMapping(
		long spCategoryMappingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.fetchSPCategoriesMapping(spCategoryMappingId);
	}

	/**
	* Returns the s p categories mapping with the matching UUID and company.
	*
	* @param uuid the s p categories mapping's UUID
	* @param companyId the primary key of the company
	* @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchSPCategoriesMappingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.fetchSPCategoriesMappingByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p categories mapping matching the UUID and group.
	*
	* @param uuid the s p categories mapping's UUID
	* @param groupId the primary key of the group
	* @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchSPCategoriesMappingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.fetchSPCategoriesMappingByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the s p categories mapping with the primary key.
	*
	* @param spCategoryMappingId the primary key of the s p categories mapping
	* @return the s p categories mapping
	* @throws PortalException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping getSPCategoriesMapping(
		long spCategoryMappingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.getSPCategoriesMapping(spCategoryMappingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p categories mapping with the matching UUID and company.
	*
	* @param uuid the s p categories mapping's UUID
	* @param companyId the primary key of the company
	* @return the matching s p categories mapping
	* @throws PortalException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping getSPCategoriesMappingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.getSPCategoriesMappingByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p categories mapping matching the UUID and group.
	*
	* @param uuid the s p categories mapping's UUID
	* @param groupId the primary key of the group
	* @return the matching s p categories mapping
	* @throws PortalException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping getSPCategoriesMappingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.getSPCategoriesMappingByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the s p categories mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @return the range of s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> getSPCategoriesMappings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.getSPCategoriesMappings(start,
			end);
	}

	/**
	* Returns the number of s p categories mappings.
	*
	* @return the number of s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPCategoriesMappingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.getSPCategoriesMappingsCount();
	}

	/**
	* Updates the s p categories mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spCategoriesMapping the s p categories mapping
	* @return the s p categories mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping updateSPCategoriesMapping(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.updateSPCategoriesMapping(spCategoriesMapping);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spCategoriesMappingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spCategoriesMappingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spCategoriesMappingLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByMainAndSubCategoryId(
		long groupId, long mainCategoryId, long subCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException {
		return _spCategoriesMappingLocalService.findByMainAndSubCategoryId(groupId,
			mainCategoryId, subCategoryId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.roles.service.SPCategoriesMappingLocalServiceUtil} to access the s p categories mapping local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByMainCategoryId(
		long groupId, long mainCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMappingLocalService.findByMainCategoryId(groupId,
			mainCategoryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPCategoriesMappingLocalService getWrappedSPCategoriesMappingLocalService() {
		return _spCategoriesMappingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPCategoriesMappingLocalService(
		SPCategoriesMappingLocalService spCategoriesMappingLocalService) {
		_spCategoriesMappingLocalService = spCategoriesMappingLocalService;
	}

	@Override
	public SPCategoriesMappingLocalService getWrappedService() {
		return _spCategoriesMappingLocalService;
	}

	@Override
	public void setWrappedService(
		SPCategoriesMappingLocalService spCategoriesMappingLocalService) {
		_spCategoriesMappingLocalService = spCategoriesMappingLocalService;
	}

	private SPCategoriesMappingLocalService _spCategoriesMappingLocalService;
}