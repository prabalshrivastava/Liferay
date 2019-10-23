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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.extendedprofile.model.SPCertification;

/**
 * The persistence interface for the s p certification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPCertificationPersistenceImpl
 * @see SPCertificationUtil
 * @generated
 */
public interface SPCertificationPersistence extends BasePersistence<SPCertification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPCertificationUtil} to access the s p certification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the s p certification where userId = &#63; and certificationId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException} if it could not be found.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the matching s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	/**
	* Returns the s p certification where userId = &#63; and certificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p certification where userId = &#63; and certificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserIdAndCertificationId(
		long userId, long certificationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p certification where userId = &#63; and certificationId = &#63; from the database.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the s p certification that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification removeByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	/**
	* Returns the number of s p certifications where userId = &#63; and certificationId = &#63;.
	*
	* @param userId the user ID
	* @param certificationId the certification ID
	* @return the number of matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndCertificationId(long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p certifications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	/**
	* Returns the first s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	/**
	* Returns the last s p certification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p certification, or <code>null</code> if a matching s p certification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification[] findByUserId_PrevAndNext(
		long classPk, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	/**
	* Removes all the s p certifications where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p certifications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p certification in the entity cache if it is enabled.
	*
	* @param spCertification the s p certification
	*/
	public void cacheResult(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification);

	/**
	* Caches the s p certifications in the entity cache if it is enabled.
	*
	* @param spCertifications the s p certifications
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> spCertifications);

	/**
	* Creates a new s p certification with the primary key. Does not add the s p certification to the database.
	*
	* @param classPk the primary key for the new s p certification
	* @return the new s p certification
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification create(
		long classPk);

	/**
	* Removes the s p certification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification that was removed
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification remove(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	public com.sambaash.platform.srv.extendedprofile.model.SPCertification updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p certification with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException} if it could not be found.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification findByPrimaryKey(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;

	/**
	* Returns the s p certification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification, or <code>null</code> if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchByPrimaryKey(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p certifications.
	*
	* @return the s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p certifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p certifications.
	*
	* @return the number of s p certifications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}