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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Organization. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author pradeep
 * @see OrganizationLocalServiceUtil
 * @see com.sambaash.platform.srv.startupprofile.service.base.OrganizationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.impl.OrganizationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OrganizationLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationLocalServiceUtil} to access the organization local service. Add custom service methods to {@link com.sambaash.platform.srv.startupprofile.service.impl.OrganizationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the organization to the database. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new organization with the primary key. Does not add the organization to the database.
	*
	* @param organizationId the primary key for the new organization
	* @return the new organization
	*/
	public com.sambaash.platform.srv.startupprofile.model.Organization createOrganization(
		long organizationId);

	/**
	* Deletes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationId the primary key of the organization
	* @return the organization that was removed
	* @throws PortalException if a organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.startupprofile.model.Organization deleteOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the organization from the database. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.startupprofile.model.Organization deleteOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization with the matching UUID and company.
	*
	* @param uuid the organization's UUID
	* @param companyId the primary key of the company
	* @return the matching organization, or <code>null</code> if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganizationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization matching the UUID and group.
	*
	* @param uuid the organization's UUID
	* @param groupId the primary key of the group
	* @return the matching organization, or <code>null</code> if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization fetchOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization with the primary key.
	*
	* @param organizationId the primary key of the organization
	* @return the organization
	* @throws PortalException if a organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization with the matching UUID and company.
	*
	* @param uuid the organization's UUID
	* @param companyId the primary key of the company
	* @return the matching organization
	* @throws PortalException if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganizationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization matching the UUID and group.
	*
	* @param uuid the organization's UUID
	* @param groupId the primary key of the group
	* @return the matching organization
	* @throws PortalException if a matching organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getOrganizations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizations.
	*
	* @return the number of organizations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOrganizationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organization the organization
	* @return the organization that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.startupprofile.model.Organization updateOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.sambaash.platform.srv.startupprofile.model.Organization create()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.startupprofile.model.Organization persistData(
		java.util.Map<java.lang.String, java.lang.String> requestParamMap,
		java.util.Map<java.lang.String, java.lang.Object> existingMap,
		java.lang.String productTypeId, java.lang.String subProductTypeId,
		java.lang.String virtualHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCurrentUserBaseOrganization(long currentUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getLoggedInUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String addPrincipalDetails(java.lang.String inputString);

	public java.lang.String addPrincipalDetails(
		com.liferay.portal.kernel.json.JSONObject inputJson);

	public java.lang.String addMentorToApplication(java.lang.String jsonString);

	public void removeRole(long userId);

	public java.lang.String updatePrinciples(java.lang.String inputString);

	public java.lang.String updateEmployeeInfo(java.lang.String inputString);

	public java.lang.String updateAccreditation(java.lang.String inputString);

	public void updateAssets(long userId,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		long[] assetCategoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateAssets(long userId,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		long[] assetCategoryIds, java.lang.String[] tagNames)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations();

	public java.util.Map<java.lang.String, java.lang.Object> createOrgDataMap(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void clearCache(
		com.sambaash.platform.srv.startupprofile.model.Organization org);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Address> getOfficeAddresses(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Address getOfficeHeadQuaterAddress(
		long orgId);

	public void reIndex(
		com.sambaash.platform.srv.startupprofile.model.Organization org);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.FundingRound> getFundingRounds(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> getContacts(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Address> getAddresses(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> getQuestionnaire(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Accreditation getAccreditation(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> getGuidelines(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getMentors(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.EmployeeInfo getEmployeeInfo(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts getSPATOContacts(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> getATODocuments(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getFounders(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getBoardAndAdvisory(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Person> getTeamMembers(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Person getFilledBy(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getCompetitors(
		long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Object> getInvestors(long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isOrganizationExistsWithName(java.lang.String orgName);

	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> findByUENNumber(
		java.lang.String uen);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isOrganizationExistsWithUEN(java.lang.String uen);

	public com.sambaash.platform.srv.startupprofile.model.Organization findByName(
		java.lang.String orgName)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getUserOrganizations(
		java.lang.Long userId);

	public java.lang.String displayFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId);

	public java.lang.String applicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay);

	public java.lang.String applicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId);

	public java.lang.String editFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long orgId);

	public java.lang.String createFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay);

	public java.lang.String exportStartupDetails(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		com.sambaash.platform.srv.startupprofile.model.Organization org,
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant applicaiton)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean canUpdateStartup(javax.portlet.PortletRequest request,
		long orgId);

	public boolean organizationHasCategoryName(long orgId,
		java.lang.String categoryName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Integer getATOExpiryPeriodParam();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Integer getATOExpiryAdvanceNoticeParam();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Integer getATOPostExpiryNoticeParam();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getATOsForExpiryNotification();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllExpiredATOs();

	public java.lang.String updateATOAsExpired(long organizationId);

	public java.lang.String updateATOInactive(long organizationId);

	public java.lang.String approveATO(long organizationId);

	public java.lang.String approveATOByUserId(long userId);

	public void transferOwnership(java.lang.Long userId);

	public java.lang.String removeTPandSCfromATO(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress, long organizationId);
}