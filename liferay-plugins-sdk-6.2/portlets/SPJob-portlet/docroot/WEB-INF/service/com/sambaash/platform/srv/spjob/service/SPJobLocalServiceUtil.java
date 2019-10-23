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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPJob. This utility wraps
 * {@link com.sambaash.platform.srv.spjob.service.impl.SPJobLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see SPJobLocalService
 * @see com.sambaash.platform.srv.spjob.service.base.SPJobLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spjob.service.impl.SPJobLocalServiceImpl
 * @generated
 */
public class SPJobLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spjob.service.impl.SPJobLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p job to the database. Also notifies the appropriate model listeners.
	*
	* @param spJob the s p job
	* @return the s p job that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob addSPJob(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPJob(spJob);
	}

	/**
	* Creates a new s p job with the primary key. Does not add the s p job to the database.
	*
	* @param spJobId the primary key for the new s p job
	* @return the new s p job
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob createSPJob(
		long spJobId) {
		return getService().createSPJob(spJobId);
	}

	/**
	* Deletes the s p job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job that was removed
	* @throws PortalException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob deleteSPJob(
		long spJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPJob(spJobId);
	}

	/**
	* Deletes the s p job from the database. Also notifies the appropriate model listeners.
	*
	* @param spJob the s p job
	* @return the s p job that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob deleteSPJob(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPJob(spJob);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spjob.model.SPJob fetchSPJob(
		long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPJob(spJobId);
	}

	/**
	* Returns the s p job with the matching UUID and company.
	*
	* @param uuid the s p job's UUID
	* @param companyId the primary key of the company
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchSPJobByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPJobByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p job matching the UUID and group.
	*
	* @param uuid the s p job's UUID
	* @param groupId the primary key of the group
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchSPJobByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPJobByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p job with the primary key.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job
	* @throws PortalException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob getSPJob(
		long spJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJob(spJobId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.sambaash.platform.srv.spjob.model.SPJob getSPJobByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobByUuidAndCompanyId(uuid, companyId);
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
	public static com.sambaash.platform.srv.spjob.model.SPJob getSPJobByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> getSPJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobs(start, end);
	}

	/**
	* Returns the number of s p jobs.
	*
	* @return the number of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobsCount();
	}

	/**
	* Updates the s p job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spJob the s p job
	* @return the s p job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob updateSPJob(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPJob(spJob);
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

	public static void closeJob(long spJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().closeJob(spJobId);
	}

	public static com.sambaash.platform.srv.spjob.model.SPJob addSPJob(
		long userId, java.lang.String corporateName, java.lang.String jobTitle,
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
		return getService()
				   .addSPJob(userId, corporateName, jobTitle, jobType,
			jobLocation, yoe, jobDescription, status, imageFileName,
			imageInputStream, imageMaxSize, imageExtensions, currency, salary,
			rate, startDate, endDate, closingDate, notefTo, serviceContext);
	}

	public static com.sambaash.platform.srv.spjob.model.SPJob updateSPJob(
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
		return getService()
				   .updateSPJob(userId, spJobId, corporateName, jobTitle,
			jobType, jobLocation, yoe, jobDescription, status, imageFileName,
			imageInputStream, imageMaxSize, imageExtensions, currency, salary,
			rate, startDate, endDate, closingDate, notefTo, serviceContext);
	}

	public static void updateAsset(long userId,
		com.sambaash.platform.srv.spjob.model.SPJob spJob,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, spJob, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPJobLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPJobLocalService.class.getName());

			if (invokableLocalService instanceof SPJobLocalService) {
				_service = (SPJobLocalService)invokableLocalService;
			}
			else {
				_service = new SPJobLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPJobLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPJobLocalService service) {
	}

	private static SPJobLocalService _service;
}