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

import com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices;

import java.util.List;

/**
 * The persistence utility for the membership package addon services service. This utility wraps {@link MembershipPackageAddonServicesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageAddonServicesPersistence
 * @see MembershipPackageAddonServicesPersistenceImpl
 * @generated
 */
public class MembershipPackageAddonServicesUtil {
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
		MembershipPackageAddonServices membershipPackageAddonServices) {
		getPersistence().clearCache(membershipPackageAddonServices);
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
	public static List<MembershipPackageAddonServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipPackageAddonServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipPackageAddonServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipPackageAddonServices update(
		MembershipPackageAddonServices membershipPackageAddonServices)
		throws SystemException {
		return getPersistence().update(membershipPackageAddonServices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipPackageAddonServices update(
		MembershipPackageAddonServices membershipPackageAddonServices,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(membershipPackageAddonServices, serviceContext);
	}

	/**
	* Returns all the membership package addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipPackageAddonServicesScId(scId);
	}

	/**
	* Returns a range of all the membership package addon serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @return the range of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageAddonServicesScId(scId, start, end);
	}

	/**
	* Returns an ordered range of all the membership package addon serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageAddonServicesScId(scId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByMembershipPackageAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence()
				   .findByMembershipPackageAddonServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the first membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByMembershipPackageAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageAddonServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByMembershipPackageAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence()
				   .findByMembershipPackageAddonServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByMembershipPackageAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageAddonServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the membership package addon serviceses before and after the current membership package addon services in the ordered set where scId = &#63;.
	*
	* @param mpAddonId the primary key of the current membership package addon services
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices[] findByMembershipPackageAddonServicesScId_PrevAndNext(
		long mpAddonId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence()
				   .findByMembershipPackageAddonServicesScId_PrevAndNext(mpAddonId,
			scId, orderByComparator);
	}

	/**
	* Removes all the membership package addon serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipPackageAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipPackageAddonServicesScId(scId);
	}

	/**
	* Returns the number of membership package addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipPackageAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipPackageAddonServicesScId(scId);
	}

	/**
	* Returns all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @return the matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceNameMpId(extra1, scName);
	}

	/**
	* Returns a range of all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @return the range of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceNameMpId(extra1, scName, start, end);
	}

	/**
	* Returns an ordered range of all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceNameMpId(extra1, scName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByServiceNameMpId_First(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence()
				   .findByServiceNameMpId_First(extra1, scName,
			orderByComparator);
	}

	/**
	* Returns the first membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByServiceNameMpId_First(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceNameMpId_First(extra1, scName,
			orderByComparator);
	}

	/**
	* Returns the last membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByServiceNameMpId_Last(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence()
				   .findByServiceNameMpId_Last(extra1, scName, orderByComparator);
	}

	/**
	* Returns the last membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByServiceNameMpId_Last(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceNameMpId_Last(extra1, scName,
			orderByComparator);
	}

	/**
	* Returns the membership package addon serviceses before and after the current membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param mpAddonId the primary key of the current membership package addon services
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices[] findByServiceNameMpId_PrevAndNext(
		long mpAddonId, java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence()
				   .findByServiceNameMpId_PrevAndNext(mpAddonId, extra1,
			scName, orderByComparator);
	}

	/**
	* Removes all the membership package addon serviceses where extra1 = &#63; and scName = &#63; from the database.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceNameMpId(java.lang.String extra1,
		java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceNameMpId(extra1, scName);
	}

	/**
	* Returns the number of membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @return the number of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceNameMpId(java.lang.String extra1,
		java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceNameMpId(extra1, scName);
	}

	/**
	* Caches the membership package addon services in the entity cache if it is enabled.
	*
	* @param membershipPackageAddonServices the membership package addon services
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices) {
		getPersistence().cacheResult(membershipPackageAddonServices);
	}

	/**
	* Caches the membership package addon serviceses in the entity cache if it is enabled.
	*
	* @param membershipPackageAddonServiceses the membership package addon serviceses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> membershipPackageAddonServiceses) {
		getPersistence().cacheResult(membershipPackageAddonServiceses);
	}

	/**
	* Creates a new membership package addon services with the primary key. Does not add the membership package addon services to the database.
	*
	* @param mpAddonId the primary key for the new membership package addon services
	* @return the new membership package addon services
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices create(
		long mpAddonId) {
		return getPersistence().create(mpAddonId);
	}

	/**
	* Removes the membership package addon services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices remove(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence().remove(mpAddonId);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipPackageAddonServices);
	}

	/**
	* Returns the membership package addon services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException} if it could not be found.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByPrimaryKey(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException {
		return getPersistence().findByPrimaryKey(mpAddonId);
	}

	/**
	* Returns the membership package addon services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services, or <code>null</code> if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByPrimaryKey(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mpAddonId);
	}

	/**
	* Returns all the membership package addon serviceses.
	*
	* @return the membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the membership package addon serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @return the range of membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the membership package addon serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package addon serviceses
	* @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership package addon serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership package addon serviceses.
	*
	* @return the number of membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipPackageAddonServicesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipPackageAddonServicesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipPackageAddonServicesPersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipPackageAddonServicesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MembershipPackageAddonServicesPersistence persistence) {
	}

	private static MembershipPackageAddonServicesPersistence _persistence;
}