package com.sambaash.platform.portlet.search.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.search.util.DWCUtil;
import com.sambaash.platform.portlet.search.wrapper.DWCWrapper;
import com.sambaash.platform.srv.spasset.NoSuchTypeException;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.util.SambaashUtil;
//import com.sambaash.platform.srv.corporate.model.CorporateProfile;

/**
 * Portlet implementation class SearchAction
 */
public class SearchAction extends MVCPortlet {

		//	private List<DWCWrapper> wrappers_ = null;

		@Override
		public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
				PortletException {

			portalURL = PortalUtil.getPortalURL(actionRequest);
			String action = actionRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {

				PortletPreferences preferences = actionRequest.getPreferences();

				String category = actionRequest.getParameter("category");

				String headerTitle = actionRequest.getParameter("headerTitle");

				String isShowBlog = actionRequest.getParameter("isShowBlog");
				String blogNum = actionRequest.getParameter("blogNum");

				String isShowGroup = actionRequest.getParameter("isShowGroup");
				String groupNum = actionRequest.getParameter("groupNum");

				String isShowEvent = actionRequest.getParameter("isShowEvent");
				String eventNum = actionRequest.getParameter("eventNum");

				String isShowGallery = actionRequest.getParameter("isShowGallery");
				String galleryNum = actionRequest.getParameter("galleryNum");

				String isShowJob = actionRequest.getParameter("isShowJob");
				String jobNum = actionRequest.getParameter("jobNum");

				String isShowKC = actionRequest.getParameter("isShowKC");
				String kcNum = actionRequest.getParameter("kcNum");

				String isShowIndiProfile = actionRequest.getParameter("isShowIndiProfile");
				String indiProfileNum = actionRequest.getParameter("indiProfileNum");

				String isShowCorpProfile = actionRequest.getParameter("isShowCorpProfile");
				String corpProfileNum = actionRequest.getParameter("corpProfileNum");

				String isShowSPAsset = actionRequest.getParameter("isShowSPAsset");
				String spAssetNum = actionRequest.getParameter("spAssetNum");

				String isShowImage = actionRequest.getParameter("isShowImage");
				String isShowTitle = actionRequest.getParameter("isShowTitle");
				String titleMaxLength = actionRequest.getParameter("titleMaxLength");
				String isShowContent = actionRequest.getParameter("isShowContent");
				String contentMaxLength = actionRequest.getParameter("contentMaxLength");
				String isShowAuthor = actionRequest.getParameter("isShowAuthor");

				String pageItems = actionRequest.getParameter("pageItems");
				String itemMinWidth = actionRequest.getParameter("itemMinWidth");

				String listingStyle = actionRequest.getParameter("listingStyle");

				String searchByKeywords = actionRequest.getParameter("searchByKeywords");
				String[] searchKeywordsFields = actionRequest.getParameterValues("searchKeywordsFields");
				preferences.setValue("searchByKeywords", searchByKeywords);
				if (searchKeywordsFields != null && searchKeywordsFields.length > 0) {
					preferences.setValues("searchKeywordsFields", searchKeywordsFields);
				} else {
					preferences.setValues("searchKeywordsFields", new String[0]);
				}

				preferences.setValue("category", category);

				preferences.setValue("headerTitle", headerTitle);

				preferences.setValue("isShowBlog", isShowBlog);
				preferences.setValue("blogNum", blogNum);

				preferences.setValue("isShowGroup", isShowGroup);
				preferences.setValue("groupNum", groupNum);

				preferences.setValue("isShowEvent", isShowEvent);
				preferences.setValue("eventNum", eventNum);

				preferences.setValue("isShowGallery", isShowGallery);
				preferences.setValue("galleryNum", galleryNum);

				preferences.setValue("isShowJob", isShowJob);
				preferences.setValue("jobNum", jobNum);

				preferences.setValue("isShowKC", isShowKC);
				preferences.setValue("kcNum", kcNum);

				preferences.setValue("isShowIndiProfile", isShowIndiProfile);
				preferences.setValue("indiProfileNum", indiProfileNum);

				preferences.setValue("isShowCorpProfile", isShowCorpProfile);
				preferences.setValue("corpProfileNum", corpProfileNum);

				preferences.setValue("isShowSPAsset", isShowSPAsset);
				preferences.setValue("spAssetNum", spAssetNum);

				preferences.setValue("isShowImage", isShowImage);
				preferences.setValue("isShowTitle", isShowTitle);
				preferences.setValue("titleMaxLength", titleMaxLength);
				preferences.setValue("isShowContent", isShowContent);
				preferences.setValue("contentMaxLength", contentMaxLength);
				preferences.setValue("isShowAuthor", isShowAuthor);

				preferences.setValue("pageItems", pageItems);
				preferences.setValue("itemMinWidth", itemMinWidth);

				preferences.setValue("listingStyle", listingStyle);

				String searchByTag = actionRequest.getParameter("searchByTag");
				preferences.setValue("searchByTag", searchByTag);

				String searchByCategory = actionRequest.getParameter("searchByCategory");
				preferences.setValue("searchByCategory", searchByCategory);

				String selectedSPAssetTypeIdStr = actionRequest.getParameter("selectedSPAssetTypeId");
				preferences.setValue("selectedSPAssetTypeId", selectedSPAssetTypeIdStr);

				preferences.store();

				actionResponse.setPortletMode(PortletMode.VIEW);

			}

		}

