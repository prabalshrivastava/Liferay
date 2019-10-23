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

package com.sambaash.platform.srv.startupprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;

import java.util.List;

/**
 * The persistence utility for the s p a t o contacts service. This utility wraps {@link SPATOContactsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPATOContactsPersistence
 * @see SPATOContactsPersistenceImpl
 * @generated
 */
public class SPATOContactsUtil {
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
	public static void clearCache(SPATOContacts spatoContacts) {
		getPersistence().clearCache(spatoContacts);
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
	public static List<SPATOContacts> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPATOContacts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPATOContacts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPATOContacts update(SPATOContacts spatoContacts)
		throws SystemException {
		return getPersistence().update(spatoContacts);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPATOContacts update(SPATOContacts spatoContacts,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spatoContacts, serviceContext);
	}

	/**
	* Returns all the s p a t o contactses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	* Returns a range of all the s p a t o contactses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @return the range of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the s p a t o contactses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findByOrganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the s p a t o contactses before and after the current s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param spATOContactId the primary key of the current s p a t o contacts
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findByOrganizationId_PrevAndNext(
		long spATOContactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(spATOContactId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the s p a t o contactses where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	* Returns the number of s p a t o contactses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	* Returns all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @return the matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrimaryPrincipalUserId(primaryPrincipalUserId);
	}

	/**
	* Returns a range of all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @return the range of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrimaryPrincipalUserId(primaryPrincipalUserId, start,
			end);
	}

	/**
	* Returns an ordered range of all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrimaryPrincipalUserId(primaryPrincipalUserId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByPrimaryPrincipalUserId_First(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findByPrimaryPrincipalUserId_First(primaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the first s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByPrimaryPrincipalUserId_First(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryPrincipalUserId_First(primaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the last s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByPrimaryPrincipalUserId_Last(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findByPrimaryPrincipalUserId_Last(primaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the last s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByPrimaryPrincipalUserId_Last(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryPrincipalUserId_Last(primaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the s p a t o contactses before and after the current s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param spATOContactId the primary key of the current s p a t o contacts
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findByPrimaryPrincipalUserId_PrevAndNext(
		long spATOContactId, java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findByPrimaryPrincipalUserId_PrevAndNext(spATOContactId,
			primaryPrincipalUserId, orderByComparator);
	}

	/**
	* Removes all the s p a t o contactses where primaryPrincipalUserId = &#63; from the database.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPrimaryPrincipalUserId(primaryPrincipalUserId);
	}

	/**
	* Returns the number of s p a t o contactses where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @return the number of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPrimaryPrincipalUserId(primaryPrincipalUserId);
	}

	/**
	* Returns all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @return the matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySecondaryPrincipalUserId(secondaryPrincipalUserId);
	}

	/**
	* Returns a range of all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @return the range of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySecondaryPrincipalUserId(secondaryPrincipalUserId,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySecondaryPrincipalUserId(secondaryPrincipalUserId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findBySecondaryPrincipalUserId_First(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findBySecondaryPrincipalUserId_First(secondaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the first s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchBySecondaryPrincipalUserId_First(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySecondaryPrincipalUserId_First(secondaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the last s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findBySecondaryPrincipalUserId_Last(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findBySecondaryPrincipalUserId_Last(secondaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the last s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchBySecondaryPrincipalUserId_Last(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySecondaryPrincipalUserId_Last(secondaryPrincipalUserId,
			orderByComparator);
	}

	/**
	* Returns the s p a t o contactses before and after the current s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param spATOContactId the primary key of the current s p a t o contacts
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findBySecondaryPrincipalUserId_PrevAndNext(
		long spATOContactId, java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence()
				   .findBySecondaryPrincipalUserId_PrevAndNext(spATOContactId,
			secondaryPrincipalUserId, orderByComparator);
	}

	/**
	* Removes all the s p a t o contactses where secondaryPrincipalUserId = &#63; from the database.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBySecondaryPrincipalUserId(secondaryPrincipalUserId);
	}

	/**
	* Returns the number of s p a t o contactses where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @return the number of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySecondaryPrincipalUserId(secondaryPrincipalUserId);
	}

	/**
	* Caches the s p a t o contacts in the entity cache if it is enabled.
	*
	* @param spatoContacts the s p a t o contacts
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts) {
		getPersistence().cacheResult(spatoContacts);
	}

	/**
	* Caches the s p a t o contactses in the entity cache if it is enabled.
	*
	* @param spatoContactses the s p a t o contactses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> spatoContactses) {
		getPersistence().cacheResult(spatoContactses);
	}

	/**
	* Creates a new s p a t o contacts with the primary key. Does not add the s p a t o contacts to the database.
	*
	* @param spATOContactId the primary key for the new s p a t o contacts
	* @return the new s p a t o contacts
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts create(
		long spATOContactId) {
		return getPersistence().create(spATOContactId);
	}

	/**
	* Removes the s p a t o contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts remove(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence().remove(spATOContactId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts updateImpl(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spatoContacts);
	}

	/**
	* Returns the s p a t o contacts with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException} if it could not be found.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByPrimaryKey(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException {
		return getPersistence().findByPrimaryKey(spATOContactId);
	}

	/**
	* Returns the s p a t o contacts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts, or <code>null</code> if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByPrimaryKey(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spATOContactId);
	}

	/**
	* Returns all the s p a t o contactses.
	*
	* @return the s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p a t o contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @return the range of s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p a t o contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p a t o contactses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p a t o contactses.
	*
	* @return the number of s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPATOContactsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPATOContactsPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.startupprofile.service.ClpSerializer.getServletContextName(),
					SPATOContactsPersistence.class.getName());

			ReferenceRegistry.registerReference(SPATOContactsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPATOContactsPersistence persistence) {
	}

	private static SPATOContactsPersistence _persistence;
}