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

package com.sambaash.platform.srv.result.service.base;

import com.sambaash.platform.srv.result.service.SPResultLocalServiceUtil;

import java.util.Arrays;

/**
 * @author sunil.sharma
 * @generated
 */
public class SPResultLocalServiceClpInvoker {
	public SPResultLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "createRecord";

		_methodParameterTypes20 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName21 = "multiCreateRecord";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName22 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes22 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName23 = "fetchRecord";

		_methodParameterTypes23 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName24 = "updateRecord";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName25 = "getMicroserviceModelColumnList";

		_methodParameterTypes25 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName26 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes26 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName27 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes27 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName28 = "convertToAPIModel";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName29 = "convertToFormModel";

		_methodParameterTypes29 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName30 = "FormIOToModelJSON";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName32 = "getFormV2Fields";

		_methodParameterTypes32 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName33 = "getListing";

		_methodParameterTypes33 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName41 = "getElasticSearchListing";

		_methodParameterTypes41 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName44 = "getSearchListing";

		_methodParameterTypes44 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName45 = "archiveRecord";

		_methodParameterTypes45 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName46 = "handleFileUpload";

		_methodParameterTypes46 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName47 = "filterDistinct";

		_methodParameterTypes47 = new String[] {
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName48 = "getFilterColumnHeader";

		_methodParameterTypes48 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName50 = "exportListToExcelFile";

		_methodParameterTypes50 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName51 = "exportRowToExcelFile";

		_methodParameterTypes51 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName53 = "saveExportQuery";

		_methodParameterTypes53 = new String[] {
				"java.lang.String", "java.lang.String",
				"javax.portlet.ResourceRequest"
			};

		_methodName54 = "saveCurrentQuery";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "javax.portlet.ResourceRequest"
			};

		_methodName55 = "getUserLayoutsOne";

		_methodParameterTypes55 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName59 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes59 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName60 = "fetchDocumentS3";

		_methodParameterTypes60 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName61 = "getElasticSearchListForModel";

		_methodParameterTypes61 = new String[] { "java.lang.String", "long" };

		_methodName62 = "generateReferenceNumber";

		_methodParameterTypes62 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName65 = "saveTransactionData";

		_methodParameterTypes65 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName66 = "isSubmitter";

		_methodParameterTypes66 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName67 = "isApprover";

		_methodParameterTypes67 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName68 = "exportPdf";

		_methodParameterTypes68 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName69 = "exportTranscript";

		_methodParameterTypes69 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName71 = "processRecord";

		_methodParameterTypes71 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName72 = "getCategoryMap";

		_methodParameterTypes72 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName73 = "getTransactionTypeMap";

		_methodParameterTypes73 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName74 = "getClientTypeMap";

		_methodParameterTypes74 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName75 = "getFunctionalComponentMap";

		_methodParameterTypes75 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName76 = "getProductTypeMap";

		_methodParameterTypes76 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName77 = "getProductSubTypeMap";

		_methodParameterTypes77 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPResultLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPResultLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SPResultLocalServiceUtil.createRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPResultLocalServiceUtil.multiCreateRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPResultLocalServiceUtil.fetchElasticRecordsForGenericSearch((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SPResultLocalServiceUtil.fetchRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPResultLocalServiceUtil.updateRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SPResultLocalServiceUtil.getMicroserviceModelColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SPResultLocalServiceUtil.getMicroserviceModelFilterColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SPResultLocalServiceUtil.getMicroserviceModelColumnTitleMap((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPResultLocalServiceUtil.convertToAPIModel((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SPResultLocalServiceUtil.convertToFormModel((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SPResultLocalServiceUtil.FormIOToModelJSON((javax.portlet.ResourceRequest)arguments[0],
				(com.liferay.portal.kernel.json.JSONObject)arguments[1],
				(com.liferay.portal.kernel.json.JSONObject)arguments[2]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SPResultLocalServiceUtil.getFormV2Fields((javax.portlet.ResourceRequest)arguments[0]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SPResultLocalServiceUtil.getListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return SPResultLocalServiceUtil.getElasticSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return SPResultLocalServiceUtil.getSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return SPResultLocalServiceUtil.archiveRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			SPResultLocalServiceUtil.handleFileUpload((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return SPResultLocalServiceUtil.filterDistinct((com.liferay.portal.kernel.json.JSONObject)arguments[0]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SPResultLocalServiceUtil.getFilterColumnHeader((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			SPResultLocalServiceUtil.exportListToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			SPResultLocalServiceUtil.exportRowToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			SPResultLocalServiceUtil.saveExportQuery((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(javax.portlet.ResourceRequest)arguments[2]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			SPResultLocalServiceUtil.saveCurrentQuery((java.lang.String)arguments[0],
				(javax.portlet.ResourceRequest)arguments[1]);

			return null;
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SPResultLocalServiceUtil.getUserLayoutsOne((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SPResultLocalServiceUtil.fetchElasticRecordsForGenericSearch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SPResultLocalServiceUtil.fetchDocumentS3((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SPResultLocalServiceUtil.getElasticSearchListForModel((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SPResultLocalServiceUtil.generateReferenceNumber(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SPResultLocalServiceUtil.saveTransactionData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13], (java.lang.String)arguments[14]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SPResultLocalServiceUtil.isSubmitter((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return SPResultLocalServiceUtil.isApprover((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			SPResultLocalServiceUtil.exportPdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SPResultLocalServiceUtil.exportTranscript((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SPResultLocalServiceUtil.processRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SPResultLocalServiceUtil.getCategoryMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SPResultLocalServiceUtil.getTransactionTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SPResultLocalServiceUtil.getClientTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SPResultLocalServiceUtil.getFunctionalComponentMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SPResultLocalServiceUtil.getProductTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SPResultLocalServiceUtil.getProductSubTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
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
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
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
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
}