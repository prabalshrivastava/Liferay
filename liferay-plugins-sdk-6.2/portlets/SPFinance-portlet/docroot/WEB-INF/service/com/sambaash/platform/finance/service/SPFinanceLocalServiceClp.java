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

package com.sambaash.platform.finance.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author abhishek.upadhyay
 * @generated
 */
public class SPFinanceLocalServiceClp implements SPFinanceLocalService {
	public SPFinanceLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "createRecord";

		_methodParameterTypes3 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName4 = "multiCreateRecord";

		_methodParameterTypes4 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName5 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes5 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName6 = "fetchRecord";

		_methodParameterTypes6 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName7 = "fetchInvoiceReceipt";

		_methodParameterTypes7 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName8 = "fetchOrganizationIds";

		_methodParameterTypes8 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName9 = "getReportPdfData";

		_methodParameterTypes9 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName10 = "getCreditDetailByUserId";

		_methodParameterTypes10 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName11 = "fetchTodayRecord";

		_methodParameterTypes11 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName12 = "checkLOR";

		_methodParameterTypes12 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName13 = "invoiceFilter";

		_methodParameterTypes13 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName14 = "fetchMiscFeeSchemeList";

		_methodParameterTypes14 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName15 = "fetchReportType";

		_methodParameterTypes15 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName16 = "getRefundMiscFees";

		_methodParameterTypes16 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName17 = "updateRecord";

		_methodParameterTypes17 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName18 = "getMicroserviceModelColumnList";

		_methodParameterTypes18 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName19 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes19 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName20 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes20 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName21 = "getMicroserviceModelColumnTitleMapNew";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName22 = "convertToAPIModel";

		_methodParameterTypes22 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName23 = "convertToFormModel";

		_methodParameterTypes23 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName24 = "FormIOToModelJSON";

		_methodParameterTypes24 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName25 = "convertToReportData";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName26 = "getFormV2Fields";

		_methodParameterTypes26 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName27 = "getListing";

		_methodParameterTypes27 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName28 = "getElasticSearchListing";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName29 = "searchAdmissionRecords";

