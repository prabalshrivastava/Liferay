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

import com.sambaash.platform.srv.model.LearningDuration;

/**
 * The persistence interface for the learning duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see LearningDurationPersistenceImpl
 * @see LearningDurationUtil
 * @generated
 */
public interface LearningDurationPersistence extends BasePersistence<LearningDuration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LearningDurationUtil} to access the learning duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the learning duration in the entity cache if it is enabled.
	*
	* @param learningDuration the learning duration
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.LearningDuration learningDuration);

	/**
	* Caches the learning durations in the entity cache if it is enabled.
	*
	* @param learningDurations the learning durations
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.LearningDuration> learningDurations);

	/**
	* Creates a new learning duration with the primary key. Does not add the learning duration to the database.
	*
	* @param spLearningDurationId the primary key for the new learning duration
	* @return the new learning duration
	*/
	public com.sambaash.platform.srv.model.LearningDuration create(
		long spLearningDurationId);

	/**
	* Removes the learning duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLearningDurationId the primary key of the learning duration
	* @return the learning duration that was removed
	* @throws com.sambaash.platform.srv.NoSuchLearningDurationException if a learning duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.LearningDuration remove(
		long spLearningDurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchLearningDurationException;

	public com.sambaash.platform.srv.model.LearningDuration updateImpl(
		com.sambaash.platform.srv.model.LearningDuration learningDuration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the learning duration with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchLearningDurationException} if it could not be found.
	*
	* @param spLearningDurationId the primary key of the learning duration
	* @return the learning duration
	* @throws com.sambaash.platform.srv.NoSuchLearningDurationException if a learning duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.LearningDuration findByPrimaryKey(
		long spLearningDurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchLearningDurationException;

	/**
	* Returns the learning duration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLearningDurationId the primary key of the learning duration
	* @return the learning duration, or <code>null</code> if a learning duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.LearningDuration fetchByPrimaryKey(
		long spLearningDurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the learning durations.
	*
	* @return the learning durations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.LearningDuration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the learning durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learning durations
	* @param end the upper bound of the range of learning durations (not inclusive)
	* @return the range of learning durations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.LearningDuration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the learning durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learning durations
	* @param end the upper bound of the range of learning durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of learning durations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.LearningDuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the learning durations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of learning durations.
	*
	* @return the number of learning durations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}