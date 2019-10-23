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

package com.sambaash.platform.srv.startupprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;

import java.util.List;

/**
 * The persistence utility for the approved mentors service. This utility wraps {@link ApprovedMentorsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ApprovedMentorsPersistence
 * @see ApprovedMentorsPersistenceImpl
 * @generated
 */
public class ApprovedMentorsUtil {
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
	public static void clearCache(ApprovedMentors approvedMentors) {
		getPersistence().clearCache(approvedMentors);
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
	public static List<ApprovedMentors> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApprovedMentors> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApprovedMentors> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ApprovedMentors update(ApprovedMentors approvedMentors)
		throws SystemException {
		return getPersistence().update(approvedMentors);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ApprovedMentors update(ApprovedMentors approvedMentors,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(approvedMentors, serviceContext);
	}

	/**
	* Returns all the approved mentorses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the approved mentorses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where uuid = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByUuid_PrevAndNext(
		long mentorId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(mentorId, uuid, orderByComparator);
	}

	/**
	* Removes all the approved mentorses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of approved mentorses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the approved mentorses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUserId(
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the approved mentorses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUserId(
		java.lang.String userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUserId(
		java.lang.String userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByUserId_First(
		java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByUserId_First(
		java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByUserId_Last(
		java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByUserId_Last(
		java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where userId = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByUserId_PrevAndNext(
		long mentorId, java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByUserId_PrevAndNext(mentorId, userId, orderByComparator);
	}

	/**
	* Removes all the approved mentorses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of approved mentorses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the approved mentorses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	* Returns a range of all the approved mentorses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByOrganizationId_PrevAndNext(
		long mentorId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(mentorId, organizationId,
			orderByComparator);
	}

	/**
	* Removes all the approved mentorses where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	* Returns the number of approved mentorses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	* Returns all the approved mentorses where status = &#63;.
	*
	* @param status the status
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the approved mentorses where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where status = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByStatus_PrevAndNext(
		long mentorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByStatus_PrevAndNext(mentorId, status, orderByComparator);
	}

	/**
	* Removes all the approved mentorses where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of approved mentorses where status = &#63;.
	*
	* @param status the status
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the approved mentorses where organizationId = &#63; and userId = &#63;.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndUserId(organizationId, userId);
	}

	/**
	* Returns a range of all the approved mentorses where organizationId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, java.lang.String userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndUserId(organizationId, userId, start,
			end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where organizationId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, java.lang.String userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndUserId(organizationId, userId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationAndUserId_First(
		long organizationId, java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationAndUserId_First(organizationId, userId,
			orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationAndUserId_First(
		long organizationId, java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndUserId_First(organizationId, userId,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationAndUserId_Last(
		long organizationId, java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationAndUserId_Last(organizationId, userId,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationAndUserId_Last(
		long organizationId, java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndUserId_Last(organizationId, userId,
			orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param organizationId the organization ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByOrganizationAndUserId_PrevAndNext(
		long mentorId, long organizationId, java.lang.String userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationAndUserId_PrevAndNext(mentorId,
			organizationId, userId, orderByComparator);
	}

	/**
	* Removes all the approved mentorses where organizationId = &#63; and userId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationAndUserId(long organizationId,
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationAndUserId(organizationId, userId);
	}

	/**
	* Returns the number of approved mentorses where organizationId = &#63; and userId = &#63;.
	*
	* @param organizationId the organization ID
	* @param userId the user ID
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationAndUserId(long organizationId,
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrganizationAndUserId(organizationId, userId);
	}

	/**
	* Returns all the approved mentorses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationIdApprovedMentors(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationIdApprovedMentors(organizationId);
	}

	/**
	* Returns a range of all the approved mentorses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationIdApprovedMentors(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationIdApprovedMentors(organizationId, start,
			end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationIdApprovedMentors(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationIdApprovedMentors(organizationId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationIdApprovedMentors_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationIdApprovedMentors_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationIdApprovedMentors_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationIdApprovedMentors_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationIdApprovedMentors_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationIdApprovedMentors_Last(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationIdApprovedMentors_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationIdApprovedMentors_Last(organizationId,
			orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByOrganizationIdApprovedMentors_PrevAndNext(
		long mentorId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationIdApprovedMentors_PrevAndNext(mentorId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the approved mentorses where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationIdApprovedMentors(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationIdApprovedMentors(organizationId);
	}

	/**
	* Returns the number of approved mentorses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationIdApprovedMentors(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrganizationIdApprovedMentors(organizationId);
	}

	/**
	* Returns all the approved mentorses where organizationId = &#63; and status = &#63;.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @return the matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationIdStatus(
		long organizationId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationIdStatus(organizationId, status);
	}

	/**
	* Returns a range of all the approved mentorses where organizationId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param status the status
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationIdStatus(
		long organizationId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationIdStatus(organizationId, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the approved mentorses where organizationId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param status the status
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationIdStatus(
		long organizationId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationIdStatus(organizationId, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationIdStatus_First(
		long organizationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationIdStatus_First(organizationId, status,
			orderByComparator);
	}

	/**
	* Returns the first approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationIdStatus_First(
		long organizationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationIdStatus_First(organizationId, status,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByOrganizationIdStatus_Last(
		long organizationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationIdStatus_Last(organizationId, status,
			orderByComparator);
	}

	/**
	* Returns the last approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByOrganizationIdStatus_Last(
		long organizationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationIdStatus_Last(organizationId, status,
			orderByComparator);
	}

	/**
	* Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	*
	* @param mentorId the primary key of the current approved mentors
	* @param organizationId the organization ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors[] findByOrganizationIdStatus_PrevAndNext(
		long mentorId, long organizationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence()
				   .findByOrganizationIdStatus_PrevAndNext(mentorId,
			organizationId, status, orderByComparator);
	}

	/**
	* Removes all the approved mentorses where organizationId = &#63; and status = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationIdStatus(long organizationId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationIdStatus(organizationId, status);
	}

	/**
	* Returns the number of approved mentorses where organizationId = &#63; and status = &#63;.
	*
	* @param organizationId the organization ID
	* @param status the status
	* @return the number of matching approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationIdStatus(long organizationId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrganizationIdStatus(organizationId, status);
	}

	/**
	* Caches the approved mentors in the entity cache if it is enabled.
	*
	* @param approvedMentors the approved mentors
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors) {
		getPersistence().cacheResult(approvedMentors);
	}

	/**
	* Caches the approved mentorses in the entity cache if it is enabled.
	*
	* @param approvedMentorses the approved mentorses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> approvedMentorses) {
		getPersistence().cacheResult(approvedMentorses);
	}

	/**
	* Creates a new approved mentors with the primary key. Does not add the approved mentors to the database.
	*
	* @param mentorId the primary key for the new approved mentors
	* @return the new approved mentors
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors create(
		long mentorId) {
		return getPersistence().create(mentorId);
	}

	/**
	* Removes the approved mentors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mentorId the primary key of the approved mentors
	* @return the approved mentors that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors remove(
		long mentorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().remove(mentorId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(approvedMentors);
	}

	/**
	* Returns the approved mentors with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException} if it could not be found.
	*
	* @param mentorId the primary key of the approved mentors
	* @return the approved mentors
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors findByPrimaryKey(
		long mentorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException {
		return getPersistence().findByPrimaryKey(mentorId);
	}

	/**
	* Returns the approved mentors with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mentorId the primary key of the approved mentors
	* @return the approved mentors, or <code>null</code> if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchByPrimaryKey(
		long mentorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mentorId);
	}

	/**
	* Returns all the approved mentorses.
	*
	* @return the approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the approved mentorses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the approved mentorses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the approved mentorses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of approved mentorses.
	*
	* @return the number of approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ApprovedMentorsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApprovedMentorsPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.startupprofile.service.ClpSerializer.getServletContextName(),
					ApprovedMentorsPersistence.class.getName());

			ReferenceRegistry.registerReference(ApprovedMentorsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ApprovedMentorsPersistence persistence) {
	}

	private static ApprovedMentorsPersistence _persistence;
}