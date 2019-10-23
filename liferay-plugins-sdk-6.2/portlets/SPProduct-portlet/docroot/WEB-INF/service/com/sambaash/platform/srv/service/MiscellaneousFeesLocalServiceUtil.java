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
 * Provides the local service utility for MiscellaneousFees. This utility wraps
 * {@link com.sambaash.platform.srv.service.impl.MiscellaneousFeesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see MiscellaneousFeesLocalService
 * @see com.sambaash.platform.srv.service.base.MiscellaneousFeesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.impl.MiscellaneousFeesLocalServiceImpl
 * @generated
 */
public class MiscellaneousFeesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.service.impl.MiscellaneousFeesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the miscellaneous fees to the database. Also notifies the appropriate model listeners.
	*
	* @param miscellaneousFees the miscellaneous fees
	* @return the miscellaneous fees that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees addMiscellaneousFees(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMiscellaneousFees(miscellaneousFees);
	}

	/**
	* Creates a new miscellaneous fees with the primary key. Does not add the miscellaneous fees to the database.
	*
	* @param spMiscFeesId the primary key for the new miscellaneous fees
	* @return the new miscellaneous fees
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees createMiscellaneousFees(
		long spMiscFeesId) {
		return getService().createMiscellaneousFees(spMiscFeesId);
	}

	/**
	* Deletes the miscellaneous fees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMiscFeesId the primary key of the miscellaneous fees
	* @return the miscellaneous fees that was removed
	* @throws PortalException if a miscellaneous fees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees deleteMiscellaneousFees(
		long spMiscFeesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMiscellaneousFees(spMiscFeesId);
	}

	/**
	* Deletes the miscellaneous fees from the database. Also notifies the appropriate model listeners.
	*
	* @param miscellaneousFees the miscellaneous fees
	* @return the miscellaneous fees that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees deleteMiscellaneousFees(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMiscellaneousFees(miscellaneousFees);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.model.MiscellaneousFees fetchMiscellaneousFees(
		long spMiscFeesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMiscellaneousFees(spMiscFeesId);
	}

	/**
	* Returns the miscellaneous fees with the primary key.
	*
	* @param spMiscFeesId the primary key of the miscellaneous fees
	* @return the miscellaneous fees
	* @throws PortalException if a miscellaneous fees with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees getMiscellaneousFees(
		long spMiscFeesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMiscellaneousFees(spMiscFeesId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the miscellaneous feeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of miscellaneous feeses
	* @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	* @return the range of miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> getMiscellaneousFeeses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMiscellaneousFeeses(start, end);
	}

	/**
	* Returns the number of miscellaneous feeses.
	*
	* @return the number of miscellaneous feeses
	* @throws SystemException if a system exception occurred
	*/
	public static int getMiscellaneousFeesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMiscellaneousFeesesCount();
	}

	/**
	* Updates the miscellaneous fees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param miscellaneousFees the miscellaneous fees
	* @return the miscellaneous fees that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.MiscellaneousFees updateMiscellaneousFees(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMiscellaneousFees(miscellaneousFees);
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

	public static java.util.List<com.sambaash.platform.srv.model.MiscellaneousFees> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCourseIdAndGroupId(spCourseId, groupId);
	}

	public static com.sambaash.platform.srv.model.MiscellaneousFees findByCourseIdFeeType(
		long courseId, long feeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchMiscellaneousFeesException {
		return getService().findByCourseIdFeeType(courseId, feeTypeId);
	}

	public static com.sambaash.platform.srv.model.MiscellaneousFees create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearService() {
		_service = null;
	}

	public static MiscellaneousFeesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MiscellaneousFeesLocalService.class.getName());

			if (invokableLocalService instanceof MiscellaneousFeesLocalService) {
				_service = (MiscellaneousFeesLocalService)invokableLocalService;
			}
			else {
				_service = new MiscellaneousFeesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MiscellaneousFeesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MiscellaneousFeesLocalService service) {
	}

	private static MiscellaneousFeesLocalService _service;
}