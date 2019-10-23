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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPSite. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.SPSiteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPSiteLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.SPSiteLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.SPSiteLocalServiceImpl
 * @generated
 */
public class SPSiteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.SPSiteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p site to the database. Also notifies the appropriate model listeners.
	*
	* @param spSite the s p site
	* @return the s p site that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite addSPSite(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPSite(spSite);
	}

	/**
	* Creates a new s p site with the primary key. Does not add the s p site to the database.
	*
	* @param spSiteId the primary key for the new s p site
	* @return the new s p site
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite createSPSite(
		long spSiteId) {
		return getService().createSPSite(spSiteId);
	}

	/**
	* Deletes the s p site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site that was removed
	* @throws PortalException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite deleteSPSite(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSite(spSiteId);
	}

	/**
	* Deletes the s p site from the database. Also notifies the appropriate model listeners.
	*
	* @param spSite the s p site
	* @return the s p site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite deleteSPSite(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSite(spSite);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.SPSite fetchSPSite(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPSite(spSiteId);
	}

	/**
	* Returns the s p site with the matching UUID and company.
	*
	* @param uuid the s p site's UUID
	* @param companyId the primary key of the company
	* @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite fetchSPSiteByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPSiteByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p site matching the UUID and group.
	*
	* @param uuid the s p site's UUID
	* @param groupId the primary key of the group
	* @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite fetchSPSiteByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPSiteByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p site with the primary key.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site
	* @throws PortalException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite getSPSite(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSite(spSiteId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p site with the matching UUID and company.
	*
	* @param uuid the s p site's UUID
	* @param companyId the primary key of the company
	* @return the matching s p site
	* @throws PortalException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite getSPSiteByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSiteByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p site matching the UUID and group.
	*
	* @param uuid the s p site's UUID
	* @param groupId the primary key of the group
	* @return the matching s p site
	* @throws PortalException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite getSPSiteByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSiteByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of s p sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> getSPSites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSites(start, end);
	}

	/**
	* Returns the number of s p sites.
	*
	* @return the number of s p sites
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPSitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSitesCount();
	}

	/**
	* Updates the s p site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSite the s p site
	* @return the s p site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPSite updateSPSite(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPSite(spSite);
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

	public static void addOrUpdateSPSiteUser(long companyId, long groupId,
		long authAccessId, long userId, long layoutSetId, long virtualHostId,
		java.lang.String loginType, java.lang.String plainPassword,
		java.lang.String encryptedPassword) {
		getService()
			.addOrUpdateSPSiteUser(companyId, groupId, authAccessId, userId,
			layoutSetId, virtualHostId, loginType, plainPassword,
			encryptedPassword);
	}

	public static void addOrUpdateSPSiteUser(long companyId, long groupId,
		long authAccessId, long userId, long layoutSetId, long virtualHostId,
		java.lang.String loginType, java.lang.String plainPassword,
		java.lang.String encryptedPassword, long userTypeId) {
		getService()
			.addOrUpdateSPSiteUser(companyId, groupId, authAccessId, userId,
			layoutSetId, virtualHostId, loginType, plainPassword,
			encryptedPassword, userTypeId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndVirtualHostId(
		long userId, long virtualHostId) {
		return getService().findByUserIdAndVirtualHostId(userId, virtualHostId);
	}

	public static boolean hasExistingDomainEntry(long userId, long virtualHostId) {
		return getService().hasExistingDomainEntry(userId, virtualHostId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndAuthAccessId(
		long userId, long authAccessId) {
		return getService().findByUserIdAndAuthAccessId(userId, authAccessId);
	}

	public static boolean hasExistingAuthAccessEntry(long userId,
		long authAccessId) {
		return getService().hasExistingAuthAccessEntry(userId, authAccessId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserId(
		long userId) {
		return getService().findByUserId(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPSiteLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPSiteLocalService.class.getName());

			if (invokableLocalService instanceof SPSiteLocalService) {
				_service = (SPSiteLocalService)invokableLocalService;
			}
			else {
				_service = new SPSiteLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPSiteLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPSiteLocalService service) {
	}

	private static SPSiteLocalService _service;
}