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

package com.sambaash.platform.pricingengine.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto;
import com.sambaash.platform.model.microservice.pricing.dto.SubjectDto;
import com.sambaash.platform.model.microservice.pricing.enums.PriceCategory;
import com.sambaash.platform.model.microservice.pricing.enums.PriceType;
import com.sambaash.platform.model.microservice.pricing.enums.SubjectType;
import com.sambaash.platform.pricingengine.service.SPPricingEngineLocalServiceUtil;
import com.sambaash.platform.pricingengine.service.base.SPPricingEngineServiceBaseImpl;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * The implementation of the s p pricing engine remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.pricingengine.service.SPPricingEngineService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author bhavin.panchani
 * @see com.sambaash.platform.pricingengine.service.base.SPPricingEngineServiceBaseImpl
 * @see com.sambaash.platform.pricingengine.service.SPPricingEngineServiceUtil
 */
public class SPPricingEngineServiceImpl extends SPPricingEngineServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.pricingengine.service.SPPricingEngineServiceUtil}
	 * to access the s p pricing engine remote service.
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(SPPricingEngineServiceImpl.class);
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public JSONArray getPricing(
		long scopeGroupId,
		String programmeScheduleCode,
		String scheduleCode,
		String programmeType,
		String fullUnitNumber,
		String halfUnitNumber,
		String lawUnitNumber,
		String dateString,
		String dateFormat,
		String priceSchemeCode, // comma-separated list of priceSchemeCode (e.g PSC004,PSC002 )
		String promoCode,
		String subjectCodes,	// comma-separated list of subjectCodes (e.g Subject1,Subject2 )
		String subjectTypes,	// comma-separated list of subjectType (e.g FullUnit,HalfUnitWritten )
		String baseCurrency,
		String baseCurrencyCode,
		String roundingMode,
		String roundingScale,
		String priceCategory,
		String action,
		String purposeForExchangeRate
	) {	
		// remove leading and trailing white spaces
		if (StringUtils.isNotEmpty(programmeScheduleCode)) {
			programmeScheduleCode = StringUtils.trim(programmeScheduleCode);
		}
		if (StringUtils.isNotEmpty(scheduleCode)) {
			scheduleCode = StringUtils.trim(scheduleCode);
		}
		if (StringUtils.isNotEmpty(programmeType)) {
			programmeType = StringUtils.trim(programmeType);
		}
		if (StringUtils.isNotEmpty(fullUnitNumber)) {
			fullUnitNumber = StringUtils.trim(fullUnitNumber);
		}
		if (StringUtils.isNotEmpty(halfUnitNumber)) {
			halfUnitNumber = StringUtils.trim(halfUnitNumber);
		}
		if (StringUtils.isNotEmpty(lawUnitNumber)) {
			lawUnitNumber = StringUtils.trim(lawUnitNumber);
		}
		if (StringUtils.isNotEmpty(dateString)) {
			dateString = StringUtils.trim(dateString);
		}
		if (StringUtils.isNotEmpty(dateFormat)) {
			dateFormat = StringUtils.trim(dateFormat);
		}
		if (StringUtils.isNotEmpty(priceSchemeCode)) {
			priceSchemeCode = StringUtils.trim(priceSchemeCode);
		}
		if (StringUtils.isNotEmpty(promoCode)) {
			promoCode = StringUtils.trim(promoCode);
		}
		if (StringUtils.isNotEmpty(subjectCodes)) {
			subjectCodes = StringUtils.trim(subjectCodes);
		}
		if (StringUtils.isNotEmpty(subjectTypes)) {
			subjectTypes = StringUtils.trim(subjectTypes);
		}
		if (StringUtils.isNotEmpty(baseCurrency)) {
			baseCurrency = StringUtils.trim(baseCurrency);
		}
		if (StringUtils.isNotEmpty(baseCurrencyCode)) {
			baseCurrencyCode = StringUtils.trim(baseCurrencyCode);
		}
		if (StringUtils.isNotEmpty(priceCategory)) {
			priceCategory = StringUtils.trim(priceCategory);
		}	
		
		List<SubjectDto> subjects = null;
		if (StringUtils.isNotEmpty(subjectCodes) && StringUtils.isNotEmpty(subjectTypes)) {
			String[] sCodes = subjectCodes.split(",");
			String[] sTypes = subjectTypes.split(",");
			subjects = new ArrayList<>();
			for(int i=0; i<sCodes.length; i++) {
				SubjectDto subject = new SubjectDto();
				subject.setSubjectCode(sCodes[i]);
				subject.setSubjectType(SubjectType.fromValue(sTypes[i]));
				subjects.add(subject);
			}
		}

		PriceType pt = null;
		if (StringUtils.isNotEmpty(programmeType)) {
			pt = PriceType.fromValue(programmeType);			
		}

		PriceCategory pc = null;
		if (StringUtils.isNotEmpty(priceCategory)) {
			pc = PriceCategory.fromValue(priceCategory);
		}
		
		Date date = null;
		if (StringUtils.isEmpty(dateFormat)) {
			dateFormat = DEFAULT_DATE_FORMAT;
		}
		if (StringUtils.isNotEmpty(dateString)) {
			SimpleDateFormat df = new SimpleDateFormat(dateFormat);
			try {
				date = df.parse(dateString);				
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}

		List<String> psc = null;
		if (StringUtils.isNotEmpty(priceSchemeCode)) {
			psc = Arrays.asList(priceSchemeCode.split(","));
		}
		
		return SPPricingEngineLocalServiceUtil.getPricing(scopeGroupId, programmeScheduleCode, scheduleCode,
				pt, StringUtils.isNotEmpty(fullUnitNumber)?Integer.parseInt(fullUnitNumber):null, 
				StringUtils.isNotEmpty(halfUnitNumber)?Integer.parseInt(halfUnitNumber):null, 
				StringUtils.isNotEmpty(lawUnitNumber)?Integer.parseInt(lawUnitNumber):null, 
				date, psc, promoCode, subjects, 
				baseCurrency, baseCurrencyCode,roundingMode,roundingScale, pc, action, purposeForExchangeRate);
				
	}
}