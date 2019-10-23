package com.sambaash.platform.sociallogin.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class CodeExchangeException extends PortalException {

	private static final long serialVersionUID = 1L;

	public CodeExchangeException() {
	}

	public CodeExchangeException(String msg) {
		super(msg);
	}

	public CodeExchangeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CodeExchangeException(Throwable cause) {
		super(cause);
	}
}
