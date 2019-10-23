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

package com.sambaash.platform.srv.startupprofile.service.base;

import com.sambaash.platform.srv.startupprofile.service.StartupProfileServiceUtil;

import java.util.Arrays;

/**
 * @author pradeep
 * @generated
 */
public class StartupProfileServiceClpInvoker {
	public StartupProfileServiceClpInvoker() {
		_methodName82 = "getBeanIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "setBeanIdentifier";

		_methodParameterTypes83 = new String[] { "java.lang.String" };

		_methodName86 = "getAllActiveOrganizations";

		_methodParameterTypes86 = new String[] {  };

		_methodName87 = "addOrganizationDetails";

		_methodParameterTypes87 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName89 = "getOrganization";

		_methodParameterTypes89 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName90 = "addOrganization";

		_methodParameterTypes90 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName91 = "createAtos";

		_methodParameterTypes91 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName92 = "createAtodetails";

		_methodParameterTypes92 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName93 = "getUsersByRole";

		_methodParameterTypes93 = new String[] { "java.lang.String" };

		_methodName94 = "findApprovedMentorsByOrganizationId";

		_methodParameterTypes94 = new String[] { "long" };

		_methodName95 = "findApprovedMentorsByOrganizationIdWithOthers";

		_methodParameterTypes95 = new String[] { "long" };

		_methodName96 = "findATOContactsByOrganizationId";

		_methodParameterTypes96 = new String[] { "long" };

		_methodName97 = "findATOContactsByUserId";

		_methodParameterTypes97 = new String[] { "long" };

		_methodName98 = "getAllATO";

		_methodParameterTypes98 = new String[] {  };

		_methodName99 = "addPrincipalDetails";

		_methodParameterTypes99 = new String[] { "long" };

		_methodName100 = "addMentorToApplication";

		_methodParameterTypes100 = new String[] { "long" };

		_methodName101 = "isUserLinkedToOrganization";

		_methodParameterTypes101 = new String[] { "java.lang.String" };

		_methodName102 = "getATOContactDetail";

		_methodParameterTypes102 = new String[] { "long" };

		_methodName105 = "updatePrinciples";

		_methodParameterTypes105 = new String[] { "long" };

		_methodName106 = "updateEmployeeInfo";

		_methodParameterTypes106 = new String[] { "long" };

		_methodName107 = "updateAccreditation";

		_methodParameterTypes107 = new String[] { "long" };

		_methodName108 = "getOrganizationDetail";

		_methodParameterTypes108 = new String[] { "long" };

		_methodName109 = "getOrganizationDetailByUserId";

		_methodParameterTypes109 = new String[] { "long" };

		_methodName110 = "approveMentor";

		_methodParameterTypes110 = new String[] { "long" };

		_methodName111 = "rejectMentor";

		_methodParameterTypes111 = new String[] { "long" };

		_methodName112 = "approveATO";

		_methodParameterTypes112 = new String[] { "long" };

		_methodName113 = "approveATOByUserId";

		_methodParameterTypes113 = new String[] { "long" };

		_methodName114 = "getApprovedMentors";

		_methodParameterTypes114 = new String[] { "long" };

		_methodName115 = "getAllApprovedMentors";

		_methodParameterTypes115 = new String[] { "int" };

		_methodName116 = "findApprovedMentorsByOrganizationIdAndStatus";

		_methodParameterTypes116 = new String[] { "long", "int" };

		_methodName117 = "findApprovedMentorsByUserIdAndStatus";

		_methodParameterTypes117 = new String[] { "long", "int" };

		_methodName118 = "findMentorsByOrganizationId";

		_methodParameterTypes118 = new String[] { "long" };

		_methodName119 = "removeRole";

		_methodParameterTypes119 = new String[] { "long" };

		_methodName120 = "transerOwnership";

		_methodParameterTypes120 = new String[] { "java.lang.Long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return StartupProfileServiceUtil.getBeanIdentifier();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			StartupProfileServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return StartupProfileServiceUtil.getAllActiveOrganizations();
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return StartupProfileServiceUtil.addOrganizationDetails(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				((Long)arguments[19]).longValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return StartupProfileServiceUtil.getOrganization(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return StartupProfileServiceUtil.addOrganization(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return StartupProfileServiceUtil.createAtos(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.lang.String)arguments[11]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return StartupProfileServiceUtil.createAtodetails(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return StartupProfileServiceUtil.getUsersByRole((java.lang.String)arguments[0]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return StartupProfileServiceUtil.findApprovedMentorsByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return StartupProfileServiceUtil.findApprovedMentorsByOrganizationIdWithOthers(((Long)arguments[0]).longValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return StartupProfileServiceUtil.findATOContactsByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return StartupProfileServiceUtil.findATOContactsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return StartupProfileServiceUtil.getAllATO();
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return StartupProfileServiceUtil.addPrincipalDetails(((Long)arguments[0]).longValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return StartupProfileServiceUtil.addMentorToApplication(((Long)arguments[0]).longValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return StartupProfileServiceUtil.isUserLinkedToOrganization((java.lang.String)arguments[0]);
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return StartupProfileServiceUtil.getATOContactDetail(((Long)arguments[0]).longValue());
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return StartupProfileServiceUtil.updatePrinciples(((Long)arguments[0]).longValue());
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return StartupProfileServiceUtil.updateEmployeeInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return StartupProfileServiceUtil.updateAccreditation(((Long)arguments[0]).longValue());
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return StartupProfileServiceUtil.getOrganizationDetail(((Long)arguments[0]).longValue());
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return StartupProfileServiceUtil.getOrganizationDetailByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return StartupProfileServiceUtil.approveMentor(((Long)arguments[0]).longValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return StartupProfileServiceUtil.rejectMentor(((Long)arguments[0]).longValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return StartupProfileServiceUtil.approveATO(((Long)arguments[0]).longValue());
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return StartupProfileServiceUtil.approveATOByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return StartupProfileServiceUtil.getApprovedMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return StartupProfileServiceUtil.getAllApprovedMentors(((Integer)arguments[0]).intValue());
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return StartupProfileServiceUtil.findApprovedMentorsByOrganizationIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return StartupProfileServiceUtil.findApprovedMentorsByUserIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return StartupProfileServiceUtil.findMentorsByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			StartupProfileServiceUtil.removeRole(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			StartupProfileServiceUtil.transerOwnership((java.lang.Long)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
}