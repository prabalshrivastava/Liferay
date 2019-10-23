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

import com.sambaash.platform.srv.mail.model.SPMailTemplate;

import java.util.List;

/**
 * The persistence utility for the s p mail template service. This utility wraps {@link SPMailTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplatePersistence
 * @see SPMailTemplatePersistenceImpl
 * @generated
 */
public class SPMailTemplateUtil {
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
	public static void clearCache(SPMailTemplate spMailTemplate) {
		getPersistence().clearCache(spMailTemplate);
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
	public static List<SPMailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailTemplate update(SPMailTemplate spMailTemplate)
		throws SystemException {
		return getPersistence().update(spMailTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailTemplate update(SPMailTemplate spMailTemplate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spMailTemplate, serviceContext);
	}

	/**
	* Returns all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @return the matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName);
	}

	/**
	* Returns a range of all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @return the range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByProductTypeIdAndSubProductTypeIdAndTemplateName_First(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateName_First(productTypeId,
			subProductTypeId, templateName, orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_First(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_First(productTypeId,
			subProductTypeId, templateName, orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(productTypeId,
			subProductTypeId, templateName, orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(productTypeId,
			subProductTypeId, templateName, orderByComparator);
	}

	/**
	* Returns the s p mail templates before and after the current s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param spMailTemplateId the primary key of the current s p mail template
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate[] findByProductTypeIdAndSubProductTypeIdAndTemplateName_PrevAndNext(
		long spMailTemplateId, long productTypeId, long subProductTypeId,
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateName_PrevAndNext(spMailTemplateId,
			productTypeId, subProductTypeId, templateName, orderByComparator);
	}

	/**
	* Removes all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; from the database.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName);
	}

	/**
	* Returns the number of s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @return the number of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName);
	}

	/**
	* Returns all the s p mail templates where templateName = &#63;.
	*
	* @param templateName the template name
	* @return the matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByTemplateName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateName(templateName);
	}

	/**
	* Returns a range of all the s p mail templates where templateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateName the template name
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @return the range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByTemplateName(
		java.lang.String templateName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateName(templateName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail templates where templateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateName the template name
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByTemplateName(
		java.lang.String templateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateName(templateName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByTemplateName_First(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByTemplateName_First(templateName, orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByTemplateName_First(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateName_First(templateName, orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByTemplateName_Last(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByTemplateName_Last(templateName, orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where templateName = &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByTemplateName_Last(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateName_Last(templateName, orderByComparator);
	}

	/**
	* Returns the s p mail templates before and after the current s p mail template in the ordered set where templateName = &#63;.
	*
	* @param spMailTemplateId the primary key of the current s p mail template
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate[] findByTemplateName_PrevAndNext(
		long spMailTemplateId, java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByTemplateName_PrevAndNext(spMailTemplateId,
			templateName, orderByComparator);
	}

	/**
	* Removes all the s p mail templates where templateName = &#63; from the database.
	*
	* @param templateName the template name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateName(templateName);
	}

	/**
	* Returns the number of s p mail templates where templateName = &#63;.
	*
	* @param templateName the template name
	* @return the number of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateName(templateName);
	}

	/**
	* Returns the s p mail template where templateName = &#63; and versionNumber = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateException} if it could not be found.
	*
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByTemplateNameAndVersionNumber(
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByTemplateNameAndVersionNumber(templateName,
			versionNumber);
	}

	/**
	* Returns the s p mail template where templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByTemplateNameAndVersionNumber(
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateNameAndVersionNumber(templateName,
			versionNumber);
	}

	/**
	* Returns the s p mail template where templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param templateName the template name
	* @param versionNumber the version number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByTemplateNameAndVersionNumber(
		java.lang.String templateName, java.lang.String versionNumber,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateNameAndVersionNumber(templateName,
			versionNumber, retrieveFromCache);
	}

	/**
	* Removes the s p mail template where templateName = &#63; and versionNumber = &#63; from the database.
	*
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the s p mail template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate removeByTemplateNameAndVersionNumber(
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .removeByTemplateNameAndVersionNumber(templateName,
			versionNumber);
	}

	/**
	* Returns the number of s p mail templates where templateName = &#63; and versionNumber = &#63;.
	*
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the number of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateNameAndVersionNumber(
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTemplateNameAndVersionNumber(templateName,
			versionNumber);
	}

	/**
	* Returns the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateException} if it could not be found.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
			subProductTypeId, templateName, versionNumber);
	}

	/**
	* Returns the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
			subProductTypeId, templateName, versionNumber);
	}

	/**
	* Returns the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param versionNumber the version number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, java.lang.String versionNumber,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
			subProductTypeId, templateName, versionNumber, retrieveFromCache);
	}

	/**
	* Removes the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; from the database.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the s p mail template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate removeByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .removeByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
			subProductTypeId, templateName, versionNumber);
	}

	/**
	* Returns the number of s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63;.
	*
	* @param productTypeId the product type ID
	* @param subProductTypeId the sub product type ID
	* @param templateName the template name
	* @param versionNumber the version number
	* @return the number of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId,
		java.lang.String templateName, java.lang.String versionNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
			subProductTypeId, templateName, versionNumber);
	}

	/**
	* Returns all the s p mail templates where parentTempalteId = &#63;.
	*
	* @param parentTempalteId the parent tempalte ID
	* @return the matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByparentTempalteId(
		long parentTempalteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentTempalteId(parentTempalteId);
	}

	/**
	* Returns a range of all the s p mail templates where parentTempalteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTempalteId the parent tempalte ID
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @return the range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByparentTempalteId(
		long parentTempalteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentTempalteId(parentTempalteId, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail templates where parentTempalteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTempalteId the parent tempalte ID
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByparentTempalteId(
		long parentTempalteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentTempalteId(parentTempalteId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where parentTempalteId = &#63;.
	*
	* @param parentTempalteId the parent tempalte ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByparentTempalteId_First(
		long parentTempalteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByparentTempalteId_First(parentTempalteId,
			orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where parentTempalteId = &#63;.
	*
	* @param parentTempalteId the parent tempalte ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByparentTempalteId_First(
		long parentTempalteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentTempalteId_First(parentTempalteId,
			orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where parentTempalteId = &#63;.
	*
	* @param parentTempalteId the parent tempalte ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByparentTempalteId_Last(
		long parentTempalteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByparentTempalteId_Last(parentTempalteId,
			orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where parentTempalteId = &#63;.
	*
	* @param parentTempalteId the parent tempalte ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByparentTempalteId_Last(
		long parentTempalteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentTempalteId_Last(parentTempalteId,
			orderByComparator);
	}

	/**
	* Returns the s p mail templates before and after the current s p mail template in the ordered set where parentTempalteId = &#63;.
	*
	* @param spMailTemplateId the primary key of the current s p mail template
	* @param parentTempalteId the parent tempalte ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate[] findByparentTempalteId_PrevAndNext(
		long spMailTemplateId, long parentTempalteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findByparentTempalteId_PrevAndNext(spMailTemplateId,
			parentTempalteId, orderByComparator);
	}

	/**
	* Removes all the s p mail templates where parentTempalteId = &#63; from the database.
	*
	* @param parentTempalteId the parent tempalte ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentTempalteId(long parentTempalteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByparentTempalteId(parentTempalteId);
	}

	/**
	* Returns the number of s p mail templates where parentTempalteId = &#63;.
	*
	* @param parentTempalteId the parent tempalte ID
	* @return the number of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentTempalteId(long parentTempalteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByparentTempalteId(parentTempalteId);
	}

	/**
	* Returns all the s p mail templates where status = &#63;.
	*
	* @param status the status
	* @return the matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findBystatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the s p mail templates where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @return the range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail templates where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first s p mail template in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchBystatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last s p mail template in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchBystatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the s p mail templates before and after the current s p mail template in the ordered set where status = &#63;.
	*
	* @param spMailTemplateId the primary key of the current s p mail template
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate[] findBystatus_PrevAndNext(
		long spMailTemplateId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence()
				   .findBystatus_PrevAndNext(spMailTemplateId, status,
			orderByComparator);
	}

	/**
	* Removes all the s p mail templates where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of s p mail templates where status = &#63;.
	*
	* @param status the status
	* @return the number of matching s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Caches the s p mail template in the entity cache if it is enabled.
	*
	* @param spMailTemplate the s p mail template
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate) {
		getPersistence().cacheResult(spMailTemplate);
	}

	/**
	* Caches the s p mail templates in the entity cache if it is enabled.
	*
	* @param spMailTemplates the s p mail templates
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> spMailTemplates) {
		getPersistence().cacheResult(spMailTemplates);
	}

	/**
	* Creates a new s p mail template with the primary key. Does not add the s p mail template to the database.
	*
	* @param spMailTemplateId the primary key for the new s p mail template
	* @return the new s p mail template
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate create(
		long spMailTemplateId) {
		return getPersistence().create(spMailTemplateId);
	}

	/**
	* Removes the s p mail template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplateId the primary key of the s p mail template
	* @return the s p mail template that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate remove(
		long spMailTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence().remove(spMailTemplateId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailTemplate updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailTemplate);
	}

	/**
	* Returns the s p mail template with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateException} if it could not be found.
	*
	* @param spMailTemplateId the primary key of the s p mail template
	* @return the s p mail template
	* @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate findByPrimaryKey(
		long spMailTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchTemplateException {
		return getPersistence().findByPrimaryKey(spMailTemplateId);
	}

	/**
	* Returns the s p mail template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailTemplateId the primary key of the s p mail template
	* @return the s p mail template, or <code>null</code> if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailTemplate fetchByPrimaryKey(
		long spMailTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMailTemplateId);
	}

	/**
	* Returns all the s p mail templates.
	*
	* @return the s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p mail templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @return the range of s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p mail templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail templates.
	*
	* @return the number of s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailTemplatePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailTemplatePersistence persistence) {
	}

	private static SPMailTemplatePersistence _persistence;
}