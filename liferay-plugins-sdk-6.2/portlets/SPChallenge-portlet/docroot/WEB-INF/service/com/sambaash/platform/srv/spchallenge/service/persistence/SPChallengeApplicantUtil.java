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

package com.sambaash.platform.srv.spchallenge.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;

import java.util.List;

/**
 * The persistence utility for the s p challenge applicant service. This utility wraps {@link SPChallengeApplicantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPChallengeApplicantPersistence
 * @see SPChallengeApplicantPersistenceImpl
 * @generated
 */
public class SPChallengeApplicantUtil {
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
	public static void clearCache(SPChallengeApplicant spChallengeApplicant) {
		getPersistence().clearCache(spChallengeApplicant);
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
	public static List<SPChallengeApplicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPChallengeApplicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPChallengeApplicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPChallengeApplicant update(
		SPChallengeApplicant spChallengeApplicant) throws SystemException {
		return getPersistence().update(spChallengeApplicant);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPChallengeApplicant update(
		SPChallengeApplicant spChallengeApplicant, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spChallengeApplicant, serviceContext);
	}

	/**
	* Returns all the s p challenge applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p challenge applicants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p challenge applicants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findByUuid_PrevAndNext(
		long spChallengeApplicantId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spChallengeApplicantId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the s p challenge applicants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p challenge applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p challenge applicant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p challenge applicant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p challenge applicants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findByUuid_C_PrevAndNext(
		long spChallengeApplicantId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spChallengeApplicantId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the s p challenge applicants where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the s p challenge applicants where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicantRefId(applicantRefId);
	}

	/**
	* Returns a range of all the s p challenge applicants where applicantRefId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantRefId the applicant ref ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicantRefId(applicantRefId, start, end);
	}

	/**
	* Returns an ordered range of all the s p challenge applicants where applicantRefId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantRefId the applicant ref ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantRefId(applicantRefId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByApplicantRefId_First(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByApplicantRefId_First(applicantRefId, orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByApplicantRefId_First(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicantRefId_First(applicantRefId,
			orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByApplicantRefId_Last(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByApplicantRefId_Last(applicantRefId, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByApplicantRefId_Last(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicantRefId_Last(applicantRefId, orderByComparator);
	}

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findByApplicantRefId_PrevAndNext(
		long spChallengeApplicantId, long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByApplicantRefId_PrevAndNext(spChallengeApplicantId,
			applicantRefId, orderByComparator);
	}

	/**
	* Removes all the s p challenge applicants where applicantRefId = &#63; from the database.
	*
	* @param applicantRefId the applicant ref ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApplicantRefId(long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApplicantRefId(applicantRefId);
	}

	/**
	* Returns the number of s p challenge applicants where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApplicantRefId(long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApplicantRefId(applicantRefId);
	}

	/**
	* Returns all the s p challenge applicants where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySPChallengeId(spChallengeId);
	}

	/**
	* Returns a range of all the s p challenge applicants where spChallengeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spChallengeId the sp challenge ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySPChallengeId(spChallengeId, start, end);
	}

	/**
	* Returns an ordered range of all the s p challenge applicants where spChallengeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spChallengeId the sp challenge ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySPChallengeId(spChallengeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findBySPChallengeId_First(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findBySPChallengeId_First(spChallengeId, orderByComparator);
	}

	/**
	* Returns the first s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchBySPChallengeId_First(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySPChallengeId_First(spChallengeId, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findBySPChallengeId_Last(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findBySPChallengeId_Last(spChallengeId, orderByComparator);
	}

	/**
	* Returns the last s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchBySPChallengeId_Last(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySPChallengeId_Last(spChallengeId, orderByComparator);
	}

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findBySPChallengeId_PrevAndNext(
		long spChallengeApplicantId, long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findBySPChallengeId_PrevAndNext(spChallengeApplicantId,
			spChallengeId, orderByComparator);
	}

	/**
	* Removes all the s p challenge applicants where spChallengeId = &#63; from the database.
	*
	* @param spChallengeId the sp challenge ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySPChallengeId(long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySPChallengeId(spChallengeId);
	}

	/**
	* Returns the number of s p challenge applicants where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySPChallengeId(long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySPChallengeId(spChallengeId);
	}

	/**
	* Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .findByChallengeIdApplicantRefId(spChallengeId,
			applicantRefId);
	}

	/**
	* Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChallengeIdApplicantRefId(spChallengeId,
			applicantRefId);
	}

	/**
	* Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChallengeIdApplicantRefId(spChallengeId,
			applicantRefId, retrieveFromCache);
	}

	/**
	* Removes the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; from the database.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the s p challenge applicant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant removeByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence()
				   .removeByChallengeIdApplicantRefId(spChallengeId,
			applicantRefId);
	}

	/**
	* Returns the number of s p challenge applicants where spChallengeId = &#63; and applicantRefId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChallengeIdApplicantRefId(long spChallengeId,
		long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByChallengeIdApplicantRefId(spChallengeId,
			applicantRefId);
	}

	/**
	* Caches the s p challenge applicant in the entity cache if it is enabled.
	*
	* @param spChallengeApplicant the s p challenge applicant
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant) {
		getPersistence().cacheResult(spChallengeApplicant);
	}

	/**
	* Caches the s p challenge applicants in the entity cache if it is enabled.
	*
	* @param spChallengeApplicants the s p challenge applicants
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> spChallengeApplicants) {
		getPersistence().cacheResult(spChallengeApplicants);
	}

	/**
	* Creates a new s p challenge applicant with the primary key. Does not add the s p challenge applicant to the database.
	*
	* @param spChallengeApplicantId the primary key for the new s p challenge applicant
	* @return the new s p challenge applicant
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant create(
		long spChallengeApplicantId) {
		return getPersistence().create(spChallengeApplicantId);
	}

	/**
	* Removes the s p challenge applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant that was removed
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant remove(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence().remove(spChallengeApplicantId);
	}

	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant updateImpl(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spChallengeApplicant);
	}

	/**
	* Returns the s p challenge applicant with the primary key or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByPrimaryKey(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException {
		return getPersistence().findByPrimaryKey(spChallengeApplicantId);
	}

	/**
	* Returns the s p challenge applicant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant, or <code>null</code> if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByPrimaryKey(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spChallengeApplicantId);
	}

	/**
	* Returns all the s p challenge applicants.
	*
	* @return the s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p challenge applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p challenge applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p challenge applicants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p challenge applicants.
	*
	* @return the number of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPChallengeApplicantPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPChallengeApplicantPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spchallenge.service.ClpSerializer.getServletContextName(),
					SPChallengeApplicantPersistence.class.getName());

			ReferenceRegistry.registerReference(SPChallengeApplicantUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPChallengeApplicantPersistence persistence) {
	}

	private static SPChallengeApplicantPersistence _persistence;
}