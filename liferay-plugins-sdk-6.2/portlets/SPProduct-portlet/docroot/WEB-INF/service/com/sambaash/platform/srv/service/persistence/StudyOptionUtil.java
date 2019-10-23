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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.StudyOption;

import java.util.List;

/**
 * The persistence utility for the study option service. This utility wraps {@link StudyOptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudyOptionPersistence
 * @see StudyOptionPersistenceImpl
 * @generated
 */
public class StudyOptionUtil {
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
	public static void clearCache(StudyOption studyOption) {
		getPersistence().clearCache(studyOption);
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
	public static List<StudyOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudyOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudyOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StudyOption update(StudyOption studyOption)
		throws SystemException {
		return getPersistence().update(studyOption);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StudyOption update(StudyOption studyOption,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(studyOption, serviceContext);
	}

	/**
	* Returns all the study options where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the matching study options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(spCourseId);
	}

	/**
	* Returns a range of all the study options where spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @return the range of matching study options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(spCourseId, start, end);
	}

	/**
	* Returns an ordered range of all the study options where spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching study options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudyOption> findByCourseId(
		long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseId(spCourseId, start, end, orderByComparator);
	}

	/**
	* Returns the first study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption findByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException {
		return getPersistence()
				   .findByCourseId_First(spCourseId, orderByComparator);
	}

	/**
	* Returns the first study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching study option, or <code>null</code> if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption fetchByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId_First(spCourseId, orderByComparator);
	}

	/**
	* Returns the last study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption findByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException {
		return getPersistence()
				   .findByCourseId_Last(spCourseId, orderByComparator);
	}

	/**
	* Returns the last study option in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching study option, or <code>null</code> if a matching study option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption fetchByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId_Last(spCourseId, orderByComparator);
	}

	/**
	* Returns the study options before and after the current study option in the ordered set where spCourseId = &#63;.
	*
	* @param spStudyOptionId the primary key of the current study option
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption[] findByCourseId_PrevAndNext(
		long spStudyOptionId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException {
		return getPersistence()
				   .findByCourseId_PrevAndNext(spStudyOptionId, spCourseId,
			orderByComparator);
	}

	/**
	* Removes all the study options where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseId(spCourseId);
	}

	/**
	* Returns the number of study options where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching study options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(spCourseId);
	}

	/**
	* Caches the study option in the entity cache if it is enabled.
	*
	* @param studyOption the study option
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.StudyOption studyOption) {
		getPersistence().cacheResult(studyOption);
	}

	/**
	* Caches the study options in the entity cache if it is enabled.
	*
	* @param studyOptions the study options
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.StudyOption> studyOptions) {
		getPersistence().cacheResult(studyOptions);
	}

	/**
	* Creates a new study option with the primary key. Does not add the study option to the database.
	*
	* @param spStudyOptionId the primary key for the new study option
	* @return the new study option
	*/
	public static com.sambaash.platform.srv.model.StudyOption create(
		long spStudyOptionId) {
		return getPersistence().create(spStudyOptionId);
	}

	/**
	* Removes the study option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option that was removed
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption remove(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException {
		return getPersistence().remove(spStudyOptionId);
	}

	public static com.sambaash.platform.srv.model.StudyOption updateImpl(
		com.sambaash.platform.srv.model.StudyOption studyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(studyOption);
	}

	/**
	* Returns the study option with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchStudyOptionException} if it could not be found.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option
	* @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption findByPrimaryKey(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudyOptionException {
		return getPersistence().findByPrimaryKey(spStudyOptionId);
	}

	/**
	* Returns the study option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spStudyOptionId the primary key of the study option
	* @return the study option, or <code>null</code> if a study option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.StudyOption fetchByPrimaryKey(
		long spStudyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spStudyOptionId);
	}

	/**
	* Returns all the study options.
	*
	* @return the study options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudyOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.model.StudyOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the study options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of study options
	* @param end the upper bound of the range of study options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of study options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.StudyOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the study options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of study options.
	*
	* @return the number of study options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudyOptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudyOptionPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					StudyOptionPersistence.class.getName());

			ReferenceRegistry.registerReference(StudyOptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StudyOptionPersistence persistence) {
	}

	private static StudyOptionPersistence _persistence;
}