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

package com.sambaash.platform.srv.spinbox.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spinbox.model.IBMessage;

import java.util.List;

/**
 * The persistence utility for the i b message service. This utility wraps {@link IBMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessagePersistence
 * @see IBMessagePersistenceImpl
 * @generated
 */
public class IBMessageUtil {
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
	public static void clearCache(IBMessage ibMessage) {
		getPersistence().clearCache(ibMessage);
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
	public static List<IBMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IBMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IBMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static IBMessage update(IBMessage ibMessage)
		throws SystemException {
		return getPersistence().update(ibMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static IBMessage update(IBMessage ibMessage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ibMessage, serviceContext);
	}

	/**
	* Returns all the i b messages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the i b messages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the i b messages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where uuid = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage[] findByUuid_PrevAndNext(
		long messageId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByUuid_PrevAndNext(messageId, uuid, orderByComparator);
	}

	/**
	* Removes all the i b messages where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of i b messages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the i b message where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the i b message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the i b message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the i b message where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the i b message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of i b messages where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the i b messages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the i b messages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the i b messages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage[] findByUuid_C_PrevAndNext(
		long messageId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(messageId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the i b messages where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of i b messages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		java.lang.String createByUserId, boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreateUserId(createByUserId, deleteStatus);
	}

	/**
	* Returns a range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		java.lang.String createByUserId, boolean deleteStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreateUserId(createByUserId, deleteStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		java.lang.String createByUserId, boolean deleteStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreateUserId(createByUserId, deleteStatus, start,
			end, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserId_First(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreateUserId_First(createByUserId, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserId_First(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreateUserId_First(createByUserId, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserId_Last(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreateUserId_Last(createByUserId, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserId_Last(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreateUserId_Last(createByUserId, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreateUserId_PrevAndNext(
		long messageId, java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreateUserId_PrevAndNext(messageId, createByUserId,
			deleteStatus, orderByComparator);
	}

	/**
	* Removes all the i b messages where createByUserId = &#63; and deleteStatus = &#63; from the database.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreateUserId(java.lang.String createByUserId,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreateUserId(createByUserId, deleteStatus);
	}

	/**
	* Returns the number of i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreateUserId(java.lang.String createByUserId,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreateUserId(createByUserId, deleteStatus);
	}

	/**
	* Returns all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreateUserIdAndDraft(createByUserId, deleteStatus,
			draft);
	}

	/**
	* Returns a range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreateUserIdAndDraft(createByUserId, deleteStatus,
			draft, start, end);
	}

	/**
	* Returns an ordered range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreateUserIdAndDraft(createByUserId, deleteStatus,
			draft, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserIdAndDraft_First(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreateUserIdAndDraft_First(createByUserId,
			deleteStatus, draft, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserIdAndDraft_First(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreateUserIdAndDraft_First(createByUserId,
			deleteStatus, draft, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserIdAndDraft_Last(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreateUserIdAndDraft_Last(createByUserId,
			deleteStatus, draft, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserIdAndDraft_Last(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreateUserIdAndDraft_Last(createByUserId,
			deleteStatus, draft, orderByComparator);
	}

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreateUserIdAndDraft_PrevAndNext(
		long messageId, java.lang.String createByUserId, boolean deleteStatus,
		boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreateUserIdAndDraft_PrevAndNext(messageId,
			createByUserId, deleteStatus, draft, orderByComparator);
	}

	/**
	* Removes all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63; from the database.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCreateUserIdAndDraft(createByUserId, deleteStatus, draft);
	}

	/**
	* Returns the number of i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCreateUserIdAndDraft(createByUserId, deleteStatus,
			draft);
	}

	/**
	* Returns all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		java.lang.String createBy, boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreatorName(createBy, deleteStatus);
	}

	/**
	* Returns a range of all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		java.lang.String createBy, boolean deleteStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreatorName(createBy, deleteStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		java.lang.String createBy, boolean deleteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreatorName(createBy, deleteStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorName_First(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreatorName_First(createBy, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorName_First(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreatorName_First(createBy, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorName_Last(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreatorName_Last(createBy, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorName_Last(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreatorName_Last(createBy, deleteStatus,
			orderByComparator);
	}

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreatorName_PrevAndNext(
		long messageId, java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreatorName_PrevAndNext(messageId, createBy,
			deleteStatus, orderByComparator);
	}

	/**
	* Removes all the i b messages where createBy = &#63; and deleteStatus = &#63; from the database.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreatorName(java.lang.String createBy,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreatorName(createBy, deleteStatus);
	}

	/**
	* Returns the number of i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreatorName(java.lang.String createBy,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreatorName(createBy, deleteStatus);
	}

	/**
	* Returns all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		java.lang.String createBy, boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreatorNameAndDraft(createBy, deleteStatus, draft);
	}

	/**
	* Returns a range of all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreatorNameAndDraft(createBy, deleteStatus, draft,
			start, end);
	}

	/**
	* Returns an ordered range of all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreatorNameAndDraft(createBy, deleteStatus, draft,
			start, end, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorNameAndDraft_First(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreatorNameAndDraft_First(createBy, deleteStatus,
			draft, orderByComparator);
	}

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorNameAndDraft_First(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreatorNameAndDraft_First(createBy, deleteStatus,
			draft, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorNameAndDraft_Last(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreatorNameAndDraft_Last(createBy, deleteStatus,
			draft, orderByComparator);
	}

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorNameAndDraft_Last(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreatorNameAndDraft_Last(createBy, deleteStatus,
			draft, orderByComparator);
	}

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreatorNameAndDraft_PrevAndNext(
		long messageId, java.lang.String createBy, boolean deleteStatus,
		boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence()
				   .findByCreatorNameAndDraft_PrevAndNext(messageId, createBy,
			deleteStatus, draft, orderByComparator);
	}

	/**
	* Removes all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63; from the database.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreatorNameAndDraft(java.lang.String createBy,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCreatorNameAndDraft(createBy, deleteStatus, draft);
	}

	/**
	* Returns the number of i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreatorNameAndDraft(java.lang.String createBy,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCreatorNameAndDraft(createBy, deleteStatus, draft);
	}

	/**
	* Caches the i b message in the entity cache if it is enabled.
	*
	* @param ibMessage the i b message
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage) {
		getPersistence().cacheResult(ibMessage);
	}

	/**
	* Caches the i b messages in the entity cache if it is enabled.
	*
	* @param ibMessages the i b messages
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> ibMessages) {
		getPersistence().cacheResult(ibMessages);
	}

	/**
	* Creates a new i b message with the primary key. Does not add the i b message to the database.
	*
	* @param messageId the primary key for the new i b message
	* @return the new i b message
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage create(
		long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	* Removes the i b message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message that was removed
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage remove(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence().remove(messageId);
	}

	public static com.sambaash.platform.srv.spinbox.model.IBMessage updateImpl(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ibMessage);
	}

	/**
	* Returns the i b message with the primary key or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageException} if it could not be found.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage findByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException {
		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	* Returns the i b message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message, or <code>null</code> if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	* Returns all the i b messages.
	*
	* @return the i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the i b messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the i b messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the i b messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of i b messages.
	*
	* @return the number of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IBMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IBMessagePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spinbox.service.ClpSerializer.getServletContextName(),
					IBMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(IBMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(IBMessagePersistence persistence) {
	}

	private static IBMessagePersistence _persistence;
}