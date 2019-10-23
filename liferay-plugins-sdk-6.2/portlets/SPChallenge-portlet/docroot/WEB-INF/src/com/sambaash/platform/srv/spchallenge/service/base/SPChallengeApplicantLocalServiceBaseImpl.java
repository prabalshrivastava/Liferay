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

package com.sambaash.platform.srv.spchallenge.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetCategoryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;

import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalService;
import com.sambaash.platform.srv.spchallenge.service.persistence.SPChallengeApplicantPersistence;
import com.sambaash.platform.srv.spchallenge.service.persistence.SPChallengePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p challenge applicant local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeApplicantLocalServiceImpl}.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spchallenge.service.impl.SPChallengeApplicantLocalServiceImpl
 * @see com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil
 * @generated
 */
public abstract class SPChallengeApplicantLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SPChallengeApplicantLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil} to access the s p challenge applicant local service.
	 */

	/**
	 * Adds the s p challenge applicant to the database. Also notifies the appropriate model listeners.
	 *
	 * @param spChallengeApplicant the s p challenge applicant
	 * @return the s p challenge applicant that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPChallengeApplicant addSPChallengeApplicant(
		SPChallengeApplicant spChallengeApplicant) throws SystemException {
		spChallengeApplicant.setNew(true);

		return spChallengeApplicantPersistence.update(spChallengeApplicant);
	}

	/**
	 * Creates a new s p challenge applicant with the primary key. Does not add the s p challenge applicant to the database.
	 *
	 * @param spChallengeApplicantId the primary key for the new s p challenge applicant
	 * @return the new s p challenge applicant
	 */
	@Override
	public SPChallengeApplicant createSPChallengeApplicant(
		long spChallengeApplicantId) {
		return spChallengeApplicantPersistence.create(spChallengeApplicantId);
	}

	/**
	 * Deletes the s p challenge applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spChallengeApplicantId the primary key of the s p challenge applicant
	 * @return the s p challenge applicant that was removed
	 * @throws PortalException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPChallengeApplicant deleteSPChallengeApplicant(
		long spChallengeApplicantId) throws PortalException, SystemException {
		return spChallengeApplicantPersistence.remove(spChallengeApplicantId);
	}

	/**
	 * Deletes the s p challenge applicant from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spChallengeApplicant the s p challenge applicant
	 * @return the s p challenge applicant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SPChallengeApplicant deleteSPChallengeApplicant(
		SPChallengeApplicant spChallengeApplicant) throws SystemException {
		return spChallengeApplicantPersistence.remove(spChallengeApplicant);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SPChallengeApplicant.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return spChallengeApplicantPersistence.findWithDynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return spChallengeApplicantPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return spChallengeApplicantPersistence.findWithDynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return spChallengeApplicantPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return spChallengeApplicantPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SPChallengeApplicant fetchSPChallengeApplicant(
		long spChallengeApplicantId) throws SystemException {
		return spChallengeApplicantPersistence.fetchByPrimaryKey(spChallengeApplicantId);
	}

	/**
	 * Returns the s p challenge applicant with the matching UUID and company.
	 *
	 * @param uuid the s p challenge applicant's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchSPChallengeApplicantByUuidAndCompanyId(
		String uuid, long companyId) throws SystemException {
		return spChallengeApplicantPersistence.fetchByUuid_C_First(uuid,
			companyId, null);
	}

	/**
	 * Returns the s p challenge applicant matching the UUID and group.
	 *
	 * @param uuid the s p challenge applicant's UUID
	 * @param groupId the primary key of the group
	 * @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchSPChallengeApplicantByUuidAndGroupId(
		String uuid, long groupId) throws SystemException {
		return spChallengeApplicantPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the s p challenge applicant with the primary key.
	 *
	 * @param spChallengeApplicantId the primary key of the s p challenge applicant
	 * @return the s p challenge applicant
	 * @throws PortalException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant getSPChallengeApplicant(
		long spChallengeApplicantId) throws PortalException, SystemException {
		return spChallengeApplicantPersistence.findByPrimaryKey(spChallengeApplicantId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return spChallengeApplicantPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the s p challenge applicant with the matching UUID and company.
	 *
	 * @param uuid the s p challenge applicant's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching s p challenge applicant
	 * @throws PortalException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant getSPChallengeApplicantByUuidAndCompanyId(
		String uuid, long companyId) throws PortalException, SystemException {
		return spChallengeApplicantPersistence.findByUuid_C_First(uuid,
			companyId, null);
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
	@Override
	public SPChallengeApplicant getSPChallengeApplicantByUuidAndGroupId(
		String uuid, long groupId) throws PortalException, SystemException {
		return spChallengeApplicantPersistence.findByUUID_G(uuid, groupId);
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
	@Override
	public List<SPChallengeApplicant> getSPChallengeApplicants(int start,
		int end) throws SystemException {
		return spChallengeApplicantPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of s p challenge applicants.
	 *
	 * @return the number of s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSPChallengeApplicantsCount() throws SystemException {
		return spChallengeApplicantPersistence.countAll();
	}

	/**
	 * Updates the s p challenge applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param spChallengeApplicant the s p challenge applicant
	 * @return the s p challenge applicant that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SPChallengeApplicant updateSPChallengeApplicant(
		SPChallengeApplicant spChallengeApplicant) throws SystemException {
		return spChallengeApplicantPersistence.update(spChallengeApplicant);
	}

	/**
	 * Returns the s p challenge local service.
	 *
	 * @return the s p challenge local service
	 */
	public com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalService getSPChallengeLocalService() {
		return spChallengeLocalService;
	}

	/**
	 * Sets the s p challenge local service.
	 *
	 * @param spChallengeLocalService the s p challenge local service
	 */
	public void setSPChallengeLocalService(
		com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalService spChallengeLocalService) {
		this.spChallengeLocalService = spChallengeLocalService;
	}

	/**
	 * Returns the s p challenge persistence.
	 *
	 * @return the s p challenge persistence
	 */
	public SPChallengePersistence getSPChallengePersistence() {
		return spChallengePersistence;
	}

	/**
	 * Sets the s p challenge persistence.
	 *
	 * @param spChallengePersistence the s p challenge persistence
	 */
	public void setSPChallengePersistence(
		SPChallengePersistence spChallengePersistence) {
		this.spChallengePersistence = spChallengePersistence;
	}

	/**
	 * Returns the s p challenge applicant local service.
	 *
	 * @return the s p challenge applicant local service
	 */
	public com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalService getSPChallengeApplicantLocalService() {
		return spChallengeApplicantLocalService;
	}

	/**
	 * Sets the s p challenge applicant local service.
	 *
	 * @param spChallengeApplicantLocalService the s p challenge applicant local service
	 */
	public void setSPChallengeApplicantLocalService(
		com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalService spChallengeApplicantLocalService) {
		this.spChallengeApplicantLocalService = spChallengeApplicantLocalService;
	}

	/**
	 * Returns the s p challenge applicant persistence.
	 *
	 * @return the s p challenge applicant persistence
	 */
	public SPChallengeApplicantPersistence getSPChallengeApplicantPersistence() {
		return spChallengeApplicantPersistence;
	}

	/**
	 * Sets the s p challenge applicant persistence.
	 *
	 * @param spChallengeApplicantPersistence the s p challenge applicant persistence
	 */
	public void setSPChallengeApplicantPersistence(
		SPChallengeApplicantPersistence spChallengeApplicantPersistence) {
		this.spChallengeApplicantPersistence = spChallengeApplicantPersistence;
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
	 * Returns the asset category local service.
	 *
	 * @return the asset category local service
	 */
	public com.liferay.portlet.asset.service.AssetCategoryLocalService getAssetCategoryLocalService() {
		return assetCategoryLocalService;
	}

	/**
	 * Sets the asset category local service.
	 *
	 * @param assetCategoryLocalService the asset category local service
	 */
	public void setAssetCategoryLocalService(
		com.liferay.portlet.asset.service.AssetCategoryLocalService assetCategoryLocalService) {
		this.assetCategoryLocalService = assetCategoryLocalService;
	}

	/**
	 * Returns the asset category remote service.
	 *
	 * @return the asset category remote service
	 */
	public com.liferay.portlet.asset.service.AssetCategoryService getAssetCategoryService() {
		return assetCategoryService;
	}

	/**
	 * Sets the asset category remote service.
	 *
	 * @param assetCategoryService the asset category remote service
	 */
	public void setAssetCategoryService(
		com.liferay.portlet.asset.service.AssetCategoryService assetCategoryService) {
		this.assetCategoryService = assetCategoryService;
	}

	/**
	 * Returns the asset category persistence.
	 *
	 * @return the asset category persistence
	 */
	public AssetCategoryPersistence getAssetCategoryPersistence() {
		return assetCategoryPersistence;
	}

	/**
	 * Sets the asset category persistence.
	 *
	 * @param assetCategoryPersistence the asset category persistence
	 */
	public void setAssetCategoryPersistence(
		AssetCategoryPersistence assetCategoryPersistence) {
		this.assetCategoryPersistence = assetCategoryPersistence;
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

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.portlet.asset.service.AssetTagLocalService getAssetTagLocalService() {
		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.portlet.asset.service.AssetTagLocalService assetTagLocalService) {
		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag remote service.
	 *
	 * @return the asset tag remote service
	 */
	public com.liferay.portlet.asset.service.AssetTagService getAssetTagService() {
		return assetTagService;
	}

	/**
	 * Sets the asset tag remote service.
	 *
	 * @param assetTagService the asset tag remote service
	 */
	public void setAssetTagService(
		com.liferay.portlet.asset.service.AssetTagService assetTagService) {
		this.assetTagService = assetTagService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant",
			spChallengeApplicantLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant");
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
		return SPChallengeApplicant.class;
	}

	protected String getModelClassName() {
		return SPChallengeApplicant.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spChallengeApplicantPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalService.class)
	protected com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalService spChallengeLocalService;
	@BeanReference(type = SPChallengePersistence.class)
	protected SPChallengePersistence spChallengePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalService.class)
	protected com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalService spChallengeApplicantLocalService;
	@BeanReference(type = SPChallengeApplicantPersistence.class)
	protected SPChallengeApplicantPersistence spChallengeApplicantPersistence;
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
	@BeanReference(type = com.liferay.portlet.asset.service.AssetCategoryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetCategoryLocalService assetCategoryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetCategoryService.class)
	protected com.liferay.portlet.asset.service.AssetCategoryService assetCategoryService;
	@BeanReference(type = AssetCategoryPersistence.class)
	protected AssetCategoryPersistence assetCategoryPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
	protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
	protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetTagLocalService.class)
	protected com.liferay.portlet.asset.service.AssetTagLocalService assetTagLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetTagService.class)
	protected com.liferay.portlet.asset.service.AssetTagService assetTagService;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SPChallengeApplicantLocalServiceClpInvoker _clpInvoker = new SPChallengeApplicantLocalServiceClpInvoker();
}