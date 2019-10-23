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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.template.model.SPComponentTemplate;

import java.util.List;

/**
 * The persistence utility for the s p component template service. This utility wraps {@link SPComponentTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author WattabyteIT
 * @see SPComponentTemplatePersistence
 * @see SPComponentTemplatePersistenceImpl
 * @generated
 */
public class SPComponentTemplateUtil {
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
	public static void clearCache(SPComponentTemplate spComponentTemplate) {
		getPersistence().clearCache(spComponentTemplate);
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
	public static List<SPComponentTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPComponentTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPComponentTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPComponentTemplate update(
		SPComponentTemplate spComponentTemplate) throws SystemException {
		return getPersistence().update(spComponentTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPComponentTemplate update(
		SPComponentTemplate spComponentTemplate, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spComponentTemplate, serviceContext);
	}

	/**
	* Returns all the s p component templates where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p component templates where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @return the range of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p component templates where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p component template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p component template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p component template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p component template in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p component templates before and after the current s p component template in the ordered set where uuid = &#63;.
	*
	* @param spComponentTemplateId the primary key of the current s p component template
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate[] findByUuid_PrevAndNext(
		long spComponentTemplateId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spComponentTemplateId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the s p component templates where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p component templates where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p component template where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p component template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p component template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p component template where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p component template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p component templates where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p component templates where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the s p component templates where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @return the range of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the s p component templates where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the s p component templates before and after the current s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spComponentTemplateId the primary key of the current s p component template
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate[] findByUuid_C_PrevAndNext(
		long spComponentTemplateId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spComponentTemplateId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the s p component templates where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of s p component templates where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the s p component templates where spTemplateId = &#63;.
	*
	* @param spTemplateId the sp template ID
	* @return the matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByTemplateId(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(spTemplateId);
	}

	/**
	* Returns a range of all the s p component templates where spTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spTemplateId the sp template ID
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @return the range of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByTemplateId(
		long spTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(spTemplateId, start, end);
	}

	/**
	* Returns an ordered range of all the s p component templates where spTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spTemplateId the sp template ID
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findByTemplateId(
		long spTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(spTemplateId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p component template in the ordered set where spTemplateId = &#63;.
	*
	* @param spTemplateId the sp template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByTemplateId_First(
		long spTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByTemplateId_First(spTemplateId, orderByComparator);
	}

	/**
	* Returns the first s p component template in the ordered set where spTemplateId = &#63;.
	*
	* @param spTemplateId the sp template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByTemplateId_First(
		long spTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(spTemplateId, orderByComparator);
	}

	/**
	* Returns the last s p component template in the ordered set where spTemplateId = &#63;.
	*
	* @param spTemplateId the sp template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByTemplateId_Last(
		long spTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByTemplateId_Last(spTemplateId, orderByComparator);
	}

	/**
	* Returns the last s p component template in the ordered set where spTemplateId = &#63;.
	*
	* @param spTemplateId the sp template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByTemplateId_Last(
		long spTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(spTemplateId, orderByComparator);
	}

	/**
	* Returns the s p component templates before and after the current s p component template in the ordered set where spTemplateId = &#63;.
	*
	* @param spComponentTemplateId the primary key of the current s p component template
	* @param spTemplateId the sp template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate[] findByTemplateId_PrevAndNext(
		long spComponentTemplateId, long spTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(spComponentTemplateId,
			spTemplateId, orderByComparator);
	}

	/**
	* Removes all the s p component templates where spTemplateId = &#63; from the database.
	*
	* @param spTemplateId the sp template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(spTemplateId);
	}

	/**
	* Returns the number of s p component templates where spTemplateId = &#63;.
	*
	* @param spTemplateId the sp template ID
	* @return the number of matching s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(spTemplateId);
	}

	/**
	* Caches the s p component template in the entity cache if it is enabled.
	*
	* @param spComponentTemplate the s p component template
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate) {
		getPersistence().cacheResult(spComponentTemplate);
	}

	/**
	* Caches the s p component templates in the entity cache if it is enabled.
	*
	* @param spComponentTemplates the s p component templates
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> spComponentTemplates) {
		getPersistence().cacheResult(spComponentTemplates);
	}

	/**
	* Creates a new s p component template with the primary key. Does not add the s p component template to the database.
	*
	* @param spComponentTemplateId the primary key for the new s p component template
	* @return the new s p component template
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate create(
		long spComponentTemplateId) {
		return getPersistence().create(spComponentTemplateId);
	}

	/**
	* Removes the s p component template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spComponentTemplateId the primary key of the s p component template
	* @return the s p component template that was removed
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate remove(
		long spComponentTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence().remove(spComponentTemplateId);
	}

	public static com.sambaash.platform.srv.template.model.SPComponentTemplate updateImpl(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spComponentTemplate);
	}

	/**
	* Returns the s p component template with the primary key or throws a {@link com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException} if it could not be found.
	*
	* @param spComponentTemplateId the primary key of the s p component template
	* @return the s p component template
	* @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate findByPrimaryKey(
		long spComponentTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException {
		return getPersistence().findByPrimaryKey(spComponentTemplateId);
	}

	/**
	* Returns the s p component template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spComponentTemplateId the primary key of the s p component template
	* @return the s p component template, or <code>null</code> if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchByPrimaryKey(
		long spComponentTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spComponentTemplateId);
	}

	/**
	* Returns all the s p component templates.
	*
	* @return the s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p component templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @return the range of s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p component templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p component templates
	* @param end the upper bound of the range of s p component templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p component templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p component templates.
	*
	* @return the number of s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPComponentTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPComponentTemplatePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.template.service.ClpSerializer.getServletContextName(),
					SPComponentTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(SPComponentTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPComponentTemplatePersistence persistence) {
	}

	private static SPComponentTemplatePersistence _persistence;
}