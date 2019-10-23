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

package com.sambaash.platform.pricingengine.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.pricingengine.service.SPPricingEngineServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.pricingengine.service.SPPricingEngineServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author bhavin.panchani
 * @see SPPricingEngineServiceHttp
 * @see com.sambaash.platform.pricingengine.service.SPPricingEngineServiceUtil
 * @generated
 */
public class SPPricingEngineServiceSoap {
	public static java.lang.String getPricing(long scopeGroupId,
		java.lang.String programmeScheduleCode, java.lang.String scheduleCode,
		java.lang.String programmeType, java.lang.String fullUnitNumber,
		java.lang.String halfUnitNumber, java.lang.String lawUnitNumber,
		java.lang.String dateString, java.lang.String dateFormat,
		java.lang.String priceSchemeCode, java.lang.String promoCode,
		java.lang.String subjectCodes, java.lang.String subjectTypes,
		java.lang.String baseCurrency, java.lang.String baseCurrencyCode,
		java.lang.String roundingMode, java.lang.String roundingScale,
		java.lang.String priceCategory, java.lang.String action,
		java.lang.String purposeForExchangeRate) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPPricingEngineServiceUtil.getPricing(scopeGroupId,
					programmeScheduleCode, scheduleCode, programmeType,
					fullUnitNumber, halfUnitNumber, lawUnitNumber, dateString,
					dateFormat, priceSchemeCode, promoCode, subjectCodes,
					subjectTypes, baseCurrency, baseCurrencyCode, roundingMode,
					roundingScale, priceCategory, action, purposeForExchangeRate);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPPricingEngineServiceSoap.class);
}