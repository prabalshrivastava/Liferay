package com.sambaash.platform.certificate.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.certificate.service.SPCertificateCollectionLocalService;
import com.sambaash.platform.certificate.service.SPCertificateCollectionLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ElasticSearchListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ElasticSearchListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPCertificateCollectionLocalServiceUtil.getElasticSearchListing(request, response);
//			SPCertificateCollectionLocalServiceUtil.saveExportQuery("elasticsearch", modelData, request);
			response.getWriter().write(modelData);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
