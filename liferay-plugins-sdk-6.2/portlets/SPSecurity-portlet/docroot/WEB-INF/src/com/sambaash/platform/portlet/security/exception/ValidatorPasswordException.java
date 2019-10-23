package com.sambaash.platform.portlet.security.exception;

import javax.portlet.PortletException;
@SuppressWarnings("serial")
public class ValidatorPasswordException extends PortletException {

	public ValidatorPasswordException() {
		super();
	}

	public ValidatorPasswordException(String msg) {
		super(msg);
	}

	public ValidatorPasswordException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ValidatorPasswordException(Throwable cause) {
		super(cause);
	}

}