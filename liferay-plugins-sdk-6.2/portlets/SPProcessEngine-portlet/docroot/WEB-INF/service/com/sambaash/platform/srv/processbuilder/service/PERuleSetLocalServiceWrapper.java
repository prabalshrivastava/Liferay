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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PERuleSetLocalService}.
 *
 * @author nareshchebolu
 * @see PERuleSetLocalService
 * @generated
 */
public class PERuleSetLocalServiceWrapper implements PERuleSetLocalService,
	ServiceWrapper<PERuleSetLocalService> {
	public PERuleSetLocalServiceWrapper(
		PERuleSetLocalService peRuleSetLocalService) {
		_peRuleSetLocalService = peRuleSetLocalService;
	}

	/**
	* Adds the p e rule set to the database. Also notifies the appropriate model listeners.
	*
	* @param peRuleSet the p e rule set
	* @return the p e rule set that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet addPERuleSet(
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.addPERuleSet(peRuleSet);
	}

	/**
	* Creates a new p e rule set with the primary key. Does not add the p e rule set to the database.
	*
	* @param spPERuleSetId the primary key for the new p e rule set
	* @return the new p e rule set
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet createPERuleSet(
		long spPERuleSetId) {
		return _peRuleSetLocalService.createPERuleSet(spPERuleSetId);
	}

	/**
	* Deletes the p e rule set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPERuleSetId the primary key of the p e rule set
	* @return the p e rule set that was removed
	* @throws PortalException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet deletePERuleSet(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.deletePERuleSet(spPERuleSetId);
	}

	/**
	* Deletes the p e rule set from the database. Also notifies the appropriate model listeners.
	*
	* @param peRuleSet the p e rule set
	* @return the p e rule set that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet deletePERuleSet(
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.deletePERuleSet(peRuleSet);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peRuleSetLocalService.dynamicQuery();
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
		return _peRuleSetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peRuleSetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peRuleSetLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _peRuleSetLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peRuleSetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchPERuleSet(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.fetchPERuleSet(spPERuleSetId);
	}

	/**
	* Returns the p e rule set with the matching UUID and company.
	*
	* @param uuid the p e rule set's UUID
	* @param companyId the primary key of the company
	* @return the matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchPERuleSetByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.fetchPERuleSetByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e rule set matching the UUID and group.
	*
	* @param uuid the p e rule set's UUID
	* @param groupId the primary key of the group
	* @return the matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchPERuleSetByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.fetchPERuleSetByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the p e rule set with the primary key.
	*
	* @param spPERuleSetId the primary key of the p e rule set
	* @return the p e rule set
	* @throws PortalException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet getPERuleSet(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.getPERuleSet(spPERuleSetId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e rule set with the matching UUID and company.
	*
	* @param uuid the p e rule set's UUID
	* @param companyId the primary key of the company
	* @return the matching p e rule set
	* @throws PortalException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet getPERuleSetByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.getPERuleSetByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the p e rule set matching the UUID and group.
	*
	* @param uuid the p e rule set's UUID
	* @param groupId the primary key of the group
	* @return the matching p e rule set
	* @throws PortalException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet getPERuleSetByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.getPERuleSetByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the p e rule sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @return the range of p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> getPERuleSets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.getPERuleSets(start, end);
	}

	/**
	* Returns the number of p e rule sets.
	*
	* @return the number of p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPERuleSetsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.getPERuleSetsCount();
	}

	/**
	* Updates the p e rule set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peRuleSet the p e rule set
	* @return the p e rule set that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet updatePERuleSet(
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.updatePERuleSet(peRuleSet);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peRuleSetLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peRuleSetLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peRuleSetLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil} to access the p e rule set local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByComponentType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSetLocalService.findByComponentType(type);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PERuleSetLocalService getWrappedPERuleSetLocalService() {
		return _peRuleSetLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPERuleSetLocalService(
		PERuleSetLocalService peRuleSetLocalService) {
		_peRuleSetLocalService = peRuleSetLocalService;
	}

	@Override
	public PERuleSetLocalService getWrappedService() {
		return _peRuleSetLocalService;
	}

	@Override
	public void setWrappedService(PERuleSetLocalService peRuleSetLocalService) {
		_peRuleSetLocalService = peRuleSetLocalService;
	}

	private PERuleSetLocalService _peRuleSetLocalService;
}