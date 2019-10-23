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

package com.sambaash.platform.srv.spmicroservice.service.base;

import com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author glenn
 * @generated
 */
public class CandidateMicroserviceLocalServiceClpInvoker {
	public CandidateMicroserviceLocalServiceClpInvoker() {
		_methodName28 = "getBeanIdentifier";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "setBeanIdentifier";

		_methodParameterTypes29 = new String[] { "java.lang.String" };

		_methodName32 = "validate";

		_methodParameterTypes32 = new String[] {
				"long", "com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName33 = "craete";

		_methodParameterTypes33 = new String[] {
				"long", "com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName34 = "update";

		_methodParameterTypes34 = new String[] {
				"long", "com.liferay.portal.kernel.json.JSONObject",
				"java.lang.String"
			};

		_methodName35 = "retrieveCandidateProgrammePath";

		_methodParameterTypes35 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName36 = "getCandidateAllowedModules";

		_methodParameterTypes36 = new String[] {
				"long", "java.lang.Long", "java.lang.String"
			};

		_methodName37 = "getCandidateSchedule";

		_methodParameterTypes37 = new String[] { "long", "java.lang.Long" };

		_methodName38 = "getCandidateFailedModules";

		_methodParameterTypes38 = new String[] {
				"long", "java.lang.Long", "java.lang.String"
			};

		_methodName39 = "hasResults";

		_methodParameterTypes39 = new String[] {
				"long", "java.lang.String", "java.lang.Long"
			};

		_methodName40 = "allowedProgrammeScheduleToEnrol";

		_methodParameterTypes40 = new String[] { "long", "java.lang.Long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			CandidateMicroserviceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.validate(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.json.JSONObject)arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.craete(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.json.JSONObject)arguments[1]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.update(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.json.JSONObject)arguments[1],
				(java.lang.String)arguments[2]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.retrieveCandidateProgrammePath(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.getCandidateAllowedModules(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.getCandidateSchedule(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.getCandidateFailedModules(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.hasResults(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.Long)arguments[2]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return CandidateMicroserviceLocalServiceUtil.allowedProgrammeScheduleToEnrol(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
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
}