package com.sambaash.platform.product.util;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.NoSuchCompetencyUnitException;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPCompetencyUnitsUtil {

	private static Log _log = LogFactoryUtil.getLog(SPCompetencyUnitsUtil.class);

	public static JSONObject addCompetencyUnits(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			_log.error("Adding CompetenctyUntis");

			String competencyId = resourceRequest.getParameter("spCompetencyUnitId");
			boolean hasPermission = false;
			if (GetterUtil.getLong(competencyId) > 0) {
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			} else {
				// create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}

			if (!hasPermission) {
				response.put("error", "You are not authorized to Add/Update the Competency Units");
				return response;
			}
			String competencyUnitCode = ParamUtil.getString(resourceRequest, "competencyUnitCode", StringPool.BLANK);

			// check for uniqueness
			try {
				CompetencyUnit existing = CompetencyUnitLocalServiceUtil
						.findByCompetencyUnitCode(competencyUnitCode.trim());
				if (existing.getSpCompetencyUnitId() != GetterUtil.getLong(competencyId)) {
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.competency.exist")
							+ competencyUnitCode + LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.unique.competency"));
					return response;
				}
			} catch (NoSuchCompetencyUnitException e) {
				// does not exist..
			}

			String competencyLevel = ParamUtil.getString(resourceRequest, "competencyLevel");
			String competencyUnitDesc = ParamUtil.getString(resourceRequest, "competencyUnitDesc");
			String cvs = ParamUtil.getString(resourceRequest, "cvs");
			String jobFamily = ParamUtil.getString(resourceRequest, "jobFamily");
			String frameworkId = ParamUtil.getString(resourceRequest, "framework");
			String country = ParamUtil.getString(resourceRequest, "country");

			CompetencyUnit competencyUnit = null;

			if (Validator.isNumber(competencyId) && Long.parseLong(competencyId) > 0) {
				competencyUnit = CompetencyUnitLocalServiceUtil.fetchCompetencyUnit(Long.parseLong(competencyId));
				competencyUnit.setModifiedDate(DateUtil.newDate());
			} else {
				long spCompetencyUnitId = CounterLocalServiceUtil.increment("CompetencyUnit.class");
				competencyUnit = CompetencyUnitLocalServiceUtil.createCompetencyUnit(spCompetencyUnitId);
				competencyUnit.setCreateDate(DateUtil.newDate());
			}

			competencyUnit.setCompetencyLevel(Long.parseLong(competencyLevel));
			competencyUnit.setCompetencyUnitCode(competencyUnitCode.trim());
			competencyUnit.setCompetencyUnitDesc(competencyUnitDesc);
			competencyUnit.setCountryId(Long.parseLong(country));

			competencyUnit.setJobFamily(Long.parseLong(jobFamily));
			competencyUnit.setGroupId(themeDisplay.getScopeGroupId());
			competencyUnit.setUserId(themeDisplay.getUser().getUserId());
			competencyUnit.setUserName(themeDisplay.getUser().getFullName());
			competencyUnit.setSpFrameworkId(Long.parseLong(frameworkId));
			competencyUnit.setCreditValue(Long.parseLong(cvs));
			competencyUnit.setCompanyId(themeDisplay.getCompanyId());

			CompetencyUnitLocalServiceUtil.updateCompetencyUnit(competencyUnit);
			CompetencyUnitLocalServiceUtil.clearCache();

			response.put("saveFlag", "success");
			response.put("spCompetencyUnitId", competencyUnit.getSpCompetencyUnitId());

		} catch (SystemException e) {
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.competencyUnit.save.error"));
			_log.error(e);
		}

		return response;
	}
}
