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

import com.sambaash.platform.srv.model.Module;

import java.util.List;

/**
 * The persistence utility for the module service. This utility wraps {@link ModulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModulePersistence
 * @see ModulePersistenceImpl
 * @generated
 */
public class ModuleUtil {
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
	public static void clearCache(Module module) {
		getPersistence().clearCache(module);
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
	public static List<Module> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Module> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Module> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Module update(Module module) throws SystemException {
		return getPersistence().update(module);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Module update(Module module, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(module, serviceContext);
	}

	/**
	* Returns all the modules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the modules where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @return the range of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the modules where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the modules before and after the current module in the ordered set where groupId = &#63;.
	*
	* @param spModuleId the primary key of the current module
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module[] findByGroupId_PrevAndNext(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the modules where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of modules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the modules where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByCountryIdAndGroupId(
		long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns a range of all the modules where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @return the range of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the modules where countryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByCountryIdAndGroupId(
		long countryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupId(countryId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first module in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first module in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByCountryIdAndGroupId_First(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_First(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last module in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last module in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByCountryIdAndGroupId_Last(
		long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupId_Last(countryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the modules before and after the current module in the ordered set where countryId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the primary key of the current module
	* @param countryId the country ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module[] findByCountryIdAndGroupId_PrevAndNext(
		long spModuleId, long countryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByCountryIdAndGroupId_PrevAndNext(spModuleId,
			countryId, groupId, orderByComparator);
	}

	/**
	* Removes all the modules where countryId = &#63; and groupId = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns the number of modules where countryId = &#63; and groupId = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @return the number of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupId(long countryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryIdAndGroupId(countryId, groupId);
	}

	/**
	* Returns all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @return the matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByCountryIdAndGroupIdAndModuleCode(
		long countryId, long groupId, java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode);
	}

	/**
	* Returns a range of all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @return the range of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByCountryIdAndGroupIdAndModuleCode(
		long countryId, long groupId, java.lang.String moduleCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode, start, end);
	}

	/**
	* Returns an ordered range of all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findByCountryIdAndGroupIdAndModuleCode(
		long countryId, long groupId, java.lang.String moduleCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode, start, end, orderByComparator);
	}

	/**
	* Returns the first module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByCountryIdAndGroupIdAndModuleCode_First(
		long countryId, long groupId, java.lang.String moduleCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndModuleCode_First(countryId,
			groupId, moduleCode, orderByComparator);
	}

	/**
	* Returns the first module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByCountryIdAndGroupIdAndModuleCode_First(
		long countryId, long groupId, java.lang.String moduleCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupIdAndModuleCode_First(countryId,
			groupId, moduleCode, orderByComparator);
	}

	/**
	* Returns the last module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByCountryIdAndGroupIdAndModuleCode_Last(
		long countryId, long groupId, java.lang.String moduleCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndModuleCode_Last(countryId,
			groupId, moduleCode, orderByComparator);
	}

	/**
	* Returns the last module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByCountryIdAndGroupIdAndModuleCode_Last(
		long countryId, long groupId, java.lang.String moduleCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryIdAndGroupIdAndModuleCode_Last(countryId,
			groupId, moduleCode, orderByComparator);
	}

	/**
	* Returns the modules before and after the current module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param spModuleId the primary key of the current module
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module[] findByCountryIdAndGroupIdAndModuleCode_PrevAndNext(
		long spModuleId, long countryId, long groupId,
		java.lang.String moduleCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence()
				   .findByCountryIdAndGroupIdAndModuleCode_PrevAndNext(spModuleId,
			countryId, groupId, moduleCode, orderByComparator);
	}

	/**
	* Removes all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63; from the database.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryIdAndGroupIdAndModuleCode(
		long countryId, long groupId, java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode);
	}

	/**
	* Returns the number of modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	*
	* @param countryId the country ID
	* @param groupId the group ID
	* @param moduleCode the module code
	* @return the number of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryIdAndGroupIdAndModuleCode(long countryId,
		long groupId, java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode);
	}

	/**
	* Returns the module where moduleCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchModuleException} if it could not be found.
	*
	* @param moduleCode the module code
	* @return the matching module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByModuleCode(
		java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence().findByModuleCode(moduleCode);
	}

	/**
	* Returns the module where moduleCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param moduleCode the module code
	* @return the matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByModuleCode(
		java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByModuleCode(moduleCode);
	}

	/**
	* Returns the module where moduleCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param moduleCode the module code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching module, or <code>null</code> if a matching module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByModuleCode(
		java.lang.String moduleCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByModuleCode(moduleCode, retrieveFromCache);
	}

	/**
	* Removes the module where moduleCode = &#63; from the database.
	*
	* @param moduleCode the module code
	* @return the module that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module removeByModuleCode(
		java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence().removeByModuleCode(moduleCode);
	}

	/**
	* Returns the number of modules where moduleCode = &#63;.
	*
	* @param moduleCode the module code
	* @return the number of matching modules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleCode(java.lang.String moduleCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleCode(moduleCode);
	}

	/**
	* Caches the module in the entity cache if it is enabled.
	*
	* @param module the module
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Module module) {
		getPersistence().cacheResult(module);
	}

	/**
	* Caches the modules in the entity cache if it is enabled.
	*
	* @param modules the modules
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Module> modules) {
		getPersistence().cacheResult(modules);
	}

	/**
	* Creates a new module with the primary key. Does not add the module to the database.
	*
	* @param spModuleId the primary key for the new module
	* @return the new module
	*/
	public static com.sambaash.platform.srv.model.Module create(long spModuleId) {
		return getPersistence().create(spModuleId);
	}

	/**
	* Removes the module with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spModuleId the primary key of the module
	* @return the module that was removed
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module remove(long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence().remove(spModuleId);
	}

	public static com.sambaash.platform.srv.model.Module updateImpl(
		com.sambaash.platform.srv.model.Module module)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(module);
	}

	/**
	* Returns the module with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleException} if it could not be found.
	*
	* @param spModuleId the primary key of the module
	* @return the module
	* @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module findByPrimaryKey(
		long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleException {
		return getPersistence().findByPrimaryKey(spModuleId);
	}

	/**
	* Returns the module with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spModuleId the primary key of the module
	* @return the module, or <code>null</code> if a module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Module fetchByPrimaryKey(
		long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spModuleId);
	}

	/**
	* Returns all the modules.
	*
	* @return the modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @return the range of modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of modules
	* @param end the upper bound of the range of modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of modules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Module> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the modules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of modules.
	*
	* @return the number of modules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ModulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ModulePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					ModulePersistence.class.getName());

			ReferenceRegistry.registerReference(ModuleUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ModulePersistence persistence) {
	}

	private static ModulePersistence _persistence;
}