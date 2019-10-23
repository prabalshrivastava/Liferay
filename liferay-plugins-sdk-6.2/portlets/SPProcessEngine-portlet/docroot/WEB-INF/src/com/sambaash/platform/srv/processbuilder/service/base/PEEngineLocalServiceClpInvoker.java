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

package com.sambaash.platform.srv.processbuilder.service.base;

import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;

import java.util.Arrays;

/**
 * @author nareshchebolu
 * @generated
 */
public class PEEngineLocalServiceClpInvoker {
	public PEEngineLocalServiceClpInvoker() {
		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName66 = "getStatusString";

		_methodParameterTypes66 = new String[] { "long", "long", "long", "long" };

		_methodName67 = "getStatusString";

		_methodParameterTypes67 = new String[] { "long" };

		_methodName68 = "runProcessEngineUsingEsignPackagId";

		_methodParameterTypes68 = new String[] { "java.lang.String" };

		_methodName69 = "runProcessEngineUsingFormId";

		_methodParameterTypes69 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.util.Map"
			};

		_methodName70 = "runProcessEngineUsingFormIdWithException";

		_methodParameterTypes70 = new String[] {
				"javax.portlet.PortletRequest", "long", "long", "long", "long",
				"java.lang.String", "java.util.Map"
			};

		_methodName71 = "runProcessEngineProductApp";

		_methodParameterTypes71 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName72 = "submitApplciaiton";

		_methodParameterTypes72 = new String[] {
				"com.sambaash.platform.pe.PESubmitAppRequest"
			};

		_methodName73 = "submitApplicationV2";

		_methodParameterTypes73 = new String[] {
				"com.sambaash.platform.pe.v2.PESubmitAppRequestV2"
			};

		_methodName76 = "getFirstFormIdToLoad";

		_methodParameterTypes76 = new String[] { "long" };

		_methodName77 = "isAgent";

		_methodParameterTypes77 = new String[] {
				"com.liferay.portal.model.User", "long"
			};

		_methodName78 = "isSupervisor";

		_methodParameterTypes78 = new String[] {
				"com.liferay.portal.model.User", "long"
			};

		_methodName79 = "addExtraParamsToFormUrl";

		_methodParameterTypes79 = new String[] {
				"boolean", "com.liferay.portal.model.User", "long",
				"java.lang.String"
			};

		_methodName80 = "getNonDealStageIds";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "getDealStageIds";

		_methodParameterTypes81 = new String[] {  };

		_methodName82 = "getLeadProcessId";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "getOpportunityProcessIds";

		_methodParameterTypes83 = new String[] {  };

		_methodName84 = "toLong";

		_methodParameterTypes84 = new String[] { "java.lang.String[][]" };

		_methodName85 = "isOpenApplication";

		_methodParameterTypes85 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName86 = "isRejectedApplicaiton";

		_methodParameterTypes86 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName87 = "isActiveApplicaiton";

		_methodParameterTypes87 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName88 = "isConvertedToOtherApplication";

		_methodParameterTypes88 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName89 = "getApplicationDisplayUrl";

		_methodParameterTypes89 = new String[] {
				"com.liferay.portal.model.User", "long",
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName90 = "getApplicationDisplayFriendlyUrl";

		_methodParameterTypes90 = new String[] {
				"com.liferay.portal.model.User", "long",
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName91 = "getPeEntity";

		_methodParameterTypes91 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return PEEngineLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			PEEngineLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return PEEngineLocalServiceUtil.getStatusString(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return PEEngineLocalServiceUtil.getStatusString(((Long)arguments[0]).longValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			PEEngineLocalServiceUtil.runProcessEngineUsingEsignPackagId((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return PEEngineLocalServiceUtil.runProcessEngineUsingFormId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				(java.util.Map<java.lang.String, java.lang.String[]>)arguments[5]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return PEEngineLocalServiceUtil.runProcessEngineUsingFormIdWithException((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				(java.util.Map<java.lang.String, java.lang.String[]>)arguments[6]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			PEEngineLocalServiceUtil.runProcessEngineProductApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return PEEngineLocalServiceUtil.submitApplciaiton((com.sambaash.platform.pe.PESubmitAppRequest)arguments[0]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return PEEngineLocalServiceUtil.submitApplicationV2((com.sambaash.platform.pe.v2.PESubmitAppRequestV2)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return PEEngineLocalServiceUtil.getFirstFormIdToLoad(((Long)arguments[0]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return PEEngineLocalServiceUtil.isAgent((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return PEEngineLocalServiceUtil.isSupervisor((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return PEEngineLocalServiceUtil.addExtraParamsToFormUrl(((Boolean)arguments[0]).booleanValue(),
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return PEEngineLocalServiceUtil.getNonDealStageIds();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return PEEngineLocalServiceUtil.getDealStageIds();
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return PEEngineLocalServiceUtil.getLeadProcessId();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return PEEngineLocalServiceUtil.getOpportunityProcessIds();
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return PEEngineLocalServiceUtil.toLong((java.lang.String[])arguments[0]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return PEEngineLocalServiceUtil.isOpenApplication((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return PEEngineLocalServiceUtil.isRejectedApplicaiton((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return PEEngineLocalServiceUtil.isActiveApplicaiton((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return PEEngineLocalServiceUtil.isConvertedToOtherApplication((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return PEEngineLocalServiceUtil.getApplicationDisplayUrl((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.theme.ThemeDisplay)arguments[2]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return PEEngineLocalServiceUtil.getApplicationDisplayFriendlyUrl((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.theme.ThemeDisplay)arguments[2]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return PEEngineLocalServiceUtil.getPeEntity(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
}