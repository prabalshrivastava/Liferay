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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPAuditLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPAuditLocalService
 * @generated
 */
public class SPAuditLocalServiceWrapper implements SPAuditLocalService,
	ServiceWrapper<SPAuditLocalService> {
	public SPAuditLocalServiceWrapper(SPAuditLocalService spAuditLocalService) {
		_spAuditLocalService = spAuditLocalService;
	}

	/**
	* Adds the s p audit to the database. Also notifies the appropriate model listeners.
	*
	* @param spAudit the s p audit
	* @return the s p audit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit addSPAudit(
		com.sambaash.platform.srv.spservices.model.SPAudit spAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.addSPAudit(spAudit);
	}

	/**
	* Creates a new s p audit with the primary key. Does not add the s p audit to the database.
	*
	* @param SPAuditId the primary key for the new s p audit
	* @return the new s p audit
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit createSPAudit(
		long SPAuditId) {
		return _spAuditLocalService.createSPAudit(SPAuditId);
	}

	/**
	* Deletes the s p audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPAuditId the primary key of the s p audit
	* @return the s p audit that was removed
	* @throws PortalException if a s p audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit deleteSPAudit(
		long SPAuditId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.deleteSPAudit(SPAuditId);
	}

	/**
	* Deletes the s p audit from the database. Also notifies the appropriate model listeners.
	*
	* @param spAudit the s p audit
	* @return the s p audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit deleteSPAudit(
		com.sambaash.platform.srv.spservices.model.SPAudit spAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.deleteSPAudit(spAudit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spAuditLocalService.dynamicQuery();
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
		return _spAuditLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spAuditLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spAuditLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spAuditLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spAuditLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit fetchSPAudit(
		long SPAuditId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.fetchSPAudit(SPAuditId);
	}

	/**
	* Returns the s p audit with the matching UUID and company.
	*
	* @param uuid the s p audit's UUID
	* @param companyId the primary key of the company
	* @return the matching s p audit, or <code>null</code> if a matching s p audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit fetchSPAuditByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.fetchSPAuditByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p audit matching the UUID and group.
	*
	* @param uuid the s p audit's UUID
	* @param groupId the primary key of the group
	* @return the matching s p audit, or <code>null</code> if a matching s p audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit fetchSPAuditByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.fetchSPAuditByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p audit with the primary key.
	*
	* @param SPAuditId the primary key of the s p audit
	* @return the s p audit
	* @throws PortalException if a s p audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit getSPAudit(
		long SPAuditId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getSPAudit(SPAuditId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p audit with the matching UUID and company.
	*
	* @param uuid the s p audit's UUID
	* @param companyId the primary key of the company
	* @return the matching s p audit
	* @throws PortalException if a matching s p audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit getSPAuditByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getSPAuditByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p audit matching the UUID and group.
	*
	* @param uuid the s p audit's UUID
	* @param groupId the primary key of the group
	* @return the matching s p audit
	* @throws PortalException if a matching s p audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit getSPAuditByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getSPAuditByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p audits
	* @param end the upper bound of the range of s p audits (not inclusive)
	* @return the range of s p audits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPAudit> getSPAudits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getSPAudits(start, end);
	}

	/**
	* Returns the number of s p audits.
	*
	* @return the number of s p audits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPAuditsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getSPAuditsCount();
	}

	/**
	* Updates the s p audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spAudit the s p audit
	* @return the s p audit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit updateSPAudit(
		com.sambaash.platform.srv.spservices.model.SPAudit spAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.updateSPAudit(spAudit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAuditLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAuditLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAuditLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.create();
	}

	@Override
	public long getNewPK()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAuditLocalService.getNewPK();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPAuditLocalService getWrappedSPAuditLocalService() {
		return _spAuditLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPAuditLocalService(
		SPAuditLocalService spAuditLocalService) {
		_spAuditLocalService = spAuditLocalService;
	}

	@Override
	public SPAuditLocalService getWrappedService() {
		return _spAuditLocalService;
	}

	@Override
	public void setWrappedService(SPAuditLocalService spAuditLocalService) {
		_spAuditLocalService = spAuditLocalService;
	}

	private SPAuditLocalService _spAuditLocalService;
}