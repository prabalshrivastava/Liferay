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

package com.sambaash.platform.srv.spmicroservice.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalService;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the candidate microservice local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl}.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil
 * @generated
 */
public abstract class CandidateMicroserviceLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CandidateMicroserviceLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil} to access the candidate microservice local service.
	 */

	/**
	 * Returns the candidate microservice local service.
	 *
	 * @return the candidate microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalService getCandidateMicroserviceLocalService() {
		return candidateMicroserviceLocalService;
	}

	/**
	 * Sets the candidate microservice local service.
	 *
	 * @param candidateMicroserviceLocalService the candidate microservice local service
	 */
	public void setCandidateMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalService candidateMicroserviceLocalService) {
		this.candidateMicroserviceLocalService = candidateMicroserviceLocalService;
	}

	/**
	 * Returns the enrolment microservice local service.
	 *
	 * @return the enrolment microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.EnrolmentMicroserviceLocalService getEnrolmentMicroserviceLocalService() {
		return enrolmentMicroserviceLocalService;
	}

	/**
	 * Sets the enrolment microservice local service.
	 *
	 * @param enrolmentMicroserviceLocalService the enrolment microservice local service
	 */
	public void setEnrolmentMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.EnrolmentMicroserviceLocalService enrolmentMicroserviceLocalService) {
		this.enrolmentMicroserviceLocalService = enrolmentMicroserviceLocalService;
	}

	/**
	 * Returns the forms microservice local service.
	 *
	 * @return the forms microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalService getFormsMicroserviceLocalService() {
		return formsMicroserviceLocalService;
	}

	/**
	 * Sets the forms microservice local service.
	 *
	 * @param formsMicroserviceLocalService the forms microservice local service
	 */
	public void setFormsMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalService formsMicroserviceLocalService) {
		this.formsMicroserviceLocalService = formsMicroserviceLocalService;
	}

	/**
	 * Returns the pricing microservice local service.
	 *
	 * @return the pricing microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalService getPricingMicroserviceLocalService() {
		return pricingMicroserviceLocalService;
	}

	/**
	 * Sets the pricing microservice local service.
	 *
	 * @param pricingMicroserviceLocalService the pricing microservice local service
	 */
	public void setPricingMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalService pricingMicroserviceLocalService) {
		this.pricingMicroserviceLocalService = pricingMicroserviceLocalService;
	}

	/**
	 * Returns the rules microservice local service.
	 *
	 * @return the rules microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalService getRulesMicroserviceLocalService() {
		return rulesMicroserviceLocalService;
	}

	/**
	 * Sets the rules microservice local service.
	 *
	 * @param rulesMicroserviceLocalService the rules microservice local service
	 */
	public void setRulesMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalService rulesMicroserviceLocalService) {
		this.rulesMicroserviceLocalService = rulesMicroserviceLocalService;
	}

	/**
	 * Returns the s p microservice local service.
	 *
	 * @return the s p microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalService getSPMicroserviceLocalService() {
		return spMicroserviceLocalService;
	}

	/**
	 * Sets the s p microservice local service.
	 *
	 * @param spMicroserviceLocalService the s p microservice local service
	 */
	public void setSPMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalService spMicroserviceLocalService) {
		this.spMicroserviceLocalService = spMicroserviceLocalService;
	}

	/**
	 * Returns the s p microservice remote service.
	 *
	 * @return the s p microservice remote service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceService getSPMicroserviceService() {
		return spMicroserviceService;
	}

	/**
	 * Sets the s p microservice remote service.
	 *
	 * @param spMicroserviceService the s p microservice remote service
	 */
	public void setSPMicroserviceService(
		com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceService spMicroserviceService) {
		this.spMicroserviceService = spMicroserviceService;
	}

	/**
	 * Returns the system setup microservice local service.
	 *
	 * @return the system setup microservice local service
	 */
	public com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalService getSystemSetupMicroserviceLocalService() {
		return systemSetupMicroserviceLocalService;
	}

	/**
	 * Sets the system setup microservice local service.
	 *
	 * @param systemSetupMicroserviceLocalService the system setup microservice local service
	 */
	public void setSystemSetupMicroserviceLocalService(
		com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalService systemSetupMicroserviceLocalService) {
		this.systemSetupMicroserviceLocalService = systemSetupMicroserviceLocalService;
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

	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalService candidateMicroserviceLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.EnrolmentMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.EnrolmentMicroserviceLocalService enrolmentMicroserviceLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalService formsMicroserviceLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalService pricingMicroserviceLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalService rulesMicroserviceLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalService spMicroserviceLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceService spMicroserviceService;
	@BeanReference(type = com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalService.class)
	protected com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalService systemSetupMicroserviceLocalService;
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
	private CandidateMicroserviceLocalServiceClpInvoker _clpInvoker = new CandidateMicroserviceLocalServiceClpInvoker();
}