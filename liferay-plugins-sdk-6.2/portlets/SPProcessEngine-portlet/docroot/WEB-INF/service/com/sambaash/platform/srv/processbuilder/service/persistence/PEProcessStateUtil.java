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

import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import java.util.List;

/**
 * The persistence utility for the p e process state service. This utility wraps {@link PEProcessStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatePersistence
 * @see PEProcessStatePersistenceImpl
 * @generated
 */
public class PEProcessStateUtil {
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
	public static void clearCache(PEProcessState peProcessState) {
		getPersistence().clearCache(peProcessState);
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
	public static List<PEProcessState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PEProcessState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PEProcessState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PEProcessState update(PEProcessState peProcessState)
		throws SystemException {
		return getPersistence().update(peProcessState);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PEProcessState update(PEProcessState peProcessState,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(peProcessState, serviceContext);
	}

	/**
	* Returns all the p e process states where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the p e process states where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where uuid = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByUuid_PrevAndNext(
		long spPEProcessStateId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spPEProcessStateId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the p e process states where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of p e process states where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the p e process state where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e process state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e process state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the p e process state where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e process state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of p e process states where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the p e process states where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the p e process states where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByUuid_C_PrevAndNext(
		long spPEProcessStateId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spPEProcessStateId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the p e process states where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of p e process states where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the p e process states where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserIdProcess(userIdProcess);
	}

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserIdProcess(userIdProcess, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcess(userIdProcess, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcess_First(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcess_First(userIdProcess, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcess_First(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcess_First(userIdProcess, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcess_Last(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcess_Last(userIdProcess, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcess_Last(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcess_Last(userIdProcess, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcess_PrevAndNext(
		long spPEProcessStateId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcess_PrevAndNext(spPEProcessStateId,
			userIdProcess, orderByComparator);
	}

	/**
	* Removes all the p e process states where userIdProcess = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserIdProcess(long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserIdProcess(userIdProcess);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserIdProcess(long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserIdProcess(userIdProcess);
	}

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessId(userIdProcess, spPEProcessId);
	}

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessId(userIdProcess,
			spPEProcessId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessId(userIdProcess,
			spPEProcessId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessId_First(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessId_First(userIdProcess,
			spPEProcessId, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessId_First(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessId_First(userIdProcess,
			spPEProcessId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessId_Last(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessId_Last(userIdProcess,
			spPEProcessId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessId_Last(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessId_Last(userIdProcess,
			spPEProcessId, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessId_PrevAndNext(spPEProcessStateId,
			userIdProcess, spPEProcessId, orderByComparator);
	}

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserIdProcessPEProcessId(long userIdProcess,
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByuserIdProcessPEProcessId(userIdProcess, spPEProcessId);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserIdProcessPEProcessId(long userIdProcess,
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByuserIdProcessPEProcessId(userIdProcess, spPEProcessId);
	}

	/**
	* Returns all the p e process states where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByPEProcessId(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPEProcessId(spPEProcessId);
	}

	/**
	* Returns a range of all the p e process states where spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByPEProcessId(
		long spPEProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPEProcessId(spPEProcessId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByPEProcessId(
		long spPEProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessId(spPEProcessId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPEProcessId_First(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByPEProcessId_First(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByPEProcessId_First(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessId_First(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPEProcessId_Last(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByPEProcessId_Last(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByPEProcessId_Last(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessId_Last(spPEProcessId, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByPEProcessId_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByPEProcessId_PrevAndNext(spPEProcessStateId,
			spPEProcessId, orderByComparator);
	}

	/**
	* Removes all the p e process states where spPEProcessId = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPEProcessId(long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPEProcessId(spPEProcessId);
	}

	/**
	* Returns the number of p e process states where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessId(long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPEProcessId(spPEProcessId);
	}

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId);
	}

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIClassId_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIClassId_First(userIdProcess,
			spPEProcessId, entityClassId, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIClassId_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessIClassId_First(userIdProcess,
			spPEProcessId, entityClassId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIClassId_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIClassId_Last(userIdProcess,
			spPEProcessId, entityClassId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIClassId_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessIClassId_Last(userIdProcess,
			spPEProcessId, entityClassId, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessIClassId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIClassId_PrevAndNext(spPEProcessStateId,
			userIdProcess, spPEProcessId, entityClassId, orderByComparator);
	}

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId);
	}

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus);
	}

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long entityClassId, long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(spPEProcessStateId,
			userIdProcess, spPEProcessId, entityClassId, entityId,
			activeStatus, orderByComparator);
	}

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus);
	}

	/**
	* Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByprocessStatePK(userIdProcess, spPEProcessId, entityId);
	}

	/**
	* Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStatePK(userIdProcess, spPEProcessId, entityId);
	}

	/**
	* Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStatePK(userIdProcess, spPEProcessId,
			entityId, retrieveFromCache);
	}

	/**
	* Removes the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the p e process state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState removeByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .removeByprocessStatePK(userIdProcess, spPEProcessId,
			entityId);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByprocessStatePK(long userIdProcess,
		long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByprocessStatePK(userIdProcess, spPEProcessId, entityId);
	}

	/**
	* Returns all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long spPEProcessId, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateLead(spPEProcessId, userIdProcess);
	}

	/**
	* Returns a range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long spPEProcessId, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateLead(spPEProcessId, userIdProcess, start,
			end);
	}

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long spPEProcessId, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateLead(spPEProcessId, userIdProcess, start,
			end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateLead_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByProcessStateLead_First(spPEProcessId, userIdProcess,
			orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateLead_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateLead_First(spPEProcessId, userIdProcess,
			orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateLead_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByProcessStateLead_Last(spPEProcessId, userIdProcess,
			orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateLead_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateLead_Last(spPEProcessId, userIdProcess,
			orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByProcessStateLead_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByProcessStateLead_PrevAndNext(spPEProcessStateId,
			spPEProcessId, userIdProcess, orderByComparator);
	}

	/**
	* Returns all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] spPEProcessIds, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateLead(spPEProcessIds, userIdProcess);
	}

	/**
	* Returns a range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] spPEProcessIds, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateLead(spPEProcessIds, userIdProcess,
			start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] spPEProcessIds, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateLead(spPEProcessIds, userIdProcess,
			start, end, orderByComparator);
	}

	/**
	* Removes all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStateLead(long spPEProcessId,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProcessStateLead(spPEProcessId, userIdProcess);
	}

	/**
	* Returns the number of p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateLead(long spPEProcessId,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateLead(spPEProcessId, userIdProcess);
	}

	/**
	* Returns the number of p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateLead(long[] spPEProcessIds,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateLead(spPEProcessIds, userIdProcess);
	}

	/**
	* Returns all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateOpportunity(spPEProcessId, userIdProcess);
	}

	/**
	* Returns a range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateOpportunity(spPEProcessId, userIdProcess,
			start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateOpportunity(spPEProcessId, userIdProcess,
			start, end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateOpportunity_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByProcessStateOpportunity_First(spPEProcessId,
			userIdProcess, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateOpportunity_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateOpportunity_First(spPEProcessId,
			userIdProcess, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateOpportunity_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByProcessStateOpportunity_Last(spPEProcessId,
			userIdProcess, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateOpportunity_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateOpportunity_Last(spPEProcessId,
			userIdProcess, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByProcessStateOpportunity_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByProcessStateOpportunity_PrevAndNext(spPEProcessStateId,
			spPEProcessId, userIdProcess, orderByComparator);
	}

	/**
	* Returns all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateOpportunity(spPEProcessIds, userIdProcess);
	}

	/**
	* Returns a range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateOpportunity(spPEProcessIds,
			userIdProcess, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateOpportunity(spPEProcessIds,
			userIdProcess, start, end, orderByComparator);
	}

	/**
	* Removes all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStateOpportunity(long spPEProcessId,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProcessStateOpportunity(spPEProcessId, userIdProcess);
	}

	/**
	* Returns the number of p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateOpportunity(long spPEProcessId,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateOpportunity(spPEProcessId, userIdProcess);
	}

	/**
	* Returns the number of p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateOpportunity(long[] spPEProcessIds,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateOpportunity(spPEProcessIds, userIdProcess);
	}

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId);
	}

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessStageId_First(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessStageId_First(userIdProcess,
			spPEProcessStageId, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessStageId_First(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessStageId_First(userIdProcess,
			spPEProcessStageId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessStageId_Last(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessStageId_Last(userIdProcess,
			spPEProcessStageId, orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessStageId_Last(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessPEProcessStageId_Last(userIdProcess,
			spPEProcessStageId, orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessStageId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessPEProcessStageId_PrevAndNext(spPEProcessStateId,
			userIdProcess, spPEProcessStageId, orderByComparator);
	}

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserIdProcessPEProcessStageId(long userIdProcess,
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId);
	}

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus);
	}

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus, start,
			end);
	}

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus, start,
			end, orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
			orderByComparator);
	}

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long sourceClassId, long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence()
				   .findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(spPEProcessStateId,
			userIdProcess, spPEProcessId, sourceClassId, sourceEntityID,
			activeStatus, orderByComparator);
	}

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus);
	}

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus);
	}

	/**
	* Caches the p e process state in the entity cache if it is enabled.
	*
	* @param peProcessState the p e process state
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState) {
		getPersistence().cacheResult(peProcessState);
	}

	/**
	* Caches the p e process states in the entity cache if it is enabled.
	*
	* @param peProcessStates the p e process states
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> peProcessStates) {
		getPersistence().cacheResult(peProcessStates);
	}

	/**
	* Creates a new p e process state with the primary key. Does not add the p e process state to the database.
	*
	* @param spPEProcessStateId the primary key for the new p e process state
	* @return the new p e process state
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState create(
		long spPEProcessStateId) {
		return getPersistence().create(spPEProcessStateId);
	}

	/**
	* Removes the p e process state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState remove(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence().remove(spPEProcessStateId);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(peProcessState);
	}

	/**
	* Returns the p e process state with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPrimaryKey(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException {
		return getPersistence().findByPrimaryKey(spPEProcessStateId);
	}

	/**
	* Returns the p e process state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state, or <code>null</code> if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByPrimaryKey(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spPEProcessStateId);
	}

	/**
	* Returns all the p e process states.
	*
	* @return the p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p e process states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p e process states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p e process states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p e process states.
	*
	* @return the number of p e process states
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PEProcessStatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PEProcessStatePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.getServletContextName(),
					PEProcessStatePersistence.class.getName());

			ReferenceRegistry.registerReference(PEProcessStateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PEProcessStatePersistence persistence) {
	}

	private static PEProcessStatePersistence _persistence;
}