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

package com.sambaash.platform.srv.sharing.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.sharing.NoSuchSPSharingException;
import com.sambaash.platform.srv.sharing.model.SPSharing;
import com.sambaash.platform.srv.sharing.service.base.SPSharingLocalServiceBaseImpl;

/**
 * The implementation of the s p sharing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.sharing.service.SPSharingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.sharing.service.base.SPSharingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sharing.service.SPSharingLocalServiceUtil
 */
public class SPSharingLocalServiceImpl extends SPSharingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.sharing.service.SPSharingLocalServiceUtil} to access the s p sharing local service.
	 */


	

    
    public SPSharing getSharing(long userId, long classNameId, long classPK) throws NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByUserIdClassNameIdAndClassPK(userId, classNameId, classPK);
	}
	
	public SPSharing getSharing(long userId, long classNameId, long classPK, boolean internalShare) throws NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByUserIdClassNameIdClassPKAndShareType(userId, classNameId, classPK,internalShare);
	}
	
	public List<SPSharing> getSharing(long classPK, long classNameId) throws NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByClassPKAndClassNameId(classPK, classNameId);
	}
	
	public SPSharing getSharing(String emailAddress, long classNameId, long classPK,
			boolean internalShare) throws NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByEmailClassNameIdClassPKAndShareType(emailAddress, classNameId, classPK,internalShare);
	}
	
	public List<SPSharing> getFileSharing(long createdBy, long classPK, long classNameId)
			throws SystemException{
		return spSharingPersistence.findByCreatedByClassPKAndClassNameId(createdBy,classPK,classNameId);
	}
	
	public List<SPSharing> getUserSharings(long userId, Date date) throws NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByUserIdDatesExpired(userId, date, date);
	}
	
	public List<SPSharing> getUserSharedFiles(long userId, Date date) throws  NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByCreatedByDatesExpired(userId, date, date);
	}
	
	public List<SPSharing> getUserSharedFiles(long userId, Date date, int start, int end) throws  NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByCreatedByDatesExpired(userId, date, date, start, end);
	}
	
	public List<SPSharing> getUserSharingByEmail(String emailAddress) throws NoSuchSPSharingException, SystemException {
		return spSharingPersistence.findByEmail(emailAddress);
	}

}