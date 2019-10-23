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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SamlSpSessionLocalService}.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlSpSessionLocalService
 * @generated
 */
public class SamlSpSessionLocalServiceWrapper
	implements SamlSpSessionLocalService,
		ServiceWrapper<SamlSpSessionLocalService> {
	public SamlSpSessionLocalServiceWrapper(
		SamlSpSessionLocalService samlSpSessionLocalService) {
		_samlSpSessionLocalService = samlSpSessionLocalService;
	}

	/**
	* Adds the saml sp session to the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpSession the saml sp session
	* @return the saml sp session that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.saml.model.SamlSpSession addSamlSpSession(
		com.liferay.saml.model.SamlSpSession samlSpSession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.addSamlSpSession(samlSpSession);
	}

	/**
	* Creates a new saml sp session with the primary key. Does not add the saml sp session to the database.
	*
	* @param samlSpSessionId the primary key for the new saml sp session
	* @return the new saml sp session
	*/
	@Override
	public com.liferay.saml.model.SamlSpSession createSamlSpSession(
		long samlSpSessionId) {
		return _samlSpSessionLocalService.createSamlSpSession(samlSpSessionId);
	}

	/**
	* Deletes the saml sp session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpSessionId the primary key of the saml sp session
	* @return the saml sp session that was removed
	* @throws PortalException if a saml sp session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.saml.model.SamlSpSession deleteSamlSpSession(
		long samlSpSessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.deleteSamlSpSession(samlSpSessionId);
	}

	/**
	* Deletes the saml sp session from the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpSession the saml sp session
	* @return the saml sp session that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.saml.model.SamlSpSession deleteSamlSpSession(
		com.liferay.saml.model.SamlSpSession samlSpSession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.deleteSamlSpSession(samlSpSession);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _samlSpSessionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession fetchSamlSpSession(
		long samlSpSessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.fetchSamlSpSession(samlSpSessionId);
	}

	/**
	* Returns the saml sp session with the primary key.
	*
	* @param samlSpSessionId the primary key of the saml sp session
	* @return the saml sp session
	* @throws PortalException if a saml sp session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.saml.model.SamlSpSession getSamlSpSession(
		long samlSpSessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSession(samlSpSessionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the saml sp sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of saml sp sessions
	* @param end the upper bound of the range of saml sp sessions (not inclusive)
	* @return the range of saml sp sessions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.saml.model.SamlSpSession> getSamlSpSessions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSessions(start, end);
	}

	/**
	* Returns the number of saml sp sessions.
	*
	* @return the number of saml sp sessions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSamlSpSessionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSessionsCount();
	}

	/**
	* Updates the saml sp session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param samlSpSession the saml sp session
	* @return the saml sp session that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.saml.model.SamlSpSession updateSamlSpSession(
		com.liferay.saml.model.SamlSpSession samlSpSession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.updateSamlSpSession(samlSpSession);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _samlSpSessionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_samlSpSessionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _samlSpSessionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession addSamlSpSession(
		java.lang.String samlSpSessionKey, java.lang.String assertionXml,
		java.lang.String jSessionId, java.lang.String nameIdFormat,
		java.lang.String nameIdValue, java.lang.String sessionIndex,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.addSamlSpSession(samlSpSessionKey,
			assertionXml, jSessionId, nameIdFormat, nameIdValue, sessionIndex,
			serviceContext);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession fetchSamlSpSessionByJSessionId(
		java.lang.String jSessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.fetchSamlSpSessionByJSessionId(jSessionId);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession fetchSamlSpSessionBySamlSpSessionKey(
		java.lang.String samlSpSessionKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.fetchSamlSpSessionBySamlSpSessionKey(samlSpSessionKey);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession fetchSamlSpSessionBySessionIndex(
		java.lang.String sessionIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.fetchSamlSpSessionBySessionIndex(sessionIndex);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession getSamlSpSessionByJSessionId(
		java.lang.String jSessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSessionByJSessionId(jSessionId);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession getSamlSpSessionBySamlSpSessionKey(
		java.lang.String samlSpSessionKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSessionBySamlSpSessionKey(samlSpSessionKey);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession getSamlSpSessionBySessionIndex(
		java.lang.String sessionIndex)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSessionBySessionIndex(sessionIndex);
	}

	@Override
	public java.util.List<com.liferay.saml.model.SamlSpSession> getSamlSpSessions(
		java.lang.String nameIdValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.getSamlSpSessions(nameIdValue);
	}

	@Override
	public com.liferay.saml.model.SamlSpSession updateSamlSpSession(
		long samlSpSessionId, java.lang.String samlSpSessionKey,
		java.lang.String assertionXml, java.lang.String jSessionId,
		java.lang.String nameIdFormat, java.lang.String nameIdValue,
		java.lang.String sessionIndex,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _samlSpSessionLocalService.updateSamlSpSession(samlSpSessionId,
			samlSpSessionKey, assertionXml, jSessionId, nameIdFormat,
			nameIdValue, sessionIndex, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SamlSpSessionLocalService getWrappedSamlSpSessionLocalService() {
		return _samlSpSessionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSamlSpSessionLocalService(
		SamlSpSessionLocalService samlSpSessionLocalService) {
		_samlSpSessionLocalService = samlSpSessionLocalService;
	}

	@Override
	public SamlSpSessionLocalService getWrappedService() {
		return _samlSpSessionLocalService;
	}

	@Override
	public void setWrappedService(
		SamlSpSessionLocalService samlSpSessionLocalService) {
		_samlSpSessionLocalService = samlSpSessionLocalService;
	}

	private SamlSpSessionLocalService _samlSpSessionLocalService;
}