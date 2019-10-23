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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit;

/**
 * The persistence interface for the social profile pull audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePullAuditPersistenceImpl
 * @see SocialProfilePullAuditUtil
 * @generated
 */
public interface SocialProfilePullAuditPersistence extends BasePersistence<SocialProfilePullAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfilePullAuditUtil} to access the social profile pull audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException} if it could not be found.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the matching social profile pull audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a matching social profile pull audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit findByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException;

	/**
	* Returns the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the matching social profile pull audit, or <code>null</code> if a matching social profile pull audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit fetchByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param socialNetworkProfileId the social network profile ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile pull audit, or <code>null</code> if a matching social profile pull audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit fetchByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the social profile pull audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit removeByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException;

	/**
	* Returns the number of social profile pull audits where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the number of matching social profile pull audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndSocialNetworkProfileId(long companyId,
		long userId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the social profile pull audit in the entity cache if it is enabled.
	*
	* @param socialProfilePullAudit the social profile pull audit
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit socialProfilePullAudit);

	/**
	* Caches the social profile pull audits in the entity cache if it is enabled.
	*
	* @param socialProfilePullAudits the social profile pull audits
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit> socialProfilePullAudits);

	/**
	* Creates a new social profile pull audit with the primary key. Does not add the social profile pull audit to the database.
	*
	* @param socialProfilePullAuditPK the primary key for the new social profile pull audit
	* @return the new social profile pull audit
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit create(
		SocialProfilePullAuditPK socialProfilePullAuditPK);

	/**
	* Removes the social profile pull audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfilePullAuditPK the primary key of the social profile pull audit
	* @return the social profile pull audit that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a social profile pull audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit remove(
		SocialProfilePullAuditPK socialProfilePullAuditPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit socialProfilePullAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile pull audit with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException} if it could not be found.
	*
	* @param socialProfilePullAuditPK the primary key of the social profile pull audit
	* @return the social profile pull audit
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a social profile pull audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit findByPrimaryKey(
		SocialProfilePullAuditPK socialProfilePullAuditPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException;

	/**
	* Returns the social profile pull audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfilePullAuditPK the primary key of the social profile pull audit
	* @return the social profile pull audit, or <code>null</code> if a social profile pull audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit fetchByPrimaryKey(
		SocialProfilePullAuditPK socialProfilePullAuditPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile pull audits.
	*
	* @return the social profile pull audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile pull audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile pull audits
	* @param end the upper bound of the range of social profile pull audits (not inclusive)
	* @return the range of social profile pull audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile pull audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile pull audits
	* @param end the upper bound of the range of social profile pull audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social profile pull audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social profile pull audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile pull audits.
	*
	* @return the number of social profile pull audits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}