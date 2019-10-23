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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OutlineLocalService}.
 *
 * @author gauravvijayvergia
 * @see OutlineLocalService
 * @generated
 */
public class OutlineLocalServiceWrapper implements OutlineLocalService,
	ServiceWrapper<OutlineLocalService> {
	public OutlineLocalServiceWrapper(OutlineLocalService outlineLocalService) {
		_outlineLocalService = outlineLocalService;
	}

	/**
	* Adds the outline to the database. Also notifies the appropriate model listeners.
	*
	* @param outline the outline
	* @return the outline that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outline addOutline(
		com.sambaash.platform.srv.model.Outline outline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.addOutline(outline);
	}

	/**
	* Creates a new outline with the primary key. Does not add the outline to the database.
	*
	* @param spOutlineId the primary key for the new outline
	* @return the new outline
	*/
	@Override
	public com.sambaash.platform.srv.model.Outline createOutline(
		long spOutlineId) {
		return _outlineLocalService.createOutline(spOutlineId);
	}

	/**
	* Deletes the outline with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline that was removed
	* @throws PortalException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outline deleteOutline(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.deleteOutline(spOutlineId);
	}

	/**
	* Deletes the outline from the database. Also notifies the appropriate model listeners.
	*
	* @param outline the outline
	* @return the outline that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outline deleteOutline(
		com.sambaash.platform.srv.model.Outline outline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.deleteOutline(outline);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _outlineLocalService.dynamicQuery();
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
		return _outlineLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _outlineLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _outlineLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _outlineLocalService.dynamicQueryCount(dynamicQuery);
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
		return _outlineLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.model.Outline fetchOutline(
		long spOutlineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.fetchOutline(spOutlineId);
	}

	/**
	* Returns the outline with the primary key.
	*
	* @param spOutlineId the primary key of the outline
	* @return the outline
	* @throws PortalException if a outline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outline getOutline(long spOutlineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.getOutline(spOutlineId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the outlines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of outlines
	* @param end the upper bound of the range of outlines (not inclusive)
	* @return the range of outlines
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.Outline> getOutlines(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.getOutlines(start, end);
	}

	/**
	* Returns the number of outlines.
	*
	* @return the number of outlines
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOutlinesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.getOutlinesCount();
	}

	/**
	* Updates the outline in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param outline the outline
	* @return the outline that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outline updateOutline(
		com.sambaash.platform.srv.model.Outline outline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.updateOutline(outline);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _outlineLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_outlineLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _outlineLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.Outline create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.create();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndOutlineType(
		java.lang.Long groupId, java.lang.Long outlineType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.findByGroupIdAndOutlineType(groupId,
			outlineType);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Outline> findByGroupIdAndCompetencyUnitId(
		java.lang.Long groupId, java.lang.Long spCompetnectyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outlineLocalService.findByGroupIdAndCompetencyUnitId(groupId,
			spCompetnectyUnitId);
	}

	@Override
	public void clearCache() {
		_outlineLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OutlineLocalService getWrappedOutlineLocalService() {
		return _outlineLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOutlineLocalService(
		OutlineLocalService outlineLocalService) {
		_outlineLocalService = outlineLocalService;
	}

	@Override
	public OutlineLocalService getWrappedService() {
		return _outlineLocalService;
	}

	@Override
	public void setWrappedService(OutlineLocalService outlineLocalService) {
		_outlineLocalService = outlineLocalService;
	}

	private OutlineLocalService _outlineLocalService;
}