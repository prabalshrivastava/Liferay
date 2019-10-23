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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit;

/**
 * The persistence interface for the social profile view audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileViewAuditPersistenceImpl
 * @see SocialProfileViewAuditUtil
 * @generated
 */
public interface SocialProfileViewAuditPersistence extends BasePersistence<SocialProfileViewAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfileViewAuditUtil} to access the social profile view audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the social profile view audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	/**
	* Returns the first social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	/**
	* Returns the last social profile view audit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit[] findByUuid_PrevAndNext(
		long socialProfileViewAuditId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	/**
	* Removes all the social profile view audits where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile view audits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException} if it could not be found.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the matching social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	/**
	* Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; from the database.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the social profile view audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit removeByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	/**
	* Returns the number of social profile view audits where loggedInUserId = &#63; and profileUserId = &#63;.
	*
	* @param loggedInUserId the logged in user ID
	* @param profileUserId the profile user ID
	* @return the number of matching social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByLoggedInUserIdAndProfileUserId(long loggedInUserId,
		long profileUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the social profile view audit in the entity cache if it is enabled.
	*
	* @param socialProfileViewAudit the social profile view audit
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit socialProfileViewAudit);

	/**
	* Caches the social profile view audits in the entity cache if it is enabled.
	*
	* @param socialProfileViewAudits the social profile view audits
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> socialProfileViewAudits);

	/**
	* Creates a new social profile view audit with the primary key. Does not add the social profile view audit to the database.
	*
	* @param socialProfileViewAuditId the primary key for the new social profile view audit
	* @return the new social profile view audit
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit create(
		long socialProfileViewAuditId);

	/**
	* Removes the social profile view audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileViewAuditId the primary key of the social profile view audit
	* @return the social profile view audit that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit remove(
		long socialProfileViewAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit socialProfileViewAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile view audit with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException} if it could not be found.
	*
	* @param socialProfileViewAuditId the primary key of the social profile view audit
	* @return the social profile view audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit findByPrimaryKey(
		long socialProfileViewAuditId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;

	/**
	* Returns the social profile view audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfileViewAuditId the primary key of the social profile view audit
	* @return the social profile view audit, or <code>null</code> if a social profile view audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit fetchByPrimaryKey(
		long socialProfileViewAuditId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile view audits.
	*
	* @return the social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social profile view audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile view audits.
	*
	* @return the number of social profile view audits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}