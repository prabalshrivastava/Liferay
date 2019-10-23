package com.sambaash.platform.portlet.spmail.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TriggerState;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.portlet.spmail.util.CampaignHelper;
import com.sambaash.platform.portlet.spmail.util.MailConst;
import com.sambaash.platform.portlet.spmail.util.MailSchedularHelper;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPMailCampaignJob extends SPScheduledJob {

	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignJob.class);
	public static final String JOB_CLASS_EDM = "com.sambaash.platform.portlet.spmail.listener.SPMailCampaignJob";

	public void receive(Message message) throws MessageListenerException {
		_log.error(" Send Invite - " + message.toString());
		long startTime = Calendar.getInstance().getTimeInMillis();
		Map<String, Object> mapMsg = (Map<String, Object>) message.get("map");
		List<FileAttachment> fileList = new ArrayList<FileAttachment>();
		try {
			if (_log.isDebugEnabled()) {
				_log.error(" campaignId value - " + (Long) mapMsg.get("campaignId"));
				_log.error(" spParams value - " + (Integer) mapMsg.get("spMailType"));

				_log.error("Start time for send invite : " + startTime);
			}

			long spMailCampaignId = (Long) mapMsg.get("campaignId");
			String attachments =  (String)mapMsg.get("attachments");
			_log.error("attachments : " + attachments);
			if(Validator.isNotNull(attachments)){
				String[] attachmentsArray = attachments.split(",");
				for(String attchment : attachmentsArray){
					fileList.add(new FileAttachment(new File(attchment), "Attachment"));
				}
			}
			// String[] params = StringUtil.split(mapMsg.get("spParams"),
			// CharPool.DASH);

			int spMailType = (Integer) mapMsg.get("spMailType");
			_log.error(" spMailCampaignId - " + spMailCampaignId + " spMailType " + spMailType);
			// String[] param = message.getString("spParams").split("-");
			// long spMailCampaignId =
			// GetterUtil.getLong(message.getString("templateCategoryId"));
			// int spMailType = GetterUtil.getInteger(param[0]);
			SPMailCampaignEDM edm = SPMailCampaignEDMLocalServiceUtil.findByCampaignIdMailType(spMailCampaignId,
					spMailType);
			// if the job is resumed after some time it's paused, quartz will
			// fire the trigger for pause period too. so have to handle pause
			// period.
			if (String.valueOf(SPScheduleJobStatus.PAUSED.intValue()).equalsIgnoreCase(edm.getStatus())) {
				_log.error("Job is paused hence mail campaign will not run for edm : mailcampaignId=" + spMailCampaignId
						+ " seqNo =" + spMailType);
				return;
			}	
			// update job status to complete if it is done
			try {
				String jobName = MailSchedularHelper.getJobNameEDM(spMailCampaignId, edm.getSeqNo());
				String jobStatus =  StringPool.BLANK;
				List<SPJobEntry> jobEntryList = SPJobEntryLocalServiceUtil.findByJobNameAndJobClass(jobName, JOB_CLASS_EDM);
				for(SPJobEntry jobEntry : jobEntryList){
					if(Validator.isNotNull(jobEntry.getStatus())){
						jobStatus =String.valueOf(jobEntry.getStatus());
						//_log.error("getJobStatus " + getJobStatus(campaign,edm.getSeqNo()));
					}
				}	
//				TriggerState triggerState = SchedulerEngineHelperUtil.getJobState(jobName,
//						MailSchedularHelper.JOB_CLASS_EDM, StorageType.PERSISTED);
//				_log.error("triggerState " + triggerState);
				if (jobStatus == String.valueOf(SPScheduleJobStatus.SUCCESS.intValue())) {
					edm.setStatus(jobStatus);
					SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
				}
			} catch (Exception ex) {
				_log.error("error updating edm status " + ex.getMessage());
			}
			_log.info("Job is running state");

			SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil.getSPMailCampaign(spMailCampaignId);

			try {
				// spMailCampaign.setStatus(SPMailStatus.PROCESSING.ordinal());
				SPMailCampaignLocalServiceUtil.updateSPMailCampaign(spMailCampaign);
				Rsvp rsvp = null;
				if (spMailCampaign.getRsvpId() > 0) {
					rsvp = RsvpLocalServiceUtil.getRsvp(spMailCampaign.getRsvpId());
					rsvp.setProcessing(SPMailStatus.PROCESSING.getStatus());
					RsvpLocalServiceUtil.updateRsvp(rsvp);
				}

				// SPMailCampaignSubscribersLocalServiceUtil.clearCache();
				List<SPMailCampaignSubscribers> spMailCampaignSubscribersList = null;

				if (edm.getCroneType().equalsIgnoreCase(MailConst.CRONE_TYPE_ONE_TIME)) {
					spMailCampaignSubscribersList = SPMailCampaignSubscribersLocalServiceUtil
							.findByCampaignIdMailTypeAndStatus(spMailCampaignId, spMailType,
									SPMailStatus.NOT_SCHEDULED.getStatus());
				} else {

					spMailCampaignSubscribersList = SPMailCampaignSubscribersLocalServiceUtil
							.findByCampaignIdAndMailType(spMailCampaignId, spMailType);
				}


				String content = StringPool.BLANK;
				String subject = StringPool.BLANK;

				SPMailTemplate template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(edm.getSpMailTemplateId());
				content = template.getHtmlContent();
				subject = template.getSubject();
				
				String fromName = SambaashUtil.getEmailFromName(PortalUtil.getDefaultCompanyId(), template);
				String fromAddress = SambaashUtil.getEmailFromAddress(PortalUtil.getDefaultCompanyId(), template);
				
				if (Validator.isNull(fromName)) {
					fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
							PropsKeys.ADMIN_EMAIL_FROM_NAME);
				}

				if (Validator.isNull(fromAddress)) {
					fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
							PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
				}

				if (_log.isDebugEnabled()) {
					_log.debug("mail subject  " + subject);
					_log.debug("mail content  " + content);
				}
				content = SPMailLocalServiceUtil.appendTracker(content);

				if (_log.isInfoEnabled()) {
					_log.info("spMailCampaignSubscribersList.size() :  " + spMailCampaignSubscribersList.size());
				}

				for (SPMailCampaignSubscribers subscriber : spMailCampaignSubscribersList) {
					boolean canSend = CampaignHelper.canSendMail(spMailCampaign, subscriber.getEmailAddress());
					if (!canSend) {
						continue;
					}

					String htmlContent = SPMailLocalServiceUtil.processMailBodyParameters(subject, content,
							spMailCampaign.getRsvpId(), subscriber, fromName, fromAddress);

					MailMessage mailMessage = new MailMessage();
					mailMessage.setFromAddress(fromAddress);
					mailMessage.setFromName(fromName);
					mailMessage.setSubject(subject);
					mailMessage.setHtmlBody(SPMailLocalServiceUtil.getProcessedContent(htmlContent, spMailCampaign,
							subscriber.getSpMailCampaignSubscribersId(), subscriber.getSpMailType()));
					mailMessage.setToAddress(subscriber.getEmailAddress());
					if(!fileList.isEmpty()){
						mailMessage.setFileAttachments(fileList);
						mailMessage.setMultiPart(true);
					}

					if (_log.isDebugEnabled()) {
					_log.error("Final html content :  " + mailMessage.getHtmlBody());
					_log.error("subject : " + subject + " to address " + subscriber.getEmailAddress());
					 }

					try {
						String messageId = SPMailLocalServiceUtil.sendMail(mailMessage);
						subscriber.setMessageId(messageId);
						subscriber.setStatus(SPMailStatus.SENT.getStatus());
					} catch (Exception e) {
						subscriber.setStatus(SPMailStatus.ERROR.getStatus());
						_log.error(e.getMessage());
					}

					SPMailCampaignSubscribersLocalServiceUtil.updateSPMailCampaignSubscribers(subscriber);

				}

				if (rsvp != null) {
					rsvp.setProcessing(SPMailStatus.SENT.getStatus());
					RsvpLocalServiceUtil.updateRsvp(rsvp);
				}

				// TODO: check the use of status and comment/uncomment below
				// line
				// spMailCampaign.setStatus(SPMailStatus.SENT.ordinal());
				spMailCampaign.setSentDate(DateUtil.newDate());
				SPMailCampaignLocalServiceUtil.updateSPMailCampaign(spMailCampaign);

				long endTime = Calendar.getInstance().getTimeInMillis();

				if (_log.isDebugEnabled()) {
					_log.debug("End time for send invite : " + endTime);
				}

				_log.error("Total time taken for blast : " + getTotalTime(endTime - startTime));
			} catch (Exception e) {
				spMailCampaign.setStatus(SPMailStatus.ERROR.ordinal());
				SPMailCampaignLocalServiceUtil.updateSPMailCampaign(spMailCampaign);
				_log.error(e);
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public String getTotalTime(long diffMSec) {
		int left = 0;
		int ss = 0;
		int mm = 0;
		int hh = 0;
		int dd = 0;
		left = (int) (diffMSec / 1000);
		ss = left % 60;
		left = (int) left / 60;
		if (left > 0) {
			mm = left % 60;
			left = (int) left / 60;
			if (left > 0) {
				hh = left % 24;
				left = (int) left / 24;
				if (left > 0) {
					dd = left;
				}
			}
		}

		StringBuffer diff = new StringBuffer();
		diff.append(dd).append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(hh)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(mm)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(ss)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE);

		return diff.toString();

	}

	@Override
	public void executeJob() {
		_log.error("executeJob ");
		Map<String, Object> extrasMap = getExtrasMap();
		Message message = new Message();
		message.put("map", extrasMap);
		try {
			receive(message);
		} catch (MessageListenerException e) {
			_log.error(e);
		}
	}

}
