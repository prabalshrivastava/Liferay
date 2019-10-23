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

package com.sambaash.platform.finance.service.base;

import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author abhishek.upadhyay
 * @generated
 */
public class SPFinanceLocalServiceClpInvoker {
	public SPFinanceLocalServiceClpInvoker() {
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

		_methodName24 = "fetchInvoiceReceipt";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName25 = "fetchOrganizationIds";

		_methodParameterTypes25 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName26 = "getReportPdfData";

		_methodParameterTypes26 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName27 = "getCreditDetailByUserId";

		_methodParameterTypes27 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName28 = "fetchTodayRecord";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName29 = "checkLOR";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName30 = "invoiceFilter";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName32 = "fetchMiscFeeSchemeList";

		_methodParameterTypes32 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName33 = "fetchReportType";

		_methodParameterTypes33 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName34 = "getRefundMiscFees";

		_methodParameterTypes34 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName35 = "updateRecord";

		_methodParameterTypes35 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName36 = "getMicroserviceModelColumnList";

		_methodParameterTypes36 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName37 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes37 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName38 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes38 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName39 = "getMicroserviceModelColumnTitleMapNew";

		_methodParameterTypes39 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName40 = "convertToAPIModel";

		_methodParameterTypes40 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName41 = "convertToFormModel";

		_methodParameterTypes41 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName42 = "FormIOToModelJSON";

		_methodParameterTypes42 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName43 = "convertToReportData";

		_methodParameterTypes43 = new String[] { "java.lang.String" };

		_methodName49 = "getFormV2Fields";

		_methodParameterTypes49 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName50 = "getListing";

		_methodParameterTypes50 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName59 = "getElasticSearchListing";

		_methodParameterTypes59 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName60 = "searchAdmissionRecords";

		_methodParameterTypes60 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String[][]"
			};

		_methodName63 = "getSearchListing";

		_methodParameterTypes63 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName64 = "archiveRecord";

		_methodParameterTypes64 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName65 = "handleFileUpload";

		_methodParameterTypes65 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName66 = "getFilterColumnHeader";

		_methodParameterTypes66 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName68 = "exportListToExcelFile";

		_methodParameterTypes68 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName69 = "exportPaymentAdvicePdf";

		_methodParameterTypes69 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName70 = "exportPaymentAdviceExcel";

		_methodParameterTypes70 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName71 = "exportRowToExcelFile";

		_methodParameterTypes71 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName73 = "saveExportQuery";

		_methodParameterTypes73 = new String[] {
				"java.lang.String", "java.lang.String",
				"javax.portlet.ResourceRequest"
			};

		_methodName74 = "saveCurrentQuery";

		_methodParameterTypes74 = new String[] {
				"java.lang.String", "javax.portlet.ResourceRequest"
			};

		_methodName75 = "getUserLayoutsOne";

		_methodParameterTypes75 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName79 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes79 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName80 = "fetchDocumentS3";

		_methodParameterTypes80 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName81 = "getElasticSearchListForModel";

		_methodParameterTypes81 = new String[] { "java.lang.String", "long" };

		_methodName82 = "generateReferenceNumber";

		_methodParameterTypes82 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName86 = "saveTransactionData";

		_methodParameterTypes86 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName87 = "saveCreditBalance";

		_methodParameterTypes87 = new String[] {
				"long", "java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName88 = "checkRole";

		_methodParameterTypes88 = new String[] {
				"javax.servlet.http.HttpServletRequest", "java.lang.String"
			};

		_methodName89 = "downloadPdfFromServer";

		_methodParameterTypes89 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName90 = "preparePdf";

		_methodParameterTypes90 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName91 = "preparePdf";

		_methodParameterTypes91 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse", "java.lang.String"
			};

		_methodName92 = "prepareLorPdf";

		_methodParameterTypes92 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName95 = "processRecord";

		_methodParameterTypes95 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName96 = "processWorkFlow";

		_methodParameterTypes96 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName97 = "generateReport";

		_methodParameterTypes97 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName98 = "generateReportZip";

		_methodParameterTypes98 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName99 = "getCategoryMap";

		_methodParameterTypes99 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName100 = "getCategoryMap";

		_methodParameterTypes100 = new String[] { "long" };

		_methodName101 = "getClaimMap";

