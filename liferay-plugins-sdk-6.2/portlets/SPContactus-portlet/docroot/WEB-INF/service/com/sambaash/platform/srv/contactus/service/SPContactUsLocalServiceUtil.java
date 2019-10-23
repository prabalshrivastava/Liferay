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

package com.sambaash.platform.srv.contactus.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPContactUs. This utility wraps
 * {@link com.sambaash.platform.srv.contactus.service.impl.SPContactUsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPContactUsLocalService
 * @see com.sambaash.platform.srv.contactus.service.base.SPContactUsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.contactus.service.impl.SPContactUsLocalServiceImpl
 * @generated
 */
public class SPContactUsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.contactus.service.impl.SPContactUsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p contact us to the database. Also notifies the appropriate model listeners.
	*
	* @param spContactUs the s p contact us
	* @return the s p contact us that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.contactus.model.SPContactUs addSPContactUs(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPContactUs(spContactUs);
	}

	/**
	* Creates a new s p contact us with the primary key. Does not add the s p contact us to the database.
	*
	* @param spContactUsId the primary key for the new s p contact us
	* @return the new s p contact us
	*/
	public static com.sambaash.platform.srv.contactus.model.SPContactUs createSPContactUs(
		long spContactUsId) {
		return getService().createSPContactUs(spContactUsId);
	}

	/**
	* Deletes the s p contact us with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spContactUsId the primary key of the s p contact us
	* @return the s p contact us that was removed
	* @throws PortalException if a s p contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.contactus.model.SPContactUs deleteSPContactUs(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPContactUs(spContactUsId);
	}

	/**
	* Deletes the s p contact us from the database. Also notifies the appropriate model listeners.
	*
	* @param spContactUs the s p contact us
	* @return the s p contact us that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.contactus.model.SPContactUs deleteSPContactUs(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPContactUs(spContactUs);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.contactus.model.SPContactUs fetchSPContactUs(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPContactUs(spContactUsId);
	}

	/**
	* Returns the s p contact us with the primary key.
	*
	* @param spContactUsId the primary key of the s p contact us
	* @return the s p contact us
	* @throws PortalException if a s p contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.contactus.model.SPContactUs getSPContactUs(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPContactUs(spContactUsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p contact uses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p contact uses
	* @param end the upper bound of the range of s p contact uses (not inclusive)
	* @return the range of s p contact uses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.contactus.model.SPContactUs> getSPContactUses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPContactUses(start, end);
	}

	/**
	* Returns the number of s p contact uses.
	*
	* @return the number of s p contact uses
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPContactUsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPContactUsesCount();
	}

	/**
	* Updates the s p contact us in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spContactUs the s p contact us
	* @return the s p contact us that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.contactus.model.SPContactUs updateSPContactUs(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPContactUs(spContactUs);
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

	public static void create(java.lang.String name,
		java.lang.String emailAddress, java.lang.String category,
		java.lang.String comment, java.lang.String countryName,
		long contactNumber, java.lang.String lastName,
		java.lang.String company, java.lang.String jobTitle,
		java.lang.String companyUrl, long noofemployee, java.lang.String rate,
		java.lang.String typeofenquiry, java.lang.String emLocationOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.create(name, emailAddress, category, comment, countryName,
			contactNumber, lastName, company, jobTitle, companyUrl,
			noofemployee, rate, typeofenquiry, emLocationOffice);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPContactUsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPContactUsLocalService.class.getName());

			if (invokableLocalService instanceof SPContactUsLocalService) {
				_service = (SPContactUsLocalService)invokableLocalService;
			}
			else {
				_service = new SPContactUsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPContactUsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPContactUsLocalService service) {
	}

	private static SPContactUsLocalService _service;
}