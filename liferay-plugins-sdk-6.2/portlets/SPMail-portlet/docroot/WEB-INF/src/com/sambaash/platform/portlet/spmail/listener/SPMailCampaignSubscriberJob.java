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
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.portlet.spmail.util.CampaignHelper;
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
import com.sambaash.platform.util.SambaashUtil;

public class SPMailCampaignSubscriberJob extends SPScheduledJob {

	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignSubscriberJob.class);

	@SuppressWarnings("unchecked")
	public void receive(Message message) throws MessageListenerException {
		_log.error(" Send Invite - " + message.toString());
		long startTime = Calendar.getInstance().getTimeInMillis();
		Map<String, Object> mapMsg = (Map<String, Object>) message.get("map");
		List<FileAttachment> fileList = new ArrayList<FileAttachment>();
		try {
			_log.error(" campaignId value - " + (Long) mapMsg.get("campaignId"));
			_log.error(" spParams value - " + mapMsg.get("spParams"));
			_log.error("Start time for send invite : " + startTime);
			// String[] param = message.getString("spParams").split("-");
			// String id = param[0];
			long subscriberId = (Long) mapMsg.get("subscriberId");
			long spMailCampaignId = (Long) mapMsg.get("campaignId");
			String attachments =  (String)mapMsg.get("attachments");
			//attachments.lastIndexOf("/");
			/**_log.error("attachments : " + attachments);
			if(Validator.isNotNull(attachments)){
				String[] attachmentsArray = attachments.split(",");
				for(String attchment : attachmentsArray){
					fileList.add(new FileAttachment(new File(attchment), "Attachment"));
				}
			}**/
			
			//fileList.add(new FileAttachment(new File("/Volumes/Development/master/liferay6.2GA4/tomcat-7.0.42/temp/liferay/Camapign-create.png"), "Attachment"));
			SPMailCampaignSubscribers subscriber = SPMailCampaignSubscribersLocalServiceUtil
					.getSPMailCampaignSubscribers(subscriberId);
			_log.error(new Date() + " spMailCampaignId = " + spMailCampaignId + "  subscriberid = " + subscriberId);
			SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil.getSPMailCampaign(spMailCampaignId);
			
			SPMailCampaignEDM spMailCampaignEDM = SPMailCampaignEDMLocalServiceUtil.findByCampaignIdMailType(spMailCampaign.getSpMailCampaignId(), subscriber.getSpMailType());
			long templateId = spMailCampaignEDM.getSpMailTemplateId();
			
			boolean canSend = CampaignHelper.canSendMail(spMailCampaign, subscriber.getEmailAddress());
			if (!canSend) {
				_log.debug("Subscriber is blaklisted or unsubscried. So mail can not be sent to email"
						+ subscriber.getEmailAddress() + " Subscriber id" + subscriberId);
				return;
			}
			_log.error("Mail can send to subscriber " + subscriber.getEmailAddress());
			try {



				String content = SPMailLocalServiceUtil.getMailBody(spMailCampaign, subscriber.getSpMailType());
				String subject = SPMailLocalServiceUtil.getMailSubject(spMailCampaign, subscriber.getSpMailType());
				content = SPMailLocalServiceUtil.appendTracker(content);
				
				SPMailTemplate template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(templateId);
				
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
				
				content = template.getHtmlContent();
				subject = template.getSubject();


				String htmlContent = SPMailLocalServiceUtil.processMailBodyParameters(subject, content,
						spMailCampaign.getRsvpId(), subscriber, fromName, fromAddress);

				MailMessage mailMessage = new MailMessage();
				mailMessage.setFromAddress(fromAddress);
				mailMessage.setFromName(fromName);
				mailMessage.setSubject(subject);
				if(!fileList.isEmpty()){
					mailMessage.setFileAttachments(fileList);
					mailMessage.setMultiPart(true);
				}
				mailMessage.setHtmlBody(SPMailLocalServiceUtil.getProcessedContent(htmlContent, spMailCampaign,
						subscriber.getSpMailCampaignSubscribersId(), subscriber.getSpMailType()));
				mailMessage.setToAddress(subscriber.getEmailAddress());

				if (_log.isDebugEnabled()) {
					_log.debug("Final html content :  " + mailMessage.getHtmlBody());
				}
				try {
					String messageId = SPMailLocalServiceUtil.sendMail(mailMessage);
					subscriber.setMessageId(messageId);
					// subscriber.setStatus(SPMailStatus.SENT.getStatus());
				} catch (Exception e) {
					_log.error(e.getMessage());
				}

				SPMailCampaignSubscribersLocalServiceUtil.updateSPMailCampaignSubscribers(subscriber);

				long endTime = Calendar.getInstance().getTimeInMillis();

				if (_log.isDebugEnabled()) {
					_log.debug("End time for send invite : " + endTime);
				}

				_log.error("Total time taken for blast : " + getTotalTime(endTime - startTime));
			} catch (Exception e) {
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
		// TODO Auto-generated method stub
		_log.error("SPMailCampaignSubscriberJob executeJobsssss ");
		Map<String, Object> extrasMap = getExtrasMap();
		Message message = new Message();
		message.put("map", extrasMap);
//		for (Map.Entry<String, Object> entry : extrasMap.entrySet()) {
//			_log.error(entry.getKey() + "/" + entry.getValue());
//		}
		try {
			receive(message);
		} catch (MessageListenerException e) {
			_log.error(e);
		}
	}

}
