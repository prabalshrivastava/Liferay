package com.sambaash.platform.sppayment.action.route.handler;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public interface FriendlyUrlHandler {
	/*
	 * returns the render page
	 */
	String handle(PortletRequest request, PortletResponse response);
}
