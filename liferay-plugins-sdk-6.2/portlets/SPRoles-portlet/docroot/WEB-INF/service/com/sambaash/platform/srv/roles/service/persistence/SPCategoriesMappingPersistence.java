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

package com.sambaash.platform.srv.roles.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.roles.model.SPCategoriesMapping;

/**
 * The persistence interface for the s p categories mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPCategoriesMappingPersistenceImpl
 * @see SPCategoriesMappingUtil
 * @generated
 */
public interface SPCategoriesMappingPersistence extends BasePersistence<SPCategoriesMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPCategoriesMappingUtil} to access the s p categories mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p categories mappings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p categories mappings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @return the range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p categories mappings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p categories mapping in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the first s p categories mapping in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p categories mapping in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the last s p categories mapping in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where uuid = &#63;.
	*
	* @param spCategoryMappingId the primary key of the current s p categories mapping
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping[] findByUuid_PrevAndNext(
		long spCategoryMappingId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Removes all the s p categories mappings where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p categories mappings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mapping where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the s p categories mapping where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mapping where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p categories mapping where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p categories mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the number of s p categories mappings where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p categories mappings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p categories mappings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @return the range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p categories mappings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the first s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the last s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spCategoryMappingId the primary key of the current s p categories mapping
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping[] findByUuid_C_PrevAndNext(
		long spCategoryMappingId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Removes all the s p categories mappings where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p categories mappings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @return the matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByCreatedVocabularyId(
		long groupId, long createdVocabularyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @return the range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByCreatedVocabularyId(
		long groupId, long createdVocabularyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByCreatedVocabularyId(
		long groupId, long createdVocabularyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByCreatedVocabularyId_First(
		long groupId, long createdVocabularyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the first s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByCreatedVocabularyId_First(
		long groupId, long createdVocabularyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByCreatedVocabularyId_Last(
		long groupId, long createdVocabularyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the last s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByCreatedVocabularyId_Last(
		long groupId, long createdVocabularyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param spCategoryMappingId the primary key of the current s p categories mapping
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping[] findByCreatedVocabularyId_PrevAndNext(
		long spCategoryMappingId, long groupId, long createdVocabularyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Removes all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreatedVocabularyId(long groupId,
		long createdVocabularyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	*
	* @param groupId the group ID
	* @param createdVocabularyId the created vocabulary ID
	* @return the number of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreatedVocabularyId(long groupId, long createdVocabularyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @return the matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByMainCategoryId(
		long groupId, long mainCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @return the range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByMainCategoryId(
		long groupId, long mainCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findByMainCategoryId(
		long groupId, long mainCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByMainCategoryId_First(
		long groupId, long mainCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the first s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByMainCategoryId_First(
		long groupId, long mainCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByMainCategoryId_Last(
		long groupId, long mainCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the last s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByMainCategoryId_Last(
		long groupId, long mainCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param spCategoryMappingId the primary key of the current s p categories mapping
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping[] findByMainCategoryId_PrevAndNext(
		long spCategoryMappingId, long groupId, long mainCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Removes all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMainCategoryId(long groupId, long mainCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @return the number of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByMainCategoryId(long groupId, long mainCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException} if it could not be found.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param subCategoryId the sub category ID
	* @return the matching s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByMainAndSubCategoryId(
		long groupId, long mainCategoryId, long subCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param subCategoryId the sub category ID
	* @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByMainAndSubCategoryId(
		long groupId, long mainCategoryId, long subCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param subCategoryId the sub category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByMainAndSubCategoryId(
		long groupId, long mainCategoryId, long subCategoryId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param subCategoryId the sub category ID
	* @return the s p categories mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping removeByMainAndSubCategoryId(
		long groupId, long mainCategoryId, long subCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the number of s p categories mappings where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param mainCategoryId the main category ID
	* @param subCategoryId the sub category ID
	* @return the number of matching s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByMainAndSubCategoryId(long groupId, long mainCategoryId,
		long subCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p categories mapping in the entity cache if it is enabled.
	*
	* @param spCategoriesMapping the s p categories mapping
	*/
	public void cacheResult(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping);

	/**
	* Caches the s p categories mappings in the entity cache if it is enabled.
	*
	* @param spCategoriesMappings the s p categories mappings
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> spCategoriesMappings);

	/**
	* Creates a new s p categories mapping with the primary key. Does not add the s p categories mapping to the database.
	*
	* @param spCategoryMappingId the primary key for the new s p categories mapping
	* @return the new s p categories mapping
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping create(
		long spCategoryMappingId);

	/**
	* Removes the s p categories mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCategoryMappingId the primary key of the s p categories mapping
	* @return the s p categories mapping that was removed
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping remove(
		long spCategoryMappingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping updateImpl(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p categories mapping with the primary key or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException} if it could not be found.
	*
	* @param spCategoryMappingId the primary key of the s p categories mapping
	* @return the s p categories mapping
	* @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping findByPrimaryKey(
		long spCategoryMappingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;

	/**
	* Returns the s p categories mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCategoryMappingId the primary key of the s p categories mapping
	* @return the s p categories mapping, or <code>null</code> if a s p categories mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping fetchByPrimaryKey(
		long spCategoryMappingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p categories mappings.
	*
	* @return the s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p categories mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @return the range of s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p categories mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p categories mappings
	* @param end the upper bound of the range of s p categories mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p categories mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p categories mappings.
	*
	* @return the number of s p categories mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}