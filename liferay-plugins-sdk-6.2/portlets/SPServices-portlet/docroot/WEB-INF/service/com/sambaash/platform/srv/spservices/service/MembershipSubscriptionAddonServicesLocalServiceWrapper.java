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
 * Provides a wrapper for {@link MembershipSubscriptionAddonServicesLocalService}.
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionAddonServicesLocalService
 * @generated
 */
public class MembershipSubscriptionAddonServicesLocalServiceWrapper
	implements MembershipSubscriptionAddonServicesLocalService,
		ServiceWrapper<MembershipSubscriptionAddonServicesLocalService> {
	public MembershipSubscriptionAddonServicesLocalServiceWrapper(
		MembershipSubscriptionAddonServicesLocalService membershipSubscriptionAddonServicesLocalService) {
		_membershipSubscriptionAddonServicesLocalService = membershipSubscriptionAddonServicesLocalService;
	}

	/**
	* Adds the membership subscription addon services to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscriptionAddonServices the membership subscription addon services
	* @return the membership subscription addon services that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices addMembershipSubscriptionAddonServices(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.addMembershipSubscriptionAddonServices(membershipSubscriptionAddonServices);
	}

	/**
	* Creates a new membership subscription addon services with the primary key. Does not add the membership subscription addon services to the database.
	*
	* @param msAddonId the primary key for the new membership subscription addon services
	* @return the new membership subscription addon services
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices createMembershipSubscriptionAddonServices(
		long msAddonId) {
		return _membershipSubscriptionAddonServicesLocalService.createMembershipSubscriptionAddonServices(msAddonId);
	}

	/**
	* Deletes the membership subscription addon services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services that was removed
	* @throws PortalException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices deleteMembershipSubscriptionAddonServices(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.deleteMembershipSubscriptionAddonServices(msAddonId);
	}

	/**
	* Deletes the membership subscription addon services from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscriptionAddonServices the membership subscription addon services
	* @return the membership subscription addon services that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices deleteMembershipSubscriptionAddonServices(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.deleteMembershipSubscriptionAddonServices(membershipSubscriptionAddonServices);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membershipSubscriptionAddonServicesLocalService.dynamicQuery();
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
		return _membershipSubscriptionAddonServicesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipSubscriptionAddonServicesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipSubscriptionAddonServicesLocalService.dynamicQuery(dynamicQuery,
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
		return _membershipSubscriptionAddonServicesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _membershipSubscriptionAddonServicesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchMembershipSubscriptionAddonServices(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.fetchMembershipSubscriptionAddonServices(msAddonId);
	}

	/**
	* Returns the membership subscription addon services with the primary key.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services
	* @throws PortalException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices getMembershipSubscriptionAddonServices(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.getMembershipSubscriptionAddonServices(msAddonId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership subscription addon serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @return the range of membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> getMembershipSubscriptionAddonServiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.getMembershipSubscriptionAddonServiceses(start,
			end);
	}

	/**
	* Returns the number of membership subscription addon serviceses.
	*
	* @return the number of membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembershipSubscriptionAddonServicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.getMembershipSubscriptionAddonServicesesCount();
	}

	/**
	* Updates the membership subscription addon services in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscriptionAddonServices the membership subscription addon services
	* @return the membership subscription addon services that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices updateMembershipSubscriptionAddonServices(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionAddonServicesLocalService.updateMembershipSubscriptionAddonServices(membershipSubscriptionAddonServices);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _membershipSubscriptionAddonServicesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_membershipSubscriptionAddonServicesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _membershipSubscriptionAddonServicesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MembershipSubscriptionAddonServicesLocalService getWrappedMembershipSubscriptionAddonServicesLocalService() {
		return _membershipSubscriptionAddonServicesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMembershipSubscriptionAddonServicesLocalService(
		MembershipSubscriptionAddonServicesLocalService membershipSubscriptionAddonServicesLocalService) {
		_membershipSubscriptionAddonServicesLocalService = membershipSubscriptionAddonServicesLocalService;
	}

	@Override
	public MembershipSubscriptionAddonServicesLocalService getWrappedService() {
		return _membershipSubscriptionAddonServicesLocalService;
	}

	@Override
	public void setWrappedService(
		MembershipSubscriptionAddonServicesLocalService membershipSubscriptionAddonServicesLocalService) {
		_membershipSubscriptionAddonServicesLocalService = membershipSubscriptionAddonServicesLocalService;
	}

	private MembershipSubscriptionAddonServicesLocalService _membershipSubscriptionAddonServicesLocalService;
}