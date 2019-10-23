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

package com.sambaash.platform.srv.spmicroservice.service.base;

import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author glenn
 * @generated
 */
public class PricingMicroserviceLocalServiceClpInvoker {
	public PricingMicroserviceLocalServiceClpInvoker() {
		_methodName28 = "getBeanIdentifier";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "setBeanIdentifier";

		_methodParameterTypes29 = new String[] { "java.lang.String" };

		_methodName32 = "getPricing";

		_methodParameterTypes32 = new String[] {
				"long",
				"com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto"
			};

		_methodName33 = "getPEPriceSchemeLOV";

		_methodParameterTypes33 = new String[] { "long" };

		_methodName34 = "getPEPriceSubSchemeLOV";

		_methodParameterTypes34 = new String[] { "long", "java.lang.String" };

		_methodName35 = "getPEPriceSchemeDetails";

		_methodParameterTypes35 = new String[] { "long", "java.lang.String" };

		_methodName36 = "createPEInvoice";

		_methodParameterTypes36 = new String[] {
				"long", "long", "long", "long", "java.lang.Double",
				"java.lang.String", "long", "long",
				"com.liferay.portal.kernel.json.JSONArray", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName37 = "getUserFees";

		_methodParameterTypes37 = new String[] {
				"long", "long", "java.lang.String", "boolean",
				"java.lang.String", "boolean"
			};

		_methodName38 = "getTransactionFees";

		_methodParameterTypes38 = new String[] {
				"long", "boolean", "java.util.List"
			};

		_methodName39 = "publishStripeEvent";

		_methodParameterTypes39 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName40 = "computeSchemeFees";

		_methodParameterTypes40 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};

		_methodName41 = "computeCandidateSchemeFees";

		_methodParameterTypes41 = new String[] {
				"long", "java.lang.String", "java.lang.String", "java.util.List"
			};

		_methodName42 = "retrieveTransactionStatus";

		_methodParameterTypes42 = new String[] { "long", "java.util.List" };

		_methodName43 = "retrievePEProgrammePriceSchemeByScheduleAndModule";

		_methodParameterTypes43 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName44 = "isPaidInvoice";

		_methodParameterTypes44 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			PricingMicroserviceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getPricing(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto)arguments[1]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getPEPriceSchemeLOV(((Long)arguments[0]).longValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getPEPriceSubSchemeLOV(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getPEPriceSchemeDetails(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.createPEInvoice(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.Double)arguments[4], (java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(com.liferay.portal.kernel.json.JSONArray)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.lang.String)arguments[11]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getUserFees(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				(java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.getTransactionFees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.util.List<java.lang.String>)arguments[2]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			PricingMicroserviceLocalServiceUtil.publishStripeEvent(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.computeSchemeFees(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.computeCandidateSchemeFees(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.util.List<java.lang.String>)arguments[3]);
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.retrieveTransactionStatus(((Long)arguments[0]).longValue(),
				(java.util.List<java.lang.String>)arguments[1]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.retrievePEProgrammePriceSchemeByScheduleAndModule(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return PricingMicroserviceLocalServiceUtil.isPaidInvoice(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
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
}