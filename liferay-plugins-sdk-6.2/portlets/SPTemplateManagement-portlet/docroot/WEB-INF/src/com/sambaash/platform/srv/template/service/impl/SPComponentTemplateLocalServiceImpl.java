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

package com.sambaash.platform.srv.template.service.impl;

import com.sambaash.platform.srv.template.service.base.SPComponentTemplateLocalServiceBaseImpl;
import com.sambaash.platform.srv.template.service.persistence.SPComponentTemplateUtil;

/**
 * The implementation of the s p component template local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.template.service.SPComponentTemplateLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author WattabyteIT
 * @see com.sambaash.platform.srv.template.service.base.SPComponentTemplateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.template.service.SPComponentTemplateLocalServiceUtil
 */
public class SPComponentTemplateLocalServiceImpl extends SPComponentTemplateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.template.service.
	 * SPComponentTemplateLocalServiceUtil} to access the s p component template
	 * local service.
	 */

	public void deleteTemplateComponentsByTemplateId(long spTemplateId) {
		try {
			SPComponentTemplateUtil.removeByTemplateId(spTemplateId);
		} catch (Exception ex) {
			// log your exception
		}
	}

}