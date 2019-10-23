package com.sambaash.platform.portlet.spasset.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.VideoProcessorUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spasset.helper.SPAssetHelper;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.permission.PermissionUtil;
import com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil;
import com.sambaash.platform.util.DownloadFilesZipHelper;
import com.sambaash.platform.util.FilenameUtils;
import com.sambaash.platform.util.SPAssetConstants;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

/**
 * Portlet implementation class SPAssetEntry
 */
public class SPAssetEntryAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPAssetEntryAction.class);
	private static final String FILE_EXT_SEP = FilenameUtils.EXTENSION_SEPARATOR_STR;
	private static final String ZIP_FILE_EXT_NAME = "zip";
	private static final String ZIP_FILE_EXT = FILE_EXT_SEP + ZIP_FILE_EXT_NAME;
	private static int DEFAULT_DL_FILE_DOWNLOAD_CACHE_MAX_AGE = 1;
	private static String searchText = null;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		boolean isAdmin = false;
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			// Checking the permission

			// checkViewPermission(renderRequest);
			checkAddPermission(renderRequest);
			// checkEditPermission(renderRequest);
			// checkDeletePermission(renderRequest);
			// checkDownloadPermission(renderRequest);

			PortletPreferences prefs = renderRequest.getPreferences();

			boolean showLoadmore = false;
			int totalDisplayResult = 10;
			String styleType = prefs.getValue("styleType", "");
			String isEditIconOnTop = prefs.getValue("isEditIconOnTop", "");
			String isVoting = prefs.getValue("isVoting", "");
			if ("checked".equalsIgnoreCase(isEditIconOnTop)) {
				isEditIconOnTop = "isEditIconOnTop";
			} else {
				isEditIconOnTop = "isEditIconOnBottom";
			}
			renderRequest.setAttribute("styleType", styleType);
			renderRequest.setAttribute("isEditIconOnTop", isEditIconOnTop);
			renderRequest.setAttribute("isVoting", isVoting);
			renderRequest.setAttribute("isAdmin", isAdmin);

			long spAssetTypeId = GetterUtil.getLong(prefs.getValue("assetType", ""));

			SPAssetType spAstType = SPAssetTypeLocalServiceUtil.getSPAssetType(spAssetTypeId);
			String detailPageUrl = spAstType.getSpAssetTypeDetailUrl();
			List<SPAssetEntry> assetEntryListCnt = SPAssetEntryLocalServiceUtil.findBySpAssetEntries(
					themeDisplay.getScopeGroupId(), spAssetTypeId);
			int assetEntryListCount = assetEntryListCnt.size();

			List<Document> docs = null;
			List<Document> docs1 = null;

			docs = SPAssetHelper.getGalleryListing(renderRequest, 0, totalDisplayResult, spAssetTypeId, searchText);
			if (searchText != null) {
				docs1 = SPAssetHelper.getGalleryListing(renderRequest, -1, -1, spAssetTypeId, searchText);
				assetEntryListCount = docs1.size();
			}
			showLoadmore = getSearchResultsCount(assetEntryListCount, themeDisplay, 0, totalDisplayResult);
			_log.debug("assetEntryListCount " + assetEntryListCount + " showLoadmore " + showLoadmore);

			HashMap<Long, List<String>> assetList = new LinkedHashMap<Long, List<String>>();

			long assetEntryId;
			int count = 1;
			for (Document doc : docs) {
				assetEntryId = Long.parseLong(doc.get("spAssetEntryId"));

				long docUserId = Long.parseLong(doc.get(Field.USER_ID));
				boolean editAssetEntryPermission = checkEditPermission(renderRequest, assetEntryId, themeDisplay,
						docUserId);
				boolean delAssetEntryPermission = checkDeletePermission(renderRequest, assetEntryId, themeDisplay,
						docUserId);
				boolean downloadAssetEntryPermission = checkDownloadPermission(renderRequest, assetEntryId,
						themeDisplay, docUserId);

				SPAssetEntry assetEntry = null;
				try{
					assetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(assetEntryId);
				}catch(Exception e){
					_log.error("no asset entry found " + e.getMessage());
				}
				if(Validator.isNotNull(assetEntry)){
				if (searchText != null && !isFoundInSearch(docs, assetEntry)) {
					continue;
				}

				String url = themeDisplay.getPathThemeImages() + "/common/default-gallery-image.png";
				List<String> assetDetail = new ArrayList<String>();
				boolean toBeShownInListing = true;
				boolean assetentryStatus = assetEntry.getStatus();
				try {
					long coverFileEntryId = Long.parseLong(doc.get("spCoverFileEntryId"));
					if(coverFileEntryId > 0){
						FileEntry coverFileEntry = DLAppServiceUtil.getFileEntry(coverFileEntryId);
						if (coverFileEntry != null) {
							url = ThumbnailUtil.getThumbnailUrl(coverFileEntry, themeDisplay.getPathThemeImages(),
									themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3);
						}
					}else{
						toBeShownInListing = listAssetEntryPermission(assetentryStatus,coverFileEntryId,themeDisplay,docUserId);
					}
					
					if(toBeShownInListing){
						assetDetail.add(url);
	
						String detailUrl = StringPool.BLANK;
						if (Boolean.parseBoolean(doc.get("status"))) {
							detailUrl = SPAssetHelper.getFriendlyUrlAssetDetails(detailPageUrl, assetEntryId, count++,
									searchText);
						}
						assetDetail.add(detailUrl);
						String projectName = doc.get(Field.TITLE);
	
						int y = projectName.length();
						String projectDisplayName = projectName;
						int titleLength = 75;
						if (y > titleLength) {
							projectDisplayName = projectName.substring(0, titleLength) + "..";
						}
						String displayDesc = doc.get(Field.DESCRIPTION);
						int z = displayDesc.length();
						if (z > 150) {
							z = 150;
							displayDesc = displayDesc.substring(0, z) + "..";
						}
	
						assetDetail.add(projectDisplayName);
						assetDetail.add(displayDesc);
						String userName = doc.get(Field.USER_NAME);
						int n = userName.length();
						if (n > 20) {
							n = 20;
							userName = userName.substring(0, n) + "..";
						}
						assetDetail.add(userName);
						Date createdDate = assetEntry.getCreateDate();
						SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
						String displayDate = format.format(createdDate);
						assetDetail.add(displayDate);
	
						assetDetail.add(String.valueOf(editAssetEntryPermission));
						assetDetail.add(String.valueOf(delAssetEntryPermission));
						assetDetail.add(String.valueOf(downloadAssetEntryPermission));
						_log.debug("assetEntryId " + assetEntryId + " toBeShownInListing " + toBeShownInListing + " assetentryStatus " + assetentryStatus + " editAssetEntryPermission " + editAssetEntryPermission + " delAssetEntryPermission " + delAssetEntryPermission + " downloadAssetEntryPermission " + downloadAssetEntryPermission);
	
						assetList.put(assetEntryId, assetDetail);
						
					}
				} catch (PortalException e) {
					_log.error(e);
				}
				}

			}
			renderRequest.setAttribute("assetList", assetList);
			renderRequest.setAttribute("searchText", searchText);
			renderRequest.setAttribute("showLoadmore", showLoadmore);
			searchText = null;

		} catch (SystemException e) {
			_log.error(e);
		} catch (PrincipalException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}

		super.doView(renderRequest, renderResponse);
	}

	private boolean listAssetEntryPermission(boolean assetentryStatus,
			long coverFileEntryId, ThemeDisplay themeDisplay, long docUserId) {
		boolean toBeshownInList = true;
		if(!assetentryStatus || coverFileEntryId == 0){
			if((themeDisplay.getUserId() == docUserId) || (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))){
				toBeshownInList = true;
			}else{
				toBeshownInList = false;
			}
		}
		return toBeshownInList;
	}

	private boolean getSearchResultsCount(int totalCount, ThemeDisplay themeDisplay, int paginationN,
			int totalDisplayResultsN) {

		boolean showLoadmore = false;

		if (totalCount > (paginationN + totalDisplayResultsN)) {
			showLoadmore = true;
		}
		_log.debug("totalCount " + totalCount + " (paginationN+totalDisplayResultsN) "
				+ (paginationN + totalDisplayResultsN) + " showLoadmore " + showLoadmore);
		return showLoadmore;
	}

	public void loadMoreImages(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			int totalDisplayResult, User user, ThemeDisplay themeDisplay, int start) throws IOException,
			PortletException {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		JSONArray urls = JSONFactoryUtil.createJSONArray();

		PortletPreferences prefs = resourceRequest.getPreferences();
		String isEditIconOnTop = prefs.getValue("isEditIconOnTop", "");
		if ("checked".equalsIgnoreCase(isEditIconOnTop)) {
			isEditIconOnTop = "isEditIconOnTop";
		} else {
			isEditIconOnTop = "isEditIconOnBottom";
		}
		boolean showLoadmore = false;

		try {

			long spAssetTypeId = GetterUtil.getLong(prefs.getValue("assetType", ""));

			SPAssetType spAstType = SPAssetTypeLocalServiceUtil.getSPAssetType(spAssetTypeId);
			String detailPageUrl = spAstType.getSpAssetTypeDetailUrl();
			List<SPAssetEntry> assetEntryListCnt = SPAssetEntryLocalServiceUtil.findBySpAssetEntries(
					themeDisplay.getScopeGroupId(), spAssetTypeId);
			int assetEntryListCount = assetEntryListCnt.size();

			List<Document> docs = null;

			docs = SPAssetHelper.getGalleryListing(resourceRequest, start, (start + totalDisplayResult), spAssetTypeId,
					searchText);

			showLoadmore = getSearchResultsCount(assetEntryListCount, themeDisplay, start, totalDisplayResult);
			_log.debug("LoadMore start " + start + " totalDisplayResult " + totalDisplayResult + " showLoadmore "
					+ showLoadmore);
			for (Document doc : docs) {

				JSONArray urlData = JSONFactoryUtil.createJSONArray();
				long assetEntryId = Long.parseLong(doc.get("spAssetEntryId"));

				long docUserId = Long.parseLong(doc.get(Field.USER_ID));
				boolean editAssetEntryPermission = checkEditPermission(resourceRequest, assetEntryId, themeDisplay,
						docUserId);
				boolean delAssetEntryPermission = checkDeletePermission(resourceRequest, assetEntryId, themeDisplay,
						docUserId);
				boolean downloadAssetEntryPermission = checkDownloadPermission(resourceRequest, assetEntryId,
						themeDisplay, docUserId);

				SPAssetEntry assetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(assetEntryId);
				if (searchText != null && !isFoundInSearch(docs, assetEntry)) {
					continue;
				}

				String url = themeDisplay.getPathThemeImages() + "/common/default-gallery-image.png";
				boolean toBeShownInListing = true;
				boolean assetentryStatus = assetEntry.getStatus();
				try {
					long coverFileEntryId = Long.parseLong(doc.get("spCoverFileEntryId"));
					if(coverFileEntryId > 0){
						FileEntry coverFileEntry = DLAppServiceUtil.getFileEntry(coverFileEntryId);
						if (coverFileEntry != null) {
							url = ThumbnailUtil.getThumbnailUrl(coverFileEntry, themeDisplay.getPathThemeImages(),
									themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3);
						}
					}
					toBeShownInListing = listAssetEntryPermission(assetentryStatus,coverFileEntryId,themeDisplay,docUserId);

					if(toBeShownInListing)	{
						urlData.put(url);
	
						String detailUrl = StringPool.BLANK;
						if (Boolean.parseBoolean(doc.get("status"))) {
							detailUrl = "/" + detailPageUrl + "/-/assetdetails/view/" + assetEntryId;
						}
						urlData.put(detailUrl);
						String projectName = doc.get(Field.TITLE);
	
						int y = projectName.length();
						String projectDisplayName = projectName;
						int titleLength = 75;
						if (y > titleLength) {
							projectDisplayName = projectName.substring(0, titleLength) + "..";
						}
						String displayDesc = doc.get(Field.DESCRIPTION);
						int z = displayDesc.length();
						if (z > 150) {
							z = 150;
							displayDesc = displayDesc.substring(0, z) + "..";
						}
	
						urlData.put(projectDisplayName);
						urlData.put(displayDesc);
						String userName = doc.get(Field.USER_NAME);
						int n = userName.length();
						if (n > 20) {
							n = 20;
							userName = userName.substring(0, n) + "..";
						}
						String screenName = StringPool.BLANK;
						if (user != null) {
							screenName = user.getScreenName();
						}
						String userURL = StringPool.SLASH + screenName;
						urlData.put(userURL);
						urlData.put(userName);
						Date createdDate = assetEntry.getCreateDate();
						SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
						String displayDate = format.format(createdDate);
						urlData.put(displayDate);
						urlData.put(assetEntryId);
						urlData.put(isEditIconOnTop);
	
						urlData.put(String.valueOf(editAssetEntryPermission));
						urlData.put(String.valueOf(delAssetEntryPermission));
						urlData.put(String.valueOf(downloadAssetEntryPermission));
						_log.debug("assetEntryId " + assetEntryId + " toBeShownInListing " + toBeShownInListing + " assetentryStatus " + assetentryStatus + " editAssetEntryPermission " + editAssetEntryPermission + " delAssetEntryPermission " + delAssetEntryPermission + " downloadAssetEntryPermission " + downloadAssetEntryPermission);
						urls.put(urlData);
						_log.debug("urlData " + urlData);
					}
				} catch (PortalException e) {
					_log.error(e);
				}

			}

			data.put("total", totalDisplayResult);
			data.put("numberOfItems", start);
			data.put("showLoadmore", showLoadmore);
			data.put("urls", urls);
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			resourceResponse.getWriter().write(data.toString());
			searchText = null;

		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			List<SPAssetType> assetList = SPAssetTypeLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
			renderRequest.setAttribute("assetList", assetList);

			PortletPreferences prefs = renderRequest.getPreferences();
			String aType = prefs.getValue("assetType", "");
			String styleType = prefs.getValue("styleType", "");
			String isEditIconOnTop = prefs.getValue("isEditIconOnTop", "");
			String isVoting = prefs.getValue("isVoting", "");
			String detailPageName = prefs.getValue("detailPageName", "");
			renderRequest.setAttribute("aType", aType);
			renderRequest.setAttribute("styleType", styleType);
			renderRequest.setAttribute("isEditIconOnTop", isEditIconOnTop);
			renderRequest.setAttribute("isVoting", isVoting);
			renderRequest.setAttribute("isVoting", isVoting);
			renderRequest.setAttribute("detailPageName", detailPageName);
		} catch (SystemException e) {
			_log.error(e);
		}
		super.doEdit(renderRequest, renderResponse);

	}

	public void saveAssetPreference(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		try {
			// TODO: asset type mandatory check
			PortletPreferences prefs = actionRequest.getPreferences();

			String spAssetTypeName = ParamUtil.getString(actionRequest, "spAssetTypeName");
			String detailPageName = ParamUtil.getString(actionRequest, "detailPageName");
			String styleType = ParamUtil.getString(actionRequest, "Style");
			String isEditIconOnTop = ParamUtil.getString(actionRequest, "editIconsAlignment");

			String isVoting = ParamUtil.getString(actionRequest, "voting");
			if (Validator.isNotNull(isEditIconOnTop)) {
				isEditIconOnTop = "checked";
			}
			if (Validator.isNotNull(isVoting)) {
				isVoting = "checked";
			}
			prefs.setValue("assetType", spAssetTypeName);
			prefs.setValue("styleType", styleType);
			prefs.setValue("isEditIconOnTop", isEditIconOnTop);
			prefs.setValue("isVoting", isVoting);
			prefs.setValue("detailPageName", detailPageName);
			prefs.store();
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void displayCreateAssetEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		// TODO: check permissions
		long typeId = getAssetTypeIdFromPrefs(actionRequest);
		actionResponse.setRenderParameter("jspPage", "/html/spassetentry/create.jsp");
		try {
			SPAssetType assetType = SPAssetTypeLocalServiceUtil.getSPAssetType(typeId);
			actionRequest.setAttribute("assetTypeValue", assetType);
			setFileRules(actionRequest, assetType);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	public void displayUpdateAssetEntry(ActionRequest actionRequest, ActionResponse actionResponse) {

		// TODO: check permissions
		long typeId = getAssetTypeIdFromPrefs(actionRequest);
		actionResponse.setRenderParameter("jspPage", "/html/spassetentry/create.jsp");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			long spAssetEntryId = ParamUtil.getLong(actionRequest, "spAssetEntryId");
			SPAssetEntry assetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(spAssetEntryId);
			actionRequest.setAttribute("assetEntry", assetEntry);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
					assetEntry.getDlFolderId());
			actionRequest.setAttribute("fileEntries", fileEntries);
			SPAssetType assetType = SPAssetTypeLocalServiceUtil.getSPAssetType(typeId);
			actionRequest.setAttribute("assetTypeValue", assetType);

			setFileRules(actionRequest, assetType);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	private long getAssetTypeIdFromPrefs(PortletRequest request) {
		PortletPreferences prefs = request.getPreferences();
		long typeId = GetterUtil.getLong(prefs.getValue("assetType", ""));
		return typeId;
	}

	private void setFileRules(ActionRequest actionRequest, SPAssetType assetType) {
		JSONObject fileRules = JSONFactoryUtil.createJSONObject();
		fileRules.put("minWidth", GetterUtil.getLong(assetType.getMinImageWidth()));
		fileRules.put("minHeight", GetterUtil.getLong(assetType.getMinImageHeight()));
		fileRules.put("maxSize", GetterUtil.getLong(assetType.getMaxFileSize()));
		fileRules.put("allowedTypes",
				Validator.isNull(assetType.getAllowedFileTypes()) ? "all" : assetType.getAllowedFileTypes());

		actionRequest.setAttribute("fileRules", fileRules);
	}

	public void deleteAssetEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

		try {
			// TODO: check for permissions. also instead of delete, status can
			// be changed
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences portletPreferences = actionRequest.getPreferences();
			long spAssetEntryId = ParamUtil.getLong(actionRequest, "spAssetEntryId");
			SPAssetEntry spAssetEntry = SPAssetEntryLocalServiceUtil.fetchSPAssetEntry(spAssetEntryId);

			SPAssetEntryLocalServiceUtil.deleteSPAssetEntry(spAssetEntryId);

			long spAssetTypeId = GetterUtil.getLong(portletPreferences.getValue("assetType", ""));
			long spAssetFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0,
					SPAssetConstants.SPASSET_ROOT_FOLDER_NAME).getFolderId();
			long spAssetTypeFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), spAssetFolderId,
					String.valueOf(spAssetTypeId)).getFolderId();
			long spAssetEntryFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), spAssetTypeFolderId,
					String.valueOf(spAssetEntryId)).getFolderId();
			DLAppServiceUtil.deleteFolder(spAssetEntryFolderId);

			// SocialActivityLocalServiceUtil.deleteActivity(activityId);
			// Delete activity
			// SocialActivityLocalServiceUtil.deleteActivities(SPAssetEntry.class.getName(),
			// spAssetEntryId);

			// delete index
			Indexer indexer = IndexerRegistryUtil.getIndexer(SPAssetEntry.class);
			try {
				indexer.delete(spAssetEntry);
			} catch (SearchException e) {
				_log.error(e);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void downloadAssetEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences portletPreferences = resourceRequest.getPreferences();
			long spAssetEntryId = ParamUtil.getLong(resourceRequest, "spAssetEntryId");

			long spAssetTypeId = GetterUtil.getLong(portletPreferences.getValue("assetType", ""));

			long spAssetFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0,
					SPAssetConstants.SPASSET_ROOT_FOLDER_NAME).getFolderId();

			long spAssetTypeFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), spAssetFolderId,
					String.valueOf(spAssetTypeId)).getFolderId();

			long spAssetEntryFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), spAssetTypeFolderId,
					String.valueOf(spAssetEntryId)).getFolderId();
			long repositoryId = themeDisplay.getScopeGroupId();
			List<FileEntry> list = DLAppServiceUtil.getFileEntries(repositoryId, spAssetEntryFolderId);

			if (list.size() <= 0) {
				SessionErrors.add(resourceRequest, "Please Select File.");
				resourceResponse.setProperty("portlet.http-status-code", "302");
				resourceResponse.addProperty("Location", resourceResponse.createRenderURL().toString());
				return;
			} else {
				setupResponseHeaders(resourceRequest, resourceResponse);
				List<String> fileIdsArray = new ArrayList<String>();
				for (FileEntry file : list) {
					fileIdsArray.add(String.valueOf(file.getFileEntryId()));
				}
				try {
					downloadMultipleFilesInZip(resourceRequest, resourceResponse, fileIdsArray);
				} catch (PortalException e) {
					_log.debug("PortalException", e);
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void saveAssetEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		try {
			long coverFileEntryId = 0;
			boolean status = true;
			String removedFileEntriesId = "";

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String title = ParamUtil.getString(actionRequest, "title");
			String description = ParamUtil.getString(actionRequest, "description");
			long spAssetEntryId = ParamUtil.getLong(actionRequest, "spAssetEntryId");
			coverFileEntryId = ParamUtil.getLong(actionRequest, "coverFileEntryId");
			removedFileEntriesId = ParamUtil.getString(actionRequest, "removedFileEntriesId");
			String[] removedFileEntryId = removedFileEntriesId.split(",");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(SPAssetEntry.class.getName(),
					actionRequest);
			SPAssetEntry spAssetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(spAssetEntryId);
			spAssetEntry.setTitle(title);
			spAssetEntry.setDescription(description);

			if (removedFileEntryId.length > 0) {
				for (String fileEntryId : removedFileEntryId) {

					if (Long.valueOf(fileEntryId).compareTo(spAssetEntry.getCoverFileEntryId()) == 0) {
						coverFileEntryId = 0;
					}

					if (Long.parseLong(fileEntryId) > 0) {
						DLAppServiceUtil.deleteFileEntry(Long.parseLong(fileEntryId));
					}
				}
			}

			if (coverFileEntryId > 0) {
				spAssetEntry.setCoverFileEntryId(coverFileEntryId);
			} else {
				long folderId = spAssetEntry.getDlFolderId();
				_log.error("fileEntries folderId save " + folderId + " " + spAssetEntry.getCoverFileEntryId());
				if (folderId > 0) {
					List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
							folderId);
					_log.error("fileEntries save " + fileEntries.size());
					if(fileEntries.size() > 0){
						for (FileEntry fileEntry : fileEntries) {
							spAssetEntry.setCoverFileEntryId(fileEntry.getFileEntryId());
							break;
						}
					}else{
						status = false;
					}
				}
			}

			spAssetEntry.setStatus(status);

			SPAssetEntryLocalServiceUtil.updateAssetEntry(spAssetEntry, serviceContext);

			// while adding
			if (ParamUtil.getString(actionRequest, "actionParam").equalsIgnoreCase("add")) {
				// add model resources for sp asset entry
				SPAssetEntryLocalServiceUtil.addModelResource(spAssetEntry, serviceContext);
				setupPermissionsOnAssetEntryFolder(serviceContext, spAssetEntry);
				// calculate guest permissions to apply to files in asset entry
				// folder
				setupPermissionsFilesInAssetEntryFolder(themeDisplay, serviceContext.getGuestPermissions(),
						serviceContext.getGroupPermissions(), serviceContext.getAssetCategoryIds(),
						serviceContext.getAssetTagNames(), spAssetEntry);
			} else {
				// while update
				try {
					// Get the list of actions associated with asset entry
					List<ResourceAction> allActions = ResourceActionLocalServiceUtil
							.getResourceActions(SPAssetEntry.class.getName());
					// -- For Site member
					Role siteMemberRole = RoleLocalServiceUtil.getRole(spAssetEntry.getCompanyId(),
							RoleConstants.SITE_MEMBER);
					ResourcePermission rp = ResourcePermissionLocalServiceUtil.getResourcePermission(
							spAssetEntry.getCompanyId(), SPAssetEntry.class.getName(),
							ResourceConstants.SCOPE_INDIVIDUAL, spAssetEntry.getSpAssetEntryId() + "",
							siteMemberRole.getRoleId());
					List<String> grpActions = new ArrayList<String>();
					for (ResourceAction action : allActions) {
						if (ResourcePermissionLocalServiceUtil.hasActionId(rp, action)) {
							grpActions.add(action.getActionId());
						}
					}

					// -- for Guest
					Role guestRole = RoleLocalServiceUtil.getRole(spAssetEntry.getCompanyId(), RoleConstants.GUEST);
					rp = ResourcePermissionLocalServiceUtil.getResourcePermission(spAssetEntry.getCompanyId(),
							SPAssetEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							spAssetEntry.getSpAssetEntryId() + "", guestRole.getRoleId());
					long guestActions = rp.getActionIds();
					String[] guestPerms = null;
					if (guestActions > 0) {
						guestPerms = new String[] { ActionKeys.VIEW };
					}

					setupPermissionsFilesInAssetEntryFolder(themeDisplay, guestPerms,
							grpActions.toArray(new String[] {}), serviceContext.getAssetCategoryIds(),
							serviceContext.getAssetTagNames(), spAssetEntry);

				} catch (Exception ex) {

				}

			}

			SPAssetType assetType = SPAssetTypeLocalServiceUtil.getSPAssetType(spAssetEntry.getSpAssetTypeId());
			// TODO: redirect to view page
			actionResponse.sendRedirect(SPAssetHelper.getFriendlyUrlAssetDetails(assetType.getSpAssetTypeDetailUrl(),
					spAssetEntryId, null, null));

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	private void setupPermissionsFilesInAssetEntryFolder(ThemeDisplay themeDisplay, String[] assetEntryGuestPerms,
			String[] assetEntryGrpPerms, long[] assetCategoryIds, String[] tagNames, SPAssetEntry spAssetEntry)
			throws PortalException, SystemException {
		List<FileEntry> files = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
				spAssetEntry.getDlFolderId(), -1, -1);

		List<ResourceAction> fileActions = ResourceActionLocalServiceUtil.getResourceActions(DLFileEntry.class
				.getName());
		List<String> fileGuesetPerms = new ArrayList<String>();
		if (assetEntryGuestPerms != null && assetEntryGuestPerms.length > 0) {
			fileGuesetPerms.add(ActionKeys.VIEW);
		}

		// calculate site member permissions to apply to files in asset
		// entry folder
		List<String> fileGrpPerms = new ArrayList<String>();
		if (assetEntryGrpPerms != null) {
			for (String action : assetEntryGrpPerms) {
				for (ResourceAction ra : fileActions) {
					if (action.equalsIgnoreCase(ra.getActionId())) {
						fileGrpPerms.add(ra.getActionId());
					}
				}
			}
		}

		// update guest and site member permissions for each file in
		// asset entry folder
		for (FileEntry dlFileEntry : files) {
			try {
				AssetEntryLocalServiceUtil.updateEntry(dlFileEntry.getUserId(), dlFileEntry.getGroupId(),
						DLFileEntry.class.getName(), dlFileEntry.getFileEntryId(), assetCategoryIds, tagNames);
				ResourceLocalServiceUtil.updateResources(dlFileEntry.getCompanyId(), dlFileEntry.getGroupId(),
						DLFileEntry.class.getName(), dlFileEntry.getFileEntryId(),
						fileGrpPerms.toArray(new String[] {}), fileGuesetPerms.toArray(new String[] {}));
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}

	private void setupPermissionsOnAssetEntryFolder(ServiceContext serviceContext, SPAssetEntry spAssetEntry)
			throws SystemException {
		// calculate guest permissions on asset entry folder
		List<ResourceAction> folderActions = ResourceActionLocalServiceUtil
				.getResourceActions(DLFolder.class.getName());
		String[] assetEntryGuestPerms = serviceContext.getGuestPermissions();
		List<String> folderGuesetPerms = new ArrayList<String>();
		if (assetEntryGuestPerms != null && assetEntryGuestPerms.length > 0) {
			folderGuesetPerms.add(ActionKeys.VIEW);
		}

		// calculate Site member permissions on asset entry folder
		String[] assetEntryGrpPerms = serviceContext.getGroupPermissions();
		List<String> folderGrpPerms = new ArrayList<String>();
		if (assetEntryGrpPerms != null) {
			for (String action : assetEntryGrpPerms) {
				for (ResourceAction ra : folderActions) {
					if (action.equalsIgnoreCase(ra.getActionId())) {
						folderGrpPerms.add(ra.getActionId());
					}
				}
			}
		}
		// update guest and site member permissions
		try {
			Folder assetEntryFolder = DLAppServiceUtil.getFolder(spAssetEntry.getDlFolderId());
			ResourceLocalServiceUtil.updateResources(assetEntryFolder.getCompanyId(), assetEntryFolder.getGroupId(),
					DLFolder.class.getName(), assetEntryFolder.getFolderId(), folderGrpPerms.toArray(new String[] {}),
					folderGuesetPerms.toArray(new String[] {}));
		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		final long repositoryId = themeDisplay.getScopeGroupId();
		final long groupId = themeDisplay.getScopeGroupId();
		// TODO: have look at below parameter
		String type = ParamUtil.getString(resourceRequest, "type");
		String totalDisplayResults = resourceRequest.getParameter("totalDisplayResults");
		String pagination = ParamUtil.getString(resourceRequest, "pagination");
		String action = ParamUtil.getString(resourceRequest, "action");

		if ("downloadFiles".equals(resourceRequest.getResourceID())) {
			downloadAssetEntry(resourceRequest, resourceResponse);
		} else if ("saveTitle".equalsIgnoreCase(action)) {

			String spAssetEntrySubType = StringPool.BLANK;
			long classNameId = 0;
			long coverFileEntryId = 0;
			long spAssetEntryId = 0;
			String content = StringPool.BLANK;
			String link = StringPool.BLANK;
			String statusByUserName = StringPool.BLANK;
			String description = StringPool.BLANK;
			boolean status = false;

			PortletPreferences portletPreferences = resourceRequest.getPreferences();

			// TODO: check assettype configruation and title field
			// TODO: check for permissions for adding/updating asset entry
			long spAssetTypeId = GetterUtil.getLong(portletPreferences.getValue("assetType", ""));
			String title = ParamUtil.getString(resourceRequest, "title");
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			SPAssetEntry spAssetEntry = null;
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SPAssetEntry.class.getName(),
						resourceRequest);

				// TODO: check for permission on this sp asset entry
				spAssetEntryId = ParamUtil.getLong(resourceRequest, "spAssetEntryId");

				if (spAssetEntryId == 0) {

					spAssetEntry = SPAssetEntryLocalServiceUtil.addSPAssetEntry(themeDisplay.getScopeGroupId(),
							themeDisplay.getCompanyId(), themeDisplay.getUserId(), spAssetTypeId, spAssetEntrySubType,
							coverFileEntryId, classNameId, title, description, content, link, status, statusByUserName,
							serviceContext);

				} else {
					spAssetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(spAssetEntryId);
					spAssetEntry.setTitle(title);
					SPAssetEntryLocalServiceUtil.updateSPAssetEntry(spAssetEntry);
				}
				obj.put("entryId", spAssetEntry.getSpAssetEntryId());
			} catch (PortalException e) {
				_log.error(e);
				obj.put("error", "Error while saving title");
			} catch (SystemException e) {
				obj.put("error", "Error while saving title");
				_log.error(e);
			}

			PrintWriter out = resourceResponse.getWriter();
			out.print(obj.toString());

		} else if (action.equals("uploadFile")) {
			// TODO:permission checks
			JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			String sourceFileName = uploadRequest.getFileName("file");
			long spAssetEntryId = GetterUtil.getLong(uploadRequest.getParameter("spAssetEntryId"));

			_log.error("sourceFileName : " + sourceFileName + " : spAssetEntryId : "
					+ uploadRequest.getParameter("spAssetEntryId"));

			try {
				SPAssetEntry spAssetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(spAssetEntryId);
				// TODO: validate sp asset entry and it dl folder id.
				if (Validator.isNotNull(spAssetEntry)) {
					InputStream in = uploadRequest.getFileAsStream("file");
					String contentType = uploadRequest.getContentType("file");
					try {
						FileEntry flEnty = DLAppServiceUtil.getFileEntry(groupId, spAssetEntry.getDlFolderId(),
								sourceFileName);
						if (Validator.isNotNull(flEnty)) {
							// generate unique name
							sourceFileName = getUniqueFileName(sourceFileName);
						}
					} catch (PortalException e) {
						// unique name
					}

					ServiceContext fileServiceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
							resourceRequest);
					FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
							themeDisplay.getScopeGroupId(), spAssetEntry.getDlFolderId(), sourceFileName, contentType,
							sourceFileName, sourceFileName, StringPool.BLANK, in, uploadRequest.getSize("file"),
							fileServiceContext);

					if (spAssetEntry.getCoverFileEntryId() < 1) {
						ServiceContext serviceContext = ServiceContextFactory.getInstance(SPAssetEntry.class.getName(),
								resourceRequest);
						spAssetEntry.setCoverFileEntryId(fileEntry.getFileEntryId());
						SPAssetEntryLocalServiceUtil.updateAssetEntry(spAssetEntry, serviceContext);
					}

					try {
						if (VideoProcessorUtil.isSupported(contentType)) {
							List<String> fileGuesetPerms = new ArrayList<String>();
							fileGuesetPerms.add(ActionKeys.VIEW);
							ResourceLocalServiceUtil.updateResources(fileEntry.getCompanyId(), fileEntry.getGroupId(),
									DLFileEntry.class.getName(), fileEntry.getFileEntryId(), new String[] {},
									fileGuesetPerms.toArray(new String[] {}));

							VideoFileEntryLocalServiceUtil.addVideoFileEntry(themeDisplay.getScopeGroup().getName(),
									fileEntry.getFileVersion(), DLUtil.getPreviewURL(fileEntry,
											fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK));

						} else {
							_log.error("Video mime type not supported : " + contentType);
						}
					} catch (Exception e) {
						_log.error("Video Conversion job failed to execute : " + e.getMessage());
					}

					dataJSONObject.put("fileEntryId", fileEntry.getFileEntryId());

					resourceResponse.getWriter().write(dataJSONObject.toString());
				}
			} catch (Exception e) {
				throw new PortletException("Valid SPAssetEntry not found in draft status.");
			}

		} else if ("delete".equals(action)) {

			String spAssetTypeId = null;
			UploadPortletRequest uploadRequest;
			String sourceFileName = "";
			String spAssetEntryId = null;

			PortletPreferences prefs = resourceRequest.getPreferences();
			spAssetTypeId = prefs.getValue("assetType", "");

			uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

			if (Validator.isNotNull(uploadRequest.getParameter("fileName") != null)) {
				sourceFileName = uploadRequest.getParameter("fileName");
			}
			if (Validator.isNotNull(uploadRequest.getParameter("spAssetEntryId") != null)) {
				spAssetEntryId = uploadRequest.getParameter("spAssetEntryId");
			}

			long spAssetEntryFolderId;
			try {
				long spAssetFolderId = DLAppServiceUtil.getFolder(repositoryId, 0,
						SPAssetConstants.SPASSET_ROOT_FOLDER_NAME).getFolderId();

				long spAssetTypeFolderId = DLAppServiceUtil.getFolder(repositoryId, spAssetFolderId,
						String.valueOf(spAssetTypeId)).getFolderId();

				spAssetEntryFolderId = DLAppServiceUtil.getFolder(repositoryId, spAssetTypeFolderId, spAssetEntryId)
						.getFolderId();

				DLFileEntry remFile = DLFileEntryLocalServiceUtil.getFileEntry(groupId, spAssetEntryFolderId,
						sourceFileName);

				DLAppLocalServiceUtil.deleteFileEntry(remFile.getFileEntryId());

			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}

		} else if ("checkfilesBeforeConfirm".equals(type)) {
			String fldIdr = ParamUtil.getString(resourceRequest, "folderId");
			int fileEntryCount = 0;
			if (Long.parseLong(fldIdr) > 0) {
				try {
					fileEntryCount = DLFileEntryLocalServiceUtil.getFileEntriesCount(themeDisplay.getScopeGroupId(),
							Long.parseLong(fldIdr));
				} catch (NumberFormatException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				}
			}
			JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
			dataJSONObject.put("fileEntryCount", fileEntryCount);
			resourceResponse.getWriter().write(dataJSONObject.toString());
		} else if ("loadmore".equalsIgnoreCase(type)) {
			loadMoreImages(resourceRequest, resourceResponse, Integer.parseInt(totalDisplayResults),
					themeDisplay.getUser(), themeDisplay, Integer.parseInt(pagination));
			super.serveResource(resourceRequest, resourceResponse);
		}else if ("galleryMigrate".equalsIgnoreCase(type)) {
			galleryMigrate(themeDisplay,resourceRequest);
		}
		// super.serveResource(resourceRequest, resourceResponse);
	}



	private void galleryMigrate(ThemeDisplay themeDisplay,
			ResourceRequest resourceRequest) {
			try {
				List<SPAssetEntry> assetEntrylist = SPAssetEntryLocalServiceUtil.getSPAssetEntries(-1,-1);
			
				for (SPAssetEntry assetEntry : assetEntrylist) {
					
					if (Validator.isNotNull(assetEntry)) {
						String fileEntryContent = HtmlUtil.stripHtml(assetEntry.getContent());
						assetEntry.setDescription(fileEntryContent);
						SPAssetEntryLocalServiceUtil.updateSPAssetEntry(assetEntry);
					}
				}	

			} catch (Exception e) {
				_log.error(e);
			}
	}
	
	public static String getCurrentVideoUrl(FileEntry fileEntry, ThemeDisplay themeDisplay,boolean appendToken) {

			com.liferay.portal.kernel.util.StringBundler sb = new com.liferay.portal.kernel.util.StringBundler(13);

			sb.append(themeDisplay.getPortalURL());
			sb.append(themeDisplay.getPathContext());
			sb.append("/documents/");
			sb.append(fileEntry.getRepositoryId());
			sb.append(com.liferay.portal.kernel.util.StringPool.SLASH);
			sb.append(fileEntry.getFolderId());
			sb.append(com.liferay.portal.kernel.util.StringPool.SLASH);
			sb.append(com.liferay.portal.kernel.util.HttpUtil.encodeURL(com.liferay.portal.kernel.util.HtmlUtil.unescape(fileEntry.getTitle()), true));
			sb.append("?version=");
			sb.append(fileEntry.getVersion());

			if (appendToken) {
				sb.append("&t=");

				java.util.Date modifiedDate = fileEntry.getModifiedDate();

				sb.append(modifiedDate.getTime());
			}

			return sb.toString();
	}

	public static void checkAddPermission(PortletRequest request) throws PrincipalException, PortalException,
			SystemException {

		try {
			boolean addAssetEntryPermission = PermissionUtil.authorizeModel(request, SPAssetConstants.PORTLET_ID, SPAssetConstants.ACTION_KEY_ADD);
			//_log.error("addAssetEntryPermission" + addAssetEntryPermission);
			request.setAttribute("addAssetEntryPermission", addAssetEntryPermission);

		} catch (Exception e) {
			_log.error(e);
		}

	}

	public static void checkViewPermission(PortletRequest request) throws PrincipalException, PortalException,
			SystemException {

		try {
			boolean viewAssetEntryPermission = PermissionUtil.authorizeModel(request, SPAssetConstants.PORTLET_ID, SPAssetConstants.ACTION_KEY_VIEW);
			request.setAttribute("viewAssetEntryPermission", viewAssetEntryPermission);

		} catch (Exception e) {
			SessionErrors.add(request.getPortletSession(), "spassetentry-view-perission-error");
		}

	}

	public boolean checkEditPermission(PortletRequest request, long spAssetEntryId, ThemeDisplay themeDisplay,
			long docUserId) throws PrincipalException, PortalException, SystemException {

		boolean editPermFlag = false;

		try {
			editPermFlag = PermissionUtil.authorizeModel(request, SPAssetConstants.PORTLET_ID, SPAssetConstants.ACTION_KEY_UPDATE);
			boolean userEditPermission = false;
			if ((themeDisplay.getUserId() == docUserId)
					|| (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))) {
				userEditPermission = true;
			}
			_log.error("editPermFlag " + editPermFlag + " userEditPermission " + userEditPermission);
			if (editPermFlag && userEditPermission) {
				editPermFlag = true;
			} else {
				editPermFlag = false;
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return editPermFlag;

	}

	public boolean checkDeletePermission(PortletRequest request, long spAssetEntryId, ThemeDisplay themeDisplay,
			long docUserId) throws PrincipalException, PortalException, SystemException {

		boolean deletePermFlag = false;

		try {

			deletePermFlag = PermissionUtil.authorizeModel(request, SPAssetConstants.PORTLET_ID, SPAssetConstants.ACTION_KEY_DELETE);
			boolean userDelPermission = false;
			if ((themeDisplay.getUserId() == docUserId)
					|| (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))) {
				userDelPermission = true;
			}
			if (deletePermFlag && userDelPermission) {
				deletePermFlag = true;
			} else {
				deletePermFlag = false;
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return deletePermFlag;

	}

	public boolean checkDownloadPermission(PortletRequest request, long spAssetEntryId, ThemeDisplay themeDisplay,
			long docUserId) throws PrincipalException, PortalException, SystemException {

		boolean downloadPermFlag = false;

		try {

			downloadPermFlag = PermissionUtil.authorizeModel(request, SPAssetConstants.PORTLET_ID,
					SPAssetConstants.ACTION_KEY_DOWNLOAD);
			boolean userDwnlPermission = false;
			if ((themeDisplay.getUserId() == docUserId)
					|| (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))) {
				userDwnlPermission = true;
			}
			if (downloadPermFlag && userDwnlPermission) {
				downloadPermFlag = true;
			} else {
				downloadPermFlag = false;
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return downloadPermFlag;

	}

	private void setupResponseHeaders(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String zipFileMimeType = "application/zip";
		resourceResponse.setContentType(zipFileMimeType);
		int multipleFileDownloadCacheMaxAge = DEFAULT_DL_FILE_DOWNLOAD_CACHE_MAX_AGE;
		if (multipleFileDownloadCacheMaxAge > 0) {
			String cacheControlValue = "max-age=" + multipleFileDownloadCacheMaxAge + ", must-revalidate";
			resourceResponse.addProperty("Cache-Control", cacheControlValue);
		}
		String zipFileName = "ATTACHMENTS_" + new Date().getTime() + ZIP_FILE_EXT;
		String contentDispositionValue = "attachment; filename=\"" + zipFileName + "\"";
		resourceResponse.addProperty("Content-Disposition", contentDispositionValue);
	}

	private void downloadMultipleFilesInZip(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			List<String> fileIdsArray) throws PortalException {
		try {
			DownloadFilesZipHelper
					.exportMultipleFilesToZipFile(fileIdsArray, resourceResponse.getPortletOutputStream());
		} catch (Exception e) {
			String msg = "Error downloading files " + e.getMessage();
			_log.error(msg, e);
			throw new PortalException(msg, e);
		}
	}

	public void searchAssetEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

		try {

			searchText = ParamUtil.getString(actionRequest, "searchText");

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private boolean isFoundInSearch(List<Document> docs, SPAssetEntry assetEntry) {
		boolean found = false;
		for (Document document : docs) {
			long entryId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
			if (assetEntry.getSpAssetEntryId() == entryId) {
				found = true;
				break;
			}
		}
		return found;
	}

	private String getUniqueFileName(String sourceFileName) {
		int index = sourceFileName.lastIndexOf(".");
		StringBuilder sb = new StringBuilder(sourceFileName);

		return index != -1 ? sb.insert(index, ("_" + Calendar.getInstance().getTimeInMillis())).toString()
				: sourceFileName + "_" + Calendar.getInstance().getTimeInMillis();

	}

}
