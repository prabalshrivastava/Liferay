package com.sambaash.platform.portlet.spblogs.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.spblogs.listener.BlogsEntryListener;
import com.sambaash.platform.portlet.spblogs.util.ActionUtil;
import com.sambaash.platform.portlet.spblogs.wrapper.AllChannelWrapper;
import com.sambaash.platform.portlet.spblogs.wrapper.ChannelWrapper;
import com.sambaash.platform.portlet.spblogs.wrapper.SPBlogWrapper;
import com.sambaash.platform.util.OmnitureUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPBlogsAction
 */
public class SPBlogsAction extends MVCPortlet {

	@SuppressWarnings("unchecked")
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		BlogsEntry currentBlogsEntry = null;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			PortletPreferences preferences = renderRequest.getPreferences();
			String selectedAssetVocabularyIds = preferences.getValue("selectedAssetVocabularyIds", StringPool.BLANK);
			String itermsPerPageStr = preferences.getValue("itermsPerPage", "8");
			String topAlignStr = preferences.getValue("topAlign", "0");
			boolean enableDisqus = Boolean.valueOf(preferences.getValue("enableDisqus", StringPool.TRUE));
			boolean enableComments = Boolean.valueOf(preferences.getValue("enableComments", StringPool.TRUE));
			String disqusShortname = preferences.getValue("disqusShortname", StringPool.BLANK);
			int itermsPerPage = 8;
			try {
				itermsPerPage = Integer.valueOf(itermsPerPageStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			int topAlign = 0;
			try {
				topAlign = Integer.valueOf(topAlignStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			List<AllChannelWrapper> allWrappers = getAllChannelWrappers(selectedAssetVocabularyIds);

			renderRequest.setAttribute("itermsPerPage", itermsPerPage);
			renderRequest.setAttribute("topAlign", topAlign);
			renderRequest.setAttribute("enableDisqus", enableDisqus);
			renderRequest.setAttribute("enableComments", enableComments);
			renderRequest.setAttribute("disqusShortname", disqusShortname);
			renderRequest.setAttribute("socialShare", SambaashUtil.isSocialShareEnabled());

			renderRequest.setAttribute("allChannelWrappers", allWrappers);

			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
			HttpServletRequest originalHttpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			String channel = originalHttpRequest.getParameter("channel");
			
			//TODO: Cleanup. All request parameters should be sanitized before processed by any application.
			boolean found = false;
			String selectedCategories = StringPool.BLANK;
			for (AllChannelWrapper allWrapper : allWrappers) {
				if (checkCategory(allWrapper.getChannelWrappers(), channel)) {
					found = true;
					break;
				}
			}

			if (!found)
				channel = StringPool.BLANK;

			renderRequest.setAttribute("channel", channel);

			currentBlogsEntry = ActionUtil.getEntry(renderRequest);

			if (currentBlogsEntry != null) {
				SPBlogWrapper spBlogWrapper = new SPBlogWrapper();
				spBlogWrapper.setEntryId(currentBlogsEntry.getEntryId());
				spBlogWrapper.setTitle(HtmlUtil.escape(currentBlogsEntry.getTitle()));
				spBlogWrapper.setDescription(currentBlogsEntry.getDescription());
				spBlogWrapper.setContent(currentBlogsEntry.getContent());
				spBlogWrapper.setImageUrl(
						getSPBlogImageUrl(currentBlogsEntry.getContent(), 3, PortalUtil.getPortalURL(renderRequest)));
				spBlogWrapper.setAuthor(ActionUtil.getAuthor(currentBlogsEntry));
				spBlogWrapper.setDisplayDateString(dateFormat.format(currentBlogsEntry.getDisplayDate()));
				spBlogWrapper.setDisplayDate(currentBlogsEntry.getDisplayDate());
				spBlogWrapper.setUrlTitle(currentBlogsEntry.getUrlTitle());

				PortletURL spBlogDetailPortletURL = renderResponse.createRenderURL();
				try {
					spBlogDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
					spBlogDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
					spBlogDetailPortletURL.setParameter("struts_action", "/spblogs/view_entry");
					spBlogDetailPortletURL.setParameter("urlTitle", currentBlogsEntry.getUrlTitle());
					spBlogWrapper.setDetailUrl(spBlogDetailPortletURL.toString());
				} catch (WindowStateException e) {
				} catch (PortletModeException e) {
				}

				setDetailPageProperties(spBlogWrapper, renderRequest, channel);

				renderRequest.setAttribute("spBlogWrapper", spBlogWrapper);
			} else {

				Map<String, Object> landingMap = searchSPBlogs(themeDisplay.getLayout().getFriendlyURL(),
						themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), 0, 3, channel, true, 3,
						currentBlogsEntry,allWrappers);

				List<SPBlogWrapper> landingSPBlogWrappers = (List<SPBlogWrapper>) landingMap.get("spBlogWrappers");
				renderRequest.setAttribute("landingSPBlogWrappers", landingSPBlogWrappers);
			}

			Map<String, Object> nextMap = searchSPBlogs(themeDisplay.getLayout().getFriendlyURL(),
					themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), 0, 2, channel, true, 1,
					currentBlogsEntry,allWrappers);

			List<SPBlogWrapper> nextSPBlogWrappers = (List<SPBlogWrapper>) nextMap.get("spBlogWrappers");

			SPBlogWrapper nextSPBlogWrapper = null;

			if (nextSPBlogWrappers.size() > 1) {
				nextSPBlogWrapper = nextSPBlogWrappers.get(1);
			}

			renderRequest.setAttribute("nextSPBlogWrapper", nextSPBlogWrapper);

			Map<String, Object> prevMap = searchSPBlogs(themeDisplay.getLayout().getFriendlyURL(),
					themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), 0, 2, channel, false, 1,
					currentBlogsEntry,allWrappers);

			List<SPBlogWrapper> prevSPBlogWrappers = (List<SPBlogWrapper>) prevMap.get("spBlogWrappers");

			SPBlogWrapper prevSPBlogWrapper = null;

			if (prevSPBlogWrappers.size() > 1) {
				prevSPBlogWrapper = prevSPBlogWrappers.get(1);
			}

			renderRequest.setAttribute("prevSPBlogWrapper", prevSPBlogWrapper);

			Map<String, Object> relatedSPBlogsMap = searchRelatedSPBlogs(themeDisplay.getLayout().getFriendlyURL(),
					themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), 0, 7, 3, currentBlogsEntry);

