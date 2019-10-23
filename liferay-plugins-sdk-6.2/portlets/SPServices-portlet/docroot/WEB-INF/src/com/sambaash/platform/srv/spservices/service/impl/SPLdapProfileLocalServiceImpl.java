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

package com.sambaash.platform.srv.spservices.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.spservices.model.SPLdapProfile;
import com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.base.SPLdapProfileLocalServiceBaseImpl;

/**
 * The implementation of the s p ldap profile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPLdapProfileLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalServiceUtil
 */
public class SPLdapProfileLocalServiceImpl extends
		SPLdapProfileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.SPLdapProfileLocalServiceUtil} to access the s p
	 * ldap profile local service.
	 */

	private static Log _log = LogFactoryUtil
			.getLog(SPLdapProfileLocalServiceImpl.class);

	public SPLdapProfile getNewSPLdapProfile() throws SystemException {
		SPLdapProfile wsnLdapProfile = null;
		try {
			long spLdapProfileId = counterLocalService
					.increment("SPLdapProfile.class");
			wsnLdapProfile = SPLdapProfileLocalServiceUtil
					.createSPLdapProfile(spLdapProfileId);
			wsnLdapProfile.setNew(true);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return wsnLdapProfile;
	}

	public SPLdapProfile findByUserId(long userId) {
		SPLdapProfile profile = null;
		try {
			profile = spLdapProfilePersistence.findByUserId(userId);
		} catch (Exception e) {
			_log.error("SP Ldap Profile not found for userId : " + userId);
		}
		return profile;
	}

}