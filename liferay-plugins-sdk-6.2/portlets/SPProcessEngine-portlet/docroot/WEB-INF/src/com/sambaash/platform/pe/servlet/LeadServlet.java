package com.sambaash.platform.pe.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.StringPool;

public class LeadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Log _log = LogFactoryUtil.getLog(LeadServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String challenge = StringPool.BLANK;
		Enumeration<?> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			_log.error("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
			
			if(paramName.equalsIgnoreCase("hub.challenge")){
				_log.error("equal : " + request.getParameter(paramName));
				challenge = request.getParameter(paramName);
			} else if(paramName.contains("challenge")){
				_log.error("contain : " + request.getParameter(paramName));
				challenge = request.getParameter(paramName);
			}
		}
		
		_log.error("challenge : " + challenge);
		ServletResponseUtil.write(response, challenge);

	}
	
	
//	17:03:14,160 ERROR [ajp-apr-8009-exec-1][LeadServlet:32] Parameter Name - hub.verify_token, Value - lithanstg
//	17:03:14,161 ERROR [ajp-apr-8009-exec-1][LeadServlet:32] Parameter Name - hub.mode, Value - subscribe
//	17:03:14,162 ERROR [ajp-apr-8009-exec-1][LeadServlet:32] Parameter Name - hub.challenge, Value - 347434073

}