			if (Validator.isNotNull(relatedSPBlogsMap)) {
				List<SPBlogWrapper> relatedSPBlogWrappers = (List<SPBlogWrapper>) relatedSPBlogsMap
						.get("spBlogWrappers");
				List<SPBlogWrapper> relatedSPBlogWrappersCopy = new ArrayList<SPBlogWrapper>();

				for (SPBlogWrapper relatedSPBlogWrapper : relatedSPBlogWrappers) {
					if (currentBlogsEntry.getEntryId() != relatedSPBlogWrapper.getEntryId()) {
						if (!relatedSPBlogWrappersCopy.contains(relatedSPBlogWrapper)) {
							relatedSPBlogWrappersCopy.add(relatedSPBlogWrapper);
						}
					}
				}

				if (relatedSPBlogWrappersCopy.size() < 6) {
					Map<String, Object> lastestSPBlogsMap = searchLastestSPBlogs(
							themeDisplay.getLayout().getFriendlyURL(), themeDisplay.getCompanyId(),
							themeDisplay.getPortalURL(), 0, (6 - relatedSPBlogWrappersCopy.size() + 1), 3);
					List<SPBlogWrapper> lastestSPBlogWrappers = (List<SPBlogWrapper>) lastestSPBlogsMap
							.get("spBlogWrappers");

					for (SPBlogWrapper lastestSPBlogWrapper : lastestSPBlogWrappers) {
						if (currentBlogsEntry.getEntryId() != lastestSPBlogWrapper.getEntryId()) {
							if (!relatedSPBlogWrappersCopy.contains(lastestSPBlogWrapper)) {
								relatedSPBlogWrappersCopy.add(lastestSPBlogWrapper);
							}
						}
					}
				}

				renderRequest.setAttribute("relatedSPBlogWrappers", relatedSPBlogWrappersCopy);
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();
			String action = actionRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String selectedAssetVocabularyIds = actionRequest.getParameter("selectedAssetVocabularyIds");
				String itermsPerPage = actionRequest.getParameter("itermsPerPage");
				String topAlign = actionRequest.getParameter("topAlign");
				String enableDisqus = actionRequest.getParameter("enableDisqus");
				String enableComments = actionRequest.getParameter("enableComments");
				String disqusShortname = actionRequest.getParameter("disqusShortname");

				preferences.setValue("selectedAssetVocabularyIds", selectedAssetVocabularyIds);
				preferences.setValue("itermsPerPage", itermsPerPage);
				preferences.setValue("topAlign", topAlign);
				preferences.setValue("enableDisqus", enableDisqus);
				preferences.setValue("enableComments", enableComments);
				preferences.setValue("disqusShortname", disqusShortname);
				preferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			StringBuffer sb = new StringBuffer();
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

			for (AssetVocabulary av : assetVocabularies) {
				sb.append(av.getName() + ": " + av.getVocabularyId() + ", ");
			}

			renderRequest.setAttribute("assetVocabulariesString", sb.toString());
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String action = resourceRequest.getParameter("action");
			PortletPreferences preferences = resourceRequest.getPreferences();
			String selectedAssetVocabularyIds = preferences.getValue("selectedAssetVocabularyIds", StringPool.BLANK);
			List<AllChannelWrapper> allWrappers = getAllChannelWrappers(selectedAssetVocabularyIds);

			if ("retrieve".equalsIgnoreCase(action)) {
				String channel = resourceRequest.getParameter("channel");

				String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}

				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;
				int end = start + offset;

				BlogsEntry currentBlogsEntry = ActionUtil.getEntry(resourceRequest);
				
				Map<String, Object> map = searchSPBlogs(themeDisplay.getLayout().getFriendlyURL(),
						themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), start, end, channel, true, 1, null,allWrappers);

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				List<SPBlogWrapper> spBlogWrappers = (List<SPBlogWrapper>) map.get("spBlogWrappers");
				int count = (Integer) map.get("count");

