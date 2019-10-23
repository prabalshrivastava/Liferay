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

package com.sambaash.platform.rpec.service.base;

import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gaurav.kapadiya
 * @generated
 */
public class SPRPECLocalServiceClpInvoker {
	public SPRPECLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName21 = "getCompetenceType";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName22 = "getCompetenceSubjects";

		_methodParameterTypes22 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName23 = "notifyByEmail";

		_methodParameterTypes23 = new String[] {  };

		_methodName24 = "getGridData";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName25 = "getElasticsearchData";

		_methodParameterTypes25 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName26 = "getCompetenceSubjectsQuestions";

		_methodParameterTypes26 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName27 = "createRPECRecord";

		_methodParameterTypes27 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName28 = "createRemarks";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName29 = "checkCompetencyProficiency";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName30 = "updateRPECRecord";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName32 = "fetchRPECRemarks";

		_methodParameterTypes32 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName33 = "updateRPECStatus";

		_methodParameterTypes33 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName34 = "getUserType";

		_methodParameterTypes34 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.Long"
			};

		_methodName35 = "exportRowToExcelFile";

		_methodParameterTypes35 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName37 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes37 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName38 = "getMicroserviceModelColumnList";

		_methodParameterTypes38 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName39 = "archiveRecord";

		_methodParameterTypes39 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName40 = "candidateProfile";

		_methodParameterTypes40 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName41 = "getCandidateListOfMentor";

		_methodParameterTypes41 = new String[] { "long", "long" };

		_methodName42 = "getCandidateListOfTp";

		_methodParameterTypes42 = new String[] { "long", "long" };

		_methodName43 = "getCandidateListOfInternalUser";

		_methodParameterTypes43 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPRPECLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPRPECLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPRPECLocalServiceUtil.getCompetenceType((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPRPECLocalServiceUtil.getCompetenceSubjects((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			SPRPECLocalServiceUtil.notifyByEmail();

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPRPECLocalServiceUtil.getGridData((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SPRPECLocalServiceUtil.getElasticsearchData((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SPRPECLocalServiceUtil.getCompetenceSubjectsQuestions((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SPRPECLocalServiceUtil.createRPECRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPRPECLocalServiceUtil.createRemarks((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SPRPECLocalServiceUtil.checkCompetencyProficiency((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SPRPECLocalServiceUtil.updateRPECRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SPRPECLocalServiceUtil.fetchRPECRemarks((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SPRPECLocalServiceUtil.updateRPECStatus((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SPRPECLocalServiceUtil.getUserType((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.Long)arguments[4]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			SPRPECLocalServiceUtil.exportRowToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SPRPECLocalServiceUtil.getMicroserviceModelColumnTitleMap((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SPRPECLocalServiceUtil.getMicroserviceModelColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SPRPECLocalServiceUtil.archiveRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SPRPECLocalServiceUtil.candidateProfile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return SPRPECLocalServiceUtil.getCandidateListOfMentor(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SPRPECLocalServiceUtil.getCandidateListOfTp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return SPRPECLocalServiceUtil.getCandidateListOfInternalUser((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
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
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
}