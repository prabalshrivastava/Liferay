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

package com.sambaash.platform.srv.spmicroservice.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author glenn
 * @generated
 */
public class PricingMicroserviceLocalServiceClp
	implements PricingMicroserviceLocalService {
	public PricingMicroserviceLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getPricing";

		_methodParameterTypes3 = new String[] {
				"long",
				"com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto"
			};

		_methodName4 = "getPEPriceSchemeLOV";

		_methodParameterTypes4 = new String[] { "long" };

		_methodName5 = "getPEPriceSubSchemeLOV";

		_methodParameterTypes5 = new String[] { "long", "java.lang.String" };

		_methodName6 = "getPEPriceSchemeDetails";

		_methodParameterTypes6 = new String[] { "long", "java.lang.String" };

		_methodName7 = "createPEInvoice";

		_methodParameterTypes7 = new String[] {
				"long", "long", "long", "long", "java.lang.Double",
				"java.lang.String", "long", "long",
				"com.liferay.portal.kernel.json.JSONArray", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName8 = "getUserFees";

		_methodParameterTypes8 = new String[] {
				"long", "long", "java.lang.String", "boolean",
				"java.lang.String", "boolean"
			};

		_methodName9 = "getTransactionFees";

		_methodParameterTypes9 = new String[] {
				"long", "boolean", "java.util.List"
			};

		_methodName10 = "publishStripeEvent";

		_methodParameterTypes10 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName11 = "computeSchemeFees";

		_methodParameterTypes11 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};

		_methodName12 = "computeCandidateSchemeFees";

		_methodParameterTypes12 = new String[] {
				"long", "java.lang.String", "java.lang.String", "java.util.List"
			};

		_methodName13 = "retrieveTransactionStatus";

		_methodParameterTypes13 = new String[] { "long", "java.util.List" };

		_methodName14 = "retrievePEProgrammePriceSchemeByScheduleAndModule";

		_methodParameterTypes14 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName15 = "isPaidInvoice";

		_methodParameterTypes15 = new String[] { "long", "java.lang.String" };
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
	public com.liferay.portal.kernel.json.JSONArray getPricing(
		long scopeGroupId,
		com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto inputDto) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(inputDto)
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeLOV(
		long scopeGroupId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] { scopeGroupId });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSubSchemeLOV(
		long scopeGroupId, java.lang.String priceSchemeCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(priceSchemeCode)
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeDetails(
		long scopeGroupId, java.lang.String priceSchemeCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(priceSchemeCode)
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject createPEInvoice(
		long scopeGroupId, long processStateId, long processAuditId,
		long applicantId, java.lang.Double amount, java.lang.String currency,
		long productTypeId, long productSubTypeId,
		com.liferay.portal.kernel.json.JSONArray feeDetails,
		java.lang.String applicantName, java.lang.String title,
		java.lang.String description) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						scopeGroupId,
						
					processStateId,
						
					processAuditId,
						
					applicantId,
						
					ClpSerializer.translateInput(amount),
						
					ClpSerializer.translateInput(currency),
						
					productTypeId,
						
					productSubTypeId,
						
					ClpSerializer.translateInput(feeDetails),
						
					ClpSerializer.translateInput(applicantName),
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(description)
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
	public com.liferay.portal.kernel.json.JSONObject getUserFees(
		long scopeGroupId, long userId, java.lang.String componentRef,
		boolean includeOutstanding, java.lang.String consolidateSourceId,
		boolean fullInfo) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						scopeGroupId,
						
					userId,
						
					ClpSerializer.translateInput(componentRef),
						
					includeOutstanding,
						
					ClpSerializer.translateInput(consolidateSourceId),
						
					fullInfo
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
	public com.liferay.portal.kernel.json.JSONObject getTransactionFees(
		long scopeGroupId, boolean pendingOnly,
		java.util.List<java.lang.String> transactionMasterCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						scopeGroupId,
						
					pendingOnly,
						
					ClpSerializer.translateInput(transactionMasterCode)
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
	public void publishStripeEvent(long scopeGroupId,
		java.lang.String eventUri, java.lang.String eventData) {
		try {
			_invokableLocalService.invokeMethod(_methodName10,
				_methodParameterTypes10,
				new Object[] {
					scopeGroupId,
					
				ClpSerializer.translateInput(eventUri),
					
				ClpSerializer.translateInput(eventData)
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
	public com.liferay.portal.kernel.json.JSONObject computeSchemeFees(
		long scopeGroupId, java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(priceSchemeCode),
						
					ClpSerializer.translateInput(priceSubSchemeCode)
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
	public com.liferay.portal.kernel.json.JSONObject computeCandidateSchemeFees(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(candidateId),
						
					ClpSerializer.translateInput(priceSchemeCode),
						
					ClpSerializer.translateInput(priceSubSchemeCode)
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
	public com.liferay.portal.kernel.json.JSONObject retrieveTransactionStatus(
		long scopeGroupId,
		java.util.List<java.lang.String> transactionMasterCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(transactionMasterCode)
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
	public com.liferay.portal.kernel.json.JSONObject retrievePEProgrammePriceSchemeByScheduleAndModule(
		long scopeGroupId, java.lang.String programmeCode,
		java.lang.String schedModulesParamJson) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(programmeCode),
						
					ClpSerializer.translateInput(schedModulesParamJson)
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
	public boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(invoiceNumbers)
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
}