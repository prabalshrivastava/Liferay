package com.sambaash.platform.pe;

import java.util.ArrayList;
import java.util.List;

public class PESubmitAppResponse {

	private long processStateId;
	private List<String> errors = new ArrayList<String>();
	
	public void addError(String error){
		errors.add(error);
	}

	public long getProcessStateId() {
		return processStateId;
	}

	public void setProcessStateId(long processStateId) {
		this.processStateId = processStateId;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
