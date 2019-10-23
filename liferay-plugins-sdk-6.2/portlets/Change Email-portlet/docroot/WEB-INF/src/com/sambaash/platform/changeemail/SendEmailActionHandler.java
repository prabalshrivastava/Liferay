package com.sambaash.platform.changeemail;

import java.util.Date;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.TicketConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class SendEmailActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(SendEmailActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(SendEmailActionHandler.class.getName(),
					request);
		} catch (PortalException | SystemException e1) {
			log.error(e1.getMessage());
		}
		String currentEmail = request.getParameter("currentEmail");  
		String newEmail = request.getParameter("newEmail");   
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		User currentUsr = null;
		User newUser = null;
		String errorKey = "";

		try {

			currentUsr = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), currentEmail);
		
			if (currentUsr != null) {

				newUser = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), newEmail);
			
				if (newUser == null) {
					try {
						
						currentUsr.setEmailAddress(newEmail);
						currentUsr.setEmailAddressVerified(false);
						UserLocalServiceUtil.updateUser(currentUsr);
						Contact cnt = currentUsr.getContact();
						cnt.setEmailAddress(newEmail);
						ContactLocalServiceUtil.updateContact(cnt);
						Date expirationDate = null;
						
						Ticket ticket=TicketLocalServiceUtil.addTicket(themeDisplay.getCompanyId(), User.class.getName(),
								currentUsr.getUserId(), TicketConstants.TYPE_EMAIL_ADDRESS,
								currentUsr.getEmailAddress(), expirationDate, serviceContext);
						
							UserLocalServiceUtil.sendEmailAddressVerification(
									currentUsr, ticket.getExtraInfo(), serviceContext);
							response.getWriter().write("Email sent");
						
					} catch (Exception e) {
						errorKey = "EMAIL ADDRESS NOT UPDATED";
					}

				} else {
					errorKey = "USER ALREADY IN USE";
				}

			} else {

				errorKey = "USER NOT FOUND";
			}
			response.getWriter().write(errorKey);
		} catch (Exception e) {
			errorKey = "USER NOT FOUND1";
			log.error(e.getMessage());
		}

		if (Validator.isNull(errorKey)) {
			SessionMessages.add(request, "updated Successfully");
		} else {
			SessionErrors.add(request, errorKey);
		}
	}


}

