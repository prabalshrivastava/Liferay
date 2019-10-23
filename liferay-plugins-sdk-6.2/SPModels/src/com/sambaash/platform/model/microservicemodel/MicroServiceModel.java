package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class MicroServiceModel {
	public ArrayList<String> columnList() {
		return new ArrayList<String>();
	}

	public ArrayList<String> filterColumnList() {
		return new ArrayList<String>();
	}

	public Map<String, String> columnTitleMap() {
		return new HashMap<String, String>();
	}

	public JSONObject FormIOToModelJSON(JSONObject inp, JSONObject jsonModelExistingData) {
		try {
			ArrayList<String> columns = columnList();
			if (columns.size() <= 1)
				return No_Op_FormIOToModelJSON(inp, jsonModelExistingData);
			if (jsonModelExistingData.toString().equals("{}")) {

				JSONObject contentJson = JSONFactoryUtil.createJSONObject();
				contentJson.put("Status", "Active");
				jsonModelExistingData.put("contentJson", contentJson);
			}
			JSONObject in = JSONFactoryUtil.createJSONObject(inp.toString());
			for (int i = 0; i < in.names().length(); i++) {
				if (columns.contains(in.names().getString(i))) {

					jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
							in.getString(in.names().getString(i)));
					try {
						jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
								inp.getJSONArray(in.names().getString(i)));
					} catch (Exception e) {
						jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
								in.getString(in.names().getString(i)));
					}

				}
			}
		} catch (Exception e) {

		}

		return jsonModelExistingData;

	}

	protected JSONObject No_Op_FormIOToModelJSON(JSONObject in, JSONObject jsonModelExistingData) {
		JSONObject apiJsonModelData = JSONFactoryUtil.createJSONObject();
		apiJsonModelData.put("contentJson", in.toString());
		return apiJsonModelData;
	}

	public JSONObject ModelToFormIOJSON(JSONObject in) {
		return in;
	}

}