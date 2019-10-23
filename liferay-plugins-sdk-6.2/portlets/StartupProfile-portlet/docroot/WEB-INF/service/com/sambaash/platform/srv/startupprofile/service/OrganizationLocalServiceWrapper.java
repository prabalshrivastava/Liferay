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
 * Provides a wrapper for {@link OrganizationLocalService}.
 *
 * @author pradeep
 * @see OrganizationLocalService
 * @generated
 */
public class OrganizationLocalServiceWrapper implements OrganizationLocalService,
	ServiceWrapper<OrganizationLocalService> {
	public OrganizationLocalServiceWrapper(
		OrganizationLocalService organizationLocalService) {
		_organizationLocalService = organizationLocalService;
	}

	/**
	* Adds the organization to the database. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.addOrganization(organization);
	}

	/**
	* Creates a new organization with the primary key. Does not add the organization to the database.
	*
	* @param organizationId the primary key for the new organization
	* @return the new organization
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization createOrganization(
		long organizationId) {
		return _organizationLocalService.createOrganization(organizationId);
	}

	/**
	* Deletes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationId the primary key of the organization
	* @return the organization that was removed
	* @throws PortalException if a organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization deleteOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.deleteOrganization(organizationId);
	}

	/**
	* Deletes the organization from the database. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization deleteOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.deleteOrganization(organization);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationLocalService.dynamicQuery();
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
		return _organizationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _organizationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organizationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.fetchOrganization(organizationId);
	}

	/**
	* Returns the organization with the matching UUID and company.
	*
	* @param uuid the organization's UUID
	* @param companyId the primary key of the company
	* @return the matching organization, or <code>null</code> if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganizationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.fetchOrganizationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the organization matching the UUID and group.
	*
	* @param uuid the organization's UUID
	* @param groupId the primary key of the group
	* @return the matching organization, or <code>null</code> if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.fetchOrganizationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the organization with the primary key.
	*
	* @param organizationId the primary key of the organization
	* @return the organization
	* @throws PortalException if a organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getOrganization(organizationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the organization with the matching UUID and company.
	*
	* @param uuid the organization's UUID
	* @param companyId the primary key of the company
	* @return the matching organization
	* @throws PortalException if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganizationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getOrganizationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the organization matching the UUID and group.
	*
	* @param uuid the organization's UUID
	* @param groupId the primary key of the group
	* @return the matching organization
	* @throws PortalException if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getOrganizationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizations
	* @param end the upper bound of the range of organizations (not inclusive)
	* @return the range of organizations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getOrganizations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getOrganizations(start, end);
	}

	/**
	* Returns the number of organizations.
	*
	* @return the number of organizations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrganizationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getOrganizationsCount();
	}

	/**
	* Updates the organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization updateOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.updateOrganization(organization);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organizationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organizationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organizationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.create();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization persistData(
		java.util.Map<java.lang.String, java.lang.String> requestParamMap,
		java.util.Map<java.lang.String, java.lang.Object> existingMap,
		java.lang.String productTypeId, java.lang.String subProductTypeId,
		java.lang.String virtualHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.persistData(requestParamMap,
			existingMap, productTypeId, subProductTypeId, virtualHostId);
	}

	@Override
	public java.lang.String getCurrentUserBaseOrganization(long currentUserId) {
		return _organizationLocalService.getCurrentUserBaseOrganization(currentUserId);
	}

	@Override
	public long getLoggedInUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.getLoggedInUserId();
	}

	@Override
	public java.lang.String addPrincipalDetails(java.lang.String inputString) {
		return _organizationLocalService.addPrincipalDetails(inputString);
	}

	@Override
	public java.lang.String addPrincipalDetails(
		com.liferay.portal.kernel.json.JSONObject inputJson) {
		return _organizationLocalService.addPrincipalDetails(inputJson);
	}

	@Override
	public java.lang.String addMentorToApplication(java.lang.String jsonString) {
		return _organizationLocalService.addMentorToApplication(jsonString);
	}

	@Override
	public void removeRole(long userId) {
		_organizationLocalService.removeRole(userId);
	}

	@Override
	public java.lang.String updatePrinciples(java.lang.String inputString) {
		return _organizationLocalService.updatePrinciples(inputString);
	}

	@Override
	public java.lang.String updateEmployeeInfo(java.lang.String inputString) {
		return _organizationLocalService.updateEmployeeInfo(inputString);
	}

	@Override
	public java.lang.String updateAccreditation(java.lang.String inputString) {
		return _organizationLocalService.updateAccreditation(inputString);
	}

	@Override
	public void updateAssets(long userId,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		long[] assetCategoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_organizationLocalService.updateAssets(userId, org, assetCategoryIds);
	}

	@Override
	public void updateAssets(long userId,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		long[] assetCategoryIds, java.lang.String[] tagNames)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_organizationLocalService.updateAssets(userId, org, assetCategoryIds,
			tagNames);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations() {
		return _organizationLocalService.getAllActiveOrganizations();
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> createOrgDataMap(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.createOrgDataMap(organizationId);
	}

	@Override
	public void clearCache(
		com.sambaash.platform.srv.startupprofile.model.Organization org) {
		_organizationLocalService.clearCache(org);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Address> getOfficeAddresses(
		long orgId) {
		return _organizationLocalService.getOfficeAddresses(orgId);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Address getOfficeHeadQuaterAddress(
		long orgId) {
		return _organizationLocalService.getOfficeHeadQuaterAddress(orgId);
	}

	@Override
	public void reIndex(
		com.sambaash.platform.srv.startupprofile.model.Organization org) {
		_organizationLocalService.reIndex(org);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.FundingRound> getFundingRounds(
		long orgId) {
		return _organizationLocalService.getFundingRounds(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> getContacts(
		long orgId) {
		return _organizationLocalService.getContacts(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Address> getAddresses(
		long orgId) {
		return _organizationLocalService.getAddresses(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> getQuestionnaire(
		long orgId) {
		return _organizationLocalService.getQuestionnaire(orgId);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Accreditation getAccreditation(
		long orgId) {
		return _organizationLocalService.getAccreditation(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> getGuidelines(
		long orgId) {
		return _organizationLocalService.getGuidelines(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getMentors(
		long orgId) {
		return _organizationLocalService.getMentors(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long orgId) {
		return _organizationLocalService.getApprovedMentors(orgId);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.EmployeeInfo getEmployeeInfo(
		long orgId) {
		return _organizationLocalService.getEmployeeInfo(orgId);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts getSPATOContacts(
		long orgId) {
		return _organizationLocalService.getSPATOContacts(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> getATODocuments(
		long orgId) {
		return _organizationLocalService.getATODocuments(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getFounders(
		long orgId) {
		return _organizationLocalService.getFounders(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getBoardAndAdvisory(
		long orgId) {
		return _organizationLocalService.getBoardAndAdvisory(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getTeamMembers(
		long orgId) {
		return _organizationLocalService.getTeamMembers(orgId);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Person getFilledBy(
		long orgId) {
		return _organizationLocalService.getFilledBy(orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getCompetitors(
		long orgId) {
		return _organizationLocalService.getCompetitors(orgId);
	}

	@Override
	public java.util.List<java.lang.Object> getInvestors(long orgId) {
		return _organizationLocalService.getInvestors(orgId);
	}

	@Override
	public boolean isOrganizationExistsWithName(java.lang.String orgName) {
		return _organizationLocalService.isOrganizationExistsWithName(orgName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> findByUENNumber(
		java.lang.String uen) {
		return _organizationLocalService.findByUENNumber(uen);
	}

	@Override
	public boolean isOrganizationExistsWithUEN(java.lang.String uen) {
		return _organizationLocalService.isOrganizationExistsWithUEN(uen);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization findByName(
		java.lang.String orgName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.findByName(orgName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getUserOrganizations(
		java.lang.Long userId) {
		return _organizationLocalService.getUserOrganizations(userId);
	}

	@Override
	public java.lang.String displayFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId) {
		return _organizationLocalService.displayFriendlyURL(themeDisplay, orgId);
	}

	@Override
	public java.lang.String applicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _organizationLocalService.applicationFriendlyURL(themeDisplay);
	}

	@Override
	public java.lang.String applicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId) {
		return _organizationLocalService.applicationFriendlyURL(themeDisplay,
			orgId);
	}

	@Override
	public java.lang.String editFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId) {
		return _organizationLocalService.editFriendlyURL(themeDisplay, orgId);
	}

	@Override
	public java.lang.String createFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _organizationLocalService.createFriendlyURL(themeDisplay);
	}

	@Override
	public java.lang.String exportStartupDetails(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant applicaiton)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationLocalService.exportStartupDetails(themeDisplay,
			org, applicaiton);
	}

	@Override
	public boolean canUpdateStartup(javax.portlet.PortletRequest request,
		long orgId) {
		return _organizationLocalService.canUpdateStartup(request, orgId);
	}

	@Override
	public boolean organizationHasCategoryName(long orgId,
		java.lang.String categoryName) {
		return _organizationLocalService.organizationHasCategoryName(orgId,
			categoryName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO() {
		return _organizationLocalService.getAllATO();
	}

	@Override
	public java.lang.Integer getATOExpiryPeriodParam() {
		return _organizationLocalService.getATOExpiryPeriodParam();
	}

	@Override
	public java.lang.Integer getATOExpiryAdvanceNoticeParam() {
		return _organizationLocalService.getATOExpiryAdvanceNoticeParam();
	}

	@Override
	public java.lang.Integer getATOPostExpiryNoticeParam() {
		return _organizationLocalService.getATOPostExpiryNoticeParam();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getATOsForExpiryNotification() {
		return _organizationLocalService.getATOsForExpiryNotification();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllExpiredATOs() {
		return _organizationLocalService.getAllExpiredATOs();
	}

	@Override
	public java.lang.String updateATOAsExpired(long organizationId) {
		return _organizationLocalService.updateATOAsExpired(organizationId);
	}

	@Override
	public java.lang.String updateATOInactive(long organizationId) {
		return _organizationLocalService.updateATOInactive(organizationId);
	}

	@Override
	public java.lang.String approveATO(long organizationId) {
		return _organizationLocalService.approveATO(organizationId);
	}

	@Override
	public java.lang.String approveATOByUserId(long userId) {
		return _organizationLocalService.approveATOByUserId(userId);
	}

	@Override
	public void transferOwnership(java.lang.Long userId) {
		_organizationLocalService.transferOwnership(userId);
	}

	@Override
	public java.lang.String removeTPandSCfromATO(long userId) {
		return _organizationLocalService.removeTPandSCfromATO(userId);
	}

	@Override
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress) {
		return _organizationLocalService.isUserLinkedToOrganization(emailAddress);
	}

	@Override
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress, long organizationId) {
		return _organizationLocalService.isUserLinkedToOrganization(emailAddress,
			organizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganizationLocalService getWrappedOrganizationLocalService() {
		return _organizationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganizationLocalService(
		OrganizationLocalService organizationLocalService) {
		_organizationLocalService = organizationLocalService;
	}

	@Override
	public OrganizationLocalService getWrappedService() {
		return _organizationLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationLocalService organizationLocalService) {
		_organizationLocalService = organizationLocalService;
	}

	private OrganizationLocalService _organizationLocalService;
}