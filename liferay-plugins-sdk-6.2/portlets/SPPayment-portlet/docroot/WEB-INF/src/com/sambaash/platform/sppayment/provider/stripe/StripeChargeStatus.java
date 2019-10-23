package com.sambaash.platform.sppayment.provider.stripe;

import org.apache.commons.lang.StringUtils;

import com.sambaash.platform.model.payment.ChargeStatus;

public class StripeChargeStatus extends ChargeStatus {

	public StripeChargeStatus(String chargeId, String errorCode) {
		super(chargeId, errorCode);
		// TODO glenn set the custom error message and next step accordingly
	}

	public StripeChargeStatus(String chargeId) {
		super(chargeId);
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		if (StringUtils.isEmpty(getErrorMessage())) {
			// set only if there is no custom message. Custom message set on constructor.
			super.setErrorMessage(errorMessage);			
		}
	}

}
