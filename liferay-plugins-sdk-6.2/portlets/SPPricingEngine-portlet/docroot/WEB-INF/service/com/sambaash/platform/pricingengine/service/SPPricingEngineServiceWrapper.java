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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPPricingEngineService}.
 *
 * @author bhavin.panchani
 * @see SPPricingEngineService
 * @generated
 */
public class SPPricingEngineServiceWrapper implements SPPricingEngineService,
	ServiceWrapper<SPPricingEngineService> {
	public SPPricingEngineServiceWrapper(
		SPPricingEngineService spPricingEngineService) {
		_spPricingEngineService = spPricingEngineService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spPricingEngineService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spPricingEngineService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spPricingEngineService.invokeMethod(name, parameterTypes,
			arguments);
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
		return _spPricingEngineService.getPricing(scopeGroupId,
			programmeScheduleCode, scheduleCode, programmeType, fullUnitNumber,
			halfUnitNumber, lawUnitNumber, dateString, dateFormat,
			priceSchemeCode, promoCode, subjectCodes, subjectTypes,
			baseCurrency, baseCurrencyCode, roundingMode, roundingScale,
			priceCategory, action, purposeForExchangeRate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPPricingEngineService getWrappedSPPricingEngineService() {
		return _spPricingEngineService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPPricingEngineService(
		SPPricingEngineService spPricingEngineService) {
		_spPricingEngineService = spPricingEngineService;
	}

	@Override
	public SPPricingEngineService getWrappedService() {
		return _spPricingEngineService;
	}

	@Override
	public void setWrappedService(SPPricingEngineService spPricingEngineService) {
		_spPricingEngineService = spPricingEngineService;
	}

	private SPPricingEngineService _spPricingEngineService;
}