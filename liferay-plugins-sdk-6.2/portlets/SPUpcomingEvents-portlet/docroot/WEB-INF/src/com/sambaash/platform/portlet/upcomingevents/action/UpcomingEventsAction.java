package com.sambaash.platform.portlet.upcomingevents.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.upcomingevents.wrapper.UpcomingEventsWrapper;
import com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException;
import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;
import com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class UpcomingEventsAction
 */
public class UpcomingEventsAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long profileUserId = getProfileUserId(themeDisplay);
		String careerpath = getCareerPathUrl(profileUserId);
		renderRequest.setAttribute("careerpath", careerpath);
		PortletPreferences preferences = renderRequest.getPreferences();
		String vocabularyList = preferences.getValue("searchCriteriaVoc", StringPool.BLANK);
		String searchArea = preferences.getValue("eventsListCriteria", StringPool.BLANK);
		renderRequest.setAttribute("vocabularyList", vocabularyList);
		renderRequest.setAttribute("searchArea", searchArea);
		String processId = preferences.getValue("processId", "0");
		String processName = StringPool.BLANK;
		if(Validator.isNotNull(processId) && processId != ""){
			if(Long.parseLong(processId) > 0){
				try {
					PEProcess peProcess = PEProcessLocalServiceUtil.getPEProcess(Long.parseLong(processId));
					processName = peProcess.getName();
				} catch (NumberFormatException | PortalException | SystemException e) {
					_log.error(e.getMessage());
				}
			}
		}	else{
			processId = "0";
		}
		renderRequest.setAttribute("processName", processName);
		renderRequest.setAttribute("processId", processId);
		String searchByDomainValues = StringPool.BLANK;
		/**try {
			if("Functional Group".equalsIgnoreCase(searchArea)){
				List<UpcomingEventsWrapper> upcomingEventsWrappers = getUpcomingEventsWrappers(themeDisplay, profileUserId);
				renderRequest.setAttribute("upcomingEventsWrappers", upcomingEventsWrappers);
				if (upcomingEventsWrappers.size() == 0) {
					renderRequest.setAttribute("showNoAvailableMessage", true);
				}
			}else{
				searchByDomainValues = getDomainAreas(themeDisplay,processId);
				_log.error("searchByDomainValues " + searchByDomainValues);
				List<UpcomingEventsWrapper> upcomingEventsWrappersForDomain= getUpcomingEventsWrappersForDomain(themeDisplay,vocabularyList,searchByDomainValues);//"Build and maintain effective sales relationship,Build and deliver customer service and customer care support"
				renderRequest.setAttribute("upcomingEventsWrappers", upcomingEventsWrappersForDomain);
				if (upcomingEventsWrappersForDomain.size() == 0) {
					renderRequest.setAttribute("showNoAvailableMessage", true);
				}
			}
			
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}**/

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		
		super.processAction(actionRequest, actionResponse);
	}

	private long getProfileUserId(ThemeDisplay themeDisplay) {
		long remoteUserId = themeDisplay.getUserId();
		String friendlyURL = themeDisplay.getURLCurrent();
		long companyId = themeDisplay.getCompanyId();
		long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
		if (profileUserId == 0) {
			profileUserId = remoteUserId;
		}
		return profileUserId;
	}

	private String getCareerPathUrl(long userId) {
		String careerPathUrl = "";
		long careerPathUrlId = 0;
		SPListType spList = null;
		try {
			SPJobRole jobRole = SPJobRoleLocalServiceUtil.findByJobRole(userId);
			if (jobRole != null) {
				careerPathUrlId = jobRole.getCareerPathId();
				spList = SPListTypeLocalServiceUtil.getSPListType(careerPathUrlId);
				careerPathUrl = spList.getItemValue();
			}
		} catch (Exception e) {
			if (e instanceof NoSuchSPJobRoleException) {
				// do nothing
			} else {
				_log.error(e.getMessage(), e);
			}
		}
		return careerPathUrl;
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long profileUserId = getProfileUserId(themeDisplay);
		String currentPageStr = resourceRequest.getParameter("currentPage");
		String type = resourceRequest.getParameter("action");
		int currentPage = 0;
		if(Validator.isNotNull(currentPageStr)){
			currentPage = Integer.valueOf(currentPageStr);
		}
		int pageItems = 3;
		int count = 0;
		JSONObject data = JSONFactoryUtil.createJSONObject();
		JSONArray items = JSONFactoryUtil.createJSONArray();
		JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();
		
		if("saveSearchCriterias".equalsIgnoreCase(type)){
			PortletPreferences prefs = resourceRequest.getPreferences();
			
			String eventsListCriteria = ParamUtil.getString(resourceRequest,"eventsListCriteria");
			String[] searchCriteriaVoc = ParamUtil.getParameterValues(resourceRequest,"searchCriteriasVocabularySelect");
			String processId = ParamUtil.getString(resourceRequest,"processId");
			
			String searchCriteria = StringPool.BLANK;
			for (int f = 0; f < searchCriteriaVoc.length; f++) {
				searchCriteria = searchCriteriaVoc[f] + "," + searchCriteria;
			} 

			
			prefs.setValue("eventsListCriteria", eventsListCriteria);
			prefs.setValue("searchCriteriaVoc", searchCriteria);
			prefs.setValue("processId", processId);
			prefs.store();
			String paramKey = processId + ".domainAreas.Vocabularies";
			try {
				SPParameter spParameters = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(), paramKey);
				if(Validator.isNull(spParameters)){
					long spparamId = CounterLocalServiceUtil.increment("SPParameter.class");
					spParameters = SPParameterLocalServiceUtil.createSPParameter(spparamId);
					spParameters.setName(paramKey);
					spParameters.setValue(searchCriteria);
					spParameters.setDescription(StringPool.BLANK);
					spParameters = SPParameterLocalServiceUtil.updateSPParameter(spParameters);	
				}else {
					spParameters.setName(paramKey);
					spParameters.setValue(searchCriteria);
					spParameters.setDescription(StringPool.BLANK);
					spParameters = SPParameterLocalServiceUtil.updateSPParameter(spParameters);
				}
				SPParameterLocalServiceUtil.clearSPParameterPool(themeDisplay.getScopeGroupId(), paramKey);	
			} catch (NoSuchSPParameterException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
			
		}else{
			PortletPreferences prefs = resourceRequest.getPreferences();
			String searchArea = prefs.getValue("eventsListCriteria", StringPool.BLANK);
			String vocabularyList = prefs.getValue("searchCriteriaVoc", StringPool.BLANK);
			List<UpcomingEventsWrapper> upcomingEventsWrappers = null;
			String searchByDomainValues = StringPool.BLANK;
			String processId =  prefs.getValue("processId", "0");
			try {
				if("Functional Group".equalsIgnoreCase(searchArea)){
					upcomingEventsWrappers = getUpcomingEventsWrappers(themeDisplay, profileUserId);
				}else{
					searchByDomainValues = getDomainAreas(themeDisplay,processId);
					_log.error("searchByDomainValues processId " + processId + " " + searchByDomainValues);
					upcomingEventsWrappers= getUpcomingEventsWrappersForDomain(themeDisplay,vocabularyList,searchByDomainValues);//"Build and maintain effective sales relationship,Build and deliver customer service and customer care support"
				}
				count = upcomingEventsWrappers.size();
				int start = currentPage * pageItems;
				int end = (currentPage + 1) * pageItems;
	
				if (end > count) {
					end = count;
				}
	
				countJSONObject.put("value", count);
	
				for (int i = start; i < end; i++) {
					UpcomingEventsWrapper uew = upcomingEventsWrappers.get(i);
					JSONObject item = JSONFactoryUtil.createJSONObject();
					StringBuffer sb = new StringBuffer();
	
					sb.append("<li class=\"upcoming-event-mosaic-block\">");
					sb.append("<div class=\"upcoming-event-mosaic-block-content\">");
	
					if (Validator.isNotNull(uew.getTitle())) {
						sb.append("<a href=\"");
						sb.append(uew.getUrl());
						sb.append("\" class=\"content-title\">");
						sb.append(uew.getTitle().trim());
						sb.append("</a>");
					}
	
					if (Validator.isNotNull(uew.getDescription())) {
						sb.append("<div class=\"upcoming-event-mosaic-block-description\">");
						sb.append(uew.getDescription().trim());
						sb.append("</div>");
					}
	
					sb.append("</div>");
					sb.append("</li>");
	
					item.put("html", sb.toString());
					items.put(item);
				}
	
			} catch (Exception e) {
				if (e instanceof NoSuchSPJobRoleException) {
	
					// do nothing
	
				} else {
					_log.error(e.getMessage(), e);
				}
			}
		}	
		data.put("items", items);
		data.put("count", countJSONObject);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("utf-8");
		resourceResponse.getWriter().write(data.toString());

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private String getDomainAreas(ThemeDisplay themeDisplay,String processId) {
		String searchByDomainValues = StringPool.BLANK;
		try {
			List<PEProcessState> peProcessStateList = PEProcessStateLocalServiceUtil.findByUserIdProcessAndPEProcessId(themeDisplay.getUserId(), Long.parseLong(processId));
			for(PEProcessState peProcessState : peProcessStateList){
				JSONObject jObject = JSONFactoryUtil.createJSONObject(peProcessState.getData());
				String dmnAreas = jObject.getString("domainAreas"); 
				if(dmnAreas.contains("[") && dmnAreas.contains("]")){
					dmnAreas = dmnAreas.substring((dmnAreas.indexOf("[")+1), dmnAreas.indexOf("]"));
				}	
				String[] dmnAreasArr = dmnAreas.split(StringPool.COMMA);
				for(String domainAreaVal : dmnAreasArr){
					JSONObject jObject1 = JSONFactoryUtil.createJSONObject(domainAreaVal);
					 if(!searchByDomainValues.isEmpty()){
					    	searchByDomainValues = searchByDomainValues + StringPool.COMMA + jObject1.getString("value");
					    }else{
							searchByDomainValues = jObject1.getString("value");
						}
				}
			}	
		} catch (JSONException | NoSuchPEProcessStateException | NumberFormatException | SystemException e) {
			_log.error(e.getMessage());
		}
		
		return searchByDomainValues;
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<AssetVocabulary> assetVocabularyList = null;
		PortletPreferences prefs = renderRequest.getPreferences();
		try {
			assetVocabularyList = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		renderRequest.setAttribute("assetVocabularyList", assetVocabularyList);
		String eventsListCriteria = prefs.getValue("eventsListCriteria", StringPool.BLANK);
		String searchCriteriaVoc = prefs.getValue("searchCriteriaVoc",StringPool.BLANK);
		String processId = prefs.getValue("processId",StringPool.BLANK);
		renderRequest.setAttribute("eventsListCriteria", eventsListCriteria);
		renderRequest.setAttribute("searchCriteriaVoc", searchCriteriaVoc);
		renderRequest.setAttribute("processId", processId);
		super.doEdit(renderRequest, renderResponse);
	}	
	
	
	private List<UpcomingEventsWrapper> getUpcomingEventsWrappersForDomain(
			ThemeDisplay themeDisplay,String vocabularyList,String domainAreas) {
		// TODO Auto-generated method stub
		List<UpcomingEventsWrapper> upcomingEventsWrappers = new ArrayList<UpcomingEventsWrapper>();
		String[] vocabularyArray = vocabularyList.split(StringPool.COMMA);
		String[] domainAreasArray = domainAreas.split(StringPool.COMMA);
		try {
			List<CalendarBooking> calEvents = CalendarBookingLocalServiceUtil.getCalendarBookings(-1, -1);
			String eventsAdded = StringPool.BLANK;
			for (CalendarBooking calEvent : calEvents) {
				long endDate = calEvent.getEndTime();
				Date now = new Date();

				if(Validator.isNotNull(endDate)){
					if (now.getTime() > endDate) {
						continue;
					}
				}	
				for(String vocabulary : vocabularyArray){
					if(Validator.isNotNull(vocabulary)){
						List<AssetCategory> categoryIds = AssetCategoryLocalServiceUtil.getVocabularyCategories(Long.parseLong(vocabulary), -1, -1, null);//(190731);//Categories(841371,calEvent.getCalendarBookingId());
						for (int l = 0; l < categoryIds.size(); l++) {
							long categoryId = categoryIds.get(l).getCategoryId();
							String categoryName = categoryIds.get(l).getName();
							for(String domainAreaValue : domainAreasArray){
								if (categoryName.equalsIgnoreCase(domainAreaValue)) {
									List<AssetCategory> eventCategoryIds = AssetCategoryLocalServiceUtil.getCategories(CalendarBooking.class.getName(),calEvent.getCalendarBookingId());
									for (int k = 0; k < eventCategoryIds.size(); k++) {
										long eventCategoryId = eventCategoryIds.get(k).getCategoryId();
										if (categoryId == eventCategoryId) {
											if(!eventsAdded.contains(String.valueOf(calEvent.getCalendarBookingId())+StringPool.COMMA)){
												eventsAdded = String.valueOf(calEvent.getCalendarBookingId()) + StringPool.COMMA + eventsAdded;
												String title = HtmlUtil.stripHtml(calEvent.getTitle());
												String description = HtmlUtil.unescape(HtmlUtil.stripHtml(calEvent.getDescription()));
						
												if (Validator.isNotNull(title) && title.length() > TITLE_MAX_LENGTH) {
													title = title.substring(0, TITLE_MAX_LENGTH) + "...";
												}
						
												if (Validator.isNotNull(description) && description.length() > DESCRIPTION_MAX_LENGTH) {
													description = description.substring(0, DESCRIPTION_MAX_LENGTH) + "...";
												}
												String url = "/event-details/-/event/view_event/" + calEvent.getCalendarBookingId() + "?flagDetail=false";
												UpcomingEventsWrapper upcomingEventsWrapper = new UpcomingEventsWrapper(title, description, url);
												upcomingEventsWrappers.add(upcomingEventsWrapper);
												break;
											}	
										}	
									}	
								}
							}	
						}
					}	
				}	
			}
		} catch (NumberFormatException | SystemException e) {
			_log.error(e.getMessage());
		}

		return upcomingEventsWrappers;
	
	}

	private List<UpcomingEventsWrapper> getUpcomingEventsWrappers(ThemeDisplay themeDisplay, long profileUserId)
			throws PortalException, SystemException {
		List<UpcomingEventsWrapper> upcomingEventsWrappers = new ArrayList<UpcomingEventsWrapper>();
		try {
			SPJobRole jobRole = SPJobRoleLocalServiceUtil.findByJobRole(profileUserId);
			long functionalGroupId = jobRole.getFunctionalGroupId();
			_log.error("functionalGroupId " + functionalGroupId);
			List<CalendarBooking> calEvents = CalendarBookingLocalServiceUtil.getCalendarBookings(-1, -1);

			for (CalendarBooking calEvent : calEvents) {
				long endDate = calEvent.getEndTime();
				Date now = new Date();

				if(Validator.isNotNull(endDate)){
					if (now.getTime() > endDate) {
						continue;
					}
				}	
				List<AssetCategory> categoryIds = AssetCategoryLocalServiceUtil.getCategories(CalendarBooking.class.getName(),calEvent.getCalendarBookingId());
				for (int l = 0; l < categoryIds.size(); l++) {
					long categoryId = categoryIds.get(l).getCategoryId();
					if (categoryId == functionalGroupId) {
						String title = HtmlUtil.stripHtml(calEvent.getTitle());
						String description = HtmlUtil.unescape(HtmlUtil.stripHtml(calEvent.getDescription()));

						if (Validator.isNotNull(title) && title.length() > TITLE_MAX_LENGTH) {
							title = title.substring(0, TITLE_MAX_LENGTH) + "...";
						}

						if (Validator.isNotNull(description) && description.length() > DESCRIPTION_MAX_LENGTH) {
							description = description.substring(0, DESCRIPTION_MAX_LENGTH) + "...";
						}
						String url = "/event-details/-/event/view_event/" + calEvent.getCalendarBookingId() + "?flagDetail=false";
						UpcomingEventsWrapper upcomingEventsWrapper = new UpcomingEventsWrapper(title, description, url);
						upcomingEventsWrappers.add(upcomingEventsWrapper);
						break;
					}
				}
			}
		} catch (NoSuchSPJobRoleException e) {
			_log.error("No JobRole exists with the key {userId=" + profileUserId + "}");
		}

		return upcomingEventsWrappers;
	}

	private static final int DESCRIPTION_MAX_LENGTH = 200;

	private static final int TITLE_MAX_LENGTH = 100;

	private static Log _log = LogFactoryUtil.getLog(UpcomingEventsAction.class);

}
