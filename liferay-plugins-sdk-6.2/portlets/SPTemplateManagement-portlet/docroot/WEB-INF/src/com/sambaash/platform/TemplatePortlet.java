package com.sambaash.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.helper.TemplatePermissionHelper;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.template.model.SPComponentTemplate;
import com.sambaash.platform.srv.template.model.SPTemplate;
import com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil;
import com.sambaash.platform.templatemanagement.action.ajax.AddTemplateActionHandler;
import com.sambaash.platform.templatemanagement.action.ajax.DeleteTemplateActionHandler;
import com.sambaash.platform.templatemanagement.action.ajax.EditTemplateActionHandler;
import com.sambaash.platform.util.TemplateUtil;

/**
 * Portlet implementation class TemplatePortlet
 */
public class TemplatePortlet extends MVCPortlet {
 
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("createTemplate", AddTemplateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("editTemplate", EditTemplateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("deleteTemplate", DeleteTemplateActionHandler.class);
				
	}
	/**
     * This is an object of Log class
     */
    private Log _log = LogFactoryUtil.getLog(TemplatePortlet.class.getName());
	
    
    @Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
    	
		HashMap<Long,String> formList = new HashMap<Long,String>();
		JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsListV2();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject step2JsonObject = jsonArray.getJSONObject(i);
			formList.put(step2JsonObject.getLong("htmlFormId"),step2JsonObject.getString("formName"));
			
		}
		String delta = "4"; String cur = "1";
		if(renderRequest.getParameter("delta") != null){
			delta = renderRequest.getParameter("delta");
		}
		if(renderRequest.getParameter("cur") != null){
			cur = renderRequest.getParameter("cur");
		}
		List alltemplates =  SPTemplateLocalServiceUtil.getAllTemplates(cur,delta); 
		
		renderRequest.setAttribute("formList", formList);
		renderRequest.setAttribute("templates", alltemplates);
		int templatesCount = 0;
		templatesCount = SPTemplateLocalServiceUtil.getAllTemplatesCount();
		renderRequest.setAttribute("templatescount",templatesCount);
		_log.info("template count is " + templatesCount);
		
