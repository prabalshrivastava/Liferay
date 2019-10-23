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

import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices;

/**
 * The persistence interface for the membership package ind services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageIndServicesPersistenceImpl
 * @see MembershipPackageIndServicesUtil
 * @generated
 */
public interface MembershipPackageIndServicesPersistence extends BasePersistence<MembershipPackageIndServices> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipPackageIndServicesUtil} to access the membership package ind services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership package ind serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the first membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the last membership package ind services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices[] findByMembershipPackageIndServicesScId_PrevAndNext(
		long mpgsscId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Removes all the membership package ind serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipPackageIndServicesScId(java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package ind serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipPackageIndServicesScId(java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package ind serviceses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesMpId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesMpId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByMembershipPackageIndServicesMpId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByMembershipPackageIndServicesMpId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices[] findByMembershipPackageIndServicesMpId_PrevAndNext(
		long mpgsscId, long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Removes all the membership package ind serviceses where mpId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipPackageIndServicesMpId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package ind serviceses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the number of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipPackageIndServicesMpId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @return the matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByServiceNameMpId(
		long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByServiceNameMpId(
		long mpId, java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findByServiceNameMpId(
		long mpId, java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByServiceNameMpId_First(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the first membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByServiceNameMpId_First(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByServiceNameMpId_Last(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the last membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByServiceNameMpId_Last(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices[] findByServiceNameMpId_PrevAndNext(
		long mpgsscId, long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Removes all the membership package ind serviceses where mpId = &#63; and extra1 = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceNameMpId(long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @return the number of matching membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceNameMpId(long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership package ind services in the entity cache if it is enabled.
	*
	* @param membershipPackageIndServices the membership package ind services
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices membershipPackageIndServices);

	/**
	* Caches the membership package ind serviceses in the entity cache if it is enabled.
	*
	* @param membershipPackageIndServiceses the membership package ind serviceses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> membershipPackageIndServiceses);

	/**
	* Creates a new membership package ind services with the primary key. Does not add the membership package ind services to the database.
	*
	* @param mpgsscId the primary key for the new membership package ind services
	* @return the new membership package ind services
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices create(
		long mpgsscId);

	/**
	* Removes the membership package ind services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsscId the primary key of the membership package ind services
	* @return the membership package ind services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices remove(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices membershipPackageIndServices)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package ind services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException} if it could not be found.
	*
	* @param mpgsscId the primary key of the membership package ind services
	* @return the membership package ind services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices findByPrimaryKey(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;

	/**
	* Returns the membership package ind services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpgsscId the primary key of the membership package ind services
	* @return the membership package ind services, or <code>null</code> if a membership package ind services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices fetchByPrimaryKey(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package ind serviceses.
	*
	* @return the membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership package ind serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package ind serviceses.
	*
	* @return the number of membership package ind serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}