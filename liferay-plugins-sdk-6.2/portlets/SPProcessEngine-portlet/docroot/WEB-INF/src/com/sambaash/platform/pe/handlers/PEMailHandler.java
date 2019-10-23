package com.sambaash.platform.pe.handlers;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.OrganizationHelper;
import com.sambaash.platform.pe.helpers.PEMailHelper;
import com.sambaash.platform.pe.jaxb.PEMail;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.mail.model.SPEMailAudit;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPEMailAuditLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PEMailHandler extends PESingleOutputNodeHandler {

	// Only used from passing of information from Scheduler call for information
	// not available in ProcessState/Process dataSource
	private JSONObject additionalData;

	public PEMailHandler(PEMail node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws SystemException {

		_log.debug("In mail handler nodeId = " + node.getNodeId());
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		PEMail mailNode = (PEMail) node;

		// checking if mail notifications needs to be suppressed
		if (ds.isSuppressMailNotifications()) {
			// output.setNextNodeId(node.getNextNodeId());
			proceedToNextNode(output, node.getNextNodeId(), false);
			return output;
		}

		// getting the mail tempalted
		SPMailTemplate mailTemplate = null;
		try {
			mailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(mailNode.getMailTemplateId());
		} catch (PortalException | SystemException e) {
			// output.setNextNodeId(node.getNextNodeId());
			proceedToNextNode(output, node.getNextNodeId(), false);
			// output.setError(PEErrors.format(PEErrors.NOT_FOUND_MAIL_TEMPLATE_ARGS,
			// mailNode.getMailTemplateId()));
			_log.error(
					String.format("Error while fetching mail template with id %s, nodeId %s, processId %s, error %s ",
							mailNode.getMailTemplateId(), node.getNodeId(), ds.getProcess().getSpPEProcessId(),
							e.getMessage()));
			return output;
		}

		String subjectFormat = mailTemplate.getSubject();
		String contentFormat = mailTemplate.getHtmlContent();

		// Get the mail helper. Here nodeId is required for logging purpose
		PEMailHelper mailHelper = PEMailHelper.getMailHelper(ds, mailNode.getNodeId());

		if (PEConstants.RECIPIENT_GLOBAL_APPROVERS.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for global approvers");
			String temp = ds.getProcess().getApproveRoleIds();
			if (Validator.isNotNull(temp)) {
				long[] roleIds = StringUtil.split(temp, StringPool.COMMA, 0l);// ArrayUtil.toLongArray(mailNode.getToRoleIds().split(StringPool.COMMA));
				_log.debug("Roles Ids to send mail : " + roleIds);
				for (long roleId : roleIds) {
					if (roleId > 0) {
						mailToOfficerRole(subjectFormat, contentFormat, roleId, mailHelper,
								SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
								SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
					}
				}
			}

		}
		if (PEConstants.RECIPIENT_OFFICER.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for officers");
			String temp = mailNode.getOfficerRoleIds();
			if (Validator.isNotNull(temp)) {
				long[] roleIds = StringUtil.split(temp, StringPool.COMMA, 0l);// ArrayUtil.toLongArray(mailNode.getToRoleIds().split(StringPool.COMMA));
				_log.debug("Roles Ids to send mail : " + roleIds);
				for (long roleId : roleIds) {
					if (roleId > 0) {
						mailToOfficerRole(subjectFormat, contentFormat, roleId, mailHelper,
								SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
								SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
					}
				}
			}

		} else if (PEConstants.RECIPIENT_USER.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for user in process");
			String ccEmailAddress = StringPool.BLANK;
			try {
				if (PEConstants.CC_ASSIGNED_SALES_AGENT.equalsIgnoreCase(mailNode.getCc())) {
					ccEmailAddress = UserLocalServiceUtil.getUser(ds.getProcessState().getUserIdAgent())
							.getEmailAddress();
				} else if (PEConstants.CC_ASSIGNED_SUPERVISOR.equalsIgnoreCase(mailNode.getCc())) {
					ccEmailAddress = UserLocalServiceUtil.getUser(ds.getProcessState().getUserIdSupervisor())
							.getEmailAddress();
				} else if (PEConstants.CC_EMAIL_ADDRESS.equalsIgnoreCase(mailNode.getCc())) {
					ccEmailAddress = mailNode.getCcEmailAddressText();
				}
				mailHelper.sendMailtoUser(subjectFormat, contentFormat, ccEmailAddress,
						SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
						SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		} else if (PEConstants.RECIPIENT_ASSIGNED_SALES_AGENT.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for sales agent in process");
			try {
				if (ds.getProcessState().getUserIdAgent() != 0) {
					User agent = UserLocalServiceUtil.getUser(ds.getProcessState().getUserIdAgent());
					mailHelper.sendMailtoSalesAgent(agent, subjectFormat, contentFormat,
							SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
							SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
				}
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		} else if (PEConstants.RECIPIENT_ASSIGNED_SUPERVISOR.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for supervisor in process");
			try {
				User supervisor = UserLocalServiceUtil.getUser(ds.getProcessState().getUserIdSupervisor());
				mailHelper.sendMailtoSupervisor(supervisor, subjectFormat, contentFormat,
						SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
						SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		} else if (PEConstants.RECIPIENT_SALES_AGENT_ROLE.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for officers");
			String temp = ds.getProcess().getAgentRoleIds();
			if (Validator.isNotNull(temp)) {
				long[] roleIds = StringUtil.split(temp, StringPool.COMMA, 0l);// ArrayUtil.toLongArray(mailNode.getToRoleIds().split(StringPool.COMMA));
				_log.debug("Roles Ids to send mail : " + roleIds);
				for (long roleId : roleIds) {
					if (roleId > 0) {
						mailToAgentRole(subjectFormat, contentFormat, roleId, mailHelper,
								SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
								SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
					}
				}
			}

		} else if (PEConstants.RECIPIENT_SUPERVISOR_ROLE.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.debug("mail node id " + mailNode.getNextNodeId() + ". This mail node is for officers");
			String temp = ds.getProcess().getSupervisorRoleIds();
			if (Validator.isNotNull(temp)) {
				long[] roleIds = StringUtil.split(temp, StringPool.COMMA, 0l);// ArrayUtil.toLongArray(mailNode.getToRoleIds().split(StringPool.COMMA));
				_log.debug("Roles Ids to send mail : " + roleIds);
				for (long roleId : roleIds) {
					if (roleId > 0) {
						mailToSupervisorRole(subjectFormat, contentFormat, roleId, mailHelper,
								SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
								SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
					}
				}
			}

		} else if (PEConstants.RECIPIENT_TRAINING_PRINCIPAL_ROLE.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.error("mail node id " + mailNode.getNextNodeId() + ". This mail node is for Training Principal");
			mailToTrainingPrincipal(subjectFormat, contentFormat, mailHelper, mailTemplate.getTemplateName(),
					SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
					SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));

		} else if (PEConstants.RECIPIENT_SECONDAY_CONTACT_ROLE.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.error("mail node id " + mailNode.getNextNodeId() + ". This mail node is for Secondary Contact");
			mailToSecondayContact(subjectFormat, contentFormat, mailHelper, mailTemplate.getTemplateName(),
					SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
					SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));

		} else if (PEConstants.RECIPIENT_MENTOR_ROLE.equalsIgnoreCase(mailNode.getRecipient())) {
			_log.error("mail node id " + mailNode.getNextNodeId() + ". This mail node is for Mentor");
			mailToMentors(subjectFormat, contentFormat, mailHelper, mailTemplate.getTemplateName(),
					SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
					SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
		}

		// output.setNextNodeId(node.getNextNodeId());
		proceedToNextNode(output, node.getNextNodeId(), false);
		return output;
	}

	private void mailToOfficerRole(String subjectFormat, String contentFormat, long roleId, PEMailHelper mailHelper,
			String fromName, String fromAddress) throws SystemException {
		_log.debug("Sending mail to officer roleId " + roleId);
		List<User> officers = UserLocalServiceUtil.getRoleUsers(roleId);
		// Send mail to each user
		for (User officer : officers) {
			mailHelper.sendMailtoOfficer(officer, subjectFormat, contentFormat, fromName, fromAddress);
		}
	}

	private void mailToAgentRole(String subjectFormat, String contentFormat, long roleId, PEMailHelper mailHelper,
			String fromName, String fromAddress) throws SystemException {
		_log.debug("Sending mail to agent roleId " + roleId);
		List<User> agents = UserLocalServiceUtil.getRoleUsers(roleId);
		// Send mail to each user
		for (User agent : agents) {
			mailHelper.sendMailtoSalesAgent(agent, subjectFormat, contentFormat, fromName, fromAddress);
		}
	}

	private void mailToSupervisorRole(String subjectFormat, String contentFormat, long roleId, PEMailHelper mailHelper,
			String fromName, String fromAddress) throws SystemException {
		_log.debug("Sending mail to supervisor roleId " + roleId);
		List<User> supervisors = UserLocalServiceUtil.getRoleUsers(roleId);
		// Send mail to each user
		for (User supervisor : supervisors) {
			mailHelper.sendMailtoSupervisor(supervisor, subjectFormat, contentFormat, fromName, fromAddress);
		}
	}

	private void mailToMentors(String subjectFormat, String contentFormat, PEMailHelper mailHelper, String templateName,
			String fromName, String fromAddress) throws SystemException {
		List<User> mentors = OrganizationHelper.getMentors(additionalData, ds);
		for (User mentor : mentors) {
			mailHelper.sendMailGeneric(mentor, subjectFormat, contentFormat, fromName, fromAddress);
			publishTimelineActivity(mentor, subjectFormat, contentFormat, mailHelper, fromName, fromAddress);
			addSPMailAudit(mentor, templateName, subjectFormat, contentFormat, mailHelper, fromName, fromAddress);
		}
	}

	private void mailToTrainingPrincipal(String subjectFormat, String contentFormat, PEMailHelper mailHelper,
			String templateName, String fromName, String fromAddress) throws SystemException {
		User trainingPrincipal = OrganizationHelper.getTrainingPrincipal(additionalData, ds);
		mailHelper.sendMailGeneric(trainingPrincipal, subjectFormat, contentFormat, fromName, fromAddress);
		publishTimelineActivity(trainingPrincipal, subjectFormat, contentFormat, mailHelper, fromName, fromAddress);
		addSPMailAudit(trainingPrincipal, templateName, subjectFormat, contentFormat, mailHelper, fromName,
				fromAddress);
	}

	private void mailToSecondayContact(String subjectFormat, String contentFormat, PEMailHelper mailHelper,
			String templateName, String fromName, String fromAddress) throws SystemException {
		User secondaryContact = OrganizationHelper.getSecondaryContact(additionalData, ds);
		mailHelper.sendMailGeneric(secondaryContact, subjectFormat, contentFormat, fromName, fromAddress);
		publishTimelineActivity(secondaryContact, subjectFormat, contentFormat, mailHelper, fromName, fromAddress);
		addSPMailAudit(secondaryContact, templateName, subjectFormat, contentFormat, mailHelper, fromName, fromAddress);
	}

	public void setAdditionalData(JSONObject additionalData) {
		this.additionalData = additionalData;
	}

	private void publishTimelineActivity(User user, String subjectFormat, String contentFormat, PEMailHelper mailHelper,
			String fromName, String fromAddress) {
		if (Validator.isNotNull(additionalData) && additionalData.has(PEConstants.ACTIVITY)) {
			mailHelper.publishToTimeline(user, subjectFormat, contentFormat,
					additionalData.getString(PEConstants.RENEWAL_URL),
					additionalData.getString(PEConstants.RENEWAL_STATUS), additionalData.getString(PEConstants.TITLE),
					fromName, fromAddress);
		}
	}

	private void addSPMailAudit(User user, String templateName, String subjectFormat, String contentFormat,
			PEMailHelper mailHelper, String fromName, String fromAddress) {
		try {
			SPEMailAudit spEMailAudit = SPEMailAuditLocalServiceUtil
					.createSPEMailAudit(CounterLocalServiceUtil.increment(SPEMailAudit.class.getName()));
			spEMailAudit.setCategory(templateName);
			if (Validator.isNotNull(additionalData) && additionalData.has(PEConstants.ORGANIZATION_ID)) {
				spEMailAudit.setOrgId(Long.parseLong(additionalData.getString(PEConstants.ORGANIZATION_ID)));
			}
			spEMailAudit.setSentTo(user.getEmailAddress());
			spEMailAudit.setSentDate(DateUtil.newDate());
			spEMailAudit.setSubject(mailHelper.replaceTokensGeneric(user, subjectFormat, fromName, fromAddress));
			spEMailAudit.setContent(mailHelper.replaceTokensGeneric(user, contentFormat, fromName, fromAddress));
			spEMailAudit.setGroupId(ds.getProcessState().getGroupId());
			spEMailAudit.setCompanyId(ds.getCompanyId());
			spEMailAudit.setNodeId(node.getNodeId());
			spEMailAudit.setProcessStateId(ds.getProcessState().getSpPEProcessStateId());
			SPEMailAuditLocalServiceUtil.addSPEMailAudit(spEMailAudit);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PEMailHandler.class);

}