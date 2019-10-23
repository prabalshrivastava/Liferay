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

package com.sambaash.platform.srv.spsocialprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialProfileDetailLocalService}.
 *
 * @author gauravvijayvergia
 * @see SocialProfileDetailLocalService
 * @generated
 */
public class SocialProfileDetailLocalServiceWrapper
	implements SocialProfileDetailLocalService,
		ServiceWrapper<SocialProfileDetailLocalService> {
	public SocialProfileDetailLocalServiceWrapper(
		SocialProfileDetailLocalService socialProfileDetailLocalService) {
		_socialProfileDetailLocalService = socialProfileDetailLocalService;
	}

	/**
	* Adds the social profile detail to the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileDetail the social profile detail
	* @return the social profile detail that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail addSocialProfileDetail(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.addSocialProfileDetail(socialProfileDetail);
	}

	/**
	* Creates a new social profile detail with the primary key. Does not add the social profile detail to the database.
	*
	* @param socialProfileDetailId the primary key for the new social profile detail
	* @return the new social profile detail
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail createSocialProfileDetail(
		long socialProfileDetailId) {
		return _socialProfileDetailLocalService.createSocialProfileDetail(socialProfileDetailId);
	}

	/**
	* Deletes the social profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileDetailId the primary key of the social profile detail
	* @return the social profile detail that was removed
	* @throws PortalException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail deleteSocialProfileDetail(
		long socialProfileDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.deleteSocialProfileDetail(socialProfileDetailId);
	}

	/**
	* Deletes the social profile detail from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileDetail the social profile detail
	* @return the social profile detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail deleteSocialProfileDetail(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.deleteSocialProfileDetail(socialProfileDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialProfileDetailLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchSocialProfileDetail(
		long socialProfileDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.fetchSocialProfileDetail(socialProfileDetailId);
	}

	/**
	* Returns the social profile detail with the matching UUID and company.
	*
	* @param uuid the social profile detail's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchSocialProfileDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.fetchSocialProfileDetailByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the social profile detail matching the UUID and group.
	*
	* @param uuid the social profile detail's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchSocialProfileDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.fetchSocialProfileDetailByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the social profile detail with the primary key.
	*
	* @param socialProfileDetailId the primary key of the social profile detail
	* @return the social profile detail
	* @throws PortalException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail getSocialProfileDetail(
		long socialProfileDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.getSocialProfileDetail(socialProfileDetailId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the social profile detail with the matching UUID and company.
	*
	* @param uuid the social profile detail's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile detail
	* @throws PortalException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail getSocialProfileDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.getSocialProfileDetailByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the social profile detail matching the UUID and group.
	*
	* @param uuid the social profile detail's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile detail
	* @throws PortalException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail getSocialProfileDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.getSocialProfileDetailByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the social profile details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @return the range of social profile details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> getSocialProfileDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.getSocialProfileDetails(start,
			end);
	}

	/**
	* Returns the number of social profile details.
	*
	* @return the number of social profile details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSocialProfileDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.getSocialProfileDetailsCount();
	}

	/**
	* Updates the social profile detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialProfileDetail the social profile detail
	* @return the social profile detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail updateSocialProfileDetail(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.updateSocialProfileDetail(socialProfileDetail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _socialProfileDetailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_socialProfileDetailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _socialProfileDetailLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.service.SocialProfileDetailLocalServiceUtil}
	* to access the social profile detail local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetailLocalService.findByUserId(userId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUserIdAndCompanyName(
		java.lang.String companyName, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException {
		return _socialProfileDetailLocalService.findByUserIdAndCompanyName(companyName,
			userId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUserIdAndUserJobId(
		java.lang.String userJobId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException {
		return _socialProfileDetailLocalService.findByUserIdAndUserJobId(userJobId,
			userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SocialProfileDetailLocalService getWrappedSocialProfileDetailLocalService() {
		return _socialProfileDetailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSocialProfileDetailLocalService(
		SocialProfileDetailLocalService socialProfileDetailLocalService) {
		_socialProfileDetailLocalService = socialProfileDetailLocalService;
	}

	@Override
	public SocialProfileDetailLocalService getWrappedService() {
		return _socialProfileDetailLocalService;
	}

	@Override
	public void setWrappedService(
		SocialProfileDetailLocalService socialProfileDetailLocalService) {
		_socialProfileDetailLocalService = socialProfileDetailLocalService;
	}

	private SocialProfileDetailLocalService _socialProfileDetailLocalService;
}