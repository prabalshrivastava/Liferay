package com.sambaash.platform.ato.sponseredcandidates;




import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.ato.ajax.CreateActionHandler;
import com.sambaash.platform.ato.ajax.DownloadPdfActionHandler;
import com.sambaash.platform.ato.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.ato.ajax.ExportListActionHandler;
import com.sambaash.platform.ato.ajax.ExportPdfActionHandler;
import com.sambaash.platform.ato.ajax.ExportRowActionHandler;
import com.sambaash.platform.ato.ajax.FetchActionHandler;
import com.sambaash.platform.ato.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.ato.ajax.FileDownloadActionHandler;
import com.sambaash.platform.ato.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.ato.ajax.LoadListActionHandler;
import com.sambaash.platform.ato.ajax.ProcessStatusDataActionHandler;
import com.sambaash.platform.ato.ajax.ScannedDataActionHandler;
import com.sambaash.platform.ato.ajax.SearchListActionHandler;
import com.sambaash.platform.ato.ajax.SendInvoiceHandler;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;


public class SponseredCandidates extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("scanedData", ScannedDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("processStatus", ProcessStatusDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportPdf", ExportPdfActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendInvoice", SendInvoiceHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("downloadPdf", DownloadPdfActionHandler.class);
	}
	/**
	 * This is an object of Log class
	 * @throws PortletException 
	 * @throws IOException 
	 */
	
	
	

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		
		PortletPreferences prefer = renderRequest.getPreferences();
		
		String secondaryContact = null;
		String trainingPricipalRole = null;
		
		
		if (prefer.getMap().containsKey("secondaryContact")) {
		
			secondaryContact = prefer.getMap().get("secondaryContact")[0];
		}
		if (prefer.getMap().containsKey("traniningPrincipalRole")) {
		
			trainingPricipalRole = prefer.getMap()
					.get("traniningPrincipalRole")[0];
		}
		
		
		String userType = SPATOAdmissionLocalServiceUtil.getUserType(
				secondaryContact, trainingPricipalRole, 
				themeDisplay.getUserId());
		String atoName= SPATOAdmissionLocalServiceUtil.getAtoName(userType,themeDisplay.getUserId());
		renderRequest.setAttribute("userType", userType);
		renderRequest.setAttribute("atoName", atoName);
		

		super.doView(renderRequest, renderResponse);
	}


	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		
		
		
		PortletPreferences prefer = request.getPreferences();
		
		String secondaryContact = null;
		String trainingPricipalRole = null;
		
		
		if (prefer.getMap().containsKey("secondaryContact")) {
		
			secondaryContact = prefer.getMap().get("secondaryContact")[0];
		}
		if (prefer.getMap().containsKey("traniningPrincipalRole")) {
		
			trainingPricipalRole = prefer.getMap()
					.get("traniningPrincipalRole")[0];
		}
		
		
		String userType = SPATOAdmissionLocalServiceUtil.getUserType(
				secondaryContact, trainingPricipalRole, 
				themeDisplay.getUserId());
		
		String atoName= SPATOAdmissionLocalServiceUtil.getAtoName(userType,themeDisplay.getUserId());
		request.setAttribute("userType", userType);
		request.setAttribute("atoName", atoName);
		super.render(request, response);
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			//log.error(e);
		}
	}
	
	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		String relcUserRole = ParamUtil.getString(actionRequest,
				"secondaryContact", "");
		String traniningPrincipalRole = ParamUtil.getString(actionRequest,
				"traniningPrincipalRole", "");
		
		try {
			preferences.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.setValue("secondaryContact", relcUserRole);
			preferences.setValue("traniningPrincipalRole",
					traniningPrincipalRole);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			//log.error(e);
		}
	}
	
	




}

