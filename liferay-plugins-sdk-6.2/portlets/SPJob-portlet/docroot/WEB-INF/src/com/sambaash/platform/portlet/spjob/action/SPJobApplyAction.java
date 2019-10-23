package com.sambaash.platform.portlet.spjob.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.portlet.spjob.permissions.JobPermissionsUtil;
import com.sambaash.platform.portlet.spjob.util.SPJobConstants;
import com.sambaash.platform.portlet.spjob.util.SPJobUtil;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;
import com.sambaash.platform.srv.mail.NoSuchTemplateException;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spjob.NoSuchSPJobException;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.model.SPJobApplicants;
import com.sambaash.platform.srv.spjob.service.SPJobApplicantsLocalServiceUtil;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
//import com.sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPJobApplyAction
 */
public class SPJobApplyAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);

		try {
			boolean applyServiceHasAccess = false;
			PortletPreferences preferences = renderRequest.getPreferences();
			/* SPParameter applyServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), SPJobConstants.JOBS.APPLY_JOB_SERVICE);
			applyServiceStrutsAction = applyServiceParameter.getValue();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("struts_action", applyServiceStrutsAction);
			parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));

			Map<String, Object> applyServiceHasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(parameterMap,
					themeDisplay.getUser());
			applyServiceHasAccess = (Boolean)applyServiceHasAccessMap
					.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
			applyServiceUserStatus = (String)applyServiceHasAccessMap
					.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);
			
			renderRequest.setAttribute("applyServiceUserStatus", applyServiceUserStatus);*/
			
			String applyServiceUserStatus = "You do not have the required permission to access this service.";
			String signUpUrl = PortalUtil.getCreateAccountURL(request, themeDisplay);
			if(!themeDisplay.isSignedIn()){
				applyServiceUserStatus="Please <a href='/signin'>Login</a> to post a job.<br/> Not a Member?<a href="  + signUpUrl + "Join Us";
			}

			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || JobPermissionsUtil.hasJobApplyPermission(themeDisplay,StringPool.BLANK)) {
				renderRequest.setAttribute("applyServiceHasAccess", true);
			}else{
				renderRequest.setAttribute("applyServiceHasAccess", false);
				renderRequest.setAttribute("applyServiceUserStatus", applyServiceUserStatus);
			}

			String spJobDetailPageName = preferences.getValue("spJobDetailPageName", StringPool.BLANK);
			renderRequest.setAttribute("spJobDetailPageName", spJobDetailPageName);

			String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
			renderRequest.setAttribute("communityName", communityName);

			HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(request);
			String jobIdStr = originalServletRequest.getParameter("id");
			boolean jobNotFound = false;
			long jobId = 0;
			try {
				jobId = Long.valueOf(jobIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			try {
				SPJob spJob = SPJobLocalServiceUtil.getSPJob(jobId);
				String jobStatus = spJob.getStatus();
				_log.error("job status " + jobStatus + " id  " + jobId);
				if(!"Closed".equalsIgnoreCase(jobStatus)){
				renderRequest.setAttribute("spJob", spJob);
				}else{
					jobNotFound = true;
					renderRequest.setAttribute("jobNotFound", jobNotFound);
				}
			} catch (NoSuchSPJobException nsje) {
				jobNotFound = true;
				renderRequest.setAttribute("jobNotFound", jobNotFound);

			}

			String step = originalServletRequest.getParameter("step");
			renderRequest.setAttribute("step", step);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = actionRequest.getPreferences();

		String action = ParamUtil.getString(actionRequest, "action");

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			try {
				String spJobDetailPageName = ParamUtil.getString(actionRequest, "spJobDetailPageName");
				String spJobAppNotiTemplateIdForPoster = ParamUtil.getString(actionRequest,
						"spJobAppNotiTemplateIdForPoster");
				String spJobAppNotiTemplateIdForApplicant = ParamUtil.getString(actionRequest,
						"spJobAppNotiTemplateIdForApplicant");

				preferences.setValue("spJobDetailPageName", spJobDetailPageName);
				preferences.setValue("spJobAppNotiTemplateIdForPoster", spJobAppNotiTemplateIdForPoster);
				preferences.setValue("spJobAppNotiTemplateIdForApplicant", spJobAppNotiTemplateIdForApplicant);

				preferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

		} else if ("applySPJob".equalsIgnoreCase(action)) {
			try {
				String portalUrl = PortalUtil.getPortalURL(actionRequest);
				boolean attachments = ParamUtil.getBoolean(actionRequest, "attachments", true);

				long spJobId = 0L;
				String firstName = StringPool.BLANK;
				String lastName = StringPool.BLANK;
				String emailAddress = StringPool.BLANK;
				String contactNumber = StringPool.BLANK;
				String coverLetter = StringPool.BLANK;
				String jobTitle = StringPool.BLANK;

				long documentId = 0L;
				String resumeUrl = StringPool.BLANK;

				ServiceContext serviceContext = null;

				if (attachments) {
					UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
					serviceContext = ServiceContextFactory.getInstance(uploadPortletRequest);

					spJobId = ParamUtil.getLong(uploadPortletRequest, "jobId");
					firstName = ParamUtil.getString(uploadPortletRequest, "firstName");
					lastName = ParamUtil.getString(uploadPortletRequest, "lastName");
					emailAddress = ParamUtil.getString(uploadPortletRequest, "emailAddress");
					contactNumber = ParamUtil.getString(uploadPortletRequest, "contactNumber");
					coverLetter = ParamUtil.getString(uploadPortletRequest, "coverLetter");
					jobTitle = ParamUtil.getString(uploadPortletRequest, "jobTitle");

					File file = uploadPortletRequest.getFile("fileName");

					if (file != null) {
						documentId = SPJobUtil.saveDocument(DEFAULT_JOB_RESUME_FOLDER_NAME, themeDisplay.getUserId(),
								themeDisplay.getCompanyId(), file, themeDisplay.getScopeGroupId());
						String uuId = SPJobUtil.getPictureFileUuid(documentId);
						resumeUrl = portalUrl + "/../documents/" + themeDisplay.getScopeGroupId() + "/" + uuId;
					}
				} else {
					serviceContext = ServiceContextFactory.getInstance(SPJobApplicants.class.getName(), actionRequest);
					spJobId = ParamUtil.getLong(actionRequest, "jobId");
					firstName = ParamUtil.getString(actionRequest, "firstName");
					lastName = ParamUtil.getString(actionRequest, "lastName");
					emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
					contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
					coverLetter = ParamUtil.getString(actionRequest, "coverLetter");
					jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
				}

				SPJobApplicantsLocalServiceUtil.addSPJobApplicants(themeDisplay.getUserId(), spJobId, firstName,
						lastName, emailAddress, contactNumber, coverLetter, documentId, serviceContext);

				try {
					SPJob spJob = SPJobLocalServiceUtil.getSPJob(spJobId);
					long createByUserId = spJob.getUserId();
					try {
						User createBy = UserLocalServiceUtil.getUser(createByUserId);

						// send application

						Map<String, Object> paramsMap = new HashMap<String, Object>();

						String applicantProfileUrl = portalUrl + "/" + themeDisplay.getUser().getScreenName();
						String applicantName = firstName + " " + lastName;
						String spJobDetailPageName = preferences.getValue("spJobDetailPageName", "job-detail");
						String jobDetailUrl = portalUrl + "/" + spJobDetailPageName + "?id=" + spJobId;

						paramsMap.put("applicantProfileUrl", applicantProfileUrl);
						paramsMap.put("applicantName", applicantName);
						paramsMap.put("posterName", createBy.getFullName());
						paramsMap.put("jobDetailUrl", jobDetailUrl);
						paramsMap.put("jobId", String.valueOf(spJobId));
						paramsMap.put("jobTitle", jobTitle);
						paramsMap.put("senderId", String.valueOf(themeDisplay.getUserId()));
						paramsMap.put("resumeUrl", resumeUrl);
						paramsMap.put("jobLocation", spJob.getJobLocation());
						paramsMap.put("companyName", spJob.getCorporateName());
						paramsMap.put("applicantEmail", emailAddress);
						paramsMap.put("applicantContactNo", contactNumber);
						paramsMap.put("coverLetter", coverLetter);

						// String[] spJobApplicationTitleAndBody =
						// getSPJobApplicationTitleAndBody(paramsMap);

						// for applicant

						String spJobAppNotiTemplateIdForApplicant = preferences.getValue(
								"spJobAppNotiTemplateIdForApplicant", "0");
						try {
							long spJobAppNotiTemplateIdLForApplicant = 0;
							try {
								spJobAppNotiTemplateIdLForApplicant = Long.valueOf(spJobAppNotiTemplateIdForApplicant);
							} catch (NumberFormatException nfe) {

								// do nothing

							}

							if (spJobAppNotiTemplateIdLForApplicant > 0) {
								SPMailTemplate spMailTemplateForApplicant = SPMailTemplateLocalServiceUtil
										.getSPMailTemplate(spJobAppNotiTemplateIdLForApplicant);
								String subjectForApplicant = spMailTemplateForApplicant.getSubject();
								String htmlContentForApplicant = spMailTemplateForApplicant.getHtmlContent();

								String[] spJobAppNotiTemplateIdForApplicantTitleAndBody = this
										.getSPJobAppNotiTemplateIdForApplicantTitleAndBody(subjectForApplicant,
												htmlContentForApplicant, paramsMap);

								sendExternalEmail(themeDisplay.getCompanyId(),
											spJobAppNotiTemplateIdForApplicantTitleAndBody[0],
											spJobAppNotiTemplateIdForApplicantTitleAndBody[1], themeDisplay.getUser()
											.getFullName(), themeDisplay.getUser().getEmailAddress(), paramsMap);

								// inbox

								String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
										PropsKeys.ADMIN_EMAIL_FROM_NAME);
								String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
										PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

								IBMessage ibmessage = addIBMessage(themeDisplay.getScopeGroupId(),
										themeDisplay.getCompanyId(), fromName, 0, fromAddress,
										themeDisplay.getUser().getEmailAddress(),
										spJobAppNotiTemplateIdForApplicantTitleAndBody[0],
										spJobAppNotiTemplateIdForApplicantTitleAndBody[1]);

								addIBMessageDetail(themeDisplay.getCompanyId(), ibmessage, themeDisplay.getUser()
										.getUserId(), themeDisplay.getUser().getFullName(), "", "message");
							}
						} catch (NoSuchTemplateException e) {
							_log.error(e.getMessage(), e);
						}

						// for poster

						String spJobAppNotiTemplateIdForPoster = preferences.getValue(
								"spJobAppNotiTemplateIdForPoster", "0");
						try {
							long spJobAppNotiTemplateIdLForPoster = 0;
							try {
								spJobAppNotiTemplateIdLForPoster = Long.valueOf(spJobAppNotiTemplateIdForPoster);
							} catch (NumberFormatException nfe) {

								// do nothing

							}

							if (spJobAppNotiTemplateIdLForPoster > 0) {
								SPMailTemplate spMailTemplateForPoster = SPMailTemplateLocalServiceUtil
										.getSPMailTemplate(spJobAppNotiTemplateIdLForPoster);

								String subjectForPoster = spMailTemplateForPoster.getSubject();
								String htmlContentForPoster = spMailTemplateForPoster.getHtmlContent();

								String[] spJobAppNotiTemplateIdForPosterTitleAndBody = this
										.getSPJobAppNotiTemplateIdForPosterTitleAndBody(subjectForPoster,
												htmlContentForPoster, paramsMap);

								// external

								/* If "Notefication To field is availble, then mail must be sent to mail Id's provided in it */
								boolean enableNotef = SPJobUtil.enableNoteficationTo();

								if (enableNotef) {
									String notefTo = spJob.getNotefto();

									if (Validator.isNotNull(notefTo)) {
										String mailIds[] = notefTo.split(StringPool.SEMICOLON);

										for (String mailId : mailIds) {

											try {
												User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), mailId);

												if (Validator.isNotNull(user)) {
													sendExternalEmail(themeDisplay.getCompanyId(),
															spJobAppNotiTemplateIdForPosterTitleAndBody[0],
															spJobAppNotiTemplateIdForPosterTitleAndBody[1], user.getFullName(),
															user.getEmailAddress(), paramsMap);

												}
											} catch (NoSuchUserException e) {
												_log.error("User not found with mail id" + mailId);
											}
										}
									}
								}else {

									// "Notification To" not available so mail must be send to job creator

									sendExternalEmail(themeDisplay.getCompanyId(),
											spJobAppNotiTemplateIdForPosterTitleAndBody[0],
											spJobAppNotiTemplateIdForPosterTitleAndBody[1], createBy.getFullName(),
											createBy.getEmailAddress(), paramsMap);

								}

								// inbox

								String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
										PropsKeys.ADMIN_EMAIL_FROM_NAME);
								String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
										PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

								IBMessage ibmessageForPoster = addIBMessage(themeDisplay.getScopeGroupId(),
										themeDisplay.getCompanyId(), fromName, 0, fromAddress,
										createBy.getEmailAddress(), spJobAppNotiTemplateIdForPosterTitleAndBody[0],
										spJobAppNotiTemplateIdForPosterTitleAndBody[1]);

								addIBMessageDetail(themeDisplay.getCompanyId(), ibmessageForPoster,
										createBy.getUserId(), createBy.getFullName(), "", "message");
							}
						} catch (NoSuchTemplateException e) {
							_log.error(e.getMessage(), e);
						}

						String currentUrl = PortalUtil.getCurrentURL(actionRequest);
						actionResponse.sendRedirect(currentUrl.substring(0, currentUrl.indexOf("?")) + "?id=" +
								spJob.getSpJobId() + "&step=success");

					} catch (NoSuchUserException nsue) {

						// do nothing

					}

				} catch (NoSuchSPJobException nsje) {

					// do nothing

				}

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}

	private String[] getSPJobAppNotiTemplateIdForPosterTitleAndBody(String subject, String body,
			Map<String, Object> paramsMap) {

		String applicantProfileUrl = (String) paramsMap.get("applicantProfileUrl");
		String applicantName = (String) paramsMap.get("applicantName");
		String posterName = (String) paramsMap.get("posterName");
		String jobDetailUrl = (String) paramsMap.get("jobDetailUrl");
		String jobId = (String) paramsMap.get("jobId");
		String jobTitle = (String) paramsMap.get("jobTitle");
		String resumeUrl = (String) paramsMap.get("resumeUrl");
		String jobLocation = (String) paramsMap.get("jobLocation");
		String companyName = (String) paramsMap.get("companyName");
		String applicantEmail = (String) paramsMap.get("applicantEmail");
		String applicantContactNo = (String) paramsMap.get("applicantContactNo");
		String coverLetter = (String) paramsMap.get("coverLetter");

		body = StringUtil
				.replace(body, new String[] { "[$APPLICANT_PROFILE_URL$]", "[$APPLICANT_NAME$]", "[$POSTER_NAME$]",
						"[$JOB_DETAIL_URL$]", "[$JOB_ID$]", "[$JOB_TITLE$]", "[$RESUME_URL$]", "[$JOB_LOCATION$]",
						"[$COMPANY_NAME$]", "[$APPLICANT_EMAIL$]", "[$APPLICANT_CONTACT_NO$]", "[$COVER_LETTER$]" },
						new String[] { applicantProfileUrl, applicantName, posterName, jobDetailUrl, jobId, jobTitle,
								resumeUrl, jobLocation, companyName, applicantEmail, applicantContactNo, coverLetter });

		return new String[] { subject, body };
	}

	private String[] getSPJobAppNotiTemplateIdForApplicantTitleAndBody(String subject, String body,
			Map<String, Object> paramsMap) {

		String applicantProfileUrl = (String) paramsMap.get("applicantProfileUrl");
		String applicantName = (String) paramsMap.get("applicantName");
		String jobDetailUrl = (String) paramsMap.get("jobDetailUrl");
		String jobId = (String) paramsMap.get("jobId");
		String jobTitle = (String) paramsMap.get("jobTitle");
		String resumeUrl = (String) paramsMap.get("resumeUrl");
		String jobLocation = (String) paramsMap.get("jobLocation");
		String companyName = (String) paramsMap.get("companyName");
		String applicantEmail = (String) paramsMap.get("applicantEmail");
		String applicantContactNo = (String) paramsMap.get("applicantContactNo");
		String coverLetter = (String) paramsMap.get("coverLetter");

		body = StringUtil.replace(body, new String[] { "[$APPLICANT_PROFILE_URL$]", "[$APPLICANT_NAME$]",
				"[$JOB_DETAIL_URL$]", "[$JOB_ID$]", "[$JOB_TITLE$]", "[$RESUME_URL$]", "[$JOB_LOCATION$]",
				"[$COMPANY_NAME$]", "[$APPLICANT_EMAIL$]", "[$APPLICANT_CONTACT_NO$]", "[$COVER_LETTER$]" },
				new String[] { applicantProfileUrl, applicantName, jobDetailUrl, jobId, jobTitle, resumeUrl,
						jobLocation, companyName, applicantEmail, applicantContactNo, coverLetter });

		return new String[] { subject, body };
	}

	private IBMessage addIBMessage(long scopeGroupId, long companyId, String createBy, long createByUserId,
			String fromEmail, String toEmails, String subject, String body) throws PortalException, SystemException {
		IBMessage ibmessage = IBMessageLocalServiceUtil.addMessage(null, 0, scopeGroupId, companyId, subject, body,
				new Date(), fromEmail, toEmails, createBy, String.valueOf(createByUserId), true, false, "", false, false, 0);
		Indexer indexer = IndexerRegistryUtil.getIndexer(IBMessage.class);
		indexer.reindex(ibmessage);
		return ibmessage;
	}

	private void addIBMessageDetail(long companyId, IBMessage ibmessage, long toUserId, String toUserFullName,
			String ibMsgDetailStatus, String messageCategory) throws PortalException, SystemException {

		// add IBMessageDetail

		IBMessageDetailLocalServiceUtil.addMessageDetail(ibmessage.getMessageId(), toUserId, toUserFullName,
				new Date(), messageCategory, false, null, null, "unread", "", ibMsgDetailStatus, 0, 0);
	}

	private void sendExternalEmail(long companyId, String subject, String body, String toName, String toAddress,
			Map<String, Object> paramsMap) throws Exception {

		String fromName = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		MailMessage mailMessage = new MailMessage();
		mailMessage.setFromAddress(fromAddress);
		mailMessage.setFromName(fromName);
		mailMessage.setSubject(subject);
		mailMessage.setHtmlBody(body);
		mailMessage.setToAddress(toAddress);
		SPMailLocalServiceUtil.sendMail(mailMessage);

	}

	private static final String DEFAULT_JOB_RESUME_FOLDER_NAME = "JobApplicants_Resumes";

	private static Log _log = LogFactoryUtil.getLog(SPJobApplyAction.class);

}