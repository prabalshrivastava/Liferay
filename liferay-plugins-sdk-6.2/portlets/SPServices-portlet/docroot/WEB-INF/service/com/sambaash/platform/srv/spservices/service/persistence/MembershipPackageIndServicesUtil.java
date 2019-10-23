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

import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices;

import java.util.List;

/**
 * The persistence utility for the membership package ind services service. This utility wraps {@link MembershipPackageIndServicesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageIndServicesPersistence
 * @see MembershipPackageIndServicesPersistenceImpl
 * @generated
 */
public class MembershipPackageIndServicesUtil {
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
		MembershipPackageIndServices membershipPackageIndServices) {
		getPersistence().clearCache(membershipPackageIndServices);
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
	public static List<MembershipPackageIndServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipPackageIndServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipPackageIndServices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipPackageIndServices update(
		MembershipPackageIndServices membershipPackageIndServices)
		throws SystemException {
		return getPersistence().update(membershipPackageIndServices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipPackageIndServices update(
		MembershipPackageIndServices membershipPackageIndServices,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(membershipPackageIndServices, serviceContext);
	}

	/**
	* Returns all the membership package ind serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipPackageIndServicesScId(scId);
	}

	/**
	* Returns a range of all the membership package ind serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @return the range of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageIndServicesScId(scId, start, end);
	}

	/**
	* Returns an ordered range of all the membership package ind serviceses where scId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scId the sc ID
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageIndServicesScId(scId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByMembershipPackageIndServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the first membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageIndServicesScId_First(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByMembershipPackageIndServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the last membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageIndServicesScId_Last(scId,
			orderByComparator);
	}

	/**
	* Returns the membership package ind serviceses before and after the current membership package ind services in the ordered set where scId = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package ind services
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices[] findByMembershipPackageIndServicesScId_PrevAndNext(
		long mpgsscId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByMembershipPackageIndServicesScId_PrevAndNext(mpgsscId,
			scId, orderByComparator);
	}

	/**
	* Removes all the membership package ind serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipPackageIndServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipPackageIndServicesScId(scId);
	}

	/**
	* Returns the number of membership package ind serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipPackageIndServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipPackageIndServicesScId(scId);
	}

	/**
	* Returns all the membership package ind serviceses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipPackageIndServicesMpId(mpId);
	}

	/**
	* Returns a range of all the membership package ind serviceses where mpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @return the range of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageIndServicesMpId(mpId, start, end);
	}

	/**
	* Returns an ordered range of all the membership package ind serviceses where mpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipPackageIndServicesMpId(mpId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesMpId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByMembershipPackageIndServicesMpId_First(mpId,
			orderByComparator);
	}

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesMpId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageIndServicesMpId_First(mpId,
			orderByComparator);
	}

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesMpId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByMembershipPackageIndServicesMpId_Last(mpId,
			orderByComparator);
	}

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesMpId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipPackageIndServicesMpId_Last(mpId,
			orderByComparator);
	}

	/**
	* Returns the membership package ind serviceses before and after the current membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package ind services
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices[] findByMembershipPackageIndServicesMpId_PrevAndNext(
		long mpgsscId, long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByMembershipPackageIndServicesMpId_PrevAndNext(mpgsscId,
			mpId, orderByComparator);
	}

	/**
	* Removes all the membership package ind serviceses where mpId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipPackageIndServicesMpId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipPackageIndServicesMpId(mpId);
	}

	/**
	* Returns the number of membership package ind serviceses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the number of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipPackageIndServicesMpId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipPackageIndServicesMpId(mpId);
	}

	/**
	* Returns all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @return the matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByServiceNameMpId(
		long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceNameMpId(mpId, extra1);
	}

	/**
	* Returns a range of all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @return the range of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByServiceNameMpId(
		long mpId, java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceNameMpId(mpId, extra1, start, end);
	}

	/**
	* Returns an ordered range of all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByServiceNameMpId(
		long mpId, java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceNameMpId(mpId, extra1, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByServiceNameMpId_First(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByServiceNameMpId_First(mpId, extra1, orderByComparator);
	}

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByServiceNameMpId_First(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceNameMpId_First(mpId, extra1, orderByComparator);
	}

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByServiceNameMpId_Last(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByServiceNameMpId_Last(mpId, extra1, orderByComparator);
	}

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByServiceNameMpId_Last(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceNameMpId_Last(mpId, extra1, orderByComparator);
	}

	/**
	* Returns the membership package ind serviceses before and after the current membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpgsscId the primary key of the current membership package ind services
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices[] findByServiceNameMpId_PrevAndNext(
		long mpgsscId, long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence()
				   .findByServiceNameMpId_PrevAndNext(mpgsscId, mpId, extra1,
			orderByComparator);
	}

	/**
	* Removes all the membership package ind serviceses where mpId = &#63; and extra1 = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceNameMpId(long mpId,
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceNameMpId(mpId, extra1);
	}

	/**
	* Returns the number of membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @return the number of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceNameMpId(long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceNameMpId(mpId, extra1);
	}

	/**
	* Caches the membership package ind services in the entity cache if it is enabled.
	*
	* @param membershipPackageIndServices the membership package ind services
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices membershipPackageIndServices) {
		getPersistence().cacheResult(membershipPackageIndServices);
	}

	/**
	* Caches the membership package ind serviceses in the entity cache if it is enabled.
	*
	* @param membershipPackageIndServiceses the membership package ind serviceses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> membershipPackageIndServiceses) {
		getPersistence().cacheResult(membershipPackageIndServiceses);
	}

	/**
	* Creates a new membership package ind services with the primary key. Does not add the membership package ind services to the database.
	*
	* @param mpgsscId the primary key for the new membership package ind services
	* @return the new membership package ind services
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices create(
		long mpgsscId) {
		return getPersistence().create(mpgsscId);
	}

	/**
	* Removes the membership package ind services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsscId the primary key of the membership package ind services
	* @return the membership package ind services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices remove(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence().remove(mpgsscId);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices membershipPackageIndServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipPackageIndServices);
	}

	/**
	* Returns the membership package ind services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException} if it could not be found.
	*
	* @param mpgsscId the primary key of the membership package ind services
	* @return the membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByPrimaryKey(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException {
		return getPersistence().findByPrimaryKey(mpgsscId);
	}

	/**
	* Returns the membership package ind services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpgsscId the primary key of the membership package ind services
	* @return the membership package ind services, or <code>null</code> if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByPrimaryKey(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mpgsscId);
	}

	/**
	* Returns all the membership package ind serviceses.
	*
	* @return the membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the membership package ind serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @return the range of membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the membership package ind serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package ind serviceses
	* @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership package ind serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership package ind serviceses.
	*
	* @return the number of membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipPackageIndServicesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipPackageIndServicesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipPackageIndServicesPersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipPackageIndServicesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MembershipPackageIndServicesPersistence persistence) {
	}

	private static MembershipPackageIndServicesPersistence _persistence;
}