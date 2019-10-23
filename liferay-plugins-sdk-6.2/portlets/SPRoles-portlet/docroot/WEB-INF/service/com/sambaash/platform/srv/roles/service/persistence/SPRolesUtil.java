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

package com.sambaash.platform.srv.roles.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.roles.model.SPRoles;

import java.util.List;

/**
 * The persistence utility for the s p roles service. This utility wraps {@link SPRolesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPRolesPersistence
 * @see SPRolesPersistenceImpl
 * @generated
 */
public class SPRolesUtil {
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
	public static void clearCache(SPRoles spRoles) {
		getPersistence().clearCache(spRoles);
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
	public static List<SPRoles> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPRoles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPRoles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPRoles update(SPRoles spRoles) throws SystemException {
		return getPersistence().update(spRoles);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPRoles update(SPRoles spRoles, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spRoles, serviceContext);
	}

	/**
	* Returns all the s p roleses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p roleses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where uuid = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByUuid_PrevAndNext(
		long spRoleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spRoleId, uuid, orderByComparator);
	}

	/**
	* Removes all the s p roleses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p roleses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p roles where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPRolesException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p roles where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p roles where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p roles where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p roles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p roleses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p roleses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the s p roleses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByUuid_C_PrevAndNext(
		long spRoleId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spRoleId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the s p roleses where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of s p roleses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleId(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoleId(groupId, roleId);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleId(
		long groupId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoleId(groupId, roleId, start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleId(
		long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleId(groupId, roleId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleId_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleId_First(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleId_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleId_First(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleId_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleId_Last(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleId_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleId_Last(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByRoleId_PrevAndNext(
		long spRoleId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleId_PrevAndNext(spRoleId, groupId, roleId,
			orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and roleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoleId(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoleId(groupId, roleId);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoleId(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoleId(groupId, roleId);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCategoryId1(
		long groupId, long categoryId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId1(groupId, categoryId1);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and categoryId1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCategoryId1(
		long groupId, long categoryId1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId1(groupId, categoryId1, start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and categoryId1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCategoryId1(
		long groupId, long categoryId1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId1(groupId, categoryId1, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByCategoryId1_First(
		long groupId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCategoryId1_First(groupId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByCategoryId1_First(
		long groupId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId1_First(groupId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByCategoryId1_Last(
		long groupId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCategoryId1_Last(groupId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByCategoryId1_Last(
		long groupId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId1_Last(groupId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByCategoryId1_PrevAndNext(
		long spRoleId, long groupId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCategoryId1_PrevAndNext(spRoleId, groupId,
			categoryId1, orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and categoryId1 = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId1(long groupId, long categoryId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId1(groupId, categoryId1);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId1 the category id1
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId1(long groupId, long categoryId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId1(groupId, categoryId1);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId1(
		long groupId, long roleId, long categoryId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleIdCategoryId1(groupId, roleId, categoryId1);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId1(
		long groupId, long roleId, long categoryId1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleIdCategoryId1(groupId, roleId, categoryId1,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId1(
		long groupId, long roleId, long categoryId1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleIdCategoryId1(groupId, roleId, categoryId1,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleIdCategoryId1_First(
		long groupId, long roleId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId1_First(groupId, roleId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleIdCategoryId1_First(
		long groupId, long roleId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleIdCategoryId1_First(groupId, roleId,
			categoryId1, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleIdCategoryId1_Last(
		long groupId, long roleId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId1_Last(groupId, roleId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleIdCategoryId1_Last(
		long groupId, long roleId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleIdCategoryId1_Last(groupId, roleId, categoryId1,
			orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByRoleIdCategoryId1_PrevAndNext(
		long spRoleId, long groupId, long roleId, long categoryId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId1_PrevAndNext(spRoleId, groupId,
			roleId, categoryId1, orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoleIdCategoryId1(groupId, roleId, categoryId1);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRoleIdCategoryId1(groupId, roleId, categoryId1);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId2(
		long groupId, long roleId, long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleIdCategoryId2(groupId, roleId, categoryId2);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId2(
		long groupId, long roleId, long categoryId2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleIdCategoryId2(groupId, roleId, categoryId2,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId2(
		long groupId, long roleId, long categoryId2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleIdCategoryId2(groupId, roleId, categoryId2,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleIdCategoryId2_First(
		long groupId, long roleId, long categoryId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId2_First(groupId, roleId, categoryId2,
			orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleIdCategoryId2_First(
		long groupId, long roleId, long categoryId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleIdCategoryId2_First(groupId, roleId,
			categoryId2, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleIdCategoryId2_Last(
		long groupId, long roleId, long categoryId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId2_Last(groupId, roleId, categoryId2,
			orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleIdCategoryId2_Last(
		long groupId, long roleId, long categoryId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleIdCategoryId2_Last(groupId, roleId, categoryId2,
			orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByRoleIdCategoryId2_PrevAndNext(
		long spRoleId, long groupId, long roleId, long categoryId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId2_PrevAndNext(spRoleId, groupId,
			roleId, categoryId2, orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoleIdCategoryId2(groupId, roleId, categoryId2);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId2 the category id2
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRoleIdCategoryId2(groupId, roleId, categoryId2);
	}

	/**
	* Returns the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPRolesException} if it could not be found.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param categoryId2 the category id2
	* @return the matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleIdCategoryId1AndCategoryId2(
		long groupId, long roleId, long categoryId1, long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2);
	}

	/**
	* Returns the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param categoryId2 the category id2
	* @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleIdCategoryId1AndCategoryId2(
		long groupId, long roleId, long categoryId1, long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2);
	}

	/**
	* Returns the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param categoryId2 the category id2
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByRoleIdCategoryId1AndCategoryId2(
		long groupId, long roleId, long categoryId1, long categoryId2,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2, retrieveFromCache);
	}

	/**
	* Removes the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param categoryId2 the category id2
	* @return the s p roles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles removeByRoleIdCategoryId1AndCategoryId2(
		long groupId, long roleId, long categoryId1, long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .removeByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param categoryId1 the category id1
	* @param categoryId2 the category id2
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoleIdCategoryId1AndCategoryId2(long groupId,
		long roleId, long categoryId1, long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryId(
		long groupId, long countryCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryCategoryId(groupId, countryCategoryId);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryId(
		long groupId, long countryCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryCategoryId(groupId, countryCategoryId, start,
			end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryId(
		long groupId, long countryCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryCategoryId(groupId, countryCategoryId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByCountryCategoryId_First(
		long groupId, long countryCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCountryCategoryId_First(groupId, countryCategoryId,
			orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByCountryCategoryId_First(
		long groupId, long countryCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryCategoryId_First(groupId, countryCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByCountryCategoryId_Last(
		long groupId, long countryCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCountryCategoryId_Last(groupId, countryCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByCountryCategoryId_Last(
		long groupId, long countryCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryCategoryId_Last(groupId, countryCategoryId,
			orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByCountryCategoryId_PrevAndNext(
		long spRoleId, long groupId, long countryCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCountryCategoryId_PrevAndNext(spRoleId, groupId,
			countryCategoryId, orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and countryCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryCategoryId(long groupId,
		long countryCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountryCategoryId(groupId, countryCategoryId);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryCategoryId(long groupId,
		long countryCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryCategoryId(groupId, countryCategoryId);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByDepartmentCategoryId(
		long groupId, long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentCategoryId(groupId, departmentCategoryId);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByDepartmentCategoryId(
		long groupId, long departmentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentCategoryId(groupId, departmentCategoryId,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByDepartmentCategoryId(
		long groupId, long departmentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentCategoryId(groupId, departmentCategoryId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByDepartmentCategoryId_First(
		long groupId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByDepartmentCategoryId_First(groupId,
			departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByDepartmentCategoryId_First(
		long groupId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentCategoryId_First(groupId,
			departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByDepartmentCategoryId_Last(
		long groupId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByDepartmentCategoryId_Last(groupId,
			departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByDepartmentCategoryId_Last(
		long groupId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentCategoryId_Last(groupId,
			departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByDepartmentCategoryId_PrevAndNext(
		long spRoleId, long groupId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByDepartmentCategoryId_PrevAndNext(spRoleId, groupId,
			departmentCategoryId, orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and departmentCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentCategoryId(long groupId,
		long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByDepartmentCategoryId(groupId, departmentCategoryId);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentCategoryId the department category ID
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentCategoryId(long groupId,
		long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentCategoryId(groupId, departmentCategoryId);
	}

	/**
	* Returns all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @return the matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId);
	}

	/**
	* Returns a range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByCountryCategoryIdAndDepartmentCategoryId_First(
		long groupId, long countryCategoryId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCountryCategoryIdAndDepartmentCategoryId_First(groupId,
			countryCategoryId, departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByCountryCategoryIdAndDepartmentCategoryId_First(
		long groupId, long countryCategoryId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryCategoryIdAndDepartmentCategoryId_First(groupId,
			countryCategoryId, departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByCountryCategoryIdAndDepartmentCategoryId_Last(
		long groupId, long countryCategoryId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCountryCategoryIdAndDepartmentCategoryId_Last(groupId,
			countryCategoryId, departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByCountryCategoryIdAndDepartmentCategoryId_Last(
		long groupId, long countryCategoryId, long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryCategoryIdAndDepartmentCategoryId_Last(groupId,
			countryCategoryId, departmentCategoryId, orderByComparator);
	}

	/**
	* Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param spRoleId the primary key of the current s p roles
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles[] findByCountryCategoryIdAndDepartmentCategoryId_PrevAndNext(
		long spRoleId, long groupId, long countryCategoryId,
		long departmentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence()
				   .findByCountryCategoryIdAndDepartmentCategoryId_PrevAndNext(spRoleId,
			groupId, countryCategoryId, departmentCategoryId, orderByComparator);
	}

	/**
	* Removes all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId);
	}

	/**
	* Returns the number of s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryCategoryId the country category ID
	* @param departmentCategoryId the department category ID
	* @return the number of matching s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId);
	}

	/**
	* Caches the s p roles in the entity cache if it is enabled.
	*
	* @param spRoles the s p roles
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.roles.model.SPRoles spRoles) {
		getPersistence().cacheResult(spRoles);
	}

	/**
	* Caches the s p roleses in the entity cache if it is enabled.
	*
	* @param spRoleses the s p roleses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> spRoleses) {
		getPersistence().cacheResult(spRoleses);
	}

	/**
	* Creates a new s p roles with the primary key. Does not add the s p roles to the database.
	*
	* @param spRoleId the primary key for the new s p roles
	* @return the new s p roles
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles create(
		long spRoleId) {
		return getPersistence().create(spRoleId);
	}

	/**
	* Removes the s p roles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRoleId the primary key of the s p roles
	* @return the s p roles that was removed
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles remove(
		long spRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence().remove(spRoleId);
	}

	public static com.sambaash.platform.srv.roles.model.SPRoles updateImpl(
		com.sambaash.platform.srv.roles.model.SPRoles spRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spRoles);
	}

	/**
	* Returns the s p roles with the primary key or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPRolesException} if it could not be found.
	*
	* @param spRoleId the primary key of the s p roles
	* @return the s p roles
	* @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles findByPrimaryKey(
		long spRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getPersistence().findByPrimaryKey(spRoleId);
	}

	/**
	* Returns the s p roles with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spRoleId the primary key of the s p roles
	* @return the s p roles, or <code>null</code> if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchByPrimaryKey(
		long spRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spRoleId);
	}

	/**
	* Returns all the s p roleses.
	*
	* @return the s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p roleses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p roleses.
	*
	* @return the number of s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPRolesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPRolesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.roles.service.ClpSerializer.getServletContextName(),
					SPRolesPersistence.class.getName());

			ReferenceRegistry.registerReference(SPRolesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPRolesPersistence persistence) {
	}

	private static SPRolesPersistence _persistence;
}