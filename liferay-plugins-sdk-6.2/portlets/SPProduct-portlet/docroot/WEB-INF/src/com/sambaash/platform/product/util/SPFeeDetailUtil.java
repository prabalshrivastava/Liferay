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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;

public class SPFeeDetailUtil {

	private static Log _log = LogFactoryUtil.getLog(SPFeeDetailUtil.class);

	public static JSONObject addFeeDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			String fundInst, long fundId, String instancesCount) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String spCourseId = resourceRequest.getParameter("spCourseId");
		String feeDescData = ParamUtil.getString(resourceRequest, "feeDesc");
		log("adding Fee details util spCourseId " + spCourseId + " fundInst " + fundInst + " instancesCount "
				+ instancesCount);
		if ((Validator.isNotNull(spCourseId) && fundId == 0)) {
			log("adding Fee details util spCourseId " + spCourseId);
			List<FeeDetails> feeDetailsList;
			try {
				feeDetailsList = FeeDetailsLocalServiceUtil.findByCourseIdAndGroupId(Long.parseLong(spCourseId),
						themeDisplay.getScopeGroupId());
				for (FeeDetails feeDetails : feeDetailsList) {
					FeeDetailsLocalServiceUtil.deleteFeeDetails(feeDetails.getSpFeeDetailsId());
				}
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		log("adding Fee details util" + instancesCount);
		if(Long.parseLong(instancesCount) > 0){
			for (int i = 0; i < Long.parseLong(instancesCount); i++) {
				String feeType = ParamUtil.getString(resourceRequest, "feeType_" + fundInst + i);
				String feeDesc = ParamUtil.getString(resourceRequest, "feeDescData_" + fundInst + i);
				String feeDispOrd = ParamUtil.getString(resourceRequest, "displayOrder_" + fundInst + i);
				// String feeCalcData = ParamUtil.getString(resourceRequest,
				// "feeCalcData_" + i);
				String feeAmountData = ParamUtil.getString(resourceRequest, "feeAmountData_" + fundInst + i);
				// long feeDetailId = 0;
				try {
					if (Validator.isNull(feeDispOrd)) {
	
						log("Will skip the saving of Feedetail instance as it is empty.");
	
					} else {
						// feeDetailId =
						// CounterLocalServiceUtil.increment("FeeDetails.class");
	
						FeeDetails feeDetails = FeeDetailsLocalServiceUtil.create();
	
						// feeDetails.setSpFeeDetailsId(feeDetailId);
						feeDetails.setCompanyId(themeDisplay.getCompanyId());
						feeDetails.setGroupId(themeDisplay.getScopeGroupId());
						feeDetails.setUserId(themeDisplay.getUserId());
						feeDetails.setUserName(themeDisplay.getUser().getFullName());
						feeDetails.setCreateDate(DateUtil.newDate());
						if (Validator.isNumber(feeType)) {
							feeDetails.setFeeType(Long.parseLong(feeType));
						}
						if (Validator.isNumber(feeDispOrd)) {
							feeDetails.setDisplayOrder(Long.parseLong(feeDispOrd));
						}
						if (Validator.isNotNull(fundId)) {
							feeDetails.setFundId(fundId);
						}
	
						if (Validator.isNotNull(feeAmountData)) {
							feeDetails.setAmount(feeAmountData);
						}
	
						if (Validator.isNumber(spCourseId)) {
							feeDetails.setSpCourseId(Long.parseLong(spCourseId));
							Course course = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
							course.setFeeDetailsDesc(feeDescData);
							CourseLocalServiceUtil.updateCourse(course);
						}
						// feeDetails.setCalculationBase(feeCalcData);
						feeDetails.setFeeDesc(feeDesc);
	
						FeeDetailsLocalServiceUtil.updateFeeDetails(feeDetails);
					}
	
				} catch (SystemException e) {
					_log.error(e);
				} catch (NumberFormatException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}else{
			try{
			if (Validator.isNumber(spCourseId)) {
				//feeDetails.setSpCourseId(Long.parseLong(spCourseId));
				Course course = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
				course.setFeeDetailsDesc(feeDescData);
				CourseLocalServiceUtil.updateCourse(course);
			}
			//FeeDetailsLocalServiceUtil.updateFeeDetails(feeDetails);
			}catch(Exception e){
				_log.error(e);
			}
		}	

		FeeDetailsLocalServiceUtil.clearCache();

		response.put("saveFlag", "success");

		return response;
	}

	public static JSONObject getFeeType(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		String feeTypeValue = resourceRequest.getParameter("feeTypeValue");
		String feeTypeDesc = StringPool.BLANK;
		try {
			FeeType feetype = FeeTypeLocalServiceUtil.getFeeType(Long.parseLong(feeTypeValue));
			if (Validator.isNotNull(feetype)) {
				feeTypeDesc = feetype.getFeeTypeDesc();
			}
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		response.put("feeTypeDesc", feeTypeDesc);
		return response;
	}

	private static void log(String message) {
		if (_log.isDebugEnabled()) {
			_log.debug(message);
		}
	}

}
