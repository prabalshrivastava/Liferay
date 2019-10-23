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

package com.sambaash.platform.srv.roles.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPRoles. This utility wraps
 * {@link com.sambaash.platform.srv.roles.service.impl.SPRolesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPRolesLocalService
 * @see com.sambaash.platform.srv.roles.service.base.SPRolesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.roles.service.impl.SPRolesLocalServiceImpl
 * @generated
 */
public class SPRolesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.roles.service.impl.SPRolesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p roles to the database. Also notifies the appropriate model listeners.
	*
	* @param spRoles the s p roles
	* @return the s p roles that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles addSPRoles(
		com.sambaash.platform.srv.roles.model.SPRoles spRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPRoles(spRoles);
	}

	/**
	* Creates a new s p roles with the primary key. Does not add the s p roles to the database.
	*
	* @param spRoleId the primary key for the new s p roles
	* @return the new s p roles
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles createSPRoles(
		long spRoleId) {
		return getService().createSPRoles(spRoleId);
	}

	/**
	* Deletes the s p roles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRoleId the primary key of the s p roles
	* @return the s p roles that was removed
	* @throws PortalException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles deleteSPRoles(
		long spRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPRoles(spRoleId);
	}

	/**
	* Deletes the s p roles from the database. Also notifies the appropriate model listeners.
	*
	* @param spRoles the s p roles
	* @return the s p roles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles deleteSPRoles(
		com.sambaash.platform.srv.roles.model.SPRoles spRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPRoles(spRoles);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.roles.model.SPRoles fetchSPRoles(
		long spRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPRoles(spRoleId);
	}

	/**
	* Returns the s p roles with the matching UUID and company.
	*
	* @param uuid the s p roles's UUID
	* @param companyId the primary key of the company
	* @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchSPRolesByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPRolesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p roles matching the UUID and group.
	*
	* @param uuid the s p roles's UUID
	* @param groupId the primary key of the group
	* @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles fetchSPRolesByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPRolesByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p roles with the primary key.
	*
	* @param spRoleId the primary key of the s p roles
	* @return the s p roles
	* @throws PortalException if a s p roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles getSPRoles(
		long spRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPRoles(spRoleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p roles with the matching UUID and company.
	*
	* @param uuid the s p roles's UUID
	* @param companyId the primary key of the company
	* @return the matching s p roles
	* @throws PortalException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles getSPRolesByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPRolesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p roles matching the UUID and group.
	*
	* @param uuid the s p roles's UUID
	* @param groupId the primary key of the group
	* @return the matching s p roles
	* @throws PortalException if a matching s p roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles getSPRolesByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPRolesByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p roleses
	* @param end the upper bound of the range of s p roleses (not inclusive)
	* @return the range of s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> getSPRoleses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPRoleses(start, end);
	}

	/**
	* Returns the number of s p roleses.
	*
	* @return the number of s p roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPRolesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPRolesesCount();
	}

	/**
	* Updates the s p roles in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spRoles the s p roles
	* @return the s p roles that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.roles.model.SPRoles updateSPRoles(
		com.sambaash.platform.srv.roles.model.SPRoles spRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPRoles(spRoles);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCategoryId1(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryId1(groupId, categoryId);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCategoryId1(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryId1(groupId, categoryId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryId(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCountryCategoryId(groupId, userId);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByDepartmentCategoryId(
		long groupId, long countryCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentCategoryId(groupId, countryCategoryId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil} to access the s p roles local service.
	*/
	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleId(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleId(groupId, roleId);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId1(
		long groupId, long roleId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleIdCategoryId1(groupId, roleId, categoryId);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId1(
		long groupId, long roleId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByRoleIdCategoryId1(groupId, roleId, categoryId, start,
			end);
	}

	public static com.sambaash.platform.srv.roles.model.SPRoles findByRoleIdCategoryId1AndCategoryId2(
		long groupId, long roleId, long categoryId1, long categoryId2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPRolesException {
		return getService()
				   .findByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId2(
		long groupId, long roleId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleIdCategoryId2(groupId, roleId, categoryId);
	}

	public static java.util.List<com.sambaash.platform.srv.roles.model.SPRoles> findByRoleIdCategoryId2(
		long groupId, long roleId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByRoleIdCategoryId2(groupId, roleId, categoryId, start,
			end);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPRolesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPRolesLocalService.class.getName());

			if (invokableLocalService instanceof SPRolesLocalService) {
				_service = (SPRolesLocalService)invokableLocalService;
			}
			else {
				_service = new SPRolesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPRolesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPRolesLocalService service) {
	}

	private static SPRolesLocalService _service;
}