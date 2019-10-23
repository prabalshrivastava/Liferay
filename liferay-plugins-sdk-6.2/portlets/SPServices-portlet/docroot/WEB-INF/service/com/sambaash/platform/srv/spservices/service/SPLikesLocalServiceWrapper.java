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
 * Provides a wrapper for {@link SPLikesLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPLikesLocalService
 * @generated
 */
public class SPLikesLocalServiceWrapper implements SPLikesLocalService,
	ServiceWrapper<SPLikesLocalService> {
	public SPLikesLocalServiceWrapper(SPLikesLocalService spLikesLocalService) {
		_spLikesLocalService = spLikesLocalService;
	}

	/**
	* Adds the s p likes to the database. Also notifies the appropriate model listeners.
	*
	* @param spLikes the s p likes
	* @return the s p likes that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes addSPLikes(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.addSPLikes(spLikes);
	}

	/**
	* Creates a new s p likes with the primary key. Does not add the s p likes to the database.
	*
	* @param spLikesId the primary key for the new s p likes
	* @return the new s p likes
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes createSPLikes(
		long spLikesId) {
		return _spLikesLocalService.createSPLikes(spLikesId);
	}

	/**
	* Deletes the s p likes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLikesId the primary key of the s p likes
	* @return the s p likes that was removed
	* @throws PortalException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes deleteSPLikes(
		long spLikesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.deleteSPLikes(spLikesId);
	}

	/**
	* Deletes the s p likes from the database. Also notifies the appropriate model listeners.
	*
	* @param spLikes the s p likes
	* @return the s p likes that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes deleteSPLikes(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.deleteSPLikes(spLikes);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spLikesLocalService.dynamicQuery();
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
		return _spLikesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spLikesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spLikesLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spLikesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spLikesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes fetchSPLikes(
		long spLikesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.fetchSPLikes(spLikesId);
	}

	/**
	* Returns the s p likes with the matching UUID and company.
	*
	* @param uuid the s p likes's UUID
	* @param companyId the primary key of the company
	* @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes fetchSPLikesByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.fetchSPLikesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p likes matching the UUID and group.
	*
	* @param uuid the s p likes's UUID
	* @param groupId the primary key of the group
	* @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes fetchSPLikesByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.fetchSPLikesByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p likes with the primary key.
	*
	* @param spLikesId the primary key of the s p likes
	* @return the s p likes
	* @throws PortalException if a s p likes with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes getSPLikes(
		long spLikesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.getSPLikes(spLikesId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p likes with the matching UUID and company.
	*
	* @param uuid the s p likes's UUID
	* @param companyId the primary key of the company
	* @return the matching s p likes
	* @throws PortalException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes getSPLikesByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.getSPLikesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p likes matching the UUID and group.
	*
	* @param uuid the s p likes's UUID
	* @param groupId the primary key of the group
	* @return the matching s p likes
	* @throws PortalException if a matching s p likes could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes getSPLikesByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.getSPLikesByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p likeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p likeses
	* @param end the upper bound of the range of s p likeses (not inclusive)
	* @return the range of s p likeses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPLikes> getSPLikeses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.getSPLikeses(start, end);
	}

	/**
	* Returns the number of s p likeses.
	*
	* @return the number of s p likeses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPLikesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.getSPLikesesCount();
	}

	/**
	* Updates the s p likes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spLikes the s p likes
	* @return the s p likes that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes updateSPLikes(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikesLocalService.updateSPLikes(spLikes);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spLikesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spLikesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spLikesLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPLikesLocalService getWrappedSPLikesLocalService() {
		return _spLikesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPLikesLocalService(
		SPLikesLocalService spLikesLocalService) {
		_spLikesLocalService = spLikesLocalService;
	}

	@Override
	public SPLikesLocalService getWrappedService() {
		return _spLikesLocalService;
	}

	@Override
	public void setWrappedService(SPLikesLocalService spLikesLocalService) {
		_spLikesLocalService = spLikesLocalService;
	}

	private SPLikesLocalService _spLikesLocalService;
}