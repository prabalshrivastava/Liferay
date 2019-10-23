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

package com.sambaash.platform.srv.mail.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPEMailAuditLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPEMailAuditLocalService
 * @generated
 */
public class SPEMailAuditLocalServiceWrapper implements SPEMailAuditLocalService,
	ServiceWrapper<SPEMailAuditLocalService> {
	public SPEMailAuditLocalServiceWrapper(
		SPEMailAuditLocalService speMailAuditLocalService) {
		_speMailAuditLocalService = speMailAuditLocalService;
	}

	/**
	* Adds the s p e mail audit to the database. Also notifies the appropriate model listeners.
	*
	* @param speMailAudit the s p e mail audit
	* @return the s p e mail audit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit addSPEMailAudit(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.addSPEMailAudit(speMailAudit);
	}

	/**
	* Creates a new s p e mail audit with the primary key. Does not add the s p e mail audit to the database.
	*
	* @param spEMailAudit the primary key for the new s p e mail audit
	* @return the new s p e mail audit
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit createSPEMailAudit(
		long spEMailAudit) {
		return _speMailAuditLocalService.createSPEMailAudit(spEMailAudit);
	}

	/**
	* Deletes the s p e mail audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spEMailAudit the primary key of the s p e mail audit
	* @return the s p e mail audit that was removed
	* @throws PortalException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit deleteSPEMailAudit(
		long spEMailAudit)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.deleteSPEMailAudit(spEMailAudit);
	}

	/**
	* Deletes the s p e mail audit from the database. Also notifies the appropriate model listeners.
	*
	* @param speMailAudit the s p e mail audit
	* @return the s p e mail audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit deleteSPEMailAudit(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.deleteSPEMailAudit(speMailAudit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _speMailAuditLocalService.dynamicQuery();
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
		return _speMailAuditLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _speMailAuditLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _speMailAuditLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _speMailAuditLocalService.dynamicQueryCount(dynamicQuery);
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
		return _speMailAuditLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit fetchSPEMailAudit(
		long spEMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.fetchSPEMailAudit(spEMailAudit);
	}

	/**
	* Returns the s p e mail audit with the primary key.
	*
	* @param spEMailAudit the primary key of the s p e mail audit
	* @return the s p e mail audit
	* @throws PortalException if a s p e mail audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit getSPEMailAudit(
		long spEMailAudit)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.getSPEMailAudit(spEMailAudit);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p e mail audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p e mail audits
	* @param end the upper bound of the range of s p e mail audits (not inclusive)
	* @return the range of s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> getSPEMailAudits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.getSPEMailAudits(start, end);
	}

	/**
	* Returns the number of s p e mail audits.
	*
	* @return the number of s p e mail audits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPEMailAuditsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.getSPEMailAuditsCount();
	}

	/**
	* Updates the s p e mail audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param speMailAudit the s p e mail audit
	* @return the s p e mail audit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit updateSPEMailAudit(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAuditLocalService.updateSPEMailAudit(speMailAudit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _speMailAuditLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_speMailAuditLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _speMailAuditLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findEMails(
		long processStateId, long nodeId, long userId, long orgId) {
		return _speMailAuditLocalService.findEMails(processStateId, nodeId,
			userId, orgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPEMailAudit> findEMails(
		long processStateId, long nodeId, long orgId) {
		return _speMailAuditLocalService.findEMails(processStateId, nodeId,
			orgId);
	}

	@Override
	public java.util.List<java.lang.Object> findEMailsTriggered(
		long processStateId, long nodeId, long orgId) {
		return _speMailAuditLocalService.findEMailsTriggered(processStateId,
			nodeId, orgId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPEMailAuditLocalService getWrappedSPEMailAuditLocalService() {
		return _speMailAuditLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPEMailAuditLocalService(
		SPEMailAuditLocalService speMailAuditLocalService) {
		_speMailAuditLocalService = speMailAuditLocalService;
	}

	@Override
	public SPEMailAuditLocalService getWrappedService() {
		return _speMailAuditLocalService;
	}

	@Override
	public void setWrappedService(
		SPEMailAuditLocalService speMailAuditLocalService) {
		_speMailAuditLocalService = speMailAuditLocalService;
	}

	private SPEMailAuditLocalService _speMailAuditLocalService;
}