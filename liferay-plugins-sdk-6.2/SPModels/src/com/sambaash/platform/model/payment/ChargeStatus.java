package com.sambaash.platform.model.payment;

public class ChargeStatus {
	private static final String DEFAULT_NEXT_STEP = "Please contact the administrator.";
	
	private boolean success;
	private String errorCode;
	private String errorMessage;
	private String nextStep;
	private String chargeId;
	private String cartId;
	private String chargeInfo;

	public ChargeStatus(String chargeId) {
		this(chargeId, true);
	}
	
	public ChargeStatus(String chargeId, String errorCode) {
		this(chargeId, false);
		this.errorCode = errorCode;
	}

	private ChargeStatus(String chargeId, boolean success) {
		this.success = success;
		this.chargeId = chargeId;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getNextStep() {
		if (nextStep == null && errorCode !=null && !"".equals(errorCode.trim())) {
			nextStep = DEFAULT_NEXT_STEP;
		}
		return nextStep;
	}
	
	public String getChargeId() {
		return chargeId;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getChargeInfo() {
		return chargeInfo;
	}

	public void setChargeInfo(String chargeInfo) {
		this.chargeInfo = chargeInfo;
	}

}
