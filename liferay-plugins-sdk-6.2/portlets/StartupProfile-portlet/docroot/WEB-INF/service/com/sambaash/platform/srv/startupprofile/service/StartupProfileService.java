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
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for StartupProfile. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author pradeep
 * @see StartupProfileServiceUtil
 * @see com.sambaash.platform.srv.startupprofile.service.base.StartupProfileServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface StartupProfileService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StartupProfileServiceUtil} to access the startup profile remote service. Add custom service methods to {@link com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations();

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
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
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long groupId, long companyId, java.lang.String companyName)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		long groupId, long companyId, java.lang.String userEmail,
		java.lang.String orgDesc, java.lang.String orgName, long userId,
		java.lang.String userName, java.lang.String uen,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.sambaash.platform.srv.startupprofile.model.Organization createAtos(
		long sgroupId, long scompanyId, java.lang.String suserEmail,
		java.lang.String sorgDesc, java.lang.String scompanyName,
		java.lang.String sorgCode, long suserId, java.lang.String suserName,
		java.lang.String suen, java.lang.String swebsite,
		java.lang.String sindustrySector, java.lang.String slistedCo)
		throws com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String createAtodetails(long dgroupid, long dcompanyid,
		long dorgid, long duserid, java.lang.String dusername,
		java.lang.String dremarks, java.lang.String dspatocontactsarray,
		java.lang.String daddress, java.lang.String dorgname,
		java.lang.String dcountry, java.lang.String dpostcode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.User> getUsersByRole(
		java.lang.String roleName);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationId(
		long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(
		long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsByOrganizationId(
		long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject findATOContactsByUserId(
		long userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO();

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String addPrincipalDetails(long processStateId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String addMentorToApplication(long processStateId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getATOContactDetail(long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String updatePrinciples(long processStateId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String updateEmployeeInfo(long processStateId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String updateAccreditation(long processStateId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetail(
		long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetailByUserId(
		long userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String approveMentor(long userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String rejectMentor(long userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String approveATO(long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String approveATOByUserId(long userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getAllApprovedMentors(
		int status);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(
		long organizationId, int status);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByUserIdAndStatus(
		long userId, int status);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findMentorsByOrganizationId(
		long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public void removeRole(long userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public void transerOwnership(java.lang.Long userId);
}