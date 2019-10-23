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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.Product;

import java.util.List;

/**
 * The persistence utility for the product service. This utility wraps {@link ProductPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductPersistence
 * @see ProductPersistenceImpl
 * @generated
 */
public class ProductUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Product product) {
		getPersistence().clearCache(product);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Product> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Product> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Product> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Product update(Product product) throws SystemException {
		return getPersistence().update(product);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Product update(Product product, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(product, serviceContext);
	}

	/**
	* Returns all the products where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the products where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the products where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the products before and after the current product in the ordered set where groupId = &#63;.
	*
	* @param spProductId the primary key of the current product
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product[] findByGroupId_PrevAndNext(
		long spProductId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spProductId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the products where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of products where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the products where countryId = &#63;.
	*
	* @param countryId the country ID
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByCountryId(
		java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryId(countryId);
	}

	/**
	* Returns a range of all the products where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByCountryId(
		java.lang.String countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryId(countryId, start, end);
	}

	/**
	* Returns an ordered range of all the products where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByCountryId(
		java.lang.String countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryId(countryId, start, end, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByCountryId_First(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByCountryId_First(countryId, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByCountryId_First(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryId_First(countryId, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByCountryId_Last(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByCountryId_Last(countryId, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByCountryId_Last(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryId_Last(countryId, orderByComparator);
	}

	/**
	* Returns the products before and after the current product in the ordered set where countryId = &#63;.
	*
	* @param spProductId the primary key of the current product
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product[] findByCountryId_PrevAndNext(
		long spProductId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByCountryId_PrevAndNext(spProductId, countryId,
			orderByComparator);
	}

	/**
	* Removes all the products where countryId = &#63; from the database.
	*
	* @param countryId the country ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryId(java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountryId(countryId);
	}

	/**
	* Returns the number of products where countryId = &#63;.
	*
	* @param countryId the country ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryId(java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryId(countryId);
	}

	/**
	* Returns all the products where groupId = &#63; and countryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCountryId(
		long groupId, java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndCountryId(groupId, countryId);
	}

	/**
	* Returns a range of all the products where groupId = &#63; and countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCountryId(
		long groupId, java.lang.String countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCountryId(groupId, countryId, start, end);
	}

	/**
	* Returns an ordered range of all the products where groupId = &#63; and countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCountryId(
		long groupId, java.lang.String countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCountryId(groupId, countryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where groupId = &#63; and countryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByGroupIdAndCountryId_First(
		long groupId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupIdAndCountryId_First(groupId, countryId,
			orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where groupId = &#63; and countryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByGroupIdAndCountryId_First(
		long groupId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCountryId_First(groupId, countryId,
			orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where groupId = &#63; and countryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByGroupIdAndCountryId_Last(
		long groupId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupIdAndCountryId_Last(groupId, countryId,
			orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where groupId = &#63; and countryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByGroupIdAndCountryId_Last(
		long groupId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCountryId_Last(groupId, countryId,
			orderByComparator);
	}

	/**
	* Returns the products before and after the current product in the ordered set where groupId = &#63; and countryId = &#63;.
	*
	* @param spProductId the primary key of the current product
	* @param groupId the group ID
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product[] findByGroupIdAndCountryId_PrevAndNext(
		long spProductId, long groupId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupIdAndCountryId_PrevAndNext(spProductId, groupId,
			countryId, orderByComparator);
	}

	/**
	* Removes all the products where groupId = &#63; and countryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndCountryId(long groupId,
		java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdAndCountryId(groupId, countryId);
	}

	/**
	* Returns the number of products where groupId = &#63; and countryId = &#63;.
	*
	* @param groupId the group ID
	* @param countryId the country ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndCountryId(long groupId,
		java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdAndCountryId(groupId, countryId);
	}

	/**
	* Returns the product where productName = &#63; and countryId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchProductException} if it could not be found.
	*
	* @param productName the product name
	* @param countryId the country ID
	* @return the matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByProductNameCounryId(
		java.lang.String productName, java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().findByProductNameCounryId(productName, countryId);
	}

	/**
	* Returns the product where productName = &#63; and countryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param productName the product name
	* @param countryId the country ID
	* @return the matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByProductNameCounryId(
		java.lang.String productName, java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductNameCounryId(productName, countryId);
	}

	/**
	* Returns the product where productName = &#63; and countryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param productName the product name
	* @param countryId the country ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByProductNameCounryId(
		java.lang.String productName, java.lang.String countryId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductNameCounryId(productName, countryId,
			retrieveFromCache);
	}

	/**
	* Removes the product where productName = &#63; and countryId = &#63; from the database.
	*
	* @param productName the product name
	* @param countryId the country ID
	* @return the product that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product removeByProductNameCounryId(
		java.lang.String productName, java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .removeByProductNameCounryId(productName, countryId);
	}

	/**
	* Returns the number of products where productName = &#63; and countryId = &#63;.
	*
	* @param productName the product name
	* @param countryId the country ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProductNameCounryId(java.lang.String productName,
		java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByProductNameCounryId(productName, countryId);
	}

	/**
	* Returns all the products where status = &#63;.
	*
	* @param status the status
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the products where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the products where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the products before and after the current product in the ordered set where status = &#63;.
	*
	* @param spProductId the primary key of the current product
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product[] findByStatus_PrevAndNext(
		long spProductId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByStatus_PrevAndNext(spProductId, status,
			orderByComparator);
	}

	/**
	* Removes all the products where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of products where status = &#63;.
	*
	* @param status the status
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the products where spProductId = &#63;.
	*
	* @param spProductId the sp product ID
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByproductIds(
		long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByproductIds(spProductId);
	}

	/**
	* Returns a range of all the products where spProductId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spProductId the sp product ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByproductIds(
		long spProductId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByproductIds(spProductId, start, end);
	}

	/**
	* Returns an ordered range of all the products where spProductId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spProductId the sp product ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByproductIds(
		long spProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByproductIds(spProductId, start, end, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where spProductId = &#63;.
	*
	* @param spProductId the sp product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByproductIds_First(
		long spProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByproductIds_First(spProductId, orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where spProductId = &#63;.
	*
	* @param spProductId the sp product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByproductIds_First(
		long spProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByproductIds_First(spProductId, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where spProductId = &#63;.
	*
	* @param spProductId the sp product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByproductIds_Last(
		long spProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByproductIds_Last(spProductId, orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where spProductId = &#63;.
	*
	* @param spProductId the sp product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByproductIds_Last(
		long spProductId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByproductIds_Last(spProductId, orderByComparator);
	}

	/**
	* Returns all the products where spProductId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spProductIds the sp product IDs
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByproductIds(
		long[] spProductIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByproductIds(spProductIds);
	}

	/**
	* Returns a range of all the products where spProductId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spProductIds the sp product IDs
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByproductIds(
		long[] spProductIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByproductIds(spProductIds, start, end);
	}

	/**
	* Returns an ordered range of all the products where spProductId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spProductIds the sp product IDs
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByproductIds(
		long[] spProductIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByproductIds(spProductIds, start, end, orderByComparator);
	}

	/**
	* Removes all the products where spProductId = &#63; from the database.
	*
	* @param spProductId the sp product ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByproductIds(long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByproductIds(spProductId);
	}

	/**
	* Returns the number of products where spProductId = &#63;.
	*
	* @param spProductId the sp product ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByproductIds(long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByproductIds(spProductId);
	}

	/**
	* Returns the number of products where spProductId = any &#63;.
	*
	* @param spProductIds the sp product IDs
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByproductIds(long[] spProductIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByproductIds(spProductIds);
	}

	/**
	* Returns all the products where groupId = &#63; and spCourseId = &#63;.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCourseId(
		long groupId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndCourseId(groupId, spCourseId);
	}

	/**
	* Returns a range of all the products where groupId = &#63; and spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCourseId(
		long groupId, long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCourseId(groupId, spCourseId, start, end);
	}

	/**
	* Returns an ordered range of all the products where groupId = &#63; and spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findByGroupIdAndCourseId(
		long groupId, long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndCourseId(groupId, spCourseId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByGroupIdAndCourseId_First(
		long groupId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupIdAndCourseId_First(groupId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the first product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByGroupIdAndCourseId_First(
		long groupId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCourseId_First(groupId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByGroupIdAndCourseId_Last(
		long groupId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupIdAndCourseId_Last(groupId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the last product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByGroupIdAndCourseId_Last(
		long groupId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCourseId_Last(groupId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the products before and after the current product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	*
	* @param spProductId the primary key of the current product
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product[] findByGroupIdAndCourseId_PrevAndNext(
		long spProductId, long groupId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence()
				   .findByGroupIdAndCourseId_PrevAndNext(spProductId, groupId,
			spCourseId, orderByComparator);
	}

	/**
	* Removes all the products where groupId = &#63; and spCourseId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndCourseId(long groupId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdAndCourseId(groupId, spCourseId);
	}

	/**
	* Returns the number of products where groupId = &#63; and spCourseId = &#63;.
	*
	* @param groupId the group ID
	* @param spCourseId the sp course ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndCourseId(long groupId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdAndCourseId(groupId, spCourseId);
	}

	/**
	* Caches the product in the entity cache if it is enabled.
	*
	* @param product the product
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Product product) {
		getPersistence().cacheResult(product);
	}

	/**
	* Caches the products in the entity cache if it is enabled.
	*
	* @param products the products
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Product> products) {
		getPersistence().cacheResult(products);
	}

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param spProductId the primary key for the new product
	* @return the new product
	*/
	public static com.sambaash.platform.srv.model.Product create(
		long spProductId) {
		return getPersistence().create(spProductId);
	}

	/**
	* Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spProductId the primary key of the product
	* @return the product that was removed
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product remove(
		long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().remove(spProductId);
	}

	public static com.sambaash.platform.srv.model.Product updateImpl(
		com.sambaash.platform.srv.model.Product product)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(product);
	}

	/**
	* Returns the product with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchProductException} if it could not be found.
	*
	* @param spProductId the primary key of the product
	* @return the product
	* @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product findByPrimaryKey(
		long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchProductException {
		return getPersistence().findByPrimaryKey(spProductId);
	}

	/**
	* Returns the product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spProductId the primary key of the product
	* @return the product, or <code>null</code> if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Product fetchByPrimaryKey(
		long spProductId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spProductId);
	}

	/**
	* Returns all the products.
	*
	* @return the products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.model.Product> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Product> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the products from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of products.
	*
	* @return the number of products
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					ProductPersistence.class.getName());

			ReferenceRegistry.registerReference(ProductUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProductPersistence persistence) {
	}

	private static ProductPersistence _persistence;
}