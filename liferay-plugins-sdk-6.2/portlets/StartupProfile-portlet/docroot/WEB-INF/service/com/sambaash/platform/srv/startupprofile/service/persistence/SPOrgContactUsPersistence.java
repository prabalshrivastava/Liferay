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

import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;

/**
 * The persistence interface for the s p org contact us service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPOrgContactUsPersistenceImpl
 * @see SPOrgContactUsUtil
 * @generated
 */
public interface SPOrgContactUsPersistence extends BasePersistence<SPOrgContactUs> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPOrgContactUsUtil} to access the s p org contact us persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p org contact uses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p org contact uses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of s p org contact uses
	* @param end the upper bound of the range of s p org contact uses (not inclusive)
	* @return the range of matching s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p org contact uses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of s p org contact uses
	* @param end the upper bound of the range of s p org contact uses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p org contact us in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p org contact us
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a matching s p org contact us could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException;

	/**
	* Returns the first s p org contact us in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p org contact us, or <code>null</code> if a matching s p org contact us could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p org contact us in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p org contact us
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a matching s p org contact us could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException;

	/**
	* Returns the last s p org contact us in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p org contact us, or <code>null</code> if a matching s p org contact us could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p org contact uses before and after the current s p org contact us in the ordered set where organizationId = &#63;.
	*
	* @param spContactUsId the primary key of the current s p org contact us
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p org contact us
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs[] findByOrganizationId_PrevAndNext(
		long spContactUsId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException;

	/**
	* Removes all the s p org contact uses where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p org contact uses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p org contact us in the entity cache if it is enabled.
	*
	* @param spOrgContactUs the s p org contact us
	*/
	public void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs);

	/**
	* Caches the s p org contact uses in the entity cache if it is enabled.
	*
	* @param spOrgContactUses the s p org contact uses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> spOrgContactUses);

	/**
	* Creates a new s p org contact us with the primary key. Does not add the s p org contact us to the database.
	*
	* @param spContactUsId the primary key for the new s p org contact us
	* @return the new s p org contact us
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs create(
		long spContactUsId);

	/**
	* Removes the s p org contact us with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spContactUsId the primary key of the s p org contact us
	* @return the s p org contact us that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs remove(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException;

	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs updateImpl(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p org contact us with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException} if it could not be found.
	*
	* @param spContactUsId the primary key of the s p org contact us
	* @return the s p org contact us
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs findByPrimaryKey(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException;

	/**
	* Returns the s p org contact us with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spContactUsId the primary key of the s p org contact us
	* @return the s p org contact us, or <code>null</code> if a s p org contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs fetchByPrimaryKey(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p org contact uses.
	*
	* @return the s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p org contact uses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p org contact uses
	* @param end the upper bound of the range of s p org contact uses (not inclusive)
	* @return the range of s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p org contact uses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p org contact uses
	* @param end the upper bound of the range of s p org contact uses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p org contact uses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p org contact uses.
	*
	* @return the number of s p org contact uses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}