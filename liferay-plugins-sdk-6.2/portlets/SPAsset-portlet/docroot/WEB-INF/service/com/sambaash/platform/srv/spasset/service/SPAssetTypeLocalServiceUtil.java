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

package com.sambaash.platform.srv.spasset.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPAssetType. This utility wraps
 * {@link com.sambaash.platform.srv.spasset.service.impl.SPAssetTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see SPAssetTypeLocalService
 * @see com.sambaash.platform.srv.spasset.service.base.SPAssetTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spasset.service.impl.SPAssetTypeLocalServiceImpl
 * @generated
 */
public class SPAssetTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spasset.service.impl.SPAssetTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p asset type to the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetType the s p asset type
	* @return the s p asset type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetType addSPAssetType(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPAssetType(spAssetType);
	}

	/**
	* Creates a new s p asset type with the primary key. Does not add the s p asset type to the database.
	*
	* @param spAssetTypeId the primary key for the new s p asset type
	* @return the new s p asset type
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetType createSPAssetType(
		long spAssetTypeId) {
		return getService().createSPAssetType(spAssetTypeId);
	}

	/**
	* Deletes the s p asset type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetTypeId the primary key of the s p asset type
	* @return the s p asset type that was removed
	* @throws PortalException if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetType deleteSPAssetType(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPAssetType(spAssetTypeId);
	}

	/**
	* Deletes the s p asset type from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetType the s p asset type
	* @return the s p asset type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetType deleteSPAssetType(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPAssetType(spAssetType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spasset.model.SPAssetType fetchSPAssetType(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPAssetType(spAssetTypeId);
	}

	/**
	* Returns the s p asset type with the primary key.
	*
	* @param spAssetTypeId the primary key of the s p asset type
	* @return the s p asset type
	* @throws PortalException if a s p asset type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetType getSPAssetType(
		long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPAssetType(spAssetTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p asset types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p asset types
	* @param end the upper bound of the range of s p asset types (not inclusive)
	* @return the range of s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> getSPAssetTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPAssetTypes(start, end);
	}

	/**
	* Returns the number of s p asset types.
	*
	* @return the number of s p asset types
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPAssetTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPAssetTypesCount();
	}

	/**
	* Updates the s p asset type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spAssetType the s p asset type
	* @return the s p asset type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spasset.model.SPAssetType updateSPAssetType(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPAssetType(spAssetType);
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

	public static com.sambaash.platform.srv.spasset.model.SPAssetType addSPAssetType(
		long userId, long groupId, long companyId,
		java.lang.String spAssetTypeName, boolean status,
		java.lang.String spAssetTypeCreateUrl,
		java.lang.String spAssetTypeDetailUrl,
		java.lang.String spAssetTypeInnerDetailUrl, boolean requiredTermsOfUse,
		boolean requiredLogin, boolean categoryMandatory,
		boolean notifyUponCreation, long notificationTemplateId,
		java.lang.String allowedFileTypes, int maxFileSize, int minImageHeight,
		int minImageWidth,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSPAssetType(userId, groupId, companyId, spAssetTypeName,
			status, spAssetTypeCreateUrl, spAssetTypeDetailUrl,
			spAssetTypeInnerDetailUrl, requiredTermsOfUse, requiredLogin,
			categoryMandatory, notifyUponCreation, notificationTemplateId,
			allowedFileTypes, maxFileSize, minImageHeight, minImageWidth,
			serviceContext);
	}

	public static com.sambaash.platform.srv.spasset.model.SPAssetType updateSPAssetType(
		long spAssetTypeId, long userId, long groupId, long companyId,
		java.lang.String spAssetTypeName, boolean status,
		java.lang.String spAssetTypeCreateUrl,
		java.lang.String spAssetTypeDetailUrl,
		java.lang.String spAssetTypeInnerDetailUrl, boolean requiredTermsOfUse,
		boolean requiredLogin, boolean categoryMandatory,
		boolean notifyUponCreation, long notificationTemplateId,
		java.lang.String allowedFileTypes, int maxFileSize, int minImageHeight,
		int minImageWidth,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSPAssetType(spAssetTypeId, userId, groupId,
			companyId, spAssetTypeName, status, spAssetTypeCreateUrl,
			spAssetTypeDetailUrl, spAssetTypeInnerDetailUrl,
			requiredTermsOfUse, requiredLogin, categoryMandatory,
			notifyUponCreation, notificationTemplateId, allowedFileTypes,
			maxFileSize, minImageHeight, minImageWidth, serviceContext);
	}

	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId);
	}

	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByGroupId(
		long groupId, int startIndex, int endIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId, startIndex, endIndex);
	}

	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByStatus()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus();
	}

	public static java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetType> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus(status);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPAssetTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPAssetTypeLocalService.class.getName());

			if (invokableLocalService instanceof SPAssetTypeLocalService) {
				_service = (SPAssetTypeLocalService)invokableLocalService;
			}
			else {
				_service = new SPAssetTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPAssetTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPAssetTypeLocalService service) {
	}

	private static SPAssetTypeLocalService _service;
}