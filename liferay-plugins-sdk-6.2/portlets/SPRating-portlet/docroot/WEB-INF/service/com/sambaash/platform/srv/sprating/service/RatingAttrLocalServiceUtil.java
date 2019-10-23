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

package com.sambaash.platform.srv.sprating.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RatingAttr. This utility wraps
 * {@link com.sambaash.platform.srv.sprating.service.impl.RatingAttrLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see RatingAttrLocalService
 * @see com.sambaash.platform.srv.sprating.service.base.RatingAttrLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sprating.service.impl.RatingAttrLocalServiceImpl
 * @generated
 */
public class RatingAttrLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.sprating.service.impl.RatingAttrLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rating attr to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingAttr the rating attr
	* @return the rating attr that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr addRatingAttr(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRatingAttr(ratingAttr);
	}

	/**
	* Creates a new rating attr with the primary key. Does not add the rating attr to the database.
	*
	* @param spRatingAttrId the primary key for the new rating attr
	* @return the new rating attr
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr createRatingAttr(
		long spRatingAttrId) {
		return getService().createRatingAttr(spRatingAttrId);
	}

	/**
	* Deletes the rating attr with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRatingAttrId the primary key of the rating attr
	* @return the rating attr that was removed
	* @throws PortalException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr deleteRatingAttr(
		long spRatingAttrId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRatingAttr(spRatingAttrId);
	}

	/**
	* Deletes the rating attr from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingAttr the rating attr
	* @return the rating attr that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr deleteRatingAttr(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRatingAttr(ratingAttr);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.sprating.model.RatingAttr fetchRatingAttr(
		long spRatingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRatingAttr(spRatingAttrId);
	}

	/**
	* Returns the rating attr with the matching UUID and company.
	*
	* @param uuid the rating attr's UUID
	* @param companyId the primary key of the company
	* @return the matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr fetchRatingAttrByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRatingAttrByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rating attr matching the UUID and group.
	*
	* @param uuid the rating attr's UUID
	* @param groupId the primary key of the group
	* @return the matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr fetchRatingAttrByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRatingAttrByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rating attr with the primary key.
	*
	* @param spRatingAttrId the primary key of the rating attr
	* @return the rating attr
	* @throws PortalException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr getRatingAttr(
		long spRatingAttrId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingAttr(spRatingAttrId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rating attr with the matching UUID and company.
	*
	* @param uuid the rating attr's UUID
	* @param companyId the primary key of the company
	* @return the matching rating attr
	* @throws PortalException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr getRatingAttrByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingAttrByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rating attr matching the UUID and group.
	*
	* @param uuid the rating attr's UUID
	* @param groupId the primary key of the group
	* @return the matching rating attr
	* @throws PortalException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr getRatingAttrByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingAttrByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rating attrs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> getRatingAttrs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingAttrs(start, end);
	}

	/**
	* Returns the number of rating attrs.
	*
	* @return the number of rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public static int getRatingAttrsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingAttrsCount();
	}

	/**
	* Updates the rating attr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingAttr the rating attr
	* @return the rating attr that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.RatingAttr updateRatingAttr(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRatingAttr(ratingAttr);
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

	public static com.sambaash.platform.srv.sprating.model.RatingAttr getNewRatingAttr()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewRatingAttr();
	}

	public static com.sambaash.platform.srv.sprating.model.RatingAttr addRatingAttr(
		java.lang.String name, boolean visible, double weight,
		long componentId, com.liferay.portal.model.User user)
		throws java.lang.Exception {
		return getService()
				   .addRatingAttr(name, visible, weight, componentId, user);
	}

	public static long generateNewRatingAttrId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().generateNewRatingAttrId();
	}

	public static java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findRatingAttrsByComponentId(
		long componentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findRatingAttrsByComponentId(componentId);
	}

	public static void clearService() {
		_service = null;
	}

	public static RatingAttrLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RatingAttrLocalService.class.getName());

			if (invokableLocalService instanceof RatingAttrLocalService) {
				_service = (RatingAttrLocalService)invokableLocalService;
			}
			else {
				_service = new RatingAttrLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RatingAttrLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RatingAttrLocalService service) {
	}

	private static RatingAttrLocalService _service;
}