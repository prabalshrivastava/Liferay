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

import com.liferay.portal.service.InvokableService;

/**
 * @author pradeep
 * @generated
 */
public class StartupProfileServiceClp implements StartupProfileService {
	public StartupProfileServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getAllActiveOrganizations";

		_methodParameterTypes3 = new String[] {  };

		_methodName4 = "addOrganizationDetails";

		_methodParameterTypes4 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName5 = "getOrganization";

		_methodParameterTypes5 = new String[] { "long", "long", "java.lang.String" };

		_methodName6 = "addOrganization";

		_methodParameterTypes6 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName7 = "createAtos";

		_methodParameterTypes7 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName8 = "createAtodetails";

		_methodParameterTypes8 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName9 = "getUsersByRole";

		_methodParameterTypes9 = new String[] { "java.lang.String" };

		_methodName10 = "findApprovedMentorsByOrganizationId";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "findApprovedMentorsByOrganizationIdWithOthers";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "findATOContactsByOrganizationId";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "findATOContactsByUserId";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getAllATO";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "addPrincipalDetails";

		_methodParameterTypes15 = new String[] { "long" };

		_methodName16 = "addMentorToApplication";

		_methodParameterTypes16 = new String[] { "long" };

		_methodName17 = "isUserLinkedToOrganization";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName18 = "getATOContactDetail";

		_methodParameterTypes18 = new String[] { "long" };

		_methodName19 = "updatePrinciples";

		_methodParameterTypes19 = new String[] { "long" };

		_methodName20 = "updateEmployeeInfo";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "updateAccreditation";

		_methodParameterTypes21 = new String[] { "long" };

		_methodName22 = "getOrganizationDetail";

		_methodParameterTypes22 = new String[] { "long" };

		_methodName23 = "getOrganizationDetailByUserId";

		_methodParameterTypes23 = new String[] { "long" };

		_methodName24 = "approveMentor";

		_methodParameterTypes24 = new String[] { "long" };

		_methodName25 = "rejectMentor";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "approveATO";

		_methodParameterTypes26 = new String[] { "long" };

		_methodName27 = "approveATOByUserId";

		_methodParameterTypes27 = new String[] { "long" };

		_methodName28 = "getApprovedMentors";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "getAllApprovedMentors";

		_methodParameterTypes29 = new String[] { "int" };

		_methodName30 = "findApprovedMentorsByOrganizationIdAndStatus";

		_methodParameterTypes30 = new String[] { "long", "int" };

		_methodName31 = "findApprovedMentorsByUserIdAndStatus";

		_methodParameterTypes31 = new String[] { "long", "int" };

		_methodName32 = "findMentorsByOrganizationId";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "removeRole";

		_methodParameterTypes33 = new String[] { "long" };

		_methodName34 = "transerOwnership";

		_methodParameterTypes34 = new String[] { "java.lang.Long" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization>)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						agroupid,
						
					acompanyid,
						
					ClpSerializer.translateInput(auseremail),
						
					ClpSerializer.translateInput(aorgdesc),
						
					ClpSerializer.translateInput(aorgname),
						
					ClpSerializer.translateInput(aorgcode),
						
					auserid,
						
					ClpSerializer.translateInput(ausername),
						
					ClpSerializer.translateInput(auen),
						
					ClpSerializer.translateInput(awebsite),
						
					ClpSerializer.translateInput(aindustrysector),
						
					ClpSerializer.translateInput(alistedco),
						
					ClpSerializer.translateInput(aaccreditationstatus),
						
					ClpSerializer.translateInput(aaccreditationby),
						
					ClpSerializer.translateInput(adateofaccreditation),
						
					ClpSerializer.translateInput(adateofexpiry),
						
					ClpSerializer.translateInput(alatestpaymentdate),
						
					ClpSerializer.translateInput(astartdateofreaccreditation),
						
					ClpSerializer.translateInput(adateofreaccdtreview),
						
