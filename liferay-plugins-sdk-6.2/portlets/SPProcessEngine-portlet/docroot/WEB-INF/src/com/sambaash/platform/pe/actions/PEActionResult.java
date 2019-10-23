package com.sambaash.platform.pe.actions;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.exception.PEException;

public class PEActionResult {
	

	public boolean errorExists() {
		boolean exists = (Validator.isNotNull(error) || validationMsgsExists());
		return exists;
	}
	
	public boolean validationMsgsExists() {
		boolean exists = (msgs != null && !msgs.isEmpty());
		return exists;
	}
	
	public void addValidationMsg(String msg) {
		getValidationMsgs().add(msg);
	}
	
	public List<String> getValidationMsgs() {
		if (Validator.isNull(this.msgs)) {
			this.msgs = new ArrayList<String>();
		}

		return this.msgs;
	}

	public PEError getError() {
		return error;
	}

	public void setError(PEError error) {
		this.error = error;
	} 
	
	public void setError(Throwable throwable) {
		if (throwable instanceof PEException) {
			PEException pee = (PEException)throwable;
			this.error = pee.getError();;
		}

		if (Validator.isNull(error)) {
			this.error = PEError.createError(throwable);
		}
	}

	public void setValidationMsgs(List<String> validationMsgs) {
		this.msgs = validationMsgs;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	private PEError error;
	private List<String> msgs;
	private String successMsg;
}
