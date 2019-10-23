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

import com.sambaash.platform.srv.startupprofile.model.ReAccreditation;

/**
 * The persistence interface for the re accreditation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ReAccreditationPersistenceImpl
 * @see ReAccreditationUtil
 * @generated
 */
public interface ReAccreditationPersistence extends BasePersistence<ReAccreditation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReAccreditationUtil} to access the re accreditation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the re accreditations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the re accreditations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @return the range of matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the re accreditations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first re accreditation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Returns the first re accreditation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last re accreditation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Returns the last re accreditation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the re accreditations before and after the current re accreditation in the ordered set where uuid = &#63;.
	*
	* @param accreditationId the primary key of the current re accreditation
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation[] findByUuid_PrevAndNext(
		long accreditationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Removes all the re accreditations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of re accreditations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the re accreditations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the re accreditations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @return the range of matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the re accreditations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first re accreditation in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Returns the first re accreditation in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last re accreditation in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Returns the last re accreditation in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the re accreditations before and after the current re accreditation in the ordered set where organizationId = &#63;.
	*
	* @param accreditationId the primary key of the current re accreditation
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation[] findByOrganizationId_PrevAndNext(
		long accreditationId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Removes all the re accreditations where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of re accreditations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the re accreditation in the entity cache if it is enabled.
	*
	* @param reAccreditation the re accreditation
	*/
	public void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation);

	/**
	* Caches the re accreditations in the entity cache if it is enabled.
	*
	* @param reAccreditations the re accreditations
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> reAccreditations);

	/**
	* Creates a new re accreditation with the primary key. Does not add the re accreditation to the database.
	*
	* @param accreditationId the primary key for the new re accreditation
	* @return the new re accreditation
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation create(
		long accreditationId);

	/**
	* Removes the re accreditation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param accreditationId the primary key of the re accreditation
	* @return the re accreditation that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation remove(
		long accreditationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the re accreditation with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException} if it could not be found.
	*
	* @param accreditationId the primary key of the re accreditation
	* @return the re accreditation
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation findByPrimaryKey(
		long accreditationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;

	/**
	* Returns the re accreditation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param accreditationId the primary key of the re accreditation
	* @return the re accreditation, or <code>null</code> if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation fetchByPrimaryKey(
		long accreditationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the re accreditations.
	*
	* @return the re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the re accreditations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @return the range of re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the re accreditations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the re accreditations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of re accreditations.
	*
	* @return the number of re accreditations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}