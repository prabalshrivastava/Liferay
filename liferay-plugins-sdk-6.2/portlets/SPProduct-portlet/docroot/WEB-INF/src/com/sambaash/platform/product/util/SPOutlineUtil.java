package com.sambaash.platform.product.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPOutlineUtil {

	private static Log _log = LogFactoryUtil.getLog(SPOutlineUtil.class);

	public static JSONObject addOutline(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			_log.error("Adding OutlineUtil");

			String outlineId = resourceRequest.getParameter("spOutlineId");
			boolean hasPermission = false;
			if(GetterUtil.getLong(outlineId) > 0){
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			}else{
			    // create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}
			
			if(!hasPermission){
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.noauth.add.outline"));
				return response;
			}
			String outlineType = resourceRequest.getParameter("outlineType");
			String competencyUnitCodeId = resourceRequest.getParameter("competencyUnitCodeId");
			String outlineDescription = resourceRequest.getParameter("outlineDescription");

			Outline outline = null;

			if (Validator.isNumber(outlineId)) {
				outline = OutlineLocalServiceUtil.fetchOutline(Long.parseLong(outlineId));
				outline.setModifiedDate(DateUtil.newDate());
			} else {
				long spOutlineId = CounterLocalServiceUtil.increment("Outline.class");
				outline = OutlineLocalServiceUtil.createOutline(spOutlineId);
				outline.setCreateDate(DateUtil.newDate());
			}

			outline.setGroupId(themeDisplay.getScopeGroupId());
			outline.setUserId(themeDisplay.getUser().getUserId());
			outline.setUserName(themeDisplay.getUser().getFullName());
			outline.setCompanyId(themeDisplay.getCompanyId());
			outline.setOutlineDesc(outlineDescription);
			outline.setOutlineType(Long.parseLong(outlineType));
			outline.setSpCompetencyUnitId(Long.parseLong(competencyUnitCodeId));

			OutlineLocalServiceUtil.updateOutline(outline);
			OutlineLocalServiceUtil.clearCache();

			response.put("saveFlag", "success");
			response.put("spOutlineId", outline.getSpOutlineId());
			return response;

		} catch (Exception e) {
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.save.outline.error"));
			_log.error(e);
		}

		response.put("saveFlag", "error");

		return response;

	}

	public static Map<Long, List<String>> getOutlineMap(List<Outline> outlineList) {
		HashMap<Long, List<String>> outlineDetailsMap = new LinkedHashMap<Long, List<String>>();
		try {
			CompetencyUnit competencyUnit = null;
			for (Outline outline : outlineList) {
				String skillsDesc = StringPool.BLANK;
				List<String> outlineListing = new ArrayList<String>();
				outlineListing.add(String.valueOf(outline.getSpOutlineId()));

				AssetCategory oAsset = AssetCategoryLocalServiceUtil.getAssetCategory(outline.getOutlineType());

				if (Validator.isNull(competencyUnit)) {
					competencyUnit = CompetencyUnitLocalServiceUtil.getCompetencyUnit(outline.getSpCompetencyUnitId());
				}

				if (competencyUnit != null && competencyUnit.getSpCompetencyUnitId() != outline.getSpCompetencyUnitId()) {
					competencyUnit = CompetencyUnitLocalServiceUtil.getCompetencyUnit(outline.getSpCompetencyUnitId());
				}
				outlineListing.add(competencyUnit.getCompetencyUnitCode());
				outlineListing.add(oAsset.getName());
				outlineListing.add(HtmlUtil.stripHtml(skillsDesc));
				outlineListing.add(HtmlUtil.stripHtml(outline.getOutlineDesc()));
				outlineListing.add(HtmlUtil.stripHtml(competencyUnit.getCompetencyUnitDesc()));
				outlineDetailsMap.put(outline.getSpOutlineId(), outlineListing);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return sortByComparator(outlineDetailsMap, true);
	}

	private static Map<Long, List<String>> sortByComparator(Map<Long, List<String>> unsortMap, final boolean order) {

		List<Entry<Long, List<String>>> list = new LinkedList<Entry<Long, List<String>>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<Long, List<String>>>() {
			public int compare(Entry<Long, List<String>> o1, Entry<Long, List<String>> o2) {
				if (order) {
					return o1.getValue().get(1).compareTo(o2.getValue().get(1));
				} else {
					return o2.getValue().get(1).compareTo(o1.getValue().get(1));

				}
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<Long, List<String>> sortedMap = new LinkedHashMap<Long, List<String>>();
		for (Entry<Long, List<String>> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

}
