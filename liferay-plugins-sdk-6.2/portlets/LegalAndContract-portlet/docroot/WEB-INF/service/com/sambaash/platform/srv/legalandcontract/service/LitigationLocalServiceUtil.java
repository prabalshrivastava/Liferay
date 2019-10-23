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

package com.sambaash.platform.srv.legalandcontract.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Litigation. This utility wraps
 * {@link com.sambaash.platform.srv.legalandcontract.service.impl.LitigationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see LitigationLocalService
 * @see com.sambaash.platform.srv.legalandcontract.service.base.LitigationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.impl.LitigationLocalServiceImpl
 * @generated
 */
public class LitigationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.legalandcontract.service.impl.LitigationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the litigation to the database. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation addLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLitigation(litigation);
	}

	/**
	* Creates a new litigation with the primary key. Does not add the litigation to the database.
	*
	* @param spLitigationId the primary key for the new litigation
	* @return the new litigation
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation createLitigation(
		long spLitigationId) {
		return getService().createLitigation(spLitigationId);
	}

	/**
	* Deletes the litigation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation that was removed
	* @throws PortalException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation deleteLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLitigation(spLitigationId);
	}

	/**
	* Deletes the litigation from the database. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation deleteLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLitigation(litigation);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLitigation(spLitigationId);
	}

	/**
	* Returns the litigation with the matching UUID and company.
	*
	* @param uuid the litigation's UUID
	* @param companyId the primary key of the company
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLitigationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the litigation matching the UUID and group.
	*
	* @param uuid the litigation's UUID
	* @param groupId the primary key of the group
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLitigationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the litigation with the primary key.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation
	* @throws PortalException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLitigation(spLitigationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the litigation with the matching UUID and company.
	*
	* @param uuid the litigation's UUID
	* @param companyId the primary key of the company
	* @return the matching litigation
	* @throws PortalException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLitigationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the litigation matching the UUID and group.
	*
	* @param uuid the litigation's UUID
	* @param groupId the primary key of the group
	* @return the matching litigation
	* @throws PortalException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLitigationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the litigations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @return the range of litigations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> getLitigations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLitigations(start, end);
	}

	/**
	* Returns the number of litigations.
	*
	* @return the number of litigations
	* @throws SystemException if a system exception occurred
	*/
	public static int getLitigationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLitigationsCount();
	}

	/**
	* Updates the litigation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Litigation updateLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLitigation(litigation);
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

	public static void addNewLitigationVersion(long userId,
		long oldLitigationId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation newLitigation,
		long[] assetCategoryIds) {
		getService()
			.addNewLitigationVersion(userId, oldLitigationId, newLitigation,
			assetCategoryIds);
	}

	public static void addNewLitigationVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation oldLitigation,
		com.sambaash.platform.srv.legalandcontract.model.Litigation newLitigation,
		long[] assetCategoryIds) {
		getService()
			.addNewLitigationVersion(userId, oldLitigation, newLitigation,
			assetCategoryIds);
	}

	public static void addNewLitigation(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds) {
		getService().addNewLitigation(userId, litigation, assetCategoryIds);
	}

	public static void reIndex(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation) {
		getService().reIndex(litigation);
	}

	public static void reIndexTrademark(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks) {
		getService().reIndexTrademark(trademarks);
	}

	public static void addLitigation(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds) throws java.lang.Exception {
		getService().addLitigation(userId, litigation, assetCategoryIds);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Litigation getNewLitigation()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewLitigation();
	}

	public static void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, litigation, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static java.util.List<java.lang.Object[]> getLatestLitigation(
		long rootLitigationId) {
		return getService().getLatestLitigation(rootLitigationId);
	}

	/**
	* @param trademarkId
	* @param country
	* @return
	*/
	public static java.util.List<java.lang.Object[]> getLatestLitigationsByTrademarkId(
		long trademarkId) {
		return getService().getLatestLitigationsByTrademarkId(trademarkId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LitigationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LitigationLocalService.class.getName());

			if (invokableLocalService instanceof LitigationLocalService) {
				_service = (LitigationLocalService)invokableLocalService;
			}
			else {
				_service = new LitigationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LitigationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LitigationLocalService service) {
	}

	private static LitigationLocalService _service;
}