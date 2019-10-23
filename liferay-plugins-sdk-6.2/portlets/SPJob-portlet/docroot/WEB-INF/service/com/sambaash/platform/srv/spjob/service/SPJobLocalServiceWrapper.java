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

package com.sambaash.platform.srv.spjob.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPJobLocalService}.
 *
 * @author harini
 * @see SPJobLocalService
 * @generated
 */
public class SPJobLocalServiceWrapper implements SPJobLocalService,
	ServiceWrapper<SPJobLocalService> {
	public SPJobLocalServiceWrapper(SPJobLocalService spJobLocalService) {
		_spJobLocalService = spJobLocalService;
	}

	/**
	* Adds the s p job to the database. Also notifies the appropriate model listeners.
	*
	* @param spJob the s p job
	* @return the s p job that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob addSPJob(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.addSPJob(spJob);
	}

	/**
	* Creates a new s p job with the primary key. Does not add the s p job to the database.
	*
	* @param spJobId the primary key for the new s p job
	* @return the new s p job
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob createSPJob(long spJobId) {
		return _spJobLocalService.createSPJob(spJobId);
	}

	/**
	* Deletes the s p job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job that was removed
	* @throws PortalException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob deleteSPJob(long spJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.deleteSPJob(spJobId);
	}

	/**
	* Deletes the s p job from the database. Also notifies the appropriate model listeners.
	*
	* @param spJob the s p job
	* @return the s p job that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob deleteSPJob(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.deleteSPJob(spJob);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spJobLocalService.dynamicQuery();
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
		return _spJobLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spJobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spJobLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _spJobLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spJobLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob fetchSPJob(long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.fetchSPJob(spJobId);
	}

	/**
	* Returns the s p job with the matching UUID and company.
	*
	* @param uuid the s p job's UUID
	* @param companyId the primary key of the company
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob fetchSPJobByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.fetchSPJobByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p job matching the UUID and group.
	*
	* @param uuid the s p job's UUID
	* @param groupId the primary key of the group
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob fetchSPJobByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.fetchSPJobByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p job with the primary key.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job
	* @throws PortalException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob getSPJob(long spJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.getSPJob(spJobId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p job with the matching UUID and company.
	*
	* @param uuid the s p job's UUID
	* @param companyId the primary key of the company
	* @return the matching s p job
	* @throws PortalException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob getSPJobByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.getSPJobByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p job matching the UUID and group.
	*
	* @param uuid the s p job's UUID
	* @param groupId the primary key of the group
	* @return the matching s p job
	* @throws PortalException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob getSPJobByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.getSPJobByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> getSPJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.getSPJobs(start, end);
	}

	/**
	* Returns the number of s p jobs.
	*
	* @return the number of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.getSPJobsCount();
	}

	/**
	* Updates the s p job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spJob the s p job
	* @return the s p job that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob updateSPJob(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.updateSPJob(spJob);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spJobLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spJobLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spJobLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void closeJob(long spJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spJobLocalService.closeJob(spJobId);
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob addSPJob(long userId,
		java.lang.String corporateName, java.lang.String jobTitle,
		java.lang.String jobType, java.lang.String jobLocation,
		java.lang.String yoe, java.lang.String jobDescription,
		java.lang.String status, java.lang.String imageFileName,
		java.io.InputStream imageInputStream, long imageMaxSize,
		java.lang.String[] imageExtensions, java.lang.String currency,
		java.lang.String salary, java.lang.String rate,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date closingDate, java.lang.String notefTo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.addSPJob(userId, corporateName, jobTitle,
			jobType, jobLocation, yoe, jobDescription, status, imageFileName,
			imageInputStream, imageMaxSize, imageExtensions, currency, salary,
			rate, startDate, endDate, closingDate, notefTo, serviceContext);
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob updateSPJob(
		long userId, long spJobId, java.lang.String corporateName,
		java.lang.String jobTitle, java.lang.String jobType,
		java.lang.String jobLocation, java.lang.String yoe,
		java.lang.String jobDescription, java.lang.String status,
		java.lang.String imageFileName, java.io.InputStream imageInputStream,
		long imageMaxSize, java.lang.String[] imageExtensions,
		java.lang.String currency, java.lang.String salary,
		java.lang.String rate, java.util.Date startDate,
		java.util.Date endDate, java.util.Date closingDate,
		java.lang.String notefTo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spJobLocalService.updateSPJob(userId, spJobId, corporateName,
			jobTitle, jobType, jobLocation, yoe, jobDescription, status,
			imageFileName, imageInputStream, imageMaxSize, imageExtensions,
			currency, salary, rate, startDate, endDate, closingDate, notefTo,
			serviceContext);
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.spjob.model.SPJob spJob,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spJobLocalService.updateAsset(userId, spJob, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPJobLocalService getWrappedSPJobLocalService() {
		return _spJobLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPJobLocalService(SPJobLocalService spJobLocalService) {
		_spJobLocalService = spJobLocalService;
	}

	@Override
	public SPJobLocalService getWrappedService() {
		return _spJobLocalService;
	}

	@Override
	public void setWrappedService(SPJobLocalService spJobLocalService) {
		_spJobLocalService = spJobLocalService;
	}

	private SPJobLocalService _spJobLocalService;
}