package com.sambaash.platform.spmicroservice.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.util.GroupThreadLocal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ShortLiveTaskExecutor;

public abstract class BaseSPMicroservice {
	private static final String BEARER = "Bearer ";
	private static final String USER_ROLES_HEADER = "X-USER-ROLES";
	private static final String SCOPE_GROUP_ID_HEADER = "X-SCOPEGROUP-ID";
	private static final String SITE_ID_HEADER = "X-SITE-ID";
	private static final String COMPANY_ID_HEADER = "X-COMPANY-ID";
	private static final String USER_ID_HEADER = "X-USER-ID";
	private static final String USER_NAME_HEADER = "X-USER-NAME";
	private static final String DATA_DOMAIN_HEADER = "X-DATA-DOMAIN";
	protected static final String AUTHORIZATION = "Authorization";
	protected static final String CLIENT_CREDENTIALS = "client_credentials";
	protected static final String GRANT_TYPE = "grant_type";
	protected static final String DEFAULT_SERVICE_GATEWAY = "https://api.forms.sambaash.com";
	protected static final String OAUTH_TOKEN_URI = "/uaa/oauth/token";
	protected static final String CHECK_TOKEN_URI = "/uaa/oauth/check_token";
	
	protected static ThreadLocal<Map<String, String>> serviceAccessTokenThreadLocal = new ThreadLocal<Map<String, String>>() {
		@Override
	    protected Map<String, String> initialValue() {
			return new HashMap<>();
	    }
	};

	private String clientId;
	private String clientSecret;
	private String rootContext;
	private int retryCount = 0;
				
	protected abstract Log logger();
	protected abstract String clientIdKey();
	protected abstract String clientSecretKey();
	protected abstract String rootContextKey();

	protected String getClientId() {
		if (clientId==null) {
			clientId = getSPParameter(clientIdKey(), "");
		}
		return clientId;
	}

	protected String getClientSecret() {
		if (clientSecret==null) {
			clientSecret = getSPParameter(clientSecretKey(), "");
		}
		return clientSecret;
	}
	
	protected String getRootContext() {
		if (rootContext==null) {
			rootContext = getSPParameter(rootContextKey(), "");
		}
		return rootContext;
	}
	
	public String getServiceAccessToken(String clientId, String clientSecret) {
		String currentToken = serviceAccessTokenThreadLocal.get().get(clientId);
		if (StringUtils.isEmpty(currentToken) || !isValidToken(currentToken)) {			
			try {
				String url = gatewayUrl() + OAUTH_TOKEN_URI;
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
				headers.set(AUTHORIZATION, "Basic "+base64EncodeClientInfo(clientId, clientSecret));
				
				MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
				paramMap.add(GRANT_TYPE,CLIENT_CREDENTIALS );
				
				HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(paramMap, headers);
				
				RestTemplate restTemplate = new RestTemplate();
				
				String str = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
				JSONObject response = JSONFactoryUtil.createJSONObject(str);	
				currentToken = (response != null) ? response.getString("access_token") : "";
				serviceAccessTokenThreadLocal.get().put(clientId, currentToken);
			} catch (Exception e) {
				logger().error(e);
			}
		}

		return currentToken;
	}
	
	protected boolean isValidToken(String currentToken) {
		boolean valid = false;
		if (StringUtils.isNotEmpty(currentToken)){
			try {
				String url = gatewayUrl() + CHECK_TOKEN_URI;
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
				headers.set(AUTHORIZATION, "Basic "+base64EncodeClientInfo(clientId, clientSecret));
				
				MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
				paramMap.add("token",currentToken );
				
				HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(paramMap, headers);
				
				RestTemplate restTemplate = new RestTemplate();
				
				String str = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
				JSONObject response = JSONFactoryUtil.createJSONObject(str);	
				valid = (response != null) && !response.has("error");
			} catch (Exception e) {
				logger().error(e);
			}			
		}
		return valid;
	}
	
	protected String gatewayUrl() {
		return getSPParameter(MicroserviceConstants.SERVICE_GATEWAY, DEFAULT_SERVICE_GATEWAY);
	}

	protected String constructGatewayUrl(String apiEndPoint) {
		return String.format("%s%s%s", gatewayUrl(), getRootContext(), apiEndPoint);
	}

	public <T> String execServiceApi(boolean isUserBased, String url, MediaType contentType, HttpMethod method, T requestBody){
		return execServiceApi(isUserBased, url, contentType, method, requestBody, false);
	}
	
