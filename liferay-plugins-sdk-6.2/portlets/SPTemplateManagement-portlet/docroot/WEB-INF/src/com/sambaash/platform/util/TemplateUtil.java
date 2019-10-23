package com.sambaash.platform.util;

import java.util.HashMap;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;

public class TemplateUtil {

	private static Log _log = LogFactoryUtil.getLog(TemplateUtil.class);
	
	public static void getFormsListV2(HashMap<String,JSONObject> systemtemplates,HashMap<String,JSONObject> copiedtemplates){
		
		JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsListV2();
		 for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject step2JsonObject = jsonArray.getJSONObject(i);
			if(step2JsonObject.getLong("parentHtmlFormId") <= 0){
				systemtemplates.put(step2JsonObject.getString("htmlFormId"),step2JsonObject);
			}else if(step2JsonObject.getLong("parentHtmlFormId" ) > 0){
				copiedtemplates.put(step2JsonObject.getString("htmlFormId"),step2JsonObject);
			}
		 }
		 for (String name: systemtemplates.keySet()){
	            String key =name.toString();
	            String value = systemtemplates.get(name).toString(); 
		 }
		 
		
	}
}
