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

package com.liferay.saml.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SamlSpMessage. This utility wraps
 * {@link com.liferay.saml.service.impl.SamlSpMessageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlSpMessageLocalService
 * @see com.liferay.saml.service.base.SamlSpMessageLocalServiceBaseImpl
 * @see com.liferay.saml.service.impl.SamlSpMessageLocalServiceImpl
 * @generated
 */
public class SamlSpMessageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.saml.service.impl.SamlSpMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the saml sp message to the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpMessage the saml sp message
	* @return the saml sp message that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.saml.model.SamlSpMessage addSamlSpMessage(
		com.liferay.saml.model.SamlSpMessage samlSpMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSamlSpMessage(samlSpMessage);
	}

	/**
	* Creates a new saml sp message with the primary key. Does not add the saml sp message to the database.
	*
	* @param samlSpMessageId the primary key for the new saml sp message
	* @return the new saml sp message
	*/
	public static com.liferay.saml.model.SamlSpMessage createSamlSpMessage(
		long samlSpMessageId) {
		return getService().createSamlSpMessage(samlSpMessageId);
	}

	/**
	* Deletes the saml sp message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpMessageId the primary key of the saml sp message
	* @return the saml sp message that was removed
	* @throws PortalException if a saml sp message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.saml.model.SamlSpMessage deleteSamlSpMessage(
		long samlSpMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSamlSpMessage(samlSpMessageId);
	}

	/**
	* Deletes the saml sp message from the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpMessage the saml sp message
	* @return the saml sp message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.saml.model.SamlSpMessage deleteSamlSpMessage(
		com.liferay.saml.model.SamlSpMessage samlSpMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSamlSpMessage(samlSpMessage);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.saml.model.SamlSpMessage fetchSamlSpMessage(
		long samlSpMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSamlSpMessage(samlSpMessageId);
	}

	/**
	* Returns the saml sp message with the primary key.
	*
	* @param samlSpMessageId the primary key of the saml sp message
	* @return the saml sp message
	* @throws PortalException if a saml sp message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.saml.model.SamlSpMessage getSamlSpMessage(
		long samlSpMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSamlSpMessage(samlSpMessageId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the saml sp messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of saml sp messages
	* @param end the upper bound of the range of saml sp messages (not inclusive)
	* @return the range of saml sp messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.saml.model.SamlSpMessage> getSamlSpMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSamlSpMessages(start, end);
	}

	/**
	* Returns the number of saml sp messages.
	*
	* @return the number of saml sp messages
	* @throws SystemException if a system exception occurred
	*/
	public static int getSamlSpMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSamlSpMessagesCount();
	}

	/**
	* Updates the saml sp message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param samlSpMessage the saml sp message
	* @return the saml sp message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.saml.model.SamlSpMessage updateSamlSpMessage(
		com.liferay.saml.model.SamlSpMessage samlSpMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSamlSpMessage(samlSpMessage);
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

	public static com.liferay.saml.model.SamlSpMessage addSamlSpMessage(
		java.lang.String samlIdpEntityId, java.lang.String samlIdpResponseKey,
		java.util.Date expirationDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSamlSpMessage(samlIdpEntityId, samlIdpResponseKey,
			expirationDate, serviceContext);
	}

	public static com.liferay.saml.model.SamlSpMessage fetchSamlSpMessage(
		java.lang.String samlIdpEntityId, java.lang.String samlIdpResponseKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSamlSpMessage(samlIdpEntityId, samlIdpResponseKey);
	}

	public static com.liferay.saml.model.SamlSpMessage getSamlSpMessage(
		java.lang.String samlIdpEntityId, java.lang.String samlIdpResponseKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSamlSpMessage(samlIdpEntityId, samlIdpResponseKey);
	}

	public static void clearService() {
		_service = null;
	}

	public static SamlSpMessageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SamlSpMessageLocalService.class.getName());

			if (invokableLocalService instanceof SamlSpMessageLocalService) {
				_service = (SamlSpMessageLocalService)invokableLocalService;
			}
			else {
				_service = new SamlSpMessageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SamlSpMessageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SamlSpMessageLocalService service) {
	}

	private static SamlSpMessageLocalService _service;
}