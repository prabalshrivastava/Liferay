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

package com.sambaash.platform.systemmodelsetup.service.base;

import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

import java.util.Arrays;

/**
 * @author biswo
 * @generated
 */
public class SystemLocalServiceClpInvoker {
	public SystemLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "createRecord";

		_methodParameterTypes20 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName21 = "sendRequest";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName22 = "multiCreateRecord";

		_methodParameterTypes22 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName23 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes23 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName24 = "fetchRecord";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName25 = "fetchRecord";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName26 = "fetchRecordByModelId";

		_methodParameterTypes26 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName27 = "updateRecord";

		_methodParameterTypes27 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName28 = "getMicroserviceModelColumnList";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName29 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName30 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName31 = "convertToAPIModel";

		_methodParameterTypes31 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName32 = "convertToFormModel";

		_methodParameterTypes32 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName33 = "FormIOToModelJSON";

		_methodParameterTypes33 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName35 = "getFormV2Fields";

		_methodParameterTypes35 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName36 = "getListing";

		_methodParameterTypes36 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName37 = "getElasticSearchListing";

		_methodParameterTypes37 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName38 = "getSearchListing";

		_methodParameterTypes38 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName39 = "archiveRecord";

		_methodParameterTypes39 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName40 = "handleFileUpload";

		_methodParameterTypes40 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName41 = "handleBatchUpload";

		_methodParameterTypes41 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName42 = "getFilterColumnHeader";

		_methodParameterTypes42 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName43 = "exportListToExcelFile";

		_methodParameterTypes43 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName44 = "exportRowToExcelFile";

		_methodParameterTypes44 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName46 = "saveExportQuery";

		_methodParameterTypes46 = new String[] {
				"java.lang.String", "java.lang.String",
				"javax.portlet.ResourceRequest"
			};

		_methodName47 = "saveCurrentQuery";

		_methodParameterTypes47 = new String[] {
				"java.lang.String", "javax.portlet.ResourceRequest"
			};

		_methodName48 = "getUserLayoutsOne1";

		_methodParameterTypes48 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName49 = "getUserLayoutsOne";

		_methodParameterTypes49 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName51 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes51 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName52 = "fetchDocumentS3";

		_methodParameterTypes52 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName53 = "getElasticSearchListForModel";

		_methodParameterTypes53 = new String[] { "java.lang.String", "long" };

		_methodName54 = "getElasticSearchListForModel";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName55 = "getElasticSearchListForModel";

		_methodParameterTypes55 = new String[] {
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "int"
			};

		_methodName56 = "fetchEntityLink";

		_methodParameterTypes56 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName57 = "fetchEntityLinkObject";

		_methodParameterTypes57 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName58 = "fetchEntityLink";

		_methodParameterTypes58 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName59 = "addTimelineActivity";

		_methodParameterTypes59 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SystemLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SystemLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SystemLocalServiceUtil.createRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SystemLocalServiceUtil.sendRequest((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SystemLocalServiceUtil.multiCreateRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SystemLocalServiceUtil.fetchElasticRecordsForGenericSearch((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SystemLocalServiceUtil.fetchRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SystemLocalServiceUtil.fetchRecord((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SystemLocalServiceUtil.fetchRecordByModelId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SystemLocalServiceUtil.updateRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SystemLocalServiceUtil.getMicroserviceModelColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SystemLocalServiceUtil.getMicroserviceModelFilterColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SystemLocalServiceUtil.getMicroserviceModelColumnTitleMap((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return SystemLocalServiceUtil.convertToAPIModel((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SystemLocalServiceUtil.convertToFormModel((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SystemLocalServiceUtil.FormIOToModelJSON((javax.portlet.ResourceRequest)arguments[0],
				(com.liferay.portal.kernel.json.JSONObject)arguments[1],
				(com.liferay.portal.kernel.json.JSONObject)arguments[2]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SystemLocalServiceUtil.getFormV2Fields((javax.portlet.ResourceRequest)arguments[0]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SystemLocalServiceUtil.getListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SystemLocalServiceUtil.getElasticSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SystemLocalServiceUtil.getSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SystemLocalServiceUtil.archiveRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			SystemLocalServiceUtil.handleFileUpload((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			SystemLocalServiceUtil.handleBatchUpload((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SystemLocalServiceUtil.getFilterColumnHeader((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			SystemLocalServiceUtil.exportListToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			SystemLocalServiceUtil.exportRowToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			SystemLocalServiceUtil.saveExportQuery((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(javax.portlet.ResourceRequest)arguments[2]);

			return null;
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			SystemLocalServiceUtil.saveCurrentQuery((java.lang.String)arguments[0],
				(javax.portlet.ResourceRequest)arguments[1]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SystemLocalServiceUtil.getUserLayoutsOne1((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return SystemLocalServiceUtil.getUserLayoutsOne((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return SystemLocalServiceUtil.fetchElasticRecordsForGenericSearch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return SystemLocalServiceUtil.fetchDocumentS3((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return SystemLocalServiceUtil.getElasticSearchListForModel((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SystemLocalServiceUtil.getElasticSearchListForModel((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SystemLocalServiceUtil.getElasticSearchListForModel((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SystemLocalServiceUtil.fetchEntityLink((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return SystemLocalServiceUtil.fetchEntityLinkObject((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SystemLocalServiceUtil.fetchEntityLink((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			SystemLocalServiceUtil.addTimelineActivity((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				((Long)arguments[12]).longValue());

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
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
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
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
}