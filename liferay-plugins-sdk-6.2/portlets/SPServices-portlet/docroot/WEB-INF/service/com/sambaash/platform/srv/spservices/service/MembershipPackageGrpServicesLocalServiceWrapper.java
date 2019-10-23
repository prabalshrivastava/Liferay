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
 * Provides a wrapper for {@link MembershipPackageGrpServicesLocalService}.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageGrpServicesLocalService
 * @generated
 */
public class MembershipPackageGrpServicesLocalServiceWrapper
	implements MembershipPackageGrpServicesLocalService,
		ServiceWrapper<MembershipPackageGrpServicesLocalService> {
	public MembershipPackageGrpServicesLocalServiceWrapper(
		MembershipPackageGrpServicesLocalService membershipPackageGrpServicesLocalService) {
		_membershipPackageGrpServicesLocalService = membershipPackageGrpServicesLocalService;
	}

	/**
	* Adds the membership package grp services to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageGrpServices the membership package grp services
	* @return the membership package grp services that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices addMembershipPackageGrpServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.addMembershipPackageGrpServices(membershipPackageGrpServices);
	}

	/**
	* Creates a new membership package grp services with the primary key. Does not add the membership package grp services to the database.
	*
	* @param mpgsscId the primary key for the new membership package grp services
	* @return the new membership package grp services
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices createMembershipPackageGrpServices(
		long mpgsscId) {
		return _membershipPackageGrpServicesLocalService.createMembershipPackageGrpServices(mpgsscId);
	}

	/**
	* Deletes the membership package grp services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services that was removed
	* @throws PortalException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices deleteMembershipPackageGrpServices(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.deleteMembershipPackageGrpServices(mpgsscId);
	}

	/**
	* Deletes the membership package grp services from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageGrpServices the membership package grp services
	* @return the membership package grp services that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices deleteMembershipPackageGrpServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.deleteMembershipPackageGrpServices(membershipPackageGrpServices);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membershipPackageGrpServicesLocalService.dynamicQuery();
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
		return _membershipPackageGrpServicesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipPackageGrpServicesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _membershipPackageGrpServicesLocalService.dynamicQuery(dynamicQuery,
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
		return _membershipPackageGrpServicesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _membershipPackageGrpServicesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchMembershipPackageGrpServices(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.fetchMembershipPackageGrpServices(mpgsscId);
	}

	/**
	* Returns the membership package grp services with the primary key.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services
	* @throws PortalException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices getMembershipPackageGrpServices(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.getMembershipPackageGrpServices(mpgsscId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership package grp serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> getMembershipPackageGrpServiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.getMembershipPackageGrpServiceses(start,
			end);
	}

	/**
	* Returns the number of membership package grp serviceses.
	*
	* @return the number of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembershipPackageGrpServicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.getMembershipPackageGrpServicesesCount();
	}

	/**
	* Updates the membership package grp services in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageGrpServices the membership package grp services
	* @return the membership package grp services that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices updateMembershipPackageGrpServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.updateMembershipPackageGrpServices(membershipPackageGrpServices);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _membershipPackageGrpServicesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_membershipPackageGrpServicesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _membershipPackageGrpServicesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByMembershipPackageGrpServicesScgId(scgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByMembershipPackageGrpServicesScgId(scgId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByMembershipPackageGrpServicesScId(scId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByMembershipPackageGrpServicesScId(scId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByMembershipPackageGrpServicesMpId(mpId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByMembershipPackageGrpServicesMpId(mpId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByServiceNameMpId(
		long mpId, java.lang.String extra2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipPackageGrpServicesLocalService.findByServiceNameMpId(mpId,
			extra2);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MembershipPackageGrpServicesLocalService getWrappedMembershipPackageGrpServicesLocalService() {
		return _membershipPackageGrpServicesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMembershipPackageGrpServicesLocalService(
		MembershipPackageGrpServicesLocalService membershipPackageGrpServicesLocalService) {
		_membershipPackageGrpServicesLocalService = membershipPackageGrpServicesLocalService;
	}

	@Override
	public MembershipPackageGrpServicesLocalService getWrappedService() {
		return _membershipPackageGrpServicesLocalService;
	}

	@Override
	public void setWrappedService(
		MembershipPackageGrpServicesLocalService membershipPackageGrpServicesLocalService) {
		_membershipPackageGrpServicesLocalService = membershipPackageGrpServicesLocalService;
	}

	private MembershipPackageGrpServicesLocalService _membershipPackageGrpServicesLocalService;
}