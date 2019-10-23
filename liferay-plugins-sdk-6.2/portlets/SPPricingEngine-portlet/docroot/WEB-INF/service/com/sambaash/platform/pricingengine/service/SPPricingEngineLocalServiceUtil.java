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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPPricingEngine. This utility wraps
 * {@link com.sambaash.platform.pricingengine.service.impl.SPPricingEngineLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author bhavin.panchani
 * @see SPPricingEngineLocalService
 * @see com.sambaash.platform.pricingengine.service.base.SPPricingEngineLocalServiceBaseImpl
 * @see com.sambaash.platform.pricingengine.service.impl.SPPricingEngineLocalServiceImpl
 * @generated
 */
public class SPPricingEngineLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.pricingengine.service.impl.SPPricingEngineLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
		java.lang.String scheduleCode,
		com.sambaash.platform.model.microservice.pricing.enums.PriceType programmeType,
		java.lang.Integer fullUnitNumber, java.lang.Integer halfUnitNumber,
		java.lang.Integer lawUnitNumber, java.util.Date date,
		java.util.List<java.lang.String> priceSchemeCode,
		java.lang.String promoCode,
		java.util.List<com.sambaash.platform.model.microservice.pricing.dto.SubjectDto> subjects,
		java.lang.String baseCurrency, java.lang.String baseCurrencyCode,
		java.lang.String roundingMode, java.lang.String roundingScale,
		com.sambaash.platform.model.microservice.pricing.enums.PriceCategory priceCategory,
		java.lang.String action, java.lang.String purposeForExchangeRate) {
		return getService()
				   .getPricing(scopeGroupId, programmeScheduleCode,
			scheduleCode, programmeType, fullUnitNumber, halfUnitNumber,
			lawUnitNumber, date, priceSchemeCode, promoCode, subjects,
			baseCurrency, baseCurrencyCode, roundingMode, roundingScale,
			priceCategory, action, purposeForExchangeRate);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPPricingEngineLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPPricingEngineLocalService.class.getName());

			if (invokableLocalService instanceof SPPricingEngineLocalService) {
				_service = (SPPricingEngineLocalService)invokableLocalService;
			}
			else {
				_service = new SPPricingEngineLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPPricingEngineLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPPricingEngineLocalService service) {
	}

	private static SPPricingEngineLocalService _service;
}