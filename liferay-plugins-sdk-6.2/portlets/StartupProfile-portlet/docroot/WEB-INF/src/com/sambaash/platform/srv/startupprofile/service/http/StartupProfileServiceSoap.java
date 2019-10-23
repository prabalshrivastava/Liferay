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

package com.sambaash.platform.srv.startupprofile.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.startupprofile.service.StartupProfileServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.startupprofile.service.StartupProfileServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author pradeep
 * @see StartupProfileServiceHttp
 * @see com.sambaash.platform.srv.startupprofile.service.StartupProfileServiceUtil
 * @generated
 */
public class StartupProfileServiceSoap {
	public static com.sambaash.platform.srv.startupprofile.model.Organization[] getAllActiveOrganizations()
		throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> returnValue =
				StartupProfileServiceUtil.getAllActiveOrganizations();

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.Organization[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.OrganizationSoap addOrganizationDetails(
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
		throws RemoteException {
		try {
			com.sambaash.platform.srv.startupprofile.model.Organization returnValue =
				StartupProfileServiceUtil.addOrganizationDetails(agroupid,
					acompanyid, auseremail, aorgdesc, aorgname, aorgcode,
					auserid, ausername, auen, awebsite, aindustrysector,
					alistedco, aaccreditationstatus, aaccreditationby,
					adateofaccreditation, adateofexpiry, alatestpaymentdate,
					astartdateofreaccreditation, adateofreaccdtreview,
					anoofpotentialcandidates);

			return com.sambaash.platform.srv.startupprofile.model.OrganizationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.OrganizationSoap getOrganization(
		long groupId, long companyId, java.lang.String companyName)
		throws RemoteException {
		try {
			com.sambaash.platform.srv.startupprofile.model.Organization returnValue =
				StartupProfileServiceUtil.getOrganization(groupId, companyId,
					companyName);

			return com.sambaash.platform.srv.startupprofile.model.OrganizationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.OrganizationSoap addOrganization(
		long groupId, long companyId, java.lang.String userEmail,
		java.lang.String orgDesc, java.lang.String orgName, long userId,
		java.lang.String userName, java.lang.String uen,
		java.lang.String website) throws RemoteException {
		try {
			com.sambaash.platform.srv.startupprofile.model.Organization returnValue =
				StartupProfileServiceUtil.addOrganization(groupId, companyId,
					userEmail, orgDesc, orgName, userId, userName, uen, website);

			return com.sambaash.platform.srv.startupprofile.model.OrganizationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.OrganizationSoap createAtos(
		long sgroupId, long scompanyId, java.lang.String suserEmail,
		java.lang.String sorgDesc, java.lang.String scompanyName,
		java.lang.String sorgCode, long suserId, java.lang.String suserName,
		java.lang.String suen, java.lang.String swebsite,
		java.lang.String sindustrySector, java.lang.String slistedCo)
		throws RemoteException {
		try {
			com.sambaash.platform.srv.startupprofile.model.Organization returnValue =
				StartupProfileServiceUtil.createAtos(sgroupId, scompanyId,
					suserEmail, sorgDesc, scompanyName, sorgCode, suserId,
					suserName, suen, swebsite, sindustrySector, slistedCo);

			return com.sambaash.platform.srv.startupprofile.model.OrganizationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createAtodetails(long dgroupid,
		long dcompanyid, long dorgid, long duserid, java.lang.String dusername,
		java.lang.String dremarks, java.lang.String dspatocontactsarray,
		java.lang.String daddress, java.lang.String dorgname,
		java.lang.String dcountry, java.lang.String dpostcode)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.createAtodetails(dgroupid,
					dcompanyid, dorgid, duserid, dusername, dremarks,
					dspatocontactsarray, daddress, dorgname, dcountry, dpostcode);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User[] getUsersByRole(
		java.lang.String roleName) throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.User> returnValue = StartupProfileServiceUtil.getUsersByRole(roleName);

			return returnValue.toArray(new com.liferay.portal.model.User[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findApprovedMentorsByOrganizationId(
		long organizationId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.findApprovedMentorsByOrganizationId(organizationId);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findApprovedMentorsByOrganizationIdWithOthers(
		long organizationId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.findApprovedMentorsByOrganizationIdWithOthers(organizationId);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findATOContactsByOrganizationId(
		long organizationId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> returnValue =
				StartupProfileServiceUtil.findATOContactsByOrganizationId(organizationId);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.SPATOContacts[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String findATOContactsByUserId(long userId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = StartupProfileServiceUtil.findATOContactsByUserId(userId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.Organization[] getAllATO()
		throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> returnValue =
				StartupProfileServiceUtil.getAllATO();

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.Organization[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String addPrincipalDetails(long processStateId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.addPrincipalDetails(processStateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String addMentorToApplication(long processStateId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.addMentorToApplication(processStateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress) throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.isUserLinkedToOrganization(emailAddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getATOContactDetail(long organizationId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.getATOContactDetail(organizationId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updatePrinciples(long processStateId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.updatePrinciples(processStateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updateEmployeeInfo(long processStateId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.updateEmployeeInfo(processStateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updateAccreditation(long processStateId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.updateAccreditation(processStateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String approveMentor(long userId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.approveMentor(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String rejectMentor(long userId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.rejectMentor(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String approveATO(long organizationId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.approveATO(organizationId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String approveATOByUserId(long userId)
		throws RemoteException {
		try {
			java.lang.String returnValue = StartupProfileServiceUtil.approveATOByUserId(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] getApprovedMentors(
		long organizationId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.getApprovedMentors(organizationId);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] getAllApprovedMentors(
		int status) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.getAllApprovedMentors(status);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findApprovedMentorsByOrganizationIdAndStatus(
		long organizationId, int status) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.findApprovedMentorsByOrganizationIdAndStatus(organizationId,
					status);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findApprovedMentorsByUserIdAndStatus(
		long userId, int status) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.findApprovedMentorsByUserIdAndStatus(userId,
					status);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findMentorsByOrganizationId(
		long organizationId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> returnValue =
				StartupProfileServiceUtil.findMentorsByOrganizationId(organizationId);

			return returnValue.toArray(new com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeRole(long userId) throws RemoteException {
		try {
			StartupProfileServiceUtil.removeRole(userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void transerOwnership(java.lang.Long userId)
		throws RemoteException {
		try {
			StartupProfileServiceUtil.transerOwnership(userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(StartupProfileServiceSoap.class);
}