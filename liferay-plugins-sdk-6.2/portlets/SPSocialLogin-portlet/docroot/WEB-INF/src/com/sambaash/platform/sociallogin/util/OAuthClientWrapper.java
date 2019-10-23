package com.sambaash.platform.sociallogin.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.oltu.oauth2.client.HttpClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class OAuthClientWrapper {
	
	private static Log _log = LogFactoryUtil.getLog(OAuthClientWrapper.class);
	
	protected HttpClient httpClient;

	public OAuthClientWrapper(HttpClient oauthClient) {
		this.httpClient = oauthClient;
	}

	public <T extends OAuthAccessTokenResponse> OAuthAccessTokenResponse accessToken(
			OAuthClientRequest request, Class<T> responseClass)
			throws OAuthSystemException, OAuthProblemException {
		return accessToken(request, "POST", responseClass);
	}

	public <T extends OAuthAccessTokenResponse> OAuthAccessTokenResponse accessToken(
			OAuthClientRequest request, String requestMethod,
			Class<T> responseClass) throws OAuthSystemException,
			OAuthProblemException {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		return (OAuthAccessTokenResponse) this.httpClient.execute(request,
				headers, requestMethod, responseClass);
	}

	public <T extends OAuthAccessTokenResponse> OAuthAccessTokenResponse accessToken(
			OAuthClientRequest request, String requestMethod, String body,
			Class<T> responseClass) throws OAuthSystemException,
			OAuthProblemException {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		int length = body.length();
		headers.put("Content-length", String.valueOf(length));
		request.setBody(body);

		return (OAuthAccessTokenResponse) this.httpClient.execute(request,
				headers, requestMethod, responseClass);
	}

	public OAuthJSONAccessTokenResponse accessToken(OAuthClientRequest request)
			throws OAuthSystemException, OAuthProblemException {
		return (OAuthJSONAccessTokenResponse) accessToken(request,
				OAuthJSONAccessTokenResponse.class);
	}

	public OAuthJSONAccessTokenResponse accessToken(OAuthClientRequest request,
			String requestMethod) throws OAuthSystemException,
			OAuthProblemException {
		return (OAuthJSONAccessTokenResponse) accessToken(request,
				requestMethod, OAuthJSONAccessTokenResponse.class);
	}

	public <T extends OAuthClientResponse> T resource(
			OAuthClientRequest request, String requestMethod,
			Class<T> responseClass) throws OAuthSystemException,
			OAuthProblemException {
		return this.httpClient.execute(request, null, requestMethod,
				responseClass);
	}

	public void shutdown() {
		this.httpClient.shutdown();
	}
}