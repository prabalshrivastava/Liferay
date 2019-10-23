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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spservices.model.SPSiteSetup;

/**
 * The persistence interface for the s p site setup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPSiteSetupPersistenceImpl
 * @see SPSiteSetupUtil
 * @generated
 */
public interface SPSiteSetupPersistence extends BasePersistence<SPSiteSetup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSiteSetupUtil} to access the s p site setup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p site setups where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where uuid = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findByUuid_PrevAndNext(
		long spSiteSetupId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setup where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the s p site setup where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setup where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p site setup where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p site setup that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the number of s p site setups where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findByUuid_C_PrevAndNext(
		long spSiteSetupId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductId(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductId(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductId(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByProductId_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByProductId_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByProductId_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByProductId_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where productId = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findByProductId_PrevAndNext(
		long spSiteSetupId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProductId(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByProductId(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where productName = &#63;.
	*
	* @param productName the product name
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductName(
		java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productName the product name
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductName(
		java.lang.String productName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productName the product name
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByProductName(
		java.lang.String productName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByProductName_First(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByProductName_First(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByProductName_Last(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByProductName_Last(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where productName = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findByProductName_PrevAndNext(
		long spSiteSetupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where productName = &#63; from the database.
	*
	* @param productName the product name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProductName(java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where productName = &#63;.
	*
	* @param productName the product name
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByProductName(java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where subProductId = &#63;.
	*
	* @param subProductId the sub product ID
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductId(
		long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where subProductId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subProductId the sub product ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductId(
		long subProductId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where subProductId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subProductId the sub product ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductId(
		long subProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where subProductId = &#63;.
	*
	* @param subProductId the sub product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findBySubProductId_First(
		long subProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where subProductId = &#63;.
	*
	* @param subProductId the sub product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchBySubProductId_First(
		long subProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where subProductId = &#63;.
	*
	* @param subProductId the sub product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findBySubProductId_Last(
		long subProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where subProductId = &#63;.
	*
	* @param subProductId the sub product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchBySubProductId_Last(
		long subProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where subProductId = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param subProductId the sub product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findBySubProductId_PrevAndNext(
		long spSiteSetupId, long subProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where subProductId = &#63; from the database.
	*
	* @param subProductId the sub product ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySubProductId(long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where subProductId = &#63;.
	*
	* @param subProductId the sub product ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countBySubProductId(long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where subProductName = &#63;.
	*
	* @param subProductName the sub product name
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductName(
		java.lang.String subProductName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where subProductName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subProductName the sub product name
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductName(
		java.lang.String subProductName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where subProductName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subProductName the sub product name
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findBySubProductName(
		java.lang.String subProductName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where subProductName = &#63;.
	*
	* @param subProductName the sub product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findBySubProductName_First(
		java.lang.String subProductName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where subProductName = &#63;.
	*
	* @param subProductName the sub product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchBySubProductName_First(
		java.lang.String subProductName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where subProductName = &#63;.
	*
	* @param subProductName the sub product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findBySubProductName_Last(
		java.lang.String subProductName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where subProductName = &#63;.
	*
	* @param subProductName the sub product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchBySubProductName_Last(
		java.lang.String subProductName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where subProductName = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param subProductName the sub product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findBySubProductName_PrevAndNext(
		long spSiteSetupId, java.lang.String subProductName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where subProductName = &#63; from the database.
	*
	* @param subProductName the sub product name
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySubProductName(java.lang.String subProductName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where subProductName = &#63;.
	*
	* @param subProductName the sub product name
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countBySubProductName(java.lang.String subProductName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setup where productId = &#63; and subProductId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException} if it could not be found.
	*
	* @param productId the product ID
	* @param subProductId the sub product ID
	* @return the matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByProductIdAndSubProductId(
		long productId, long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the s p site setup where productId = &#63; and subProductId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param productId the product ID
	* @param subProductId the sub product ID
	* @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByProductIdAndSubProductId(
		long productId, long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setup where productId = &#63; and subProductId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param productId the product ID
	* @param subProductId the sub product ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByProductIdAndSubProductId(
		long productId, long subProductId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p site setup where productId = &#63; and subProductId = &#63; from the database.
	*
	* @param productId the product ID
	* @param subProductId the sub product ID
	* @return the s p site setup that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup removeByProductIdAndSubProductId(
		long productId, long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the number of s p site setups where productId = &#63; and subProductId = &#63;.
	*
	* @param productId the product ID
	* @param subProductId the sub product ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByProductIdAndSubProductId(long productId, long subProductId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByVirtualHostId(
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where virtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualHostId the virtual host ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByVirtualHostId(
		long virtualHostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where virtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualHostId the virtual host ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByVirtualHostId(
		long virtualHostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByVirtualHostId_First(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByVirtualHostId_First(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByVirtualHostId_Last(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByVirtualHostId_Last(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where virtualHostId = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findByVirtualHostId_PrevAndNext(
		long spSiteSetupId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where virtualHostId = &#63; from the database.
	*
	* @param virtualHostId the virtual host ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVirtualHostId(long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByVirtualHostId(long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups where backOfficeVirtualHostId = &#63;.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @return the matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByBackOfficeVirtualHostId(
		long backOfficeVirtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups where backOfficeVirtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByBackOfficeVirtualHostId(
		long backOfficeVirtualHostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups where backOfficeVirtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findByBackOfficeVirtualHostId(
		long backOfficeVirtualHostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByBackOfficeVirtualHostId_First(
		long backOfficeVirtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the first s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByBackOfficeVirtualHostId_First(
		long backOfficeVirtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByBackOfficeVirtualHostId_Last(
		long backOfficeVirtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the last s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByBackOfficeVirtualHostId_Last(
		long backOfficeVirtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setups before and after the current s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	*
	* @param spSiteSetupId the primary key of the current s p site setup
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup[] findByBackOfficeVirtualHostId_PrevAndNext(
		long spSiteSetupId, long backOfficeVirtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Removes all the s p site setups where backOfficeVirtualHostId = &#63; from the database.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBackOfficeVirtualHostId(long backOfficeVirtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups where backOfficeVirtualHostId = &#63;.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID
	* @return the number of matching s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countByBackOfficeVirtualHostId(long backOfficeVirtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p site setup in the entity cache if it is enabled.
	*
	* @param spSiteSetup the s p site setup
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup);

	/**
	* Caches the s p site setups in the entity cache if it is enabled.
	*
	* @param spSiteSetups the s p site setups
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> spSiteSetups);

	/**
	* Creates a new s p site setup with the primary key. Does not add the s p site setup to the database.
	*
	* @param spSiteSetupId the primary key for the new s p site setup
	* @return the new s p site setup
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup create(
		long spSiteSetupId);

	/**
	* Removes the s p site setup with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteSetupId the primary key of the s p site setup
	* @return the s p site setup that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup remove(
		long spSiteSetupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	public com.sambaash.platform.srv.spservices.model.SPSiteSetup updateImpl(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site setup with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException} if it could not be found.
	*
	* @param spSiteSetupId the primary key of the s p site setup
	* @return the s p site setup
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup findByPrimaryKey(
		long spSiteSetupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;

	/**
	* Returns the s p site setup with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSiteSetupId the primary key of the s p site setup
	* @return the s p site setup, or <code>null</code> if a s p site setup with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup fetchByPrimaryKey(
		long spSiteSetupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p site setups.
	*
	* @return the s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p site setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @return the range of s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p site setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p site setups
	* @param end the upper bound of the range of s p site setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSiteSetup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p site setups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p site setups.
	*
	* @return the number of s p site setups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}