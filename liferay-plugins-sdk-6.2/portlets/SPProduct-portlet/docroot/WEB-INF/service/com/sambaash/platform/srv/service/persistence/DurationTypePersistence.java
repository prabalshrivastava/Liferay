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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.DurationType;

/**
 * The persistence interface for the duration type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see DurationTypePersistenceImpl
 * @see DurationTypeUtil
 * @generated
 */
public interface DurationTypePersistence extends BasePersistence<DurationType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DurationTypeUtil} to access the duration type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the duration type in the entity cache if it is enabled.
	*
	* @param durationType the duration type
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.DurationType durationType);

	/**
	* Caches the duration types in the entity cache if it is enabled.
	*
	* @param durationTypes the duration types
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.DurationType> durationTypes);

	/**
	* Creates a new duration type with the primary key. Does not add the duration type to the database.
	*
	* @param spDurationTypeId the primary key for the new duration type
	* @return the new duration type
	*/
	public com.sambaash.platform.srv.model.DurationType create(
		long spDurationTypeId);

	/**
	* Removes the duration type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spDurationTypeId the primary key of the duration type
	* @return the duration type that was removed
	* @throws com.sambaash.platform.srv.NoSuchDurationTypeException if a duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.DurationType remove(
		long spDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchDurationTypeException;

	public com.sambaash.platform.srv.model.DurationType updateImpl(
		com.sambaash.platform.srv.model.DurationType durationType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the duration type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchDurationTypeException} if it could not be found.
	*
	* @param spDurationTypeId the primary key of the duration type
	* @return the duration type
	* @throws com.sambaash.platform.srv.NoSuchDurationTypeException if a duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.DurationType findByPrimaryKey(
		long spDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchDurationTypeException;

	/**
	* Returns the duration type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spDurationTypeId the primary key of the duration type
	* @return the duration type, or <code>null</code> if a duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.DurationType fetchByPrimaryKey(
		long spDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the duration types.
	*
	* @return the duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.DurationType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the duration types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.DurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of duration types
	* @param end the upper bound of the range of duration types (not inclusive)
	* @return the range of duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.DurationType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the duration types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.DurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of duration types
	* @param end the upper bound of the range of duration types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.DurationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the duration types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of duration types.
	*
	* @return the number of duration types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}