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

package com.sambaash.platform.srv.spprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfilePreferencesLocalService}.
 *
 * @author harini
 * @see ProfilePreferencesLocalService
 * @generated
 */
public class ProfilePreferencesLocalServiceWrapper
	implements ProfilePreferencesLocalService,
		ServiceWrapper<ProfilePreferencesLocalService> {
	public ProfilePreferencesLocalServiceWrapper(
		ProfilePreferencesLocalService profilePreferencesLocalService) {
		_profilePreferencesLocalService = profilePreferencesLocalService;
	}

	/**
	* Adds the profile preferences to the database. Also notifies the appropriate model listeners.
	*
	* @param profilePreferences the profile preferences
	* @return the profile preferences that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences addProfilePreferences(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.addProfilePreferences(profilePreferences);
	}

	/**
	* Creates a new profile preferences with the primary key. Does not add the profile preferences to the database.
	*
	* @param proferenceId the primary key for the new profile preferences
	* @return the new profile preferences
	*/
	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences createProfilePreferences(
		long proferenceId) {
		return _profilePreferencesLocalService.createProfilePreferences(proferenceId);
	}

	/**
	* Deletes the profile preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences that was removed
	* @throws PortalException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences deleteProfilePreferences(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.deleteProfilePreferences(proferenceId);
	}

	/**
	* Deletes the profile preferences from the database. Also notifies the appropriate model listeners.
	*
	* @param profilePreferences the profile preferences
	* @return the profile preferences that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences deleteProfilePreferences(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.deleteProfilePreferences(profilePreferences);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profilePreferencesLocalService.dynamicQuery();
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
		return _profilePreferencesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _profilePreferencesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _profilePreferencesLocalService.dynamicQuery(dynamicQuery,
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
		return _profilePreferencesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _profilePreferencesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchProfilePreferences(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.fetchProfilePreferences(proferenceId);
	}

	/**
	* Returns the profile preferences with the primary key.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences
	* @throws PortalException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences getProfilePreferences(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.getProfilePreferences(proferenceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the profile preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile preferenceses
	* @param end the upper bound of the range of profile preferenceses (not inclusive)
	* @return the range of profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> getProfilePreferenceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.getProfilePreferenceses(start,
			end);
	}

	/**
	* Returns the number of profile preferenceses.
	*
	* @return the number of profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProfilePreferencesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.getProfilePreferencesesCount();
	}

	/**
	* Updates the profile preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profilePreferences the profile preferences
	* @return the profile preferences that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences updateProfilePreferences(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferencesLocalService.updateProfilePreferences(profilePreferences);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _profilePreferencesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_profilePreferencesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _profilePreferencesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return _profilePreferencesLocalService.findBylayOutIdAndPortletId(layoutId,
			portletId);
	}

	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdPreferencesNameAndPortletId(
		java.lang.String layoutId, java.lang.String preferenceName,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return _profilePreferencesLocalService.findBylayOutIdPreferencesNameAndPortletId(layoutId,
			preferenceName, portletId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProfilePreferencesLocalService getWrappedProfilePreferencesLocalService() {
		return _profilePreferencesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProfilePreferencesLocalService(
		ProfilePreferencesLocalService profilePreferencesLocalService) {
		_profilePreferencesLocalService = profilePreferencesLocalService;
	}

	@Override
	public ProfilePreferencesLocalService getWrappedService() {
		return _profilePreferencesLocalService;
	}

	@Override
	public void setWrappedService(
		ProfilePreferencesLocalService profilePreferencesLocalService) {
		_profilePreferencesLocalService = profilePreferencesLocalService;
	}

	private ProfilePreferencesLocalService _profilePreferencesLocalService;
}