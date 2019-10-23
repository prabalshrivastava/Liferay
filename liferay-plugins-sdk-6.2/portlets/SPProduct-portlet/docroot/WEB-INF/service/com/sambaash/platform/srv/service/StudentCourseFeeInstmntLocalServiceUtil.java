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

package com.sambaash.platform.srv.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for StudentCourseFeeInstmnt. This utility wraps
 * {@link com.sambaash.platform.srv.service.impl.StudentCourseFeeInstmntLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmntLocalService
 * @see com.sambaash.platform.srv.service.base.StudentCourseFeeInstmntLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.impl.StudentCourseFeeInstmntLocalServiceImpl
 * @generated
 */
public class StudentCourseFeeInstmntLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.service.impl.StudentCourseFeeInstmntLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the student course fee instmnt to the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	* @return the student course fee instmnt that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt addStudentCourseFeeInstmnt(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStudentCourseFeeInstmnt(studentCourseFeeInstmnt);
	}

	/**
	* Creates a new student course fee instmnt with the primary key. Does not add the student course fee instmnt to the database.
	*
	* @param spStudentCourseFeeInstmntId the primary key for the new student course fee instmnt
	* @return the new student course fee instmnt
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt createStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId) {
		return getService()
				   .createStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	/**
	* Deletes the student course fee instmnt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt that was removed
	* @throws PortalException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt deleteStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	/**
	* Deletes the student course fee instmnt from the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	* @return the student course fee instmnt that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt deleteStudentCourseFeeInstmnt(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteStudentCourseFeeInstmnt(studentCourseFeeInstmnt);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	/**
	* Returns the student course fee instmnt with the primary key.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt
	* @throws PortalException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt getStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the student course fee instmnts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student course fee instmnts
	* @param end the upper bound of the range of student course fee instmnts (not inclusive)
	* @return the range of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> getStudentCourseFeeInstmnts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStudentCourseFeeInstmnts(start, end);
	}

	/**
	* Returns the number of student course fee instmnts.
	*
	* @return the number of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	public static int getStudentCourseFeeInstmntsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStudentCourseFeeInstmntsCount();
	}

	/**
	* Updates the student course fee instmnt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	* @return the student course fee instmnt that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt updateStudentCourseFeeInstmnt(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStudentCourseFeeInstmnt(studentCourseFeeInstmnt);
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

	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findByProcessStateId(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByProcessStateId(processStateId);
	}

	public static com.sambaash.platform.srv.model.StudentCourseFeeInstmnt findByProcessStateIdInstmntNo(
		long processStateId, int instmntNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return getService()
				   .findByProcessStateIdInstmntNo(processStateId, instmntNo);
	}

	public static void clearService() {
		_service = null;
	}

	public static StudentCourseFeeInstmntLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StudentCourseFeeInstmntLocalService.class.getName());

			if (invokableLocalService instanceof StudentCourseFeeInstmntLocalService) {
				_service = (StudentCourseFeeInstmntLocalService)invokableLocalService;
			}
			else {
				_service = new StudentCourseFeeInstmntLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StudentCourseFeeInstmntLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StudentCourseFeeInstmntLocalService service) {
	}

	private static StudentCourseFeeInstmntLocalService _service;
}