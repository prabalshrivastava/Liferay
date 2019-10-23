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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.Outline;

import java.util.List;

/**
 * The persistence utility for the outline service. This utility wraps {@link OutlinePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see OutlinePersistence
 * @see OutlinePersistenceImpl
 * @generated
 */
public class OutlineUtil {
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
	public static void clearCache(Outline outline) {
		getPersistence().clearCache(outline);
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
	public static List<Outline> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Outline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Outline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Outline update(Outline outline) throws SystemException {
		return getPersistence().update(outline);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Outline update(Outline outline, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(outline, serviceContext);
	}

	/**
	* Returns all the outlines where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the outlines where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @return the range of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the outlines where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the outlines before and after the current outline in the ordered set where groupId = &#63;.
	*
	* @param spOutlineId the primary key of the current outline
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline[] findByGroupId_PrevAndNext(
		long spOutlineId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spOutlineId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the outlines where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of outlines where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the outlines where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @return the matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		long groupId, long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndOutlineType(groupId, outlineType);
	}

	/**
	* Returns a range of all the outlines where groupId = &#63; and outlineType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @return the range of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		long groupId, long outlineType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndOutlineType(groupId, outlineType, start, end);
	}

	/**
	* Returns an ordered range of all the outlines where groupId = &#63; and outlineType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		long groupId, long outlineType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndOutlineType(groupId, outlineType, start,
			end, orderByComparator);
	}

	/**
	* Returns the first outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByGroupIdAndOutlineType_First(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupIdAndOutlineType_First(groupId, outlineType,
			orderByComparator);
	}

	/**
	* Returns the first outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByGroupIdAndOutlineType_First(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndOutlineType_First(groupId, outlineType,
			orderByComparator);
	}

	/**
	* Returns the last outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByGroupIdAndOutlineType_Last(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupIdAndOutlineType_Last(groupId, outlineType,
			orderByComparator);
	}

	/**
	* Returns the last outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByGroupIdAndOutlineType_Last(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndOutlineType_Last(groupId, outlineType,
			orderByComparator);
	}

	/**
	* Returns the outlines before and after the current outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param spOutlineId the primary key of the current outline
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline[] findByGroupIdAndOutlineType_PrevAndNext(
		long spOutlineId, long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupIdAndOutlineType_PrevAndNext(spOutlineId,
			groupId, outlineType, orderByComparator);
	}

	/**
	* Removes all the outlines where groupId = &#63; and outlineType = &#63; from the database.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndOutlineType(long groupId,
		long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdAndOutlineType(groupId, outlineType);
	}

	/**
	* Returns the number of outlines where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @return the number of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndOutlineType(long groupId,
		long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupIdAndOutlineType(groupId, outlineType);
	}

	/**
	* Returns all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId);
	}

	/**
	* Returns a range of all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @return the range of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId, start, end);
	}

	/**
	* Returns an ordered range of all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId, start, end, orderByComparator);
	}

	/**
	* Returns the first outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId_First(groupId,
			spCompetencyUnitId, orderByComparator);
	}

	/**
	* Returns the first outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCompetencyUnitId_First(groupId,
			spCompetencyUnitId, orderByComparator);
	}

	/**
	* Returns the last outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId_Last(groupId,
			spCompetencyUnitId, orderByComparator);
	}

	/**
	* Returns the last outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCompetencyUnitId_Last(groupId,
			spCompetencyUnitId, orderByComparator);
	}

	/**
	* Returns the outlines before and after the current outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param spOutlineId the primary key of the current outline
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline[] findByGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutlineId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence()
				   .findByGroupIdAndCompetencyUnitId_PrevAndNext(spOutlineId,
			groupId, spCompetencyUnitId, orderByComparator);
	}

	/**
	* Removes all the outlines where groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId);
	}

	/**
	* Returns the number of outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the number of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId);
	}

	/**
	* Caches the outline in the entity cache if it is enabled.
	*
	* @param outline the outline
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Outline outline) {
		getPersistence().cacheResult(outline);
	}

	/**
	* Caches the outlines in the entity cache if it is enabled.
	*
	* @param outlines the outlines
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Outline> outlines) {
		getPersistence().cacheResult(outlines);
	}

	/**
	* Creates a new outline with the primary key. Does not add the outline to the database.
	*
	* @param spOutlineId the primary key for the new outline
	* @return the new outline
	*/
	public static com.sambaash.platform.srv.model.Outline create(
		long spOutlineId) {
		return getPersistence().create(spOutlineId);
	}

	/**
	* Removes the outline with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline that was removed
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline remove(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence().remove(spOutlineId);
	}

	public static com.sambaash.platform.srv.model.Outline updateImpl(
		com.sambaash.platform.srv.model.Outline outline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(outline);
	}

	/**
	* Returns the outline with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchOutlineException} if it could not be found.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline findByPrimaryKey(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException {
		return getPersistence().findByPrimaryKey(spOutlineId);
	}

	/**
	* Returns the outline with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline, or <code>null</code> if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Outline fetchByPrimaryKey(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spOutlineId);
	}

	/**
	* Returns all the outlines.
	*
	* @return the outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the outlines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @return the range of outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the outlines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of outlines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Outline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the outlines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of outlines.
	*
	* @return the number of outlines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OutlinePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OutlinePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					OutlinePersistence.class.getName());

			ReferenceRegistry.registerReference(OutlineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OutlinePersistence persistence) {
	}

	private static OutlinePersistence _persistence;
}