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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RelationshipLocalService}.
 *
 * @author pradeep
 * @see RelationshipLocalService
 * @generated
 */
public class RelationshipLocalServiceWrapper implements RelationshipLocalService,
	ServiceWrapper<RelationshipLocalService> {
	public RelationshipLocalServiceWrapper(
		RelationshipLocalService relationshipLocalService) {
		_relationshipLocalService = relationshipLocalService;
	}

	/**
	* Adds the relationship to the database. Also notifies the appropriate model listeners.
	*
	* @param relationship the relationship
	* @return the relationship that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship addRelationship(
		com.sambaash.platform.srv.startupprofile.model.Relationship relationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.addRelationship(relationship);
	}

	/**
	* Creates a new relationship with the primary key. Does not add the relationship to the database.
	*
	* @param relationshipId the primary key for the new relationship
	* @return the new relationship
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship createRelationship(
		long relationshipId) {
		return _relationshipLocalService.createRelationship(relationshipId);
	}

	/**
	* Deletes the relationship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param relationshipId the primary key of the relationship
	* @return the relationship that was removed
	* @throws PortalException if a relationship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship deleteRelationship(
		long relationshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.deleteRelationship(relationshipId);
	}

	/**
	* Deletes the relationship from the database. Also notifies the appropriate model listeners.
	*
	* @param relationship the relationship
	* @return the relationship that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship deleteRelationship(
		com.sambaash.platform.srv.startupprofile.model.Relationship relationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.deleteRelationship(relationship);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _relationshipLocalService.dynamicQuery();
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
		return _relationshipLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.RelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _relationshipLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.RelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _relationshipLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _relationshipLocalService.dynamicQueryCount(dynamicQuery);
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
		return _relationshipLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship fetchRelationship(
		long relationshipId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.fetchRelationship(relationshipId);
	}

	/**
	* Returns the relationship with the primary key.
	*
	* @param relationshipId the primary key of the relationship
	* @return the relationship
	* @throws PortalException if a relationship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship getRelationship(
		long relationshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.getRelationship(relationshipId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the relationships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.RelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of relationships
	* @param end the upper bound of the range of relationships (not inclusive)
	* @return the range of relationships
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Relationship> getRelationships(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.getRelationships(start, end);
	}

	/**
	* Returns the number of relationships.
	*
	* @return the number of relationships
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRelationshipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.getRelationshipsCount();
	}

	/**
	* Updates the relationship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param relationship the relationship
	* @return the relationship that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship updateRelationship(
		com.sambaash.platform.srv.startupprofile.model.Relationship relationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationshipLocalService.updateRelationship(relationship);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _relationshipLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_relationshipLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _relationshipLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RelationshipLocalService getWrappedRelationshipLocalService() {
		return _relationshipLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRelationshipLocalService(
		RelationshipLocalService relationshipLocalService) {
		_relationshipLocalService = relationshipLocalService;
	}

	@Override
	public RelationshipLocalService getWrappedService() {
		return _relationshipLocalService;
	}

	@Override
	public void setWrappedService(
		RelationshipLocalService relationshipLocalService) {
		_relationshipLocalService = relationshipLocalService;
	}

	private RelationshipLocalService _relationshipLocalService;
}