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
 * Provides a wrapper for {@link MembershipPackageAddonServicesLocalService}.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageAddonServicesLocalService
 * @generated
 */
public class MembershipPackageAddonServicesLocalServiceWrapper
	implements MembershipPackageAddonServicesLocalService,
		ServiceWrapper<MembershipPackageAddonServicesLocalService> {
	public MembershipPackageAddonServicesLocalServiceWrapper(
		MembershipPackageAddonServicesLocalService membershipPackageAddonServicesLocalService) {
		_membershipPackageAddonServicesLocalService = membershipPackageAddonServicesLocalService;
	}

	/**
	* Adds the membership package addon services to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageAddonServices the membership package addon services
	* @return the membership package addon services that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices addMembershipPackageAddonServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.addMembershipPackageAddonServices(membershipPackageAddonServices);
	}

	/**
	* Creates a new membership package addon services with the primary key. Does not add the membership package addon services to the database.
	*
	* @param mpAddonId the primary key for the new membership package addon services
	* @return the new membership package addon services
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices createMembershipPackageAddonServices(
		long mpAddonId) {
		return _membershipPackageAddonServicesLocalService.createMembershipPackageAddonServices(mpAddonId);
	}

	/**
	* Deletes the membership package addon services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services that was removed
	* @throws PortalException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices deleteMembershipPackageAddonServices(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.deleteMembershipPackageAddonServices(mpAddonId);
	}

	/**
	* Deletes the membership package addon services from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageAddonServices the membership package addon services
	* @return the membership package addon services that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices deleteMembershipPackageAddonServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.deleteMembershipPackageAddonServices(membershipPackageAddonServices);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membershipPackageAddonServicesLocalService.dynamicQuery();
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
		return _membershipPackageAddonServicesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipPackageAddonServicesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipPackageAddonServicesLocalService.dynamicQuery(dynamicQuery,
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
		return _membershipPackageAddonServicesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _membershipPackageAddonServicesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchMembershipPackageAddonServices(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.fetchMembershipPackageAddonServices(mpAddonId);
	}

	/**
	* Returns the membership package addon services with the primary key.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services
	* @throws PortalException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices getMembershipPackageAddonServices(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.getMembershipPackageAddonServices(mpAddonId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership package addon serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @return the range of membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> getMembershipPackageAddonServiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.getMembershipPackageAddonServiceses(start,
			end);
	}

	/**
	* Returns the number of membership package addon serviceses.
	*
	* @return the number of membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembershipPackageAddonServicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.getMembershipPackageAddonServicesesCount();
	}

	/**
	* Updates the membership package addon services in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageAddonServices the membership package addon services
	* @return the membership package addon services that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices updateMembershipPackageAddonServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.updateMembershipPackageAddonServices(membershipPackageAddonServices);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _membershipPackageAddonServicesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_membershipPackageAddonServicesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _membershipPackageAddonServicesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.findByMembershipPackageAddonServicesScId(scId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.findByMembershipPackageAddonServicesScId(scId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageAddonServicesLocalService.findByServiceNameMpId(extra1,
			scName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MembershipPackageAddonServicesLocalService getWrappedMembershipPackageAddonServicesLocalService() {
		return _membershipPackageAddonServicesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMembershipPackageAddonServicesLocalService(
		MembershipPackageAddonServicesLocalService membershipPackageAddonServicesLocalService) {
		_membershipPackageAddonServicesLocalService = membershipPackageAddonServicesLocalService;
	}

	@Override
	public MembershipPackageAddonServicesLocalService getWrappedService() {
		return _membershipPackageAddonServicesLocalService;
	}

	@Override
	public void setWrappedService(
		MembershipPackageAddonServicesLocalService membershipPackageAddonServicesLocalService) {
		_membershipPackageAddonServicesLocalService = membershipPackageAddonServicesLocalService;
	}

	private MembershipPackageAddonServicesLocalService _membershipPackageAddonServicesLocalService;
}