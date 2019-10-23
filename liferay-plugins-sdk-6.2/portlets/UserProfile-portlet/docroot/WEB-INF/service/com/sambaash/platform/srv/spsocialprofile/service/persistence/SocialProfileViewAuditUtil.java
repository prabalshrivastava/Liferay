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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit;

import java.util.List;

/**
 * The persistence utility for the social profile view audit service. This utility wraps {@link SocialProfileViewAuditPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileViewAuditPersistence
 * @see SocialProfileViewAuditPersistenceImpl
 * @generated
 */
public class SocialProfileViewAuditUtil {
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
	public static void clearCache(SocialProfileViewAudit socialProfileViewAudit) {
		getPersistence().clearCache(socialProfileViewAudit);
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
	public static List<SocialProfileViewAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialProfileViewAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialProfileViewAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SocialProfileViewAudit update(
		SocialProfileViewAudit socialProfileViewAudit)
		throws SystemException {
		return getPersistence().update(socialProfileViewAudit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SocialProfileViewAudit update(
		SocialProfileViewAudit socialProfileViewAudit,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(socialProfileViewAudit, serviceContext);
	}

	/**
	* Returns all the social profile view audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the social profile view audits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of social profile view audits
	* @param end the upper bound of the range of social profile view audits (not inclusive)
	* @return the range of matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the social profile view audits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of social profile view audits
	* @param end the upper bound of the range of social profile view audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the social profile view audits before and after the current social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param socialProfileViewAuditId the primary key of the current social profile view audit
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit[] findByUuid_PrevAndNext(
		long socialProfileViewAuditId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence()
				   .findByUuid_PrevAndNext(socialProfileViewAuditId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the social profile view audits where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of social profile view audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException} if it could not be found.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the matching social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence()
				   .findByLoggedInUserIdAndProfileUserId(loggedInUserId,
			profileUserId);
	}

	/**
	* Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLoggedInUserIdAndProfileUserId(loggedInUserId,
			profileUserId);
	}

	/**
	* Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLoggedInUserIdAndProfileUserId(loggedInUserId,
			profileUserId, retrieveFromCache);
	}

	/**
	* Removes the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; from the database.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the social profile view audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit removeByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence()
				   .removeByLoggedInUserIdAndProfileUserId(loggedInUserId,
			profileUserId);
	}

	/**
	* Returns the number of social profile view audits where loggedInUserId = &#63; and profileUserId = &#63;.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the number of matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLoggedInUserIdAndProfileUserId(loggedInUserId,
			profileUserId);
	}

	/**
	* Caches the social profile view audit in the entity cache if it is enabled.
	*
	* @param socialProfileViewAudit the social profile view audit
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit socialProfileViewAudit) {
		getPersistence().cacheResult(socialProfileViewAudit);
	}

	/**
	* Caches the social profile view audits in the entity cache if it is enabled.
	*
	* @param socialProfileViewAudits the social profile view audits
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> socialProfileViewAudits) {
		getPersistence().cacheResult(socialProfileViewAudits);
	}

	/**
	* Creates a new social profile view audit with the primary key. Does not add the social profile view audit to the database.
	*
	* @param socialProfileViewAuditId the primary key for the new social profile view audit
	* @return the new social profile view audit
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit create(
		long socialProfileViewAuditId) {
		return getPersistence().create(socialProfileViewAuditId);
	}

	/**
	* Removes the social profile view audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileViewAuditId the primary key of the social profile view audit
	* @return the social profile view audit that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit remove(
		long socialProfileViewAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence().remove(socialProfileViewAuditId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit socialProfileViewAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(socialProfileViewAudit);
	}

	/**
	* Returns the social profile view audit with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException} if it could not be found.
	*
	* @param socialProfileViewAuditId the primary key of the social profile view audit
	* @return the social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByPrimaryKey(
		long socialProfileViewAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException {
		return getPersistence().findByPrimaryKey(socialProfileViewAuditId);
	}

	/**
	* Returns the social profile view audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfileViewAuditId the primary key of the social profile view audit
	* @return the social profile view audit, or <code>null</code> if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByPrimaryKey(
		long socialProfileViewAuditId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(socialProfileViewAuditId);
	}

	/**
	* Returns all the social profile view audits.
	*
	* @return the social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the social profile view audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile view audits
	* @param end the upper bound of the range of social profile view audits (not inclusive)
	* @return the range of social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the social profile view audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile view audits
	* @param end the upper bound of the range of social profile view audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the social profile view audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of social profile view audits.
	*
	* @return the number of social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SocialProfileViewAuditPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SocialProfileViewAuditPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.getServletContextName(),
					SocialProfileViewAuditPersistence.class.getName());

			ReferenceRegistry.registerReference(SocialProfileViewAuditUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SocialProfileViewAuditPersistence persistence) {
	}

	private static SocialProfileViewAuditPersistence _persistence;
}