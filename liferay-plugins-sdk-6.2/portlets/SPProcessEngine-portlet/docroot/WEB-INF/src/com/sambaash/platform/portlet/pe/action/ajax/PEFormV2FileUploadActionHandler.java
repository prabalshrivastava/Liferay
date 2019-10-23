package com.sambaash.platform.portlet.pe.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;

public class PEFormV2FileUploadActionHandler implements ServeResourceActionHandler {

	private static final Log _log = LogFactoryUtil.getLog(PEFormV2FileUploadActionHandler.class);

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {

		long processStateId = ParamUtil.getLong(request, PEConstants.PARAM_PROCESS_STATE_ID, 0);

		_log.error("Invoking PEFormV2FileUploadActionHandler handle for processStateId :  " + processStateId);

		SPDynamicFormsLocalServiceUtil.handleFileUpload(request, response);
	}

}
