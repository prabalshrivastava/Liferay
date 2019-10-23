/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.rpec.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.json.JSONObject;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.rpec.service.base.SPRPECServiceBaseImpl;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;

/**
 * The implementation of the s p r p e c remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.rpec.service.SPRPECService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author gaurav.kapadiya
 * @see com.sambaash.platform.rpec.service.base.SPRPECServiceBaseImpl
 * @see com.sambaash.platform.rpec.service.SPRPECServiceUtil
 */
public class SPRPECServiceImpl extends SPRPECServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.rpec.service.SPRPECServiceUtil} to access the s p r
	 * p e c remote service.
	 */

	private static final Log _log = LogFactoryUtil
			.getLog(SPRPECServiceImpl.class);

	@AccessControlled(guestAccessEnabled = true)
	public void updateStatusNotification(String candidateEmail,
			String firstName, String lastName, String rpecStatus,
			String updateBy, String dateOfUpdation, String mentorId,
			String trainingPricipalId) throws PortalException, SystemException {
		try {
			if(lastName.equals("lastName"))
			{
				lastName="";
			}
			User updatedBy = UserLocalServiceUtil.getUserById(Long
					.valueOf(updateBy));
			User mentor = null;
			if(!mentorId.equals("null"))
			{
				mentor = UserLocalServiceUtil.getUserById(Long
						.valueOf(mentorId));
			}
			
			User trainingPricipal = null;
			if(!trainingPricipalId.equals("null"))
			{
				trainingPricipal = UserLocalServiceUtil.getUserById(Long.valueOf(trainingPricipalId));
			}

			MailMessage mailMessage = new MailMessage();

			String mailTemplateIdParameter = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
							0,
							"rpec.erpec.update.status.notification.template.id")
					.getValue().toString();

			SPMailTemplate spmailTem = null;

			try {
				spmailTem = SPMailTemplateLocalServiceUtil
						.getTemplateByName(mailTemplateIdParameter);
			} catch (NullPointerException e) {
				_log.error(e);
				return;
			}
			if (spmailTem != null) {
				mailMessage.setSubject("Alert From ERPEC");

				mailMessage.setFromAddress("alerts@sambaash.com");
				mailMessage.setFromName("Alert From ERPEC");
				mailMessage.setHtmlFormat(true);
				String bodyContent = spmailTem.getHtmlContent();
				bodyContent = bodyContent.replace("[$first_name]", firstName);
				bodyContent = bodyContent.replace("[$last_name]", lastName);
				bodyContent = bodyContent.replace("[$update_by]",
						updatedBy.getFullName());
				bodyContent = bodyContent.replace("[$update_status]",
						rpecStatus);
				
				if(mentor != null)
				{
					bodyContent = bodyContent.replace("[$mentor_name]",
							mentor.getFullName());
				}else
				{
					bodyContent = bodyContent.replace("[$mentor_name]",
							"");
				}
				
				if(trainingPricipal != null)
				{
					bodyContent = bodyContent.replace("[$training_principal_name]",
							trainingPricipal.getFullName());
				}else
				{
					bodyContent = bodyContent.replace("[$training_principal_name]",
							"");
				}
				
				bodyContent = bodyContent.replace("[$date_of_update]",
						dateOfUpdation);

				mailMessage.setHtmlBody(bodyContent);
				if (rpecStatus.equalsIgnoreCase("Pending Sign Off")) {
					mailMessage
							.setToAddress(trainingPricipal.getEmailAddress());
					SPMailLocalServiceUtil.sendMail(mailMessage);
				} else if (rpecStatus
						.equalsIgnoreCase("Pending Standard Approval")
						|| rpecStatus
								.equalsIgnoreCase("Pending Final Approval")) {
					mailMessage.setToAddress(mentor.getEmailAddress());
					SPMailLocalServiceUtil.sendMail(mailMessage);

				} else {
					mailMessage.setToAddress(candidateEmail);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}

			}
		} catch (Exception e) {
			_log.error(e.toString());
		}

	}
}