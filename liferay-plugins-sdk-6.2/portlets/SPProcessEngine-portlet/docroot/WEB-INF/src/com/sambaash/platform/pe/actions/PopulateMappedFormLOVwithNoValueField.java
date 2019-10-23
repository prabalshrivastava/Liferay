package com.sambaash.platform.pe.actions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.util.SPStringUtils;
import com.sambaash.platform.util.URLUtil;

/*
 * For populating form select fields that are storing entire JSONObject.
 * An example is the SAC Admission's ATO details.
 * This is the sample configuration used:
[
  {
    "selectField": "AtoName",
    "hiddenField": "atoVF",
    "hiddenFieldTemplate": "[$name$]",
    "sourceUrl": "/api/jsonws/StartupProfile-portlet.startupprofile/get-all-ato",
    "headers": [],
    "chainedFields": [
      {
        "selectField": "TrainingPrincipal",
        "hiddenField": "tpVF",
        "hiddenFieldTemplate": "[$primaryPrincipalUserFirstName$] [$primaryPrincipalUserLastName$]",
        "sourceUrl": "/api/jsonws/StartupProfile-portlet.startupprofile/find-ato-contacts-by-organization-id/organization-id/[$organizationId$]",
        "headers": [],
        "chainedFields": []
      },
      {
        "selectField": "MentorId",
        "hiddenField": "mentorVF",
        "hiddenFieldTemplate": "[$firstName$] [$lastName$]",
        "sourceUrl": "/api/jsonws/StartupProfile-portlet.startupprofile/find-approved-mentors-by-organization-id/organization-id/[$organizationId$]",
        "headers": [],
        "chainedFields": []
      }      
    ]
  }
]
 */
public class PopulateMappedFormLOVwithNoValueField extends PECustomActionImpl {

	private static final String HIDDEN_FIELD = "hiddenField";
	private static final String CHAINED_FIELDS = "chainedFields";
	private static final Log LOGGER = LogFactoryUtil.getLog(PopulateMappedFormLOVwithNoValueField.class);
	private PEProcessStateDataAdapter dataAdapter;

	public PopulateMappedFormLOVwithNoValueField(PEDataSource ds, PECustomActionNode actionNode) {
		super(ds, actionNode);
	}

	@Override
	public PEActionResult perform() {
		JSONArray config;
		try {
			if (Validator.isNotNull(actionNode.getConfiguration())) {
				config = JSONFactoryUtil.createJSONArray(actionNode.getConfiguration());
				boolean modified = false;
				for (int i = 0; i < config.length(); i++) {
					JSONObject currLevelConfig = config.getJSONObject(i);
					JSONObject currLevelData = JSONFactoryUtil.createJSONObject();
					String savedValueOptionLabel = ds.getDataFromProcessState(currLevelConfig.getString(HIDDEN_FIELD));
					if (StringUtils.isEmpty(savedValueOptionLabel)) {
						break; // hidden field not populated. no need to lookup anything.
					}
					invokeApi(currLevelData, currLevelConfig);
					modified = true;
				}
				if (modified){
					updateProcessState();
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return getActionResultFailure("Error populating mapped LOV fields." + e.toString());
		}
		return getActionResultSuccess();
	}

	private String invokeApi(JSONObject data, JSONObject config) throws PEException, JSONException {
		String response;
		RestTemplate restTemplate = new RestTemplate();

		String apiUrl = URLUtil.autoResolveUrl(ds.getRequestData().getPortletRequest(), config.getString("sourceUrl"));
		LOGGER.debug("API URL :  " + apiUrl);

		if (SPStringUtils.hasTokenPattern(apiUrl)) {
			apiUrl = SPStringUtils.replaceTokensFromJson(data, apiUrl, false);
			LOGGER.debug("API URL token replaced :  " + apiUrl);
		}

		JSONArray apiHeaders = config.getJSONArray("headers");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (apiHeaders != null && apiHeaders.length() > 0) {
			for (int i = 0; i < apiHeaders.length(); i++) {
				JSONObject apiHeader = apiHeaders.getJSONObject(i);
				headers.set(apiHeader.getString("header"), apiHeader.getString("value"));
			}
		}

		HttpMethod apiUrlMethod = config.has("sourceUrlMethod")
				? HttpMethod.valueOf(config.getString("sourceUrlMethod").toUpperCase()) : HttpMethod.GET;
		String requestBody = config.has("requestBody") ? config.getString("requestBody") : null;
		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
		response = restTemplate.exchange(apiUrl, apiUrlMethod, request, String.class).getBody();

		handleResponse(config, response);

		return response;
	}

	private void handleResponse(JSONObject config, String response) throws JSONException, PEException {
		if (StringUtils.isNotEmpty(response)) {
			LOGGER.debug("Got API response:" + response);
			boolean isExpectedArrayResponse = response.startsWith("[") && response.endsWith("]");
			if (isExpectedArrayResponse) {
				JSONArray lovDataArr = JSONFactoryUtil.createJSONArray(response);
				JSONObject selected = getSelectedValue(config, lovDataArr);
				if (config.has(CHAINED_FIELDS) && config.getJSONArray(CHAINED_FIELDS).length() > 0) {
					JSONArray chainedFieldLookup = config.getJSONArray(CHAINED_FIELDS);
					for (int i = 0; i < chainedFieldLookup.length(); i++) {
						JSONObject chainedConfig = chainedFieldLookup.getJSONObject(i);
						invokeApi(selected, chainedConfig);
					}
				}
			} else {
				JSONObject respObj = JSONFactoryUtil.createJSONObject(response);
				if (respObj.has("error")) {
					throw new PEException(
							String.format("System Error. Please contact support team. Error invoking Node %d - %s",
									actionNode.getNodeId(), respObj.getString("error")));
				} else if (respObj.has("exception")) {
					throw new PEException(String.format(
							"System Error. Please contact support team. Error invoking API Node %d - %s : %s",
							actionNode.getNodeId(), respObj.getString("exception"), respObj.getString("message")));
				}
			}
		}
	}

	private JSONObject getSelectedValue(JSONObject config, JSONArray lovDataArr) {
		JSONObject selectedData = null;
		String savedValueOptionLabel = ds.getDataFromProcessState(config.getString(HIDDEN_FIELD));
		String valueOptionLabelTemplate = config.getString("hiddenFieldTemplate");
		for (int i = 0; i < lovDataArr.length(); i++) {
			JSONObject lovItem = lovDataArr.getJSONObject(i);
			String lovItemLabel = SPStringUtils.replaceTokensFromJson(lovItem, valueOptionLabelTemplate, false);
			LOGGER.debug(String.format("%s = %s", savedValueOptionLabel, lovItemLabel));
			if (lovItemLabel.equals(savedValueOptionLabel)) {
				// found it
				selectedData = lovItem;
				saveDataToState(config.getString("selectField"), selectedData);
				break;
			}
		}
		return selectedData;
	}

	protected PEProcessStateDataAdapter getDataAdapter() {
		if (dataAdapter == null) {
			dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		}
		return dataAdapter;
	}

	protected void saveDataToState(String stateDataField, JSONObject selectedData) {
		getDataAdapter().store(stateDataField, selectedData.toString());
	}

	protected void updateProcessState() {
		PEProcessState processState = ds.getProcessState();
		PEProcessStateHelper.updateProcessStateSafe(processState, ds.getRequestData());
	}

}
