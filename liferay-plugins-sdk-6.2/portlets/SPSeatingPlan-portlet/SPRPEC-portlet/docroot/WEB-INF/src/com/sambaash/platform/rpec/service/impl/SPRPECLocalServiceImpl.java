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

package com.sambaash.platform.rpec.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.util.IOUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.rpec.service.base.SPRPECLocalServiceBaseImpl;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p r p e c local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.rpec.service.SPRPECLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gaurav.kapadiya
 * @see com.sambaash.platform.rpec.service.base.SPRPECLocalServiceBaseImpl
 * @see com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil
 */
public class SPRPECLocalServiceImpl extends SPRPECLocalServiceBaseImpl {
	private static final Log _log = LogFactoryUtil
			.getLog(SPRPECLocalServiceImpl.class);
	private static String requestURL = "Request URL";
	private static String formType = "formType";

	private static final String TOTAL_ELEMENTS = "totalElements";
	private static final String TITLES = "titles";
	private static final String ORDER = "order";
	private static final String COLUMN_LIST = "columnlist";
	private static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	private static final String CREATED_DATE = "createdDate";
	private static final String LAST_MODIFIED_BY = "lastModifiedBy";
	private static final String CREATED_BY = "createdBy";
	private static final String SESSION_CURRENTQUERY = "currentquery";
	private static final String SESSION_EXPORTQUERY = "exportquery";
	private static final String CONTENT_JSON = "contentJson";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String ELASTIC_SEARCH = "/elasticsearch?";
	private static final String CONTENT_DISPOSITION = "Content-Disposition";
	private static final String STORAGEID = "storageid";

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil} to
	 * access the system local service.
	 */

	private static String errorStr = "error";
	private static String formStorageIdStr = "formStorageId";
	private static String formTypeStr = "formType";
	private static String sortByStr = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";

	private static String contentStr = "content";
	private static String contentTypeStr = "contentType";
	private static String restUriLimit = "limit";
	private static String pageEqual = "page=";

	public class APICall {
		long userId = 0;
		long siteId = 0;
		ResourceRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		RestTemplate restTemplate;
		String baseUrl = "";

		public APICall(ResourceRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID",
						"" + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", "" + userId);
				restTemplate = new RestTemplate();
				baseUrl = SambaashUtil.getParameter(
						SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);
				SambaashUtil.printSystem("BASEURL ::" + baseUrl);

			} catch (PortalException | SystemException e1) {
				_log.error(e1);
			}

		}

		public APICall(long userId, long siteId) throws PortalException {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID",
					"" + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", "" + userId);
			restTemplate = new RestTemplate();
			baseUrl = SambaashUtil.getParameter(
					SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);
			SambaashUtil.printSystem("BASEURL ::" + baseUrl);

		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = "";
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(
						uri, method, httprequest, String.class);
				SambaashUtil.printSystem(baseUrl + subUrl);
				_log.debug(requestURL + baseUrl + subUrl);
				response = httpresponse.getBody();

			} catch (Exception e) {
				SambaashUtil.printSystem(baseUrl + subUrl);
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

			return response;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		private Map downloadFile(String subUrl, HttpMethod method) {
			Map response = new HashMap<>();
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<byte[]> httpresponse = restTemplate.exchange(
						uri, method, httprequest, byte[].class);
				SambaashUtil.printSystem(baseUrl + subUrl);
				_log.debug(requestURL + baseUrl + subUrl);
				response.put("content", httpresponse.getBody());
				response.put("contentType", httpresponse.getHeaders()
						.getContentType());
			} catch (Exception e) {
				SambaashUtil.printSystem(baseUrl + subUrl);
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

			return response;
		}

		private String putForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpMethod method = HttpMethod.PUT;
				httprequest = new HttpEntity<>(data, headers);
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(
						uri, method, httprequest, String.class);
				response = httpresponse.getBody();
				SambaashUtil.printSystem(baseUrl + subUrl);
				SambaashUtil.printSystem(data);
				return response;
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
				return response;
			}
		}

		private String postForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				httprequest = new HttpEntity<>(data, headers);
				response = restTemplate.postForObject(baseUrl + subUrl,
						httprequest, String.class);
				SambaashUtil.printSystem(baseUrl + subUrl);
				SambaashUtil.printSystem(data);
				return response;

			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
				return response;
			}
		}

		private void downloadObject(String data, String subUrl,
				HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(
						uri, method, httprequest, Resource.class);
				SambaashUtil.printSystem(baseUrl + subUrl);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					SambaashUtil.printSystem("downloadObject HTTPStatus"
							+ httpresponse.getStatusCode().toString());
					HttpHeaders head = httpresponse.getHeaders();
					MediaType mtype = head.getContentType();
					List<String> contentDisposition = head
							.get(CONTENT_DISPOSITION);

					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse
							.addProperty(
									com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
									"max-age=3600, must-revalidate");
					SambaashUtil.printSystem("downloadObject ContentType"
							+ mtype.getType() + mtype.getSubtype());
					for (String cd : contentDisposition) {
						resourceResponse.addProperty(CONTENT_DISPOSITION, cd);
						SambaashUtil
								.printSystem("downloadObject Content-Disposition"
										+ cd);

					}
					OutputStream out = null;
					InputStream in = null;
					try {
						in = httpresponse.getBody().getContentAsStream();
						Scanner s = new Scanner(in).useDelimiter("\\A");
						String ee = s.hasNext() ? s.next() : "";

						SambaashUtil.printSystem("ee " + ee);
						out = resourceResponse.getPortletOutputStream();
						SambaashUtil.printSystem("out " + out);
						IOUtils.copy(in, out);
						in.close();
						out.flush();
						out.close();
						resourceResponse.flushBuffer();
					} catch (final IOException e) {
						_log.error(e);
					} finally {
						try {
							if (Validator.isNotNull(out)) {
								out.flush();
								out.close();
							}
							if (Validator.isNotNull(in)) {
								in.close();
							}

						} catch (final IOException e) {
							_log.error(e);
						}
					}

				}

			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

		}

		private void downloadObjects(String data, String subUrl,
				HttpMethod method, ResourceResponse resourceResponse,
				ResourceRequest resourceRequest) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);

			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(
						uri, method, httprequest, String.class);
				SambaashUtil.printSystem(baseUrl + subUrl);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {

					String response2 = httpresponse.getBody();
//					new JSONObject(response2).getJSONArray("content").get(0);
					response2=changeResponseForExport(response2);
					// SPERPECModelHandler.exportData(response2, data,
					// resourceResponse);
					SPERPECModelHandler.exportData(resourceRequest, response2,
							data, resourceResponse);

				} else {
					SambaashUtil.printSystem("downloadObject HTTPStatus"
							+ httpresponse.getStatusCode().toString());
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

		}
	}
