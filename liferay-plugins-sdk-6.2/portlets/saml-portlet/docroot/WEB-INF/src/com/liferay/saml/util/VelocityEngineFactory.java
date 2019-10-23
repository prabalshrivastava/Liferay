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
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * @author Mika Koivisto
 */
public class VelocityEngineFactory {

	public static VelocityEngine getVelocityEngine() {
		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(
				PortletClassLoaderUtil.getClassLoader());

			VelocityEngine velocityEngine = new VelocityEngine();

			velocityEngine.setProperty(
				RuntimeConstants.ENCODING_DEFAULT, StringPool.UTF8);
			velocityEngine.setProperty(
				RuntimeConstants.OUTPUT_ENCODING, StringPool.UTF8);
			velocityEngine.setProperty(
				RuntimeConstants.RESOURCE_LOADER, "classpath");
			velocityEngine.setProperty(
				RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
				PropsUtil.get(PropsKeys.VELOCITY_ENGINE_LOGGER));
			velocityEngine.setProperty(
				RuntimeConstants.RUNTIME_LOG_LOGSYSTEM + ".log4j.category",
				PropsUtil.get(PropsKeys.VELOCITY_ENGINE_LOGGER_CATEGORY));
			velocityEngine.setProperty(
				"classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());

			velocityEngine.init();

			return velocityEngine;
		}
		catch (Exception e) {
			throw new RuntimeException(
				"Unable to initialize velocity engine", e);
		}
		finally {
			currentThread.setContextClassLoader(classLoader);
		}
	}

}