package com.liferay.saml.hook.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServiceProviderAction extends BaseSamlStrutsAction {

	protected String doExecute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(
				"/admin/edit_service_provider_connection.jsp");
		requestDispatcher.forward(request, response);
		return null;
	}
}
