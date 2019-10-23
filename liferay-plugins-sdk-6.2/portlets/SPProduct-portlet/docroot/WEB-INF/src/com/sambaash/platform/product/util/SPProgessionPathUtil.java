package com.sambaash.platform.product.util;

import java.util.List;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.ProgressionPath;
import com.sambaash.platform.srv.service.ProgressionPathLocalServiceUtil;

public class SPProgessionPathUtil {

	private static Log _log = LogFactoryUtil.getLog(SPProgessionPathUtil.class);

	public static JSONObject addProgessionPath(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String instancesCount = resourceRequest.getParameter("critInstancesCount");
		String spCourseId = resourceRequest.getParameter("spCourseId");

		if (Validator.isNotNull(spCourseId)) {
			List<ProgressionPath> progressionpathList;
			try {
				progressionpathList = ProgressionPathLocalServiceUtil.findByCourseIdAndGroupId(
						Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
				for (ProgressionPath prgPath : progressionpathList) {
					ProgressionPathLocalServiceUtil.deleteProgressionPath(prgPath.getSpProgressionPathId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		_log.error("adding ProgessionPath" + instancesCount);
		for (int i = 0; i < Long.parseLong(instancesCount); i++) {
			String progressionLevel = ParamUtil.getString(resourceRequest, "progressionLevel_" + i);
			// String progressionSequence = ParamUtil.getString(resourceRequest,
			// "progressionSequence_" + i);
			String progressionCareerLevel = ParamUtil.getString(resourceRequest, "progressionCareerLevel_" + i);
			String progressionCareerType = ParamUtil.getString(resourceRequest, "progressionCareerType_" + i);
			String progressionCategory = ParamUtil.getString(resourceRequest, "progressionCategory_" + i);
			String progressionStMo = ParamUtil.getString(resourceRequest, "progressionStMo_" + i);
			String progressionEnddMo = ParamUtil.getString(resourceRequest, "progressionEnddMo_" + i);
			String progressionDuratio = ParamUtil.getString(resourceRequest, "progressionDuration_" + i);
			String progressionOptLevenl = ParamUtil.getString(resourceRequest, "progressionOptLevela_" + i);
			long progressionPathId = 0;
			try {
				progressionPathId = CounterLocalServiceUtil.increment("ProgressionPath.class");

				ProgressionPath progressionPath = ProgressionPathLocalServiceUtil
						.createProgressionPath(progressionPathId);

				progressionPath.setSpProgressionPathId(progressionPathId);
				progressionPath.setCompanyId(themeDisplay.getCompanyId());
				progressionPath.setGroupId(themeDisplay.getScopeGroupId());
				progressionPath.setUserId(themeDisplay.getUserId());
				progressionPath.setUserName(themeDisplay.getUser().getFullName());
				progressionPath.setCreateDate(DateUtil.newDate());

				// if (Validator.isNumber(progressionSequence)) {
				// progressionPath.setSequence(Integer.parseInt(progressionSequence));
				// }

				if (Validator.isNumber(progressionCareerLevel)) {
					progressionPath.setCareerLevel(Long.parseLong(progressionCareerLevel));
				}
				if (Validator.isNumber(progressionLevel)) {
					progressionPath.setLevel(Integer.parseInt(progressionLevel));
				}
				if (Validator.isNumber(progressionCareerType)) {
					progressionPath.setProgressionType(Long.parseLong(progressionCareerType));
				}
				if (Validator.isNumber(progressionCategory)) {
					progressionPath.setProgressionCategory(Long.parseLong(progressionCategory));
				}
				progressionPath.setStartMonth(progressionStMo);
				progressionPath.setEndMonth(progressionEnddMo);
				progressionPath.setOptionalMandatory(progressionOptLevenl);

				progressionPath.setDuration(progressionDuratio);

				if (Validator.isNumber(spCourseId)) {
					progressionPath.setSpCourseId(Long.parseLong(spCourseId));
				}

				ProgressionPathLocalServiceUtil.updateProgressionPath(progressionPath);

			}  catch (Exception e) {
				_log.error(e);
				response.put("error", "Error while saving Progression Path details");
			}
		}

		ProgressionPathLocalServiceUtil.clearCache();

		response.put("saveFlag", "success");

		return response;
	}

}