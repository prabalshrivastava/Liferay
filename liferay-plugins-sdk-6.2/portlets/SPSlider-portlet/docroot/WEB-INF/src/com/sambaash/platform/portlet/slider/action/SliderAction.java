package com.sambaash.platform.portlet.slider.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.slider.wrapper.*;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Portlet implementation class SliderAction
 */
public class SliderAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SliderAction.class);

	private static List<AssetVocabulary> assetVocabularies;

	private static List<AssetCategory> interestCategories = null;

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		List<List<Comparable>> imageCatgList = new ArrayList<List<Comparable>>();
		PortletPreferences preferences = renderRequest.getPreferences();
		try {
			String category = StringPool.BLANK;
			String parentCategory = StringPool.BLANK;

			String searchPriority = preferences.getValue("searchPriority", "0");
			String selectedCategory = preferences.getValue("feedSearchCatId", "0");
			String feedSearchVocId = preferences.getValue("feedSearchVocId", "0");
			String feedSearchCriteria = preferences.getValue("feedSearchCriteria", "");

			long parentFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "Slider").getFolderId();
			User user = themeDisplay.getUser();
			String countryName = SambaashUtil.getUserCountry(user.getUserId());
			String deptName = SambaashUtil.getUserDepartment(user.getUserId());

			if (Validator.isNotNull(httpRequest.getParameter("parentCategory"))) {
				parentCategory = httpRequest.getParameter("parentCategory");
			}

			if (Validator.isNotNull(httpRequest.getParameter("category"))) {
				category = httpRequest.getParameter("category");
			}

			if (Validator.isNull(category)) {
				if (feedSearchCriteria.equalsIgnoreCase("custom")) {
					try {
						imageCatgList = getImageListByCustomFields(feedSearchVocId, selectedCategory, themeDisplay,
								parentFolderId);
					} catch (Exception e) {
						_log.error("fileentrylist no found " + e.getMessage());
					}
				} else {
					if (searchPriority.equalsIgnoreCase("region")) {
						/** First search by Region **/
						Folder regionFolder = null;
						try {
							regionFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
									"Region");
							long regionFolderId = regionFolder.getFolderId();
							imageCatgList = getImageListByPriority(regionFolderId, themeDisplay, imageCatgList);
						} catch (Exception ce) {
							_log.error("No region folder found " + ce.getMessage());
						}

						Folder countryFolder = null;
						try {
							countryFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
									countryName);
							long countryFolderId = countryFolder.getFolderId();
							/** Second search by user CountryName **/
							if (!countryName.equalsIgnoreCase("Region")) {
								imageCatgList = getImageListByPriority(countryFolderId, themeDisplay, imageCatgList);
							}

							/** Third search by user Country-Department Name **/
							long deptFolderId = DLAppServiceUtil
									.getFolder(themeDisplay.getScopeGroupId(), countryFolderId, deptName).getFolderId();
							imageCatgList = getImageListByPriority(deptFolderId, themeDisplay, imageCatgList);
						} catch (Exception ce) {
							_log.error("No country / department found " + ce.getMessage());
						}
					} else {
						Folder countryFolder = null;
						try {
							countryFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
									countryName);
							long countryFolderId = countryFolder.getFolderId();
							/** first search by user CountryName **/
							imageCatgList = getImageListByPriority(countryFolderId, themeDisplay, imageCatgList);
							/**
							 * Second search by user Country-Department Name
							 **/
							long deptFolderId = DLAppServiceUtil
									.getFolder(themeDisplay.getScopeGroupId(), countryFolderId, deptName).getFolderId();
							imageCatgList = getImageListByPriority(deptFolderId, themeDisplay, imageCatgList);
						} catch (Exception ce) {
							_log.error("No country / department found " + ce.getMessage());
						}

						/** Third search by Region **/
						Folder regionFolder = null;
						try {
							regionFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
									"Region");
							long regionFolderId = regionFolder.getFolderId();
							imageCatgList = getImageListByPriority(regionFolderId, themeDisplay, imageCatgList);
						} catch (Exception ce) {
							_log.error("No region folder found " + ce.getMessage());
						}
					}
				}
			} else {
				AssetCategory asstCatg = null;
				try {
					asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(parentCategory));
					String secParentFolderName = asstCatg.getName();
					Folder secParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
							secParentFolderName);
					long secParentFolderId = secParentFolder.getFolderId();

					asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(category));
					String trdParentFolderName = asstCatg.getName();
					Folder trdParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
							secParentFolderId, trdParentFolderName);

					imageCatgList = getImageListByPriority(trdParentFolder.getFolderId(), themeDisplay, imageCatgList);

					if (imageCatgList.size() < 1) {
						imageCatgList = getImageListByPriority(trdParentFolder.getParentFolderId(), themeDisplay,
								imageCatgList);
					}

				} catch (Exception e) {
					_log.error("No folder found for country department selected from menu " + e.getMessage());
				}
			}

		} catch (Exception e) {
			_log.error("fileentrylist no found " + e.getMessage());
		}
		String licenseKey = preferences.getValue("licenseKey", "0");
		renderRequest.setAttribute("licenseKey", licenseKey);
		renderRequest.setAttribute("sliderId", preferences.getValue("sliderId", "slide"));
		renderRequest.setAttribute("effect", preferences.getValue("effect", "slide"));
		renderRequest.setAttribute("autoAdvance", preferences.getValue("autoAdvance", "true"));
		renderRequest.setAttribute("pauseOnHover", preferences.getValue("pauseOnHover", "true"));
		renderRequest.setAttribute("pauseTime", preferences.getValue("pauseTime", "3500"));
		renderRequest.setAttribute("speed", preferences.getValue("speed", "default"));
		renderRequest.setAttribute("startSlide", preferences.getValue("startSlide", "0"));
		renderRequest.setAttribute("aspectRatio", preferences.getValue("aspectRatio", "fixed"));
		renderRequest.setAttribute("circular", preferences.getValue("circular", "true"));
		renderRequest.setAttribute("touchCircular", preferences.getValue("touchCircular", "true"));
		renderRequest.setAttribute("mobileNavigation", preferences.getValue("mobileNavigation", "false"));
		renderRequest.setAttribute("before", preferences.getValue("before", "null"));
		renderRequest.setAttribute("after", preferences.getValue("after", "null"));
		renderRequest.setAttribute("multipleImages", preferences.getValue("multipleImages", "null"));

		renderRequest.setAttribute("imageCatgList", imageCatgList);

		super.doView(renderRequest, renderResponse);
	}

	private List<List<Comparable>> getImageListByPriority(long searchFolderId, ThemeDisplay themeDisplay,
			List<List<Comparable>> imageCatgList) {
		List<FileEntry> fileEntryList = null;
		try {
			fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), searchFolderId);

			for (FileEntry fentry : fileEntryList) {
				List<Comparable> imageCatg = new ArrayList<Comparable>();
				String imgUrl = "/documents/";
				imgUrl = imgUrl + fentry.getRepositoryId() + "/" + fentry.getFolderId() + "/" + fentry.getTitle()
						+ "?version=" + fentry.getVersion();
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fentry.getFileEntryId());
				imageCatg.add(imgUrl);
				imageCatg.add(fentry.getTitle());
				imageCatg.add(fentry.getFileEntryId());
				imageCatg.add(dlFileEntry.getExtraSettings());
				imageCatgList.add(imageCatg);
			}
		} catch (Exception e) {

			// TODO Auto-generated catch block

		}

		return imageCatgList;
	}

	private List<List<Comparable>> getImageListByCustomFields(String feedSearchVocId, String selectedCategory,
			ThemeDisplay themeDisplay, long parentFolderId) throws Exception, NumberFormatException {
		List<List<Comparable>> imageCatgList = new ArrayList<List<Comparable>>();
		String selectedSecFolderName = getAssetVocabularyName(Long.parseLong(feedSearchVocId));
		long selectedSecFolderId = DLAppServiceUtil
				.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, selectedSecFolderName).getFolderId();

		AssetCategory asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(selectedCategory));

		String selectedTrdFolderName = asstCatg.getName();// getAssetCategoryName(Long.parseLong(selectedCategory));
		long selectedTrdFolderId = 0;// DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
										// selectedSecFolderId,selectedTrdFolderName).getFolderId();

		if (asstCatg.getParentCategoryId() > 0) {
			selectedTrdFolderName = getAssetCategoryName(asstCatg.getParentCategoryId());
			selectedTrdFolderId = DLAppServiceUtil
					.getFolder(themeDisplay.getScopeGroupId(), selectedSecFolderId, selectedTrdFolderName)
					.getFolderId();

			String selectedFrthFolderName = asstCatg.getName();
			long selectedFrthFolderId = DLAppServiceUtil
					.getFolder(themeDisplay.getScopeGroupId(), selectedTrdFolderId, selectedFrthFolderName)
					.getFolderId();

			selectedTrdFolderName = selectedFrthFolderName;
			selectedTrdFolderId = selectedFrthFolderId;
		} else {
			selectedTrdFolderId = DLAppServiceUtil
					.getFolder(themeDisplay.getScopeGroupId(), selectedSecFolderId, selectedTrdFolderName)
					.getFolderId();
		}

		List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
				selectedTrdFolderId);

		for (FileEntry fentry : fileEntryList) {
			List<Comparable> imageCatg = new ArrayList<Comparable>();
			String imgUrl = "/documents/";
			imgUrl = imgUrl + fentry.getRepositoryId() + "/" + fentry.getFolderId() + "/" + fentry.getTitle()
					+ "?version=" + fentry.getVersion();
			imageCatg.add(imgUrl);
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fentry.getFileEntryId());
			imageCatg.add(fentry.getTitle());
			imageCatg.add(fentry.getFileEntryId());
			imageCatg.add(dlFileEntry.getExtraSettings());
			imageCatgList.add(imageCatg);
		}

		return imageCatgList;
	}

	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String imageUpload = (String) renderRequest.getAttribute("imageUpload");
		AssetVocabulary assetVocabulary = null;
		String spParameter = StringPool.BLANK;

		String searchPriority = preferences.getValue("searchPriority", "0");
		String selectedCategory = preferences.getValue("feedSearchCatId", "0");
		String feedSearchVocId = preferences.getValue("feedSearchVocId", "0");
		String channel = preferences.getValue("channel", "0");
		String feedSearchCriteria = preferences.getValue("feedSearchCriteria", "");
		String defaultCategory = "No Default Category available";

		if (Validator.isNull(feedSearchCriteria)) {
			feedSearchCriteria = "countryRegion";
		}

		if (Validator.isNull(searchPriority)) {
			searchPriority = "region";
		}
		try {
			spParameter = SambaashUtil.getParameter(SambaashConstants.CATEGORIES.MAPPED_CATEGORY,
					themeDisplay.getScopeGroupId()); // to get the default

			// mapped category for
			// filtering

			assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(Long.parseLong(spParameter));
			defaultCategory = assetVocabulary.getName();

			// assetVocabularies = getAssetVocabularies();

		} catch (Exception e) {
			_log.error("error getting assetvocabulary in edit " + e.getMessage());
		}

		try {
			renderRequest.setAttribute("assetVocabularies", getAssetVocabularies());
			renderRequest.setAttribute("allChannelWrappers", getAllChannelWrappers(spParameter));
		} catch (SystemException e1) {

			_log.error("Errro getting Asset vocabularies " + e1.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		renderRequest.setAttribute("channel", channel);
		renderRequest.setAttribute("feedSearchVocId", feedSearchVocId);
		renderRequest.setAttribute("feedSearchCatId", selectedCategory);
		renderRequest.setAttribute("region", "checked");

		if ("custom".equalsIgnoreCase(feedSearchCriteria)) {
			renderRequest.setAttribute("custom", "checked");
		} else {
			renderRequest.setAttribute("countryRegion", "checked");

			if ("country".equalsIgnoreCase(searchPriority)) {
				renderRequest.setAttribute("country", "checked");
				renderRequest.setAttribute("region", "");
			} else {
				renderRequest.setAttribute("region", "checked");
				renderRequest.setAttribute("country", "");
			}
		}

		renderRequest.setAttribute("searchPriority", searchPriority);
		renderRequest.setAttribute("defaultCategory", defaultCategory);
		renderRequest.setAttribute("selectedCategory", selectedCategory);

		String vocabularyId = spParameter;// preferences.getValue("selectedCategory",

		// "0");

		String selectedCategoryId = selectedCategory;

		List<AssetCategory> assetCategory = new ArrayList<AssetCategory>();
		List<List<Comparable>> imageCatgList = new ArrayList<List<Comparable>>();
		boolean hasAccess = false;
		try {
			hasAccess = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		} catch (Exception e) {
			_log.error("error getting assetvocabulary in edit " + e.getMessage());
		}

		try {
			int spRolesCount = SPRolesLocalServiceUtil.getSPRolesesCount();

			if (spRolesCount > 0) {
				if (!hasAccess) {
					AssetCategory assetCategoryRes = null;
					List<Role> roleListOfLoggedInUser = RoleServiceUtil.getUserRoles(themeDisplay.getUserId());
					int c = 0;

					for (Role roles : roleListOfLoggedInUser) {
						long roleId = roles.getRoleId();
						List<SPRoles> spRolesList = SPRolesLocalServiceUtil
								.findByRoleId(SambaashUtil.getGroupId(themeDisplay.getCompanyId()), roleId);
						long[] categoryIds = new long[spRolesList.size()];

						if (!spRolesList.isEmpty()) {
							for (SPRoles spRoles : spRolesList) {
								categoryIds[c] = spRoles.getCategoryId1();
								assetCategoryRes = AssetCategoryLocalServiceUtil.getAssetCategory(categoryIds[c]);
								c = c + 1;

								if (assetCategory != null) {
									if (!assetCategory.contains(assetCategoryRes)) {
										assetCategory.add(assetCategoryRes);
									}
								}
							}
						}
					}
				} else if (hasAccess) {
					assetCategory = getInterestCategories(Long.parseLong(vocabularyId));
				}
			}
		} catch (Exception ae) {
			_log.error("error getting assetcatrgoy based on role " + ae.getMessage());
		}

		renderRequest.setAttribute("selectedCategoryId", selectedCategory);

		if (feedSearchCriteria.equalsIgnoreCase("custom")) {
			try {
				long parentFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "Slider")
						.getFolderId();
				imageCatgList = getImageListByCustomFields(feedSearchVocId, selectedCategory, themeDisplay,
						parentFolderId);

			} catch (Exception e) {
				_log.error("fileentrylist no found " + e.getMessage());
			}
		} else if (feedSearchCriteria.equalsIgnoreCase("countryRegion")) {
			try {
				long parentFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "Slider")
						.getFolderId();
				imageCatgList = getImageListBySearchCategory(selectedCategory, themeDisplay, parentFolderId);

			} catch (Exception e) {
				_log.error("fileentrylist no found " + e.getMessage());
			}
		}

		String licenseKey = preferences.getValue("licenseKey", "0");
		renderRequest.setAttribute("licenseKey", licenseKey);
		renderRequest.setAttribute("sliderId", preferences.getValue("sliderId", "slide"));
		renderRequest.setAttribute("effect", preferences.getValue("effect", "slide"));
		renderRequest.setAttribute("autoAdvance", preferences.getValue("autoAdvance", "true"));
		renderRequest.setAttribute("pauseOnHover", preferences.getValue("pauseOnHover", "true"));
		renderRequest.setAttribute("pauseTime", preferences.getValue("pauseTime", "3500"));
		renderRequest.setAttribute("speed", preferences.getValue("speed", "default"));
		renderRequest.setAttribute("startSlide", preferences.getValue("startSlide", "0"));
		renderRequest.setAttribute("aspectRatio", preferences.getValue("aspectRatio", "fixed"));
		renderRequest.setAttribute("circular", preferences.getValue("circular", "true"));
		renderRequest.setAttribute("touchCircular", preferences.getValue("touchCircular", "true"));
		renderRequest.setAttribute("mobileNavigation", preferences.getValue("mobileNavigation", "false"));
		renderRequest.setAttribute("before", preferences.getValue("before", "null"));
		renderRequest.setAttribute("after", preferences.getValue("after", "null"));
		renderRequest.setAttribute("multipleImages", preferences.getValue("multipleImages", "null"));

		renderRequest.setAttribute("imageCatgList", imageCatgList);
		renderRequest.setAttribute("hasAccess", hasAccess);
		renderRequest.setAttribute("mainAssetCategory", assetCategory);
		renderRequest.setAttribute("imageUpload", imageUpload);
		renderRequest.setAttribute("selectedCategoryId", selectedCategoryId);

		super.doEdit(renderRequest, renderResponse);
	}

	private List<List<Comparable>> getImageListBySearchCategory(String selectedCategory, ThemeDisplay themeDisplay,
			long parentFolderId) throws Exception {

		List<List<Comparable>> imageCatgList = new ArrayList<List<Comparable>>();
		AssetCategory asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(selectedCategory));
		long secFolderCatgId = asstCatg.getParentCategoryId();
		String secFolderName = StringPool.BLANK;
		long selectedTrdFolderId = 0;
		long secFolderId = 0;

		if (secFolderCatgId > 0) {
			secFolderName = getAssetCategoryName(secFolderCatgId);
			secFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, secFolderName)
					.getFolderId();

			String selectedTrdFolderName = getAssetCategoryName(Long.parseLong(selectedCategory));
			selectedTrdFolderId = DLAppServiceUtil
					.getFolder(themeDisplay.getScopeGroupId(), secFolderId, selectedTrdFolderName).getFolderId();

		} else {
			secFolderName = asstCatg.getName();
			secFolderId = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, secFolderName)
					.getFolderId();
			selectedTrdFolderId = secFolderId;
		}

		List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
				selectedTrdFolderId);

		for (FileEntry fentry : fileEntryList) {
			List<Comparable> imageCatg = new ArrayList<Comparable>();
			String imgUrl = "/documents/";
			imgUrl = imgUrl + fentry.getRepositoryId() + "/" + fentry.getFolderId() + "/" + fentry.getTitle()
					+ "?version=" + fentry.getVersion();
			imageCatg.add(imgUrl);
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fentry.getFileEntryId());
			imageCatg.add(fentry.getTitle());
			imageCatg.add(fentry.getFileEntryId());
			imageCatg.add(dlFileEntry.getExtraSettings());
			imageCatgList.add(imageCatg);
		}

		return imageCatgList;

	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();

		if (action.equalsIgnoreCase("imageUpload")) {
			String searchPriority = actionRequest.getParameter("searchPriority");
			String feedSearchCriteria = actionRequest.getParameter("feedSearchCriteria");
			String feedSearchVocId = actionRequest.getParameter("feedSearchVocId");
			String feedSearchCatId = actionRequest.getParameter("feedSearchCatId");
			String selCatg = actionRequest.getParameter("defaultCategory_sel_list");

			if (Validator.isNotNull(searchPriority)) {
				preferences.setValue("searchPriority", searchPriority);
				preferences.store();
			}

			if (Validator.isNotNull(feedSearchCriteria)) {
				preferences.setValue("feedSearchCriteria", feedSearchCriteria);
				preferences.store();
			}

			if (Validator.isNotNull(selCatg)) {
				preferences.setValue("channel", selCatg);
				preferences.setValue("selectedCategoryId", selCatg);
				preferences.setValue("feedSearchCatId", selCatg);
				preferences.store();
			}

			if (Validator.isNotNull(feedSearchCatId)) {
				if ("custom".equalsIgnoreCase(feedSearchCriteria)) {
					preferences.setValue("feedSearchCatId", feedSearchCatId);
					preferences.store();
				}
			}

			if (Validator.isNotNull(feedSearchVocId)) {
				preferences.setValue("feedSearchVocId", feedSearchVocId);
				preferences.store();
			}

			actionRequest.setAttribute("selectedCategoryView", selCatg);

			actionResponse.setPortletMode(PortletMode.EDIT);

		}

		if (Constants.VIEW.equalsIgnoreCase(action)) {
			String selCatg = actionRequest.getParameter("mainCategory_sel_list");
			actionRequest.setAttribute("selectedCategoryView", selCatg);
			preferences.setValue("selectedCategoryId", selCatg);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		}

		if (action.equalsIgnoreCase("reLoad")) {
			preferences.setValue("selectedCategory", "0");
			preferences.store();
		}

		super.processAction(actionRequest, actionResponse);
	}

	public AssetVocabulary addAssetVocabulary(long userId, String title, ActionRequest actionRequest)
			throws PortalException, SystemException {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetVocabulary.class.getName(),
				actionRequest);
		return AssetVocabularyLocalServiceUtil.addVocabulary(userId, title, titleMap, null, null, serviceContext);
	}

	public AssetCategory addAssetCatagories(long userId, String title, long vocabularyId, ActionRequest actionRequest)
			throws PortalException, SystemException {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetCategory.class.getName(), actionRequest);
		return AssetCategoryLocalServiceUtil.addCategory(userId, 0, titleMap, null, vocabularyId, null, serviceContext);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String action = request.getParameter("action");
		String selectedCategoryId = "0";
		String selectedCustomVocId = "0";
		long scopeGroupId = themeDisplay.getScopeGroupId();
		HttpServletRequest request_ = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request_);
		String folderName = "";
		Folder firstParentFolder = null;
		Folder secParentFolder = null;
		Folder thirdParentFolder = null;
		Folder fourthParentFolder = null;

		if ("uploadFile".equalsIgnoreCase(action)) {
			selectedCategoryId = ParamUtil.getString(request, "categoryId");
			selectedCustomVocId = ParamUtil.getString(request, "customVocabId");
			String searchPriorityId = ParamUtil.getString(request, "searchPriority");
			String feedSearchCriteria = ParamUtil.getString(request, "feedSearchCriteria");

			PortletPreferences preferences = request.getPreferences();
			preferences.setValue("feedSearchCriteria", feedSearchCriteria);
			preferences.setValue("feedSearchVocId", selectedCustomVocId);
			preferences.setValue("feedSearchCatId", selectedCategoryId);
			preferences.setValue("searchPriority", searchPriorityId);
			preferences.store();
			folderName = "Slider";
			try {
				firstParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, folderName);
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
				ServiceContext serviceContext;
				try {
					serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
					firstParentFolder = createParentFolder(serviceContext, themeDisplay.getScopeGroupId(),
							themeDisplay.getCompanyId(), folderName, themeDisplay.getUser());

					if (Validator.isNull(firstParentFolder)) {

					}
				} catch (PortalException e1) {
					_log.error(e1);
				} catch (SystemException e1) {
					_log.error(e1);
				}
			}

			if (Long.parseLong(selectedCustomVocId) != 0) {
				try {
					folderName = getAssetVocabularyName(Long.parseLong(selectedCustomVocId));
					secParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
							firstParentFolder.getFolderId(), folderName);
				} catch (Exception e2) {
					_log.error(e2.getMessage(), e2);
					try {
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
								request);
						secParentFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(),
								firstParentFolder.getFolderId(), folderName, "", serviceContext);
						PermissionUtil.addDefaultRoleResourcePermission(themeDisplay.getCompanyId(),
								DLFolder.class.getName(), secParentFolder.getFolderId(), new String[] { ActionKeys.VIEW,
										ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER });
					} catch (Exception ep) {
						_log.error(ep.getMessage(), ep);
					}
				}
			} else {
				AssetCategory asstCatg = null;
				long prntCatgId = 0;
				try {
					asstCatg = AssetCategoryLocalServiceUtil.getCategory(Long.parseLong(selectedCategoryId));
					prntCatgId = asstCatg.getParentCategoryId();
				} catch (Exception e) {
					_log.error(e);
				}

				if (prntCatgId > 0) {
					try {
						folderName = getAssetCategoryName(prntCatgId);
						secParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
								firstParentFolder.getFolderId(), folderName);
					} catch (Exception e2) {
						_log.error(e2.getMessage(), e2);
						try {
							ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
									request);
							secParentFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(),
									firstParentFolder.getFolderId(), folderName, "", serviceContext);
							PermissionUtil.addDefaultRoleResourcePermission(themeDisplay.getCompanyId(),
									DLFolder.class.getName(), secParentFolder.getFolderId(),
									new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
											ActionKeys.ADD_SUBFOLDER });
						} catch (Exception ep) {
							_log.error(ep.getMessage(), ep);
						}
					}
				} else {
					secParentFolder = firstParentFolder;
				}
			}

			if (Long.parseLong(selectedCategoryId) != 0) {

				AssetCategory asstCatg = null;
				long prntCatgId = 0;
				try {
					asstCatg = AssetCategoryLocalServiceUtil.getCategory(Long.parseLong(selectedCategoryId));
					prntCatgId = asstCatg.getParentCategoryId();
				} catch (Exception e) {
					_log.error(e);
				}

				if (prntCatgId > 0) {
					try {
						folderName = getAssetCategoryName(prntCatgId);
						thirdParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
								secParentFolder.getFolderId(), folderName);
					} catch (Exception e2) {
						_log.error(e2.getMessage(), e2);
						try {
							ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
									request);
							thirdParentFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(),
									secParentFolder.getFolderId(), folderName, "", serviceContext);
							PermissionUtil.addDefaultRoleResourcePermission(themeDisplay.getCompanyId(),
									DLFolder.class.getName(), thirdParentFolder.getFolderId(),
									new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
											ActionKeys.ADD_SUBFOLDER });
						} catch (Exception ep) {
							_log.error(ep.getMessage(), ep);
						}
					}

					/** to create fourth level of folder **/
					try {
						folderName = getAssetCategoryName(Long.parseLong(selectedCategoryId));
						fourthParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
								thirdParentFolder.getFolderId(), folderName);
						thirdParentFolder = fourthParentFolder;
					} catch (Exception e2) {
						_log.error(e2.getMessage(), e2);
						try {
							ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
									request);
							fourthParentFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(),
									thirdParentFolder.getFolderId(), folderName, "", serviceContext);
							PermissionUtil.addDefaultRoleResourcePermission(themeDisplay.getCompanyId(),
									DLFolder.class.getName(), fourthParentFolder.getFolderId(),
									new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
											ActionKeys.ADD_SUBFOLDER });
							thirdParentFolder = fourthParentFolder;
						} catch (Exception ep) {
							_log.error(ep.getMessage(), ep);
						}
					}

				} else {
					try {
						folderName = getAssetCategoryName(Long.parseLong(selectedCategoryId));
						thirdParentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
								secParentFolder.getFolderId(), folderName);
					} catch (Exception e2) {
						_log.error(e2.getMessage(), e2);
						try {
							ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
									request);
							thirdParentFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(),
									secParentFolder.getFolderId(), folderName, "", serviceContext);
							PermissionUtil.addDefaultRoleResourcePermission(themeDisplay.getCompanyId(),
									DLFolder.class.getName(), thirdParentFolder.getFolderId(),
									new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
											ActionKeys.ADD_SUBFOLDER });
						} catch (Exception ep) {
							_log.error(ep.getMessage(), ep);
						}
					}
				}
			}

			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);

				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);
				FileEntry fileEntry = null;
				boolean isDuplicate = false;
				JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();

				for (FileItem item : items) {
					String name = SambaashUtil.getValidFileName(item.getName());

					try {
						if (Long.parseLong(selectedCategoryId) != 0) {
							fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, thirdParentFolder.getFolderId(),
									name, item.getContentType(), name, StringPool.BLANK, StringPool.BLANK,
									item.getInputStream(), item.getSize(), serviceContext);
						} else {
							fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, firstParentFolder.getFolderId(),
									name, item.getContentType(), name, StringPool.BLANK, StringPool.BLANK,
									item.getInputStream(), item.getSize(), serviceContext);
						}

						PermissionUtil.addDefaultRoleResourcePermission(themeDisplay.getCompanyId(),
								DLFileEntry.class.getName(), fileEntry.getFileEntryId(),
								new String[] { ActionKeys.VIEW, ActionKeys.UPDATE });
					} catch (DuplicateFileException dfe) {
						_log.error(dfe);
						isDuplicate = true;
					}

					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					dataJSONObject.put("isDuplicate", isDuplicate);

					if (fileEntry != null) {
						dataJSONObject.put("fileEntryId", fileEntry.getFileEntryId());
					} else {
						dataJSONObject.put("fileEntryId", 0);
					}
				}

				response.getWriter().write(dataJSONObject.toString());

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		if ("getCats".equalsIgnoreCase(action)) {
			long vocId = GetterUtil.getLong(request.getParameter("vocId"));
			List<AssetCategory> catgs = null;
			try {
				catgs = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, vocId, -1, -1, null);
			} catch (SystemException e) {
				_log.error(e);
			}

			JSONObject json;
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			if (Validator.isNotNull(catgs)) {
				for (AssetCategory catg : catgs) {
					json = JSONFactoryUtil.createJSONObject();
					json.put("id", catg.getCategoryId());
					json.put("value", catg.getName());
					json.put("isChild", "false");
					jsonArray.put(json);

					List<AssetCategory> childCatgs = null;
					try {
						childCatgs = AssetCategoryLocalServiceUtil.getChildCategories(catg.getCategoryId());

						for (AssetCategory childCatg : childCatgs) {
							json = JSONFactoryUtil.createJSONObject();
							json.put("id", childCatg.getCategoryId());
							json.put("value", childCatg.getName());
							json.put("isChild", "true");
							jsonArray.put(json);
						}
					} catch (SystemException e) {
						_log.error(e.getMessage());
					}
				}
			}

			json = JSONFactoryUtil.createJSONObject();
			json.put("items", jsonArray);

			response.getWriter().write(json.toString());
		}

		if ("removeFile".equalsIgnoreCase(action)) {
			try {
				long fileEntryId = ParamUtil.getLong(request, "fileEntryId");
				_log.debug("fileEntryId: " + fileEntryId);
				DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntryId);

				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
				dataJSONObject.put("fileEntryId", fileEntryId);
				response.getWriter().write(dataJSONObject.toString());
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		if ("saveLink".equalsIgnoreCase(action)) {
			try {
				long fileEntryId = ParamUtil.getLong(request, "fileEntryId");
				String linkUrl = ParamUtil.getString(request, "linkUrl");
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
				dlFileEntry.setExtraSettings(linkUrl);
				DLFileEntryLocalServiceUtil.updateDLFileEntry(dlFileEntry);
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
				dataJSONObject.put("fileEntryId", fileEntryId);
				dataJSONObject.put("linkUrl", linkUrl);
				response.getWriter().write(dataJSONObject.toString());
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		if ("saveSliderSettings".equalsIgnoreCase(action)) {
			String licenseKey = request.getParameter("licenseKey");
			String sliderId = request.getParameter("sliderId");
			String effect = request.getParameter("effect");
			String autoAdvance = request.getParameter("autoAdvance");
			String pauseOnHover = request.getParameter("pauseOnHover");
			String pauseTime = request.getParameter("pauseTime");
			String speed = request.getParameter("speed");
			String startSlide = request.getParameter("startSlide");
			String aspectRatio = request.getParameter("aspectRatio");
			String circular = request.getParameter("circular");
			String touchCircular = request.getParameter("touchCircular");
			String mobileNavigation = request.getParameter("mobileNavigation");
			String before = request.getParameter("before");
			String after = request.getParameter("after");
			String multipleImages = request.getParameter("multipleImages");

			PortletPreferences preferences = request.getPreferences();
			preferences.setValue("licenseKey", licenseKey);
			preferences.setValue("sliderId", sliderId);
			preferences.setValue("effect", effect);
			preferences.setValue("autoAdvance", autoAdvance);
			preferences.setValue("pauseOnHover", pauseOnHover);
			preferences.setValue("pauseTime", pauseTime);
			preferences.setValue("speed", speed);
			preferences.setValue("startSlide", startSlide);
			preferences.setValue("circular", circular);
			preferences.setValue("touchCircular", touchCircular);
			preferences.setValue("mobileNavigation", mobileNavigation);
			preferences.setValue("before", before);
			preferences.setValue("after", after);
			preferences.setValue("multipleImages", multipleImages);
			preferences.store();
		}

		super.serveResource(request, response);

	}

	private Folder createParentFolder(ServiceContext serviceContext, long scopeGroupId, long companyId,
			String folderName, User user) {

		Folder newFolder = null;
		try {
			PermissionUtil.initializeAdminPermissionChecker();
			newFolder = DLAppServiceUtil.addFolder(scopeGroupId, 0, folderName, "", serviceContext);
			PermissionUtil.addDefaultRoleResourcePermission(companyId, DLFolder.class.getName(),
					newFolder.getFolderId(), new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
							ActionKeys.ADD_SUBFOLDER });
			PermissionUtil.resetPermissionChecker(user);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return newFolder;
	}

	public static String getAssetVocabularyName(long vocabularyId) throws Exception {

		String vName = "";
		AssetVocabulary assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocabularyId);
		vName = assetVocabularies.getName();
		return vName;
	}

	public static String getAssetCategoryName(long categoryId) throws Exception {

		String cName = "";
		AssetCategory assetCategories = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
		cName = assetCategories.getName();
		return cName;
	}

	public static List<AssetVocabulary> getAssetVocabularies() throws SystemException {

		initAssetVocabularies();
		return assetVocabularies;
	}

	public static void initAssetVocabularies() throws SystemException {

		if (assetVocabularies == null) {
			assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		}
	}

	public static List<AssetCategory> getInterestCategories(long vocabularyId) throws SystemException {

		initInterestCategories(vocabularyId);
		return interestCategories;
	}

	public static void initInterestCategories(long vocabularyId) throws SystemException {

		int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
		interestCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, noOfCategories,
				null);
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
					}
				}
			}
		}

		return allChannelWrappers;
	}

	public static final String DEFAULT_TABLE_NAME = "CUSTOM_FIELDS";

}