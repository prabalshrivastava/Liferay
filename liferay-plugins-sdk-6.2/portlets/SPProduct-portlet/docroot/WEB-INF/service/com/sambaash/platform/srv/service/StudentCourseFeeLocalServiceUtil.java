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
 * Provides the local service utility for StudentCourseFee. This utility wraps
 * {@link com.sambaash.platform.srv.service.impl.StudentCourseFeeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeLocalService
 * @see com.sambaash.platform.srv.service.base.StudentCourseFeeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.impl.StudentCourseFeeLocalServiceImpl
 * @generated
 */
public class StudentCourseFeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.service.impl.StudentCourseFeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the student course fee to the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFee the student course fee
	* @return the student course fee that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFee addStudentCourseFee(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStudentCourseFee(studentCourseFee);
	}

	/**
	* Creates a new student course fee with the primary key. Does not add the student course fee to the database.
	*
	* @param spStudentCourseFeeId the primary key for the new student course fee
	* @return the new student course fee
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFee createStudentCourseFee(
		long spStudentCourseFeeId) {
		return getService().createStudentCourseFee(spStudentCourseFeeId);
	}

	/**
	* Deletes the student course fee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseFeeId the primary key of the student course fee
	* @return the student course fee that was removed
	* @throws PortalException if a student course fee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFee deleteStudentCourseFee(
		long spStudentCourseFeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStudentCourseFee(spStudentCourseFeeId);
	}

	/**
	* Deletes the student course fee from the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFee the student course fee
	* @return the student course fee that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFee deleteStudentCourseFee(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStudentCourseFee(studentCourseFee);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.model.StudentCourseFee fetchStudentCourseFee(
		long spStudentCourseFeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStudentCourseFee(spStudentCourseFeeId);
	}

	/**
	* Returns the student course fee with the primary key.
	*
	* @param spStudentCourseFeeId the primary key of the student course fee
	* @return the student course fee
	* @throws PortalException if a student course fee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFee getStudentCourseFee(
		long spStudentCourseFeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStudentCourseFee(spStudentCourseFeeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the student course fees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student course fees
	* @param end the upper bound of the range of student course fees (not inclusive)
	* @return the range of student course fees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFee> getStudentCourseFees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStudentCourseFees(start, end);
	}

	/**
	* Returns the number of student course fees.
	*
	* @return the number of student course fees
	* @throws SystemException if a system exception occurred
	*/
	public static int getStudentCourseFeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStudentCourseFeesCount();
	}

	/**
	* Updates the student course fee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFee the student course fee
	* @return the student course fee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudentCourseFee updateStudentCourseFee(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStudentCourseFee(studentCourseFee);
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

	public static java.util.List<com.sambaash.platform.srv.model.StudentCourseFee> findByProcessStateId(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByProcessStateId(processStateId);
	}

	public static com.sambaash.platform.srv.model.StudentCourseFee findByProcessStateIdFeeType(
		long processStateId, java.lang.String feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeException {
		return getService().findByProcessStateIdFeeType(processStateId, feeType);
	}

	public static com.sambaash.platform.srv.model.StudentCourseFee create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static void clearService() {
		_service = null;
	}

	public static StudentCourseFeeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StudentCourseFeeLocalService.class.getName());

			if (invokableLocalService instanceof StudentCourseFeeLocalService) {
				_service = (StudentCourseFeeLocalService)invokableLocalService;
			}
			else {
				_service = new StudentCourseFeeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StudentCourseFeeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StudentCourseFeeLocalService service) {
	}

	private static StudentCourseFeeLocalService _service;
}