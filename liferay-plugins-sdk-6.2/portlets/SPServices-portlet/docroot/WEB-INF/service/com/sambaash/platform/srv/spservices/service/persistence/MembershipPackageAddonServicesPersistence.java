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

import com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices;

/**
 * The persistence interface for the membership package addon services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageAddonServicesPersistenceImpl
 * @see MembershipPackageAddonServicesUtil
 * @generated
 */
public interface MembershipPackageAddonServicesPersistence
	extends BasePersistence<MembershipPackageAddonServices> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipPackageAddonServicesUtil} to access the membership package addon services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership package addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByMembershipPackageAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Returns the first membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByMembershipPackageAddonServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByMembershipPackageAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Returns the last membership package addon services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByMembershipPackageAddonServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices[] findByMembershipPackageAddonServicesScId_PrevAndNext(
		long mpAddonId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Removes all the membership package addon serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipPackageAddonServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package addon serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipPackageAddonServicesScId(java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @return the matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findByServiceNameMpId(
		java.lang.String extra1, java.lang.String scName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByServiceNameMpId_First(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Returns the first membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByServiceNameMpId_First(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByServiceNameMpId_Last(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Returns the last membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByServiceNameMpId_Last(
		java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices[] findByServiceNameMpId_PrevAndNext(
		long mpAddonId, java.lang.String extra1, java.lang.String scName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Removes all the membership package addon serviceses where extra1 = &#63; and scName = &#63; from the database.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceNameMpId(java.lang.String extra1,
		java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	*
	* @param extra1 the extra1
	* @param scName the sc name
	* @return the number of matching membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceNameMpId(java.lang.String extra1,
		java.lang.String scName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership package addon services in the entity cache if it is enabled.
	*
	* @param membershipPackageAddonServices the membership package addon services
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices);

	/**
	* Caches the membership package addon serviceses in the entity cache if it is enabled.
	*
	* @param membershipPackageAddonServiceses the membership package addon serviceses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> membershipPackageAddonServiceses);

	/**
	* Creates a new membership package addon services with the primary key. Does not add the membership package addon services to the database.
	*
	* @param mpAddonId the primary key for the new membership package addon services
	* @return the new membership package addon services
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices create(
		long mpAddonId);

	/**
	* Removes the membership package addon services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices remove(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package addon services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException} if it could not be found.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices findByPrimaryKey(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;

	/**
	* Returns the membership package addon services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpAddonId the primary key of the membership package addon services
	* @return the membership package addon services, or <code>null</code> if a membership package addon services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices fetchByPrimaryKey(
		long mpAddonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package addon serviceses.
	*
	* @return the membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership package addon serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package addon serviceses.
	*
	* @return the number of membership package addon serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}