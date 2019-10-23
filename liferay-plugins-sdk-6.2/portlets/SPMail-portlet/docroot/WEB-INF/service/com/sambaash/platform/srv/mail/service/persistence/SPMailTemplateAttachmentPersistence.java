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

package com.sambaash.platform.srv.mail.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;

/**
 * The persistence interface for the s p mail template attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateAttachmentPersistenceImpl
 * @see SPMailTemplateAttachmentUtil
 * @generated
 */
public interface SPMailTemplateAttachmentPersistence extends BasePersistence<SPMailTemplateAttachment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailTemplateAttachmentUtil} to access the s p mail template attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p mail template attachments where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail template attachments where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @return the range of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail template attachments where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail template attachments before and after the current s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param spTemplateAttachmentId the primary key of the current s p mail template attachment
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment[] findByTemplateId_PrevAndNext(
		long spTemplateAttachmentId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Removes all the s p mail template attachments where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail template attachments where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail template attachments where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail template attachments where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @return the range of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail template attachments where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByfileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the first s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByfileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByfileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the last s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByfileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail template attachments before and after the current s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param spTemplateAttachmentId the primary key of the current s p mail template attachment
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment[] findByfileEntryId_PrevAndNext(
		long spTemplateAttachmentId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Removes all the s p mail template attachments where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfileEntryId(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail template attachments where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByfileEntryId(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @return the matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @return the range of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateIdFileEntryId_First(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateIdFileEntryId_First(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateIdFileEntryId_Last(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateIdFileEntryId_Last(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail template attachments before and after the current s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param spTemplateAttachmentId the primary key of the current s p mail template attachment
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment[] findByTemplateIdFileEntryId_PrevAndNext(
		long spTemplateAttachmentId, long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Removes all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63; from the database.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateIdFileEntryId(long templateId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @return the number of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateIdFileEntryId(long templateId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail template attachment in the entity cache if it is enabled.
	*
	* @param spMailTemplateAttachment the s p mail template attachment
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment);

	/**
	* Caches the s p mail template attachments in the entity cache if it is enabled.
	*
	* @param spMailTemplateAttachments the s p mail template attachments
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> spMailTemplateAttachments);

	/**
	* Creates a new s p mail template attachment with the primary key. Does not add the s p mail template attachment to the database.
	*
	* @param spTemplateAttachmentId the primary key for the new s p mail template attachment
	* @return the new s p mail template attachment
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment create(
		long spTemplateAttachmentId);

	/**
	* Removes the s p mail template attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment remove(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail template attachment with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException} if it could not be found.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByPrimaryKey(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;

	/**
	* Returns the s p mail template attachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment, or <code>null</code> if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByPrimaryKey(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail template attachments.
	*
	* @return the s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail template attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @return the range of s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail template attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail template attachments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail template attachments.
	*
	* @return the number of s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}