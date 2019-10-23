package com.sambaash.platform.util;

import java.util.ArrayList;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;

public class ProductUtil {

	private static Log _log = LogFactoryUtil.getLog(ProductUtil.class);
	
	public static void getFormsDataV2(JSONArray templates,ArrayList<String> list){
		
		JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsListV2();
		 for (int i = 0; i < jsonArray.length(); i++) {
			 if(list.contains(jsonArray.getJSONObject(i).getString("htmlFormId"))){
				JSONObject step2JsonObject = JSONFactoryUtil.createJSONObject();
				step2JsonObject.put("FormId", jsonArray.getJSONObject(i).getString("htmlFormId"));
				step2JsonObject.put("FormName", jsonArray.getJSONObject(i).getString("formName"));
				step2JsonObject.put("FormClass", jsonArray.getJSONObject(i).getString("className"));
				templates.put(step2JsonObject);
				 
			 }
			
			
		 }
		 
		
	}
}
