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
 * Provides a wrapper for {@link AgencyLocalService}.
 *
 * @author nareshchebolu
 * @see AgencyLocalService
 * @generated
 */
public class AgencyLocalServiceWrapper implements AgencyLocalService,
	ServiceWrapper<AgencyLocalService> {
	public AgencyLocalServiceWrapper(AgencyLocalService agencyLocalService) {
		_agencyLocalService = agencyLocalService;
	}

	/**
	* Adds the agency to the database. Also notifies the appropriate model listeners.
	*
	* @param agency the agency
	* @return the agency that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency addAgency(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.addAgency(agency);
	}

	/**
	* Creates a new agency with the primary key. Does not add the agency to the database.
	*
	* @param spAgencyId the primary key for the new agency
	* @return the new agency
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency createAgency(
		long spAgencyId) {
		return _agencyLocalService.createAgency(spAgencyId);
	}

	/**
	* Deletes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency that was removed
	* @throws PortalException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency deleteAgency(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.deleteAgency(spAgencyId);
	}

	/**
	* Deletes the agency from the database. Also notifies the appropriate model listeners.
	*
	* @param agency the agency
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency deleteAgency(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.deleteAgency(agency);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agencyLocalService.dynamicQuery();
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
		return _agencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _agencyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _agencyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _agencyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _agencyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchAgency(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.fetchAgency(spAgencyId);
	}

	/**
	* Returns the agency with the matching UUID and company.
	*
	* @param uuid the agency's UUID
	* @param companyId the primary key of the company
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchAgencyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.fetchAgencyByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the agency matching the UUID and group.
	*
	* @param uuid the agency's UUID
	* @param groupId the primary key of the group
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency fetchAgencyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.fetchAgencyByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the agency with the primary key.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency
	* @throws PortalException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency getAgency(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getAgency(spAgencyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the agency with the matching UUID and company.
	*
	* @param uuid the agency's UUID
	* @param companyId the primary key of the company
	* @return the matching agency
	* @throws PortalException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency getAgencyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getAgencyByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the agency matching the UUID and group.
	*
	* @param uuid the agency's UUID
	* @param groupId the primary key of the group
	* @return the matching agency
	* @throws PortalException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency getAgencyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getAgencyByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the agencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of agencies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> getAgencies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getAgencies(start, end);
	}

	/**
	* Returns the number of agencies.
	*
	* @return the number of agencies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAgenciesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getAgenciesCount();
	}

	/**
	* Updates the agency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param agency the agency
	* @return the agency that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency updateAgency(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.updateAgency(agency);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _agencyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_agencyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _agencyLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addAgency(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency agency,
		long[] assetCategoryIds) throws java.lang.Exception {
		_agencyLocalService.addAgency(userId, agency, assetCategoryIds);
	}

	@Override
	public void addNewAgencyVersion(long userId, long oldAgencyId,
		com.sambaash.platform.srv.legalandcontract.model.Agency newAgency,
		long[] assetCategoryIds) throws java.lang.Exception {
		_agencyLocalService.addNewAgencyVersion(userId, oldAgencyId, newAgency,
			assetCategoryIds);
	}

	@Override
	public void addNewAgencyVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency oldAgency,
		com.sambaash.platform.srv.legalandcontract.model.Agency newAgency,
		long[] assetCategoryIds) throws java.lang.Exception {
		_agencyLocalService.addNewAgencyVersion(userId, oldAgency, newAgency,
			assetCategoryIds);
	}

	@Override
	public void addNewAgency(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency agency,
		long[] assetCategoryIds) throws java.lang.Exception {
		_agencyLocalService.addNewAgency(userId, agency, assetCategoryIds);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency getNewAgency()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agencyLocalService.getNewAgency();
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency agency,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_agencyLocalService.updateAsset(userId, agency, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency findByNumberCountry(
		java.lang.String number, java.lang.String country) {
		return _agencyLocalService.findByNumberCountry(number, country);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency getLatestAgencyByNumberCountry(
		java.lang.String number, java.lang.String country) {
		return _agencyLocalService.getLatestAgencyByNumberCountry(number,
			country);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency getLatestAgencyByNameCountry(
		java.lang.String name, java.lang.String country) {
		return _agencyLocalService.getLatestAgencyByNameCountry(name, country);
	}

	/**
	* @param number
	* @param country
	* @return
	*/
	@Override
	public java.util.List<java.lang.Object[]> getLatestAgencyIdAndVersionNumber(
		java.lang.String number, java.lang.String country) {
		return _agencyLocalService.getLatestAgencyIdAndVersionNumber(number,
			country);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AgencyLocalService getWrappedAgencyLocalService() {
		return _agencyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAgencyLocalService(
		AgencyLocalService agencyLocalService) {
		_agencyLocalService = agencyLocalService;
	}

	@Override
	public AgencyLocalService getWrappedService() {
		return _agencyLocalService;
	}

	@Override
	public void setWrappedService(AgencyLocalService agencyLocalService) {
		_agencyLocalService = agencyLocalService;
	}

	private AgencyLocalService _agencyLocalService;
}