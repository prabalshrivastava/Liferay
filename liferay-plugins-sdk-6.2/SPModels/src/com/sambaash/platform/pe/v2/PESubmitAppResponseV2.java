package com.sambaash.platform.pe.v2;

import java.util.ArrayList;
import java.util.List;

public class PESubmitAppResponseV2 {
	private long processStateId;
	private List<String> errors = new ArrayList<>();

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
