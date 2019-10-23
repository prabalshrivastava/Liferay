Liferay.Service.register("Liferay.Service.SpInbox", "com.sambaash.platform.portlet.spinbox.srv.service", "SPInbox-portlet");

Liferay.Service.registerClass(
	Liferay.Service.SpInbox, "IBMessage",
	{
		addMessage: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.SpInbox, "IBMessageDetail",
	{
		addMessageDetail: true
	}
);