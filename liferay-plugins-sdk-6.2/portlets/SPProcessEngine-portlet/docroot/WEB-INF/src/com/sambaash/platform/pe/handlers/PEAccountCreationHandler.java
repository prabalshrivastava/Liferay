package com.sambaash.platform.pe.handlers;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.util.PwdGenerator;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEMailHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.helpers.PEUrlHelper;
import com.sambaash.platform.pe.jaxb.PECreatAccountNode;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PEAccountCreationHandler extends PESingleOutputNodeHandler {

	private static Log _log = LogFactoryUtil.getLog(PEAccountCreationHandler.class);

	public PEAccountCreationHandler(PECreatAccountNode node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws SystemException, PEException {
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		PECreatAccountNode accntNode = (PECreatAccountNode) node;

		// TODO Auto-generated method stub

		String firstName = ds.getData("firstName");
		String lastName = ds.getData("lastName");
		String emailAddress = StringUtil.toLowerCase(ds.getData("emailAddress"));
		
		if (Validator.isNull(lastName)){
			lastName = ".";
		}

		// if user is already member then no need to create account.

		PERequestData requestData = ds.getRequestData();
		if (ds.isSignedInUser()) {

			if (!ds.isAgentLoggedInUser() && !ds.isSupervisorLoggedInUser()) {
				_log.debug("Existing user. So account creation not required");
//				output.setNextNodeId(node.getNextNodeId());
				proceedToNextNode(output, node.getNextNodeId(), false);
				try {
					PEProcessStateHelper.updateProcessState(processState, requestData);
				} catch (PEProcessStateException e) {
					output.setError(e);
				}

				return output;
			} else {
				_log.debug("Agent is doing the regsistration.");
			}
		} else {
			_log.debug("Guest user want to register for process. email=" + emailAddress);
		}

		User user = null;
		try {

			// email adress must be read from FORM not from themedisplay because
			// registration also can be done by another user like agent

			user = UserLocalServiceUtil.getUserByEmailAddress(requestData.getCompanyId(), emailAddress);
		} catch (NoSuchUserException ex) {
			_log.error("User does not exist with emailAddress=" + emailAddress);
		} catch (Exception e) {
			_log.error(e);
			output.setError(e);
			return output;
		}

		// either agent or guest can come till this point
		if (user != null) {
			_log.error(
					"User exists with emailAddress=" + emailAddress + ". No need to create. Just proceed to next step");
			// output.addValidationMsg("Account exists with email address you
			// entered. Please login to register.");
			// output.setError(PEErrors.USER_EXITS_EMAIL_ADDRESS);
			// processState.set
			// output.setNextNodeId(node.getNextNodeId());
			// return output;
		}
		boolean isNewUser = false;
		if (user == null) {
			
			if(Validator.isNull(firstName) || Validator.isNull(lastName) || Validator.isNull(emailAddress)){
				_log.error("Error while creating account.One or more values blank First Name=" + firstName + " Last Name=" + lastName
						+ "emailAddress=" + emailAddress);
				throw new PEException(PEErrors.ACCOUNT_CREATION_ERROR);
			}
			
			String password = StringPool.BLANK;
			

			password = ds.getData("defaultPassword");
			
			if (Validator.isNull(password)) {
				password = "jkA04hcL9^";
			} else {
				password = PwdGenerator.getPassword(6);
			}
			
			try {
				new ServiceContextFactory();
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setCompanyId(requestData.getCompanyId());
				serviceContext.setCreateDate(DateUtil.newDate());
				serviceContext.setScopeGroupId(requestData.getScopeGroupId());
				user = UserServiceUtil.addUser(requestData.getCompanyId(), false, // auto

						// password

						password, password, true, // auto

						// screen name

						StringPool.BLANK, // screen name
						emailAddress, new Long(0), // facebookId
						StringPool.BLANK, // open id
						LocaleUtil.getDefault(), firstName, StringPool.BLANK, // middle

						// name

						lastName, 0, // prefix id
						0, // suffix id
						true, 1, 1, 1970, // birthdate
						StringPool.BLANK, // job title
						null, // group ids
						null, // organization ids
						null, // role ids
						null, // usegroup ids
						false, // send email
						serviceContext);
				isNewUser = true;
				user.setStatus(accntNode.getAccountStatusId());
				user.setEmailAddressVerified(GetterUtil.getBoolean(String.valueOf(accntNode.getEmailAddressVerifiedId())));

				// need to update the password to acutal one since the User api
				// stores the password in encrypted format

				user.setPassword(password);
				user.setPasswordEncrypted(false);
				//user.setEmailAddressVerified(true);
				user.setPasswordReset(true);
				UserLocalServiceUtil.updateUser(user);

				_log.debug("User has been created: " + user);
				// ds.setUser(user);
				processState.setUserIdProcess(user.getUserId());
				
				try {
					SPAuthenticationUtil.addSiteMembership(ds.getRequestData().getPortletRequest(), user);
					// add user site setup
					long subProductTypeId = ds.getProcess().getSubProductTypeId();
					SPAuthenticationUtil.addOrUpdateSPSiteUser(String.valueOf(subProductTypeId), ds.getRequestData().getPortletRequest(), user.getUserId(), user.getPassword());					
				} catch (Exception e) {
					_log.debug("Unable to setup SP Auth.", e);
				}

				if (ds.isSignedInUser()) {
					// logged in user is creating the account. Agent/supervisor
					// has the ability to register the user on behalf of him.In
					// this case agent is the creator
					processState.setUserIdCreator(requestData.getUserId());
				} else {
					// New user (Guest), who registering for himself
					processState.setUserIdCreator(user.getUserId());
				}

				if(!ds.isSuppressMailNotifications() &&  ds.getProcess().isAccountCreationEmailEnabled()){
					_log.debug("Notifiy the user about account creation by mail");
					sendAccountCreatinMail(user, ds);
				}else{
					_log.debug("Skipping account creation notification");
				}
			} catch (UserEmailAddressException ex) {
				_log.error("Error while creating account. First Name=" + firstName + " Last Name=" + lastName
						+ "emailAddress=" + emailAddress);
				output.setError(PEErrors.format(PEErrors.ACCOUNT_CREATION_EMAIL_ERROR_ARGS, emailAddress));
			} catch (PortalException | SystemException e) {
				_log.error("Error while creating account. First Name=" + firstName + " Last Name=" + lastName
						+ "emailAddress=" + emailAddress, e);
				output.setError(PEErrors.ACCOUNT_CREATION_ERROR);
			} catch (PEException e) {
				_log.error(e);
				output.setError(e);
			}
		}

		// this point user object must be exist until unless there is some
		// exception

		if (user != null) {

			// to support update of firstname and lastname.
			// Either logged in agent or guest ( but existing user) can modify
			// firstname, lastname
//			boolean updateUser = false;
//			if (Validator.isNotNull(firstName)) {
//				if (!firstName.equals(user.getFirstName())) {
//					user.setFirstName(firstName);
//					updateUser = true;
//				}
//			}
//			if (Validator.isNotNull(lastName)) {
//				if (!lastName.equals(user.getLastName())) {
//					user.setLastName(lastName);
//					updateUser = true;
//				}
//			}
//			if (updateUser) {
//				Date now = new Date();
//				user.setModifiedDate(now);
//				UserLocalServiceUtil.updateUser(user);
//			}

			// TODO: call to form builder using emailaddress and update userId
//			output.setNextNodeId(node.getNextNodeId());
			proceedToNextNode(output, node.getNextNodeId(), false);

			// processstate must be updated with userId of newly created user.
			// ProcessEngineImpl just creates ProcessState filled with
			// classNameId/classPk/ProcessId. userId must be updated here.
			processState.setUserIdProcess(user.getUserId());
			PEProcessStateHelper.updateProcessState(processState, requestData);

			_log.debug("Process state created for the user" + processState);
			PEAuditHelper auditHelper = ds.getAuditHelper();
			_log.debug(" Let's update all pending audits");
			auditHelper.updatePendingAudits();
			_log.debug("Pending audits are commited to database");

			if (isNewUser) {
				// audit the user creation
				try {
					auditHelper.logAccountCreation(node.getNodeId());
					_log.debug("Account creation audit is done");
				} catch (Exception ex) {
					// output.setError(PEErrors.AUDIT_ACCOUNT);
					_log.error("Error while auditing account creation", ex);
				}
			}
		}

		return output;
	}

	private void sendAccountCreatinMail(User createdUser, PEDataSource ds) throws PEException, SystemException {
		try {
			PECreatAccountNode accntNode = (PECreatAccountNode) node;
			_log.debug("Preparing mail data");
			SPMailTemplate mailTemplate = null;
			try {
				mailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(accntNode.getMailTemplateId());
			} catch (PortalException e) {
				_log.error("Error while fetching mail template ", e);
				throw new PEException(
						PEErrors.format(PEErrors.NOT_FOUND_MAIL_TEMPLATE_ARGS, accntNode.getMailTemplateId()));
			}

			if (Validator.isNotNull(mailTemplate) && Validator.isNotNull(mailTemplate.getSubject())
					&& Validator.isNotNull(mailTemplate.getHtmlContent())) {

				String fromName = SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate);
				String fromAddress = SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate);

				MailMessage mailMessage = new MailMessage();
				mailMessage.setFromAddress(fromAddress);
				mailMessage.setFromName(fromName);

				String subjectFormat = mailTemplate.getSubject();
				String contentFormat = mailTemplate.getHtmlContent();

				String subject = replaceTokens(ds, createdUser, subjectFormat, fromName);
				String content = replaceTokens(ds, createdUser, contentFormat, fromName);

				mailMessage.setSubject(subject);
				mailMessage.setHtmlBody(content);
				mailMessage.setHtmlFormat(true);
				mailMessage.setToAddress(createdUser.getEmailAddress());

				_log.debug("AccountCreationEmailEnabled : " + ds.getProcess().isAccountCreationEmailEnabled() + " : "
						+ mailMessage);
				if (ds.getProcess().isAccountCreationEmailEnabled()) {
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}
			} else {
				SambaashUtil.notifySystemAdmin(
						ds.getProcess().getSpPEProcessId() + " : Email Configuration not valid in process setup",
						"Either subject or content is null in process email setup.");
			}

		} catch (Exception e) {
			_log.error("Error while sending mail", e);
		}
	}

	private String replaceTokens(PEDataSource ds, User user, String format, String fromName) {
		PEUrlHelper urlHelper = PEUrlHelper.getUrlHelper(ds);// ds.getUrlHelper();
		String url = urlHelper.getUrlProcessStateListingUser();
		String result =  StringUtil.replace(format,
				new String[] { "[$USER_FULL_NAME$]", "[$FIRST_NAME$]", "[$EMAIL$]", "[$PASSWORD$]", "[$LOGIN_URL$]",
						"[$FROM$]" },
				new String[] { user.getFullName(), user.getFirstName(), user.getEmailAddress(), user.getPassword(), url,
						fromName });
		
		return PEMailHelper.findAndReplaceProcessData(result, ds);
	}
}