package com.sambaash.platform.spscheduler.impl;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.quartz.Job;
import org.quartz.simpl.CascadingClassLoadHelper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

/**
 * Assumption: entries are in database logger table/ enhance to load from props
 * file or somewhere..
 */
public class SPQuartzClassLoaderHelper extends CascadingClassLoadHelper {

	private static Log logger = LogFactoryUtil
			.getLog(SPQuartzClassLoaderHelper.class);

	private static final List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();

	// TODO
	public ClassLoader getClassLoader() {
		return super.getClassLoader();
	}

	// TODO
	public URL getResource(String name) {
		return super.getResource(name);
	}

	// TODO
	public InputStream getResourceAsStream(String name) {
		return super.getResourceAsStream(name);
	}

	public void initialize() {
		super.initialize();
		List<String> portletIds = SPJobEntryLocalServiceUtil
				.getSavedPortletIds();
		if(portletIds == null) {
			portletIds = new ArrayList();
			portletIds.add("testaction_WAR_testProjportlet");
			portletIds.add("sambaashscheduleraction_WAR_SPServicesportlet");
		}
		for (String portletId : portletIds) {
			ClassLoader classLoader = PortletClassLoaderUtil
					.getClassLoader(portletId);
			if (classLoader != null)
				classLoaders.add(classLoader);
		}
		classLoaders.add(PortalClassLoaderUtil.getClassLoader());
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		try {
			return super.loadClass(name);
		} catch (ClassNotFoundException e) {
			return loadJobClass(name);
		}
	}

	// TODO
	public <T> Class<? extends T> loadClass(String name, Class<T> clazz)
			throws ClassNotFoundException {
		return super.loadClass(name, clazz);
	}

	private Class loadJobClass(String jobClassName) {
		for (Iterator iterator = classLoaders.iterator(); iterator.hasNext();) {
			ClassLoader classLoader = (ClassLoader) iterator.next();
			try {
				return classLoader.loadClass(jobClassName);
			} catch (ClassNotFoundException e) {
			}
		}
		throw new IllegalArgumentException(
				"jobClass could not be loaded..You should never see this in the log!!"
						+ jobClassName);
	}

	@SuppressWarnings({ "rawtypes" })
	public static Class loadJobClass(String jobClassName, String portletId) {
		Class jobClass = null;
		boolean retry = false;
		try {
			ClassLoader classLoader = PortletClassLoaderUtil
					.getClassLoader(portletId);
			jobClass = classLoader.loadClass(jobClassName);

			if (!classLoaders.contains(classLoader)) {
				classLoaders.add(classLoaders.size() - 1, classLoader);
			}

			if (!Job.class.isAssignableFrom(jobClass)) {
				throw new IllegalArgumentException(
						"Invalid jobClass/portletId combination" + jobClassName);
			}
		} catch (IllegalArgumentException e) {
			retry = true;
		} catch (ClassNotFoundException e) {
			retry = true;
		} catch (Exception e) {
			logger.error("Error initializing jobClass "+ e.getMessage());
		} finally {
			if (retry) {
				logger.warn("Couldnt find the class at portlet level, trying at portal level");
				try {
					ClassLoader classLoader = PortalClassLoaderUtil
							.getClassLoader();
					jobClass = classLoader.loadClass(jobClassName);

					if (!Job.class.isAssignableFrom(jobClass)) {
						throw new IllegalArgumentException(
								"Invalid jobClass/portletId combination"
										+ jobClassName);
					}
				} catch (Exception e1) {
					logger.error("Error initializing jobClass", e1);
					throw new IllegalArgumentException(
							"Invalid jobClass/portletId combination"
									+ jobClassName);
				}
			}
		}

		return jobClass;
	}

}
