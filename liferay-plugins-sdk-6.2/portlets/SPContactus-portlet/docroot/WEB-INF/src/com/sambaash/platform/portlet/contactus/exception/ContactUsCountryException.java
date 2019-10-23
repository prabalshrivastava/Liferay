package com.sambaash.platform.portlet.contactus.exception;

import javax.portlet.PortletException;

public class ContactUsCountryException extends PortletException {

	public ContactUsCountryException() {
		super();
	}

	public ContactUsCountryException(String msg) {
		super(msg);
	}

	public ContactUsCountryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ContactUsCountryException(Throwable cause) {
		super(cause);
	}

}