		@Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
				PortletException {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			portalURL = PortalUtil.getPortalURL(resourceRequest);

			String currentURL = resourceRequest.getParameter("currentURL");

			String currentPageStr = resourceRequest.getParameter("currentPage");
			int currentPage = Validator.isNotNull(currentPageStr) ? Integer.valueOf(currentPageStr) : 1;

			PortletPreferences preferences = resourceRequest.getPreferences();

			String category = preferences.getValue("category", StringPool.BLANK);

			String headerTitle = preferences.getValue("headerTitle", StringPool.BLANK);
			String preHeaderTitle = StringPool.BLANK;
			String postHeaderTitle = StringPool.BLANK;
			if (Validator.isNotNull(headerTitle)) {
				if (headerTitle.indexOf(StringPool.SPACE) > 0) {
					preHeaderTitle = headerTitle.substring(0, headerTitle.indexOf(StringPool.SPACE));
					postHeaderTitle = headerTitle.substring(headerTitle.indexOf(StringPool.SPACE), headerTitle.length());

				} else {
					postHeaderTitle = headerTitle;
				}
			}

			String isShowBlog = preferences.getValue("isShowBlog", StringPool.FALSE);
			String blogNum = preferences.getValue("blogNum", "0");

			String isShowGroup = preferences.getValue("isShowGroup", StringPool.FALSE);
			String groupNum = preferences.getValue("groupNum", "0");

			String isShowEvent = preferences.getValue("isShowEvent", StringPool.FALSE);
			String eventNum = preferences.getValue("eventNum", "0");

			String isShowGallery = preferences.getValue("isShowGallery", StringPool.FALSE);
			String galleryNum = preferences.getValue("galleryNum", "0");

			String isShowJob = preferences.getValue("isShowJob", StringPool.FALSE);
			String jobNum = preferences.getValue("jobNum", "0");

			String isShowKC = preferences.getValue("isShowKC", StringPool.FALSE);
			String kcNum = preferences.getValue("kcNum", "0");

			String isShowIndiProfile = preferences.getValue("isShowIndiProfile", StringPool.FALSE);
			String indiProfileNum = preferences.getValue("indiProfileNum", "0");

			String isShowCorpProfile = preferences.getValue("isShowCorpProfile", StringPool.FALSE);
			String corpProfileNum = preferences.getValue("corpProfileNum", "0");

			String isShowSPAsset = preferences.getValue("isShowSPAsset", StringPool.FALSE);
			String spAssetNum = preferences.getValue("spAssetNum", "0");

			String isShowImage = preferences.getValue("isShowImage", StringPool.BLANK);
			String isShowTitle = preferences.getValue("isShowTitle", StringPool.BLANK);
			String titleMaxLength = preferences.getValue("titleMaxLength", "0");
			String isShowContent = preferences.getValue("isShowContent", StringPool.BLANK);
			String contentMaxLength = preferences.getValue("contentMaxLength", "0");
			String isShowAuthor = preferences.getValue("isShowAuthor", StringPool.BLANK);

			String pageItemsStr = preferences.getValue("pageItems", "0");
			String itemMinWidth = preferences.getValue("itemMinWidth", "167");

			int pageItems = 0;
			try {
				pageItems = Integer.valueOf(pageItemsStr);
			} catch (NumberFormatException nfe) {
				pageItems = 0;
			}

			String selectedSPAssetTypeIdStr = preferences.getValue("selectedSPAssetTypeId", StringPool.BLANK);
			long selectedSPAssetTypeId = 0;
			try {
				selectedSPAssetTypeId = Integer.valueOf(selectedSPAssetTypeIdStr);
			} catch (NumberFormatException nfe) {
				selectedSPAssetTypeId = 0;
			}

			//		String wp = "100%";
			_log.debug("pageItems " + pageItems);
			//		if (pageItems > 0) {
			//			wp = ((100 / pageItems - 2) * 10 + 34 )+ "px";
			//		}
			String wp = itemMinWidth + "px";
			_log.debug("pageItems wp " + wp);
			String listingStyle = preferences.getValue("listingStyle", _DEFAULT_LISTING_STYLE);
			_log.debug("listingStyle1 " + listingStyle);
			String searchByKeywords = preferences.getValue("searchByKeywords", StringPool.BLANK);
			String[] searchKeywordsFields = preferences.getValues("searchKeywordsFields", new String[0]);

			String searchByTag = preferences.getValue("searchByTag", StringPool.BLANK);
			String searchByCategory = preferences.getValue("searchByCategory", StringPool.BLANK);

			Map<String, Object> paramsMap = new HashMap<String, Object>();

			paramsMap.put("currentURL", currentURL);

			paramsMap.put("category", category);

			paramsMap.put("headerTitle", headerTitle);
			paramsMap.put("preHeaderTitle", preHeaderTitle);
			paramsMap.put("postHeaderTitle", postHeaderTitle);

			paramsMap.put("isShowBlog", isShowBlog);
			paramsMap.put("blogNum", blogNum);

			paramsMap.put("isShowGroup", isShowGroup);
			paramsMap.put("groupNum", groupNum);

			paramsMap.put("isShowEvent", isShowEvent);
			paramsMap.put("eventNum", eventNum);

			paramsMap.put("isShowGallery", isShowGallery);
			paramsMap.put("galleryNum", galleryNum);

			paramsMap.put("isShowJob", isShowJob);
			paramsMap.put("jobNum", jobNum);

			paramsMap.put("isShowKC", isShowKC);
			paramsMap.put("kcNum", kcNum);

			paramsMap.put("isShowIndiProfile", isShowIndiProfile);
			paramsMap.put("indiProfileNum", indiProfileNum);

			paramsMap.put("isShowCorpProfile", isShowCorpProfile);
			paramsMap.put("corpProfileNum", corpProfileNum);

			paramsMap.put("isShowSPAsset", isShowSPAsset);
			paramsMap.put("spAssetNum", spAssetNum);

			paramsMap.put("titleMaxLength", titleMaxLength);
			paramsMap.put("contentMaxLength", contentMaxLength);

			paramsMap.put("searchByKeywords", searchByKeywords);
			paramsMap.put("searchKeywordsFields", searchKeywordsFields);

			paramsMap.put("searchByTag", searchByTag);
			paramsMap.put("searchByCategory", searchByCategory);

			paramsMap.put("selectedSPAssetTypeId", selectedSPAssetTypeId);

			String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");
			String eventDetailPageName = preferences.getValue("eventDetailPageName", "event-details");

			paramsMap.put("groupDetailPageName", groupDetailPageName);
			paramsMap.put("eventDetailPageName", eventDetailPageName);

			//		if(wrappers == null) {
			//			wrappers = search(themeDisplay, paramsMap);
			//		}
			List<DWCWrapper> wrappers = search(resourceRequest, themeDisplay, paramsMap);
			int count = wrappers.size();
			int start = currentPage * pageItems;
			int end = (currentPage + 1) * pageItems;
			if (end > count) {
				end = count;
			}
			JSONObject data = JSONFactoryUtil.createJSONObject();
			JSONArray items = JSONFactoryUtil.createJSONArray();
			JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();
			countJSONObject.put("value", count);

			if ("horizontal".equalsIgnoreCase(listingStyle)) {
				StringBuffer sb = new StringBuffer();
				sb.append("<li class=\"search-stream-mosaic-block\" ");
			}

			for (int i = start; i < end; i++) {
				DWCWrapper dwcw = wrappers.get(i);
				JSONObject item = JSONFactoryUtil.createJSONObject();

				StringBuffer sb = new StringBuffer();

				if ("horizontal".equalsIgnoreCase(listingStyle)) {
					sb.append("<div class=\"search-stream-mosaic-block\" ");
					sb.append("style=\"width: " + wp + ";\">");
				} else {
					sb.append("<li class=\"search-stream-mosaic-block\" ");
					sb.append("style=\"width: 100%;\">");
				}

				sb.append("<div style=\"width: 100%\">");

				if ("true".equalsIgnoreCase(isShowImage)) {
					sb.append("<div class=\"search-stream-mosaic-block-icon\">");
					sb.append("<img alt=\"Image\" src=\"");
					if (Validator.isNotNull(dwcw.getImage())) {
						sb.append(dwcw.getImage().trim());
					} else {
						sb.append(dwcw.getImage().trim());
					}
					sb.append("\">");
				} else {
					sb.append("<div class=\"search-stream-mosaic-empty-icon\">");
				}
				sb.append("</div>");

				if ("true".equalsIgnoreCase(isShowImage)) {
					sb.append("<div class=\"search-stream-mosaic-block-content\">");
				} else {
					sb.append("<div class=\"search-stream-mosaic-empty-content\">");
				}

				if (Validator.isNotNull(dwcw.getTitle()) && "true".equalsIgnoreCase(isShowTitle)) {
					sb.append("<div class=\"content-title\"><a href=\"");
					sb.append(dwcw.getDetailUrl());
					sb.append("\" >");
					sb.append(dwcw.getTitle().trim());
					sb.append("</a></div>");
				}
				if (Validator.isNotNull(dwcw.getContent()) && "true".equalsIgnoreCase(isShowContent)) {
					sb.append("<div class=\"search-stream-mosaic-block-description search-description-height\">");
					sb.append(dwcw.getContent().trim());
					sb.append("</div>");
				}
				if (Validator.isNotNull(dwcw.getAuthor()) && "true".equalsIgnoreCase(isShowAuthor)) {
					sb.append("</br><div class=\"search-stream-mosaic-block-author\"><a href=\"");
					sb.append(dwcw.getProfileUrl());
					sb.append("\" >");
					sb.append(dwcw.getAuthor().trim());
					sb.append("</a> ");
					if ("horizontal".equalsIgnoreCase(listingStyle)) {
						sb.append("<br />");
					}
					sb.append("<b>" + dwcw.getDisplayDate() + "</b>");
					sb.append("</div>");
				}
				sb.append("</div>");
				sb.append("</div>");
				//			else {
				//				if (Validator.isNotNull(dwcw.getTitle()) && "true".equalsIgnoreCase(isShowTitle)) {
				//					sb.append("<div class=\"content-title\"><a href=\"");
				//					sb.append(dwcw.getDetailUrl());
				//					sb.append("\" >");
				//					sb.append(dwcw.getTitle().trim());
				//					sb.append("</a></div>");
				//				}
				//				if (Validator.isNotNull(dwcw.getContent()) && "true".equalsIgnoreCase(isShowContent)) {
				//					sb.append("<div class=\"search-stream-mosaic-block-description\">");
				//					sb.append(dwcw.getContent().trim());
				//					sb.append("</div>");
				//				}
				//				if (Validator.isNotNull(dwcw.getAuthor()) && "true".equalsIgnoreCase(isShowAuthor)) {
				//					sb.append("</br><div class=\"search-stream-mosaic-block-author\"><a href=\"");
				//					sb.append(dwcw.getProfileUrl());
				//					sb.append("\" >");
				//					sb.append(dwcw.getAuthor().trim());
				//					sb.append("</a> ");
				//					if ("horizontal".equalsIgnoreCase(listingStyle)) {
				//						sb.append("<br />");
				//					}
				//					sb.append("<b>" + dwcw.getDisplayDate() + "</b>");
				//					sb.append("</div>");
				//				}
				//			}
				if ("horizontal".equalsIgnoreCase(listingStyle)) {
					sb.append("</div>");
				} else {
					sb.append("</li>");
				}
				item.put("html", sb.toString());
				items.put(item);
			}
			data.put("items", items);
			data.put("count", countJSONObject);

			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");

			resourceResponse.getWriter().write(data.toString());

			super.serveResource(resourceRequest, resourceResponse);
		}

