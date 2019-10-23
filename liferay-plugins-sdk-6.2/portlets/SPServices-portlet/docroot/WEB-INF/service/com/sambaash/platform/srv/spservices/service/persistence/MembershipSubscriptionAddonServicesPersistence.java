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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices;

/**
 * The persistence interface for the membership subscription addon services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionAddonServicesPersistenceImpl
 * @see MembershipSubscriptionAddonServicesUtil
 * @generated
 */
public interface MembershipSubscriptionAddonServicesPersistence
	extends BasePersistence<MembershipSubscriptionAddonServices> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipSubscriptionAddonServicesUtil} to access the membership subscription addon services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership subscription addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscription addon serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @return the range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscription addon serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the first membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the last membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param msAddonId the primary key of the current membership subscription addon services
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesScId_PrevAndNext(
		long msAddonId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Removes all the membership subscription addon serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscription addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscription addon serviceses where description = &#63;.
	*
	* @param description the description
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscription addon serviceses where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @return the range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscription addon serviceses where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the first membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the last membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param msAddonId the primary key of the current membership subscription addon services
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesDescription_PrevAndNext(
		long msAddonId, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Removes all the membership subscription addon serviceses where description = &#63; from the database.
	*
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscription addon serviceses where description = &#63;.
	*
	* @param description the description
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscription addon serviceses where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscription addon serviceses where extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @return the range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscription addon serviceses where extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesUserId_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the first membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesUserId_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesUserId_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the last membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesUserId_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param msAddonId the primary key of the current membership subscription addon services
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesUserId_PrevAndNext(
		long msAddonId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Removes all the membership subscription addon serviceses where extra1 = &#63; from the database.
	*
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscription addon serviceses where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscription addon serviceses where msId = &#63;.
	*
	* @param msId the ms ID
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscription addon serviceses where msId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param msId the ms ID
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @return the range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscription addon serviceses where msId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param msId the ms ID
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesMsId_First(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the first membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesMsId_First(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesMsId_Last(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the last membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesMsId_Last(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msAddonId the primary key of the current membership subscription addon services
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesMsId_PrevAndNext(
		long msAddonId, long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Removes all the membership subscription addon serviceses where msId = &#63; from the database.
	*
	* @param msId the ms ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionAddonServicesMsId(long msId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscription addon serviceses where msId = &#63;.
	*
	* @param msId the ms ID
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionAddonServicesMsId(long msId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership subscription addon services in the entity cache if it is enabled.
	*
	* @param membershipSubscriptionAddonServices the membership subscription addon services
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices);

	/**
	* Caches the membership subscription addon serviceses in the entity cache if it is enabled.
	*
	* @param membershipSubscriptionAddonServiceses the membership subscription addon serviceses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> membershipSubscriptionAddonServiceses);

	/**
	* Creates a new membership subscription addon services with the primary key. Does not add the membership subscription addon services to the database.
	*
	* @param msAddonId the primary key for the new membership subscription addon services
	* @return the new membership subscription addon services
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices create(
		long msAddonId);

	/**
	* Removes the membership subscription addon services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices remove(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscription addon services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException} if it could not be found.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByPrimaryKey(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;

	/**
	* Returns the membership subscription addon services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services, or <code>null</code> if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByPrimaryKey(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscription addon serviceses.
	*
	* @return the membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscription addon serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @return the range of membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscription addon serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscription addon serviceses
	* @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership subscription addon serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscription addon serviceses.
	*
	* @return the number of membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}