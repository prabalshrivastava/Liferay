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

package com.sambaash.platform.systemmodelsetup.service.base;

import com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil;

import java.util.Arrays;

/**
 * @author biswo
 * @generated
 */
public class SystemServiceClpInvoker {
	public SystemServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "getCategory";

		_methodParameterTypes20 = new String[] { "java.lang.String", "long" };

		_methodName21 = "getModelList";

		_methodParameterTypes21 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String"
			};

		_methodName22 = "getModelList";

		_methodParameterTypes22 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName23 = "getModelList";

		_methodParameterTypes23 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName24 = "getUserByEmail";

		_methodParameterTypes24 = new String[] { "long", "java.lang.String" };

		_methodName25 = "createRecord";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName26 = "createRecordNew";

		_methodParameterTypes26 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName27 = "updateRecordFromProcessState";

		_methodParameterTypes27 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName28 = "createRecordFromProcessState";

		_methodParameterTypes28 = new String[] { "java.lang.String" };

		_methodName36 = "getRecord";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName37 = "getActiveSchedules";

		_methodParameterTypes37 = new String[] { "long", "java.lang.String" };

		_methodName38 = "getPrepareClaimSchedules";

		_methodParameterTypes38 = new String[] { "long", "java.lang.String" };

		_methodName39 = "getSchedulesForEnroledProgramme";

		_methodParameterTypes39 = new String[] { "long", "long", "long" };

		_methodName40 = "getProgrammeEnroled";

		_methodParameterTypes40 = new String[] { "long", "long", "long" };

		_methodName41 = "getCandidateCurrentAto";

		_methodParameterTypes41 = new String[] { "long", "long", "long" };

		_methodName42 = "getModules";

		_methodParameterTypes42 = new String[] { "long", "long", "long" };

		_methodName43 = "createUser";

		_methodParameterTypes43 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName44 = "getRoleDetails";

		_methodParameterTypes44 = new String[] { "long", "java.lang.String" };

		_methodName45 = "addUserRecord";

		_methodParameterTypes45 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean"
			};

		_methodName46 = "addUserRecord";

		_methodParameterTypes46 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String", "long"
			};

		_methodName47 = "assignRolesToUser";

		_methodParameterTypes47 = new String[] { "long", "long[][]" };

		_methodName48 = "deleteRoleFromUser";

		_methodParameterTypes48 = new String[] { "long", "long" };

		_methodName49 = "checkIfUserHasRole";

		_methodParameterTypes49 = new String[] {
				"long", "long", "java.lang.String", "boolean"
			};

		_methodName50 = "deleteUserRecord";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "removeTPandSCfromATO";

		_methodParameterTypes51 = new String[] { "long" };

		_methodName52 = "checkExemptionEligibility";

		_methodParameterTypes52 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName53 = "checkExemptionEligibility";

		_methodParameterTypes53 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName54 = "addAdmissionRecord";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName55 = "addExemptionRecord";

		_methodParameterTypes55 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName56 = "createEnrolmentRecord";

		_methodParameterTypes56 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName58 = "getEntityLink";

		_methodParameterTypes58 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.Boolean"
			};

		_methodName64 = "decode";

		_methodParameterTypes64 = new String[] { "java.lang.String" };

		_methodName65 = "createUser";

		_methodParameterTypes65 = new String[] { "java.lang.String" };

		_methodName70 = "addTimelineActivity";

		_methodParameterTypes70 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName71 = "updateUser";

		_methodParameterTypes71 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SystemServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SystemServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SystemServiceUtil.getCategory((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SystemServiceUtil.getModelList((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SystemServiceUtil.getModelList((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue());
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SystemServiceUtil.getModelList((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SystemServiceUtil.getUserByEmail(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SystemServiceUtil.createRecord((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SystemServiceUtil.createRecordNew(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SystemServiceUtil.updateRecordFromProcessState((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SystemServiceUtil.createRecordFromProcessState((java.lang.String)arguments[0]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SystemServiceUtil.getRecord((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SystemServiceUtil.getActiveSchedules(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SystemServiceUtil.getPrepareClaimSchedules(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SystemServiceUtil.getSchedulesForEnroledProgramme(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SystemServiceUtil.getProgrammeEnroled(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return SystemServiceUtil.getCandidateCurrentAto(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SystemServiceUtil.getModules(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return SystemServiceUtil.createUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return SystemServiceUtil.getRoleDetails(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return SystemServiceUtil.addUserRecord((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return SystemServiceUtil.addUserRecord((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(java.lang.String)arguments[5], ((Long)arguments[6]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			SystemServiceUtil.assignRolesToUser(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			SystemServiceUtil.deleteRoleFromUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return SystemServiceUtil.checkIfUserHasRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			SystemServiceUtil.deleteUserRecord(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			SystemServiceUtil.removeTPandSCfromATO(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return SystemServiceUtil.checkExemptionEligibility((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return SystemServiceUtil.checkExemptionEligibility(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SystemServiceUtil.addAdmissionRecord((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SystemServiceUtil.addExemptionRecord((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SystemServiceUtil.createEnrolmentRecord((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SystemServiceUtil.getEntityLink(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.Boolean)arguments[4]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SystemServiceUtil.decode((java.lang.String)arguments[0]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SystemServiceUtil.createUser((java.lang.String)arguments[0]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			SystemServiceUtil.addTimelineActivity((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				((Long)arguments[12]).longValue());

			return null;
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SystemServiceUtil.updateUser((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
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
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
}