private String changeResponseForExport(String response) throws org.json.JSONException, PortalException, SystemException
{
	JSONObject jsonObj=(JSONObject) new JSONObject(response).getJSONArray("content").get(0);
	JSONObject contentJsonObj=jsonObj.getJSONObject("contentJson");
	
	try
	{
		if(jsonObj.has("createdBy"))
		{
			User createdBy = UserLocalServiceUtil.getUser(jsonObj.getLong("createdBy"));
			jsonObj.put("createdBy", createdBy.getFullName());
		}
		else{
			jsonObj.put("createdBy", "");
		}
	}
	catch(JSONException je)
	{
		jsonObj.put("createdBy", "");
	}
	
	try
	{
		if(jsonObj.has("lastModifiedBy"))
		{
			User modifiedBy = UserLocalServiceUtil.getUser(jsonObj.getLong("lastModifiedBy"));
			jsonObj.put("lastModifiedBy", modifiedBy.getFullName());
		}
		else{
			jsonObj.put("lastModifiedBy", "");
		}
	}
	catch(JSONException je)
	{
		jsonObj.put("lastModifiedBy", "");
	}
	
	
//	User createdBy = UserLocalServiceUtil.getUser(jsonObj.getLong("createdBy"));
//	User modifiedBy = UserLocalServiceUtil.getUser(jsonObj.getLong("lastModifiedBy"));
//	jsonObj.put("createdBy", createdBy.getFullName());
//	jsonObj.put("lastModifiedBy", modifiedBy.getFullName());
	contentJsonObj.put("startDate",contentJsonObj.get("reviewFromDate").toString().split(" ")[0].replace('-', '/'));
	contentJsonObj.put("endDate",contentJsonObj.get("reviewToDate").toString().split(" ")[0].replace('-', '/'));
	jsonObj.put("contentJson", contentJsonObj);
	JSONObject resObj=new JSONObject(response);
	resObj.getJSONArray("content").put(0,jsonObj);
	return resObj.toString();
	
	
}
	// ws call for getting competence type
	public String getCompetenceType(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			_log.debug("get competence data" + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/types";
			SambaashUtil.printSystem("subURL" + subUrl);
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}

	// ws call for getting competence subjects based on type
	public String getCompetenceSubjects(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);
			_log.debug("get competence data" + modeldata);
			SambaashUtil.printSystem("typeid  "
					+ data.getString("competenceTypeId"));
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/subject/"
					+ data.getString("competenceTypeId");
			SambaashUtil.printSystem("subURL  " + subUrl);
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}

	public void notifyByEmail() {
		try {

			String subUrl = "erpec/elasticsearch";

			String data = "{\"filters\":[{\"contentJson.rpecStatus\":[\"Pending Standard Approval\",\"Pending Final Approval\",\"Pending Sign Off\"]}],\"formType\":\"erpec\"}";

			String subject = null;
			String body = null;
			MailMessage mailMessage = new MailMessage();
			SPMailTemplate spmailTem = null;
			String mailTemplateIdParameter = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.mail.template.id").getValue().toString();

			try {
				spmailTem = SPMailTemplateLocalServiceUtil
						.getTemplateByName(mailTemplateIdParameter);
			} catch (NullPointerException e) {
				_log.error(e);
				return;
			}

			if (spmailTem != null) {
				mailMessage.setSubject("Alert From ERPEC");
				//
				mailMessage.setFromAddress("alerts@sambaash.com");
				mailMessage.setFromName("Alert From ERPEC");
				mailMessage.setHtmlFormat(true);

				String response = new APICall(1L,
						SambaashUtil.getScopeGroupId(0L)).postForObject(data,
						subUrl);
				JSONObject jsonObj = new JSONObject(response);

				JSONArray jsonArray = (JSONArray) jsonObj.get("content");
				String relcEmailId = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.erpec.relc.user.emailid").getValue()
						.toString();
				String url = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.erpec.site.url").getValue().toString();

				for (int i = 0, size = jsonArray.length(); i < size; i++) {
					String bodyContent = spmailTem.getHtmlContent();
					JSONObject objectInArray = (JSONObject) jsonArray
							.getJSONObject(i).get("contentJson");

					User trainingPrincipal = null;
					User mentor = null;
					User candidate = null;
					Organization org = null;

					if (objectInArray.get("trainingPrincipalId") != null
							&& StringUtils.isEmpty(objectInArray.get(
									"trainingPrincipalId").toString())) {
						trainingPrincipal = UserLocalServiceUtil
								.getUserById(Long.valueOf(objectInArray.get(
										"trainingPrincipalId").toString()));

						bodyContent = bodyContent.replace(
								"[$training_principal]",
								trainingPrincipal.getFullName());
					} else {

						bodyContent = bodyContent.replace(
								"[$training_principal]", "");
					}
					if (objectInArray.get("mentorId") != null
							&& StringUtils.isEmpty(objectInArray
									.get("mentorId").toString())) {
						mentor = UserLocalServiceUtil.getUserById(Long
								.valueOf(objectInArray.get("mentorId")
										.toString()));
						bodyContent = bodyContent.replace("[$mentor_name]",
								mentor.getFullName());
					} else {
						bodyContent = bodyContent.replace("[$mentor_name]", "");
					}
					if (objectInArray.get("candidateId") != null
							&& StringUtils.isEmpty(objectInArray.get(
									"candidateId").toString())) {
						candidate = UserLocalServiceUtil.getUserById(Long
								.valueOf(objectInArray.get("candidateId")
										.toString()));
						bodyContent = bodyContent.replace("[$first_name]",
								candidate.getFirstName());
						bodyContent = bodyContent.replace("[$last_name]",
								candidate.getLastName());
					} else {
						bodyContent = bodyContent.replace("[$first_name]", "");
						bodyContent = bodyContent.replace("[$last_name]", "");
					}
					if (objectInArray.get("accreditedTrainingOrganisationId") != null
							&& StringUtils.isEmpty(objectInArray.get(
									"accreditedTrainingOrganisationId")
									.toString())) {
						org = (Organization) com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil
								.getOrganization(Long
										.valueOf(objectInArray
												.get("accreditedTrainingOrganisationId")
												.toString()));
					}
					bodyContent = bodyContent.replace("[$site_name]", url);
					bodyContent = bodyContent.replace("[$review_from_date]",
							objectInArray.getString("reviewFromDate"));
					bodyContent = bodyContent.replace("[$review_to_date]",
							objectInArray.getString("reviewToDate"));
					bodyContent = bodyContent.replace("[$ato_name]",
							org.getName());

					mailMessage.setHtmlBody(bodyContent);
					System.out.println("bodyContent::" + bodyContent);

					if (trainingPrincipal != null) {
						mailMessage.setToAddress(trainingPrincipal
								.getEmailAddress());
						SPMailLocalServiceUtil.sendMail(mailMessage);
					}
					if (mentor != null) {
						mailMessage.setToAddress(mentor.getEmailAddress());
						SPMailLocalServiceUtil.sendMail(mailMessage);
					}
					mailMessage.setToAddress(org.getEmailId());
					SPMailLocalServiceUtil.sendMail(mailMessage);

					mailMessage.setToAddress(relcEmailId);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getGridData(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String data = resourceRequest.getParameter("data");

			String subUrl = "/erpec/elasticsearch";

			response = new APICall(resourceRequest).postForObject(data, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}
	// ws for elasticsearch using filters
	public String getElasticsearchData(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String data = resourceRequest.getParameter("data");
			SambaashUtil.printSystem("data::::" + data);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/elasticsearch";

			response = new APICall(resourceRequest).postForObject(data, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}

	// ws call for getting questions based on subjects
	public String getCompetenceSubjectsQuestions(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);
			_log.debug("get competence data" + modeldata);
			SambaashUtil.printSystem("typeid  "
					+ data.getString("competenceTypeId"));
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/question/"
					+ data.getString("competenceTypeId") + "/"
					+ data.getString("competenceSubjectId") + "/"
					+ data.getString("candidateId");
			SambaashUtil.printSystem("subURL  " + subUrl);
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}

	// ws call for save RPEC data
	public String createRPECRecord(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			long siteId = PortalUtil.getScopeGroupId(resourceRequest);
			String modeldata = resourceRequest.getParameter("data");
			SambaashUtil.printSystem("model data is " + modeldata);
			JSONObject data = new JSONObject(modeldata);
			
			if(data.has("mentorId"))
			{
				User mentor = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("mentorId")));
				data.put("mentorEmail", mentor.getEmailAddress());
			}
			else
			{
				data.put("mentorEmail", "");
			}
			
			if(data.has("trainingPrincipalId"))
			{
				User tpUser = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("trainingPrincipalId")));
				data.put("trainingPrincipalEmail", tpUser.getEmailAddress());
			}
			else
			{
				data.put("trainingPrincipalEmail", "");
			}
			
//			User mentor = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("mentorId")));
//			User tpUser = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("trainingPrincipalId")));
//			
//			data.put("mentorEmail", mentor.getEmailAddress());
//			data.put("trainingPrincipalEmail", tpUser.getEmailAddress());
			
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/newErpec";
			response = new APICall(resourceRequest).postForObject(data.toString(),
					subUrl);
			
			JSONObject contentJson = new JSONObject(new JSONObject(response).getString("contentJson"));
			//String url = createURL(contentJson, resourceRequest);
			User candidate = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("candidateId")));
			String title = "Notification for RPEC Application - " + candidate.getFirstName() + " " + candidate.getLastName();
			
			
			if(response != null &&  !(new JSONObject(response).has("checkErrorFlag")) &&  !(new JSONObject(response).has("error"))) {
				if(data.get("rpecStatus").equals("Pending Final Approval") || data.get("rpecStatus").equals("Pending Sign Off") || data.get("rpecStatus").equals("Pending Standard Approval")) {
					if(data.get("rpecStatus").equals("Pending Sign Off") && !StringUtils.isEmpty(data.get("trainingPrincipalId").toString())) {
						//SystemLocalServiceUtil.addTimelineActivity("/rpec", "Status changed notification", "title", "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("trainingPrincipalId")), SambaashUtil.getScopeGroupId(siteId));
						String url = createURL(contentJson, resourceRequest,"TrainingPrincipal");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("trainingPrincipalId")), SambaashUtil.getScopeGroupId(siteId));
					} else if ((data.get("rpecStatus").equals("Pending Final Approval") || data.get("rpecStatus").equals("Pending Standard Approval")) && !StringUtils.isEmpty(data.get("mentorId").toString())) {
						//SystemLocalServiceUtil.addTimelineActivity("/rpec", "Status changed notification", "title", "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")) , SambaashUtil.getScopeGroupId(siteId));
						String url = createURL(contentJson, resourceRequest,"Mentor");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")), SambaashUtil.getScopeGroupId(siteId));
	             	}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	// ws call for add remarks
	public String createRemarks(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/new";
			SambaashUtil.printSystem("new data :: " + modeldata);
			response = new APICall(resourceRequest).postForObject(modeldata,
					subUrl);
	
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	//ws call for check if competency is upto the mark
	public String checkCompetencyProficiency(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			String model = resourceRequest.getParameter(formType).toLowerCase();
			JSONObject data = new JSONObject(modeldata);
			
			JSONObject conditionalParameter = new JSONObject();
			String genericCount = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.generic.count").getValue().toString();
			String technicalCount = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.technical.count").getValue();
			String totalPracDay = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.totalPracticalDays.count").getValue();
			String genProLvl = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.generic.profenciencyLevel").getValue();
			String techProLvl = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.technical.profenciencyLevel").getValue();
			String subjectCode = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.subjectCode").getValue();
			conditionalParameter.put("genericCount", genericCount);
			conditionalParameter.put("technicalCount", technicalCount);
			conditionalParameter.put("totalPracDay", totalPracDay);
			conditionalParameter.put("genProLvl", genProLvl);
			conditionalParameter.put("techProLvl", techProLvl);
			conditionalParameter.put("subjectCode", subjectCode);
			data.put("conditionalParameter", conditionalParameter.toString());
			
			_log.info("updateRPECRecord data --> " + data.toString());
			System.out.println("updateRPECRecord data --> " + data.toString());
			
			String subUrl = model + "/validate-candidate/" + data.getString("candidateId") ;
			SambaashUtil.printSystem("new data :: " + modeldata);
			response = new APICall(resourceRequest).postForObject(data.toString(),
					subUrl);
	
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	// ws call for update RPEC data
	public String updateRPECRecord(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			long siteId = PortalUtil.getScopeGroupId(resourceRequest);
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);

			JSONObject conditionalParameter = new JSONObject();

			String genericCount = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.generic.count").getValue().toString();
			String technicalCount = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.technical.count").getValue();
			String totalPracDay = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.totalPracticalDays.count").getValue();
			String genProLvl = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.generic.profenciencyLevel").getValue();
			String techProLvl = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.technical.profenciencyLevel").getValue();
			String subjectCode = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0, "rpec.subjectCode").getValue();
			conditionalParameter.put("genericCount", genericCount);
			conditionalParameter.put("technicalCount", technicalCount);
			conditionalParameter.put("totalPracDay", totalPracDay);
			conditionalParameter.put("genProLvl", genProLvl);
			conditionalParameter.put("techProLvl", techProLvl);
			conditionalParameter.put("subjectCode", subjectCode);
			data.put("conditionalParameter", conditionalParameter.toString());
			
			_log.info("updateRPECRecord data --> " + data.toString());
			System.out.println("updateRPECRecord data --> " + data.toString());
			
			if(data.has("mentorId"))
			{
				User mentor = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("mentorId")));
				data.put("mentorEmail", mentor.getEmailAddress());
			}
			else
			{
				data.put("mentorEmail", "");
			}
			
			if(data.has("trainingPrincipalId"))
			{
				User tpUser = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("trainingPrincipalId")));
				data.put("trainingPrincipalEmail", tpUser.getEmailAddress());
			}
			else
			{
				data.put("trainingPrincipalEmail", "");
			}
			
