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

import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;

import java.util.List;

/**
 * The persistence utility for the p e process audit service. This utility wraps {@link PEProcessAuditPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessAuditPersistence
 * @see PEProcessAuditPersistenceImpl
 * @generated
 */
public class PEProcessAuditUtil {
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
	public static void clearCache(PEProcessAudit peProcessAudit) {
		getPersistence().clearCache(peProcessAudit);
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
	public static List<PEProcessAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PEProcessAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PEProcessAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PEProcessAudit update(PEProcessAudit peProcessAudit)
		throws SystemException {
		return getPersistence().update(peProcessAudit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PEProcessAudit update(PEProcessAudit peProcessAudit,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(peProcessAudit, serviceContext);
	}

	/**
	* Returns all the p e process audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the p e process audits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where uuid = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByUuid_PrevAndNext(
		long spPEProcessAuditId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spPEProcessAuditId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the p e process audits where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of p e process audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the p e process audit where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e process audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e process audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the p e process audit where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of p e process audits where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByUuid_C_PrevAndNext(
		long spPEProcessAuditId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spPEProcessAuditId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateId(spPEProcessStateId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateId(spPEProcessStateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateId_First(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateId_First(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateId_First(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateId_First(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateId_Last(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateId_Last(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateId_Last(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateId_Last(spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateId_PrevAndNext(spPEProcessAuditId,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPEProcessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdFormId(spPEProcessStateId, field2);
	}

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, java.lang.String field2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdFormId(spPEProcessStateId, field2,
			start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, java.lang.String field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdFormId(spPEProcessStateId, field2,
			start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdFormId_First(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdFormId_First(spPEProcessStateId,
			field2, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdFormId_First(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdFormId_First(spPEProcessStateId,
			field2, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdFormId_Last(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdFormId_Last(spPEProcessStateId,
			field2, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdFormId_Last(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdFormId_Last(spPEProcessStateId,
			field2, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdFormId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdFormId_PrevAndNext(spPEProcessAuditId,
			spPEProcessStateId, field2, orderByComparator);
	}

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPEProcessStateIdFormId(long spPEProcessStateId,
		java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPEProcessStateIdFormId(spPEProcessStateId, field2);
	}

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateIdFormId(long spPEProcessStateId,
		java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPEProcessStateIdFormId(spPEProcessStateId, field2);
	}

	/**
	* Returns all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypePEProcessStateId(
		java.lang.String type, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypePEProcessStateId(type, spPEProcessStateId);
	}

	/**
	* Returns a range of all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypePEProcessStateId(
		java.lang.String type, long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypePEProcessStateId(type, spPEProcessStateId, start,
			end);
	}

	/**
	* Returns an ordered range of all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypePEProcessStateId(
		java.lang.String type, long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypePEProcessStateId(type, spPEProcessStateId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypePEProcessStateId_First(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByTypePEProcessStateId_First(type, spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypePEProcessStateId_First(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypePEProcessStateId_First(type, spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypePEProcessStateId_Last(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByTypePEProcessStateId_Last(type, spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypePEProcessStateId_Last(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypePEProcessStateId_Last(type, spPEProcessStateId,
			orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByTypePEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, java.lang.String type,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByTypePEProcessStateId_PrevAndNext(spPEProcessAuditId,
			type, spPEProcessStateId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where type = &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypePEProcessStateId(java.lang.String type,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypePEProcessStateId(type, spPEProcessStateId);
	}

	/**
	* Returns the number of p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypePEProcessStateId(java.lang.String type,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTypePEProcessStateId(type, spPEProcessStateId);
	}

	/**
	* Returns all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId);
	}

	/**
	* Returns a range of all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdTypeCreateDateLT_First(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdTypeCreateDateLT_First(type,
			createDate, spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeCreateDateLT_First(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdTypeCreateDateLT_First(type,
			createDate, spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdTypeCreateDateLT_Last(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdTypeCreateDateLT_Last(type,
			createDate, spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeCreateDateLT_Last(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdTypeCreateDateLT_Last(type,
			createDate, spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdTypeCreateDateLT_PrevAndNext(
		long spPEProcessAuditId, java.lang.String type,
		java.util.Date createDate, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdTypeCreateDateLT_PrevAndNext(spPEProcessAuditId,
			type, createDate, spPEProcessStateId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId);
	}

	/**
	* Returns the number of p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId);
	}

	/**
	* Returns all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByDoneByPEProcessStateId(
		java.lang.String doneBy, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDoneByPEProcessStateId(doneBy, spPEProcessStateId);
	}

	/**
	* Returns a range of all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByDoneByPEProcessStateId(
		java.lang.String doneBy, long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDoneByPEProcessStateId(doneBy, spPEProcessStateId,
			start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByDoneByPEProcessStateId(
		java.lang.String doneBy, long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDoneByPEProcessStateId(doneBy, spPEProcessStateId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByDoneByPEProcessStateId_First(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByDoneByPEProcessStateId_First(doneBy,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByDoneByPEProcessStateId_First(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDoneByPEProcessStateId_First(doneBy,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByDoneByPEProcessStateId_Last(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByDoneByPEProcessStateId_Last(doneBy,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByDoneByPEProcessStateId_Last(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDoneByPEProcessStateId_Last(doneBy,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByDoneByPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, java.lang.String doneBy,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByDoneByPEProcessStateId_PrevAndNext(spPEProcessAuditId,
			doneBy, spPEProcessStateId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDoneByPEProcessStateId(java.lang.String doneBy,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByDoneByPEProcessStateId(doneBy, spPEProcessStateId);
	}

	/**
	* Returns the number of p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDoneByPEProcessStateId(java.lang.String doneBy,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDoneByPEProcessStateId(doneBy, spPEProcessStateId);
	}

	/**
	* Returns all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeActionPEProcessStateId(type, action,
			spPEProcessStateId);
	}

	/**
	* Returns a range of all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeActionPEProcessStateId(type, action,
			spPEProcessStateId, start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeActionPEProcessStateId(type, action,
			spPEProcessStateId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypeActionPEProcessStateId_First(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByTypeActionPEProcessStateId_First(type, action,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypeActionPEProcessStateId_First(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeActionPEProcessStateId_First(type, action,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypeActionPEProcessStateId_Last(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByTypeActionPEProcessStateId_Last(type, action,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypeActionPEProcessStateId_Last(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeActionPEProcessStateId_Last(type, action,
			spPEProcessStateId, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByTypeActionPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, java.lang.String type,
		java.lang.String action, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByTypeActionPEProcessStateId_PrevAndNext(spPEProcessAuditId,
			type, action, spPEProcessStateId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTypeActionPEProcessStateId(type, action, spPEProcessStateId);
	}

	/**
	* Returns the number of p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeActionPEProcessStateId(java.lang.String type,
		java.lang.String action, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTypeActionPEProcessStateId(type, action,
			spPEProcessStateId);
	}

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdTypeField2(spPEProcessStateId, type,
			field2);
	}

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdTypeField2(spPEProcessStateId, type,
			field2);
	}

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type,
		java.lang.String field2, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdTypeField2(spPEProcessStateId, type,
			field2, retrieveFromCache);
	}

	/**
	* Removes the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit removeByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .removeByPEProcessStateIdTypeField2(spPEProcessStateId,
			type, field2);
	}

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPEProcessStateIdTypeField2(spPEProcessStateId, type,
			field2);
	}

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdNodeId(spPEProcessStateId, nodeId);
	}

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdNodeId(spPEProcessStateId, nodeId,
			start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdNodeId(spPEProcessStateId, nodeId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdNodeId_First(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdNodeId_First(spPEProcessStateId,
			nodeId, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeId_First(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdNodeId_First(spPEProcessStateId,
			nodeId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdNodeId_Last(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdNodeId_Last(spPEProcessStateId,
			nodeId, orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeId_Last(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdNodeId_Last(spPEProcessStateId,
			nodeId, orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdNodeId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdNodeId_PrevAndNext(spPEProcessAuditId,
			spPEProcessStateId, nodeId, orderByComparator);
	}

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPEProcessStateIdNodeId(long spPEProcessStateId,
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPEProcessStateIdNodeId(spPEProcessStateId, nodeId);
	}

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateIdNodeId(long spPEProcessStateId,
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPEProcessStateIdNodeId(spPEProcessStateId, nodeId);
	}

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdType(spPEProcessStateId, type);
	}

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdType(spPEProcessStateId, type, start,
			end);
	}

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPEProcessStateIdType(spPEProcessStateId, type, start,
			end, orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdType_First(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdType_First(spPEProcessStateId, type,
			orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdType_First(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdType_First(spPEProcessStateId, type,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdType_Last(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdType_Last(spPEProcessStateId, type,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdType_Last(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdType_Last(spPEProcessStateId, type,
			orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdType_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdType_PrevAndNext(spPEProcessAuditId,
			spPEProcessStateId, type, orderByComparator);
	}

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; and type = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPEProcessStateIdType(long spPEProcessStateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPEProcessStateIdType(spPEProcessStateId, type);
	}

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateIdType(long spPEProcessStateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPEProcessStateIdType(spPEProcessStateId, type);
	}

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByPEProcessStateIdNodeIdAction(spPEProcessStateId,
			nodeId, action);
	}

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdNodeIdAction(spPEProcessStateId,
			nodeId, action);
	}

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPEProcessStateIdNodeIdAction(spPEProcessStateId,
			nodeId, action, retrieveFromCache);
	}

	/**
	* Removes the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit removeByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .removeByPEProcessStateIdNodeIdAction(spPEProcessStateId,
			nodeId, action);
	}

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPEProcessStateIdNodeIdAction(spPEProcessStateId,
			nodeId, action);
	}

	/**
	* Returns all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActionTypeField2(action, type, field2);
	}

	/**
	* Returns a range of all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type,
		java.lang.String field2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActionTypeField2(action, type, field2, start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type,
		java.lang.String field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActionTypeField2(action, type, field2, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByActionTypeField2_First(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByActionTypeField2_First(action, type, field2,
			orderByComparator);
	}

	/**
	* Returns the first p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByActionTypeField2_First(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActionTypeField2_First(action, type, field2,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByActionTypeField2_Last(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByActionTypeField2_Last(action, type, field2,
			orderByComparator);
	}

	/**
	* Returns the last p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByActionTypeField2_Last(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActionTypeField2_Last(action, type, field2,
			orderByComparator);
	}

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByActionTypeField2_PrevAndNext(
		long spPEProcessAuditId, java.lang.String action,
		java.lang.String type, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence()
				   .findByActionTypeField2_PrevAndNext(spPEProcessAuditId,
			action, type, field2, orderByComparator);
	}

	/**
	* Removes all the p e process audits where action = &#63; and type = &#63; and field2 = &#63; from the database.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActionTypeField2(java.lang.String action,
		java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActionTypeField2(action, type, field2);
	}

	/**
	* Returns the number of p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActionTypeField2(java.lang.String action,
		java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActionTypeField2(action, type, field2);
	}

	/**
	* Caches the p e process audit in the entity cache if it is enabled.
	*
	* @param peProcessAudit the p e process audit
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit) {
		getPersistence().cacheResult(peProcessAudit);
	}

	/**
	* Caches the p e process audits in the entity cache if it is enabled.
	*
	* @param peProcessAudits the p e process audits
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> peProcessAudits) {
		getPersistence().cacheResult(peProcessAudits);
	}

	/**
	* Creates a new p e process audit with the primary key. Does not add the p e process audit to the database.
	*
	* @param spPEProcessAuditId the primary key for the new p e process audit
	* @return the new p e process audit
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit create(
		long spPEProcessAuditId) {
		return getPersistence().create(spPEProcessAuditId);
	}

	/**
	* Removes the p e process audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit remove(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence().remove(spPEProcessAuditId);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(peProcessAudit);
	}

	/**
	* Returns the p e process audit with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPrimaryKey(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException {
		return getPersistence().findByPrimaryKey(spPEProcessAuditId);
	}

	/**
	* Returns the p e process audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit, or <code>null</code> if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPrimaryKey(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spPEProcessAuditId);
	}

	/**
	* Returns all the p e process audits.
	*
	* @return the p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p e process audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p e process audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p e process audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p e process audits.
	*
	* @return the number of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PEProcessAuditPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PEProcessAuditPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.getServletContextName(),
					PEProcessAuditPersistence.class.getName());

			ReferenceRegistry.registerReference(PEProcessAuditUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PEProcessAuditPersistence persistence) {
	}

	private static PEProcessAuditPersistence _persistence;
}