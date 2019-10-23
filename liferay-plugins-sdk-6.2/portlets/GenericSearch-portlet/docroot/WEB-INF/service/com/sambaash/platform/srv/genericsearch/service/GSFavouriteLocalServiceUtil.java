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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GSFavourite. This utility wraps
 * {@link com.sambaash.platform.srv.genericsearch.service.impl.GSFavouriteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see GSFavouriteLocalService
 * @see com.sambaash.platform.srv.genericsearch.service.base.GSFavouriteLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.genericsearch.service.impl.GSFavouriteLocalServiceImpl
 * @generated
 */
public class GSFavouriteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.genericsearch.service.impl.GSFavouriteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the g s favourite to the database. Also notifies the appropriate model listeners.
	*
	* @param gsFavourite the g s favourite
	* @return the g s favourite that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite addGSFavourite(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGSFavourite(gsFavourite);
	}

	/**
	* Creates a new g s favourite with the primary key. Does not add the g s favourite to the database.
	*
	* @param SPGSFavouriteId the primary key for the new g s favourite
	* @return the new g s favourite
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite createGSFavourite(
		long SPGSFavouriteId) {
		return getService().createGSFavourite(SPGSFavouriteId);
	}

	/**
	* Deletes the g s favourite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite that was removed
	* @throws PortalException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite deleteGSFavourite(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGSFavourite(SPGSFavouriteId);
	}

	/**
	* Deletes the g s favourite from the database. Also notifies the appropriate model listeners.
	*
	* @param gsFavourite the g s favourite
	* @return the g s favourite that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite deleteGSFavourite(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGSFavourite(gsFavourite);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite fetchGSFavourite(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGSFavourite(SPGSFavouriteId);
	}

	/**
	* Returns the g s favourite with the primary key.
	*
	* @param SPGSFavouriteId the primary key of the g s favourite
	* @return the g s favourite
	* @throws PortalException if a g s favourite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite getGSFavourite(
		long SPGSFavouriteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGSFavourite(SPGSFavouriteId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> getGSFavourites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGSFavourites(start, end);
	}

	/**
	* Returns the number of g s favourites.
	*
	* @return the number of g s favourites
	* @throws SystemException if a system exception occurred
	*/
	public static int getGSFavouritesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGSFavouritesCount();
	}

	/**
	* Updates the g s favourite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gsFavourite the g s favourite
	* @return the g s favourite that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite updateGSFavourite(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGSFavourite(gsFavourite);
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

	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findByCreatedBy(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCreatedBy(userId);
	}

	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findPrivateFavourites(
		long userId, long layoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findPrivateFavourites(userId, layoutId);
	}

	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findGlobalFavourites(
		long layoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findGlobalFavourites(layoutId);
	}

	public static java.util.List<com.sambaash.platform.srv.genericsearch.model.GSFavourite> findAll(
		long userId, long layoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(userId, layoutId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> getResults(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite fav,
		int start, int end) {
		return getService().getResults(fav, start, end);
	}

	public static com.sambaash.platform.srv.genericsearch.model.GSFavourite create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchByFavourite(
		int start, int end,
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite) {
		return getService().searchByFavourite(start, end, gsFavourite);
	}

	public static void clearService() {
		_service = null;
	}

	public static GSFavouriteLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GSFavouriteLocalService.class.getName());

			if (invokableLocalService instanceof GSFavouriteLocalService) {
				_service = (GSFavouriteLocalService)invokableLocalService;
			}
			else {
				_service = new GSFavouriteLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GSFavouriteLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GSFavouriteLocalService service) {
	}

	private static GSFavouriteLocalService _service;
}