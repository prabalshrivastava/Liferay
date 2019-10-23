package com.sambaash.platform.exception;

import com.liferay.portal.kernel.util.StringPool;

public class UpdateFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	String msg = StringPool.BLANK;

	public UpdateFailedException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}