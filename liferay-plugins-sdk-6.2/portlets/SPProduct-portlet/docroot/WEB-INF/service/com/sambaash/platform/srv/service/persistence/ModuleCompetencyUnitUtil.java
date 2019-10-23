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

import com.sambaash.platform.srv.model.ModuleCompetencyUnit;

import java.util.List;

/**
 * The persistence utility for the module competency unit service. This utility wraps {@link ModuleCompetencyUnitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCompetencyUnitPersistence
 * @see ModuleCompetencyUnitPersistenceImpl
 * @generated
 */
public class ModuleCompetencyUnitUtil {
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
	public static void clearCache(ModuleCompetencyUnit moduleCompetencyUnit) {
		getPersistence().clearCache(moduleCompetencyUnit);
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
	public static List<ModuleCompetencyUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ModuleCompetencyUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ModuleCompetencyUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ModuleCompetencyUnit update(
		ModuleCompetencyUnit moduleCompetencyUnit) throws SystemException {
		return getPersistence().update(moduleCompetencyUnit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ModuleCompetencyUnit update(
		ModuleCompetencyUnit moduleCompetencyUnit, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(moduleCompetencyUnit, serviceContext);
	}

	/**
	* Returns all the module competency units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the module competency units where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @return the range of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the module competency units where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first module competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first module competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last module competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last module competency unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the module competency units before and after the current module competency unit in the ordered set where groupId = &#63;.
	*
	* @param spModuleCompetencyUnitId the primary key of the current module competency unit
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit[] findByGroupId_PrevAndNext(
		long spModuleCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spModuleCompetencyUnitId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the module competency units where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of module competency units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the module competency units where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleIdAndGroupId(spModuleId, groupId);
	}

	/**
	* Returns a range of all the module competency units where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @return the range of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdAndGroupId(spModuleId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the module competency units where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdAndGroupId(spModuleId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByModuleIdAndGroupId_First(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdAndGroupId_First(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByModuleIdAndGroupId_Last(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdAndGroupId_Last(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Returns the module competency units before and after the current module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleCompetencyUnitId the primary key of the current module competency unit
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleCompetencyUnitId, long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByModuleIdAndGroupId_PrevAndNext(spModuleCompetencyUnitId,
			spModuleId, groupId, orderByComparator);
	}

	/**
	* Removes all the module competency units where spModuleId = &#63; and groupId = &#63; from the database.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByModuleIdAndGroupId(spModuleId, groupId);
	}

	/**
	* Returns the number of module competency units where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the number of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleIdAndGroupId(spModuleId, groupId);
	}

	/**
	* Returns all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @return the matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompetencyUnitIdAndGroupId(spCompetencyUnitId, groupId);
	}

	/**
	* Returns a range of all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @return the range of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompetencyUnitIdAndGroupId(spCompetencyUnitId,
			groupId, start, end);
	}

	/**
	* Returns an ordered range of all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompetencyUnitIdAndGroupId(spCompetencyUnitId,
			groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByCompetencyUnitIdAndGroupId_First(
		long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByCompetencyUnitIdAndGroupId_First(spCompetencyUnitId,
			groupId, orderByComparator);
	}

	/**
	* Returns the first module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByCompetencyUnitIdAndGroupId_First(
		long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyUnitIdAndGroupId_First(spCompetencyUnitId,
			groupId, orderByComparator);
	}

	/**
	* Returns the last module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByCompetencyUnitIdAndGroupId_Last(
		long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByCompetencyUnitIdAndGroupId_Last(spCompetencyUnitId,
			groupId, orderByComparator);
	}

	/**
	* Returns the last module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByCompetencyUnitIdAndGroupId_Last(
		long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyUnitIdAndGroupId_Last(spCompetencyUnitId,
			groupId, orderByComparator);
	}

	/**
	* Returns the module competency units before and after the current module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spModuleCompetencyUnitId the primary key of the current module competency unit
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit[] findByCompetencyUnitIdAndGroupId_PrevAndNext(
		long spModuleCompetencyUnitId, long spCompetencyUnitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence()
				   .findByCompetencyUnitIdAndGroupId_PrevAndNext(spModuleCompetencyUnitId,
			spCompetencyUnitId, groupId, orderByComparator);
	}

	/**
	* Removes all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63; from the database.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCompetencyUnitIdAndGroupId(spCompetencyUnitId, groupId);
	}

	/**
	* Returns the number of module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	*
	* @param spCompetencyUnitId the sp competency unit ID
	* @param groupId the group ID
	* @return the number of matching module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompetencyUnitIdAndGroupId(spCompetencyUnitId,
			groupId);
	}

	/**
	* Caches the module competency unit in the entity cache if it is enabled.
	*
	* @param moduleCompetencyUnit the module competency unit
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit) {
		getPersistence().cacheResult(moduleCompetencyUnit);
	}

	/**
	* Caches the module competency units in the entity cache if it is enabled.
	*
	* @param moduleCompetencyUnits the module competency units
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> moduleCompetencyUnits) {
		getPersistence().cacheResult(moduleCompetencyUnits);
	}

	/**
	* Creates a new module competency unit with the primary key. Does not add the module competency unit to the database.
	*
	* @param spModuleCompetencyUnitId the primary key for the new module competency unit
	* @return the new module competency unit
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit create(
		long spModuleCompetencyUnitId) {
		return getPersistence().create(spModuleCompetencyUnitId);
	}

	/**
	* Removes the module competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spModuleCompetencyUnitId the primary key of the module competency unit
	* @return the module competency unit that was removed
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit remove(
		long spModuleCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence().remove(spModuleCompetencyUnitId);
	}

	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit updateImpl(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(moduleCompetencyUnit);
	}

	/**
	* Returns the module competency unit with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException} if it could not be found.
	*
	* @param spModuleCompetencyUnitId the primary key of the module competency unit
	* @return the module competency unit
	* @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit findByPrimaryKey(
		long spModuleCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException {
		return getPersistence().findByPrimaryKey(spModuleCompetencyUnitId);
	}

	/**
	* Returns the module competency unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spModuleCompetencyUnitId the primary key of the module competency unit
	* @return the module competency unit, or <code>null</code> if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchByPrimaryKey(
		long spModuleCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spModuleCompetencyUnitId);
	}

	/**
	* Returns all the module competency units.
	*
	* @return the module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the module competency units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @return the range of module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the module competency units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the module competency units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of module competency units.
	*
	* @return the number of module competency units
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ModuleCompetencyUnitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ModuleCompetencyUnitPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					ModuleCompetencyUnitPersistence.class.getName());

			ReferenceRegistry.registerReference(ModuleCompetencyUnitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ModuleCompetencyUnitPersistence persistence) {
	}

	private static ModuleCompetencyUnitPersistence _persistence;
}