		_methodParameterTypes101 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName102 = "getTransactionTypeMap";

		_methodParameterTypes102 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName103 = "getClientTypeMap";

		_methodParameterTypes103 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName104 = "getFunctionalComponentMap";

		_methodParameterTypes104 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName105 = "getFunctionalComponentDisplayMap";

		_methodParameterTypes105 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName106 = "getProductTypeMap";

		_methodParameterTypes106 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName107 = "getProductSubTypeMap";

		_methodParameterTypes107 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName108 = "getSpListTypeMap";

		_methodParameterTypes108 = new String[] {
				"java.lang.String", "javax.servlet.http.HttpServletRequest"
			};

		_methodName109 = "getSpListTypeIdToDisplayName";

		_methodParameterTypes109 = new String[] {
				"java.lang.String", "javax.servlet.http.HttpServletRequest"
			};

		_methodName110 = "stripeCharge";

		_methodParameterTypes110 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName111 = "getWalletAmount";

		_methodParameterTypes111 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName112 = "getWalletListing";

		_methodParameterTypes112 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName113 = "autoCloseCounter";

		_methodParameterTypes113 = new String[] {  };

		_methodName114 = "generateLorReport";

		_methodParameterTypes114 = new String[] { "java.lang.String" };

		_methodName115 = "getGroupIds";

		_methodParameterTypes115 = new String[] {  };

		_methodName116 = "getScopeGroupId";

		_methodParameterTypes116 = new String[] { "java.lang.Long" };

		_methodName117 = "getUploadedFileUrl";

		_methodParameterTypes117 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName118 = "prepareDccPdf";

		_methodParameterTypes118 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName120 = "checkUserRoles";

		_methodParameterTypes120 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName121 = "handlePendingAmendmentsClaimNotification";

		_methodParameterTypes121 = new String[] {
				"boolean", "boolean", "boolean", "com.liferay.portal.model.User",
				"java.util.List", "com.liferay.portal.theme.ThemeDisplay",
				"java.lang.String"
			};

		_methodName122 = "handleRejectedClaimNotification";

		_methodParameterTypes122 = new String[] {
				"boolean", "boolean", "boolean", "com.liferay.portal.model.User",
				"java.util.List", "com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName123 = "handlePendingApprovalClaimNotification";

		_methodParameterTypes123 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.util.List",
				"boolean"
			};

		_methodName124 = "handleApprovedClaimNotification";

