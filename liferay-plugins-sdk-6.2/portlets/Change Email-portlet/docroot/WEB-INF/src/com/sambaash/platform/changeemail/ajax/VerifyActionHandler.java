package com.sambaash.platform.changeemail.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class VerifyActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(VerifyActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
	
		log.debug("***************Eureka****"+user.getEmailAddress().toString()+"*************************");
	
		String ticketKey  = request.getParameter("ticketKey");  
		String errorKey = "";

		try {
		
			if(themeDisplay.isSignedIn() && !user.isEmailAddressVerified())
			{
			Ticket ticket=TicketLocalServiceUtil.fetchTicket(ticketKey);
	
			if(ticket!=null) {
			
				if((user.getEmailAddress().equals(ticket.getExtraInfo()))){
					
					user.setEmailAddressVerified(true);
					response.getWriter().write("EmailAdress Verified");
				}
				else
				{
					errorKey = "INVALID VERIFICATION CODE";
				}
			}
			else
			{
				errorKey = "INVALID VERIFICATION CODE";
			}
			
		}
		} 
				catch (Exception e) {
						errorKey = "EMAIL ADDRESS NOT VERIFIED";
						log.error(e.getMessage());
					}

				 
		if (Validator.isNull(errorKey)) {
			SessionMessages.add(request, "updated Successfully");
		} else {
			SessionErrors.add(request, errorKey);
		}
	}
}