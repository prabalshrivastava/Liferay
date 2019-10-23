package com.sambaash.platform.pe.helpers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * 
 * This class is used to send mail to officer roles or actual user who is the
 * candidate of the process.
 * 
 * @author nareshchebolu
 *
 */
public class PEMailHelper {

	public static int URL_TYPE_NONE = 0;

	public static int URL_TYPE_OFFICER = 1;

	public static int URL_TYPE_USER = 2;

	public static int URL_TYPE_USER_OFFICER = 3;

	public static PEMailHelper getMailHelper(PEDataSource ds, long nodeId) throws SystemException {
		return new PEMailHelper(ds, nodeId);
	}

	private long nodeId;

	// nodeId is for logging purpose
	private PEMailHelper(PEDataSource ds, long nodeId) throws SystemException {
		this.ds = ds;
		this.nodeId = nodeId;
	}

	public MailMessage sendMailtoUser(String subjectFormat, String contentFormat, String ccEmailAddress,
			String fromName, String fromAddress) {
		String subject = replaceTokensForUser(subjectFormat, fromName, fromAddress);
		String content = replaceTokensForUser(contentFormat, fromName, fromAddress);

		return sendMail(subject, content, ds.getApplicant().getEmailAddress(), ccEmailAddress, fromName, fromAddress);
	}

	public MailMessage sendMailtoOfficer(User officer, String subjectFormat, String contentFormat, String fromName,
			String fromAddress) {
		String subject = replaceTokensForOfficer(officer, subjectFormat, fromName, fromAddress);
		String content = replaceTokensForOfficer(officer, contentFormat, fromName, fromAddress);

		return sendMail(subject, content, officer.getEmailAddress(), null, fromName, fromAddress);
	}

	public MailMessage sendMailtoSalesAgent(User agent, String subjectFormat, String contentFormat, String fromName,
			String fromAddress) {
		String subject = replaceTokensForSalesAgent(agent, subjectFormat, fromName, fromAddress);
		String content = replaceTokensForSalesAgent(agent, contentFormat, fromName, fromAddress);

		return sendMail(subject, content, agent.getEmailAddress(), null, fromName, fromAddress);
	}

	public MailMessage sendMailtoSupervisor(User supervisor, String subjectFormat, String contentFormat,
			String fromName, String fromAddress) {
		String subject = replaceTokensForSupervisor(supervisor, subjectFormat, fromName, fromAddress);
		String content = replaceTokensForSupervisor(supervisor, contentFormat, fromName, fromAddress);

		return sendMail(subject, content, supervisor.getEmailAddress(), null, fromName, fromAddress);
	}

	public MailMessage sendMailGeneric(User user, String subjectFormat, String contentFormat, String fromName,
			String fromAddress) {
		_log.error("sendMailGeneric triggered");
		String subject = replaceTokensGeneric(user, subjectFormat, fromName, fromAddress);
		String content = replaceTokensGeneric(user, contentFormat, fromName, fromAddress);

		return sendMail(subject, content, user.getEmailAddress(), null, fromName, fromAddress);
	}

	public String replaceTokensForOfficer(User officer, String format, String fromName, String fromAddress) {

		String userFullName = ds.getApplicant().getFullName();
		String officerFirstName = officer.getFullName();
		String processName = ds.getProcessName();
		PEProcessState processState = ds.getProcessState();
		String entityName = ds.getEntityName();
		long processStateId = processState.getSpPEProcessStateId();
		String entityNameWithoutCountry = ds.getPeEntity().getDesc();

		PEUrlHelper urlHelper = PEUrlHelper.getUrlHelper(ds);

		String result = StringUtil.replace(format,
				new String[] { "[$OFFICER_FULL_NAME$]", "[$PROCESS_NAME$]", "[$ENTITY_NAME$]", "[$USER_FULL_NAME$]",
						"[$PROCESS_STATE_ID$]", "[$FROM$]", "[$PROCESS_STATE_URL_VIEW_OFFICER$]",
						"[$PROCESS_STATE_URL_VIEW_SUPERVISOR$]", "[$ENTITY_NAME_WITHOUT_COUNTRY$]" },
				new String[] { officerFirstName, processName, entityName, userFullName, String.valueOf(processStateId),
						fromName, urlHelper.getUrlDisplayProcessStateOfficer(),
						urlHelper.getUrlDisplayProcessStateSupervisor(), entityNameWithoutCountry });

		return findAndReplaceProcessData(result);
	}

