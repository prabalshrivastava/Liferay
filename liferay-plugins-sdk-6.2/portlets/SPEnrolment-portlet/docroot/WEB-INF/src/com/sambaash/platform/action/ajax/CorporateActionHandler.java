package com.sambaash.platform.action.ajax;

import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class CorporateActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(CorporateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {

		try {
			List<Company> companies = CompanyLocalServiceUtil.getCompanies(1, 10);
			JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
			String userJson = jsonSerializer.serialize(companies);
			response.getWriter().write(userJson);

		} catch (SystemException | IOException e) {
			_log.error(e);
		}
	}
}
