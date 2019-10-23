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

import com.sambaash.platform.srv.model.MiscellaneousFees;

import java.util.List;

/**
 * The persistence utility for the miscellaneous fees service. This utility wraps {@link MiscellaneousFeesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MiscellaneousFeesPersistence
 * @see MiscellaneousFeesPersistenceImpl
 * @generated
 */
public class MiscellaneousFeesUtil {
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
	public static void clearCache(MiscellaneousFees miscellaneousFees) {
		getPersistence().clearCache(miscellaneousFees);
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
	public static List<MiscellaneousFees> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MiscellaneousFees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MiscellaneousFees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MiscellaneousFees update(MiscellaneousFees miscellaneousFees)
		throws SystemException {
		return getPersistence().update(miscellaneousFees);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MiscellaneousFees update(
		MiscellaneousFees miscellaneousFees, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(miscellaneousFees, serviceContext);
	}

	/**
	* Returns all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns a range of all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of miscellaneous feeses
	* @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	* @return the range of matching miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndGroupId(spCourseId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of miscellaneous feeses
	* @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndGroupId(spCourseId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching miscellaneous fees
	* @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence()
				   .findByCourseIdAndGroupId_First(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndGroupId_First(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching miscellaneous fees
	* @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence()
				   .findByCourseIdAndGroupId_Last(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndGroupId_Last(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the miscellaneous feeses before and after the current miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spMiscFeesId the primary key of the current miscellaneous fees
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next miscellaneous fees
	* @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees[] findByCourseIdAndGroupId_PrevAndNext(
		long spMiscFeesId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence()
				   .findByCourseIdAndGroupId_PrevAndNext(spMiscFeesId,
			spCourseId, groupId, orderByComparator);
	}

	/**
	* Removes all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns the number of miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchMiscellaneousFeesException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @param miscFeeType the misc fee type
	* @return the matching miscellaneous fees
	* @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees findByCourseIdFeeType(
		long spCourseId, long miscFeeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence().findByCourseIdFeeType(spCourseId, miscFeeType);
	}

	/**
	* Returns the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param miscFeeType the misc fee type
	* @return the matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees fetchByCourseIdFeeType(
		long spCourseId, long miscFeeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseIdFeeType(spCourseId, miscFeeType);
	}

	/**
	* Returns the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param miscFeeType the misc fee type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees fetchByCourseIdFeeType(
		long spCourseId, long miscFeeType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdFeeType(spCourseId, miscFeeType,
			retrieveFromCache);
	}

	/**
	* Removes the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param miscFeeType the misc fee type
	* @return the miscellaneous fees that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees removeByCourseIdFeeType(
		long spCourseId, long miscFeeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence().removeByCourseIdFeeType(spCourseId, miscFeeType);
	}

	/**
	* Returns the number of miscellaneous feeses where spCourseId = &#63; and miscFeeType = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param miscFeeType the misc fee type
	* @return the number of matching miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdFeeType(long spCourseId, long miscFeeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseIdFeeType(spCourseId, miscFeeType);
	}

	/**
	* Caches the miscellaneous fees in the entity cache if it is enabled.
	*
	* @param miscellaneousFees the miscellaneous fees
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees) {
		getPersistence().cacheResult(miscellaneousFees);
	}

	/**
	* Caches the miscellaneous feeses in the entity cache if it is enabled.
	*
	* @param miscellaneousFeeses the miscellaneous feeses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> miscellaneousFeeses) {
		getPersistence().cacheResult(miscellaneousFeeses);
	}

	/**
	* Creates a new miscellaneous fees with the primary key. Does not add the miscellaneous fees to the database.
	*
	* @param spMiscFeesId the primary key for the new miscellaneous fees
	* @return the new miscellaneous fees
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees create(
		long spMiscFeesId) {
		return getPersistence().create(spMiscFeesId);
	}

	/**
	* Removes the miscellaneous fees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMiscFeesId the primary key of the miscellaneous fees
	* @return the miscellaneous fees that was removed
	* @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees remove(
		long spMiscFeesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence().remove(spMiscFeesId);
	}

	public static com.sambaash.platform.srv.model.MiscellaneousFees updateImpl(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(miscellaneousFees);
	}

	/**
	* Returns the miscellaneous fees with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchMiscellaneousFeesException} if it could not be found.
	*
	* @param spMiscFeesId the primary key of the miscellaneous fees
	* @return the miscellaneous fees
	* @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees findByPrimaryKey(
		long spMiscFeesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getPersistence().findByPrimaryKey(spMiscFeesId);
	}

	/**
	* Returns the miscellaneous fees with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMiscFeesId the primary key of the miscellaneous fees
	* @return the miscellaneous fees, or <code>null</code> if a miscellaneous fees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees fetchByPrimaryKey(
		long spMiscFeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMiscFeesId);
	}

	/**
	* Returns all the miscellaneous feeses.
	*
	* @return the miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the miscellaneous feeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of miscellaneous feeses
	* @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	* @return the range of miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the miscellaneous feeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of miscellaneous feeses
	* @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the miscellaneous feeses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of miscellaneous feeses.
	*
	* @return the number of miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MiscellaneousFeesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MiscellaneousFeesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					MiscellaneousFeesPersistence.class.getName());

			ReferenceRegistry.registerReference(MiscellaneousFeesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MiscellaneousFeesPersistence persistence) {
	}

	private static MiscellaneousFeesPersistence _persistence;
}