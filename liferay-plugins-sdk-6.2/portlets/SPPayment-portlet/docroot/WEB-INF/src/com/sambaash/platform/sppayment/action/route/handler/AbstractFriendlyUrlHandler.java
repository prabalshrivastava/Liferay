package com.sambaash.platform.sppayment.action.route.handler;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public abstract class AbstractFriendlyUrlHandler implements FriendlyUrlHandler {
	
	abstract String getAction();
	abstract String getDefaultRenderPage();
	abstract String handleRouting(PortletRequest request, PortletResponse response);
	
	@Override
	public String handle(PortletRequest request, PortletResponse response) {
		String renderPage = getDefaultRenderPage();
		try {
			String action = request.getParameter("actionp");
			if (getAction().equals(action)) {
				handleRouting(request, response);			
			}
		} catch (Exception e) {
			// nothing
		}
		return renderPage;
	}
}
