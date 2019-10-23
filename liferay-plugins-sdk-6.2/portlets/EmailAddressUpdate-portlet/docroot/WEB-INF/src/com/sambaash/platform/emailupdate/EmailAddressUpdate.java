package com.sambaash.platform.emailupdate;

import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.portal.kernel.util.ParamUtil;
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
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * Portlet implementation class EmailAddressUpdate
 */
public class EmailAddressUpdate extends MVCPortlet {
	private Log _log = LogFactoryUtil.getLog(EmailAddressUpdate.class.getName());

	public void updateEmailAddress(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		_log.info("*******************calling updateEmailAddress***********************");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(EmailAddressUpdate.class.getName(),actionRequest);
	
		String currentEmail = ParamUtil.getString(actionRequest, "currentEmail", "");
		String newEmail = ParamUtil.getString(actionRequest, "newEmail", "");

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
						/* Date expirationDate = new Date(); */
						Date expirationDate = null;
						Ticket ticket=TicketLocalServiceUtil.addTicket(themeDisplay.getCompanyId(), User.class.getName(),
								currentUsr.getUserId(), TicketConstants.TYPE_EMAIL_ADDRESS,
								currentUsr.getEmailAddress(), expirationDate, serviceContext);

						UserLocalServiceUtil.sendEmailAddressVerification(
								currentUsr, ticket.getExtraInfo(), serviceContext);
					 	
					} catch (Exception e) {
						errorKey = "EMAIL ADDRESS NOT UPDATED";
					}

				} else {
					errorKey = "USER ALREADY IN USE";
				}

			} else {

				errorKey = "USER NOT FOUND";
			}

		} catch (Exception e) {
			errorKey = "USER NOT FOUND";
			_log.error(e.getMessage());
		}
		if (Validator.isNull(errorKey)) {
			SessionMessages.add(actionRequest, "updated Successfully");
		} else {
			SessionErrors.add(actionRequest, errorKey);
		}

	}
	
}
