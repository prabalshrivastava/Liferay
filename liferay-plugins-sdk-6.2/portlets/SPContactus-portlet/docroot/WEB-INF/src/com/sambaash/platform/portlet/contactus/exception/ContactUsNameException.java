package com.sambaash.platform.portlet.contactus.exception;

import javax.portlet.PortletException;

public class ContactUsNameException extends PortletException {

	public ContactUsNameException() {
		super();
	}

	public ContactUsNameException(String msg) {
		super(msg);
	}

	public ContactUsNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ContactUsNameException(Throwable cause) {
		super(cause);
	}

}
