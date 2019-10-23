package com.sambaash.platform.portlet.pe.action;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.ProcessEngine;
import com.sambaash.platform.pe.ProcessEngineImpl;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.course.enroll.CourseEnrollAction;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2FileDownloadActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2FileUploadActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2LoadDataActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2PersistActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEPriceSchemeDetailsHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.validation.service.SPStudentProgrammeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class PEProcessRegisterAction
 */
public class RegisterProcessAction extends MVCPortlet implements PEConstants {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", PEFormV2PersistActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", PEFormV2LoadDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("upload", PEFormV2FileUploadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", PEFormV2FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getPEPriceSchemeDetails", PEPriceSchemeDetailsHandler.class);
	}
	
	// please have look at ProcessStateDisplayHelper.getDisplayUrlProcessState which consturcts url to display individual applicaiton

	public void displayProcessState(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		process(request, response);
	}

	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		PortletPreferences portletPreferences = request.getPreferences();
		long requestedStatusTypeId = ParamUtil.getLong(request, PEConstants.PARAM_STATUS_TYPE_ID);

		//PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter(PARAM_pro)
		
		// fetch from url parameters
		long classPk = ParamUtil.getLong(request, PARAM_CLASS_PK);
		long processId = ParamUtil.getLong(request, PARAM_PROCESS_ID);
		long classNameId = ParamUtil.getLong(request, PARAM_CLASS_NAME_ID);
		if(  (classPk > 0 && processId == 0) || (classPk == 0 && processId != 0)){
			SessionErrors.add(request, "config.error");
			include("/html/register/error.jsp", request, response);
			return;
		}
		
		if ( classPk == 0 || processId == 0) {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			classPk = ParamUtil.getLong(httpRequest, PARAM_CLASS_PK);
			processId = ParamUtil.getLong(httpRequest, PARAM_PROCESS_ID);
			classNameId = ParamUtil.getLong(request, PARAM_CLASS_NAME_ID);
		}
		
		// if not found , try to get from preferences
		if ( classPk == 0 || processId == 0) {
			classPk = GetterUtil.getLong(portletPreferences.getValue(PARAM_CLASS_PK, "0"));
			processId = GetterUtil.getLong(portletPreferences.getValue(PARAM_PROCESS_ID, "0"));
			classNameId = GetterUtil.getLong(portletPreferences.getValue(PARAM_CLASS_NAME_ID, "0"));
			if ( classPk == 0 || processId == 0) {
				// incorrect configuration
				SessionErrors.add(request, "config.error");
				include("/html/register/error.jsp", request, response);
			}
		}
		
		//PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter("nodeId")
		if (classPk != 0 && processId != 0) {
			ProcessEngine processEngine = new ProcessEngineImpl();
			try {
				PEOutput output = processEngine.executeByEntityIdProcessId(classNameId,classPk, processId, requestedStatusTypeId, request, response);
				request.setAttribute(ATTR_OUTPUT, output);
				super.doView(request, response);
			} catch (SystemException e) {
				SessionErrors.add(request, "system.error");
				include("/html/register/error.jsp", request, response);
				_log.error(e);
			}
		}
	}
	
	
	
	/*public boolean validate(ActionRequest request, ActionResponse response) throws IOException, PortletException, PEException{
		boolean allowedToTakeCourse = true;
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			
			PortletPreferences portletPreferences = request.getPreferences();
			boolean enableTempStorageValidation = GetterUtil.getBoolean(GetterUtil.getString(portletPreferences.getValue(ENABLE_TEMP_STORAGE_VALIDATION, "false")));
			long enableTempStorageValidationStepNo = GetterUtil.getLong(portletPreferences.getValue(ENABLE_TEMP_STORAGE_VALIDATION_STEP_NUMBER, "0"));
			long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
			if (processStateId > 0 && enableTempStorageValidationStepNo > 1){
				PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
				long statusTypeId = processState.getStatusTypeId();
				long currentStepNo = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(statusTypeId).getSeqNo();
				if(currentStepNo == enableTempStorageValidationStepNo){
					User user = UserLocalServiceUtil.getUser(processState.getUserId());
					PERequestData requestData = PERequestData.getRequestData(request, user);
					PEDataSource dataSource = new PEDataSource(requestData, processState);
					String emailAddress = dataSource.getDataFromProcessState("email");
					String nric = dataSource.getDataFromProcessState("nric");
					//String remarks = dataSource.getFormDataAdapter().getDataFromForm(JSONFactoryUtil.createJSONObject(request.getParameter("formData")), 1, "remarks_4");
					String programmeCode = GetterUtil.getString(portletPreferences.getValue(PARAM_CLASS_PK_SAVED_CODE, "0"));
					String validationResultStr = SPStudentProgrammeLocalServiceUtil.getStudentProgramme(themeDisplay.getScopeGroupId(), programmeCode, nric, emailAddress, new Date(), enableTempStorageValidation);
					JSONObject validationResult = JSONFactoryUtil.createJSONObject(validationResultStr);							
					allowedToTakeCourse = validationResult.getBoolean("allowedToTakeCourse");
					if (!allowedToTakeCourse){
						SessionErrors.add(request, "temp.storage.validation.error");
						throw new PEException("You are not allowed to take course");
					}else{
						request.setAttribute(ATTR_OUTPUT_VALIDATION, validationResult.toString());
					}
				}
			}
			
			
			
		}catch (SystemException e){
			SessionErrors.add(request, "system.error");
			include("/html/register/error.jsp", request, response);
			_log.error(e);
		}catch (PortalException e){
			SessionErrors.add(request, "system.error");
			include("/html/register/error.jsp", request, response);
			_log.error(e);
		}
		return allowedToTakeCourse;
	}
	*/
	

	public void process(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		
		ProcessEngine processEngine = new ProcessEngineImpl();
		_log.debug(request.getParameter("formData"));
		try {
			/*boolean allowedToTakeCourse = validate(request, response);
			
			
			if (allowedToTakeCourse){*/
				
				long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
				long requestedStatusTypeId = ParamUtil.getLong(request, PEConstants.PARAM_STATUS_TYPE_ID);
	
				if (processStateId > 0) {
	
					// should execute any step after registration. By then, processstate is available
	
					PEOutput output = processEngine.executeByProcessStateId(processStateId, requestedStatusTypeId, request, response);
					request.setAttribute(ATTR_OUTPUT, output);
					response.setRenderParameter("jspPage", "/html/process.jsp");
				}else {
	
					// executes during registration. Here processstate not available
	
					PortletPreferences portletPreferences = request.getPreferences();
					long classPk = ParamUtil.getLong(request, PARAM_CLASS_PK);
					long processId = ParamUtil.getLong(request, PARAM_PROCESS_ID);
					long classNameId = ParamUtil.getLong(request, PARAM_CLASS_NAME_ID);
	
					PEOutput output = processEngine.executeByEntityIdProcessId(classNameId,classPk, processId, requestedStatusTypeId, request, response);
					request.setAttribute(ATTR_OUTPUT, output);
					response.setRenderParameter("jspPage", "/html/process.jsp");
				}
			//}
		} catch (SystemException e) {
			SessionErrors.add(request, "system.error");
			include("/html/register/error.jsp", request, response);
			_log.error(e);
		}/*catch (PEException e) {
			SessionErrors.add(request, "temp.storage.validation.error");
			include("/html/register/error.jsp", request, response);
			_log.error(e);
		}*/
	}

	@Override
	public void serveResource( ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		
		_log.error("RegisterProcessAction serveResource");
		
		String action = ParamUtil.getString(resourceRequest, "action");

		boolean multipart = ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest));
		if (multipart && org.apache.commons.lang.StringUtils.isEmpty(action)) {
			action = "upload";
		}
		
		// this called from config mode of the portlet. As configuration class won't support serveResource method, has been kept here.

		if ("getPKs".equalsIgnoreCase(action)) {
			JSONObject data = JSONFactoryUtil.createJSONObject();
			long entityClassId = ParamUtil.getLong(resourceRequest, "entityClassId");
			data = PEProcessLocalServiceUtil.getEntitiesListing(resourceRequest,resourceResponse,"",entityClassId,true);
			resourceResponse.getWriter().write(data.toString());
		} else if ("CourseEnrollmentProcess".equalsIgnoreCase(action)) {
			CourseEnrollAction courseEnrollAction = new CourseEnrollAction();
			courseEnrollAction.serveResource(resourceRequest, resourceResponse);

			return;
		}  else {
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);		
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RegisterProcessAction.class);

}
