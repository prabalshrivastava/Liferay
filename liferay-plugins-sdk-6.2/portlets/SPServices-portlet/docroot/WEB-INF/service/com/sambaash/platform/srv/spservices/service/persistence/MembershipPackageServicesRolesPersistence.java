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

import com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles;

/**
 * The persistence interface for the membership package services roles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageServicesRolesPersistenceImpl
 * @see MembershipPackageServicesRolesUtil
 * @generated
 */
public interface MembershipPackageServicesRolesPersistence
	extends BasePersistence<MembershipPackageServicesRoles> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipPackageServicesRolesUtil} to access the membership package services roles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership package services roleses where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByClassName(
		long mpId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where mpId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByClassName(
		long mpId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where mpId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByClassName(
		long mpId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByClassName_First(
		long mpId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByClassName_First(
		long mpId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByClassName_Last(
		long mpId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByClassName_Last(
		long mpId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findByClassName_PrevAndNext(
		long mpgsrlId, long mpId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where mpId = &#63; and classNameId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassName(long mpId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where mpId = &#63; and classNameId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassName(long mpId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBympIdClassNameIdSvcId(
		long mpId, long classNameId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBympIdClassNameIdSvcId(
		long mpId, long classNameId, long serviceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBympIdClassNameIdSvcId(
		long mpId, long classNameId, long serviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findBympIdClassNameIdSvcId_First(
		long mpId, long classNameId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchBympIdClassNameIdSvcId_First(
		long mpId, long classNameId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findBympIdClassNameIdSvcId_Last(
		long mpId, long classNameId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchBympIdClassNameIdSvcId_Last(
		long mpId, long classNameId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findBympIdClassNameIdSvcId_PrevAndNext(
		long mpgsrlId, long mpId, long classNameId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBympIdClassNameIdSvcId(long mpId, long classNameId,
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	*
	* @param mpId the mp ID
	* @param classNameId the class name ID
	* @param serviceId the service ID
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countBympIdClassNameIdSvcId(long mpId, long classNameId,
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBympId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where mpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBympId(
		long mpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where mpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBympId(
		long mpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findBympId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchBympId_First(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findBympId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchBympId_Last(
		long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param mpId the mp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findBympId_PrevAndNext(
		long mpgsrlId, long mpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where mpId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBympId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where mpId = &#63;.
	*
	* @param mpId the mp ID
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countBympId(long mpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses where mpId = &#63; and roleId = &#63;.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageAndRole(
		long mpId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where mpId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageAndRole(
		long mpId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where mpId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageAndRole(
		long mpId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByMembershipPackageAndRole_First(
		long mpId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByMembershipPackageAndRole_First(
		long mpId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByMembershipPackageAndRole_Last(
		long mpId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByMembershipPackageAndRole_Last(
		long mpId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param mpId the mp ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findByMembershipPackageAndRole_PrevAndNext(
		long mpgsrlId, long mpId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where mpId = &#63; and roleId = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipPackageAndRole(long mpId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where mpId = &#63; and roleId = &#63;.
	*
	* @param mpId the mp ID
	* @param roleId the role ID
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipPackageAndRole(long mpId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByRoleId(
		long roleId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByRoleId(
		long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByRoleId(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByRoleId_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByRoleId_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByRoleId_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByRoleId_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where roleId = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findByRoleId_PrevAndNext(
		long mpgsrlId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where roleId = &#63; from the database.
	*
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceId(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceId the service ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceId(
		long serviceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceId the service ID
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceId(
		long serviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByServiceId_First(
		long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByServiceId_First(
		long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByServiceId_Last(
		long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByServiceId_Last(
		long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where serviceId = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findByServiceId_PrevAndNext(
		long mpgsrlId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where serviceId = &#63; from the database.
	*
	* @param serviceId the service ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceId(long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceId(long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @return the matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses where mpId = &#63; and extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses where mpId = &#63; and extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByServiceNameMpId_First(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the first membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByServiceNameMpId_First(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByServiceNameMpId_Last(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the last membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByServiceNameMpId_Last(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpgsrlId the primary key of the current membership package services roles
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles[] findByServiceNameMpId_PrevAndNext(
		long mpgsrlId, long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Removes all the membership package services roleses where mpId = &#63; and extra1 = &#63; from the database.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceNameMpId(long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses where mpId = &#63; and extra1 = &#63;.
	*
	* @param mpId the mp ID
	* @param extra1 the extra1
	* @return the number of matching membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceNameMpId(long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership package services roles in the entity cache if it is enabled.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles);

	/**
	* Caches the membership package services roleses in the entity cache if it is enabled.
	*
	* @param membershipPackageServicesRoleses the membership package services roleses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> membershipPackageServicesRoleses);

	/**
	* Creates a new membership package services roles with the primary key. Does not add the membership package services roles to the database.
	*
	* @param mpgsrlId the primary key for the new membership package services roles
	* @return the new membership package services roles
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles create(
		long mpgsrlId);

	/**
	* Removes the membership package services roles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles remove(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package services roles with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException} if it could not be found.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles findByPrimaryKey(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;

	/**
	* Returns the membership package services roles with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles, or <code>null</code> if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchByPrimaryKey(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package services roleses.
	*
	* @return the membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership package services roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership package services roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership package services roleses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package services roleses.
	*
	* @return the number of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}