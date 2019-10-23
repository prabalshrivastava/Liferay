package com.sambaash.platform.portlet.pe.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.apache.poi.util.IOUtils;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.ProcessEngine;
import com.sambaash.platform.pe.ProcessEngineImpl;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.course.enroll.CourseEnrollAction;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.pe.permissions.PermissionsUtil;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2FileDownloadActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2FileUploadActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2LoadDataActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEFormV2PersistActionHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEPriceSchemeDetailsHandler;
import com.sambaash.platform.portlet.pe.helper.ProcessStateActionHelper;
import com.sambaash.platform.portlet.pe.helper.ProcessStateSearchHelper;
import com.sambaash.platform.portlet.pe.helper.WebUploadHelper;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class ProcessStateListing
 */
public class ProcessStateAction extends MVCPortlet implements PEConstants {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", PEFormV2PersistActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", PEFormV2LoadDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("upload", PEFormV2FileUploadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", PEFormV2FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getPEPriceSchemeDetails", PEPriceSchemeDetailsHandler.class);
	}
	
	public void init() throws PortletException{
		super.init();
		try{
			SambaashUtil.clearAllCaches();
			
		}catch(Exception ex){
		}
	}
	public void displayProcessState(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException {
		ProcessEngine processEngine = new ProcessEngineImpl();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
			PEProcessState processState = null;
			if (processStateId > 0){
				processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			}
			
			ClassName cn = ClassNameLocalServiceUtil.getClassName(PEProcessState.class.getName());
			request.setAttribute("SPActivityHub_ClassPK_"+ themeDisplay.getPortletDisplay().getId(), String.valueOf(processStateId));
			request.setAttribute("SPActivityHub_ClassName_"+ themeDisplay.getPortletDisplay().getId(), PEProcessState.class.getName());
			request.setAttribute("SPActivityHub_ClassNameId_"+ themeDisplay.getPortletDisplay().getId(), cn.getClassNameId());
			request.setAttribute("SPActivityHub_DispalyParam_"+ themeDisplay.getPortletDisplay().getId(), request.getParameter("javax.portlet.action"));
			if (Validator.isNotNull(processState)){
				request.setAttribute("SPActivityHub_AssociatedWith_"+ themeDisplay.getPortletDisplay().getId(), String.valueOf(processState.getUserIdProcess()));
			}
			
			long requestedStatusTypeId = ParamUtil.getLong(request, PEConstants.PARAM_STATUS_TYPE_ID);
			PEOutput output = processEngine.executeByProcessStateId(processStateId, requestedStatusTypeId, request,
					response);
			request.setAttribute(ATTR_OUTPUT, output);
			response.setRenderParameter("jspPage", "/html/process.jsp");
		} catch (SystemException e) {
			SessionErrors.add(request, "system.error");
			include("/html/register/error.jsp", request, response);
			_log.error(e);
		}
	}

	public void process(ActionRequest request, ActionResponse response) throws IOException, PortletException, PortalException {
		displayProcessState(request, response);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		_log.error("ProcessStateAction serveResource");
		JSONObject data = JSONFactoryUtil.createJSONObject();

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String action = ParamUtil.getString(resourceRequest, "action");
		boolean multipart = ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest));
		if (multipart && org.apache.commons.lang.StringUtils.isEmpty(action)) {
			action = "upload";
		}

		if ("fetchProcessStates".equals(action)) {
			data = ProcessStateSearchHelper.searchProcessStates(resourceRequest,resourceResponse);
		} else if ("approve".equals(action)) {
			data = ProcessStateActionHelper.approve(resourceRequest, resourceResponse);
		} else if ("reject".equals(action)) {
			data = ProcessStateActionHelper.reject(resourceRequest, resourceResponse);
		} else if ("exportProessStates".equals(action)) {
			if (PermissionsUtil.hasExportPermission(themeDisplay)) {
				data = ProcessStateSearchHelper.export(resourceRequest);
			} else {
				data.put("error", "Unable to export the data");
			}
		} else if ("downloadFile".equals(action)) {
			if (PermissionsUtil.hasExportPermission(themeDisplay)) {
				String filePath = ParamUtil.getString(resourceRequest, "filePath");
				download(resourceRequest, resourceResponse, filePath);
				return;
			} else {
				data.put("error", "Unable to export the data");
			}
		} else if (PEConstants.ACTION_DOWNLOAD_FROM_TEMP.equals(action)) {
			String filePath = ParamUtil.getString(resourceRequest, "filePath");
			download(resourceRequest, resourceResponse, filePath);
			return;

		} else if ("CourseEnrollmentProcess".equalsIgnoreCase(action)) {
			CourseEnrollAction courseEnrollAction = new CourseEnrollAction();
			courseEnrollAction.serveResource(resourceRequest, resourceResponse);

			return;
		} else if ("assign".equalsIgnoreCase(action)) {
			data = ProcessStateActionHelper.assign(resourceRequest, resourceResponse);
		} else if ("changeStatus".equalsIgnoreCase(action)) {
			data = ProcessStateActionHelper.changeStatus(resourceRequest, resourceResponse);
		} else if ("close".equalsIgnoreCase(action)) {
			data = ProcessStateActionHelper.close(resourceRequest, resourceResponse);
		} else if("uploadFileToTemp".equalsIgnoreCase(action)){
			WebUploadHelper helper = WebUploadHelper.getInstance(resourceRequest, resourceResponse,themeDisplay.getScopeGroupId(),themeDisplay.getCompanyId());
			try {
				data = helper.uploadFileToTemp();
			} catch (PortalException | SystemException e) {
				_log.error(e);
				data.put("error", "Error while uploadin file");
			}
		}else if("getEntites".equalsIgnoreCase(action)){
			String servercall = ParamUtil.getString(resourceRequest, "api");
			String entityClassIdStr = ParamUtil.getString(resourceRequest, "entityType");
			long entityClassId = 0;
			if(Validator.isNotNull(entityClassIdStr)){
				entityClassId = Long.parseLong(entityClassIdStr);
			}
			data = PEProcessLocalServiceUtil.getEntitiesListing(resourceRequest,resourceResponse,servercall,entityClassId,false);
		}else if("uploadBulkRegistration".equalsIgnoreCase(action)){
			data = ProcessStateActionHelper.uploadBulkRegistration(resourceRequest, resourceResponse);
		}else if("getSubPersona".equalsIgnoreCase(action)){
			String selectedPersona = ParamUtil.getString(resourceRequest, "selectedPersona");
			data = ProcessStateActionHelper.getSubPersona(selectedPersona);
		}  else {
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
			return;
		}

		resourceResponse.getWriter().write(data.toString());
	}
	
	
	protected boolean download(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String filePath) {

		try {
			String contentType = MimeTypesUtil.getContentType(filePath);
			File file = new File(filePath);
			boolean exists = file.exists();
			if (!exists) {
				_log.info("File does not exists");
			}

			Integer length = new Integer(file.length() + "");
			resourceResponse.setContentType(contentType);
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
			resourceResponse.addProperty("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			resourceResponse.setContentLength(length);
			_log.info("File length ==" + file.length());
			if (file.length() <= 0) {
				return false;
			}

			final FileInputStream fis = new FileInputStream(file);
			OutputStream output = resourceResponse.getPortletOutputStream();
			IOUtils.copy(fis, output);
			output.flush();
			output.close();
			fis.close();

		} catch (Exception e) {
			_log.error(e);
		}
		return true;
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);

			long processStateId = GetterUtil.getLong(request.getParameter(PEConstants.PARAM_PROCESS_STATE_ID));
			long requestedStatusTypeId = ParamUtil.getLong(request,PEConstants.PARAM_STATUS_TYPE_ID);
			
			ClassName cn = ClassNameLocalServiceUtil.getClassName(PEProcessState.class.getName());
			request.setAttribute("SPActivityHub_ClassPK_"+ themeDisplay.getPortletDisplay().getId(), String.valueOf(processStateId));
			request.setAttribute("SPActivityHub_ClassName_"+ themeDisplay.getPortletDisplay().getId(), PEProcessState.class.getName());
			request.setAttribute("SPActivityHub_ClassNameId_"+ themeDisplay.getPortletDisplay().getId(), cn.getClassNameId());
			
			if (processStateId > 0){
				PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
				request.setAttribute("SPActivityHub_AssociatedWith_"+ themeDisplay.getPortletDisplay().getId(), String.valueOf(processState.getUserIdProcess()));
				request.setAttribute("SPActivityHub_DispalyParam_"+ themeDisplay.getPortletDisplay().getId(), "displayProcessState");
			}else{
				request.setAttribute("SPActivityHub_DispalyParam_"+ themeDisplay.getPortletDisplay().getId(), "processStateListing");
			}
			
			boolean supportedDevice = PEProcessHelper.supportedDevice(request);

			if (!supportedDevice) {
				_log.error("User trying to access from unsupported device");
				SessionErrors.add(request, "unsupported.device.error");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				include("/html/register/error.jsp", request, response);
				return;
			}

			if (processStateId != 0) {

				// individual application page

				// TODO: permissions
				ProcessEngine processEngine = new ProcessEngineImpl();
				try {
					PEOutput output = processEngine.executeByProcessStateId(processStateId, requestedStatusTypeId, request,
							response);
					request.setAttribute(ATTR_OUTPUT, output);
					include("/html/process.jsp", request, response);
				} catch (SystemException e) {
					SessionErrors.add(request, "system.error");
					include("/html/register/error.jsp", request, response);
					_log.error(e);
				}
			} else {

			// show listing page

				PortletPreferences portletPreferences = request.getPreferences();
				String processIds = portletPreferences.getValue(PEConstants.PREF_PROCESS_IDS, "0");
				// checking the setup

				if (Validator.isNull(processIds)) {

					// incorrect configuration

					SessionErrors.add(request, "config.process.state.list.error");
					include("/html/register/error.jsp", request, response);
				} else {

					// call search helper

					// ProcessStateSearchHelper.searchProcessStates(request);
					super.doView(request, response);
				}
			}

		
				List<Product> list = ProductLocalServiceUtil.getProducts(-1, -1);
				request.setAttribute("products", list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProcessStateAction.class);

}
