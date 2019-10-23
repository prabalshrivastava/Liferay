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

import com.sambaash.platform.srv.model.StudyOption;

/**
 * The persistence interface for the study option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudyOptionPersistenceImpl
 * @see StudyOptionUtil
 * @generated
 */
public interface StudyOptionPersistence extends BasePersistence<StudyOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudyOptionUtil} to access the study option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the study options where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the matching study options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the study options where spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @return the range of matching study options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the study options where spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching study options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption findByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException;

	/**
	* Returns the first study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching study option, or <code>null</code> if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption fetchByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption findByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException;

	/**
	* Returns the last study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching study option, or <code>null</code> if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption fetchByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the study options before and after the current study option in the ordered set where spCourseId = &#63;.
	*
	* @param spStudyOptionId the primary key of the current study option
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption[] findByCourseId_PrevAndNext(
		long spStudyOptionId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException;

	/**
	* Removes all the study options where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of study options where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching study options
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the study option in the entity cache if it is enabled.
	*
	* @param studyOption the study option
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.StudyOption studyOption);

	/**
	* Caches the study options in the entity cache if it is enabled.
	*
	* @param studyOptions the study options
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.StudyOption> studyOptions);

	/**
	* Creates a new study option with the primary key. Does not add the study option to the database.
	*
	* @param spStudyOptionId the primary key for the new study option
	* @return the new study option
	*/
	public com.sambaash.platform.srv.model.StudyOption create(
		long spStudyOptionId);

	/**
	* Removes the study option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option that was removed
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption remove(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException;

	public com.sambaash.platform.srv.model.StudyOption updateImpl(
		com.sambaash.platform.srv.model.StudyOption studyOption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the study option with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchStudyOptionException} if it could not be found.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption findByPrimaryKey(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException;

	/**
	* Returns the study option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option, or <code>null</code> if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.StudyOption fetchByPrimaryKey(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the study options.
	*
	* @return the study options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the study options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @return the range of study options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the study options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of study options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the study options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of study options.
	*
	* @return the number of study options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}