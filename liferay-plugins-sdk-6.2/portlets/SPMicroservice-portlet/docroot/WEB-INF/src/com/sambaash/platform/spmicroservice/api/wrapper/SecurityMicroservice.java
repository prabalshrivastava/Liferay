package com.sambaash.platform.spmicroservice.api.wrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.spmicroservice.api.BaseSPMicroservice;
import com.sambaash.platform.spmicroservice.api.MicroserviceConstants;

public class SecurityMicroservice extends BaseSPMicroservice{
	private static final Log LOGGER = LogFactoryUtil.getLog(SecurityMicroservice.class);
	
	protected Log logger() {
		return LOGGER;
	}

	@Override
	protected String clientIdKey() {
		return MicroserviceConstants.FORM_SERVICE_CLIENT_ID;
	}

	@Override
	protected String clientSecretKey() {
		return MicroserviceConstants.FORM_SERVICE_CLIENT_SECRET;
	}

	@Override
	protected String rootContextKey() {
		return MicroserviceConstants.SECURITY_SERVICE_ROOT_CONTEXT;
	}
	
}
