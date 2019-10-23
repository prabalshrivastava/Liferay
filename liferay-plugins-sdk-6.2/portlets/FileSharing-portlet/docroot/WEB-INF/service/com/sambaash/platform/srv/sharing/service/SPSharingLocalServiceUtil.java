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

package com.sambaash.platform.srv.sharing.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPSharing. This utility wraps
 * {@link com.sambaash.platform.srv.sharing.service.impl.SPSharingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see SPSharingLocalService
 * @see com.sambaash.platform.srv.sharing.service.base.SPSharingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sharing.service.impl.SPSharingLocalServiceImpl
 * @generated
 */
public class SPSharingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.sharing.service.impl.SPSharingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p sharing to the database. Also notifies the appropriate model listeners.
	*
	* @param spSharing the s p sharing
	* @return the s p sharing that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sharing.model.SPSharing addSPSharing(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPSharing(spSharing);
	}

	/**
	* Creates a new s p sharing with the primary key. Does not add the s p sharing to the database.
	*
	* @param spSharingId the primary key for the new s p sharing
	* @return the new s p sharing
	*/
	public static com.sambaash.platform.srv.sharing.model.SPSharing createSPSharing(
		long spSharingId) {
		return getService().createSPSharing(spSharingId);
	}

	/**
	* Deletes the s p sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing that was removed
	* @throws PortalException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sharing.model.SPSharing deleteSPSharing(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSharing(spSharingId);
	}

	/**
	* Deletes the s p sharing from the database. Also notifies the appropriate model listeners.
	*
	* @param spSharing the s p sharing
	* @return the s p sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sharing.model.SPSharing deleteSPSharing(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSharing(spSharing);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.sharing.model.SPSharing fetchSPSharing(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPSharing(spSharingId);
	}

	/**
	* Returns the s p sharing with the primary key.
	*
	* @param spSharingId the primary key of the s p sharing
	* @return the s p sharing
	* @throws PortalException if a s p sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sharing.model.SPSharing getSPSharing(
		long spSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSharing(spSharingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sharings
	* @param end the upper bound of the range of s p sharings (not inclusive)
	* @return the range of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getSPSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSharings(start, end);
	}

	/**
	* Returns the number of s p sharings.
	*
	* @return the number of s p sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSharingsCount();
	}

	/**
	* Updates the s p sharing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSharing the s p sharing
	* @return the s p sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sharing.model.SPSharing updateSPSharing(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPSharing(spSharing);
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

	public static com.sambaash.platform.srv.sharing.model.SPSharing getSharing(
		long userId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService().getSharing(userId, classNameId, classPK);
	}

	public static com.sambaash.platform.srv.sharing.model.SPSharing getSharing(
		long userId, long classNameId, long classPK, boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService()
				   .getSharing(userId, classNameId, classPK, internalShare);
	}

	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getSharing(
		long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService().getSharing(classPK, classNameId);
	}

	public static com.sambaash.platform.srv.sharing.model.SPSharing getSharing(
		java.lang.String emailAddress, long classNameId, long classPK,
		boolean internalShare)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService()
				   .getSharing(emailAddress, classNameId, classPK, internalShare);
	}

	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getFileSharing(
		long createdBy, long classPK, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFileSharing(createdBy, classPK, classNameId);
	}

	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharings(
		long userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService().getUserSharings(userId, date);
	}

	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharedFiles(
		long userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService().getUserSharedFiles(userId, date);
	}

	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharedFiles(
		long userId, java.util.Date date, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService().getUserSharedFiles(userId, date, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.sharing.model.SPSharing> getUserSharingByEmail(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sharing.NoSuchSPSharingException {
		return getService().getUserSharingByEmail(emailAddress);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPSharingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPSharingLocalService.class.getName());

			if (invokableLocalService instanceof SPSharingLocalService) {
				_service = (SPSharingLocalService)invokableLocalService;
			}
			else {
				_service = new SPSharingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPSharingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPSharingLocalService service) {
	}

	private static SPSharingLocalService _service;
}