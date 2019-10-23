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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.base.SPListTypeLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.SPListTypeUtil;

/**
 * The implementation of the s p list type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPListTypeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPListTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil
 */
public class SPListTypeLocalServiceImpl extends SPListTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil}
	 * to access the s p list type local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SPListTypeLocalServiceImpl.class);

	public List<SPListType> getByKey(String key, long groupId) throws SystemException {

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
				if (spListType != null && spListType.size() != 0) {
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

	public List<SPListType> getSPListTypeByCategoryIdGroupId(long groupId, long categoryId) throws SystemException {
		return spListTypePersistence.findByCategoryIdGroupId(groupId, categoryId);
	}

	public Map<String, SPListType> mapListTypeByItemValue(String key, long groupId) throws SystemException {
		Map<String, SPListType> map = new HashMap<>();
		for (SPListType list : getByKey(key, groupId)) {
			map.put(list.getItemValue(), list);
		}
		return map;
	}

	public SPListType addOrUpdateSPListType(String keyName, String keyValue, int order, long groupId, long categoryId)
			throws SystemException {
		long counter = counterLocalService.increment();

		SPListType spListType = spListTypePersistence.create(counter);
		spListType.setItemKey(keyName);
		spListType.setItemValue(keyValue);
		spListType.setCreateDate(new Date());
		spListType.setGroupId(groupId);
		spListType.setDisplayOrder(order);
		spListType.setCategoryId(categoryId);

		spListTypePersistence.update(spListType);

		SPListTypeLocalUtil.clearSPListTypePool(groupId, keyName);

		return spListType;
	}

	protected String encodeKey(long groupId, java.lang.String name) {
		return String.valueOf(groupId).concat(StringPool.POUND).concat(name);
	}

}