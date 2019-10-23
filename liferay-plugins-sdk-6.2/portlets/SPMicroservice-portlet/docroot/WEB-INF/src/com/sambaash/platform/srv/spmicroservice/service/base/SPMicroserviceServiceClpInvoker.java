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

import com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil;

import java.util.Arrays;

/**
 * @author glenn
 * @generated
 */
public class SPMicroserviceServiceClpInvoker {
	public SPMicroserviceServiceClpInvoker() {
		_methodName28 = "getBeanIdentifier";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "setBeanIdentifier";

		_methodParameterTypes29 = new String[] { "java.lang.String" };

		_methodName32 = "fetchListOptionByName";

		_methodParameterTypes32 = new String[] { "boolean", "java.lang.String[][]" };

		_methodName33 = "fetchRuleSetTypes";

		_methodParameterTypes33 = new String[] { "boolean" };

		_methodName34 = "getRuleSetListing";

		_methodParameterTypes34 = new String[] { "boolean" };

		_methodName35 = "getProcessRuleSets";

		_methodParameterTypes35 = new String[] { "boolean", "java.lang.String" };

		_methodName36 = "saveRuleSet";

		_methodParameterTypes36 = new String[] { "java.lang.String" };

		_methodName37 = "getRuleSet";

		_methodParameterTypes37 = new String[] { "java.lang.Long" };

		_methodName38 = "getFormListing";

		_methodParameterTypes38 = new String[] {  };

		_methodName39 = "getForm";

		_methodParameterTypes39 = new String[] { "long" };

		_methodName40 = "getFormFields";

		_methodParameterTypes40 = new String[] { "long", "boolean", "boolean" };

		_methodName41 = "addFormEvent";

		_methodParameterTypes41 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName42 = "getVocabularyCategories";

		_methodParameterTypes42 = new String[] { "long", "int", "int" };

		_methodName43 = "validateCandidate";

		_methodParameterTypes43 = new String[] { "long", "java.lang.String" };

		_methodName44 = "getPostalAddress";

		_methodParameterTypes44 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName46 = "retrieveCandidateProgrammePath";

		_methodParameterTypes46 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName47 = "getCandidateAllowedModules";

		_methodParameterTypes47 = new String[] {
				"long", "java.lang.Long", "java.lang.String"
			};

		_methodName48 = "getCandidateSchedule";

		_methodParameterTypes48 = new String[] { "long", "java.lang.Long" };

		_methodName49 = "getCandidateFailedModules";

		_methodParameterTypes49 = new String[] {
				"long", "java.lang.Long", "java.lang.String"
			};

		_methodName50 = "hasResults";

		_methodParameterTypes50 = new String[] {
				"long", "java.lang.String", "java.lang.Long"
			};

		_methodName51 = "isPaidInvoice";

		_methodParameterTypes51 = new String[] { "long", "java.lang.String" };

		_methodName52 = "updateContentJson";

		_methodParameterTypes52 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName53 = "allowedProgrammeScheduleToEnrol";

		_methodParameterTypes53 = new String[] { "long", "java.lang.Long" };

		_methodName54 = "validateBatchSwitchEnrolmentIds";

		_methodParameterTypes54 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPMicroserviceServiceUtil.getBeanIdentifier();
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			SPMicroserviceServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SPMicroserviceServiceUtil.fetchListOptionByName(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String[])arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SPMicroserviceServiceUtil.fetchRuleSetTypes(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SPMicroserviceServiceUtil.getRuleSetListing(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SPMicroserviceServiceUtil.getProcessRuleSets(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SPMicroserviceServiceUtil.saveRuleSet((java.lang.String)arguments[0]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SPMicroserviceServiceUtil.getRuleSet((java.lang.Long)arguments[0]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SPMicroserviceServiceUtil.getFormListing();
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SPMicroserviceServiceUtil.getForm(((Long)arguments[0]).longValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SPMicroserviceServiceUtil.getFormFields(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			SPMicroserviceServiceUtil.addFormEvent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SPMicroserviceServiceUtil.getVocabularyCategories(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return SPMicroserviceServiceUtil.validateCandidate(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return SPMicroserviceServiceUtil.getPostalAddress((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return SPMicroserviceServiceUtil.retrieveCandidateProgrammePath(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return SPMicroserviceServiceUtil.getCandidateAllowedModules(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SPMicroserviceServiceUtil.getCandidateSchedule(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return SPMicroserviceServiceUtil.getCandidateFailedModules(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return SPMicroserviceServiceUtil.hasResults(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.Long)arguments[2]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return SPMicroserviceServiceUtil.isPaidInvoice(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return SPMicroserviceServiceUtil.updateContentJson(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return SPMicroserviceServiceUtil.allowedProgrammeScheduleToEnrol(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SPMicroserviceServiceUtil.validateBatchSwitchEnrolmentIds(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
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
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
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
}