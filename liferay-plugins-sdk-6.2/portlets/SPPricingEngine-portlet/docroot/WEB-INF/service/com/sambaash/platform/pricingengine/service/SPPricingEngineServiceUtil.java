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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SPPricingEngine. This utility wraps
 * {@link com.sambaash.platform.pricingengine.service.impl.SPPricingEngineServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author bhavin.panchani
 * @see SPPricingEngineService
 * @see com.sambaash.platform.pricingengine.service.base.SPPricingEngineServiceBaseImpl
 * @see com.sambaash.platform.pricingengine.service.impl.SPPricingEngineServiceImpl
 * @generated
 */
public class SPPricingEngineServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.pricingengine.service.impl.SPPricingEngineServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPricing(
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
		return getService()
				   .getPricing(scopeGroupId, programmeScheduleCode,
			scheduleCode, programmeType, fullUnitNumber, halfUnitNumber,
			lawUnitNumber, dateString, dateFormat, priceSchemeCode, promoCode,
			subjectCodes, subjectTypes, baseCurrency, baseCurrencyCode,
			roundingMode, roundingScale, priceCategory, action,
			purposeForExchangeRate);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPPricingEngineService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPPricingEngineService.class.getName());

			if (invokableService instanceof SPPricingEngineService) {
				_service = (SPPricingEngineService)invokableService;
			}
			else {
				_service = new SPPricingEngineServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPPricingEngineServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPPricingEngineService service) {
	}

	private static SPPricingEngineService _service;
}