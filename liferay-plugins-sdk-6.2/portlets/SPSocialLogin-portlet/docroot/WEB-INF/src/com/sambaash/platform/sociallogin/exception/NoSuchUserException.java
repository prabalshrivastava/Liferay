package com.sambaash.platform.sociallogin.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class NoSuchUserException extends PortalException {

	private static final long serialVersionUID = 1L;

	public NoSuchUserException() {
	}

	public NoSuchUserException(String msg) {
		super(msg);
	}

	public NoSuchUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserException(Throwable cause) {
		super(cause);
	}
}