		@Override
		public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
			portalURL = PortalUtil.getPortalURL(renderRequest);

			PortletPreferences preferences = renderRequest.getPreferences();

			String category = preferences.getValue("category", StringPool.BLANK);

			String headerTitle = preferences.getValue("headerTitle", StringPool.BLANK);

			String isShowBlog = preferences.getValue("isShowBlog", StringPool.FALSE);
			String blogNum = preferences.getValue("blogNum", "0");

			String isShowGroup = preferences.getValue("isShowGroup", StringPool.FALSE);
			String groupNum = preferences.getValue("groupNum", "0");

			String isShowEvent = preferences.getValue("isShowEvent", StringPool.FALSE);
			String eventNum = preferences.getValue("eventNum", "0");

			String isShowGallery = preferences.getValue("isShowGallery", StringPool.FALSE);
			String galleryNum = preferences.getValue("galleryNum", "0");

			String isShowJob = preferences.getValue("isShowJob", StringPool.FALSE);
			String jobNum = preferences.getValue("jobNum", "0");

			String isShowKC = preferences.getValue("isShowKC", StringPool.FALSE);
			String kcNum = preferences.getValue("kcNum", "0");

			String isShowIndiProfile = preferences.getValue("isShowIndiProfile", StringPool.FALSE);
			String indiProfileNum = preferences.getValue("indiProfileNum", "0");

			String isShowCorpProfile = preferences.getValue("isShowCorpProfile", StringPool.FALSE);
			String corpProfileNum = preferences.getValue("corpProfileNum", "0");

			String isShowSPAsset = preferences.getValue("isShowSPAsset", StringPool.FALSE);
			String spAssetNum = preferences.getValue("spAssetNum", "0");

			String isShowImage = preferences.getValue("isShowImage", StringPool.FALSE);
			String isShowTitle = preferences.getValue("isShowTitle", StringPool.FALSE);
			String titleMaxLength = preferences.getValue("titleMaxLength", "0");
			String isShowContent = preferences.getValue("isShowContent", StringPool.FALSE);
			String contentMaxLength = preferences.getValue("contentMaxLength", "0");
			String isShowAuthor = preferences.getValue("isShowAuthor", StringPool.FALSE);

			String pageItems = preferences.getValue("pageItems", "0");
			String itemMinWidth = preferences.getValue("itemMinWidth", "167");

			String listingStyle = preferences.getValue("listingStyle", _DEFAULT_LISTING_STYLE);

			String searchByKeywords = preferences.getValue("searchByKeywords", StringPool.BLANK);
			renderRequest.setAttribute("searchByKeywords", searchByKeywords);

			String[] searchKeywordsFields = preferences.getValues("searchKeywordsFields", new String[0]);
			StringBuffer searchKeywordsFieldSB = new StringBuffer();
			for (String searchKeywordsField : searchKeywordsFields) {
				searchKeywordsFieldSB.append(searchKeywordsField);
				searchKeywordsFieldSB.append(StringPool.SPACE);
			}
			renderRequest.setAttribute("searchKeywordsFields", searchKeywordsFieldSB.toString().trim());

