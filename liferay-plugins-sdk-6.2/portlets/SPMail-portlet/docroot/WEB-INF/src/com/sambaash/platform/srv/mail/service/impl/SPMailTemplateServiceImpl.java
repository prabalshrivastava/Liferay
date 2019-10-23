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

package com.sambaash.platform.srv.mail.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailTemplateServiceBaseImpl;

/**
 * The implementation of the s p mail template remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.mail.service.SPMailTemplateService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.mail.service.base.SPMailTemplateServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailTemplateServiceUtil
 */
public class SPMailTemplateServiceImpl extends SPMailTemplateServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPMailTemplateServiceUtil} to
	 * access the s p mail template remote service.
	 */

	@AccessControlled(guestAccessEnabled = true)
	public SPMailTemplate getTemplateByName(String templateName) throws SystemException {
		return SPMailTemplateLocalServiceUtil.getTemplateByName(templateName);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public SPMailTemplate getTemplateByName(long productTypeId, long subProductTypeId, String templateName) throws SystemException {
		return SPMailTemplateLocalServiceUtil.getTemplateByName(productTypeId, subProductTypeId, templateName);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public void sendAdHocEmaills(String userIdsStr, long templateId) {
		SPMailTemplateLocalServiceUtil.sendAdHocEmaills(userIdsStr, templateId);
	}

}