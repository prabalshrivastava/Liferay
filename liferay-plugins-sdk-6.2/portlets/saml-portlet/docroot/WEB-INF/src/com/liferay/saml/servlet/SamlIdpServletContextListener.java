/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.servlet;

import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.saml.util.OpenSamlBootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Brian Wing Shun Chan
 */
public class SamlIdpServletContextListener
	extends BasePortalLifecycle implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		portalDestroy();
	}


	public void contextInitialized(ServletContextEvent servletContextEvent) {
		registerPortalLifecycle();
	}


	protected void doPortalDestroy() throws Exception {
	}


	protected void doPortalInit() throws Exception {
		initOpenSaml();
	}

	protected void initOpenSaml() throws Exception {
		OpenSamlBootstrap.bootstrap();
	}

}