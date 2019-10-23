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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spprofile.model.ProfilePreferences;

import java.util.List;

/**
 * The persistence utility for the profile preferences service. This utility wraps {@link ProfilePreferencesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see ProfilePreferencesPersistence
 * @see ProfilePreferencesPersistenceImpl
 * @generated
 */
public class ProfilePreferencesUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ProfilePreferences profilePreferences) {
		getPersistence().clearCache(profilePreferences);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfilePreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfilePreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfilePreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProfilePreferences update(
		ProfilePreferences profilePreferences) throws SystemException {
		return getPersistence().update(profilePreferences);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProfilePreferences update(
		ProfilePreferences profilePreferences, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(profilePreferences, serviceContext);
	}

	/**
	* Returns all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @return the matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylayOutIdAndPortletId(layoutId, portletId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylayOutIdAndPortletId(layoutId, portletId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findBylayOutIdAndPortletId(
		java.lang.String layoutId, java.lang.String portletId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylayOutIdAndPortletId(layoutId, portletId, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdAndPortletId_First(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence()
				   .findBylayOutIdAndPortletId_First(layoutId, portletId,
			orderByComparator);
	}

	/**
	* Returns the first profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdAndPortletId_First(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylayOutIdAndPortletId_First(layoutId, portletId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdAndPortletId_Last(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence()
				   .findBylayOutIdAndPortletId_Last(layoutId, portletId,
			orderByComparator);
	}

	/**
	* Returns the last profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdAndPortletId_Last(
		java.lang.String layoutId, java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylayOutIdAndPortletId_Last(layoutId, portletId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences[] findBylayOutIdAndPortletId_PrevAndNext(
		long proferenceId, java.lang.String layoutId,
		java.lang.String portletId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence()
				   .findBylayOutIdAndPortletId_PrevAndNext(proferenceId,
			layoutId, portletId, orderByComparator);
	}

	/**
	* Removes all the profile preferenceses where layoutId = &#63; and portletId = &#63; from the database.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylayOutIdAndPortletId(java.lang.String layoutId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylayOutIdAndPortletId(layoutId, portletId);
	}

	/**
	* Returns the number of profile preferenceses where layoutId = &#63; and portletId = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @return the number of matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylayOutIdAndPortletId(java.lang.String layoutId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylayOutIdAndPortletId(layoutId, portletId);
	}

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
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences findBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence()
				   .findBylayOutIdPortletIdAndPreferenceName(layoutId,
			portletId, preferenceName);
	}

	/**
	* Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylayOutIdPortletIdAndPreferenceName(layoutId,
			portletId, preferenceName);
	}

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
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylayOutIdPortletIdAndPreferenceName(layoutId,
			portletId, preferenceName, retrieveFromCache);
	}

	/**
	* Removes the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; from the database.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the profile preferences that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences removeBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence()
				   .removeBylayOutIdPortletIdAndPreferenceName(layoutId,
			portletId, preferenceName);
	}

	/**
	* Returns the number of profile preferenceses where layoutId = &#63; and portletId = &#63; and preferenceName = &#63;.
	*
	* @param layoutId the layout ID
	* @param portletId the portlet ID
	* @param preferenceName the preference name
	* @return the number of matching profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylayOutIdPortletIdAndPreferenceName(
		java.lang.String layoutId, java.lang.String portletId,
		java.lang.String preferenceName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBylayOutIdPortletIdAndPreferenceName(layoutId,
			portletId, preferenceName);
	}

	/**
	* Caches the profile preferences in the entity cache if it is enabled.
	*
	* @param profilePreferences the profile preferences
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences) {
		getPersistence().cacheResult(profilePreferences);
	}

	/**
	* Caches the profile preferenceses in the entity cache if it is enabled.
	*
	* @param profilePreferenceses the profile preferenceses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> profilePreferenceses) {
		getPersistence().cacheResult(profilePreferenceses);
	}

	/**
	* Creates a new profile preferences with the primary key. Does not add the profile preferences to the database.
	*
	* @param proferenceId the primary key for the new profile preferences
	* @return the new profile preferences
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences create(
		long proferenceId) {
		return getPersistence().create(proferenceId);
	}

	/**
	* Removes the profile preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences that was removed
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences remove(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence().remove(proferenceId);
	}

	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences updateImpl(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(profilePreferences);
	}

	/**
	* Returns the profile preferences with the primary key or throws a {@link com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException} if it could not be found.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences
	* @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences findByPrimaryKey(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException {
		return getPersistence().findByPrimaryKey(proferenceId);
	}

	/**
	* Returns the profile preferences with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proferenceId the primary key of the profile preferences
	* @return the profile preferences, or <code>null</code> if a profile preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spprofile.model.ProfilePreferences fetchByPrimaryKey(
		long proferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(proferenceId);
	}

	/**
	* Returns all the profile preferenceses.
	*
	* @return the profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the profile preferenceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of profile preferenceses.
	*
	* @return the number of profile preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProfilePreferencesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProfilePreferencesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spprofile.service.ClpSerializer.getServletContextName(),
					ProfilePreferencesPersistence.class.getName());

			ReferenceRegistry.registerReference(ProfilePreferencesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProfilePreferencesPersistence persistence) {
	}

	private static ProfilePreferencesPersistence _persistence;
}