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

package com.sambaash.platform.srv.rsvp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RsvpLocalService}.
 *
 * @author gauravvijayvergia
 * @see RsvpLocalService
 * @generated
 */
public class RsvpLocalServiceWrapper implements RsvpLocalService,
	ServiceWrapper<RsvpLocalService> {
	public RsvpLocalServiceWrapper(RsvpLocalService rsvpLocalService) {
		_rsvpLocalService = rsvpLocalService;
	}

	/**
	* Adds the rsvp to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvp the rsvp
	* @return the rsvp that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp addRsvp(
		com.sambaash.platform.srv.rsvp.model.Rsvp rsvp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.addRsvp(rsvp);
	}

	/**
	* Creates a new rsvp with the primary key. Does not add the rsvp to the database.
	*
	* @param rsvpId the primary key for the new rsvp
	* @return the new rsvp
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp createRsvp(long rsvpId) {
		return _rsvpLocalService.createRsvp(rsvpId);
	}

	/**
	* Deletes the rsvp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpId the primary key of the rsvp
	* @return the rsvp that was removed
	* @throws PortalException if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp deleteRsvp(long rsvpId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.deleteRsvp(rsvpId);
	}

	/**
	* Deletes the rsvp from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvp the rsvp
	* @return the rsvp that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp deleteRsvp(
		com.sambaash.platform.srv.rsvp.model.Rsvp rsvp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.deleteRsvp(rsvp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rsvpLocalService.dynamicQuery();
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
		return _rsvpLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _rsvpLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rsvpLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp fetchRsvp(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.fetchRsvp(rsvpId);
	}

	/**
	* Returns the rsvp with the matching UUID and company.
	*
	* @param uuid the rsvp's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp fetchRsvpByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.fetchRsvpByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rsvp matching the UUID and group.
	*
	* @param uuid the rsvp's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp fetchRsvpByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.fetchRsvpByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rsvp with the primary key.
	*
	* @param rsvpId the primary key of the rsvp
	* @return the rsvp
	* @throws PortalException if a rsvp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp getRsvp(long rsvpId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.getRsvp(rsvpId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp with the matching UUID and company.
	*
	* @param uuid the rsvp's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp
	* @throws PortalException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp getRsvpByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.getRsvpByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rsvp matching the UUID and group.
	*
	* @param uuid the rsvp's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp
	* @throws PortalException if a matching rsvp could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp getRsvpByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.getRsvpByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rsvps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvps
	* @param end the upper bound of the range of rsvps (not inclusive)
	* @return the range of rsvps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.Rsvp> getRsvps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.getRsvps(start, end);
	}

	/**
	* Returns the number of rsvps.
	*
	* @return the number of rsvps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRsvpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.getRsvpsCount();
	}

	/**
	* Updates the rsvp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvp the rsvp
	* @return the rsvp that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp updateRsvp(
		com.sambaash.platform.srv.rsvp.model.Rsvp rsvp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpLocalService.updateRsvp(rsvp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rsvpLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rsvpLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rsvpLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil} to access the rsvp local service.
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp findByeventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return _rsvpLocalService.findByeventId(eventId);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp findByeventIdAndSpAssetTypeId(
		long eventId, long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return _rsvpLocalService.findByeventIdAndSpAssetTypeId(eventId,
			spAssetTypeId);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp findByspAssetTypeId(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return _rsvpLocalService.findByspAssetTypeId(spAssetTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RsvpLocalService getWrappedRsvpLocalService() {
		return _rsvpLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRsvpLocalService(RsvpLocalService rsvpLocalService) {
		_rsvpLocalService = rsvpLocalService;
	}

	@Override
	public RsvpLocalService getWrappedService() {
		return _rsvpLocalService;
	}

	@Override
	public void setWrappedService(RsvpLocalService rsvpLocalService) {
		_rsvpLocalService = rsvpLocalService;
	}

	private RsvpLocalService _rsvpLocalService;
}