					anoofpotentialcandidates
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.startupprofile.model.Organization)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization getOrganization(
		long groupId, long companyId, java.lang.String companyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						groupId,
						
					companyId,
						
					ClpSerializer.translateInput(companyName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.startupprofile.model.Organization)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		long groupId, long companyId, java.lang.String userEmail,
		java.lang.String orgDesc, java.lang.String orgName, long userId,
		java.lang.String userName, java.lang.String uen,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						groupId,
						
					companyId,
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(orgDesc),
						
					ClpSerializer.translateInput(orgName),
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					ClpSerializer.translateInput(uen),
						
					ClpSerializer.translateInput(website)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.startupprofile.model.Organization)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization createAtos(
		long sgroupId, long scompanyId, java.lang.String suserEmail,
		java.lang.String sorgDesc, java.lang.String scompanyName,
		java.lang.String sorgCode, long suserId, java.lang.String suserName,
		java.lang.String suen, java.lang.String swebsite,
		java.lang.String sindustrySector, java.lang.String slistedCo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						sgroupId,
						
					scompanyId,
						
					ClpSerializer.translateInput(suserEmail),
						
					ClpSerializer.translateInput(sorgDesc),
						
					ClpSerializer.translateInput(scompanyName),
						
					ClpSerializer.translateInput(sorgCode),
						
					suserId,
						
					ClpSerializer.translateInput(suserName),
						
					ClpSerializer.translateInput(suen),
						
					ClpSerializer.translateInput(swebsite),
						
					ClpSerializer.translateInput(sindustrySector),
						
					ClpSerializer.translateInput(slistedCo)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.startupprofile.model.Organization)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String createAtodetails(long dgroupid, long dcompanyid,
		long dorgid, long duserid, java.lang.String dusername,
		java.lang.String dremarks, java.lang.String dspatocontactsarray,
		java.lang.String daddress, java.lang.String dorgname,
		java.lang.String dcountry, java.lang.String dpostcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						dgroupid,
						
					dcompanyid,
						
					dorgid,
						
					duserid,
						
					ClpSerializer.translateInput(dusername),
						
					ClpSerializer.translateInput(dremarks),
						
					ClpSerializer.translateInput(dspatocontactsarray),
						
					ClpSerializer.translateInput(daddress),
						
					ClpSerializer.translateInput(dorgname),
						
					ClpSerializer.translateInput(dcountry),
						
					ClpSerializer.translateInput(dpostcode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersByRole(
		java.lang.String roleName) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { ClpSerializer.translateInput(roleName) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.model.User>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationId(
		long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(
		long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsByOrganizationId(
		long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject findATOContactsByUserId(
		long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllATO() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addPrincipalDetails(long processStateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName15,
					_methodParameterTypes15, new Object[] { processStateId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addMentorToApplication(long processStateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] { processStateId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String isUserLinkedToOrganization(
		java.lang.String emailAddress) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] { ClpSerializer.translateInput(emailAddress) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getATOContactDetail(long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updatePrinciples(long processStateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName19,
					_methodParameterTypes19, new Object[] { processStateId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateEmployeeInfo(long processStateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] { processStateId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateAccreditation(long processStateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName21,
					_methodParameterTypes21, new Object[] { processStateId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetail(
		long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName22,
					_methodParameterTypes22, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.Object>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getOrganizationDetailByUserId(
		long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName23,
					_methodParameterTypes23, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.Object>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String approveMentor(long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName24,
					_methodParameterTypes24, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String rejectMentor(long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName25,
					_methodParameterTypes25, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String approveATO(long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName26,
					_methodParameterTypes26, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String approveATOByUserId(long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName27,
					_methodParameterTypes27, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentors(
		long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName28,
					_methodParameterTypes28, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getAllApprovedMentors(
		int status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName29,
					_methodParameterTypes29, new Object[] { status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(
		long organizationId, int status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] { organizationId, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByUserIdAndStatus(
		long userId, int status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName31,
					_methodParameterTypes31, new Object[] { userId, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findMentorsByOrganizationId(
		long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName32,
					_methodParameterTypes32, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void removeRole(long userId) {
		try {
			_invokableService.invokeMethod(_methodName33,
				_methodParameterTypes33, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void transerOwnership(java.lang.Long userId) {
		try {
			_invokableService.invokeMethod(_methodName34,
				_methodParameterTypes34,
				new Object[] { ClpSerializer.translateInput(userId) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
}