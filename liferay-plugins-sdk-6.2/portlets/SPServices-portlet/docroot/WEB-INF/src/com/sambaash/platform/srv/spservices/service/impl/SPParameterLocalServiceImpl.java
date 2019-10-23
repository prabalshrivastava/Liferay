/**
3 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.base.SPParameterLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.SPParameterUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p parameter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPParameterLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPParameterLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil
 */
public class SPParameterLocalServiceImpl extends SPParameterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil}
	 * to access the s p parameter local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SPParameterLocalServiceImpl.class);

	public SPParameter findBySPParameterGroupIdAndName(long groupId, String name)
			throws SystemException, NoSuchSPParameterException {

		/*
		 * The multiTenantId refers to the company id of the user performing the
		 * request. This was added on the key to fix the issue on multi-tenant
		 * system. Please see VD-50 for details.
		 */
		long multiTenantId = SambaashUtil.getCurrentCompanyId();

		// if multiTenantId is -1, then use the original key implementation
		String key = multiTenantId != -1 ? encodeKey(multiTenantId, groupId, name) : encodeKey(groupId, name);

		Map<String, SPParameter> spParametersPool = multiTenantId != -1 ? SPParameterLocalUtil.getSPParameterPool(key)
				: SPParameterLocalUtil.getSPParameterPool(groupId, name);

		SPParameter spParameters = spParametersPool.get(key);

		if (spParameters == null) {
			String defaultKey = multiTenantId != -1
					? encodeKey(multiTenantId, Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID), name)
					: encodeKey(Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID), name);
			spParameters = spParametersPool.get(defaultKey);

			if (spParameters == null) {
				try {
					spParameters = SPParameterUtil.findBySPParameterGroupIdAndName(groupId, name);
				} catch (NoSuchSPParameterException ne) {
					_log.debug("Parameter by community not found. Trying to get it using default groupId");
				}

				if (spParameters != null) {
					spParametersPool.put(key, spParameters);

				} else {
					try {
						if (groupId != 0) {
							spParameters = SPParameterUtil.findBySPParameterGroupIdAndName(
									Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID), name);
						} else {
							throw new NoSuchSPParameterException("Parameter not found.");
						}

					} catch (NoSuchSPParameterException ne) {
						try {
							spParameters = createSPParamObject(name, groupId);
							if (Validator.isNotNull(spParameters)) {
								spParametersPool.put(defaultKey, spParameters);
							}

						} catch (Exception ee) {
							_log.error("Error while adding new param entry for " + name, ee);
						}
					}
				}
			}
		}

		return (SPParameter) spParameters.clone();

	}

	public SPParameter findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(long groupId, String name)
			throws SystemException, NoSuchSPParameterException {
		SPParameter spParameters = null;
		try {
			spParameters = SPParameterUtil.findBySPParameterGroupIdAndName(groupId, name);

		} catch (NoSuchSPParameterException ne) {
			spParameters = null;
		}

		return spParameters;

	}

	public SPParameter getNewSPParameter() throws SystemException {
		SPParameter spParameters = null;
		try {
			long spParameterId = getNewSpParameterId();
			spParameters = SPParameterLocalServiceUtil.createSPParameter(spParameterId);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return spParameters;
	}

	public void addNewSPParameter(long userId, SPParameter spParameter) throws Exception {
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			Date now = new Date();
			spParameter.setCreateDate(now);
			spParameter.setCompanyId(user.getCompanyId());
			spParameter.setUserId(user.getUserId());
			spParameter.setUserName(user.getFullName());
			spParameter.setNew(true);
			spParameter = spParameterPersistence.update(spParameter);
		} catch (Exception ex) {
			_log.error(ex);
			throw ex;
		}
	}

	private long getNewSpParameterId() throws SystemException {
		long spParameterId = counterLocalService.increment(SPParameter.class.getName());
		return spParameterId;
	}

	private SPParameter createSPParamObject(String name, Long groupId) throws Exception {
		long spParameterId = getNewSpParameterId();
		SPParameter spParam = SPParameterLocalServiceUtil.createSPParameter(spParameterId);
		spParam.setGroupId(groupId);
		spParam.setCategory("Default");
		spParam.setName(name);
		spParam.setDescription(name);
		spParam.setValue(StringPool.BLANK);
		spParam.setCompanyId(PortalUtil.getDefaultCompanyId());
		spParam.setCreateDate(DateUtil.newDate());
		spParam.setModifiedDate(DateUtil.newDate());
		SPParameter spParameter = super.addSPParameter(spParam);
		return spParameter;
	}

	public SPParameter findSPParameterOrAdd(String name, String value, String description, String category,
			Long groupId) {
		SPParameter spParameter = null;
		try {
			spParameter = findBySPParameterGroupIdAndName(groupId, name);
			if (Validator.isNull(spParameter)) {
				long spParameterId = getNewSpParameterId();
				spParameter = SPParameterLocalServiceUtil.createSPParameter(spParameterId);
				spParameter.setGroupId(groupId);
				spParameter.setCategory(Validator.isNull(category) ? "Default" : category);
				spParameter.setName(name);
				spParameter.setDescription(Validator.isNull(description) ? name : description);
				spParameter.setValue(value);
				spParameter.setCompanyId(PortalUtil.getDefaultCompanyId());
				spParameter.setCreateDate(DateUtil.newDate());
				spParameter = getSPParameterPersistence().update(spParameter);
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return spParameter;
	}

	public void updateSPParameter(String paramName, String paramValue) {
		SPParameter spParameter;
		try {
			spParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0, paramName);
			spParameter.setValue(paramValue);
			spParameter.setModifiedDate(DateUtil.newDate());
			updateSPParameter(spParameter);
			SPParameterUtil.clearCache(spParameter);
		} catch (NoSuchSPParameterException e) {
		} catch (SystemException e) {
		}
	}

	public void clearSPParameterPool(long groupId, String name) {
		SPParameterLocalUtil.clearSPParameterPool(groupId, name);
	}

	protected String encodeKey(long groupId, java.lang.String name) {
		return String.valueOf(groupId).concat(StringPool.POUND).concat(name);
	}

	public List<SPParameter> getSPParameterByPrefix(String prefix, int start, int end) throws SystemException {
		return spParameterFinder.findByNamePrefix(prefix, start, end);
	}

	@Override
	public List<Group> getSPParameterGroupIdAndName() {
		return null;
	}

	protected String encodeKey(long companyId, long groupId, java.lang.String name) {
		return String.format("%d#%d#%s", companyId, groupId, name);
	}

}