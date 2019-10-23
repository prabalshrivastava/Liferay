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

package com.sambaash.platform.srv.spshopping.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sambaash.platform.srv.spshopping.service.SPShoppingService;
import com.sambaash.platform.srv.spshopping.service.persistence.SPCartPackageItemPersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPCartPackagePersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPCartPersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPDiscountPersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPPackageItemsPersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPSellingItemPersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPSellingPackagePersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPSellingPricePersistence;
import com.sambaash.platform.srv.spshopping.service.persistence.SPTaxPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p shopping remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.spshopping.service.impl.SPShoppingServiceImpl}.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spshopping.service.impl.SPShoppingServiceImpl
 * @see com.sambaash.platform.srv.spshopping.service.SPShoppingServiceUtil
 * @generated
 */
public abstract class SPShoppingServiceBaseImpl extends BaseServiceImpl
	implements SPShoppingService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.spshopping.service.SPShoppingServiceUtil} to access the s p shopping remote service.
	 */

	/**
	 * Returns the s p cart local service.
	 *
	 * @return the s p cart local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPCartLocalService getSPCartLocalService() {
		return spCartLocalService;
	}

	/**
	 * Sets the s p cart local service.
	 *
	 * @param spCartLocalService the s p cart local service
	 */
	public void setSPCartLocalService(
		com.sambaash.platform.srv.spshopping.service.SPCartLocalService spCartLocalService) {
		this.spCartLocalService = spCartLocalService;
	}

	/**
	 * Returns the s p cart persistence.
	 *
	 * @return the s p cart persistence
	 */
	public SPCartPersistence getSPCartPersistence() {
		return spCartPersistence;
	}

	/**
	 * Sets the s p cart persistence.
	 *
	 * @param spCartPersistence the s p cart persistence
	 */
	public void setSPCartPersistence(SPCartPersistence spCartPersistence) {
		this.spCartPersistence = spCartPersistence;
	}

	/**
	 * Returns the s p cart package local service.
	 *
	 * @return the s p cart package local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalService getSPCartPackageLocalService() {
		return spCartPackageLocalService;
	}

	/**
	 * Sets the s p cart package local service.
	 *
	 * @param spCartPackageLocalService the s p cart package local service
	 */
	public void setSPCartPackageLocalService(
		com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalService spCartPackageLocalService) {
		this.spCartPackageLocalService = spCartPackageLocalService;
	}

	/**
	 * Returns the s p cart package persistence.
	 *
	 * @return the s p cart package persistence
	 */
	public SPCartPackagePersistence getSPCartPackagePersistence() {
		return spCartPackagePersistence;
	}

	/**
	 * Sets the s p cart package persistence.
	 *
	 * @param spCartPackagePersistence the s p cart package persistence
	 */
	public void setSPCartPackagePersistence(
		SPCartPackagePersistence spCartPackagePersistence) {
		this.spCartPackagePersistence = spCartPackagePersistence;
	}

	/**
	 * Returns the s p cart package item local service.
	 *
	 * @return the s p cart package item local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalService getSPCartPackageItemLocalService() {
		return spCartPackageItemLocalService;
	}

	/**
	 * Sets the s p cart package item local service.
	 *
	 * @param spCartPackageItemLocalService the s p cart package item local service
	 */
	public void setSPCartPackageItemLocalService(
		com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalService spCartPackageItemLocalService) {
		this.spCartPackageItemLocalService = spCartPackageItemLocalService;
	}

	/**
	 * Returns the s p cart package item persistence.
	 *
	 * @return the s p cart package item persistence
	 */
	public SPCartPackageItemPersistence getSPCartPackageItemPersistence() {
		return spCartPackageItemPersistence;
	}

	/**
	 * Sets the s p cart package item persistence.
	 *
	 * @param spCartPackageItemPersistence the s p cart package item persistence
	 */
	public void setSPCartPackageItemPersistence(
		SPCartPackageItemPersistence spCartPackageItemPersistence) {
		this.spCartPackageItemPersistence = spCartPackageItemPersistence;
	}

	/**
	 * Returns the s p discount local service.
	 *
	 * @return the s p discount local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPDiscountLocalService getSPDiscountLocalService() {
		return spDiscountLocalService;
	}

	/**
	 * Sets the s p discount local service.
	 *
	 * @param spDiscountLocalService the s p discount local service
	 */
	public void setSPDiscountLocalService(
		com.sambaash.platform.srv.spshopping.service.SPDiscountLocalService spDiscountLocalService) {
		this.spDiscountLocalService = spDiscountLocalService;
	}

	/**
	 * Returns the s p discount persistence.
	 *
	 * @return the s p discount persistence
	 */
	public SPDiscountPersistence getSPDiscountPersistence() {
		return spDiscountPersistence;
	}

	/**
	 * Sets the s p discount persistence.
	 *
	 * @param spDiscountPersistence the s p discount persistence
	 */
	public void setSPDiscountPersistence(
		SPDiscountPersistence spDiscountPersistence) {
		this.spDiscountPersistence = spDiscountPersistence;
	}

	/**
	 * Returns the s p package items local service.
	 *
	 * @return the s p package items local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalService getSPPackageItemsLocalService() {
		return spPackageItemsLocalService;
	}

	/**
	 * Sets the s p package items local service.
	 *
	 * @param spPackageItemsLocalService the s p package items local service
	 */
	public void setSPPackageItemsLocalService(
		com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalService spPackageItemsLocalService) {
		this.spPackageItemsLocalService = spPackageItemsLocalService;
	}

	/**
	 * Returns the s p package items persistence.
	 *
	 * @return the s p package items persistence
	 */
	public SPPackageItemsPersistence getSPPackageItemsPersistence() {
		return spPackageItemsPersistence;
	}

	/**
	 * Sets the s p package items persistence.
	 *
	 * @param spPackageItemsPersistence the s p package items persistence
	 */
	public void setSPPackageItemsPersistence(
		SPPackageItemsPersistence spPackageItemsPersistence) {
		this.spPackageItemsPersistence = spPackageItemsPersistence;
	}

	/**
	 * Returns the s p selling item local service.
	 *
	 * @return the s p selling item local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalService getSPSellingItemLocalService() {
		return spSellingItemLocalService;
	}

	/**
	 * Sets the s p selling item local service.
	 *
	 * @param spSellingItemLocalService the s p selling item local service
	 */
	public void setSPSellingItemLocalService(
		com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalService spSellingItemLocalService) {
		this.spSellingItemLocalService = spSellingItemLocalService;
	}

	/**
	 * Returns the s p selling item persistence.
	 *
	 * @return the s p selling item persistence
	 */
	public SPSellingItemPersistence getSPSellingItemPersistence() {
		return spSellingItemPersistence;
	}

	/**
	 * Sets the s p selling item persistence.
	 *
	 * @param spSellingItemPersistence the s p selling item persistence
	 */
	public void setSPSellingItemPersistence(
		SPSellingItemPersistence spSellingItemPersistence) {
		this.spSellingItemPersistence = spSellingItemPersistence;
	}

	/**
	 * Returns the s p selling package local service.
	 *
	 * @return the s p selling package local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalService getSPSellingPackageLocalService() {
		return spSellingPackageLocalService;
	}

	/**
	 * Sets the s p selling package local service.
	 *
	 * @param spSellingPackageLocalService the s p selling package local service
	 */
	public void setSPSellingPackageLocalService(
		com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalService spSellingPackageLocalService) {
		this.spSellingPackageLocalService = spSellingPackageLocalService;
	}

	/**
	 * Returns the s p selling package persistence.
	 *
	 * @return the s p selling package persistence
	 */
	public SPSellingPackagePersistence getSPSellingPackagePersistence() {
		return spSellingPackagePersistence;
	}

	/**
	 * Sets the s p selling package persistence.
	 *
	 * @param spSellingPackagePersistence the s p selling package persistence
	 */
	public void setSPSellingPackagePersistence(
		SPSellingPackagePersistence spSellingPackagePersistence) {
		this.spSellingPackagePersistence = spSellingPackagePersistence;
	}

	/**
	 * Returns the s p selling price local service.
	 *
	 * @return the s p selling price local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalService getSPSellingPriceLocalService() {
		return spSellingPriceLocalService;
	}

	/**
	 * Sets the s p selling price local service.
	 *
	 * @param spSellingPriceLocalService the s p selling price local service
	 */
	public void setSPSellingPriceLocalService(
		com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalService spSellingPriceLocalService) {
		this.spSellingPriceLocalService = spSellingPriceLocalService;
	}

	/**
	 * Returns the s p selling price persistence.
	 *
	 * @return the s p selling price persistence
	 */
	public SPSellingPricePersistence getSPSellingPricePersistence() {
		return spSellingPricePersistence;
	}

	/**
	 * Sets the s p selling price persistence.
	 *
	 * @param spSellingPricePersistence the s p selling price persistence
	 */
	public void setSPSellingPricePersistence(
		SPSellingPricePersistence spSellingPricePersistence) {
		this.spSellingPricePersistence = spSellingPricePersistence;
	}

	/**
	 * Returns the s p shopping local service.
	 *
	 * @return the s p shopping local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPShoppingLocalService getSPShoppingLocalService() {
		return spShoppingLocalService;
	}

	/**
	 * Sets the s p shopping local service.
	 *
	 * @param spShoppingLocalService the s p shopping local service
	 */
	public void setSPShoppingLocalService(
		com.sambaash.platform.srv.spshopping.service.SPShoppingLocalService spShoppingLocalService) {
		this.spShoppingLocalService = spShoppingLocalService;
	}

	/**
	 * Returns the s p shopping remote service.
	 *
	 * @return the s p shopping remote service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPShoppingService getSPShoppingService() {
		return spShoppingService;
	}

	/**
	 * Sets the s p shopping remote service.
	 *
	 * @param spShoppingService the s p shopping remote service
	 */
	public void setSPShoppingService(
		com.sambaash.platform.srv.spshopping.service.SPShoppingService spShoppingService) {
		this.spShoppingService = spShoppingService;
	}

	/**
	 * Returns the s p tax local service.
	 *
	 * @return the s p tax local service
	 */
	public com.sambaash.platform.srv.spshopping.service.SPTaxLocalService getSPTaxLocalService() {
		return spTaxLocalService;
	}

	/**
	 * Sets the s p tax local service.
	 *
	 * @param spTaxLocalService the s p tax local service
	 */
	public void setSPTaxLocalService(
		com.sambaash.platform.srv.spshopping.service.SPTaxLocalService spTaxLocalService) {
		this.spTaxLocalService = spTaxLocalService;
	}

	/**
	 * Returns the s p tax persistence.
	 *
	 * @return the s p tax persistence
	 */
	public SPTaxPersistence getSPTaxPersistence() {
		return spTaxPersistence;
	}

	/**
	 * Sets the s p tax persistence.
	 *
	 * @param spTaxPersistence the s p tax persistence
	 */
	public void setSPTaxPersistence(SPTaxPersistence spTaxPersistence) {
		this.spTaxPersistence = spTaxPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPCartLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPCartLocalService spCartLocalService;
	@BeanReference(type = SPCartPersistence.class)
	protected SPCartPersistence spCartPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalService spCartPackageLocalService;
	@BeanReference(type = SPCartPackagePersistence.class)
	protected SPCartPackagePersistence spCartPackagePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalService spCartPackageItemLocalService;
	@BeanReference(type = SPCartPackageItemPersistence.class)
	protected SPCartPackageItemPersistence spCartPackageItemPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPDiscountLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPDiscountLocalService spDiscountLocalService;
	@BeanReference(type = SPDiscountPersistence.class)
	protected SPDiscountPersistence spDiscountPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalService spPackageItemsLocalService;
	@BeanReference(type = SPPackageItemsPersistence.class)
	protected SPPackageItemsPersistence spPackageItemsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalService spSellingItemLocalService;
	@BeanReference(type = SPSellingItemPersistence.class)
	protected SPSellingItemPersistence spSellingItemPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalService spSellingPackageLocalService;
	@BeanReference(type = SPSellingPackagePersistence.class)
	protected SPSellingPackagePersistence spSellingPackagePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalService spSellingPriceLocalService;
	@BeanReference(type = SPSellingPricePersistence.class)
	protected SPSellingPricePersistence spSellingPricePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPShoppingLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPShoppingLocalService spShoppingLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPShoppingService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPShoppingService spShoppingService;
	@BeanReference(type = com.sambaash.platform.srv.spshopping.service.SPTaxLocalService.class)
	protected com.sambaash.platform.srv.spshopping.service.SPTaxLocalService spTaxLocalService;
	@BeanReference(type = SPTaxPersistence.class)
	protected SPTaxPersistence spTaxPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SPShoppingServiceClpInvoker _clpInvoker = new SPShoppingServiceClpInvoker();
}