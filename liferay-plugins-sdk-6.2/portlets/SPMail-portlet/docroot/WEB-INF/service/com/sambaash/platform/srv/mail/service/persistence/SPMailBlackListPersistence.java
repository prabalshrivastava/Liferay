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

import com.sambaash.platform.srv.mail.model.SPMailBlackList;

/**
 * The persistence interface for the s p mail black list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailBlackListPersistenceImpl
 * @see SPMailBlackListUtil
 * @generated
 */
public interface SPMailBlackListPersistence extends BasePersistence<SPMailBlackList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailBlackListUtil} to access the s p mail black list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @return the range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBounced_First(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBounced_First(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBounced_Last(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBounced_Last(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailBlackListId the primary key of the current s p mail black list
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignIdAndBounced_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @return the range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndComplain_First(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndComplain_First(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndComplain_Last(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndComplain_Last(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailBlackListId the primary key of the current s p mail black list
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignIdAndComplain_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @return the range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBouncedSoft_First(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBouncedSoft_First(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBouncedSoft_Last(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBouncedSoft_Last(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailBlackListId the primary key of the current s p mail black list
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignIdAndBouncedSoft_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black list where emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	*
	* @param emailAddress the email address
	* @return the matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the s p mail black list where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black list where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByEmailAddress(
		java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail black list where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @return the s p mail black list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList removeByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the number of s p mail black lists where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail black lists where spMailCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @return the range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailBlackListId the primary key of the current s p mail black list
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignId_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black list where messageId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	*
	* @param messageId the message ID
	* @return the matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the s p mail black list where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param messageId the message ID
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black list where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param messageId the message ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByMessageId(
		java.lang.String messageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail black list where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @return the s p mail black list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList removeByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the number of s p mail black lists where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByMessageId(java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail black list in the entity cache if it is enabled.
	*
	* @param spMailBlackList the s p mail black list
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList);

	/**
	* Caches the s p mail black lists in the entity cache if it is enabled.
	*
	* @param spMailBlackLists the s p mail black lists
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> spMailBlackLists);

	/**
	* Creates a new s p mail black list with the primary key. Does not add the s p mail black list to the database.
	*
	* @param spMailBlackListId the primary key for the new s p mail black list
	* @return the new s p mail black list
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList create(
		long spMailBlackListId);

	/**
	* Removes the s p mail black list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList remove(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	public com.sambaash.platform.srv.mail.model.SPMailBlackList updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail black list with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList findByPrimaryKey(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException;

	/**
	* Returns the s p mail black list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list, or <code>null</code> if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByPrimaryKey(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail black lists.
	*
	* @return the s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail black lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @return the range of s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail black lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail black lists
	* @param end the upper bound of the range of s p mail black lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail black lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail black lists.
	*
	* @return the number of s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}