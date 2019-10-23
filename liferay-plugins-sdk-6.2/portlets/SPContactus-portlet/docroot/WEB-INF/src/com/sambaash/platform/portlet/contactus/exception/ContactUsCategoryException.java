package com.sambaash.platform.portlet.contactus.exception;

import javax.portlet.PortletException;

public class ContactUsCategoryException extends PortletException {
		
		public ContactUsCategoryException() {
			super();
		}

		public ContactUsCategoryException(String msg) {
			super(msg);
		}

		public ContactUsCategoryException(String msg, Throwable cause) {
			super(msg, cause);
		}

		public ContactUsCategoryException(Throwable cause) {
			super(cause);
		}
		
}
