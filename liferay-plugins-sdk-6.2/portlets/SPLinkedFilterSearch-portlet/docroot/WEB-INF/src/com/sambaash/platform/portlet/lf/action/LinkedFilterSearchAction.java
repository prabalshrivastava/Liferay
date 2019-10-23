package com.sambaash.platform.portlet.lf.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.util.CookieUtil;

public class LinkedFilterSearchAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(LinkedFilterSearchAction.class);
	public static final String I18N_LANGUAGE_ID = "I18N_LANGUAGE_ID";

	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		prepareCatIdsInUrl(request);
		super.doView(request, response);

	}

	private void prepareCatIdsInUrl(PortletRequest portletRequest) {
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		Map<String, String[]> params = httpReq.getParameterMap();
		Iterator<String> keys = params.keySet().iterator();
		String IND_FILTER = "ifilter";
		String LINK_FILTER = "lfilter";
		String COUSRSE_SEARCH = "cSearch";
		long catId = 0;
		String country = getCountry(portletRequest);
		catId = getCatIdByName(country);
		obj.put(IND_FILTER + "_location", String.valueOf(catId));
		while (keys.hasNext()) {
			String key = keys.next();
			if (key.startsWith(IND_FILTER) || key.startsWith(LINK_FILTER)) {
				String commaSepVals = ParamUtil.getString(httpReq, key);
				String values[] = commaSepVals.split(StringPool.COMMA);
				String temp = StringPool.BLANK;
				for (String catName : values) {
					if (Validator.isNull(catName)) {
						continue;
					}
					catId = getCatIdByName(catName);
					if (catId == 0) {
						continue;
					}
					if (temp.length() > 0) {
						temp = temp + StringPool.COMMA;
					}
					temp = temp + catId;
				}
				obj.put(key, temp);
			}

			if (key.startsWith(COUSRSE_SEARCH)) {
				obj.put(key, ParamUtil.getString(httpReq, key));
			}

		}
		portletRequest.setAttribute("filtersFrmUrl", obj.toString());
	}

	private String getCountry(PortletRequest request) {
		String languageId = (String) request.getAttribute(I18N_LANGUAGE_ID);
		if (Validator.isNull(languageId)) {
			languageId = CookieUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)),
					"GUEST_LANGUAGE_ID");
		}
		String country = StringPool.BLANK;
		if (Validator.isNotNull(languageId)) {
			Locale locale = LocaleUtil.fromLanguageId(languageId);
			country = locale.getDisplayCountry();
		}

		return country;
	}

	@SuppressWarnings("unchecked")
	private long getCatIdByName(String name) {
		long catId = 0;
		DynamicQuery dQuery = DynamicQueryFactoryUtil.forClass(AssetCategory.class,
				PortalClassLoaderUtil.getClassLoader());
		dQuery.add(RestrictionsFactoryUtil.ilike("name", name));
		try {
			List<AssetCategory> list = AssetCategoryLocalServiceUtil.dynamicQuery(dQuery);
			if (list.size() > 0) {
				catId = list.get(0).getCategoryId();
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return catId;
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		JSONObject data = JSONFactoryUtil.createJSONObject();

		String action = ParamUtil.getString(resourceRequest, "action");
		if ("getMaxSubLevel".equals(action)) {
			data = prepareResponseMaxSublevel(resourceRequest);
		} else if ("loadChildsAndSearchResults".equals(action)) {
			data = LinkedSearchHelper.handleLoadChildsAndSearch(resourceRequest);
		}
		resourceResponse.getWriter().write(data.toString());
	}

	private JSONObject prepareResponseMaxSublevel(PortletRequest request) {
		long vocId = ParamUtil.getLong(request, "vocId");
		JSONObject data = JSONFactoryUtil.createJSONObject();
		try {
			int maxLevel = getMaxSubLevel(vocId);
			data.put("maxLevel", maxLevel);
		} catch (SystemException e) {
			data.put("error", "Error while fetching max sublevel");
		}
		return data;
	}

	private int getMaxSubLevel(long vocId) throws SystemException {
		List<AssetCategory> list = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocId, -1, -1, null);
		if (list.isEmpty()) {
			return 0;
		}
		int level = 1;
		int max = 1;
		for (AssetCategory category : list) {
			int temp = getMaxSubLevel(category, level);
			if (temp > max) {
				max = temp;
			}
		}
		return max;

	}

	private int getMaxSubLevel(AssetCategory category, int level) throws SystemException {
		List<AssetCategory> subList = AssetCategoryLocalServiceUtil.getChildCategories(category.getCategoryId());
		if (subList.isEmpty()) {
			return level;
		}

		level = level + 1;
		int max = level;
		int temp;
		for (AssetCategory child : subList) {
			temp = getMaxSubLevel(child, level);
			if (temp > max) {
				max = temp;
			}
		}

		return max;
	}
}
