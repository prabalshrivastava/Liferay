package com.sambaash.platform.portlet.pe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONException;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.pe.PEEntityClassRegister;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.handlers.job.listener.AbstractJobListener;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.helpers.ProcessBuilderHelper;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.model.PERule;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.ClassLoaderUtil;
import com.sambaash.platform.util.ConvertUtil;
import com.sambaash.platform.util.SambaashUtil;

class ProcessBuilderActionHelper extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(ProcessBuilderActionHelper.class);
	
	//snippet for xml generation
	private static Document doc = null;
	private static Element rootElement, forms, formsV2, jsps, payments, paymentV2s, pricings, apis, entities, previews, processes, pages, msgs, actions, mails, statuses, accounts, timers, scheduledJobs, customActions;
	
	//Convert xml to string for saving into sppeprocess table of db
	public static String getStringFromDocument(Document doc) throws TransformerException {

		DOMSource domSource = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		return writer.toString();
	}

	public static void loadProcessDetailInToResponseObj(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {
		
		long processId = ParamUtil.getLong(request, "processId", -1);

		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj = getProcessDetailById(processId);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("processDetail", obj);

		streamWriter(response, jsonObject);
	}
	
	public static void loadStatusTypeDetailInToResponseObj(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {
		
		long spPEProcessStatusTypeId = ParamUtil.getLong(request, "statusTypeId", -1);

		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj = getStatusTypeDetailById(spPEProcessStatusTypeId);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("statusTypeDetail", obj);

		streamWriter(response, jsonObject);
	}
	
	private static JSONObject getProcessDetailById(long processId) throws PortalException, SystemException{
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		PEProcess process = PEProcessLocalServiceUtil.getPEProcess(processId);
		
		obj.put("processId", process.getSpPEProcessId());
		obj.put("processName", process.getName());
		obj.put("enityClassId", process.getEntityClassId());
		obj.put("agentRoleIds", process.getAgentRoleIds());
		obj.put("approverIds", process.getApproveRoleIds());
		obj.put("supervisorRoleIds", process.getSupervisorRoleIds());
		obj.put("applicantRoleId", process.getApplicantRoleId());
		obj.put("approverPagaeName", process.getApproverPageName());
		obj.put("agentPageName", process.getAgentPageName());
		obj.put("supervisorPageName", process.getSupervisorPageName());
		obj.put("userPageName", process.getUserPageName());
		obj.put("entityTitle", process.getEntityTitle());
		obj.put("isAgentEnabled", process.getAgentEnabled());
		obj.put("closedReasonVocId", process.getClosedReasonVocId());
		obj.put("isAccountCreationEmailEnabled", process.getAccountCreationEmailEnabled());
		obj.put("isEditFeeDetails", process.getEditFeeDetails());
		obj.put("isEnableAssignment", process.getEnableAssignment());
		obj.put("scheduleModelId", process.getScheduleModelId());
		obj.put("isEnableSingleSubmission", process.getEnableSingleSubmission());
		obj.put("orientation", process.getOrientation());
		obj.put("isShowHeader", process.isShowHeader());
		obj.put("isEnableFirstStepProgress", process.isEnableFirstStepProgress());
		obj.put("subProductTypeId", process.getSubProductTypeId());
		obj.put("productTypeId", process.getProductTypeId());
		obj.put("singleSubmissionErrorMsg", process.getSingleSubmissionErrorMsg());
		
		return obj;
	}

	private static JSONObject getStatusTypeDetailById(long spPEProcessStatusTypeId) throws PortalException, SystemException{
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		PEProcessStatusType processStatusType = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(spPEProcessStatusTypeId);
			obj.put("statusTypeId",processStatusType.getSpPEProcessStatusTypeId());
			obj.put("statusTypeName", processStatusType.getStatusName());
			obj.put("statusTypeStageId", processStatusType.getSpPEProcessStageId());
			obj.put("statusTypeSeqNo", processStatusType.getSeqNo());
			obj.put("statusTypeProcessId", processStatusType.getSpPEProcessId());
			obj.put("statusTypeDateCreated", processStatusType.getCreateDate());
			
		return obj;	
	}
	
	public static void prepareEntities(ResourceRequest req, ResourceResponse res) {

		Set<Long> ids = PEEntityClassRegister.getClassNameIds();

		JSONObject entityNameIdMap = JSONFactoryUtil.createJSONObject();

		for (long id : ids)
			entityNameIdMap.put(Long.toString(id), PEEntityClassRegister.getDisplayName(id));

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("entities", entityNameIdMap);

		streamWriter(res, jsonObject);
	}
	
	public static void prepareSchedules(ResourceRequest req, ResourceResponse res) throws JSONException {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONObject jsonObjContent = JSONFactoryUtil.createJSONObject();
		JSONObject reustObj = JSONFactoryUtil.createJSONObject();
		try {
		String modelData = "{'limit':'99999','modelName':'Schedule','page':'0','formType':'Schedule','filterdata':[]}";
		if (!modelData.isEmpty() && modelData != null) {
			req.setAttribute("data", modelData);
			String elkListing = SystemLocalServiceUtil.getElasticSearchListing(req,
					res);
			
				data = JSONFactoryUtil.createJSONObject(elkListing);
			
		}
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray(data.getString("content"));
		for (int i=0; i<jsonArr.length(); i++){
			jsonObjContent = JSONFactoryUtil.createJSONObject(jsonArr.getJSONObject(i).getString("contentJson"));
			reustObj.put(jsonArr.getJSONObject(i).getString("modelId"), jsonObjContent.getString("Name"));
		}
		
		jsonObject.put("schedules", reustObj);
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			_log.error(e.getMessage());
		}
		streamWriter(res, jsonObject);
	}
	
	public static void prepareSubProductType(ResourceRequest req, ResourceResponse res) throws JSONException, SystemException {
		JSONObject subProductTypeJSON = JSONFactoryUtil.createJSONObject();
		List<SPSiteSetup> subProductTypeList = SPSiteSetupLocalServiceUtil.getSPSiteSetups(-1, -1);
		for(SPSiteSetup subProductType : subProductTypeList){
			subProductTypeJSON.put(Long.toString(subProductType.getSubProductId()), subProductType.getSubProductName());
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("subProductType", subProductTypeJSON);

		streamWriter(res, jsonObject);
	}
	
	public static void prepareProductType(ResourceRequest req, ResourceResponse res) throws JSONException, SystemException, PortalException {
		JSONObject productTypeJSON = JSONFactoryUtil.createJSONObject();
		long subProductTypeId = ParamUtil.getLong(req, "subProductTypeId");
		if (subProductTypeId > 0){
			List<SPSiteSetup> productTypeList = SPSiteSetupLocalServiceUtil.findBySubProductId(subProductTypeId);
			for(SPSiteSetup productType : productTypeList){
				productTypeJSON.put(Long.toString(productType.getProductId()), productType.getProductName());
			}
		}
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("productType", productTypeJSON);

		streamWriter(res, jsonObject);
	}
	
	public static void prepareProcess(ResourceRequest req, ResourceResponse res) throws SystemException {
		JSONObject processes = JSONFactoryUtil.createJSONObject();
		List<PEProcess> processList = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
		for(PEProcess process : processList){
			processes.put(Long.toString(process.getSpPEProcessId()), process.getName());
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("processes", processes);

		streamWriter(res, jsonObject);
	}
	
	private static void prepareAllProcessList(ResourceRequest req, ResourceResponse res) throws SystemException {
		JSONArray processes = JSONFactoryUtil.createJSONArray();
		JSONObject obj=null;
		List<PEProcess> processList = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
		for(PEProcess process : processList){
			obj = JSONFactoryUtil.createJSONObject();
			obj.put("processId", process.getSpPEProcessId());
			obj.put("processName", process.getName());
			obj.put("status", process.getStatus());
			obj.put("createDate", PEHelper.getDateStrddMMYYYYHMS(process.getCreateDate()));
			obj.put("enityClassId", process.getEntityClassId());
			obj.put("agentRoleIds", process.getAgentRoleIds());
			obj.put("approverIds", process.getApproveRoleIds());
			obj.put("supervisorRoleIds", process.getSupervisorRoleIds());
			obj.put("applicantRoleId", process.getApplicantRoleId());
			obj.put("approverPageName", process.getApproverPageName());
			obj.put("userPageName", process.getUserPageName());
			obj.put("agentPageName", process.getAgentPageName());
			obj.put("supervisorPageName", process.getSupervisorPageName());
			obj.put("entityTitle", process.getEntityTitle());
			obj.put("isAgentEnabled", process.getAgentEnabled());
			obj.put("closedReasonVocId", process.getClosedReasonVocId());
			obj.put("isAccountCreationEmailEnabled", process.getAccountCreationEmailEnabled());
			obj.put("isEditFeeDetails", process.getEditFeeDetails());
			obj.put("isEnableAssignment", process.getEnableAssignment());
			obj.put("scheduleModelId", process.getScheduleModelId());
			obj.put("isEnableSingleSubmission", process.getEnableSingleSubmission());
			obj.put("orientation", process.getOrientation());
			obj.put("isShowHeader", process.isShowHeader());
			obj.put("isEnableFirstStepProgress", process.isEnableFirstStepProgress());
			obj.put("subProductTypeId", process.getSubProductTypeId());
			obj.put("productTypeId", process.getProductTypeId());
			obj.put("singleSubmissionErrorMsg", process.getSingleSubmissionErrorMsg());
			processes.put(obj);
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("processes", processes);

		streamWriter(res, jsonObject);
	}
	
	private static void prepareAllProcessStatusTypes(ResourceRequest req, ResourceResponse res) throws SystemException {
		JSONArray statusTypes = JSONFactoryUtil.createJSONArray();
		JSONObject obj=null;
		List<PEProcessStatusType> processStatusTypeList = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusTypes(-1, -1);
		for(PEProcessStatusType status : processStatusTypeList){
			obj = JSONFactoryUtil.createJSONObject();
			obj.put("statusTypeId",status.getSpPEProcessStatusTypeId());
			obj.put("statusTypeName", status.getStatusName());
			obj.put("statusTypeStageId", status.getSpPEProcessStageId());
			obj.put("statusTypeSeqNo", status.getSeqNo());
			obj.put("statusTypeProcessId", status.getSpPEProcessId());
			obj.put("statusTypeDateCreated", PEHelper.getDateStrddMMYYYYHMS(status.getCreateDate()));
			
			statusTypes.put(obj);
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("statusTypes", statusTypes);

		streamWriter(res, jsonObject);
	}
	
	public static void prepareRoleDropDownData(ResourceRequest req, ResourceResponse res){
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try {
			jsonObject.put("roles", ProcessBuilderHelper.loadRoles());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		streamWriter(res, jsonObject);
	}

	public static void prepareModalDropDownData(ResourceRequest request, ResourceResponse response) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		String componentType = ParamUtil.getString(request, "componentType", StringPool.BLANK);
		long processId = ParamUtil.getLong(request, "processId");
		JSONObject obj = null ;
		switch(componentType.toLowerCase()) {

			case "form":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("RuleSetsForm", ProcessBuilderHelper.loadRuleSetsForm());
				obj.put("roles", ProcessBuilderHelper.loadRoles());
				obj.put("steps", ProcessBuilderHelper.loadStatusTypesAndStatus(processId));
				jsonObject.put("model_popup_dropdown_json", obj);
				break;

			case "formv2":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("RuleSetsForm", RulesMicroserviceLocalServiceUtil.getPERuleSets(true, "form"));
				obj.put("roles", ProcessBuilderHelper.loadRoles());
				obj.put("steps", ProcessBuilderHelper.loadStatusTypesAndStatus(processId));
				jsonObject.put("model_popup_dropdown_json", obj);
				break;

			case "jsp":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("roles", ProcessBuilderHelper.loadRoles());
				obj.put("ruleSetJsp",ProcessBuilderHelper.loadRuleSetsJsp());
				obj.put("steps", ProcessBuilderHelper.loadStatusTypesAndStatus(processId));
				obj.put("RuleSetsJSP", RulesMicroserviceLocalServiceUtil.getPERuleSets(true, "jsp"));
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "payment":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("ruleSetJsp",ProcessBuilderHelper.loadRuleSetsJsp());
				obj.put("providerList",ProcessBuilderHelper.loadPaymentProviders());
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "paymentv2":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("RuleSetsJSP", RulesMicroserviceLocalServiceUtil.getPERuleSets(true, "jsp"));
				obj.put("providerList",ProcessBuilderHelper.loadPaymentProviders());
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "pricing":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("priceSchemes",PricingMicroserviceLocalServiceUtil.getPEPriceSchemeLOV(themeDisplay.getScopeGroupId()));
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "api":
				obj = JSONFactoryUtil.createJSONObject();
				// no drop down list
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "entity":
				obj = JSONFactoryUtil.createJSONObject();
				// no drop down list
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "preview":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("previewList",ProcessBuilderHelper.loadPreviewList());
				obj.put("customList",ProcessBuilderHelper.loadCustomList());
				jsonObject.put("model_popup_dropdown_json",obj );
				break;

			case "process": 
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("processRulesV1",ProcessBuilderHelper.loadRuleSetsProcess());
				obj.put("processRulesV2",RulesMicroserviceLocalServiceUtil.getPERuleSets(true, "process"));
				jsonObject.put("model_popup_dropdown_json", obj); 
				break;

			case "mail":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("mailTemplate", ProcessBuilderHelper.loadMailTemplates());
				obj.put("roles", ProcessBuilderHelper.loadRoles());
				jsonObject.put("model_popup_dropdown_json", obj);
				break;
				
			case "vocabulary":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("vocabulary", ProcessBuilderHelper.loadVocabulary());
				jsonObject.put("model_popup_dropdown_json", obj);
				break;

			case "status": 
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("mailTemplate", ProcessBuilderHelper.loadMailTemplates());
				obj.put("roles", ProcessBuilderHelper.loadRoles());
				obj.put("statusTypes", ProcessBuilderHelper.loadStatusTypes(processId,false));
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "stage":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("stages",ProcessBuilderHelper.loadStages(false));
				jsonObject.put("model_popup_dropdown_json",obj );
				break;
				
			case "customaction":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("customAction",ProcessBuilderHelper.loadCustomActionDetails());
				jsonObject.put("model_popup_dropdown_json",obj );
				break;

			case "timer":
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("mailTemplate", ProcessBuilderHelper.loadMailTemplates());
				obj.put("roles", ProcessBuilderHelper.loadRoles());
				obj.put("RuleSetsProcess", RulesMicroserviceLocalServiceUtil.getPERuleSets(true, "process"));
				obj.put("peJobListeners", retrieveJobListenerClasses());
				jsonObject.put("model_popup_dropdown_json", obj);
				break;
				
			case "account":
				jsonObject.put("model_popup_dropdown_json", ProcessBuilderHelper.loadMailTemplates());
				break;

			default: 
				jsonObject.put("model_popup_dropdown_json", "empty");
		}
	
		streamWriter(response, jsonObject);
	}

	private static JSONArray retrieveJobListenerClasses() {
		JSONArray arr = JSONFactoryUtil.createJSONArray();
		try {
			for (Class<?> c: ClassLoaderUtil.getClassesInPackage(PEConstants.JOB_LISTENER_PACKAGE, SPScheduledJob.class)) {
				String simpleName = c.getSimpleName();
				if ("AbstractJobListener".equals(simpleName)) continue;
				JSONObject o = JSONFactoryUtil.createJSONObject();
				o.put("id", simpleName);
				o.put("name", simpleName);
				arr.put(o);
			}
		} catch (Exception e) {
			_log.error("Unable to get list of Job listeners", e);
		}
		return arr;
	}

	public static void validateEmailAddress(ResourceRequest request, ResourceResponse response) throws SystemException, com.liferay.portal.kernel.json.JSONException {
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		String email = ParamUtil.getString(request, "emailAddress", StringPool.BLANK);
		
		
		if (Validator.isNull(email) || !Validator.isEmailAddress(email)) {
			jsonObject.put("result", "Undeliverable");
		} else{
			// Call to ApI
			RestTemplate restTemplate = new RestTemplate();
			
			String url = SambaashUtil.getParameter(SambaashConstants.API_EMAIL_VALIDATION, SambaashConstants.DEFAULT_GROUP_ID_LONG);
			url = StringUtil.replace(url, new String[]{"[EMAIL_ADDRESS]"}, 
					new String[]{String.valueOf(email)});
			
			String str = restTemplate.getForEntity(url, String.class).getBody();
			JSONObject obj = JSONFactoryUtil.createJSONObject(str);
			String result = obj.getString("result");
			if (result.equalsIgnoreCase("undeliverable")) {
				jsonObject.put("result", "Undeliverable");
			} else if (result.equalsIgnoreCase("unknown")) {
				jsonObject.put("result", "Unknown - The destination mail server is too slow or temporarily unavailable. In some cases, retrying your request after about 5 minutes will return a valid or invalid response. If you still want to continue, click on Save");
			} else if (result.equalsIgnoreCase("risky")) {
				jsonObject.put("result", "Risky - The email address has quality issues that may result in a bounce or low engagement. If you still want to continue, click on Save");
			} else {
				jsonObject.put("result", "Success");
			}
		}
		
			streamWriter(response, jsonObject);
		
	}
	
	public static void prepareRuleSetId(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {

		long formId = ParamUtil.getLong(request, "formID");

		PERule peRuleList = PERuleLocalServiceUtil.getPERule(formId);
		String ruleSetId = Long.toString(peRuleList.getSpPERuleSetId());

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("ruleSetId", ruleSetId);

		streamWriter(response, jsonObject);
	}
	
	protected static void addProcess(ResourceRequest request, ResourceResponse response) throws SystemException {

		PEProcess process = PEProcessLocalServiceUtil.create();

		String processName = ParamUtil.getString(request, "processName", StringPool.BLANK);
		long processEntity = ParamUtil.getLong(request, "processEntityClassOptions", -1);

		String agentRoleIds[] = ParamUtil.getParameterValues(request, "agentRoleIds");
		String approverIds[] = ParamUtil.getParameterValues(request, "approverIds");
		String supervisorRoleIds[] = ParamUtil.getParameterValues(request, "supervisorRoleIds");
		long applicantRoleId = ParamUtil.getLong(request, "applicantRoleId");
		String approverPageName = ParamUtil.getString(request, "approverPageName", StringPool.BLANK);
		String userPageName = ParamUtil.getString(request, "userPageName", StringPool.BLANK);
		String agentPageName = ParamUtil.getString(request, "agentPageName", StringPool.BLANK);
		String supervisorPageName = ParamUtil.getString(request, "supervisorPageName", StringPool.BLANK);
		String entityTitle = ParamUtil.getString(request, "entityTitle", StringPool.BLANK);
		boolean isAgentEnabled = ParamUtil.getBoolean(request, "agentEnabled", false);
		long closedReasonVocId = ParamUtil.getLong(request, "closedReasonVocId");
		boolean isAccountCreationEmailEnabled = ParamUtil.getBoolean(request, "accountCreationEmailEnabled", false);
		boolean isEditFeeDetails = ParamUtil.getBoolean(request, "editFeeDetails", false);
		boolean isEnableAssignment = ParamUtil.getBoolean(request, "enableAssignment", false);
		String scheduleOptions = ParamUtil.getString(request, "scheduleOptions");
		String subProductTypeId = ParamUtil.getString(request, "subProductTypeId");
		String productTypeId = ParamUtil.getString(request, "productTypeId");
		boolean isEnableSingleSubmission = ParamUtil.getBoolean(request, "enableSingleSubmission", false);
		boolean isShowHeader = ParamUtil.getBoolean(request, "showHeader", false);
		boolean isEnableFirstStepProgress = ParamUtil.getBoolean(request, "enableFirstStepProgress", false);
		String orientation = ParamUtil.getString(request, "orientation", StringPool.BLANK);
		String singleSubmissionErrorMsg = ParamUtil.getString(request, "singleSubmissionErrorMsg", StringPool.BLANK);

		//Set above parameters
		process.setName(processName);
		process.setEntityClassId(processEntity);
		process.setAgentRoleIds(Arrays.toString(agentRoleIds).replaceAll("[\\[\\]]", StringPool.BLANK));
		process.setApproveRoleIds(Arrays.toString(approverIds).replaceAll("[\\[\\]]", StringPool.BLANK));
		process.setSupervisorRoleIds(Arrays.toString(supervisorRoleIds).replaceAll("[\\[\\]]", StringPool.BLANK));
		process.setApplicantRoleId(applicantRoleId);
		process.setApproverPageName(approverPageName);
		process.setUserPageName(userPageName);
		process.setAgentPageName(agentPageName);
		process.setSupervisorPageName(supervisorPageName);
		process.setEntityTitle(entityTitle);
		process.setAgentEnabled(isAgentEnabled);
		process.setClosedReasonVocId(closedReasonVocId);
		process.setAccountCreationEmailEnabled(isAccountCreationEmailEnabled);
		process.setEnableAssignment(isEnableAssignment);
		process.setEditFeeDetails(isEditFeeDetails);
		process.setScheduleModelId(GetterUtil.getLong(scheduleOptions));
		process.setEnableSingleSubmission(isEnableSingleSubmission);
		process.setShowHeader(isShowHeader);
		process.setEnableFirstStepProgress(isEnableFirstStepProgress);
		process.setOrientation(orientation);
		process.setSubProductTypeId(GetterUtil.getLong(subProductTypeId));
		process.setProductTypeId(GetterUtil.getLong(productTypeId));
		process.setSingleSubmissionErrorMsg(singleSubmissionErrorMsg);

		Date now = new Date();
		process.setCreateDate(now);
		process.setModifiedDate(now);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		process.setGroupId(themeDisplay.getScopeGroupId());
		process.setCompanyId(themeDisplay.getCompanyId());
		process.setUserId(themeDisplay.getUserId());
		process.setUserName(themeDisplay.getUser().getFullName());

		PEProcessLocalServiceUtil.addPEProcess(process);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("processID", process.getSpPEProcessId());

		streamWriter(response, jsonObject);
	}
	
	protected static void copyProcess(ResourceRequest request,
			ResourceResponse response) throws SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long processIdToCopy = ParamUtil.getLong(request, "processId", -1);

		PEProcess process = PEProcessLocalServiceUtil.create();

		try {
			
			//creating new process
			PEProcess processToCopy = PEProcessLocalServiceUtil
					.getPEProcess(processIdToCopy);

			process.setName("Copy of "+GetterUtil.getString(processToCopy.getName()));
			process.setEntityClassId(GetterUtil.getLong(processToCopy.getEntityClassId()));
			process.setAgentRoleIds(GetterUtil.getString(processToCopy.getAgentRoleIds()));
			process.setApproveRoleIds(GetterUtil.getString(processToCopy.getApproveRoleIds()));
			process.setSupervisorRoleIds(GetterUtil.getString(processToCopy.getSupervisorRoleIds()));
			process.setApplicantRoleId(GetterUtil.getLong(processToCopy.getApplicantRoleId()));
			process.setApproverPageName(GetterUtil.getString(processToCopy.getApproverPageName()));
			process.setUserPageName(GetterUtil.getString(processToCopy.getUserPageName()));
			process.setAgentPageName(GetterUtil.getString(processToCopy.getAgentPageName()));
			process.setSupervisorPageName(GetterUtil.getString(processToCopy.getSupervisorPageName()));
			process.setEntityTitle(GetterUtil.getString(processToCopy.getEntityTitle()));
			process.setAgentEnabled(GetterUtil.getBoolean(processToCopy.getAgentEnabled()));
			process.setClosedReasonVocId(GetterUtil.getLong(processToCopy.getClosedReasonVocId()));
			process.setAccountCreationEmailEnabled(GetterUtil.getBoolean(processToCopy.getAccountCreationEmailEnabled()));
			process.setEditFeeDetails(GetterUtil.getBoolean(processToCopy.getEditFeeDetails()));
			process.setScheduleModelId(GetterUtil.getLong(processToCopy.getScheduleModelId()));
			process.setEnableAssignment(GetterUtil.getBoolean(processToCopy.getEnableAssignment()));
			process.setDiagramData(GetterUtil.getString(processToCopy.getDiagramData()));
			process.setDefiniton(GetterUtil.getString(processToCopy.getDefiniton()));
			process.setEnableSingleSubmission(GetterUtil.getBoolean(processToCopy.getEnableSingleSubmission()));
			process.setOrientation(GetterUtil.getString(processToCopy.getOrientation()));
			process.setShowHeader(GetterUtil.getBoolean(processToCopy.isShowHeader()));
			process.setEnableFirstStepProgress(GetterUtil.getBoolean(processToCopy.isEnableFirstStepProgress()));
			process.setSubProductTypeId(GetterUtil.getLong(processToCopy.getSubProductTypeId()));
			process.setProductTypeId(GetterUtil.getLong(processToCopy.getProductTypeId()));
			process.setSingleSubmissionErrorMsg(GetterUtil.getString(processToCopy.getSingleSubmissionErrorMsg()));
			
			SambaashUtil.fillAudit(process, themeDisplay, process.isNew());
			
			PEProcessLocalServiceUtil.addPEProcess(process);
			
			String diagramData = process.getDiagramData();
			
			
			String definiton = process.getDefiniton();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				            .parse(new InputSource(new StringReader(definiton)));
			NodeList statuses = document.getElementsByTagName("status");
			

			//creating new status types
			List<PEProcessStatusType> peProcessStatusTypesToCopy = PEProcessStatusTypeLocalServiceUtil.findByProcessId(processIdToCopy);
			
			for (PEProcessStatusType peProcessStatusTypeToCopy : peProcessStatusTypesToCopy) {

				PEProcessStatusType peProcessStatusType = PEProcessStatusTypeLocalServiceUtil.create();

				peProcessStatusType.setSpPEProcessId(GetterUtil.getLong(process.getSpPEProcessId()));
				peProcessStatusType.setStatusName(GetterUtil.getString(peProcessStatusTypeToCopy.getStatusName()));
				peProcessStatusType.setSeqNo(GetterUtil.getLong(peProcessStatusTypeToCopy.getSeqNo()));
				peProcessStatusType.setSpPEProcessStageId(GetterUtil.getLong(peProcessStatusTypeToCopy.getSpPEProcessStageId()));

				SambaashUtil.fillAudit(peProcessStatusType, themeDisplay, peProcessStatusType.isNew());

				PEProcessStatusTypeLocalServiceUtil.addPEProcessStatusType(peProcessStatusType);

				//replace status type in defnition
				outer:for(int i = 0; i < statuses.getLength(); i++) {
				    Node status = statuses.item(i);
				    NodeList statusChildren = status.getChildNodes();
				    for ( int j = 0; j < statusChildren.getLength(); j++ ) {
				        Node elem = statusChildren.item(j);
				        if(elem.getNodeName().equalsIgnoreCase("statusTypeId") ) {
				        	long oldStatusId = GetterUtil.getLong(elem.getTextContent());;
				        	if(oldStatusId == peProcessStatusTypeToCopy.getSpPEProcessStatusTypeId()){
				        		elem.setTextContent(String.valueOf(peProcessStatusType.getSpPEProcessStatusTypeId()));
				        		break  outer;
				        	}
				        }
				    }
				}
				
				//replace status type in diagram data
				String statusTypeOld="\"statusTypeId\":\""+peProcessStatusTypeToCopy.getSpPEProcessStatusTypeId()+"\"";
				String statusTypeNew="\"statusTypeId\":\""+peProcessStatusType.getSpPEProcessStatusTypeId()+"\"";
				diagramData = diagramData.replaceAll(statusTypeOld, statusTypeNew);
			}
			
			definiton = docToString(document);
			
			process.setDiagramData(diagramData);
			process.setDefiniton(definiton);
			PEProcessLocalServiceUtil.updatePEProcess(process);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}

	}
	
	private static String docToString(Document newDoc) throws Exception{
	    DOMSource domSource = new DOMSource(newDoc);
	    Transformer transformer = TransformerFactory.newInstance().newTransformer();
	    StringWriter sw = new StringWriter();
	    StreamResult sr = new StreamResult(sw);
	    transformer.transform(domSource, sr);
	    return sw.toString(); 
	  }

	protected static void editProcess(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {

		long processId = ParamUtil.getLong(request, "processId", -1);

		PEProcess process = PEProcessLocalServiceUtil.getPEProcess(processId);

		String processName = ParamUtil.getString(request, "processName", StringPool.BLANK);
		long processEntity = ParamUtil.getLong(request, "processEntityClassOptions", -1);

		String agentRoleIds[] = ParamUtil.getParameterValues(request, "agentRoleIds");
		String approverIds[] = ParamUtil.getParameterValues(request, "approverIds");
		String supervisorRoleIds[] = ParamUtil.getParameterValues(request, "supervisorRoleIds");
		long applicantRoleId = ParamUtil.getLong(request, "applicantRoleId");
		String userPageName = ParamUtil.getString(request, "userPageName", StringPool.BLANK);
		String entityTitle = ParamUtil.getString(request, "entityTitle", StringPool.BLANK);
		String approverPageName = ParamUtil.getString(request, "approverPageName", StringPool.BLANK);
		String agentPageName = ParamUtil.getString(request, "agentPageName", StringPool.BLANK);
		String supervisorPageName = ParamUtil.getString(request, "supervisorPageName", StringPool.BLANK);
		long closedReasonVocId = ParamUtil.getLong(request, "closedReasonVocId");
		boolean isAgentEnabled = ParamUtil.getBoolean(request, "agentEnabled", false);
		boolean isAccountCreationEmailEnabled = ParamUtil.getBoolean(request, "accountCreationEmailEnabled", false);
		boolean isEditFeeDetails = ParamUtil.getBoolean(request, "editFeeDetails", false);
		boolean isEnableAssignment = ParamUtil.getBoolean(request, "enableAssignment", false);
		String scheduleOptions = ParamUtil.getString(request, "scheduleOptions");
		String subProductTypeId = ParamUtil.getString(request, "subProductTypeId");
		String productTypeId = ParamUtil.getString(request, "productTypeId");
		boolean isEnableSingleSubmission = ParamUtil.getBoolean(request, "enableSingleSubmission", false);
		boolean isShowHeader = ParamUtil.getBoolean(request, "showHeader", false);
		boolean isEnableFirstStepProgress = ParamUtil.getBoolean(request, "enableFirstStepProgress", false);
		String orientation = ParamUtil.getString(request, "orientation", StringPool.BLANK);
		String singleSubmissionErrorMsg = ParamUtil.getString(request, "singleSubmissionErrorMsg", StringPool.BLANK);

		//Set above parameters
		process.setName(processName);
		process.setEntityClassId(processEntity);
		process.setAgentRoleIds(Arrays.toString(agentRoleIds).replaceAll("[\\[\\]\\s]", StringPool.BLANK));
		process.setApproveRoleIds(Arrays.toString(approverIds).replaceAll("[\\[\\]\\s]", StringPool.BLANK));
		process.setSupervisorRoleIds(Arrays.toString(supervisorRoleIds).replaceAll("[\\[\\]\\s]", StringPool.BLANK));
		process.setApplicantRoleId(applicantRoleId);
		//process.setUserName(userPageName);
		process.setUserPageName(userPageName);
		process.setEntityTitle(entityTitle);
		process.setAgentEnabled(isAgentEnabled);
		process.setApproverPageName(approverPageName);
		process.setAgentPageName(agentPageName);
		process.setSupervisorPageName(supervisorPageName);
		process.setClosedReasonVocId(closedReasonVocId);
		process.setAccountCreationEmailEnabled(isAccountCreationEmailEnabled);
		process.setEditFeeDetails(isEditFeeDetails);
		process.setEnableAssignment(isEnableAssignment);
		process.setScheduleModelId(GetterUtil.getLong(scheduleOptions));
		process.setEnableSingleSubmission(isEnableSingleSubmission);
		process.setShowHeader(isShowHeader);
		process.setEnableFirstStepProgress(isEnableFirstStepProgress);
		process.setOrientation(orientation);
		process.setSubProductTypeId(GetterUtil.getLong(subProductTypeId));
		process.setProductTypeId(GetterUtil.getLong(productTypeId));
		process.setSingleSubmissionErrorMsg(singleSubmissionErrorMsg);

		Date now = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		process.setModifiedDate(now);
		process.setUserId(themeDisplay.getUserId());
		process.setUserName(themeDisplay.getUser().getFullName());
		process.setCompanyId(themeDisplay.getCompanyId());
		process.setGroupId(themeDisplay.getScopeGroupId());
		PEProcessLocalServiceUtil.updatePEProcess(process);
		SambaashUtil.clearAllCaches();
	}
	
	//add new process type
	protected static void addProcessStatusType(ResourceRequest request, ResourceResponse response) throws SystemException{
		
		PEProcessStatusType peProcessStatusType = PEProcessStatusTypeLocalServiceUtil.create();
		
		long spPEProcessId = ParamUtil.getLong(request, "processNameOptions", -1);
		String statusName = ParamUtil.getString(request,"statusName",StringPool.BLANK);
		long sequenceNo = ParamUtil.getLong(request, "sequenceNo", -1);
		long processStageId = ParamUtil.getLong(request, "processStage", -1);
		
		//set above fields
		peProcessStatusType.setSpPEProcessId(spPEProcessId);
		peProcessStatusType.setStatusName(statusName);
		peProcessStatusType.setSeqNo(sequenceNo);
		peProcessStatusType.setSpPEProcessStageId(processStageId);

		Date now = new Date();
		peProcessStatusType.setCreateDate(now);
		peProcessStatusType.setModifiedDate(now);
		
		//set common fields
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		peProcessStatusType.setGroupId(themeDisplay.getScopeGroupId());
		peProcessStatusType.setCompanyId(themeDisplay.getCompanyId());
		peProcessStatusType.setUserId(themeDisplay.getUserId());
		peProcessStatusType.setUserName(themeDisplay.getUser().getFullName());

		PEProcessStatusTypeLocalServiceUtil.addPEProcessStatusType(peProcessStatusType);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("spPEProcessStatusTypeId", peProcessStatusType.getSpPEProcessId());

		streamWriter(response, jsonObject);
		
	}
	
	//edit processStatusType
	protected static void editProcessStatusType(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException{
		long spPEProcessStatusTypeId = ParamUtil.getLong(request, "statusTypeId",1);
		PEProcessStatusType peProcessStatusType = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(spPEProcessStatusTypeId);
		
		long spPEProcessId = ParamUtil.getLong(request, "processNameOptions", -1);
		String statusName = ParamUtil.getString(request,"statusName",StringPool.BLANK);
		long sequenceNo = ParamUtil.getLong(request, "sequenceNo", -1);
		long processStageId = ParamUtil.getLong(request, "processStage", -1);
		
		//set above fields
		peProcessStatusType.setSpPEProcessId(spPEProcessId);
		peProcessStatusType.setStatusName(statusName);
		peProcessStatusType.setSeqNo(sequenceNo);
		peProcessStatusType.setSpPEProcessStageId(processStageId);

		Date now = new Date();
		peProcessStatusType.setModifiedDate(now);

		PEProcessStatusTypeLocalServiceUtil.updatePEProcessStatusType(peProcessStatusType);
		
	}
	

	protected static void prepareDesignerData(ResourceRequest request, ResourceResponse response) {

		long processId = ParamUtil.getLong(request, "processId", -1);
		PEProcess process = null;

		try {
			process = PEProcessLocalServiceUtil.getPEProcess(processId);
		} catch (PortalException|SystemException e) {
			_log.error(e.getMessage());
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("processDefinition", process.getDiagramData());

		streamWriter(response, jsonObject);
	}

	protected static void saveProcess(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {

		//collect data from request object.
		long processId = ParamUtil.getLong(request, "processId", -1);
		String operationType = ParamUtil.getString(request,"operationType",StringPool.BLANK);
		String nodeSkelton = ParamUtil.getString(request, "nodeSkelton", StringPool.BLANK);
		boolean isUpdate = ParamUtil.getBoolean(request, "isUpdate");

		PEProcess process = PEProcessLocalServiceUtil.getPEProcess(processId);

		Date now = new Date();
		process.setModifiedDate(now);
		process.setDiagramData(nodeSkelton);

		if(operationType.equals("publish")){ // save xml only if its publish
			String strXml = null;
			try { 
				strXml = getJsonMappedXml(nodeSkelton); 
			} catch (ParserConfigurationException | JSONException e) {
				_log.error("Unable to generate process definition !!!",e);
			}
			process.setDefiniton(strXml);
		}
		
		if (isUpdate == false){//if new process
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			process.setUserId(themeDisplay.getUserId());
			process.setUserName(themeDisplay.getUser().getFullName());
			process.setCompanyId(themeDisplay.getCompanyId());
			process.setGroupId(themeDisplay.getScopeGroupId());
		}

		PEProcessLocalServiceUtil.updatePEProcess(process);
		SambaashUtil.clearAllCaches();
	}

	/*
	 * fetches Processes and Process Status Types and populates Process builder table 
	 */
	public static void retrieveTableData(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {
		String requestedData = ParamUtil.getString(request, "requestedData",StringPool.BLANK);
		
		if(requestedData.equalsIgnoreCase("process")){
			prepareAllProcessList(request, response);
		}
		else if(requestedData.equalsIgnoreCase("statusType")){
			prepareAllProcessStatusTypes(request, response);
		}
		
		
	}
	
	private static void addHeadersToNode(Element element, org.json.JSONObject jObject) throws JSONException {
		org.json.JSONArray childArray = null;
		try{childArray = jObject.getJSONArray("child");}catch (Exception ex){return;}
		if (childArray == null)return;
		Element header = doc.createElement("header");
		//for each header section
		org.json.JSONArray headerArr = jObject.getJSONArray("header");
		int arrLen = headerArr.length();
		Element parameter = null, temp = null;

		for (int indx = 0; indx < arrLen; indx++) {

			parameter = doc.createElement("parameter");
			header.appendChild(parameter);

			temp = doc.createElement("key");
			temp.appendChild((doc.createTextNode(headerArr.getJSONObject(indx).getString("key"))));
			parameter.appendChild(temp);

			temp = doc.createElement("value");
			temp.appendChild((doc.createTextNode(headerArr.getJSONObject(indx).getString("value"))));
			parameter.appendChild(temp);
		}

		element.appendChild(header);
	}
	
	private static void addDataMappingToNode(Element element, org.json.JSONObject jObject) throws JSONException {

		org.json.JSONArray childArray = null;

		try{childArray = jObject.getJSONArray("child");}catch (Exception ex){return;}

		if (childArray == null)return;

		Element dataMapping = doc.createElement("dataMapping");

		//for each dataMap section
		org.json.JSONArray dataMappingArr = jObject.getJSONArray("dataMapping");
		//org.json.JSONArray dataMapTextFieldsArr = jObject.getJSONArray("dataMapTextFields");
		
		int arrLen = dataMappingArr.length();
		Element mappingElement = null, temp = null;

		for (int indx = 0; indx < arrLen; indx++) {

			mappingElement = doc.createElement("mappingElement");
			dataMapping.appendChild(mappingElement);

			temp = doc.createElement("fieldId");
			temp.appendChild((doc.createTextNode(dataMappingArr.getJSONObject(indx).getString("fieldId"))));
			mappingElement.appendChild(temp);

			temp = doc.createElement("processFieldId");
			temp.appendChild((doc.createTextNode(dataMappingArr.getJSONObject(indx).getString("processFieldId"))));
			mappingElement.appendChild(temp);
		}

		element.appendChild(dataMapping);
	} 
	
	private static void addRulesToNode(Element element, org.json.JSONObject jObject) throws JSONException {

		org.json.JSONArray childArray = null;

		try{childArray = jObject.getJSONArray("child");}catch (Exception ex){return;}

		if (childArray == null)return;
		
		Element editConfiguration = doc.createElement("editConfiguration");

		//for each rule section
		if(jObject.optJSONArray("editOptions") != null){
		org.json.JSONArray rulesArr = jObject.getJSONArray("editOptions");
		JSONArray arr = JSONFactoryUtil.createJSONArray();
		
		int arrLen = rulesArr.length();
		for (int indx = 0; indx < arrLen; indx++) {
			JSONObject object = JSONFactoryUtil.createJSONObject();
			org.json.JSONObject rulesArrObj = rulesArr.getJSONObject(indx);
			
			JSONObject childObj = JSONFactoryUtil.createJSONObject();
			childObj.put("fieldName", rulesArrObj.getString("fieldName"));
			childObj.put("statusType", rulesArrObj.getString("steps"));
			
			JSONArray childarr = JSONFactoryUtil.createJSONArray();
			childarr.put(childObj);
			
			object.put("conditions", childarr);
			object.put("roleIds", rulesArrObj.getString("roles"));
			arr.put(object);
			
		}
		
		editConfiguration.appendChild((doc.createCDATASection(arr.toString())));
		}
		element.appendChild(editConfiguration);
		
	} 
	
	private static void appendChildrenNode(org.json.JSONObject jObject, List<String> visitedNodeList) throws JSONException {

		String elementImgSrcId = "";
		try {elementImgSrcId = (jObject.getJSONObject("image")).get("id").toString();}catch (Exception ex){};
		
		if (jObject.isNull("child") && elementImgSrcId.isEmpty())
			return;
		
		org.json.JSONArray childArray = null;		
		try{childArray = jObject.getJSONArray("child");}catch(Exception ex){};
		
		if (!elementImgSrcId.isEmpty()) {
			elementImgSrcId = elementImgSrcId.toLowerCase();

			//Maintain the visited node id list
			String currNodeId = jObject.getString("nodeId");
			if(visitedNodeList.contains(currNodeId))
				return;
			visitedNodeList.add(currNodeId);
			
			if (elementImgSrcId.equals("form")) {

				Element form = doc.createElement("form");
				forms.appendChild(form);

				addAllowReprocessInfo(form, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				form.appendChild(nodeId);

				Element name = doc.createElement("name");
				name.appendChild((doc.createTextNode(jObject.getString("name"))));
				form.appendChild(name);
				
				Element submitterRoleIds = doc.createElement("submitterRoleIds");
				submitterRoleIds.appendChild((doc.createTextNode(jObject.getString("submitterRoleIds").replaceAll("[\\s\\[\\]\"\"]",""))));
				form.appendChild(submitterRoleIds);
				
				Element submittableByApplicant = doc.createElement("submittableByApplicant");
				submittableByApplicant.appendChild((doc.createTextNode(jObject.getString("submittableByApplicant"))));
				form.appendChild(submittableByApplicant);
				
				
				Element waitMsg = doc.createElement("waitMsg");
				waitMsg.appendChild((doc.createCDATASection(jObject.getString("waitMsg"))));
				form.appendChild(waitMsg);
				
				Element rulesetId = doc.createElement("rulesetId");
				rulesetId.appendChild((doc.createTextNode(jObject.getString("rulesetId"))));
				form.appendChild(rulesetId);

				addOutcomeToNode(form, jObject);
				addDataMappingToNode(form, jObject);
				addRulesToNode(form, jObject);

			} else if (elementImgSrcId.equals("formv2")) {

					Element formV2 = doc.createElement("formV2");
					formsV2.appendChild(formV2);

					addAllowReprocessInfo(formV2, jObject);
					
					Element nodeId = doc.createElement("nodeId");
					nodeId.appendChild((doc.createTextNode(currNodeId)));
					formV2.appendChild(nodeId);

					Element name = doc.createElement("name");
					name.appendChild((doc.createTextNode(jObject.getString("name"))));
					formV2.appendChild(name);
					
					Element submitterRoleIds = doc.createElement("submitterRoleIds");
					submitterRoleIds.appendChild((doc.createTextNode(jObject.getString("submitterRoleIds").replaceAll("[\\s\\[\\]\"\"]",""))));
					formV2.appendChild(submitterRoleIds);
					
					Element submittableByApplicant = doc.createElement("submittableByApplicant");
					submittableByApplicant.appendChild((doc.createTextNode(jObject.getString("submittableByApplicant"))));
					formV2.appendChild(submittableByApplicant);
					
					
					Element waitMsg = doc.createElement("waitMsg");
					waitMsg.appendChild((doc.createCDATASection(jObject.getString("waitMsg"))));
					formV2.appendChild(waitMsg);
					
					Element rulesetId = doc.createElement("rulesetId");
					rulesetId.appendChild((doc.createTextNode(jObject.getString("rulesetId"))));
					formV2.appendChild(rulesetId);

					addOutcomeToNode(formV2, jObject);
					addDataMappingToNode(formV2, jObject);
					addRulesToNode(formV2, jObject);

			} else if (elementImgSrcId.equals("jsp")) {

				Element jsp = doc.createElement("jsp");
				jsps.appendChild(jsp);

				addAllowReprocessInfo(jsp, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				jsp.appendChild(nodeId);

				Element name = doc.createElement("name");
				name.appendChild((doc.createTextNode(jObject.getString("name"))));
				jsp.appendChild(name);
				
				Element submitterRoleIds = doc.createElement("submitterRoleIds");
				submitterRoleIds.appendChild((doc.createTextNode(jObject.getString("submitterRoleIds").replaceAll("[\\s\\[\\]\"\"]",""))));
				jsp.appendChild(submitterRoleIds);
				
				Element submittableByApplicant = doc.createElement("submittableByApplicant");
				submittableByApplicant.appendChild((doc.createTextNode(jObject.getString("submittableByApplicant"))));
				jsp.appendChild(submittableByApplicant);
				
				
				Element waitMsg = doc.createElement("waitMsg");
				waitMsg.appendChild((doc.createCDATASection(jObject.getString("waitMsg"))));
				jsp.appendChild(waitMsg);

				Element rulesetId = doc.createElement("rulesetId");
				rulesetId.appendChild((doc.createTextNode(jObject.getString("rulesetId"))));
				jsp.appendChild(rulesetId);

				Element ruleVersion = doc.createElement("ruleVersion");
				ruleVersion.appendChild((doc.createTextNode(jObject.getString("ruleVersion"))));
				jsp.appendChild(ruleVersion);

				addOutcomeToNode(jsp, jObject);
				addDataMappingToNode(jsp, jObject);
				addRulesToNode(jsp, jObject);

			} else if (elementImgSrcId.equals("payment")) {

				Element payment = doc.createElement("payment");
				payments.appendChild(payment);

				addAllowReprocessInfo(payment, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				payment.appendChild(nodeId);

				Element name = doc.createElement("name");
				name.appendChild((doc.createTextNode(jObject.getString("name"))));
				payment.appendChild(name);
				
				Element provider = doc.createElement("provider");
				provider.appendChild((doc.createTextNode(jObject.getString("provider"))));
				payment.appendChild(provider);
				
				Element payCcy = doc.createElement("payCcy");
				payCcy.appendChild((doc.createTextNode(jObject.getString("payCcy"))));
				payment.appendChild(payCcy);
				
				Element payAmount = doc.createElement("payAmount");
				payAmount.appendChild((doc.createTextNode(jObject.getString("payAmount"))));
				payment.appendChild(payAmount);
				
				Element payDesc = doc.createElement("payDesc");
				payDesc.appendChild((doc.createTextNode(jObject.getString("payDesc"))));
				payment.appendChild(payDesc);
				
				Element paymentCancel = doc.createElement("paymentCancel");
				paymentCancel.appendChild((doc.createTextNode(String.valueOf(jObject.has("paymentCancel")?jObject.get("paymentCancel"):""))));
				payment.appendChild(paymentCancel);
				
				Element paymentRefundOn = doc.createElement("paymentRefundOn");
				paymentRefundOn.appendChild((doc.createTextNode(String.valueOf(jObject.has("paymentRefundOn")?jObject.get("paymentRefundOn"):""))));
				payment.appendChild(paymentRefundOn);
				
				Element paySiteName = doc.createElement("paySiteName");
				paySiteName.appendChild((doc.createTextNode(jObject.getString("paySiteName"))));
				payment.appendChild(paySiteName);
				
				Element paySiteLogo = doc.createElement("paySiteLogo");
				paySiteLogo.appendChild((doc.createTextNode(jObject.getString("paySiteLogo"))));
				payment.appendChild(paySiteLogo);
				
				Element payItemClassName = doc.createElement("payItemClassName");
				payItemClassName.appendChild((doc.createTextNode(jObject.getString("payItemClassName"))));
				payment.appendChild(payItemClassName);
				
				Element payItemClassPk = doc.createElement("payItemClassPk");
				payItemClassPk.appendChild((doc.createTextNode(jObject.getString("payItemClassPk"))));
				payment.appendChild(payItemClassPk);
				
				Element waitMsg = doc.createElement("waitMsg");
				waitMsg.appendChild((doc.createCDATASection(jObject.getString("waitMsg"))));
				payment.appendChild(waitMsg);

				Element paidMsg = doc.createElement("paidMsg");
				paidMsg.appendChild((doc.createCDATASection(jObject.getString("paidMsg"))));
				payment.appendChild(paidMsg);

				Element refundedMsg = doc.createElement("refundedMsg");
				refundedMsg.appendChild((doc.createCDATASection(jObject.getString("refundedMsg"))));
				payment.appendChild(refundedMsg);

				Element rulesetId = doc.createElement("rulesetId");
				rulesetId.appendChild((doc.createTextNode(jObject.getString("rulesetId"))));
				payment.appendChild(rulesetId);

				addOutcomeToNode(payment, jObject);
				addDataMappingToNode(payment, jObject);
				addRulesToNode(payment, jObject);

			} else if (elementImgSrcId.equals("paymentv2")) {

				Element paymentV2 = doc.createElement("paymentV2");
				paymentV2s.appendChild(paymentV2);

				addAllowReprocessInfo(paymentV2, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				paymentV2.appendChild(nodeId);

				Element name = doc.createElement("name");
				name.appendChild((doc.createTextNode(jObject.getString("name"))));
				paymentV2.appendChild(name);
				
				Element provider = doc.createElement("provider");
				provider.appendChild((doc.createTextNode(jObject.getString("provider"))));
				paymentV2.appendChild(provider);
				
				Element paymentCancel = doc.createElement("paymentCancel");
				paymentCancel.appendChild((doc.createTextNode(String.valueOf(jObject.has("paymentCancel")?jObject.get("paymentCancel"):""))));
				paymentV2.appendChild(paymentCancel);
				
				Element paymentRefundOn = doc.createElement("paymentRefundOn");
				paymentRefundOn.appendChild((doc.createTextNode(String.valueOf(jObject.has("paymentRefundOn")?jObject.get("paymentRefundOn"):""))));
				paymentV2.appendChild(paymentRefundOn);
				
				Element paySiteName = doc.createElement("paySiteName");
				paySiteName.appendChild((doc.createTextNode(jObject.getString("paySiteName"))));
				paymentV2.appendChild(paySiteName);
				
				Element paySiteLogo = doc.createElement("paySiteLogo");
				paySiteLogo.appendChild((doc.createTextNode(jObject.getString("paySiteLogo"))));
				paymentV2.appendChild(paySiteLogo);

				Element termsAndCondition = doc.createElement("termsAndCondition");
				termsAndCondition.appendChild((doc.createCDATASection(jObject.getString("termsAndCondition"))));
				paymentV2.appendChild(termsAndCondition);
				
				Element enableOfflinePayment = doc.createElement("enableOfflinePayment");
				enableOfflinePayment.appendChild((doc.createTextNode(String.valueOf(jObject.has("enableOfflinePayment")?jObject.get("enableOfflinePayment"):""))));
				paymentV2.appendChild(enableOfflinePayment);
				
				Element waitMsg = doc.createElement("waitMsg");
				waitMsg.appendChild((doc.createCDATASection(jObject.getString("waitMsg"))));
				paymentV2.appendChild(waitMsg);

				Element paidMsg = doc.createElement("paidMsg");
				paidMsg.appendChild((doc.createCDATASection(jObject.getString("paidMsg"))));
				paymentV2.appendChild(paidMsg);

				Element refundedMsg = doc.createElement("refundedMsg");
				refundedMsg.appendChild((doc.createCDATASection(jObject.getString("refundedMsg"))));
				paymentV2.appendChild(refundedMsg);

				Element rulesetId = doc.createElement("rulesetId");
				rulesetId.appendChild((doc.createTextNode(jObject.getString("rulesetId"))));
				paymentV2.appendChild(rulesetId);

				addOutcomeToNode(paymentV2, jObject);
				addDataMappingToNode(paymentV2, jObject);
				addRulesToNode(paymentV2, jObject);

			} else if (elementImgSrcId.equals("pricing")) {

				Element pricing = doc.createElement("pricing");
				pricings.appendChild(pricing);

				addAllowReprocessInfo(pricing, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				pricing.appendChild(nodeId);

				Element name = doc.createElement("name");
				name.appendChild((doc.createTextNode(jObject.getString("name"))));
				pricing.appendChild(name);
				
				Element scheme = doc.createElement("scheme");
				scheme.appendChild((doc.createTextNode(jObject.getString("scheme"))));
				pricing.appendChild(scheme);
				
				Element subScheme = doc.createElement("subScheme");
				subScheme.appendChild((doc.createTextNode(jObject.getString("subScheme").replaceAll("[\\s\\[\\]\"\"]",""))));
				pricing.appendChild(subScheme);
				
				Element outstanding = doc.createElement("outstanding");
				outstanding.appendChild((doc.createTextNode(String.valueOf(jObject.has("outstanding")?jObject.get("outstanding"):""))));
				pricing.appendChild(outstanding);
				
				Element consolidate = doc.createElement("consolidate");
				consolidate.appendChild((doc.createTextNode(String.valueOf(jObject.has("consolidate")?jObject.get("consolidate"):""))));
				pricing.appendChild(consolidate);
				
				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				pricing.appendChild(nextNodeId);

			} else if (elementImgSrcId.equals("api")) {

				Element api = doc.createElement("api");
				apis.appendChild(api);

				addAllowReprocessInfo(api, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				api.appendChild(nodeId);

				Element url = doc.createElement("url");
				url.appendChild((doc.createTextNode(jObject.getString("url"))));
				api.appendChild(url);

				Element encode = doc.createElement("encode");
				encode.appendChild((doc.createTextNode(jObject.getString("encode"))));
				api.appendChild(encode);
				
				Element method = doc.createElement("method");
				method.appendChild((doc.createTextNode(jObject.getString("method"))));
				api.appendChild(method);

				Element asynchronous = doc.createElement("asynchronous");
				asynchronous.appendChild((doc.createTextNode(jObject.getString("asynchronous"))));
				api.appendChild(asynchronous);
				
				Element responseMapping = doc.createElement("responseMapping");
				responseMapping.appendChild((doc.createTextNode(jObject.getString("responseMapping"))));
				api.appendChild(responseMapping);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				api.appendChild(nextNodeId);

				addHeadersToNode(api, jObject);
				
			} else if (elementImgSrcId.equals("entity")) {

				Element entity = doc.createElement("entity");
				entities.appendChild(entity);

				addAllowReprocessInfo(entity, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				entity.appendChild(nodeId);

				Element type = doc.createElement("type");
				type.appendChild((doc.createTextNode(jObject.getString("type"))));
				entity.appendChild(type);

				Element identifier = doc.createElement("identifier");
				identifier.appendChild((doc.createTextNode(jObject.getString("identifier"))));
				entity.appendChild(identifier);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				entity.appendChild(nextNodeId);
				
			}else if (elementImgSrcId.equals("preview")) {

				Element preview = doc.createElement("preview");
				previews.appendChild(preview);

				addAllowReprocessInfo(preview, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				preview.appendChild(nodeId);

				Element previewId = doc.createElement("previewId");
				previewId.appendChild((doc.createTextNode(jObject.getString("previewId"))));
				preview.appendChild(previewId);
				
				Element customId = doc.createElement("customId");
				customId.appendChild((doc.createTextNode(jObject.getString("customId"))));
				preview.appendChild(customId);
				
				Element enablePreview = doc.createElement("enablePreview");
				enablePreview.appendChild((doc.createTextNode(String.valueOf(jObject.has("enablePreview")?jObject.get("enablePreview"):""))));
				preview.appendChild(enablePreview);
				
				Element enableEsign = doc.createElement("enableEsign");
				enableEsign.appendChild((doc.createTextNode(String.valueOf(jObject.has("enableEsign")?jObject.get("enableEsign"):""))));
				preview.appendChild(enableEsign);
				
				Element esignApiKey = doc.createElement("esignApiKey");
				esignApiKey.appendChild((doc.createTextNode(jObject.getString("esignApiKey"))));
				preview.appendChild(esignApiKey);
				
				Element esignApiUrl = doc.createElement("esignApiUrl");
				esignApiUrl.appendChild((doc.createTextNode(jObject.getString("esignApiUrl"))));
				preview.appendChild(esignApiUrl);
				
				Element previewJspNode = doc.createElement("previewJspNode");
				previewJspNode.appendChild((doc.createTextNode(jObject.getString("previewJspNode"))));
				preview.appendChild(previewJspNode);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				preview.appendChild(nextNodeId);

			}else if (elementImgSrcId.equals("process")) {

				Element Process = doc.createElement("process");
				processes.appendChild(Process);

				addAllowReprocessInfo(Process, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				Process.appendChild(nodeId);

				Element ruleVersion = doc.createElement("ruleVersion");
				ruleVersion.appendChild((doc.createTextNode(jObject.getString("ruleVersion"))));
				Process.appendChild(ruleVersion);

				Element rulesetId = doc.createElement("rulesetId");
				rulesetId.appendChild((doc.createTextNode(jObject.getString("rulesetId"))));
				Process.appendChild(rulesetId);

				addOutcomeToNode(Process, jObject);

			}else if (elementImgSrcId.equals("pages")) {

				Element page = doc.createElement("page");
				pages.appendChild(page);

				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				page.appendChild(nodeId);

				addOutcomeToNode(page, jObject);

			}else if (elementImgSrcId.equals("message")) {

				Element msg = doc.createElement("msg");
				msgs.appendChild(msg);

				addAllowReprocessInfo(msg, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				msg.appendChild(nodeId);

				Element nextNodeId = doc.createElement("nextNodeId");
				
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				msg.appendChild(nextNodeId);

				Element html = doc.createElement("html");
				html.appendChild((doc.createCDATASection(jObject.getString("messageInput"))));
				msg.appendChild(html);

			}else if (elementImgSrcId.equals("mail")) {

				Element mail = doc.createElement("mail");
				mails.appendChild(mail);

				addAllowReprocessInfo(mail, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				mail.appendChild(nodeId);

				Element templateId = doc.createElement("templateId");
				templateId.appendChild(doc.createTextNode(jObject.getString("templateId")));
				mail.appendChild(templateId);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				//nextNodeId.appendChild(doc.createTextNode(childArray.getJSONObject(0).getString("nodeId")));
				mail.appendChild(nextNodeId);
				
				Element recipient = doc.createElement("recipient");
				recipient.appendChild(doc.createTextNode(jObject.getString("recipient")));
				mail.appendChild(recipient);
				
				if(jObject.getString("recipient").equals("officer")){
					Element officerRoleIds = doc.createElement("officerRoleIds");
					officerRoleIds.appendChild(doc.createTextNode(jObject.getString("officerRoleIds").replaceAll("[\\s\\[\\]\"\"]","")));
					mail.appendChild(officerRoleIds);
				}
				
				Element cc = doc.createElement("cc");
				cc.appendChild(doc.createTextNode(jObject.getString("cc")));
				mail.appendChild(cc);
				
				Element ccEmailAddressText = doc.createElement("ccEmailAddressText");
				ccEmailAddressText.appendChild(doc.createTextNode(jObject.getString("ccEmailAddressText")));
				mail.appendChild(ccEmailAddressText);
				
				
			}else if (elementImgSrcId.equals("customaction")) {

				Element customAction = doc.createElement("customAction");
				customActions.appendChild(customAction);

				addAllowReprocessInfo(customAction, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				customAction.appendChild(nodeId);

				Element customActionId = doc.createElement("customActionId");
				customActionId.appendChild(doc.createTextNode(jObject.getString("customActionTitleOptions")));
				customAction.appendChild(customActionId);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				customAction.appendChild(nextNodeId);
				
				Element configuration = doc.createElement("configuration");
				configuration.appendChild((doc.createCDATASection(jObject.getString("configurationText"))));
				customAction.appendChild(configuration);
				
				
			}else if (elementImgSrcId.equals("status")) {

				Element status = doc.createElement("status");
				statuses.appendChild(status);

				addAllowReprocessInfo(status, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				status.appendChild(nodeId);

				//We need to modify it.
				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				//nextNodeId.appendChild(doc.createTextNode(childArray.getJSONObject(0).getString("nodeId")));
				status.appendChild(nextNodeId);

				Element statusTypeId = doc.createElement("statusTypeId");
				statusTypeId.appendChild((doc.createTextNode(jObject.getString("statusTypeId"))));
				status.appendChild(statusTypeId);
			
				Element status1 = doc.createElement("status");
				status1.appendChild(doc.createTextNode(jObject.getString("status")));
				status.appendChild(status1);
				
				Element statusApproverIds = doc.createElement("statusApproverIds");
				statusApproverIds.appendChild((doc.createTextNode(jObject.getString("statusApproverIds").replaceAll("[\\s\\[\\]\"\"]", ""))));
				status.appendChild(statusApproverIds);

				if(jObject.getString("status").equals("Pending")){
					Element emailTemplateId = doc.createElement("emailTemplateId");
					emailTemplateId.appendChild(doc.createTextNode(jObject.getString("emailTemplateId")));
					status.appendChild(emailTemplateId);
				}
				

			}else if (elementImgSrcId.equals("account")) {

				Element createAccount = doc.createElement("createAccount");
				actions.appendChild(createAccount);

				addAllowReprocessInfo(createAccount, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				createAccount.appendChild(nodeId);

				Element templateId = doc.createElement("templateId");
				templateId.appendChild(doc.createTextNode(jObject.getString("templateId")));
				createAccount.appendChild(templateId);
				
				Element emailAddressVerifiedId = doc.createElement("emailAddressVerifiedId");
				emailAddressVerifiedId.appendChild(doc.createTextNode(jObject.getString("emailAddressVerifiedId")));
				createAccount.appendChild(emailAddressVerifiedId);
				
				Element accountStatusId = doc.createElement("accountStatusId");
				accountStatusId.appendChild(doc.createTextNode(jObject.getString("accountStatusId")));
				createAccount.appendChild(accountStatusId);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				//nextNodeId.appendChild(doc.createTextNode(childArray.getJSONObject(0).getString("nodeId")));
				createAccount.appendChild(nextNodeId);

			}else if (elementImgSrcId.equals("timer")) {

				Element scheduledJob = doc.createElement("scheduledJob");
				scheduledJobs.appendChild(scheduledJob);

				addAllowReprocessInfo(scheduledJob, jObject);
				
				Element nodeId = doc.createElement("nodeId");
				nodeId.appendChild((doc.createTextNode(currNodeId)));
				scheduledJob.appendChild(nodeId);

				Element nextNodeId = doc.createElement("nextNodeId");
				String nextnodeid = evaluateNextNodeId(childArray.getJSONObject(0));				
				nextNodeId.appendChild(doc.createTextNode(nextnodeid));
				scheduledJob.appendChild(nextNodeId);

				Element templateId = doc.createElement("templateId");
				templateId.appendChild(doc.createTextNode(jObject.getString("templateId")));
				scheduledJob.appendChild(templateId);
				
				Element recipient = doc.createElement("recipient");
				recipient.appendChild(doc.createTextNode(jObject.getString("recipient")));
				scheduledJob.appendChild(recipient);
				
				if(jObject.getString("recipient").equals("officer")){
					Element officerRoleIds = doc.createElement("officerRoleIds");
					officerRoleIds.appendChild(doc.createTextNode(jObject.getString("officerRoleIds").replaceAll("[\\s\\[\\]\"\"]","")));
					scheduledJob.appendChild(officerRoleIds);
				}
				
				Element cc = doc.createElement("cc");
				cc.appendChild(doc.createTextNode(jObject.getString("cc")));
				scheduledJob.appendChild(cc);
				
				Element ccEmailAddressText = doc.createElement("ccEmailAddressText");
				ccEmailAddressText.appendChild(doc.createTextNode(jObject.getString("ccEmailAddressText")));
				scheduledJob.appendChild(ccEmailAddressText);

				Element execOnce = doc.createElement("execOnce");
				execOnce.appendChild((doc.createTextNode(String.valueOf(jObject.has("execOnce")?jObject.get("execOnce"):""))));
				scheduledJob.appendChild(execOnce);
				
				Element cronSchedule = doc.createElement("cronSchedule");
				cronSchedule.appendChild(doc.createTextNode(jObject.getString("cronSchedule")));
				scheduledJob.appendChild(cronSchedule);
				
				Element rulesetId = doc.createElement("rulesetId");
				rulesetId.appendChild(doc.createTextNode(jObject.getString("rulesetId")));
				scheduledJob.appendChild(rulesetId);
				
				Element jobListener = doc.createElement("jobListener");
				jobListener.appendChild(doc.createTextNode(jObject.getString("jobListener")));
				scheduledJob.appendChild(jobListener);
				
			}
		}
		
		if(childArray == null)
			return;
		
		for (int i = 0; i < childArray.length(); i++) {
			appendChildrenNode(childArray.getJSONObject(i),visitedNodeList);
		}
	}

	private static void addAllowReprocessInfo(Element nodeElement, org.json.JSONObject dataObj) throws JSONException {
		Element allowReprocess = doc.createElement("allowReprocess");
		allowReprocess.appendChild((doc.createTextNode(String.valueOf(dataObj.has("allowReprocess")?dataObj.get("allowReprocess"):""))));
		nodeElement.appendChild(allowReprocess);
	}

	private static void addOutcomeToNode(Element element, org.json.JSONObject jObject) throws JSONException {

		org.json.JSONArray childArray = null;

		try {
			childArray = jObject.getJSONArray("child");
		}catch (Exception ex){return; }

		if (childArray == null)
			return;

		Element outcomes = doc.createElement("outcomes");

		for (int i = 0; i < childArray.length(); i++) {
			
			org.json.JSONObject childNode = childArray.getJSONObject(i);
			
			String nextnodeid = evaluateNextNodeId(childNode);
			
			if(nextnodeid == null || nextnodeid.isEmpty())
				continue;

			Element outcome = doc.createElement("outcome");
			outcomes.appendChild(outcome);

			Element ruleId = doc.createElement("ruleId");
			ruleId.appendChild((doc.createTextNode(childNode.getString("ruleId"))));
			outcome.appendChild(ruleId);

			Element nextNodeId = doc.createElement("nextNodeId");
			//nextNodeId.appendChild((doc.createTextNode(childNode.getString("nodeId"))));
			//Put condition if nextNode is empty then traverse to next-to-next node
			nextNodeId.appendChild((doc.createTextNode(nextnodeid)));
			outcome.appendChild(nextNodeId);
		}

		element.appendChild(outcomes);
	}
 
	private static String evaluateNextNodeId(org.json.JSONObject childNode) {
		
		if(childNode.has("image")) {
		    try {return childNode.getString("nodeId");} catch (JSONException e) {_log.error(e.getMessage());}
		}else if(!childNode.has("child"))//If child i not there then return empty string.
			return "";
		
		org.json.JSONArray childrenArray = null;
		try {childrenArray = childNode.getJSONArray("child");} catch (JSONException e1) {_log.error(e1.getMessage());}
		
		for(int indx=0; indx<childrenArray.length(); indx++){
			
			try {return evaluateNextNodeId(childrenArray.getJSONObject(indx));} catch (JSONException e) {_log.error(e.getMessage());}			
		}
		return "";
	}

	private static void createXmlSkelton() {

		forms = doc.createElement("forms");
		rootElement.appendChild(forms);

		formsV2 = doc.createElement("formsV2");
		rootElement.appendChild(formsV2);

		jsps = doc.createElement("jsps");
		rootElement.appendChild(jsps);

		payments = doc.createElement("payments");
		rootElement.appendChild(payments);
		
		paymentV2s = doc.createElement("paymentV2s");
		rootElement.appendChild(paymentV2s);
		
		pricings = doc.createElement("pricings");
		rootElement.appendChild(pricings);
		
		apis = doc.createElement("apis");
		rootElement.appendChild(apis);
		
		entities = doc.createElement("entities");
		rootElement.appendChild(entities);
		
		previews = doc.createElement("previews");
		rootElement.appendChild(previews);

		processes = doc.createElement("processes");
		rootElement.appendChild(processes);

		pages = doc.createElement("pages");
		rootElement.appendChild(pages);

		msgs = doc.createElement("msgs");
		rootElement.appendChild(msgs);

		accounts = doc.createElement("accounts");
		rootElement.appendChild(accounts);

		actions = doc.createElement("actions");

		mails = doc.createElement("mails");
		actions.appendChild(mails);

		statuses = doc.createElement("statuses");
		actions.appendChild(statuses);
		
		customActions = doc.createElement("customActions");
		actions.appendChild(customActions);

		rootElement.appendChild(actions);

		scheduledJobs = doc.createElement("scheduledJobs");
		timers = doc.createElement("timers");
		timers.appendChild(scheduledJobs);
		rootElement.appendChild(timers);

	}

	private static String getJsonMappedXml(String nodeSkelton) throws JSONException, ParserConfigurationException {

		org.json.JSONObject rootJsonObject = new org.json.JSONObject(nodeSkelton);
		org.json.JSONArray jArray = rootJsonObject.getJSONArray("nodeGroups");
		org.json.JSONObject jObject = new org.json.JSONObject(jArray.getJSONObject(0).getString("nodeStructure"));
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		doc = docBuilder.newDocument();
		rootElement = doc.createElement("process");
		doc.appendChild(rootElement);

		Element startNodeId = doc.createElement("startNodeId");
		startNodeId.appendChild((doc.createTextNode(jObject.getString("nodeId"))));
		rootElement.appendChild(startNodeId);

		createXmlSkelton();

		String jsonMappedXmlStr = null;
		try {
			List<String> visitedNodeList = new ArrayList<String>();
			appendChildrenNode(jObject, visitedNodeList);//A method will add elements recursively.
			jsonMappedXmlStr = getStringFromDocument(doc);
		} catch (JSONException | TransformerException e) {_log.error(e.getMessage()); }

		return jsonMappedXmlStr;
	}

	private static void streamWriter(ResourceResponse response, JSONObject jsonObject) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e1) {
			_log.error(e1.getMessage());
		}

		writer.print(jsonObject.toString());
		writer.flush();
		writer.close();
	}
	
}	