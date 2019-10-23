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

package com.sambaash.platform.srv.spasset.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spasset.model.SPAssetEntry;

import java.util.List;

/**
 * The persistence utility for the s p asset entry service. This utility wraps {@link SPAssetEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPAssetEntryPersistence
 * @see SPAssetEntryPersistenceImpl
 * @generated
 */
public class SPAssetEntryUtil {
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
	public static void clearCache(SPAssetEntry spAssetEntry) {
		getPersistence().clearCache(spAssetEntry);
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
	public static List<SPAssetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPAssetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPAssetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPAssetEntry update(SPAssetEntry spAssetEntry)
		throws SystemException {
		return getPersistence().update(spAssetEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPAssetEntry update(SPAssetEntry spAssetEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spAssetEntry, serviceContext);
	}

	/**
	* Returns the s p asset entry where urlTitle = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spasset.NoSuchEntryException} if it could not be found.
	*
	* @param urlTitle the url title
	* @param groupId the group ID
	* @return the matching s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry findByurlTitle(
		java.lang.String urlTitle, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence().findByurlTitle(urlTitle, groupId);
	}

	/**
	* Returns the s p asset entry where urlTitle = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param urlTitle the url title
	* @param groupId the group ID
	* @return the matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchByurlTitle(
		java.lang.String urlTitle, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByurlTitle(urlTitle, groupId);
	}

	/**
	* Returns the s p asset entry where urlTitle = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param urlTitle the url title
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchByurlTitle(
		java.lang.String urlTitle, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByurlTitle(urlTitle, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p asset entry where urlTitle = &#63; and groupId = &#63; from the database.
	*
	* @param urlTitle the url title
	* @param groupId the group ID
	* @return the s p asset entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry removeByurlTitle(
		java.lang.String urlTitle, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence().removeByurlTitle(urlTitle, groupId);
	}

	/**
	* Returns the number of s p asset entries where urlTitle = &#63; and groupId = &#63;.
	*
	* @param urlTitle the url title
	* @param groupId the group ID
	* @return the number of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByurlTitle(java.lang.String urlTitle, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByurlTitle(urlTitle, groupId);
	}

	/**
	* Returns all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpAssetTypeIdStatus(spAssetTypeId, groupId, status);
	}

	/**
	* Returns a range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @return the range of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpAssetTypeIdStatus(spAssetTypeId, groupId, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpAssetTypeIdStatus(spAssetTypeId, groupId, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry findBySpAssetTypeIdStatus_First(
		long spAssetTypeId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .findBySpAssetTypeIdStatus_First(spAssetTypeId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchBySpAssetTypeIdStatus_First(
		long spAssetTypeId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpAssetTypeIdStatus_First(spAssetTypeId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry findBySpAssetTypeIdStatus_Last(
		long spAssetTypeId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .findBySpAssetTypeIdStatus_Last(spAssetTypeId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchBySpAssetTypeIdStatus_Last(
		long spAssetTypeId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpAssetTypeIdStatus_Last(spAssetTypeId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns the s p asset entries before and after the current s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetEntryId the primary key of the current s p asset entry
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry[] findBySpAssetTypeIdStatus_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .findBySpAssetTypeIdStatus_PrevAndNext(spAssetEntryId,
			spAssetTypeId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> filterFindBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySpAssetTypeIdStatus(spAssetTypeId, groupId,
			status);
	}

	/**
	* Returns a range of all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @return the range of matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> filterFindBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySpAssetTypeIdStatus(spAssetTypeId, groupId,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the s p asset entries that the user has permissions to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> filterFindBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySpAssetTypeIdStatus(spAssetTypeId, groupId,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the s p asset entries before and after the current s p asset entry in the ordered set of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetEntryId the primary key of the current s p asset entry
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry[] filterFindBySpAssetTypeIdStatus_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .filterFindBySpAssetTypeIdStatus_PrevAndNext(spAssetEntryId,
			spAssetTypeId, groupId, status, orderByComparator);
	}

	/**
	* Removes all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBySpAssetTypeIdStatus(spAssetTypeId, groupId, status);
	}

	/**
	* Returns the number of s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySpAssetTypeIdStatus(spAssetTypeId, groupId, status);
	}

	/**
	* Returns the number of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountBySpAssetTypeIdStatus(spAssetTypeId, groupId,
			status);
	}

	/**
	* Returns all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @return the matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySpAssetTypeId(spAssetTypeId, groupId);
	}

	/**
	* Returns a range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @return the range of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpAssetTypeId(spAssetTypeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpAssetTypeId(spAssetTypeId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry findBySpAssetTypeId_First(
		long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .findBySpAssetTypeId_First(spAssetTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchBySpAssetTypeId_First(
		long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpAssetTypeId_First(spAssetTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry findBySpAssetTypeId_Last(
		long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .findBySpAssetTypeId_Last(spAssetTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchBySpAssetTypeId_Last(
		long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpAssetTypeId_Last(spAssetTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the s p asset entries before and after the current s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetEntryId the primary key of the current s p asset entry
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry[] findBySpAssetTypeId_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .findBySpAssetTypeId_PrevAndNext(spAssetEntryId,
			spAssetTypeId, groupId, orderByComparator);
	}

	/**
	* Returns all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @return the matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> filterFindBySpAssetTypeId(
		long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySpAssetTypeId(spAssetTypeId, groupId);
	}

	/**
	* Returns a range of all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @return the range of matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> filterFindBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySpAssetTypeId(spAssetTypeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the s p asset entries that the user has permissions to view where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> filterFindBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySpAssetTypeId(spAssetTypeId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Returns the s p asset entries before and after the current s p asset entry in the ordered set of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetEntryId the primary key of the current s p asset entry
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry[] filterFindBySpAssetTypeId_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence()
				   .filterFindBySpAssetTypeId_PrevAndNext(spAssetEntryId,
			spAssetTypeId, groupId, orderByComparator);
	}

	/**
	* Removes all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; from the database.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySpAssetTypeId(spAssetTypeId, groupId);
	}

	/**
	* Returns the number of s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @return the number of matching s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySpAssetTypeId(spAssetTypeId, groupId);
	}

	/**
	* Returns the number of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	*
	* @param spAssetTypeId the sp asset type ID
	* @param groupId the group ID
	* @return the number of matching s p asset entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySpAssetTypeId(long spAssetTypeId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountBySpAssetTypeId(spAssetTypeId, groupId);
	}

	/**
	* Caches the s p asset entry in the entity cache if it is enabled.
	*
	* @param spAssetEntry the s p asset entry
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry) {
		getPersistence().cacheResult(spAssetEntry);
	}

	/**
	* Caches the s p asset entries in the entity cache if it is enabled.
	*
	* @param spAssetEntries the s p asset entries
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> spAssetEntries) {
		getPersistence().cacheResult(spAssetEntries);
	}

	/**
	* Creates a new s p asset entry with the primary key. Does not add the s p asset entry to the database.
	*
	* @param spAssetEntryId the primary key for the new s p asset entry
	* @return the new s p asset entry
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry create(
		long spAssetEntryId) {
		return getPersistence().create(spAssetEntryId);
	}

	/**
	* Removes the s p asset entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry that was removed
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry remove(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence().remove(spAssetEntryId);
	}

	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry updateImpl(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spAssetEntry);
	}

	/**
	* Returns the s p asset entry with the primary key or throws a {@link com.sambaash.platform.srv.spasset.NoSuchEntryException} if it could not be found.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry
	* @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry findByPrimaryKey(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spasset.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(spAssetEntryId);
	}

	/**
	* Returns the s p asset entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry, or <code>null</code> if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchByPrimaryKey(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spAssetEntryId);
	}

	/**
	* Returns all the s p asset entries.
	*
	* @return the s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p asset entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @return the range of s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p asset entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p asset entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p asset entries.
	*
	* @return the number of s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPAssetEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPAssetEntryPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spasset.service.ClpSerializer.getServletContextName(),
					SPAssetEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(SPAssetEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPAssetEntryPersistence persistence) {
	}

	private static SPAssetEntryPersistence _persistence;
}