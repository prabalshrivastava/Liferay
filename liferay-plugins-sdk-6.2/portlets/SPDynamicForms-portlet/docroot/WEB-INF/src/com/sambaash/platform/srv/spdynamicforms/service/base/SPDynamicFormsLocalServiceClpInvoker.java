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

package com.sambaash.platform.srv.spdynamicforms.service.base;

import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author glenn
 * @generated
 */
public class SPDynamicFormsLocalServiceClpInvoker {
	public SPDynamicFormsLocalServiceClpInvoker() {
		_methodName24 = "getBeanIdentifier";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "setBeanIdentifier";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName28 = "retrieveLoadParam";

		_methodParameterTypes28 = new String[] { "javax.portlet.RenderRequest" };

		_methodName29 = "handleLoadData";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName30 = "handlePersist";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName31 = "persistFormJsonData";

		_methodParameterTypes31 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long",
				"java.lang.Long", "com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName32 = "handlePersist";

		_methodParameterTypes32 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName35 = "handleFileUpload";

		_methodParameterTypes35 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPDynamicFormsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			SPDynamicFormsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPDynamicFormsLocalServiceUtil.retrieveLoadParam((javax.portlet.RenderRequest)arguments[0]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			SPDynamicFormsLocalServiceUtil.handleLoadData((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			SPDynamicFormsLocalServiceUtil.handlePersist((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return SPDynamicFormsLocalServiceUtil.persistFormJsonData((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue(), (java.lang.Long)arguments[2],
				(com.liferay.portal.kernel.json.JSONObject)arguments[3]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SPDynamicFormsLocalServiceUtil.handlePersist(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			SPDynamicFormsLocalServiceUtil.handleFileUpload((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName35;
	private String[] _methodParameterTypes35;
}