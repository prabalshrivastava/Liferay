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

package com.sambaash.platform.srv.spvoting.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.spvoting.AlreadyVotedException;
import com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;
import com.sambaash.platform.srv.spvoting.model.SPVoting;
import com.sambaash.platform.srv.spvoting.service.base.SPVotingLocalServiceBaseImpl;

/**
 * The implementation of the s p voting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link service.SPVotingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see service.base.SPVotingLocalServiceBaseImpl
 * @see service.SPVotingLocalServiceUtil
 */
public class SPVotingLocalServiceImpl extends SPVotingLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link service.SPVotingLocalServiceUtil} to access the s p voting local
	 * service.
	 */
	public void testVoting(String msg) {
		
	}

	public void voteUp(String className, long classPK, long userId, String ip,
			boolean isSignedIn) throws PortalException, SystemException {
		SPVoting voting = null;
		try {
			if (isSignedIn) {
				voting = spVotingPersistence.findByEntryAndUserId(className,
						classPK, userId);
			} else {
				voting = spVotingPersistence.findByEntryAndIp(className,
						classPK, ip);
			}

			throw new AlreadyVotedException();

		} catch (NoSuchSPVotingException nsve) {
			long votingId = counterLocalService.increment(SPVoting.class
					.getName());
			voting = spVotingPersistence.create(votingId);

			voting.setClassName(className);
			voting.setClassPK(classPK);

			if (isSignedIn) {
				voting.setUserId(userId);
			} else {
				voting.setIp(ip);
			}

			voting.setCreateDate(new Date());
			spVotingPersistence.update(voting);
		}
	}

	public List<SPVoting> findByEntry(String className, long classPK)
			throws SystemException {
		return spVotingPersistence.findByEntry(className, classPK);
	}

	public SPVoting findByEntryAndUserId(String className, long classPK,
			long userId) throws SystemException, NoSuchSPVotingException {
		return spVotingPersistence.findByEntryAndUserId(className, classPK,
				userId);
	}

	public SPVoting findByEntryAndIp(String className, long classPK, String ip)
			throws SystemException, NoSuchSPVotingException {
		return spVotingPersistence.findByEntryAndIp(className, classPK, ip);
	}

	public int countByEntry(String className, long classPK)
			throws SystemException {
		return spVotingPersistence.countByEntry(className, classPK);
	}

	public int countByEntryAndUserId(String className, long classPK, long userId)
			throws SystemException {
		return spVotingPersistence.countByEntryAndUserId(className, classPK,
				userId);
	}

	public int countByEntryAndIp(String className, long classPK, String ip)
			throws SystemException {
		return spVotingPersistence.countByEntryAndIp(className, classPK, ip);
	}
}