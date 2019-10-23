package com.sambaash.platform.pe.actions;

import java.util.Iterator;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;

/*
 * The configuration is expected as a valid JSON object.
 * All values must be in string format including JSONObject and JSONAarray values.
 */
public class PEStateDataSetterCustomAction extends PECustomActionImpl  {
	private static final String ENCODE_DATA = "_encode_data_";
	public static final String PAY_OFFLINE_AMT_FEE_TYPE = "payOfflineAmtFeeType";
	public static final String CONFIRM_PAYMENT_NODE_ID = "confirmPaymentNodeId";	
	
	private static Log _log = LogFactoryUtil
			.getLog(PEStateDataSetterCustomAction.class);
					
	public PEStateDataSetterCustomAction(PEDataSource ds,
			PECustomActionNode actionNode) {
		super(ds, actionNode);
	}
	
	@Override
	public PEActionResult perform() {
		JSONObject config;
		try {
			config = JSONFactoryUtil.createJSONObject(actionNode
					.getConfiguration());
		} catch (Exception e) {
			return getActionResultFailure("Missing Node Configuration");
		}
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		boolean encode = config.has(ENCODE_DATA) ? config.getBoolean(ENCODE_DATA) : false;
		Iterator<String> keysIt = config.keys();
		while(keysIt.hasNext()) {
			String key = keysIt.next();
			if (ENCODE_DATA.equals(key)) {
				continue;
			}
			String val = config.getString(key);
			try {
				dataAdapter.store(key, ds.replaceTokensInData(val, encode));
			} catch (Exception e) {
				_log.debug("Unable to set value for "+key);
			}
		}
		
		PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());	
		return getActionResultSuccess();
	}

}
