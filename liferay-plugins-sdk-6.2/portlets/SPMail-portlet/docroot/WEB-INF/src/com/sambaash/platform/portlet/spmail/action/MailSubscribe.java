package com.sambaash.platform.portlet.spmail.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class MailSubscribe
 */
public class MailSubscribe extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(MailSubscribe.class);
 
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String action = ParamUtil.getString(resourceRequest, "action");
		if("subscribe".equalsIgnoreCase(action)){
			JSONObject responseData  = subscribe(resourceRequest, resourceResponse);
			resourceResponse.getWriter().write(responseData.toString());
		}else if("subscribeToEmail".equalsIgnoreCase(action)){
			JSONObject responseData  = subscribeToEmail(resourceRequest, resourceResponse);
			resourceResponse.getWriter().write(responseData.toString());
		}

	}
	private JSONObject subscribeToEmail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		String emailAddress = ParamUtil.getString(resourceRequest, "emailAddress");
		if (!Validator.isEmailAddress(emailAddress)) {
			responseData.put("error", "Not a valid EmailAddress");
			return responseData;
		}
		String firstName = ParamUtil.getString(resourceRequest, "firstName");
		String lastName = ParamUtil.getString(resourceRequest, "lastName");
		PortletPreferences prefs = resourceRequest.getPreferences();
		long campaignId = GetterUtil.getLong(prefs.getValue("campaignId", ""));
		if(campaignId == 0){
			_log.error("Mail Subscriber preference not valid. Missing campaign Id");
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			SPMailCampaignLocalServiceUtil.subscribeToCampaign(emailAddress,  firstName,
					lastName, campaignId,PortalUtil.getPortalURL(resourceRequest));		
			} catch(Exception e) {
			_log.error("Error while adding campaign subscriber" + e.getMessage(),e);
			responseData.put("error", "Can not subscribe at this moment.");
		}
		return responseData;
	}

	public JSONObject subscribe(ResourceRequest request, ResourceResponse response) {
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		String emailAddress = ParamUtil.getString(request, "emailAddress");
		if (!Validator.isEmailAddress(emailAddress)) {
			responseData.put("error", "Not a valid EmailAddress");
			return responseData;
		}
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		PortletPreferences prefs = request.getPreferences();
		long campaignId = GetterUtil.getLong(prefs.getValue("campaignId", ""));
		if(campaignId == 0){
			_log.error("Mail Subscriber preference not valid. Missing campaign Id");
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			SPMailCampaignSubscribersLocalServiceUtil.addSubscriber(themeDisplay.getCompanyId(), themeDisplay.getUserId(), campaignId, firstName, lastName, emailAddress);
		} catch (SystemException e) {
			_log.error("Error while adding campaign subscriber" + e.getMessage(),e);
			responseData.put("error", "Can not subscribe at this moment.");
		}
		return responseData;
	}

}
