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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.legalandcontract.model.RDL;

/**
 * The persistence interface for the r d l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see RDLPersistenceImpl
 * @see RDLUtil
 * @generated
 */
public interface RDLPersistence extends BasePersistence<RDL> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RDLUtil} to access the r d l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the r d ls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the first r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the last r d l in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.RDL[] findByUuid_PrevAndNext(
		long spRdlId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Removes all the r d ls where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d ls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d l where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the r d l where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d l where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the r d l where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the r d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the number of r d ls where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the r d ls where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the first r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the last r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.RDL[] findByUuid_C_PrevAndNext(
		long spRdlId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Removes all the r d ls where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d ls where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByRdlIdLitigationId(
		long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByRdlIdLitigationId(
		long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByRdlIdLitigationId(
		long spRdlId, long spLitigationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the r d l where spRdlId = &#63; and spLitigationId = &#63; from the database.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the r d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL removeByRdlIdLitigationId(
		long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the number of r d ls where spRdlId = &#63; and spLitigationId = &#63;.
	*
	* @param spRdlId the sp rdl ID
	* @param spLitigationId the sp litigation ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countByRdlIdLitigationId(long spRdlId, long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the r d ls where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @return the matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long spLitigationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long spLitigationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findBylitigationId_First(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the first r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchBylitigationId_First(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findBylitigationId_Last(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the last r d l in the ordered set where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchBylitigationId_Last(
		long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.legalandcontract.model.RDL[] findBylitigationId_PrevAndNext(
		long spRdlId, long spLitigationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Removes all the r d ls where spLitigationId = &#63; from the database.
	*
	* @param spLitigationId the sp litigation ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBylitigationId(long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d ls where spLitigationId = &#63;.
	*
	* @param spLitigationId the sp litigation ID
	* @return the number of matching r d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countBylitigationId(long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the r d l in the entity cache if it is enabled.
	*
	* @param rdl the r d l
	*/
	public void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl);

	/**
	* Caches the r d ls in the entity cache if it is enabled.
	*
	* @param rdls the r d ls
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> rdls);

	/**
	* Creates a new r d l with the primary key. Does not add the r d l to the database.
	*
	* @param spRdlId the primary key for the new r d l
	* @return the new r d l
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL create(
		long spRdlId);

	/**
	* Removes the r d l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL remove(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	public com.sambaash.platform.srv.legalandcontract.model.RDL updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d l with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL findByPrimaryKey(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;

	/**
	* Returns the r d l with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l, or <code>null</code> if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.RDL fetchByPrimaryKey(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the r d ls.
	*
	* @return the r d ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the r d ls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d ls.
	*
	* @return the number of r d ls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}