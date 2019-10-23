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

package com.sambaash.platform.srv.processbuilder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.processbuilder.model.PEProcess;

import java.util.List;

/**
 * The persistence utility for the p e process service. This utility wraps {@link PEProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessPersistence
 * @see PEProcessPersistenceImpl
 * @generated
 */
public class PEProcessUtil {
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
	public static void clearCache(PEProcess peProcess) {
		getPersistence().clearCache(peProcess);
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
	public static List<PEProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PEProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PEProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PEProcess update(PEProcess peProcess)
		throws SystemException {
		return getPersistence().update(peProcess);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PEProcess update(PEProcess peProcess,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(peProcess, serviceContext);
	}

	/**
	* Returns all the p e processes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the p e processes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the p e processes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the p e processes before and after the current p e process in the ordered set where uuid = &#63;.
	*
	* @param spPEProcessId the primary key of the current p e process
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess[] findByUuid_PrevAndNext(
		long spPEProcessId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spPEProcessId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the p e processes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of p e processes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the p e process where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the p e process where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of p e processes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the p e processes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the p e processes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the p e processes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the p e processes before and after the current p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEProcessId the primary key of the current p e process
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess[] findByUuid_C_PrevAndNext(
		long spPEProcessId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spPEProcessId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the p e processes where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of p e processes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the p e processes where status = &#63;.
	*
	* @param status the status
	* @return the matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findBystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the p e processes where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the p e processes where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findBystatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchBystatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findBystatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchBystatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the p e processes before and after the current p e process in the ordered set where status = &#63;.
	*
	* @param spPEProcessId the primary key of the current p e process
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess[] findBystatus_PrevAndNext(
		long spPEProcessId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findBystatus_PrevAndNext(spPEProcessId, status,
			orderByComparator);
	}

	/**
	* Removes all the p e processes where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of p e processes where status = &#63;.
	*
	* @param status the status
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Returns all the p e processes where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @return the matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByspPEProcessIds(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByspPEProcessIds(spPEProcessId);
	}

	/**
	* Returns a range of all the p e processes where spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByspPEProcessIds(
		long spPEProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByspPEProcessIds(spPEProcessId, start, end);
	}

	/**
	* Returns an ordered range of all the p e processes where spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByspPEProcessIds(
		long spPEProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByspPEProcessIds(spPEProcessId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByspPEProcessIds_First(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findByspPEProcessIds_First(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the first p e process in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByspPEProcessIds_First(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByspPEProcessIds_First(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByspPEProcessIds_Last(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence()
				   .findByspPEProcessIds_Last(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the last p e process in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByspPEProcessIds_Last(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByspPEProcessIds_Last(spPEProcessId, orderByComparator);
	}

	/**
	* Returns all the p e processes where spPEProcessId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @return the matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByspPEProcessIds(
		long[] spPEProcessIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByspPEProcessIds(spPEProcessIds);
	}

	/**
	* Returns a range of all the p e processes where spPEProcessId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByspPEProcessIds(
		long[] spPEProcessIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByspPEProcessIds(spPEProcessIds, start, end);
	}

	/**
	* Returns an ordered range of all the p e processes where spPEProcessId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByspPEProcessIds(
		long[] spPEProcessIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByspPEProcessIds(spPEProcessIds, start, end,
			orderByComparator);
	}

	/**
	* Removes all the p e processes where spPEProcessId = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByspPEProcessIds(long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByspPEProcessIds(spPEProcessId);
	}

	/**
	* Returns the number of p e processes where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByspPEProcessIds(long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByspPEProcessIds(spPEProcessId);
	}

	/**
	* Returns the number of p e processes where spPEProcessId = any &#63;.
	*
	* @param spPEProcessIds the sp p e process IDs
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByspPEProcessIds(long[] spPEProcessIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByspPEProcessIds(spPEProcessIds);
	}

	/**
	* Returns the p e process where name = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException} if it could not be found.
	*
	* @param name the name
	* @return the matching p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByProcessName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findByProcessName(name);
	}

	/**
	* Returns the p e process where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByProcessName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProcessName(name);
	}

	/**
	* Returns the p e process where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByProcessName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProcessName(name, retrieveFromCache);
	}

	/**
	* Removes the p e process where name = &#63; from the database.
	*
	* @param name the name
	* @return the p e process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess removeByProcessName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().removeByProcessName(name);
	}

	/**
	* Returns the number of p e processes where name = &#63;.
	*
	* @param name the name
	* @return the number of matching p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProcessName(name);
	}

	/**
	* Caches the p e process in the entity cache if it is enabled.
	*
	* @param peProcess the p e process
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess) {
		getPersistence().cacheResult(peProcess);
	}

	/**
	* Caches the p e processes in the entity cache if it is enabled.
	*
	* @param peProcesses the p e processes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> peProcesses) {
		getPersistence().cacheResult(peProcesses);
	}

	/**
	* Creates a new p e process with the primary key. Does not add the p e process to the database.
	*
	* @param spPEProcessId the primary key for the new p e process
	* @return the new p e process
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess create(
		long spPEProcessId) {
		return getPersistence().create(spPEProcessId);
	}

	/**
	* Removes the p e process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessId the primary key of the p e process
	* @return the p e process that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess remove(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().remove(spPEProcessId);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcess updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(peProcess);
	}

	/**
	* Returns the p e process with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException} if it could not be found.
	*
	* @param spPEProcessId the primary key of the p e process
	* @return the p e process
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByPrimaryKey(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getPersistence().findByPrimaryKey(spPEProcessId);
	}

	/**
	* Returns the p e process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEProcessId the primary key of the p e process
	* @return the p e process, or <code>null</code> if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchByPrimaryKey(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spPEProcessId);
	}

	/**
	* Returns all the p e processes.
	*
	* @return the p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p e processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p e processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p e processes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p e processes.
	*
	* @return the number of p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PEProcessPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PEProcessPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.getServletContextName(),
					PEProcessPersistence.class.getName());

			ReferenceRegistry.registerReference(PEProcessUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PEProcessPersistence persistence) {
	}

	private static PEProcessPersistence _persistence;
}