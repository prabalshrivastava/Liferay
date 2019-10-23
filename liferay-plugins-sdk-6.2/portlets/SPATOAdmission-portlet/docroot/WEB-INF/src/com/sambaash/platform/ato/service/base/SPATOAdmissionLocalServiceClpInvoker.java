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

package com.sambaash.platform.ato.service.base;

import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author keyur.kalariya
 * @generated
 */
public class SPATOAdmissionLocalServiceClpInvoker {
	public SPATOAdmissionLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "getListOfComponent";

		_methodParameterTypes20 = new String[] {
				"java.lang.Long", "java.lang.String"
			};

		_methodName21 = "handleBatchUploadFile";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ActionRequest", "javax.portlet.ActionResponse",
				"java.lang.String"
			};

		_methodName22 = "getSPListParamVal";

		_methodParameterTypes22 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName23 = "getSPListParamId";

		_methodParameterTypes23 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName24 = "convertToAPIModel";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName25 = "convertToFormModel";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName26 = "FormIOToModelJSON";

		_methodParameterTypes26 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName28 = "getMicroserviceModelColumnList";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName29 = "archiveRecord";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName30 = "scannedDataRecord";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName31 = "changeProcessStatus";

		_methodParameterTypes31 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName32 = "exportPdf";

		_methodParameterTypes32 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName33 = "sendInvoice";

		_methodParameterTypes33 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName34 = "sendInvoiceToCantidate";

		_methodParameterTypes34 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName35 = "isATO";

		_methodParameterTypes35 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName36 = "getUserType";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.Long"
			};

		_methodName37 = "getAtoName";

		_methodParameterTypes37 = new String[] {
				"java.lang.String", "java.lang.Long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPATOAdmissionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getListOfComponent((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.handleBatchUploadFile((javax.portlet.ActionRequest)arguments[0],
				(javax.portlet.ActionResponse)arguments[1],
				(java.lang.String)arguments[2]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getSPListParamVal((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getSPListParamId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.convertToAPIModel((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.convertToFormModel((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.FormIOToModelJSON((javax.portlet.ResourceRequest)arguments[0],
				(com.liferay.portal.kernel.json.JSONObject)arguments[1],
				(com.liferay.portal.kernel.json.JSONObject)arguments[2]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getMicroserviceModelColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.archiveRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.scannedDataRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.changeProcessStatus((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			SPATOAdmissionLocalServiceUtil.exportPdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.sendInvoice((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.sendInvoiceToCantidate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.isATO((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getUserType((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.Long)arguments[2]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SPATOAdmissionLocalServiceUtil.getAtoName((java.lang.String)arguments[0],
				(java.lang.Long)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
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
}