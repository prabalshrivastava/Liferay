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

package com.sambaash.platform.srv.spjob.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio;

/**
 * The persistence interface for the s p job applicants portfolio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPortfolioPersistenceImpl
 * @see SPJobApplicantsPortfolioUtil
 * @generated
 */
public interface SPJobApplicantsPortfolioPersistence extends BasePersistence<SPJobApplicantsPortfolio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPJobApplicantsPortfolioUtil} to access the s p job applicants portfolio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p job applicants portfolios where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @return the matching s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p job applicants portfolios where jobApplyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobApplyId the job apply ID
	* @param start the lower bound of the range of s p job applicants portfolios
	* @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	* @return the range of matching s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p job applicants portfolios where jobApplyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobApplyId the job apply ID
	* @param start the lower bound of the range of s p job applicants portfolios
	* @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio findByAllPortfolioIdsForJobApplyId_First(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException;

	/**
	* Returns the first s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants portfolio, or <code>null</code> if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio fetchByAllPortfolioIdsForJobApplyId_First(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio findByAllPortfolioIdsForJobApplyId_Last(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException;

	/**
	* Returns the last s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants portfolio, or <code>null</code> if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio fetchByAllPortfolioIdsForJobApplyId_Last(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job applicants portfolios before and after the current s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the current s p job applicants portfolio
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio[] findByAllPortfolioIdsForJobApplyId_PrevAndNext(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK, long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException;

	/**
	* Removes all the s p job applicants portfolios where jobApplyId = &#63; from the database.
	*
	* @param jobApplyId the job apply ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllPortfolioIdsForJobApplyId(long jobApplyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job applicants portfolios where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @return the number of matching s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllPortfolioIdsForJobApplyId(long jobApplyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p job applicants portfolio in the entity cache if it is enabled.
	*
	* @param spJobApplicantsPortfolio the s p job applicants portfolio
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio spJobApplicantsPortfolio);

	/**
	* Caches the s p job applicants portfolios in the entity cache if it is enabled.
	*
	* @param spJobApplicantsPortfolios the s p job applicants portfolios
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> spJobApplicantsPortfolios);

	/**
	* Creates a new s p job applicants portfolio with the primary key. Does not add the s p job applicants portfolio to the database.
	*
	* @param spJobApplicantsPortfolioPK the primary key for the new s p job applicants portfolio
	* @return the new s p job applicants portfolio
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio create(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK);

	/**
	* Removes the s p job applicants portfolio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	* @return the s p job applicants portfolio that was removed
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio remove(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException;

	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio spJobApplicantsPortfolio)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job applicants portfolio with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException} if it could not be found.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	* @return the s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio findByPrimaryKey(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException;

	/**
	* Returns the s p job applicants portfolio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	* @return the s p job applicants portfolio, or <code>null</code> if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio fetchByPrimaryKey(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job applicants portfolios.
	*
	* @return the s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p job applicants portfolios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job applicants portfolios
	* @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	* @return the range of s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p job applicants portfolios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job applicants portfolios
	* @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p job applicants portfolios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job applicants portfolios.
	*
	* @return the number of s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}