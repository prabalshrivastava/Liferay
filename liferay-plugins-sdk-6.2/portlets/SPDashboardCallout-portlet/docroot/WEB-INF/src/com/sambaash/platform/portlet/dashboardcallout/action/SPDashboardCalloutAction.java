package com.sambaash.platform.portlet.dashboardcallout.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.model.ProfileType;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SPDashboardCalloutAction
 */
public class SPDashboardCalloutAction extends MVCPortlet {



	private static Log _log = LogFactoryUtil.getLog(SPDashboardCalloutAction.class);
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {


		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String userImage = preferences.getValue("userImage", "0");
		String userCalloutUrl = preferences.getValue("userCalloutUrl", "0");
		String startUpImage = preferences.getValue("startUpImage", "0");
		String startupCalloutUrl = preferences.getValue("startupCalloutUrl", "0");
		String marketerImage = preferences.getValue("marketerImage", "0");
		String marketerCalloutUrl = preferences.getValue("marketerCalloutUrl", "0");
		String mentorImage = preferences.getValue("mentorImage", "0");
		String mentorCalloutUrl = preferences.getValue("mentorCalloutUrl", "0");

		renderRequest.setAttribute("userImage", userImage);
		renderRequest.setAttribute("userCalloutUrl", userCalloutUrl);
		renderRequest.setAttribute("startUpImage", startUpImage);
		renderRequest.setAttribute("startupCalloutUrl", startupCalloutUrl);
		renderRequest.setAttribute("marketerImage", marketerImage);
		renderRequest.setAttribute("marketerCalloutUrl", marketerCalloutUrl);
		renderRequest.setAttribute("mentorImage", mentorImage);
		renderRequest.setAttribute("mentorCalloutUrl", mentorCalloutUrl);
		
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String imageUrl = StringPool.BLANK;
		String callOutUrl = StringPool.BLANK;

		PortletPreferences preferences = renderRequest.getPreferences();
		String userImage = preferences.getValue("userImage", "0");
		String userCalloutUrl = preferences.getValue("userCalloutUrl", "0");
		String startUpImage = preferences.getValue("startUpImage", "0");
		String startupCalloutUrl = preferences.getValue("startupCalloutUrl", "0");
		String marketerImage = preferences.getValue("marketerImage", "0");
		String marketerCalloutUrl = preferences.getValue("marketerCalloutUrl", "0");
		String mentorImage = preferences.getValue("mentorImage", "0");
		String mentorCalloutUrl = preferences.getValue("mentorCalloutUrl", "0");
		
		 String userType = StringPool.BLANK;
		 try{
		 if (Validator.isNotNull(user.getExpandoBridge().getAttribute("profile-type"))) {
				ExpandoBridge bridge = user.getExpandoBridge();
				String[] pList = (String[]) ExpandoValueLocalServiceUtil.getData(user.getCompanyId(),
						bridge.getClassName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.PROFILE_TYPE,
						user.getUserId(), new String[] {});
				if (Validator.isNotNull(pList) && pList.length > 0) {
					userType = pList[0];
				} else {
					userType = ProfileType.USER.getValue();
				}
			}
		 }catch(Exception e){
			 _log.error("Error getting user type " + e.getMessage());
		 }
		 
		 if(Validator.isNotNull(userType) && ProfileType.MARKETER.getValue().equalsIgnoreCase(userType)){
			 if(SambaashUtil.isMentor(user)){
				 imageUrl = mentorImage;
				 callOutUrl = mentorCalloutUrl;
			 }else{
				 imageUrl = marketerImage;
				 callOutUrl = marketerCalloutUrl;
			 }
		 }else if(Validator.isNotNull(userType) && ProfileType.STARTUP.getValue().equalsIgnoreCase(userType)){
			 imageUrl = startUpImage;
			 callOutUrl = startupCalloutUrl;
		 }else{
			 imageUrl = userImage;
			 callOutUrl = userCalloutUrl; 
		 }
		
		 renderRequest.setAttribute("imageUrl", imageUrl);
			renderRequest.setAttribute("callOutUrl", callOutUrl);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();
		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String userImage = actionRequest.getParameter("userImage");
			String userCalloutUrl = actionRequest.getParameter("userCalloutUrl");
			String startUpImage = actionRequest.getParameter("startUpImage");
			String startupCalloutUrl = actionRequest.getParameter("startupCalloutUrl");
			String marketerImage = actionRequest.getParameter("marketerImage");
			String marketerCalloutUrl = actionRequest.getParameter("marketerCalloutUrl");
			String mentorImage = actionRequest.getParameter("mentorImage");
			String mentorCalloutUrl = actionRequest.getParameter("mentorCalloutUrl");
			
			preferences.setValue("userImage", userImage);
			preferences.setValue("userCalloutUrl", userCalloutUrl);
			preferences.setValue("startUpImage", startUpImage);
			preferences.setValue("startupCalloutUrl", startupCalloutUrl);
			preferences.setValue("marketerImage", marketerImage);
			preferences.setValue("marketerCalloutUrl", marketerCalloutUrl);
			preferences.setValue("mentorImage", mentorImage);
			preferences.setValue("mentorCalloutUrl", mentorCalloutUrl);

			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);
		}
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}

}
