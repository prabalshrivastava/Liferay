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

package com.sambaash.platform.srv.genericupload.service.base;

import com.sambaash.platform.srv.genericupload.service.BatchUploadLocalServiceUtil;

import java.util.Arrays;

/**
 * @author biswo
 * @generated
 */
public class BatchUploadLocalServiceClpInvoker {
	public BatchUploadLocalServiceClpInvoker() {
		_methodName14 = "getBeanIdentifier";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "setBeanIdentifier";

		_methodParameterTypes15 = new String[] { "java.lang.String" };

		_methodName18 = "handleBatchUpload";

		_methodParameterTypes18 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName19 = "handleBatchUploadFile";

		_methodParameterTypes19 = new String[] {
				"javax.portlet.ActionRequest", "javax.portlet.ActionResponse"
			};

		_methodName20 = "getCellValue";

		_methodParameterTypes20 = new String[] {
				"org.apache.poi.ss.usermodel.Cell"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BatchUploadLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			BatchUploadLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			BatchUploadLocalServiceUtil.handleBatchUpload((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return BatchUploadLocalServiceUtil.handleBatchUploadFile((javax.portlet.ActionRequest)arguments[0],
				(javax.portlet.ActionResponse)arguments[1]);
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return BatchUploadLocalServiceUtil.getCellValue((org.apache.poi.ss.usermodel.Cell)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
}