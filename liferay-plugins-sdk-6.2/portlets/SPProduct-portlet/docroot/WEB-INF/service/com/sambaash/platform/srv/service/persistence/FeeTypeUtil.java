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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.FeeType;

import java.util.List;

/**
 * The persistence utility for the fee type service. This utility wraps {@link FeeTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeTypePersistence
 * @see FeeTypePersistenceImpl
 * @generated
 */
public class FeeTypeUtil {
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
	public static void clearCache(FeeType feeType) {
		getPersistence().clearCache(feeType);
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
	public static List<FeeType> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FeeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FeeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FeeType update(FeeType feeType) throws SystemException {
		return getPersistence().update(feeType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FeeType update(FeeType feeType, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(feeType, serviceContext);
	}

	/**
	* Returns all the fee types where misc = &#63;.
	*
	* @param misc the misc
	* @return the matching fee types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeType> findByMisc(
		boolean misc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMisc(misc);
	}

	/**
	* Returns a range of all the fee types where misc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param misc the misc
	* @param start the lower bound of the range of fee types
	* @param end the upper bound of the range of fee types (not inclusive)
	* @return the range of matching fee types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeType> findByMisc(
		boolean misc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMisc(misc, start, end);
	}

	/**
	* Returns an ordered range of all the fee types where misc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param misc the misc
	* @param start the lower bound of the range of fee types
	* @param end the upper bound of the range of fee types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fee types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeType> findByMisc(
		boolean misc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMisc(misc, start, end, orderByComparator);
	}

	/**
	* Returns the first fee type in the ordered set where misc = &#63;.
	*
	* @param misc the misc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee type
	* @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType findByMisc_First(
		boolean misc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence().findByMisc_First(misc, orderByComparator);
	}

	/**
	* Returns the first fee type in the ordered set where misc = &#63;.
	*
	* @param misc the misc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee type, or <code>null</code> if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType fetchByMisc_First(
		boolean misc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMisc_First(misc, orderByComparator);
	}

	/**
	* Returns the last fee type in the ordered set where misc = &#63;.
	*
	* @param misc the misc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee type
	* @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType findByMisc_Last(
		boolean misc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence().findByMisc_Last(misc, orderByComparator);
	}

	/**
	* Returns the last fee type in the ordered set where misc = &#63;.
	*
	* @param misc the misc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee type, or <code>null</code> if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType fetchByMisc_Last(
		boolean misc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMisc_Last(misc, orderByComparator);
	}

	/**
	* Returns the fee types before and after the current fee type in the ordered set where misc = &#63;.
	*
	* @param spFeeTypeId the primary key of the current fee type
	* @param misc the misc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fee type
	* @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType[] findByMisc_PrevAndNext(
		long spFeeTypeId, boolean misc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence()
				   .findByMisc_PrevAndNext(spFeeTypeId, misc, orderByComparator);
	}

	/**
	* Removes all the fee types where misc = &#63; from the database.
	*
	* @param misc the misc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMisc(boolean misc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMisc(misc);
	}

	/**
	* Returns the number of fee types where misc = &#63;.
	*
	* @param misc the misc
	* @return the number of matching fee types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMisc(boolean misc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMisc(misc);
	}

	/**
	* Returns the fee type where feeTypeName = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeTypeException} if it could not be found.
	*
	* @param feeTypeName the fee type name
	* @return the matching fee type
	* @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType findByFeeTypeName(
		java.lang.String feeTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence().findByFeeTypeName(feeTypeName);
	}

	/**
	* Returns the fee type where feeTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param feeTypeName the fee type name
	* @return the matching fee type, or <code>null</code> if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType fetchByFeeTypeName(
		java.lang.String feeTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFeeTypeName(feeTypeName);
	}

	/**
	* Returns the fee type where feeTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param feeTypeName the fee type name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching fee type, or <code>null</code> if a matching fee type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType fetchByFeeTypeName(
		java.lang.String feeTypeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFeeTypeName(feeTypeName, retrieveFromCache);
	}

	/**
	* Removes the fee type where feeTypeName = &#63; from the database.
	*
	* @param feeTypeName the fee type name
	* @return the fee type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType removeByFeeTypeName(
		java.lang.String feeTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence().removeByFeeTypeName(feeTypeName);
	}

	/**
	* Returns the number of fee types where feeTypeName = &#63;.
	*
	* @param feeTypeName the fee type name
	* @return the number of matching fee types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFeeTypeName(java.lang.String feeTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFeeTypeName(feeTypeName);
	}

	/**
	* Caches the fee type in the entity cache if it is enabled.
	*
	* @param feeType the fee type
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.FeeType feeType) {
		getPersistence().cacheResult(feeType);
	}

	/**
	* Caches the fee types in the entity cache if it is enabled.
	*
	* @param feeTypes the fee types
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.FeeType> feeTypes) {
		getPersistence().cacheResult(feeTypes);
	}

	/**
	* Creates a new fee type with the primary key. Does not add the fee type to the database.
	*
	* @param spFeeTypeId the primary key for the new fee type
	* @return the new fee type
	*/
	public static com.sambaash.platform.srv.model.FeeType create(
		long spFeeTypeId) {
		return getPersistence().create(spFeeTypeId);
	}

	/**
	* Removes the fee type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFeeTypeId the primary key of the fee type
	* @return the fee type that was removed
	* @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType remove(
		long spFeeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence().remove(spFeeTypeId);
	}

	public static com.sambaash.platform.srv.model.FeeType updateImpl(
		com.sambaash.platform.srv.model.FeeType feeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(feeType);
	}

	/**
	* Returns the fee type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFeeTypeException} if it could not be found.
	*
	* @param spFeeTypeId the primary key of the fee type
	* @return the fee type
	* @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType findByPrimaryKey(
		long spFeeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeTypeException {
		return getPersistence().findByPrimaryKey(spFeeTypeId);
	}

	/**
	* Returns the fee type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spFeeTypeId the primary key of the fee type
	* @return the fee type, or <code>null</code> if a fee type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeType fetchByPrimaryKey(
		long spFeeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spFeeTypeId);
	}

	/**
	* Returns all the fee types.
	*
	* @return the fee types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fee types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fee types
	* @param end the upper bound of the range of fee types (not inclusive)
	* @return the range of fee types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fee types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fee types
	* @param end the upper bound of the range of fee types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fee types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fee types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fee types.
	*
	* @return the number of fee types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FeeTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FeeTypePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					FeeTypePersistence.class.getName());

			ReferenceRegistry.registerReference(FeeTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FeeTypePersistence persistence) {
	}

	private static FeeTypePersistence _persistence;
}