package com.sambaash.platform.portlet.spmail.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
//import sambaash.platform.util.SchedulerUtil;
import com.sambaash.platform.portlet.spmail.util.MailSchedularHelper;
import com.sambaash.platform.srv.filter.model.SPSearchFilter;
import com.sambaash.platform.srv.filter.service.SPSearchFilterLocalServiceUtil;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;
import com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

//import net.redhogs.cronparser.CronExpressionDescriptor;

/**
 * Portlet implementation class SPMailCampaignListingAction
 */
public class SPMailCampaignListingAction extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignListingAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		String successMessage = httpRequest.getParameter("flag");

		if (Validator.isNotNull(successMessage)) {
			renderRequest.setAttribute("updateMessage", true);
		}

		// get campaign list

		List<SPMailCampaign> lstSPMailCampaign = null;
		int totalCount = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = renderRequest.getPreferences();
		String chkEnableRem1 = preferences.getValue("chkEnableRem1", StringPool.FALSE);
		String chkEnableRem2 = preferences.getValue("chkEnableRem2", StringPool.FALSE);
		String chkEnableRem3 = preferences.getValue("chkEnableRem3", StringPool.FALSE);
		String chkEnableThankYou = preferences.getValue("chkEnableThankYou", StringPool.FALSE);
		String chkEnableMissYou = preferences.getValue("chkEnableMissYou", StringPool.FALSE);
		int totalCol = 8;

		if (Validator.isNotNull(chkEnableRem1)) {
			_log.info("doview chkEnableRem1 " + chkEnableRem1);
			renderRequest.setAttribute("chkEnableRem1", chkEnableRem1);
			totalCol++;
		}

		if (Validator.isNotNull(chkEnableRem2)) {
			renderRequest.setAttribute("chkEnableRem2", chkEnableRem2);
			totalCol++;
		}

		if (Validator.isNotNull(chkEnableRem3)) {
			_log.info("chkEnableRem3 " + chkEnableRem3);
			renderRequest.setAttribute("chkEnableRem3", chkEnableRem3);
			totalCol++;
		}

		if (Validator.isNotNull(chkEnableThankYou)) {
			renderRequest.setAttribute("chkEnableThankYou", chkEnableThankYou);
			totalCol++;
		}

		if (Validator.isNotNull(chkEnableMissYou)) {
			renderRequest.setAttribute("chkEnableMissYou", chkEnableMissYou);
			totalCol++;
		}

		try {
			if (SPMailCampaignLocalServiceUtil.getSPMailCampaignsCount() < 20) {
				lstSPMailCampaign = SPMailCampaignLocalServiceUtil.getActiveCampaigns(0,
						SPMailCampaignLocalServiceUtil.getSPMailCampaignsCount());
				totalCount = 1;
			} else {
				totalCount = SPMailCampaignLocalServiceUtil.getSPMailCampaignsCount() / 20;
				lstSPMailCampaign = SPMailCampaignLocalServiceUtil.getActiveCampaigns(0, 20);

				if ((SPMailCampaignLocalServiceUtil.getSPMailCampaignsCount() % 20) != 0) {
					totalCount += 1;
				}
			}

			_log.error("totalCount : " + totalCount);
			renderRequest.setAttribute("totalCount", totalCount);
			renderRequest.setAttribute("createPageName", preferences.getValue("createPageName", StringPool.BLANK));
			renderRequest.setAttribute("favCreatePageName", preferences.getValue("favCreatePageName", StringPool.BLANK));
			if (lstSPMailCampaign != null) {
				renderRequest.setAttribute("lstSPMailCampaign", lstSPMailCampaign);
			}

			renderRequest.setAttribute("scheduleIcon", "/SPMail-portlet/images/subscribe.png");
			renderRequest.setAttribute("previewIcon", "/SPMail-portlet/images/Preview01.png");
			renderRequest.setAttribute("textcontentIcon", "/SPMail-portlet/images/texticon.png");
			renderRequest.setAttribute("archiveIcon", "/SPMail-portlet/images/archive.png");

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		// end campaign list

		renderRequest.setAttribute("totalCol", totalCol);

		// get SP search filter List

		//List<SPSearchFilter> lstSPSearchFilter = new ArrayList<SPSearchFilter>();
		List<GSFavourite> lstSPSearchFilter = new ArrayList<GSFavourite>();

		try {
			//lstSPSearchFilter = SPSearchFilterLocalServiceUtil.getSPSearchFilters(0,
			//		SPSearchFilterLocalServiceUtil.getSPSearchFiltersCount());
			
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/"+preferences.getValue("favCreatePageName", StringPool.BLANK));
			lstSPSearchFilter = GSFavouriteLocalServiceUtil.findAll(themeDisplay.getUserId(),layout.getPlid());
			renderRequest.setAttribute("lstSPSearchFilter", lstSPSearchFilter);
			
		} catch (Exception e) {
			_log.error("No List for SPSearchFilter" + e);
		}

		// end

		renderRequest.setAttribute("hasAccess",
				(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
						|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())));

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String templatePage = preferences.getValue("createPageName", StringPool.BLANK);
		String favCreatePage = preferences.getValue("favCreatePageName", StringPool.BLANK);
		String chkEnableRem1 = preferences.getValue("chkEnableRem1", StringPool.FALSE);
		String chkEnableRem2 = preferences.getValue("chkEnableRem2", StringPool.FALSE);
		String chkEnableRem3 = preferences.getValue("chkEnableRem3", StringPool.FALSE);
		String chkEnableThankYou = preferences.getValue("chkEnableThankYou", StringPool.FALSE);
		String chkEnableMissYou = preferences.getValue("chkEnableMissYou", StringPool.FALSE);

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

		renderRequest.setAttribute("createPageName", templatePage);
		renderRequest.setAttribute("favCreatePageName", favCreatePage);
		

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String filterName = resourceRequest.getParameter("filterName");
		String filterValue = resourceRequest.getParameter("filterValue");

		if ("get".equals(filterName)) {
			JSONObject lstObject = JSONFactoryUtil.createJSONObject();
			try {
				JSONObject spMailCampaignObject = JSONFactoryUtil.createJSONObject();
				spMailCampaignObject.put("subject",
						SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(filterValue)).getSubject());
				spMailCampaignObject.put("htmlContent",
						SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(filterValue)).getHtmlContent());
				spMailCampaignObject.put("textContent",
						SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(filterValue)).getTextContent());
				lstObject.put(filterValue, spMailCampaignObject);
				resourceResponse.getWriter().append(lstObject.toString());
			} catch (Exception e) {
				_log.error(e);
			}

		} else if ("addByFilter".equals(filterName)) {
			try {
				long filterId = Long.valueOf(filterValue);
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long campaignId = Long.valueOf(resourceRequest.getParameter("campaignId"));
				GSFavourite favourite;
				favourite = GSFavouriteLocalServiceUtil.getGSFavourite(filterId);
				addUsersByFavourite(-1, -1, favourite, themeDisplay, campaignId);
				//addSubscribersByFilter(campaignId, filterId, themeDisplay);
				resourceResponse.getWriter().append("Successfully added.");
			} catch (PortalException | SystemException e) {
				_log.error(e);
			} 
		} else if ("pageChange".equals(filterName)) {
			JSONObject lstObjectObject = JSONFactoryUtil.createJSONObject();
			int count = 0;
			int order = 0;
			List<SPMailCampaign> lstMailCampaign = null;

			try {
				if (Integer.valueOf(filterValue) == 1) {
					count = 0;
					// lstMailCampaign =
					// SPMailCampaignLocalServiceUtil.getActiveCampaigns(count,
					// 20);

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailCampaign.class);
					dynamicQuery.add(PropertyFactoryUtil.forName("archive").eq(new Boolean(false)));
					dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
					lstMailCampaign = SPMailCampaignLocalServiceUtil.dynamicQuery(dynamicQuery, count, 20);
					_log.info("lstMailCampaign " + lstMailCampaign.size());
				} else {
					count = (Integer.valueOf(filterValue) - 1) * 20;
					// lstMailCampaign =
					// SPMailCampaignLocalServiceUtil.getActiveCampaigns(count,
					// (Integer.valueOf(filterValue) * 20));

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailCampaign.class);
					dynamicQuery.add(PropertyFactoryUtil.forName("archive").eq(new Boolean(false)));
					dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
					lstMailCampaign = SPMailCampaignLocalServiceUtil.dynamicQuery(dynamicQuery, count,
							(Integer.valueOf(filterValue) * 20));
				}
				for (int l=0;l<lstMailCampaign.size();l++){//SPMailCampaign spMailCampaign : lstMailCampaign) {
					JSONObject spMailTemplateObject = JSONFactoryUtil.createJSONObject();
					spMailTemplateObject.put("id", lstMailCampaign.get(l).getSpMailCampaignId());
					spMailTemplateObject.put("campaignName", lstMailCampaign.get(l).getCampaignName());
					spMailTemplateObject.put("sendDate", lstMailCampaign.get(l).getSentDate());

					if (lstMailCampaign.get(l).getStatus() == SPMailStatus.NOT_SCHEDULED.getStatus()) {
						spMailTemplateObject.put("status", SPMailStatus.NOT_SCHEDULED.getValue());
					} else if (lstMailCampaign.get(l).getStatus() == SPMailStatus.SCHEDULED.getStatus()) {
						spMailTemplateObject.put("status", SPMailStatus.SCHEDULED.getValue());
					} else if (lstMailCampaign.get(l).getStatus() == SPMailStatus.PROCESSING.getStatus()) {
						spMailTemplateObject.put("status", SPMailStatus.PROCESSING.getValue());
					} else if (lstMailCampaign.get(l).getStatus() == SPMailStatus.SENT.getStatus()) {
						spMailTemplateObject.put("status", SPMailStatus.SENT.getValue());
					} else {
						spMailTemplateObject.put("status", StringPool.BLANK);
					}
					try {
						List<SPMailCampaignEDM> edms = SPMailCampaignEDMLocalServiceUtil
								.findByCampaignId(lstMailCampaign.get(l).getSpMailCampaignId());
						JSONObject jsonEdm;
						JSONArray jsonEdmArray = JSONFactoryUtil.createJSONArray();
						for (SPMailCampaignEDM edm : edms) {
							jsonEdm = JSONFactoryUtil.createJSONObject();
							String jobName = MailSchedularHelper.getJobNameEDM(lstMailCampaign.get(l).getSpMailCampaignId(),
									edm.getSeqNo());
							Calendar nextSchdTime = Calendar.getInstance();
							nextSchdTime.setTime(edm.getNextScheduleDateTime());
							// SPJobEntryLocalServiceUtil.
							String cronExp = MailSchedularHelper.getCronExp(edm.getCroneType(), edm.getDayOfWeek(),
									edm.getDayOfMonth(), nextSchdTime);
							String readableDate = getReadableText(cronExp);

							jsonEdm.put("nextScheduleTime", edm.getNextScheduleDateTime());// MailSchedularHelper.getNextScheduleTime(edm));
							jsonEdm.put("name", edm.getName());
							jsonEdm.put("templateId", edm.getSpMailTemplateId());
							List<SPJobEntry> jobentryList = SPJobEntryLocalServiceUtil.findByJobNameAndJobClass(jobName,
									MailSchedularHelper.JOB_CLASS_EDM);
							String sentDate = StringPool.BLANK;
							for (SPJobEntry jobEntry : jobentryList) {
								jsonEdm.put("status", SPScheduleJobStatus.stringValue(jobEntry.getStatus()));
								_log.info("name " + edm.getName() + " status " + jobEntry.getStatus());
								String statusMsg = jobEntry.getStatusMsg();
								String[] statusMsgArray = statusMsg.split("New Job");
								for (String statusMsg1 : statusMsgArray) {
									String[] statusMsg1Array = statusMsg1.split("<br/>");
									for (String scMsg : statusMsg1Array) {
										if (scMsg.contains("Success")) {
											int successIndex = scMsg.indexOf("Success");
											if (sentDate.isEmpty()) {
												sentDate = scMsg.substring(successIndex + 10, successIndex + 31);
											} else {
												sentDate = sentDate + StringPool.SPACE + StringPool.BACK_SLASH
														+ StringPool.SPACE
														+ scMsg.substring(successIndex + 10, successIndex + 31);
											}
										}
									}
								}
							}
							jsonEdm.put("sentDate", sentDate);
							jsonEdmArray.put(jsonEdm);
						}
						spMailTemplateObject.put("edms", jsonEdmArray);
					} catch (Exception ex) {
						_log.error("Error while getting edms for campaignId = " + lstMailCampaign.get(l).getSpMailCampaignId());
					}
					spMailTemplateObject.put("mainSchedule", lstMailCampaign.get(l).getMainScheduledDate());
					spMailTemplateObject.put("rem1Schedule", lstMailCampaign.get(l).getRem1ScheduledDate());
					spMailTemplateObject.put("rem2Schedule", lstMailCampaign.get(l).getRem2ScheduledDate());
					spMailTemplateObject.put("rem3Schedule", lstMailCampaign.get(l).getRem3ScheduledDate());
					spMailTemplateObject.put("thankYouSchedule", lstMailCampaign.get(l).getThankYouScheduledDate());
					spMailTemplateObject.put("missYouSchedule", lstMailCampaign.get(l).getMissedyouScheduledDate());

					long rsvpId = lstMailCampaign.get(l).getRsvpId();

					if (rsvpId != 0) {
						spMailTemplateObject.put("rsvpName", RsvpLocalServiceUtil.getRsvp(rsvpId).getTitle());
					} else {
						spMailTemplateObject.put("rsvpName", "No Rsvp");
					}
					spMailTemplateObject.put("order", order);
					order = order+1;
					lstObjectObject.put(String.valueOf(lstMailCampaign.get(l).getSpMailCampaignId()), spMailTemplateObject);
				}

				resourceResponse.getWriter().append(lstObjectObject.toString());
			} catch (Exception e) {
				_log.error(e.getMessage());
			}

		} else if ("archive".equalsIgnoreCase(filterName)) {
			long spMailCampaignId = Long.valueOf(filterValue);
			archive(spMailCampaignId);
			resourceResponse.getWriter().append("success");
		}
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();
		if ("uploadFiles".equalsIgnoreCase(action)) {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File[] files = uploadPortletRequest.getFiles("filesToUpload");
			long campaignId = Long.valueOf(uploadPortletRequest.getParameter("campaignId"));
			String campaignNameIp = uploadPortletRequest.getParameter("campaignNameIp");
			actionRequest.setAttribute("campaignId", campaignId);
			actionRequest.setAttribute("campaignNameIp", campaignNameIp);
			HashMap<String, Object> result = new HashMap<String, Object>();
			try {
				long folderId = getFolderId(themeDisplay.getScopeGroupId(), String.valueOf(campaignId),
						ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest));

				String error = StringPool.BLANK;
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MINUTE, 3);
				int diffBetweenNextJob = 1;

				if (files.length > 1) {
					diffBetweenNextJob = 5;
				}

				for (File file : files) {

					String mimeType = StringPool.BLANK;
					String extension = StringPool.BLANK;

					if (file.getName().endsWith(EXCEL.EXTENSION)) {
						mimeType = EXCEL.MIME_TYPE;
						extension = EXCEL.EXTENSION;
					} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
						mimeType = EXCEL.MIME_TYPE_OLD;
						extension = EXCEL.EXTENSION_OLD;
					} else {
						throw new FileExtensionException();
					}

					String fileName = "ExcelUplaod-" + cal.getTimeInMillis() + extension;

					FileEntry fielEntry;
					try {
						fielEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName,
								mimeType, fileName, file.getName(), StringPool.BLANK, file,
								ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest));
						_log.info(" campaignId" + campaignId + " fielEntry " + fielEntry.getFileEntryId());
						schedule(campaignId, themeDisplay.getUserId(), fielEntry.getFileEntryId(), cal);
						cal.add(Calendar.MINUTE, diffBetweenNextJob);
						_log.info("upload of xsl schedule time " + cal.getTime());
					} catch (Exception e) {
						_log.error(
								"Error occured while uplaoding file : " + file.getName() + " " + e.getMessage());
						error = error + file.getName() + " \n";

					}

				}

				if (Validator.isNotNull(error)) {
					result.put("error", error);
				}
				actionRequest.setAttribute("subscriberaddedCampaign",true);
				actionRequest.setAttribute("successMsgTemplate",true);
			} catch (Exception e1) {
				_log.error(e1);
				result.put("errorRow", "Error occured for folder setup.");
			}
		} else if ("editListingPreference".equalsIgnoreCase(action)) {

			String createPageName = actionRequest.getParameter("createPageName");
			String favCreatePageName = actionRequest.getParameter("favCreatePageName");
			String chkEnableRem1 = actionRequest.getParameter("chkEnableRem1");
			String chkEnableRem2 = actionRequest.getParameter("chkEnableRem2");
			String chkEnableRem3 = actionRequest.getParameter("chkEnableRem3");
			String chkEnableThankYou = actionRequest.getParameter("chkEnableThankYou");
			String chkEnableMissYou = actionRequest.getParameter("chkEnableMissYou");

			preferences.setValue("createPageName", createPageName);
			preferences.setValue("favCreatePageName", favCreatePageName);
			preferences.setValue("chkEnableRem1", chkEnableRem1);
			preferences.setValue("chkEnableRem2", chkEnableRem2);
			preferences.setValue("chkEnableRem3", chkEnableRem3);
			preferences.setValue("chkEnableThankYou", chkEnableThankYou);
			preferences.setValue("chkEnableMissYou", chkEnableMissYou);

			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		}
	}

	/** modified by Harini as advcied by Naresh **/
	private void schedule(long campaignId, long userId, long fileEntryId, Calendar schedule) {
		Map<String, Object> mapMsg = new HashMap<String, Object>();
		mapMsg.put("campaignId", String.valueOf(campaignId));
		mapMsg.put("userId", String.valueOf(userId));
		mapMsg.put("fileEntryId", String.valueOf(fileEntryId));
		mapMsg.put(SPSchedulerConstants.START_DATE, schedule.getTime());
		String uploadXslDEtails = "list for campaign " + campaignId;
		SPJobEntryLocalServiceUtil.schedule(portletId, _schedulerClassName, "Upload subscription list", schedule,
				uploadXslDEtails, mapMsg);
		// SchedulerUtil.schedule(
		// portletId,
		// _schedulerClassName,
		// schedule,
		// String.valueOf(campaignId) + StringPool.COLON +
		// String.valueOf(fileEntryId) + StringPool.DASH
		// + String.valueOf(userId) + "-Upload",mapMsg);

	}

	private long getFolderId(long scopeGroupId, String campaignId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Folder folder = null;

		try {
			folder = DLAppServiceUtil.getFolder(scopeGroupId, 0, FOLDER_NAME);
			return folder.getFolderId();
		} catch (Exception e) {

		}

		folder = DLAppServiceUtil.addFolder(scopeGroupId, 0, FOLDER_NAME, "Folder for  " + FOLDER_NAME, serviceContext);
		return folder.getFolderId();

	}
	
	private void addUsersByFavourite(int start, int end, GSFavourite favourite, ThemeDisplay themeDisplay, long campaignId){
		List<Document> docs = GSFavouriteLocalServiceUtil.searchByFavourite(start, end, favourite);
		addIndividualProfiles(campaignId, docs, themeDisplay);
	}

	/*private void addSubscribersByFilter(long spMailCampaignId, long spSearchFilterId, ThemeDisplay themeDisplay) {
		try {
			SPSearchFilter spSearchFilter = SPSearchFilterLocalServiceUtil.getSPSearchFilter(spSearchFilterId);

			if (spSearchFilter != null) {
				String paramString = spSearchFilter.getFilterParameter();
				String[] filterParamArray = paramString.split(",");
				String indexerClassName = "com.sambaash.platform.srv.spsocialprofile.model.SocialProfile";
				String bcoValue = "and";
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("occur", filterParamArray[0]);
				paramsMap.put("clause", filterParamArray[1]);
				paramsMap.put("q", filterParamArray[2]);
				paramsMap.put("indexerClassName", indexerClassName);
				paramsMap.put("bcoValue", bcoValue);

				String[] occurArray = StringUtil.split(filterParamArray[0], StringPool.DASH);
				String[] clauseArray = StringUtil.split(filterParamArray[1], StringPool.DASH);
				String[] qArray = StringUtil.split(filterParamArray[2], StringPool.DASH);

				SearchContext searchContext = new SearchContext();
				searchContext.setCompanyId(themeDisplay.getCompanyId());
				Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
				Sort[] sorts = new Sort[] { sort };
				searchContext.setSorts(sorts);
				List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();

				if (occurArray.length > 0) {
					BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);

					for (int i = 0; i < occurArray.length; i++) {
						BooleanQuery _booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						String _clause = clauseArray[i];
						String _q = qArray[i];

						_booleanQuery.addRequiredTerm(_clause, _q);

						if ("and".equalsIgnoreCase(bcoValue)) {
							fullQuery.add(_booleanQuery, BooleanClauseOccur.MUST.getName());
						} else {
							fullQuery.add(_booleanQuery, BooleanClauseOccur.SHOULD.getName());
						}
					}

					BooleanClause _booleanClause = BooleanClauseFactoryUtil.create(searchContext, fullQuery,
							BooleanClauseOccur.MUST.getName());
					booleanClauseList.add(_booleanClause);
				}

				BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];

				for (int i = 0; i < booleanClauseList.size(); i++) {
					booleanClauses[i] = booleanClauseList.get(i);
				}

				searchContext.setBooleanClauses(booleanClauses);

				Hits results;
				Indexer indexer = IndexerRegistryUtil.getIndexer(indexerClassName);
				results = indexer.search(searchContext);
				addIndividualProfiles(spMailCampaignId, results, themeDisplay);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}*/

	public void addIndividualProfiles(long spMailCampaignId, List<Document> results, ThemeDisplay themeDisplay) {
		try {
			List<SPMailCampaignEDM>edms = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(spMailCampaignId);
			for (int i = 0; i < results.size(); i++) {
				Document doc = results.get(i);

				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String firstName = doc.get("firstName");
				String lastName = doc.get("lastName");
				String emailAddress = doc.get("emailAddress");

				if(edms.size() > 0){
				for (SPMailCampaignEDM spMailCampaignEDM : edms) {
				long spSubId = CounterLocalServiceUtil.increment("SPMailCampaignSubscribers.class");
				SPMailCampaignSubscribers sp = SPMailCampaignSubscribersLocalServiceUtil
						.createSPMailCampaignSubscribers(spSubId);

				Calendar cal = Calendar.getInstance();

				sp.setFirstName(firstName);
				sp.setLastName(lastName);
				sp.setEmailAddress(emailAddress);
				sp.setCreateBy(themeDisplay.getUserId());
				sp.setSpMailCampaignId(spMailCampaignId);
				sp.setSpMailType((int) spMailCampaignEDM.getSeqNo());
				sp.setUserId(userId);
				sp.setCreateDate(cal.getTime());
				sp.setParentSubscriberId(0);
				SPMailCampaignSubscribersLocalServiceUtil.addSPMailCampaignSubscribers(sp);
				}
				}

			}

		} catch (Exception e) {
			_log.error(e);
		}

	}

	private void archive(long spMailCampaignId) {
		try {
			SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil.getSPMailCampaign(spMailCampaignId);
			spMailCampaign.setArchive(true);
			SPMailCampaignLocalServiceUtil.updateSPMailCampaign(spMailCampaign);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	private String getReadableText(String cronExpression) {
		String str = "";
		try {
			String[] arr = cronExpression.split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, Integer.parseInt(arr[4]));
			cal.set(Calendar.YEAR, Integer.parseInt(arr[6]));
			cal.set(Calendar.DATE, Integer.parseInt(arr[3]));
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(arr[2]));
			cal.set(Calendar.MINUTE, Integer.parseInt(arr[1]));
			cal.set(Calendar.SECOND, Integer.parseInt(arr[0]));
			str = sdf.format(cal.getTime());
		} catch (Exception e) {
			_log.error("Error while parsing cronExpression");
			return cronExpression;
		}
		return str;
	}

	private static final String FOLDER_NAME = "CampaignExcelFiles";
	private static final String portletId = "SPMailCampaignListing_WAR_SPMailportlet";
	private static final String _schedulerClassName = "com.sambaash.platform.portlet.spmail.listener.UploadExcelJob";

}
