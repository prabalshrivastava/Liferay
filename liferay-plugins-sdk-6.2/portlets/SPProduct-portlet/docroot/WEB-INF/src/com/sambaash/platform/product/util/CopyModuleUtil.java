package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;

import org.apache.commons.lang3.SerializationUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
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
import com.sambaash.platform.util.SambaashUtil;

public class CopyModuleUtil {

	public static String MODULE_ID = "spModuleId";

	public static JSONObject copyModule(RenderRequest renderRequest) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {

			long moduleId = ParamUtil.getLong(renderRequest, MODULE_ID);
			Module module = ModuleLocalServiceUtil.fetchModule(moduleId);

			// Module
			Module clonedModule = SerializationUtils.clone(module);
			clonedModule.setSpModuleId(CounterLocalServiceUtil.increment("Module.class"));
			clonedModule.setModuleName("Copy of " + clonedModule.getModuleName());
			clonedModule.setModuleCode("Copy of " + clonedModule.getModuleCode());

			SambaashUtil.fillAudit(clonedModule, themeDisplay, true);

			clonedModule = ModuleLocalServiceUtil.updateModule(clonedModule);

			_log.error(" original courseId : " + module.getSpModuleId() + " : clonedModuleId : "
					+ clonedModule.getSpModuleId());

			// Module Session
			List<Schedule> moduleScheduleList = ScheduleLocalServiceUtil.findByGroupIdAndModuleId(
					themeDisplay.getScopeGroupId(),module.getSpModuleId());

			for (Schedule moduleSchedule : moduleScheduleList) {
				Schedule clonedModuleSchedule = SerializationUtils.clone(moduleSchedule);
				clonedModuleSchedule.setSpScheduleId(CounterLocalServiceUtil.increment("Schedule.class"));
				clonedModuleSchedule.setSpModuleId(clonedModule.getSpModuleId());

				SambaashUtil.fillAudit(clonedModuleSchedule, themeDisplay, true);

				ScheduleLocalServiceUtil.updateSchedule(clonedModuleSchedule);
			

			// Module Session Activity
			List<Activity> scheduleActivityList = ActivityLocalServiceUtil.findByGroupIdAndScheduleId(
					themeDisplay.getScopeGroupId(),moduleSchedule.getSpScheduleId());

			for (Activity scheduleActivity : scheduleActivityList) {
				Activity clonedScheduleActivity = SerializationUtils.clone(scheduleActivity);

				clonedScheduleActivity.setSpActivityId(CounterLocalServiceUtil.increment("Activity.class"));

				clonedScheduleActivity.setSpScheduleId(clonedModuleSchedule.getSpScheduleId());
				clonedScheduleActivity.setSpModuleId(clonedModuleSchedule.getSpModuleId());

				SambaashUtil.fillAudit(clonedScheduleActivity, themeDisplay, true);

				ActivityLocalServiceUtil.updateActivity(clonedScheduleActivity);
			}
			}

			// Course Certificate
			List<ModuleCertificate> moduleCertificateList = ModuleCertificateLocalServiceUtil.findByModuleIdAndGroupId(
					module.getSpModuleId(), themeDisplay.getScopeGroupId());

			for (ModuleCertificate moduleCertificate : moduleCertificateList) {
				ModuleCertificate clonedModuleCertificate = SerializationUtils.clone(moduleCertificate);
				clonedModuleCertificate.setSpModuleCertificateId(CounterLocalServiceUtil
						.increment("ModuleCertificate.class"));

				clonedModuleCertificate.setSpModuleId(clonedModule.getSpModuleId());
				clonedModuleCertificate.setSpCertificatetId(moduleCertificate.getSpCertificatetId());

				SambaashUtil.fillAudit(clonedModuleCertificate, themeDisplay, true);

				ModuleCertificateLocalServiceUtil.updateModuleCertificate(clonedModuleCertificate);

			}
			
			// Module Competency
						List<ModuleCompetencyUnit> moduleCompetencyList = ModuleCompetencyUnitLocalServiceUtil.findByModuleIdAndGroupId(
								module.getSpModuleId(), themeDisplay.getScopeGroupId());

						for (ModuleCompetencyUnit moduleCompetency : moduleCompetencyList) {
							ModuleCompetencyUnit clonedModuleCompetency = SerializationUtils.clone(moduleCompetency);
							clonedModuleCompetency.setSpModuleCompetencyUnitId(CounterLocalServiceUtil
									.increment("ModuleCertificate.class"));

							clonedModuleCompetency.setSpModuleId(clonedModule.getSpModuleId());
							clonedModuleCompetency.setSpCompetencyUnitId(moduleCompetency.getSpCompetencyUnitId());

							SambaashUtil.fillAudit(clonedModuleCompetency, themeDisplay, true);

							ModuleCompetencyUnitLocalServiceUtil.updateModuleCompetencyUnit(clonedModuleCompetency);

						}
						
						// Module FrameWork
						List<ModuleFramework> moduleFrameworkList =ModuleFrameworkLocalServiceUtil.findByModuleIdAndGroupId(
								module.getSpModuleId(), themeDisplay.getScopeGroupId());

						for (ModuleFramework moduleFramework : moduleFrameworkList) {
							ModuleFramework clonedModuleFrameworkList = SerializationUtils.clone(moduleFramework);
							clonedModuleFrameworkList.setSpModuleFrameworkId(CounterLocalServiceUtil
									.increment("ModuleFramework.class"));

							clonedModuleFrameworkList.setSpModuleId(clonedModule.getSpModuleId());
							clonedModuleFrameworkList.setSpFrameworkId(moduleFramework.getSpFrameworkId());

							SambaashUtil.fillAudit(clonedModuleFrameworkList, themeDisplay, true);

							ModuleFrameworkLocalServiceUtil.updateModuleFramework(clonedModuleFrameworkList);

						}
			
			

			ModuleLocalServiceUtil.clearCache();

			response.put("copyFlag", "success");

		} catch (Exception e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.module.copy"));
		}

		return response;
	}

	private static Log _log = LogFactoryUtil.getLog(CopyModuleUtil.class);

}
