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

package com.liferay.saml.util;

import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;

/**
 * @author Mika Koivisto
 */
public class OpenSamlBootstrap extends DefaultBootstrap {

	public static synchronized void bootstrap() throws ConfigurationException {
		if (_initialized) return;
		
		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(
				PortletClassLoaderUtil.getClassLoader());

			initializeXMLSecurity();

			initializeXMLTooling(_xmlToolingConfigs);

			initializeArtifactBuilderFactories();

			initializeGlobalSecurityConfiguration();

			initializeParserPool();

			initializeESAPI();
		}
		finally {
			currentThread.setContextClassLoader(classLoader);
			_initialized = true;
		}
	}

	private static String[] _xmlToolingConfigs = {
		"/default-config.xml", "/encryption-config.xml",
		"/encryption-validation-config.xml", "/saml1-metadata-config.xml",
		"/saml2-assertion-config.xml",
		"/saml2-assertion-delegation-restriction-config.xml",
		"/saml2-core-validation-config.xml", "/saml2-metadata-config.xml",
		"/saml2-metadata-idp-discovery-config.xml",
		"/saml2-metadata-query-config.xml",
		"/saml2-metadata-validation-config.xml", "/saml2-protocol-config.xml",
		"/saml2-protocol-thirdparty-config.xml", "/schema-config.xml",
		"/signature-config.xml", "/signature-validation-config.xml",
		"/soap11-config.xml"
	};
	private static boolean _initialized = false;

}