				for (SPBlogWrapper spBlogWrapper : spBlogWrappers) {
					JSONObject item = JSONFactoryUtil.createJSONObject();
					String html = "<li data-spblog-id=\"" + spBlogWrapper.getEntryId()
							+ "\" class=\"spblogs-stream-item aui-helper-clearfix block padding-quarter box-sizing-border font-none   "
							+ (currentBlogsEntry != null && spBlogWrapper.getEntryId() == currentBlogsEntry.getEntryId()
									? " active " : "")
							+ "\">" + "<div class=\"spblogs-thumb inline-block font-std align-top line-none \">"
							+ "<a title=\"" + spBlogWrapper.getTitle() + "\" href=\"" + spBlogWrapper.getDetailUrl()
							+ "/\"><img width=\"60\" height=\"50\" alt=\"" + spBlogWrapper.getTitle() + "\" title=\"" + spBlogWrapper.getTitle() + "\" src=\""
							+ spBlogWrapper.getImageUrl() + "\"></a>" + "</div>"
							+ "<div class=\"spblogs-body inline-block font-std align-top padding-left-quarter padding-right-quarter box-sizing-border  \">"
							+ "<h5><a title=\"" + spBlogWrapper.getTitle() + "\" href=\"" + spBlogWrapper.getDetailUrl()
							+ "\" class=\"block spblogs-title spblogs-title\">" + spBlogWrapper.getTitle() + "</a></h5>"
							+ "<div class=\"block spblogs-date spblogs-date\">" + spBlogWrapper.getTimeDifference()
							+ "</div>" + "</div>" + "</li>";

					item.put("html", html);
					items.put(item);
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());

			} else if ("retrieveHilight".equalsIgnoreCase(action)) {
				String channel = resourceRequest.getParameter("channel");

				String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}

				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;
				int end = start + offset;

				if (start == 0) {
					end = end + 3;
				}
				
				Map<String, Object> map = searchSPBlogs(themeDisplay.getLayout().getFriendlyURL(),
						themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), start, end, channel, true, 3, null,allWrappers);

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				List<SPBlogWrapper> spBlogWrappers = (List<SPBlogWrapper>) map.get("spBlogWrappers");
				int count = (Integer) map.get("count");

				for (int i = 0; i < spBlogWrappers.size(); i++) {
					SPBlogWrapper spBlogWrapper = spBlogWrappers.get(i);
					JSONObject item = JSONFactoryUtil.createJSONObject();
					String display = StringPool.BLANK;

					if ((i + start) < 3) {
						display = "display: none;";
					}
					String html = "<li style=\"" + display + "\">" + "<div class=\"spblogs-main\"> "
							+ "<div class=\"spblogs-main-image\"> " + "<a href=\"" + spBlogWrapper.getDetailUrl()
							+ "\">" + "<img alt=\"Blog Image\" style=\"width: 100%;\" src=\"" + spBlogWrapper.getImageUrl() + "\">"
							+ "</a> " + "</div> " + "<div class=\"spblogs-main-content-head\"> "
							+ "<div class=\"spblogs-content-author\"> "
							+ "<span class=\"spblogs-article-author-name\">By <a rel=\"author\" title=\"Posts by "
							+ spBlogWrapper.getAuthor() + "\" href=\"\">" + spBlogWrapper.getAuthor()
							+ "</a>, </span> <span class=\"spblogs-article-date\">"
							+ spBlogWrapper.getDisplayDateString() + "</span> " + "</div> " + "<a href=\""
							+ spBlogWrapper.getDetailUrl() + "\"><span class=\"spblogs-content-right-title\">"
							+ spBlogWrapper.getTitle() + "</a> " + "</div> " + "</div>" + "</li>";

					item.put("html", html);
					items.put(item);
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private List<AllChannelWrapper> getAllChannelWrappers(String selectedAssetVocabularyIds)
			throws PortalException, SystemException {
		List<AllChannelWrapper> allChannelWrappers = null;

		if (allChannelWrappers == null || allChannelWrappers.size() < 1) {
			allChannelWrappers = new ArrayList<AllChannelWrapper>();

			if (Validator.isNotNull(selectedAssetVocabularyIds)) {
				String[] selectedAssetVocabularyIdArray = StringUtil.split(selectedAssetVocabularyIds);

				for (String selectedAssetVocabularyIdStr : selectedAssetVocabularyIdArray) {
					try {
						long selectedAssetVocabularyId = Long.valueOf(selectedAssetVocabularyIdStr);
						AssetVocabulary selectedAssetVocabulary = AssetVocabularyLocalServiceUtil
								.getAssetVocabulary(selectedAssetVocabularyId);
						AllChannelWrapper allChannelWrapper = new AllChannelWrapper();
						allChannelWrapper.setVocabularyId(selectedAssetVocabularyId);
						allChannelWrapper.setVocabularyName(selectedAssetVocabulary.getName());
						List<AssetCategory> selectedAssetCategories = AssetCategoryLocalServiceUtil
								.getVocabularyCategories(0, selectedAssetVocabularyId, -1, -1, null);

						List<ChannelWrapper> channelWrappers = new ArrayList<ChannelWrapper>();

						for (AssetCategory selectedAssetCategory : selectedAssetCategories) {
							ChannelWrapper channelWrapper = new ChannelWrapper();
							channelWrapper.setCategoryId(selectedAssetCategory.getCategoryId());
							channelWrapper.setCategoryName(selectedAssetCategory.getName());
							channelWrappers.add(channelWrapper);

							List<AssetCategory> selectedChildAssetCategories = AssetCategoryLocalServiceUtil
									.getChildCategories(selectedAssetCategory.getCategoryId());

							for (AssetCategory selectedChildAssetCategory : selectedChildAssetCategories) {
								ChannelWrapper channelChildWrapper = new ChannelWrapper();
								channelChildWrapper.setCategoryId(selectedChildAssetCategory.getCategoryId());
								channelChildWrapper.setCategoryName(selectedChildAssetCategory.getName());
								channelChildWrapper.setChild(true);
								channelWrappers.add(channelChildWrapper);
							}

						}

						allChannelWrapper.setChannelWrappers(channelWrappers);
						allChannelWrappers.add(allChannelWrapper);
					} catch (NumberFormatException nfe) {

						// do nothing

					}
				}
			}
		}

		return allChannelWrappers;
	}

	private Map<String, Object> searchLastestSPBlogs(String pageFriendlyUrl, long companyId, String portalUrl,
			int start, int end, int imageThumbnail)
			throws SearchException, ParserException, ParseException, WindowStateException, PortletModeException,
			SystemException, com.liferay.portal.kernel.search.ParseException {

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		searchContext.setStart(start);
		searchContext.setEnd(end);

		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		Indexer indexer = IndexerRegistryUtil.getIndexer(BlogsEntry.class.getName());
		Hits results = indexer.search(searchContext);

		return getResultsMap(results, pageFriendlyUrl, portalUrl, StringPool.BLANK, imageThumbnail);
	}

	private Map<String, Object> searchRelatedSPBlogs(String pageFriendlyurl, long companyId, String portalUrl,
			int start, int end, int imageThumbnail, BlogsEntry currentBlogsEntry)
			throws SearchException, ParserException, ParseException, WindowStateException, PortletModeException,
			SystemException, com.liferay.portal.kernel.search.ParseException {

		if (Validator.isNotNull(currentBlogsEntry)) {
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(companyId);
			searchContext.setStart(start);
			searchContext.setEnd(end);

			long blogEntryId = currentBlogsEntry.getEntryId();

			String[] assetCategoryNames = AssetCategoryLocalServiceUtil.getCategoryNames(BlogsEntry.class.getName(),
					blogEntryId);
			String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(BlogsEntry.class.getName(), blogEntryId);

			List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();

			// categories
			BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);

			for (String assetCategoryName : assetCategoryNames) {
				// categoryBooleanQuery.addTerm(Field.ASSET_CATEGORY_NAMES, "\""
				// + assetCategoryName + "\"");
				categoryBooleanQuery.addTerm(Field.ASSET_CATEGORY_TITLES, "\"" + assetCategoryName + "\"");
			}

			BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext, categoryBooleanQuery,
					BooleanClauseOccur.MUST.getName());
			booleanClauseList.add(categoryBooleanClause);

			// tags

			BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);

			for (String assetTagName : assetTagNames) {
				tagBooleanQuery.addTerm(Field.ASSET_TAG_NAMES, "\"" + assetTagName + "\"");
			}

			BooleanClause tagBooleanClause = BooleanClauseFactoryUtil.create(searchContext, tagBooleanQuery,
					BooleanClauseOccur.SHOULD.getName());
			booleanClauseList.add(tagBooleanClause);

			if (booleanClauseList.size() > 0) {
				BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];

				for (int i = 0; i < booleanClauseList.size(); i++) {
					booleanClauses[i] = booleanClauseList.get(i);
				}

				searchContext.setBooleanClauses(booleanClauses);
			}

			Indexer indexer = IndexerRegistryUtil.getIndexer(BlogsEntry.class.getName());
			Hits results = indexer.search(searchContext);

			return getResultsMap(results, pageFriendlyurl, portalUrl, StringPool.BLANK, imageThumbnail);
		}

		return null;
	}

	private Map<String, Object> searchSPBlogs(String pageFriendlyUrl, long companyId, String portalUrl, int start,
			int end, String channel, boolean next, int imageThumbnail, BlogsEntry currentBlogsEntry, List<AllChannelWrapper> allWrappers)
			throws SearchException, ParserException, ParseException, WindowStateException, PortletModeException {
		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(companyId);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		Sort sort = null;

		if (next) {
			sort = SortFactoryUtil.create("displayDate", Sort.LONG_TYPE, true);
		} else {
			sort = SortFactoryUtil.create("displayDate", Sort.LONG_TYPE, false);
		}

		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();

		if (Validator.isNotNull(channel)) {
			BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
			// categoryBooleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_NAMES,
			// "\"" + channel + "\"");
			categoryBooleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_TITLES, "\"" + channel + "\"");
			BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext, categoryBooleanQuery,
					BooleanClauseOccur.MUST.getName());
			booleanClauseList.add(categoryBooleanClause);
		}
		if(Validator.isNotNull(allWrappers) && !allWrappers.isEmpty()){
			BooleanQuery categoryBooleanQuery1 = BooleanQueryFactoryUtil.create(searchContext);
			for (AllChannelWrapper allWrapper : allWrappers) {
				for (ChannelWrapper wrapper : allWrapper.getChannelWrappers()) {
					try {
						categoryBooleanQuery1.addTerm(Field.ASSET_CATEGORY_IDS, wrapper.getCategoryId());
					} catch (com.liferay.portal.kernel.search.ParseException e) {
						_log.error(e.getMessage());
					}
				}
			}
			BooleanClause categoryBooleanClause1 = BooleanClauseFactoryUtil.create(searchContext, categoryBooleanQuery1,
					BooleanClauseOccur.MUST.getName());
			booleanClauseList.add(categoryBooleanClause1);
		}	
		

		if (currentBlogsEntry != null) {
			Calendar fromCalendar = Calendar.getInstance();
			Calendar toCalendar = Calendar.getInstance();

			fromCalendar.setTime(currentBlogsEntry.getModifiedDate());
			toCalendar.setTime(currentBlogsEntry.getModifiedDate());

			if (next) {
				fromCalendar.add(Calendar.YEAR, -100);
			} else {
				toCalendar.add(Calendar.YEAR, 100);
			}

			String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(DATE_FORMAT_PATTERN)
					.format(fromCalendar.getTime());
			String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(DATE_FORMAT_PATTERN)
					.format(toCalendar.getTime());

			BooleanQuery dateBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
			dateBooleanQuery.addRangeTerm(Field.MODIFIED_DATE, fromDateString, toDateString);
			BooleanClause dateBooleanClause = BooleanClauseFactoryUtil.create(searchContext, dateBooleanQuery,
					BooleanClauseOccur.MUST.getName());
			booleanClauseList.add(dateBooleanClause);
		}

		if (booleanClauseList.size() > 0) {
			BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];

			for (int i = 0; i < booleanClauseList.size(); i++) {
				booleanClauses[i] = booleanClauseList.get(i);
			}

			searchContext.setBooleanClauses(booleanClauses);
		}

		Indexer indexer = IndexerRegistryUtil.getIndexer(BlogsEntry.class.getName());
		Hits results = indexer.search(searchContext);

		return getResultsMap(results, pageFriendlyUrl, portalUrl, channel, imageThumbnail);
	}

	private Map<String, Object> getResultsMap(Hits results, String pageFriendlyUrl, String portalUrl, String channel,
			int imageThumbnail) throws ParserException, WindowStateException, PortletModeException, ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = results.getLength();

		Date now = new Date();

		int length = results.getDocs().length;

		List<SPBlogWrapper> spBlogWrappers = new ArrayList<SPBlogWrapper>();

		for (int i = 0; i < length; i++) {
			SPBlogWrapper spBlogWrapper = new SPBlogWrapper();

			Document doc = results.doc(i);
			long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

			String title = GetterUtil.getString(doc.get(Field.TITLE));

			String description = GetterUtil.getString(doc.get(Field.DESCRIPTION));
			String content = GetterUtil.getString(doc.get(Field.CONTENT));
			content = HtmlUtil.stripHtml(content.trim());
			String urlTitle = GetterUtil.getString(doc.get("urlTitle"));

			String image = getSPBlogImageUrl(description, imageThumbnail, portalUrl);

			Date displayDate = GetterUtil.getDate(doc.getDate("displayDate"), DateFormat.getDateInstance());
			String timeDifference = getTimeDifference(displayDate, now);

			String spBlogDetailURL = "%s%s/-/blogs/%s";
			spBlogDetailURL = String.format(spBlogDetailURL, portalUrl, pageFriendlyUrl, urlTitle);

			if (Validator.isNotNull(channel)) {
				spBlogDetailURL += "?channel=" + channel;
			}

			spBlogWrapper.setEntryId(classPK);
			spBlogWrapper.setTitle(title);
			spBlogWrapper.setDescription(description);
			spBlogWrapper.setAuthor(GetterUtil.getString(doc.get("author")));
			spBlogWrapper.setContent(
					(Validator.isNotNull(content) && content.length() > 300) ? content.substring(0, 300) : content);
			spBlogWrapper.setDetailUrl(spBlogDetailURL);
			spBlogWrapper.setImageUrl(image);
			spBlogWrapper.setDisplayDateString(dateFormat.format(doc.getDate("displayDate")));
			spBlogWrapper.setDisplayDate(displayDate);
			spBlogWrapper.setTimeDifference(timeDifference);

			spBlogWrappers.add(spBlogWrapper);
		}
		map.put("spBlogWrappers", spBlogWrappers);
		map.put("count", count);

		return map;
	}

	private String getSPBlogImageUrl(String content, int imageThumbnail, String portalUrl) throws ParserException {
		String image = getImageUrlFromHtml(content);
		if (Validator.isNotNull(image) && image.startsWith(portalUrl) || image.startsWith(StringPool.FORWARD_SLASH)) {
			if (image.indexOf(StringPool.QUESTION) != -1) {
				image = image + "&imageThumbnail=" + imageThumbnail;
			} else {
				image = image + "?imageThumbnail=" + imageThumbnail;
			}
		}
		return image;
	}

	private String getSharingVideoUrlFromHtml(String content) throws ParserException {
		String videoUrl = StringPool.BLANK;
		Parser parser = Parser.createParser(content, "UTF-8");
		NodeFilter filter = new AndFilter(new TagNameFilter("source"), new HasAttributeFilter("type", "video/mp4"));

		NodeList nodeList = parser.parse(filter);
		Node node = null;

		if (nodeList.size() > 0) {
			node = nodeList.elementAt(0);
			videoUrl = ((TagNode) node).getAttribute("src");
		}

		if (videoUrl.indexOf("?") != -1) {
			videoUrl = videoUrl.substring(0, videoUrl.indexOf("?"));
		}

		videoUrl = videoUrl.replaceFirst("/documents", "/spasset/video");
		return videoUrl;
	}

	private String getImageUrlFromHtml(String content) throws ParserException {
		String image = StringPool.BLANK;
		Parser parser = Parser.createParser(content, DEFAULTCHARSET);
		TagNameFilter filter = new TagNameFilter("img");
		NodeList nodeList3 = parser.parse(filter);
		Node node = null;
		if (nodeList3.size() > 0) {
			node = nodeList3.elementAt(0);
			image = ((ImageTag) node).getAttribute("src");
		}

		return image;
	}

	private String getTimeDifference(Date d1, Date d2) {
		String timeDiff = "";

		DateTime dt1 = new DateTime(d1);
		DateTime dt2 = new DateTime(d2);

		Years yearDiff = Years.yearsBetween(dt1, dt2);
		int years = yearDiff.getYears();

		if (years == 0) {
			Months monthDiff = Months.monthsBetween(dt1, dt2);
			int months = monthDiff.getMonths();

			if (months == 0) {
				Days dayDiff = Days.daysBetween(dt1, dt2);
				int days = dayDiff.getDays();

				if (days == 0) {
					Hours hourDiff = Hours.hoursBetween(dt1, dt2);
					int hours = hourDiff.getHours();

					if (hours == 0) {
						Minutes minDiff = Minutes.minutesBetween(dt1, dt2);
						int minutes = minDiff.getMinutes();

						if (minutes == 0) {
							Seconds secDiff = Seconds.secondsBetween(dt1, dt2);
							int seconds = secDiff.getSeconds();

							if (seconds == 0) {
								timeDiff = "0 second ago";
							} else {
								if (seconds == 1) {
									timeDiff = "1 second ago";
								} else {
									timeDiff = seconds + " seconds ago";
								}
							}
						} else {
							if (minutes == 1) {
								timeDiff = "1 minute ago";
							} else {
								timeDiff = minutes + " minutes ago";
							}
						}
					} else {
						if (hours == 1) {
							timeDiff = "1 hour ago";
						} else {
							timeDiff = hours + " hours ago";
						}
					}
				} else {
					if (days == 1) {
						timeDiff = "1 day ago";
					} else {
						timeDiff = days + " days ago";
					}
				}
			} else {
				if (months == 1) {
					timeDiff = "1 month ago";
				} else {
					timeDiff = months + " months ago";
				}
			}
		} else {
			if (years == 1) {
				timeDiff = "1 year ago";
			} else {
				timeDiff = years + " years ago";
			}
		}

		return timeDiff;
	}

	private void setDetailPageProperties(SPBlogWrapper entry, RenderRequest renderRequest, String channel) {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String description = StringPool.BLANK;

		if (Validator.isNotNull(entry.getDescription())) {
			description = entry.getDescription();
		} else {
			String temp = HtmlUtil.stripHtml(entry.getContent());

			if (Validator.isNotNull(temp)) {
				description = HtmlUtil.stripHtml(temp.length() > 500 ? temp.substring(0, 500) : temp);
			}
		}

		String imageUrl = PortalUtil.getPortalURL(request) + entry.getImageUrl();
		String category = StringPool.BLANK;
		PortalUtil.setPageSubtitle(entry.getTitle(), request);
		PortalUtil.setPageDescription(description, request);
		
		renderRequest.setAttribute("ogtitle", entry.getTitle());
		renderRequest.setAttribute("ogdescription", description);
		renderRequest.setAttribute("ogimage", imageUrl);
		try {
			renderRequest.setAttribute("ogurl", URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8"));
			renderRequest.setAttribute("fbappid",FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
		} catch (UnsupportedEncodingException | SystemException e) {
			_log.error(e.getMessage());
		}
		
//		SambaashUtil.setOGTitle(entry.getTitle(), request);
//		SambaashUtil.setOGType("article", request);
//		SambaashUtil.setOGImage(imageUrl, request);
//		SambaashUtil.setOGUrl(entry.getDetailUrl(), request);
//		SambaashUtil.setOGSiteName(PortalUtil.getHost(request), request);
//		SambaashUtil.setOGDescription(description, request);
//		
//		SambaashUtil.setCustomFtlVariables(request, "ogTitle", "BlogsTitle");

		String videoUrl = StringPool.BLANK;
		try {
			videoUrl = PortalUtil.getPortalURL(renderRequest) + getSharingVideoUrlFromHtml(entry.getContent());
		} catch (ParserException pe) {

			// do nothing

		}

		SambaashUtil.setOGVideo(videoUrl, request);
		SambaashUtil.setOGVideoType("video/mp4", request);

		try {
			List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(BlogsEntry.class.getName(), entry.getEntryId());
			PortalUtil.setPageKeywords(ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR), request);
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
					.getCategories(BlogsEntry.class.getName(), entry.getEntryId());
			PortalUtil.addPageKeywords(ListUtil.toString(assetCategories, AssetCategory.NAME_ACCESSOR), request);

			if (assetCategories != null && assetCategories.size() > 0) {
				category = assetCategories.get(0).getName();
			}
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		PortalUtil.addPortletBreadcrumbEntry(request, entry.getTitle(), entry.getDetailUrl());

		// twitter

		SambaashUtil.setTwitterCard("summary", request);
		SambaashUtil.setTwitterDescription(description, request);
		SambaashUtil.setTwitterImage(imageUrl, request);
		SambaashUtil.setTwitterTitle(entry.getTitle(), request);
		SambaashUtil.setTwitterUrl(entry.getDetailUrl(), request);

		// schema

		SambaashUtil.setSchemaItempropItemtype("http://schema.org/ImageObject", request);
		SambaashUtil.setSchemaItempropContentUrl(entry.getDetailUrl(), request);
		SambaashUtil.setSchemaItempropDescription(description, request);
		SambaashUtil.setSchemaItempropName(entry.getTitle(), request);
		SambaashUtil.setSchemaItempropThumbnail(imageUrl, request);
		SambaashUtil.setSchemaItempropUrl(entry.getDetailUrl(), request);

		if (SambaashUtil.isOmnitureEnabled()) {
			String contentCategory = StringPool.BLANK;

			if ("videos".equalsIgnoreCase(channel)) {
				contentCategory = "videos";
			} else {
				contentCategory = "articles";
			}

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			SambaashUtil.setOmnitureTags(
					OmnitureUtil.getOmnitureTags(category, contentCategory, SambaashConstants.PAGE_TYPE.DETAIL_PAGE,
							format.format(entry.getDisplayDate()), Long.toString(entry.getEntryId()), entry.getTitle()),
					request);
		}

	}

	public void destroy() {
		BlogsEntryListener.shutdown();
		super.destroy();
	}

	private boolean checkCategory(List<ChannelWrapper> channelWrapperList, String channel) {
		boolean found = false;
		for (ChannelWrapper wrapper : channelWrapperList) {
			if (wrapper.getCategoryName().equalsIgnoreCase(channel)) {
				found = true;
				break;
			}
		}
		return found;
	}

	private final static String DEFAULTCHARSET = "UTF-8";

	private final String DATE_FORMAT_PATTERN = PropsUtil.get("index.date.format.pattern");

	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM ''yy");

	private static Log _log = LogFactoryUtil.getLog(SPBlogsAction.class);

}