		_methodParameterTypes124 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.util.List",
				"boolean", "com.liferay.portal.model.User"
			};

		_methodName125 = "getUsersByRoles";

		_methodParameterTypes125 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.lang.String"
			};

		_methodName126 = "sendSubmittedClaimNotifications";

		_methodParameterTypes126 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName127 = "sendEmailNotification";

		_methodParameterTypes127 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.lang.String",
				"java.lang.String", "java.util.Map"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPFinanceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SPFinanceLocalServiceUtil.createRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPFinanceLocalServiceUtil.multiCreateRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchElasticRecordsForGenericSearch((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchInvoiceReceipt((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchOrganizationIds((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getReportPdfData((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getCreditDetailByUserId((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchTodayRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SPFinanceLocalServiceUtil.checkLOR((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SPFinanceLocalServiceUtil.invoiceFilter((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchMiscFeeSchemeList((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchReportType((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getRefundMiscFees((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SPFinanceLocalServiceUtil.updateRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getMicroserviceModelColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getMicroserviceModelFilterColumnList((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getMicroserviceModelColumnTitleMap((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getMicroserviceModelColumnTitleMapNew((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SPFinanceLocalServiceUtil.convertToAPIModel((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return SPFinanceLocalServiceUtil.convertToFormModel((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SPFinanceLocalServiceUtil.FormIOToModelJSON((javax.portlet.ResourceRequest)arguments[0],
				(com.liferay.portal.kernel.json.JSONObject)arguments[1],
				(com.liferay.portal.kernel.json.JSONObject)arguments[2]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return SPFinanceLocalServiceUtil.convertToReportData((java.lang.String)arguments[0]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getFormV2Fields((javax.portlet.ResourceRequest)arguments[0]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getElasticSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SPFinanceLocalServiceUtil.searchAdmissionRecords((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String[])arguments[1]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getSearchListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SPFinanceLocalServiceUtil.archiveRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			SPFinanceLocalServiceUtil.handleFileUpload((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getFilterColumnHeader((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			SPFinanceLocalServiceUtil.exportListToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SPFinanceLocalServiceUtil.exportPaymentAdvicePdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			SPFinanceLocalServiceUtil.exportPaymentAdviceExcel((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			SPFinanceLocalServiceUtil.exportRowToExcelFile((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			SPFinanceLocalServiceUtil.saveExportQuery((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(javax.portlet.ResourceRequest)arguments[2]);

			return null;
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			SPFinanceLocalServiceUtil.saveCurrentQuery((java.lang.String)arguments[0],
				(javax.portlet.ResourceRequest)arguments[1]);

			return null;
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getUserLayoutsOne((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchElasticRecordsForGenericSearch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SPFinanceLocalServiceUtil.fetchDocumentS3((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getElasticSearchListForModel((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SPFinanceLocalServiceUtil.generateReferenceNumber(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SPFinanceLocalServiceUtil.saveTransactionData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15], (java.lang.String)arguments[16]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SPFinanceLocalServiceUtil.saveCreditBalance(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return SPFinanceLocalServiceUtil.checkRole((javax.servlet.http.HttpServletRequest)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			SPFinanceLocalServiceUtil.downloadPdfFromServer((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return SPFinanceLocalServiceUtil.preparePdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return SPFinanceLocalServiceUtil.preparePdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1],
				(java.lang.String)arguments[2]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return SPFinanceLocalServiceUtil.prepareLorPdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return SPFinanceLocalServiceUtil.processRecord((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return SPFinanceLocalServiceUtil.processWorkFlow((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return SPFinanceLocalServiceUtil.generateReport((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			SPFinanceLocalServiceUtil.generateReportZip((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);

			return null;
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getCategoryMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getCategoryMap(((Long)arguments[0]).longValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getClaimMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getTransactionTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getClientTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getFunctionalComponentMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getProductTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getProductSubTypeMap((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getSpListTypeMap((java.lang.String)arguments[0],
				(javax.servlet.http.HttpServletRequest)arguments[1]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getSpListTypeIdToDisplayName((java.lang.String)arguments[0],
				(javax.servlet.http.HttpServletRequest)arguments[1]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return SPFinanceLocalServiceUtil.stripeCharge((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getWalletAmount((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getWalletListing((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return SPFinanceLocalServiceUtil.autoCloseCounter();
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return SPFinanceLocalServiceUtil.generateLorReport((java.lang.String)arguments[0]);
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getGroupIds();
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getScopeGroupId((java.lang.Long)arguments[0]);
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getUploadedFileUrl((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return SPFinanceLocalServiceUtil.prepareDccPdf((javax.portlet.ResourceRequest)arguments[0],
				(javax.portlet.ResourceResponse)arguments[1]);
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return SPFinanceLocalServiceUtil.checkUserRoles((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			SPFinanceLocalServiceUtil.handlePendingAmendmentsClaimNotification(((Boolean)arguments[0]).booleanValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue(),
				(com.liferay.portal.model.User)arguments[3],
				(java.util.List<java.util.List<java.lang.Object>>)arguments[4],
				(com.liferay.portal.theme.ThemeDisplay)arguments[5],
				(java.lang.String)arguments[6]);

			return null;
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			SPFinanceLocalServiceUtil.handleRejectedClaimNotification(((Boolean)arguments[0]).booleanValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue(),
				(com.liferay.portal.model.User)arguments[3],
				(java.util.List<java.util.List<java.lang.Object>>)arguments[4],
				(com.liferay.portal.theme.ThemeDisplay)arguments[5]);

			return null;
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			SPFinanceLocalServiceUtil.handlePendingApprovalClaimNotification((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				(java.util.List<java.util.List<java.lang.Object>>)arguments[1],
				((Boolean)arguments[2]).booleanValue());

			return null;
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			SPFinanceLocalServiceUtil.handleApprovedClaimNotification((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				(java.util.List<java.util.List<java.lang.Object>>)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				(com.liferay.portal.model.User)arguments[3]);

			return null;
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return SPFinanceLocalServiceUtil.getUsersByRoles((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			SPFinanceLocalServiceUtil.sendSubmittedClaimNotifications((javax.portlet.ResourceRequest)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			SPFinanceLocalServiceUtil.sendEmailNotification((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.util.Map<java.lang.String, java.lang.String>)arguments[3]);

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
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
}