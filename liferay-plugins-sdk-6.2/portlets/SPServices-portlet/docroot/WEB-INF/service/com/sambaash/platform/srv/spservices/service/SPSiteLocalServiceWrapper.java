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
 * Provides a wrapper for {@link SPSiteLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPSiteLocalService
 * @generated
 */
public class SPSiteLocalServiceWrapper implements SPSiteLocalService,
	ServiceWrapper<SPSiteLocalService> {
	public SPSiteLocalServiceWrapper(SPSiteLocalService spSiteLocalService) {
		_spSiteLocalService = spSiteLocalService;
	}

	/**
	* Adds the s p site to the database. Also notifies the appropriate model listeners.
	*
	* @param spSite the s p site
	* @return the s p site that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite addSPSite(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.addSPSite(spSite);
	}

	/**
	* Creates a new s p site with the primary key. Does not add the s p site to the database.
	*
	* @param spSiteId the primary key for the new s p site
	* @return the new s p site
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite createSPSite(
		long spSiteId) {
		return _spSiteLocalService.createSPSite(spSiteId);
	}

	/**
	* Deletes the s p site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site that was removed
	* @throws PortalException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite deleteSPSite(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.deleteSPSite(spSiteId);
	}

	/**
	* Deletes the s p site from the database. Also notifies the appropriate model listeners.
	*
	* @param spSite the s p site
	* @return the s p site that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite deleteSPSite(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.deleteSPSite(spSite);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSiteLocalService.dynamicQuery();
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
		return _spSiteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSiteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSiteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spSiteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSiteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite fetchSPSite(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.fetchSPSite(spSiteId);
	}

	/**
	* Returns the s p site with the matching UUID and company.
	*
	* @param uuid the s p site's UUID
	* @param companyId the primary key of the company
	* @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite fetchSPSiteByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.fetchSPSiteByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p site matching the UUID and group.
	*
	* @param uuid the s p site's UUID
	* @param groupId the primary key of the group
	* @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite fetchSPSiteByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.fetchSPSiteByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p site with the primary key.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site
	* @throws PortalException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite getSPSite(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.getSPSite(spSiteId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p site with the matching UUID and company.
	*
	* @param uuid the s p site's UUID
	* @param companyId the primary key of the company
	* @return the matching s p site
	* @throws PortalException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite getSPSiteByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.getSPSiteByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p site matching the UUID and group.
	*
	* @param uuid the s p site's UUID
	* @param groupId the primary key of the group
	* @return the matching s p site
	* @throws PortalException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite getSPSiteByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.getSPSiteByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of s p sites
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> getSPSites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.getSPSites(start, end);
	}

	/**
	* Returns the number of s p sites.
	*
	* @return the number of s p sites
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.getSPSitesCount();
	}

	/**
	* Updates the s p site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSite the s p site
	* @return the s p site that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite updateSPSite(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSiteLocalService.updateSPSite(spSite);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSiteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSiteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSiteLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addOrUpdateSPSiteUser(long companyId, long groupId,
		long authAccessId, long userId, long layoutSetId, long virtualHostId,
		java.lang.String loginType, java.lang.String plainPassword,
		java.lang.String encryptedPassword) {
		_spSiteLocalService.addOrUpdateSPSiteUser(companyId, groupId,
			authAccessId, userId, layoutSetId, virtualHostId, loginType,
			plainPassword, encryptedPassword);
	}

	@Override
	public void addOrUpdateSPSiteUser(long companyId, long groupId,
		long authAccessId, long userId, long layoutSetId, long virtualHostId,
		java.lang.String loginType, java.lang.String plainPassword,
		java.lang.String encryptedPassword, long userTypeId) {
		_spSiteLocalService.addOrUpdateSPSiteUser(companyId, groupId,
			authAccessId, userId, layoutSetId, virtualHostId, loginType,
			plainPassword, encryptedPassword, userTypeId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndVirtualHostId(
		long userId, long virtualHostId) {
		return _spSiteLocalService.findByUserIdAndVirtualHostId(userId,
			virtualHostId);
	}

	@Override
	public boolean hasExistingDomainEntry(long userId, long virtualHostId) {
		return _spSiteLocalService.hasExistingDomainEntry(userId, virtualHostId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndAuthAccessId(
		long userId, long authAccessId) {
		return _spSiteLocalService.findByUserIdAndAuthAccessId(userId,
			authAccessId);
	}

	@Override
	public boolean hasExistingAuthAccessEntry(long userId, long authAccessId) {
		return _spSiteLocalService.hasExistingAuthAccessEntry(userId,
			authAccessId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserId(
		long userId) {
		return _spSiteLocalService.findByUserId(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSiteLocalService getWrappedSPSiteLocalService() {
		return _spSiteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSiteLocalService(
		SPSiteLocalService spSiteLocalService) {
		_spSiteLocalService = spSiteLocalService;
	}

	@Override
	public SPSiteLocalService getWrappedService() {
		return _spSiteLocalService;
	}

	@Override
	public void setWrappedService(SPSiteLocalService spSiteLocalService) {
		_spSiteLocalService = spSiteLocalService;
	}

	private SPSiteLocalService _spSiteLocalService;
}