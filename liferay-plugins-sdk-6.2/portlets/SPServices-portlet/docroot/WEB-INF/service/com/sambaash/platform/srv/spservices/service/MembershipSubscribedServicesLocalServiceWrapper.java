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
 * Provides a wrapper for {@link MembershipSubscribedServicesLocalService}.
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServicesLocalService
 * @generated
 */
public class MembershipSubscribedServicesLocalServiceWrapper
	implements MembershipSubscribedServicesLocalService,
		ServiceWrapper<MembershipSubscribedServicesLocalService> {
	public MembershipSubscribedServicesLocalServiceWrapper(
		MembershipSubscribedServicesLocalService membershipSubscribedServicesLocalService) {
		_membershipSubscribedServicesLocalService = membershipSubscribedServicesLocalService;
	}

	/**
	* Adds the membership subscribed services to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscribedServices the membership subscribed services
	* @return the membership subscribed services that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices addMembershipSubscribedServices(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.addMembershipSubscribedServices(membershipSubscribedServices);
	}

	/**
	* Creates a new membership subscribed services with the primary key. Does not add the membership subscribed services to the database.
	*
	* @param mssId the primary key for the new membership subscribed services
	* @return the new membership subscribed services
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices createMembershipSubscribedServices(
		long mssId) {
		return _membershipSubscribedServicesLocalService.createMembershipSubscribedServices(mssId);
	}

	/**
	* Deletes the membership subscribed services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services that was removed
	* @throws PortalException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices deleteMembershipSubscribedServices(
		long mssId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.deleteMembershipSubscribedServices(mssId);
	}

	/**
	* Deletes the membership subscribed services from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscribedServices the membership subscribed services
	* @return the membership subscribed services that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices deleteMembershipSubscribedServices(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.deleteMembershipSubscribedServices(membershipSubscribedServices);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membershipSubscribedServicesLocalService.dynamicQuery();
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
		return _membershipSubscribedServicesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipSubscribedServicesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipSubscribedServicesLocalService.dynamicQuery(dynamicQuery,
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
		return _membershipSubscribedServicesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _membershipSubscribedServicesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchMembershipSubscribedServices(
		long mssId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.fetchMembershipSubscribedServices(mssId);
	}

	/**
	* Returns the membership subscribed services with the primary key.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services
	* @throws PortalException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices getMembershipSubscribedServices(
		long mssId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.getMembershipSubscribedServices(mssId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership subscribed serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @return the range of membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> getMembershipSubscribedServiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.getMembershipSubscribedServiceses(start,
			end);
	}

	/**
	* Returns the number of membership subscribed serviceses.
	*
	* @return the number of membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembershipSubscribedServicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.getMembershipSubscribedServicesesCount();
	}

	/**
	* Updates the membership subscribed services in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscribedServices the membership subscribed services
	* @return the membership subscribed services that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices updateMembershipSubscribedServices(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscribedServicesLocalService.updateMembershipSubscribedServices(membershipSubscribedServices);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _membershipSubscribedServicesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_membershipSubscribedServicesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _membershipSubscribedServicesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MembershipSubscribedServicesLocalService getWrappedMembershipSubscribedServicesLocalService() {
		return _membershipSubscribedServicesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMembershipSubscribedServicesLocalService(
		MembershipSubscribedServicesLocalService membershipSubscribedServicesLocalService) {
		_membershipSubscribedServicesLocalService = membershipSubscribedServicesLocalService;
	}

	@Override
	public MembershipSubscribedServicesLocalService getWrappedService() {
		return _membershipSubscribedServicesLocalService;
	}

	@Override
	public void setWrappedService(
		MembershipSubscribedServicesLocalService membershipSubscribedServicesLocalService) {
		_membershipSubscribedServicesLocalService = membershipSubscribedServicesLocalService;
	}

	private MembershipSubscribedServicesLocalService _membershipSubscribedServicesLocalService;
}