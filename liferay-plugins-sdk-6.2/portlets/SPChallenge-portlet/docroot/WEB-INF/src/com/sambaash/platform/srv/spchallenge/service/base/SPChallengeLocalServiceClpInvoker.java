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

package com.sambaash.platform.srv.spchallenge.service.base;

import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author pradeep
 * @generated
 */
public class SPChallengeLocalServiceClpInvoker {
	public SPChallengeLocalServiceClpInvoker() {
		_methodName0 = "addSPChallenge";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spchallenge.model.SPChallenge"
			};

		_methodName1 = "createSPChallenge";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSPChallenge";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSPChallenge";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spchallenge.model.SPChallenge"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSPChallenge";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchSPChallengeByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchSPChallengeByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getSPChallenge";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getSPChallengeByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getSPChallengeByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getSPChallenges";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getSPChallengesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateSPChallenge";

		_methodParameterTypes19 = new String[] {
				"com.sambaash.platform.srv.spchallenge.model.SPChallenge"
			};

		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName68 = "updateAssets";

		_methodParameterTypes68 = new String[] {
				"long",
				"com.sambaash.platform.srv.spchallenge.model.SPChallenge",
				"long[][]"
			};

		_methodName69 = "getChallenges";

		_methodParameterTypes69 = new String[] {
				"javax.portlet.PortletRequest", "long", "int", "int",
				"java.lang.String", "boolean"
			};

		_methodName70 = "searchChallenges";

		_methodParameterTypes70 = new String[] {
				"javax.portlet.PortletRequest", "long", "int", "int",
				"java.lang.String", "boolean"
			};

		_methodName71 = "searchChallenges";

		_methodParameterTypes71 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName72 = "displayChallengeFriendlyURL";

		_methodParameterTypes72 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName73 = "applyChallengeFriendlyURL";

		_methodParameterTypes73 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long", "boolean"
			};

		_methodName74 = "editChallengeFriendlyURL";

		_methodParameterTypes74 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName75 = "addChallengeFriendlyURL";

		_methodParameterTypes75 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName76 = "addAllChallengesToGraph";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "canUpdateChallenge";

		_methodParameterTypes77 = new String[] {
				"javax.portlet.PortletRequest", "long"
			};

		_methodName78 = "displayApplicationFriendlyURL";

		_methodParameterTypes78 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName79 = "editApplicationFriendlyURL";

		_methodParameterTypes79 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName80 = "getChallengesPath";

		_methodParameterTypes80 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SPChallengeLocalServiceUtil.addSPChallenge((com.sambaash.platform.srv.spchallenge.model.SPChallenge)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SPChallengeLocalServiceUtil.createSPChallenge(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SPChallengeLocalServiceUtil.deleteSPChallenge(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SPChallengeLocalServiceUtil.deleteSPChallenge((com.sambaash.platform.srv.spchallenge.model.SPChallenge)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SPChallengeLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SPChallengeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SPChallengeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SPChallengeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SPChallengeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SPChallengeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SPChallengeLocalServiceUtil.fetchSPChallenge(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SPChallengeLocalServiceUtil.fetchSPChallengeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SPChallengeLocalServiceUtil.fetchSPChallengeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getSPChallenge(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getSPChallengeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getSPChallengeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getSPChallenges(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getSPChallengesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return SPChallengeLocalServiceUtil.updateSPChallenge((com.sambaash.platform.srv.spchallenge.model.SPChallenge)arguments[0]);
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			SPChallengeLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			SPChallengeLocalServiceUtil.updateAssets(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.spchallenge.model.SPChallenge)arguments[1],
				(long[])arguments[2]);

			return null;
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getChallenges((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return SPChallengeLocalServiceUtil.searchChallenges((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SPChallengeLocalServiceUtil.searchChallenges((com.liferay.portal.kernel.search.SearchContext)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SPChallengeLocalServiceUtil.displayChallengeFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SPChallengeLocalServiceUtil.applyChallengeFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SPChallengeLocalServiceUtil.editChallengeFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SPChallengeLocalServiceUtil.addChallengeFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			SPChallengeLocalServiceUtil.addAllChallengesToGraph();

			return null;
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SPChallengeLocalServiceUtil.canUpdateChallenge((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SPChallengeLocalServiceUtil.displayApplicationFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SPChallengeLocalServiceUtil.editApplicationFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SPChallengeLocalServiceUtil.getChallengesPath();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
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
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
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
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
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
}