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
 * Provides the local service utility for AttrRate. This utility wraps
 * {@link com.sambaash.platform.srv.sprating.service.impl.AttrRateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see AttrRateLocalService
 * @see com.sambaash.platform.srv.sprating.service.base.AttrRateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sprating.service.impl.AttrRateLocalServiceImpl
 * @generated
 */
public class AttrRateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.sprating.service.impl.AttrRateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the attr rate to the database. Also notifies the appropriate model listeners.
	*
	* @param attrRate the attr rate
	* @return the attr rate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate addAttrRate(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAttrRate(attrRate);
	}

	/**
	* Creates a new attr rate with the primary key. Does not add the attr rate to the database.
	*
	* @param spAttrRateId the primary key for the new attr rate
	* @return the new attr rate
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate createAttrRate(
		long spAttrRateId) {
		return getService().createAttrRate(spAttrRateId);
	}

	/**
	* Deletes the attr rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAttrRateId the primary key of the attr rate
	* @return the attr rate that was removed
	* @throws PortalException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate deleteAttrRate(
		long spAttrRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAttrRate(spAttrRateId);
	}

	/**
	* Deletes the attr rate from the database. Also notifies the appropriate model listeners.
	*
	* @param attrRate the attr rate
	* @return the attr rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate deleteAttrRate(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAttrRate(attrRate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchAttrRate(
		long spAttrRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAttrRate(spAttrRateId);
	}

	/**
	* Returns the attr rate with the matching UUID and company.
	*
	* @param uuid the attr rate's UUID
	* @param companyId the primary key of the company
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchAttrRateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAttrRateByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the attr rate matching the UUID and group.
	*
	* @param uuid the attr rate's UUID
	* @param groupId the primary key of the group
	* @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate fetchAttrRateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAttrRateByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the attr rate with the primary key.
	*
	* @param spAttrRateId the primary key of the attr rate
	* @return the attr rate
	* @throws PortalException if a attr rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate getAttrRate(
		long spAttrRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttrRate(spAttrRateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the attr rate with the matching UUID and company.
	*
	* @param uuid the attr rate's UUID
	* @param companyId the primary key of the company
	* @return the matching attr rate
	* @throws PortalException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate getAttrRateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttrRateByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the attr rate matching the UUID and group.
	*
	* @param uuid the attr rate's UUID
	* @param groupId the primary key of the group
	* @return the matching attr rate
	* @throws PortalException if a matching attr rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate getAttrRateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttrRateByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the attr rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attr rates
	* @param end the upper bound of the range of attr rates (not inclusive)
	* @return the range of attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> getAttrRates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttrRates(start, end);
	}

	/**
	* Returns the number of attr rates.
	*
	* @return the number of attr rates
	* @throws SystemException if a system exception occurred
	*/
	public static int getAttrRatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttrRatesCount();
	}

	/**
	* Updates the attr rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param attrRate the attr rate
	* @return the attr rate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sprating.model.AttrRate updateAttrRate(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAttrRate(attrRate);
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

	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByUserIdClassNameIdObjId(
		long userId, long classNameId, java.lang.String objId) {
		return getService()
				   .findByUserIdClassNameIdObjId(userId, classNameId, objId);
	}

	public static com.sambaash.platform.srv.sprating.model.AttrRate findByUserIdRatingAttrIdObjId(
		long userId, long ratingAttrId, java.lang.String objId) {
		return getService()
				   .findByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId);
	}

	public static java.util.List<com.sambaash.platform.srv.sprating.model.AttrRate> findByRatingAttrIdObjId(
		long ratingAttrId, java.lang.String objId) {
		return getService().findByRatingAttrIdObjId(ratingAttrId, objId);
	}

	public static long generateAttrRateId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().generateAttrRateId();
	}

	public static com.sambaash.platform.srv.sprating.model.AttrRate createAttrRate()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createAttrRate();
	}

	public static com.sambaash.platform.srv.sprating.model.AttrRate addAttrRate(
		java.lang.String objId, long ratingAttrId, long classNameId,
		double rateValue, long companyId, long groupId,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAttrRate(objId, ratingAttrId, classNameId, rateValue,
			companyId, groupId, user);
	}

	public static void clearService() {
		_service = null;
	}

	public static AttrRateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AttrRateLocalService.class.getName());

			if (invokableLocalService instanceof AttrRateLocalService) {
				_service = (AttrRateLocalService)invokableLocalService;
			}
			else {
				_service = new AttrRateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AttrRateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AttrRateLocalService service) {
	}

	private static AttrRateLocalService _service;
}