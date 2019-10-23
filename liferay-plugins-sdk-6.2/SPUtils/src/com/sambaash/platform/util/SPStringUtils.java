package com.sambaash.platform.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPStringUtils {
	private static final Log LOG = LogFactoryUtil.getLog(SPStringUtils.class);
	public static final Pattern TOKEN_PATTERN = Pattern.compile("\\[\\$[a-zA-Z0-9_\\.\\-\\(\\)]*\\$\\]");
	
	private SPStringUtils() {
		// Statics only
	}
	
	public static boolean hasTokenPattern(String data) {
		return TOKEN_PATTERN.matcher(data).find();
	}

	public static String nestedReplaceToken(Object sourceObject, String data, boolean encode) throws JSONException {
		String newData = "";
		String currData = data;
		while (currData != null) {
			newData = replaceTokens(sourceObject, currData, encode);
			currData = hasTokenPattern(newData) ? newData : null;
		}
		return newData;
	}
	
	public static String replaceTokens(Object sourceObject, String data, boolean encode) throws JSONException {
		return replaceTokensFromJson(JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerializeDeep(sourceObject)), data, encode);
	}
	
	public static String replaceTokensFromJson(JSONObject sourceObject, String data, boolean encode) {
		LOG.debug("data to replace: " + data);
		LOG.debug("get replacement data from : " + sourceObject);

		Pattern patt = TOKEN_PATTERN;
		Matcher m = patt.matcher(data);
		StringBuffer sb = new StringBuffer(data.length());
		while (m.find()) {
			try {
				String text = m.group(0);
				LOG.debug("IN Matcher loop : " + text);
				StringBuilder propSb = new StringBuilder(text);
				propSb.replace(0, 2, ""); // replace "[$"
				propSb.replace(propSb.length() - 2, propSb.length(), ""); // replace "$]"
				String token = propSb.toString();
				String replacedData = getSourceData(sourceObject, token);
				if (encode) {
					replacedData = URLUtil.encodeValue(replacedData);
				}
				LOG.debug("replaced data => " + replacedData);
				m.appendReplacement(sb, replacedData);
			} catch (Exception e) {
				LOG.error("Error while processing token." + e.toString());
			}
		}

		m.appendTail(sb);
		return sb.toString().trim();
	}

	private static String getSourceData(JSONObject sourceObject, String token) {
		if (token.contains(".")) {
			JSONObject curObj = sourceObject;
			String[] tokenPath = token.split("\\.");
			String sourceData = "";
			JSONArray curArray = null;
			for(int i=0; i<tokenPath.length; i++) {
				String path = tokenPath[i];
				if (i<tokenPath.length-1) {
					// is parent array?
					if (curObj.getJSONObject(path) == null) {
						curArray = curObj.getJSONArray(path);						
					} else {
						// must be parent object
						curObj = curObj.getJSONObject(path);
					}
				// only supports 1 array deep
				} else if(curArray != null) {
					// arrays will be ouputted as comma-delimited
					StringBuilder sb = new StringBuilder();
					boolean firstEntry = true;
					for(int x=0; x<curArray.length(); x++) {
						curObj = curArray.getJSONObject(x);
						if (firstEntry) {
							firstEntry = false;
						} else {
							sb.append(",");
						}
						sb.append(curObj.has(path) ? curObj.getString(path) : "");
					}
					sourceData = sb.toString();
				} else {
					sourceData = curObj.has(path) ? curObj.getString(path) : "";
				}
			}
			return sourceData;			
		} else {
			return sourceObject.getString(token);
		}
	}

	public static String nestedReplaceTokenFromJson(JSONObject sourceObject, String data, boolean encode) {
		String newData = "";
		String currData = data;
		while (currData != null) {
			newData = replaceTokensFromJson(sourceObject, currData, encode);
			currData = hasTokenPattern(newData) ? newData : null;
		}
		return newData;
	}
}
