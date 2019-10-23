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

package com.sambaash.platform.srv.sharing.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPSharingLocalService}.
 *
 * @author harini
 * @see SPSharingLocalService
 * @generated
 */
public class SPSharingLocalServiceWrapper implements SPSharingLocalService,
	ServiceWrapper<SPSharingLocalService> {
	public SPSharingLocalServiceWrapper(
		SPSharingLocalService spSharingLocalService) {
		_spSharingLocalService = spSharingLocalService;
	}

	/**
	* Adds the s p sharing to the database. Also notifies the appropriate model listeners.
	*
	* @param spSharing the s p sharing
	* @return the s p sharing that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing addSPSharing(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.addSPSharing(spSharing);
	}

	/**
	* Creates a new s p sharing with the primary key. Does not add the s p sharing to the database.
	*
	* @param spSharingId the primary key for the new s p sharing
	* @return the new s p sharing
	*/
	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing createSPSharing(
		long spSharingId) {
		return _spSharingLocalService.createSPSharing(spSharingId);
	}

	/**
	* Deletes the s p sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing that was removed
	* @throws PortalException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing deleteSPSharing(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.deleteSPSharing(spSharingId);
	}

	/**
	* Deletes the s p sharing from the database. Also notifies the appropriate model listeners.
	*
	* @param spSharing the s p sharing
	* @return the s p sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing deleteSPSharing(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.deleteSPSharing(spSharing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSharingLocalService.dynamicQuery();
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
		return _spSharingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSharingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSharingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spSharingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSharingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing fetchSPSharing(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.fetchSPSharing(spSharingId);
	}

	/**
	* Returns the s p sharing with the primary key.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing
	* @throws PortalException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing getSPSharing(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.getSPSharing(spSharingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getSPSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.getSPSharings(start, end);
	}

	/**
	* Returns the number of s p sharings.
	*
	* @return the number of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.getSPSharingsCount();
	}

	/**
	* Updates the s p sharing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSharing the s p sharing
	* @return the s p sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing updateSPSharing(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.updateSPSharing(spSharing);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSharingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSharingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSharingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing getSharing(
		long userId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getSharing(userId, classNameId, classPK);
	}

	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing getSharing(
		long userId, long classNameId, long classPK, boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getSharing(userId, classNameId, classPK,
			internalShare);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getSharing(
		long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getSharing(classPK, classNameId);
	}

	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing getSharing(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getSharing(emailAddress, classNameId,
			classPK, internalShare);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getFileSharing(
		long createdBy, long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharingLocalService.getFileSharing(createdBy, classPK,
			classNameId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharings(
		long userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getUserSharings(userId, date);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharedFiles(
		long userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getUserSharedFiles(userId, date);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharedFiles(
		long userId, java.util.Date date, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getUserSharedFiles(userId, date, start,
			end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharingByEmail(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return _spSharingLocalService.getUserSharingByEmail(emailAddress);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSharingLocalService getWrappedSPSharingLocalService() {
		return _spSharingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSharingLocalService(
		SPSharingLocalService spSharingLocalService) {
		_spSharingLocalService = spSharingLocalService;
	}

	@Override
	public SPSharingLocalService getWrappedService() {
		return _spSharingLocalService;
	}

	@Override
	public void setWrappedService(SPSharingLocalService spSharingLocalService) {
		_spSharingLocalService = spSharingLocalService;
	}

	private SPSharingLocalService _spSharingLocalService;
}