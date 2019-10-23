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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.startupprofile.model.ATODocument;

/**
 * The persistence interface for the a t o document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ATODocumentPersistenceImpl
 * @see ATODocumentUtil
 * @generated
 */
public interface ATODocumentPersistence extends BasePersistence<ATODocument> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ATODocumentUtil} to access the a t o document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the a t o documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a t o documents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @return the range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a t o documents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the first a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the last a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a t o documents before and after the current a t o document in the ordered set where uuid = &#63;.
	*
	* @param atoDocumentId the primary key of the current a t o document
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByUuid_PrevAndNext(
		long atoDocumentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Removes all the a t o documents where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a t o documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the a t o documents where documentType = &#63;.
	*
	* @param documentType the document type
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByDocumentType(
		java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a t o documents where documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param documentType the document type
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @return the range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByDocumentType(
		java.lang.String documentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a t o documents where documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param documentType the document type
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByDocumentType(
		java.lang.String documentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByDocumentType_First(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the first a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByDocumentType_First(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByDocumentType_Last(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the last a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByDocumentType_Last(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a t o documents before and after the current a t o document in the ordered set where documentType = &#63;.
	*
	* @param atoDocumentId the primary key of the current a t o document
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByDocumentType_PrevAndNext(
		long atoDocumentId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Removes all the a t o documents where documentType = &#63; from the database.
	*
	* @param documentType the document type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDocumentType(java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a t o documents where documentType = &#63;.
	*
	* @param documentType the document type
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByDocumentType(java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the a t o documents where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a t o documents where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @return the range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a t o documents where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a t o documents before and after the current a t o document in the ordered set where organizationId = &#63;.
	*
	* @param atoDocumentId the primary key of the current a t o document
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByOrganizationId_PrevAndNext(
		long atoDocumentId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Removes all the a t o documents where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a t o documents where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the a t o documents where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a t o documents where organizationId = &#63; and documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @return the range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a t o documents where organizationId = &#63; and documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationAndDocumentType_First(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationAndDocumentType_First(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationAndDocumentType_Last(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationAndDocumentType_Last(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a t o documents before and after the current a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param atoDocumentId the primary key of the current a t o document
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByOrganizationAndDocumentType_PrevAndNext(
		long atoDocumentId, long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Removes all the a t o documents where organizationId = &#63; and documentType = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationAndDocumentType(long organizationId,
		java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a t o documents where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationAndDocumentType(long organizationId,
		java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the a t o document in the entity cache if it is enabled.
	*
	* @param atoDocument the a t o document
	*/
	public void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument);

	/**
	* Caches the a t o documents in the entity cache if it is enabled.
	*
	* @param atoDocuments the a t o documents
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> atoDocuments);

	/**
	* Creates a new a t o document with the primary key. Does not add the a t o document to the database.
	*
	* @param atoDocumentId the primary key for the new a t o document
	* @return the new a t o document
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument create(
		long atoDocumentId);

	/**
	* Removes the a t o document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument remove(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	public com.sambaash.platform.srv.startupprofile.model.ATODocument updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a t o document with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException} if it could not be found.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument findByPrimaryKey(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;

	/**
	* Returns the a t o document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document, or <code>null</code> if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByPrimaryKey(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the a t o documents.
	*
	* @return the a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a t o documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @return the range of a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a t o documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the a t o documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a t o documents.
	*
	* @return the number of a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}