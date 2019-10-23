package com.sambaash.platform.startupprofile.helper;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.sprating.model.AttrRate;
import com.sambaash.platform.srv.sprating.model.RatingAttr;
import com.sambaash.platform.srv.sprating.service.AttrRateLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.RatingAttrLocalServiceUtil;
import com.sambaash.platform.startupprofile.RatingConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class RatingHelper {
	
	private static Log _log = LogFactoryUtil.getLog(RatingHelper.class);
	
	public static Map<Long,String> getModelClassNames(){
		Map<Long,String> map = new LinkedHashMap<Long,String>();
		try{
			List<ClassName>names = ClassNameLocalServiceUtil.getClassNames(-1, -1);
			for(ClassName name:names){
				map.put(name.getClassNameId(), name.getClassName());
			}
		}catch(Exception ex){
			
		}
		return  map;
	}

	public static ThemeDisplay getThemeDisplay(PortletRequest request){
		return (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	public static Date getTodayDate(){
		return new Date();
	}
	public static void authorize(PortletRequest req, String portletName,String action)
			throws PrincipalException, PortalException, SystemException {
		// permission checker code
		ThemeDisplay themeDisplay = getThemeDisplay(req);
		Layout layout = themeDisplay.getLayout();
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal
				.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,
					portletName, action);
		} catch (PrincipalException pe) {
			throw new PrincipalException(pe);
		}
	}
	
	public static boolean checkRatingPermission(PortletRequest req) throws PortalException, SystemException{
		boolean hasPermission = false;
		try{
			ThemeDisplay themeDisplay = getThemeDisplay(req);
			PortletDisplay portletDisplay= themeDisplay.getPortletDisplay();
			  String portletId= portletDisplay.getId();
			 authorize(req, portletId, RatingConstants.ACTION_RATING);
			 hasPermission = true;
		}catch(PrincipalException ex){
			_log.error(ex.getMessage());
		}
		return hasPermission;
	}
	
	public JSONObject getAllAvgRatingsJson(long componentId,String objId) throws SystemException{
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put(RatingConstants.COMPONENT_ID, componentId);
		data.put(RatingConstants.OBJID, objId);
		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject item;
		List<RatingAttr> attrs = RatingAttrLocalServiceUtil.findRatingAttrsByComponentId(componentId);
		double sum = 0;
		double count = 0;
		if(!attrs.isEmpty()){
			for(RatingAttr attr: attrs){
				if(attr.isVisible()){
					item = JSONFactoryUtil.createJSONObject();
					double attrAvgRating = getAttrAvgRating(attr, objId);
					double weight = attr.getWeight();
					weight = (!Double.isNaN(weight) && weight > 0) ? weight : 1;
					if(attrAvgRating != -1){
						sum = sum + (attrAvgRating * weight);
						count = count + weight;
					}else{
						count = count + weight;
					}
					item.put(RatingConstants.RATING_ATTR_ID,attr.getSpRatingAttrId());
					item.put(RatingConstants.RATING_ATTR_NAME,attr.getName());
					item.put(RatingConstants.AVG_RATING,attrAvgRating);
					array.put(item);
				}
			}
		}
		double avg = RatingConstants.RATING_NOT_AVAILABLE;
		if(count > 0){
			avg = sum / count;
		}
		 DecimalFormat df = new DecimalFormat("#.#");
		 df.setRoundingMode(RoundingMode.CEILING);
		 avg = GetterUtil.getDouble(df.format(avg));
		data.put(RatingConstants.AVG_RATING, avg);
		data.put(RatingConstants.ITEMS, array);
		return data;
	}
	
	private double getAttrAvgRating(RatingAttr attr, String objId){
		//List<RatingAttr> attrs = RatingAttrLocalServiceUtil.findRatingAttrsByComponentId(componentId);
		List<AttrRate> attrRates = AttrRateLocalServiceUtil.findByRatingAttrIdObjId(attr.getSpRatingAttrId(), objId);
		 DecimalFormat df = new DecimalFormat("#.#");
		 df.setRoundingMode(RoundingMode.CEILING);
		double avg = RatingConstants.RATING_NOT_AVAILABLE;
		if(attrRates.isEmpty()){
			return RatingConstants.RATING_NOT_AVAILABLE;
		}else{
			double sum = 0;
			int count = 0;
			
			for(AttrRate rate : attrRates){
				// mostly value will be > 0;
				if( rate.getValue() > 0){
						sum = sum + rate.getValue() ;
						count = count + 1;
				}
			}
			if(count > 0){
				avg = sum/count;
			}
			avg = GetterUtil.getDouble(df.format(avg));
			return avg;
		}
	}
	
}
