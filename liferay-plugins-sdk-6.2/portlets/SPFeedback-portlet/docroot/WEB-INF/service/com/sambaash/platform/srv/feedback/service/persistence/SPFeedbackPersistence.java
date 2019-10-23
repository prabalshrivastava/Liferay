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

package com.sambaash.platform.srv.feedback.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.feedback.model.SPFeedback;

/**
 * The persistence interface for the s p feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPFeedbackPersistenceImpl
 * @see SPFeedbackUtil
 * @generated
 */
public interface SPFeedbackPersistence extends BasePersistence<SPFeedback> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPFeedbackUtil} to access the s p feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s p feedback in the entity cache if it is enabled.
	*
	* @param spFeedback the s p feedback
	*/
	public void cacheResult(
		com.sambaash.platform.srv.feedback.model.SPFeedback spFeedback);

	/**
	* Caches the s p feedbacks in the entity cache if it is enabled.
	*
	* @param spFeedbacks the s p feedbacks
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.feedback.model.SPFeedback> spFeedbacks);

	/**
	* Creates a new s p feedback with the primary key. Does not add the s p feedback to the database.
	*
	* @param spFeedbackId the primary key for the new s p feedback
	* @return the new s p feedback
	*/
	public com.sambaash.platform.srv.feedback.model.SPFeedback create(
		long spFeedbackId);

	/**
	* Removes the s p feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFeedbackId the primary key of the s p feedback
	* @return the s p feedback that was removed
	* @throws com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException if a s p feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.feedback.model.SPFeedback remove(
		long spFeedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException;

	public com.sambaash.platform.srv.feedback.model.SPFeedback updateImpl(
		com.sambaash.platform.srv.feedback.model.SPFeedback spFeedback)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p feedback with the primary key or throws a {@link com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException} if it could not be found.
	*
	* @param spFeedbackId the primary key of the s p feedback
	* @return the s p feedback
	* @throws com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException if a s p feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.feedback.model.SPFeedback findByPrimaryKey(
		long spFeedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException;

	/**
	* Returns the s p feedback with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spFeedbackId the primary key of the s p feedback
	* @return the s p feedback, or <code>null</code> if a s p feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.feedback.model.SPFeedback fetchByPrimaryKey(
		long spFeedbackId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p feedbacks.
	*
	* @return the s p feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.feedback.model.SPFeedback> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p feedbacks
	* @param end the upper bound of the range of s p feedbacks (not inclusive)
	* @return the range of s p feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.feedback.model.SPFeedback> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p feedbacks
	* @param end the upper bound of the range of s p feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.feedback.model.SPFeedback> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p feedbacks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p feedbacks.
	*
	* @return the number of s p feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}