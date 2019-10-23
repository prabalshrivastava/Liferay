package com.sambaash.platform.action;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DefaultServeResourceManager implements ServeResourceActionManager {
	private static final Log LOG = LogFactoryUtil.getLog(DefaultServeResourceManager.class);

	private Map<String, Class<? extends ServeResourceActionHandler>> handlerMap = new HashMap<>();

	@Override
	public ServeResourceActionManager registerResourceActionHandler(String resourceAction,
			Class<? extends ServeResourceActionHandler> handler) {
		handlerMap.put(resourceAction, handler);
		return this;
	}

	@Override
	public ServeResourceActionHandler newHandler(String resourceAction) {
		Class<? extends ServeResourceActionHandler> handlerClass = handlerMap.get(resourceAction);
		try {
			return handlerClass.newInstance();
		} catch (Exception e) {
			LOG.error("Unable to instantiate new server resource action handler. Returning null. " + e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.error(e);
			}
			return null;
		}
	}

}
