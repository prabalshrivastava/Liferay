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

package com.sambaash.platform.srv.spsocialprofile.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileService;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.ExamBodyUserPersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileDetailPersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileFinder;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileFriendsPersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileLikePersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileViewAuditPersistence;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.UserAvailabilityCalendarPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the social profile remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileServiceImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileServiceImpl
 * @see com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil
 * @generated
 */
public abstract class SocialProfileServiceBaseImpl extends BaseServiceImpl
	implements SocialProfileService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil} to access the social profile remote service.
	 */

	/**
	 * Returns the exam body user local service.
	 *
	 * @return the exam body user local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalService getExamBodyUserLocalService() {
		return examBodyUserLocalService;
	}

	/**
	 * Sets the exam body user local service.
	 *
	 * @param examBodyUserLocalService the exam body user local service
	 */
	public void setExamBodyUserLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalService examBodyUserLocalService) {
		this.examBodyUserLocalService = examBodyUserLocalService;
	}

	/**
	 * Returns the exam body user persistence.
	 *
	 * @return the exam body user persistence
	 */
	public ExamBodyUserPersistence getExamBodyUserPersistence() {
		return examBodyUserPersistence;
	}

	/**
	 * Sets the exam body user persistence.
	 *
	 * @param examBodyUserPersistence the exam body user persistence
	 */
	public void setExamBodyUserPersistence(
		ExamBodyUserPersistence examBodyUserPersistence) {
		this.examBodyUserPersistence = examBodyUserPersistence;
	}

	/**
	 * Returns the social profile local service.
	 *
	 * @return the social profile local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalService getSocialProfileLocalService() {
		return socialProfileLocalService;
	}

	/**
	 * Sets the social profile local service.
	 *
	 * @param socialProfileLocalService the social profile local service
	 */
	public void setSocialProfileLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalService socialProfileLocalService) {
		this.socialProfileLocalService = socialProfileLocalService;
	}

	/**
	 * Returns the social profile remote service.
	 *
	 * @return the social profile remote service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfileService getSocialProfileService() {
		return socialProfileService;
	}

	/**
	 * Sets the social profile remote service.
	 *
	 * @param socialProfileService the social profile remote service
	 */
	public void setSocialProfileService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfileService socialProfileService) {
		this.socialProfileService = socialProfileService;
	}

	/**
	 * Returns the social profile persistence.
	 *
	 * @return the social profile persistence
	 */
	public SocialProfilePersistence getSocialProfilePersistence() {
		return socialProfilePersistence;
	}

	/**
	 * Sets the social profile persistence.
	 *
	 * @param socialProfilePersistence the social profile persistence
	 */
	public void setSocialProfilePersistence(
		SocialProfilePersistence socialProfilePersistence) {
		this.socialProfilePersistence = socialProfilePersistence;
	}

	/**
	 * Returns the social profile finder.
	 *
	 * @return the social profile finder
	 */
	public SocialProfileFinder getSocialProfileFinder() {
		return socialProfileFinder;
	}

	/**
	 * Sets the social profile finder.
	 *
	 * @param socialProfileFinder the social profile finder
	 */
	public void setSocialProfileFinder(SocialProfileFinder socialProfileFinder) {
		this.socialProfileFinder = socialProfileFinder;
	}

	/**
	 * Returns the social profile detail local service.
	 *
	 * @return the social profile detail local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfileDetailLocalService getSocialProfileDetailLocalService() {
		return socialProfileDetailLocalService;
	}

	/**
	 * Sets the social profile detail local service.
	 *
	 * @param socialProfileDetailLocalService the social profile detail local service
	 */
	public void setSocialProfileDetailLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfileDetailLocalService socialProfileDetailLocalService) {
		this.socialProfileDetailLocalService = socialProfileDetailLocalService;
	}

	/**
	 * Returns the social profile detail persistence.
	 *
	 * @return the social profile detail persistence
	 */
	public SocialProfileDetailPersistence getSocialProfileDetailPersistence() {
		return socialProfileDetailPersistence;
	}

	/**
	 * Sets the social profile detail persistence.
	 *
	 * @param socialProfileDetailPersistence the social profile detail persistence
	 */
	public void setSocialProfileDetailPersistence(
		SocialProfileDetailPersistence socialProfileDetailPersistence) {
		this.socialProfileDetailPersistence = socialProfileDetailPersistence;
	}

	/**
	 * Returns the social profile friends local service.
	 *
	 * @return the social profile friends local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfileFriendsLocalService getSocialProfileFriendsLocalService() {
		return socialProfileFriendsLocalService;
	}

	/**
	 * Sets the social profile friends local service.
	 *
	 * @param socialProfileFriendsLocalService the social profile friends local service
	 */
	public void setSocialProfileFriendsLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfileFriendsLocalService socialProfileFriendsLocalService) {
		this.socialProfileFriendsLocalService = socialProfileFriendsLocalService;
	}

	/**
	 * Returns the social profile friends persistence.
	 *
	 * @return the social profile friends persistence
	 */
	public SocialProfileFriendsPersistence getSocialProfileFriendsPersistence() {
		return socialProfileFriendsPersistence;
	}

	/**
	 * Sets the social profile friends persistence.
	 *
	 * @param socialProfileFriendsPersistence the social profile friends persistence
	 */
	public void setSocialProfileFriendsPersistence(
		SocialProfileFriendsPersistence socialProfileFriendsPersistence) {
		this.socialProfileFriendsPersistence = socialProfileFriendsPersistence;
	}

	/**
	 * Returns the social profile like local service.
	 *
	 * @return the social profile like local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalService getSocialProfileLikeLocalService() {
		return socialProfileLikeLocalService;
	}

	/**
	 * Sets the social profile like local service.
	 *
	 * @param socialProfileLikeLocalService the social profile like local service
	 */
	public void setSocialProfileLikeLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalService socialProfileLikeLocalService) {
		this.socialProfileLikeLocalService = socialProfileLikeLocalService;
	}

	/**
	 * Returns the social profile like persistence.
	 *
	 * @return the social profile like persistence
	 */
	public SocialProfileLikePersistence getSocialProfileLikePersistence() {
		return socialProfileLikePersistence;
	}

	/**
	 * Sets the social profile like persistence.
	 *
	 * @param socialProfileLikePersistence the social profile like persistence
	 */
	public void setSocialProfileLikePersistence(
		SocialProfileLikePersistence socialProfileLikePersistence) {
		this.socialProfileLikePersistence = socialProfileLikePersistence;
	}

	/**
	 * Returns the social profile pull audit local service.
	 *
	 * @return the social profile pull audit local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfilePullAuditLocalService getSocialProfilePullAuditLocalService() {
		return socialProfilePullAuditLocalService;
	}

	/**
	 * Sets the social profile pull audit local service.
	 *
	 * @param socialProfilePullAuditLocalService the social profile pull audit local service
	 */
	public void setSocialProfilePullAuditLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfilePullAuditLocalService socialProfilePullAuditLocalService) {
		this.socialProfilePullAuditLocalService = socialProfilePullAuditLocalService;
	}

	/**
	 * Returns the social profile pull audit persistence.
	 *
	 * @return the social profile pull audit persistence
	 */
	public SocialProfilePullAuditPersistence getSocialProfilePullAuditPersistence() {
		return socialProfilePullAuditPersistence;
	}

	/**
	 * Sets the social profile pull audit persistence.
	 *
	 * @param socialProfilePullAuditPersistence the social profile pull audit persistence
	 */
	public void setSocialProfilePullAuditPersistence(
		SocialProfilePullAuditPersistence socialProfilePullAuditPersistence) {
		this.socialProfilePullAuditPersistence = socialProfilePullAuditPersistence;
	}

	/**
	 * Returns the social profile view audit local service.
	 *
	 * @return the social profile view audit local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.SocialProfileViewAuditLocalService getSocialProfileViewAuditLocalService() {
		return socialProfileViewAuditLocalService;
	}

	/**
	 * Sets the social profile view audit local service.
	 *
	 * @param socialProfileViewAuditLocalService the social profile view audit local service
	 */
	public void setSocialProfileViewAuditLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.SocialProfileViewAuditLocalService socialProfileViewAuditLocalService) {
		this.socialProfileViewAuditLocalService = socialProfileViewAuditLocalService;
	}

	/**
	 * Returns the social profile view audit persistence.
	 *
	 * @return the social profile view audit persistence
	 */
	public SocialProfileViewAuditPersistence getSocialProfileViewAuditPersistence() {
		return socialProfileViewAuditPersistence;
	}

	/**
	 * Sets the social profile view audit persistence.
	 *
	 * @param socialProfileViewAuditPersistence the social profile view audit persistence
	 */
	public void setSocialProfileViewAuditPersistence(
		SocialProfileViewAuditPersistence socialProfileViewAuditPersistence) {
		this.socialProfileViewAuditPersistence = socialProfileViewAuditPersistence;
	}

	/**
	 * Returns the user availability calendar local service.
	 *
	 * @return the user availability calendar local service
	 */
	public com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalService getUserAvailabilityCalendarLocalService() {
		return userAvailabilityCalendarLocalService;
	}

	/**
	 * Sets the user availability calendar local service.
	 *
	 * @param userAvailabilityCalendarLocalService the user availability calendar local service
	 */
	public void setUserAvailabilityCalendarLocalService(
		com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalService userAvailabilityCalendarLocalService) {
		this.userAvailabilityCalendarLocalService = userAvailabilityCalendarLocalService;
	}

	/**
	 * Returns the user availability calendar persistence.
	 *
	 * @return the user availability calendar persistence
	 */
	public UserAvailabilityCalendarPersistence getUserAvailabilityCalendarPersistence() {
		return userAvailabilityCalendarPersistence;
	}

	/**
	 * Sets the user availability calendar persistence.
	 *
	 * @param userAvailabilityCalendarPersistence the user availability calendar persistence
	 */
	public void setUserAvailabilityCalendarPersistence(
		UserAvailabilityCalendarPersistence userAvailabilityCalendarPersistence) {
		this.userAvailabilityCalendarPersistence = userAvailabilityCalendarPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SocialProfile.class;
	}

	protected String getModelClassName() {
		return SocialProfile.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = socialProfilePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalService examBodyUserLocalService;
	@BeanReference(type = ExamBodyUserPersistence.class)
	protected ExamBodyUserPersistence examBodyUserPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalService socialProfileLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfileService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfileService socialProfileService;
	@BeanReference(type = SocialProfilePersistence.class)
	protected SocialProfilePersistence socialProfilePersistence;
	@BeanReference(type = SocialProfileFinder.class)
	protected SocialProfileFinder socialProfileFinder;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfileDetailLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfileDetailLocalService socialProfileDetailLocalService;
	@BeanReference(type = SocialProfileDetailPersistence.class)
	protected SocialProfileDetailPersistence socialProfileDetailPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfileFriendsLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfileFriendsLocalService socialProfileFriendsLocalService;
	@BeanReference(type = SocialProfileFriendsPersistence.class)
	protected SocialProfileFriendsPersistence socialProfileFriendsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalService socialProfileLikeLocalService;
	@BeanReference(type = SocialProfileLikePersistence.class)
	protected SocialProfileLikePersistence socialProfileLikePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfilePullAuditLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfilePullAuditLocalService socialProfilePullAuditLocalService;
	@BeanReference(type = SocialProfilePullAuditPersistence.class)
	protected SocialProfilePullAuditPersistence socialProfilePullAuditPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.SocialProfileViewAuditLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.SocialProfileViewAuditLocalService socialProfileViewAuditLocalService;
	@BeanReference(type = SocialProfileViewAuditPersistence.class)
	protected SocialProfileViewAuditPersistence socialProfileViewAuditPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalService.class)
	protected com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalService userAvailabilityCalendarLocalService;
	@BeanReference(type = UserAvailabilityCalendarPersistence.class)
	protected UserAvailabilityCalendarPersistence userAvailabilityCalendarPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
	protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SocialProfileServiceClpInvoker _clpInvoker = new SocialProfileServiceClpInvoker();
}