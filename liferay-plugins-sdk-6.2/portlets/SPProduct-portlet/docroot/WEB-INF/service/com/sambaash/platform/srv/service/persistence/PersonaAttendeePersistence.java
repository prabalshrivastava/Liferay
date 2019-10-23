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

import com.sambaash.platform.srv.model.PersonaAttendee;

/**
 * The persistence interface for the persona attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see PersonaAttendeePersistenceImpl
 * @see PersonaAttendeeUtil
 * @generated
 */
public interface PersonaAttendeePersistence extends BasePersistence<PersonaAttendee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonaAttendeeUtil} to access the persona attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the persona attendees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the persona attendees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @return the range of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the persona attendees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first persona attendee in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the first persona attendee in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last persona attendee in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the last persona attendee in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persona attendees before and after the current persona attendee in the ordered set where groupId = &#63;.
	*
	* @param spPersonaAttendeeId the primary key of the current persona attendee
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee[] findByGroupId_PrevAndNext(
		long spPersonaAttendeeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Removes all the persona attendees where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of persona attendees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the persona attendees where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @return the matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByPersonaIdAndGroupId(
		long spPersonaId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the persona attendees where spPersonaId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @return the range of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByPersonaIdAndGroupId(
		long spPersonaId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the persona attendees where spPersonaId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByPersonaIdAndGroupId(
		long spPersonaId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByPersonaIdAndGroupId_First(
		long spPersonaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the first persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByPersonaIdAndGroupId_First(
		long spPersonaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByPersonaIdAndGroupId_Last(
		long spPersonaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the last persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByPersonaIdAndGroupId_Last(
		long spPersonaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persona attendees before and after the current persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaAttendeeId the primary key of the current persona attendee
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee[] findByPersonaIdAndGroupId_PrevAndNext(
		long spPersonaAttendeeId, long spPersonaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Removes all the persona attendees where spPersonaId = &#63; and groupId = &#63; from the database.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPersonaIdAndGroupId(long spPersonaId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of persona attendees where spPersonaId = &#63; and groupId = &#63;.
	*
	* @param spPersonaId the sp persona ID
	* @param groupId the group ID
	* @return the number of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countByPersonaIdAndGroupId(long spPersonaId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the persona attendees where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the persona attendees where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @return the range of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the persona attendees where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the first persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the last persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persona attendees before and after the current persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spPersonaAttendeeId the primary key of the current persona attendee
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee[] findByCourseIdAndGroupId_PrevAndNext(
		long spPersonaAttendeeId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Removes all the persona attendees where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of persona attendees where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the persona attendee in the entity cache if it is enabled.
	*
	* @param personaAttendee the persona attendee
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee);

	/**
	* Caches the persona attendees in the entity cache if it is enabled.
	*
	* @param personaAttendees the persona attendees
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> personaAttendees);

	/**
	* Creates a new persona attendee with the primary key. Does not add the persona attendee to the database.
	*
	* @param spPersonaAttendeeId the primary key for the new persona attendee
	* @return the new persona attendee
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee create(
		long spPersonaAttendeeId);

	/**
	* Removes the persona attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPersonaAttendeeId the primary key of the persona attendee
	* @return the persona attendee that was removed
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee remove(
		long spPersonaAttendeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	public com.sambaash.platform.srv.model.PersonaAttendee updateImpl(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persona attendee with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchPersonaAttendeeException} if it could not be found.
	*
	* @param spPersonaAttendeeId the primary key of the persona attendee
	* @return the persona attendee
	* @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee findByPrimaryKey(
		long spPersonaAttendeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchPersonaAttendeeException;

	/**
	* Returns the persona attendee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPersonaAttendeeId the primary key of the persona attendee
	* @return the persona attendee, or <code>null</code> if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.PersonaAttendee fetchByPrimaryKey(
		long spPersonaAttendeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the persona attendees.
	*
	* @return the persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the persona attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @return the range of persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the persona attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the persona attendees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of persona attendees.
	*
	* @return the number of persona attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}