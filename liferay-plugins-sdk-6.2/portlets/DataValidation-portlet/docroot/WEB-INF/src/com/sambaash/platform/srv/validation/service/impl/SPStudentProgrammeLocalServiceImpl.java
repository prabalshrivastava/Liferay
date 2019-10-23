/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.validation.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.validation.model.SPStudentProgramme;
import com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult;
import com.sambaash.platform.srv.validation.service.base.SPStudentProgrammeLocalServiceBaseImpl;
import com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p student programme local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.validation.service.SPStudentProgrammeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.validation.service.base.SPStudentProgrammeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.validation.service.SPStudentProgrammeLocalServiceUtil
 */
public class SPStudentProgrammeLocalServiceImpl extends SPStudentProgrammeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.validation.service.
	 * SPStudentProgrammeLocalServiceUtil} to access the s p student programme
	 * local service.
	 */

	public JSONObject getStudentProgramme(Long scopeGroupId, String programmeCode, String nric) {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		try {
			
			result.put("isAllowedToProceed", false);
			result.put("isPresentInExistingList", false);
			result.put("hasExceededTwoYrs", false);
			
			Calendar cal = Calendar.getInstance();
			//cal.setTime(DateUtil.newDate());
			//cal.add(Calendar.YEAR, -2);
			
			String dateStr = "Sat Jun 29 00:00:00 SGT 2019";
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Date date = (Date)formatter.parse(dateStr);
			cal.setTime(date);
			cal.add(Calendar.YEAR, -2);
	

			_log.error("Calendar time : " + cal.getTime());

			List<SPStudentProgramme> spStudentProgrammeList = spStudentProgrammePersistence.findByNricAndProgramme(nric,
					programmeCode);
			_log.error("Student Programme Result Size : " + spStudentProgrammeList.size());

			if (Validator.isNotNull(spStudentProgrammeList) && spStudentProgrammeList.size() > 0) {

				SPStudentProgramme spStudentProgramme = spStudentProgrammeList.get(0);

				_log.error("spStudentProgramme.getCourseEndDate() : " + spStudentProgramme.getCourseEndDate());

				if (spStudentProgramme.getCourseEndDate().after(cal.getTime())) {
					_log.error("Allowed to take exam 1.");
					result.put("isAllowedToProceed", true);
					result.put("isPresentInExistingList", true);
					result.put("hasExceededTwoYrs", false);
				}else if (spStudentProgramme.getCourseEndDate().before(cal.getTime())) {
					_log.error("Allowed to take exam 2.");
					result.put("isAllowedToProceed", true);
					result.put("isPresentInExistingList", true);
					result.put("hasExceededTwoYrs", true);
				}
			} else {
				_log.error("Allowed to take exam 3.");
				result.put("isAllowedToProceed", true);
				result.put("isPresentInExistingList", false);
				result.put("hasExceededTwoYrs", false);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return result;
	}

	public String getStudentProgramme(Long scopeGroupId, String programmeCode, String nric, String emailAddress,
			Date programmeEndDate, boolean validationRequired) {

		try {

			boolean courseValidationEnabled = false;
			boolean resultValidationEnabled = false;
			String allowedToTakeCourse = "allowedToTakeCourse";

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("field", "fullSitting, modularSitting");

			jsonObject.put("fullSittingLabel", "Full Sitting");
			jsonObject.put("modularSittingLabel", "Modular Sitting");

			jsonObject.put("fullSitting", "enabled");
			jsonObject.put("modularSitting", "enabled");

			jsonObject.put("fullSittingPricingSubScheme", "CEA-RES-FULL-SITTING");
			jsonObject.put("modularSittingPricingSubScheme", "CEA-RES-MODULAR");
			jsonObject.put(allowedToTakeCourse, StringPool.TRUE);
			jsonObject.put("subject", getSubject(scopeGroupId, programmeCode, nric));
			jsonObject.put("Paper-1", "enabled");
			jsonObject.put("Paper-2", "enabled");

			if (validationRequired) {

				if (Validator
						.isNotNull(SambaashUtil.getParameter(SambaashConstants.COURSE_END_DATE_VALIDATION_ENABLED,
								scopeGroupId))
						&& StringPool.TRUE.equalsIgnoreCase(SambaashUtil
								.getParameter(SambaashConstants.COURSE_END_DATE_VALIDATION_ENABLED, scopeGroupId))) {
					courseValidationEnabled = true;
				}

				if (Validator
						.isNotNull(SambaashUtil.getParameter(SambaashConstants.RESULT_VALIDATION_ENABLED, scopeGroupId))
						&& StringPool.TRUE.equalsIgnoreCase(
								SambaashUtil.getParameter(SambaashConstants.RESULT_VALIDATION_ENABLED, scopeGroupId))) {
					resultValidationEnabled = true;
				}

				if (courseValidationEnabled) {
					Calendar cal = Calendar.getInstance();
					//cal.setTime(DateUtil.newDate());
					//cal.add(Calendar.YEAR, -2);
					
					String dateStr = "Sat Jun 29 00:00:00 SGT 2019";
					DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
					Date date = (Date)formatter.parse(dateStr);
					cal.setTime(date);
					cal.add(Calendar.YEAR, -2);

					_log.error("cal.getTime() :" + cal.getTime());

					List<SPStudentProgramme> spStudentProgrammeList = spStudentProgrammePersistence
							.findByNricAndProgramme(nric, programmeCode);
					_log.error("spStudentProgrammeList.size() : " + spStudentProgrammeList.size());

					if (Validator.isNotNull(spStudentProgrammeList) && spStudentProgrammeList.size() > 0) {

						SPStudentProgramme spStudentProgramme = spStudentProgrammeList.get(0);

						_log.error("spStudentProgramme.getCourseEndDate() : " + spStudentProgramme.getCourseEndDate());

						if (spStudentProgramme.getCourseEndDate().after(cal.getTime())) {

							_log.error("Allowed to take exam.");

							jsonObject.put(allowedToTakeCourse, StringPool.TRUE);
						} else {

							_log.error("Not Allowed to take exam.");

							jsonObject.put(allowedToTakeCourse, StringPool.FALSE);
							return jsonObject.toString();
						}
					} else {
						jsonObject.put(allowedToTakeCourse, StringPool.FALSE);
						return jsonObject.toString();
					}
				}

				if (resultValidationEnabled) {

					List<SPStudentProgrammeResult> spStudentProgrammeResultList;

					spStudentProgrammeResultList = spStudentProgrammeResultPersistence.findByNricAndProgramme(nric,
							programmeCode);

					_log.error("spStudentProgrammeResultList.size() : " + spStudentProgrammeResultList.size());

					for (SPStudentProgrammeResult spStudentProgrammeResult : spStudentProgrammeResultList) {
						_log.error("spStudentProgrammeResult.getCourseEndDate() "
								+ spStudentProgrammeResult.getCourseEndDate());
						_log.error("spStudentProgrammeResult.getPaper1Result() "
								+ spStudentProgrammeResult.getPaper1Result());
						_log.error("spStudentProgrammeResult.getPaper2Result() "
								+ spStudentProgrammeResult.getPaper2Result());

						if ("pass".equalsIgnoreCase(spStudentProgrammeResult.getPaper1Result())
								&& "pass".equalsIgnoreCase(spStudentProgrammeResult.getPaper2Result())) {
							jsonObject.put(allowedToTakeCourse, "false");
							jsonObject.put("fullSitting", "disabled");
							jsonObject.put("modularSitting", "disabled");
							jsonObject.put("message", "You have passed both papers.");
							jsonObject.put("Paper-1", "disabled");
							jsonObject.put("Paper-2", "disabled");

						} else if (("pass".equalsIgnoreCase(spStudentProgrammeResult.getPaper1Result())
								&& "fail".equalsIgnoreCase(spStudentProgrammeResult.getPaper2Result()))) {
							jsonObject.put(allowedToTakeCourse, "true");

							jsonObject.put("fullSitting", "disabled");
							jsonObject.put("modularSitting", "enabled");
							jsonObject.put("message", "Allowed to take only Modular Sitting.");
							jsonObject.put("Paper-1", "disabled");
							jsonObject.put("Paper-2", "enabled");
						} else if (("fail".equalsIgnoreCase(spStudentProgrammeResult.getPaper1Result())
								&& "pass".equalsIgnoreCase(spStudentProgrammeResult.getPaper2Result()))

						) {
							jsonObject.put(allowedToTakeCourse, "true");

							jsonObject.put("fullSitting", "disabled");
							jsonObject.put("modularSitting", "enabled");
							jsonObject.put("Paper-1", "enabled");
							jsonObject.put("Paper-2", "disabled");
							jsonObject.put("message", "Allowed to take only Modular Sitting.");
						} else if (("fail".equalsIgnoreCase(spStudentProgrammeResult.getPaper1Result())
								&& "fail".equalsIgnoreCase(spStudentProgrammeResult.getPaper2Result()))

						) {
							jsonObject.put(allowedToTakeCourse, "true");
							jsonObject.put("fullSitting", "enabled");
							jsonObject.put("modularSitting", "disabled");

							jsonObject.put("message", "Allowed to take only Full Sitting.");
						} else {
							jsonObject.put(allowedToTakeCourse, "true");
							jsonObject.put("fullSitting", "enabled");
							jsonObject.put("modularSitting", "enabled");

							jsonObject.put("message",
									"Result record not found so, system will treat it as fresh candidate.");
						}
						_log.error(
								"Multiple Record found for candiate in Temporary data storage for validation so picking random first record and using for validation.");

						break;

					}
				}
			}

			_log.error("final json : " + jsonObject.toString());

			return jsonObject.toString();

		} catch (Exception e) {
			_log.error(e);
		}
		return StringPool.BLANK;

	}

	private JSONArray getSubject(Long scopeGroupId, String programmeCode, String nric) {
		JSONArray subjectArray = JSONFactoryUtil.createJSONArray();

		try {

			JSONObject programmeLink = JSONFactoryUtil.createJSONObject();

			programmeLink.put("ModelLeft", "Programme");
			programmeLink.put("ModelRight", "Subject");
			programmeLink.put("StorageIdLeft", programmeCode);

			JSONArray subArray = SystemServiceUtil.getEntityLink(scopeGroupId, programmeLink.toString(),
					"ModelRightDetails.SubjectCode,ModelRightDetails.SubjectTitle", "ModelRight", true);

			_log.error("subArray : " + subArray.toString());

			for (int i = 0; i < subArray.length(); i++) {
				JSONObject obj = subArray.getJSONObject(i);
				JSONObject obj1 = JSONFactoryUtil.createJSONObject();
				obj1.put(obj.getString("SubjectCode"), obj.getString("SubjectTitle"));
				subjectArray.put(obj1);
			}

		} catch (SystemException e) {
			_log.error(e);
		} catch (JSONException e) {
			_log.error(e);
		} catch (org.json.JSONException e) {
			_log.error(e);
		}
		return subjectArray;
	}

	private static final Log _log = LogFactoryUtil.getLog(SPStudentProgrammeLocalServiceImpl.class);

}