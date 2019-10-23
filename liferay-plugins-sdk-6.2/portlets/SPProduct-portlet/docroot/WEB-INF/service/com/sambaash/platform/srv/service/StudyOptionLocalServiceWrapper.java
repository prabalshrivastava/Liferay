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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudyOptionLocalService}.
 *
 * @author gauravvijayvergia
 * @see StudyOptionLocalService
 * @generated
 */
public class StudyOptionLocalServiceWrapper implements StudyOptionLocalService,
	ServiceWrapper<StudyOptionLocalService> {
	public StudyOptionLocalServiceWrapper(
		StudyOptionLocalService studyOptionLocalService) {
		_studyOptionLocalService = studyOptionLocalService;
	}

	/**
	* Adds the study option to the database. Also notifies the appropriate model listeners.
	*
	* @param studyOption the study option
	* @return the study option that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudyOption addStudyOption(
		com.sambaash.platform.srv.model.StudyOption studyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.addStudyOption(studyOption);
	}

	/**
	* Creates a new study option with the primary key. Does not add the study option to the database.
	*
	* @param spStudyOptionId the primary key for the new study option
	* @return the new study option
	*/
	@Override
	public com.sambaash.platform.srv.model.StudyOption createStudyOption(
		long spStudyOptionId) {
		return _studyOptionLocalService.createStudyOption(spStudyOptionId);
	}

	/**
	* Deletes the study option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option that was removed
	* @throws PortalException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudyOption deleteStudyOption(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.deleteStudyOption(spStudyOptionId);
	}

	/**
	* Deletes the study option from the database. Also notifies the appropriate model listeners.
	*
	* @param studyOption the study option
	* @return the study option that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudyOption deleteStudyOption(
		com.sambaash.platform.srv.model.StudyOption studyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.deleteStudyOption(studyOption);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studyOptionLocalService.dynamicQuery();
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
		return _studyOptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _studyOptionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _studyOptionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _studyOptionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _studyOptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.StudyOption fetchStudyOption(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.fetchStudyOption(spStudyOptionId);
	}

	/**
	* Returns the study option with the primary key.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option
	* @throws PortalException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudyOption getStudyOption(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.getStudyOption(spStudyOptionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the study options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @return the range of study options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> getStudyOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.getStudyOptions(start, end);
	}

	/**
	* Returns the number of study options.
	*
	* @return the number of study options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStudyOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.getStudyOptionsCount();
	}

	/**
	* Updates the study option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studyOption the study option
	* @return the study option that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudyOption updateStudyOption(
		com.sambaash.platform.srv.model.StudyOption studyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.updateStudyOption(studyOption);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _studyOptionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_studyOptionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _studyOptionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.findByCourseId(courseId);
	}

	@Override
	public com.sambaash.platform.srv.model.StudyOption create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOptionLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StudyOptionLocalService getWrappedStudyOptionLocalService() {
		return _studyOptionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStudyOptionLocalService(
		StudyOptionLocalService studyOptionLocalService) {
		_studyOptionLocalService = studyOptionLocalService;
	}

	@Override
	public StudyOptionLocalService getWrappedService() {
		return _studyOptionLocalService;
	}

	@Override
	public void setWrappedService(
		StudyOptionLocalService studyOptionLocalService) {
		_studyOptionLocalService = studyOptionLocalService;
	}

	private StudyOptionLocalService _studyOptionLocalService;
}