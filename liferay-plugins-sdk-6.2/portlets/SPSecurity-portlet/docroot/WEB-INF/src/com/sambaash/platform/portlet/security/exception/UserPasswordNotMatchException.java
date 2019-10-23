package com.sambaash.platform.portlet.security.exception;

import javax.portlet.PortletException;
@SuppressWarnings("serial")
public class UserPasswordNotMatchException extends PortletException {

	public UserPasswordNotMatchException() {
		super();
	}

	public UserPasswordNotMatchException(String msg) {
		super(msg);
	}

	public UserPasswordNotMatchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserPasswordNotMatchException(Throwable cause) {
		super(cause);
	}

}