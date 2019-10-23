package com.sambaash.platform.portlet.contactus.exception;

import javax.portlet.PortletException;

public class ContactUsCommentException extends PortletException{

	public ContactUsCommentException() {
		super();
	}

	public ContactUsCommentException(String msg) {
		super(msg);
	}

	public ContactUsCommentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ContactUsCommentException(Throwable cause) {
		super(cause);
	}

}
