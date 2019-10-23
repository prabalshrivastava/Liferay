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

package com.sambaash.platform.srv.mail.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.mail.model.SPEMailAudit;

import java.util.List;

/**
 * The persistence utility for the s p e mail audit service. This utility wraps {@link SPEMailAuditPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPEMailAuditPersistence
 * @see SPEMailAuditPersistenceImpl
 * @generated
 */
public class SPEMailAuditUtil {
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
	public static void clearCache(SPEMailAudit speMailAudit) {
		getPersistence().clearCache(speMailAudit);
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
	public static List<SPEMailAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPEMailAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPEMailAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPEMailAudit update(SPEMailAudit speMailAudit)
		throws SystemException {
		return getPersistence().update(speMailAudit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPEMailAudit update(SPEMailAudit speMailAudit,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(speMailAudit, serviceContext);
	}

	/**
	* Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @return the matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeId(
		long processStateId, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeId(processStateId, nodeId);
	}

	/**
	* Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @return the range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeId(
		long processStateId, long nodeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeId(processStateId, nodeId,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeId(
		long processStateId, long nodeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeId(processStateId, nodeId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeId_First(
		long processStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeId_First(processStateId, nodeId,
			orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeId_First(
		long processStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeId_First(processStateId,
			nodeId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeId_Last(
		long processStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeId_Last(processStateId, nodeId,
			orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeId_Last(
		long processStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeId_Last(processStateId, nodeId,
			orderByComparator);
	}

	/**
	* Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	*
	* @param spEMailAudit the primary key of the current s p e mail audit
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit[] findByProcessStateIdAndNodeId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeId_PrevAndNext(spEMailAudit,
			processStateId, nodeId, orderByComparator);
	}

	/**
	* Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; from the database.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStateIdAndNodeId(long processStateId,
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProcessStateIdAndNodeId(processStateId, nodeId);
	}

	/**
	* Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @return the number of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateIdAndNodeId(long processStateId,
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateIdAndNodeId(processStateId, nodeId);
	}

	/**
	* Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @return the matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserId(processStateId,
			nodeId, userId);
	}

	/**
	* Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @return the range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserId(processStateId,
			nodeId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserId(processStateId,
			nodeId, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeIdAndUserId_First(
		long processStateId, long nodeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserId_First(processStateId,
			nodeId, userId, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserId_First(
		long processStateId, long nodeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeIdAndUserId_First(processStateId,
			nodeId, userId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeIdAndUserId_Last(
		long processStateId, long nodeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserId_Last(processStateId,
			nodeId, userId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserId_Last(
		long processStateId, long nodeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeIdAndUserId_Last(processStateId,
			nodeId, userId, orderByComparator);
	}

	/**
	* Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param spEMailAudit the primary key of the current s p e mail audit
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit[] findByProcessStateIdAndNodeIdAndUserId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserId_PrevAndNext(spEMailAudit,
			processStateId, nodeId, userId, orderByComparator);
	}

	/**
	* Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; from the database.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProcessStateIdAndNodeIdAndUserId(processStateId, nodeId,
			userId);
	}

	/**
	* Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @return the number of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateIdAndNodeIdAndUserId(processStateId,
			nodeId, userId);
	}

	/**
	* Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @return the matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndOrgId(processStateId,
			nodeId, orgId);
	}

	/**
	* Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @return the range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndOrgId(processStateId,
			nodeId, orgId, start, end);
	}

	/**
	* Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndOrgId(processStateId,
			nodeId, orgId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeIdAndOrgId_First(
		long processStateId, long nodeId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndOrgId_First(processStateId,
			nodeId, orgId, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeIdAndOrgId_First(
		long processStateId, long nodeId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeIdAndOrgId_First(processStateId,
			nodeId, orgId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeIdAndOrgId_Last(
		long processStateId, long nodeId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndOrgId_Last(processStateId,
			nodeId, orgId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeIdAndOrgId_Last(
		long processStateId, long nodeId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeIdAndOrgId_Last(processStateId,
			nodeId, orgId, orderByComparator);
	}

	/**
	* Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param spEMailAudit the primary key of the current s p e mail audit
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit[] findByProcessStateIdAndNodeIdAndOrgId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndOrgId_PrevAndNext(spEMailAudit,
			processStateId, nodeId, orgId, orderByComparator);
	}

	/**
	* Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63; from the database.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProcessStateIdAndNodeIdAndOrgId(processStateId, nodeId,
			orgId);
	}

	/**
	* Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param orgId the org ID
	* @return the number of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateIdAndNodeIdAndOrgId(processStateId,
			nodeId, orgId);
	}

	/**
	* Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @return the matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId);
	}

	/**
	* Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @return the range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId, start, end);
	}

	/**
	* Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(
		long processStateId, long nodeId, long userId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(processStateId,
			nodeId, userId, orgId, orderByComparator);
	}

	/**
	* Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(
		long processStateId, long nodeId, long userId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(processStateId,
			nodeId, userId, orgId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(
		long processStateId, long nodeId, long userId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(processStateId,
			nodeId, userId, orgId, orderByComparator);
	}

	/**
	* Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(
		long processStateId, long nodeId, long userId, long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(processStateId,
			nodeId, userId, orgId, orderByComparator);
	}

	/**
	* Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param spEMailAudit the primary key of the current s p e mail audit
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit[] findByProcessStateIdAndNodeIdAndUserIdAndOrgId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId, long userId,
		long orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence()
				   .findByProcessStateIdAndNodeIdAndUserIdAndOrgId_PrevAndNext(spEMailAudit,
			processStateId, nodeId, userId, orgId, orderByComparator);
	}

	/**
	* Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63; from the database.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId);
	}

	/**
	* Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	*
	* @param processStateId the process state ID
	* @param nodeId the node ID
	* @param userId the user ID
	* @param orgId the org ID
	* @return the number of matching s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId);
	}

	/**
	* Caches the s p e mail audit in the entity cache if it is enabled.
	*
	* @param speMailAudit the s p e mail audit
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit) {
		getPersistence().cacheResult(speMailAudit);
	}

	/**
	* Caches the s p e mail audits in the entity cache if it is enabled.
	*
	* @param speMailAudits the s p e mail audits
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> speMailAudits) {
		getPersistence().cacheResult(speMailAudits);
	}

	/**
	* Creates a new s p e mail audit with the primary key. Does not add the s p e mail audit to the database.
	*
	* @param spEMailAudit the primary key for the new s p e mail audit
	* @return the new s p e mail audit
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit create(
		long spEMailAudit) {
		return getPersistence().create(spEMailAudit);
	}

	/**
	* Removes the s p e mail audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spEMailAudit the primary key of the s p e mail audit
	* @return the s p e mail audit that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit remove(
		long spEMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence().remove(spEMailAudit);
	}

	public static com.sambaash.platform.srv.mail.model.SPEMailAudit updateImpl(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(speMailAudit);
	}

	/**
	* Returns the s p e mail audit with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException} if it could not be found.
	*
	* @param spEMailAudit the primary key of the s p e mail audit
	* @return the s p e mail audit
	* @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit findByPrimaryKey(
		long spEMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException {
		return getPersistence().findByPrimaryKey(spEMailAudit);
	}

	/**
	* Returns the s p e mail audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spEMailAudit the primary key of the s p e mail audit
	* @return the s p e mail audit, or <code>null</code> if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPEMailAudit fetchByPrimaryKey(
		long spEMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spEMailAudit);
	}

	/**
	* Returns all the s p e mail audits.
	*
	* @return the s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p e mail audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @return the range of s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p e mail audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p e mail audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p e mail audits.
	*
	* @return the number of s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPEMailAuditPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPEMailAuditPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPEMailAuditPersistence.class.getName());

			ReferenceRegistry.registerReference(SPEMailAuditUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPEMailAuditPersistence persistence) {
	}

	private static SPEMailAuditPersistence _persistence;
}