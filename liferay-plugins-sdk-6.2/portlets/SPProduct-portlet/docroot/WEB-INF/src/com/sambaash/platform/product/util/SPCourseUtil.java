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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.NoSuchCourseException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.CourseOutcome;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPCourseUtil {

	private static Log _log = LogFactoryUtil.getLog(SPCourseUtil.class);

	public static JSONObject addCourse(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			_log.error("Adding Course");

			// String editCourseId = resourceRequest.getParameter("spCourseId");
			long spCourseId = ParamUtil.getLong(resourceRequest, "spCourseId");
			boolean hasPermission = false;
			if (spCourseId > 0) {
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			} else {
				// create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}

			if (!hasPermission) {
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.noauth.add.course"));
				return response;
			}
			String courseCode = resourceRequest.getParameter("courseCode");

			// check for coursecode uniqueness
			try {
				Course exising = CourseLocalServiceUtil.findByCourseCode(courseCode.trim());
				if (exising.getSpCourseId() != spCourseId) {
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.course.exist") + courseCode
							+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.unique.course"));
					return response;
				}
			} catch (NoSuchCourseException e) {
				// it's new
			}

			String courseName = resourceRequest.getParameter("courseName");
			String displayCourseName = resourceRequest.getParameter("displayCourseName");
			String courseDurationFullTime = resourceRequest.getParameter("courseDurationFullTime");
			String learningDurationFullTime = resourceRequest.getParameter("learningDurationFullTime");
			String courseDurationPartTime = resourceRequest.getParameter("courseDurationPartTime");
			String learningDurationPartTime = resourceRequest.getParameter("learningDurationPartTime");
			String complexityLevel = resourceRequest.getParameter("complexityLevel");
			String frameworkApprovalStatus = resourceRequest.getParameter("frameworkApprovalStatus");
			String courseType = resourceRequest.getParameter("courseType");
			String country = resourceRequest.getParameter("country");
			String moduleArray[] = resourceRequest.getParameterValues("moduleArray");
			String courseDescription = resourceRequest.getParameter("courseDescription");
			String testLink = resourceRequest.getParameter("testLink");
			String certificateTitle = resourceRequest.getParameter("certificateTitle");
			String award = resourceRequest.getParameter("award");
			String courseDeveloper = resourceRequest.getParameter("courseDeveloper");

			String[] certificateArray = resourceRequest.getParameterValues("certValueToBeSaved");
			_log.error("certificateArray " + certificateArray);
			String outcomeDescription = resourceRequest.getParameter("outcomeDesc");
			String courseOutcomeTitle = resourceRequest.getParameter("courseOutcomeTitle");
			// long courseLevel =
			// GetterUtil.getLong(resourceRequest.getParameter("courseLevel"));

			Course course = null;
			if (spCourseId > 0) {
				// spCourseId = Long.parseLong(editCourseId);
				course = CourseLocalServiceUtil.fetchCourse(spCourseId);
				course.setModifiedDate(DateUtil.newDate());
			} else {
				spCourseId = CounterLocalServiceUtil.increment("Course.class");
				course = CourseLocalServiceUtil.createCourse(spCourseId);
				course.setCreateDate(DateUtil.newDate());
			}
			course.setCourseCode(courseCode.trim());
			course.setCourseName(courseName);

			if ("yes".equalsIgnoreCase(displayCourseName)) {
				course.setDisplayCourseName(true);
			} else {
				course.setDisplayCourseName(false);
			}

			if ("yes".equalsIgnoreCase(frameworkApprovalStatus)) {
				course.setFrameworkApprovalStatus(true);
			} else {
				course.setFrameworkApprovalStatus(false);
			}

			course.setCourseDurationFullTime(courseDurationFullTime);

			course.setLearningDurationFullTime(learningDurationFullTime);
			course.setCourseDurationPartTime(courseDurationPartTime);
			course.setLearningDurationPartTime(learningDurationPartTime);

			if (Validator.isNumber(courseType)) {
				course.setCourseType(Long.parseLong(courseType));
			}

			if (Validator.isNumber(country)) {
				course.setCountryId(country);
			}
			
			if (Validator.isNumber(courseDeveloper)) {
				course.setCourseDeveloperId(GetterUtil.getLong(courseDeveloper));
			}

			if (Validator.isNumber(award)) {
				course.setAwardingBodyId(Long.parseLong(award));
			}

			course.setComplexityLevel(complexityLevel);

			course.setCourseDesc(courseDescription);
			course.setGroupId(themeDisplay.getScopeGroupId());
			course.setCompanyId(themeDisplay.getCompanyId());
			course.setUserId(themeDisplay.getUser().getUserId());
			course.setUserName(themeDisplay.getUser().getFullName());
			course.setTestLink(testLink);
			course.setCourseOutcomeTitle(courseOutcomeTitle);
			course.setCourseOutcomeDesc(outcomeDescription);
			course.setCertificateTitle(certificateTitle);
			// course.setCourseLevel(courseLevel);
			course = CourseLocalServiceUtil.updateCourse(course);

			response.put("spCourseId", spCourseId);

			CourseModule courseModule = null;

			List<CourseModule> courseModuleList = CourseModuleLocalServiceUtil.findByCourseIdAndGroupId(spCourseId,
					themeDisplay.getScopeGroupId());

			for (CourseModule cmodule : courseModuleList) {
				CourseModuleLocalServiceUtil.deleteCourseModule(cmodule.getSpCourseModuleId());
			}

			for (String moduleId : moduleArray) {
				_log.error("moduleArray :" + moduleId);

				if (Validator.isNumber(moduleId)) {
					long spCourseModuleId = CounterLocalServiceUtil.increment("CourseModule.class");
					courseModule = CourseModuleLocalServiceUtil.createCourseModule(spCourseModuleId);
					courseModule.setSpCourseId(course.getSpCourseId());
					courseModule.setSpModuleId(Long.parseLong(moduleId));

					courseModule.setGroupId(themeDisplay.getScopeGroupId());
					courseModule.setCompanyId(themeDisplay.getCompanyId());
					courseModule.setCreateDate(DateUtil.newDate());
					courseModule.setUserId(themeDisplay.getUser().getUserId());
					courseModule.setUserName(themeDisplay.getUser().getFullName());

					CourseModuleLocalServiceUtil.updateCourseModule(courseModule);
				}
			}

			addCertificateList(themeDisplay, certificateArray, course.getSpCourseId());
			addOutcomeList(themeDisplay, resourceRequest, course.getSpCourseId());

			CourseLocalServiceUtil.clearCache();
			CourseModuleLocalServiceUtil.clearCache();
			CourseCertificateLocalServiceUtil.clearCache();
			CourseOutcomeLocalServiceUtil.clearCache();
			
			try {
				SPCourseProductIndexerThread frameworkProductIndexerUpdate = new SPCourseProductIndexerThread(course, themeDisplay.getUser());
				Thread thread = new Thread(frameworkProductIndexerUpdate);
				thread.setName("Course Product Indexer Updater Thread");
				thread.start();
			} catch (Exception e) {
				_log.error("Error while exucting thread to run product indexer", e);
			}
		} catch (Exception e) {
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.course.save.error"));
			_log.error(e);
		}

		return response;

	}

	private static void addOutcomeList(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, long spCourseId) {
		// TODO Auto-generated method stub
		String outcomeInstancesCount = resourceRequest.getParameter("outcomeInstancesCount");
		if (Validator.isNotNull(spCourseId)) {
			try {
				List<CourseOutcome> ocList = CourseOutcomeLocalServiceUtil.findByCourseIdAndGroupId(spCourseId,
						themeDisplay.getScopeGroupId());
				for (CourseOutcome oc : ocList) {
					CourseOutcomeLocalServiceUtil.deleteCourseOutcome(oc.getSpCourseOutcomeId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}

		for (int i = 0; i < Long.parseLong(outcomeInstancesCount); i++) {
			String outcomeType = ParamUtil.getString(resourceRequest, "outcomeTypeList_" + i);
			String outcomeDescription = ParamUtil.getString(resourceRequest, "Ip_outcome_description_" + i);
			long spCourseOutcomeId = 0;
			_log.error("outcomeType " + outcomeType + " outcomeDescription " + outcomeDescription);
			try {
				if (Validator.isNull(outcomeType) && Validator.isNull(outcomeDescription)
						|| (Validator.isNotNull(outcomeDescription) && "Outcome Description"
								.equalsIgnoreCase(HtmlUtil.stripHtml(outcomeDescription).trim()))) {

					_log.error("Will skip the saving of outcome as it is empty or with default values.");

				} else {
					spCourseOutcomeId = CounterLocalServiceUtil.increment("CourseOutcome.class");
					CourseOutcome courseOutcome = CourseOutcomeLocalServiceUtil.createCourseOutcome(spCourseOutcomeId);

					courseOutcome.setSpCourseOutcomeId(spCourseOutcomeId);
					courseOutcome.setCompanyId(themeDisplay.getCompanyId());
					courseOutcome.setGroupId(themeDisplay.getScopeGroupId());
					courseOutcome.setUserId(themeDisplay.getUserId());
					courseOutcome.setUserName(themeDisplay.getUser().getFullName());
					courseOutcome.setCreateDate(DateUtil.newDate());

					courseOutcome.setSpCourseId(spCourseId);
					if (Validator.isNotNull(outcomeType)) {
						courseOutcome.setOutcomeId(Long.parseLong(outcomeType));
					}
					courseOutcome.setOutcomeDesc(outcomeDescription);

					CourseOutcomeLocalServiceUtil.updateCourseOutcome(courseOutcome);
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

	}

	private static void addCertificateList(ThemeDisplay themeDisplay, String[] certificateArray, long spCourseId) {

		if (Validator.isNotNull(spCourseId)) {
			try {
				List<CourseCertificate> mcList = CourseCertificateLocalServiceUtil.findByCourseIdAndGroupId(spCourseId,
						themeDisplay.getScopeGroupId());
				for (CourseCertificate mc : mcList) {
					CourseCertificateLocalServiceUtil.deleteCourseCertificate(mc.getSpCourseCertificateId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if (ArrayUtil.isNotEmpty(certificateArray)) {
			for (String certificates : certificateArray) {
				if (Long.parseLong(certificates) > 0) {
					try {
						long courseCertificateId = CounterLocalServiceUtil.increment("CourseCertificate.class");
						CourseCertificate courseCertificateUnit = CourseCertificateLocalServiceUtil
								.createCourseCertificate(courseCertificateId);
						courseCertificateUnit.setSpCourseCertificateId(courseCertificateId);
						courseCertificateUnit.setGroupId(themeDisplay.getScopeGroupId());
						courseCertificateUnit.setUserId(themeDisplay.getUser().getUserId());
						courseCertificateUnit.setUserName(themeDisplay.getUser().getFullName());
						courseCertificateUnit.setCreateDate(DateUtil.newDate());
						courseCertificateUnit.setCompanyId(themeDisplay.getCompanyId());
						courseCertificateUnit.setSpCertificatetId(Long.parseLong(certificates));
						courseCertificateUnit.setSpCourseId(spCourseId);
						CourseCertificateLocalServiceUtil.updateCourseCertificate(courseCertificateUnit);
					} catch (SystemException e) {
						_log.error(e);
					}
				}
			}

		}

	}

}
