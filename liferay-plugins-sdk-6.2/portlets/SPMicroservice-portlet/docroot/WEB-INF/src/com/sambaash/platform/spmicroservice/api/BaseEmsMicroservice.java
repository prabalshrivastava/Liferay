package com.sambaash.platform.spmicroservice.api;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ShortLiveTaskExecutor;

public abstract class BaseEmsMicroservice {
	private static final String SCOPE_GROUP_ID_HEADER = "X-SCOPEGROUP-ID";
	private static final String USER_ID_HEADER = "X-USER-ID";
	private static final String USER_NAME_HEADER = "X-USER-NAME";
	
	protected abstract Log logger();
	protected abstract String getRootContext();
	protected abstract String getClientId();
	
	protected String scopeGroupId;
	
	public BaseEmsMicroservice(long scopeGroupId) {
		this.scopeGroupId = String.valueOf(SambaashUtil.getScopeGroupId(scopeGroupId));
	}
	
	public BaseEmsMicroservice(String scopeGroupId) {
		this.scopeGroupId = scopeGroupId;
	}
	
	public String getScopeGroupId() {
		return scopeGroupId;
	}

	public long getNumericScopeGroupId() {
		return Long.parseLong(scopeGroupId);
	}

	protected String gatewayUrl() {
		return getSPParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,"http://localhost:9065/");
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
			}
		} catch (Exception e) {
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
	
	protected boolean toBoolean(String str) {
		boolean retval;
		try {
			retval = Boolean.parseBoolean(str);
		} catch (Exception e) {
			logger().error("Error converting to string to boolean. Returning false.");
			retval = false;
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
		if(StringUtils.isEmpty(param)){
			logger().error(String.format("Unable to get parameter : %s. Defaulting to %s", name, defaultValue));
		}
		return param;
	}
	
	protected <T extends Object> HttpEntity<T> newApiRequest(boolean isUserBased, MediaType contentType, T body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(contentType);
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
		try {
			User u = UserLocalServiceUtil.getUser(userId); 			
			headers.set(SCOPE_GROUP_ID_HEADER, getScopeGroupId());
			headers.set(USER_NAME_HEADER, u.getFullName()); // use full name if available
		} catch (Exception e) {
			logger().error("Unable to retrieve scope group id for user "+userId);
		}
	}
	
	private void addSystemContextHeader(HttpHeaders headers) {
		long userId = PrincipalThreadLocal.getUserId();
		headers.set(USER_NAME_HEADER, getClientId()); // initial 
		headers.set(USER_ID_HEADER, getClientId());
//		try {
//			User u = UserLocalServiceUtil.getUser(userId); 			
//			headers.set(SCOPE_GROUP_ID_HEADER, String.valueOf(u.getGroupId()));
//		} catch (Exception e) {
//			logger().error("Unable to retrieve scope group id for system user");
//		}
		headers.set(SCOPE_GROUP_ID_HEADER, getScopeGroupId());
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
