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

package com.sambaash.platform.srv.extendedprofile.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;
import com.sambaash.platform.srv.extendedprofile.model.SPCertification;
import com.sambaash.platform.srv.extendedprofile.service.base.SPCertificationLocalServiceBaseImpl;

/**
 * The implementation of the s p certification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.extendedprofile.service.base.SPCertificationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalServiceUtil
 */
public class SPCertificationLocalServiceImpl
	extends SPCertificationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalServiceUtil} to access the s p certification local service.
	 */
	
    public SPCertification findByUserIdAndCertificationId(
            long userId, long certificationId)
            throws SystemException,
                NoSuchSPCertificationException {
            return spCertificationPersistence
                    .findByUserIdAndCertificationId(userId, certificationId);
        }

        public List<SPCertification> findByUserId(
            long userId) throws SystemException {
            return spCertificationPersistence.findByUserId(userId);
        }

        public List<SPCertification> findByUserId(
            long userId, int start, int end)
            throws SystemException {
            return spCertificationPersistence.findByUserId(userId, start, end);
        }

        public List<SPCertification> findByUserId(
            long userId, int start, int end,
            OrderByComparator orderByComparator)
            throws SystemException {
            return spCertificationPersistence
                    .findByUserId(userId, start, end, orderByComparator);
        }
	
}