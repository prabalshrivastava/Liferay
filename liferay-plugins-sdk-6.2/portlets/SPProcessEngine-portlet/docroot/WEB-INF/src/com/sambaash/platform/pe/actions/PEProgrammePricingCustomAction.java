package com.sambaash.platform.pe.actions;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;

/*
 * The configuration is expected as a valid JSON object.
 * All values must be in string format including JSONObject and JSONAarray values.
 * 
 * Example Configuration
 * 	{
 *		"enrolmentDetailKey" : "enrolmentDetails",
 *		"semesterDataPath" : "semester",
 *		"modulesDataPath" : "modules",
 *		"ProgrammeCode" : "PP",
 *		"enrolmentDetailIsArray" : true
 *	}
 */
public class PEProgrammePricingCustomAction extends PECustomActionImpl {
	private static final String MODULES = "modules";
	private static final String SCHEDULE_CODE = "ScheduleCode";
	private static final String ENROLMENT_DETAIL_KEY = "enrolmentDetailKey";
	private static final String SCHEDULE_DATA_PATH = "scheduleDataPath";
	private static final String MODULES_DATA_PATH = "modulesDataPath";
	private static final String ENROLMENT_DETAIL_IS_ARRAY = "enrolmentDetailIsArray";
	private static final String PROGRAMME_CODE = "ProgrammeCode";
	private static final String PRICING_SCHEME = "pricingScheme";
	private static final String CANDIDATE_ID = "candidateId";
	private static final String PRICING_TYPE = "pricingType";
	private static final String EXEMPTION = "exemption";
	private static final String RETIRED_PRICING_SCHEME = "retiredPricingScheme";
	private static final String RETIRED_PRICING_SCHEME_DATE = "retiredPricingSchemeDate";

	private static final Log LOGGER = LogFactoryUtil.getLog(PEProgrammePricingCustomAction.class);

	public PEProgrammePricingCustomAction(PEDataSource ds, PECustomActionNode actionNode) {
		super(ds, actionNode);
	}

	@Override
	public PEActionResult perform() {
		JSONObject config;
		try {
			config = JSONFactoryUtil.createJSONObject(actionNode.getConfiguration());
		} catch (Exception e) {
			return getActionResultFailure("Missing Node Configuration");
		}
		try {

			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter
					.getProcessStateDataAdapter(ds.getProcessState());
			JSONArray queryParam = JSONFactoryUtil.createJSONArray();
			String programmeCode = StringPool.BLANK;

			if (config.getBoolean(EXEMPTION)) {
				programmeCode = config.getString(PROGRAMME_CODE);
				String modulesStr = dataAdapter.getDataFromProcessState(config.getString(MODULES_DATA_PATH));
				JSONArray modules = JSONFactoryUtil.createJSONArray(modulesStr);
				JSONObject o = JSONFactoryUtil.createJSONObject();
				o.put(PROGRAMME_CODE, programmeCode);
				o.put(MODULES, modules);
				queryParam.put(o);

				LOGGER.error(String.format("programmeCode %s , modules %s", programmeCode, modules.toString()));

			} else {

				String dtlStr = dataAdapter.getDataFromProcessState(config.getString(ENROLMENT_DETAIL_KEY));
				JSONArray enrolmentDetails;
				if (config.getBoolean(ENROLMENT_DETAIL_IS_ARRAY)) {
					enrolmentDetails = JSONFactoryUtil.createJSONArray(dtlStr);
				} else {
					enrolmentDetails = JSONFactoryUtil.createJSONArray();
					enrolmentDetails.put(JSONFactoryUtil.createJSONObject(dtlStr));
				}

				programmeCode = enrolmentDetails.getJSONObject(0).getJSONArray(config.getString(MODULES_DATA_PATH))
						.getJSONObject(0).getString(PROGRAMME_CODE);
				for (int i = 0; i < enrolmentDetails.length(); i++) {
					JSONObject dtl = enrolmentDetails.getJSONObject(i);
					JSONObject o = JSONFactoryUtil.createJSONObject();
					JSONArray modules = dtl.getJSONArray(config.getString(MODULES_DATA_PATH));
					o.put(PROGRAMME_CODE, modules.getJSONObject(0).getString(PROGRAMME_CODE));
					o.put(SCHEDULE_CODE,
							dtl.getJSONObject(config.getString(SCHEDULE_DATA_PATH)).getString(SCHEDULE_CODE));
					o.put(MODULES, modules);
					queryParam.put(o);
				}
			}

			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(PRICING_TYPE, config.getString(PRICING_TYPE, StringPool.BLANK));
			queryParam.put(jsonObj);

			jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(PRICING_SCHEME, config.getString(PRICING_SCHEME, StringPool.BLANK));
			queryParam.put(jsonObj);
			
			if (Validator.isNotNull(ds.getProcessState()) && ds.getProcessState().getUserIdProcess() > 0) {
				jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put(CANDIDATE_ID, String.valueOf(ds.getProcessState().getUserIdProcess()));
				queryParam.put(jsonObj);
			}
			
			jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(RETIRED_PRICING_SCHEME, config.getString(RETIRED_PRICING_SCHEME, StringPool.BLANK));
			queryParam.put(jsonObj);
			
			jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(RETIRED_PRICING_SCHEME_DATE, config.getString(RETIRED_PRICING_SCHEME_DATE, StringPool.BLANK));
			queryParam.put(jsonObj);

			LOGGER.error("Sending for query of programme schedule pricing " + queryParam.toString());

			JSONObject pricingDtl = PricingMicroserviceLocalServiceUtil
					.retrievePEProgrammePriceSchemeByScheduleAndModule(ds.getProcessState().getGroupId(), programmeCode,
							queryParam.toString());
			dataAdapter.store("pricingNodeOverride", pricingDtl.getJSONArray("pricingNodeOverride").toString());

			PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
		} catch (Exception e) {
			return getActionResultFailure("Error getting pricing info");
		}
		return getActionResultSuccess();
	}

}
