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
 * Provides the local service utility for Agency. This utility wraps
 * {@link com.sambaash.platform.srv.legalandcontract.service.impl.AgencyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see AgencyLocalService
 * @see com.sambaash.platform.srv.legalandcontract.service.base.AgencyLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.impl.AgencyLocalServiceImpl
 * @generated
 */
public class AgencyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.legalandcontract.service.impl.AgencyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the agency to the database. Also notifies the appropriate model listeners.
	*
	* @param agency the agency
	* @return the agency that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency addAgency(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAgency(agency);
	}

	/**
	* Creates a new agency with the primary key. Does not add the agency to the database.
	*
	* @param spAgencyId the primary key for the new agency
	* @return the new agency
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency createAgency(
		long spAgencyId) {
		return getService().createAgency(spAgencyId);
	}

	/**
	* Deletes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency that was removed
	* @throws PortalException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency deleteAgency(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAgency(spAgencyId);
	}

	/**
	* Deletes the agency from the database. Also notifies the appropriate model listeners.
	*
	* @param agency the agency
	* @return the agency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency deleteAgency(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAgency(agency);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchAgency(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAgency(spAgencyId);
	}

	/**
	* Returns the agency with the matching UUID and company.
	*
	* @param uuid the agency's UUID
	* @param companyId the primary key of the company
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchAgencyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAgencyByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the agency matching the UUID and group.
	*
	* @param uuid the agency's UUID
	* @param groupId the primary key of the group
	* @return the matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency fetchAgencyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAgencyByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the agency with the primary key.
	*
	* @param spAgencyId the primary key of the agency
	* @return the agency
	* @throws PortalException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency getAgency(
		long spAgencyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAgency(spAgencyId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the agency with the matching UUID and company.
	*
	* @param uuid the agency's UUID
	* @param companyId the primary key of the company
	* @return the matching agency
	* @throws PortalException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency getAgencyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAgencyByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the agency matching the UUID and group.
	*
	* @param uuid the agency's UUID
	* @param groupId the primary key of the group
	* @return the matching agency
	* @throws PortalException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency getAgencyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAgencyByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the agencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of agencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.Agency> getAgencies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAgencies(start, end);
	}

	/**
	* Returns the number of agencies.
	*
	* @return the number of agencies
	* @throws SystemException if a system exception occurred
	*/
	public static int getAgenciesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAgenciesCount();
	}

	/**
	* Updates the agency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param agency the agency
	* @return the agency that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.Agency updateAgency(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAgency(agency);
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

	public static void addAgency(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency agency,
		long[] assetCategoryIds) throws java.lang.Exception {
		getService().addAgency(userId, agency, assetCategoryIds);
	}

	public static void addNewAgencyVersion(long userId, long oldAgencyId,
		com.sambaash.platform.srv.legalandcontract.model.Agency newAgency,
		long[] assetCategoryIds) throws java.lang.Exception {
		getService()
			.addNewAgencyVersion(userId, oldAgencyId, newAgency,
			assetCategoryIds);
	}

	public static void addNewAgencyVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency oldAgency,
		com.sambaash.platform.srv.legalandcontract.model.Agency newAgency,
		long[] assetCategoryIds) throws java.lang.Exception {
		getService()
			.addNewAgencyVersion(userId, oldAgency, newAgency, assetCategoryIds);
	}

	public static void addNewAgency(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency agency,
		long[] assetCategoryIds) throws java.lang.Exception {
		getService().addNewAgency(userId, agency, assetCategoryIds);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Agency getNewAgency()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewAgency();
	}

	public static void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Agency agency,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, agency, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Agency findByNumberCountry(
		java.lang.String number, java.lang.String country) {
		return getService().findByNumberCountry(number, country);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Agency getLatestAgencyByNumberCountry(
		java.lang.String number, java.lang.String country) {
		return getService().getLatestAgencyByNumberCountry(number, country);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.Agency getLatestAgencyByNameCountry(
		java.lang.String name, java.lang.String country) {
		return getService().getLatestAgencyByNameCountry(name, country);
	}

	/**
	* @param number
	* @param country
	* @return
	*/
	public static java.util.List<java.lang.Object[]> getLatestAgencyIdAndVersionNumber(
		java.lang.String number, java.lang.String country) {
		return getService().getLatestAgencyIdAndVersionNumber(number, country);
	}

	public static void clearService() {
		_service = null;
	}

	public static AgencyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AgencyLocalService.class.getName());

			if (invokableLocalService instanceof AgencyLocalService) {
				_service = (AgencyLocalService)invokableLocalService;
			}
			else {
				_service = new AgencyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AgencyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AgencyLocalService service) {
	}

	private static AgencyLocalService _service;
}