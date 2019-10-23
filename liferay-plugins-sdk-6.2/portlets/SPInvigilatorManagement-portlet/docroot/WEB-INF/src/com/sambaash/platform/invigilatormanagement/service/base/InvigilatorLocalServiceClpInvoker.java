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

package com.sambaash.platform.invigilatormanagement.service.base;

import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Himadri
 * @generated
 */
public class InvigilatorLocalServiceClpInvoker {
	public InvigilatorLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes20 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName21 = "getUniqueList";

		_methodParameterTypes21 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName22 = "getScheduleList";

		_methodParameterTypes22 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName23 = "getPastAppointmentList";

		_methodParameterTypes23 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName24 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName25 = "getFilterColumnHeader";

		_methodParameterTypes25 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName26 = "fetchUpcommingFacilitySchedul";

		_methodParameterTypes26 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName27 = "getGroupNameHeader";

		_methodParameterTypes27 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName28 = "getUniqueData";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName29 = "updateAppointmentStatus";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName30 = "notifyInvigilator";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName33 = "sendNewUserLoginDetailsEmail";

		_methodParameterTypes33 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String"
			};

		_methodName34 = "getPriceScheme";

		_methodParameterTypes34 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			InvigilatorLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getMicroserviceModelFilterColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getUniqueList((javax.portlet.ResourceRequest)arguments[0]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getScheduleList((javax.portlet.ResourceRequest)arguments[0]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getPastAppointmentList((javax.portlet.ResourceRequest)arguments[0]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getMicroserviceModelColumnTitleMap((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getFilterColumnHeader((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return InvigilatorLocalServiceUtil.fetchUpcommingFacilitySchedul((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getGroupNameHeader((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getUniqueData((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return InvigilatorLocalServiceUtil.updateAppointmentStatus((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return InvigilatorLocalServiceUtil.notifyInvigilator((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			InvigilatorLocalServiceUtil.sendNewUserLoginDetailsEmail((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return InvigilatorLocalServiceUtil.getPriceScheme((javax.portlet.ResourceRequest)arguments[0],
				(com.liferay.portal.kernel.json.JSONObject)arguments[1]);
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
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
}