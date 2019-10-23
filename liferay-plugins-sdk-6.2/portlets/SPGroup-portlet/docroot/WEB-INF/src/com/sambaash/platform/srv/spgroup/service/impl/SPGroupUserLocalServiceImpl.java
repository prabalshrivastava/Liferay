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

package com.sambaash.platform.srv.spgroup.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sambaash.platform.srv.spgroup.NoSuchUserException;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.base.SPGroupUserLocalServiceBaseImpl;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK;

/**
 * The implementation of the s p group user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SPGroupUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.service.base.SPGroupUserLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SPGroupUserLocalServiceUtil
 */
public class SPGroupUserLocalServiceImpl extends
		SPGroupUserLocalServiceBaseImpl {
	public SPGroupUser addSPGroupUser(long spGroupId, long userId, int role,
			int status,Long groupId, Long companyId) throws PortalException, SystemException {

		Date now = new Date();

		SPGroupUser spGroupUser = spGroupUserPersistence
				.create(new SPGroupUserPK(spGroupId, userId));
		spGroupUser.setJoinDate(now);
		spGroupUser.setRole(role);
		spGroupUser.setStatus(status);
		spGroupUser.setGroupId(groupId);
		spGroupUser.setCompanyId(companyId);
		spGroupUser.setCreateDate(now);
		spGroupUser.setModifiedDate(now);
		
		spGroupUserPersistence.update(spGroupUser);

		return spGroupUser;
	}

	public int countBySPGroupId(long spGroupId) throws SystemException {
		return spGroupUserPersistence.countBySPGroupId(spGroupId);
	}

	public int countBySPGroupIdAndRole(long spGroupId, int role)
			throws SystemException {
		return spGroupUserPersistence.countBySPGroupIdAndRole(spGroupId, role);
	}

	public int countBySPGroupIdAndStatus(long spGroupId, int status)
			throws SystemException {
		return spGroupUserPersistence.countBySPGroupIdAndStatus(spGroupId,
				status);
	}

	public int countByUserId(long userId) throws SystemException {
		return spGroupUserPersistence.countByUserId(userId);
	}

	public int countByUserIdAndGroupIdAndStatus(long userId, long spGroupId,
			int status) throws SystemException {
		return spGroupUserPersistence.countByUserIdAndGroupIdAndStatus(userId,
				spGroupId, status);
	}

	public int countByUserIdAndStatus(long userId, int status)
			throws SystemException {
		return spGroupUserPersistence.countByUserIdAndStatus(userId, status);
	}

	public void deleteSPGroupUser(long spGroupId, long userId)
			throws PortalException, SystemException {
		spGroupUserPersistence.remove(new SPGroupUserPK(spGroupId, userId));
	}

	public SPGroupUser fetchByUserIdAndGroupIdAndStatus(long userId,
			long spGroupId, int status) throws SystemException {
		return spGroupUserPersistence.fetchByUserIdAndGroupIdAndStatus(userId,
				spGroupId, status);
	}

	public SPGroupUser fetchByUserIdAndGroupIdAndStatus(long userId,
			long spGroupId, int status, boolean retrieveFromCache)
			throws SystemException {
		return spGroupUserPersistence.fetchByUserIdAndGroupIdAndStatus(userId,
				spGroupId, status, retrieveFromCache);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SPGroupUserLocalServiceUtil} to
	 * access the s p group user local service.
	 */

	public List<SPGroupUser> findBySPGroupId(long spGroupId)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupId(spGroupId);
	}

	public List<SPGroupUser> findBySPGroupId(long spGroupId, int start, int end)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupId(spGroupId, start, end);
	}

	public List<SPGroupUser> findBySPGroupId(long spGroupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupId(spGroupId, start, end,
				orderByComparator);
	}

	public SPGroupUser findBySPGroupId_First(long spGroupId,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findBySPGroupId_First(spGroupId,
				orderByComparator);
	}

	public SPGroupUser findBySPGroupId_Last(long spGroupId,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findBySPGroupId_Last(spGroupId,
				orderByComparator);
	}

	public SPGroupUser[] findBySPGroupId_PrevAndNext(
			SPGroupUserPK spGroupUserPK, long spGroupId,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findBySPGroupId_PrevAndNext(
				spGroupUserPK, spGroupId, orderByComparator);
	}

	public List<SPGroupUser> findBySPGroupIdAndRole(long spGroupId, int role)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupIdAndRole(spGroupId, role);
	}

	public List<SPGroupUser> findBySPGroupIdAndRole(long spGroupId, int role,
			int start, int end) throws SystemException {
		return spGroupUserPersistence.findBySPGroupIdAndRole(spGroupId, role,
				start, end);
	}

	public List<SPGroupUser> findBySPGroupIdAndRole(long spGroupId, int role,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupIdAndRole(spGroupId, role,
				start, end, orderByComparator);
	}

	public List<SPGroupUser> findBySPGroupIdAndStatus(long spGroupId, int status)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupIdAndStatus(spGroupId,
				status);
	}

	public List<SPGroupUser> findBySPGroupIdAndStatus(long spGroupId,
			int status, int start, int end) throws SystemException {
		return spGroupUserPersistence.findBySPGroupIdAndStatus(spGroupId,
				status, start, end);
	}

	public List<SPGroupUser> findBySPGroupIdAndStatus(long spGroupId,
			int status, int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return spGroupUserPersistence.findBySPGroupIdAndStatus(spGroupId,
				status, start, end, orderByComparator);
	}

	public SPGroupUser findBySPGroupIdAndStatus_First(long spGroupId,
			int status, OrderByComparator orderByComparator)
			throws SystemException, NoSuchUserException {
		return spGroupUserPersistence.findBySPGroupIdAndStatus_First(spGroupId,
				status, orderByComparator);
	}

	public SPGroupUser findBySPGroupIdAndStatus_Last(long spGroupId,
			int status, OrderByComparator orderByComparator)
			throws SystemException, NoSuchUserException {
		return spGroupUserPersistence.findBySPGroupIdAndStatus_Last(spGroupId,
				status, orderByComparator);
	}

	public SPGroupUser[] findBySPGroupIdAndStatus_PrevAndNext(
			SPGroupUserPK spGroupUserPK, long spGroupId, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findBySPGroupIdAndStatus_PrevAndNext(
				spGroupUserPK, spGroupId, status, orderByComparator);
	}

	public List<SPGroupUser> findByUserId(long userId) throws SystemException {
		return spGroupUserPersistence.findByUserId(userId);
	}

	public List<SPGroupUser> findByUserId(long userId, int start, int end)
			throws SystemException {
		return spGroupUserPersistence.findByUserId(userId, start, end);
	}

	public List<SPGroupUser> findByUserId(long userId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return spGroupUserPersistence.findByUserId(userId, start, end,
				orderByComparator);
	}

	public SPGroupUser findByUserId_First(long userId,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findByUserId_First(userId,
				orderByComparator);
	}

	public SPGroupUser findByUserId_Last(long userId,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findByUserId_Last(userId,
				orderByComparator);
	}

	public SPGroupUser[] findByUserId_PrevAndNext(SPGroupUserPK spGroupUserPK,
			long userId, OrderByComparator orderByComparator)
			throws SystemException, NoSuchUserException {
		return spGroupUserPersistence.findByUserId_PrevAndNext(spGroupUserPK,
				userId, orderByComparator);
	}

	public SPGroupUser findByUserIdAndGroupIdAndStatus(long userId,
			long spGroupId, int status) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findByUserIdAndGroupIdAndStatus(userId,
				spGroupId, status);
	}

	public List<SPGroupUser> findByUserIdAndStatus(long userId, int status)
			throws SystemException {
		return spGroupUserPersistence.findByUserIdAndStatus(userId, status);
	}

	public List<SPGroupUser> findByUserIdAndStatus(long userId, int status,
			int start, int end) throws SystemException {
		return spGroupUserPersistence.findByUserIdAndStatus(userId, status,
				start, end);
	}

	public List<SPGroupUser> findByUserIdAndStatus(long userId, int status,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return spGroupUserPersistence.findByUserIdAndStatus(userId, status,
				start, end, orderByComparator);
	}

	public SPGroupUser findByUserIdAndStatus_First(long userId, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findByUserIdAndStatus_First(userId,
				status, orderByComparator);
	}

	public SPGroupUser findByUserIdAndStatus_Last(long userId, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findByUserIdAndStatus_Last(userId,
				status, orderByComparator);
	}

	public SPGroupUser[] findByUserIdAndStatus_PrevAndNext(
			SPGroupUserPK spGroupUserPK, long userId, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchUserException {
		return spGroupUserPersistence.findByUserIdAndStatus_PrevAndNext(
				spGroupUserPK, userId, status, orderByComparator);
	}

	public SPGroupUser updateSPGroupUser(long spGroupId, long userId, int role,
			int status) throws PortalException, SystemException {

		SPGroupUser spGroupUser = spGroupUserPersistence
				.findByPrimaryKey(new SPGroupUserPK(spGroupId, userId));
		spGroupUser.setRole(role);
		spGroupUser.setStatus(status);
		spGroupUser.setModifiedDate(new Date());

		spGroupUserPersistence.update(spGroupUser);

		return spGroupUser;
	}

	public SPGroupUser updateSPGroupUserRole(long spGroupId, long userId,
			int role) throws PortalException, SystemException {

		SPGroupUser spGroupUser = spGroupUserPersistence
				.findByPrimaryKey(new SPGroupUserPK(spGroupId, userId));
		spGroupUser.setRole(role);
		spGroupUser.setModifiedDate(new Date());
		
		spGroupUserPersistence.update(spGroupUser);

		return spGroupUser;
	}

	public SPGroupUser updateSPGroupUserStatus(long spGroupId, long userId,
			int status) throws PortalException, SystemException {

		SPGroupUser spGroupUser = spGroupUserPersistence
				.findByPrimaryKey(new SPGroupUserPK(spGroupId, userId));
		spGroupUser.setStatus(status);
		spGroupUser.setModifiedDate(new Date());
		
		spGroupUserPersistence.update(spGroupUser);

		return spGroupUser;
	}

}