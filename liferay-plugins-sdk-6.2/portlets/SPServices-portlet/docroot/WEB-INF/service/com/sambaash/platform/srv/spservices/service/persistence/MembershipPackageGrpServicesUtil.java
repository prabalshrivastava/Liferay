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

import com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices;

import java.util.List;

/**
 * The persistence utility for the membership package grp services service. This utility wraps {@link MembershipPackageGrpServicesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageGrpServicesPersistence
 * @see MembershipPackageGrpServicesPersistenceImpl
 * @generated
 */
public class MembershipPackageGrpServicesUtil {
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
		MembershipPackageGrpServices membershipPackageGrpServices) {
		getPersistence().clearCache(membershipPackageGrpServices);
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
	public static List<MembershipPackageGrpServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipPackageGrpServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipPackageGrpServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipPackageGrpServices update(
		MembershipPackageGrpServices membershipPackageGrpServices)
		throws SystemException {
		return getPersistence().update(membershipPackageGrpServices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipPackageGrpServices update(
		MembershipPackageGrpServices membershipPackageGrpServices,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(membershipPackageGrpServices, serviceContext);
	}

	/**
	* Returns all the membership package grp serviceses where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @return the matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipPackageGrpServicesScgId(scgId);
	}

	/**
	* Returns a range of all the membership package grp serviceses where scgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scgId the scg ID
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScgId(scgId, start, end);
	}

	/**
	* Returns an ordered range of all the membership package grp serviceses where scgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scgId the scg ID
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScgId(scgId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByMembershipPackageGrpServicesScgId_First(
		java.lang.String scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScgId_First(scgId,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScgId_First(
		java.lang.String scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageGrpServicesScgId_First(scgId,
			orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByMembershipPackageGrpServicesScgId_Last(
		java.lang.String scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScgId_Last(scgId,
			orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScgId_Last(
		java.lang.String scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageGrpServicesScgId_Last(scgId,
			orderByComparator);
	}

	/**
	* Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where scgId = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package grp services
	* @param scgId the scg ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices[] findByMembershipPackageGrpServicesScgId_PrevAndNext(
		long mpgsscId, java.lang.String scgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScgId_PrevAndNext(mpgsscId,
			scgId, orderByComparator);
	}

	/**
	* Removes all the membership package grp serviceses where scgId = &#63; from the database.
	*
	* @param scgId the scg ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipPackageGrpServicesScgId(
		java.lang.String scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipPackageGrpServicesScgId(scgId);
	}

	/**
	* Returns the number of membership package grp serviceses where scgId = &#63;.
	*
	* @param scgId the scg ID
	* @return the number of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipPackageGrpServicesScgId(
		java.lang.String scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipPackageGrpServicesScgId(scgId);
	}

	/**
	* Returns all the membership package grp serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipPackageGrpServicesScId(scId);
	}

	/**
	* Returns a range of all the membership package grp serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScId(scId, start, end);
	}

	/**
	* Returns an ordered range of all the membership package grp serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScId(scId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByMembershipPackageGrpServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageGrpServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByMembershipPackageGrpServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageGrpServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where scId = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package grp services
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices[] findByMembershipPackageGrpServicesScId_PrevAndNext(
		long mpgsscId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesScId_PrevAndNext(mpgsscId,
			scId, orderByComparator);
	}

	/**
	* Removes all the membership package grp serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipPackageGrpServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipPackageGrpServicesScId(scId);
	}

	/**
	* Returns the number of membership package grp serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipPackageGrpServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipPackageGrpServicesScId(scId);
	}

	/**
	* Returns all the membership package grp serviceses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipPackageGrpServicesMpId(mpId);
	}

	/**
	* Returns a range of all the membership package grp serviceses where mpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesMpId(mpId, start, end);
	}

	/**
	* Returns an ordered range of all the membership package grp serviceses where mpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesMpId(mpId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByMembershipPackageGrpServicesMpId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesMpId_First(mpId,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByMembershipPackageGrpServicesMpId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageGrpServicesMpId_First(mpId,
			orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByMembershipPackageGrpServicesMpId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesMpId_Last(mpId,
			orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByMembershipPackageGrpServicesMpId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageGrpServicesMpId_Last(mpId,
			orderByComparator);
	}

	/**
	* Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where mpId = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package grp services
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices[] findByMembershipPackageGrpServicesMpId_PrevAndNext(
		long mpgsscId, long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByMembershipPackageGrpServicesMpId_PrevAndNext(mpgsscId,
			mpId, orderByComparator);
	}

	/**
	* Removes all the membership package grp serviceses where mpId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipPackageGrpServicesMpId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipPackageGrpServicesMpId(mpId);
	}

	/**
	* Returns the number of membership package grp serviceses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the number of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipPackageGrpServicesMpId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipPackageGrpServicesMpId(mpId);
	}

	/**
	* Returns all the membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @return the matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByServiceNameMpId(
		long mpId, java.lang.String extra2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceNameMpId(mpId, extra2);
	}

	/**
	* Returns a range of all the membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByServiceNameMpId(
		long mpId, java.lang.String extra2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceNameMpId(mpId, extra2, start, end);
	}

	/**
	* Returns an ordered range of all the membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByServiceNameMpId(
		long mpId, java.lang.String extra2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceNameMpId(mpId, extra2, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByServiceNameMpId_First(
		long mpId, java.lang.String extra2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByServiceNameMpId_First(mpId, extra2, orderByComparator);
	}

	/**
	* Returns the first membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByServiceNameMpId_First(
		long mpId, java.lang.String extra2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceNameMpId_First(mpId, extra2, orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByServiceNameMpId_Last(
		long mpId, java.lang.String extra2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByServiceNameMpId_Last(mpId, extra2, orderByComparator);
	}

	/**
	* Returns the last membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByServiceNameMpId_Last(
		long mpId, java.lang.String extra2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceNameMpId_Last(mpId, extra2, orderByComparator);
	}

	/**
	* Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package grp services
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices[] findByServiceNameMpId_PrevAndNext(
		long mpgsscId, long mpId, java.lang.String extra2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence()
				   .findByServiceNameMpId_PrevAndNext(mpgsscId, mpId, extra2,
			orderByComparator);
	}

	/**
	* Removes all the membership package grp serviceses where mpId = &#63; and extra2 = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceNameMpId(long mpId,
		java.lang.String extra2)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceNameMpId(mpId, extra2);
	}

	/**
	* Returns the number of membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra2 the extra2
	* @return the number of matching membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceNameMpId(long mpId, java.lang.String extra2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceNameMpId(mpId, extra2);
	}

	/**
	* Caches the membership package grp services in the entity cache if it is enabled.
	*
	* @param membershipPackageGrpServices the membership package grp services
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices) {
		getPersistence().cacheResult(membershipPackageGrpServices);
	}

	/**
	* Caches the membership package grp serviceses in the entity cache if it is enabled.
	*
	* @param membershipPackageGrpServiceses the membership package grp serviceses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> membershipPackageGrpServiceses) {
		getPersistence().cacheResult(membershipPackageGrpServiceses);
	}

	/**
	* Creates a new membership package grp services with the primary key. Does not add the membership package grp services to the database.
	*
	* @param mpgsscId the primary key for the new membership package grp services
	* @return the new membership package grp services
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices create(
		long mpgsscId) {
		return getPersistence().create(mpgsscId);
	}

	/**
	* Removes the membership package grp services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices remove(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence().remove(mpgsscId);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipPackageGrpServices);
	}

	/**
	* Returns the membership package grp services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException} if it could not be found.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices findByPrimaryKey(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException {
		return getPersistence().findByPrimaryKey(mpgsscId);
	}

	/**
	* Returns the membership package grp services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services, or <code>null</code> if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchByPrimaryKey(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mpgsscId);
	}

	/**
	* Returns all the membership package grp serviceses.
	*
	* @return the membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the membership package grp serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the membership package grp serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership package grp serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership package grp serviceses.
	*
	* @return the number of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipPackageGrpServicesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipPackageGrpServicesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipPackageGrpServicesPersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipPackageGrpServicesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MembershipPackageGrpServicesPersistence persistence) {
	}

	private static MembershipPackageGrpServicesPersistence _persistence;
}