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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Organization. This utility wraps
 * {@link com.sambaash.platform.srv.startupprofile.service.impl.OrganizationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see OrganizationLocalService
 * @see com.sambaash.platform.srv.startupprofile.service.base.OrganizationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.impl.OrganizationLocalServiceImpl
 * @generated
 */
public class OrganizationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.startupprofile.service.impl.OrganizationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the organization to the database. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOrganization(organization);
	}

	/**
	* Creates a new organization with the primary key. Does not add the organization to the database.
	*
	* @param organizationId the primary key for the new organization
	* @return the new organization
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization createOrganization(
		long organizationId) {
		return getService().createOrganization(organizationId);
	}

	/**
	* Deletes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationId the primary key of the organization
	* @return the organization that was removed
	* @throws PortalException if a organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization deleteOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrganization(organizationId);
	}

	/**
	* Deletes the organization from the database. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization deleteOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrganization(organization);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOrganization(organizationId);
	}

	/**
	* Returns the organization with the matching UUID and company.
	*
	* @param uuid the organization's UUID
	* @param companyId the primary key of the company
	* @return the matching organization, or <code>null</code> if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganizationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOrganizationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the organization matching the UUID and group.
	*
	* @param uuid the organization's UUID
	* @param groupId the primary key of the group
	* @return the matching organization, or <code>null</code> if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOrganizationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the organization with the primary key.
	*
	* @param organizationId the primary key of the organization
	* @return the organization
	* @throws PortalException if a organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganization(organizationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.sambaash.platform.srv.startupprofile.model.Organization getOrganizationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationByUuidAndCompanyId(uuid, companyId);
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
	public static com.sambaash.platform.srv.startupprofile.model.Organization getOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getOrganizations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizations(start, end);
	}

	/**
	* Returns the number of organizations.
	*
	* @return the number of organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrganizationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationsCount();
	}

	/**
	* Updates the organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Organization updateOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrganization(organization);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization persistData(
		java.util.Map<java.lang.String, java.lang.String> requestParamMap,
		java.util.Map<java.lang.String, java.lang.Object> existingMap,
		java.lang.String productTypeId, java.lang.String subProductTypeId,
		java.lang.String virtualHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .persistData(requestParamMap, existingMap, productTypeId,
			subProductTypeId, virtualHostId);
	}

	public static java.lang.String getCurrentUserBaseOrganization(
		long currentUserId) {
		return getService().getCurrentUserBaseOrganization(currentUserId);
	}

	public static long getLoggedInUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoggedInUserId();
	}

	public static java.lang.String addPrincipalDetails(
		java.lang.String inputString) {
		return getService().addPrincipalDetails(inputString);
	}

	public static java.lang.String addPrincipalDetails(
		com.liferay.portal.kernel.json.JSONObject inputJson) {
		return getService().addPrincipalDetails(inputJson);
	}

	public static java.lang.String addMentorToApplication(
		java.lang.String jsonString) {
		return getService().addMentorToApplication(jsonString);
	}

	public static void removeRole(long userId) {
		getService().removeRole(userId);
	}

	public static java.lang.String updatePrinciples(
		java.lang.String inputString) {
		return getService().updatePrinciples(inputString);
	}

	public static java.lang.String updateEmployeeInfo(
		java.lang.String inputString) {
		return getService().updateEmployeeInfo(inputString);
	}

	public static java.lang.String updateAccreditation(
		java.lang.String inputString) {
		return getService().updateAccreditation(inputString);
	}

	public static void updateAssets(long userId,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		long[] assetCategoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateAssets(userId, org, assetCategoryIds);
	}

	public static void updateAssets(long userId,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		long[] assetCategoryIds, java.lang.String[] tagNames)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateAssets(userId, org, assetCategoryIds, tagNames);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations() {
		return getService().getAllActiveOrganizations();
	}

	public static java.util.Map<java.lang.String, java.lang.Object> createOrgDataMap(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().createOrgDataMap(organizationId);
	}

	public static void clearCache(
		com.sambaash.platform.srv.startupprofile.model.Organization org) {
		getService().clearCache(org);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Address> getOfficeAddresses(
		long orgId) {
		return getService().getOfficeAddresses(orgId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Address getOfficeHeadQuaterAddress(
		long orgId) {
		return getService().getOfficeHeadQuaterAddress(orgId);
	}

	public static void reIndex(
		com.sambaash.platform.srv.startupprofile.model.Organization org) {
		getService().reIndex(org);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.FundingRound> getFundingRounds(
		long orgId) {
		return getService().getFundingRounds(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> getContacts(
		long orgId) {
		return getService().getContacts(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Address> getAddresses(
		long orgId) {
		return getService().getAddresses(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> getQuestionnaire(
		long orgId) {
		return getService().getQuestionnaire(orgId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Accreditation getAccreditation(
		long orgId) {
		return getService().getAccreditation(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> getGuidelines(
		long orgId) {
		return getService().getGuidelines(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getMentors(
		long orgId) {
		return getService().getMentors(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long orgId) {
		return getService().getApprovedMentors(orgId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.EmployeeInfo getEmployeeInfo(
		long orgId) {
		return getService().getEmployeeInfo(orgId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts getSPATOContacts(
		long orgId) {
		return getService().getSPATOContacts(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> getATODocuments(
		long orgId) {
		return getService().getATODocuments(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getFounders(
		long orgId) {
		return getService().getFounders(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getBoardAndAdvisory(
		long orgId) {
		return getService().getBoardAndAdvisory(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getTeamMembers(
		long orgId) {
		return getService().getTeamMembers(orgId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Person getFilledBy(
		long orgId) {
		return getService().getFilledBy(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getCompetitors(
		long orgId) {
		return getService().getCompetitors(orgId);
	}

	public static java.util.List<java.lang.Object> getInvestors(long orgId) {
		return getService().getInvestors(orgId);
	}

	public static boolean isOrganizationExistsWithName(java.lang.String orgName) {
		return getService().isOrganizationExistsWithName(orgName);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> findByUENNumber(
		java.lang.String uen) {
		return getService().findByUENNumber(uen);
	}

	public static boolean isOrganizationExistsWithUEN(java.lang.String uen) {
		return getService().isOrganizationExistsWithUEN(uen);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization findByName(
		java.lang.String orgName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByName(orgName);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getUserOrganizations(
		java.lang.Long userId) {
		return getService().getUserOrganizations(userId);
	}

	public static java.lang.String displayFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId) {
		return getService().displayFriendlyURL(themeDisplay, orgId);
	}

	public static java.lang.String applicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService().applicationFriendlyURL(themeDisplay);
	}

	public static java.lang.String applicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId) {
		return getService().applicationFriendlyURL(themeDisplay, orgId);
	}

	public static java.lang.String editFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId) {
		return getService().editFriendlyURL(themeDisplay, orgId);
	}

	public static java.lang.String createFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService().createFriendlyURL(themeDisplay);
	}

	public static java.lang.String exportStartupDetails(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant applicaiton)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().exportStartupDetails(themeDisplay, org, applicaiton);
	}

	public static boolean canUpdateStartup(
		javax.portlet.PortletRequest request, long orgId) {
		return getService().canUpdateStartup(request, orgId);
	}

	public static boolean organizationHasCategoryName(long orgId,
		java.lang.String categoryName) {
		return getService().organizationHasCategoryName(orgId, categoryName);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO() {
		return getService().getAllATO();
	}

	public static java.lang.Integer getATOExpiryPeriodParam() {
		return getService().getATOExpiryPeriodParam();
	}

	public static java.lang.Integer getATOExpiryAdvanceNoticeParam() {
		return getService().getATOExpiryAdvanceNoticeParam();
	}

	public static java.lang.Integer getATOPostExpiryNoticeParam() {
		return getService().getATOPostExpiryNoticeParam();
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getATOsForExpiryNotification() {
		return getService().getATOsForExpiryNotification();
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllExpiredATOs() {
		return getService().getAllExpiredATOs();
	}

	public static java.lang.String updateATOAsExpired(long organizationId) {
		return getService().updateATOAsExpired(organizationId);
	}

	public static java.lang.String updateATOInactive(long organizationId) {
		return getService().updateATOInactive(organizationId);
	}

	public static java.lang.String approveATO(long organizationId) {
		return getService().approveATO(organizationId);
	}

	public static java.lang.String approveATOByUserId(long userId) {
		return getService().approveATOByUserId(userId);
	}

	public static void transferOwnership(java.lang.Long userId) {
		getService().transferOwnership(userId);
	}

	public static java.lang.String removeTPandSCfromATO(long userId) {
		return getService().removeTPandSCfromATO(userId);
	}

	public static java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress) {
		return getService().isUserLinkedToOrganization(emailAddress);
	}

	public static java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress, long organizationId) {
		return getService()
				   .isUserLinkedToOrganization(emailAddress, organizationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrganizationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OrganizationLocalService.class.getName());

			if (invokableLocalService instanceof OrganizationLocalService) {
				_service = (OrganizationLocalService)invokableLocalService;
			}
			else {
				_service = new OrganizationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OrganizationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(OrganizationLocalService service) {
	}

	private static OrganizationLocalService _service;
}