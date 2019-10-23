package com.sambaash.platform.portlet.sproles.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.sproles.wrapper.AllChannelWrapper;
import com.sambaash.platform.portlet.sproles.wrapper.ChannelWrapper;
import com.sambaash.platform.srv.roles.model.SPCategoriesMapping;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.service.SPCategoriesMappingLocalServiceUtil;
import com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;

/**
 * Portlet implementation class SPRolesAction
 */
public class SPRolesAction extends MVCPortlet {

	public static String getAssetCategoryName(long categoryId)
		throws Exception {

		String cName = StringPool.BLANK;
		AssetCategory assetCategories = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
		cName = assetCategories.getName();
		return cName;
	}

	public static List<AssetVocabulary> getAssetVocabularies()
		throws SystemException {

		initAssetVocabularies();
		return assetVocabularies;
	}

	public static String getAssetVocabularyName(long vocabularyId)
		throws Exception {

		String vName = StringPool.BLANK;
		AssetVocabulary assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocabularyId);
		vName = assetVocabularies.getName();
		return vName;
	}

	public static List<AssetCategory> getInterestCategories(long vocabularyId)
		throws SystemException {

		initInterestCategories(vocabularyId);
		return interestCategories;
	}

	public static void initAssetVocabularies() throws SystemException {
		if (assetVocabularies == null) {
			assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		}
	}

	public static void initInterestCategories(long vocabularyId)
		throws SystemException {

		int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
		interestCategories =
			AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, noOfCategories, null);
	}

	public AssetCategory addAssetCatagories(long userId, String title, long vocabularyId, ActionRequest actionRequest)
		throws PortalException, SystemException {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetCategory.class.getName(), actionRequest);
		return AssetCategoryLocalServiceUtil.addCategory(userId, 0, titleMap, null, vocabularyId, null, serviceContext);
	}

	public AssetVocabulary addAssetVocabulary(long userId, String title, ActionRequest actionRequest) {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		AssetVocabulary assetVocabulary = null;
		try {
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(AssetVocabulary.class.getName(), actionRequest);
			assetVocabulary =
				AssetVocabularyLocalServiceUtil.addVocabulary(userId, title, titleMap, null, null, serviceContext);
		}
		catch (Exception e) {
			_log.error("AssetVocabulary create error " + e.getMessage());
		}

		return assetVocabulary;
	}

	public void addCategoryMapping(
		ThemeDisplay themeDisplay, ActionRequest actionRequest, PortletPreferences preferences) {

		String saveorupdateVoc = actionRequest.getParameter("saveorupdateVoc");
		String[] subCategory = actionRequest.getParameterValues("subCategory_chk"); // list of subcategories (department) selected/mapped with main category(country)
		String selectedSubCategoryName = preferences.getValue("selectedSubCategoryName", "0");
		String selectedMainCategoryName = preferences.getValue("selectedMainCategoryName", "0");
		String mainCatg = actionRequest.getParameter("mainCategory_sel_list"); // selected main category(country) id
		String subCatgvalues = actionRequest.getParameter("removedSubCatg"); // list of unselected subcategories id
		String subCatgNames = actionRequest.getParameter("removedSubCatgNames"); // list of unselected subcategories  names
		String subMainCatgNames = actionRequest.getParameter("removedmainCatgName"); // selected main category(country) name
		String subCategoryList = StringPool.BLANK;
		String catergoryName = StringPool.BLANK;
		try {
			if (saveorupdateVoc.equalsIgnoreCase("updateVocabulary")) { // delete the respective categories as per the unselested subcategory values

					if (subCatgvalues != null) {
					String[] subCatg = subCatgvalues.split("#");
					String[] subCatgName = subCatgNames.split("#");

					for (int g = 0; g < subCatg.length; g++) {
						try {
							SPCategoriesMapping spCategoriesMapping =
								SPCategoriesMappingLocalServiceUtil.findByMainAndSubCategoryId(
									themeDisplay.getScopeGroupId(), Long.parseLong(mainCatg),
									Long.parseLong(subCatg[g]));
							long deleteVocabularyId = spCategoriesMapping.getCreatedVocabularyId();
							SPCategoriesMappingLocalServiceUtil.deleteSPCategoriesMapping(spCategoriesMapping);
							List<AssetCategory> deleteAssetCatgList =
								AssetCategoryLocalServiceUtil.getVocabularyCategories(deleteVocabularyId, -1, -1, null);

							for (AssetCategory toDelCatg : deleteAssetCatgList) {
								String catgName = subMainCatgNames.trim() + "-" + subCatgName[g].trim();

								if (catgName.equalsIgnoreCase(toDelCatg.getName())) {
									AssetCategoryLocalServiceUtil.deleteAssetCategory(toDelCatg.getCategoryId());
								}
							}
						}
						catch (Exception es) {
							_log.error("Error Deleting spCategoriesMapping " + es.getMessage());
						}
					}
				}

				if (subCategory != null) { // update the dynamically created vocabulary as per the deleted / newly mapped categories

						for (int g = 0; g < subCategory.length; g++) {
						try {
							SPCategoriesMappingLocalServiceUtil.findByMainAndSubCategoryId(
								themeDisplay.getScopeGroupId(), Long.parseLong(mainCatg),
								Long.parseLong(subCategory[g]));
						}
						catch (Exception es) {
							_log.error("No spCategoriesMapping for sub Category." + subCategory[g] +
								"Creating New spCategorysMapping");
							createCategoryMapping(
								themeDisplay, mainCatg, subCategory, actionRequest, subCategoryList, catergoryName,
								selectedSubCategoryName, selectedMainCategoryName);
						}
					}
				}
			}// end of update / delete
			else {
				createCategoryMapping(
					themeDisplay, mainCatg, subCategory, actionRequest, subCategoryList, catergoryName,
					selectedSubCategoryName, selectedMainCategoryName);
			}
		}
		catch (Exception ea) {
			_log.error("error creating new vocabulary " + ea.getMessage());
		}

		actionRequest.setAttribute("subCategoryList", subCategoryList);
		actionRequest.setAttribute("catergoryName", catergoryName);
	}

	public void addRoleCategoryMapping(ThemeDisplay themeDisplay, ActionRequest actionRequest) {

		String saveorupdate = actionRequest.getParameter("saveorupdate");
		String role = actionRequest.getParameter("current_role_Id");
		String catg1VocabularyId = actionRequest.getParameter("selectedCategoryId1");
		String[] ctg1values = actionRequest.getParameterValues("categories1"); //list of selected categories1 to be updated / added
		String[] ctg2values = actionRequest.getParameterValues("categories2"); //list of selected categories1 to be updated / addeds
		String catg1Delete = actionRequest.getParameter("removedCatg1"); // list of categories1 selected for deletion
		String catg2Delete = actionRequest.getParameter("removedCatg2"); // list of categories2 selected for deletion
		_log.debug("ctg1values " + ctg1values.length);
		List<AssetCategory> indCatg1CategoryList = null;
		List<AssetCategory> indCatg2CategoryList = null;

		try {
		String catg1VocabularyName = getAssetVocabularyName(Long.parseLong(catg1VocabularyId));
		String[] splitcatg1VocabularyName = catg1VocabularyName.trim().split("-");

		if (splitcatg1VocabularyName.length >0) {
			long indcatg1VocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), splitcatg1VocabularyName[0]).getVocabularyId();
			indCatg1CategoryList = getInterestCategories(indcatg1VocabularyId);

			long indcatg2VocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), splitcatg1VocabularyName[1]).getVocabularyId();
			indCatg2CategoryList = getInterestCategories(indcatg2VocabularyId);

		}
		}catch (Exception e) {
			_log.error(" indcatg1VocabularyId erreor" + e.getMessage());
		}

		if (saveorupdate.equalsIgnoreCase("update")) {
			String[] splitcatg1Delete = catg1Delete.split("#");
			String[] splitcatg2Delete = catg2Delete.split("#");
			_log.debug("splitcatg1Delete " + splitcatg1Delete);

			if (ctg2values != null) { // to delete the list of unselected categories1 & categories2

					for (int y = 0; y < ctg1values.length; y++) {
					for (int z = 1; z < splitcatg2Delete.length; z++) {
						try {
							SPRoles spRoleDelete =
								SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
									themeDisplay.getScopeGroupId(), Long.parseLong(role),
									Long.parseLong(ctg1values[y]), Long.parseLong(splitcatg2Delete[z]));

							if (spRoleDelete != null) {
								SPRolesLocalServiceUtil.deleteSPRoles(spRoleDelete);
							}
						}
						catch (Exception e) {
							_log.error("delete error on removing category2 based on category1 " + e.getMessage());
						}
					}
				}

				for (int y = 1; y < splitcatg1Delete.length; y++) {
					for (int z = 0; z < ctg2values.length; z++) {
						try {
							SPRoles spRoleDelete =
								SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
									themeDisplay.getScopeGroupId(), Long.parseLong(role),
									Long.parseLong(splitcatg1Delete[y]), Long.parseLong(ctg2values[z]));

							if (spRoleDelete != null) {
								SPRolesLocalServiceUtil.deleteSPRoles(spRoleDelete);
							}
						}
						catch (Exception e) {
							_log.error("delete error on removing category1 based on category2" + e.getMessage());
						}
					}
				}
			}
			else { // to delete the list of unselected categories1 when categrioes2 is not configured

				for (int y = 1; y < splitcatg1Delete.length; y++) {
					try {
						AssetCategory delAssetCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(splitcatg1Delete[y]));
						SPRoles spRoleDelete =
							SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
								themeDisplay.getScopeGroupId(), Long.parseLong(role), delAssetCatg.getParentCategoryId(),
								Long.parseLong(splitcatg1Delete[y]));

						if (spRoleDelete != null) {
							SPRolesLocalServiceUtil.deleteSPRoles(spRoleDelete);
						}
					}
					catch (Exception e) {
						_log.error("delete error category1 " + e.getMessage());
					}
				}
			}

			if (ctg2values != null) { // to add / update the modified select categories1 & categries2 list

					for (int i = 0; i < ctg1values.length; i++) {
					for (int x = 0; x < ctg2values.length; x++) {
						try {
							SPRoles spRoleDelete =
								SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
									themeDisplay.getScopeGroupId(), Long.parseLong(role),
									Long.parseLong(ctg1values[i]), Long.parseLong(ctg2values[x]));
//							if (spRoleDelete != null) {
//								SPRolesLocalServiceUtil.deleteSPRoles(spRoleDelete);
//							}
						}
						catch (Exception e) {
							_log.error(e.getMessage() + "does not exist. Creating new entry on update.");
							try {
								addToSPRoles(themeDisplay, Long.parseLong(ctg1values[i]), Long.parseLong(ctg2values[x]), role);
							}
							catch (Exception ex) {
								_log.error("error adding new entry on update" + ex.getMessage());
							}
						}
					}
				}
			}
			else { // to add / update the modified selected categories1 list when categries2 is not configured

				for (int i = 0; i < ctg1values.length; i++) {
					try {
						AssetCategory asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(ctg1values[i]));
						SPRoles spRoleDelete =
							SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
								themeDisplay.getScopeGroupId(), Long.parseLong(role), asstCatg.getParentCategoryId(), Long.parseLong(ctg1values[i]));
//						if (spRoleDelete != null) {
//							SPRolesLocalServiceUtil.deleteSPRoles(spRoleDelete);
//						}
					}
					catch (Exception e) {
						_log.error(e.getMessage() + "does not exist. Creating new entry on update.");
						try {

							long countryCategoryId = 0;
							long departmentCategoryId = 0;

							AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(ctg1values[i]));
							long parentCategoryId = assetCategory.getParentCategoryId();
							long vocId = assetCategory.getVocabularyId();

							if (parentCategoryId > 0) {
								addToSPRoles(themeDisplay, parentCategoryId, Long.parseLong(ctg1values[i]), role);
								actionRequest.setAttribute("success", "success");
							}else {
								List<AssetCategory> childAssetcategories = null;
								try {
									childAssetcategories = AssetCategoryLocalServiceUtil.getChildCategories(Long.parseLong(ctg1values[i]));

									if (childAssetcategories.isEmpty()) {
										addToSPRoles(themeDisplay, Long.parseLong(ctg1values[i]), 0, role);
									}
									}catch (Exception ce) {
										_log.error("error getting hildAssetcategories catch " + ce.getMessage());
									}
							}

							/*String ctg1valueName = getAssetCategoryName(Long.parseLong(ctg1values[i]));
							String[] splitCtg1valueName = ctg1valueName.trim().split("-");

							if (Validator.isNotNull(indCatg1CategoryList)) {
								for (AssetCategory indCatg1Category : indCatg1CategoryList) {
									if (indCatg1Category.getName().equalsIgnoreCase(splitCtg1valueName[0])) {
										countryCategoryId = indCatg1Category.getCategoryId();
									}
								}
							}

							if (Validator.isNotNull(indCatg2CategoryList)) {
								for (AssetCategory indCatg2Category : indCatg2CategoryList) {
									if (indCatg2Category.getName().equalsIgnoreCase(splitCtg1valueName[1])) {
										departmentCategoryId = indCatg2Category.getCategoryId();
									}
								}
							} */
						}
						catch (Exception ex) {
							_log.error("error adding new entry on update" + ex.getMessage());
						}
					}
				}
			}

			actionRequest.setAttribute("success", "success");
		}

		// end of update

		else {
			try {
				if (ctg2values != null) {
					for (int i = 0; i < ctg1values.length; i++) {
						for (int x = 0; x < ctg2values.length; x++) {
							addToSPRoles(themeDisplay, Long.parseLong(ctg1values[i]), Long.parseLong(ctg2values[x]), role);
						}
					}

					actionRequest.setAttribute("success", "success");
				}
				else {
					for (int i = 0; i < ctg1values.length; i++) {

						AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(ctg1values[i]));
						long parentCategoryId = assetCategory.getParentCategoryId();

						if (parentCategoryId > 0) {
							addToSPRoles(themeDisplay, parentCategoryId, Long.parseLong(ctg1values[i]), role);
						}else {
							List<AssetCategory> childAssetcategories = null;
							try {
								childAssetcategories = AssetCategoryLocalServiceUtil.getChildCategories(Long.parseLong(ctg1values[i]));

								if (childAssetcategories.isEmpty()) {
									addToSPRoles(themeDisplay, Long.parseLong(ctg1values[i]), 0, role);
								}
								}catch (Exception ce) {
									_log.error("error getting hildAssetcategories catch " + ce.getMessage());
								}
						}

						/*String ctg1valueName = getAssetCategoryName(Long.parseLong(ctg1values[i]));
						String[] splitCtg1valueName = ctg1valueName.trim().split("-");

						if (Validator.isNotNull(indCatg1CategoryList)) {
							for (AssetCategory indCatg1Category : indCatg1CategoryList) {
								if (indCatg1Category.getName().equalsIgnoreCase(splitCtg1valueName[0])) {
									countryCategoryId = indCatg1Category.getCategoryId();
								}
							}
						}

						if (Validator.isNotNull(indCatg2CategoryList)) {
							for (AssetCategory indCatg2Category : indCatg2CategoryList) {
								if (indCatg2Category.getName().equalsIgnoreCase(splitCtg1valueName[1])) {
									departmentCategoryId = indCatg2Category.getCategoryId();
								}
							}
						} */
					}

					actionRequest.setAttribute("success", "success");
				}
			}
			catch (Exception e) {
				_log.error("error adding roles " + e.getMessage());
			}
		}
	}

	public void createCategoryMapping(
		ThemeDisplay themeDisplay, String mainCatg, String[] subCategory, ActionRequest actionRequest,
		String subCategoryList, String catergoryName, String selectedSubCategoryName, String selectedMainCategoryName)
		throws Exception {

		catergoryName = getAssetCategoryName(Long.parseLong(mainCatg));
		String newVocabularyName = selectedMainCategoryName + "-" + selectedSubCategoryName;
		AssetVocabulary asssetVocabulary = null;
		List<SPCategoriesMapping> spCatgMapping = SPCategoriesMappingLocalServiceUtil.getSPCategoriesMappings(0, 1);
		long createdVocabularyId = 0;

		if (spCatgMapping.isEmpty()) {
			asssetVocabulary = addAssetVocabulary(themeDisplay.getUserId(), newVocabularyName, actionRequest);
			createdVocabularyId = asssetVocabulary.getVocabularyId();

			if (createdVocabularyId > 0) {
				String paramName = "mapped.category.list.submenu";
				SPParameter spParameters = null;
				try {
					spParameters =
						SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
							themeDisplay.getScopeGroupId(), SambaashConstants.CATEGORIES.MAPPED_CATEGORY);

					if (spParameters != null) {
						spParameters.setDescription(selectedMainCategoryName);
						spParameters.setValue(String.valueOf(createdVocabularyId));
						SPParameterLocalServiceUtil.addSPParameter(spParameters);
					}
				}
				catch (Exception sp) {
					long pKey = CounterLocalServiceUtil.increment("SPParameter.class");
					String uuid = PortalUUIDUtil.generate();
					spParameters = SPParameterLocalServiceUtil.createSPParameter(pKey);
					spParameters.setUuid(uuid);
					spParameters.setDescription(selectedMainCategoryName);
					spParameters.setName(paramName);
					spParameters.setValue(String.valueOf(createdVocabularyId));
					spParameters.setGroupId(themeDisplay.getScopeGroupId());
					SPParameterLocalServiceUtil.addSPParameter(spParameters);
				}
			}
		}
		else {
			createdVocabularyId = spCatgMapping.get(0).getCreatedVocabularyId();
		}

		for (int s = 0; s < subCategory.length; s++) {
			String subCtgName = getAssetCategoryName(Long.parseLong(subCategory[s]));
			String newCategoryname = catergoryName + "-" + subCtgName;
			subCategoryList = subCtgName + "#" + subCategoryList;
			try {
				SPCategoriesMapping existCatgMap = SPCategoriesMappingLocalServiceUtil.findByMainAndSubCategoryId(themeDisplay.getScopeGroupId(), Long.parseLong(mainCatg), Long.parseLong(subCategory[s]));
			}catch (Exception es) {
				addAssetCatagories(themeDisplay.getUserId(), newCategoryname, createdVocabularyId, actionRequest);

				long pKey = CounterLocalServiceUtil.increment("SPCategoriesMapping.class");
				String uuid = PortalUUIDUtil.generate();
				SPCategoriesMapping spCategoriesMapping =
					SPCategoriesMappingLocalServiceUtil.createSPCategoriesMapping(pKey);
				spCategoriesMapping.setUuid(uuid);
				spCategoriesMapping.setSpCategoryMappingId(pKey);
				spCategoriesMapping.setCompanyId(themeDisplay.getCompanyId());
				spCategoriesMapping.setGroupId(themeDisplay.getScopeGroupId());
				spCategoriesMapping.setUserId(themeDisplay.getUserId());
				spCategoriesMapping.setUserName(themeDisplay.getUser().getFirstName() + " " +
					themeDisplay.getUser().getLastName());
				spCategoriesMapping.setCreateDate(Calendar.getInstance().getTime());
				spCategoriesMapping.setModifiedDate(Calendar.getInstance().getTime());
				spCategoriesMapping.setCreatedVocabularyId(createdVocabularyId);
				spCategoriesMapping.setMainCategoryId(Long.parseLong(mainCatg));
				spCategoriesMapping.setSubCategoryId(Long.parseLong(subCategory[s]));
				SPCategoriesMappingLocalServiceUtil.addSPCategoriesMapping(spCategoriesMapping);
			}
		}
	}

	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<AssetVocabulary> assetVocabularies = null;

		String selectedCategory = preferences.getValue("selectedCategory", "0");
		String selectedCategoryMappedTo = preferences.getValue("selectedCategoryMappedTo", "0");
		String selectedMainCategory = preferences.getValue("selectedMainCategory", "0");
		String selectedSubCategory = preferences.getValue("selectedSubCategory", "0");

		try {
			assetVocabularies =
				AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId(), false);
		}
		catch (Exception e) {
			_log.error("error getting assetvocabulary in edit " + e.getMessage());
		}

		renderRequest.setAttribute("assetVocabularies", assetVocabularies);
		renderRequest.setAttribute("selectedCategory", selectedCategory);
		renderRequest.setAttribute("selectedCategoryMappedTo", selectedCategoryMappedTo);
		renderRequest.setAttribute("selectedMainCategory", selectedMainCategory);
		renderRequest.setAttribute("selectedSubCategory", selectedSubCategory);

		super.doEdit(renderRequest, renderResponse);
	}

	@SuppressWarnings("rawtypes")
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences preferences = renderRequest.getPreferences();

		String selectedCategory = preferences.getValue("selectedCategory", "0");
		String selectedCategoryMappedTo = preferences.getValue("selectedCategoryMappedTo", "0");
		String selectedMainCategory = preferences.getValue("selectedMainCategory", "0");
		String selectedSubCategory = preferences.getValue("selectedSubCategory", "0");
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		String selectedCategoryName = preferences.getValue("selectedCategoryName", "0");
		String selectedCategoryMappedToName = preferences.getValue("selectedCategoryMappedToName", "0");
		String selectedMainCategoryName = preferences.getValue("selectedMainCategoryName", "0");
		String selectedSubCategoryName = preferences.getValue("selectedSubCategoryName", "0");
		long vocabularyId = Long.parseLong(selectedCategory);
		long vocabularyId1 = Long.parseLong(selectedCategoryMappedTo);
		long mainVocabularyId = Long.parseLong(selectedMainCategory);
		long subVocabularyId = Long.parseLong(selectedSubCategory);
		List<AssetCategory> assetCategory = null;
		List<AssetCategory> assetCategory1 = null;
		List<AssetCategory> mainAssetCategory = null;
		List<AssetCategory> subAssetCategory = null;
		_log.info("vocabularyId do edit " + vocabularyId);
		try {
			//assetCategory = getInterestCategories(vocabularyId);
			renderRequest.setAttribute("allChannelWrappers", getAllChannelWrappers(selectedCategory));
			assetCategory1 = getInterestCategories(vocabularyId1);
			mainAssetCategory = getInterestCategories(mainVocabularyId);
			subAssetCategory = getInterestCategories(subVocabularyId);
		}catch (Exception e1) {
			_log.error(e1);
		}

		List<Role> roleList = null;
		List<SPRoles> spRolesList = null;
		List<List<Comparable>> finalRoleList = new ArrayList<List<Comparable>>();
		AssetCategory asstCatg = null;
		AssetCategory mainAsstCatg = null;
		//Listing for Roles & category Mapping
		try {
			roleList = RoleLocalServiceUtil.getRoles(-1, -1);
			spRolesList = SPRolesLocalServiceUtil.getSPRoleses(-1, -1);

			for (Role rls : roleList) {
				List<Comparable> selRoleList = new ArrayList<Comparable>();
				spRolesList = SPRolesLocalServiceUtil.findByRoleId(themeDisplay.getScopeGroupId(), rls.getRoleId());

				if (spRolesList != null && !spRolesList.isEmpty()) {
					selRoleList.add(rls.getRoleId());
					selRoleList.add(rls.getName());
					String categories1 = StringPool.BLANK;
					String categories1Id = StringPool.BLANK;
					String categories2 = StringPool.BLANK;
					String categories2Id = StringPool.BLANK;
					String countryCategoriesId = StringPool.BLANK;
					String countryCategoriesName = StringPool.BLANK;

					for (SPRoles spRole : spRolesList) {

						if (Validator.isNotNull(assetCategory1) && !assetCategory1.isEmpty()) {
							if (spRole.getCategoryId1() > 0) {
								try {
									asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spRole.getCategoryId1());
									mainAsstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spRole.getCountryCategoryId());

									if (!categories1Id.contains(String.valueOf(spRole.getCategoryId1()))) {
										categories1Id = spRole.getCategoryId1() + "##" + categories1Id;
										categories1 = asstCatg.getName() + "," + categories1;
									}
								}catch (Exception ectg) {
									_log.error("error getting AssetCategories for categoryID1 " + spRole.getCategoryId1() + " " + ectg.getMessage());
								}
							}

							if (spRole.getCategoryId2() > 0) {
								asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spRole.getCategoryId2());

								if (!categories2Id.contains(String.valueOf(spRole.getCategoryId2()))) {
									categories2Id = spRole.getCategoryId2() + "##" + categories2Id;
									categories2 = asstCatg.getName() + "," + categories2;
								}
							}

						}else {
							if (spRole.getCategoryId2() > 0) {
								try {
									asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spRole.getCategoryId2());
									mainAsstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spRole.getCountryCategoryId());

									if (!categories1Id.contains(String.valueOf(spRole.getCategoryId2()))) {
										categories1Id = spRole.getCountryCategoryId() + "-" + spRole.getCategoryId2() + "##" + categories1Id;
										categories1 = mainAsstCatg.getName()+ "-" +asstCatg.getName() + "," + categories1;
									}
								}catch (Exception ectg) {
									_log.error("error getting AssetCategories for categoryID1 " + spRole.getCategoryId1() + " " + ectg.getMessage());
								}
							}else {
								try {
									asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spRole.getCategoryId1());

									if (!categories1Id.contains(String.valueOf(spRole.getCategoryId1()))) {
										categories1Id = spRole.getCategoryId1() + "##" + categories1Id;
										categories1 = asstCatg.getName() + "," + categories1;
									}
								}catch (Exception ectg) {
									_log.error("error getting AssetCategories for categoryID1 " + spRole.getCategoryId1() + " " + ectg.getMessage());
								}
							}
						}
					}

					selRoleList.add(categories1Id);
					selRoleList.add(categories1);
					selRoleList.add(countryCategoriesId);

					// if (isCatg2) {

					selRoleList.add(categories2Id);
					selRoleList.add(categories2);

					// }

					finalRoleList.add(selRoleList);
				}
			}
		}
		catch (Exception e) {
			_log.error("error in view " + e.getMessage());
		}

		AssetCategory subAsstCatg = null;
		List<List> finalSelCatgMapList = new ArrayList<List>();
		List<Comparable> selCatgMapList = new ArrayList<Comparable>();

		// Listing for categories mapping

		try {
			List<SPCategoriesMapping> spCatgMapList =
				SPCategoriesMappingLocalServiceUtil.getSPCategoriesMappings(-1, -1);

			for (SPCategoriesMapping spCatgMap : spCatgMapList) {
				String subCategory = StringPool.BLANK;
				String subCategoryId = StringPool.BLANK;

				if (!selCatgMapList.contains(spCatgMap.getMainCategoryId())) {
					selCatgMapList = new ArrayList<Comparable>();
					subAsstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spCatgMap.getMainCategoryId());
					selCatgMapList.add(spCatgMap.getMainCategoryId());
					selCatgMapList.add(subAsstCatg.getName());
					List<SPCategoriesMapping> spCatgMaps =
						SPCategoriesMappingLocalServiceUtil.findByMainCategoryId(
							themeDisplay.getScopeGroupId(), spCatgMap.getMainCategoryId());

					for (SPCategoriesMapping spCatg : spCatgMaps) {
						subAsstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(spCatg.getSubCategoryId());

						if (!selCatgMapList.contains(spCatg.getSubCategoryId())) {
							subCategoryId = spCatg.getSubCategoryId() + "##" + subCategoryId;
							subCategory = subAsstCatg.getName() + "," + subCategory;
						}
					}

					selCatgMapList.add(subCategoryId);
					selCatgMapList.add(subCategory);
					finalSelCatgMapList.add(selCatgMapList);
				}
			}
		}
		catch (Exception ec) {
		}

		renderRequest.setAttribute("roleList", roleList);
		renderRequest.setAttribute("assetCategory", assetCategory);
		renderRequest.setAttribute("assetCategory1", assetCategory1);
		renderRequest.setAttribute("mainAssetCategory", mainAssetCategory);
		renderRequest.setAttribute("subAssetCategory", subAssetCategory);
		renderRequest.setAttribute("finalRoleList", finalRoleList);
		renderRequest.setAttribute("selectedCategory", selectedCategory);
		renderRequest.setAttribute("selectedCategoryName", selectedCategoryName);
		renderRequest.setAttribute("selectedCategoryMappedToName", selectedCategoryMappedToName);
		renderRequest.setAttribute("selectedMainCategoryName", selectedMainCategoryName);
		renderRequest.setAttribute("selectedSubCategoryName", selectedSubCategoryName);
		renderRequest.setAttribute("finalSelCatgMapList", finalSelCatgMapList);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String category1 = actionRequest.getParameter("current_category_Id");
			String category2 = actionRequest.getParameter("current_category1_Id");
			String selectedCategoryName = StringPool.BLANK;
			String selectedCategoryMappedToName = StringPool.BLANK;

			try {
				selectedCategoryName = getAssetVocabularyName(Long.parseLong(category1));

				if (Long.parseLong(category2) > 0) {
					selectedCategoryMappedToName = getAssetVocabularyName(Long.parseLong(category2));
				}
			}
			catch (Exception e) {
				_log.error("error getting assetvocabulary name in processaction " + e.getMessage());
			}

			preferences.setValue("selectedCategory", category1);
			preferences.setValue("selectedCategoryName", selectedCategoryName);

			if (Long.parseLong(category2) > 0) {
				preferences.setValue("selectedCategoryMappedTo", category2);
				preferences.setValue("selectedCategoryMappedToName", selectedCategoryMappedToName);
			}

			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);
		}
		else if (action.equalsIgnoreCase("CategoriesMapping")) {
			String category1 = actionRequest.getParameter("CategoriesMapping_mainlist");
			String category2 = actionRequest.getParameter("CategoriesMapping_sublist");

			String selectedMainCategoryName = StringPool.BLANK;
			String selectedSubCategoryName = StringPool.BLANK;

			try {
				selectedMainCategoryName = getAssetVocabularyName(Long.parseLong(category1));
				selectedSubCategoryName = getAssetVocabularyName(Long.parseLong(category2));
				List<SPCategoriesMapping> existingCatgMapList =
					SPCategoriesMappingLocalServiceUtil.getSPCategoriesMappings(0, 1);

				if (!existingCatgMapList.isEmpty()) {
					long catg1 = existingCatgMapList.get(0).getMainCategoryId();
					long catg2 = existingCatgMapList.get(0).getSubCategoryId();

					if ((catg1 == Long.parseLong(category1)) || (catg2 == Long.parseLong(category2))) {
						for (SPCategoriesMapping existingCatgMap : existingCatgMapList) {
							SPCategoriesMappingLocalServiceUtil.deleteSPCategoriesMapping(existingCatgMap);
						}
					}
				}
			}
			catch (Exception e) {
				_log.error("error getting assetvocabulary name in processaction " + e.getMessage());
			}

			preferences.setValue("selectedMainCategory", category1);
			preferences.setValue("selectedSubCategory", category2);
			preferences.setValue("selectedMainCategoryName", selectedMainCategoryName);
			preferences.setValue("selectedSubCategoryName", selectedSubCategoryName);
			preferences.store();
		}
		else if (Constants.VIEW.equalsIgnoreCase(action)) {
			addRoleCategoryMapping(themeDisplay, actionRequest);
			actionResponse.setPortletMode(PortletMode.VIEW);
		}
		else if (action.equalsIgnoreCase("mapping")) {
			addCategoryMapping(themeDisplay, actionRequest, preferences);
			actionResponse.setPortletMode(PortletMode.VIEW);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String type = resourceRequest.getParameter("type");
		String rols1 = resourceRequest.getParameter("rols1");
		String catg1Delete = resourceRequest.getParameter("catg1Edit");
		String catg2Delete = resourceRequest.getParameter("catg2Edit");
		String[] splitcatg1Delete = {};

		String existingCatg1 = resourceRequest.getParameter("catg1");

		if (catg1Delete != null) {
			if (catg1Delete.contains("##")) {
				splitcatg1Delete = catg1Delete.split("##");
			}
		}

		if (type.equalsIgnoreCase("deleteInfo")) {
			try {
				if (!catg2Delete.isEmpty()) {
					String[] splitcatg2Delete = catg2Delete.split("##");

					for (int i = 0; i < splitcatg1Delete.length; i++) {
						for (int x = 0; x < splitcatg2Delete.length; x++) {
							SPRoles spRoles =
								SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
									themeDisplay.getScopeGroupId(), Long.parseLong(rols1),
									Long.parseLong(splitcatg1Delete[i]), Long.parseLong(splitcatg2Delete[x]));
							SPRolesLocalServiceUtil.deleteSPRoles(spRoles);
						}
					}
				}
				else {
					for (int i = 0; i < splitcatg1Delete.length; i++) {
						SPRoles spRoles =
							SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(
								themeDisplay.getScopeGroupId(), Long.parseLong(rols1),
								Long.parseLong(splitcatg1Delete[i]), 0);
						SPRolesLocalServiceUtil.deleteSPRoles(spRoles);
					}
				}
			}
			catch (Exception e) {
				_log.error("error deleting sproles " + e.getMessage());
			}
		}

		if (type.equalsIgnoreCase("deleteCatgInfo")) {
			try {
				if (catg2Delete != null) {
					String[] splitcatg2Delete = catg2Delete.split("##");

					for (int i = 0; i < splitcatg2Delete.length; i++) {
						SPCategoriesMapping spCatgMap =
							SPCategoriesMappingLocalServiceUtil.findByMainAndSubCategoryId(
								themeDisplay.getScopeGroupId(), Long.parseLong(catg1Delete),
								Long.parseLong(splitcatg2Delete[i]));
						SPCategoriesMappingLocalServiceUtil.deleteSPCategoriesMapping(spCatgMap);
					}
				}
			}
			catch (Exception e) {
				_log.error("error deleting mapped categories " + e.getMessage());
			}
		}

		String existCatgIds = "0";
		String existCatgIds1 = "0";

		if (type.equalsIgnoreCase("populateCatgMap")) {
			try {
				List<SPCategoriesMapping> spCatgMaps = SPCategoriesMappingLocalServiceUtil.findByMainCategoryId(themeDisplay.getScopeGroupId(), Long.parseLong(existingCatg1));

				for (SPCategoriesMapping indCatg : spCatgMaps) {
					existCatgIds = indCatg.getSubCategoryId() + "##" + existCatgIds;
				}
			}catch (Exception e) {
				_log.error("SPcategories mapping not found" + e.getMessage());
			}
		}

		if (type.equalsIgnoreCase("populateRoleCatg")) {
			try {
				List<SPRoles> sproleMaps = SPRolesLocalServiceUtil.findByRoleId(themeDisplay.getScopeGroupId(), Long.parseLong(existingCatg1));

				for (SPRoles indCatg : sproleMaps) {
					existCatgIds = indCatg.getCategoryId1() + "##" + existCatgIds;

					if (indCatg.getCategoryId2() > 0) {
						existCatgIds1 = indCatg.getCategoryId2() + "##" + existCatgIds1;
					}
				}

				if (existCatgIds1 != "0") {
					existCatgIds = existCatgIds + "@@" + existCatgIds1;
				}
			}catch (Exception e) {
				_log.error("SPcategories mapping not found" + e.getMessage());
			}
		}

		resourceResponse.getWriter().append(existCatgIds);
		super.serveResource(resourceRequest, resourceResponse);
	}

	private void addToSPRoles(ThemeDisplay themeDisplay, long categoryId1, long categoryId2, String role) throws Exception {
		// Check if it exists
		try{
			SPRoles temp = SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(themeDisplay.getScopeGroupId(), GetterUtil.getLong(role), categoryId1, categoryId2);
			if(Validator.isNotNull(temp)){
				return;
			}
		}catch(Exception ex){
			//_log.error(ex);
		}
		
		String uuid = PortalUUIDUtil.generate();
		long pKey = CounterLocalServiceUtil.increment("SPRoles.class");
		SPRoles spRoles = SPRolesLocalServiceUtil.createSPRoles(pKey);

		spRoles.setUuid(uuid);
		spRoles.setSpRoleId(pKey);
		spRoles.setGroupId(themeDisplay.getScopeGroupId());
		spRoles.setCompanyId(themeDisplay.getCompanyId());
		spRoles.setUserId(themeDisplay.getUserId());
		spRoles.setUserName(themeDisplay.getUser().getFirstName() + " " +
			themeDisplay.getUser().getLastName());
		spRoles.setCreateDate(Calendar.getInstance().getTime());
		spRoles.setModifiedDate(Calendar.getInstance().getTime());
		spRoles.setCategoryId1(categoryId1);
		spRoles.setCategoryId2(categoryId2);
		spRoles.setDepartmentCategoryId(categoryId2);
		spRoles.setCountryCategoryId(categoryId1);
		spRoles.setRoleId(Long.parseLong(role));

		SPRolesLocalServiceUtil.addSPRoles(spRoles);
	}

	private List<AllChannelWrapper> getAllChannelWrappers(String selectedAssetVocabularyIds) throws PortalException,
	SystemException {
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
							channelWrapper.setParentCategoryId(selectedAssetCategory.getCategoryId());
							channelWrappers.add(channelWrapper);

							List<AssetCategory> selectedChildAssetCategories = AssetCategoryLocalServiceUtil
									.getChildCategories(selectedAssetCategory.getCategoryId());

							for (AssetCategory selectedChildAssetCategory : selectedChildAssetCategories) {
								ChannelWrapper channelChildWrapper = new ChannelWrapper();
								channelChildWrapper.setCategoryId(selectedChildAssetCategory.getCategoryId());
								channelChildWrapper.setCategoryName(selectedChildAssetCategory.getName());
								channelChildWrapper.setParentCategoryId(selectedAssetCategory.getCategoryId());
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

	private static Log _log = LogFactoryUtil.getLog(SPRolesAction.class);

	private static List<AssetVocabulary> assetVocabularies;
	private static List<AssetCategory> interestCategories = null;

}