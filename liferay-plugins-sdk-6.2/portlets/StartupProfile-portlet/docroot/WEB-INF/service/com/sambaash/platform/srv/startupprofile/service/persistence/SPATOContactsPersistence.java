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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;

/**
 * The persistence interface for the s p a t o contacts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPATOContactsPersistenceImpl
 * @see SPATOContactsUtil
 * @generated
 */
public interface SPATOContactsPersistence extends BasePersistence<SPATOContacts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPATOContactsUtil} to access the s p a t o contacts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p a t o contactses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the first s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the last s p a t o contacts in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findByOrganizationId_PrevAndNext(
		long spATOContactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Removes all the s p a t o contactses where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p a t o contactses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @return the matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByPrimaryPrincipalUserId_First(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the first s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByPrimaryPrincipalUserId_First(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByPrimaryPrincipalUserId_Last(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the last s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByPrimaryPrincipalUserId_Last(
		java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findByPrimaryPrincipalUserId_PrevAndNext(
		long spATOContactId, java.lang.String primaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Removes all the s p a t o contactses where primaryPrincipalUserId = &#63; from the database.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p a t o contactses where primaryPrincipalUserId = &#63;.
	*
	* @param primaryPrincipalUserId the primary principal user ID
	* @return the number of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @return the matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findBySecondaryPrincipalUserId_First(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the first s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchBySecondaryPrincipalUserId_First(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findBySecondaryPrincipalUserId_Last(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the last s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchBySecondaryPrincipalUserId_Last(
		java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts[] findBySecondaryPrincipalUserId_PrevAndNext(
		long spATOContactId, java.lang.String secondaryPrincipalUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Removes all the s p a t o contactses where secondaryPrincipalUserId = &#63; from the database.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p a t o contactses where secondaryPrincipalUserId = &#63;.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID
	* @return the number of matching s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countBySecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p a t o contacts in the entity cache if it is enabled.
	*
	* @param spatoContacts the s p a t o contacts
	*/
	public void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts);

	/**
	* Caches the s p a t o contactses in the entity cache if it is enabled.
	*
	* @param spatoContactses the s p a t o contactses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> spatoContactses);

	/**
	* Creates a new s p a t o contacts with the primary key. Does not add the s p a t o contacts to the database.
	*
	* @param spATOContactId the primary key for the new s p a t o contacts
	* @return the new s p a t o contacts
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts create(
		long spATOContactId);

	/**
	* Removes the s p a t o contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts remove(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts updateImpl(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p a t o contacts with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException} if it could not be found.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts findByPrimaryKey(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;

	/**
	* Returns the s p a t o contacts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts, or <code>null</code> if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchByPrimaryKey(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p a t o contactses.
	*
	* @return the s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p a t o contactses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p a t o contactses.
	*
	* @return the number of s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}