package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.util.Validator;

import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.exception.PEException;

import java.util.ArrayList;
import java.util.List;
public class PEProcessableNodeOutput {

	public void addValidationMsg(String msg) {
		getValidationMsgs().add(msg);
	}

	public boolean errorExists() {
		boolean exists = (Validator.isNotNull(error));
		return exists;
	}

	public PEError getError() {
		return error;
	}

	public List<String> getValidationMsgs() {
		if (Validator.isNull(this.msgs)) {
			this.msgs = new ArrayList<String>();
		}

		return this.msgs;
	}

	public void setError(PEError error) {
		this.error = error;
	} public long getNextNodeId() {
		return nextNodeId;
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

	public void setNextNodeId(long nextNodeId) {
		this.nextNodeId = nextNodeId;
	}

	public void setValidationMsgs(List<String> validationMsgs) {
		this.msgs = validationMsgs;
	}

	public boolean validationMsgsExists() {
		boolean exists = (!getValidationMsgs().isEmpty());
		return exists;
	}

	public boolean isCanProceedToNext() {
		return canProceedToNext;
	}

	public void setCanProceedToNext(boolean canProceedToNext) {
		this.canProceedToNext = canProceedToNext;
	}

	public long getDraftStorageId() {
		return draftStorageId;
	}

	public void setDraftStorageId(long draftStorageId) {
		this.draftStorageId = draftStorageId;
	}

	private PEError error;
	private List<String> msgs;
	private boolean canProceedToNext;
	private long nextNodeId;
	private long draftStorageId;

}