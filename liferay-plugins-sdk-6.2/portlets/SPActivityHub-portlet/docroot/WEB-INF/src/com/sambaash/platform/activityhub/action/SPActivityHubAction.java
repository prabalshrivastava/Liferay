package com.sambaash.platform.activityhub.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.activityhub.constants.SPActivityHubConstants;
import com.sambaash.platform.activityhub.helper.SPActivityHubHelper;
import com.sambaash.platform.activityhub.helper.WebUploadHelper;
import com.sambaash.platform.util.SambaashUtil;

public class SPActivityHubAction extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(SPActivityHubAction.class);

	public void init() throws PortletException{
		super.init();
		try{
			SambaashUtil.clearAllCaches();
			
		}catch(Exception ex){
		}
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			int count = 0;
			Enumeration<String> attributeNames = renderRequest.getAttributeNames();
			long entityId = 0, entityClassId = 0, associatedWith = 0;
			String entityClassName = StringPool.BLANK;
			String displayParam = StringPool.BLANK;
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			while ( attributeNames.hasMoreElements())
	        {
	            Object attributeName;
	            
	            if((attributeName = attributeNames.nextElement())!=null)
	            {
	            	if(String.valueOf(attributeName).contains("SPActivityHub_ClassName_")){
	            		count += 1;
	            		entityClassName = renderRequest.getAttribute(String.valueOf(attributeName)).toString();
	            		_log.debug("attributes in activityhub action " + entityClassName);
	            	} else if(String.valueOf(attributeName).contains("SPActivityHub_ClassPK_")){
	            		entityId = Long.parseLong(renderRequest.getAttribute(String.valueOf(attributeName)).toString());
	            	} else if(String.valueOf(attributeName).contains("SPActivityHub_ClassNameId_")){
	            		entityClassId = Long.parseLong(renderRequest.getAttribute(String.valueOf(attributeName)).toString());
	            	} else if(String.valueOf(attributeName).contains("SPActivityHub_AssociatedWith_")){
	            		associatedWith = Long.parseLong(renderRequest.getAttribute(String.valueOf(attributeName)).toString());
	            	} else if(String.valueOf(attributeName).contains("SPActivityHub_DispalyParam_")){
	            		displayParam = renderRequest.getAttribute(String.valueOf(attributeName)).toString();
	            	}
	            	
	               
	            }
	
	        }
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			
			String userTypeLoggedIn = SPActivityHubHelper.checkInternalOrExternal(renderRequest, user);
			
			String dispalyParamValues = SambaashUtil.getParameter(SPActivityHubConstants.SP_PARAM_ACTIVITY_HUB_DISPLAY, 0);
			List<String> dispalyParamList = Arrays.asList(dispalyParamValues.split(","));
			if (count == 1 && dispalyParamList.contains(displayParam)){
				renderRequest.setAttribute(SPActivityHubConstants.ENTITY_ID, entityId);
				renderRequest.setAttribute(SPActivityHubConstants.ENTITY_CLASS_ID, entityClassId);
				renderRequest.setAttribute(SPActivityHubConstants.ENTITY_CLASS_NAME, entityClassName);
				renderRequest.setAttribute(SPActivityHubConstants.ASSOCIATED_WITH, associatedWith);
				include("/view.jsp", renderRequest, renderResponse);
			}
		}
		catch (Exception e){
			_log.error(e);
		}

		
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String action = ParamUtil.getString(resourceRequest, "action");
		
		if ("saveConversation".equals(action)) {
			data = SPActivityHubHelper.saveConversation(resourceRequest);
		}else if ("loadConversation".equals(action)) {
			data = SPActivityHubHelper.searchConversation(resourceRequest);
		}else if ("deleteConversation".equals(action)) {
			data = SPActivityHubHelper.deleteConversation(resourceRequest);
		} else if("uploadFileToTemp".equalsIgnoreCase(action)){
			WebUploadHelper helper = WebUploadHelper.getInstance(resourceRequest, resourceResponse,themeDisplay.getScopeGroupId(),themeDisplay.getCompanyId());
			try {
				data = helper.uploadFileToTemp();
			} catch (PortalException | SystemException e) {
				_log.error(e);
				data.put("error", "Error while uploadin file");
			}
		}else if ("fetchConversation".equals(action)) {
			data = SPActivityHubHelper.searchConversation(resourceRequest);
		}else if ("restrictConversation".equals(action)) {
			data = SPActivityHubHelper.restrictConversation(resourceRequest);
		}else if ("saveNote".equals(action)) {
			data = SPActivityHubHelper.saveNote(resourceRequest);
		}else if ("loadNote".equals(action)) {
			data = SPActivityHubHelper.searchNote(resourceRequest);
		}else if ("deleteNote".equals(action)) {
			data = SPActivityHubHelper.deleteNote(resourceRequest);
		}else if ("updateNote".equals(action)) {
			data = SPActivityHubHelper.updateNote(resourceRequest);
		}else if ("loadLogActivity".equals(action)) {
			data = SPActivityHubHelper.searchLogActivity(resourceRequest);
		}else if ("saveLogActivity".equals(action)) {
			data = SPActivityHubHelper.saveLogActivity(resourceRequest);
		}else if ("deleteLogActivity".equals(action)) {
			data = SPActivityHubHelper.deleteLogActivity(resourceRequest);
		}else if ("updateLogActivity".equals(action)) {
			data = SPActivityHubHelper.updateLogActivity(resourceRequest);
		}
		
		resourceResponse.getWriter().write(data.toString());
		
		
	}
	
	
}