	public String replaceTokensForUser(String format, String fromName, String fromAddress) {
		String userFullName = ds.getApplicant().getFullName();
		String urlUser = PEUrlHelper.getUrlHelper(ds).getUrlDisplayProcessStateUser();
		String processName = ds.getProcessName();
		String entityNameWithoutCountry = ds.getPeEntity().getDesc();
		PEProcessState processState = ds.getProcessState();
		String entityName = ds.getEntityName();

		try {
			String careerContent = PECareerSupportMailHelper.searchByDomain(ds, format);
			if (Validator.isNotNull(careerContent)) {
				format = careerContent;
			}

		} catch (Exception e) {
			_log.debug("Skipping the matching " + e.getMessage());
		}

		long processStateId = processState.getSpPEProcessStateId();
		String result = StringUtil.replace(format,
				new String[] { "[$PROCESS_NAME$]", "[$ENTITY_NAME$]", "[$USER_FULL_NAME$]", "[$PROCESS_STATE_ID$]",
						"[$FROM$]", "[$PROCESS_STATE_URL_VIEW_USER$]", "[$ENTITY_NAME_WITHOUT_COUNTRY$]",
						"[$FIRST_NAME$]", "[$EMAIL$]", "[$PASSWORD$]" },
				new String[] { processName, entityName, userFullName, String.valueOf(processStateId), fromName, urlUser,
						entityNameWithoutCountry, ds.getApplicant().getFirstName(), ds.getApplicant().getEmailAddress(),
						ds.getApplicant().getPassword() });

		return findAndReplaceProcessData(result);
	}

	public String replaceTokensForSalesAgent(User agent, String format, String fromName, String fromAddress) {
		String agentFullName = agent.getFullName();
		String userFullName = ds.getApplicant().getFullName();
		String urlAgent = PEUrlHelper.getUrlHelper(ds).getUrlDisplayProcessStateAgent();
		String processName = ds.getProcessName();
		String entityNameWithoutCountry = ds.getPeEntity().getDesc();
		PEProcessState processState = ds.getProcessState();
		String entityName = ds.getEntityName();

		try {
			String careerContent = PECareerSupportMailHelper.searchByDomain(ds, format);
			if (Validator.isNotNull(careerContent)) {
				format = careerContent;
			}

		} catch (Exception e) {
			_log.debug("Skipping the matching " + e.getMessage());
		}

		long processStateId = processState.getSpPEProcessStateId();
		String result = StringUtil.replace(format,
				new String[] { "[$AGENT_FULL_NAME$]", "[$PROCESS_NAME$]", "[$ENTITY_NAME$]", "[$USER_FULL_NAME$]",
						"[$PROCESS_STATE_ID$]", "[$FROM$]", "[$PROCESS_STATE_URL_VIEW_AGENT$]",
						"[$ENTITY_NAME_WITHOUT_COUNTRY$]" },
				new String[] { agentFullName, processName, entityName, userFullName, String.valueOf(processStateId),
						fromName, urlAgent, entityNameWithoutCountry });
		return findAndReplaceProcessData(result);
	}

	public String replaceTokensForSupervisor(User supervisor, String format, String fromName, String fromAddress) {
		String supervisorFullName = supervisor.getFullName();
		String userFullName = ds.getApplicant().getFullName();
		String urlSupervisor = PEUrlHelper.getUrlHelper(ds).getUrlDisplayProcessStateSupervisor();
		String processName = ds.getProcessName();

		PEProcessState processState = ds.getProcessState();
		String entityName = ds.getEntityName();
		String entityNameWithoutCountry = ds.getPeEntity().getDesc();

		try {
			String careerContent = PECareerSupportMailHelper.searchByDomain(ds, format);
			if (Validator.isNotNull(careerContent)) {
				format = careerContent;
			}

		} catch (Exception e) {
			_log.debug("Skipping the matching " + e.getMessage());
		}

		long processStateId = processState.getSpPEProcessStateId();
		String result = StringUtil.replace(format,
				new String[] { "[$SUPERVISOR_FULL_NAME$]", "[$PROCESS_NAME$]", "[$ENTITY_NAME$]", "[$USER_FULL_NAME$]",
						"[$PROCESS_STATE_ID$]", "[$FROM$]", "[$PROCESS_STATE_URL_VIEW_SUPERVISOR$]",
						"[$ENTITY_NAME_WITHOUT_COUNTRY$]" },
				new String[] { supervisorFullName, processName, entityName, userFullName,
						String.valueOf(processStateId), fromName, urlSupervisor, entityNameWithoutCountry });
		return findAndReplaceProcessData(result);
	}

