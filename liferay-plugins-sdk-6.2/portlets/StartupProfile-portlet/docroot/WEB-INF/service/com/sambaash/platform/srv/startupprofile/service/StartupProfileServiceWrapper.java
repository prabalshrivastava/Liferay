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
 * Provides a wrapper for {@link StartupProfileService}.
 *
 * @author pradeep
 * @see StartupProfileService
 * @generated
 */
public class StartupProfileServiceWrapper implements StartupProfileService,
	ServiceWrapper<StartupProfileService> {
	public StartupProfileServiceWrapper(
		StartupProfileService startupProfileService) {
		_startupProfileService = startupProfileService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _startupProfileService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_startupProfileService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _startupProfileService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations() {
		return _startupProfileService.getAllActiveOrganizations();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganizationDetails(
		long agroupid, long acompanyid, java.lang.String auseremail,
		java.lang.String aorgdesc, java.lang.String aorgname,
		java.lang.String aorgcode, long auserid, java.lang.String ausername,
		java.lang.String auen, java.lang.String awebsite,
		java.lang.String aindustrysector, java.lang.String alistedco,
		java.lang.String aaccreditationstatus,
		java.lang.String aaccreditationby,
		java.lang.String adateofaccreditation, java.lang.String adateofexpiry,
		java.lang.String alatestpaymentdate,
		java.lang.String astartdateofreaccreditation,
		java.lang.String adateofreaccdtreview, long anoofpotentialcandidates)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _startupProfileService.addOrganizationDetails(agroupid,
			acompanyid, auseremail, aorgdesc, aorgname, aorgcode, auserid,
			ausername, auen, awebsite, aindustrysector, alistedco,
			aaccreditationstatus, aaccreditationby, adateofaccreditation,
			adateofexpiry, alatestpaymentdate, astartdateofreaccreditation,
			adateofreaccdtreview, anoofpotentialcandidates);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long groupId, long companyId, java.lang.String companyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _startupProfileService.getOrganization(groupId, companyId,
			companyName);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		long groupId, long companyId, java.lang.String userEmail,
		java.lang.String orgDesc, java.lang.String orgName, long userId,
		java.lang.String userName, java.lang.String uen,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _startupProfileService.addOrganization(groupId, companyId,
			userEmail, orgDesc, orgName, userId, userName, uen, website);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization createAtos(
		long sgroupId, long scompanyId, java.lang.String suserEmail,
		java.lang.String sorgDesc, java.lang.String scompanyName,
		java.lang.String sorgCode, long suserId, java.lang.String suserName,
		java.lang.String suen, java.lang.String swebsite,
		java.lang.String sindustrySector, java.lang.String slistedCo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _startupProfileService.createAtos(sgroupId, scompanyId,
			suserEmail, sorgDesc, scompanyName, sorgCode, suserId, suserName,
			suen, swebsite, sindustrySector, slistedCo);
	}

	@Override
	public java.lang.String createAtodetails(long dgroupid, long dcompanyid,
		long dorgid, long duserid, java.lang.String dusername,
		java.lang.String dremarks, java.lang.String dspatocontactsarray,
		java.lang.String daddress, java.lang.String dorgname,
		java.lang.String dcountry, java.lang.String dpostcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _startupProfileService.createAtodetails(dgroupid, dcompanyid,
			dorgid, duserid, dusername, dremarks, dspatocontactsarray,
			daddress, dorgname, dcountry, dpostcode);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersByRole(
		java.lang.String roleName) {
		return _startupProfileService.getUsersByRole(roleName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationId(
		long organizationId) {
		return _startupProfileService.findApprovedMentorsByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(
		long organizationId) {
		return _startupProfileService.findApprovedMentorsByOrganizationIdWithOthers(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsByOrganizationId(
		long organizationId) {
		return _startupProfileService.findATOContactsByOrganizationId(organizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject findATOContactsByUserId(
		long userId) {
		return _startupProfileService.findATOContactsByUserId(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO() {
		return _startupProfileService.getAllATO();
	}

	@Override
	public java.lang.String addPrincipalDetails(long processStateId) {
		return _startupProfileService.addPrincipalDetails(processStateId);
	}

	@Override
	public java.lang.String addMentorToApplication(long processStateId) {
		return _startupProfileService.addMentorToApplication(processStateId);
	}

	@Override
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress) {
		return _startupProfileService.isUserLinkedToOrganization(emailAddress);
	}

	@Override
	public java.lang.String getATOContactDetail(long organizationId) {
		return _startupProfileService.getATOContactDetail(organizationId);
	}

	@Override
	public java.lang.String updatePrinciples(long processStateId) {
		return _startupProfileService.updatePrinciples(processStateId);
	}

	@Override
	public java.lang.String updateEmployeeInfo(long processStateId) {
		return _startupProfileService.updateEmployeeInfo(processStateId);
	}

	@Override
	public java.lang.String updateAccreditation(long processStateId) {
		return _startupProfileService.updateAccreditation(processStateId);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetail(
		long organizationId) {
		return _startupProfileService.getOrganizationDetail(organizationId);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetailByUserId(
		long userId) {
		return _startupProfileService.getOrganizationDetailByUserId(userId);
	}

	@Override
	public java.lang.String approveMentor(long userId) {
		return _startupProfileService.approveMentor(userId);
	}

	@Override
	public java.lang.String rejectMentor(long userId) {
		return _startupProfileService.rejectMentor(userId);
	}

	@Override
	public java.lang.String approveATO(long organizationId) {
		return _startupProfileService.approveATO(organizationId);
	}

	@Override
	public java.lang.String approveATOByUserId(long userId) {
		return _startupProfileService.approveATOByUserId(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long organizationId) {
		return _startupProfileService.getApprovedMentors(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getAllApprovedMentors(
		int status) {
		return _startupProfileService.getAllApprovedMentors(status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(
		long organizationId, int status) {
		return _startupProfileService.findApprovedMentorsByOrganizationIdAndStatus(organizationId,
			status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByUserIdAndStatus(
		long userId, int status) {
		return _startupProfileService.findApprovedMentorsByUserIdAndStatus(userId,
			status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findMentorsByOrganizationId(
		long organizationId) {
		return _startupProfileService.findMentorsByOrganizationId(organizationId);
	}

	@Override
	public void removeRole(long userId) {
		_startupProfileService.removeRole(userId);
	}

	@Override
	public void transerOwnership(java.lang.Long userId) {
		_startupProfileService.transerOwnership(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StartupProfileService getWrappedStartupProfileService() {
		return _startupProfileService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStartupProfileService(
		StartupProfileService startupProfileService) {
		_startupProfileService = startupProfileService;
	}

	@Override
	public StartupProfileService getWrappedService() {
		return _startupProfileService;
	}

	@Override
	public void setWrappedService(StartupProfileService startupProfileService) {
		_startupProfileService = startupProfileService;
	}

	private StartupProfileService _startupProfileService;
}