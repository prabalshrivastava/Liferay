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

import com.sambaash.platform.srv.mail.model.SPMailBlackList;

import java.util.List;

/**
 * The persistence utility for the s p mail black list service. This utility wraps {@link SPMailBlackListPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailBlackListPersistence
 * @see SPMailBlackListPersistenceImpl
 * @generated
 */
public class SPMailBlackListUtil {
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
	public static void clearCache(SPMailBlackList spMailBlackList) {
		getPersistence().clearCache(spMailBlackList);
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
	public static List<SPMailBlackList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailBlackList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailBlackList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailBlackList update(SPMailBlackList spMailBlackList)
		throws SystemException {
		return getPersistence().update(spMailBlackList);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailBlackList update(SPMailBlackList spMailBlackList,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spMailBlackList, serviceContext);
	}

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndBounced(spMailCampaignId, bounced,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndBounced(spMailCampaignId, bounced,
			start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBounced_First(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndBounced_First(spMailCampaignId, bounced,
			orderByComparator);
	}

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBounced_First(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndBounced_First(spMailCampaignId,
			bounced, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBounced_Last(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndBounced_Last(spMailCampaignId, bounced,
			orderByComparator);
	}

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBounced_Last(
		long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndBounced_Last(spMailCampaignId, bounced,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignIdAndBounced_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean bounced,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndBounced_PrevAndNext(spMailBlackListId,
			spMailCampaignId, bounced, orderByComparator);
	}

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounced the bounced
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndBounced(spMailCampaignId, bounced);
	}

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndComplain(spMailCampaignId, complain);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndComplain(spMailCampaignId, complain,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndComplain(spMailCampaignId, complain,
			start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndComplain_First(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndComplain_First(spMailCampaignId,
			complain, orderByComparator);
	}

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndComplain_First(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndComplain_First(spMailCampaignId,
			complain, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndComplain_Last(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndComplain_Last(spMailCampaignId,
			complain, orderByComparator);
	}

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndComplain_Last(
		long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndComplain_Last(spMailCampaignId,
			complain, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignIdAndComplain_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean complain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndComplain_PrevAndNext(spMailBlackListId,
			spMailCampaignId, complain, orderByComparator);
	}

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndComplain(spMailCampaignId, complain);
	}

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param complain the complain
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndComplain(spMailCampaignId, complain);
	}

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndBouncedSoft(spMailCampaignId,
			bounce_soft, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndBouncedSoft(spMailCampaignId,
			bounce_soft, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBouncedSoft_First(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndBouncedSoft_First(spMailCampaignId,
			bounce_soft, orderByComparator);
	}

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBouncedSoft_First(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndBouncedSoft_First(spMailCampaignId,
			bounce_soft, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignIdAndBouncedSoft_Last(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndBouncedSoft_Last(spMailCampaignId,
			bounce_soft, orderByComparator);
	}

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignIdAndBouncedSoft_Last(
		long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndBouncedSoft_Last(spMailCampaignId,
			bounce_soft, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignIdAndBouncedSoft_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean bounce_soft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignIdAndBouncedSoft_PrevAndNext(spMailBlackListId,
			spMailCampaignId, bounce_soft, orderByComparator);
	}

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft);
	}

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param bounce_soft the bounce_soft
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndBouncedSoft(spMailCampaignId,
			bounce_soft);
	}

	/**
	* Returns the s p mail black list where emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	*
	* @param emailAddress the email address
	* @return the matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	* Returns the s p mail black list where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailAddress(emailAddress);
	}

	/**
	* Returns the s p mail black list where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByEmailAddress(
		java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress(emailAddress, retrieveFromCache);
	}

	/**
	* Removes the s p mail black list where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @return the s p mail black list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList removeByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	* Returns the number of s p mail black lists where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	* Returns all the s p mail black lists where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(spMailCampaignId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(spMailCampaignId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findByCampaignId(
		long spMailCampaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(spMailCampaignId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignId_First(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignId_Last(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_Last(spMailCampaignId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList[] findByCampaignId_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(spMailBlackListId,
			spMailCampaignId, orderByComparator);
	}

	/**
	* Removes all the s p mail black lists where spMailCampaignId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(spMailCampaignId);
	}

	/**
	* Returns the number of s p mail black lists where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(spMailCampaignId);
	}

	/**
	* Returns the s p mail black list where messageId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	*
	* @param messageId the message ID
	* @return the matching s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence().findByMessageId(messageId);
	}

	/**
	* Returns the s p mail black list where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param messageId the message ID
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMessageId(messageId);
	}

	/**
	* Returns the s p mail black list where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param messageId the message ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByMessageId(
		java.lang.String messageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMessageId(messageId, retrieveFromCache);
	}

	/**
	* Removes the s p mail black list where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @return the s p mail black list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList removeByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence().removeByMessageId(messageId);
	}

	/**
	* Returns the number of s p mail black lists where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessageId(java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessageId(messageId);
	}

	/**
	* Caches the s p mail black list in the entity cache if it is enabled.
	*
	* @param spMailBlackList the s p mail black list
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList) {
		getPersistence().cacheResult(spMailBlackList);
	}

	/**
	* Caches the s p mail black lists in the entity cache if it is enabled.
	*
	* @param spMailBlackLists the s p mail black lists
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> spMailBlackLists) {
		getPersistence().cacheResult(spMailBlackLists);
	}

	/**
	* Creates a new s p mail black list with the primary key. Does not add the s p mail black list to the database.
	*
	* @param spMailBlackListId the primary key for the new s p mail black list
	* @return the new s p mail black list
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList create(
		long spMailBlackListId) {
		return getPersistence().create(spMailBlackListId);
	}

	/**
	* Removes the s p mail black list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList remove(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence().remove(spMailBlackListId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailBlackList updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailBlackList);
	}

	/**
	* Returns the s p mail black list with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list
	* @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList findByPrimaryKey(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchBlackListException {
		return getPersistence().findByPrimaryKey(spMailBlackListId);
	}

	/**
	* Returns the s p mail black list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailBlackListId the primary key of the s p mail black list
	* @return the s p mail black list, or <code>null</code> if a s p mail black list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailBlackList fetchByPrimaryKey(
		long spMailBlackListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMailBlackListId);
	}

	/**
	* Returns all the s p mail black lists.
	*
	* @return the s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailBlackList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail black lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail black lists.
	*
	* @return the number of s p mail black lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailBlackListPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailBlackListPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailBlackListPersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailBlackListUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailBlackListPersistence persistence) {
	}

	private static SPMailBlackListPersistence _persistence;
}