//			User mentor = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("mentorId")));
//			
//			_log.info("updateRPECRecord mentor --> " + mentor.toString());
//			System.out.println("updateRPECRecord mentor --> " + mentor.toString());
//			
//			User tpUser = UserLocalServiceUtil.getUser(Long.parseLong(data.getString("trainingPrincipalId")));
//			
//			_log.info("updateRPECRecord tpUser --> " + tpUser.toString());
//			System.out.println("updateRPECRecord tpUser --> " + tpUser.toString());
//			
//			data.put("mentorEmail", mentor.getEmailAddress());
//			data.put("trainingPrincipalEmail", tpUser.getEmailAddress());
			
			_log.info("updateRPECRecord data --> " + data.toString());
			System.out.println("updateRPECRecord data --> " + data.toString());

			SambaashUtil.printSystem("model data is " + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/edit/" + data.getString("storageId");
			response = new APICall(resourceRequest).postForObject(
					data.toString(), subUrl);
			
			JSONObject contentJson = new JSONObject(new JSONObject(response).getString("contentJson"));
			//String url = createURL(contentJson, resourceRequest);
			User candidate = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("candidateId")));
			String title = "Notification for RPEC Application - " + candidate.getFirstName() + " " + candidate.getLastName();
			//System.out.println("URL --> " + url);
			
			if(response != null && new JSONObject(response).has("contentJson")) {
				if(data.get("rpecStatus").equals("Pending Final Approval") || data.get("rpecStatus").equals("Pending Sign Off") || data.get("rpecStatus").equals("Pending Standard Approval") 
						|| data.get("rpecStatus").equals("Rejected") || data.get("rpecStatus").equals("Approved")) {
					if(data.get("rpecStatus").equals("Pending Sign Off") && !StringUtils.isEmpty(data.get("trainingPrincipalId").toString())) {
						String url = createURL(contentJson, resourceRequest, "TrainingPrincipal");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("trainingPrincipalId")), SambaashUtil.getScopeGroupId(siteId));
					} else if ((data.get("rpecStatus").equals("Pending Final Approval") || data.get("rpecStatus").equals("Pending Standard Approval")) && !StringUtils.isEmpty(data.get("mentorId").toString())) {
						String url = createURL(contentJson, resourceRequest, "Mentor");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")), SambaashUtil.getScopeGroupId(siteId));
	             	} else if ((data.get("rpecStatus").equals("Rejected"))) {
						//SystemLocalServiceUtil.addTimelineActivity("/rpec", "Status changed notification", "title", "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")) , SambaashUtil.getScopeGroupId(siteId));
	             		title = "Notification for RPEC Application - Rejected";
	             		String url = createURL(contentJson, resourceRequest, "Candidate");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("statusUpdateBy").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("candidateId")), SambaashUtil.getScopeGroupId(siteId));
	             	} else if ((data.get("rpecStatus").equals("Approved"))) {
						//SystemLocalServiceUtil.addTimelineActivity("/rpec", "Status changed notification", "title", "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")) , SambaashUtil.getScopeGroupId(siteId));
	             		title = "Notification for RPEC Application - Approved";
	             		String url = createURL(contentJson, resourceRequest, "Candidate");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("statusUpdateBy").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("candidateId")), SambaashUtil.getScopeGroupId(siteId));
	             	}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	// ws call for fetch RPEC remarks
	
	private String createURL(JSONObject contentJson, ResourceRequest resourceRequest,String userType)
	{
		try
		{
			PortletPreferences prefer = resourceRequest.getPreferences();
			String baseURL = prefer.getMap().get(SystemSetupConstants.PREF_BASE_URL)[0];
			StringBuilder url = new StringBuilder();
			url.append(baseURL)
			.append("?")
			.append("p_p_id=eRPEC_WAR_SPRPECportlet").append("&")
			.append("p_p_lifecycle=0").append("&")
			.append("p_p_state=normal").append("&")
			.append("_eRPEC_WAR_SPRPECportlet_jspPage=%2Fhtml%2FRPEC%2Faddrpec.jsp").append("&")
			.append("_eRPEC_WAR_SPRPECportlet_storageId=").append(contentJson.getString("storageId")).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_formTypeName=").append(resourceRequest.getParameter(formType).toLowerCase()).append("&");
			
			if(userType.equals("Candidate"))
			{
				url.append("_eRPEC_WAR_SPRPECportlet_mode=view").append("&");
			}
			else
			{
				url.append("_eRPEC_WAR_SPRPECportlet_mode=edit").append("&");
			}
			
			url.append("_eRPEC_WAR_SPRPECportlet_candidateId=").append(contentJson.get("candidateId")).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_rpecStatus=").append(contentJson.getString("rpecStatus")).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_isStandardReview=").append(contentJson.getString("isStandardReview")).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_isFinalReview=").append(contentJson.getString("isFinalReview")).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_isSignOff=").append(contentJson.getString("isSignOff")).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_userType=").append(userType).append("&")
			.append("_eRPEC_WAR_SPRPECportlet_loggedInUser=").append(PortalUtil.getUserId(resourceRequest));
			
			return url.toString();
		}catch(JSONException e)
		{
			_log.error(e);
		}
		return null;
		
	}
	public String fetchRPECRemarks(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);

			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/fetchLatestRemark/"
					+ data.getString("storageId");
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
		
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	// ws for update RPEC status
	public String updateRPECStatus(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = "";
		try {
			long siteId = PortalUtil.getScopeGroupId(resourceRequest);
			String modeldata = resourceRequest.getParameter("data");

			JSONObject data = new JSONObject(modeldata);
			JSONObject contentJson = new JSONObject(data.get("contentJson")
					.toString());
			if (contentJson.getString("status").equalsIgnoreCase(
					"Pending Sign Off")) {
				String genericCount = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.generic.count").getValue().toString();
				String technicalCount = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.technical.count").getValue();
				String totalPracDay = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.totalPracticalDays.count").getValue();
				String genProLvl = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.generic.profenciencyLevel").getValue();
				String techProLvl = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.technical.profenciencyLevel")
						.getValue();
				String subjectCode = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
								0, "rpec.subjectCode").getValue();
				contentJson.put("genericCount", genericCount);
				contentJson.put("technicalCount", technicalCount);
				contentJson.put("totalPracDay", totalPracDay);
				contentJson.put("genProLvl", genProLvl);
				contentJson.put("techProLvl", techProLvl);
				contentJson.put("subjectCode", subjectCode);
			}
			
			data.put("contentJson", contentJson.toString());
			
			_log.error("updateRPECStatus contentJson --> " + contentJson.toString());
			System.out.println("updateRPECStatus contentJson --> " + contentJson.toString());
			
			if(contentJson.has("mentorId"))
			{
				User mentor = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("mentorId")));
				data.put("mentorEmail", mentor.getEmailAddress());
				_log.error("updateRPECStatus mentor --> " + mentor.toString());
			}
			else
			{
				data.put("mentorEmail", "");
			}
			
			if(contentJson.has("trainingPrincipalId"))
			{
				User tpUser = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("trainingPrincipalId")));
				data.put("trainingPrincipalEmail", tpUser.getEmailAddress());
				_log.error("updateRPECStatus tpUser --> " + tpUser.toString());
			}
			else
			{
				data.put("trainingPrincipalEmail", "");
			}
			
