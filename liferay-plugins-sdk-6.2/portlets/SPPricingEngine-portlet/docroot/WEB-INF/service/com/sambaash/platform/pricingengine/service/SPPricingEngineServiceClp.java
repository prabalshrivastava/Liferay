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

package com.sambaash.platform.pricingengine.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author bhavin.panchani
 * @generated
 */
public class SPPricingEngineServiceClp implements SPPricingEngineService {
	public SPPricingEngineServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getPricing";

		_methodParameterTypes3 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
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
			_invokableService.invokeMethod(_methodName1,
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
		long scopeGroupId, java.lang.String programmeScheduleCode,
		java.lang.String scheduleCode, java.lang.String programmeType,
		java.lang.String fullUnitNumber, java.lang.String halfUnitNumber,
		java.lang.String lawUnitNumber, java.lang.String dateString,
		java.lang.String dateFormat, java.lang.String priceSchemeCode,
		java.lang.String promoCode, java.lang.String subjectCodes,
		java.lang.String subjectTypes, java.lang.String baseCurrency,
		java.lang.String baseCurrencyCode, java.lang.String roundingMode,
		java.lang.String roundingScale, java.lang.String priceCategory,
		java.lang.String action, java.lang.String purposeForExchangeRate) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						scopeGroupId,
						
					ClpSerializer.translateInput(programmeScheduleCode),
						
					ClpSerializer.translateInput(scheduleCode),
						
					ClpSerializer.translateInput(programmeType),
						
					ClpSerializer.translateInput(fullUnitNumber),
						
					ClpSerializer.translateInput(halfUnitNumber),
						
					ClpSerializer.translateInput(lawUnitNumber),
						
					ClpSerializer.translateInput(dateString),
						
					ClpSerializer.translateInput(dateFormat),
						
					ClpSerializer.translateInput(priceSchemeCode),
						
					ClpSerializer.translateInput(promoCode),
						
					ClpSerializer.translateInput(subjectCodes),
						
					ClpSerializer.translateInput(subjectTypes),
						
					ClpSerializer.translateInput(baseCurrency),
						
					ClpSerializer.translateInput(baseCurrencyCode),
						
					ClpSerializer.translateInput(roundingMode),
						
					ClpSerializer.translateInput(roundingScale),
						
					ClpSerializer.translateInput(priceCategory),
						
					ClpSerializer.translateInput(action),
						
					ClpSerializer.translateInput(purposeForExchangeRate)
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

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
}