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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPPricingEngine. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author bhavin.panchani
 * @see SPPricingEngineLocalServiceUtil
 * @see com.sambaash.platform.pricingengine.service.base.SPPricingEngineLocalServiceBaseImpl
 * @see com.sambaash.platform.pricingengine.service.impl.SPPricingEngineLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPPricingEngineLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPPricingEngineLocalServiceUtil} to access the s p pricing engine local service. Add custom service methods to {@link com.sambaash.platform.pricingengine.service.impl.SPPricingEngineLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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
		java.lang.String action, java.lang.String purposeForExchangeRate);
}