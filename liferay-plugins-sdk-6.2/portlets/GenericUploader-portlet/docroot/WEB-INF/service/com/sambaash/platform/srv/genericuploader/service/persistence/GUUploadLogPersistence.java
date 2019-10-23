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

package com.sambaash.platform.srv.genericuploader.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;

/**
 * The persistence interface for the g u upload log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see GUUploadLogPersistenceImpl
 * @see GUUploadLogUtil
 * @generated
 */
public interface GUUploadLogPersistence extends BasePersistence<GUUploadLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GUUploadLogUtil} to access the g u upload log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the g u upload log in the entity cache if it is enabled.
	*
	* @param guUploadLog the g u upload log
	*/
	public void cacheResult(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog);

	/**
	* Caches the g u upload logs in the entity cache if it is enabled.
	*
	* @param guUploadLogs the g u upload logs
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> guUploadLogs);

	/**
	* Creates a new g u upload log with the primary key. Does not add the g u upload log to the database.
	*
	* @param SPGUUploadLogId the primary key for the new g u upload log
	* @return the new g u upload log
	*/
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog create(
		long SPGUUploadLogId);

	/**
	* Removes the g u upload log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPGUUploadLogId the primary key of the g u upload log
	* @return the g u upload log that was removed
	* @throws com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException if a g u upload log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog remove(
		long SPGUUploadLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException;

	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog updateImpl(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g u upload log with the primary key or throws a {@link com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException} if it could not be found.
	*
	* @param SPGUUploadLogId the primary key of the g u upload log
	* @return the g u upload log
	* @throws com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException if a g u upload log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog findByPrimaryKey(
		long SPGUUploadLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException;

	/**
	* Returns the g u upload log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SPGUUploadLogId the primary key of the g u upload log
	* @return the g u upload log, or <code>null</code> if a g u upload log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog fetchByPrimaryKey(
		long SPGUUploadLogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g u upload logs.
	*
	* @return the g u upload logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g u upload logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g u upload logs
	* @param end the upper bound of the range of g u upload logs (not inclusive)
	* @return the range of g u upload logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g u upload logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g u upload logs
	* @param end the upper bound of the range of g u upload logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g u upload logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g u upload logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g u upload logs.
	*
	* @return the number of g u upload logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}