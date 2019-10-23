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

import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailTemplateLocalServiceClpInvoker {
	public SPMailTemplateLocalServiceClpInvoker() {
		_methodName0 = "addSPMailTemplate";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailTemplate"
			};

		_methodName1 = "createSPMailTemplate";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSPMailTemplate";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSPMailTemplate";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailTemplate"
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

		_methodName10 = "fetchSPMailTemplate";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSPMailTemplate";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSPMailTemplates";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSPMailTemplatesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSPMailTemplate";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailTemplate"
			};

		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "addCustomSPMailTemplate";

		_methodParameterTypes78 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailTemplate"
			};

		_methodName79 = "findByparentTempalteId";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "findByStatus";

		_methodParameterTypes80 = new String[] { "boolean" };

		_methodName81 = "getMailMessage";

		_methodParameterTypes81 = new String[] {
				"java.lang.String", "long", "boolean"
			};

		_methodName82 = "getSPMailTemplate";

		_methodParameterTypes82 = new String[] { "java.lang.String", "long" };

		_methodName83 = "getTemplates";

		_methodParameterTypes83 = new String[] {  };

		_methodName84 = "getTemplateByName";

		_methodParameterTypes84 = new String[] { "java.lang.String" };

		_methodName85 = "getTemplateByName";

		_methodParameterTypes85 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName86 = "sendAdHocEmaills";

		_methodParameterTypes86 = new String[] { "java.lang.String", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.addSPMailTemplate((com.sambaash.platform.srv.mail.model.SPMailTemplate)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.createSPMailTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.deleteSPMailTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.deleteSPMailTemplate((com.sambaash.platform.srv.mail.model.SPMailTemplate)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.fetchSPMailTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getSPMailTemplate(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getSPMailTemplates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getSPMailTemplatesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.updateSPMailTemplate((com.sambaash.platform.srv.mail.model.SPMailTemplate)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			SPMailTemplateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			SPMailTemplateLocalServiceUtil.addCustomSPMailTemplate((com.sambaash.platform.srv.mail.model.SPMailTemplate)arguments[0]);

			return null;
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.findByparentTempalteId(((Long)arguments[0]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.findByStatus(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getMailMessage((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getSPMailTemplate((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getTemplates();
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getTemplateByName((java.lang.String)arguments[0]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SPMailTemplateLocalServiceUtil.getTemplateByName(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			SPMailTemplateLocalServiceUtil.sendAdHocEmaills((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
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
}