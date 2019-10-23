package com.sambaash.platform.spmicroservice.api.wrapper;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.spmicroservice.api.BaseSPMicroservice;
import com.sambaash.platform.spmicroservice.api.MicroserviceConstants;

public class FormMicroservice extends BaseSPMicroservice{
	private static final Log LOGGER = LogFactoryUtil.getLog(FormMicroservice.class);
	
	protected Log logger() {
		return LOGGER;
	}

	@Override
	protected String clientIdKey() {
		return MicroserviceConstants.FORM_SERVICE_CLIENT_ID;
	}

	@Override
	protected String clientSecretKey() {
		return MicroserviceConstants.FORM_SERVICE_CLIENT_SECRET;
	}

	@Override
	protected String rootContextKey() {
		return MicroserviceConstants.FORM_SERVICE_ROOT_CONTEXT;
	}

	public JSONArray getFormListing() {
		String url = constructGatewayUrl("/list");
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONObject getForm(long formId) {
		String url = constructGatewayUrl(String.format("/schema/%d", formId));
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONArray getFormFields(long formId, boolean includeLayout, boolean fullInfo) {
		String url = constructGatewayUrl(String.format("/schema/%d/fields?includeLayout=%s&fullInfo=%s", formId, includeLayout, fullInfo));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public void synchroniseRole(long groupId, long roleId, String roleName) {
		String url = constructGatewayUrl(String.format("/site/%d/role", groupId));
		JSONObject o = JSONFactoryUtil.createJSONObject();
		o.put("siteId", String.valueOf(groupId));
		o.put("siteRoleId", roleId);
		o.put("siteRoleName", roleName);
		execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, o.toString(), true);
	}

	public void addFormEvent(JSONObject eventJson) {
		String url = constructGatewayUrl("/notification/event");
		execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, eventJson.toString(), true);
	}
}
