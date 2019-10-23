package com.sambaash.platform.portlet.spgroup.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.portlet.spgroup.listener.SPGroupUpdatesJob;
import com.sambaash.platform.portlet.spgroup.util.SPGroupConstants.FIELDS;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

public class SPGroupUpdatesUtil {

	private static Log _log = LogFactoryUtil.getLog(SPGroupUpdatesUtil.class);

	public static void addSPMailCampaignSubscriber(long spMailCampaignId, long createBy, long subscriberId, String name,
			String email) throws SystemException {
		long spSubId = CounterLocalServiceUtil.increment("SPMailCampaignSubscribers.class");
		SPMailCampaignSubscribers sp = SPMailCampaignSubscribersLocalServiceUtil
				.createSPMailCampaignSubscribers(spSubId);

		Calendar cal = Calendar.getInstance();

		sp.setUserId(subscriberId);
		sp.setFirstName(name);
		sp.setLastName(StringPool.BLANK);
		sp.setEmailAddress(email);
		sp.setCreateBy(createBy);
		sp.setSpMailCampaignId(spMailCampaignId);
		sp.setSpMailType(SPMailType.MAIN.ordinal());
		sp.setCreateDate(cal.getTime());
		sp.setParentSubscriberId(0);
		sp.setStatus(SPMailStatus.SCHEDULED.ordinal());
		SPMailCampaignSubscribersLocalServiceUtil.addSPMailCampaignSubscribers(sp);
	}

	@SuppressWarnings("unchecked")
	public static SPMailCampaign getSPMailCampaign(long companyId, long scopeGroupId, long userId)
			throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailCampaign.class,
				PortletClassLoaderUtil.getClassLoader(spMailPortletId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignName", campaignName));

		SPMailCampaign spMailCampaign = null;
		List<SPMailCampaign> spMailCampaigns = SPMailCampaignLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (spMailCampaigns != null && spMailCampaigns.size() > 0) {

			// assume there is only one

			spMailCampaign = spMailCampaigns.get(0);
		} else {

			// create one

			SPMailTemplate spMailTemplate = getSPMailTemplate(companyId, scopeGroupId, userId);
			spMailCampaign = SPMailCampaignLocalServiceUtil
					.createSPMailCampaign(CounterLocalServiceUtil.increment("SPMailCampaign.class"));
			spMailCampaign.setCampaignName(campaignName);

			spMailCampaign.setMainTempalteId(spMailTemplate.getSpMailTemplateId());
			spMailCampaign.setCategoryId(0);
			spMailCampaign.setStatus(SPMailStatus.SCHEDULED.ordinal());
			spMailCampaign.setGroupId(scopeGroupId);
			spMailCampaign.setCompanyId(companyId);

			SPMailCampaignLocalServiceUtil.addSPMailCampaign(spMailCampaign);
		}

		return spMailCampaign;
	}

	@SuppressWarnings("unchecked")
	public static SPMailTemplate getSPMailTemplate(long companyId, long scopeGroupId, long userId)
			throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailTemplate.class,
				PortletClassLoaderUtil.getClassLoader(spMailPortletId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("templateName", templateName));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		SPMailTemplate spMailTemplate = null;
		List<SPMailTemplate> spMailTemplates = SPMailTemplateLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (spMailTemplates != null && spMailTemplates.size() > 0) {

			// assume there is only one

			spMailTemplate = spMailTemplates.get(0);
		} else {

			// create one

			spMailTemplate = SPMailTemplateLocalServiceUtil
					.createSPMailTemplate(CounterLocalServiceUtil.increment("SPMailTemplate.class"));

			spMailTemplate.setTemplateName(templateName);
			spMailTemplate.setSubject(SUBJECT);
			spMailTemplate.setHtmlContent(DEFAULT_CONTENT);
			spMailTemplate.setStatus(false);
			spMailTemplate.setCreateBy(userId);
			spMailTemplate.setCreateDate(DateUtil.newDate());
			spMailTemplate.setModifiedBy(userId);
			spMailTemplate.setModifiedDate(DateUtil.newDate());
			spMailTemplate.setGroupId(scopeGroupId);
			spMailTemplate.setCompanyId(companyId);
			spMailTemplate.setVersionNumber("1");
			spMailTemplate.setParentTempalteId(spMailTemplate.getSpMailTemplateId());
			spMailTemplate.setHtmlUpload(false);

			// SPMailTemplateLocalServiceUtil.addSPMailTemplate(spMailTemplate);

			SPMailTemplateLocalServiceUtil.addCustomSPMailTemplate(spMailTemplate);
		}

