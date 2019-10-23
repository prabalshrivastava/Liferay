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

package com.sambaash.platform.srv.extendedprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPCertificationLocalService}.
 *
 * @author harini
 * @see SPCertificationLocalService
 * @generated
 */
public class SPCertificationLocalServiceWrapper
	implements SPCertificationLocalService,
		ServiceWrapper<SPCertificationLocalService> {
	public SPCertificationLocalServiceWrapper(
		SPCertificationLocalService spCertificationLocalService) {
		_spCertificationLocalService = spCertificationLocalService;
	}

	/**
	* Adds the s p certification to the database. Also notifies the appropriate model listeners.
	*
	* @param spCertification the s p certification
	* @return the s p certification that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification addSPCertification(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.addSPCertification(spCertification);
	}

	/**
	* Creates a new s p certification with the primary key. Does not add the s p certification to the database.
	*
	* @param classPk the primary key for the new s p certification
	* @return the new s p certification
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification createSPCertification(
		long classPk) {
		return _spCertificationLocalService.createSPCertification(classPk);
	}

	/**
	* Deletes the s p certification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification that was removed
	* @throws PortalException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification deleteSPCertification(
		long classPk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.deleteSPCertification(classPk);
	}

	/**
	* Deletes the s p certification from the database. Also notifies the appropriate model listeners.
	*
	* @param spCertification the s p certification
	* @return the s p certification that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification deleteSPCertification(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.deleteSPCertification(spCertification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spCertificationLocalService.dynamicQuery();
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
		return _spCertificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spCertificationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spCertificationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _spCertificationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spCertificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification fetchSPCertification(
		long classPk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.fetchSPCertification(classPk);
	}

	/**
	* Returns the s p certification with the primary key.
	*
	* @param classPk the primary key of the s p certification
	* @return the s p certification
	* @throws PortalException if a s p certification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification getSPCertification(
		long classPk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.getSPCertification(classPk);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p certifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p certifications
	* @param end the upper bound of the range of s p certifications (not inclusive)
	* @return the range of s p certifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> getSPCertifications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.getSPCertifications(start, end);
	}

	/**
	* Returns the number of s p certifications.
	*
	* @return the number of s p certifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPCertificationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.getSPCertificationsCount();
	}

	/**
	* Updates the s p certification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spCertification the s p certification
	* @return the s p certification that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification updateSPCertification(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.updateSPCertification(spCertification);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spCertificationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spCertificationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spCertificationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification findByUserIdAndCertificationId(
		long userId, long certificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException {
		return _spCertificationLocalService.findByUserIdAndCertificationId(userId,
			certificationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.findByUserId(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.findByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCertification> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertificationLocalService.findByUserId(userId, start, end,
			orderByComparator);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPCertificationLocalService getWrappedSPCertificationLocalService() {
		return _spCertificationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPCertificationLocalService(
		SPCertificationLocalService spCertificationLocalService) {
		_spCertificationLocalService = spCertificationLocalService;
	}

	@Override
	public SPCertificationLocalService getWrappedService() {
		return _spCertificationLocalService;
	}

	@Override
	public void setWrappedService(
		SPCertificationLocalService spCertificationLocalService) {
		_spCertificationLocalService = spCertificationLocalService;
	}

	private SPCertificationLocalService _spCertificationLocalService;
}