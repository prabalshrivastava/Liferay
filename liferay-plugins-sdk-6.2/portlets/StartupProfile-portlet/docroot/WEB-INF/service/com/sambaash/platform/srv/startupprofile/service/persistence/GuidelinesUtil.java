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

package com.sambaash.platform.srv.startupprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.startupprofile.model.Guidelines;

import java.util.List;

/**
 * The persistence utility for the guidelines service. This utility wraps {@link GuidelinesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see GuidelinesPersistence
 * @see GuidelinesPersistenceImpl
 * @generated
 */
public class GuidelinesUtil {
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
	public static void clearCache(Guidelines guidelines) {
		getPersistence().clearCache(guidelines);
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
	public static List<Guidelines> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Guidelines> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Guidelines> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Guidelines update(Guidelines guidelines)
		throws SystemException {
		return getPersistence().update(guidelines);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Guidelines update(Guidelines guidelines,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(guidelines, serviceContext);
	}

	/**
	* Returns all the guidelineses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the guidelineses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @return the range of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the guidelineses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first guidelines in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first guidelines in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guidelines, or <code>null</code> if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last guidelines in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last guidelines in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guidelines, or <code>null</code> if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the guidelineses before and after the current guidelines in the ordered set where uuid = &#63;.
	*
	* @param guidelineId the primary key of the current guidelines
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines[] findByUuid_PrevAndNext(
		long guidelineId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByUuid_PrevAndNext(guidelineId, uuid, orderByComparator);
	}

	/**
	* Removes all the guidelineses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of guidelineses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the guidelineses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	* Returns a range of all the guidelineses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @return the range of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the guidelineses where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first guidelines in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByOrganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first guidelines in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guidelines, or <code>null</code> if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last guidelines in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last guidelines in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guidelines, or <code>null</code> if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the guidelineses before and after the current guidelines in the ordered set where organizationId = &#63;.
	*
	* @param guidelineId the primary key of the current guidelines
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines[] findByOrganizationId_PrevAndNext(
		long guidelineId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(guidelineId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the guidelineses where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	* Returns the number of guidelineses where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	* Returns all the guidelineses where organizationId = &#63; and principleId = &#63;.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @return the matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByOrganizationAndPrincipleIdId(
		long organizationId, long principleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndPrincipleIdId(organizationId,
			principleId);
	}

	/**
	* Returns a range of all the guidelineses where organizationId = &#63; and principleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @return the range of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByOrganizationAndPrincipleIdId(
		long organizationId, long principleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndPrincipleIdId(organizationId,
			principleId, start, end);
	}

	/**
	* Returns an ordered range of all the guidelineses where organizationId = &#63; and principleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findByOrganizationAndPrincipleIdId(
		long organizationId, long principleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndPrincipleIdId(organizationId,
			principleId, start, end, orderByComparator);
	}

	/**
	* Returns the first guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByOrganizationAndPrincipleIdId_First(
		long organizationId, long principleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByOrganizationAndPrincipleIdId_First(organizationId,
			principleId, orderByComparator);
	}

	/**
	* Returns the first guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guidelines, or <code>null</code> if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByOrganizationAndPrincipleIdId_First(
		long organizationId, long principleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndPrincipleIdId_First(organizationId,
			principleId, orderByComparator);
	}

	/**
	* Returns the last guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByOrganizationAndPrincipleIdId_Last(
		long organizationId, long principleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByOrganizationAndPrincipleIdId_Last(organizationId,
			principleId, orderByComparator);
	}

	/**
	* Returns the last guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guidelines, or <code>null</code> if a matching guidelines could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByOrganizationAndPrincipleIdId_Last(
		long organizationId, long principleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndPrincipleIdId_Last(organizationId,
			principleId, orderByComparator);
	}

	/**
	* Returns the guidelineses before and after the current guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	*
	* @param guidelineId the primary key of the current guidelines
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines[] findByOrganizationAndPrincipleIdId_PrevAndNext(
		long guidelineId, long organizationId, long principleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence()
				   .findByOrganizationAndPrincipleIdId_PrevAndNext(guidelineId,
			organizationId, principleId, orderByComparator);
	}

	/**
	* Removes all the guidelineses where organizationId = &#63; and principleId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationAndPrincipleIdId(
		long organizationId, long principleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByOrganizationAndPrincipleIdId(organizationId, principleId);
	}

	/**
	* Returns the number of guidelineses where organizationId = &#63; and principleId = &#63;.
	*
	* @param organizationId the organization ID
	* @param principleId the principle ID
	* @return the number of matching guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationAndPrincipleIdId(long organizationId,
		long principleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrganizationAndPrincipleIdId(organizationId,
			principleId);
	}

	/**
	* Caches the guidelines in the entity cache if it is enabled.
	*
	* @param guidelines the guidelines
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.Guidelines guidelines) {
		getPersistence().cacheResult(guidelines);
	}

	/**
	* Caches the guidelineses in the entity cache if it is enabled.
	*
	* @param guidelineses the guidelineses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> guidelineses) {
		getPersistence().cacheResult(guidelineses);
	}

	/**
	* Creates a new guidelines with the primary key. Does not add the guidelines to the database.
	*
	* @param guidelineId the primary key for the new guidelines
	* @return the new guidelines
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines create(
		long guidelineId) {
		return getPersistence().create(guidelineId);
	}

	/**
	* Removes the guidelines with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guidelineId the primary key of the guidelines
	* @return the guidelines that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines remove(
		long guidelineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence().remove(guidelineId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Guidelines updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Guidelines guidelines)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(guidelines);
	}

	/**
	* Returns the guidelines with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException} if it could not be found.
	*
	* @param guidelineId the primary key of the guidelines
	* @return the guidelines
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines findByPrimaryKey(
		long guidelineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException {
		return getPersistence().findByPrimaryKey(guidelineId);
	}

	/**
	* Returns the guidelines with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param guidelineId the primary key of the guidelines
	* @return the guidelines, or <code>null</code> if a guidelines with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Guidelines fetchByPrimaryKey(
		long guidelineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(guidelineId);
	}

	/**
	* Returns all the guidelineses.
	*
	* @return the guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the guidelineses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @return the range of guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the guidelineses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of guidelineses
	* @param end the upper bound of the range of guidelineses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Guidelines> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the guidelineses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of guidelineses.
	*
	* @return the number of guidelineses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GuidelinesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GuidelinesPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.startupprofile.service.ClpSerializer.getServletContextName(),
					GuidelinesPersistence.class.getName());

			ReferenceRegistry.registerReference(GuidelinesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GuidelinesPersistence persistence) {
	}

	private static GuidelinesPersistence _persistence;
}