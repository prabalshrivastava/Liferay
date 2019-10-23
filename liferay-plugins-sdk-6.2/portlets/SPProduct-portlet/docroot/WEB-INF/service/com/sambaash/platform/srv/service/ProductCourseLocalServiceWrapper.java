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
 * Provides a wrapper for {@link ProductCourseLocalService}.
 *
 * @author gauravvijayvergia
 * @see ProductCourseLocalService
 * @generated
 */
public class ProductCourseLocalServiceWrapper
	implements ProductCourseLocalService,
		ServiceWrapper<ProductCourseLocalService> {
	public ProductCourseLocalServiceWrapper(
		ProductCourseLocalService productCourseLocalService) {
		_productCourseLocalService = productCourseLocalService;
	}

	/**
	* Adds the product course to the database. Also notifies the appropriate model listeners.
	*
	* @param productCourse the product course
	* @return the product course that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductCourse addProductCourse(
		com.sambaash.platform.srv.model.ProductCourse productCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.addProductCourse(productCourse);
	}

	/**
	* Creates a new product course with the primary key. Does not add the product course to the database.
	*
	* @param spProductCourseId the primary key for the new product course
	* @return the new product course
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductCourse createProductCourse(
		long spProductCourseId) {
		return _productCourseLocalService.createProductCourse(spProductCourseId);
	}

	/**
	* Deletes the product course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spProductCourseId the primary key of the product course
	* @return the product course that was removed
	* @throws PortalException if a product course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductCourse deleteProductCourse(
		long spProductCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.deleteProductCourse(spProductCourseId);
	}

	/**
	* Deletes the product course from the database. Also notifies the appropriate model listeners.
	*
	* @param productCourse the product course
	* @return the product course that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductCourse deleteProductCourse(
		com.sambaash.platform.srv.model.ProductCourse productCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.deleteProductCourse(productCourse);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productCourseLocalService.dynamicQuery();
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
		return _productCourseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _productCourseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _productCourseLocalService.dynamicQuery(dynamicQuery, start,
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
		return _productCourseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _productCourseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.ProductCourse fetchProductCourse(
		long spProductCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.fetchProductCourse(spProductCourseId);
	}

	/**
	* Returns the product course with the primary key.
	*
	* @param spProductCourseId the primary key of the product course
	* @return the product course
	* @throws PortalException if a product course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductCourse getProductCourse(
		long spProductCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.getProductCourse(spProductCourseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the product courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of product courses
	* @param end the upper bound of the range of product courses (not inclusive)
	* @return the range of product courses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.ProductCourse> getProductCourses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.getProductCourses(start, end);
	}

	/**
	* Returns the number of product courses.
	*
	* @return the number of product courses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProductCoursesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.getProductCoursesCount();
	}

	/**
	* Updates the product course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productCourse the product course
	* @return the product course that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductCourse updateProductCourse(
		com.sambaash.platform.srv.model.ProductCourse productCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.updateProductCourse(productCourse);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _productCourseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_productCourseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _productCourseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.ProductCourse> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourseLocalService.findByCourseIdAndGroupId(spCourseId,
			groupId);
	}

	@Override
	public void clearCache() {
		_productCourseLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProductCourseLocalService getWrappedProductCourseLocalService() {
		return _productCourseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProductCourseLocalService(
		ProductCourseLocalService productCourseLocalService) {
		_productCourseLocalService = productCourseLocalService;
	}

	@Override
	public ProductCourseLocalService getWrappedService() {
		return _productCourseLocalService;
	}

	@Override
	public void setWrappedService(
		ProductCourseLocalService productCourseLocalService) {
		_productCourseLocalService = productCourseLocalService;
	}

	private ProductCourseLocalService _productCourseLocalService;
}