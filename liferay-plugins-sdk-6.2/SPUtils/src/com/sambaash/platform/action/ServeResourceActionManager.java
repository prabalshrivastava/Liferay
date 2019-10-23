package com.sambaash.platform.action;

public interface ServeResourceActionManager {
	ServeResourceActionManager registerResourceActionHandler(String resourceAction, Class<? extends ServeResourceActionHandler> handler);
	ServeResourceActionHandler newHandler(String resourceAction);
}
