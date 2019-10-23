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

package com.sambaash.platform.srv.validation.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult;

/**
 * The persistence interface for the s p student programme result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeResultPersistenceImpl
 * @see SPStudentProgrammeResultUtil
 * @generated
 */
public interface SPStudentProgrammeResultPersistence extends BasePersistence<SPStudentProgrammeResult> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPStudentProgrammeResultUtil} to access the s p student programme result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p student programme results where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @return the matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p student programme results where nric = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nric the nric
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p student programme results where nric = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nric the nric
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByNricAndProgramme(
		java.lang.String nric, java.lang.String programme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByNricAndProgramme_First(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Returns the first s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByNricAndProgramme_First(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByNricAndProgramme_Last(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Returns the last s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByNricAndProgramme_Last(
		java.lang.String nric, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p student programme results before and after the current s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	*
	* @param spStudentProgrammeResultId the primary key of the current s p student programme result
	* @param nric the nric
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult[] findByNricAndProgramme_PrevAndNext(
		long spStudentProgrammeResultId, java.lang.String nric,
		java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Removes all the s p student programme results where nric = &#63; and programme = &#63; from the database.
	*
	* @param nric the nric
	* @param programme the programme
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNricAndProgramme(java.lang.String nric,
		java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p student programme results where nric = &#63; and programme = &#63;.
	*
	* @param nric the nric
	* @param programme the programme
	* @return the number of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public int countByNricAndProgramme(java.lang.String nric,
		java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @return the matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByEmailAddressAndProgramme_First(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Returns the first s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByEmailAddressAndProgramme_First(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByEmailAddressAndProgramme_Last(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Returns the last s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByEmailAddressAndProgramme_Last(
		java.lang.String emailAddress, java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p student programme results before and after the current s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	*
	* @param spStudentProgrammeResultId the primary key of the current s p student programme result
	* @param emailAddress the email address
	* @param programme the programme
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult[] findByEmailAddressAndProgramme_PrevAndNext(
		long spStudentProgrammeResultId, java.lang.String emailAddress,
		java.lang.String programme,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Removes all the s p student programme results where emailAddress = &#63; and programme = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailAddressAndProgramme(
		java.lang.String emailAddress, java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p student programme results where emailAddress = &#63; and programme = &#63;.
	*
	* @param emailAddress the email address
	* @param programme the programme
	* @return the number of matching s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddressAndProgramme(java.lang.String emailAddress,
		java.lang.String programme)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p student programme result in the entity cache if it is enabled.
	*
	* @param spStudentProgrammeResult the s p student programme result
	*/
	public void cacheResult(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult);

	/**
	* Caches the s p student programme results in the entity cache if it is enabled.
	*
	* @param spStudentProgrammeResults the s p student programme results
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> spStudentProgrammeResults);

	/**
	* Creates a new s p student programme result with the primary key. Does not add the s p student programme result to the database.
	*
	* @param spStudentProgrammeResultId the primary key for the new s p student programme result
	* @return the new s p student programme result
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult create(
		long spStudentProgrammeResultId);

	/**
	* Removes the s p student programme result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result that was removed
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult remove(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult updateImpl(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p student programme result with the primary key or throws a {@link com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException} if it could not be found.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result
	* @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult findByPrimaryKey(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;

	/**
	* Returns the s p student programme result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result, or <code>null</code> if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchByPrimaryKey(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p student programme results.
	*
	* @return the s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p student programme results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p student programme results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p student programme results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p student programme results.
	*
	* @return the number of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}