		_methodParameterTypes29 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String[][]"
			};

		_methodName30 = "getSearchListing";

		_methodParameterTypes30 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName31 = "archiveRecord";

		_methodParameterTypes31 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName32 = "handleFileUpload";

		_methodParameterTypes32 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName33 = "getFilterColumnHeader";

		_methodParameterTypes33 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName34 = "exportListToExcelFile";

		_methodParameterTypes34 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName35 = "exportPaymentAdvicePdf";

		_methodParameterTypes35 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName36 = "exportPaymentAdviceExcel";

		_methodParameterTypes36 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName37 = "exportRowToExcelFile";

		_methodParameterTypes37 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName38 = "saveExportQuery";

		_methodParameterTypes38 = new String[] {
				"java.lang.String", "java.lang.String",
				"javax.portlet.ResourceRequest"
			};

		_methodName39 = "saveCurrentQuery";

		_methodParameterTypes39 = new String[] {
				"java.lang.String", "javax.portlet.ResourceRequest"
			};

		_methodName40 = "getUserLayoutsOne";

		_methodParameterTypes40 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName41 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes41 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName42 = "fetchDocumentS3";

		_methodParameterTypes42 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName43 = "getElasticSearchListForModel";

		_methodParameterTypes43 = new String[] { "java.lang.String", "long" };

		_methodName44 = "generateReferenceNumber";

		_methodParameterTypes44 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName45 = "saveTransactionData";

		_methodParameterTypes45 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName46 = "saveCreditBalance";

		_methodParameterTypes46 = new String[] {
				"long", "java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName47 = "checkRole";

		_methodParameterTypes47 = new String[] {
				"javax.servlet.http.HttpServletRequest", "java.lang.String"
			};

		_methodName48 = "downloadPdfFromServer";

		_methodParameterTypes48 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName49 = "preparePdf";

		_methodParameterTypes49 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName50 = "preparePdf";

		_methodParameterTypes50 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse", "java.lang.String"
			};

		_methodName51 = "prepareLorPdf";

		_methodParameterTypes51 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName52 = "processRecord";

		_methodParameterTypes52 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName53 = "processWorkFlow";

		_methodParameterTypes53 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName54 = "generateReport";

		_methodParameterTypes54 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName55 = "generateReportZip";

		_methodParameterTypes55 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName56 = "getCategoryMap";

		_methodParameterTypes56 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName57 = "getCategoryMap";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "getClaimMap";

		_methodParameterTypes58 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName59 = "getTransactionTypeMap";

		_methodParameterTypes59 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName60 = "getClientTypeMap";

		_methodParameterTypes60 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName61 = "getFunctionalComponentMap";

		_methodParameterTypes61 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName62 = "getFunctionalComponentDisplayMap";

		_methodParameterTypes62 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName63 = "getProductTypeMap";

		_methodParameterTypes63 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName64 = "getProductSubTypeMap";

		_methodParameterTypes64 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName65 = "getSpListTypeMap";

		_methodParameterTypes65 = new String[] {
				"java.lang.String", "javax.servlet.http.HttpServletRequest"
			};

		_methodName66 = "getSpListTypeIdToDisplayName";

		_methodParameterTypes66 = new String[] {
				"java.lang.String", "javax.servlet.http.HttpServletRequest"
			};

		_methodName67 = "stripeCharge";

		_methodParameterTypes67 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName68 = "getWalletAmount";

		_methodParameterTypes68 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName69 = "getWalletListing";

		_methodParameterTypes69 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName70 = "autoCloseCounter";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "generateLorReport";

		_methodParameterTypes71 = new String[] { "java.lang.String" };

		_methodName72 = "getGroupIds";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "getScopeGroupId";

		_methodParameterTypes73 = new String[] { "java.lang.Long" };

		_methodName74 = "getUploadedFileUrl";

		_methodParameterTypes74 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName75 = "prepareDccPdf";

		_methodParameterTypes75 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName76 = "checkUserRoles";

		_methodParameterTypes76 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName77 = "handlePendingAmendmentsClaimNotification";

		_methodParameterTypes77 = new String[] {
				"boolean", "boolean", "boolean", "com.liferay.portal.model.User",
				"java.util.List", "com.liferay.portal.theme.ThemeDisplay",
				"java.lang.String"
			};

		_methodName78 = "handleRejectedClaimNotification";

		_methodParameterTypes78 = new String[] {
				"boolean", "boolean", "boolean", "com.liferay.portal.model.User",
				"java.util.List", "com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName79 = "handlePendingApprovalClaimNotification";

		_methodParameterTypes79 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.util.List",
				"boolean"
			};

		_methodName80 = "handleApprovedClaimNotification";

		_methodParameterTypes80 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.util.List",
				"boolean", "com.liferay.portal.model.User"
			};

		_methodName81 = "getUsersByRoles";

		_methodParameterTypes81 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.lang.String"
			};

		_methodName82 = "sendSubmittedClaimNotifications";

		_methodParameterTypes82 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName83 = "sendEmailNotification";

		_methodParameterTypes83 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "java.lang.String",
				"java.lang.String", "java.util.Map"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String multiCreateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String jsonElasticSearchQuery, java.lang.String subUrl) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(jsonElasticSearchQuery),
						
					ClpSerializer.translateInput(subUrl)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchInvoiceReceipt(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchOrganizationIds(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getReportPdfData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getCreditDetailByUserId(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchTodayRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String checkLOR(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String invoiceFilter(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchMiscFeeSchemeList(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchReportType(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getRefundMiscFees(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(modelName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(modelName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(modelName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getMicroserviceModelColumnTitleMapNew(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(modelName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(modelData),
						
					ClpSerializer.translateInput(existingData)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						ClpSerializer.translateInput(existingData),
						
					ClpSerializer.translateInput(modelName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(inp),
						
					ClpSerializer.translateInput(jsonModelExistingData)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject convertToReportData(
		java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] { ClpSerializer.translateInput(existingData) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] { ClpSerializer.translateInput(resourceRequest) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String searchAdmissionRecords(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String[] transactionCodes) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(transactionCodes)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		try {
			_invokableLocalService.invokeMethod(_methodName32,
				_methodParameterTypes32,
				new Object[] {
					ClpSerializer.translateInput(request),
					
				ClpSerializer.translateInput(response)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		try {
			_invokableLocalService.invokeMethod(_methodName34,
				_methodParameterTypes34,
				new Object[] {
					ClpSerializer.translateInput(resourceRequest),
					
				ClpSerializer.translateInput(resourceResponse)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String exportPaymentAdvicePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void exportPaymentAdviceExcel(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		try {
			_invokableLocalService.invokeMethod(_methodName36,
				_methodParameterTypes36,
				new Object[] {
					ClpSerializer.translateInput(resourceRequest),
					
				ClpSerializer.translateInput(resourceResponse)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		try {
			_invokableLocalService.invokeMethod(_methodName37,
				_methodParameterTypes37,
				new Object[] {
					ClpSerializer.translateInput(resourceRequest),
					
				ClpSerializer.translateInput(resourceResponse)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException {
		try {
			_invokableLocalService.invokeMethod(_methodName38,
				_methodParameterTypes38,
				new Object[] {
					ClpSerializer.translateInput(querytype),
					
				ClpSerializer.translateInput(pageModelData),
					
				ClpSerializer.translateInput(resourceRequest)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		try {
			_invokableLocalService.invokeMethod(_methodName39,
				_methodParameterTypes39,
				new Object[] {
					ClpSerializer.translateInput(query),
					
				ClpSerializer.translateInput(resourceRequest)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.Map<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { ClpSerializer.translateInput(themeDisplay) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(long userId,
		long scopeId, java.lang.String jsonElasticSearchQuery,
		java.lang.String subUrl) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] {
						userId,
						
					scopeId,
						
					ClpSerializer.translateInput(jsonElasticSearchQuery),
						
					ClpSerializer.translateInput(subUrl)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(fileName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] { ClpSerializer.translateInput(model), siteId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(productType),
						
					ClpSerializer.translateInput(productSubType),
						
					ClpSerializer.translateInput(functionalComponent),
						
					ClpSerializer.translateInput(categoryType),
						
					ClpSerializer.translateInput(clientType)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String componentRefNumber,
		java.lang.String txnType, java.lang.String title,
		java.lang.String description, java.lang.String dueDate,
		java.lang.String valueDate, java.lang.String creditDate,
		java.lang.String transactionDetailJson,
		java.lang.String paymentDetailJson) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(productType),
						
					ClpSerializer.translateInput(productSubType),
						
					ClpSerializer.translateInput(functionalComponent),
						
					ClpSerializer.translateInput(categoryType),
						
					ClpSerializer.translateInput(clientType),
						
					ClpSerializer.translateInput(txnDate),
						
					ClpSerializer.translateInput(source),
						
					ClpSerializer.translateInput(componentRefNumber),
						
					ClpSerializer.translateInput(txnType),
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(description),
						
					ClpSerializer.translateInput(dueDate),
						
					ClpSerializer.translateInput(valueDate),
						
					ClpSerializer.translateInput(creditDate),
						
					ClpSerializer.translateInput(transactionDetailJson),
						
					ClpSerializer.translateInput(paymentDetailJson)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String saveCreditBalance(long scopeGroupId,
		java.lang.Long creditBalanceAmt, java.lang.String status,
		java.lang.String usereId, java.lang.String userName,
		java.lang.String userType) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(creditBalanceAmt),
						
					ClpSerializer.translateInput(status),
						
					ClpSerializer.translateInput(usereId),
						
					ClpSerializer.translateInput(userName),
						
					ClpSerializer.translateInput(userType)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean checkRole(javax.servlet.http.HttpServletRequest request,
		java.lang.String role) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] {
						ClpSerializer.translateInput(request),
						
					ClpSerializer.translateInput(role)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void downloadPdfFromServer(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		try {
			_invokableLocalService.invokeMethod(_methodName48,
				_methodParameterTypes48,
				new Object[] {
					ClpSerializer.translateInput(resourceRequest),
					
				ClpSerializer.translateInput(resourceResponse)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String preparePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String preparePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse, java.lang.String data) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse),
						
					ClpSerializer.translateInput(data)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String prepareLorPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName52,
					_methodParameterTypes52,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String processWorkFlow(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String generateReport(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName54,
					_methodParameterTypes54,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void generateReportZip(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		try {
			_invokableLocalService.invokeMethod(_methodName55,
				_methodParameterTypes55,
				new Object[] {
					ClpSerializer.translateInput(resourceRequest),
					
				ClpSerializer.translateInput(resourceResponse)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName56,
					_methodParameterTypes56,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		long scopeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName57,
					_methodParameterTypes57, new Object[] { scopeId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getClaimMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName58,
					_methodParameterTypes58,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getTransactionTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName59,
					_methodParameterTypes59,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getClientTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName60,
					_methodParameterTypes60,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName61,
					_methodParameterTypes61,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentDisplayMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName62,
					_methodParameterTypes62,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getProductTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName63,
					_methodParameterTypes63,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getProductSubTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName64,
					_methodParameterTypes64,
					new Object[] { ClpSerializer.translateInput(request) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getSpListTypeMap(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName65,
					_methodParameterTypes65,
					new Object[] {
						ClpSerializer.translateInput(key),
						
					ClpSerializer.translateInput(request)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.Long, java.lang.String> getSpListTypeIdToDisplayName(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName66,
					_methodParameterTypes66,
					new Object[] {
						ClpSerializer.translateInput(key),
						
					ClpSerializer.translateInput(request)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.Long, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String stripeCharge(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName67,
					_methodParameterTypes67,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getWalletAmount(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName68,
					_methodParameterTypes68,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getWalletListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName69,
					_methodParameterTypes69,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String autoCloseCounter() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName70,
					_methodParameterTypes70, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String generateLorReport(java.lang.String groupIds) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName71,
					_methodParameterTypes71,
					new Object[] { ClpSerializer.translateInput(groupIds) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getGroupIds() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName72,
					_methodParameterTypes72, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long getScopeGroupId(java.lang.Long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName73,
					_methodParameterTypes73,
					new Object[] { ClpSerializer.translateInput(siteId) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public java.lang.String getUploadedFileUrl(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName74,
					_methodParameterTypes74,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String prepareDccPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName75,
					_methodParameterTypes75,
					new Object[] {
						ClpSerializer.translateInput(resourceRequest),
						
					ClpSerializer.translateInput(resourceResponse)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean[] checkUserRoles(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName76,
					_methodParameterTypes76,
					new Object[] { ClpSerializer.translateInput(themeDisplay) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (boolean[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void handlePendingAmendmentsClaimNotification(boolean submitter,
		boolean verifier, boolean approver,
		com.liferay.portal.model.User invigilatorUser,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		com.liferay.portal.theme.ThemeDisplay themeDisplay, java.lang.String ws) {
		try {
			_invokableLocalService.invokeMethod(_methodName77,
				_methodParameterTypes77,
				new Object[] {
					submitter,
					
				verifier,
					
				approver,
					
				ClpSerializer.translateInput(invigilatorUser),
					
				ClpSerializer.translateInput(notifyData),
					
				ClpSerializer.translateInput(themeDisplay),
					
				ClpSerializer.translateInput(ws)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void handleRejectedClaimNotification(boolean submitter,
		boolean verifier, boolean approver,
		com.liferay.portal.model.User invigilatorUser,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		try {
			_invokableLocalService.invokeMethod(_methodName78,
				_methodParameterTypes78,
				new Object[] {
					submitter,
					
				verifier,
					
				approver,
					
				ClpSerializer.translateInput(invigilatorUser),
					
				ClpSerializer.translateInput(notifyData),
					
				ClpSerializer.translateInput(themeDisplay)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void handlePendingApprovalClaimNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		boolean verifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName79,
				_methodParameterTypes79,
				new Object[] {
					ClpSerializer.translateInput(themeDisplay),
					
				ClpSerializer.translateInput(notifyData),
					
				verifier
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void handleApprovedClaimNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		boolean approver, com.liferay.portal.model.User invigilatorUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName80,
				_methodParameterTypes80,
				new Object[] {
					ClpSerializer.translateInput(themeDisplay),
					
				ClpSerializer.translateInput(notifyData),
					
				approver,
					
				ClpSerializer.translateInput(invigilatorUser)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersByRoles(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String roleParam) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName81,
					_methodParameterTypes81,
					new Object[] {
						ClpSerializer.translateInput(themeDisplay),
						
					ClpSerializer.translateInput(roleParam)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.model.User>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void sendSubmittedClaimNotifications(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String inputData, java.lang.String response) {
		try {
			_invokableLocalService.invokeMethod(_methodName82,
				_methodParameterTypes82,
				new Object[] {
					ClpSerializer.translateInput(resourceRequest),
					
				ClpSerializer.translateInput(inputData),
					
				ClpSerializer.translateInput(response)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void sendEmailNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String toAddress, java.lang.String templateName,
		java.util.Map<java.lang.String, java.lang.String> params) {
		try {
			_invokableLocalService.invokeMethod(_methodName83,
				_methodParameterTypes83,
				new Object[] {
					ClpSerializer.translateInput(themeDisplay),
					
				ClpSerializer.translateInput(toAddress),
					
				ClpSerializer.translateInput(templateName),
					
				ClpSerializer.translateInput(params)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
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
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
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
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
}