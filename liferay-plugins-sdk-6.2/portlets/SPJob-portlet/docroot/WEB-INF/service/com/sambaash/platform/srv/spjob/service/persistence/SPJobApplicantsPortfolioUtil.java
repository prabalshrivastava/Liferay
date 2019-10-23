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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio;

import java.util.List;

/**
 * The persistence utility for the s p job applicants portfolio service. This utility wraps {@link SPJobApplicantsPortfolioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPortfolioPersistence
 * @see SPJobApplicantsPortfolioPersistenceImpl
 * @generated
 */
public class SPJobApplicantsPortfolioUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		getPersistence().clearCache(spJobApplicantsPortfolio);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SPJobApplicantsPortfolio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPJobApplicantsPortfolio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPJobApplicantsPortfolio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPJobApplicantsPortfolio update(
		SPJobApplicantsPortfolio spJobApplicantsPortfolio)
		throws SystemException {
		return getPersistence().update(spJobApplicantsPortfolio);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPJobApplicantsPortfolio update(
		SPJobApplicantsPortfolio spJobApplicantsPortfolio,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spJobApplicantsPortfolio, serviceContext);
	}

	/**
	* Returns all the s p job applicants portfolios where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @return the matching s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllPortfolioIdsForJobApplyId(jobApplyId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllPortfolioIdsForJobApplyId(jobApplyId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllPortfolioIdsForJobApplyId(jobApplyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio findByAllPortfolioIdsForJobApplyId_First(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException {
		return getPersistence()
				   .findByAllPortfolioIdsForJobApplyId_First(jobApplyId,
			orderByComparator);
	}

	/**
	* Returns the first s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants portfolio, or <code>null</code> if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio fetchByAllPortfolioIdsForJobApplyId_First(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllPortfolioIdsForJobApplyId_First(jobApplyId,
			orderByComparator);
	}

	/**
	* Returns the last s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio findByAllPortfolioIdsForJobApplyId_Last(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException {
		return getPersistence()
				   .findByAllPortfolioIdsForJobApplyId_Last(jobApplyId,
			orderByComparator);
	}

	/**
	* Returns the last s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants portfolio, or <code>null</code> if a matching s p job applicants portfolio could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio fetchByAllPortfolioIdsForJobApplyId_Last(
		long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllPortfolioIdsForJobApplyId_Last(jobApplyId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio[] findByAllPortfolioIdsForJobApplyId_PrevAndNext(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK, long jobApplyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException {
		return getPersistence()
				   .findByAllPortfolioIdsForJobApplyId_PrevAndNext(spJobApplicantsPortfolioPK,
			jobApplyId, orderByComparator);
	}

	/**
	* Removes all the s p job applicants portfolios where jobApplyId = &#63; from the database.
	*
	* @param jobApplyId the job apply ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllPortfolioIdsForJobApplyId(long jobApplyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllPortfolioIdsForJobApplyId(jobApplyId);
	}

	/**
	* Returns the number of s p job applicants portfolios where jobApplyId = &#63;.
	*
	* @param jobApplyId the job apply ID
	* @return the number of matching s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllPortfolioIdsForJobApplyId(long jobApplyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllPortfolioIdsForJobApplyId(jobApplyId);
	}

	/**
	* Caches the s p job applicants portfolio in the entity cache if it is enabled.
	*
	* @param spJobApplicantsPortfolio the s p job applicants portfolio
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		getPersistence().cacheResult(spJobApplicantsPortfolio);
	}

	/**
	* Caches the s p job applicants portfolios in the entity cache if it is enabled.
	*
	* @param spJobApplicantsPortfolios the s p job applicants portfolios
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> spJobApplicantsPortfolios) {
		getPersistence().cacheResult(spJobApplicantsPortfolios);
	}

	/**
	* Creates a new s p job applicants portfolio with the primary key. Does not add the s p job applicants portfolio to the database.
	*
	* @param spJobApplicantsPortfolioPK the primary key for the new s p job applicants portfolio
	* @return the new s p job applicants portfolio
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio create(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK) {
		return getPersistence().create(spJobApplicantsPortfolioPK);
	}

	/**
	* Removes the s p job applicants portfolio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	* @return the s p job applicants portfolio that was removed
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio remove(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException {
		return getPersistence().remove(spJobApplicantsPortfolioPK);
	}

	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio spJobApplicantsPortfolio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spJobApplicantsPortfolio);
	}

	/**
	* Returns the s p job applicants portfolio with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException} if it could not be found.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	* @return the s p job applicants portfolio
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio findByPrimaryKey(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException {
		return getPersistence().findByPrimaryKey(spJobApplicantsPortfolioPK);
	}

	/**
	* Returns the s p job applicants portfolio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	* @return the s p job applicants portfolio, or <code>null</code> if a s p job applicants portfolio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio fetchByPrimaryKey(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spJobApplicantsPortfolioPK);
	}

	/**
	* Returns all the s p job applicants portfolios.
	*
	* @return the s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p job applicants portfolios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p job applicants portfolios.
	*
	* @return the number of s p job applicants portfolios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPJobApplicantsPortfolioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPJobApplicantsPortfolioPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spjob.service.ClpSerializer.getServletContextName(),
					SPJobApplicantsPortfolioPersistence.class.getName());

			ReferenceRegistry.registerReference(SPJobApplicantsPortfolioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPJobApplicantsPortfolioPersistence persistence) {
	}

	private static SPJobApplicantsPortfolioPersistence _persistence;
}