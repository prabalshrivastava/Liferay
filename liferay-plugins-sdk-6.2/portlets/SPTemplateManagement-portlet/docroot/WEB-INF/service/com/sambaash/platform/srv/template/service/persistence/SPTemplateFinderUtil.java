/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.template.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author WattabyteIT
 */
public class SPTemplateFinderUtil {
	public static java.util.List getAllTemplates(java.lang.String cur,
		java.lang.String delta) {
		return getFinder().getAllTemplates(cur, delta);
	}

	public static int getAllTemplatesCount() {
		return getFinder().getAllTemplatesCount();
	}

	public static java.util.List getTemplateDetail(long templateId) {
		return getFinder().getTemplateDetail(templateId);
	}

	public static java.util.List<java.lang.Object> getTemplateDetail(
		java.lang.String templateName) {
		return getFinder().getTemplateDetail(templateName);
	}

	public static boolean deleteTemplateComponents(long templateId) {
		return getFinder().deleteTemplateComponents(templateId);
	}

	public static boolean deleteTemplate(long templateId) {
		return getFinder().deleteTemplate(templateId);
	}

	public static SPTemplateFinder getFinder() {
		if (_finder == null) {
			_finder = (SPTemplateFinder)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.template.service.ClpSerializer.getServletContextName(),
					SPTemplateFinder.class.getName());

			ReferenceRegistry.registerReference(SPTemplateFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SPTemplateFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SPTemplateFinderUtil.class,
			"_finder");
	}

	private static SPTemplateFinder _finder;
}