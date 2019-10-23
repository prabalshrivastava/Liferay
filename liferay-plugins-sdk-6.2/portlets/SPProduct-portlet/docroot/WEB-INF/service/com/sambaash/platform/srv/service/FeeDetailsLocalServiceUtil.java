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
 * Provides the local service utility for FeeDetails. This utility wraps
 * {@link com.sambaash.platform.srv.service.impl.FeeDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see FeeDetailsLocalService
 * @see com.sambaash.platform.srv.service.base.FeeDetailsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.impl.FeeDetailsLocalServiceImpl
 * @generated
 */
public class FeeDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.service.impl.FeeDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fee details to the database. Also notifies the appropriate model listeners.
	*
	* @param feeDetails the fee details
	* @return the fee details that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails addFeeDetails(
		com.sambaash.platform.srv.model.FeeDetails feeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFeeDetails(feeDetails);
	}

	/**
	* Creates a new fee details with the primary key. Does not add the fee details to the database.
	*
	* @param spFeeDetailsId the primary key for the new fee details
	* @return the new fee details
	*/
	public static com.sambaash.platform.srv.model.FeeDetails createFeeDetails(
		long spFeeDetailsId) {
		return getService().createFeeDetails(spFeeDetailsId);
	}

	/**
	* Deletes the fee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details that was removed
	* @throws PortalException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails deleteFeeDetails(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFeeDetails(spFeeDetailsId);
	}

	/**
	* Deletes the fee details from the database. Also notifies the appropriate model listeners.
	*
	* @param feeDetails the fee details
	* @return the fee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails deleteFeeDetails(
		com.sambaash.platform.srv.model.FeeDetails feeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFeeDetails(feeDetails);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.model.FeeDetails fetchFeeDetails(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFeeDetails(spFeeDetailsId);
	}

	/**
	* Returns the fee details with the primary key.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details
	* @throws PortalException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails getFeeDetails(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeeDetails(spFeeDetailsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> getFeeDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeeDetailses(start, end);
	}

	/**
	* Returns the number of fee detailses.
	*
	* @return the number of fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int getFeeDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeeDetailsesCount();
	}

	/**
	* Updates the fee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feeDetails the fee details
	* @return the fee details that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails updateFeeDetails(
		com.sambaash.platform.srv.model.FeeDetails feeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFeeDetails(feeDetails);
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

	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCourseIdAndGroupId(spCourseId, groupId);
	}

	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByFundIdAndSpCourseId(fundId, spCourseId);
	}

	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByFeeTypeAndCourseId(feeType, spCourseId);
	}

	public static com.sambaash.platform.srv.model.FeeDetails findByCourseIdFundIdFeeType(
		long courseId, long fundId, long feeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getService()
				   .findByCourseIdFundIdFeeType(courseId, fundId, feeTypeId);
	}

	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByFundId(fundId);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static com.sambaash.platform.srv.model.FeeDetails create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static com.sambaash.platform.srv.model.FeeDetails findByFundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getService().findByFundIdFeeType(fundId, feeType);
	}

	public static void clearService() {
		_service = null;
	}

	public static FeeDetailsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FeeDetailsLocalService.class.getName());

			if (invokableLocalService instanceof FeeDetailsLocalService) {
				_service = (FeeDetailsLocalService)invokableLocalService;
			}
			else {
				_service = new FeeDetailsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FeeDetailsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FeeDetailsLocalService service) {
	}

	private static FeeDetailsLocalService _service;
}