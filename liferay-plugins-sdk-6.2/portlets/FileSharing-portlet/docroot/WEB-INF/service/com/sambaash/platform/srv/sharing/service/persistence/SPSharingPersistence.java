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

package com.sambaash.platform.srv.sharing.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.sharing.model.SPSharing;

/**
 * The persistence interface for the s p sharing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPSharingPersistenceImpl
 * @see SPSharingUtil
 * @generated
 */
public interface SPSharingPersistence extends BasePersistence<SPSharing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSharingUtil} to access the s p sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByUserIdClassNameIdAndClassPK(
		long userId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByUserIdClassNameIdAndClassPK(
		long userId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByUserIdClassNameIdAndClassPK(
		long userId, long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the s p sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing removeByUserIdClassNameIdAndClassPK(
		long userId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the number of s p sharings where userId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdClassNameIdAndClassPK(long userId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @return the matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByUserIdDatesExpired(
		long userId, java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByUserIdDatesExpired(
		long userId, java.util.Date startDate, java.util.Date endDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByUserIdDatesExpired(
		long userId, java.util.Date startDate, java.util.Date endDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByUserIdDatesExpired_First(
		long userId, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the first s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByUserIdDatesExpired_First(
		long userId, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByUserIdDatesExpired_Last(
		long userId, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the last s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByUserIdDatesExpired_Last(
		long userId, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharings before and after the current s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param spSharingId the primary key of the current s p sharing
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing[] findByUserIdDatesExpired_PrevAndNext(
		long spSharingId, long userId, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Removes all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63; from the database.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdDatesExpired(long userId,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param endDate the end date
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdDatesExpired(long userId, java.util.Date startDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @return the matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByCreatedByDatesExpired(
		long createdBy, java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByCreatedByDatesExpired(
		long createdBy, java.util.Date startDate, java.util.Date endDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByCreatedByDatesExpired(
		long createdBy, java.util.Date startDate, java.util.Date endDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByCreatedByDatesExpired_First(
		long createdBy, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the first s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByCreatedByDatesExpired_First(
		long createdBy, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByCreatedByDatesExpired_Last(
		long createdBy, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the last s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByCreatedByDatesExpired_Last(
		long createdBy, java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharings before and after the current s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param spSharingId the primary key of the current s p sharing
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing[] findByCreatedByDatesExpired_PrevAndNext(
		long spSharingId, long createdBy, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Removes all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63; from the database.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreatedByDatesExpired(long createdBy,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	*
	* @param createdBy the created by
	* @param startDate the start date
	* @param endDate the end date
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreatedByDatesExpired(long createdBy,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByUserIdClassNameIdClassPKAndShareType(
		long userId, long classNameId, long classPK, boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByUserIdClassNameIdClassPKAndShareType(
		long userId, long classNameId, long classPK, boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByUserIdClassNameIdClassPKAndShareType(
		long userId, long classNameId, long classPK, boolean internalShare,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; from the database.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the s p sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing removeByUserIdClassNameIdClassPKAndShareType(
		long userId, long classNameId, long classPK, boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the number of s p sharings where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63;.
	*
	* @param userId the user ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdClassNameIdClassPKAndShareType(long userId,
		long classNameId, long classPK, boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	*
	* @param emailAddress the email address
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByEmailClassNameIdClassPKAndShareType(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByEmailClassNameIdClassPKAndShareType(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByEmailClassNameIdClassPKAndShareType(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the s p sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing removeByEmailClassNameIdClassPKAndShareType(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the number of s p sharings where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63;.
	*
	* @param emailAddress the email address
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param internalShare the internal share
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailClassNameIdClassPKAndShareType(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sharings where classPK = &#63; and classNameId = &#63;.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @return the matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByClassPKAndClassNameId(
		long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sharings where classPK = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByClassPKAndClassNameId(
		long classPK, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sharings where classPK = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByClassPKAndClassNameId(
		long classPK, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByClassPKAndClassNameId_First(
		long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the first s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByClassPKAndClassNameId_First(
		long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByClassPKAndClassNameId_Last(
		long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the last s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByClassPKAndClassNameId_Last(
		long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharings before and after the current s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	*
	* @param spSharingId the primary key of the current s p sharing
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing[] findByClassPKAndClassNameId_PrevAndNext(
		long spSharingId, long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Removes all the s p sharings where classPK = &#63; and classNameId = &#63; from the database.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassPKAndClassNameId(long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sharings where classPK = &#63; and classNameId = &#63;.
	*
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassPKAndClassNameId(long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @return the matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByCreatedByClassPKAndClassNameId(
		long createdBy, long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByCreatedByClassPKAndClassNameId(
		long createdBy, long classPK, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByCreatedByClassPKAndClassNameId(
		long createdBy, long classPK, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByCreatedByClassPKAndClassNameId_First(
		long createdBy, long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the first s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByCreatedByClassPKAndClassNameId_First(
		long createdBy, long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByCreatedByClassPKAndClassNameId_Last(
		long createdBy, long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the last s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByCreatedByClassPKAndClassNameId_Last(
		long createdBy, long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharings before and after the current s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param spSharingId the primary key of the current s p sharing
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing[] findByCreatedByClassPKAndClassNameId_PrevAndNext(
		long spSharingId, long createdBy, long classPK, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Removes all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63; from the database.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreatedByClassPKAndClassNameId(long createdBy,
		long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	*
	* @param createdBy the created by
	* @param classPK the class p k
	* @param classNameId the class name ID
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreatedByClassPKAndClassNameId(long createdBy,
		long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sharings where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByEmail(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sharings where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByEmail(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sharings where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findByEmail(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p sharing in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByEmail_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the first s p sharing in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByEmail_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p sharing in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByEmail_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the last s p sharing in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByEmail_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharings before and after the current s p sharing in the ordered set where emailAddress = &#63;.
	*
	* @param spSharingId the primary key of the current s p sharing
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing[] findByEmail_PrevAndNext(
		long spSharingId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Removes all the s p sharings where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmail(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sharings where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p sharing in the entity cache if it is enabled.
	*
	* @param spSharing the s p sharing
	*/
	public void cacheResult(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing);

	/**
	* Caches the s p sharings in the entity cache if it is enabled.
	*
	* @param spSharings the s p sharings
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> spSharings);

	/**
	* Creates a new s p sharing with the primary key. Does not add the s p sharing to the database.
	*
	* @param spSharingId the primary key for the new s p sharing
	* @return the new s p sharing
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing create(
		long spSharingId);

	/**
	* Removes the s p sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing that was removed
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing remove(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	public com.sambaash.platform.srv.sharing.model.SPSharing updateImpl(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sharing with the primary key or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing
	* @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing findByPrimaryKey(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException;

	/**
	* Returns the s p sharing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing, or <code>null</code> if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchByPrimaryKey(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sharings.
	*
	* @return the s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p sharings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sharings.
	*
	* @return the number of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}