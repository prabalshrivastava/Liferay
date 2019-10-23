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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.startupprofile.model.Questionnaire;

import java.util.List;

/**
 * The persistence utility for the questionnaire service. This utility wraps {@link QuestionnairePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see QuestionnairePersistence
 * @see QuestionnairePersistenceImpl
 * @generated
 */
public class QuestionnaireUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Questionnaire questionnaire) {
		getPersistence().clearCache(questionnaire);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Questionnaire> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Questionnaire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Questionnaire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Questionnaire update(Questionnaire questionnaire)
		throws SystemException {
		return getPersistence().update(questionnaire);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Questionnaire update(Questionnaire questionnaire,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(questionnaire, serviceContext);
	}

	/**
	* Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException} if it could not be found.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the matching questionnaire
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a matching questionnaire could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire findByIDAndClass(
		long entryClassPK, java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException {
		return getPersistence().findByIDAndClass(entryClassPK, entryClassName);
	}

	/**
	* Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the matching questionnaire, or <code>null</code> if a matching questionnaire could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchByIDAndClass(
		long entryClassPK, java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIDAndClass(entryClassPK, entryClassName);
	}

	/**
	* Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching questionnaire, or <code>null</code> if a matching questionnaire could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchByIDAndClass(
		long entryClassPK, java.lang.String entryClassName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIDAndClass(entryClassPK, entryClassName,
			retrieveFromCache);
	}

	/**
	* Removes the questionnaire where entryClassPK = &#63; and entryClassName = &#63; from the database.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the questionnaire that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire removeByIDAndClass(
		long entryClassPK, java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException {
		return getPersistence().removeByIDAndClass(entryClassPK, entryClassName);
	}

	/**
	* Returns the number of questionnaires where entryClassPK = &#63; and entryClassName = &#63;.
	*
	* @param entryClassPK the entry class p k
	* @param entryClassName the entry class name
	* @return the number of matching questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIDAndClass(long entryClassPK,
		java.lang.String entryClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIDAndClass(entryClassPK, entryClassName);
	}

	/**
	* Caches the questionnaire in the entity cache if it is enabled.
	*
	* @param questionnaire the questionnaire
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire) {
		getPersistence().cacheResult(questionnaire);
	}

	/**
	* Caches the questionnaires in the entity cache if it is enabled.
	*
	* @param questionnaires the questionnaires
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> questionnaires) {
		getPersistence().cacheResult(questionnaires);
	}

	/**
	* Creates a new questionnaire with the primary key. Does not add the questionnaire to the database.
	*
	* @param questionnaireId the primary key for the new questionnaire
	* @return the new questionnaire
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire create(
		long questionnaireId) {
		return getPersistence().create(questionnaireId);
	}

	/**
	* Removes the questionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire that was removed
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire remove(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException {
		return getPersistence().remove(questionnaireId);
	}

	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(questionnaire);
	}

	/**
	* Returns the questionnaire with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException} if it could not be found.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire
	* @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire findByPrimaryKey(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException {
		return getPersistence().findByPrimaryKey(questionnaireId);
	}

	/**
	* Returns the questionnaire with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionnaireId the primary key of the questionnaire
	* @return the questionnaire, or <code>null</code> if a questionnaire with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.Questionnaire fetchByPrimaryKey(
		long questionnaireId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(questionnaireId);
	}

	/**
	* Returns all the questionnaires.
	*
	* @return the questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.Questionnaire> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the questionnaires from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of questionnaires.
	*
	* @return the number of questionnaires
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QuestionnairePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionnairePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.startupprofile.service.ClpSerializer.getServletContextName(),
					QuestionnairePersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionnaireUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(QuestionnairePersistence persistence) {
	}

	private static QuestionnairePersistence _persistence;
}