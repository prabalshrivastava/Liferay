package com.sambaash.platform.portlet.spmail.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TriggerState;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.srv.mail.NoSuchBlackListException;
import com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

public class MailSchedularHelper {

	public static final String JOB_CLASS_EDM = "com.sambaash.platform.portlet.spmail.listener.SPMailCampaignJob";
	public static final String JOB_CLASS_SUBSCRIBER = "com.sambaash.platform.portlet.spmail.listener.SPMailCampaignSubscriberJob";
	private static final String portletId = "SPMailCampaignCreate_WAR_SPMailportlet";

	public static boolean pause(SPMailCampaignEDM edm,String jobName) {
		try {
			// instead pausing quartz job, we are handling from our sid. quartz
			// job fires the trigger once job it's resumed for pause period too.
			// so handling from our side
			// SchedulerEngineUtil.pause(getJobName(campaignId, spMailType),
			// _schedulerClassName, StorageType.PERSISTED);
			List<SPJobEntry> jobEntryList = SPJobEntryLocalServiceUtil.findByJobNameAndJobClass(jobName, JOB_CLASS_EDM);
			for(SPJobEntry jobEntry : jobEntryList){
				edm.setStatus(String.valueOf(SPScheduleJobStatus.PAUSED.intValue()));
				jobEntry.setStatus(SPScheduleJobStatus.PAUSED.intValue());
				SPJobEntryLocalServiceUtil.updateSPJobEntry(jobEntry);
				SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
			}
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean resume(SPMailCampaignEDM edm,String jobName) {
		try {
			// SchedulerEngineUtil.resume(getJobName(campaignId, spMailType),
			// _schedulerClassName, StorageType.PERSISTED);
			List<SPJobEntry> jobEntryList = SPJobEntryLocalServiceUtil.findByJobNameAndJobClass(jobName, JOB_CLASS_EDM);
			for(SPJobEntry jobEntry : jobEntryList){
				edm.setStatus(String.valueOf(SPScheduleJobStatus.ACTIVE.intValue()));
				jobEntry.setStatus(SPScheduleJobStatus.ACTIVE.intValue());
				SPJobEntryLocalServiceUtil.updateSPJobEntry(jobEntry);
				SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
			}
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String toggleJob(SPMailCampaign campaign, int spMailType) {
		try {
			SPMailCampaignEDM edm = SPMailCampaignEDMLocalServiceUtil
					.findByCampaignIdMailType(campaign.getSpMailCampaignId(), spMailType);
			String jobName = getJobNameEDM(campaign, spMailType);
				String jobStatus = edm.getStatus();
				int pauseStatus = SPScheduleJobStatus.PAUSED.intValue();
				if (String.valueOf(pauseStatus).equalsIgnoreCase(jobStatus)) {
					resume(edm,jobName);
					return String.valueOf(SPScheduleJobStatus.ACTIVE.intValue());
				} else {
					// any other state just pause it
					pause(edm,jobName);
					return String.valueOf(pauseStatus);
				}
			
		} catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	public static String getJobStatus(SPMailCampaign campaign, int spMailType) {
		try {
			SPMailCampaignEDM edm = SPMailCampaignEDMLocalServiceUtil
					.findByCampaignIdMailType(campaign.getSpMailCampaignId(), spMailType);
			String jobName = getJobNameEDM(campaign, spMailType);
			String jobStatus = StringPool.BLANK;
			List<SPJobEntry> jobEntryList = SPJobEntryLocalServiceUtil.findByJobNameAndJobClass(jobName, JOB_CLASS_EDM);
			for(SPJobEntry jobEntry : jobEntryList){
				if(Validator.isNotNull(jobEntry.getStatus())){
					jobStatus =String.valueOf(jobEntry.getStatus());
				}	
				edm.setStatus(jobStatus);
				SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
			}
			
			return jobStatus;
		} catch (Exception ex) {
			return StringPool.BLANK;
		}
	}

	public static void updateJobStatus(SPMailCampaignEDM edm,long jobEntryId) {
		try {
			//SPMailCampaign campaign = SPMailCampaignLocalServiceUtil.getCampaign(edm.getSpMailCampaignId());
			//SPMailCampaign campaign = SPMailCampaignLocalServiceUtil.fetchSPMailCampaign(mailCampaignId);
			//_log.error("getJobStatus campaign fetchcampaign " + campaign);
			//String jobName = getJobNameEDM(campaign, edm.getSeqNo());
			SPJobEntry jobEntry = SPJobEntryLocalServiceUtil.fetchSPJobEntry(jobEntryId);
				if(Validator.isNotNull(jobEntry.getStatus())){
					String jobStatus =String.valueOf(jobEntry.getStatus());
					//_log.error("getJobStatus " + getJobStatus(campaign,edm.getSeqNo()));
					edm.setStatus(jobStatus);
					SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
				}	
			/**TriggerState triggerState = SchedulerEngineHelperUtil.getJobState(jobName, JOB_CLASS_EDM,
					StorageType.PERSISTED);
			_log.error("triggerState updateJobStatus" + triggerState);
			if (triggerState == TriggerState.COMPLETE) {
				edm.setStatus(MailConst.STATUS_COMPLETED);
				_log.error("Status " + MailConst.STATUS_COMPLETED);
			} else if (triggerState == TriggerState.NORMAL) {
				edm.setStatus(MailConst.STATUS_NORMAL);
				_log.error("Status " + MailConst.STATUS_NORMAL);
			} else if (triggerState == TriggerState.PAUSED) {
				edm.setStatus(MailConst.STATUS_PAUSED);
				_log.error("Status " + MailConst.STATUS_PAUSED);
			} else if (triggerState == TriggerState.UNSCHEDULED) {
				edm.setStatus(MailConst.STATUS_UNSCHEDULED);
				_log.error("Status " + MailConst.STATUS_UNSCHEDULED);
			}**/
			
			//SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
		} catch (Exception ex) {

		}
	}

	public static String getJobNameEDM(SPMailCampaign campaign, int seqNo) {
		return getJobNameEDM(campaign.getSpMailCampaignId(), seqNo);
	}

	public static String getJobNameEDM(long campaignId, int seqNo) {
		return String.format(MailConst.FORMAT_JOB_ID_CAMPAIGN_AUTOMATED, campaignId, seqNo);
	}

	public static String getJobNameSubscriberCampaign(SPMailCampaign campaign, long subscriberId) {
		return String.format(MailConst.FORMAT_JOB_ID_CAMPAIGN_SUBSCRIPTION, campaign.getSpMailCampaignId(),
				subscriberId, MailConst.FLAG_SUBSCRIPTION_CAMPAIGN);
	}

	// older implementaiton support
//	public static void schedule(long companyId, long scopeGroupId, long userId, SPMailCampaign campaign,
//			Calendar schedule, int spMailType,Date startDate) {
//		// job id example : 6301:0-campaign
//		
//
//	}
	
	public static void schedule(long companyId, long scopeGroupId, long userId,
			SPMailCampaign campaign, Calendar schedule, int spMailType,
			Date startDate) {
		// TODO Auto-generated method stub
		Map<String, Object> jobData = new HashMap<String, Object>();
		jobData.put(MailConst.CAMPAIGN_ID, campaign.getSpMailCampaignId());
		jobData.put(MailConst.SP_MAIL_TYPE, spMailType);
		jobData.put(MailConst.COMPANY_ID, companyId);
		jobData.put(MailConst.SCOPE_GROUP_ID, scopeGroupId);
		jobData.put(MailConst.USER_ID, userId);
		jobData.put(SPSchedulerConstants.START_DATE, startDate);
		
		SPJobEntryLocalServiceUtil.schedule(portletId, JOB_CLASS_EDM, getJobNameEDM(campaign, spMailType), schedule,
				getJobNameEDM(campaign, spMailType), jobData);
		
	}

	public static long scheduleEDM(long companyId, long scopeGroupId, long userId, SPMailCampaign campaign, int seqNo,
			String cronExpression, Date startDate,String portalUrl) {
		// job id Example : 6301:10001-campaign
		
		SPMailCampaignEDM spMailCampaignEDM;
		String attachments = StringPool.BLANK;
		try {
			spMailCampaignEDM = SPMailCampaignEDMLocalServiceUtil.findByCampaignIdMailType( campaign.getSpMailCampaignId(), seqNo);
			attachments = getFileEntryAttachmentUrl(scopeGroupId, spMailCampaignEDM.getSpMailTemplateId());
		} catch (NoSuchCampaignEDMException | SystemException e) {
			_log.error(e.getMessage());
		}

		Map<String, Object> jobData = new HashMap<String, Object>();
		jobData.put(MailConst.CAMPAIGN_ID, campaign.getSpMailCampaignId());
		jobData.put(MailConst.SP_MAIL_TYPE, seqNo);
		jobData.put(MailConst.COMPANY_ID, companyId);
		jobData.put(MailConst.SCOPE_GROUP_ID, scopeGroupId);
		jobData.put(MailConst.USER_ID, userId);
		if(!attachments.isEmpty()){
			jobData.put("attachments", portalUrl+attachments);
		}
		jobData.put(SPSchedulerConstants.START_DATE, startDate);
		_log.error("mailschedulehelper jobData " + jobData);
		SPJobEntryLocalServiceUtil.delete(getJobNameEDM(campaign, seqNo), JOB_CLASS_EDM);
		long jobEntryId = SPJobEntryLocalServiceUtil.schedule(portletId, JOB_CLASS_EDM, getJobNameEDM(campaign, seqNo), cronExpression,
				getJobNameEDM(campaign, seqNo), jobData);
		return jobEntryId;

	}

	public static void scheduleCampaignForSubscriber(long companyId, long scopeGroupId, long userId,
			SPMailCampaign campaign, long subscriberId, String cronExpression, Date startDate,long templateId,String portalUrl) {
		// job id Example : 6301:101:U-campaign

		String attachments = StringPool.BLANK;
		attachments = getFileEntryAttachmentUrl(scopeGroupId, templateId);
		Map<String, Object> jobData = new HashMap<String, Object>();
		jobData.put(MailConst.CAMPAIGN_ID, campaign.getSpMailCampaignId());
		jobData.put(MailConst.SP_MAIL_TYPE, subscriberId);
		jobData.put(MailConst.COMPANY_ID, companyId);
		jobData.put(MailConst.SCOPE_GROUP_ID, scopeGroupId);
		jobData.put(MailConst.USER_ID, userId);
		jobData.put(MailConst.SUBSCRIBER_ID, subscriberId);
		if(!attachments.isEmpty()){
			jobData.put("attachments", portalUrl+attachments);
		}
		jobData.put(SPSchedulerConstants.START_DATE, startDate);

		SPJobEntryLocalServiceUtil.schedule(portletId, JOB_CLASS_SUBSCRIBER,
				getJobNameSubscriberCampaign(campaign, subscriberId), cronExpression,
				getJobNameSubscriberCampaign(campaign, subscriberId), jobData);

	}
	
	public static String getCronExp(String croneType, int dayOfWeek, int dayOfMonth, Calendar cal) {
		String cronExp = StringPool.BLANK;
		if (MailConst.CRONE_TYPE_DAILY.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpDailly(cal);
		} else if (MailConst.CRONE_TYPE_WEEKLY.equalsIgnoreCase(croneType)) {
			if (!(dayOfWeek >= 1 && dayOfWeek <= 7)) {
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			}
			cronExp = getCronExpWeekly(cal, dayOfWeek);
		} else if (MailConst.CRONE_TYPE_MONTHLY.equalsIgnoreCase(croneType)) {
			String cronExpDayOfMonth = String.valueOf(dayOfMonth);
			if (dayOfMonth == -1) {
				// cron expression to indicate last sunday of month
				cronExpDayOfMonth = "1L";
			} else if (!(dayOfMonth >= 1 && dayOfMonth <= 31)) {
				// if the day does fall in between 1 and 31 then get from job
				// start date
				cronExpDayOfMonth = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			}
			cronExp = getCronExpMonthly(cal, cronExpDayOfMonth);
		} else if (MailConst.CRONE_TYPE_SEMI_YEARLY.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpSemiYearly(cal);
		} else if (MailConst.CRONE_TYPE_YEARLY.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpYearly(cal);
		} else if (MailConst.CRONE_TYPE_ONE_TIME.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpOnetime(cal);
		}
		return cronExp;
	}

	// daily crone
	// every day at one'O clock,5th min, 5h sec equalent crop exp 5 5 1 * * ?
	public static String getCronExpDailly(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s * * ?";
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY));

		return exp;
	}

	// weekly cron
	// every sunday at one'O clock,5th min, 5h sec equalent crop exp 5 5 1 ? *
	// SUN
	public static String getCronExpWeekly(Calendar cal, int dayOfWeek) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s ? * %s";
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY),
				dayOfWeek);
		return exp;
	}

