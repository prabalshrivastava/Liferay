package com.sambaash.platform.announcement.helper;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.announcement.config.GenericSearchConstants;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;
import com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

public class GenericSearchFavouriteHelper {

	public static final Log _log = LogFactoryUtil
			.getLog(GenericSearchFavouriteHelper.class);

	public static JSONObject createUpdateFavourite(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		String errorCreateFav = "Error while saving favourite";
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			errorCreateFav = LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.save.favourite");
			String favName = ParamUtil.getString(request, "favName");
			String filtersConfig = ParamUtil.getString(request, "filtersConfig");
			boolean permissionType = ParamUtil.getBoolean(request, "permissionType");
			
			long favouriteId = ParamUtil.getLong(request, "favouriteId");
			GSFavourite favourite;
			boolean isNew = false;
			if(favouriteId > 0){
				favourite = GSFavouriteLocalServiceUtil.getGSFavourite(favouriteId);
				boolean canEdit = isFavOwner(themeDisplay.getUser(), favourite);
				if(!canEdit){
					throw new Exception("Not authorized to update the favourite");
				}
			}else{
				isNew = true;
				List<GSFavourite> favList = GSFavouriteLocalServiceUtil.getGSFavourites(-1, -1);
				for (GSFavourite fav : favList){
					if (fav.getName().toLowerCase().equalsIgnoreCase(favName.toLowerCase())){
						data.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.favourite.name.exist"));
						return data;
					}
				}
				favourite = GSFavouriteLocalServiceUtil.create();
				favourite.setConfig(filtersConfig);
			}
			
			if (permissionType) {
				favourite
				.setPermissionType(GenericSearchConstants.PERMISSIONTYPE_GLOBAL);
			} else {
				favourite
				.setPermissionType(GenericSearchConstants.PERMISSIONTYPE_PRIVATE);
				//TODO: If global, check if he has permission to creat/modify
			}
			
			favourite.setName(favName);
			favourite.setCreatedBy(themeDisplay.getUserId());
			favourite.setLayoutId(themeDisplay.getLayout().getPlid());
			favourite.setPortletInstanceId(themeDisplay.getPortletDisplay().getId());
			
			SambaashUtil.fillAudit(favourite, themeDisplay,
					favourite.isNew());
			
			GSFavouriteLocalServiceUtil.updateGSFavourite(favourite);
			
			if(isNew){
				data.put("msg", LabelUtil.getLabel(portletConfig,themeDisplay,"label.favourite.create.success"));
			}else{
				data.put("msg", LabelUtil.getLabel(portletConfig,themeDisplay,"label.favourite.update.success"));
			}
			
			if(isNew){
				data.put("isNew", "true");
			}
			data.put("updatedFavourite", getJson(themeDisplay.getUser(), favourite));
		} catch (Exception e) {
			data.put("error", errorCreateFav);
			_log.error(e);
		}
		return data;
	}

	public static JSONObject updateFavouriteConfig(PortletRequest request){
		JSONObject data = JSONFactoryUtil.createJSONObject();
		String errorCreateFav = "Error while saving favourite";
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			errorCreateFav = LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.save.favourite");
			String filtersConfig = ParamUtil.getString(request, "filtersConfig");
			long favouriteId = ParamUtil.getLong(request, "favouriteId");
			
			GSFavourite favourite = GSFavouriteLocalServiceUtil.getGSFavourite(favouriteId);
			boolean canEdit = isFavOwner(themeDisplay.getUser(), favourite);
			if(!canEdit){
				throw new Exception(LabelUtil.getLabel(portletConfig,themeDisplay,"label.not.authorised.update.favourite"));
			}
			
			favourite.setConfig(filtersConfig);
			
			SambaashUtil.fillAudit(favourite, themeDisplay,
					favourite.isNew());
			
			GSFavouriteLocalServiceUtil.updateGSFavourite(favourite);
			data.put("msg",  LabelUtil.getLabel(portletConfig,themeDisplay,"label.favourite.update.success"));
			data.put("updatedFavourite", getJson(themeDisplay.getUser(), favourite));
		} catch (Exception e) {
			data.put("error", errorCreateFav);
			_log.error(e);
		}
		return data;
	}
	
	public static JSONObject deleteFavourite(PortletRequest request){
		JSONObject data = JSONFactoryUtil.createJSONObject();
		String errorDelFav = "Error while deleting favourite";
		try {
			long favouriteId = ParamUtil.getLong(request, "favouriteId");
			GSFavourite favourite = GSFavouriteLocalServiceUtil.getGSFavourite(favouriteId);
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			errorDelFav = LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.delete.favourite");
			if(!isFavOwner(themeDisplay.getUser(), favourite)){
				throw new Exception("Unauthorized to delete favourite");
			}
			GSFavouriteLocalServiceUtil.deleteGSFavourite(favouriteId);
			data.put("msg", LabelUtil.getLabel(portletConfig,themeDisplay,"label.favourite.deleted"));
		} catch (Exception e) {
			data.put("error", errorDelFav);
			_log.error(e);
		}
		return data;
	}
	
	public static JSONArray getFavourites(ThemeDisplay themeDisplay){
		JSONArray favArr = JSONFactoryUtil.createJSONArray();
		try {
			 List<GSFavourite>list = GSFavouriteLocalServiceUtil.findAll(themeDisplay.getUserId(), themeDisplay.getPlid());
			 for (GSFavourite fav : list) {
				favArr.put(getJson(themeDisplay.getUser(), fav));
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return favArr;
	}
	
	public static JSONObject getJson(User user,GSFavourite fav){
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("name", fav.getName());
		obj.put("id", fav.getSPGSFavouriteId());
		obj.put("global", isGlobal(fav));
		obj.put("canEdit", canEdit(user,fav));
		obj.put("config", fav.getConfig());
		return obj;
	}
	
	public static boolean canEdit(User user, GSFavourite favourite){
		return isFavOwner(user, favourite) || SambaashUtil.isAdmin(favourite.getGroupId(), user.getUserId());
	}
	
	public static boolean isFavOwner(User user, GSFavourite favourite){
		if(user.getUserId() == favourite.getUserId()){
			return true;
		}
		return false;
	}
	
	public static boolean isGlobal(GSFavourite fav){
		return fav.getPermissionType() == GenericSearchConstants.PERMISSIONTYPE_GLOBAL;
	}
	public static boolean isPrivate(GSFavourite fav){
		return fav.getPermissionType() == GenericSearchConstants.PERMISSIONTYPE_PRIVATE;
	}
}
