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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Product. This utility wraps
 * {@link com.sambaash.platform.srv.service.impl.ProductLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see ProductLocalService
 * @see com.sambaash.platform.srv.service.base.ProductLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.impl.ProductLocalServiceImpl
 * @generated
 */
public class ProductLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.service.impl.ProductLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the product to the database. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product addProduct(
		com.sambaash.platform.srv.model.Product product)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProduct(product);
	}

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param spProductId the primary key for the new product
	* @return the new product
	*/
	public static com.sambaash.platform.srv.model.Product createProduct(
		long spProductId) {
		return getService().createProduct(spProductId);
	}

	/**
	* Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spProductId the primary key of the product
	* @return the product that was removed
	* @throws PortalException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product deleteProduct(
		long spProductId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProduct(spProductId);
	}

	/**
	* Deletes the product from the database. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product deleteProduct(
		com.sambaash.platform.srv.model.Product product)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProduct(product);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.model.Product fetchProduct(
		long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProduct(spProductId);
	}

	/**
	* Returns the product with the primary key.
	*
	* @param spProductId the primary key of the product
	* @return the product
	* @throws PortalException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product getProduct(
		long spProductId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProduct(spProductId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> getProducts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProducts(start, end);
	}

	/**
	* Returns the number of products.
	*
	* @return the number of products
	* @throws SystemException if a system exception occurred
	*/
	public static int getProductsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductsCount();
	}

	/**
	* Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product updateProduct(
		com.sambaash.platform.srv.model.Product product)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProduct(product);
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

	public static void clearCache() {
		getService().clearCache();
	}

	public static com.sambaash.platform.srv.model.Product create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static java.util.List<com.sambaash.platform.pe.PEEntity> getPEEntityList(
		java.lang.Integer start, java.lang.Integer end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEEntityList(start, end);
	}

	public static com.sambaash.platform.pe.PEEntity getPEEntity(
		java.lang.Long classPk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEEntity(classPk);
	}

	public static com.sambaash.platform.pe.PEEntity getEntity(
		com.sambaash.platform.srv.model.Product product) {
		return getService().getEntity(product);
	}

	public static java.lang.String customProductName(
		com.sambaash.platform.srv.model.Product product) {
		return getService().customProductName(product);
	}

	public static java.util.List<com.sambaash.platform.pe.PEEntityField> getPEEntityFields() {
		return getService().getPEEntityFields();
	}

	public static java.lang.String getPEEntityFieldValue(
		java.lang.Long entityId, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEEntityFieldValue(entityId, fieldId);
	}

	public static com.sambaash.platform.srv.model.Product findByProductNameCountryId(
		java.lang.String productname, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getService().findByProductNameCountryId(productname, countryCode);
	}

	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCourseId(
		long groupId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getService().findByGroupIdAndCourseId(groupId, courseId);
	}

	public static boolean isQualificationTypeProduct(
		com.sambaash.platform.srv.model.Product product) {
		return getService().isQualificationTypeProduct(product);
	}

	public static boolean isQualificationTypeCourse(
		com.sambaash.platform.srv.model.Course course) {
		return getService().isQualificationTypeCourse(course);
	}

	public static java.util.List<com.sambaash.platform.srv.model.Product> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getService().findByStatus(status, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.model.Product> getActiveProducts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveProducts();
	}

	public static java.util.List<com.sambaash.platform.pe.PEEntity> getPEEntityList(
		java.util.List<java.lang.Long> entityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEEntityList(entityIds);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetCategory> getSpecializationCatgIds(
		com.sambaash.platform.srv.model.Product product) {
		return getService().getSpecializationCatgIds(product);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProductLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProductLocalService.class.getName());

			if (invokableLocalService instanceof ProductLocalService) {
				_service = (ProductLocalService)invokableLocalService;
			}
			else {
				_service = new ProductLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProductLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ProductLocalService service) {
	}

	private static ProductLocalService _service;
}