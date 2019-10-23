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

import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author glenn
 * @generated
 */
public class RulesMicroserviceLocalServiceClpInvoker {
	public RulesMicroserviceLocalServiceClpInvoker() {
		_methodName28 = "getBeanIdentifier";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "setBeanIdentifier";

		_methodParameterTypes29 = new String[] { "java.lang.String" };

		_methodName32 = "fetchRuleSetTypes";

		_methodParameterTypes32 = new String[] { "boolean" };

		_methodName33 = "fetchListOptionByName";

		_methodParameterTypes33 = new String[] { "boolean", "java.lang.String[][]" };

		_methodName34 = "getRuleSetListing";

		_methodParameterTypes34 = new String[] { "boolean" };

		_methodName35 = "getPERuleSets";

		_methodParameterTypes35 = new String[] { "boolean", "java.lang.String" };

		_methodName36 = "getRuleSet";

		_methodParameterTypes36 = new String[] { "java.lang.Long" };

		_methodName37 = "deleteRuleSet";

		_methodParameterTypes37 = new String[] { "java.lang.Long" };

		_methodName38 = "evaluateRuleSet";

		_methodParameterTypes38 = new String[] {
				"long", "com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName39 = "saveRuleSet";

		_methodParameterTypes39 = new String[] {
				"com.liferay.portal.kernel.json.JSONObject"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			RulesMicroserviceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.fetchRuleSetTypes(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.fetchListOptionByName(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String[])arguments[1]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.getRuleSetListing(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.getPERuleSets(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.getRuleSet((java.lang.Long)arguments[0]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.deleteRuleSet((java.lang.Long)arguments[0]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.evaluateRuleSet(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.json.JSONObject)arguments[1]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return RulesMicroserviceLocalServiceUtil.saveRuleSet((com.liferay.portal.kernel.json.JSONObject)arguments[0]);
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
}