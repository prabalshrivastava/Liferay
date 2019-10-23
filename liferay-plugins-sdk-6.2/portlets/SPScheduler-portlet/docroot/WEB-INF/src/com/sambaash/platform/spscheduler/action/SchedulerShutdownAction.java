package com.sambaash.platform.spscheduler.action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.liferay.portal.kernel.events.SimpleAction;
import com.sambaash.platform.spscheduler.impl.SPSchedulerUtil;

/**
 * Needs to be refactored after there is a fix for the issue
 * https://issues.liferay.com/browse/LPS-11613 As of now using the
 * ServletContextListener to handle undeploy events of the portlet. Later need
 * to use the application.shutdown.events extension.
 * 
 * Once its implemented do the below changes
 * 1. Remove 'implements ServletContextListener' for this class
 * 2. Remove 2 methods contextXXX in this class
 * 3. Remove listener declaration in web.xml
 * 4. Add entry in portal.properties for this class with key 'application.shutdown.events'
 */
@WebListener
public class SchedulerShutdownAction extends SimpleAction implements
		ServletContextListener {

	public void run(String[] arg0) {
//		SPSchedulerUtil.shutdown();
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		SPSchedulerUtil.shutdown();
	}

	public void contextInitialized(ServletContextEvent arg0) {

	}

}
