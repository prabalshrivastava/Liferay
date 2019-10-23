package com.sambaash.platform.portlet.spcontent.resource;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public interface IResourceServer {
	public void serve(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws ServeResourceException;
}
