package com.sambaash.platform.action.ajax;

import java.io.IOException;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class FetchScreenNameActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(LoadListActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		
		String screenName = "";
		String userId = request.getParameter("formStorageId");
		
		try {
			User user = UserLocalServiceUtil.getUser(Long.valueOf(userId));
			screenName = user.getScreenName();
		} catch (NumberFormatException | PortalException | SystemException e1) {
			log.error(e1.toString());
		}
		try {
			response.getWriter().write(screenName);
			
		} catch (IOException e) {
			log.error(e);
		}
		
	}

}