	private String findAndReplaceProcessData(String htmlString) {
		return findAndReplaceProcessData(htmlString, ds);
	}

	public static String findAndReplaceProcessData(String htmlString, PEDataSource ds) {
		return ds.nestedReplaceToken(htmlString);
	}

	public String replaceTokensGeneric(User user, String format, String fromName, String fromAddress) {
		String userFullName = user.getFullName();
		String urlUser = PEUrlHelper.getUrlHelper(ds).getUrlDisplayProcessStateUser();
		String processName = ds.getProcessName();
		String entityNameWithoutCountry = ds.getPeEntity().getDesc();
		PEProcessState processState = ds.getProcessState();
		String entityName = ds.getEntityName();

		long processStateId = processState.getSpPEProcessStateId();
		String result = StringUtil.replace(format,
				new String[] { "[$PROCESS_NAME$]", "[$ENTITY_NAME$]", "[$USER_FULL_NAME$]", "[$PROCESS_STATE_ID$]",
						"[$FROM$]", "[$PROCESS_STATE_URL_VIEW_USER$]", "[$ENTITY_NAME_WITHOUT_COUNTRY$]",
						"[$FIRST_NAME$]", "[$EMAIL$]" },
				new String[] { processName, entityName, userFullName, String.valueOf(processStateId), fromName, urlUser,
						entityNameWithoutCountry, user.getFirstName(), user.getEmailAddress() });

		return findAndReplaceProcessData(result);
	}

	public MailMessage sendMail(String subject, String content, String toAddress, String ccAddress, String fromName,
			String fromAddress) {
		_log.debug("Preparing mail for email: " + toAddress);
		MailMessage mailMessage = new MailMessage();

		mailMessage.setFromAddress(fromAddress);
		mailMessage.setFromName(fromName);
		mailMessage.setSubject(subject);
		mailMessage.setHtmlBody(content);
		mailMessage.setHtmlFormat(true);
		mailMessage.setToAddress(toAddress);

		if (Validator.isNotNull(ccAddress)) {
			mailMessage.setCcAddress(ccAddress);
		}

		_log.debug("mail content " + mailMessage);

		SPMailLocalServiceUtil.sendMail(mailMessage);

		try {
			PEAuditHelper audit = PEAuditHelper.getAuditHelper(ds.getProcessState(), ds);
			audit.logMail(toAddress, mailMessage.toString(), nodeId);
			if (Validator.isNotNull(ccAddress)) {
				audit.logMail(ccAddress, mailMessage.toString(), nodeId);
			}
		} catch (Exception ex) {

			// TODO: we dont need to stop processing because if mail fails..
			// have to think alternate if mail sending fails output = new
			// PEProcessableNodeOutput();
			// output.setError(PEErrors.AUDIT_FORM);

			_log.error("Error while auditing mail", ex);
		}
		_log.debug("Mail has been sent");
		return mailMessage;
	}

	public void publishToTimeline(User user, String subjectFormat, String contentFormat, String actionLink,
			String status, String title, String fromName, String fromAddress) {
		_log.error("Publish to Timeline triggered");
		String subject = replaceTokensGeneric(user, subjectFormat, fromName, fromAddress);
		// String content = replaceTokensGeneric(user, contentFormat);
		SystemLocalServiceUtil.addTimelineActivity(actionLink, "View Details", title, subject, StringPool.BLANK, status,
				ds.getProcessState().getUserIdCreator(), ds.getProcess().getName(), title,
				String.valueOf(ds.getProcess().getSubProductTypeId()), StringPool.BLANK,
				String.valueOf(user.getUserId()), SambaashUtil.getScopeGroupId(ds.getProcess().getGroupId()));
	}

	private static Log _log = LogFactoryUtil.getLog(PEMailHelper.class);

	private PEDataSource ds;

}