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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

/**
 * The persistence interface for the p e process state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatePersistenceImpl
 * @see PEProcessStateUtil
 * @generated
 */
public interface PEProcessStatePersistence extends BasePersistence<PEProcessState> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PEProcessStateUtil} to access the p e process state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p e process states where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where uuid = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByUuid_PrevAndNext(
		long spPEProcessStateId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process state where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the p e process state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e process state where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e process state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the number of p e process states where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByUuid_C_PrevAndNext(
		long spPEProcessStateId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcess(
		long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcess_First(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcess_First(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcess_Last(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcess_Last(
		long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcess_PrevAndNext(
		long spPEProcessStateId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where userIdProcess = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserIdProcess(long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63;.
	*
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserIdProcess(long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessId_First(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessId_First(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessId_Last(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessId_Last(
		long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserIdProcessPEProcessId(long userIdProcess,
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserIdProcessPEProcessId(long userIdProcess,
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByPEProcessId(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByPEProcessId(
		long spPEProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByPEProcessId(
		long spPEProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPEProcessId_First(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByPEProcessId_First(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPEProcessId_Last(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByPEProcessId_Last(
		long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param spPEProcessId the sp p e process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByPEProcessId_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where spPEProcessId = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPEProcessId(long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where spPEProcessId = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessId(long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIClassId_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIClassId_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIClassId_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIClassId_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessIClassId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long entityClassId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserIdProcessPEProcessIClassId(long userIdProcess,
		long spPEProcessId, long entityClassId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserIdProcessPEProcessIClassId(long userIdProcess,
		long spPEProcessId, long entityClassId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long entityClassId, long entityId, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param activeStatus the active status
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the p e process state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState removeByprocessStatePK(
		long userIdProcess, long spPEProcessId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param entityId the entity ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByprocessStatePK(long userIdProcess, long spPEProcessId,
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long spPEProcessId, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long spPEProcessId, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long spPEProcessId, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateLead_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateLead_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateLead_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateLead_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByProcessStateLead_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] spPEProcessIds, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] spPEProcessIds, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateLead(
		long[] spPEProcessIds, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProcessStateLead(long spPEProcessId, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByProcessStateLead(long spPEProcessId, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByProcessStateLead(long[] spPEProcessIds, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateOpportunity_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateOpportunity_First(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByProcessStateOpportunity_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByProcessStateOpportunity_Last(
		long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByProcessStateOpportunity_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId, long userIdProcess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63; from the database.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProcessStateOpportunity(long spPEProcessId,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessId the sp p e process ID
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByProcessStateOpportunity(long spPEProcessId,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	*
	* @param spPEProcessIds the sp p e process IDs
	* @param userIdProcess the user ID process
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByProcessStateOpportunity(long[] spPEProcessIds,
		long userIdProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessStageId_First(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessStageId_First(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessPEProcessStageId_Last(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessPEProcessStageId_Last(
		long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessPEProcessStageId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessStageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserIdProcessPEProcessStageId(long userIdProcess,
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessStageId the sp p e process stage ID
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserIdProcessPEProcessStageId(long userIdProcess,
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @return the matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param spPEProcessStateId the primary key of the current p e process state
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState[] findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long sourceClassId, long sourceEntityID, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63; from the database.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	*
	* @param userIdProcess the user ID process
	* @param spPEProcessId the sp p e process ID
	* @param sourceClassId the source class ID
	* @param sourceEntityID the source entity i d
	* @param activeStatus the active status
	* @return the number of matching p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p e process state in the entity cache if it is enabled.
	*
	* @param peProcessState the p e process state
	*/
	public void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState);

	/**
	* Caches the p e process states in the entity cache if it is enabled.
	*
	* @param peProcessStates the p e process states
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> peProcessStates);

	/**
	* Creates a new p e process state with the primary key. Does not add the p e process state to the database.
	*
	* @param spPEProcessStateId the primary key for the new p e process state
	* @return the new p e process state
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState create(
		long spPEProcessStateId);

	/**
	* Removes the p e process state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState remove(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessState updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process state with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState findByPrimaryKey(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;

	/**
	* Returns the p e process state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEProcessStateId the primary key of the p e process state
	* @return the p e process state, or <code>null</code> if a p e process state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState fetchByPrimaryKey(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process states.
	*
	* @return the p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @return the range of p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process states
	* @param end the upper bound of the range of p e process states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e process states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e process states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process states.
	*
	* @return the number of p e process states
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}