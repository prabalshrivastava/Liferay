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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MembershipPackageServicesRolesLocalService}.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageServicesRolesLocalService
 * @generated
 */
public class MembershipPackageServicesRolesLocalServiceWrapper
	implements MembershipPackageServicesRolesLocalService,
		ServiceWrapper<MembershipPackageServicesRolesLocalService> {
	public MembershipPackageServicesRolesLocalServiceWrapper(
		MembershipPackageServicesRolesLocalService membershipPackageServicesRolesLocalService) {
		_membershipPackageServicesRolesLocalService = membershipPackageServicesRolesLocalService;
	}

	/**
	* Adds the membership package services roles to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	* @return the membership package services roles that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles addMembershipPackageServicesRoles(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.addMembershipPackageServicesRoles(membershipPackageServicesRoles);
	}

	/**
	* Creates a new membership package services roles with the primary key. Does not add the membership package services roles to the database.
	*
	* @param mpgsrlId the primary key for the new membership package services roles
	* @return the new membership package services roles
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles createMembershipPackageServicesRoles(
		long mpgsrlId) {
		return _membershipPackageServicesRolesLocalService.createMembershipPackageServicesRoles(mpgsrlId);
	}

	/**
	* Deletes the membership package services roles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles that was removed
	* @throws PortalException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles deleteMembershipPackageServicesRoles(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.deleteMembershipPackageServicesRoles(mpgsrlId);
	}

	/**
	* Deletes the membership package services roles from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	* @return the membership package services roles that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles deleteMembershipPackageServicesRoles(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.deleteMembershipPackageServicesRoles(membershipPackageServicesRoles);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membershipPackageServicesRolesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchMembershipPackageServicesRoles(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.fetchMembershipPackageServicesRoles(mpgsrlId);
	}

	/**
	* Returns the membership package services roles with the primary key.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles
	* @throws PortalException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles getMembershipPackageServicesRoles(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.getMembershipPackageServicesRoles(mpgsrlId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership package services roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> getMembershipPackageServicesRoleses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.getMembershipPackageServicesRoleses(start,
			end);
	}

	/**
	* Returns the number of membership package services roleses.
	*
	* @return the number of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembershipPackageServicesRolesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.getMembershipPackageServicesRolesesCount();
	}

	/**
	* Updates the membership package services roles in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	* @return the membership package services roles that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles updateMembershipPackageServicesRoles(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.updateMembershipPackageServicesRoles(membershipPackageServicesRoles);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _membershipPackageServicesRolesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_membershipPackageServicesRolesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _membershipPackageServicesRolesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBygetMembershipPackageServiceRoles(
		long mpId, long classNameId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findBygetMembershipPackageServiceRoles(mpId,
			classNameId, serviceId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackage(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findByMembershipPackage(mpId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findByMembershipPackageId(mpId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageRole(
		long mpId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findByMembershipPackageRole(mpId,
			roleId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByRoleId(
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findByRoleId(roleId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceId(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findByServiceId(serviceId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.findByServiceNameMpId(mpId,
			extra1);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Role> getUserMembershipRoles(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageServicesRolesLocalService.getUserMembershipRoles(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MembershipPackageServicesRolesLocalService getWrappedMembershipPackageServicesRolesLocalService() {
		return _membershipPackageServicesRolesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMembershipPackageServicesRolesLocalService(
		MembershipPackageServicesRolesLocalService membershipPackageServicesRolesLocalService) {
		_membershipPackageServicesRolesLocalService = membershipPackageServicesRolesLocalService;
	}

	@Override
	public MembershipPackageServicesRolesLocalService getWrappedService() {
		return _membershipPackageServicesRolesLocalService;
	}

	@Override
	public void setWrappedService(
		MembershipPackageServicesRolesLocalService membershipPackageServicesRolesLocalService) {
		_membershipPackageServicesRolesLocalService = membershipPackageServicesRolesLocalService;
	}

	private MembershipPackageServicesRolesLocalService _membershipPackageServicesRolesLocalService;
}