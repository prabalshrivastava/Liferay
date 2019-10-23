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

package com.sambaash.platform.srv.legalandcontract.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.legalandcontract.model.RDL;

import java.util.List;

/**
 * The persistence utility for the r d l service. This utility wraps {@link RDLPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see RDLPersistence
 * @see RDLPersistenceImpl
 * @generated
 */
public class RDLUtil {
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
	public static void clearCache(RDL rdl) {
		getPersistence().clearCache(rdl);
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
	public static List<RDL> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RDL> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RDL> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RDL update(RDL rdl) throws SystemException {
		return getPersistence().update(rdl);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RDL update(RDL rdl, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(rdl, serviceContext);
	}

	/**
	* Returns all the r d ls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the r d ls where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @return the range of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the r d ls where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the r d ls before and after the current r d l in the ordered set where uuid = &#63;.
	*
	* @param spRdlId the primary key of the current r d l
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL[] findByUuid_PrevAndNext(
		long spRdlId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spRdlId, uuid, orderByComparator);
	}

	/**
	* Removes all the r d ls where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of r d ls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the r d l where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the r d l where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the r d l where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the r d l where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the r d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of r d ls where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the r d ls where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the r d ls where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @return the range of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the r d ls where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the r d ls before and after the current r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spRdlId the primary key of the current r d l
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL[] findByUuid_C_PrevAndNext(
		long spRdlId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spRdlId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the r d ls where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of r d ls where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByRdlIdLitigationId(
		long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().findByRdlIdLitigationId(spRdlId, spLitigationId);
	}

	/**
	* Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByRdlIdLitigationId(
		long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRdlIdLitigationId(spRdlId, spLitigationId);
	}

	/**
	* Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByRdlIdLitigationId(
		long spRdlId, long spLitigationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRdlIdLitigationId(spRdlId, spLitigationId,
			retrieveFromCache);
	}

	/**
	* Removes the r d l where spRdlId = &#63; and spLitigationId = &#63; from the database.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the r d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL removeByRdlIdLitigationId(
		long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .removeByRdlIdLitigationId(spRdlId, spLitigationId);
	}

	/**
	* Returns the number of r d ls where spRdlId = &#63; and spLitigationId = &#63;.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRdlIdLitigationId(long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRdlIdLitigationId(spRdlId, spLitigationId);
	}

	/**
	* Returns all the r d ls where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @return the matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylitigationId(spLitigationId);
	}

	/**
	* Returns a range of all the r d ls where spLitigationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spLitigationId the sp litigation ID
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @return the range of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long spLitigationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylitigationId(spLitigationId, start, end);
	}

	/**
	* Returns an ordered range of all the r d ls where spLitigationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spLitigationId the sp litigation ID
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long spLitigationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylitigationId(spLitigationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findBylitigationId_First(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findBylitigationId_First(spLitigationId, orderByComparator);
	}

	/**
	* Returns the first r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchBylitigationId_First(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylitigationId_First(spLitigationId, orderByComparator);
	}

	/**
	* Returns the last r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findBylitigationId_Last(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findBylitigationId_Last(spLitigationId, orderByComparator);
	}

	/**
	* Returns the last r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchBylitigationId_Last(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylitigationId_Last(spLitigationId, orderByComparator);
	}

	/**
	* Returns the r d ls before and after the current r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spRdlId the primary key of the current r d l
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL[] findBylitigationId_PrevAndNext(
		long spRdlId, long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence()
				   .findBylitigationId_PrevAndNext(spRdlId, spLitigationId,
			orderByComparator);
	}

	/**
	* Removes all the r d ls where spLitigationId = &#63; from the database.
	*
	* @param spLitigationId the sp litigation ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylitigationId(long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylitigationId(spLitigationId);
	}

	/**
	* Returns the number of r d ls where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylitigationId(long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylitigationId(spLitigationId);
	}

	/**
	* Caches the r d l in the entity cache if it is enabled.
	*
	* @param rdl the r d l
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl) {
		getPersistence().cacheResult(rdl);
	}

	/**
	* Caches the r d ls in the entity cache if it is enabled.
	*
	* @param rdls the r d ls
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> rdls) {
		getPersistence().cacheResult(rdls);
	}

	/**
	* Creates a new r d l with the primary key. Does not add the r d l to the database.
	*
	* @param spRdlId the primary key for the new r d l
	* @return the new r d l
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL create(
		long spRdlId) {
		return getPersistence().create(spRdlId);
	}

	/**
	* Removes the r d l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL remove(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().remove(spRdlId);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.RDL updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rdl);
	}

	/**
	* Returns the r d l with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL findByPrimaryKey(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException {
		return getPersistence().findByPrimaryKey(spRdlId);
	}

	/**
	* Returns the r d l with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l, or <code>null</code> if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchByPrimaryKey(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spRdlId);
	}

	/**
	* Returns all the r d ls.
	*
	* @return the r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the r d ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @return the range of r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the r d ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the r d ls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of r d ls.
	*
	* @return the number of r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RDLPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RDLPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.getServletContextName(),
					RDLPersistence.class.getName());

			ReferenceRegistry.registerReference(RDLUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RDLPersistence persistence) {
	}

	private static RDLPersistence _persistence;
}