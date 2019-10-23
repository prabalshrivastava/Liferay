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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.Outline;

/**
 * The persistence interface for the outline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see OutlinePersistenceImpl
 * @see OutlineUtil
 * @generated
 */
public interface OutlinePersistence extends BasePersistence<Outline> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OutlineUtil} to access the outline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the outlines where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the first outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the last outline in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline[] findByGroupId_PrevAndNext(
		long spOutlineId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Removes all the outlines where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outlines where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outlines where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @return the matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		long groupId, long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		long groupId, long outlineType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		long groupId, long outlineType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline findByGroupIdAndOutlineType_First(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the first outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByGroupIdAndOutlineType_First(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline findByGroupIdAndOutlineType_Last(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the last outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByGroupIdAndOutlineType_Last(
		long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline[] findByGroupIdAndOutlineType_PrevAndNext(
		long spOutlineId, long groupId, long outlineType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Removes all the outlines where groupId = &#63; and outlineType = &#63; from the database.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndOutlineType(long groupId, long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outlines where groupId = &#63; and outlineType = &#63;.
	*
	* @param groupId the group ID
	* @param outlineType the outline type
	* @return the number of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndOutlineType(long groupId, long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline findByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the first outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByGroupIdAndCompetencyUnitId_First(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline findByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the last outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching outline, or <code>null</code> if a matching outline could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByGroupIdAndCompetencyUnitId_Last(
		long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Outline[] findByGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutlineId, long groupId, long spCompetencyUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Removes all the outlines where groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param spCompetencyUnitId the sp competency unit ID
	* @return the number of matching outlines
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the outline in the entity cache if it is enabled.
	*
	* @param outline the outline
	*/
	public void cacheResult(com.sambaash.platform.srv.model.Outline outline);

	/**
	* Caches the outlines in the entity cache if it is enabled.
	*
	* @param outlines the outlines
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Outline> outlines);

	/**
	* Creates a new outline with the primary key. Does not add the outline to the database.
	*
	* @param spOutlineId the primary key for the new outline
	* @return the new outline
	*/
	public com.sambaash.platform.srv.model.Outline create(long spOutlineId);

	/**
	* Removes the outline with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline that was removed
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline remove(long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	public com.sambaash.platform.srv.model.Outline updateImpl(
		com.sambaash.platform.srv.model.Outline outline)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the outline with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchOutlineException} if it could not be found.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline
	* @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline findByPrimaryKey(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchOutlineException;

	/**
	* Returns the outline with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline, or <code>null</code> if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Outline fetchByPrimaryKey(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the outlines.
	*
	* @return the outlines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Outline> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Outline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the outlines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of outlines.
	*
	* @return the number of outlines
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}