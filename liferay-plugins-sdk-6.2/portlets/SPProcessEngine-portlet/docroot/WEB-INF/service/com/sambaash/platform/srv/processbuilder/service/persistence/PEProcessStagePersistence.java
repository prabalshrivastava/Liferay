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

import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;

/**
 * The persistence interface for the p e process stage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStagePersistenceImpl
 * @see PEProcessStageUtil
 * @generated
 */
public interface PEProcessStagePersistence extends BasePersistence<PEProcessStage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PEProcessStageUtil} to access the p e process stage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p e process stages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process stages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process stages
	* @param end the upper bound of the range of p e process stages (not inclusive)
	* @return the range of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process stages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e process stages
	* @param end the upper bound of the range of p e process stages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process stage in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the first p e process stage in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process stage in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the last p e process stage in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process stages before and after the current p e process stage in the ordered set where uuid = &#63;.
	*
	* @param spPEProcessStageId the primary key of the current p e process stage
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage[] findByUuid_PrevAndNext(
		long spPEProcessStageId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Removes all the p e process stages where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process stages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process stage where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the p e process stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e process stage where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e process stage that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the number of p e process stages where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process stages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process stages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process stages
	* @param end the upper bound of the range of p e process stages (not inclusive)
	* @return the range of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process stages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e process stages
	* @param end the upper bound of the range of p e process stages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the first p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the last p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process stages before and after the current p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEProcessStageId the primary key of the current p e process stage
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage[] findByUuid_C_PrevAndNext(
		long spPEProcessStageId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Removes all the p e process stages where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process stages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p e process stage in the entity cache if it is enabled.
	*
	* @param peProcessStage the p e process stage
	*/
	public void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage);

	/**
	* Caches the p e process stages in the entity cache if it is enabled.
	*
	* @param peProcessStages the p e process stages
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> peProcessStages);

	/**
	* Creates a new p e process stage with the primary key. Does not add the p e process stage to the database.
	*
	* @param spPEProcessStageId the primary key for the new p e process stage
	* @return the new p e process stage
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage create(
		long spPEProcessStageId);

	/**
	* Removes the p e process stage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStageId the primary key of the p e process stage
	* @return the p e process stage that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage remove(
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process stage with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException} if it could not be found.
	*
	* @param spPEProcessStageId the primary key of the p e process stage
	* @return the p e process stage
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage findByPrimaryKey(
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;

	/**
	* Returns the p e process stage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEProcessStageId the primary key of the p e process stage
	* @return the p e process stage, or <code>null</code> if a p e process stage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage fetchByPrimaryKey(
		long spPEProcessStageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e process stages.
	*
	* @return the p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process stages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process stages
	* @param end the upper bound of the range of p e process stages (not inclusive)
	* @return the range of p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e process stages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process stages
	* @param end the upper bound of the range of p e process stages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e process stages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process stages.
	*
	* @return the number of p e process stages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}