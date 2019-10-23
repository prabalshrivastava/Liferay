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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.mail.model.SPMailCampaign;

import java.util.List;

/**
 * The persistence utility for the s p mail campaign service. This utility wraps {@link SPMailCampaignPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignPersistence
 * @see SPMailCampaignPersistenceImpl
 * @generated
 */
public class SPMailCampaignUtil {
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
	public static void clearCache(SPMailCampaign spMailCampaign) {
		getPersistence().clearCache(spMailCampaign);
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
	public static List<SPMailCampaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailCampaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailCampaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailCampaign update(SPMailCampaign spMailCampaign)
		throws SystemException {
		return getPersistence().update(spMailCampaign);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailCampaign update(SPMailCampaign spMailCampaign,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spMailCampaign, serviceContext);
	}

	/**
	* Returns all the s p mail campaigns where archive = &#63;.
	*
	* @param archive the archive
	* @return the matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findByArchive(
		boolean archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArchive(archive);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findByArchive(
		boolean archive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArchive(archive, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findByArchive(
		boolean archive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArchive(archive, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByArchive_First(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().findByArchive_First(archive, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByArchive_First(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArchive_First(archive, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByArchive_Last(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().findByArchive_Last(archive, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByArchive_Last(
		boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArchive_Last(archive, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign[] findByArchive_PrevAndNext(
		long spMailCampaignId, boolean archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence()
				   .findByArchive_PrevAndNext(spMailCampaignId, archive,
			orderByComparator);
	}

	/**
	* Removes all the s p mail campaigns where archive = &#63; from the database.
	*
	* @param archive the archive
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArchive(boolean archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArchive(archive);
	}

	/**
	* Returns the number of s p mail campaigns where archive = &#63;.
	*
	* @param archive the archive
	* @return the number of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArchive(boolean archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArchive(archive);
	}

	/**
	* Returns the s p mail campaign where campaignName = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	*
	* @param campaignName the campaign name
	* @return the matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().findByCampaignName(campaignName);
	}

	/**
	* Returns the s p mail campaign where campaignName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignName the campaign name
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCampaignName(campaignName);
	}

	/**
	* Returns the s p mail campaign where campaignName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignName the campaign name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByCampaignName(
		java.lang.String campaignName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignName(campaignName, retrieveFromCache);
	}

	/**
	* Removes the s p mail campaign where campaignName = &#63; from the database.
	*
	* @param campaignName the campaign name
	* @return the s p mail campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign removeByCampaignName(
		java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().removeByCampaignName(campaignName);
	}

	/**
	* Returns the number of s p mail campaigns where campaignName = &#63;.
	*
	* @param campaignName the campaign name
	* @return the number of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignName(java.lang.String campaignName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignName(campaignName);
	}

	/**
	* Returns the s p mail campaign where rsvpId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	*
	* @param rsvpId the rsvp ID
	* @return the matching s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByrsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().findByrsvpId(rsvpId);
	}

	/**
	* Returns the s p mail campaign where rsvpId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rsvpId the rsvp ID
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByrsvpId(rsvpId);
	}

	/**
	* Returns the s p mail campaign where rsvpId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rsvpId the rsvp ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByrsvpId(
		long rsvpId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByrsvpId(rsvpId, retrieveFromCache);
	}

	/**
	* Removes the s p mail campaign where rsvpId = &#63; from the database.
	*
	* @param rsvpId the rsvp ID
	* @return the s p mail campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign removeByrsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().removeByrsvpId(rsvpId);
	}

	/**
	* Returns the number of s p mail campaigns where rsvpId = &#63;.
	*
	* @param rsvpId the rsvp ID
	* @return the number of matching s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrsvpId(long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrsvpId(rsvpId);
	}

	/**
	* Caches the s p mail campaign in the entity cache if it is enabled.
	*
	* @param spMailCampaign the s p mail campaign
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign) {
		getPersistence().cacheResult(spMailCampaign);
	}

	/**
	* Caches the s p mail campaigns in the entity cache if it is enabled.
	*
	* @param spMailCampaigns the s p mail campaigns
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> spMailCampaigns) {
		getPersistence().cacheResult(spMailCampaigns);
	}

	/**
	* Creates a new s p mail campaign with the primary key. Does not add the s p mail campaign to the database.
	*
	* @param spMailCampaignId the primary key for the new s p mail campaign
	* @return the new s p mail campaign
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign create(
		long spMailCampaignId) {
		return getPersistence().create(spMailCampaignId);
	}

	/**
	* Removes the s p mail campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign remove(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().remove(spMailCampaignId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaign updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailCampaign);
	}

	/**
	* Returns the s p mail campaign with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign findByPrimaryKey(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignException {
		return getPersistence().findByPrimaryKey(spMailCampaignId);
	}

	/**
	* Returns the s p mail campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailCampaignId the primary key of the s p mail campaign
	* @return the s p mail campaign, or <code>null</code> if a s p mail campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaign fetchByPrimaryKey(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMailCampaignId);
	}

	/**
	* Returns all the s p mail campaigns.
	*
	* @return the s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail campaigns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail campaigns.
	*
	* @return the number of s p mail campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailCampaignPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailCampaignPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailCampaignPersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailCampaignUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailCampaignPersistence persistence) {
	}

	private static SPMailCampaignPersistence _persistence;
}