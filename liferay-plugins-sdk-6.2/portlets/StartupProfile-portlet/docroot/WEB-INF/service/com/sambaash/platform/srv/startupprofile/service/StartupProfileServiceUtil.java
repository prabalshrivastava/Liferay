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
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for StartupProfile. This utility wraps
 * {@link com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author pradeep
 * @see StartupProfileService
 * @see com.sambaash.platform.srv.startupprofile.service.base.StartupProfileServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileServiceImpl
 * @generated
 */
public class StartupProfileServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations() {
		return getService().getAllActiveOrganizations();
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization addOrganizationDetails(
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
		return getService()
				   .addOrganizationDetails(agroupid, acompanyid, auseremail,
			aorgdesc, aorgname, aorgcode, auserid, ausername, auen, awebsite,
			aindustrysector, alistedco, aaccreditationstatus, aaccreditationby,
			adateofaccreditation, adateofexpiry, alatestpaymentdate,
			astartdateofreaccreditation, adateofreaccdtreview,
			anoofpotentialcandidates);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long groupId, long companyId, java.lang.String companyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganization(groupId, companyId, companyName);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		long groupId, long companyId, java.lang.String userEmail,
		java.lang.String orgDesc, java.lang.String orgName, long userId,
		java.lang.String userName, java.lang.String uen,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrganization(groupId, companyId, userEmail, orgDesc,
			orgName, userId, userName, uen, website);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization createAtos(
		long sgroupId, long scompanyId, java.lang.String suserEmail,
		java.lang.String sorgDesc, java.lang.String scompanyName,
		java.lang.String sorgCode, long suserId, java.lang.String suserName,
		java.lang.String suen, java.lang.String swebsite,
		java.lang.String sindustrySector, java.lang.String slistedCo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .createAtos(sgroupId, scompanyId, suserEmail, sorgDesc,
			scompanyName, sorgCode, suserId, suserName, suen, swebsite,
			sindustrySector, slistedCo);
	}

	public static java.lang.String createAtodetails(long dgroupid,
		long dcompanyid, long dorgid, long duserid, java.lang.String dusername,
		java.lang.String dremarks, java.lang.String dspatocontactsarray,
		java.lang.String daddress, java.lang.String dorgname,
		java.lang.String dcountry, java.lang.String dpostcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .createAtodetails(dgroupid, dcompanyid, dorgid, duserid,
			dusername, dremarks, dspatocontactsarray, daddress, dorgname,
			dcountry, dpostcode);
	}

	public static java.util.List<com.liferay.portal.model.User> getUsersByRole(
		java.lang.String roleName) {
		return getService().getUsersByRole(roleName);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationId(
		long organizationId) {
		return getService().findApprovedMentorsByOrganizationId(organizationId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(
		long organizationId) {
		return getService()
				   .findApprovedMentorsByOrganizationIdWithOthers(organizationId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsByOrganizationId(
		long organizationId) {
		return getService().findATOContactsByOrganizationId(organizationId);
	}

	public static com.liferay.portal.kernel.json.JSONObject findATOContactsByUserId(
		long userId) {
		return getService().findATOContactsByUserId(userId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO() {
		return getService().getAllATO();
	}

	public static java.lang.String addPrincipalDetails(long processStateId) {
		return getService().addPrincipalDetails(processStateId);
	}

	public static java.lang.String addMentorToApplication(long processStateId) {
		return getService().addMentorToApplication(processStateId);
	}

	public static java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress) {
		return getService().isUserLinkedToOrganization(emailAddress);
	}

	public static java.lang.String getATOContactDetail(long organizationId) {
		return getService().getATOContactDetail(organizationId);
	}

	public static java.lang.String updatePrinciples(long processStateId) {
		return getService().updatePrinciples(processStateId);
	}

	public static java.lang.String updateEmployeeInfo(long processStateId) {
		return getService().updateEmployeeInfo(processStateId);
	}

	public static java.lang.String updateAccreditation(long processStateId) {
		return getService().updateAccreditation(processStateId);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetail(
		long organizationId) {
		return getService().getOrganizationDetail(organizationId);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetailByUserId(
		long userId) {
		return getService().getOrganizationDetailByUserId(userId);
	}

	public static java.lang.String approveMentor(long userId) {
		return getService().approveMentor(userId);
	}

	public static java.lang.String rejectMentor(long userId) {
		return getService().rejectMentor(userId);
	}

	public static java.lang.String approveATO(long organizationId) {
		return getService().approveATO(organizationId);
	}

	public static java.lang.String approveATOByUserId(long userId) {
		return getService().approveATOByUserId(userId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long organizationId) {
		return getService().getApprovedMentors(organizationId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getAllApprovedMentors(
		int status) {
		return getService().getAllApprovedMentors(status);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(
		long organizationId, int status) {
		return getService()
				   .findApprovedMentorsByOrganizationIdAndStatus(organizationId,
			status);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByUserIdAndStatus(
		long userId, int status) {
		return getService().findApprovedMentorsByUserIdAndStatus(userId, status);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findMentorsByOrganizationId(
		long organizationId) {
		return getService().findMentorsByOrganizationId(organizationId);
	}

	public static void removeRole(long userId) {
		getService().removeRole(userId);
	}

	public static void transerOwnership(java.lang.Long userId) {
		getService().transerOwnership(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static StartupProfileService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StartupProfileService.class.getName());

			if (invokableService instanceof StartupProfileService) {
				_service = (StartupProfileService)invokableService;
			}
			else {
				_service = new StartupProfileServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(StartupProfileServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StartupProfileService service) {
	}

	private static StartupProfileService _service;
}