//			User mentor = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("mentorId")));
//			User tpUser = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("trainingPrincipalId")));
			
//			_log.error("updateRPECStatus mentor --> " + mentor.toString());
//			System.out.println("updateRPECStatus mentor --> " + mentor.toString());
			
//			_log.error("updateRPECStatus tpUser --> " + tpUser.toString());
//			System.out.println("updateRPECStatus tpUser --> " + tpUser.toString());
			
//			data.put("mentorEmail", mentor.getEmailAddress());
//			data.put("trainingPrincipalEmail", tpUser.getEmailAddress());
			
			_log.error("updateRPECStatus data --> " + data.toString());
			System.out.println("updateRPECStatus data --> " + data.toString());
			
			SambaashUtil.printSystem("model data is " + data.toString());
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/updateStatus/"
					+ data.getString("storageId");
			response = new APICall(resourceRequest).postForObject(
					data.toString(), subUrl);
			
//			response = new APICall(resourceRequest).postForObject(
//					data.toString(), subUrl);
			
			contentJson = new JSONObject(new JSONObject(response).getString("contentJson"));
			//String url = createURL(contentJson, resourceRequest);
			User candidate = UserLocalServiceUtil.getUser(Long.parseLong(contentJson.getString("candidateId")));
			String title = "Notification for RPEC Application - " + candidate.getFirstName() + " " + candidate.getLastName();
			//System.out.println("URL --> " + url);
			data = new JSONObject(data.getString("contentJson"));
			if(response != null && new JSONObject(response).has("contentJson")) {
				if(data.get("status").equals("Pending Final Approval") || data.get("status").equals("Pending Sign Off") || data.get("status").equals("Pending Standard Approval") 
						|| data.get("status").equals("Rejected") || data.get("status").equals("Approved") || (data.get("status").equals("Completed"))) {
					if(data.get("status").equals("Pending Sign Off") && !StringUtils.isEmpty(data.get("trainingPrincipalId").toString())) {
						String url = createURL(contentJson, resourceRequest, "TrainingPrincipal");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("status").toString(), Long.parseLong(data.get("statusUpdateBy").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(contentJson.get("trainingPrincipalId")), SambaashUtil.getScopeGroupId(siteId));
					} else if ((data.get("status").equals("Pending Final Approval") || data.get("status").equals("Pending Standard Approval")) && !StringUtils.isEmpty(data.get("mentorId").toString())) {
						String url = createURL(contentJson, resourceRequest, "Mentor");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("status").toString(), Long.parseLong(data.get("statusUpdateBy").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(contentJson.get("mentorId")), SambaashUtil.getScopeGroupId(siteId));
	             	} else if ((data.get("status").equals("Rejected"))) {
						//SystemLocalServiceUtil.addTimelineActivity("/rpec", "Status changed notification", "title", "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")) , SambaashUtil.getScopeGroupId(siteId));
	             		title = "Notification for RPEC Application - Rejected";
	             		String url = createURL(contentJson, resourceRequest, "Candidate");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("status").toString(), Long.parseLong(data.get("statusUpdateBy").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(contentJson.get("candidateId")), SambaashUtil.getScopeGroupId(siteId));
	             	} else if ((data.get("status").equals("Approved")) || (data.get("status").equals("Completed"))) {
						//SystemLocalServiceUtil.addTimelineActivity("/rpec", "Status changed notification", "title", "desc", "", data.get("rpecStatus").toString(), Long.parseLong(data.get("candidateId").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(data.get("mentorId")) , SambaashUtil.getScopeGroupId(siteId));
	             		title = "Notification for RPEC Application - Approved";
	             		String url = createURL(contentJson, resourceRequest, "Candidate");
						SystemLocalServiceUtil.addTimelineActivity(url, "Status changed notification", title, "desc", "", data.get("status").toString(), Long.parseLong(data.get("statusUpdateBy").toString()), "RPEC", "RPEC", SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)resourceRequest).getHttpServletRequest()), "", String.valueOf(contentJson.get("candidateId")), SambaashUtil.getScopeGroupId(siteId));
	             	}
				}
			}
			

		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String getUserType(String canRole, String relcRole,
			String trainingRole, String mentor, Long userIdForRole) {

		try {

			List<Role> userRole = RoleLocalServiceUtil
					.getUserRoles(userIdForRole);
			List<String> roleNameLst = new ArrayList<String>();
			for (Role role : userRole) {
				
				_log.info("user Role :: " + role.getName().toLowerCase());
				roleNameLst.add(role.getName().toLowerCase());
			}
			if (roleNameLst.contains(trainingRole.toLowerCase())) {

				return "TrainingPrincipal";
			} else if (roleNameLst.contains(relcRole.toLowerCase())) {

				return "RELCUser";
			} else if (roleNameLst.contains(canRole.toLowerCase())) {

				return "Candidate";
			} else if (roleNameLst.contains(mentor.toLowerCase())) {

				return "Mentor";
			} else {
				return "";
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
		return "";
	}

	public void exportRowToExcelFile(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {
			_log.debug("exportRowToExcelFile invoked");
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String model = resourceRequest.getParameter(formTypeStr);
			String restmodel = model.toLowerCase();
			String subUrl = restmodel + "/export/" + storageId;
			com.liferay.portal.kernel.json.JSONObject jsonExportQuery = JSONFactoryUtil
					.createJSONObject();
			com.liferay.portal.kernel.json.JSONObject jsonTitleOrder = getTitleOrder(
					resourceRequest, model);
			
			jsonTitleOrder.getJSONObject(TITLES).remove("contentJson.Status");
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			System.out.println("ExportRow Called...");
			String subUrl2 = "/configuration/get/e-RPEC";
			String strColumnRsp = new APICall(resourceRequest).exchange(
					subUrl2, HttpMethod.GET);
			String strColumn = new org.json.JSONObject(strColumnRsp)
					.getJSONObject("contentJson").getString("columnlist");
			List<String> items = Arrays.asList(strColumn.split("\\s*,\\s*"));
			jsonExportQuery.put(COLUMN_LIST,
					JSONFactoryUtil.createJSONArray(items.toString()));

			new APICall(resourceRequest).downloadObjects(
					jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceResponse, resourceRequest);

			resourceRequest = null;
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private com.liferay.portal.kernel.json.JSONObject getTitleOrder(
			ResourceRequest resourceRequest, String modelName) {
		com.liferay.portal.kernel.json.JSONObject jsonTitleOrder = JSONFactoryUtil
				.createJSONObject();
		com.liferay.portal.kernel.json.JSONObject titles = JSONFactoryUtil
				.createJSONObject();
		com.liferay.portal.kernel.json.JSONArray order = JSONFactoryUtil
				.createJSONArray();
		List<String> columnsList1 = getMicroserviceModelColumnList(
				resourceRequest, modelName);
		for (String column : columnsList1) {
			order.put(CONTENT_JSON_PREFIX + column);
			_log.info("order:" + column);
		}
		order.put(CREATED_BY);
		order.put(CREATED_DATE);
		order.put(LAST_MODIFIED_BY);
		order.put(LAST_MODIFIED_DATE);

		String columnTitles = getMicroserviceModelColumnTitleMap(
				resourceRequest, modelName);
		com.liferay.portal.kernel.json.JSONArray allModelColumnTitlesArray;
		try {
			allModelColumnTitlesArray = JSONFactoryUtil
					.createJSONArray(columnTitles);
			for (int i = 0; i < allModelColumnTitlesArray.length(); i++) {
				titles.put(
						CONTENT_JSON_PREFIX
								+ allModelColumnTitlesArray.getJSONObject(i)
										.getString("key"),
						allModelColumnTitlesArray.getJSONObject(i).getString(
								"translation"));
				_log.info("titles:"
						+ allModelColumnTitlesArray.getJSONObject(i).getString(
								"translation"));
			}
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		titles.put(CREATED_BY, "Created By");
		titles.put(CREATED_DATE, "Created Date");
		titles.put(LAST_MODIFIED_BY, "Last Modified By");
		titles.put(LAST_MODIFIED_DATE, "Last Modified Date");
		titles.put("reviewPeriodNumber", "Review Period Number");
		titles.put("startDate", "Start Date");
		titles.put("endDate", "End Date");
		titles.put("accreditedTrainingOrganisation", "Accredited Training Organisation");
		titles.put("mentorName", "Mentor Name");
		titles.put("candidateJobRole", "Candidate Job Role");
		titles.put("totalDaysSpentOnPracticalExperience", "Total Days Spent On Practical Experience");
		titles.put("rpecStatus", "RPEC Status");

		jsonTitleOrder.put(TITLES, titles);
		jsonTitleOrder.put(ORDER, order);
		return jsonTitleOrder;

	}

	public String getMicroserviceModelColumnTitleMap(
			ResourceRequest resourceRequest, String modelName) {

		Map<String, String> map = new HashMap<>();
		String response = "";
		try {
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap";
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			// response = response.substring(1, response.length() - 1);
			// String[] keyValuePairs = response.split(",");
			// for (String pair : keyValuePairs) {
			// String[] entry = pair.split("=");
			// map.put(entry[0].trim(), entry[1].trim());
			// }

		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public List<String> getMicroserviceModelColumnList(
			ResourceRequest resourceRequest, String modelName) {
		String response = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumns";
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			tempArray = response.split(",");

		} catch (Exception e) {
			_log.error(e);
		}
		return (Arrays.asList(tempArray));

	}

	// ws call for archive record
	public String archiveRecord(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		String response = null;
		try {
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/" + data.getString("storageId");
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.DELETE);

		} catch (Exception e) {
			_log.error(e);
			response = e.getMessage();
		}
		return response;
	}
	
	public String candidateProfile(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = null;
		try {
			long siteId = PortalUtil.getScopeGroupId(resourceRequest);
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);
			if(data.has("userId"))
			{
				response = SystemServiceUtil.getRecord(data.getString("userId"), "Candidate", Long.parseLong(data.getString("userId")), siteId);
			}

		} catch (Exception e) {
			_log.error(e);
			response = e.getMessage();
		}
		return response;
	}
	
	public com.liferay.portal.kernel.json.JSONArray getCandidateListOfMentor(long mentorId, long siteId) {
		try {
			String response = null;
			String subUrl = "candidate/mentor/" + mentorId;
			response = new APICall(mentorId, siteId).exchange(subUrl, HttpMethod.GET);
			com.liferay.portal.kernel.json.JSONArray candArray = JSONFactoryUtil.createJSONArray(response);
			com.liferay.portal.kernel.json.JSONArray newCandArray = JSONFactoryUtil.createJSONArray(response);
			for (int i = 0; i < candArray.length(); i++) {
				newCandArray.put(JSONFactoryUtil.createJSONObject(candArray.getString(i)));
			}
			return newCandArray;
		} catch (Exception e) {
			_log.error(e);
		}
		return JSONFactoryUtil.createJSONArray();
	}
	
	public com.liferay.portal.kernel.json.JSONArray getCandidateListOfTp(long mentorId, long siteId) {
		try {
			String response = null;
			String subUrl = "candidate/tp/" + mentorId;
			response = new APICall(mentorId, siteId).exchange(subUrl, HttpMethod.GET);
			com.liferay.portal.kernel.json.JSONArray candArray = JSONFactoryUtil.createJSONArray(response);
			com.liferay.portal.kernel.json.JSONArray newCandArray = JSONFactoryUtil.createJSONArray(response);
			for (int i = 0; i < candArray.length(); i++) {
				newCandArray.put(JSONFactoryUtil.createJSONObject(candArray.getString(i)));
			}
			return newCandArray;
		} catch (Exception e) {
			_log.error(e);
		}
		return JSONFactoryUtil.createJSONArray();
	}
	
	
	public String getCandidateListOfInternalUser(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		com.liferay.portal.kernel.json.JSONArray users = JSONFactoryUtil.createJSONArray();
		try
		{
			String modeldata = resourceRequest.getParameter("data");
			JSONObject data = new JSONObject(modeldata);
			
			if(data.getString("userType").toLowerCase().equals("relcuser"))
			{
				users = SystemServiceUtil.getModelList("candidate",
		                "UserId,IDNumber,FirstName,LastName", PortalUtil.getScopeGroupId(resourceRequest), 
		                "{\"contentJson.Status\":\"Active\"}",
		                "[{\"direction\":\"asc\",\"field\":\"FirstName\",\"contentJSON\":\"true\"}]", 2147483647);
			}
			
			if(data.getString("userType").toLowerCase().equals("mentor"))
			{
				users = getCandidateListOfMentor(PortalUtil.getUserId(resourceRequest), PortalUtil.getScopeGroupId(resourceRequest));
			}
			
			if(data.getString("userType").toLowerCase().equals("trainingprincipal"))
			{
				users = getCandidateListOfTp(PortalUtil.getUserId(resourceRequest), PortalUtil.getScopeGroupId(resourceRequest));
			}
			
		}
		catch(Exception e)
		{
			_log.error(e);
		}
		return users.toString();
	}
}