	public <T> String execServiceApi(boolean isUserBased, String url, MediaType contentType, HttpMethod method, T requestBody, boolean noWait){
		String response = "";
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpEntity<T> request = newApiRequest(isUserBased, contentType, requestBody);	
			if (noWait) {
				// exec async and don't wait
				ShortLiveTaskExecutor.getInstance().submit(new AsynchRestRunnableTask<>(url, method, request));
			} else {
				response = restTemplate.exchange(url, method, request, String.class).getBody();
				retryCount = 0;			
			}
		} catch (Exception e) {
			if ( (++retryCount) <= 1 && e instanceof HttpClientErrorException && ((HttpClientErrorException)e).getStatusCode() == HttpStatus.UNAUTHORIZED) {
				// clear token, and try again while getting a new one
				serviceAccessTokenThreadLocal.get().remove(getClientId());
				execServiceApi(isUserBased, url, contentType, method, requestBody);
			}
			logger().error("Error invoking "+url, e);
		}
		return response;
	}

	protected JSONArray toJsonArray(String jsonStr) {
		JSONArray retval;
		try {
			retval = JSONFactoryUtil.createJSONArray(jsonStr);
		} catch (Exception e) {
			logger().info("Error converting to JSON Array. Returning empty array.");
			retval = JSONFactoryUtil.createJSONArray();
		}
		return retval;
	}
	
	protected JSONObject toJsonObject(String jsonStr) {
		JSONObject retval;
		try {
			retval = JSONFactoryUtil.createJSONObject(jsonStr);
		} catch (Exception e) {
			logger().info("Error converting to JSON Object. Returning empty object.");
			retval = JSONFactoryUtil.createJSONObject();
		}
		return retval;
	}
	
	protected String getSPParameter(String name, String defaultValue){
		String param = SambaashUtil.getParameter(name, SambaashConstants.DEFAULT_GROUP_ID_LONG);
		if(Validator.isNull(param)){
			logger().error(String.format("Unable to get parameter : %s. Defaulting to %s", name, defaultValue));
		}
		return param;
	}
	
	protected String base64EncodeClientInfo(String clientId, String clientSecret) {
		byte[] encodedBytes = Base64.encodeBase64(String.format("%s:%s", clientId, clientSecret).getBytes());
		return new String(encodedBytes);
	}

	protected <T extends Object> HttpEntity<T> newApiRequest(boolean isUserBased, MediaType contentType, T body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(contentType);
		headers.set(AUTHORIZATION, BEARER+getServiceAccessToken(getClientId(), getClientSecret()));
		headers.set("X-USER-BASED", String.valueOf(isUserBased));
		if (isUserBased) {
			addUserContextHeader(headers);
		} else {
			addSystemContextHeader(headers);
		}
		return new HttpEntity<>(body, headers);
	}
	
	private void addUserContextHeader(HttpHeaders headers) {
		long userId = PrincipalThreadLocal.getUserId();
		headers.set(USER_NAME_HEADER, PrincipalThreadLocal.getName()); // initial 
		headers.set(USER_ID_HEADER, String.valueOf(userId));
		headers.set(COMPANY_ID_HEADER, CompanyThreadLocal.getCompanyId().toString());
		headers.set(SITE_ID_HEADER, getSPParameter(SambaashConstants.VIRTUALHOST, "Unknown"));
		try {
			User u = UserLocalServiceUtil.getUser(userId);
			headers.set(SCOPE_GROUP_ID_HEADER, String.valueOf(GroupThreadLocal.getGroupId()));
			headers.set(USER_NAME_HEADER, u.getFullName()); // use full name if available
			headers.set(USER_ROLES_HEADER, StringUtils.join(ArrayUtils.toObject(u.getRoleIds()), ","));
			headers.set(DATA_DOMAIN_HEADER, SambaashUtil.retrieveMicroserviceDataDomain(u.getGroupId()));
		} catch (Exception e) {
			logger().error("Unable to retrieve scope group id for user "+userId);
		}
	}
	
	private void addSystemContextHeader(HttpHeaders headers) {
		long userId = PrincipalThreadLocal.getUserId();
		headers.set(USER_NAME_HEADER, getClientId()); // initial 
		headers.set(USER_ID_HEADER, getClientId());
		headers.set(COMPANY_ID_HEADER, CompanyThreadLocal.getCompanyId().toString());
		headers.set(SITE_ID_HEADER, getSPParameter(SambaashConstants.VIRTUALHOST, "Unknown"));		
		try {
			User u = UserLocalServiceUtil.getUser(userId);
			headers.set(SCOPE_GROUP_ID_HEADER, String.valueOf(GroupThreadLocal.getGroupId()));
			headers.set(DATA_DOMAIN_HEADER, SambaashUtil.retrieveMicroserviceDataDomain(u.getGroupId()));
		} catch (Exception e) {
			logger().error("Unable to retrieve scope group id for system user");
		}
	}
	
	public static class  AsynchRestRunnableTask<T> implements Runnable {
		private String url;
		private HttpMethod method; 
		private HttpEntity<T> request;
		
		public AsynchRestRunnableTask(String url, HttpMethod method, HttpEntity<T> request) {
			this.url = url;
			this.method = method;
			this.request = request;
		}
		
		@Override
		public void run() {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(url, method, request, String.class).getBody();
		}
		
	}
}
