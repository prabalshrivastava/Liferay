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

import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.ac.AccessControlled;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.base.SPListTypeServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.SPListTypeUtil;

/**
 * The implementation of the s p list type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPListTypeService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPListTypeServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPListTypeServiceUtil
 */
public class SPListTypeServiceImpl extends SPListTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spservices.service.SPListTypeServiceUtil} to
	 * access the s p list type remote service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SPListTypeServiceImpl.class);

	@AccessControlled(guestAccessEnabled = true)
	public List<SPListType> getListByKey(String key, long groupId) throws SystemException {

		Map<String, List<SPListType>> spListTypePool = SPListTypeLocalUtil.getSPListTypePool(groupId, key);

		String keyName = encodeKey(groupId, key);

		List<SPListType> spListType = spListTypePool.get(keyName);
		if (spListType == null) {
			String defaultKey = encodeKey(Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID), key);
			spListType = spListTypePool.get(defaultKey);
			if (spListType == null) {
				try {
					spListType = SPListTypeUtil.findByItemKeys(key, groupId);
				} catch (SystemException ne) {
					_log.debug("ListType by community not found. Trying to get it using default groupId");
				}
				if (spListType != null && !spListType.isEmpty()) {
					spListTypePool.put(keyName, spListType);
				} else {
					spListType = SPListTypeUtil.findByItemKeys(key, Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID));
					if (spListType != null) {
						spListTypePool.put(keyName, spListType);
					}
				}
			}
		}

		return spListType;
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<SPListType> getSPListTypeByCategoryIdGroupId(long groupId, long categoryId) throws SystemException {
		return spListTypeLocalService.getSPListTypeByCategoryIdGroupId(groupId, categoryId);
	}

	protected String encodeKey(long groupId, java.lang.String name) {
		return String.valueOf(groupId).concat(StringPool.POUND).concat(name);
	}

}