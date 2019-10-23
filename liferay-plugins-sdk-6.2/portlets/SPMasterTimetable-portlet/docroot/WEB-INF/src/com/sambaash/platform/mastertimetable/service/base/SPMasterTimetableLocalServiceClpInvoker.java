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

package com.sambaash.platform.mastertimetable.service.base;

import com.sambaash.platform.mastertimetable.service.SPMasterTimetableLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gaurav.kapadiya
 * @generated
 */
public class SPMasterTimetableLocalServiceClpInvoker {
	public SPMasterTimetableLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "getFilterColumnHeader";

		_methodParameterTypes20 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName21 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName22 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes22 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName23 = "getElasticSearchListing";

		_methodParameterTypes23 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName26 = "saveCurrentQuery";

		_methodParameterTypes26 = new String[] {
				"java.lang.String", "javax.portlet.ResourceRequest"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPMasterTimetableLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPMasterTimetableLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SPMasterTimetableLocalServiceUtil.getFilterColumnHeader((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPMasterTimetableLocalServiceUtil.getMicroserviceModelFilterColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPMasterTimetableLocalServiceUtil.getMicroserviceModelColumnTitleMap((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SPMasterTimetableLocalServiceUtil.getElasticSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			SPMasterTimetableLocalServiceUtil.saveCurrentQuery((java.lang.String)arguments[0],
				(javax.portlet.ResourceRequest)arguments[1]);

			return null;
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
	private String _methodName26;
	private String[] _methodParameterTypes26;
}