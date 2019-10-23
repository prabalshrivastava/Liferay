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
 * Provides a wrapper for {@link ExamBodyUserLocalService}.
 *
 * @author gauravvijayvergia
 * @see ExamBodyUserLocalService
 * @generated
 */
public class ExamBodyUserLocalServiceWrapper implements ExamBodyUserLocalService,
	ServiceWrapper<ExamBodyUserLocalService> {
	public ExamBodyUserLocalServiceWrapper(
		ExamBodyUserLocalService examBodyUserLocalService) {
		_examBodyUserLocalService = examBodyUserLocalService;
	}

	/**
	* Adds the exam body user to the database. Also notifies the appropriate model listeners.
	*
	* @param examBodyUser the exam body user
	* @return the exam body user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser addExamBodyUser(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.addExamBodyUser(examBodyUser);
	}

	/**
	* Creates a new exam body user with the primary key. Does not add the exam body user to the database.
	*
	* @param examBodyUserId the primary key for the new exam body user
	* @return the new exam body user
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser createExamBodyUser(
		long examBodyUserId) {
		return _examBodyUserLocalService.createExamBodyUser(examBodyUserId);
	}

	/**
	* Deletes the exam body user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user that was removed
	* @throws PortalException if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser deleteExamBodyUser(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.deleteExamBodyUser(examBodyUserId);
	}

	/**
	* Deletes the exam body user from the database. Also notifies the appropriate model listeners.
	*
	* @param examBodyUser the exam body user
	* @return the exam body user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser deleteExamBodyUser(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.deleteExamBodyUser(examBodyUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _examBodyUserLocalService.dynamicQuery();
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
		return _examBodyUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _examBodyUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _examBodyUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _examBodyUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _examBodyUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchExamBodyUser(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.fetchExamBodyUser(examBodyUserId);
	}

	/**
	* Returns the exam body user with the primary key.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user
	* @throws PortalException if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser getExamBodyUser(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.getExamBodyUser(examBodyUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the exam body users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam body users
	* @param end the upper bound of the range of exam body users (not inclusive)
	* @return the range of exam body users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> getExamBodyUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.getExamBodyUsers(start, end);
	}

	/**
	* Returns the number of exam body users.
	*
	* @return the number of exam body users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getExamBodyUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.getExamBodyUsersCount();
	}

	/**
	* Updates the exam body user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param examBodyUser the exam body user
	* @return the exam body user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser updateExamBodyUser(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUserLocalService.updateExamBodyUser(examBodyUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _examBodyUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_examBodyUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _examBodyUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public boolean isExamBodyUser(java.lang.String examBody,
		java.lang.String emailAddress) {
		return _examBodyUserLocalService.isExamBodyUser(examBody, emailAddress);
	}

	@Override
	public void addOrUpdateExamBodyUser(long companyId, long groupId,
		java.lang.String examBody, java.lang.String emailAddress) {
		_examBodyUserLocalService.addOrUpdateExamBodyUser(companyId, groupId,
			examBody, emailAddress);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ExamBodyUserLocalService getWrappedExamBodyUserLocalService() {
		return _examBodyUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedExamBodyUserLocalService(
		ExamBodyUserLocalService examBodyUserLocalService) {
		_examBodyUserLocalService = examBodyUserLocalService;
	}

	@Override
	public ExamBodyUserLocalService getWrappedService() {
		return _examBodyUserLocalService;
	}

	@Override
	public void setWrappedService(
		ExamBodyUserLocalService examBodyUserLocalService) {
		_examBodyUserLocalService = examBodyUserLocalService;
	}

	private ExamBodyUserLocalService _examBodyUserLocalService;
}