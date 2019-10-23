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

import com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices;

import java.util.List;

/**
 * The persistence utility for the membership subscribed services service. This utility wraps {@link MembershipSubscribedServicesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServicesPersistence
 * @see MembershipSubscribedServicesPersistenceImpl
 * @generated
 */
public class MembershipSubscribedServicesUtil {
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
		MembershipSubscribedServices membershipSubscribedServices) {
		getPersistence().clearCache(membershipSubscribedServices);
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
	public static List<MembershipSubscribedServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipSubscribedServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipSubscribedServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipSubscribedServices update(
		MembershipSubscribedServices membershipSubscribedServices)
		throws SystemException {
		return getPersistence().update(membershipSubscribedServices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipSubscribedServices update(
		MembershipSubscribedServices membershipSubscribedServices,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(membershipSubscribedServices, serviceContext);
	}

	/**
	* Returns all the membership subscribed serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipSubscribedServicesScId(scId);
	}

	/**
	* Returns a range of all the membership subscribed serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @return the range of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScId(scId, start, end);
	}

	/**
	* Returns an ordered range of all the membership subscribed serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScId(scId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscribedServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscribedServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the membership subscribed serviceses before and after the current membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param mssId the primary key of the current membership subscribed services
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices[] findByMembershipSubscribedServicesScId_PrevAndNext(
		long mssId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScId_PrevAndNext(mssId,
			scId, orderByComparator);
	}

	/**
	* Removes all the membership subscribed serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscribedServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscribedServicesScId(scId);
	}

	/**
	* Returns the number of membership subscribed serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscribedServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipSubscribedServicesScId(scId);
	}

	/**
	* Returns all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @return the matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy);
	}

	/**
	* Returns a range of all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @return the range of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy, start, end);
	}

	/**
	* Returns an ordered range of all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy, start, end, orderByComparator);
	}

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScIdAndCreatedBy_First(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScIdAndCreatedBy_First(scId,
			createdBy, orderByComparator);
	}

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScIdAndCreatedBy_First(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscribedServicesScIdAndCreatedBy_First(scId,
			createdBy, orderByComparator);
	}

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScIdAndCreatedBy_Last(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScIdAndCreatedBy_Last(scId,
			createdBy, orderByComparator);
	}

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScIdAndCreatedBy_Last(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscribedServicesScIdAndCreatedBy_Last(scId,
			createdBy, orderByComparator);
	}

	/**
	* Returns the membership subscribed serviceses before and after the current membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param mssId the primary key of the current membership subscribed services
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices[] findByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(
		long mssId, java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence()
				   .findByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(mssId,
			scId, createdBy, orderByComparator);
	}

	/**
	* Removes all the membership subscribed serviceses where scId = &#63; and createdBy = &#63; from the database.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy);
	}

	/**
	* Returns the number of membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @return the number of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy);
	}

	/**
	* Caches the membership subscribed services in the entity cache if it is enabled.
	*
	* @param membershipSubscribedServices the membership subscribed services
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices) {
		getPersistence().cacheResult(membershipSubscribedServices);
	}

	/**
	* Caches the membership subscribed serviceses in the entity cache if it is enabled.
	*
	* @param membershipSubscribedServiceses the membership subscribed serviceses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> membershipSubscribedServiceses) {
		getPersistence().cacheResult(membershipSubscribedServiceses);
	}

	/**
	* Creates a new membership subscribed services with the primary key. Does not add the membership subscribed services to the database.
	*
	* @param mssId the primary key for the new membership subscribed services
	* @return the new membership subscribed services
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices create(
		long mssId) {
		return getPersistence().create(mssId);
	}

	/**
	* Removes the membership subscribed services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices remove(
		long mssId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence().remove(mssId);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipSubscribedServices);
	}

	/**
	* Returns the membership subscribed services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException} if it could not be found.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByPrimaryKey(
		long mssId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException {
		return getPersistence().findByPrimaryKey(mssId);
	}

	/**
	* Returns the membership subscribed services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services, or <code>null</code> if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByPrimaryKey(
		long mssId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mssId);
	}

	/**
	* Returns all the membership subscribed serviceses.
	*
	* @return the membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the membership subscribed serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @return the range of membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the membership subscribed serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscribed serviceses
	* @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership subscribed serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership subscribed serviceses.
	*
	* @return the number of membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipSubscribedServicesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipSubscribedServicesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipSubscribedServicesPersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipSubscribedServicesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MembershipSubscribedServicesPersistence persistence) {
	}

	private static MembershipSubscribedServicesPersistence _persistence;
}