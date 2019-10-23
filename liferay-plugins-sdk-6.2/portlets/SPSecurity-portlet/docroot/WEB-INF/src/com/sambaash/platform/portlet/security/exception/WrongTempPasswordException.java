package com.sambaash.platform.portlet.security.exception;

import javax.portlet.PortletException;
@SuppressWarnings("serial")
public class WrongTempPasswordException extends PortletException {

	public WrongTempPasswordException() {
		super();
	}

	public WrongTempPasswordException(String msg) {
		super(msg);
	}

	public WrongTempPasswordException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WrongTempPasswordException(Throwable cause) {
		super(cause);
	}

}