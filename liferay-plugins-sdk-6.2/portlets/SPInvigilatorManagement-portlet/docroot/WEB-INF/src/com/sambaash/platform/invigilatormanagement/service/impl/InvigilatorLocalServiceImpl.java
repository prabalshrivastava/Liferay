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

package com.sambaash.platform.invigilatormanagement.service.impl;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.invigilatormanagement.service.base.InvigilatorLocalServiceBaseImpl;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the invigilator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Himadri
 * @see com.sambaash.platform.invigilatormanagement.service.base.InvigilatorLocalServiceBaseImpl
 * @see com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil
 */
public class InvigilatorLocalServiceImpl extends InvigilatorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.invigilatormanagement.service.
	 * InvigilatorLocalServiceUtil} to access the invigilator local service.
	 */

	private static final String TOTAL_ELEMENTS = "totalElements";
	private static final String TITLES = "titles";
	private static final String ORDER = "order";
	private static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	private static final String CREATED_DATE = "createdDate";
	private static final String LAST_MODIFIED_BY = "lastModifiedBy";
	private static final String CREATED_BY = "createdBy";
	private static final String SESSION_CURRENTQUERY = "currentquery";
	private static final String SESSION_EXPORTQUERY = "exportquery";
	private static final String MICROSERVICEMODEL_PACKAGE = "com.sambaash.platform.model.microservicemodel.MicroServiceModel";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String MODEL_PACKAGE_POSTFIX = "Model";
	private static final String MICROSERVICEMODEL_PACKAGE_PREFIX = "com.sambaash.platform.model.microservicemodel.";
	private static final String SCHEDULE_MODEL = "schedule";
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil} to
	 * access the system local service.
	 */
	private static final Log _loggg = LogFactoryUtil.getLog(InvigilatorServiceImpl.class);
	private static String error = "error";
	private static String formStorageId = "formStorageId";
	private static String formType = "formType";
	private static String sortBy = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriContentType = "ContentType:";
	private static String restUriLimit = "limit";
	RestTemplate restTemplate = new RestTemplate();
	
	
	public class APICall {
		long userId = 0;
		long siteId = 0;
		ResourceRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		
		String baseUrl = "";

		public APICall(ResourceRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", StringPool.BLANK + userId);

				baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);

			} catch (PortalException | SystemException e1) {
				//_log.error(e1);
			}
		}

		public APICall(long userId, long siteId) throws PortalException, SystemException {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getGroupId(siteId));
			headers.add("X-USER-ID", "" + userId);
			
			baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = "";
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				_loggg.debug(requestURL + baseUrl + subUrl);
				response = httpresponse.getBody();

			} catch (Exception e) {
				_loggg.error(e);
			}

			return response;
		}

		private String postForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				httprequest = new HttpEntity<>(data, headers);
				response = restTemplate.postForObject(baseUrl + subUrl, httprequest, String.class);
				return response;

			} catch (Exception e) {
				_loggg.error(e);
				return response;
			}
		}
	}

	public List<String> getMicroserviceModelFilterColumnList(ResourceRequest resourceRequest, String modelName) {

		String response = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getFilterColumns";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			tempArray = response.split(",");
		} catch (Exception e) {
			_loggg.error(e);
		}
		return (Arrays.asList(tempArray));

	}
	
 public String getUniqueList(ResourceRequest resourceRequest) 
   {
		String response = null;
		String[] tempArray = null;
		String modelName = resourceRequest.getParameter("formType");
		try {
		String subUrl = modelName.toLowerCase() + "/getunique";
		response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_loggg.error(e);
		}		
		return response;
	
}	

 public String getScheduleList(ResourceRequest resourceRequest) 
   {
	String response = null;
	String[] tempArray = null;
	String modelName = resourceRequest.getParameter("formType");
	try {
		String subUrl = modelName.toLowerCase() + "/getschedule";
		String modeldata = resourceRequest.getParameter("data");
		response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
		
	} catch (Exception e) {
		_loggg.error(e);
	}		
	return response;
   }
 
	public String getPastAppointmentList(ResourceRequest resourceRequest) {
		String response = null;
		String modelName = resourceRequest.getParameter("formType");
		String data = resourceRequest.getParameter("data");
		try {
			JSONObject dataObj = JSONFactoryUtil.createJSONObject(data);
			String invigilatorId = dataObj.getString("InvigilatorId");
			String subUrl = modelName.toLowerCase() + "/past/" + invigilatorId;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_loggg.error(e);
		}
		return response;
	}

	public Map<String, String> getMicroserviceModelColumnTitleMap(ResourceRequest resourceRequest, String modelName) {

		Map<String, String> map = new HashMap<>();
		String response = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = response.substring(1, response.length() - 1);
			String[] keyValuePairs = response.split(",");
			for (String pair : keyValuePairs) {
				String[] entry = pair.split("=");
				map.put(entry[0].trim(), entry[1].trim());
			}

		} catch (Exception e) {
			_loggg.error(e);
		}
		return map;
	}


	public String getFilterColumnHeader(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		_loggg.info("Get Filter Column Header");
		String response = null;
		List<String> nonModelFilterColumns = new ArrayList<>();
		nonModelFilterColumns.add(CREATED_BY);
		nonModelFilterColumns.add(LAST_MODIFIED_BY);
		List<String> datePickerColumns = new ArrayList<>();
		datePickerColumns.add(CREATED_DATE);
		datePickerColumns.add(LAST_MODIFIED_DATE);

		try {
			String modelNameMicroService = resourceRequest.getParameter(formType);
			String model = modelNameMicroService.toLowerCase();
			List<String> filterColumns = getMicroserviceModelFilterColumnList(resourceRequest, modelNameMicroService);
			StringBuilder sbColumns = new StringBuilder("?");
			for (String filterColumn : filterColumns) {
				if (sbColumns.toString() != "?") {
					sbColumns.append("&");
				}
				sbColumns.append("columns=contentJson.");
				sbColumns.append(filterColumn);
				_loggg.info("filtercolumn: " + filterColumn);
			}
			for (String nonModelFilterColumn : nonModelFilterColumns) {
				if (sbColumns.toString() != "?") {
					sbColumns.append("&");
				}
				sbColumns.append("columns=");
				sbColumns.append(nonModelFilterColumn);
				_loggg.info("nonmodelfiltercolumn: " + nonModelFilterColumn);
			}
			String subUrl = model + "/distinct/" + sbColumns.toString();
			_loggg.info("suburl: " + subUrl);

			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			Map<String, String> allModelColumnTitles = getMicroserviceModelColumnTitleMap(resourceRequest,
					modelNameMicroService);
			JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			JSONArray datepicker = JSONFactoryUtil.createJSONArray();
			JSONObject titles = JSONFactoryUtil.createJSONObject();

			JSONArray distinctCreatedBy = distinct.getJSONArray(CREATED_BY);

			DynamicQuery studentINOperator = DynamicQueryFactoryUtil.forClass(User.class,
					PortletClassLoaderUtil.getClassLoader());
			Criterion criterion6 = null;
			ArrayList<Long> list = new ArrayList<>();
			for (int i = 0; i < distinctCreatedBy.length(); i++) {
				try {
					if (!distinctCreatedBy.getString(i).equalsIgnoreCase(null)) {
						list.add(Long.valueOf(distinctCreatedBy.getString(i)));
					}
				} catch (Exception e) {
					_loggg.error(e);
				}
			}

			JSONArray usersInfo = JSONFactoryUtil.createJSONArray();
			JSONObject userInfo;
			if (!list.isEmpty()) {
				criterion6 = RestrictionsFactoryUtil.in("userId", list);
				criterion6 = RestrictionsFactoryUtil.and(criterion6,
						RestrictionsFactoryUtil.eq("status", new Integer("0")));
				studentINOperator.add(criterion6);
				List<User> studentList8 = UserLocalServiceUtil.dynamicQuery(studentINOperator);

				for (User student : studentList8) {
					userInfo = JSONFactoryUtil.createJSONObject();
					userInfo.put("id", student.getUserId());
					userInfo.put("name", student.getFirstName() + " " + student.getLastName());
					usersInfo.put(userInfo);
				}
			}

			for (String datePickerColumn : datePickerColumns) {
				datepicker.put(datePickerColumn);
				_loggg.info("datepicker: " + datePickerColumn);
			}
			for (Map.Entry modelColumnTitle : allModelColumnTitles.entrySet()) {
				titles.put(CONTENT_JSON_PREFIX + (String) modelColumnTitle.getKey(),
						(String) modelColumnTitle.getValue());
				_loggg.info("titles:" + modelColumnTitle.getValue());
			}
			titles.put(CREATED_BY, "Created By");
			titles.put(CREATED_DATE, "Created Date");
			titles.put(LAST_MODIFIED_BY, "Last Modified By");
			titles.put(LAST_MODIFIED_DATE, "Last Modified Date");
			obj.put("userInfo", usersInfo);
			obj.put("distinct", distinct);
			obj.put("datepicker", datepicker);
			obj.put(TITLES, titles);
			return obj.toString();
		} catch (Exception e) {
			_loggg.error("getFilterColumnHeader exception: " + e);
			response = error;
		}
		return response;
	}

	public String fetchUpcommingFacilitySchedul(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		String existingData = null;
		try {
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + "/upcomming";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_loggg.error(e);
			response = e.toString();
		}
		return response;
	}

	public String getGroupNameHeader(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			_loggg.debug("creating data" + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/distinct";

			response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
		} catch (Exception e) {
			_loggg.error(e);
		}
		return response;
	}
	public String getUniqueData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			_loggg.debug("creating data" + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/distinct";

			response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
		} catch (Exception e) {
			_loggg.error(e);
		}
		return response;
	}
	
	
	public String updateAppointmentStatus(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			_loggg.debug("creating data" + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/updateAppointmentStatus";

			response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
		} catch (Exception e) {
			_loggg.error(e);
		}
		return response;
	}
	
	public String notifyInvigilator(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			JSONArray claims = JSONFactoryUtil.createJSONArray(modeldata);
			for (int i = 0; i < claims.length(); i++) {
				String submitClaimUrl = resourceRequest.getPreferences().getValue("submitClaimUrlPref", "");
				JSONObject claim = claims.getJSONObject(i);
				String scheduleId = claim.getString("ScheduleID");
				String claimTypeId = claim.getString("ClaimType");
				String submittedClaimCode=generateCode("SC-");
				JSONObject scheduleData = getScheduleData(resourceRequest, scheduleId);
				submitClaimUrl = submitClaimUrl.replace("[$scheduleId$]", scheduleId);
				submitClaimUrl = submitClaimUrl.replace("[$claimTypeId$]", claimTypeId);
				submitClaimUrl=submitClaimUrl.replace("[$submittedClaimCode$]", submittedClaimCode);
				String notificationMessage = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
						themeDisplay.getScopeGroupId(), "prepareclaim.notification.message").getValue();
				notificationMessage = notificationMessage.replace("[$schedule$]", scheduleData.getString("name"));
				notificationMessage = notificationMessage.replace("[$claimType$]",
						SPListTypeLocalServiceUtil.fetchSPListType(Long.parseLong(claimTypeId)).getDisplayName());
				notificationMessage = notificationMessage.replace("[$duedate$]", scheduleData.getString("duedate"));
				SystemLocalServiceUtil.addTimelineActivity(submitClaimUrl, "Details", notificationMessage,
						StringPool.BLANK, StringPool.BLANK, "Completed", themeDisplay.getUserId(), "Invigilator Claim",
						"Payment", StringPool.BLANK, StringPool.BLANK, "" + claim.getString("InvigilatorID"),
						themeDisplay.getScopeGroupId());
			}
			response = "success";
		} catch (Exception e) {
			_loggg.error(e);
			response = "error";
		}
		return response;
	}
	
	private String generateCode(String prefix) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		long timeInMilis = calendar.getTimeInMillis();
		return prefix + timeInMilis;
	}

	private JSONObject getScheduleData(ResourceRequest resourceRequest, String scheduleId) {
		JSONObject sData = JSONFactoryUtil.createJSONObject();
		try {
			String storageId = scheduleId;
			String model = SCHEDULE_MODEL;
			String subUrl = model.toLowerCase() + restUriGet + storageId;
			String data = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			JSONObject scheduleData = JSONFactoryUtil.createJSONObject(data).getJSONObject("contentJson");
			String startDateString = scheduleData.getString("StartDate");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			try {
				startDate = sdf.parse(startDateString);
			} catch(ParseException pe) {
				startDate = sdf1.parse(startDateString);
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			int days = 7;
			for (int i = 0; i < days;) {
				if (calendar.get(Calendar.DAY_OF_WEEK) >= 2 && calendar.get(Calendar.DAY_OF_WEEK) <= 6) {
					i++;
				}
				calendar.add(Calendar.DAY_OF_MONTH, 1);
			}
			Date dueDate = calendar.getTime();
			String duedate = sdf.format(dueDate);
			sData.put("duedate", duedate);
			sData.put("name", scheduleData.getString("Name"));
		} catch (Exception e) {
			
		}
		return sData;
	}
	
	public void sendNewUserLoginDetailsEmail(User user, String templateName) {
		try {
			
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(user.getGroupId());
			String toAddress = user.getEmailAddress();
			String fromName = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromAddress = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			
			SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil.getTemplateByName(templateName);
			com.sambaash.platform.model.MailMessage mailMessage = new MailMessage();
			mailMessage.setSubject(spMailTemplate.getSubject());
			mailMessage.setHtmlBody(spMailTemplate.getHtmlContent());
			mailMessage.setHtmlFormat(true);
			
			String body = mailMessage.getHtmlBody();
			body = body.replace("[$TO_FULL_NAME$]", user.getFullName());
			body = body.replace("[$TO_ADDRESS$]", toAddress);
			body = body.replace("[$USER_PASSWORD$]", user.getPassword());
			body = body.replace("[$TO_FIRST_NAME$]", user.getFirstName());
			body = body.replace("[$TO_LAST_NAME$]", user.getLastName());
			
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setToAddress(toAddress);
			mailMessage.setHtmlBody(body);
			SPMailLocalServiceUtil.sendMail(mailMessage);
		} catch (Exception e) {
			_loggg.error("error" + e.toString());
		}
	}
	public String getPriceScheme(ResourceRequest resourceRequest,JSONObject appointData){
			
		String response = null;
		String[] tempArray = null;
		String modelName = "EntityLink";
		String scheduleId = appointData.getString("ScheduleId");
		try {
			String subUrl = modelName.toLowerCase() + "/fetchPricing/" + scheduleId + "/SchedulePriceSchemeEntityLink";
		response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.POST);
		
		} catch (Exception e) {
			_loggg.error(e);
		}	
		return response;
			
			
			
	}
}