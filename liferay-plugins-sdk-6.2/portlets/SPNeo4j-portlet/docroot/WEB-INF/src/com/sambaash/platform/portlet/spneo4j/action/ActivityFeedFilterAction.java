package com.sambaash.platform.portlet.spneo4j.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ActivityFeedFilterAction
 */
public class ActivityFeedFilterAction extends MVCPortlet {

	@ProcessAction(name = "pitchFilter")
	public void pitchFilter(ActionRequest actionRequest, ActionResponse actionResponse) {
		String filterType = ParamUtil.getString(actionRequest, "filterType");
		actionResponse.setRenderParameter("filterType", filterType);
		
		QName qName = new QName("http://liferay.com/events", "ipc.pitch");
		actionResponse.setEvent(qName, filterType);
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		// disable success message
	}

}