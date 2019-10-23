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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuestionnaireLocalService}.
 *
 * @author pradeep
 * @see QuestionnaireLocalService
 * @generated
 */
public class QuestionnaireLocalServiceWrapper
	implements QuestionnaireLocalService,
		ServiceWrapper<QuestionnaireLocalService> {
	public QuestionnaireLocalServiceWrapper(
		QuestionnaireLocalService questionnaireLocalService) {
		_questionnaireLocalService = questionnaireLocalService;
	}

	/**
	* Adds the questionnaire to the database. Also notifies the appropriate model listeners.
	*
	* @param questionnaire the questionnaire
	* @return the questionnaire that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire addQuestionnaire(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.addQuestionnaire(questionnaire);
	}

	/**
	* Creates a new questionnaire with the primary key. Does not add the questionnaire to the database.
	*
	* @param questionnaireId the primary key for the new questionnaire
	* @return the new questionnaire
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire createQuestionnaire(
		long questionnaireId) {
		return _questionnaireLocalService.createQuestionnaire(questionnaireId);
	}

	/**
	* Deletes the questionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire that was removed
	* @throws PortalException if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire deleteQuestionnaire(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.deleteQuestionnaire(questionnaireId);
	}

	/**
	* Deletes the questionnaire from the database. Also notifies the appropriate model listeners.
	*
	* @param questionnaire the questionnaire
	* @return the questionnaire that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire deleteQuestionnaire(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.deleteQuestionnaire(questionnaire);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionnaireLocalService.dynamicQuery();
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
		return _questionnaireLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionnaireLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionnaireLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _questionnaireLocalService.dynamicQueryCount(dynamicQuery);
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
		return _questionnaireLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchQuestionnaire(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.fetchQuestionnaire(questionnaireId);
	}

	/**
	* Returns the questionnaire with the primary key.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire
	* @throws PortalException if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire getQuestionnaire(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.getQuestionnaire(questionnaireId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the questionnaires.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of questionnaires
	* @param end the upper bound of the range of questionnaires (not inclusive)
	* @return the range of questionnaires
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> getQuestionnaires(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.getQuestionnaires(start, end);
	}

	/**
	* Returns the number of questionnaires.
	*
	* @return the number of questionnaires
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getQuestionnairesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.getQuestionnairesCount();
	}

	/**
	* Updates the questionnaire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionnaire the questionnaire
	* @return the questionnaire that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire updateQuestionnaire(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.updateQuestionnaire(questionnaire);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _questionnaireLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_questionnaireLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _questionnaireLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaireLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public QuestionnaireLocalService getWrappedQuestionnaireLocalService() {
		return _questionnaireLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedQuestionnaireLocalService(
		QuestionnaireLocalService questionnaireLocalService) {
		_questionnaireLocalService = questionnaireLocalService;
	}

	@Override
	public QuestionnaireLocalService getWrappedService() {
		return _questionnaireLocalService;
	}

	@Override
	public void setWrappedService(
		QuestionnaireLocalService questionnaireLocalService) {
		_questionnaireLocalService = questionnaireLocalService;
	}

	private QuestionnaireLocalService _questionnaireLocalService;
}