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

package com.sambaash.platform.srv.template.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.template.model.SPTemplate;

/**
 * The persistence interface for the s p template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author WattabyteIT
 * @see SPTemplatePersistenceImpl
 * @see SPTemplateUtil
 * @generated
 */
public interface SPTemplatePersistence extends BasePersistence<SPTemplate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPTemplateUtil} to access the s p template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p templates where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p templates where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @return the range of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p templates where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the first s p template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the last s p template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p templates before and after the current s p template in the ordered set where uuid = &#63;.
	*
	* @param spTemplateId the primary key of the current s p template
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate[] findByUuid_PrevAndNext(
		long spTemplateId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Removes all the s p templates where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p templates where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p template where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.template.NoSuchSPTemplateException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the s p template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p template where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the number of s p templates where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p templates where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p templates where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @return the range of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p templates where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the first s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the last s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p templates before and after the current s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spTemplateId the primary key of the current s p template
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate[] findByUuid_C_PrevAndNext(
		long spTemplateId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Removes all the s p templates where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p templates where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p templates where templateName = &#63;.
	*
	* @param templateName the template name
	* @return the matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByTemplateName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p templates where templateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateName the template name
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @return the range of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByTemplateName(
		java.lang.String templateName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p templates where templateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateName the template name
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByTemplateName(
		java.lang.String templateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByTemplateName_First(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the first s p template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByTemplateName_First(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByTemplateName_Last(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the last s p template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByTemplateName_Last(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p templates before and after the current s p template in the ordered set where templateName = &#63;.
	*
	* @param spTemplateId the primary key of the current s p template
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate[] findByTemplateName_PrevAndNext(
		long spTemplateId, java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Removes all the s p templates where templateName = &#63; from the database.
	*
	* @param templateName the template name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p templates where templateName = &#63;.
	*
	* @param templateName the template name
	* @return the number of matching s p templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p template in the entity cache if it is enabled.
	*
	* @param spTemplate the s p template
	*/
	public void cacheResult(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate);

	/**
	* Caches the s p templates in the entity cache if it is enabled.
	*
	* @param spTemplates the s p templates
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> spTemplates);

	/**
	* Creates a new s p template with the primary key. Does not add the s p template to the database.
	*
	* @param spTemplateId the primary key for the new s p template
	* @return the new s p template
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate create(
		long spTemplateId);

	/**
	* Removes the s p template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplateId the primary key of the s p template
	* @return the s p template that was removed
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate remove(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	public com.sambaash.platform.srv.template.model.SPTemplate updateImpl(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p template with the primary key or throws a {@link com.sambaash.platform.srv.template.NoSuchSPTemplateException} if it could not be found.
	*
	* @param spTemplateId the primary key of the s p template
	* @return the s p template
	* @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate findByPrimaryKey(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPTemplateException;

	/**
	* Returns the s p template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spTemplateId the primary key of the s p template
	* @return the s p template, or <code>null</code> if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.template.model.SPTemplate fetchByPrimaryKey(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p templates.
	*
	* @return the s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @return the range of s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p templates.
	*
	* @return the number of s p templates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}