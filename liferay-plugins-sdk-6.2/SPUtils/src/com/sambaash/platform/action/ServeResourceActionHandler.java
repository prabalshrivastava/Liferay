package com.sambaash.platform.action;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public interface ServeResourceActionHandler {
	public void handle(ResourceRequest resourceRequest, ResourceResponse resourceResponse);
}
