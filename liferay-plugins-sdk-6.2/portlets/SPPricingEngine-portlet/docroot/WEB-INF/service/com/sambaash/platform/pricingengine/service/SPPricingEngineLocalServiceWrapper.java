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
 * Provides a wrapper for {@link SPPricingEngineLocalService}.
 *
 * @author bhavin.panchani
 * @see SPPricingEngineLocalService
 * @generated
 */
public class SPPricingEngineLocalServiceWrapper
	implements SPPricingEngineLocalService,
		ServiceWrapper<SPPricingEngineLocalService> {
	public SPPricingEngineLocalServiceWrapper(
		SPPricingEngineLocalService spPricingEngineLocalService) {
		_spPricingEngineLocalService = spPricingEngineLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spPricingEngineLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spPricingEngineLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spPricingEngineLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPricing(
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
		return _spPricingEngineLocalService.getPricing(scopeGroupId,
			programmeScheduleCode, scheduleCode, programmeType, fullUnitNumber,
			halfUnitNumber, lawUnitNumber, date, priceSchemeCode, promoCode,
			subjects, baseCurrency, baseCurrencyCode, roundingMode,
			roundingScale, priceCategory, action, purposeForExchangeRate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPPricingEngineLocalService getWrappedSPPricingEngineLocalService() {
		return _spPricingEngineLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPPricingEngineLocalService(
		SPPricingEngineLocalService spPricingEngineLocalService) {
		_spPricingEngineLocalService = spPricingEngineLocalService;
	}

	@Override
	public SPPricingEngineLocalService getWrappedService() {
		return _spPricingEngineLocalService;
	}

	@Override
	public void setWrappedService(
		SPPricingEngineLocalService spPricingEngineLocalService) {
		_spPricingEngineLocalService = spPricingEngineLocalService;
	}

	private SPPricingEngineLocalService _spPricingEngineLocalService;
}