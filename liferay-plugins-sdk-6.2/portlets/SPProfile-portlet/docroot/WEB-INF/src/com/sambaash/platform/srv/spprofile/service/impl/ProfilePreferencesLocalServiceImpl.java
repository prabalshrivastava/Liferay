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

package com.sambaash.platform.srv.spprofile.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;
import com.sambaash.platform.srv.spprofile.model.ProfilePreferences;
import com.sambaash.platform.srv.spprofile.service.base.ProfilePreferencesLocalServiceBaseImpl;

/**
 * The implementation of the profile preferences local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spprofile.service.ProfilePreferencesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.spprofile.service.base.ProfilePreferencesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spprofile.service.ProfilePreferencesLocalServiceUtil
 */
public class ProfilePreferencesLocalServiceImpl
	extends ProfilePreferencesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spprofile.service.ProfilePreferencesLocalServiceUtil} to access the profile preferences local service.
	 */
	
	public List<ProfilePreferences> findBylayOutIdAndPortletId(String layoutId, String portletId) throws NoSuchProfilePreferencesException, SystemException{
		return profilePreferencesPersistence.findBylayOutIdAndPortletId(layoutId, portletId);
	}
	
	public ProfilePreferences findBylayOutIdPreferencesNameAndPortletId(String layoutId, String preferenceName , String portletId) throws NoSuchProfilePreferencesException, SystemException{
		return profilePreferencesPersistence.findBylayOutIdPortletIdAndPreferenceName(layoutId, portletId, preferenceName);
	}

}