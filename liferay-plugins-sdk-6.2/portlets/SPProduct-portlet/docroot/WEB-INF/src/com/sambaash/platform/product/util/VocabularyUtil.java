package com.sambaash.platform.product.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class VocabularyUtil {

	private static Log _log = LogFactoryUtil.getLog(VocabularyUtil.class);

	public AssetVocabulary getVocabulary(RenderRequest renderRequest, RenderResponse renderResponse,
			String vocabularyName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AssetVocabulary assetVocabulary = null;
		try {


			try {
				assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(),
						vocabularyName);
			} catch (NoSuchVocabularyException e) {
				User user = UserLocalServiceUtil.getUser(SambaashUtil.getAdminUserId());
				assetVocabulary = addVocabulary(vocabularyName, user, themeDisplay);
				addCategory(vocabularyName, assetVocabulary, user, themeDisplay);
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return assetVocabulary;

	}

	private void addCategory(String categoryName, AssetVocabulary assetVoc, User user, ThemeDisplay themeDisplay) {
		try {
			for (int i = 1; i < 4; i++) {
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil.createAssetCategory(CounterLocalServiceUtil
						.increment());

				assetCategory.setDescription(categoryName + " " + i);
				assetCategory.setName(categoryName + " " + i);
				assetCategory.setCompanyId(themeDisplay.getCompanyId());
				assetCategory.setGroupId(themeDisplay.getScopeGroupId());
				assetCategory.setCreateDate(DateUtil.newDate());
				assetCategory.setUserId(user.getUserId());
				assetCategory.setUserName(user.getFullName());
				assetCategory.setModifiedDate(DateUtil.newDate());
				assetCategory.setVocabularyId(assetVoc.getVocabularyId());
				AssetCategoryLocalServiceUtil.updateAssetCategory(assetCategory);
			}
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	private AssetVocabulary addVocabulary(String vocName, User user, ThemeDisplay themeDisplay) {
		AssetVocabulary assetVocabulary = null;
		try {
			assetVocabulary = AssetVocabularyLocalServiceUtil
					.createAssetVocabulary(CounterLocalServiceUtil.increment());
			assetVocabulary.setDescription(vocName);
			assetVocabulary.setName(vocName);
			assetVocabulary.setCompanyId(themeDisplay.getCompanyId());
			assetVocabulary.setGroupId(themeDisplay.getScopeGroupId());
			assetVocabulary.setCreateDate(DateUtil.newDate());
			assetVocabulary.setUserId(user.getUserId());
			assetVocabulary.setUserName(user.getFullName());
			assetVocabulary.setModifiedDate(DateUtil.newDate());
			assetVocabulary.setSettings("multiValued=true");

			assetVocabulary = AssetVocabularyLocalServiceUtil.updateAssetVocabulary(assetVocabulary);
		} catch (SystemException e) {
			_log.error(e);
		}
		return assetVocabulary;
	}

	public static AssetVocabulary getVocublarySpeicialization(PortletRequest request) {
		AssetVocabulary assetVocabulary = null;
		PortletPreferences preferences = request.getPreferences();
		long vocId = GetterUtil.getLong(preferences.getValue("vocIdSpecialization", "0"));
		if (vocId > 0) {
			try {
				assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocId);
			} catch (Exception e) {
				_log.error("Error while fetching Specialization vocabulary", e);
			}
		}
		return assetVocabulary;
	}

	public static AssetVocabulary getVocublaryPersona(PortletRequest request) {
		AssetVocabulary assetVocabulary = null;
		PortletPreferences preferences = request.getPreferences();
		long pVocId = GetterUtil.getLong(preferences.getValue("personaVocIdSpecialization", "0"));
		if (pVocId > 0) {
			try {
				assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(pVocId);
			} catch (Exception e) {
				_log.error("Error while fetching Persona vocabulary", e);
			}
		}
		return assetVocabulary;
	}

	public List<AssetCategory> getSpecializationCategories(PortletRequest request) throws SystemException,
			JSONException {
		List<AssetCategory> filteredCatgs = new ArrayList<AssetCategory>();
		AssetVocabulary voc = getVocublarySpeicialization(request);
		if (voc == null) {
			return filteredCatgs;
		}
		PortletPreferences preferences = request.getPreferences();
		String levelsData = GetterUtil.getString(preferences.getValue("levelsData", "{}"));
		if (levelsData.isEmpty()) {
			return filteredCatgs;
		}
		JSONObject levelsJson = JSONFactoryUtil.createJSONObject(levelsData);
		List<AssetCategory> allCatgs = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, voc.getVocabularyId(),
				-1, -1, null);
		int level = 1;
		for (AssetCategory category : allCatgs) {
			filterChilds(category, level, filteredCatgs, levelsJson);
		}
		Comparator<AssetCategory> comp = new Comparator<AssetCategory>() {

			@Override
			public int compare(AssetCategory o1, AssetCategory o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		};
		Collections.sort(filteredCatgs, comp);
		return filteredCatgs;
	}

	public List<AssetCategory> getPersonaCategories(PortletRequest request) {
		AssetVocabulary voc = getVocublaryPersona(request);
		List<AssetCategory> personaCatgs = null;
		try {
			personaCatgs = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(0, voc.getVocabularyId(), -1, -1, null);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return personaCatgs;
	}

	public Map<Long, AssetCategory> getSpecializationCategoriesMap(PortletRequest request) throws SystemException,
			JSONException {

		Map<Long, AssetCategory> specialisationMap = new HashMap<>();

		for (AssetCategory assetCategory : getSpecializationCategories(request)) {
			specialisationMap.put(assetCategory.getCategoryId(), assetCategory);
		}

		return specialisationMap;

	}

	private void filterChilds(AssetCategory category, int level, List<AssetCategory> filteredCatgs,
			JSONObject levelsData) throws SystemException {
		JSONObject levelData = levelsData.getJSONObject(String.valueOf(level));
		if (Validator.isNotNull(levelData.getString("includeLevel"))
				&& GetterUtil.getBoolean(levelData.getString("includeLevel"))) {
			try {
				if (category.getParentCategoryId() > 0) {
					AssetCategory parent = AssetCategoryLocalServiceUtil.getAssetCategory(category
							.getParentCategoryId());
					category.setName(getSpecializationCatName(parent.getName(), category.getName()));
				}
			} catch (Exception ex) {

			}
			filteredCatgs.add(category);
		}
		level = level + 1;
		List<AssetCategory> subList = AssetCategoryLocalServiceUtil.getChildCategories(category.getCategoryId());
		for (AssetCategory child : subList) {
			filterChilds(child, level, filteredCatgs, levelsData);
		}
	}

	public static String getSpecializationCatName(String parentnName, String childName) {
		String name = childName;
		if (Validator.isNotNull(parentnName)) {
			name = parentnName + "-" + childName;
		}
		return name;
	}

}
