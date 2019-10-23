package com.sambaash.platform.action.ajax;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto;
import com.sambaash.platform.model.microservice.pricing.dto.SubjectDto;
import com.sambaash.platform.model.microservice.pricing.enums.PriceCategory;
import com.sambaash.platform.model.microservice.pricing.enums.PriceType;
import com.sambaash.platform.model.microservice.pricing.enums.SubjectType;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;

public class PricingActionHandler implements ServeResourceActionHandler {
	private Log _log = LogFactoryUtil.getLog(PricingActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String requestData = request.getParameter("data");

		try {
			JSONObject jsonOBJ = new JSONObject(requestData.toString());
			_log.debug("req data :: " + jsonOBJ);
			_log.debug("programmeScheduleCode :: " + jsonOBJ.get("programmeScheduleCode").toString());

			String programmeScheduleCode = jsonOBJ.get("programmeScheduleCode").toString();
			String scheduleCode = jsonOBJ.get("scheduleCode").toString();
			PriceType programmeType = PriceType.fromValue(jsonOBJ.get("programmeType").toString());
			Integer fullUnitNumber = 0;
			Integer halfUnitNumber = 0;
			Integer lawUnitNumber = 0;

			String action = jsonOBJ.get("action").toString();
			String baseCurrencyCode = jsonOBJ.get("baseCurrency").toString(); // request.getParameter("baseCurrency");
			String baseCurrency = jsonOBJ.get("baseCurrency").toString(); // request.getParameter("baseCurrency");
			String promoCode = "";// request.getParameter("");

			_log.debug("programmeScheduleCode :: " + programmeScheduleCode);
			_log.debug("programmeType :: " + programmeType);
			_log.debug("fullUnitNumber :: " + fullUnitNumber);
			_log.debug("halfUnitNumber :: " + halfUnitNumber);
			_log.debug("lawUnitNumber :: " + lawUnitNumber);
			_log.debug("baseCurrencyCode:: " + baseCurrencyCode);
			_log.debug("baseCurrency :: " + baseCurrency);
			_log.debug("promoCode :: " + promoCode);

			List<SubjectDto> subjects = new ArrayList<SubjectDto>();

			if (jsonOBJ.has("subjects")) {
				org.json.JSONArray subjectArr = jsonOBJ.getJSONArray("subjects");
				for (int i = 0; i < subjectArr.length(); i++) {
					SubjectDto subjetctPOJO = new SubjectDto();
					JSONObject subject = (JSONObject) subjectArr.get(i);
					_log.debug("subject :: " + subject);
					subjetctPOJO.setSubjectCode(subject.get("subjectCode").toString());
					subjetctPOJO.setSubjectType(SubjectType.fromValue(subject.get("subjectType").toString()));
					subjects.add(subjetctPOJO);
					;
				}
			}
			List<String> priceSchemeCode = new ArrayList<>();
			if (jsonOBJ.has("priceSchemeCode")) {
				org.json.JSONArray subjectArr = jsonOBJ.getJSONArray("priceSchemeCode");
				for (int i = 0; i < subjectArr.length(); i++) {
					priceSchemeCode.add(subjectArr.get(i).toString());
					_log.debug("priceSchemeCode :: " + subjectArr.get(i).toString());

				}
			}

			// List<String> priceSchemeCode = Arrays.asList("PSC001");;//=
			// request.getParameter("");

			PriceCategory priceCategory = PriceCategory.SUBJECT;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			try {
				date = format.parse(jsonOBJ.getString("date"));
			} catch (ParseException e) {
				_log.error(e);
			}

			if (jsonOBJ.has("programmeType") && jsonOBJ.getString("programmeType").equalsIgnoreCase("MiscFees")) {
				PriceCalculationInputDto inputDto = new PriceCalculationInputDto();
				if (StringUtils.isNotEmpty(programmeScheduleCode)) {
					inputDto.setProgrammeScheduleCode(programmeScheduleCode);
				}
				if (StringUtils.isNotEmpty(scheduleCode)) {
					inputDto.setScheduleCode(scheduleCode);
				}
				inputDto.setProgrammeType(programmeType);
				inputDto.setFullUnitNumber(0);
				inputDto.setHalfUnitNumber(0);
				inputDto.setLawUnitNumber(0);
				inputDto.setDate(date);
				inputDto.setPriceSchemeCode(priceSchemeCode);
				if (StringUtils.isNotEmpty(promoCode)) {
					inputDto.setPromoCode(promoCode);
				}
				if (StringUtils.isNotEmpty(action)) {
					inputDto.setAction(action);
				}
				_log.debug("actiondd :: " + inputDto.getAction());
				// inputDto.setSubjects(null);
				if (StringUtils.isNotEmpty(baseCurrency)) {
					inputDto.setBaseCurrency(baseCurrency);
				}
				if (StringUtils.isNotEmpty(baseCurrencyCode)) {
					inputDto.setBaseCurrencyCode(baseCurrencyCode);
				}
				// inputDto.setPriceCategory(priceCategory);
				if (jsonOBJ.has("purposeForExchangeRate")) {
					inputDto.setPurposeForExchangeRate(jsonOBJ.getString("purposeForExchangeRate"));
				}

				JSONArray modelData = PricingMicroserviceLocalServiceUtil.getPricing(themeDisplay.getScopeGroupId(),
						inputDto);

				_log.debug(modelData);

				try {
					response.getWriter().write(modelData.toString());
				} catch (IOException e) {
					_log.error(e);
				}

			} else {

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
				inputDto.setPriceSchemeCode(priceSchemeCode);
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
				inputDto.setPriceCategory(priceCategory);
				_log.debug("inputDto " + inputDto.toString());
				if (jsonOBJ.has("purposeForExchangeRate")) {
					inputDto.setPurposeForExchangeRate(jsonOBJ.getString("purposeForExchangeRate"));
				}

				JSONArray modelData = PricingMicroserviceLocalServiceUtil.getPricing(themeDisplay.getScopeGroupId(),
						inputDto);

				_log.debug("model data" + modelData.toString());

				try {
					response.getWriter().write(modelData.toString());
				} catch (IOException e) {
					_log.error(e);
				}
			}

		} catch (JSONException e) {
			_log.error(e);
		}

	}
}
