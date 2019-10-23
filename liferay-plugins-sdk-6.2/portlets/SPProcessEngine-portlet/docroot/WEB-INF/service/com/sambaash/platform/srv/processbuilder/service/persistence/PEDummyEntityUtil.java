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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;

import java.util.List;

/**
 * The persistence utility for the p e dummy entity service. This utility wraps {@link PEDummyEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEDummyEntityPersistence
 * @see PEDummyEntityPersistenceImpl
 * @generated
 */
public class PEDummyEntityUtil {
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
	public static void clearCache(PEDummyEntity peDummyEntity) {
		getPersistence().clearCache(peDummyEntity);
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
	public static List<PEDummyEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PEDummyEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PEDummyEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PEDummyEntity update(PEDummyEntity peDummyEntity)
		throws SystemException {
		return getPersistence().update(peDummyEntity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PEDummyEntity update(PEDummyEntity peDummyEntity,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(peDummyEntity, serviceContext);
	}

	/**
	* Returns all the p e dummy entities where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the p e dummy entities where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @return the range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the p e dummy entities where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first p e dummy entity in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first p e dummy entity in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last p e dummy entity in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last p e dummy entity in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the p e dummy entities before and after the current p e dummy entity in the ordered set where uuid = &#63;.
	*
	* @param spPEDummyEntityId the primary key of the current p e dummy entity
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity[] findByUuid_PrevAndNext(
		long spPEDummyEntityId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spPEDummyEntityId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the p e dummy entities where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of p e dummy entities where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the p e dummy entity where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e dummy entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the p e dummy entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the p e dummy entity where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e dummy entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of p e dummy entities where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the p e dummy entities where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the p e dummy entities where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @return the range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the p e dummy entities where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the p e dummy entities before and after the current p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPEDummyEntityId the primary key of the current p e dummy entity
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity[] findByUuid_C_PrevAndNext(
		long spPEDummyEntityId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spPEDummyEntityId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the p e dummy entities where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of p e dummy entities where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the p e dummy entity where name = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException} if it could not be found.
	*
	* @param name the name
	* @return the matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the p e dummy entity where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the p e dummy entity where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the p e dummy entity where name = &#63; from the database.
	*
	* @param name the name
	* @return the p e dummy entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of p e dummy entities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the p e dummy entities where spPEDummyEntityId = &#63;.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @return the matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByentityIds(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByentityIds(spPEDummyEntityId);
	}

	/**
	* Returns a range of all the p e dummy entities where spPEDummyEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @return the range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByentityIds(
		long spPEDummyEntityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByentityIds(spPEDummyEntityId, start, end);
	}

	/**
	* Returns an ordered range of all the p e dummy entities where spPEDummyEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByentityIds(
		long spPEDummyEntityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByentityIds(spPEDummyEntityId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByentityIds_First(
		long spPEDummyEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence()
				   .findByentityIds_First(spPEDummyEntityId, orderByComparator);
	}

	/**
	* Returns the first p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByentityIds_First(
		long spPEDummyEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityIds_First(spPEDummyEntityId, orderByComparator);
	}

	/**
	* Returns the last p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByentityIds_Last(
		long spPEDummyEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence()
				   .findByentityIds_Last(spPEDummyEntityId, orderByComparator);
	}

	/**
	* Returns the last p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByentityIds_Last(
		long spPEDummyEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityIds_Last(spPEDummyEntityId, orderByComparator);
	}

	/**
	* Returns all the p e dummy entities where spPEDummyEntityId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEDummyEntityIds the sp p e dummy entity IDs
	* @return the matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByentityIds(
		long[] spPEDummyEntityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByentityIds(spPEDummyEntityIds);
	}

	/**
	* Returns a range of all the p e dummy entities where spPEDummyEntityId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEDummyEntityIds the sp p e dummy entity IDs
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @return the range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByentityIds(
		long[] spPEDummyEntityIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByentityIds(spPEDummyEntityIds, start, end);
	}

	/**
	* Returns an ordered range of all the p e dummy entities where spPEDummyEntityId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPEDummyEntityIds the sp p e dummy entity IDs
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findByentityIds(
		long[] spPEDummyEntityIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByentityIds(spPEDummyEntityIds, start, end,
			orderByComparator);
	}

	/**
	* Removes all the p e dummy entities where spPEDummyEntityId = &#63; from the database.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByentityIds(long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByentityIds(spPEDummyEntityId);
	}

	/**
	* Returns the number of p e dummy entities where spPEDummyEntityId = &#63;.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID
	* @return the number of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByentityIds(long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByentityIds(spPEDummyEntityId);
	}

	/**
	* Returns the number of p e dummy entities where spPEDummyEntityId = any &#63;.
	*
	* @param spPEDummyEntityIds the sp p e dummy entity IDs
	* @return the number of matching p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByentityIds(long[] spPEDummyEntityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByentityIds(spPEDummyEntityIds);
	}

	/**
	* Caches the p e dummy entity in the entity cache if it is enabled.
	*
	* @param peDummyEntity the p e dummy entity
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity) {
		getPersistence().cacheResult(peDummyEntity);
	}

	/**
	* Caches the p e dummy entities in the entity cache if it is enabled.
	*
	* @param peDummyEntities the p e dummy entities
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> peDummyEntities) {
		getPersistence().cacheResult(peDummyEntities);
	}

	/**
	* Creates a new p e dummy entity with the primary key. Does not add the p e dummy entity to the database.
	*
	* @param spPEDummyEntityId the primary key for the new p e dummy entity
	* @return the new p e dummy entity
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity create(
		long spPEDummyEntityId) {
		return getPersistence().create(spPEDummyEntityId);
	}

	/**
	* Removes the p e dummy entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEDummyEntityId the primary key of the p e dummy entity
	* @return the p e dummy entity that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity remove(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().remove(spPEDummyEntityId);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(peDummyEntity);
	}

	/**
	* Returns the p e dummy entity with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException} if it could not be found.
	*
	* @param spPEDummyEntityId the primary key of the p e dummy entity
	* @return the p e dummy entity
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity findByPrimaryKey(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException {
		return getPersistence().findByPrimaryKey(spPEDummyEntityId);
	}

	/**
	* Returns the p e dummy entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPEDummyEntityId the primary key of the p e dummy entity
	* @return the p e dummy entity, or <code>null</code> if a p e dummy entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEDummyEntity fetchByPrimaryKey(
		long spPEDummyEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spPEDummyEntityId);
	}

	/**
	* Returns all the p e dummy entities.
	*
	* @return the p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p e dummy entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @return the range of p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p e dummy entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e dummy entities
	* @param end the upper bound of the range of p e dummy entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p e dummy entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p e dummy entities.
	*
	* @return the number of p e dummy entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PEDummyEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PEDummyEntityPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.getServletContextName(),
					PEDummyEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(PEDummyEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PEDummyEntityPersistence persistence) {
	}

	private static PEDummyEntityPersistence _persistence;
}