package com.sambaash.platform.sociallogin.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.token.BasicOAuthToken;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;


public class AccessTokenResponseWrapper extends OAuthAccessTokenResponse {
	
	private static Log _log = LogFactoryUtil.getLog(AccessTokenResponseWrapper.class);
	
	public String getAccessToken() {
		return getParam("access_token");
	}

	public Long getExpiresIn() {
		String value = getParam("expires_in");
		return value == null ? null : Long.valueOf(value);
	}

	public String getRefreshToken() {
		return getParam("expires_in");
	}

	public String getScope() {
		return getParam("scope");
	}

	public OAuthToken getOAuthToken() {
		return new BasicOAuthToken(getAccessToken(), getExpiresIn(),
				getRefreshToken(), getScope());
	}

	protected void setBody(String body) {
		this.body = body;

		this.parameters = decodeForm(body);
	}

	protected void setContentType(String contentType) {
		this.contentType = contentType;
	}

	protected void setResponseCode(int code) {
		this.responseCode = code;
	}

	protected Map<String, Object> decodeForm(String body) {
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		if (!OAuthUtils.isEmpty(body)) {
			try {
				JSONObject json = JSONFactoryUtil.createJSONObject(body);
				for (Iterator<String> it = json.keys(); it.hasNext();) {
					String key = it.next();
					mapParameters.put(key, json.getString(key));
				}
			} catch (JSONException e) {
				_log.error(e.getMessage());

			}
		}
		return mapParameters;
	}
}
