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

package com.sambaash.platform.srv.spprofile.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spprofile.model.ProfilePreferences;

/**
 * The persistence interface for the profile preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see ProfilePreferencesPersistenceImpl
 * @see ProfilePreferencesUtil
 * @generated
 */
public interface ProfilePreferencesPersistence extends BasePersistence<ProfilePreferences> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfilePreferencesUtil} to access the profile preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @return the matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param start the lower bound of the range of profile preferenceses
	* @param end the upper bound of the range of profile preferenceses (not inclusive)
	* @return the range of matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param start the lower bound of the range of profile preferenceses
	* @param end the upper bound of the range of profile preferenceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile preferences
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdAndPortletId_First(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	/**
	* Returns the first profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdAndPortletId_First(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile preferences
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdAndPortletId_Last(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	/**
	* Returns the last profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdAndPortletId_Last(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile preferenceses before and after the current profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param proferenceId the primary key of the current profile preferences
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next profile preferences
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences[] findBylayOutIdAndPortletId_PrevAndNext(
		long proferenceId, java.lang.String layoutId,
		java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	/**
	* Removes all the profile preferenceses where layoutId = &#63; and portletId = &#63; from the database.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBylayOutIdAndPortletId(java.lang.String layoutId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profile preferenceses where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @return the number of matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public int countBylayOutIdAndPortletId(java.lang.String layoutId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or throws a {@link com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException} if it could not be found.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the matching profile preferences
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	/**
	* Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; from the database.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the profile preferences that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences removeBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	/**
	* Returns the number of profile preferenceses where layoutId = &#63; and portletId = &#63; and preferenceName = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the number of matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public int countBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the profile preferences in the entity cache if it is enabled.
	*
	* @param profilePreferences the profile preferences
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences);

	/**
	* Caches the profile preferenceses in the entity cache if it is enabled.
	*
	* @param profilePreferenceses the profile preferenceses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> profilePreferenceses);

	/**
	* Creates a new profile preferences with the primary key. Does not add the profile preferences to the database.
	*
	* @param proferenceId the primary key for the new profile preferences
	* @return the new profile preferences
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences create(
		long proferenceId);

	/**
	* Removes the profile preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences that was removed
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences remove(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences updateImpl(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the profile preferences with the primary key or throws a {@link com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException} if it could not be found.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences findByPrimaryKey(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;

	/**
	* Returns the profile preferences with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences, or <code>null</code> if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchByPrimaryKey(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the profile preferenceses.
	*
	* @return the profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the profile preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile preferenceses
	* @param end the upper bound of the range of profile preferenceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the profile preferenceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of profile preferenceses.
	*
	* @return the number of profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}