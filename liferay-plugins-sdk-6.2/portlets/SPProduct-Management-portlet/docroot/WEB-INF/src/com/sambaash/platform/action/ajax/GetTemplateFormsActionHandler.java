package com.sambaash.platform.action.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil;
import com.sambaash.platform.util.ProductUtil;


public class GetTemplateFormsActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(GetTemplateFormsActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String data =  request.getParameter("data");
		String vocabulary = "";
		HashMap<String,JSONObject> selectedFormIds =new HashMap();
		JSONObject jsonData;
		try {
			
			jsonData = JSONFactoryUtil.createJSONObject(data);
			List<Object> templateObject = SPTemplateLocalServiceUtil.getTemplateDetail(jsonData.getString(("templateId")));
			
			Object[] arrayobject=(Object[])templateObject.get(0); 
			ArrayList<String> list = new ArrayList<String>();
			
			for (int i = 0; i< templateObject.size(); i++) {
				arrayobject=(Object[])templateObject.get(i);
				if(arrayobject[3].toString() != "0"){
					list.add(arrayobject[3].toString());
				}
				if(arrayobject[4].toString() != "0"){
					list.add(arrayobject[4].toString());
				}
				if(arrayobject[5].toString() != "0"){
					list.add(arrayobject[5].toString());
				}
				if(arrayobject[6].toString() != "0"){
					list.add(arrayobject[6].toString());
				}
			}
			
			JSONArray level1templates = JSONFactoryUtil.createJSONArray();
			ProductUtil.getFormsDataV2(level1templates,list);
			response.getWriter().write(level1templates.toString());
			
		} catch (JSONException e1) {
			log.error(e1.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}
