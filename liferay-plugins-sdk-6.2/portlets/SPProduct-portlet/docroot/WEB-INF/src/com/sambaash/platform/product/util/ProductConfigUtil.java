package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class ProductConfigUtil {
	
	public static JSONObject prepareResponseMaxSublevel(PortletRequest request){
		long vocId = ParamUtil.getLong(request, "vocId");
		JSONObject data = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			int maxLevel = getMaxSubLevel(vocId);
			data.put("maxLevel", maxLevel);
		} catch (SystemException e) {
			data.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.max.sublevel"));
		}
		
		return data;
	}
	
	private static int getMaxSubLevel(long vocId) throws SystemException{
		List<AssetCategory>list = AssetCategoryLocalServiceUtil.getVocabularyCategories(0,vocId, -1, -1, null);
		if(list.isEmpty()){
			return 0;
		}
		int level = 1;
		int max = 1;
		for(AssetCategory category : list){
			int temp = getMaxSubLevel(category, level);
			if(temp > max){
				   max = temp;
			}
		}
		return max;
	
	}
	
	private static int getMaxSubLevel(AssetCategory category,int level) throws SystemException{
		List<AssetCategory>subList = AssetCategoryLocalServiceUtil.getChildCategories(category.getCategoryId());
		if(subList.isEmpty()){
			return level;
		}
		level = level + 1;
		int max = level;
		int temp;
		for(AssetCategory child : subList){
		   temp = getMaxSubLevel(child, level);
		   if(temp > max){
			   max = temp;
		   }
		}
		return max;
	}
}
