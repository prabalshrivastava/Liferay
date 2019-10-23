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

/**
 * @author WattabyteIT
 */
public interface SPTemplateFinder {
	public java.util.List getAllTemplates(java.lang.String cur,
		java.lang.String delta);

	public int getAllTemplatesCount();

	public java.util.List getTemplateDetail(long templateId);

	public java.util.List<java.lang.Object> getTemplateDetail(
		java.lang.String templateName);

	public boolean deleteTemplateComponents(long templateId);

	public boolean deleteTemplate(long templateId);
}