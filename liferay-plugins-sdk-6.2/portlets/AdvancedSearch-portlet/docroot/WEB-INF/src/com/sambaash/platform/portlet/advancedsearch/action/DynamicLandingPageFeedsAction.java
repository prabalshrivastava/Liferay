package com.sambaash.platform.portlet.advancedsearch.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.advancedsearch.util.ASUtil;
import com.sambaash.platform.portlet.advancedsearch.util.FeedConstants;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spservices.model.SPLdapProfile;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class DynamicLandingPageFeedsAction
 */
public class DynamicLandingPageFeedsAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil
			.getLog(DynamicLandingPageFeedsAction.class);

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));

		String eventsPageUrl = preferences.getValue("eventsPageUrl", "");
		String mediaPageUrl = preferences.getValue("mediaPageUrl", "");
		String blogsPageUrl = preferences.getValue("blogsPageUrl", "");
		String dscDetailPageName = preferences
				.getValue("dscDetailPageName", "");
		String docLibPageName = preferences.getValue("docLibPageName", "");

		Date d1 = Calendar.getInstance().getTime();
		List<String> docList = new ArrayList<String>();
		List<String> msgList = new ArrayList<String>();

		long scopeGroupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		String selectedDept = StringPool.BLANK;
		String selectedCountry = StringPool.BLANK;

		String folderNameToSearchDocOrder1 = StringPool.BLANK;
		String folderNameToSearchDocOrder2 = StringPool.BLANK;
		String folderNameToSearchDocOrder3 = StringPool.BLANK;
		String publicFolderFilterName = "Public Folder";

		String error = StringPool.BLANK;
		List<Role> usrRoleList = null;
		String feedPageTitle = LanguageUtil.get(themeDisplay.getLocale(),"label.my.feeds");

		final SPLdapProfile userProfile = SPLdapProfileLocalServiceUtil
				.findByUserId(userId);

		if (Validator.isNull(userProfile)) {
			renderRequest
					.setAttribute(
							"error",
							"Country & Department not found for the loggedin user (Or) CategoryId not found in current URL");
			super.doView(renderRequest, renderResponse);
			return;
		}

		String regional = SambaashConstants.COUNTRY_REGION;
		try {
			SPParameter paraConfigur = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(
							Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID),
							"countryRegional");
			regional = paraConfigur.getValue();
		} catch (Exception e1) {
		}

		final AssetCategory userCountryCatg = getAssetCategory(userProfile
				.getCountryId());
		final AssetCategory userDeptCatg = getAssetCategory(userProfile
				.getDepartmentId());
		final AssetCategory regionCatg = getCategoryFromName(
				userCountryCatg.getVocabularyId(), regional);
		final String cdFolderFormat = "%s-%s";
		String userCountryDeptCatgName = String.format(cdFolderFormat,
				userCountryCatg.getName(), userDeptCatg.getName());
		String regionalDeptCategoryName = String.format(cdFolderFormat,
				regional, userDeptCatg.getName());

		_log.error("userCountryDeptCatgName : " + userCountryDeptCatgName
				+ " - regionalDeptCategoryName : " + regionalDeptCategoryName);

		String searchPriority = preferences.getValue("searchPriority", "");

		String selectedCountryDeptCatgName = StringPool.BLANK;

		AssetCategory p1 = null;
		AssetCategory p2 = null;
		AssetCategory dept = null;

		String HEADER = "header";
		String IMAGE_PATH = "imagepath";
		String TEXT1 = "text1";
		String TEXT2 = "text2";
		String DURL = "detailUrl";
		String PAGE_URL = "pageUrl";
		final String imagePath = themeDisplay.getPathThemeImages();
		boolean isCustomFilter = false;
		try {
			String feedSearchCriteria = preferences.getValue(
					"feedSearchCriteria", "");
			selectedDept = GetterUtil.getString(httpRequest
					.getParameter("category"));
			selectedCountry = GetterUtil.getString(httpRequest
					.getParameter("parentCategory"));

			// If user visits home page selectedFilter will have null

			if (Validator.isNull(selectedDept)) {
				if (FeedConstants.COUNTRY_REGION
						.equalsIgnoreCase(feedSearchCriteria)) {
					if (FeedConstants.COUNTRY.equalsIgnoreCase(searchPriority)) {
						p1 = userCountryCatg;
						p2 = regionCatg;

						folderNameToSearchDocOrder1 = userCountryDeptCatgName;
						folderNameToSearchDocOrder2 = regionalDeptCategoryName;
						folderNameToSearchDocOrder3 = publicFolderFilterName;

					} else {
						p1 = regionCatg;
						p2 = userCountryCatg;

						folderNameToSearchDocOrder1 = regionalDeptCategoryName;
						folderNameToSearchDocOrder2 = publicFolderFilterName;
						folderNameToSearchDocOrder3 = "";
					}

					dept = userDeptCatg;

				} else {
					p1 = getAssetCategory(GetterUtil.getLong(preferences
							.getValue("feedSearchCatId", "")));
					isCustomFilter = true;

					folderNameToSearchDocOrder1 = userCountryDeptCatgName;
					folderNameToSearchDocOrder2 = publicFolderFilterName;
				}
			} else {
				p1 = getAssetCategory(GetterUtil.getLong(selectedCountry));
				dept = getAssetCategory(GetterUtil.getLong(selectedDept));

				selectedCountryDeptCatgName = String.format(cdFolderFormat,
						p1.getName(), dept.getName());

				folderNameToSearchDocOrder1 = selectedCountryDeptCatgName;
				folderNameToSearchDocOrder2 = publicFolderFilterName;
				folderNameToSearchDocOrder3 = "";
				_log.debug("selectedFilter not null "
						+ folderNameToSearchDocOrder1 + " "
						+ folderNameToSearchDocOrder2 + " "
						+ folderNameToSearchDocOrder3);

				feedPageTitle = p1.getName() + " " + dept.getName() + " Feeds";
			}

			_log.debug(" Feed Title " + feedPageTitle);

		} catch (Exception e) {
			_log.debug("Error getting User Role List " + e.getMessage());
		}

		_log.debug("selectedFilter " + selectedDept + " searchPriority "
				+ searchPriority);

		if (Validator.isNotNull(p1)) {
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setStart(0);
			try {
				usrRoleList = RoleLocalServiceUtil.getUserRoles(userId);
				int counter = 0;
				List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
				List<Document> eventSet = new ArrayList<Document>();
				List<Document> blogSet = new ArrayList<Document>();
				List<Document> mediaSet = new ArrayList<Document>();
				List<Document> msgSet = new ArrayList<Document>();
				BooleanClause deptBc = null;

				if (Validator.isNotNull(dept)) {
					deptBc = getBC(dept.getCategoryId(), scopeGroupId,
							usrRoleList, userId, searchContext);
				}

				int reqDocSize;
				final int eventSize = 2;
				final int msgSize = 3;

				if (!isCustomFilter) {
					AssetCategory[] searchCatgs = new AssetCategory[] { p1, p2 };

					/*** EVENTS Search **/
					for (AssetCategory assetCategory : searchCatgs) {
						reqDocSize = eventSize - eventSet.size();

						if (Validator.isNotNull(assetCategory)
								&& reqDocSize > 0) {
							BooleanClause p1Bc = getBC(
									assetCategory.getCategoryId(),
									scopeGroupId, usrRoleList, userId,
									searchContext);
							List<Document> cBEList = getDocs(searchContext,
									reqDocSize, p1Bc, CalEvent.class);
							List<AssetCategory> childs = AssetCategoryLocalServiceUtil
									.getChildCategories(assetCategory
											.getCategoryId());

							for (Document event : cBEList) {
								String[] assetCatIds = event
										.getValues(ASSET_CAT_IDS);
								boolean consider = true;

								for (AssetCategory catg : childs) {
									if (ArrayUtil.contains(assetCatIds, (String
											.valueOf(catg.getCategoryId())))) {
										consider = false;
										break;
									}
								}

								if (consider) {
									add(eventSet, event);
								}
							}
						} else {
							break;
						}
					}

					reqDocSize = eventSize - eventSet.size();

					if (Validator.isNotNull(dept) && reqDocSize > 0) {
						List<Document> tempList = getDocs(searchContext,
								reqDocSize, deptBc, CalEvent.class);
						eventSet.addAll(tempList);
					}

					/** Media Search **/

					final int mediaSize = 1 + (eventSize - eventSet.size());

					for (AssetCategory assetCategory : searchCatgs) {
						reqDocSize = mediaSize - mediaSet.size();

						if (Validator.isNotNull(assetCategory)
								&& reqDocSize > 0) {
							BooleanClause p1Bc = getBC(
									assetCategory.getCategoryId(),
									scopeGroupId, usrRoleList, userId,
									searchContext);
							List<Document> cBEList = getDocs(searchContext,
									reqDocSize, p1Bc, SPAssetEntry.class);
							List<AssetCategory> childs = AssetCategoryLocalServiceUtil
									.getChildCategories(assetCategory
											.getCategoryId());

							for (Document media : cBEList) {
								String[] assetCatIds = media
										.getValues(ASSET_CAT_IDS);
								boolean consider = true;

								for (AssetCategory catg : childs) {
									if (ArrayUtil.contains(assetCatIds, (String
											.valueOf(catg.getCategoryId())))) {
										consider = false;
										break;
									}
								}

								if (consider) {
									add(mediaSet, media);
								}
							}
						} else {
							break;
						}
					}

					reqDocSize = mediaSize - mediaSet.size();

					if (Validator.isNotNull(dept) && reqDocSize > 0) {
						List<Document> tempList = getDocs(searchContext,
								reqDocSize, deptBc, SPAssetEntry.class);
						mediaSet.addAll(tempList);
					}

					/** Blog Search ***/
					final int blogSize = 1 + (mediaSize - mediaSet.size());

					for (AssetCategory assetCategory : searchCatgs) {
						reqDocSize = blogSize - blogSet.size();

						if (Validator.isNotNull(assetCategory)
								&& reqDocSize > 0) {
							BooleanClause p1Bc = getBC(
									assetCategory.getCategoryId(),
									scopeGroupId, usrRoleList, userId,
									searchContext);
							List<Document> cBEList = getDocs(searchContext,
									reqDocSize, p1Bc, BlogsEntry.class);
							List<AssetCategory> childs = AssetCategoryLocalServiceUtil
									.getChildCategories(assetCategory
											.getCategoryId());

							for (Document blog : cBEList) {
								String[] assetCatIds = blog
										.getValues(ASSET_CAT_IDS);
								boolean consider = true;

								for (AssetCategory catg : childs) {
									if (ArrayUtil.contains(assetCatIds, (String
											.valueOf(catg.getCategoryId())))) {
										consider = false;
										break;
									}
								}

								if (consider) {
									add(blogSet, blog);
								}
							}
						} else {
							break;
						}
					}

					reqDocSize = blogSize - blogSet.size();

					if (Validator.isNotNull(dept) && reqDocSize > 0) {
						List<Document> tempList = getDocs(searchContext,
								reqDocSize, deptBc, BlogsEntry.class);
						blogSet.addAll(tempList);
					}

					/*** Discussions */

					for (AssetCategory assetCategory : searchCatgs) {
						reqDocSize = msgSize - msgSet.size();

						if (Validator.isNotNull(assetCategory)
								&& reqDocSize > 0) {
							BooleanClause p1Bc = getBC(
									assetCategory.getCategoryId(),
									scopeGroupId, usrRoleList, userId,
									searchContext);
							List<Document> cBEList = getDocs(searchContext,
									reqDocSize, p1Bc, SPGroup.class);
							List<AssetCategory> childs = AssetCategoryLocalServiceUtil
									.getChildCategories(assetCategory
											.getCategoryId());

							for (Document discussion : cBEList) {
								String[] assetCatIds = discussion
										.getValues(ASSET_CAT_IDS);
								boolean consider = true;

								for (AssetCategory catg : childs) {
									if (ArrayUtil.contains(assetCatIds, (String
											.valueOf(catg.getCategoryId())))) {
										consider = false;
										break;
									}
								}

								if (consider) {
									add(msgSet, discussion);
								}
							}
						} else {
							break;
						}
					}

					reqDocSize = msgSize - msgSet.size();

					if (Validator.isNotNull(dept) && reqDocSize > 0) {
						List<Document> tempList = getDocs(searchContext,
								reqDocSize, deptBc, SPGroup.class);
						msgSet.addAll(tempList);
					}

				} else {
					/** Custom Search set in portlet preferences */
					BooleanClause customBc = getBC(p1.getCategoryId(),
							scopeGroupId, usrRoleList, userId, searchContext);
					List<Document> tempList = getDocs(searchContext, eventSize,
							customBc, CalEvent.class);
					eventSet.addAll(tempList);

					final int mediaSize = 1 + (eventSize - eventSet.size());
					tempList = getDocs(searchContext, mediaSize, customBc,
							SPAssetEntry.class);
					mediaSet.addAll(tempList);

					final int blogSize = 1 + (mediaSize - mediaSet.size());
					tempList = getDocs(searchContext, blogSize, customBc,
							BlogsEntry.class);
					blogSet.addAll(tempList);

					msgSet = getDocs(searchContext, msgSize, customBc,
							SPGroup.class);
				}

				Map<String, String> map;

				for (Document doc : eventSet) {
					counter = counter + 1;
					long classPK = GetterUtil.getLong(doc
							.get(Field.ENTRY_CLASS_PK));

					map = new LinkedHashMap<String, String>();

					map.put(Field.TITLE,
							GetterUtil.getString(doc.get(Field.TITLE)));

					String desc = GetterUtil.getString(doc
							.get(Field.DESCRIPTION));

					if (Validator.isNotNull(desc) && desc.length() > 100) {
						desc = desc.substring(0, 100);
					}

					map.put(Field.DESCRIPTION, desc);

					String imgUrl = ASUtil.getSPAssetEntryThumbnailURL(
							themeDisplay,
							getEventsImageFileEntry(scopeGroupId, classPK));
					map.put(Field.URL, imgUrl);
					String eventDetailUrl = "/event-details/-/event/view_event/"
							+ String.valueOf(classPK) + "?flagDetail=false";
					map.put(DURL, eventDetailUrl);
					map.put(TEXT1, LanguageUtil.get(themeDisplay.getLocale(),"label.read.more.caps"));
					map.put(TEXT2, LanguageUtil.get(themeDisplay.getLocale(),"label.all.events.caps"));
					map.put(HEADER, LanguageUtil.get(themeDisplay.getLocale(),"label.event"));
					map.put(IMAGE_PATH, imagePath + "/feeds/Events-icon.png");
					map.put(PAGE_URL, eventsPageUrl);

					mapList.add(map);
				}

				for (Document doc : mediaSet) {
					map = new LinkedHashMap<String, String>();
					long coverFileEntryId = GetterUtil.getLong(doc
							.get("coverFileEntryId"));
					map.put(Field.TITLE,
							GetterUtil.getString(doc.get(Field.TITLE)));
					String mediaDesc = GetterUtil.getString(doc
							.get(Field.CONTENT));
					mediaDesc = HtmlUtil.stripHtml(mediaDesc.trim());

					if (!mediaDesc.isEmpty() && mediaDesc.length() > 70) {
						mediaDesc = mediaDesc.substring(0, 70);
					}

					map.put(Field.DESCRIPTION, mediaDesc);

					FileEntry coverFileEntry = null;
					try {
						coverFileEntry = DLAppLocalServiceUtil
								.getFileEntry(coverFileEntryId);
					} catch (NoSuchFileEntryException nsfee) {

						// do nothing

					}

					String image = StringPool.BLANK;

					if (coverFileEntry != null) {
						image = ASUtil.getSPAssetEntryThumbnailURL(
								themeDisplay, coverFileEntry);
					}

					map.put(Field.URL, image);
					String spAssetDetailUrl = "/media-detail/-/asset/view/"
							+ GetterUtil.getString(doc.get("spAssetUrlTitle"));

					if (Validator.isNotNull(coverFileEntry)) {
						spAssetDetailUrl = spAssetDetailUrl + "/"
								+ coverFileEntry.getFileEntryId();
					}

					_log.debug("spAssetDetailUrl " + spAssetDetailUrl);
					map.put(DURL, spAssetDetailUrl);
					map.put(TEXT1, LanguageUtil.get(themeDisplay.getLocale(),"label.view.gallery.caps"));
					map.put(TEXT2, LanguageUtil.get(themeDisplay.getLocale(),"label.all.media.caps"));
					map.put(HEADER, LanguageUtil.get(themeDisplay.getLocale(),"label.media"));
					map.put(IMAGE_PATH, imagePath + "/feeds/Media-icon.png");
					map.put(PAGE_URL, mediaPageUrl);

					mapList.add(map);
				}

				for (Document doc : blogSet) {
					map = new LinkedHashMap<String, String>();
					map.put(Field.TITLE,
							GetterUtil.getString(doc.get(Field.TITLE)));
					String blogDesc = GetterUtil.getString(doc
							.get("contentHTML"));
					String contentHTML = blogDesc;
					blogDesc = HtmlUtil.stripHtml(blogDesc.trim());

					if (!blogDesc.isEmpty() && blogDesc.length() > 70) {
						blogDesc = blogDesc.trim().substring(0, 70);
					}

					map.put(Field.DESCRIPTION, blogDesc);
					String image = ASUtil.getBlogImageUrl(contentHTML);

					if (Validator.isNotNull(image)
							&& image.startsWith(themeDisplay.getPortalURL())
							|| image.startsWith(StringPool.FORWARD_SLASH)) {
						if (image.indexOf(StringPool.QUESTION) != -1) {
							image = image + "&imageThumbnail=2";
						} else {
							image = image + "?imageThumbnail=2";
						}
					}

					map.put(Field.URL, image);
					String blogDetailUrl = "/" + blogsPageUrl + "/-/blogs/"
							+ GetterUtil.getString(doc.get("urlTitle"));
					map.put(DURL, blogDetailUrl);
					map.put(TEXT1, LanguageUtil.get(themeDisplay.getLocale(),"label.read.more.caps"));
					map.put(TEXT2, LanguageUtil.get(themeDisplay.getLocale(),"label.all.articles.caps"));
					map.put(HEADER, LanguageUtil.get(themeDisplay.getLocale(),"label.articles"));
					map.put(IMAGE_PATH, imagePath + "/feeds/Articles-icon.png");
					map.put(PAGE_URL, blogsPageUrl);
					mapList.add(map);
				}

				for (Document doc : msgSet) {
					if (msgList.size() < 12) {
						if (!msgList.contains(GetterUtil.getString(doc
								.get(Field.TITLE)))) {
							long spGroupId = GetterUtil.getLong(doc
									.get(Field.ENTRY_CLASS_PK));
							msgList.add(GetterUtil.getString(doc
									.get(Field.TITLE)));
							String urlTitle = GetterUtil.getString(doc
									.get("urlTitle"));
							getSPGroupDiscussionList(renderRequest,
									themeDisplay, spGroupId, urlTitle,
									dscDetailPageName, msgList, d1);
						}
					} else {
						break;
					}
				}

				for (int i = 0; i < mapList.size(); i++) {
					renderRequest.setAttribute("obj" + (i + 1), mapList.get(i));
				}

				String portalUrl = PortalUtil.getPortalURL(httpRequest) + "/"
						+ docLibPageName;

				if (!folderNameToSearchDocOrder1.isEmpty()) {
					docList = getDocumentList(docList, themeDisplay, portalUrl,
							d1, folderNameToSearchDocOrder1);
				}

				if (docList.size() < 12) {
					if (!folderNameToSearchDocOrder2.isEmpty()) {
						docList = getDocumentList(docList, themeDisplay,
								portalUrl, d1, folderNameToSearchDocOrder2);
					}

					if (docList.size() < 12) {
						if (!folderNameToSearchDocOrder3.isEmpty()) {
							docList = getDocumentList(docList, themeDisplay,
									portalUrl, d1, folderNameToSearchDocOrder3);
						}
					}
				}

			} catch (Exception e) {
				_log.error("Error in getting events " + e.getMessage());
			}
		} else {
			error = "Country & Department not found for the loggedin user (Or) CategoryId not found in current URL";
		}

		_log.debug(" Documnent List size " + docList.size());
		renderRequest.setAttribute("docList", docList);
		renderRequest.setAttribute("msgList", msgList);
		renderRequest.setAttribute("feedPageTitle", feedPageTitle);
		renderRequest.setAttribute("error", error);
		super.doView(renderRequest, renderResponse);
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();

		String searchPriority = preferences.getValue("searchPriority", "0");
		String eventsPageUrl = preferences.getValue("eventsPageUrl", "");
		String mediaPageUrl = preferences.getValue("mediaPageUrl", "");
		String blogsPageUrl = preferences.getValue("blogsPageUrl", "");
		String groupDetailPageName = preferences.getValue(
				"groupDetailPageName", "");
		String dscDetailPageName = preferences
				.getValue("dscDetailPageName", "");
		String docLibPageName = preferences.getValue("docLibPageName", "");
		String feedSearchCriteria = preferences.getValue("feedSearchCriteria",
				"");
		String feedSearchVodId = preferences.getValue("feedSearchVocId", "");
		String feedSearchCatgId = preferences.getValue("feedSearchCatId", "");

		renderRequest.setAttribute("assetVocabularies",
				SambaashUtil.getAllAssetVocabularies());
		renderRequest.setAttribute("feedSearchVocId", feedSearchVodId);
		renderRequest.setAttribute("feedSearchCatId", feedSearchCatgId);

		if (FeedConstants.CUSTOM.equalsIgnoreCase(feedSearchCriteria)) {
			renderRequest.setAttribute(FeedConstants.CUSTOM, "checked");
		} else {
			renderRequest.setAttribute(FeedConstants.COUNTRY_REGION, "checked");

			if (FeedConstants.COUNTRY.equalsIgnoreCase(searchPriority)) {
				renderRequest.setAttribute(FeedConstants.COUNTRY, "checked");
			} else {
				renderRequest.setAttribute(FeedConstants.REGION, "checked");
			}
		}

		renderRequest.setAttribute("searchPriority", searchPriority);
		renderRequest.setAttribute("eventsPageUrl", eventsPageUrl);
		renderRequest.setAttribute("mediaPageUrl", mediaPageUrl);
		renderRequest.setAttribute("blogsPageUrl", blogsPageUrl);
		renderRequest.setAttribute("groupDetailPageName", groupDetailPageName);
		renderRequest.setAttribute("dscDetailPageName", dscDetailPageName);
		renderRequest.setAttribute("docLibPageName", docLibPageName);
		super.doEdit(renderRequest, renderResponse);
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String action = actionRequest.getParameter("action");
		String eventsPageUrl = actionRequest.getParameter("eventsPageUrl");
		String mediaPageUrl = actionRequest.getParameter("mediaPageUrl");
		String blogsPageUrl = actionRequest.getParameter("blogsPageUrl");
		String groupDetailPageName = actionRequest
				.getParameter("groupDetailPageName");
		String dscDetailPageName = actionRequest
				.getParameter("dscDetailPageName");
		String docLibPageName = actionRequest.getParameter("docLibPageName");
		PortletPreferences preferences = actionRequest.getPreferences();

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String searchPriorityId = actionRequest
					.getParameter("searchPriority");
			String feedSearchCriteria = actionRequest
					.getParameter("feedSearchCriteria");
			String feedSearchVodId = actionRequest
					.getParameter("feedSearchVocId");
			String feedSearchCatgId = actionRequest
					.getParameter("feedSearchCatId");

			preferences.setValue("feedSearchCriteria", feedSearchCriteria);
			preferences.setValue("feedSearchVocId", feedSearchVodId);
			preferences.setValue("feedSearchCatId", feedSearchCatgId);

			preferences.setValue("searchPriority", searchPriorityId);
			preferences.setValue("blogsPageUrl", blogsPageUrl);
			preferences.setValue("mediaPageUrl", mediaPageUrl);
			preferences.setValue("eventsPageUrl", eventsPageUrl);
			preferences.setValue("groupDetailPageName", groupDetailPageName);
			preferences.setValue("dscDetailPageName", dscDetailPageName);
			preferences.setValue("docLibPageName", docLibPageName);

			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);

		}

		super.processAction(actionRequest, actionResponse);

	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String action = resourceRequest.getParameter("action");

		if ("getCats".equalsIgnoreCase(action)) {
			long vocId = GetterUtil.getLong(resourceRequest
					.getParameter("vocId"));
			List<AssetCategory> catgs = SambaashUtil.getCategories(vocId);
			JSONObject json;
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			for (AssetCategory catg : catgs) {
				json = JSONFactoryUtil.createJSONObject();
				json.put("id", catg.getCategoryId());
				json.put("value", catg.getName());
				jsonArray.put(json);
			}

			json = JSONFactoryUtil.createJSONObject();
			json.put("items", jsonArray);

			resourceResponse.getWriter().write(json.toString());
		}
	}

	private void add(List<Document> list, Document doc) {
		if (Validator.isNotNull(list) && Validator.isNotNull(doc)) {
			boolean found = false;

			for (Document temp : list) {
				if (temp.get(Field.ENTRY_CLASS_PK).equalsIgnoreCase(
						doc.get(Field.ENTRY_CLASS_PK))) {
					found = true;
					break;
				}
			}

			if (!found) {
				list.add(doc);
			}
		}
	}

	private AssetCategory getAssetCategory(long catId) {
		AssetCategory catg = null;
		try {
			catg = AssetCategoryLocalServiceUtil.getAssetCategory(catId);
		} catch (Exception ex) {
			_log.error("Error while retrieving assetcategory " + catId);
		}

		return catg;
	}

	private List<String> getDocumentList(List<String> docList,
			ThemeDisplay themeDisplay, String portalUrl, Date d1,
			String folderNameToSearchDocOrder1) {

		_log.debug("getDocumentList " + folderNameToSearchDocOrder1);
		try {
			Folder fold = DLAppServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), 0,
					folderNameToSearchDocOrder1);
			List<FileEntry> fileEtries = DLAppServiceUtil.getFileEntries(
					fold.getRepositoryId(), fold.getFolderId());

			for (FileEntry fileEntry : fileEtries) {
				if (!docList.contains(fileEntry.getFileEntryId())) {
					docList.add(fileEntry.getTitle());

					Date d2 = fileEntry.getModifiedDate();
					String dateDiff = getTimeDifferent(d2, d1);
					docList.add(dateDiff);

					docList.add(fileEntry.getDescription());
					String docLibUrl = portalUrl
							+ "?p_p_id=20&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_pos=1&_20_struts_action=%2Fdocument_library%2Fview_file_entry&_20_redirect=";
					String docLibUrl2 = portalUrl
							+ "%3Fp_p_id%3D20%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_20_showSiblings%3Dtrue&_20_fileEntryId=";
					docLibUrl = docLibUrl + docLibUrl2
							+ fileEntry.getFileEntryId();
					docList.add(docLibUrl);
				}
			}

		} catch (PortalException e1) {
			_log.error(e1);
		} catch (SystemException e1) {
			_log.error(e1);
		}

		return docList;
	}

	private AssetCategory getCategoryFromName(long vocabularyId,
			String categoryName) {
		AssetCategory catg = null;
		try {
			int catgLen = AssetCategoryLocalServiceUtil
					.getAssetCategoriesCount();
			List<AssetCategory> catList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(vocabularyId, 0, catgLen, null);

			for (AssetCategory temp : catList) {
				if (temp.getName().equalsIgnoreCase(categoryName)) {
					catg = temp;
					break;
				}
			}
		} catch (Exception e) {
			_log.error("error while getting categoryId for the given category name "
					+ categoryName + e.getMessage());
		}

		return catg;

	}

	private BooleanClause getBC(long filter1, long scopeGroupId,
			List<Role> usrRoleList, long userId, SearchContext searchContext) {

		BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		if (filter1 != 0) {
			keywordsBooleanQuery.addRequiredTerm(ASSET_CAT_IDS, "\"" + filter1
					+ "\"");
		}

		BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil.create(
				searchContext, keywordsBooleanQuery,
				BooleanClauseOccur.MUST.getName());
		return keywordsBooleanClause;
	}

	private void getSPGroupDiscussionList(RenderRequest renderRequest,
			ThemeDisplay themeDisplay, long spGroupId, String urlTitle,
			String groupDiscussionDetailPageName, List<String> msgList, Date d1)
			throws Exception {

		long scopeGroupId = themeDisplay.getScopeGroupId();
		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(SPGroup.class.getName());

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil
				.getDiscussionMessageDisplay(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(),
						SPGroup.class.getName(), spGroupId,
						WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread
					.getRootMessageId());
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(
				new Long(rootMessage.getRootMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(
				new Long(rootMessage.getRootMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(spGroupId));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(
				new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		@SuppressWarnings("unchecked")
		List<MBMessage> parentComments = MBMessageLocalServiceUtil
				.dynamicQuery(dynamicQuery, 0, 4);

		int dscCount = 0;

		for (MBMessage parentComment : parentComments) {
			dscCount = dscCount + 1;

			if (dscCount <= 1) {
				Date d2 = parentComment.getModifiedDate();
				String dateDiff = getTimeDifferent(d2, d1);
				msgList.add(dateDiff);

				String title = parentComment.getSubject();
				title = StringUtil.shorten(title, 30);

				msgList.add(title);
				String spGroupDiscussionDetailURL = StringPool.BLANK;
				Layout spGroupDiscussionDetailLayout = null;
				try {
					spGroupDiscussionDetailLayout = LayoutLocalServiceUtil
							.getFriendlyURLLayout(scopeGroupId, false, "/"
									+ groupDiscussionDetailPageName);
				} catch (com.liferay.portal.NoSuchLayoutException e) {

					// do nothing

				}

				if (spGroupDiscussionDetailLayout != null) {
					long viewSPGroupDiscussionPlid = spGroupDiscussionDetailLayout
							.getPlid();

					PortletURL spGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil
							.create(renderRequest,
									"SPGroupDiscussionDetail_WAR_SPGroupportlet",
									viewSPGroupDiscussionPlid,
									javax.portlet.PortletRequest.RENDER_PHASE);
					spGroupDiscussionPortletURL
							.setWindowState(javax.portlet.WindowState.NORMAL);
					spGroupDiscussionPortletURL
							.setPortletMode(javax.portlet.PortletMode.VIEW);
					spGroupDiscussionPortletURL.setParameter("struts_action",
							"/discussions/view_discussion");
					spGroupDiscussionPortletURL.setParameter("urlTitle",
							urlTitle);
					spGroupDiscussionPortletURL.setParameter("spGroupId",
							String.valueOf(spGroupId));
					spGroupDiscussionPortletURL.setParameter("discussionId",
							String.valueOf(parentComment.getMessageId()));
					spGroupDiscussionDetailURL = spGroupDiscussionPortletURL
							.toString();
				}

				msgList.add(spGroupDiscussionDetailURL);
			}
		}
	}

	private List<Document> getDocs(SearchContext searchContext, int reqDocLen,
			BooleanClause bc, Class<?> classObj) {
		List<BooleanClause> bcList = new ArrayList<BooleanClause>();
		bcList.add(bc);
		return getDocs(searchContext, reqDocLen, bcList, classObj);
	}

	private List<Document> getDocs(SearchContext searchContext, int reqDocLen,
			List<BooleanClause> bcList, Class<?> classObj) {

		List<Document> list = new ArrayList<Document>();
		try {
			Indexer indexer = IndexerRegistryUtil.getIndexer(classObj);
			searchContext.setStart(0);
			searchContext.setEnd(reqDocLen);

			Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE,
					Sort.LONG_TYPE, true);
			Sort[] sorts = new Sort[] { sort };
			searchContext.setSorts(sorts);

			if (Validator.isNotNull(bcList)) {
				BooleanClause[] bc = new BooleanClause[bcList.size()];

				for (int i = 0; i < bcList.size(); i++) {
					bc[i] = bcList.get(i);
				}

				searchContext.setBooleanClauses(bc);
			}

			Hits results = indexer.search(searchContext);

			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				list.add(doc);
			}
		} catch (Exception e) {
			_log.error("Blogs List not found " + e.getMessage());
		}

		return list;
	}

	public String getTimeDifferent(Date d1, Date d2) {
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

	private FileEntry getEventsImageFileEntry(long respositoryId, long eventId) {

		long parentFolderId = 0;
		FileEntry fe = null;

		try {
			Folder folder = DLAppServiceUtil.getFolder(respositoryId, 0,
					SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER);

			if (folder != null) {
				parentFolderId = folder.getFolderId();
			}

			Folder subFolder = DLAppServiceUtil.getFolder(respositoryId,
					parentFolderId, "Event_" + eventId);

			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
					respositoryId, subFolder.getFolderId(), 0, 1);

			if (Validator.isNotNull(fileEntries) && !fileEntries.isEmpty()) {
				fe = fileEntries.get(0);
			}

		} catch (Exception e) {
			_log.error("error getting events image map" + e.getMessage());
		}

		return fe;
	}

	private static String ASSET_CAT_IDS = "assetCategoryIds";

}