			renderRequest.setAttribute("category", category);

			renderRequest.setAttribute("headerTitle", headerTitle);

			renderRequest.setAttribute("isShowBlog", isShowBlog);
			renderRequest.setAttribute("blogNum", blogNum);

			renderRequest.setAttribute("isShowGroup", isShowGroup);
			renderRequest.setAttribute("groupNum", groupNum);

			renderRequest.setAttribute("isShowEvent", isShowEvent);
			renderRequest.setAttribute("eventNum", eventNum);

			renderRequest.setAttribute("isShowGallery", isShowGallery);
			renderRequest.setAttribute("galleryNum", galleryNum);

			renderRequest.setAttribute("isShowJob", isShowJob);
			renderRequest.setAttribute("jobNum", jobNum);

			renderRequest.setAttribute("isShowKC", isShowKC);
			renderRequest.setAttribute("kcNum", kcNum);

			renderRequest.setAttribute("isShowIndiProfile", isShowIndiProfile);
			renderRequest.setAttribute("indiProfileNum", indiProfileNum);

			renderRequest.setAttribute("isShowCorpProfile", isShowCorpProfile);
			renderRequest.setAttribute("corpProfileNum", corpProfileNum);

			renderRequest.setAttribute("isShowSPAsset", isShowSPAsset);
			renderRequest.setAttribute("spAssetNum", spAssetNum);

			renderRequest.setAttribute("isShowImage", isShowImage);
			renderRequest.setAttribute("isShowTitle", isShowTitle);
			renderRequest.setAttribute("titleMaxLength", titleMaxLength);
			renderRequest.setAttribute("isShowContent", isShowContent);
			renderRequest.setAttribute("contentMaxLength", contentMaxLength);
			renderRequest.setAttribute("isShowAuthor", isShowAuthor);

			renderRequest.setAttribute("pageItems", pageItems);
			renderRequest.setAttribute("itemMinWidth", itemMinWidth);

			renderRequest.setAttribute("listingStyle", listingStyle);

			String searchByTag = preferences.getValue("searchByTag", StringPool.BLANK);
			renderRequest.setAttribute("searchByTag", searchByTag);

			String searchByCategory = preferences.getValue("searchByCategory", StringPool.BLANK);
			renderRequest.setAttribute("searchByCategory", searchByCategory);

			List<SPAssetType> spAssetTypes = getAssetTypes();
			renderRequest.setAttribute("spAssetTypes", spAssetTypes);

			String selectedSPAssetTypeIdStr = preferences.getValue("selectedSPAssetTypeId", StringPool.BLANK);
			renderRequest.setAttribute("selectedSPAssetTypeId", selectedSPAssetTypeIdStr);

			String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");
			renderRequest.setAttribute("groupDetailPageName", groupDetailPageName);

			String eventDetailPageName = preferences.getValue("eventDetailPageName", "event-details");
			renderRequest.setAttribute("eventDetailPageName", eventDetailPageName);

			super.doEdit(renderRequest, renderResponse);
		}

		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				portalURL = PortalUtil.getPortalURL(renderRequest);
				//		wrappers = null;
				PortletPreferences preferences = renderRequest.getPreferences();
				String headerTitle = preferences.getValue("headerTitle", StringPool.BLANK);
				String preTitle = StringPool.BLANK;
				String postTitle = StringPool.BLANK;
				if (Validator.isNotNull(headerTitle)) {
					if (headerTitle.indexOf(StringPool.SPACE) > 0) {
						preTitle = headerTitle.substring(0, headerTitle.indexOf(StringPool.SPACE));
						postTitle = headerTitle.substring(headerTitle.indexOf(StringPool.SPACE), headerTitle.length());

					} else {
						preTitle = headerTitle;
					}
				}
				String pageItems = preferences.getValue("pageItems", "0");
				String itemMinWidth = preferences.getValue("itemMinWidth", "167");

				String listingStyle = preferences.getValue("listingStyle", _DEFAULT_LISTING_STYLE);

				renderRequest.setAttribute("headerTitle", headerTitle);
				renderRequest.setAttribute("preTitle", preTitle);
				renderRequest.setAttribute("postTitle", postTitle);
				renderRequest.setAttribute("pageItems", pageItems);
				renderRequest.setAttribute("itemMinWidth", itemMinWidth);
				renderRequest.setAttribute("listingStyle", listingStyle);

				@SuppressWarnings("unused")
				List<com.liferay.portal.model.PortletPreferences> portletPreferences = PortletPreferencesLocalServiceUtil
						.getPortletPreferencesByPlid(themeDisplay.getPlid());

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			super.doView(renderRequest, renderResponse);
		}

		public List<DWCWrapper> search(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
				Map<String, Object> paramsMap) {
			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);

			String isShowBlog = (String) paramsMap.get("isShowBlog");
			String isShowJob = (String) paramsMap.get("isShowJob");
			String isShowEvent = (String) paramsMap.get("isShowEvent");
			//		String isShowGallery = (String) paramsMap.get("isShowGallery");
			String isShowIndiProfile = (String) paramsMap.get("isShowIndiProfile");
			String isShowCorpProfile = (String) paramsMap.get("isShowCorpProfile");
			String isShowGroup = (String) paramsMap.get("isShowGroup");
			String isShowSPAsset = (String) paramsMap.get("isShowSPAsset");

			if (StringPool.TRUE.equalsIgnoreCase(isShowBlog)) {
				wrappers.addAll(searchLastestBlogs(themeDisplay, paramsMap));
			}
			if (StringPool.TRUE.equalsIgnoreCase(isShowJob)) {
				wrappers.addAll(searchLastestJobs(themeDisplay, paramsMap));
			}
			if (StringPool.TRUE.equalsIgnoreCase(isShowEvent)) {
				wrappers.addAll(searchLastestEvents(themeDisplay, paramsMap));
			}
			/**
			 * if(StringPool.TRUE.equalsIgnoreCase(isShowGallery)) { wrappers.addAll(searchLastestGallerys(themeDisplay,
			 * paramsMap)); }
			 **/
			if (StringPool.TRUE.equalsIgnoreCase(isShowIndiProfile)) {
				wrappers.addAll(searchLastestIndiProfiles(themeDisplay, paramsMap));
			}
