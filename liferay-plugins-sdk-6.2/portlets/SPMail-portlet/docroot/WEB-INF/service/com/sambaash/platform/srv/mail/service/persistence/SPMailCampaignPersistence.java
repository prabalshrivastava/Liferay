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

package com.sambaash.platform.srv.mail.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.mail.model.SPMailCampaign;

/**
 * The persistence interface for the s p mail campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignPersistenceImpl
 * @see SPMailCampaignUtil
 * @generated
 */
public interface SPMailCampaignPersistence extends BasePersistence<SPMailCampaign> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailCampaignUtil} to access the s p mail campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p mail campaigns where archive = &#63;.
	*
	* @param archive the archive
	* @return the matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findByArchive(
		boolean archive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail campaigns where archive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archive the archive
	* @param start the lower bound of the range of s p mail campaigns
	* @param end the upper bound of the range of s p mail campaigns (not inclusive)
	* @return the range of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findByArchive(
		boolean archive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail campaigns where archive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archive the archive
	* @param start the lower bound of the range of s p mail campaigns
	* @param end the upper bound of the range of s p mail campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findByArchive(
		boolean archive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByArchive_First(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the first s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByArchive_First(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByArchive_Last(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the last s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByArchive_Last(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaigns before and after the current s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param spMailCampaignId the primary key of the current s p mail campaign
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign[] findByArchive_PrevAndNext(
		long spMailCampaignId, boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Removes all the s p mail campaigns where archive = &#63; from the database.
	*
	* @param archive the archive
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArchive(boolean archive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaigns where archive = &#63;.
	*
	* @param archive the archive
	* @return the number of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int countByArchive(boolean archive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign where campaignName = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	*
	* @param campaignName the campaign name
	* @return the matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the s p mail campaign where campaignName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignName the campaign name
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign where campaignName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignName the campaign name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByCampaignName(
		java.lang.String campaignName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail campaign where campaignName = &#63; from the database.
	*
	* @param campaignName the campaign name
	* @return the s p mail campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign removeByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the number of s p mail campaigns where campaignName = &#63;.
	*
	* @param campaignName the campaign name
	* @return the number of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignName(java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign where rsvpId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	*
	* @param rsvpId the rsvp ID
	* @return the matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByrsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the s p mail campaign where rsvpId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rsvpId the rsvp ID
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign where rsvpId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rsvpId the rsvp ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByrsvpId(
		long rsvpId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail campaign where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @return the s p mail campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign removeByrsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the number of s p mail campaigns where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int countByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail campaign in the entity cache if it is enabled.
	*
	* @param spMailCampaign the s p mail campaign
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign);

	/**
	* Caches the s p mail campaigns in the entity cache if it is enabled.
	*
	* @param spMailCampaigns the s p mail campaigns
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> spMailCampaigns);

	/**
	* Creates a new s p mail campaign with the primary key. Does not add the s p mail campaign to the database.
	*
	* @param spMailCampaignId the primary key for the new s p mail campaign
	* @return the new s p mail campaign
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign create(
		long spMailCampaignId);

	/**
	* Removes the s p mail campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign remove(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	public com.sambaash.platform.srv.mail.model.SPMailCampaign updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign findByPrimaryKey(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException;

	/**
	* Returns the s p mail campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign, or <code>null</code> if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByPrimaryKey(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaigns.
	*
	* @return the s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaigns
	* @param end the upper bound of the range of s p mail campaigns (not inclusive)
	* @return the range of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaigns
	* @param end the upper bound of the range of s p mail campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail campaigns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaigns.
	*
	* @return the number of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}