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

package com.sambaash.platform.srv.result.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author sunil.sharma
 * @generated
 */
public class SPResultLocalServiceClp implements SPResultLocalService {
	public SPResultLocalServiceClp(InvokableLocalService invokableLocalService) {
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

		_methodName7 = "updateRecord";

		_methodParameterTypes7 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName8 = "getMicroserviceModelColumnList";

		_methodParameterTypes8 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName9 = "getMicroserviceModelFilterColumnList";

		_methodParameterTypes9 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName10 = "getMicroserviceModelColumnTitleMap";

		_methodParameterTypes10 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName11 = "convertToAPIModel";

		_methodParameterTypes11 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String",
				"java.lang.String"
			};

		_methodName12 = "convertToFormModel";

		_methodParameterTypes12 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName13 = "FormIOToModelJSON";

		_methodParameterTypes13 = new String[] {
				"javax.portlet.ResourceRequest",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName14 = "getFormV2Fields";

		_methodParameterTypes14 = new String[] { "javax.portlet.ResourceRequest" };

		_methodName15 = "getListing";

		_methodParameterTypes15 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName16 = "getElasticSearchListing";

		_methodParameterTypes16 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName17 = "getSearchListing";

		_methodParameterTypes17 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName18 = "archiveRecord";

		_methodParameterTypes18 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName19 = "handleFileUpload";

		_methodParameterTypes19 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName20 = "filterDistinct";

		_methodParameterTypes20 = new String[] {
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName21 = "getFilterColumnHeader";

		_methodParameterTypes21 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName22 = "exportListToExcelFile";

		_methodParameterTypes22 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName23 = "exportRowToExcelFile";

		_methodParameterTypes23 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName24 = "saveExportQuery";

		_methodParameterTypes24 = new String[] {
				"java.lang.String", "java.lang.String",
				"javax.portlet.ResourceRequest"
			};

		_methodName25 = "saveCurrentQuery";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "javax.portlet.ResourceRequest"
			};

		_methodName26 = "getUserLayoutsOne";

		_methodParameterTypes26 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName27 = "fetchElasticRecordsForGenericSearch";

		_methodParameterTypes27 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName28 = "fetchDocumentS3";

		_methodParameterTypes28 = new String[] {
				"javax.portlet.ResourceRequest", "java.lang.String"
			};

		_methodName29 = "getElasticSearchListForModel";

		_methodParameterTypes29 = new String[] { "java.lang.String", "long" };

		_methodName30 = "generateReferenceNumber";

		_methodParameterTypes30 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName31 = "saveTransactionData";

		_methodParameterTypes31 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName32 = "isSubmitter";

		_methodParameterTypes32 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName33 = "isApprover";

		_methodParameterTypes33 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName34 = "exportPdf";

		_methodParameterTypes34 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName35 = "exportTranscript";

		_methodParameterTypes35 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName36 = "processRecord";

		_methodParameterTypes36 = new String[] {
				"javax.portlet.ResourceRequest",
				"javax.portlet.ResourceResponse"
			};

		_methodName37 = "getCategoryMap";

		_methodParameterTypes37 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName38 = "getTransactionTypeMap";

		_methodParameterTypes38 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName39 = "getClientTypeMap";

		_methodParameterTypes39 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName40 = "getFunctionalComponentMap";

		_methodParameterTypes40 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName41 = "getProductTypeMap";

		_methodParameterTypes41 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName42 = "getProductSubTypeMap";

		_methodParameterTypes42 = new String[] {
				"javax.servlet.http.HttpServletRequest"
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
	public java.lang.String updateRecord(
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
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
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
	public java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
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
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
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
	public java.lang.String getElasticSearchListing(
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
	public java.lang.String getSearchListing(
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
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18,
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
			_invokableLocalService.invokeMethod(_methodName19,
				_methodParameterTypes19,
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
	public com.liferay.portal.kernel.json.JSONObject filterDistinct(
		com.liferay.portal.kernel.json.JSONObject distinct) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] { ClpSerializer.translateInput(distinct) });
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
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
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
			_invokableLocalService.invokeMethod(_methodName22,
				_methodParameterTypes22,
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
			_invokableLocalService.invokeMethod(_methodName23,
				_methodParameterTypes23,
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
			_invokableLocalService.invokeMethod(_methodName24,
				_methodParameterTypes24,
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
			_invokableLocalService.invokeMethod(_methodName25,
				_methodParameterTypes25,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
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
		java.lang.String source, java.lang.String txnType,
		java.lang.String title, java.lang.String description,
		java.lang.String dueDate, java.lang.String valueDate,
		java.lang.String creditDate, java.lang.String transactionDetailJson) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(productType),
						
					ClpSerializer.translateInput(productSubType),
						
					ClpSerializer.translateInput(functionalComponent),
						
					ClpSerializer.translateInput(categoryType),
						
					ClpSerializer.translateInput(clientType),
						
					ClpSerializer.translateInput(txnDate),
						
					ClpSerializer.translateInput(source),
						
					ClpSerializer.translateInput(txnType),
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(description),
						
					ClpSerializer.translateInput(dueDate),
						
					ClpSerializer.translateInput(valueDate),
						
					ClpSerializer.translateInput(creditDate),
						
					ClpSerializer.translateInput(transactionDetailJson)
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
	public boolean isSubmitter(javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
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

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean isApprover(javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
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

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
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
	public java.lang.String exportTranscript(java.lang.String programCode,
		java.lang.String candidateNumber) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						ClpSerializer.translateInput(programCode),
						
					ClpSerializer.translateInput(candidateNumber)
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
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
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
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
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
}