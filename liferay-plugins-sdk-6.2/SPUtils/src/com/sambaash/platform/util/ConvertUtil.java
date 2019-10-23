package com.sambaash.platform.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;


public final class ConvertUtil {
	private ConvertUtil() {
		// avoid instantiation
	}
	
	public static class Json {
		private Json() {
			// avoid instantiation
		}
		
		// for array of string only
		public static final List<String> jsonArrayToStringList(JSONArray arr) {
			List<String> result = new ArrayList<>();
			try {
				for(int i=0; i< arr.length(); i++) {
					result.add(arr.getString(i));
				}				
			} catch (Exception e) {
				//NOOP return empty list
			}
			return result;
		}
		
		public static final JSONArray stringListToJsonArray(String stringList) {
			return stringListToJsonArray(stringList, ",");
		}
		
		public static final JSONArray stringListToJsonArray(String stringList, String delimiter) {
			JSONArray arr = JSONFactoryUtil.createJSONArray();
			for(String s: stringList.split(delimiter)) {
				arr.put(s);
			}
			return arr;
		}
		
		public static Map<String, String[]> toStringArrayMap(JSONObject object) {
			Map<String, String[]> retMap = new HashMap<>();
			Map<String, Object> m = toMap(object);
			for (Map.Entry<String,Object> entry : m.entrySet()) {
			    retMap.put(entry.getKey(), new String[] {String.valueOf(entry.getValue())});
		    }
			return retMap;
		}

		public static Map<String, Object> toMap(JSONObject object) {
			Map<String, Object> map = new HashMap<>();

			Iterator<String> keysItr = object.keys();
			while (keysItr.hasNext()) {
				String key = keysItr.next();
				Object value = null;
				if (Validator.isNotNull(object.getJSONArray(key))) {
					value = object.getJSONArray(key);
					map.put(key, value);
				}

				else if (Validator.isNotNull(object.getJSONObject(key))) {
					value = object.getJSONObject(key);
					map.put(key, value);
				}

				else {
					value = object.getString(key);
					map.put(key, value);
				}
			}
			return map;
		}
		
		public static List<Object> toList(JSONArray array) {
			List<Object> list = new ArrayList<>();
			for (int i = 0; i < array.length(); i++) {
				Object value = array.getJSONObject(i);

				if (value instanceof JSONObject) {
					value = toMap((JSONObject) value);
				}
				list.add(value);
			}
			return list;
		}		
	}
}
