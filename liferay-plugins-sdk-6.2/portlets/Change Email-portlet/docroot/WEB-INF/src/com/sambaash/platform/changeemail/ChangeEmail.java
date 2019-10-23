package com.sambaash.platform.changeemail;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.changeemail.ajax.UpdateActionHandler;
import com.sambaash.platform.changeemail.ajax.VerifyActionHandler;

/**
 * Portlet implementation class ChangeEmail
 */
public class ChangeEmail extends MVCPortlet {
 
	private Log _log = LogFactoryUtil.getLog(ChangeEmail.class.getName());
	
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendVerificationCode", SendEmailActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("verify",  VerifyActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("update", UpdateActionHandler.class);
	
	}
	
	@Override 
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
	    try {
		    String action = resourceRequest.getParameter( "action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
	    }
	    catch (Exception e) {
	    	_log.error(e);
	    }
    }
	public void updateEmailAddress(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {

}
}