		return spMailTemplate;
	}

	public static void schedule(long companyId, long scopeGroupId, long spGroupId, long userId, String updateFrequency,
			String cronExpression) {

		Map<String, Object> jobData = new HashMap<String, Object>();
		jobData.put(FIELDS.COMPANY_ID, companyId);
		jobData.put(FIELDS.SCOPE_GROUP_ID, scopeGroupId);
		jobData.put(FIELDS.SP_GROUP_ID, spGroupId);
		jobData.put(FIELDS.USER_ID, userId);
		jobData.put(FIELDS.UPDATE_FREQUENCY, updateFrequency);

		SPGroup spGroup;
		try {
			spGroup = SPGroupLocalServiceUtil.getSPGroup(spGroupId);

			// remove existing job before scheduling new one
			delete(companyId, scopeGroupId, spGroupId, userId);
			_log.error("cornexpression " + cronExpression + " spGroupId " + spGroupId + " jobData " + jobData);
			SPJobEntryLocalServiceUtil.schedule(spGroupPortletId, _schedulerClassName, spGroup.getTitle() + " digest",
					cronExpression, String.valueOf(spGroupId), jobData);

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	public static void delete(long companyId, long scopeGroupId, long spGroupId, long userId) {
		try {
			SPJobEntryLocalServiceUtil.unSchedule(String.valueOf(spGroupId), _schedulerClassName);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static final String _schedulerClassName = SPGroupUpdatesJob.class.getName();
	private static final String campaignName = "Group Updates";
	private static final String spGroupPortletId = "SPGroupDetail_WAR_SPGroupportlet";
	private static final String spMailPortletId = "SPMailTemplateCreate_WAR_SPMailportlet";
	private static final String templateName = "Group Updates";
	private static final String DEFAULT_CONTENT = "<div style=\"width: 580px; font-family: Trebuchet MS; color: rgb(51, 51, 51);\">     <div>         Dear [$TO_NAME$],         <br>         <br> Here's a quick review of the latest <a href=\"[$GROUP_URL$]\"><span>[$GROUP_TITLE$]</span></a> activities.     </div>     <div id=\"discussions_updates\">         <div style=\"margin: 10px 0px 0px; padding: 10px 0px 0px;\">             <div style=\"color: rgb(0, 0, 0); font-family: Arial; font-weight: bold; margin-bottom: 10px;\">Recent Discussions:</div>             <div style=\"overflow:auto;\">                 <div style=\"padding: 10px [$DISCUSSION_PARENT_INDENT_0$]px; display: [$DISCUSSION_PARENT_DISPLAY_0$] !important;\">                     <a href=\"[$DISCUSSION_PARENT_DETAIL_URL_0$]\"><span>[$DISCUSSION_PARENT_TITLE_0$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_INDENT_0$]px; display: [$DISCUSSION_DISPLAY_0$] !important;\">                     <a href=\"[$DISCUSSION_DETAIL_URL_0$]\"><span>[$DISCUSSION_TITLE_0$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_PARENT_INDENT_1$]px; display: [$DISCUSSION_PARENT_DISPLAY_1$] !important;\">                     <a href=\"[$DISCUSSION_PARENT_DETAIL_URL_1$]\"><span>[$DISCUSSION_PARENT_TITLE_1$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_INDENT_1$]px; display: [$DISCUSSION_DISPLAY_1$] !important;\">                     <a href=\"[$DISCUSSION_DETAIL_URL_1$]\"><span>[$DISCUSSION_TITLE_1$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_PARENT_INDENT_2$]px; display: [$DISCUSSION_PARENT_DISPLAY_2$] !important;\">                     <a href=\"[$DISCUSSION_PARENT_DETAIL_URL_2$]\"><span>[$DISCUSSION_PARENT_TITLE_2$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_INDENT_2$]px; display: [$DISCUSSION_DISPLAY_2$] !important;\">                     <a href=\"[$DISCUSSION_DETAIL_URL_2$]\"><span>[$DISCUSSION_TITLE_2$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_PARENT_INDENT_3$]px; display: [$DISCUSSION_PARENT_DISPLAY_3$] !important;\">                     <a href=\"[$DISCUSSION_PARENT_DETAIL_URL_3$]\"><span>[$DISCUSSION_PARENT_TITLE_3$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_INDENT_3$]px; display: [$DISCUSSION_DISPLAY_3$] !important;\">                     <a href=\"[$DISCUSSION_DETAIL_URL_3$]\"><span>[$DISCUSSION_TITLE_3$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_PARENT_INDENT_4$]px; display: [$DISCUSSION_PARENT_DISPLAY_4$] !important;\">                     <a href=\"[$DISCUSSION_PARENT_DETAIL_URL_4$]\"><span>[$DISCUSSION_PARENT_TITLE_4$]</span></a>                 </div>                 <div style=\"padding: 10px [$DISCUSSION_INDENT_4$]px; display: [$DISCUSSION_DISPLAY_4$] !important;\">                     <a href=\"[$DISCUSSION_DETAIL_URL_4$]\"><span>[$DISCUSSION_TITLE_4$]</span></a>                 </div>             </div>         </div>     </div>     <div id=\"members_updates\">         <div style=\"margin: 10px 0px 0px; padding: 10px 0px 0px;\">             <div style=\"color: rgb(0, 0, 0); font-family: Arial; font-weight: bold; margin-bottom: 10px;\">New Members:</div>             <div style=\"overflow:auto;\">                 <div align=\"center\" style=\"width: 100px; padding: 10px 8px; float: left; display: [$MEMBER_DISPLAY_0$] !important;\">                     <div><img height=\"90\" border=\"0\" width=\"90\" src=\"[$MEMBER_PORTRAIT_0$]\"></div>                     <div style=\"padding-top: 10px;\">                         <a href=\"[$MEMBER_PROFILE_URL_0$]\"><span style=\"max-width: 80px; text-align: center; word-wrap: break-word;\">[$MEMBER_NAME_0$]</span></a>                     </div>                 </div>                 <div align=\"center\" style=\"width: 100px; padding: 10px 8px; float: left; display: [$MEMBER_DISPLAY_1$] !important;\">                     <div><img height=\"90\" border=\"0\" width=\"90\" src=\"[$MEMBER_PORTRAIT_1$]\"></div>                     <div style=\"padding-top: 10px;\">                         <a href=\"[$MEMBER_PROFILE_URL_1$]\"><span style=\"max-width: 80px; text-align: center; word-wrap: break-word;\">[$MEMBER_NAME_1$]</span></a>                     </div>                 </div>                 <div align=\"center\" style=\"width: 100px; padding: 10px 8px; float: left; display: [$MEMBER_DISPLAY_2$] !important;\">                     <div><img height=\"90\" border=\"0\" width=\"90\" src=\"[$MEMBER_PORTRAIT_2$]\"></div>                     <div style=\"padding-top: 10px;\">                         <a href=\"[$MEMBER_PROFILE_URL_2$]\"><span style=\"max-width: 80px; text-align: center; word-wrap: break-word;\">[$MEMBER_NAME_2$]</span></a>                     </div>                 </div>                 <div align=\"center\" style=\"width: 100px; padding: 10px 8px; float: left; display: [$MEMBER_DISPLAY_3$] !important;\">                     <div><img height=\"90\" border=\"0\" width=\"90\" src=\"[$MEMBER_PORTRAIT_3$]\"></div>                     <div style=\"padding-top: 10px;\">                         <a href=\"[$MEMBER_PROFILE_URL_3$]\"><span style=\"max-width: 80px; text-align: center; word-wrap: break-word;\">[$MEMBER_NAME_3$]</span></a>                     </div>                 </div>                 <div align=\"center\" style=\"width: 100px; padding: 10px 8px; float: left; display: [$MEMBER_DISPLAY_4$] !important;\">                     <div><img height=\"90\" border=\"0\" width=\"90\" src=\"[$MEMBER_PORTRAIT_4$]\"></div>                     <div style=\"padding-top: 10px;\">                         <a href=\"[$MEMBER_PROFILE_URL_4$]\"><span style=\"max-width: 80px; text-align: center; word-wrap: break-word;\">[$MEMBER_NAME_4$]</span></a>                     </div>                 </div>             </div>         </div>     </div>     <!--     <div style=\"margin: 20px 0 10px;\">         Regards,         <p style=\"margin: 10px 0;\"> The Sambaash Team </p>     </div>     --> </div>";
	private static final String SUBJECT = "[$GROUP_TITLE$] digest";

}