//			if (StringPool.TRUE.equalsIgnoreCase(isShowCorpProfile)) {
//				wrappers.addAll(searchLastestCorpProfiles(themeDisplay, paramsMap));
//			}

			if (StringPool.TRUE.equalsIgnoreCase(isShowGroup)) {
				wrappers.addAll(searchLastestGroups(resourceRequest, themeDisplay, paramsMap));
			}
			if (StringPool.TRUE.equalsIgnoreCase(isShowSPAsset)) {
				wrappers.addAll(searchLastestSPAssets(themeDisplay, paramsMap));
			}
			return wrappers;
		}

		public List<DWCWrapper> searchLastestGroups(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
				Map<String, Object> paramsMap) {

			String groupDetailPageName = (String) paramsMap.get("groupDetailPageName");

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String groupNumStr = (String) paramsMap.get("groupNum");

				int end = 0;
				try {
					end = Integer.valueOf(groupNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}

				String titleMaxLengthStr = (String) paramsMap.get("titleMaxLength");
				int titleMaxLength = 0;
				try {
					titleMaxLength = Integer.valueOf(titleMaxLengthStr);
				} catch (NumberFormatException nfe) {
					titleMaxLength = 0;
				}
				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(searchContext,keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext,tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}
					searchContext.setBooleanClauses(booleanClauses);

					Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					if ("Logined User".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);
						searchContext.setAttribute("searchByUserId", themeDisplay.getUserId());
					} else if ("Public Profile".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);

						long remoteUserId = themeDisplay.getUserId();
						String friendlyURL = (String) paramsMap.get("currentURL");
						long companyId = themeDisplay.getCompanyId();
						long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
						if (profileUserId == 0) {
							profileUserId = remoteUserId;
						}
						searchContext.setAttribute("searchByUserId", profileUserId);
					} else if ("All".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", false);
					}

					Indexer indexer = IndexerRegistryUtil.getIndexer(SPGroup.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						long spGroupId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
						String title = GetterUtil.getString(doc.get(Field.TITLE));
						String content = GetterUtil.getString(doc.get(Field.DESCRIPTION));
						String imageId = GetterUtil.getString(doc.get("imageId"));
						long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
						String userName = GetterUtil.getString(doc.get(Field.USER_NAME));

						String urlTitle = GetterUtil.getString(doc.get("urlTitle"));
						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						Date now = new Date();
						String image = "/image/image_gallery?img_id=" + imageId + "&t=" + now.getTime();
						content = HtmlUtil.stripHtml(content.trim());
						if (Validator.isNotNull(title) && title.length() > titleMaxLength) {
							title = title.substring(0, titleMaxLength) + "...";
						}
						if (Validator.isNotNull(content) && content.length() > contentMaxLength) {
							content = content.substring(0, contentMaxLength) + "...";
						}

						String spGroupDetailURL = StringPool.BLANK;
						try {
							Layout spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(
									themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
							long spGroupDetailPlid = spGroupDetailLayout.getPlid();

							PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
									"SPGroupDetail_WAR_SPGroupportlet", spGroupDetailPlid, PortletRequest.RENDER_PHASE);
							spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
							spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
							spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
							spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
							spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));
							spGroupDetailURL = spGroupDetailPortletURL.toString();
						} catch (com.liferay.portal.NoSuchLayoutException e) {
							// do nothing
						}
						String profileUrl = DWCUtil.getProfileViewDetailUrl(userId);
						wrappers.add(new DWCWrapper(title, spGroupDetailURL, content, image, userName, profileUrl,
								modifiedDate, displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;
		}

		public List<DWCWrapper> searchLastestBlogs(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String blogNumStr = (String) paramsMap.get("blogNum");

				int end = 0;
				try {
					end = Integer.valueOf(blogNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}

				String titleMaxLengthStr = (String) paramsMap.get("titleMaxLength");
				int titleMaxLength = 0;
				try {
					titleMaxLength = Integer.valueOf(titleMaxLengthStr);
				} catch (NumberFormatException nfe) {
					titleMaxLength = 0;
				}
				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(searchContext,keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext,tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}
					searchContext.setBooleanClauses(booleanClauses);

					Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					if ("Logined User".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);
						searchContext.setAttribute("searchByUserId", themeDisplay.getUserId());
					} else if ("Public Profile".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);

						long remoteUserId = themeDisplay.getUserId();
						String friendlyURL = (String) paramsMap.get("currentURL");
						long companyId = themeDisplay.getCompanyId();
						long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
						if (profileUserId == 0) {
							profileUserId = remoteUserId;
						}
						searchContext.setAttribute("searchByUserId", profileUserId);
					} else if ("All".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", false);
					}

					Indexer indexer = IndexerRegistryUtil.getIndexer(BlogsEntry.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						String title = GetterUtil.getString(doc.get(Field.TITLE));
						String content = GetterUtil.getString(doc.get(Field.CONTENT));
						String contentHTML = GetterUtil.getString(doc.get("contentHTML"));
						long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
						String userName = GetterUtil.getString(doc.get(Field.USER_NAME));

						String urlTitle = GetterUtil.getString(doc.get("urlTitle"));
						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						String image = DWCUtil.getBlogImageUrl(contentHTML);

						if (Validator.isNotNull(image) && image.startsWith(themeDisplay.getPortalURL())
								|| image.startsWith(StringPool.FORWARD_SLASH)) {
							if (image.indexOf(StringPool.QUESTION) != -1) {
								image = image + "&imageThumbnail=3";
							} else {
								image = image + "?imageThumbnail=3";
							}
						}

						content = HtmlUtil.stripHtml(content.trim());
						if (Validator.isNotNull(title) && title.length() > titleMaxLength) {
							title = title.substring(0, titleMaxLength) + "...";
						}
						if (Validator.isNotNull(content) && content.length() > contentMaxLength) {
							content = content.substring(0, contentMaxLength) + "...";
						}
						String detailUrl = DWCUtil
								.getBlogViewDetailUrl(portalURL, themeDisplay.getScopeGroupId(), urlTitle);
						String profileUrl = DWCUtil.getProfileViewDetailUrl(userId);
						wrappers.add(new DWCWrapper(title, detailUrl, content, image, userName, profileUrl, modifiedDate,
								displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;
		}
/**
		public List<DWCWrapper> searchLastestCorpProfiles(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String corpProfileNumStr = (String) paramsMap.get("corpProfileNum");

				int end = 0;
				try {
					end = Integer.valueOf(corpProfileNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}

				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}

					searchContext.setBooleanClauses(booleanClauses);
					Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					Indexer indexer = IndexerRegistryUtil.getIndexer(CorporateProfile.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						String name = GetterUtil.getString(doc.get("name"));
						String screenName = GetterUtil.getString(doc.get("profileScreenName"));
						String aboutCompany = GetterUtil.getString(doc.get("aboutCompany"));
						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						long docId = GetterUtil.getLong(doc.get("docId"));

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						aboutCompany = HtmlUtil.stripHtml(aboutCompany.trim());
						if (Validator.isNotNull(aboutCompany) && aboutCompany.length() > contentMaxLength) {
							aboutCompany = aboutCompany.substring(0, contentMaxLength) + "...";
						}

						String profileUrl = DWCUtil.getCorpProfileViewDetailUrl(screenName);
						String image = DWCUtil.getCorporateUserImageUrl(docId, themeDisplay.getScopeGroupId());

						wrappers.add(new DWCWrapper(name, profileUrl, aboutCompany, image, name, profileUrl, modifiedDate,
								displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;
		}
**/
		public List<DWCWrapper> searchLastestIndiProfiles(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String indiProfileNumStr = (String) paramsMap.get("indiProfileNum");

				int end = 0;
				try {
					end = Integer.valueOf(indiProfileNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}
				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(searchContext,keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext,tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}
					searchContext.setBooleanClauses(booleanClauses);

					Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						String fullName = GetterUtil.getString(doc.get("fullName"));
						String screenName = GetterUtil.getString(doc.get("screenName"));
						String aboutMe = GetterUtil.getString(doc.get("about"));
						long portraitId = GetterUtil.getLong(doc.get("portraitId"));
						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						//					aboutMe = HtmlUtil.escape(aboutMe.trim());
						if (Validator.isNotNull(aboutMe) && aboutMe.length() > contentMaxLength) {
							aboutMe = aboutMe.substring(0, contentMaxLength) + "...";
						}
						String profileUrl = DWCUtil.getIndiProfileViewDetailUrl(screenName);
						String image = DWCUtil.getIndividualsUserImageUrl(portraitId);
						wrappers.add(new DWCWrapper(fullName, profileUrl, aboutMe, image, fullName, profileUrl,
								modifiedDate, displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;
		}

		/**
		 * public List<DWCWrapper> searchLastestGallerys(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {
		 * 
		 * List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0); String category = (String) paramsMap.get("category");
		 * 
		 * if(Validator.isNotNull(category)) { String galleryNumStr = (String) paramsMap.get("galleryNum");
		 * 
		 * int end = 0; try{ end = Integer.valueOf(galleryNumStr); }catch(NumberFormatException nfe) { end = 0; }
		 * 
		 * String titleMaxLengthStr = (String) paramsMap.get("titleMaxLength"); int titleMaxLength = 0; try{ titleMaxLength
		 * = Integer.valueOf(titleMaxLengthStr); }catch(NumberFormatException nfe) { titleMaxLength = 0; } String
		 * contentMaxLengthStr = (String) paramsMap.get("contentMaxLength"); int contentMaxLength = 0; try{ contentMaxLength
		 * = Integer.valueOf(contentMaxLengthStr); }catch(NumberFormatException nfe) { contentMaxLength = 0; }
		 * 
		 * try{ SearchContext searchContext = new SearchContext(); searchContext.setCompanyId(themeDisplay.getCompanyId());
		 * searchContext.setStart(0); searchContext.setEnd(end);
		 * 
		 * String searchByKeywords = (String) paramsMap.get("searchByKeywords"); String[] searchKeywordsFields = (String[])
		 * paramsMap.get("searchKeywordsFields");
		 * 
		 * List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>(); if(Validator.isNotNull(searchByKeywords))
		 * { if(searchKeywordsFields.length > 0) { for(String searchKeywordsField : searchKeywordsFields) { BooleanQuery
		 * keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		 * keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords); BooleanClause keywordsBooleanClause
		 * = BooleanClauseFactoryUtil.create(keywordsBooleanQuery, BooleanClauseOccur.MUST.getName());
		 * booleanClauseList.add(keywordsBooleanClause); } }else { searchContext.setKeywords(searchByKeywords); } }
		 * 
		 * String searchByTag = (String) paramsMap.get("searchByTag"); if (Validator.isNotNull(searchByTag)) { BooleanQuery
		 * tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext); tagBooleanQuery.addRequiredTerm("assetTagNames",
		 * "\"" + searchByTag + "\""); BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(tagBooleanQuery,
		 * BooleanClauseOccur.MUST.getName()); booleanClauseList.add(tagBooleanClause); }
		 * 
		 * String searchByCategory = (String) paramsMap.get("searchByCategory"); if (Validator.isNotNull(searchByCategory))
		 * { BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		 * categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\""); BooleanClause
		 * categoryBooleanClause = BooleanClauseFactoryUtil.create(categoryBooleanQuery, BooleanClauseOccur.MUST.getName());
		 * booleanClauseList.add(categoryBooleanClause); }
		 * 
		 * BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()]; for(int i=0;
		 * i<booleanClauseList.size(); i++) { booleanClauses[i] = booleanClauseList.get(i); }
		 * searchContext.setBooleanClauses(booleanClauses);
		 * 
		 * Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true); Sort[] sorts = new Sort[] { sort
		 * }; searchContext.setSorts(sorts);
		 * 
		 * if("Logined User".equalsIgnoreCase(category)) { searchContext.setAttribute("isSearchByUserId", true);
		 * searchContext.setAttribute("searchByUserId", themeDisplay.getUserId()); }else if
		 * ("Public Profile".equalsIgnoreCase(category)) { searchContext.setAttribute("isSearchByUserId", true);
		 * 
		 * long remoteUserId = themeDisplay.getUserId(); String friendlyURL = (String) paramsMap.get("currentURL"); long
		 * companyId = themeDisplay.getCompanyId(); long profileUserId = SambaashUtil.getUserIdByScreenName(companyId,
		 * friendlyURL); if (profileUserId == 0) { profileUserId = remoteUserId; }
		 * searchContext.setAttribute("searchByUserId", profileUserId); }else if("All".equalsIgnoreCase(category)) {
		 * searchContext.setAttribute("isSearchByUserId", false); }
		 * 
		 * Indexer indexer = IndexerRegistryUtil.getIndexer(PortfolioGallery.class.getName()); Hits results =
		 * indexer.search(searchContext);
		 * 
		 * for (int i = 0; i < results.getDocs().length; i++) { Document doc = results.doc(i); String title =
		 * GetterUtil.getString(doc.get(Field.TITLE)); String content = GetterUtil.getString(doc.get(Field.DESCRIPTION));
		 * long userId = GetterUtil.getLong(doc.get(Field.USER_ID)); String userName =
		 * GetterUtil.getString(doc.get(Field.USER_NAME)); long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
		 * long fileId = GetterUtil.getLong(doc.get("fileId")); String _category =
		 * GetterUtil.getString(doc.get("category"));
		 * 
		 * Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE), DateFormat.getDateInstance());
		 * 
		 * String displayDate = DWCUtil.getDiaplayDate(modifiedDate); String image = DWCUtil.getGalleryImageUrl(fileId,
		 * _category, themeDisplay.getScopeGroupId()); content = HtmlUtil.stripHtml(content.trim()); if
		 * (Validator.isNotNull(title) && title.length() > titleMaxLength) { title = title.substring(0, titleMaxLength) +
		 * "..."; } if (Validator.isNotNull(content) && content.length() > contentMaxLength) { content =
		 * content.substring(0, contentMaxLength) + "..."; } String profileUrl = DWCUtil.getProfileViewDetailUrl(userId);
		 * String detailUrl = PortfolioGalleryLocalServiceUtil.getPortfolioDetailURL(String.valueOf(classPK), fileId,
		 * userId, themeDisplay); wrappers.add(new DWCWrapper(title, detailUrl, content, image, userName, profileUrl,
		 * modifiedDate, displayDate)); }
		 * 
		 * }catch(Exception e) { _log.error(e.getMessage(), e); }
		 * 
		 * } return wrappers; }
		 **/
		public List<DWCWrapper> searchLastestJobs(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String jobNumStr = (String) paramsMap.get("jobNum");

				int end = 0;
				try {
					end = Integer.valueOf(jobNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}

				String titleMaxLengthStr = (String) paramsMap.get("titleMaxLength");
				int titleMaxLength = 0;
				try {
					titleMaxLength = Integer.valueOf(titleMaxLengthStr);
				} catch (NumberFormatException nfe) {
					titleMaxLength = 0;
				}
				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(searchContext,keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext,tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}
					searchContext.setBooleanClauses(booleanClauses);

					Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					if ("Logined User".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);
						searchContext.setAttribute("searchByUserId", themeDisplay.getUserId());
					} else if ("Public Profile".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);

						long remoteUserId = themeDisplay.getUserId();
						String friendlyURL = (String) paramsMap.get("currentURL");
						long companyId = themeDisplay.getCompanyId();
						long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
						if (profileUserId == 0) {
							profileUserId = remoteUserId;
						}
						searchContext.setAttribute("searchByUserId", profileUserId);
					} else if ("All".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", false);
					}

					Indexer indexer = IndexerRegistryUtil.getIndexer(SPJob.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						String title = GetterUtil.getString(doc.get(Field.TITLE));
						String content = GetterUtil.getString(doc.get(Field.DESCRIPTION));
						long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
						String userName = GetterUtil.getString(doc.get(Field.USER_NAME));
						long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						String image = DWCUtil.getJobsImageUrl(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
								GetterUtil.getString(doc.get("jobsSmallImageDocId")));

						content = HtmlUtil.stripHtml(content.trim());

						if (Validator.isNotNull(title) && title.length() > titleMaxLength) {
							title = title.substring(0, titleMaxLength) + "...";
						}
						if (Validator.isNotNull(content) && content.length() > contentMaxLength) {
							content = content.substring(0, contentMaxLength) + "...";
						}
						String detailUrl = DWCUtil.getJobDetailViewUrl(portalURL, themeDisplay.getScopeGroupId(), classPK);
						String profileUrl = DWCUtil.getProfileViewDetailUrl(userId);

						wrappers.add(new DWCWrapper(title, detailUrl, content, image, userName, profileUrl, modifiedDate,
								displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;

		}

		public List<DWCWrapper> searchLastestEvents(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {
			String eventDetailPageName = (String) paramsMap.get("eventDetailPageName");

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String eventNumStr = (String) paramsMap.get("eventNum");

				int end = 0;
				try {
					end = Integer.valueOf(eventNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}

				String titleMaxLengthStr = (String) paramsMap.get("titleMaxLength");
				int titleMaxLength = 0;
				try {
					titleMaxLength = Integer.valueOf(titleMaxLengthStr);
				} catch (NumberFormatException nfe) {
					titleMaxLength = 0;
				}
				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(searchContext,keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext,tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}
					searchContext.setBooleanClauses(booleanClauses);

					Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					if ("Logined User".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);
						searchContext.setAttribute("searchByUserId", themeDisplay.getUserId());
					} else if ("Public Profile".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", true);

						long remoteUserId = themeDisplay.getUserId();
						String friendlyURL = (String) paramsMap.get("currentURL");
						long companyId = themeDisplay.getCompanyId();
						long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
						if (profileUserId == 0) {
							profileUserId = remoteUserId;
						}
						searchContext.setAttribute("searchByUserId", profileUserId);
					} else if ("All".equalsIgnoreCase(category)) {
						searchContext.setAttribute("isSearchByUserId", false);
					}

					Indexer indexer = IndexerRegistryUtil.getIndexer(CalEvent.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						String title = GetterUtil.getString(doc.get(Field.TITLE));
						String content = GetterUtil.getString(doc.get(Field.DESCRIPTION));
						long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
						String userName = GetterUtil.getString(doc.get(Field.USER_NAME));
						long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						content = HtmlUtil.stripHtml(content.trim());
						if (Validator.isNotNull(title) && title.length() > titleMaxLength) {
							title = title.substring(0, titleMaxLength) + "...";
						}
						if (Validator.isNotNull(content) && content.length() > contentMaxLength) {
							content = content.substring(0, contentMaxLength) + "...";
						}

						String detailUrl = eventDetailPageName + "/-/event/view_event/" + classPK;

						List<String> images = getEventsImageMap(themeDisplay.getScopeGroupId(), classPK);

						String image = images.size() > 0 ? images.get(0) : StringPool.BLANK;

						String profileUrl = DWCUtil.getProfileViewDetailUrl(userId);
						wrappers.add(new DWCWrapper(title, detailUrl, content, image, userName, profileUrl, modifiedDate,
								displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;
		}

		private List<String> getEventsImageMap(long respositoryId, long eventId) {
			long parentFolderId = 0;
			List<String> imageUrl = new ArrayList<String>();

			try {
				Folder folder = DLAppServiceUtil.getFolder(respositoryId, 0, "EventsImages");
				if (folder != null) {
					parentFolderId = folder.getFolderId();
				}

				Folder subFolder = DLAppServiceUtil.getFolder(respositoryId, parentFolderId, "Event_" + eventId);

				List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(respositoryId, subFolder.getFolderId());

				for (FileEntry file : fileEntries) {
					imageUrl.add("/documents/" + respositoryId + "/" + subFolder.getFolderId() + "/" + file.getTitle());
				}

			} catch (Exception e) {
				_log.error(e.getMessage());
			}

			return imageUrl;
		}

		public List<DWCWrapper> searchLastestSPAssets(ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {

			List<DWCWrapper> wrappers = new ArrayList<DWCWrapper>(0);
			String category = (String) paramsMap.get("category");

			if (Validator.isNotNull(category)) {
				String spAssetNumStr = (String) paramsMap.get("spAssetNum");

				int end = 0;
				try {
					end = Integer.valueOf(spAssetNumStr);
				} catch (NumberFormatException nfe) {
					end = 0;
				}

				String titleMaxLengthStr = (String) paramsMap.get("titleMaxLength");
				int titleMaxLength = 0;
				try {
					titleMaxLength = Integer.valueOf(titleMaxLengthStr);
				} catch (NumberFormatException nfe) {
					titleMaxLength = 0;
				}
				String contentMaxLengthStr = (String) paramsMap.get("contentMaxLength");
				int contentMaxLength = 0;
				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setStart(0);
					searchContext.setEnd(end);

					String searchByKeywords = (String) paramsMap.get("searchByKeywords");
					String[] searchKeywordsFields = (String[]) paramsMap.get("searchKeywordsFields");

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					if (Validator.isNotNull(searchByKeywords)) {
						if (searchKeywordsFields.length > 0) {
							for (String searchKeywordsField : searchKeywordsFields) {
								BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
								keywordsBooleanQuery.addRequiredTerm(searchKeywordsField, searchByKeywords);
								BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(searchContext,keywordsBooleanQuery,
										BooleanClauseOccur.MUST.getName());
								booleanClauseList.add(keywordsBooleanClause);
							}
						} else {
							searchContext.setKeywords(searchByKeywords);
						}
					}

					String searchByTag = (String) paramsMap.get("searchByTag");
					if (Validator.isNotNull(searchByTag)) {
						BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						tagBooleanQuery.addRequiredTerm("assetTagNames", "\"" + searchByTag + "\"");
						BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext,tagBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(tagBooleanClause);
					}

					String searchByCategory = (String) paramsMap.get("searchByCategory");
					if (Validator.isNotNull(searchByCategory)) {
						BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						categoryBooleanQuery.addRequiredTerm("assetCategoryNames", "\"" + searchByCategory + "\"");
						BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(categoryBooleanClause);
					}

					long selectedSPAssetTypeId = (Long) paramsMap.get("selectedSPAssetTypeId");
					if (Validator.isNotNull(selectedSPAssetTypeId)) {
						BooleanQuery spAssetTypeBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						spAssetTypeBooleanQuery.addRequiredTerm("spAssetTypeId", "\"" + selectedSPAssetTypeId + "\"");
						BooleanClause spAssetTypeBooleanClause = BooleanClauseFactoryUtil.create(searchContext,spAssetTypeBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(spAssetTypeBooleanClause);
					}

					Sort sort = SortFactoryUtil.create(Field.CREATE_DATE, Sort.LONG_TYPE, true);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);

					boolean isSearchByUserId = false;
					long searchByUserId = 0;
					if ("Logined User".equalsIgnoreCase(category)) {
						isSearchByUserId = true;
						searchByUserId = themeDisplay.getUserId();
					} else if ("Public Profile".equalsIgnoreCase(category)) {
						long remoteUserId = themeDisplay.getUserId();
						String friendlyURL = (String) paramsMap.get("currentURL");
						long companyId = themeDisplay.getCompanyId();
						long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
						if (profileUserId == 0) {
							profileUserId = remoteUserId;
						}
						isSearchByUserId = true;
						searchByUserId = profileUserId;
					} else if ("All".equalsIgnoreCase(category)) {
						// do nothing
					}

					if (isSearchByUserId && Validator.isNotNull(searchByUserId)) {
						BooleanQuery userIdBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						userIdBooleanQuery.addRequiredTerm(Field.USER_ID, searchByUserId);
						BooleanClause userIdBooleanClause = BooleanClauseFactoryUtil.create(searchContext,userIdBooleanQuery,
								BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(userIdBooleanClause);
					}

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
					for (int i = 0; i < booleanClauseList.size(); i++) {
						booleanClauses[i] = booleanClauseList.get(i);
					}
					searchContext.setBooleanClauses(booleanClauses);

					Indexer indexer = IndexerRegistryUtil.getIndexer(SPAssetEntry.class.getName());
					Hits results = indexer.search(searchContext);

					for (int i = 0; i < results.getDocs().length; i++) {
						Document doc = results.doc(i);
						String title = GetterUtil.getString(doc.get(Field.TITLE));
						String description = GetterUtil.getString(doc.get(Field.DESCRIPTION));
						long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
						String userName = GetterUtil.getString(doc.get(Field.USER_NAME));

						String urlTitle = GetterUtil.getString(doc.get("spAssetUrlTitle"));
						Date modifiedDate = GetterUtil.getDate(doc.getDate(Field.MODIFIED_DATE),
								DateFormat.getDateInstance());

						long coverFileEntryId = GetterUtil.getLong(doc.get("coverFileEntryId"));
						long spAssetTypeId = GetterUtil.getLong(doc.get("spAssetTypeId"));
						String detailPageName = StringPool.BLANK;
						try {
							SPAssetType spAssetType = SPAssetTypeLocalServiceUtil.getSPAssetType(spAssetTypeId);
							if (spAssetType != null) {
								detailPageName = spAssetType.getSpAssetTypeDetailUrl();
							}
						} catch (NoSuchTypeException nste) {
							// do nothing
						}
						FileEntry coverFileEntry = null;
						try {
							coverFileEntry = DLAppLocalServiceUtil.getFileEntry(coverFileEntryId);
						} catch (NoSuchFileEntryException nsfee) {
							// do nothing
						}
						String image = StringPool.BLANK;
						if (coverFileEntry != null) {
							image = DWCUtil.getSPAssetEntryThumbnailURL(themeDisplay, coverFileEntry);
						}

						String displayDate = DWCUtil.getDiaplayDate(modifiedDate);
						title = StringUtil.shorten(title, titleMaxLength);
						description = StringUtil.shorten(description, contentMaxLength);
						String detailUrl = DWCUtil.getSPAssetViewDetailUrl(portalURL, themeDisplay.getScopeGroupId(),
								urlTitle, detailPageName);
						String profileUrl = DWCUtil.getProfileViewDetailUrl(userId);
						wrappers.add(new DWCWrapper(title, detailUrl, description, image, userName, profileUrl,
								modifiedDate, displayDate));
					}

				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
			return wrappers;
		}

		private List<SPAssetType> getAssetTypes() {
			List<SPAssetType> assetTypes = new ArrayList<SPAssetType>();
			try {
				assetTypes = SPAssetTypeLocalServiceUtil.getSPAssetTypes(-1, -1);
			} catch (SystemException e) {
				_log.error(e.getMessage(), e);
			}
			return assetTypes;
		}

		private static Log _log = LogFactoryUtil.getLog(SearchAction.class);

		private String portalURL = StringPool.BLANK;

		private final String _DEFAULT_LISTING_STYLE = "vertical";

}
