package com.sambaash.platform.portlet.spmail.action;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.portlet.spmail.util.MailConst;
import com.sambaash.platform.portlet.spmail.util.MailSchedularHelper;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.util.SambaashUtil;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SPMailCampaignCreateAction
 */
public class SPMailCampaignCreateAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignCreateAction.class);
	public static final String JOB_CLASS_EDM = "com.sambaash.platform.portlet.spmail.listener.SPMailCampaignJob";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.error("SPMailCampaignCreateAction");

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String campaignId = httpRequest.getParameter("campaignId");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("hasAccess",
				(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
						|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())));

		PortletPreferences preferences = renderRequest.getPreferences();
		String chkEnableRem1 = preferences.getValue("chkEnableRem1", StringPool.FALSE);
		String chkEnableRem2 = preferences.getValue("chkEnableRem2", StringPool.FALSE);
		String chkEnableRem3 = preferences.getValue("chkEnableRem3", StringPool.FALSE);
		String chkEnableThankYou = preferences.getValue("chkEnableThankYou", StringPool.FALSE);
		String chkEnableMissYou = preferences.getValue("chkEnableMissYou", StringPool.FALSE);
		String categoryName = preferences.getValue("categoryName", StringPool.BLANK);

		String scheduleErrorMessage = renderRequest.getParameter("scheduleErrorMessage");

		if (Validator.isNotNull(renderRequest.getParameter("byCampaignId"))) {
			campaignId = renderRequest.getParameter("byCampaignId");
		}

		try {

			// String volcaName =
			// SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId()) +
			// ".contactus.category"; 
			// List<AssetCategory> categoryList =
			// SambaashUtil.getCategory(themeDisplay.getScopeGroupId(),
			// volcaName);

			List<AssetVocabulary> lstAssetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabularies(0,
					AssetVocabularyLocalServiceUtil.getAssetVocabulariesCount());
			long volId = 0;

			for (AssetVocabulary assetVo : lstAssetVocabulary) {
				if (assetVo.getName().equals(categoryName)) {
					volId = assetVo.getVocabularyId();
				}
			}

			List<AssetCategory> lstAssetCategory = AssetCategoryLocalServiceUtil.getVocabularyCategories(volId, -1, -1,
					null);

			renderRequest.setAttribute("lstAssetCategory", lstAssetCategory);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		String listingPageName = preferences.getValue("listingPageName", StringPool.BLANK);
		renderRequest.setAttribute("listingPageName", listingPageName);

		if (Validator.isNotNull(chkEnableRem1)) {
			renderRequest.setAttribute("chkEnableRem1", chkEnableRem1);
		}

		if (Validator.isNotNull(chkEnableRem2)) {
			renderRequest.setAttribute("chkEnableRem2", chkEnableRem2);
		}

		if (Validator.isNotNull(chkEnableRem3)) {
			renderRequest.setAttribute("chkEnableRem3", chkEnableRem3);
		}

		if (Validator.isNotNull(chkEnableThankYou)) {
			renderRequest.setAttribute("chkEnableThankYou", chkEnableThankYou);
		}

		if (Validator.isNotNull(chkEnableMissYou)) {
			renderRequest.setAttribute("chkEnableMissYou", chkEnableMissYou);
		}

		if (Validator.isNotNull(campaignId)) {
			try {
				SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil
						.getSPMailCampaign(Long.valueOf(campaignId));

				renderRequest.setAttribute("byCampaignId", campaignId);
				renderRequest.setAttribute("campaignType", spMailCampaign.getCampaignType());
				renderRequest.setAttribute("disableCampaignType", "disabled");
				if (MailConst.CAMPAIGN_TYPE_AUTOMATED.equalsIgnoreCase(spMailCampaign.getCampaignType())
						|| Validator.isNull(spMailCampaign.getCampaignType())) {
					renderRequest.setAttribute("automated", "selected");
				} else if (MailConst.CAMPAIGN_TYPE_SUBSCRIPTION.equalsIgnoreCase(spMailCampaign.getCampaignType())) {
					renderRequest.setAttribute("subscribed", "selected");
				}
				renderRequest.setAttribute("campaignName", spMailCampaign.getCampaignName());
				renderRequest.setAttribute("categoryId", spMailCampaign.getCategoryId());

				if (Validator.isNotNull(spMailCampaign.getMainTempalteId())) {
					SPMailTemplate sp = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spMailCampaign.getMainTempalteId());
					renderRequest.setAttribute("mailTemplateSubjectValue", sp.getSubject().replace("\"", "&quot;"));
					renderRequest.setAttribute("mailTemplateHTMLContentValue",
							sp.getHtmlContent().replace("\"", "&quot;"));
				}

				if (Validator.isNotNull(spMailCampaign.getRem1TempalteId())) {
					SPMailTemplate sp = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spMailCampaign.getRem1TempalteId());
					renderRequest.setAttribute("reminder1SubjectValue", sp.getSubject().replace("\"", "&quot;"));
					renderRequest.setAttribute("reminder1HTMLContentValue",
							sp.getHtmlContent().replace("\"", "&quot;"));
				}

				if (Validator.isNotNull(spMailCampaign.getRem2TempalteId())) {
					SPMailTemplate sp = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spMailCampaign.getRem2TempalteId());
					renderRequest.setAttribute("reminder2SubjectValue", sp.getSubject().replace("\"", "&quot;"));
					renderRequest.setAttribute("reminder2HTMLContentValue",
							sp.getHtmlContent().replace("\"", "&quot;"));
				}

				if (Validator.isNotNull(spMailCampaign.getRem3TempalteId())) {
					SPMailTemplate sp = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spMailCampaign.getRem3TempalteId());
					renderRequest.setAttribute("reminder3SubjectValue", sp.getSubject().replace("\"", "&quot;"));
					renderRequest.setAttribute("reminder3HTMLContentValue",
							sp.getHtmlContent().replace("\"", "&quot;"));
				}

				if (Validator.isNotNull(spMailCampaign.getThankyouTempalteId())) {
					SPMailTemplate sp = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spMailCampaign.getThankyouTempalteId());
					renderRequest.setAttribute("thankYouSubjectValue", sp.getSubject().replace("\"", "&quot;"));
					renderRequest.setAttribute("thankYouHTMLContentValue", sp.getHtmlContent().replace("\"", "&quot;"));
				}

				if (Validator.isNotNull(spMailCampaign.getMissedyouTempalteId())) {
					SPMailTemplate sp = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spMailCampaign.getMissedyouTempalteId());
					renderRequest.setAttribute("missYouSubjectValue", sp.getSubject().replace("\"", "&quot;"));
					renderRequest.setAttribute("missYouHTMLContentValue", sp.getHtmlContent().replace("\"", "&quot;"));
				}

				renderRequest.setAttribute("mainSchedule", spMailCampaign.getMainScheduledDate());
				renderRequest.setAttribute("rem1Schedule", spMailCampaign.getRem1ScheduledDate());
				renderRequest.setAttribute("rem2Schedule", spMailCampaign.getRem2ScheduledDate());
				renderRequest.setAttribute("rem3Schedule", spMailCampaign.getRem3ScheduledDate());
				renderRequest.setAttribute("thankYouSchedule", spMailCampaign.getThankYouScheduledDate());
				renderRequest.setAttribute("missYouSchedule", spMailCampaign.getMissedyouScheduledDate());

				if (spMailCampaign.getStatus() == SPMailStatus.NOT_SCHEDULED.getStatus()
						|| spMailCampaign.getStatus() == SPMailStatus.SCHEDULED.getStatus()
						|| spMailCampaign.getStatus() == SPMailStatus.SENT.getStatus()) {
					renderRequest.setAttribute("editable", true);
				} else {
					renderRequest.setAttribute("editable", false);
				}
			} catch (Exception e) {

			}

		} else {
			renderRequest.setAttribute("editable", true);
		}

		List<SPMailTemplate> lstResult = new ArrayList<SPMailTemplate>();
		long preTemplateId = 0;
		try {
			List<SPMailTemplate> lstParent = SPMailTemplateLocalServiceUtil.findByStatus(false);
			for (SPMailTemplate sp : lstParent) {
				if (preTemplateId != sp.getParentTempalteId()) {
					preTemplateId = sp.getParentTempalteId();
					List<SPMailTemplate> lstChild = SPMailTemplateLocalServiceUtil
							.findByparentTempalteId(sp.getParentTempalteId());
					lstResult.add(lstChild.get(0));
				}
			}
		} catch (Exception e) {

		}
		renderRequest.setAttribute("lstTemplate", lstResult);
		if (Validator.isNull(scheduleErrorMessage)) {
			Calendar defaultValueDate = CalendarFactoryUtil.getCalendar(themeDisplay.getUser().getTimeZone(),
					themeDisplay.getUser().getLocale());
			long dayValue = defaultValueDate.get(Calendar.DATE);
			long firstDayOfWeek = defaultValueDate.getFirstDayOfWeek() - 1;
			long monthValue = defaultValueDate.get(Calendar.MONTH);
			long yearValue = defaultValueDate.get(Calendar.YEAR);
			long yearRangeStart = defaultValueDate.get(Calendar.YEAR);
			long yearRangeEnd = defaultValueDate.get(Calendar.YEAR) + 50;
			long hourValue = defaultValueDate.get(Calendar.HOUR);
			long minuteValue = defaultValueDate.get(Calendar.MINUTE);
			long amPmValue = defaultValueDate.get(Calendar.AM_PM);

			renderRequest.setAttribute("dayValuemain", dayValue);
			renderRequest.setAttribute("firstDayOfWeekmain", firstDayOfWeek);
			renderRequest.setAttribute("monthValuemain", monthValue);
			renderRequest.setAttribute("yearValuemain", yearValue);
			renderRequest.setAttribute("yearRangeStartmain", yearRangeStart);
			renderRequest.setAttribute("yearRangeEndmain", yearRangeEnd);
			renderRequest.setAttribute("hourValuemain", hourValue);
			_log.info("hourValue " + hourValue);
			renderRequest.setAttribute("minuteValuemain", minuteValue);
			renderRequest.setAttribute("amPmValuemain", amPmValue);

			renderRequest.setAttribute("dayValuerem1", dayValue);
			renderRequest.setAttribute("firstDayOfWeekrem1", firstDayOfWeek);
			renderRequest.setAttribute("monthValuerem1", monthValue);
			renderRequest.setAttribute("yearValuerem1", yearValue);
			renderRequest.setAttribute("yearRangeStartrem1", yearRangeStart);
			renderRequest.setAttribute("yearRangeEndrem1", yearRangeEnd);
			renderRequest.setAttribute("hourValuerem1", hourValue);
			_log.info("hourValue " + hourValue);
			renderRequest.setAttribute("minuteValuerem1", minuteValue);
			renderRequest.setAttribute("amPmValuerem1", amPmValue);

			renderRequest.setAttribute("dayValuerem2", dayValue);
			renderRequest.setAttribute("firstDayOfWeekrem2", firstDayOfWeek);
			renderRequest.setAttribute("monthValuerem2", monthValue);
			renderRequest.setAttribute("yearValuerem2", yearValue);
			renderRequest.setAttribute("yearRangeStartrem2", yearRangeStart);
			renderRequest.setAttribute("yearRangeEndrem2", yearRangeEnd);
			renderRequest.setAttribute("hourValuerem2", hourValue);
			_log.info("hourValue " + hourValue);
			renderRequest.setAttribute("minuteValuerem2", minuteValue);
			renderRequest.setAttribute("amPmValuerem2", amPmValue);

			renderRequest.setAttribute("dayValuerem3", dayValue);
			renderRequest.setAttribute("firstDayOfWeekrem3", firstDayOfWeek);
			renderRequest.setAttribute("monthValuerem3", monthValue);
			renderRequest.setAttribute("yearValuerem3", yearValue);
			renderRequest.setAttribute("yearRangeStartrem3", yearRangeStart);
			renderRequest.setAttribute("yearRangeEndrem3", yearRangeEnd);
			renderRequest.setAttribute("hourValuerem3", hourValue);
			_log.info("hourValue " + hourValue);
			renderRequest.setAttribute("minuteValuerem3", minuteValue);
			renderRequest.setAttribute("amPmValuerem3", amPmValue);

			renderRequest.setAttribute("dayValuethankYou", dayValue);
			renderRequest.setAttribute("firstDayOfWeekthankYou", firstDayOfWeek);
			renderRequest.setAttribute("monthValuethankYou", monthValue);
			renderRequest.setAttribute("yearValuethankYou", yearValue);
			renderRequest.setAttribute("yearRangeStartthankYou", yearRangeStart);
			renderRequest.setAttribute("yearRangeEndthankYou", yearRangeEnd);
			renderRequest.setAttribute("hourValuethankYou", hourValue);
			_log.info("hourValue " + hourValue);
			renderRequest.setAttribute("minuteValuethankYou", minuteValue);
			renderRequest.setAttribute("amPmValuethankYou", amPmValue);

			renderRequest.setAttribute("dayValuemissYou", dayValue);
			renderRequest.setAttribute("firstDayOfWeekmissYou", firstDayOfWeek);
			renderRequest.setAttribute("monthValuemissYou", monthValue);
			renderRequest.setAttribute("yearValuemissYou", yearValue);
			renderRequest.setAttribute("yearRangeStartmissYou", yearRangeStart);
			renderRequest.setAttribute("yearRangeEndmissYou", yearRangeEnd);
			renderRequest.setAttribute("hourValuemissYou", hourValue);
			_log.info("hourValue " + hourValue);
			renderRequest.setAttribute("minuteValuemissYou", minuteValue);
			renderRequest.setAttribute("amPmValuemissYou", amPmValue);

		} else {

			renderRequest.setAttribute("dayValuemain", renderRequest.getParameter("dayValuemain"));
			renderRequest.setAttribute("monthValuemain", renderRequest.getParameter("monthValuemain"));
			renderRequest.setAttribute("yearValuemain", renderRequest.getParameter("yearValuemain"));
			renderRequest.setAttribute("yearRangeStartmain", renderRequest.getParameter("yearRangeStartmain"));
			renderRequest.setAttribute("yearRangeEndmain", renderRequest.getParameter("yearRangeEndmain"));
			renderRequest.setAttribute("hourValuemain", renderRequest.getParameter("hourValuemain"));
			renderRequest.setAttribute("minuteValuemain", renderRequest.getParameter("minuteValuemain"));
			renderRequest.setAttribute("amPmValuemain", renderRequest.getParameter("amPmValuemain"));
			renderRequest.setAttribute("mailTemplateChk", renderRequest.getParameter("mailTemplateChk"));

			renderRequest.setAttribute("dayValuerem1", renderRequest.getParameter("dayValuerem1"));
			renderRequest.setAttribute("monthValuerem1", renderRequest.getParameter("monthValuerem1"));
			renderRequest.setAttribute("yearValuerem1", renderRequest.getParameter("yearValuerem1"));
			renderRequest.setAttribute("yearRangeStartrem1", renderRequest.getParameter("yearRangeStartrem1"));
			renderRequest.setAttribute("yearRangeEndrem1", renderRequest.getParameter("yearRangeEndrem1"));
			renderRequest.setAttribute("hourValuerem1", renderRequest.getParameter("hourValuerem1"));
			renderRequest.setAttribute("minuteValuerem1", renderRequest.getParameter("minuteValuerem1"));
			renderRequest.setAttribute("amPmValuerem1", renderRequest.getParameter("amPmValuerem1"));
			renderRequest.setAttribute("reminder1Chk", renderRequest.getParameter("reminder1Chk"));
		}

		renderRequest.setAttribute("previewIcon", themeDisplay.getPathThemeImages() + "/calendar/Preview01.png");

		super.doView(renderRequest, renderResponse);

	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String chkEnableRem1 = preferences.getValue("chkEnableRem1", StringPool.FALSE);
		String chkEnableRem2 = preferences.getValue("chkEnableRem2", StringPool.FALSE);
		String chkEnableRem3 = preferences.getValue("chkEnableRem3", StringPool.FALSE);
		String chkEnableThankYou = preferences.getValue("chkEnableThankYou", StringPool.FALSE);
		String chkEnableMissYou = preferences.getValue("chkEnableMissYou", StringPool.FALSE);
		String listingPageName = preferences.getValue("listingPageName", StringPool.BLANK);
		String categoryName = preferences.getValue("categoryName", StringPool.BLANK);
		renderRequest.setAttribute("listingPageName", listingPageName);
		renderRequest.setAttribute("categoryName", categoryName);

		if (Validator.isNotNull(chkEnableRem1)) {
			renderRequest.setAttribute("chkEnableRem1", chkEnableRem1);
		}

		if (Validator.isNotNull(chkEnableRem2)) {
			renderRequest.setAttribute("chkEnableRem2", chkEnableRem2);
		}

		if (Validator.isNotNull(chkEnableRem3)) {
			renderRequest.setAttribute("chkEnableRem3", chkEnableRem3);
		}

		if (Validator.isNotNull(chkEnableThankYou)) {
			renderRequest.setAttribute("chkEnableThankYou", chkEnableThankYou);
		}

		if (Validator.isNotNull(chkEnableMissYou)) {
			renderRequest.setAttribute("chkEnableMissYou", chkEnableMissYou);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		_log.info("serveResource");
		String filterName = resourceRequest.getParameter("filterName");
		String filterValue = resourceRequest.getParameter("filterValue");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("filterName " + filterName + " filterValue " + filterValue);

		if ("templateDetail".equals(filterName)) {
			try {
				JSONObject lstObjectObject = JSONFactoryUtil.createJSONObject();
				SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil
						.getSPMailTemplate(Long.parseLong(filterValue));
				JSONObject spMailTemplateObject = JSONFactoryUtil.createJSONObject();
				spMailTemplateObject.put("subject", spMailTemplate.getSubject());
				spMailTemplateObject.put("htmlContent", spMailTemplate.getHtmlContent());
				spMailTemplateObject.put("textContent", spMailTemplate.getTextContent());
				spMailTemplateObject.put("templateId", spMailTemplate.getSpMailTemplateId());

				Calendar defaultValueDate = CalendarFactoryUtil.getCalendar(themeDisplay.getUser().getTimeZone(),
						themeDisplay.getUser().getLocale());
				long dayValue = defaultValueDate.get(Calendar.DATE);
				long firstDayOfWeek = defaultValueDate.getFirstDayOfWeek() - 1;
				long monthValue = defaultValueDate.get(Calendar.MONTH);
				long yearValue = defaultValueDate.get(Calendar.YEAR);
				long yearRangeStart = defaultValueDate.get(Calendar.YEAR);
				long yearRangeEnd = defaultValueDate.get(Calendar.YEAR) + 50;
				long hourValue = defaultValueDate.get(Calendar.HOUR);
				long minuteValue = defaultValueDate.get(Calendar.MINUTE);
				long amPmValue = defaultValueDate.get(Calendar.AM_PM);

				spMailTemplateObject.put("dayValue", dayValue);
				spMailTemplateObject.put("firstDayOfWeek", firstDayOfWeek);
				spMailTemplateObject.put("monthValue", monthValue);
				spMailTemplateObject.put("yearValue", yearValue);
				spMailTemplateObject.put("yearRangeStart", yearRangeStart);
				spMailTemplateObject.put("yearRangeEnd", yearRangeEnd);
				spMailTemplateObject.put("hourValue", hourValue);
				spMailTemplateObject.put("minuteValue", minuteValue);
				spMailTemplateObject.put("amPmValue", amPmValue);

				lstObjectObject.put(String.valueOf(spMailTemplate.getSpMailTemplateId()), spMailTemplateObject);
				resourceResponse.getWriter().append(lstObjectObject.toString());
			} catch (PortalException e) {

			} catch (SystemException e) {

			}
		} else if ("fetchTemplateDetailsNew".equalsIgnoreCase(filterName)) {
			long templateId = ParamUtil.getLong(resourceRequest, "templateId");
			try {
				SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(templateId);
				JSONObject data = JSONFactoryUtil.createJSONObject();
				data.put("subject", spMailTemplate.getSubject());
				if (Validator.isNotNull(spMailTemplate.getHtmlContent())) {
					data.put("content", spMailTemplate.getHtmlContent());
				} else {
					data.put("content", spMailTemplate.getTextContent());
				}
				data.put("htmlContent", spMailTemplate.getHtmlContent());
				data.put("textContent", spMailTemplate.getTextContent());

				data.put("templateId", spMailTemplate.getSpMailTemplateId());
				data.put("code", 0);
				resourceResponse.getWriter().append(data.toString());
			} catch (Exception ex) {
				_log.error("Error while getting template details templateId = " + templateId);
			}
		} else if ("fetchEdms".equalsIgnoreCase(filterName)) {
			long campaignId = ParamUtil.getLong(resourceRequest, "campaignId");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			if (campaignId == 0) {
				data.put("code", 1);
				resourceResponse.getWriter().write(data.toString());
				return;
			}
			try {
				SPMailCampaign campaign = SPMailCampaignLocalServiceUtil.getCampaign(campaignId);
				List<SPMailCampaignEDM> edms = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(campaignId);
				JSONArray array = JSONFactoryUtil.createJSONArray();
				for (SPMailCampaignEDM mailEdm : edms) {
					JSONObject edmJson = JSONFactoryUtil.createJSONObject();
					// key's must be equal to names given in jsp. js use this
					// technique to populate values into form fields
					edmJson.put("edmName", mailEdm.getName());
					edmJson.put("edmSeqNo", mailEdm.getSeqNo());
					edmJson.put("edmId", mailEdm.getSpMailCampaignEDMId());
					edmJson.put("mailTemplateId", mailEdm.getSpMailTemplateId());
					edmJson.put("delayAmount", mailEdm.getDelayAmount());
					edmJson.put("delayUnit", mailEdm.getDelayUnit());
					edmJson.put("croneType", mailEdm.getCroneType());
					edmJson.put("dayOfWeek", mailEdm.getDayOfWeek());
					edmJson.put("dayOfMonth", mailEdm.getDayOfMonth());
					String jobStatus = MailSchedularHelper.getJobStatus(campaign, mailEdm.getSeqNo());
					edmJson.put("jobStatus", jobStatus);
					_log.error("edmName " + mailEdm.getName() + " jobStatus " + jobStatus);
					String nextSchdTime = MailSchedularHelper.getNextScheduleTime(mailEdm);
					
					  if(SPScheduleJobStatus.PAUSED.toString().equalsIgnoreCase(jobStatus)){
					 nextSchdTime = "Job is currently paused"; }else
					  if(SPScheduleJobStatus.ACTIVE.toString().equalsIgnoreCase(jobStatus)) {
					// nothing 
						  }else { nextSchdTime = StringPool.BLANK; }
					 
					edmJson.put("nextScheduleTime", nextSchdTime);
					Calendar cal = Calendar.getInstance();
					if(Validator.isNotNull(mailEdm.getNextScheduleDateTime())){
					cal.setTime(mailEdm.getNextScheduleDateTime());
					}

					edmJson.put(resourceResponse.getNamespace() + "scheduleDay", cal.get(Calendar.DAY_OF_MONTH));
					edmJson.put(resourceResponse.getNamespace() + "scheduleMonth", cal.get(Calendar.MONTH));
					edmJson.put(resourceResponse.getNamespace() + "scheduleYear", cal.get(Calendar.YEAR));
					edmJson.put(resourceResponse.getNamespace() + "scheduleHour", cal.get(Calendar.HOUR));
					edmJson.put(resourceResponse.getNamespace() + "scheduleMin", cal.get(Calendar.MINUTE));
					edmJson.put(resourceResponse.getNamespace() + "scheduleAmpm", cal.get(Calendar.AM_PM));
					edmJson.put("scheduleDate", mailEdm.getNextScheduleDateTime());
					_log.error("mailEdm.getNextScheduleDateTime() " + mailEdm.getNextScheduleDateTime());
					array.put(edmJson);
				}
				if (edms.size() == 0) {
					// its old campaign, create main edam with the details
					// available in spcampaign table
					JSONObject edmJson = JSONFactoryUtil.createJSONObject();
					// key's must be equal to names given in jsp. js use this
					// technique to populate values into form fields
					edmJson.put("edmName", "EDM");
					// make edmId 0, when updating it actually a record will be
					// created in new edm table.
					edmJson.put("edmId", "older");
					edmJson.put("mailTemplateId", campaign.getMainTempalteId());
					edmJson.put("delayAmount", StringPool.BLANK);
					edmJson.put("delayUnit", StringPool.BLANK);
					edmJson.put("croneType", MailConst.CRONE_TYPE_ONE_TIME);
					Calendar cal = Calendar.getInstance();
					cal.setTime(campaign.getMainScheduledDate());

					edmJson.put(resourceResponse.getNamespace() + "scheduleDay", cal.get(Calendar.DAY_OF_MONTH));
					edmJson.put(resourceResponse.getNamespace() + "scheduleMonth", cal.get(Calendar.MONTH));
					edmJson.put(resourceResponse.getNamespace() + "scheduleYear", cal.get(Calendar.YEAR));
					edmJson.put(resourceResponse.getNamespace() + "scheduleHour", cal.get(Calendar.HOUR));
					edmJson.put(resourceResponse.getNamespace() + "scheduleMin", cal.get(Calendar.MINUTE));
					edmJson.put(resourceResponse.getNamespace() + "scheduleAmpm", cal.get(Calendar.AM_PM));
					edmJson.put("scheduleDate", campaign.getMainScheduledDate());
					_log.error("edmJson.getNextScheduleDateTime() edms 0 " + campaign.getMainScheduledDate());
					array.put(edmJson);
				}
				data.put("edms", array);
				data.put("code", 0);
			} catch (SystemException ex) {
				data.put("code", "error");
			}
			resourceResponse.getWriter().write(data.toString());
		} else if ("pauseResumeEdm".equalsIgnoreCase(filterName)) {
			long campaignId = ParamUtil.getLong(resourceRequest, "campaignId");
			SPMailCampaign campaign = SPMailCampaignLocalServiceUtil.getCampaign(campaignId);
			long edmId = ParamUtil.getLong(resourceRequest, "edmId");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			try {
				SPMailCampaignEDM edm = SPMailCampaignEDMLocalServiceUtil.getSPMailCampaignEDM(edmId);
				String result = MailSchedularHelper.toggleJob(campaign, edm.getSeqNo());
				data.put("jobStatus", result);
				data.put("code", 0);
			} catch (Exception ex) {

			}
			resourceResponse.getWriter().write(data.toString());
		} else {
			try {
				HashMap<String, String> imageMap = addFileEntry(resourceRequest);

				JSONObject fileUploadObject = JSONFactoryUtil.createJSONObject();
				for (String key : imageMap.keySet()) {
					fileUploadObject.put(key, imageMap.get(key));
				}

				resourceResponse.getWriter().append(fileUploadObject.toString());

			} catch (PortalException e) {

				_log.error(e);
			} catch (SystemException e) {

				_log.error(e);
			}
		}

		// JSONObject data = JSONFactoryUtil.createJSONObject();
		// resourceResponse.getWriter().write(dataString);
	}

	private HashMap<String, String> addFileEntry(ResourceRequest resourceRequest)
			throws IOException, PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String imageUrl = "";
		HashMap<String, String> fileEntryMap = new HashMap<String, String>();
		long folderId = 0;

		if ("imagesUpload".equals(resourceRequest.getParameter("cmd"))) {
			folderId = initFolder(themeDisplay.getScopeGroupId(),
					ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest), "images");

		} else {
			folderId = initFolder(themeDisplay.getScopeGroupId(),
					ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest), "attachments");
		}

		try {
			@SuppressWarnings("rawtypes")
			List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);

			if (items != null) {
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);
					InputStream inputStream = fileItem.getInputStream();
					String mimeType = fileItem.getContentType();
					FileEntry fileEntry = null;

					Calendar cal = Calendar.getInstance();
					String fileName = fileItem.getName().substring(0, fileItem.getName().indexOf("."))
							+ cal.getTimeInMillis() + fileItem.getName().substring(fileItem.getName().indexOf("."),
									fileItem.getName().length());

					fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName,
							mimeType, fileName, StringPool.BLANK, StringPool.BLANK, inputStream, fileItem.getSize(),
							ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest));

					imageUrl = "/documents/" + themeDisplay.getScopeGroupId() + "/" + folderId + "/"
							+ fileEntry.getTitle();
					fileEntryMap.put(String.valueOf(fileEntry.getFileEntryId()), imageUrl);
				}
			}
		} catch (FileUploadException e) {
			_log.error(e);
		}

		return fileEntryMap;
	}

	private long initFolder(long repositoryId, ServiceContext serviceContext, String folderName)
			throws PortalException {
		Folder folder = null;
		long folderId = 0;
		serviceContext.setGroupPermissions(null);
		serviceContext.setGuestPermissions(null);
		long parentFolderId = 0;

		try {
			try {
				parentFolderId = DLAppServiceUtil.getFolder(repositoryId, 0, "SPMailTemplate").getFolderId();
			} catch (Exception e) {
				if (parentFolderId == 0) {
					Folder folderParent = DLAppServiceUtil.addFolder(repositoryId, 0, "SPMailTemplate",
							StringPool.BLANK, serviceContext);
					parentFolderId = folderParent.getFolderId();
				}
			}

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			} catch (NoSuchFolderException e) {

			}

			if (folder == null) {
				folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, folderName, folderName,
						serviceContext);
			}

			if (folder != null) {
				folderId = folder.getFolderId();
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return folderId;
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletPreferences preferences = actionRequest.getPreferences();
		String action = actionRequest.getParameter("action");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if ("createTemplate".equalsIgnoreCase(action)) {
			// String mailTemplateChk =
			// actionRequest.getParameter("mailTemplateChk");
			String byCampaignId = actionRequest.getParameter("byCampaignId");
			String listingPageName = preferences.getValue("listingPageName", StringPool.BLANK);
			String fileEntryId = actionRequest.getParameter("fileEntryId");
			String categoryId = actionRequest.getParameter("categoryId");

			// String mainTemplateId =
			// actionRequest.getParameter("mailTemplateId");

			String campaignType = actionRequest.getParameter("campaignType");

			String campaignName = actionRequest.getParameter("campaignName");

			List<SPMailCampaignEDM> edms = new ArrayList<SPMailCampaignEDM>();
			try {
				long campaignId = 0;
				SPMailCampaign spMailCampaign = null;

				if (Validator.isNotNull(byCampaignId)) {
					campaignId = GetterUtil.getLong(byCampaignId);
					spMailCampaign = SPMailCampaignLocalServiceUtil.getSPMailCampaign(campaignId);
					spMailCampaign.setModifiedDate(DateUtil.newDate());
					spMailCampaign.setModifiedBy(themeDisplay.getUserId());
				} else {
					campaignId = CounterLocalServiceUtil.increment("SPMailCampaign.class");
					spMailCampaign = SPMailCampaignLocalServiceUtil.createSPMailCampaign(campaignId);
					spMailCampaign.setCampaignType(campaignType);
					spMailCampaign.setGroupId(themeDisplay.getScopeGroupId());
					spMailCampaign.setCompanyId(themeDisplay.getCompanyId());
				}
				spMailCampaign.setCampaignName(campaignName);
				spMailCampaign.setCategoryId(Long.parseLong(categoryId));

				try {
					long templateId;
					String edmName;
					int delayAmount;
					long edmId;
					String delayUnit;
					String croneType;
					int dayOfWeek;
					int dayOfMonth;
					String schDate;
					String schTime;

					String PARAM_EDM_SEQ_NO = "edmSeqNo";
					int edmSeqNoLower = ParamUtil.getInteger(actionRequest, "edmSeqNoLower");
					int edmSeqNoHigher = ParamUtil.getInteger(actionRequest, "edmSeqNoHigher");
					boolean changeInScheduleParams = ParamUtil.getBoolean(actionRequest, "rescheduleEdms");

					if (MailConst.CAMPAIGN_TYPE_AUTOMATED.equalsIgnoreCase(spMailCampaign.getCampaignType())) {
						if (spMailCampaign.isNew()) {
							changeInScheduleParams = true;
						} else {
							// in case of edit
							// user selected value
						}
					} else {
						// set to true, to save schedule params.
						// Anyhow in this case, scheduling does not happen upon
						// saving.
						changeInScheduleParams = true;
					}

					SPMailCampaignEDM edm;
					// relativeEdm is used to calculate the schedule time for
					// other edms
					SPMailCampaignEDM relativeEdm = null;
					for (int seqNo = edmSeqNoLower; seqNo <= edmSeqNoHigher; seqNo++) {
						SPMailCampaignEDM spMailCampaignEdm = null;
						int edmSeqNo = ParamUtil.getInteger(actionRequest, PARAM_EDM_SEQ_NO + seqNo);
						_log.debug("edmSeqNo " + edmSeqNo);
						if (edmSeqNo > 0) {
							templateId = ParamUtil.getLong(actionRequest, "mailTemplateId" + seqNo);
							edmName = ParamUtil.getString(actionRequest, "edmName" + seqNo);
							delayAmount = ParamUtil.getInteger(actionRequest, "delayAmount" + seqNo);
							schDate = ParamUtil.getString(actionRequest, "edmStartDate" + seqNo);
							schTime = ParamUtil.getString(actionRequest, "edmStartTime" + seqNo);
							dayOfWeek = ParamUtil.getInteger(actionRequest, "dayOfWeek" + seqNo);
							dayOfMonth = ParamUtil.getInteger(actionRequest, "dayOfMonth" + seqNo);
							delayUnit = ParamUtil.getString(actionRequest, "delayUnit" + seqNo);
							croneType = ParamUtil.getString(actionRequest, "croneType" + seqNo);
							edmId = ParamUtil.getLong(actionRequest, "edmId" + seqNo);
							try{
								spMailCampaignEdm = SPMailCampaignEDMLocalServiceUtil.findByCampaignIdMailType(campaignId, edmSeqNo);
							}catch(Exception e){
								_log.error("New EDM added " + e.getMessage());
							}
							_log.debug(
									"schDate schDate @@@ " + schDate + " delayAmount " + delayAmount + " @@ schTime @@ "
											+ schTime + " ##edmName " + edmName + " %%templateId " + templateId + " edmName " + edmName);
							String format = "MM/dd/yyyy";
							SimpleDateFormat df = new SimpleDateFormat(format);
							Date scheduleDate = new Date();
							if (Validator.isNotNull(schDate)) {
								scheduleDate = df.parse(schDate);
							}
							if (!(dayOfWeek >= 1 && dayOfWeek <= 7)) {
								dayOfWeek = 0;
							}
							if (!(dayOfMonth >= 1 && dayOfMonth <= 31)) {
								dayOfMonth = 0;
							}

							if (edmId > 0) {
								edm = SPMailCampaignEDMLocalServiceUtil.getSPMailCampaignEDM(edmId);
								edm.setModifiedDate(new Date());
							} else {
								edmId = CounterLocalServiceUtil.increment("SPMailCampaignEDM.class");
								edm = SPMailCampaignEDMLocalServiceUtil.createSPMailCampaignEDM(edmId);
								edm.setCreateDate(new Date());
								edm.setModifiedDate(new Date());
								edm.setGroupId(themeDisplay.getScopeGroupId());
								edm.setCompanyId(themeDisplay.getCompanyId());
								edm.setUserId(themeDisplay.getUserId());
							}
							edms.add(edm);
							edm.setName(edmName);
							edm.setSpMailCampaignId(campaignId);
							edm.setSpMailTemplateId(templateId);
							edm.setSeqNo(edmSeqNo);
							boolean isComplete = false;
							if(Validator.isNotNull(spMailCampaignEdm)){
								if((spMailCampaignEdm.getStatus().equalsIgnoreCase("1"))){
									isComplete = true;
								}
							}
							if (changeInScheduleParams && Validator.isNull(spMailCampaignEdm) || changeInScheduleParams && Validator.isNotNull(spMailCampaignEdm) || !changeInScheduleParams && Validator.isNull(spMailCampaignEdm)) {
									if(!isComplete){
										edm.setCroneType(croneType);
										edm.setDelayAmount(delayAmount);
										edm.setDelayUnit(delayUnit);
										edm.setDayOfWeek(dayOfWeek);
										edm.setDayOfMonth(dayOfMonth);
									}	
							}

							if (MailConst.CAMPAIGN_TYPE_AUTOMATED.equalsIgnoreCase(spMailCampaign.getCampaignType())) {
								if (changeInScheduleParams && Validator.isNull(spMailCampaignEdm) || changeInScheduleParams && Validator.isNotNull(spMailCampaignEdm) || !changeInScheduleParams && Validator.isNull(spMailCampaignEdm)) {
										if(!isComplete){
											Calendar nextSchdTime = Calendar.getInstance();
											_log.error("MailCnextSchdTimenextSchdTimeonst @@@@@@" + nextSchdTime.getTime());
											if (relativeEdm != null) {
												nextSchdTime.setTime(relativeEdm.getNextScheduleDateTime());
											}
											boolean canSetTime = true;
											// if delay exists
											if (delayAmount > 0) {
												if (MailConst.DELAY_MINS.equalsIgnoreCase(delayUnit)) {
													nextSchdTime.add(Calendar.MINUTE, delayAmount);
												} else if (MailConst.DELAY_HOURS.equalsIgnoreCase(delayUnit)) {
													nextSchdTime.add(Calendar.HOUR, delayAmount);
												} else if (MailConst.DELAY_DAYS.equalsIgnoreCase(delayUnit)) {
													nextSchdTime.add(Calendar.DATE, delayAmount);
												} else if (MailConst.DELAY_WEEKS.equalsIgnoreCase(delayUnit)) {
													nextSchdTime.add(Calendar.DATE, 7 * delayAmount);
												} else if (MailConst.DELAY_MONTHS.equalsIgnoreCase(delayUnit)) {
													nextSchdTime.add(Calendar.MONTH, delayAmount);
												}
		
												if (croneType.equalsIgnoreCase(MailConst.CRONE_TYPE_ONE_TIME)) {
													if (MailConst.DELAY_MINS.equalsIgnoreCase(delayUnit)
															|| MailConst.DELAY_HOURS.equalsIgnoreCase(delayUnit)) {
														canSetTime = false;
													}
												}
											} else {
												nextSchdTime.setTime(scheduleDate);
											}
											_log.debug("scheduleDate @@@@@@" + scheduleDate);
											Calendar startTime = Calendar.getInstance();
											startTime.setTimeInMillis(nextSchdTime.getTimeInMillis());
											String[] timeVals = schTime.split(":");
											int scheduleHour = 0;
											int scheduleMin = 0;
											String scheduleAmpm = "AM";
											int schAMPMVal = 0;
											if (timeVals.length > 0) {
												scheduleHour = Integer.parseInt(timeVals[0]);
												scheduleMin = Integer.parseInt(timeVals[1].substring(0, 2));
												scheduleAmpm = schTime.substring((schTime.length() - 2), schTime.length());
												if ("PM".equals(scheduleAmpm)) {
													schAMPMVal = 1;
												}
											}
											if (canSetTime) {
												nextSchdTime.set(Calendar.HOUR, scheduleHour);
												// ParamUtil.getInteger(actionRequest,
												// "scheduleHour" + seqNo));
												nextSchdTime.set(Calendar.MINUTE, scheduleMin);
												// ParamUtil.getInteger(actionRequest,
												// "scheduleMin" + seqNo));
												nextSchdTime.set(Calendar.AM_PM, schAMPMVal);
												// ParamUtil.getInteger(actionRequest,
												// "scheduleAmpm" + seqNo));
											}
		
											if (!(dayOfWeek >= 1 && dayOfWeek <= 7)) {
												dayOfWeek = nextSchdTime.get(Calendar.DAY_OF_WEEK);
											}
											if (!(dayOfMonth >= 1 && dayOfMonth <= 31)) {
												dayOfMonth = nextSchdTime.get(Calendar.DAY_OF_MONTH);
											}
											// to make sure, right values are going
											// inside dayofweek, and dayofmonth fields
											if (!MailConst.CRONE_TYPE_WEEKLY.equalsIgnoreCase(croneType)) {
												dayOfWeek = nextSchdTime.get(Calendar.DAY_OF_WEEK);
											}
											if (!MailConst.CRONE_TYPE_MONTHLY.equalsIgnoreCase(croneType)) {
												dayOfMonth = nextSchdTime.get(Calendar.DAY_OF_MONTH);
											}
											edm.setDayOfWeek(dayOfWeek);
											edm.setDayOfMonth(dayOfMonth);
											edm.setNextScheduleDateTime(nextSchdTime.getTime());
											// start scheduling only if campaing type is
											// automated
											// Schedule job only if it is future job.
											// and it must be scheduled atleast 2 min
											// future.
											long scheduleTime = nextSchdTime.getTime().getTime();
											long currentTime = System.currentTimeMillis();
											long threshold = 2 * 60 * 1000;
											boolean canSchedule = true;
											_log.debug("edm.getCroneType() @@@@@@" + edm.getCroneType() + " "
													+ (scheduleTime - currentTime) + " " + threshold);
											if (MailConst.CRONE_TYPE_ONE_TIME.equalsIgnoreCase(edm.getCroneType())
													&& (scheduleTime - currentTime) < threshold) {
												canSchedule = false;
											}
											if (canSchedule) {
												String cronExp = MailSchedularHelper.getCronExp(croneType, dayOfWeek,
														dayOfMonth, nextSchdTime);
												_log.debug("scheduleEDM begin " + startTime.getTime() + " cronExp " + cronExp);
												try {
													long jobEntryId = MailSchedularHelper.scheduleEDM(themeDisplay.getCompanyId(),
															themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
															spMailCampaign, seqNo, cronExp, startTime.getTime(),PortalUtil.getPortalURL(actionRequest));
													// update job status column to sync
													// with
													// quartz job status
													MailSchedularHelper.updateJobStatus(edm,jobEntryId);
												} catch (Exception e) {
													_log.error(
															"Error initializing MailSchedularHelper.schedule or MailSchedularHelper.updateJobStatus "
																	+ e.getMessage());
												}
											}
									}
								}else{
									
								}

							} else {
								// subscription based
								Calendar cal = Calendar.getInstance();
								cal.set(Calendar.HOUR, ParamUtil.getInteger(actionRequest, "scheduleHour" + seqNo));
								cal.set(Calendar.MINUTE, ParamUtil.getInteger(actionRequest, "scheduleMin" + seqNo));
								cal.set(Calendar.AM_PM, ParamUtil.getInteger(actionRequest, "scheduleAmpm" + seqNo));
								// in this case ( subscription based)
								// NextScheduleDate used to hold hour , min and
								// ampm value. the date is of no use.
								edm.setNextScheduleDateTime(cal.getTime());
								// if campaign is subscription basis, scheduling
								// happens by whenever user subscribes to it.
								// check method	
								// SPMailCampaignLocalServiceImpl.subscribeToCampaign
								//SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
							}

							// first edm , will be treated as main edm. this
							// will be stored in mailCampaing table as well.
							if (seqNo == edmSeqNoLower) {
								spMailCampaign.setMainTempalteId(templateId);
								spMailCampaign.setMainScheduledDate(edm.getNextScheduleDateTime());
								// schedule(campaignId, cal,
								// SPMailType.MAIN.ordinal()); // dont schedule
								// here.. all edsm scheduled above
							}

							relativeEdm = edm;
						}
					}

				} catch (Exception ex) {
					_log.error("Error creating campaign " + ex.getMessage());
				}
	
				Calendar todayTime = Calendar.getInstance();

				int min = todayTime.get(Calendar.MINUTE) + 2;
				int hour = todayTime.get(Calendar.HOUR);

				if (min > 59) {
					min = 60 - min;
					hour++;

				}

				todayTime.set(Calendar.HOUR, hour);
				todayTime.set(Calendar.MINUTE, min);

				boolean scheduleChkFlag = true;
				String scheduleErrorMessage = "Schedule for";

				if (Validator.isNotNull(fileEntryId)) {
					spMailCampaign.setDlFileEntryId(Long.valueOf(fileEntryId));
				}
				if (scheduleChkFlag) {
					if (Validator.isNotNull(byCampaignId)) {
						SPMailCampaignLocalServiceUtil.updateSPMailCampaign(spMailCampaign);
					} else {
						spMailCampaign.setCreateBy(themeDisplay.getUserId());
						spMailCampaign.setCreateDate(DateUtil.newDate());
						SPMailCampaignLocalServiceUtil.addSPMailCampaign(spMailCampaign);
					}
					for (SPMailCampaignEDM edm : edms) {
						if (edm.isNew()) {
							SPMailCampaignEDMLocalServiceUtil.addSPMailCampaignEDM(edm);
						} else {
							SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(edm);
						}
					}
					actionResponse.sendRedirect(PortalUtil.getPortalURL(actionRequest) + StringPool.FORWARD_SLASH
							+ listingPageName + "?flag=success");
				} else {
					scheduleErrorMessage += " should set 2 min later from current time.";
					actionRequest.setAttribute("scheduleErrorMessage", scheduleErrorMessage);
					actionRequest.setAttribute("campaignName", campaignName);
					actionRequest.setAttribute("categoryId", categoryId);

					actionResponse.setRenderParameter("yearValuemain",
							ParamUtil.getString(actionRequest, "mailTemplateYear"));
					actionResponse.setRenderParameter("monthValuemain",
							ParamUtil.getString(actionRequest, "mailTemplateMonth"));
					actionResponse.setRenderParameter("dayValuemain",
							ParamUtil.getString(actionRequest, "mailTemplateDay"));
					actionResponse.setRenderParameter("hourValuemain",
							ParamUtil.getString(actionRequest, "mailTemplateHour"));
					actionResponse.setRenderParameter("minuteValuemain",
							ParamUtil.getString(actionRequest, "mailTemplateMin"));
					actionResponse.setRenderParameter("amPmValuemain",
							ParamUtil.getString(actionRequest, "mailTemplateAmpm"));

					if (Validator.isNotNull(actionRequest.getParameter("mailTemplateChk"))) {
						actionResponse.setRenderParameter("mailTemplateChk", String.valueOf(true));
					}

					actionRequest.setAttribute("mailTemplateId", actionRequest.getParameter("mailTemplateId"));

					actionResponse.setRenderParameter("yearValuerem1",
							ParamUtil.getString(actionRequest, "reminder1Year"));
					actionResponse.setRenderParameter("monthValuerem1",
							ParamUtil.getString(actionRequest, "reminder1Month"));
					actionResponse.setRenderParameter("dayValuerem1",
							ParamUtil.getString(actionRequest, "reminder1Day"));
					actionResponse.setRenderParameter("hourValuerem1",
							ParamUtil.getString(actionRequest, "reminder1Hour"));
					actionResponse.setRenderParameter("minuteValuerem1",
							ParamUtil.getString(actionRequest, "reminder1Min"));
					actionResponse.setRenderParameter("amPmValuerem1",
							ParamUtil.getString(actionRequest, "reminder1Ampm"));
					if (Validator.isNotNull(actionRequest.getParameter("reminder1Chk"))) {
						actionResponse.setRenderParameter("reminder1Chk", String.valueOf(true));
					}

					actionRequest.setAttribute("reminder1Id", actionRequest.getParameter("reminder1Id"));

					actionResponse.setRenderParameter("scheduleErrorMessage", scheduleErrorMessage);
					actionResponse.setRenderParameter("byCampaignId", byCampaignId);

				}

			} catch (Exception e) {
				_log.equals(e);
			}

		} else if ("editTemplate".equalsIgnoreCase(action)) {
			String chkEnableRem1 = actionRequest.getParameter("chkEnableRem1");
			String chkEnableRem2 = actionRequest.getParameter("chkEnableRem2");
			String chkEnableRem3 = actionRequest.getParameter("chkEnableRem3");
			String chkEnableThankYou = actionRequest.getParameter("chkEnableThankYou");
			String chkEnableMissYou = actionRequest.getParameter("chkEnableMissYou");
			String listingPageName = actionRequest.getParameter("listingPageName");
			String categoryName = actionRequest.getParameter("categoryName");
			preferences.setValue("chkEnableRem1", chkEnableRem1);
			preferences.setValue("chkEnableRem2", chkEnableRem2);
			preferences.setValue("chkEnableRem3", chkEnableRem3);
			preferences.setValue("chkEnableThankYou", chkEnableThankYou);
			preferences.setValue("chkEnableMissYou", chkEnableMissYou);
			preferences.setValue("listingPageName", listingPageName);
			preferences.setValue("categoryName", categoryName);
			preferences.store();


			actionResponse.setPortletMode(PortletMode.VIEW);

		}
	}

}
