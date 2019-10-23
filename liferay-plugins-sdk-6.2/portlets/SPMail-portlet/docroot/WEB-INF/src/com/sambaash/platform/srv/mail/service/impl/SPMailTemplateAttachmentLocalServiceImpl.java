/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;
import com.sambaash.platform.srv.mail.service.base.SPMailTemplateAttachmentLocalServiceBaseImpl;

/**
 * The implementation of the s p mail template attachment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailTemplateAttachmentLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalServiceUtil
 */
public class SPMailTemplateAttachmentLocalServiceImpl
	extends SPMailTemplateAttachmentLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalServiceUtil} to access the s p mail template attachment local service.
	 */

	public java.util.List<SPMailTemplateAttachment> findByTemplateId(long templateId)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spMailTemplateAttachmentPersistence.findByTemplateId(templateId);
	}
	
	public java.util.List<SPMailTemplateAttachment> findByfileEntryId(long fileEntryId)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spMailTemplateAttachmentPersistence.findByfileEntryId(fileEntryId);
	}

	public java.util.List<SPMailTemplateAttachment> findByTemplateIdFileEntryId(long templateId, long fileEntryId)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spMailTemplateAttachmentPersistence.findByTemplateIdFileEntryId(templateId, fileEntryId);
	}

}
