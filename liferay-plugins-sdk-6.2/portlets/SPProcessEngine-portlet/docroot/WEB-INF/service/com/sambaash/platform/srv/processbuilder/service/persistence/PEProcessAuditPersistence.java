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

import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;

/**
 * The persistence interface for the p e process audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessAuditPersistenceImpl
 * @see PEProcessAuditUtil
 * @generated
 */
public interface PEProcessAuditPersistence extends BasePersistence<PEProcessAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PEProcessAuditUtil} to access the p e process audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p e process audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where uuid = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByUuid_PrevAndNext(
		long spPEProcessAuditId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the p e process audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e process audit where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the number of p e process audits where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByUuid_C_PrevAndNext(
		long spPEProcessAuditId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateId_First(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateId_First(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateId_Last(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateId_Last(
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPEProcessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateId(long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, java.lang.String field2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, java.lang.String field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdFormId_First(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdFormId_First(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdFormId_Last(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdFormId_Last(
		long spPEProcessStateId, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdFormId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPEProcessStateIdFormId(long spPEProcessStateId,
		java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param field2 the field2
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateIdFormId(long spPEProcessStateId,
		java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypePEProcessStateId(
		java.lang.String type, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypePEProcessStateId(
		java.lang.String type, long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypePEProcessStateId(
		java.lang.String type, long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypePEProcessStateId_First(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypePEProcessStateId_First(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypePEProcessStateId_Last(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypePEProcessStateId_Last(
		java.lang.String type, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByTypePEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, java.lang.String type,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where type = &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypePEProcessStateId(java.lang.String type,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypePEProcessStateId(java.lang.String type,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdTypeCreateDateLT_First(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeCreateDateLT_First(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdTypeCreateDateLT_Last(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeCreateDateLT_Last(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdTypeCreateDateLT_PrevAndNext(
		long spPEProcessAuditId, java.lang.String type,
		java.util.Date createDate, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPEProcessStateIdTypeCreateDateLT(
		java.lang.String type, java.util.Date createDate,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param createDate the create date
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateIdTypeCreateDateLT(java.lang.String type,
		java.util.Date createDate, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByDoneByPEProcessStateId(
		java.lang.String doneBy, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByDoneByPEProcessStateId(
		java.lang.String doneBy, long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByDoneByPEProcessStateId(
		java.lang.String doneBy, long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByDoneByPEProcessStateId_First(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByDoneByPEProcessStateId_First(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByDoneByPEProcessStateId_Last(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByDoneByPEProcessStateId_Last(
		java.lang.String doneBy, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByDoneByPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, java.lang.String doneBy,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDoneByPEProcessStateId(java.lang.String doneBy,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	*
	* @param doneBy the done by
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByDoneByPEProcessStateId(java.lang.String doneBy,
		long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByTypeActionPEProcessStateId(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypeActionPEProcessStateId_First(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypeActionPEProcessStateId_First(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypeActionPEProcessStateId_Last(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByTypeActionPEProcessStateId_Last(
		java.lang.String type, java.lang.String action,
		long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByTypeActionPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, java.lang.String type,
		java.lang.String action, long spPEProcessStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63; from the database.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeActionPEProcessStateId(java.lang.String type,
		java.lang.String action, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	*
	* @param type the type
	* @param action the action
	* @param spPEProcessStateId the sp p e process state ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeActionPEProcessStateId(java.lang.String type,
		java.lang.String action, long spPEProcessStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type,
		java.lang.String field2, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit removeByPEProcessStateIdTypeField2(
		long spPEProcessStateId, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param field2 the field2
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateIdTypeField2(long spPEProcessStateId,
		java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdNodeId_First(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeId_First(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdNodeId_Last(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeId_Last(
		long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdNodeId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPEProcessStateIdNodeId(long spPEProcessStateId,
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateIdNodeId(long spPEProcessStateId,
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdType_First(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdType_First(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdType_Last(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdType_Last(
		long spPEProcessStateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByPEProcessStateIdType_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where spPEProcessStateId = &#63; and type = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPEProcessStateIdType(long spPEProcessStateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param type the type
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateIdType(long spPEProcessStateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; from the database.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit removeByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the number of p e process audits where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63;.
	*
	* @param spPEProcessStateId the sp p e process state ID
	* @param nodeId the node ID
	* @param action the action
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByPEProcessStateIdNodeIdAction(long spPEProcessStateId,
		long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @return the matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type,
		java.lang.String field2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type,
		java.lang.String field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByActionTypeField2_First(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the first p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByActionTypeField2_First(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByActionTypeField2_Last(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the last p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByActionTypeField2_Last(
		java.lang.String action, java.lang.String type,
		java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audits before and after the current p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param spPEProcessAuditId the primary key of the current p e process audit
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit[] findByActionTypeField2_PrevAndNext(
		long spPEProcessAuditId, java.lang.String action,
		java.lang.String type, java.lang.String field2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Removes all the p e process audits where action = &#63; and type = &#63; and field2 = &#63; from the database.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActionTypeField2(java.lang.String action,
		java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	*
	* @param action the action
	* @param type the type
	* @param field2 the field2
	* @return the number of matching p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByActionTypeField2(java.lang.String action,
		java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p e process audit in the entity cache if it is enabled.
	*
	* @param peProcessAudit the p e process audit
	*/
	public void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit);

	/**
	* Caches the p e process audits in the entity cache if it is enabled.
	*
	* @param peProcessAudits the p e process audits
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> peProcessAudits);

	/**
	* Creates a new p e process audit with the primary key. Does not add the p e process audit to the database.
	*
	* @param spPEProcessAuditId the primary key for the new p e process audit
	* @return the new p e process audit
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit create(
		long spPEProcessAuditId);

	/**
	* Removes the p e process audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit remove(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByPrimaryKey(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	/**
	* Returns the p e process audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit, or <code>null</code> if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchByPrimaryKey(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process audits.
	*
	* @return the p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e process audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits.
	*
	* @return the number of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}