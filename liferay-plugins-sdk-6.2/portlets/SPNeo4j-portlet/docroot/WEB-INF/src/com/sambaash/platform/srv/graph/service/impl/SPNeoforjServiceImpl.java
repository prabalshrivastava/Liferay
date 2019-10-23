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

package com.sambaash.platform.srv.graph.service.impl;

import com.sambaash.platform.model.spneo4j.form.JoinGraphForm;
import com.sambaash.platform.srv.graph.service.base.SPNeoforjServiceBaseImpl;

/**
 * The implementation of the s p neoforj remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spneo4j.service.SPNeoforjService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Clark
 * @see com.sambaash.platform.srv.spneo4j.service.base.SPNeoforjServiceBaseImpl
 * @see com.sambaash.platform.srv.spneo4j.service.SPNeoforjServiceUtil
 */
public class SPNeoforjServiceImpl extends SPNeoforjServiceBaseImpl {
	
	public String follow(Long companyId, Long groupId, Long layoutSetId, String action, long startUserId, String endEntityClassName,
			long endEntityId) {
		return spNeoforjLocalService.follow(companyId, groupId, layoutSetId, action, startUserId, endEntityClassName, endEntityId);
	}

	public boolean isFollowing(Long companyId, Long groupId, Long layoutSetId, long startUserId, String endEntityClassName, long endEntityId) {
		return spNeoforjLocalService.isFollowing(companyId, groupId, layoutSetId, startUserId, endEntityClassName, endEntityId);
	}

	public String like(Long companyId, Long groupId, Long layoutSetId, String action, long startUserId, String endEntityClassName,
			long endEntityId) {
		return spNeoforjLocalService.like(companyId, groupId, layoutSetId, action, startUserId, endEntityClassName, endEntityId);
	}

	public boolean isLiking(Long companyId, Long groupId, Long layoutSetId, long startUserId, String endEntityClassName, long endEntityId) {
		return spNeoforjLocalService.isLiking(companyId, groupId, layoutSetId, startUserId, endEntityClassName, endEntityId);
	}

	public int findUsersWhoLikeCount(Long companyId, Long groupId, Long layoutSetId, String endEntityClassName, Long endEntityId) {
		return spNeoforjLocalService.findUsersWhoLikeCount(companyId, groupId, layoutSetId, endEntityClassName, endEntityId);
	}

	public String join(String action, long startUserId, String endEntityClassName,
			long endEntityClassPK, int type, int status, Long companyId, Long groupId, Long layoutSetId) {
		return spNeoforjLocalService.join(action, startUserId, endEntityClassName, endEntityClassPK, type, status, companyId, groupId, layoutSetId);
	}

	public boolean isJoined(Long companyId, Long groupId, Long layoutSetId, long startUserId, String endEntityClassName, long endEntityClassPK) {
		return spNeoforjLocalService.isJoined(companyId, groupId, layoutSetId, startUserId, endEntityClassName, endEntityClassPK);
	}

	public String updateJoinGraph(JoinGraphForm joinGraphForm) {
		return spNeoforjLocalService.updateJoinGraph(joinGraphForm);
	}
	
}