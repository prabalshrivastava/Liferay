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
import com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException;
import com.sambaash.platform.srv.spservices.model.SPLdapMapping;
import com.sambaash.platform.srv.spservices.service.base.SPLdapMappingLocalServiceBaseImpl;

/**
 * The implementation of the s p ldap mapping local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPLdapMappingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalServiceUtil
 */
public class SPLdapMappingLocalServiceImpl extends
		SPLdapMappingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.SPLdapMappingLocalServiceUtil} to access the s p
	 * ldap mapping local service.
	 */

	private static Log _log = LogFactoryUtil
			.getLog(SPLdapMappingLocalServiceImpl.class);

	public SPLdapMapping getEsnLdapMapping(String country, String department,
			String company) throws NoSuchSPLdapMappingException,
			SystemException {
		return spLdapMappingPersistence.findByCountryDepartmentAndLegalEntity(
				country, department, company);
	}

	public SPLdapMapping findByCountryDepartmentAndLegalEntity(String country,
			String department, String company) {
		SPLdapMapping maping = null;
		try {
			maping = spLdapMappingPersistence
					.findByCountryDepartmentAndLegalEntity(country, department,
							company);
		} catch (Exception ex) {
			_log.error(ex.getMessage(), ex);
		}
		return maping;
	}

}