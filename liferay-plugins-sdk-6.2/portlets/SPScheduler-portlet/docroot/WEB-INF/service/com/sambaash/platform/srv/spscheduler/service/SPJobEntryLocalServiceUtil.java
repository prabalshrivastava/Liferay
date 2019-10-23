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

package com.sambaash.platform.srv.spscheduler.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPJobEntry. This utility wraps
 * {@link com.sambaash.platform.srv.spscheduler.service.impl.SPJobEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPJobEntryLocalService
 * @see com.sambaash.platform.srv.spscheduler.service.base.SPJobEntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spscheduler.service.impl.SPJobEntryLocalServiceImpl
 * @generated
 */
public class SPJobEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spscheduler.service.impl.SPJobEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p job entry to the database. Also notifies the appropriate model listeners.
	*
	* @param spJobEntry the s p job entry
	* @return the s p job entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry addSPJobEntry(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPJobEntry(spJobEntry);
	}

	/**
	* Creates a new s p job entry with the primary key. Does not add the s p job entry to the database.
	*
	* @param spJobEntryId the primary key for the new s p job entry
	* @return the new s p job entry
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry createSPJobEntry(
		long spJobEntryId) {
		return getService().createSPJobEntry(spJobEntryId);
	}

	/**
	* Deletes the s p job entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry that was removed
	* @throws PortalException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry deleteSPJobEntry(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPJobEntry(spJobEntryId);
	}

	/**
	* Deletes the s p job entry from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobEntry the s p job entry
	* @return the s p job entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry deleteSPJobEntry(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPJobEntry(spJobEntry);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchSPJobEntry(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPJobEntry(spJobEntryId);
	}

	/**
	* Returns the s p job entry with the matching UUID and company.
	*
	* @param uuid the s p job entry's UUID
	* @param companyId the primary key of the company
	* @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchSPJobEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPJobEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p job entry matching the UUID and group.
	*
	* @param uuid the s p job entry's UUID
	* @param groupId the primary key of the group
	* @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchSPJobEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPJobEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p job entry with the primary key.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry
	* @throws PortalException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry getSPJobEntry(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobEntry(spJobEntryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p job entry with the matching UUID and company.
	*
	* @param uuid the s p job entry's UUID
	* @param companyId the primary key of the company
	* @return the matching s p job entry
	* @throws PortalException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry getSPJobEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p job entry matching the UUID and group.
	*
	* @param uuid the s p job entry's UUID
	* @param groupId the primary key of the group
	* @return the matching s p job entry
	* @throws PortalException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry getSPJobEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p job entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @return the range of s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> getSPJobEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobEntries(start, end);
	}

	/**
	* Returns the number of s p job entries.
	*
	* @return the number of s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPJobEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPJobEntriesCount();
	}

	/**
	* Updates the s p job entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spJobEntry the s p job entry
	* @return the s p job entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry updateSPJobEntry(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPJobEntry(spJobEntry);
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

	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry createNewSPJobEntry()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createNewSPJobEntry();
	}

	public static java.util.List<java.lang.String> getSavedPortletIds() {
		return getService().getSavedPortletIds();
	}

	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> getSPJobEntryByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass) {
		return getService().getSPJobEntryByJobNameAndJobClass(jobName, jobClass);
	}

	public static long schedule(java.lang.String portletId,
		java.lang.String jobClassName, java.lang.String description,
		java.util.Calendar calendar, java.lang.String jobName,
		java.util.Map<java.lang.String, java.lang.Object> jobData) {
		return getService()
				   .schedule(portletId, jobClassName, description, calendar,
			jobName, jobData);
	}

	public static long schedule(java.lang.String portletId,
		java.lang.String jobClassName, java.lang.String description,
		java.lang.String cronExpression, java.lang.String jobName,
		java.util.Map<java.lang.String, java.lang.Object> jobData) {
		return getService()
				   .schedule(portletId, jobClassName, description,
			cronExpression, jobName, jobData);
	}

	public static boolean delete(java.lang.Long spSchedulerLogId) {
		return getService().delete(spSchedulerLogId);
	}

	public static boolean pause(java.lang.Long spSchedulerLogId) {
		return getService().pause(spSchedulerLogId);
	}

	public static boolean resume(java.lang.Long spSchedulerLogId) {
		return getService().resume(spSchedulerLogId);
	}

	public static boolean unSchedule(java.lang.Long spSchedulerLogId) {
		return getService().unSchedule(spSchedulerLogId);
	}

	public static boolean delete(java.lang.String jobName,
		java.lang.String jobClass) {
		return getService().delete(jobName, jobClass);
	}

	public static boolean unSchedule(java.lang.String jobName,
		java.lang.String jobClass) {
		return getService().unSchedule(jobName, jobClass);
	}

	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByJobNameAndJobClass(jobName, jobClass);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPJobEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPJobEntryLocalService.class.getName());

			if (invokableLocalService instanceof SPJobEntryLocalService) {
				_service = (SPJobEntryLocalService)invokableLocalService;
			}
			else {
				_service = new SPJobEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPJobEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPJobEntryLocalService service) {
	}

	private static SPJobEntryLocalService _service;
}