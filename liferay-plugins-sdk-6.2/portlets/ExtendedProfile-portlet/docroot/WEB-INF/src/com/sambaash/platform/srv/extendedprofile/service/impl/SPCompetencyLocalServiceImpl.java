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
import com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.service.base.SPCompetencyLocalServiceBaseImpl;

/**
 * The implementation of the s p competency local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.extendedprofile.service.base.SPCompetencyLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil
 */
public class SPCompetencyLocalServiceImpl
	extends SPCompetencyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil} to access the s p competency local service.
	 */
	
    public List<SPCompetency> findByCategoryId(
            long userId, long categoryId)
            throws SystemException {
            return spCompetencyPersistence.findByCategoryId(userId, categoryId);
        }

        public List<SPCompetency> findByCategoryId(
            long userId, long categoryId, int start, int end)
            throws SystemException {
            return spCompetencyPersistence.findByCategoryId(userId, categoryId, start, end);
        }

        public List<SPCompetency> findByCategoryId(
            long userId, long categoryId, int start, int end,
           OrderByComparator orderByComparator)
            throws SystemException {
            return spCompetencyPersistence
                    .findByCategoryId(userId, categoryId, start, end,
                orderByComparator);
        }

        public SPCompetency findByCategoryIdAndCompetencyId(
            long userId, long categoryId, long competencyId)
            throws SystemException, NoSuchSPCompetencyException {
            return spCompetencyPersistence
                    .findByCategoryIdAndCompetencyId(userId, categoryId,
                competencyId);
        }

        public List<SPCompetency> findByCompetencyList(
            long userId) throws SystemException {
            return spCompetencyPersistence.findByCompetencyList(userId);
        }

        public List<SPCompetency> findByCompetencyList(
            long userId, int start, int end)
            throws SystemException {
            return spCompetencyPersistence.findByCompetencyList(userId, start, end);
        }

        public List<SPCompetency> findByCompetencyList(
            long userId, int start, int end,
           OrderByComparator orderByComparator)
            throws SystemException {
            return spCompetencyPersistence
                    .findByCompetencyList(userId, start, end, orderByComparator);
        }

        /**
         * NOTE FOR DEVELOPERS:
         *
         * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil} to access the s p competency local service.
         */

        public List<SPCompetency> findByCompetencyListByJobRole(
                long belongsToJobRole) throws SystemException {
            return spCompetencyPersistence.findByCompetencyListByJobRole(belongsToJobRole);
        }
	
	
}