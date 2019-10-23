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

import com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices;

/**
 * The persistence interface for the membership subscribed services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServicesPersistenceImpl
 * @see MembershipSubscribedServicesUtil
 * @generated
 */
public interface MembershipSubscribedServicesPersistence extends BasePersistence<MembershipSubscribedServices> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipSubscribedServicesUtil} to access the membership subscribed services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership subscribed serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		java.lang.String scId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScId_First(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63;.
	*
	* @param scId the sc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScId_Last(
		java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices[] findByMembershipSubscribedServicesScId_PrevAndNext(
		long mssId, java.lang.String scId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Removes all the membership subscribed serviceses where scId = &#63; from the database.
	*
	* @param scId the sc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscribedServicesScId(java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscribed serviceses where scId = &#63;.
	*
	* @param scId the sc ID
	* @return the number of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscribedServicesScId(java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @return the matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScIdAndCreatedBy_First(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Returns the first membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScIdAndCreatedBy_First(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByMembershipSubscribedServicesScIdAndCreatedBy_Last(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Returns the last membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByMembershipSubscribedServicesScIdAndCreatedBy_Last(
		java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices[] findByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(
		long mssId, java.lang.String scId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Removes all the membership subscribed serviceses where scId = &#63; and createdBy = &#63; from the database.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	*
	* @param scId the sc ID
	* @param createdBy the created by
	* @return the number of matching membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscribedServicesScIdAndCreatedBy(
		java.lang.String scId, java.lang.String createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership subscribed services in the entity cache if it is enabled.
	*
	* @param membershipSubscribedServices the membership subscribed services
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices);

	/**
	* Caches the membership subscribed serviceses in the entity cache if it is enabled.
	*
	* @param membershipSubscribedServiceses the membership subscribed serviceses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> membershipSubscribedServiceses);

	/**
	* Creates a new membership subscribed services with the primary key. Does not add the membership subscribed services to the database.
	*
	* @param mssId the primary key for the new membership subscribed services
	* @return the new membership subscribed services
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices create(
		long mssId);

	/**
	* Removes the membership subscribed services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices remove(
		long mssId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscribed services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException} if it could not be found.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices findByPrimaryKey(
		long mssId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;

	/**
	* Returns the membership subscribed services with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mssId the primary key of the membership subscribed services
	* @return the membership subscribed services, or <code>null</code> if a membership subscribed services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices fetchByPrimaryKey(
		long mssId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscribed serviceses.
	*
	* @return the membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership subscribed serviceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscribed serviceses.
	*
	* @return the number of membership subscribed serviceses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}