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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;

import java.util.List;

/**
 * The persistence utility for the s p mail template attachment service. This utility wraps {@link SPMailTemplateAttachmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateAttachmentPersistence
 * @see SPMailTemplateAttachmentPersistenceImpl
 * @generated
 */
public class SPMailTemplateAttachmentUtil {
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
		SPMailTemplateAttachment spMailTemplateAttachment) {
		getPersistence().clearCache(spMailTemplateAttachment);
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
	public static List<SPMailTemplateAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailTemplateAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailTemplateAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailTemplateAttachment update(
		SPMailTemplateAttachment spMailTemplateAttachment)
		throws SystemException {
		return getPersistence().update(spMailTemplateAttachment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailTemplateAttachment update(
		SPMailTemplateAttachment spMailTemplateAttachment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spMailTemplateAttachment, serviceContext);
	}

	/**
	* Returns all the s p mail template attachments where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(templateId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(templateId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment[] findByTemplateId_PrevAndNext(
		long spTemplateAttachmentId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(spTemplateAttachmentId,
			templateId, orderByComparator);
	}

	/**
	* Removes all the s p mail template attachments where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(templateId);
	}

	/**
	* Returns the number of s p mail template attachments where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(templateId);
	}

	/**
	* Returns all the s p mail template attachments where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfileEntryId(fileEntryId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfileEntryId(fileEntryId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfileEntryId(fileEntryId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByfileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByfileEntryId_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the first s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByfileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfileEntryId_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByfileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByfileEntryId_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last s p mail template attachment in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByfileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfileEntryId_Last(fileEntryId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment[] findByfileEntryId_PrevAndNext(
		long spTemplateAttachmentId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByfileEntryId_PrevAndNext(spTemplateAttachmentId,
			fileEntryId, orderByComparator);
	}

	/**
	* Removes all the s p mail template attachments where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfileEntryId(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfileEntryId(fileEntryId);
	}

	/**
	* Returns the number of s p mail template attachments where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfileEntryId(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfileEntryId(fileEntryId);
	}

	/**
	* Returns all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @return the matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdFileEntryId(templateId, fileEntryId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdFileEntryId(templateId, fileEntryId, start,
			end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdFileEntryId(templateId, fileEntryId, start,
			end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateIdFileEntryId_First(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByTemplateIdFileEntryId_First(templateId, fileEntryId,
			orderByComparator);
	}

	/**
	* Returns the first s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateIdFileEntryId_First(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateIdFileEntryId_First(templateId, fileEntryId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByTemplateIdFileEntryId_Last(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByTemplateIdFileEntryId_Last(templateId, fileEntryId,
			orderByComparator);
	}

	/**
	* Returns the last s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByTemplateIdFileEntryId_Last(
		long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateIdFileEntryId_Last(templateId, fileEntryId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment[] findByTemplateIdFileEntryId_PrevAndNext(
		long spTemplateAttachmentId, long templateId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence()
				   .findByTemplateIdFileEntryId_PrevAndNext(spTemplateAttachmentId,
			templateId, fileEntryId, orderByComparator);
	}

	/**
	* Removes all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63; from the database.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateIdFileEntryId(long templateId,
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateIdFileEntryId(templateId, fileEntryId);
	}

	/**
	* Returns the number of s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	*
	* @param templateId the template ID
	* @param fileEntryId the file entry ID
	* @return the number of matching s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateIdFileEntryId(long templateId,
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTemplateIdFileEntryId(templateId, fileEntryId);
	}

	/**
	* Caches the s p mail template attachment in the entity cache if it is enabled.
	*
	* @param spMailTemplateAttachment the s p mail template attachment
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment) {
		getPersistence().cacheResult(spMailTemplateAttachment);
	}

	/**
	* Caches the s p mail template attachments in the entity cache if it is enabled.
	*
	* @param spMailTemplateAttachments the s p mail template attachments
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> spMailTemplateAttachments) {
		getPersistence().cacheResult(spMailTemplateAttachments);
	}

	/**
	* Creates a new s p mail template attachment with the primary key. Does not add the s p mail template attachment to the database.
	*
	* @param spTemplateAttachmentId the primary key for the new s p mail template attachment
	* @return the new s p mail template attachment
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment create(
		long spTemplateAttachmentId) {
		return getPersistence().create(spTemplateAttachmentId);
	}

	/**
	* Removes the s p mail template attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment remove(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence().remove(spTemplateAttachmentId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailTemplateAttachment);
	}

	/**
	* Returns the s p mail template attachment with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException} if it could not be found.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment findByPrimaryKey(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException {
		return getPersistence().findByPrimaryKey(spTemplateAttachmentId);
	}

	/**
	* Returns the s p mail template attachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment, or <code>null</code> if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchByPrimaryKey(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spTemplateAttachmentId);
	}

	/**
	* Returns all the s p mail template attachments.
	*
	* @return the s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail template attachments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail template attachments.
	*
	* @return the number of s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailTemplateAttachmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailTemplateAttachmentPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailTemplateAttachmentPersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailTemplateAttachmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailTemplateAttachmentPersistence persistence) {
	}

	private static SPMailTemplateAttachmentPersistence _persistence;
}