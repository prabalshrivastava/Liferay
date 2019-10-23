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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices;

import java.util.List;

/**
 * The persistence utility for the membership subscription addon services service. This utility wraps {@link MembershipSubscriptionAddonServicesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionAddonServicesPersistence
 * @see MembershipSubscriptionAddonServicesPersistenceImpl
 * @generated
 */
public class MembershipSubscriptionAddonServicesUtil {
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
	public static void clearCache(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		getPersistence().clearCache(membershipSubscriptionAddonServices);
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
	public static List<MembershipSubscriptionAddonServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipSubscriptionAddonServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipSubscriptionAddonServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipSubscriptionAddonServices update(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws SystemException {
		return getPersistence().update(membershipSubscriptionAddonServices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipSubscriptionAddonServices update(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(membershipSubscriptionAddonServices, serviceContext);
	}

	/**
	* Returns all the membership subscription addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesScId(scId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesScId(scId, start,
			end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesScId(scId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesScId_Last(scId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesScId_PrevAndNext(
		long msAddonId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesScId_PrevAndNext(msAddonId,
			scId, orderByComparator);
	}

	/**
	* Removes all the membership subscription addon serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionAddonServicesScId(scId);
	}

	/**
	* Returns the number of membership subscription addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionAddonServicesScId(scId);
	}

	/**
	* Returns all the membership subscription addon serviceses where description = &#63;.
	*
	* @param description the description
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesDescription(description);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesDescription(description,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesDescription(description,
			start, end, orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesDescription_First(description,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesDescription_First(description,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesDescription_Last(description,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesDescription_Last(description,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesDescription_PrevAndNext(
		long msAddonId, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesDescription_PrevAndNext(msAddonId,
			description, orderByComparator);
	}

	/**
	* Removes all the membership subscription addon serviceses where description = &#63; from the database.
	*
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscriptionAddonServicesDescription(description);
	}

	/**
	* Returns the number of membership subscription addon serviceses where description = &#63;.
	*
	* @param description the description
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionAddonServicesDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionAddonServicesDescription(description);
	}

	/**
	* Returns all the membership subscription addon serviceses where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesUserId(extra1);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesUserId(extra1,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesUserId(extra1,
			start, end, orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesUserId_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesUserId_First(extra1,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesUserId_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesUserId_First(extra1,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesUserId_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesUserId_Last(extra1,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesUserId_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesUserId_Last(extra1,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesUserId_PrevAndNext(
		long msAddonId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesUserId_PrevAndNext(msAddonId,
			extra1, orderByComparator);
	}

	/**
	* Removes all the membership subscription addon serviceses where extra1 = &#63; from the database.
	*
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscriptionAddonServicesUserId(extra1);
	}

	/**
	* Returns the number of membership subscription addon serviceses where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionAddonServicesUserId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionAddonServicesUserId(extra1);
	}

	/**
	* Returns all the membership subscription addon serviceses where msId = &#63;.
	*
	* @param msId the ms ID
	* @return the matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesMsId(msId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesMsId(msId, start,
			end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesMsId(msId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesMsId_First(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesMsId_First(msId,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesMsId_First(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesMsId_First(msId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesMsId_Last(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesMsId_Last(msId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription addon services in the ordered set where msId = &#63;.
	*
	* @param msId the ms ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesMsId_Last(
		long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionAddonServicesMsId_Last(msId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesMsId_PrevAndNext(
		long msAddonId, long msId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence()
				   .findByMembershipSubscriptionAddonServicesMsId_PrevAndNext(msAddonId,
			msId, orderByComparator);
	}

	/**
	* Removes all the membership subscription addon serviceses where msId = &#63; from the database.
	*
	* @param msId the ms ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionAddonServicesMsId(
		long msId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionAddonServicesMsId(msId);
	}

	/**
	* Returns the number of membership subscription addon serviceses where msId = &#63;.
	*
	* @param msId the ms ID
	* @return the number of matching membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionAddonServicesMsId(long msId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionAddonServicesMsId(msId);
	}

	/**
	* Caches the membership subscription addon services in the entity cache if it is enabled.
	*
	* @param membershipSubscriptionAddonServices the membership subscription addon services
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		getPersistence().cacheResult(membershipSubscriptionAddonServices);
	}

	/**
	* Caches the membership subscription addon serviceses in the entity cache if it is enabled.
	*
	* @param membershipSubscriptionAddonServiceses the membership subscription addon serviceses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> membershipSubscriptionAddonServiceses) {
		getPersistence().cacheResult(membershipSubscriptionAddonServiceses);
	}

	/**
	* Creates a new membership subscription addon services with the primary key. Does not add the membership subscription addon services to the database.
	*
	* @param msAddonId the primary key for the new membership subscription addon services
	* @return the new membership subscription addon services
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices create(
		long msAddonId) {
		return getPersistence().create(msAddonId);
	}

	/**
	* Removes the membership subscription addon services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices remove(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence().remove(msAddonId);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipSubscriptionAddonServices);
	}

	/**
	* Returns the membership subscription addon services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException} if it could not be found.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices findByPrimaryKey(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException {
		return getPersistence().findByPrimaryKey(msAddonId);
	}

	/**
	* Returns the membership subscription addon services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param msAddonId the primary key of the membership subscription addon services
	* @return the membership subscription addon services, or <code>null</code> if a membership subscription addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices fetchByPrimaryKey(
		long msAddonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(msAddonId);
	}

	/**
	* Returns all the membership subscription addon serviceses.
	*
	* @return the membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership subscription addon serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership subscription addon serviceses.
	*
	* @return the number of membership subscription addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipSubscriptionAddonServicesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipSubscriptionAddonServicesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipSubscriptionAddonServicesPersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipSubscriptionAddonServicesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MembershipSubscriptionAddonServicesPersistence persistence) {
	}

	private static MembershipSubscriptionAddonServicesPersistence _persistence;
}