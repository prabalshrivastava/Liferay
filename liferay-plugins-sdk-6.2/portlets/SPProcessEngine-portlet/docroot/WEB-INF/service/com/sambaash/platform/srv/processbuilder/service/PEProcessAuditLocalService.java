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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for PEProcessAudit. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author nareshchebolu
 * @see PEProcessAuditLocalServiceUtil
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessAuditLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEProcessAuditLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PEProcessAuditLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PEProcessAuditLocalServiceUtil} to access the p e process audit local service. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEProcessAuditLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the p e process audit to the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessAudit the p e process audit
	* @return the p e process audit that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit addPEProcessAudit(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new p e process audit with the primary key. Does not add the p e process audit to the database.
	*
	* @param spPEProcessAuditId the primary key for the new p e process audit
	* @return the new p e process audit
	*/
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit createPEProcessAudit(
		long spPEProcessAuditId);

	/**
	* Deletes the p e process audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit that was removed
	* @throws PortalException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit deletePEProcessAudit(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the p e process audit from the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessAudit the p e process audit
	* @return the p e process audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit deletePEProcessAudit(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchPEProcessAudit(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit with the matching UUID and company.
	*
	* @param uuid the p e process audit's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchPEProcessAuditByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit matching the UUID and group.
	*
	* @param uuid the p e process audit's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit fetchPEProcessAuditByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit with the primary key.
	*
	* @param spPEProcessAuditId the primary key of the p e process audit
	* @return the p e process audit
	* @throws PortalException if a p e process audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getPEProcessAudit(
		long spPEProcessAuditId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit with the matching UUID and company.
	*
	* @param uuid the p e process audit's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process audit
	* @throws PortalException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getPEProcessAuditByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e process audit matching the UUID and group.
	*
	* @param uuid the p e process audit's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process audit
	* @throws PortalException if a matching p e process audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getPEProcessAuditByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e process audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process audits
	* @param end the upper bound of the range of p e process audits (not inclusive)
	* @return the range of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> getPEProcessAudits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e process audits.
	*
	* @return the number of p e process audits
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPEProcessAuditsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the p e process audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peProcessAudit the p e process audit
	* @return the p e process audit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit updatePEProcessAudit(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit create()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit create(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		long processStateId, java.lang.String type, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByProcessStateId(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByProcessStateIdType(
		long processStateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getFormJspAuditForDates(
		long processStateId, java.util.Date date1, java.util.Date date2)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getFormJspBetweenStatusTypeAudits(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit audit1,
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit audit2)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getNearestFormJsp(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit audit)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getNearestStatusTypeAudit(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit audit)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByProcessStateIdFormId(
		long processStateId, long formId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByTypeField2PEProcessStateId(
		java.lang.String type, java.lang.String field2, long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByActionTypeField2(
		java.lang.String action, java.lang.String type, java.lang.String field2)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findStatusTypeAudit_DisplayNodeIdNotZero(
		long statusType, long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findLatestStatusTypeAudit(
		long statusType, long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findByProcessStateIdNodeId(
		long processStateId, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findLatestByProcessStateIdNodeId(
		long processStateId, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit findByProcessStateIdNodeIdAction(
		long processStateId, long nodeId, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit getLatestAudit(
		long processStateId, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> findStatusTypeAudits(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void clearCache();
}