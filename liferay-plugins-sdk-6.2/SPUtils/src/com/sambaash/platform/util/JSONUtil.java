package com.sambaash.platform.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class JSONUtil {
	private static Log _log = LogFactoryUtil.getLog(JSONUtil.class);

	public static boolean isJson(String json) {
		try {
			JSONFactoryUtil.createJSONObject(json);
		} catch (JSONException ex) {
			try {
				JSONFactoryUtil.createJSONArray(json);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

	public static String getFormattedJsonString(String json) {
		try {
			return JSONFactoryUtil.createJSONObject(json).toString(4);
		} catch (JSONException ex) {
			_log.error(ex.getMessage());
			try {
				return JSONFactoryUtil.createJSONArray(json).toString(4);
			} catch (JSONException ex1) {
				_log.error(String.format("Failed to parse JSON string %s, error %s", json, ex1.getMessage()));
			}
		}
		return StringPool.BLANK;
	}

}
