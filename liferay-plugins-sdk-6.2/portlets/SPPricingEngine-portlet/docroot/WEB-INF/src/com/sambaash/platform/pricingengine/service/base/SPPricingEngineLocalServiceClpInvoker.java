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

package com.sambaash.platform.pricingengine.service.base;

import com.sambaash.platform.pricingengine.service.SPPricingEngineLocalServiceUtil;

import java.util.Arrays;

/**
 * @author bhavin.panchani
 * @generated
 */
public class SPPricingEngineLocalServiceClpInvoker {
	public SPPricingEngineLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName21 = "getPricing";

		_methodParameterTypes21 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.model.microservice.pricing.enums.PriceType",
				"java.lang.Integer", "java.lang.Integer", "java.lang.Integer",
				"java.util.Date", "java.util.List", "java.lang.String",
				"java.util.List", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.model.microservice.pricing.enums.PriceCategory",
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPPricingEngineLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPPricingEngineLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPPricingEngineLocalServiceUtil.getPricing(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.sambaash.platform.model.microservice.pricing.enums.PriceType)arguments[3],
				(java.lang.Integer)arguments[4],
				(java.lang.Integer)arguments[5],
				(java.lang.Integer)arguments[6], (java.util.Date)arguments[7],
				(java.util.List<java.lang.String>)arguments[8],
				(java.lang.String)arguments[9],
				(java.util.List<com.sambaash.platform.model.microservice.pricing.dto.SubjectDto>)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(com.sambaash.platform.model.microservice.pricing.enums.PriceCategory)arguments[15],
				(java.lang.String)arguments[16], (java.lang.String)arguments[17]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName21;
	private String[] _methodParameterTypes21;
}