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

package com.sambaash.platform.ato.service.impl;

import com.sambaash.platform.ato.service.base.SPATOAdmissionServiceBaseImpl;
import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the s p a t o admission remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.ato.service.SPATOAdmissionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author keyur.kalariya
 * @see com.sambaash.platform.ato.service.base.SPATOAdmissionServiceBaseImpl
 * @see com.sambaash.platform.ato.service.SPATOAdmissionServiceUtil
 */
public class SPATOAdmissionServiceImpl extends SPATOAdmissionServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.ato.service.SPATOAdmissionServiceUtil} to access the s p a t o admission remote service.
	 */
	@AccessControlled(guestAccessEnabled = true)
	public String sendInvoiceToCandidate(long companyId, String storageIds) throws PortalException, SystemException {
		String response = SPATOAdmissionLocalServiceUtil.sendInvoiceToCantidate(1,companyId,storageIds);
	return response;
	}
}
