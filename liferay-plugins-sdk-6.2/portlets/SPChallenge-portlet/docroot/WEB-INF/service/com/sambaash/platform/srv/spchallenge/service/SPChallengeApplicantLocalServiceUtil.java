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

package com.sambaash.platform.srv.spchallenge.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPChallengeApplicant. This utility wraps
 * {@link com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeApplicantLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPChallengeApplicantLocalService
 * @see com.sambaash.platform.srv.spchallenge.service.base.SPChallengeApplicantLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeApplicantLocalServiceImpl
 * @generated
 */
public class SPChallengeApplicantLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeApplicantLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p challenge applicant to the database. Also notifies the appropriate model listeners.
	*
	* @param spChallengeApplicant the s p challenge applicant
	* @return the s p challenge applicant that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant addSPChallengeApplicant(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPChallengeApplicant(spChallengeApplicant);
	}

	/**
	* Creates a new s p challenge applicant with the primary key. Does not add the s p challenge applicant to the database.
	*
	* @param spChallengeApplicantId the primary key for the new s p challenge applicant
	* @return the new s p challenge applicant
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant createSPChallengeApplicant(
		long spChallengeApplicantId) {
		return getService().createSPChallengeApplicant(spChallengeApplicantId);
	}

	/**
	* Deletes the s p challenge applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant that was removed
	* @throws PortalException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant deleteSPChallengeApplicant(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPChallengeApplicant(spChallengeApplicantId);
	}

	/**
	* Deletes the s p challenge applicant from the database. Also notifies the appropriate model listeners.
	*
	* @param spChallengeApplicant the s p challenge applicant
	* @return the s p challenge applicant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant deleteSPChallengeApplicant(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPChallengeApplicant(spChallengeApplicant);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchSPChallengeApplicant(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPChallengeApplicant(spChallengeApplicantId);
	}

	/**
	* Returns the s p challenge applicant with the matching UUID and company.
	*
	* @param uuid the s p challenge applicant's UUID
	* @param companyId the primary key of the company
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchSPChallengeApplicantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSPChallengeApplicantByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p challenge applicant matching the UUID and group.
	*
	* @param uuid the s p challenge applicant's UUID
	* @param groupId the primary key of the group
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchSPChallengeApplicantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSPChallengeApplicantByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p challenge applicant with the primary key.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant
	* @throws PortalException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant getSPChallengeApplicant(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallengeApplicant(spChallengeApplicantId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p challenge applicant with the matching UUID and company.
	*
	* @param uuid the s p challenge applicant's UUID
	* @param companyId the primary key of the company
	* @return the matching s p challenge applicant
	* @throws PortalException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant getSPChallengeApplicantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSPChallengeApplicantByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p challenge applicant matching the UUID and group.
	*
	* @param uuid the s p challenge applicant's UUID
	* @param groupId the primary key of the group
	* @return the matching s p challenge applicant
	* @throws PortalException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant getSPChallengeApplicantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSPChallengeApplicantByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p challenge applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> getSPChallengeApplicants(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallengeApplicants(start, end);
	}

	/**
	* Returns the number of s p challenge applicants.
	*
	* @return the number of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPChallengeApplicantsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallengeApplicantsCount();
	}

	/**
	* Updates the s p challenge applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spChallengeApplicant the s p challenge applicant
	* @return the s p challenge applicant that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant updateSPChallengeApplicant(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPChallengeApplicant(spChallengeApplicant);
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

	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByApplicantRefId(applicantRefId);
	}

	public static void updateAssets(long userId,
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant applicant,
		long[] assetCategoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateAssets(userId, applicant, assetCategoryIds);
	}

	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallenge> getAppliedChallenges(
		long orgId) {
		return getService().getAppliedChallenges(orgId);
	}

	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId) {
		return getService().findBySPChallengeId(spChallengeId);
	}

	public static com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId) {
		return getService()
				   .findByChallengeIdApplicantRefId(spChallengeId,
			applicantRefId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPChallengeApplicantLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPChallengeApplicantLocalService.class.getName());

			if (invokableLocalService instanceof SPChallengeApplicantLocalService) {
				_service = (SPChallengeApplicantLocalService)invokableLocalService;
			}
			else {
				_service = new SPChallengeApplicantLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPChallengeApplicantLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPChallengeApplicantLocalService service) {
	}

	private static SPChallengeApplicantLocalService _service;
}