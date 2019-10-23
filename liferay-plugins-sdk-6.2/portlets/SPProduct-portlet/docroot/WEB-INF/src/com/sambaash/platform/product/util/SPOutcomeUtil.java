package com.sambaash.platform.product.util;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Outcome;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.OutcomeLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPOutcomeUtil {

	private static Log _log = LogFactoryUtil.getLog(SPOutcomeUtil.class);

	public static JSONObject addOutcome(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			_log.error("Adding Outcome");

			String courseOutcomeId = resourceRequest.getParameter("spOutcomeId");
			String courseOutcomeCode = resourceRequest.getParameter("courseOutcomeCode");
			String outcomeType = resourceRequest.getParameter("outcomeType");
			String competencyUnitCodeId = resourceRequest.getParameter("competencyUnitCodeId");
			String outcomeDescription = resourceRequest.getParameter("outcomeDescription");
			String outcomeFolderId = resourceRequest.getParameter("outcomeFolderId");

			CompetencyUnit competencyUnti = CompetencyUnitLocalServiceUtil.getCompetencyUnit(Long
					.parseLong(competencyUnitCodeId));

			Outcome outcome = null;

			if (Validator.isNumber(courseOutcomeId)) {
				outcome = OutcomeLocalServiceUtil.fetchOutcome(Long.parseLong(courseOutcomeId));
				outcome.setModifiedDate(DateUtil.newDate());
			} else {

				long spOutcomeId = CounterLocalServiceUtil.increment("Outcome.class");
				outcome = OutcomeLocalServiceUtil.createOutcome(spOutcomeId);
				outcome.setCreateDate(DateUtil.newDate());
			}

			outcome.setCountryId(competencyUnti.getCountryId());

			outcome.setGroupId(themeDisplay.getScopeGroupId());
			outcome.setUserId(themeDisplay.getUser().getUserId());
			outcome.setUserName(themeDisplay.getUser().getFullName());
			outcome.setSpCompetencyUnitId(competencyUnti.getSpCompetencyUnitId());
			outcome.setCompanyId(themeDisplay.getCompanyId());
			outcome.setOutcomeCode(courseOutcomeCode);
			outcome.setOutcomeDesc(outcomeDescription);
			outcome.setOutcomeType(Long.parseLong(outcomeType));

			if (Validator.isNumber(outcomeFolderId)) {
				outcome.setOutcomeFolderId(Long.parseLong(outcomeFolderId));
				FileUtil.moveFolder(resourceRequest, themeDisplay, String.valueOf(outcome.getSpOutcomeId()),
						Long.parseLong(outcomeFolderId), SPProductConstants.OUTCOME_FOLDER,
						SPProductConstants.OUTCOME_FOLDER);
			}

			OutcomeLocalServiceUtil.updateOutcome(outcome);
			OutcomeLocalServiceUtil.clearCache();

			response.put("saveFlag", "success");
			response.put("spOutcomeId", outcome.getSpOutcomeId());

		} catch (Exception e) {
			_log.error(e);
			response.put("error",LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.outcome.save.error"));
		}

		return response;

	}

}
