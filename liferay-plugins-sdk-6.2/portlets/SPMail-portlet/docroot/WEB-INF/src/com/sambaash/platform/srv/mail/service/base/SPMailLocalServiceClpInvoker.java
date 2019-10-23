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

import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailLocalServiceClpInvoker {
	public SPMailLocalServiceClpInvoker() {
		_methodName56 = "getBeanIdentifier";

		_methodParameterTypes56 = new String[] {  };

		_methodName57 = "setBeanIdentifier";

		_methodParameterTypes57 = new String[] { "java.lang.String" };

		_methodName60 = "appendTracker";

		_methodParameterTypes60 = new String[] { "java.lang.String" };

		_methodName61 = "decryptLink";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName62 = "encryptLink";

		_methodParameterTypes62 = new String[] { "java.lang.String" };

		_methodName63 = "getLinksFromHtml";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName64 = "getMailBody";

		_methodParameterTypes64 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign", "int"
			};

		_methodName65 = "getMailSubject";

		_methodParameterTypes65 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign", "int"
			};

		_methodName66 = "getProcessedContent";

		_methodParameterTypes66 = new String[] {
				"java.lang.String",
				"com.sambaash.platform.srv.mail.model.SPMailCampaign", "long",
				"long"
			};

		_methodName67 = "getWebversion";

		_methodParameterTypes67 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers"
			};

		_methodName68 = "processMailBodyParameters";

		_methodParameterTypes68 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers",
				"java.lang.String", "java.lang.String"
			};

		_methodName69 = "processMailBodyParameters";

		_methodParameterTypes69 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers",
				"java.lang.String", "java.lang.String", "boolean"
			};

		_methodName70 = "sendMail";

		_methodParameterTypes70 = new String[] {
				"com.sambaash.platform.model.MailMessage"
			};

		_methodName71 = "sendMail";

		_methodParameterTypes71 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers",
				"java.util.List", "long", "boolean"
			};

		_methodName72 = "testTemplate";

		_methodParameterTypes72 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SPMailLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			SPMailLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SPMailLocalServiceUtil.appendTracker((java.lang.String)arguments[0]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SPMailLocalServiceUtil.decryptLink((java.lang.String)arguments[0]);
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SPMailLocalServiceUtil.encryptLink((java.lang.String)arguments[0]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SPMailLocalServiceUtil.getLinksFromHtml((java.lang.String)arguments[0]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SPMailLocalServiceUtil.getMailBody((com.sambaash.platform.srv.mail.model.SPMailCampaign)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SPMailLocalServiceUtil.getMailSubject((com.sambaash.platform.srv.mail.model.SPMailCampaign)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SPMailLocalServiceUtil.getProcessedContent((java.lang.String)arguments[0],
				(com.sambaash.platform.srv.mail.model.SPMailCampaign)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return SPMailLocalServiceUtil.getWebversion((com.sambaash.platform.srv.mail.model.SPMailCampaign)arguments[0],
				(com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[1]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return SPMailLocalServiceUtil.processMailBodyParameters((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SPMailLocalServiceUtil.processMailBodyParameters((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				((Boolean)arguments[6]).booleanValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return SPMailLocalServiceUtil.sendMail((com.sambaash.platform.model.MailMessage)arguments[0]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SPMailLocalServiceUtil.sendMail((com.sambaash.platform.srv.mail.model.SPMailCampaign)arguments[0],
				(com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[1],
				(java.util.List<com.liferay.mail.model.FileAttachment>)arguments[2],
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			SPMailLocalServiceUtil.testTemplate(((Long)arguments[0]).longValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
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
}