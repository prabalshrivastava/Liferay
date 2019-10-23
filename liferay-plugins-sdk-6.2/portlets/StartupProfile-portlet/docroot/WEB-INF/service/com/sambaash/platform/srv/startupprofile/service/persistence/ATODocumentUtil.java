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

import com.sambaash.platform.srv.startupprofile.model.ATODocument;

import java.util.List;

/**
 * The persistence utility for the a t o document service. This utility wraps {@link ATODocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ATODocumentPersistence
 * @see ATODocumentPersistenceImpl
 * @generated
 */
public class ATODocumentUtil {
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
	public static void clearCache(ATODocument atoDocument) {
		getPersistence().clearCache(atoDocument);
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
	public static List<ATODocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ATODocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ATODocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ATODocument update(ATODocument atoDocument)
		throws SystemException {
		return getPersistence().update(atoDocument);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ATODocument update(ATODocument atoDocument,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(atoDocument, serviceContext);
	}

	/**
	* Returns all the a t o documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByUuid_PrevAndNext(
		long atoDocumentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(atoDocumentId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the a t o documents where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of a t o documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the a t o documents where documentType = &#63;.
	*
	* @param documentType the document type
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByDocumentType(
		java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocumentType(documentType);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByDocumentType(
		java.lang.String documentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocumentType(documentType, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByDocumentType(
		java.lang.String documentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocumentType(documentType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByDocumentType_First(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByDocumentType_First(documentType, orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByDocumentType_First(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocumentType_First(documentType, orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByDocumentType_Last(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByDocumentType_Last(documentType, orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByDocumentType_Last(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocumentType_Last(documentType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByDocumentType_PrevAndNext(
		long atoDocumentId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByDocumentType_PrevAndNext(atoDocumentId, documentType,
			orderByComparator);
	}

	/**
	* Removes all the a t o documents where documentType = &#63; from the database.
	*
	* @param documentType the document type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDocumentType(java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDocumentType(documentType);
	}

	/**
	* Returns the number of a t o documents where documentType = &#63;.
	*
	* @param documentType the document type
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDocumentType(java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDocumentType(documentType);
	}

	/**
	* Returns all the a t o documents where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByOrganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByOrganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organizationId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByOrganizationId_PrevAndNext(
		long atoDocumentId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(atoDocumentId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the a t o documents where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	* Returns the number of a t o documents where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	* Returns all the a t o documents where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @return the matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndDocumentType(organizationId,
			documentType);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndDocumentType(organizationId,
			documentType, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndDocumentType(organizationId,
			documentType, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationAndDocumentType_First(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByOrganizationAndDocumentType_First(organizationId,
			documentType, orderByComparator);
	}

	/**
	* Returns the first a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationAndDocumentType_First(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndDocumentType_First(organizationId,
			documentType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByOrganizationAndDocumentType_Last(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByOrganizationAndDocumentType_Last(organizationId,
			documentType, orderByComparator);
	}

	/**
	* Returns the last a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByOrganizationAndDocumentType_Last(
		long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndDocumentType_Last(organizationId,
			documentType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument[] findByOrganizationAndDocumentType_PrevAndNext(
		long atoDocumentId, long organizationId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence()
				   .findByOrganizationAndDocumentType_PrevAndNext(atoDocumentId,
			organizationId, documentType, orderByComparator);
	}

	/**
	* Removes all the a t o documents where organizationId = &#63; and documentType = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByOrganizationAndDocumentType(organizationId, documentType);
	}

	/**
	* Returns the number of a t o documents where organizationId = &#63; and documentType = &#63;.
	*
	* @param organizationId the organization ID
	* @param documentType the document type
	* @return the number of matching a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationAndDocumentType(long organizationId,
		java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrganizationAndDocumentType(organizationId,
			documentType);
	}

	/**
	* Caches the a t o document in the entity cache if it is enabled.
	*
	* @param atoDocument the a t o document
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument) {
		getPersistence().cacheResult(atoDocument);
	}

	/**
	* Caches the a t o documents in the entity cache if it is enabled.
	*
	* @param atoDocuments the a t o documents
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> atoDocuments) {
		getPersistence().cacheResult(atoDocuments);
	}

	/**
	* Creates a new a t o document with the primary key. Does not add the a t o document to the database.
	*
	* @param atoDocumentId the primary key for the new a t o document
	* @return the new a t o document
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument create(
		long atoDocumentId) {
		return getPersistence().create(atoDocumentId);
	}

	/**
	* Removes the a t o document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument remove(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence().remove(atoDocumentId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.ATODocument updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(atoDocument);
	}

	/**
	* Returns the a t o document with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException} if it could not be found.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument findByPrimaryKey(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException {
		return getPersistence().findByPrimaryKey(atoDocumentId);
	}

	/**
	* Returns the a t o document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document, or <code>null</code> if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ATODocument fetchByPrimaryKey(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(atoDocumentId);
	}

	/**
	* Returns all the a t o documents.
	*
	* @return the a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the a t o documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of a t o documents.
	*
	* @return the number of a t o documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ATODocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ATODocumentPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.startupprofile.service.ClpSerializer.getServletContextName(),
					ATODocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(ATODocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ATODocumentPersistence persistence) {
	}

	private static ATODocumentPersistence _persistence;
}