	// monthly cron
	// 17th of every month at one'O clock,5th min, 5h sec equalent crop exp 5 5
	// 1 17 * ?
	public static String getCronExpMonthly(Calendar cal, String cronExpDayOfMonth) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s * ?";
		if (cronExpDayOfMonth.toLowerCase().contains("l")) {
			EXP = "%s %s %s ? * %s";
		}
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY),
				cronExpDayOfMonth);
		return exp;
	}

	// semi-annual cron
	// every 6 months starts from feb 3rd, at one'O clock,5th min, 5h sec
	// equalent crop exp 5 5 1 3 2/6 ?
	public static String getCronExpSemiYearly(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s %s/6 ?";
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1);

		return exp;
	}

	// Yearly cron
	// every year last 5th of july at one'O clock,5th min, 5h sec equalent crop
	// exp 5 5 1 5 7 ? *
	public static String getCronExpYearly(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s %s ? *";
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1);
		return exp;
	}

	public static String getCronExpOnetime(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s %s ? %s";
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
		return exp;
	}

	public static String getNextScheduleTime(SPMailCampaignEDM edm) {
		try {
			SPMailCampaign campaign = SPMailCampaignLocalServiceUtil.getCampaign(edm.getSpMailCampaignId());
			String jobStatus = MailSchedularHelper.getJobStatus(campaign, edm.getSeqNo());
			if (String.valueOf(SPScheduleJobStatus.PAUSED.intValue()).equalsIgnoreCase(jobStatus)) {
				return "Job is currently paused";
			}
			if (String.valueOf(SPScheduleJobStatus.SUCCESS.intValue()).equalsIgnoreCase(jobStatus)) {
				return "Job is completed";
			}
			String jobName = getJobNameEDM(campaign, edm.getSeqNo());
			Date nextFireTime = SchedulerEngineHelperUtil.getNextFireTime(jobName, JOB_CLASS_EDM,
					StorageType.PERSISTED);

			if (Validator.isNotNull(nextFireTime)) {
				return nextFireTime.toString();
			}
		} catch (Exception ex) {
			_log.error("Error while getting next fire time SpMailCampaignEDMId = " + edm.getSpMailCampaignEDMId()
					+ " seqno =  " + edm.getSeqNo());
		}
		return StringPool.BLANK;
	}

	public static void createCampaignSubscriber(String email, String firstName, String lastName,
			SPMailCampaign campaign, long createdBy) throws SystemException {
		// Copied from uploadexceljob -- steps to register must be same as in
		// uploadexceljob
		try {
			SPMailBlackListLocalServiceUtil.findByEmailAddress(email);
		} catch (NoSuchBlackListException e) {
			try {
				SPMailUnsubscribeLocalServiceUtil.findByEmailAddressAndCategoryId(email, campaign.getCategoryId());
			} catch (NoSuchUnsubscribeException ue) {
				List<SPMailCampaignEDM> edms = SPMailCampaignEDMLocalServiceUtil
						.findByCampaignId(campaign.getSpMailCampaignId());
				SPMailCampaignSubscribers spMailCamSub;
				for (SPMailCampaignEDM spMailCampaignEDM : edms) {
					try {
						SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndEmailAddress(
								campaign.getSpMailCampaignId(), spMailCampaignEDM.getSeqNo(), email);
						continue;
					} catch (Exception ex) {
						_log.error("Error creating campaign for subscriber " + ex.getMessage());
					}
					// create subscriber for each edm.
					long spMailCampaignSubscribersId = CounterLocalServiceUtil
							.increment("SPMailCampaignSubscribers.class");
					spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
							.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);
					// ** - mailtype is used to identify the edm.
					// existing mailTyp are 0 to 4, new mailType starts from
					// 10001. EdmId can not be used because edms having ids ( 1
					// to 4 ) can interfer with existing mail type
					spMailCamSub.setSpMailType((int) spMailCampaignEDM.getSeqNo());

					spMailCamSub.setSpMailCampaignId(campaign.getSpMailCampaignId());
					spMailCamSub.setCreateBy(createdBy);
					// TODO: check if user exist in usr table and set the
					// corresponding userid
					spMailCamSub.setUserId(0);
					spMailCamSub.setCreateDate(new Date());
					spMailCamSub.setStatus(SPMailStatus.NOT_SCHEDULED.getStatus());
					spMailCamSub.setFirstName(firstName);
					spMailCamSub.setLastName(lastName);
					spMailCamSub.setEmailAddress(email);

					SPMailCampaignSubscribersLocalServiceUtil.updateSPMailCampaignSubscribers(spMailCamSub);
				}
			}
		}
	}

	public static void scheduleCampaignForSubscriber(long companyId, long scopeGroupId, long userId,
			SPMailCampaign campaign, String email,String portalUrl) throws SystemException, NoSuchCampaignSubscribersException {
		List<SPMailCampaignEDM> edms = SPMailCampaignEDMLocalServiceUtil
				.findByCampaignId(campaign.getSpMailCampaignId());
		Calendar relativeDate = null;
		int delayAmount;
		String delayUnit;
		Calendar temp = null;
		for (SPMailCampaignEDM spMailCampaignEDM : edms) {
			Calendar cal = Calendar.getInstance();
			delayAmount = (int) spMailCampaignEDM.getDelayAmount();
			delayUnit = spMailCampaignEDM.getDelayUnit();
			boolean canUseTime = true;
			if (spMailCampaignEDM.getDelayAmount() > 0) {
				if (relativeDate != null) {
					cal.setTime(relativeDate.getTime());
				}
				if (MailConst.DELAY_MINS.equals(delayUnit)) {
					cal.add(Calendar.MINUTE, delayAmount);
				} else if (MailConst.DELAY_HOURS.equals(delayUnit)) {
					cal.add(Calendar.HOUR, delayAmount);
				}
				if (MailConst.DELAY_DAYS.equals(delayUnit)) {
					cal.add(Calendar.DATE, delayAmount);
				} else if (MailConst.DELAY_WEEKS.equals(delayUnit)) {
					cal.add(Calendar.WEEK_OF_MONTH, delayAmount);
				} else if (MailConst.DELAY_MONTHS.equals(delayUnit)) {
					cal.add(Calendar.MONTH, delayAmount);
				}

			} else {
				// crone is not one time and delay amount is zero which mean
				// immediate schedule
				cal.add(Calendar.MINUTE, 5);
			}
			if (MailConst.CRONE_TYPE_ONE_TIME.equalsIgnoreCase(spMailCampaignEDM.getCroneType())) {
				if (MailConst.DELAY_MINS.equalsIgnoreCase(delayUnit)
						|| MailConst.DELAY_HOURS.equalsIgnoreCase(delayUnit)) {
					canUseTime = false;
				}
			}
			relativeDate = cal;

			// starttime should not consider the time(exact hour,min selected by
			// user. user seletcted time used to trigger job at that point of
			// time).
			Calendar startTime = Calendar.getInstance();
			startTime.setTimeInMillis(cal.getTimeInMillis());

			temp = Calendar.getInstance();
			// spMailCampaignEDM.getNextScheduleDateTime() is used only to get
			// hour, min and am/pm values
			temp.setTime(spMailCampaignEDM.getNextScheduleDateTime());
			if (canUseTime) {
				cal.set(Calendar.HOUR, temp.get(Calendar.HOUR));
				cal.set(Calendar.MINUTE, temp.get(Calendar.MINUTE));
				cal.set(Calendar.AM_PM, temp.get(Calendar.AM_PM));
			}

			String cronExp = getCronExp(spMailCampaignEDM.getCroneType(), spMailCampaignEDM.getDayOfWeek(),
					spMailCampaignEDM.getDayOfMonth(), cal);
			SPMailCampaignSubscribers subscriber = SPMailCampaignSubscribersLocalServiceUtil
					.findByCampaignIdMailTypeAndEmailAddress(campaign.getSpMailCampaignId(),
							spMailCampaignEDM.getSeqNo(), email);
			MailSchedularHelper.scheduleCampaignForSubscriber(companyId, scopeGroupId, userId, campaign,
					subscriber.getSpMailCampaignSubscribersId(), cronExp, startTime.getTime(),spMailCampaignEDM.getSpMailTemplateId(),portalUrl);
		}
	}

	public static String getFileEntry(long groupId, long templateId) {
		String fileString = "";
		try {

			List<SPMailTemplateAttachment> lstSpTemplateAttachment = SPMailTemplateAttachmentLocalServiceUtil
					.findByTemplateId(templateId);
			for (SPMailTemplateAttachment sp : lstSpTemplateAttachment) {
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(sp.getFileEntryId());

				String imageUrl = "/documents/" + groupId + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle();

				imageUrl += ":" + fileEntry.getFileEntryId();
				if (!("".equals(fileString))) {
					fileString += "," + imageUrl;
				} else {
					fileString = imageUrl;
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return fileString;
	}
	
	public static String getFileEntryAttachmentUrl(long groupId, long templateId) {
		String fileString = "";
		try {

			List<SPMailTemplateAttachment> lstSpTemplateAttachment = SPMailTemplateAttachmentLocalServiceUtil
					.findByTemplateId(templateId);
			for (SPMailTemplateAttachment sp : lstSpTemplateAttachment) {
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(sp.getFileEntryId());

				String imageUrl = "/documents/" + groupId + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle();

				if (!("".equals(fileString))) {
					fileString += "," + imageUrl;
				} else {
					fileString = imageUrl;
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return fileString;
	}
	private static final Log _log = LogFactoryUtil.getLog(MailSchedularHelper.class);

}