		super.doView(renderRequest, renderResponse);
	}
    @ProcessAction(name = "createTemplate")
    public void createTemplate(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException {
    	if(TemplatePermissionHelper.canAddTemplate(actionRequest)){
	    	HashMap<String,JSONObject> systemtemplates =new HashMap();
			HashMap<String,JSONObject> copiedtemplates =new HashMap();
			TemplateUtil.getFormsListV2(systemtemplates,copiedtemplates); 
			actionRequest.setAttribute("systemtemplates", systemtemplates);
			actionRequest.setAttribute("copiedtemplates", copiedtemplates);
			actionResponse.setRenderParameter("jspPage", "/html/template/create_template.jsp");
	    }
		else{
			actionResponse.setRenderParameter("jspPage", "/html/template/noaccess.jsp");
		}
    }
    @ProcessAction(name = "viewTemplates")
    public void viewTemplates(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException {
    	if(TemplatePermissionHelper.canViewTemplate(actionRequest)){
	    	
    		HashMap<Long,String> formList = new HashMap<Long,String>();
    		JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsListV2();
    		for (int i = 0; i < jsonArray.length(); i++) {
    			JSONObject step2JsonObject = jsonArray.getJSONObject(i);
    			formList.put(step2JsonObject.getLong("htmlFormId"),step2JsonObject.getString("formName"));
    			
    		}
    		String delta = "4"; String cur = "1";
    		if(actionRequest.getParameter("delta") != null){
    			delta = actionRequest.getParameter("delta");
    		}
    		if(actionRequest.getParameter("cur") != null){
    			cur = actionRequest.getParameter("cur");
    		}
    		List alltemplates =  SPTemplateLocalServiceUtil.getAllTemplates(cur,delta); 
    		
    		actionRequest.setAttribute("formList", formList);
    		actionRequest.setAttribute("templates", alltemplates);
    		int templatesCount = 0;
    		templatesCount = SPTemplateLocalServiceUtil.getAllTemplatesCount();
    		actionRequest.setAttribute("templatescount",templatesCount);
    		_log.info("template count is " + templatesCount);
			
			actionResponse.setRenderParameter("jspPage", "/html/template/view_templates.jsp");
    	}
    	else{
			
			actionResponse.setRenderParameter("jspPage", "/html/template/noaccess.jsp");
		}
    }
    
	@ProcessAction(name = "viewTemplateDetail")
    public void viewTemplateDetail(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException {
		long templateId = ParamUtil.getLong(actionRequest, "templateId");
		List templateObject = SPTemplateLocalServiceUtil.getTemplateDetail(templateId);
		
		if(TemplatePermissionHelper.canViewTemplate(actionRequest)){

			HashMap<Long,String> formList = new HashMap<Long,String>();
			JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsListV2();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject step2JsonObject = jsonArray.getJSONObject(i);
				formList.put(step2JsonObject.getLong("htmlFormId"),step2JsonObject.getString("formName"));
			}
			actionRequest.setAttribute("formList", formList);
			if(templateObject.size() > 0){
				Object[] arrayobject=(Object[])templateObject.get(0); 
				SPTemplate template=(SPTemplate)arrayobject[0];
				List<SPComponentTemplate> componentTemplates =  new ArrayList<SPComponentTemplate>(); 
				for (int i = 0; i< templateObject.size(); i++) {
					arrayobject=(Object[])templateObject.get(i);
					if((arrayobject.length > 1)){
						componentTemplates.add((SPComponentTemplate)arrayobject[1]);
					}
				}
				actionRequest.setAttribute("template", template);
				actionRequest.setAttribute("componentTemplates", componentTemplates);
		        actionResponse.setRenderParameter("jspPage", "/html/template/template_detail.jsp");
			}
			else{
		       _log.info("#################Template Detail found#########################");
			}
			
		}else{
			actionResponse.setRenderParameter("jspPage", "/html/template/noaccess.jsp");
		}
		
    }
	
	@ProcessAction(name = "editTemplate")
    public void editTemplate(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException {
		if(TemplatePermissionHelper.canAddTemplate(actionRequest)){
			long templateId = ParamUtil.getLong(actionRequest, "templateId");
			List templateObject = SPTemplateLocalServiceUtil.getTemplateDetail(templateId);
			if(templateObject.size() > 0){
				Object[] arrayobject=(Object[])templateObject.get(0); 
				SPTemplate template=(SPTemplate)arrayobject[0];
				List<SPComponentTemplate> componentTemplates =  new ArrayList<SPComponentTemplate>(); 
				
				for (int i = 0; i< templateObject.size(); i++) {
					arrayobject=(Object[])templateObject.get(i);
					if((arrayobject.length > 1)){
						componentTemplates.add((SPComponentTemplate)arrayobject[1]);
					}
				}
				actionRequest.setAttribute("template", template);
				actionRequest.setAttribute("componentTemplates", componentTemplates);
				HashMap<String,JSONObject> systemtemplates =new HashMap();
				HashMap<String,JSONObject> copiedtemplates =new HashMap();
				TemplateUtil.getFormsListV2(systemtemplates,copiedtemplates); 
				actionRequest.setAttribute("systemtemplates", systemtemplates);
				actionRequest.setAttribute("copiedtemplates", copiedtemplates);
				
		        actionResponse.setRenderParameter("jspPage", "/html/template/edit_template.jsp");
			}
			else{
		       _log.info("#################Template Detail found#########################");
			}
		}
		else{
			actionRequest.setAttribute("permission_granted", "false");
			actionResponse.setRenderParameter("jspPage", "/html/template/noaccess.jsp");
		}
    }
	
    @Override
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
	    try {
		    _log.info("log---"+ resourceRequest.toString());
		    String action = resourceRequest.getParameter( "action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
	    }
	    catch (Exception e) {
	    	_log.error(e.getMessage());
	    }
    }
    
    
}
