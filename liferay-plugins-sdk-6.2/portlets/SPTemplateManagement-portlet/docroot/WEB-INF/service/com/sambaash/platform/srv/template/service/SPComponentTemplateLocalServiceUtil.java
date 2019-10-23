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

package com.sambaash.platform.srv.template.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPComponentTemplate. This utility wraps
 * {@link com.sambaash.platform.srv.template.service.impl.SPComponentTemplateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author WattabyteIT
 * @see SPComponentTemplateLocalService
 * @see com.sambaash.platform.srv.template.service.base.SPComponentTemplateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.template.service.impl.SPComponentTemplateLocalServiceImpl
 * @generated
 */
public class SPComponentTemplateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.template.service.impl.SPComponentTemplateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p component template to the database. Also notifies the appropriate model listeners.
	*
	* @param spComponentTemplate the s p component template
	* @return the s p component template that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate addSPComponentTemplate(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPComponentTemplate(spComponentTemplate);
	}

	/**
	* Creates a new s p component template with the primary key. Does not add the s p component template to the database.
	*
	* @param spComponentTemplateId the primary key for the new s p component template
	* @return the new s p component template
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate createSPComponentTemplate(
		long spComponentTemplateId) {
		return getService().createSPComponentTemplate(spComponentTemplateId);
	}

	/**
	* Deletes the s p component template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spComponentTemplateId the primary key of the s p component template
	* @return the s p component template that was removed
	* @throws PortalException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate deleteSPComponentTemplate(
		long spComponentTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPComponentTemplate(spComponentTemplateId);
	}

	/**
	* Deletes the s p component template from the database. Also notifies the appropriate model listeners.
	*
	* @param spComponentTemplate the s p component template
	* @return the s p component template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate deleteSPComponentTemplate(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPComponentTemplate(spComponentTemplate);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchSPComponentTemplate(
		long spComponentTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPComponentTemplate(spComponentTemplateId);
	}

	/**
	* Returns the s p component template with the matching UUID and company.
	*
	* @param uuid the s p component template's UUID
	* @param companyId the primary key of the company
	* @return the matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchSPComponentTemplateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSPComponentTemplateByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p component template matching the UUID and group.
	*
	* @param uuid the s p component template's UUID
	* @param groupId the primary key of the group
	* @return the matching s p component template, or <code>null</code> if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate fetchSPComponentTemplateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSPComponentTemplateByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p component template with the primary key.
	*
	* @param spComponentTemplateId the primary key of the s p component template
	* @return the s p component template
	* @throws PortalException if a s p component template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate getSPComponentTemplate(
		long spComponentTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPComponentTemplate(spComponentTemplateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p component template with the matching UUID and company.
	*
	* @param uuid the s p component template's UUID
	* @param companyId the primary key of the company
	* @return the matching s p component template
	* @throws PortalException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate getSPComponentTemplateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSPComponentTemplateByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p component template matching the UUID and group.
	*
	* @param uuid the s p component template's UUID
	* @param groupId the primary key of the group
	* @return the matching s p component template
	* @throws PortalException if a matching s p component template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate getSPComponentTemplateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPComponentTemplateByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.sambaash.platform.srv.template.model.SPComponentTemplate> getSPComponentTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPComponentTemplates(start, end);
	}

	/**
	* Returns the number of s p component templates.
	*
	* @return the number of s p component templates
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPComponentTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPComponentTemplatesCount();
	}

	/**
	* Updates the s p component template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spComponentTemplate the s p component template
	* @return the s p component template that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.template.model.SPComponentTemplate updateSPComponentTemplate(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPComponentTemplate(spComponentTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void deleteTemplateComponentsByTemplateId(long spTemplateId) {
		getService().deleteTemplateComponentsByTemplateId(spTemplateId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPComponentTemplateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPComponentTemplateLocalService.class.getName());

			if (invokableLocalService instanceof SPComponentTemplateLocalService) {
				_service = (SPComponentTemplateLocalService)invokableLocalService;
			}
			else {
				_service = new SPComponentTemplateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPComponentTemplateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPComponentTemplateLocalService service) {
	}

	private static SPComponentTemplateLocalService _service;
}