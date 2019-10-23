package com.sambaash.platform.generaluser;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GeneralUserDashBoardPortlet
 */
public class GeneralUserDashBoardPortlet extends MVCPortlet {
 
	private Log log = LogFactoryUtil.getLog(GeneralUserDashBoardPortlet.class.getName());
	
	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse)  {
		PortletPreferences preferences = actionRequest.getPreferences();
		String callOut1Link = ParamUtil.getString(actionRequest, "CallOut1Link", StringPool.BLANK);
		String callOut2Link = ParamUtil.getString(actionRequest, "CallOut2Link", StringPool.BLANK);
		String callOut3Link = ParamUtil.getString(actionRequest, "CallOut3Link", StringPool.BLANK);
		
		
		String image1Link = ParamUtil.getString(actionRequest, "Image1Link", StringPool.BLANK);
		String image2Link = ParamUtil.getString(actionRequest, "Image2Link", StringPool.BLANK);
		String image3Link = ParamUtil.getString(actionRequest, "Image3Link", StringPool.BLANK);
		
		
		String title1 = ParamUtil.getString(actionRequest,"title1", StringPool.BLANK);
		String title2 = ParamUtil.getString(actionRequest,"title2", StringPool.BLANK);
		String title3 = ParamUtil.getString(actionRequest,"title3", StringPool.BLANK);
		
		String action1 = ParamUtil.getString(actionRequest,"action1", StringPool.BLANK);
		String action2 = ParamUtil.getString(actionRequest,"action2", StringPool.BLANK);
		String action3 = ParamUtil.getString(actionRequest,"action3", StringPool.BLANK);
		
		
		try {
			preferences.setValue("CallOut1Link", callOut1Link);
			preferences.setValue("CallOut2Link", callOut2Link);
			preferences.setValue("CallOut3Link", callOut3Link);
			
			preferences.setValue("Image1Link", image1Link);
			preferences.setValue("Image2Link", image2Link);
			preferences.setValue("Image3Link", image3Link);
			
			preferences.setValue("title1", title1);
			preferences.setValue("title2", title2);
			preferences.setValue("title3", title3);
			
			preferences.setValue("action1", action1);
			preferences.setValue("action2", action2);
			preferences.setValue("action3", action3);
			
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}
		
		
		
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			if(action.equalsIgnoreCase("savePreference")){
				PortletPreferences preferences = resourceRequest.getPreferences();
				String tt = preferences.getValue("config", "dd");
				
				preferences.setValue("config", resourceRequest.getParameter("formdata"));
				preferences.store();
				
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
}
