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

import com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent;

/**
 * The persistence interface for the s p mail subscriber user agent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailSubscriberUserAgentPersistenceImpl
 * @see SPMailSubscriberUserAgentUtil
 * @generated
 */
public interface SPMailSubscriberUserAgentPersistence extends BasePersistence<SPMailSubscriberUserAgent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailSubscriberUserAgentUtil} to access the s p mail subscriber user agent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException} if it could not be found.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the matching s p mail subscriber user agent
	* @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a matching s p mail subscriber user agent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;

	/**
	* Returns the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the matching s p mail subscriber user agent, or <code>null</code> if a matching s p mail subscriber user agent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent fetchByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail subscriber user agent, or <code>null</code> if a matching s p mail subscriber user agent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent fetchByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the s p mail subscriber user agent that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent removeByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;

	/**
	* Returns the number of s p mail subscriber user agents where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the number of matching s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail subscriber user agent in the entity cache if it is enabled.
	*
	* @param spMailSubscriberUserAgent the s p mail subscriber user agent
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent);

	/**
	* Caches the s p mail subscriber user agents in the entity cache if it is enabled.
	*
	* @param spMailSubscriberUserAgents the s p mail subscriber user agents
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent> spMailSubscriberUserAgents);

	/**
	* Creates a new s p mail subscriber user agent with the primary key. Does not add the s p mail subscriber user agent to the database.
	*
	* @param spMailSubscriberUserAgentId the primary key for the new s p mail subscriber user agent
	* @return the new s p mail subscriber user agent
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent create(
		long spMailSubscriberUserAgentId);

	/**
	* Removes the s p mail subscriber user agent with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	* @return the s p mail subscriber user agent that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a s p mail subscriber user agent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent remove(
		long spMailSubscriberUserAgentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;

	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail subscriber user agent with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException} if it could not be found.
	*
	* @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	* @return the s p mail subscriber user agent
	* @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a s p mail subscriber user agent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent findByPrimaryKey(
		long spMailSubscriberUserAgentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;

	/**
	* Returns the s p mail subscriber user agent with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	* @return the s p mail subscriber user agent, or <code>null</code> if a s p mail subscriber user agent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent fetchByPrimaryKey(
		long spMailSubscriberUserAgentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail subscriber user agents.
	*
	* @return the s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail subscriber user agents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail subscriber user agents
	* @param end the upper bound of the range of s p mail subscriber user agents (not inclusive)
	* @return the range of s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail subscriber user agents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail subscriber user agents
	* @param end the upper bound of the range of s p mail subscriber user agents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail subscriber user agents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail subscriber user agents.
	*
	* @return the number of s p mail subscriber user agents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}