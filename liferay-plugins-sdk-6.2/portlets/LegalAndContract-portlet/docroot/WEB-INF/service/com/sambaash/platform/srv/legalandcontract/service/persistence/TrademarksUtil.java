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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.legalandcontract.model.Trademarks;

import java.util.List;

/**
 * The persistence utility for the trademarks service. This utility wraps {@link TrademarksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see TrademarksPersistence
 * @see TrademarksPersistenceImpl
 * @generated
 */
public class TrademarksUtil {
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
	public static void clearCache(Trademarks trademarks) {
		getPersistence().clearCache(trademarks);
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
	public static List<Trademarks> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Trademarks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Trademarks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Trademarks update(Trademarks trademarks)
		throws SystemException {
		return getPersistence().update(trademarks);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Trademarks update(Trademarks trademarks,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(trademarks, serviceContext);
	}

	/**
	* Returns all the trademarkses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the trademarkses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @return the range of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the trademarkses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first trademarks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first trademarks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last trademarks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last trademarks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the trademarkses before and after the current trademarks in the ordered set where uuid = &#63;.
	*
	* @param spTrademarksId the primary key of the current trademarks
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks[] findByUuid_PrevAndNext(
		long spTrademarksId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spTrademarksId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the trademarkses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of trademarkses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the trademarks where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the trademarks where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the trademarks where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the trademarks where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the trademarks that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of trademarkses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the trademarkses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the trademarkses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @return the range of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the trademarkses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the trademarkses before and after the current trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spTrademarksId the primary key of the current trademarks
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks[] findByUuid_C_PrevAndNext(
		long spTrademarksId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spTrademarksId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the trademarkses where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of trademarkses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the trademarks where registrationNumber = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	*
	* @param registrationNumber the registration number
	* @param country the country
	* @return the matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByRegistrationNumberCountry(
		java.lang.String registrationNumber, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByRegistrationNumberCountry(registrationNumber, country);
	}

	/**
	* Returns the trademarks where registrationNumber = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param registrationNumber the registration number
	* @param country the country
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByRegistrationNumberCountry(
		java.lang.String registrationNumber, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegistrationNumberCountry(registrationNumber, country);
	}

	/**
	* Returns the trademarks where registrationNumber = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param registrationNumber the registration number
	* @param country the country
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByRegistrationNumberCountry(
		java.lang.String registrationNumber, java.lang.String country,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegistrationNumberCountry(registrationNumber,
			country, retrieveFromCache);
	}

	/**
	* Removes the trademarks where registrationNumber = &#63; and country = &#63; from the database.
	*
	* @param registrationNumber the registration number
	* @param country the country
	* @return the trademarks that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks removeByRegistrationNumberCountry(
		java.lang.String registrationNumber, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .removeByRegistrationNumberCountry(registrationNumber,
			country);
	}

	/**
	* Returns the number of trademarkses where registrationNumber = &#63; and country = &#63;.
	*
	* @param registrationNumber the registration number
	* @param country the country
	* @return the number of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegistrationNumberCountry(
		java.lang.String registrationNumber, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRegistrationNumberCountry(registrationNumber, country);
	}

	/**
	* Returns the trademarks where applicationNo = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	*
	* @param applicationNo the application no
	* @param country the country
	* @return the matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByApplicationNoCountry(
		java.lang.String applicationNo, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByApplicationNoCountry(applicationNo, country);
	}

	/**
	* Returns the trademarks where applicationNo = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param applicationNo the application no
	* @param country the country
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByApplicationNoCountry(
		java.lang.String applicationNo, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicationNoCountry(applicationNo, country);
	}

	/**
	* Returns the trademarks where applicationNo = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param applicationNo the application no
	* @param country the country
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByApplicationNoCountry(
		java.lang.String applicationNo, java.lang.String country,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicationNoCountry(applicationNo, country,
			retrieveFromCache);
	}

	/**
	* Removes the trademarks where applicationNo = &#63; and country = &#63; from the database.
	*
	* @param applicationNo the application no
	* @param country the country
	* @return the trademarks that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks removeByApplicationNoCountry(
		java.lang.String applicationNo, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .removeByApplicationNoCountry(applicationNo, country);
	}

	/**
	* Returns the number of trademarkses where applicationNo = &#63; and country = &#63;.
	*
	* @param applicationNo the application no
	* @param country the country
	* @return the number of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApplicationNoCountry(
		java.lang.String applicationNo, java.lang.String country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByApplicationNoCountry(applicationNo, country);
	}

	/**
	* Returns the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	*
	* @param applicationNo the application no
	* @param country the country
	* @param version the version
	* @return the matching trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByApplicationNoCountryVersion(
		java.lang.String applicationNo, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .findByApplicationNoCountryVersion(applicationNo, country,
			version);
	}

	/**
	* Returns the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param applicationNo the application no
	* @param country the country
	* @param version the version
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByApplicationNoCountryVersion(
		java.lang.String applicationNo, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicationNoCountryVersion(applicationNo, country,
			version);
	}

	/**
	* Returns the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param applicationNo the application no
	* @param country the country
	* @param version the version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByApplicationNoCountryVersion(
		java.lang.String applicationNo, java.lang.String country,
		java.lang.String version, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicationNoCountryVersion(applicationNo, country,
			version, retrieveFromCache);
	}

	/**
	* Removes the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; from the database.
	*
	* @param applicationNo the application no
	* @param country the country
	* @param version the version
	* @return the trademarks that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks removeByApplicationNoCountryVersion(
		java.lang.String applicationNo, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence()
				   .removeByApplicationNoCountryVersion(applicationNo, country,
			version);
	}

	/**
	* Returns the number of trademarkses where applicationNo = &#63; and country = &#63; and version = &#63;.
	*
	* @param applicationNo the application no
	* @param country the country
	* @param version the version
	* @return the number of matching trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApplicationNoCountryVersion(
		java.lang.String applicationNo, java.lang.String country,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByApplicationNoCountryVersion(applicationNo, country,
			version);
	}

	/**
	* Caches the trademarks in the entity cache if it is enabled.
	*
	* @param trademarks the trademarks
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks) {
		getPersistence().cacheResult(trademarks);
	}

	/**
	* Caches the trademarkses in the entity cache if it is enabled.
	*
	* @param trademarkses the trademarkses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> trademarkses) {
		getPersistence().cacheResult(trademarkses);
	}

	/**
	* Creates a new trademarks with the primary key. Does not add the trademarks to the database.
	*
	* @param spTrademarksId the primary key for the new trademarks
	* @return the new trademarks
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks create(
		long spTrademarksId) {
		return getPersistence().create(spTrademarksId);
	}

	/**
	* Removes the trademarks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTrademarksId the primary key of the trademarks
	* @return the trademarks that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks remove(
		long spTrademarksId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence().remove(spTrademarksId);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(trademarks);
	}

	/**
	* Returns the trademarks with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	*
	* @param spTrademarksId the primary key of the trademarks
	* @return the trademarks
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks findByPrimaryKey(
		long spTrademarksId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException {
		return getPersistence().findByPrimaryKey(spTrademarksId);
	}

	/**
	* Returns the trademarks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spTrademarksId the primary key of the trademarks
	* @return the trademarks, or <code>null</code> if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchByPrimaryKey(
		long spTrademarksId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spTrademarksId);
	}

	/**
	* Returns all the trademarkses.
	*
	* @return the trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the trademarkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @return the range of trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the trademarkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the trademarkses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of trademarkses.
	*
	* @return the number of trademarkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TrademarksPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TrademarksPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.getServletContextName(),
					TrademarksPersistence.class.getName());

			ReferenceRegistry.registerReference(TrademarksUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TrademarksPersistence persistence) {
	}

	private static TrademarksPersistence _persistence;
}