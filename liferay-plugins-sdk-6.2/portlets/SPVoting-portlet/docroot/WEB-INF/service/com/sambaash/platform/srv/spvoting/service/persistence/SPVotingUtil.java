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

package com.sambaash.platform.srv.spvoting.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spvoting.model.SPVoting;

import java.util.List;

/**
 * The persistence utility for the s p voting service. This utility wraps {@link SPVotingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPVotingPersistence
 * @see SPVotingPersistenceImpl
 * @generated
 */
public class SPVotingUtil {
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
	public static void clearCache(SPVoting spVoting) {
		getPersistence().clearCache(spVoting);
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
	public static List<SPVoting> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPVoting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPVoting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPVoting update(SPVoting spVoting) throws SystemException {
		return getPersistence().update(spVoting);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPVoting update(SPVoting spVoting,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spVoting, serviceContext);
	}

	/**
	* Returns all the s p votings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p votings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p votings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p votings before and after the current s p voting in the ordered set where uuid = &#63;.
	*
	* @param spVotingId the primary key of the current s p voting
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting[] findByUuid_PrevAndNext(
		long spVotingId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spVotingId, uuid, orderByComparator);
	}

	/**
	* Removes all the s p votings where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p votings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p voting where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p voting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p voting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p voting where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p votings where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p votings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the s p votings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the s p votings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the s p votings before and after the current s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spVotingId the primary key of the current s p voting
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting[] findByUuid_C_PrevAndNext(
		long spVotingId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spVotingId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the s p votings where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of s p votings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().findByEntryAndUserId(className, classPK, userId);
	}

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntryAndUserId(className, classPK, userId);
	}

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndUserId(
		java.lang.String className, long classPK, long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntryAndUserId(className, classPK, userId,
			retrieveFromCache);
	}

	/**
	* Removes the s p voting where className = &#63; and classPK = &#63; and userId = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting removeByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .removeByEntryAndUserId(className, classPK, userId);
	}

	/**
	* Returns the number of s p votings where className = &#63; and classPK = &#63; and userId = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntryAndUserId(java.lang.String className,
		long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntryAndUserId(className, classPK, userId);
	}

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().findByEntryAndIp(className, classPK, ip);
	}

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntryAndIp(className, classPK, ip);
	}

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntryAndIp(className, classPK, ip, retrieveFromCache);
	}

	/**
	* Removes the s p voting where className = &#63; and classPK = &#63; and ip = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting removeByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().removeByEntryAndIp(className, classPK, ip);
	}

	/**
	* Returns the number of s p votings where className = &#63; and classPK = &#63; and ip = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntryAndIp(java.lang.String className,
		long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntryAndIp(className, classPK, ip);
	}

	/**
	* Returns all the s p votings where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntry(className, classPK);
	}

	/**
	* Returns a range of all the s p votings where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntry(className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the s p votings where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEntry(className, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByEntry_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByEntry_First(className, classPK, orderByComparator);
	}

	/**
	* Returns the first s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntry_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntry_First(className, classPK, orderByComparator);
	}

	/**
	* Returns the last s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByEntry_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByEntry_Last(className, classPK, orderByComparator);
	}

	/**
	* Returns the last s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntry_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntry_Last(className, classPK, orderByComparator);
	}

	/**
	* Returns the s p votings before and after the current s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param spVotingId the primary key of the current s p voting
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting[] findByEntry_PrevAndNext(
		long spVotingId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence()
				   .findByEntry_PrevAndNext(spVotingId, className, classPK,
			orderByComparator);
	}

	/**
	* Removes all the s p votings where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEntry(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEntry(className, classPK);
	}

	/**
	* Returns the number of s p votings where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntry(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntry(className, classPK);
	}

	/**
	* Caches the s p voting in the entity cache if it is enabled.
	*
	* @param spVoting the s p voting
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting) {
		getPersistence().cacheResult(spVoting);
	}

	/**
	* Caches the s p votings in the entity cache if it is enabled.
	*
	* @param spVotings the s p votings
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> spVotings) {
		getPersistence().cacheResult(spVotings);
	}

	/**
	* Creates a new s p voting with the primary key. Does not add the s p voting to the database.
	*
	* @param spVotingId the primary key for the new s p voting
	* @return the new s p voting
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting create(
		long spVotingId) {
		return getPersistence().create(spVotingId);
	}

	/**
	* Removes the s p voting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting that was removed
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting remove(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().remove(spVotingId);
	}

	public static com.sambaash.platform.srv.spvoting.model.SPVoting updateImpl(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spVoting);
	}

	/**
	* Returns the s p voting with the primary key or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByPrimaryKey(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getPersistence().findByPrimaryKey(spVotingId);
	}

	/**
	* Returns the s p voting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting, or <code>null</code> if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchByPrimaryKey(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spVotingId);
	}

	/**
	* Returns all the s p votings.
	*
	* @return the s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p votings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p votings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p votings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p votings.
	*
	* @return the number of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPVotingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPVotingPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spvoting.service.ClpSerializer.getServletContextName(),
					SPVotingPersistence.class.getName());

			ReferenceRegistry.registerReference(SPVotingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPVotingPersistence persistence) {
	}

	private static SPVotingPersistence _persistence;
}