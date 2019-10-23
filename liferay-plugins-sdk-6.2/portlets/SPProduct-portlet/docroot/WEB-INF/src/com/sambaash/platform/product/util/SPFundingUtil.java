package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPFundingUtil {

	private static Log _log = LogFactoryUtil.getLog(SPFundingUtil.class);

	public static JSONObject addFunding(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String instancesCount = resourceRequest.getParameter("critInstancesCount");
		String spCourseId = resourceRequest.getParameter("spCourseId");
		response.put("process", "create");
		if (Validator.isNotNull(spCourseId)) {
			List<Funding> fundingList;
			try {
				fundingList = FundingLocalServiceUtil.findByCourseIdAndGroupId(Long.parseLong(spCourseId),
						themeDisplay.getScopeGroupId());
				if (!fundingList.isEmpty()) {
					response.put("process", "update");
				}

				for (Funding fundings : fundingList) {
					FundingLocalServiceUtil.deleteFunding(fundings.getSpFundingId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		_log.error("adding Fund details util" + instancesCount);
		for (int i = 0; i < Long.parseLong(instancesCount); i++) {
			String fundingSponsored = ParamUtil.getString(resourceRequest, "fundingSponsored_" + i);
			String fundingOrder = ParamUtil.getString(resourceRequest, "fundingOrderId_" + i);
			String[] fundingResStatus = ParamUtil.getParameterValues(resourceRequest, "fundingResStatus_" + i);
			String fundingAge = ParamUtil.getString(resourceRequest, "fundingAgeValue_" + i);
			String fundingAgeOpr = ParamUtil.getString(resourceRequest, "fundingAgeOperator_" + i);
			String fundingSalOpr = ParamUtil.getString(resourceRequest, "fundingSalaryOperator_" + i);
			String fundingSalaryMonth = ParamUtil.getString(resourceRequest, "fundingSalaryMonth_" + i);
			String fundingDescPost = ParamUtil.getString(resourceRequest, "fundingDescPost_" + i);
			String fundingDesc = ParamUtil.getString(resourceRequest, "fundingGeneralNotes");
			String feeInst = ParamUtil.getString(resourceRequest, "globalCountId_Fund" + i + "_0");
			String resStatus = StringPool.BLANK;
			for (int f = 0; f < fundingResStatus.length; f++) {
				resStatus = fundingResStatus[f] + "," + resStatus;
			}
			try {
				if (Validator.isNull(fundingSponsored)) {

					_log.error("Will skip the saving of funding instance as it is empty.");

				} else {
					// fundId =
					// CounterLocalServiceUtil.increment("Funding.class");

					Funding funding = FundingLocalServiceUtil.create();

					// funding.setSpFundingId(fundId);
					funding.setCompanyId(themeDisplay.getCompanyId());
					funding.setGroupId(themeDisplay.getScopeGroupId());
					funding.setUserId(themeDisplay.getUserId());
					funding.setUserName(themeDisplay.getUser().getFullName());
					funding.setCreateDate(DateUtil.newDate());
					funding.setAgeOperator(fundingAgeOpr);
					funding.setSalaryOperator(fundingSalOpr);

					if (Validator.isNumber(fundingOrder)) {
						funding.setFundOrder(Long.parseLong(fundingOrder));
					}
					if (Validator.isNumber(fundingSponsored)) {
						funding.setSponsoredBy(Long.parseLong(fundingSponsored));
					}
					funding.setResidenceStatus(resStatus);
					if (Validator.isNumber(spCourseId)) {
						funding.setSpCourseId(Long.parseLong(spCourseId));
					}
					funding.setFundingDesc(fundingDescPost);
					if (Validator.isNumber(fundingSponsored)) {
						funding.setAge(Double.parseDouble(fundingAge));
					}
					if (Validator.isNotNull(fundingSalaryMonth)) {
						funding.setSalary(Double.parseDouble(fundingSalaryMonth));
					}

					if (Validator.isNumber(spCourseId)) {
						Course course = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
						course.setFundingDescPost(fundingDesc);
						// course.setFundingDescPre(fundingDescPre);
						CourseLocalServiceUtil.updateCourse(course);
					}

					// funding.setFundingHour(fundingHour);
					// if (Validator.isNotNull(fundingAmount)) {
					// funding.setFundingAmount(Double.parseDouble(fundingAmount));
					// }
					// if (Validator.isNotNull(fundingNetFees)) {
					// funding.setNetFees(Double.parseDouble(fundingNetFees));
					// }
					FundingLocalServiceUtil.updateFunding(funding);
					String fundInst = "Fund" + i + "_";
					SPFeeDetailUtil.addFeeDetail(resourceRequest, resourceResponse, fundInst, funding.getSpFundingId(),
							feeInst);
				}

			} catch (Exception e) {
				_log.error(e);
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.feeDetails.save.error"));
				return response;
			}
		}

		FundingLocalServiceUtil.clearCache();

		response.put("saveFlag", "success");

		return response;
	}

}