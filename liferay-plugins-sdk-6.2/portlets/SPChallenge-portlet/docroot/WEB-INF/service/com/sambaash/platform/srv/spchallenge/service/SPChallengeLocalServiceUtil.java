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
 * Provides the local service utility for SPChallenge. This utility wraps
 * {@link com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPChallengeLocalService
 * @see com.sambaash.platform.srv.spchallenge.service.base.SPChallengeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeLocalServiceImpl
 * @generated
 */
public class SPChallengeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p challenge to the database. Also notifies the appropriate model listeners.
	*
	* @param spChallenge the s p challenge
	* @return the s p challenge that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge addSPChallenge(
		com.sambaash.platform.srv.spchallenge.model.SPChallenge spChallenge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPChallenge(spChallenge);
	}

	/**
	* Creates a new s p challenge with the primary key. Does not add the s p challenge to the database.
	*
	* @param spChallengeId the primary key for the new s p challenge
	* @return the new s p challenge
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge createSPChallenge(
		long spChallengeId) {
		return getService().createSPChallenge(spChallengeId);
	}

	/**
	* Deletes the s p challenge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spChallengeId the primary key of the s p challenge
	* @return the s p challenge that was removed
	* @throws PortalException if a s p challenge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge deleteSPChallenge(
		long spChallengeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPChallenge(spChallengeId);
	}

	/**
	* Deletes the s p challenge from the database. Also notifies the appropriate model listeners.
	*
	* @param spChallenge the s p challenge
	* @return the s p challenge that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge deleteSPChallenge(
		com.sambaash.platform.srv.spchallenge.model.SPChallenge spChallenge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPChallenge(spChallenge);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge fetchSPChallenge(
		long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPChallenge(spChallengeId);
	}

	/**
	* Returns the s p challenge with the matching UUID and company.
	*
	* @param uuid the s p challenge's UUID
	* @param companyId the primary key of the company
	* @return the matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge fetchSPChallengeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPChallengeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p challenge matching the UUID and group.
	*
	* @param uuid the s p challenge's UUID
	* @param groupId the primary key of the group
	* @return the matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge fetchSPChallengeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPChallengeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p challenge with the primary key.
	*
	* @param spChallengeId the primary key of the s p challenge
	* @return the s p challenge
	* @throws PortalException if a s p challenge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge getSPChallenge(
		long spChallengeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallenge(spChallengeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p challenge with the matching UUID and company.
	*
	* @param uuid the s p challenge's UUID
	* @param companyId the primary key of the company
	* @return the matching s p challenge
	* @throws PortalException if a matching s p challenge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge getSPChallengeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallengeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p challenge matching the UUID and group.
	*
	* @param uuid the s p challenge's UUID
	* @param groupId the primary key of the group
	* @return the matching s p challenge
	* @throws PortalException if a matching s p challenge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge getSPChallengeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallengeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p challenges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p challenges
	* @param end the upper bound of the range of s p challenges (not inclusive)
	* @return the range of s p challenges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallenge> getSPChallenges(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallenges(start, end);
	}

	/**
	* Returns the number of s p challenges.
	*
	* @return the number of s p challenges
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPChallengesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPChallengesCount();
	}

	/**
	* Updates the s p challenge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spChallenge the s p challenge
	* @return the s p challenge that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spchallenge.model.SPChallenge updateSPChallenge(
		com.sambaash.platform.srv.spchallenge.model.SPChallenge spChallenge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPChallenge(spChallenge);
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

	public static void updateAssets(long userId,
		com.sambaash.platform.srv.spchallenge.model.SPChallenge challenge,
		long[] assetCategoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateAssets(userId, challenge, assetCategoryIds);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> getChallenges(
		javax.portlet.PortletRequest request, long companyId, int start,
		int end, java.lang.String query, boolean activeOnly) {
		return getService()
				   .getChallenges(request, companyId, start, end, query,
			activeOnly);
	}

	public static com.liferay.portal.kernel.search.Hits searchChallenges(
		javax.portlet.PortletRequest request, long companyId, int start,
		int end, java.lang.String query, boolean includeDateCheck) {
		return getService()
				   .searchChallenges(request, companyId, start, end, query,
			includeDateCheck);
	}

	public static com.liferay.portal.kernel.search.Hits searchChallenges(
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().searchChallenges(searchContext);
	}

	public static java.lang.String displayChallengeFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long challengeId) {
		return getService()
				   .displayChallengeFriendlyURL(themeDisplay, challengeId);
	}

	public static java.lang.String applyChallengeFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long challengeId,
		boolean external) {
		return getService()
				   .applyChallengeFriendlyURL(themeDisplay, challengeId,
			external);
	}

	public static java.lang.String editChallengeFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long challengeId) {
		return getService().editChallengeFriendlyURL(themeDisplay, challengeId);
	}

	public static java.lang.String addChallengeFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService().addChallengeFriendlyURL(themeDisplay);
	}

	public static void addAllChallengesToGraph() {
		getService().addAllChallengesToGraph();
	}

	public static boolean canUpdateChallenge(
		javax.portlet.PortletRequest request, long challengeId) {
		return getService().canUpdateChallenge(request, challengeId);
	}

	public static java.lang.String displayApplicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long applicantId) {
		return getService()
				   .displayApplicationFriendlyURL(themeDisplay, applicantId);
	}

	public static java.lang.String editApplicationFriendlyURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long applicantId) {
		return getService().editApplicationFriendlyURL(themeDisplay, applicantId);
	}

	public static java.lang.String getChallengesPath() {
		return getService().getChallengesPath();
	}

	public static void clearService() {
		_service = null;
	}

	public static SPChallengeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPChallengeLocalService.class.getName());

			if (invokableLocalService instanceof SPChallengeLocalService) {
				_service = (SPChallengeLocalService)invokableLocalService;
			}
			else {
				_service = new SPChallengeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPChallengeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPChallengeLocalService service) {
	}

	private static SPChallengeLocalService _service;
}