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

package com.sambaash.platform.srv.spdynamicforms.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;

/**
 * The persistence interface for the s p form storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author glenn
 * @see SPFormStoragePersistenceImpl
 * @see SPFormStorageUtil
 * @generated
 */
public interface SPFormStoragePersistence extends BasePersistence<SPFormStorage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPFormStorageUtil} to access the s p form storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s p form storage in the entity cache if it is enabled.
	*
	* @param spFormStorage the s p form storage
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage);

	/**
	* Caches the s p form storages in the entity cache if it is enabled.
	*
	* @param spFormStorages the s p form storages
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> spFormStorages);

	/**
	* Creates a new s p form storage with the primary key. Does not add the s p form storage to the database.
	*
	* @param formStorageId the primary key for the new s p form storage
	* @return the new s p form storage
	*/
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage create(
		long formStorageId);

	/**
	* Removes the s p form storage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage that was removed
	* @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage remove(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException;

	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage updateImpl(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p form storage with the primary key or throws a {@link com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException} if it could not be found.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage
	* @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage findByPrimaryKey(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException;

	/**
	* Returns the s p form storage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage, or <code>null</code> if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage fetchByPrimaryKey(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p form storages.
	*
	* @return the s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p form storages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p form storages
	* @param end the upper bound of the range of s p form storages (not inclusive)
	* @return the range of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p form storages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p form storages
	* @param end the upper bound of the range of s p form storages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p form storages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p form storages.
	*
	* @return the number of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}