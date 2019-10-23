package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;

public class SPMiscFeeUtil {

	private static Log _log = LogFactoryUtil.getLog(SPMiscFeeUtil.class);

	public static JSONObject addMiscFeeDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String instancesCount = resourceRequest.getParameter("critInstancesCount");
		String spCourseId = resourceRequest.getParameter("spCourseId");

		if ((Validator.isNotNull(spCourseId))) {
			List<MiscellaneousFees> MiscellaneousFeesList = null;
			try {
				MiscellaneousFeesList = MiscellaneousFeesLocalServiceUtil
						.findByCourseIdAndGroupId(Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
				for (MiscellaneousFees MiscellaneousFees : MiscellaneousFeesList) {
					MiscellaneousFeesLocalServiceUtil.deleteMiscellaneousFees(MiscellaneousFees.getSpMiscFeesId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		_log.error("adding Misc Fee details " + instancesCount);
		String miscGeneralNotes = ParamUtil.getString(resourceRequest, "miscGeneralNotes");
		for (int i = 0; i < Long.parseLong(instancesCount); i++) {
			String miscFeeType = ParamUtil.getString(resourceRequest, "miscFeeType_" + i);
			String payable = ParamUtil.getString(resourceRequest, "whenPayable_" + i);
			String miscFeeAmountData = ParamUtil.getString(resourceRequest, "miscFeeAmountData_" + i);

			// long miscFeeDetailId = 0;
			try {
				if (Validator.isNull(miscFeeType)) {

					_log.error("Will skip the saving of Feedetail instance as it is empty.");

				} else {

					MiscellaneousFees miscellaneousFees = MiscellaneousFeesLocalServiceUtil.create();

					miscellaneousFees.setCompanyId(themeDisplay.getCompanyId());
					miscellaneousFees.setGroupId(themeDisplay.getScopeGroupId());
					miscellaneousFees.setUserId(themeDisplay.getUserId());
					miscellaneousFees.setUserName(themeDisplay.getUser().getFullName());
					miscellaneousFees.setCreateDate(DateUtil.newDate());
					if (Validator.isNumber(miscFeeType)) {
						miscellaneousFees.setMiscFeeType(Long.parseLong(miscFeeType));
					}
					if (Validator.isNumber(payable)) {
						miscellaneousFees.setPayable(Long.parseLong(payable));
					}

					if (Validator.isNotNull(miscFeeAmountData)) {
						miscellaneousFees.setAmount(Double.parseDouble(miscFeeAmountData));
					}
					if (Validator.isNumber(spCourseId)) {
						miscellaneousFees.setSpCourseId(Long.parseLong(spCourseId));
					}
					MiscellaneousFeesLocalServiceUtil.updateMiscellaneousFees(miscellaneousFees);

					if (Validator.isNumber(spCourseId)) {
						Course course = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
						course.setMiscFeeDesc(miscGeneralNotes);
						CourseLocalServiceUtil.updateCourse(course);
					}
				}

			} catch (SystemException e) {
				_log.error(e);
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}

		// MiscellaneousFeesLocalServiceUtil.clearCache();

		response.put("saveFlag", "success");

		return response;
	}
}