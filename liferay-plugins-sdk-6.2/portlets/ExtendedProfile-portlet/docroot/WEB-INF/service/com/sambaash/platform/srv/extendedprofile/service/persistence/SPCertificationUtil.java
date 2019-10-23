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

package com.sambaash.platform.srv.extendedprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.extendedprofile.model.SPCertification;

import java.util.List;

/**
 * The persistence utility for the s p certification service. This utility wraps {@link SPCertificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPCertificationPersistence
 * @see SPCertificationPersistenceImpl
 * @generated
 */
public class SPCertificationUtil {
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
	public static void clearCache(SPCertification spCertification) {
		getPersistence().clearCache(spCertification);
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
	public static List<SPCertification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPCertification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPCertification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPCertification update(SPCertification spCertification)
		throws SystemException {
		return getPersistence().update(spCertification);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPCertification update(SPCertification spCertification,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spCertification, serviceContext);
	}

	/**
	* Returns the s p certification where userId = &#63; and certificationId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException} if it could not be found.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the matching s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence()
				   .findByUserIdAndCertificationId(userId, certificationId);
	}

	/**
	* Returns the s p certification where userId = &#63; and certificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndCertificationId(userId, certificationId);
	}

	/**
	* Returns the s p certification where userId = &#63; and certificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserIdAndCertificationId(
		long userId, long certificationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndCertificationId(userId, certificationId,
			retrieveFromCache);
	}

	/**
	* Removes the s p certification where userId = &#63; and certificationId = &#63; from the database.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the s p certification that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification removeByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence()
				   .removeByUserIdAndCertificationId(userId, certificationId);
	}

	/**
	* Returns the number of s p certifications where userId = &#63; and certificationId = &#63;.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the number of matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndCertificationId(long userId,
		long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdAndCertificationId(userId, certificationId);
	}

	/**
	* Returns all the s p certifications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the s p certifications where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p certifications
	* @param end the upper bound of the range of s p certifications (not inclusive)
	* @return the range of matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the s p certifications where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p certifications
	* @param end the upper bound of the range of s p certifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the s p certifications before and after the current s p certification in the ordered set where userId = &#63;.
	*
	* @param classPk the primary key of the current s p certification
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification[] findByUserId_PrevAndNext(
		long classPk, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence()
				   .findByUserId_PrevAndNext(classPk, userId, orderByComparator);
	}

	/**
	* Removes all the s p certifications where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of s p certifications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the s p certification in the entity cache if it is enabled.
	*
	* @param spCertification the s p certification
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification) {
		getPersistence().cacheResult(spCertification);
	}

	/**
	* Caches the s p certifications in the entity cache if it is enabled.
	*
	* @param spCertifications the s p certifications
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> spCertifications) {
		getPersistence().cacheResult(spCertifications);
	}

	/**
	* Creates a new s p certification with the primary key. Does not add the s p certification to the database.
	*
	* @param classPk the primary key for the new s p certification
	* @return the new s p certification
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification create(
		long classPk) {
		return getPersistence().create(classPk);
	}

	/**
	* Removes the s p certification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification that was removed
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification remove(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence().remove(classPk);
	}

	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spCertification);
	}

	/**
	* Returns the s p certification with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException} if it could not be found.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification findByPrimaryKey(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return getPersistence().findByPrimaryKey(classPk);
	}

	/**
	* Returns the s p certification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification, or <code>null</code> if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByPrimaryKey(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(classPk);
	}

	/**
	* Returns all the s p certifications.
	*
	* @return the s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p certifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p certifications
	* @param end the upper bound of the range of s p certifications (not inclusive)
	* @return the range of s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p certifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p certifications
	* @param end the upper bound of the range of s p certifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p certifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p certifications.
	*
	* @return the number of s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPCertificationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPCertificationPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.extendedprofile.service.ClpSerializer.getServletContextName(),
					SPCertificationPersistence.class.getName());

			ReferenceRegistry.registerReference(SPCertificationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPCertificationPersistence persistence) {
	}

	private static SPCertificationPersistence _persistence;
}