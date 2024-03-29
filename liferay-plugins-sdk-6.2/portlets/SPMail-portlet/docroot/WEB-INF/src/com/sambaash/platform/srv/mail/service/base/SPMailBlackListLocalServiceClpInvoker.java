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

package com.sambaash.platform.srv.mail.service.base;

import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailBlackListLocalServiceClpInvoker {
	public SPMailBlackListLocalServiceClpInvoker() {
		_methodName0 = "addSPMailBlackList";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailBlackList"
			};

		_methodName1 = "createSPMailBlackList";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSPMailBlackList";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSPMailBlackList";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailBlackList"
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

		_methodName10 = "fetchSPMailBlackList";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSPMailBlackList";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSPMailBlackLists";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSPMailBlackListsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSPMailBlackList";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailBlackList"
			};

		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "addBounce";

		_methodParameterTypes78 = new String[] {
				"java.lang.String", "com.sambaash.platform.model.aws.Message"
			};

		_methodName79 = "addComplaint";

		_methodParameterTypes79 = new String[] {
				"java.lang.String", "com.sambaash.platform.model.aws.Message"
			};

		_methodName80 = "countByCampaignIdAndBounced";

		_methodParameterTypes80 = new String[] { "long", "boolean" };

		_methodName81 = "countByCampaignIdAndBouncedSoft";

		_methodParameterTypes81 = new String[] { "long", "boolean" };

		_methodName82 = "countByCampaignIdAndComplain";

		_methodParameterTypes82 = new String[] { "long", "boolean" };

		_methodName83 = "findByCampaignId";

		_methodParameterTypes83 = new String[] { "long" };

		_methodName84 = "findByCampaignIdAndBounced";

		_methodParameterTypes84 = new String[] { "long", "boolean" };

		_methodName85 = "findByCampaignIdAndBouncedSoft";

		_methodParameterTypes85 = new String[] { "long", "boolean" };

		_methodName86 = "findByCampaignIdAndComplain";

		_methodParameterTypes86 = new String[] { "long", "boolean" };

		_methodName87 = "findByEmailAddress";

		_methodParameterTypes87 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.addSPMailBlackList((com.sambaash.platform.srv.mail.model.SPMailBlackList)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.createSPMailBlackList(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.deleteSPMailBlackList(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.deleteSPMailBlackList((com.sambaash.platform.srv.mail.model.SPMailBlackList)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.fetchSPMailBlackList(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.getSPMailBlackList(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.getSPMailBlackLists(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.getSPMailBlackListsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.updateSPMailBlackList((com.sambaash.platform.srv.mail.model.SPMailBlackList)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			SPMailBlackListLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			SPMailBlackListLocalServiceUtil.addBounce((java.lang.String)arguments[0],
				(com.sambaash.platform.model.aws.Message)arguments[1]);

			return null;
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			SPMailBlackListLocalServiceUtil.addComplaint((java.lang.String)arguments[0],
				(com.sambaash.platform.model.aws.Message)arguments[1]);

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.countByCampaignIdAndBounced(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.countByCampaignIdAndBouncedSoft(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.countByCampaignIdAndComplain(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.findByCampaignId(((Long)arguments[0]).longValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.findByCampaignIdAndBounced(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.findByCampaignIdAndBouncedSoft(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.findByCampaignIdAndComplain(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SPMailBlackListLocalServiceUtil.findByEmailAddress((java.lang.String)arguments[0]);
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
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
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
}