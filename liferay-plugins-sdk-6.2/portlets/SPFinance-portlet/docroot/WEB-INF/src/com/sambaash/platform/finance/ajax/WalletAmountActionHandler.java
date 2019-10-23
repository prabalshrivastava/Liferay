package com.sambaash.platform.finance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

public class WalletAmountActionHandler implements ServeResourceActionHandler {

	/**
	 * This is an object of Log class
	 */
	private Log log = LogFactoryUtil.getLog(WalletAmountActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String result = SPFinanceLocalServiceUtil.getWalletAmount(request, response);
			response.getWriter().write(result);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
