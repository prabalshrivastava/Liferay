package com.sambaash.platform.ato.ajax;


import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;

public class DownloadPdfActionHandler  implements ServeResourceActionHandler {
		private Log log = LogFactoryUtil.getLog(DownloadPdfActionHandler.class.getName());

		@Override
		public void handle(ResourceRequest request, ResourceResponse response) {
//			log.debug("BEFORE: exportPdf invoked");
			SPATOAdmissionLocalServiceUtil.exportPdf(request, response);
		}
	}

