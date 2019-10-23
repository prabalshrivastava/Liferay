package com.sambaash.platform.pe.actions;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;

public class PEPaymentConfirmationInitialization extends PECustomActionImpl  {
	public static final String PAY_OFFLINE_AMT_FEE_TYPE = "payOfflineAmtFeeType";
	public static final String CONFIRM_PAYMENT_NODE_ID = "confirmPaymentNodeId";	
	
	private static Log _log = LogFactoryUtil
			.getLog(PEPaymentConfirmationInitialization.class);
					
	public PEPaymentConfirmationInitialization(PEDataSource ds,
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
		
		long paymentNodeId = config.getLong("confirm.pay.nodeId");
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		dataAdapter.store(CONFIRM_PAYMENT_NODE_ID,String.valueOf(paymentNodeId));
		
		String payOfflineAmtFeeType = config.getString("pay.offline.amount.feeType");
		dataAdapter.store(PAY_OFFLINE_AMT_FEE_TYPE,payOfflineAmtFeeType);
		
		PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());	
		return getActionResultSuccess();
	}

}
