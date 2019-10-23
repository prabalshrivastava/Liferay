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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto;
import com.sambaash.platform.model.microservice.pricing.dto.SubjectDto;
import com.sambaash.platform.model.microservice.pricing.enums.PriceCategory;
import com.sambaash.platform.model.microservice.pricing.enums.PriceType;
import com.sambaash.platform.pricingengine.service.base.SPPricingEngineLocalServiceBaseImpl;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p pricing engine local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.pricingengine.service.SPPricingEngineLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author bhavin.panchani
 * @see com.sambaash.platform.pricingengine.service.base.SPPricingEngineLocalServiceBaseImpl
 * @see com.sambaash.platform.pricingengine.service.SPPricingEngineLocalServiceUtil
 */
public class SPPricingEngineLocalServiceImpl extends SPPricingEngineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.pricingengine.service.
	 * SPPricingEngineLocalServiceUtil} to access the s p pricing engine local
	 * service.
	 */

	
	private static final String	TRANSACTION_FEE_ACTION = "Action";
	private static final String	TRANSACTION_FEE_FUNCTION = "FunctionalComponent";
	private static final String	DISCOUNT_CATEGORY = "Category";
	private static final String	PRICE_SUBSCHEME_CATEGORY = "PriceCategory";
	private static final String	PRICE_SUBSCHEME_TYPE = "PriceType";
	private static final String	PRICE_SUBSCHEME_SUBTYPE = "PriceSubType";
	private static final String	PRICE_SUBSCHEME_SUBJECT = "SubjectType";
	private static final String	PRICE_SCHEME_CATEGORY = "PricingCategory";
	private static final String	PRICE_SCHEME_TYPE = "PricingType";
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil} to
	 * access the system local service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(SPPricingEngineLocalServiceImpl.class);
	
	private static Map<String, String[]> dropdownMap = new HashMap();
	private static Map<String, String[]> modelMap = new HashMap();
	RestTemplate restTemplate = new RestTemplate();
	static {
		dropdownMap.put(DISCOUNT_CATEGORY, new String[]{"priceengine.discount.category"});
		dropdownMap.put(PRICE_SCHEME_CATEGORY, new String[]{"priceengine.pricesubscheme.category"});
		dropdownMap.put(PRICE_SCHEME_TYPE, new String[]{"priceengine.pricesubscheme.subject.pricetype",
				"priceengine.pricesubscheme.invigilator.pricetype"});
		dropdownMap.put(PRICE_SUBSCHEME_CATEGORY, new String[]{"priceengine.pricesubscheme.category"});
		dropdownMap.put(PRICE_SUBSCHEME_SUBJECT, new String[]{"priceengine.pricesubscheme.subjecttype"});
		dropdownMap.put(PRICE_SUBSCHEME_SUBTYPE, new String[]{"priceengine.pricesubscheme.examfees.pricesubtype",
				"priceengine.pricesubscheme.miscfees.pricesubtype","priceengine.pricesubscheme.invigilator.pricesubtype"});
		dropdownMap.put(PRICE_SUBSCHEME_TYPE, new String[]{"priceengine.pricesubscheme.subject.pricetype",
		"priceengine.pricesubscheme.invigilator.pricetype"});
		dropdownMap.put(TRANSACTION_FEE_ACTION, new String[]{"priceengine.transactionfee.actions"});
		dropdownMap.put(TRANSACTION_FEE_FUNCTION, new String[]{"priceengine.transactionfee.functions"});
		modelMap.put("discount", new String[]{DISCOUNT_CATEGORY});
		modelMap.put("pricesubscheme", new String[]{PRICE_SUBSCHEME_CATEGORY, PRICE_SUBSCHEME_SUBJECT, PRICE_SUBSCHEME_SUBTYPE, PRICE_SUBSCHEME_TYPE});
		modelMap.put("pricescheme", new String[]{PRICE_SCHEME_CATEGORY, PRICE_SCHEME_TYPE});
		modelMap.put("transactionfee", new String[]{TRANSACTION_FEE_ACTION, TRANSACTION_FEE_FUNCTION});
	}

	
	private String setSPListTypeDecriptions(ResourceRequest resourceRequest, String jsonDataString, String[] dropDownColumns) throws SystemException, JSONException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject resp = JSONFactoryUtil.createJSONObject(jsonDataString);
		JSONArray content = resp.getJSONArray("content");
		for (int i=0; i<content.length(); i++) {
			JSONObject contentJson = content.getJSONObject(i).getJSONObject("contentJson");
			for(String column : dropDownColumns) {
				String code = contentJson.getString(column);
				List<SPListType> listTypes = new ArrayList();
				for(String listTypeKey : dropdownMap.get(column)) {
					listTypes.addAll(SPListTypeLocalServiceUtil.getByKey(listTypeKey, themeDisplay.getScopeGroupId()));
				}
				HashMap<String, String> descMap = new HashMap<>();
				for (SPListType listType : listTypes) {
					descMap.put(listType.getItemValue(), listType.getDisplayName());
				}
				String desc = descMap.get(code);
				if (StringUtils.isNotEmpty(desc)) {
					contentJson.put(column, desc);
				}
			}
		}
		return resp.toString();
	}

	

	public JSONArray getPricing(
			long scopeGroupId,
			String programmeScheduleCode,
			String scheduleCode,
			PriceType programmeType,
			Integer fullUnitNumber,
			Integer halfUnitNumber,
			Integer lawUnitNumber,
			Date date,
			List<String> priceSchemeCode,
			String promoCode,
			List<SubjectDto> subjects,
			String baseCurrency,
			String baseCurrencyCode,
			String roundingMode,
			String roundingScale,
			PriceCategory priceCategory,
			String action,
			String purposeForExchangeRate
		) {	
			PriceCalculationInputDto inputDto = new PriceCalculationInputDto();
			if (StringUtils.isNotEmpty(programmeScheduleCode)) {
				inputDto.setProgrammeScheduleCode(programmeScheduleCode);			
			}
			if (StringUtils.isNotEmpty(scheduleCode)) {
				inputDto.setScheduleCode(scheduleCode);			
			}
			inputDto.setProgrammeType(programmeType);
			inputDto.setFullUnitNumber(fullUnitNumber);
			inputDto.setHalfUnitNumber(halfUnitNumber);
			inputDto.setLawUnitNumber(lawUnitNumber);
			inputDto.setDate(date);	
			inputDto.setRoundingMode(roundingMode);
			inputDto.setRoundingScale(roundingScale);
			inputDto.setPriceSchemeCode(priceSchemeCode);
			inputDto.setPurposeForExchangeRate(purposeForExchangeRate);
			if (StringUtils.isNotEmpty(promoCode)) {
				inputDto.setPromoCode(promoCode);
			}
			inputDto.setSubjects(subjects);
			if (StringUtils.isNotEmpty(baseCurrency)) {
				inputDto.setBaseCurrency(baseCurrency);
			}
			if (StringUtils.isNotEmpty(baseCurrencyCode)) {
				inputDto.setBaseCurrencyCode(baseCurrencyCode);
			}
			if (StringUtils.isNotEmpty(action)) {
				inputDto.setAction(action);
			}
			inputDto.setPriceCategory(priceCategory);
			return PricingMicroserviceLocalServiceUtil.getPricing(scopeGroupId, inputDto);
		}
	
}