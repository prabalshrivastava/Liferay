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

package com.sambaash.platform.srv.processbuilder.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.processbuilder.model.PESupervisor;

/**
 * The persistence interface for the p e supervisor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PESupervisorPersistenceImpl
 * @see PESupervisorUtil
 * @generated
 */
public interface PESupervisorPersistence extends BasePersistence<PESupervisor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PESupervisorUtil} to access the p e supervisor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the p e supervisor in the entity cache if it is enabled.
	*
	* @param peSupervisor the p e supervisor
	*/
	public void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor);

	/**
	* Caches the p e supervisors in the entity cache if it is enabled.
	*
	* @param peSupervisors the p e supervisors
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> peSupervisors);

	/**
	* Creates a new p e supervisor with the primary key. Does not add the p e supervisor to the database.
	*
	* @param spPESupervisorId the primary key for the new p e supervisor
	* @return the new p e supervisor
	*/
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor create(
		long spPESupervisorId);

	/**
	* Removes the p e supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor remove(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException;

	public com.sambaash.platform.srv.processbuilder.model.PESupervisor updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e supervisor with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException} if it could not be found.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor findByPrimaryKey(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException;

	/**
	* Returns the p e supervisor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor, or <code>null</code> if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor fetchByPrimaryKey(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e supervisors.
	*
	* @return the p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e supervisors
	* @param end the upper bound of the range of p e supervisors (not inclusive)
	* @return the range of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e supervisors
	* @param end the upper bound of the range of p e supervisors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e supervisors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e supervisors.
	*
	* @return the number of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}