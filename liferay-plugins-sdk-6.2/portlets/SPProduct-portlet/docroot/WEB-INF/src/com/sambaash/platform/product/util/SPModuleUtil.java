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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.NoSuchModuleException;
import com.sambaash.platform.srv.model.Activity;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.ModuleCertificate;
import com.sambaash.platform.srv.model.ModuleCompetencyUnit;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.Schedule;
import com.sambaash.platform.srv.service.ActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.ScheduleLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPModuleUtil {

	private static Log _log = LogFactoryUtil.getLog(SPModuleUtil.class);

	public static JSONObject addModule(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {

			String spModuleId = resourceRequest.getParameter("spModuleId");
			boolean hasPermission = false;
			if(GetterUtil.getLong(spModuleId) > 0){
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			}else{
			    // create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}
			
			if(!hasPermission){
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.noauth"));
				return response;
			}
			
			
			String moduleCode = ParamUtil.getString(resourceRequest, "moduleCode");
			// check for uniqueness
			try {
				Module existing = ModuleLocalServiceUtil.findByModuleCode(moduleCode.trim());
				if (existing.getSpModuleId() != GetterUtil.getLong(spModuleId)) {
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.module.exist") + moduleCode
							+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.unique.module"));
					return response;
				}
			} catch (NoSuchModuleException e) {
				// does not exist..
			}
			String moduleDescription = ParamUtil.getString(resourceRequest, "moduleDescription");
			String moduleName = ParamUtil.getString(resourceRequest, "moduleName");
			String country = ParamUtil.getString(resourceRequest, "countryList");
			String moduleType = ParamUtil.getString(resourceRequest, "moduleTypeList");
			String credits = ParamUtil.getString(resourceRequest, "credits");
			String duration = ParamUtil.getString(resourceRequest, "duration");
			String noOfSessions = ParamUtil.getString(resourceRequest, "noOfSessions");
			String frameworkList = ParamUtil.getString(resourceRequest, "frameworkList");
			// String[] competencyUnitList =
			// resourceRequest.getParameterValues("competencyUnitList");
			String[] competencyUnitList = ParamUtil.getParameterValues(resourceRequest, "valueToBeSaved");
			// String certificates =
			String[] certificateList = ParamUtil.getParameterValues(resourceRequest, "certValueToBeSaved");
			String certificatesDescription = ParamUtil.getString(resourceRequest, "certificatesDescription");

			Module module = null;
			if (Validator.isNumber(spModuleId)) {
				module = ModuleLocalServiceUtil.fetchModule(Long.parseLong(spModuleId));
				module.setModifiedDate(DateUtil.newDate());
			} else {
				_log.error("creating new module");
				long moduleId = CounterLocalServiceUtil.increment("Module.class");
				module = ModuleLocalServiceUtil.createModule(moduleId);
				module.setCreateDate(DateUtil.newDate());
			}

			_log.error("spModuleId : " + spModuleId + " : certificateList : " + certificateList + " : moduleName : "
					+ moduleName);

			module.setGroupId(themeDisplay.getScopeGroupId());
			module.setUserId(themeDisplay.getUser().getUserId());
			module.setUserName(themeDisplay.getUser().getFullName());
			module.setCompanyId(themeDisplay.getCompanyId());

			if (Validator.isNumber(country)) {
				module.setCountryId(Long.parseLong(country));
			}
			if (Validator.isNumber(moduleType)) {
				module.setModuleType(Long.parseLong(moduleType));
			}
			module.setModuleCode(moduleCode.trim());
			module.setModuleName(moduleName);
			module.setModuleDesc(moduleDescription);

			if (Validator.isNumber(credits)) {
				module.setCreditValue(Long.parseLong(credits));
			}

			module.setModuleDuration(duration);

			if (Validator.isNumber(noOfSessions)) {
				module.setNoOfSessions(Long.parseLong(noOfSessions));
			}
			module.setGeneralDesc(certificatesDescription);

			ModuleLocalServiceUtil.updateModule(module);
			response.put("spModuleId", module.getSpModuleId());

			// module competency Unit
			ModuleCompetencyUnit moduleCompetencyUnit = null;

			if (Validator.isNotNull(spModuleId)) {
				List<ModuleCompetencyUnit> moduleCompetencyUnitList = ModuleCompetencyUnitLocalServiceUtil
						.findByModuleIdAndGroupId(Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());
				for (ModuleCompetencyUnit moduleCompetency : moduleCompetencyUnitList) {
					try {
						ModuleCompetencyUnitLocalServiceUtil.deleteModuleCompetencyUnit(moduleCompetency
								.getSpModuleCompetencyUnitId());
					} catch (PortalException e) {
						_log.error(e);
					}
				}
			}

			for (String competencyId : competencyUnitList) {
				if (Validator.isNumber(competencyId)) {
					if (Long.parseLong(competencyId) > 0) {
						long moduleCompUnitId = CounterLocalServiceUtil.increment("ModuleCompetencyUnit.class");
						moduleCompetencyUnit = ModuleCompetencyUnitLocalServiceUtil
								.createModuleCompetencyUnit(moduleCompUnitId);
						moduleCompetencyUnit.setSpCompetencyUnitId(moduleCompUnitId);
						moduleCompetencyUnit.setCreateDate(DateUtil.newDate());
						moduleCompetencyUnit.setGroupId(themeDisplay.getScopeGroupId());
						moduleCompetencyUnit.setUserId(themeDisplay.getUser().getUserId());
						moduleCompetencyUnit.setUserName(themeDisplay.getUser().getFullName());
						moduleCompetencyUnit.setCompanyId(themeDisplay.getCompanyId());

						moduleCompetencyUnit.setSpCompetencyUnitId(Long.parseLong(competencyId));
						moduleCompetencyUnit.setSpModuleId(module.getSpModuleId());
						ModuleCompetencyUnitLocalServiceUtil.updateModuleCompetencyUnit(moduleCompetencyUnit);
					}
				}
			}

			// module framework
			ModuleFramework moduleFramework = null;
			if (Validator.isNotNull(spModuleId)) {
				List<ModuleFramework> moduleFrameWorkList = ModuleFrameworkLocalServiceUtil.findByModuleIdAndGroupId(
						Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());

				for (ModuleFramework moduleFrameWorks : moduleFrameWorkList) {
					try {
						ModuleFrameworkLocalServiceUtil
								.deleteModuleFramework(moduleFrameWorks.getSpModuleFrameworkId());
					} catch (PortalException e) {
						_log.error(e);
					}
				}
			}

			long moduleFrameWorkId = CounterLocalServiceUtil.increment("ModuleFramework.class");
			moduleFramework = ModuleFrameworkLocalServiceUtil.createModuleFramework(moduleFrameWorkId);
			moduleFramework.setSpModuleFrameworkId(moduleFrameWorkId);
			moduleFramework.setCreateDate(DateUtil.newDate());
			moduleFramework.setGroupId(themeDisplay.getScopeGroupId());
			moduleFramework.setUserId(themeDisplay.getUser().getUserId());
			moduleFramework.setUserName(themeDisplay.getUser().getFullName());
			moduleFramework.setCompanyId(themeDisplay.getCompanyId());
			moduleFramework.setSpFrameworkId(Long.parseLong(frameworkList));
			moduleFramework.setSpModuleId(module.getSpModuleId());
			ModuleFrameworkLocalServiceUtil.updateModuleFramework(moduleFramework);

			addScheduleAndActivityList(themeDisplay, resourceRequest, module.getSpModuleId(), spModuleId);
			addCertificateList(themeDisplay, certificateList, module.getSpModuleId(), spModuleId);

			clearCache();

			_log.error("Added Module!!!!!!!!!!");
			response.put("saveFlag", "success");

		} catch (SystemException e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.save.error"));
		}

		return response;
	}

	private static void addScheduleAndActivityList(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			long moduleUnitId, String spModuleId) {
		String schInstancesCount = resourceRequest.getParameter("schInstancesCount");
		// String actvInstancesCount =
		// resourceRequest.getParameter("actvInstancesCount");

		if (Validator.isNotNull(spModuleId)) {
			try {
				List<Schedule> schList = ScheduleLocalServiceUtil.findByGroupIdAndModuleId(
						themeDisplay.getScopeGroupId(), Long.parseLong(spModuleId));
				for (Schedule sch : schList) {
					ScheduleLocalServiceUtil.deleteSchedule(sch.getSpScheduleId());
				}
				List<Activity> actvList = ActivityLocalServiceUtil.findByGroupIdAndModuleId(
						themeDisplay.getScopeGroupId(), Long.parseLong(spModuleId));
				for (Activity actv : actvList) {
					ActivityLocalServiceUtil.deleteActivity(actv.getSpActivityId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}

		for (int i = 0; i < Long.parseLong(schInstancesCount); i++) {
			String schNumber = ParamUtil.getString(resourceRequest, "sessionNumber_" + i);
			String sessionType = ParamUtil.getString(resourceRequest, "sessionTypeList_" + i);
			String sessionDuration = ParamUtil.getString(resourceRequest, "sessionDuration_" + i);
			String sessionDescription = ParamUtil.getString(resourceRequest, "Ip_eligibility_criteria_desc_" + i);

			_log.error("Data : counter : " + i + " : schNumber : " + schNumber + " : sessionType : " + sessionType
					+ " : sessionDuration : " + sessionDuration + " : sessionDescription : " + sessionDescription + " html strip " + HtmlUtil.stripHtml(sessionDescription).trim());

			try {
				
				if (Validator.isNull(schNumber)
						&& Validator.isNull(sessionType)
						&& Validator.isNull(sessionDuration)
						&& (Validator.isNull(sessionDescription) || (Validator.isNotNull(sessionDescription) && "Session Description"
											.equalsIgnoreCase(HtmlUtil.stripHtml(sessionDescription).trim())))) {

					_log.error("Will skip the saving of schedule as it is empty or with default values.");

				} else {
					long scheduleId = CounterLocalServiceUtil.increment("Schedule.class");
					Schedule schedule = ScheduleLocalServiceUtil.createSchedule(scheduleId);

					schedule.setSpScheduleId(scheduleId);
					schedule.setCompanyId(themeDisplay.getCompanyId());
					schedule.setGroupId(themeDisplay.getScopeGroupId());
					schedule.setUserId(themeDisplay.getUserId());
					schedule.setUserName(themeDisplay.getUser().getFullName());
					schedule.setCreateDate(DateUtil.newDate());

					schedule.setSpModuleId(moduleUnitId);
					schedule.setDescription(sessionDescription);
					schedule.setSessionDuration(sessionDuration);
					schedule.setSessionNumber(schNumber);
					schedule.setSessionType(Long.parseLong(sessionType));

					ScheduleLocalServiceUtil.updateSchedule(schedule);

					if (Validator.isNotNull(scheduleId)) {

						int actvInstancesCount = ParamUtil.getInteger(resourceRequest, i + "_gbActCount");

						for (int j = 0; j < actvInstancesCount; j++) {

							String inst = "SchedulewrapperId_" + i + "_activitywrapperId_" + j;
							String activityTiming = ParamUtil.getString(resourceRequest, inst + "_activityTiming_" + j);
							String activityPerformer = ParamUtil.getString(resourceRequest, inst
									+ "_activityPerformer_" + j);
							String activityDuration = ParamUtil.getString(resourceRequest, inst + "_activityDuration_"
									+ j);
							String activityDesc = ParamUtil.getString(resourceRequest, "Ip_" + inst + "_activity_desc_"
									+ j);

							_log.error("Data : counter : " + j + " : activityDesc : " + activityDesc
									+ " : activityTiming : " + activityTiming + " : activityPerformer : "
									+ activityPerformer + " : activityDuration : " + activityDuration);

							if (Validator.isNull(activityTiming)
									&& Validator.isNull(activityPerformer)
									&& Validator.isNull(activityDuration)
									&& (Validator.isNull(activityDesc) || (Validator.isNotNull(activityDesc) && "Activity Description"
											.equalsIgnoreCase(HtmlUtil.stripHtml(activityDesc).trim())))) {

								_log.error("Will skip the saving of activity as it is empty or with default values.");

							} else {
								long spActivityId = CounterLocalServiceUtil.increment("Activity.class");
								Activity activity = ActivityLocalServiceUtil.createActivity(spActivityId);

								activity.setSpScheduleId(scheduleId);
								activity.setCompanyId(themeDisplay.getCompanyId());
								activity.setGroupId(themeDisplay.getScopeGroupId());
								activity.setUserId(themeDisplay.getUserId());
								activity.setUserName(themeDisplay.getUser().getFullName());
								activity.setCreateDate(DateUtil.newDate());

								activity.setSpModuleId(moduleUnitId);
								activity.setSpScheduleId(scheduleId);
								activity.setDescription(activityDesc);
								activity.setActivityDuration(activityDuration);
								activity.setActivityPerformer(activityPerformer);
								activity.setActivityTiming(activityTiming);

								ActivityLocalServiceUtil.updateActivity(activity);
							}
						}

					}
				}
			} catch (SystemException e) {
				_log.error(e);
			}
		}

	}

	@SuppressWarnings("deprecation")
	private static void addCertificateList(ThemeDisplay themeDisplay, String[] certificateList, long moduleUnitId,
			String spModuleId) {

		if (Validator.isNotNull(spModuleId)) {
			try {
				List<ModuleCertificate> mcList = ModuleCertificateLocalServiceUtil.findByModuleIdAndGroupId(
						Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());
				for (ModuleCertificate mc : mcList) {
					ModuleCertificateLocalServiceUtil.deleteModuleCertificate(mc.getSpModuleCertificateId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if (Validator.isNotNull(certificateList)) {
			for (String certificates : certificateList) {
				if (Long.parseLong(certificates) > 0) {
					try {
						long moduleCertificateId = CounterLocalServiceUtil.increment("ModuleCertificate.class");
						ModuleCertificate moduleCertificateUnit = ModuleCertificateLocalServiceUtil
								.createModuleCertificate(moduleCertificateId);
						moduleCertificateUnit.setSpModuleCertificateId(moduleCertificateId);
						moduleCertificateUnit.setGroupId(themeDisplay.getScopeGroupId());
						moduleCertificateUnit.setUserId(themeDisplay.getUser().getUserId());
						moduleCertificateUnit.setUserName(themeDisplay.getUser().getFullName());
						moduleCertificateUnit.setCreateDate(DateUtil.newDate());
						moduleCertificateUnit.setCompanyId(themeDisplay.getCompanyId());

						moduleCertificateUnit.setSpCertificatetId(Long.parseLong(certificates));
						moduleCertificateUnit.setSpModuleId(moduleUnitId);
						ModuleCertificateLocalServiceUtil.updateModuleCertificate(moduleCertificateUnit);
					} catch (SystemException e) {
						_log.error(e);
					}
				}
			}

		}

	}

	private static void clearCache() {
		ModuleLocalServiceUtil.clearCache();
		ModuleFrameworkLocalServiceUtil.clearCache();
		ScheduleLocalServiceUtil.clearCache();
		ModuleCompetencyUnitLocalServiceUtil.clearCache();
		ModuleCertificateLocalServiceUtil.clearCache();
		ActivityLocalServiceUtil.clearCache();
	}

}
