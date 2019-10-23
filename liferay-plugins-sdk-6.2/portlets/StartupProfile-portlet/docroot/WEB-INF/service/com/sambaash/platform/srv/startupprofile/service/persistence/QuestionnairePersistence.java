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

package com.sambaash.platform.srv.startupprofile.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.startupprofile.model.Questionnaire;

/**
 * The persistence interface for the questionnaire service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see QuestionnairePersistenceImpl
 * @see QuestionnaireUtil
 * @generated
 */
public interface QuestionnairePersistence extends BasePersistence<Questionnaire> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionnaireUtil} to access the questionnaire persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException} if it could not be found.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the matching questionnaire
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a matching questionnaire could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire findByIDAndClass(
		long entryClassPK, java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException;

	/**
	* Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the matching questionnaire, or <code>null</code> if a matching questionnaire could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchByIDAndClass(
		long entryClassPK, java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching questionnaire, or <code>null</code> if a matching questionnaire could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchByIDAndClass(
		long entryClassPK, java.lang.String entryClassName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the questionnaire where entryClassPK = &#63; and entryClassName = &#63; from the database.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the questionnaire that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire removeByIDAndClass(
		long entryClassPK, java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException;

	/**
	* Returns the number of questionnaires where entryClassPK = &#63; and entryClassName = &#63;.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the number of matching questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public int countByIDAndClass(long entryClassPK,
		java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the questionnaire in the entity cache if it is enabled.
	*
	* @param questionnaire the questionnaire
	*/
	public void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire);

	/**
	* Caches the questionnaires in the entity cache if it is enabled.
	*
	* @param questionnaires the questionnaires
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> questionnaires);

	/**
	* Creates a new questionnaire with the primary key. Does not add the questionnaire to the database.
	*
	* @param questionnaireId the primary key for the new questionnaire
	* @return the new questionnaire
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire create(
		long questionnaireId);

	/**
	* Removes the questionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire remove(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException;

	public com.sambaash.platform.srv.startupprofile.model.Questionnaire updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the questionnaire with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException} if it could not be found.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire findByPrimaryKey(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException;

	/**
	* Returns the questionnaire with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire, or <code>null</code> if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchByPrimaryKey(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the questionnaires.
	*
	* @return the questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the questionnaires.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of questionnaires
	* @param end the upper bound of the range of questionnaires (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the questionnaires from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of questionnaires.
	*
	* @return the number of questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}