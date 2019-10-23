package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.GraduationCriteria;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPGraduationCriteriaUtil {

	private static Log _log = LogFactoryUtil.getLog(SPGraduationCriteriaUtil.class);

	public static JSONObject addGraduationCriteria(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		response.put("process", "create");
		String instancesCount = resourceRequest.getParameter("critInstancesCount");
		String spCourseId = resourceRequest.getParameter("spCourseId");

		String graduationCriteriaTitle = resourceRequest.getParameter("graduationCriteriaTitle");


		if (Validator.isNotNull(spCourseId)) {

			List<GraduationCriteria> graduationCriteriaList;
			try {
				graduationCriteriaList = GraduationCriteriaLocalServiceUtil.findByCourseIdAndGroupId(
						Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
				if (!graduationCriteriaList.isEmpty()) {
					response.put("process", "update");
				}
				for (GraduationCriteria grdCriteria : graduationCriteriaList) {
					GraduationCriteriaLocalServiceUtil
							.deleteGraduationCriteria(grdCriteria.getSpGraduationCriteriaId());
				}

				Course course = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
				course.setGraduationCriteriaDesc(graduationCriteriaTitle);
				CourseLocalServiceUtil.updateCourse(course);

			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		_log.error("adding GraduationCriteria util" + instancesCount);
		for (int i = 0; i < Long.parseLong(instancesCount); i++) {
			String criteriaType = ParamUtil.getString(resourceRequest, "criteriaType_" + i);
			String criteriaLevel = ParamUtil.getString(resourceRequest, "criteriaLevel_" + i);
			String criteriaValue = ParamUtil.getString(resourceRequest, "criteriaValue_" + i);
			String gradCriteriaDesc = ParamUtil.getString(resourceRequest, "gradCriteriaDesc_" + i);
			long criteriaId = 0;
				try {
					if (Validator.isNull(criteriaType)
							&& Validator.isNull(criteriaLevel)
							&& Validator.isNull(criteriaValue)) {

						_log.error("Will skip the saving of Graduation criteria instance as it is empty.");

					}else{
						criteriaId = CounterLocalServiceUtil.increment("GraduationCriteria.class");
		
						GraduationCriteria criteria = GraduationCriteriaLocalServiceUtil.createGraduationCriteria(criteriaId);
		
						criteria.setSpGraduationCriteriaId(criteriaId);
						criteria.setCompanyId(themeDisplay.getCompanyId());
						criteria.setGroupId(themeDisplay.getScopeGroupId());
						criteria.setUserId(themeDisplay.getUserId());
						criteria.setUserName(themeDisplay.getUser().getFullName());
						criteria.setCreateDate(DateUtil.newDate());
		
						if (Validator.isNumber(criteriaType)) {
							criteria.setCriteriaType(Long.parseLong(criteriaType));
						}
						if (Validator.isNumber(criteriaLevel)) {
							criteria.setCriteriaLevel(Long.parseLong(criteriaLevel));
						}
						if (Validator.isNumber(spCourseId)) {
							criteria.setSpCourseId(Long.parseLong(spCourseId));
						}
		
						criteria.setCriteriaValueRange(criteriaValue);
						criteria.setCriteriaDesc(gradCriteriaDesc);
						GraduationCriteriaLocalServiceUtil.updateGraduationCriteria(criteria);
					}	

			} catch (Exception e) {
				_log.error(e);
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.graduation.save.error"));
				return response;
			}
		}
		GraduationCriteriaLocalServiceUtil.clearCache();
		response.put("saveFlag", "success");

		return response;
	}

}