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

package com.sambaash.platform.srv.genericsearch.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GSFavouriteLocalService}.
 *
 * @author nareshchebolu
 * @see GSFavouriteLocalService
 * @generated
 */
public class GSFavouriteLocalServiceWrapper implements GSFavouriteLocalService,
	ServiceWrapper<GSFavouriteLocalService> {
	public GSFavouriteLocalServiceWrapper(
		GSFavouriteLocalService gsFavouriteLocalService) {
		_gsFavouriteLocalService = gsFavouriteLocalService;
	}

	/**
	* Adds the g s favourite to the database. Also notifies the appropriate model listeners.
	*
	* @param gsFavourite the g s favourite
	* @return the g s favourite that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite addGSFavourite(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.addGSFavourite(gsFavourite);
	}

	/**
	* Creates a new g s favourite with the primary key. Does not add the g s favourite to the database.
	*
	* @param SPGSFavouriteId the primary key for the new g s favourite
	* @return the new g s favourite
	*/
	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite createGSFavourite(
		long SPGSFavouriteId) {
		return _gsFavouriteLocalService.createGSFavourite(SPGSFavouriteId);
	}

	/**
	* Deletes the g s favourite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite that was removed
	* @throws PortalException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite deleteGSFavourite(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.deleteGSFavourite(SPGSFavouriteId);
	}

	/**
	* Deletes the g s favourite from the database. Also notifies the appropriate model listeners.
	*
	* @param gsFavourite the g s favourite
	* @return the g s favourite that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite deleteGSFavourite(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.deleteGSFavourite(gsFavourite);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gsFavouriteLocalService.dynamicQuery();
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
		return _gsFavouriteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gsFavouriteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gsFavouriteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _gsFavouriteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gsFavouriteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchGSFavourite(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.fetchGSFavourite(SPGSFavouriteId);
	}

	/**
	* Returns the g s favourite with the primary key.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite
	* @throws PortalException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite getGSFavourite(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.getGSFavourite(SPGSFavouriteId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g s favourites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g s favourites
	* @param end the upper bound of the range of g s favourites (not inclusive)
	* @return the range of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> getGSFavourites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.getGSFavourites(start, end);
	}

	/**
	* Returns the number of g s favourites.
	*
	* @return the number of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGSFavouritesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.getGSFavouritesCount();
	}

	/**
	* Updates the g s favourite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gsFavourite the g s favourite
	* @return the g s favourite that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite updateGSFavourite(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.updateGSFavourite(gsFavourite);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gsFavouriteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gsFavouriteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gsFavouriteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByCreatedBy(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.findByCreatedBy(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findPrivateFavourites(
		long userId, long layoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.findPrivateFavourites(userId, layoutId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findGlobalFavourites(
		long layoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.findGlobalFavourites(layoutId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll(
		long userId, long layoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.findAll(userId, layoutId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> getResults(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite fav,
		int start, int end) {
		return _gsFavouriteLocalService.getResults(fav, start, end);
	}

	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavouriteLocalService.create();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchByFavourite(
		int start, int end,
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite) {
		return _gsFavouriteLocalService.searchByFavourite(start, end,
			gsFavourite);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GSFavouriteLocalService getWrappedGSFavouriteLocalService() {
		return _gsFavouriteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGSFavouriteLocalService(
		GSFavouriteLocalService gsFavouriteLocalService) {
		_gsFavouriteLocalService = gsFavouriteLocalService;
	}

	@Override
	public GSFavouriteLocalService getWrappedService() {
		return _gsFavouriteLocalService;
	}

	@Override
	public void setWrappedService(
		GSFavouriteLocalService gsFavouriteLocalService) {
		_gsFavouriteLocalService = gsFavouriteLocalService;
	}

	private GSFavouriteLocalService _gsFavouriteLocalService;
}