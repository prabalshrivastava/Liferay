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

package com.sambaash.platform.srv.startupprofile.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalService;
import com.sambaash.platform.srv.startupprofile.service.persistence.ATODocumentPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.AccreditationPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.AddressPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.ApprovedMentorsPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.EmployeeInfoPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.FundingRoundPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.GuidelinesPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.OrganisationRemarksPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.OrganizationPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.PersonPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.PrinciplesPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.QuestionnairePersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.ReAccreditationPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.RelationshipPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.SPATOContactsPersistence;
import com.sambaash.platform.srv.startupprofile.service.persistence.SPOrgContactUsPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the startup profile local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileLocalServiceImpl}.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.impl.StartupProfileLocalServiceImpl
 * @see com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalServiceUtil
 * @generated
 */
public abstract class StartupProfileLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements StartupProfileLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalServiceUtil} to access the startup profile local service.
	 */

	/**
	 * Returns the accreditation local service.
	 *
	 * @return the accreditation local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.AccreditationLocalService getAccreditationLocalService() {
		return accreditationLocalService;
	}

	/**
	 * Sets the accreditation local service.
	 *
	 * @param accreditationLocalService the accreditation local service
	 */
	public void setAccreditationLocalService(
		com.sambaash.platform.srv.startupprofile.service.AccreditationLocalService accreditationLocalService) {
		this.accreditationLocalService = accreditationLocalService;
	}

	/**
	 * Returns the accreditation persistence.
	 *
	 * @return the accreditation persistence
	 */
	public AccreditationPersistence getAccreditationPersistence() {
		return accreditationPersistence;
	}

	/**
	 * Sets the accreditation persistence.
	 *
	 * @param accreditationPersistence the accreditation persistence
	 */
	public void setAccreditationPersistence(
		AccreditationPersistence accreditationPersistence) {
		this.accreditationPersistence = accreditationPersistence;
	}

	/**
	 * Returns the address local service.
	 *
	 * @return the address local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.AddressLocalService getAddressLocalService() {
		return addressLocalService;
	}

	/**
	 * Sets the address local service.
	 *
	 * @param addressLocalService the address local service
	 */
	public void setAddressLocalService(
		com.sambaash.platform.srv.startupprofile.service.AddressLocalService addressLocalService) {
		this.addressLocalService = addressLocalService;
	}

	/**
	 * Returns the address persistence.
	 *
	 * @return the address persistence
	 */
	public AddressPersistence getAddressPersistence() {
		return addressPersistence;
	}

	/**
	 * Sets the address persistence.
	 *
	 * @param addressPersistence the address persistence
	 */
	public void setAddressPersistence(AddressPersistence addressPersistence) {
		this.addressPersistence = addressPersistence;
	}

	/**
	 * Returns the approved mentors local service.
	 *
	 * @return the approved mentors local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalService getApprovedMentorsLocalService() {
		return approvedMentorsLocalService;
	}

	/**
	 * Sets the approved mentors local service.
	 *
	 * @param approvedMentorsLocalService the approved mentors local service
	 */
	public void setApprovedMentorsLocalService(
		com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalService approvedMentorsLocalService) {
		this.approvedMentorsLocalService = approvedMentorsLocalService;
	}

	/**
	 * Returns the approved mentors persistence.
	 *
	 * @return the approved mentors persistence
	 */
	public ApprovedMentorsPersistence getApprovedMentorsPersistence() {
		return approvedMentorsPersistence;
	}

	/**
	 * Sets the approved mentors persistence.
	 *
	 * @param approvedMentorsPersistence the approved mentors persistence
	 */
	public void setApprovedMentorsPersistence(
		ApprovedMentorsPersistence approvedMentorsPersistence) {
		this.approvedMentorsPersistence = approvedMentorsPersistence;
	}

	/**
	 * Returns the a t o document local service.
	 *
	 * @return the a t o document local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalService getATODocumentLocalService() {
		return atoDocumentLocalService;
	}

	/**
	 * Sets the a t o document local service.
	 *
	 * @param atoDocumentLocalService the a t o document local service
	 */
	public void setATODocumentLocalService(
		com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalService atoDocumentLocalService) {
		this.atoDocumentLocalService = atoDocumentLocalService;
	}

	/**
	 * Returns the a t o document persistence.
	 *
	 * @return the a t o document persistence
	 */
	public ATODocumentPersistence getATODocumentPersistence() {
		return atoDocumentPersistence;
	}

	/**
	 * Sets the a t o document persistence.
	 *
	 * @param atoDocumentPersistence the a t o document persistence
	 */
	public void setATODocumentPersistence(
		ATODocumentPersistence atoDocumentPersistence) {
		this.atoDocumentPersistence = atoDocumentPersistence;
	}

	/**
	 * Returns the employee info local service.
	 *
	 * @return the employee info local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalService getEmployeeInfoLocalService() {
		return employeeInfoLocalService;
	}

	/**
	 * Sets the employee info local service.
	 *
	 * @param employeeInfoLocalService the employee info local service
	 */
	public void setEmployeeInfoLocalService(
		com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalService employeeInfoLocalService) {
		this.employeeInfoLocalService = employeeInfoLocalService;
	}

	/**
	 * Returns the employee info persistence.
	 *
	 * @return the employee info persistence
	 */
	public EmployeeInfoPersistence getEmployeeInfoPersistence() {
		return employeeInfoPersistence;
	}

	/**
	 * Sets the employee info persistence.
	 *
	 * @param employeeInfoPersistence the employee info persistence
	 */
	public void setEmployeeInfoPersistence(
		EmployeeInfoPersistence employeeInfoPersistence) {
		this.employeeInfoPersistence = employeeInfoPersistence;
	}

	/**
	 * Returns the funding round local service.
	 *
	 * @return the funding round local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalService getFundingRoundLocalService() {
		return fundingRoundLocalService;
	}

	/**
	 * Sets the funding round local service.
	 *
	 * @param fundingRoundLocalService the funding round local service
	 */
	public void setFundingRoundLocalService(
		com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalService fundingRoundLocalService) {
		this.fundingRoundLocalService = fundingRoundLocalService;
	}

	/**
	 * Returns the funding round persistence.
	 *
	 * @return the funding round persistence
	 */
	public FundingRoundPersistence getFundingRoundPersistence() {
		return fundingRoundPersistence;
	}

	/**
	 * Sets the funding round persistence.
	 *
	 * @param fundingRoundPersistence the funding round persistence
	 */
	public void setFundingRoundPersistence(
		FundingRoundPersistence fundingRoundPersistence) {
		this.fundingRoundPersistence = fundingRoundPersistence;
	}

	/**
	 * Returns the guidelines local service.
	 *
	 * @return the guidelines local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalService getGuidelinesLocalService() {
		return guidelinesLocalService;
	}

	/**
	 * Sets the guidelines local service.
	 *
	 * @param guidelinesLocalService the guidelines local service
	 */
	public void setGuidelinesLocalService(
		com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalService guidelinesLocalService) {
		this.guidelinesLocalService = guidelinesLocalService;
	}

	/**
	 * Returns the guidelines persistence.
	 *
	 * @return the guidelines persistence
	 */
	public GuidelinesPersistence getGuidelinesPersistence() {
		return guidelinesPersistence;
	}

	/**
	 * Sets the guidelines persistence.
	 *
	 * @param guidelinesPersistence the guidelines persistence
	 */
	public void setGuidelinesPersistence(
		GuidelinesPersistence guidelinesPersistence) {
		this.guidelinesPersistence = guidelinesPersistence;
	}

	/**
	 * Returns the organisation remarks local service.
	 *
	 * @return the organisation remarks local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalService getOrganisationRemarksLocalService() {
		return organisationRemarksLocalService;
	}

	/**
	 * Sets the organisation remarks local service.
	 *
	 * @param organisationRemarksLocalService the organisation remarks local service
	 */
	public void setOrganisationRemarksLocalService(
		com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalService organisationRemarksLocalService) {
		this.organisationRemarksLocalService = organisationRemarksLocalService;
	}

	/**
	 * Returns the organisation remarks persistence.
	 *
	 * @return the organisation remarks persistence
	 */
	public OrganisationRemarksPersistence getOrganisationRemarksPersistence() {
		return organisationRemarksPersistence;
	}

	/**
	 * Sets the organisation remarks persistence.
	 *
	 * @param organisationRemarksPersistence the organisation remarks persistence
	 */
	public void setOrganisationRemarksPersistence(
		OrganisationRemarksPersistence organisationRemarksPersistence) {
		this.organisationRemarksPersistence = organisationRemarksPersistence;
	}

	/**
	 * Returns the organization local service.
	 *
	 * @return the organization local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.OrganizationLocalService getOrganizationLocalService() {
		return organizationLocalService;
	}

	/**
	 * Sets the organization local service.
	 *
	 * @param organizationLocalService the organization local service
	 */
	public void setOrganizationLocalService(
		com.sambaash.platform.srv.startupprofile.service.OrganizationLocalService organizationLocalService) {
		this.organizationLocalService = organizationLocalService;
	}

	/**
	 * Returns the organization remote service.
	 *
	 * @return the organization remote service
	 */
	public com.sambaash.platform.srv.startupprofile.service.OrganizationService getOrganizationService() {
		return organizationService;
	}

	/**
	 * Sets the organization remote service.
	 *
	 * @param organizationService the organization remote service
	 */
	public void setOrganizationService(
		com.sambaash.platform.srv.startupprofile.service.OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	/**
	 * Returns the organization persistence.
	 *
	 * @return the organization persistence
	 */
	public OrganizationPersistence getOrganizationPersistence() {
		return organizationPersistence;
	}

	/**
	 * Sets the organization persistence.
	 *
	 * @param organizationPersistence the organization persistence
	 */
	public void setOrganizationPersistence(
		OrganizationPersistence organizationPersistence) {
		this.organizationPersistence = organizationPersistence;
	}

	/**
	 * Returns the person local service.
	 *
	 * @return the person local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.PersonLocalService getPersonLocalService() {
		return personLocalService;
	}

	/**
	 * Sets the person local service.
	 *
	 * @param personLocalService the person local service
	 */
	public void setPersonLocalService(
		com.sambaash.platform.srv.startupprofile.service.PersonLocalService personLocalService) {
		this.personLocalService = personLocalService;
	}

	/**
	 * Returns the person persistence.
	 *
	 * @return the person persistence
	 */
	public PersonPersistence getPersonPersistence() {
		return personPersistence;
	}

	/**
	 * Sets the person persistence.
	 *
	 * @param personPersistence the person persistence
	 */
	public void setPersonPersistence(PersonPersistence personPersistence) {
		this.personPersistence = personPersistence;
	}

	/**
	 * Returns the principles local service.
	 *
	 * @return the principles local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalService getPrinciplesLocalService() {
		return principlesLocalService;
	}

	/**
	 * Sets the principles local service.
	 *
	 * @param principlesLocalService the principles local service
	 */
	public void setPrinciplesLocalService(
		com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalService principlesLocalService) {
		this.principlesLocalService = principlesLocalService;
	}

	/**
	 * Returns the principles persistence.
	 *
	 * @return the principles persistence
	 */
	public PrinciplesPersistence getPrinciplesPersistence() {
		return principlesPersistence;
	}

	/**
	 * Sets the principles persistence.
	 *
	 * @param principlesPersistence the principles persistence
	 */
	public void setPrinciplesPersistence(
		PrinciplesPersistence principlesPersistence) {
		this.principlesPersistence = principlesPersistence;
	}

	/**
	 * Returns the questionnaire local service.
	 *
	 * @return the questionnaire local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalService getQuestionnaireLocalService() {
		return questionnaireLocalService;
	}

	/**
	 * Sets the questionnaire local service.
	 *
	 * @param questionnaireLocalService the questionnaire local service
	 */
	public void setQuestionnaireLocalService(
		com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalService questionnaireLocalService) {
		this.questionnaireLocalService = questionnaireLocalService;
	}

	/**
	 * Returns the questionnaire persistence.
	 *
	 * @return the questionnaire persistence
	 */
	public QuestionnairePersistence getQuestionnairePersistence() {
		return questionnairePersistence;
	}

	/**
	 * Sets the questionnaire persistence.
	 *
	 * @param questionnairePersistence the questionnaire persistence
	 */
	public void setQuestionnairePersistence(
		QuestionnairePersistence questionnairePersistence) {
		this.questionnairePersistence = questionnairePersistence;
	}

	/**
	 * Returns the re accreditation local service.
	 *
	 * @return the re accreditation local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalService getReAccreditationLocalService() {
		return reAccreditationLocalService;
	}

	/**
	 * Sets the re accreditation local service.
	 *
	 * @param reAccreditationLocalService the re accreditation local service
	 */
	public void setReAccreditationLocalService(
		com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalService reAccreditationLocalService) {
		this.reAccreditationLocalService = reAccreditationLocalService;
	}

	/**
	 * Returns the re accreditation persistence.
	 *
	 * @return the re accreditation persistence
	 */
	public ReAccreditationPersistence getReAccreditationPersistence() {
		return reAccreditationPersistence;
	}

	/**
	 * Sets the re accreditation persistence.
	 *
	 * @param reAccreditationPersistence the re accreditation persistence
	 */
	public void setReAccreditationPersistence(
		ReAccreditationPersistence reAccreditationPersistence) {
		this.reAccreditationPersistence = reAccreditationPersistence;
	}

	/**
	 * Returns the relationship local service.
	 *
	 * @return the relationship local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.RelationshipLocalService getRelationshipLocalService() {
		return relationshipLocalService;
	}

	/**
	 * Sets the relationship local service.
	 *
	 * @param relationshipLocalService the relationship local service
	 */
	public void setRelationshipLocalService(
		com.sambaash.platform.srv.startupprofile.service.RelationshipLocalService relationshipLocalService) {
		this.relationshipLocalService = relationshipLocalService;
	}

	/**
	 * Returns the relationship persistence.
	 *
	 * @return the relationship persistence
	 */
	public RelationshipPersistence getRelationshipPersistence() {
		return relationshipPersistence;
	}

	/**
	 * Sets the relationship persistence.
	 *
	 * @param relationshipPersistence the relationship persistence
	 */
	public void setRelationshipPersistence(
		RelationshipPersistence relationshipPersistence) {
		this.relationshipPersistence = relationshipPersistence;
	}

	/**
	 * Returns the s p a t o contacts local service.
	 *
	 * @return the s p a t o contacts local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalService getSPATOContactsLocalService() {
		return spatoContactsLocalService;
	}

	/**
	 * Sets the s p a t o contacts local service.
	 *
	 * @param spatoContactsLocalService the s p a t o contacts local service
	 */
	public void setSPATOContactsLocalService(
		com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalService spatoContactsLocalService) {
		this.spatoContactsLocalService = spatoContactsLocalService;
	}

	/**
	 * Returns the s p a t o contacts persistence.
	 *
	 * @return the s p a t o contacts persistence
	 */
	public SPATOContactsPersistence getSPATOContactsPersistence() {
		return spatoContactsPersistence;
	}

	/**
	 * Sets the s p a t o contacts persistence.
	 *
	 * @param spatoContactsPersistence the s p a t o contacts persistence
	 */
	public void setSPATOContactsPersistence(
		SPATOContactsPersistence spatoContactsPersistence) {
		this.spatoContactsPersistence = spatoContactsPersistence;
	}

	/**
	 * Returns the s p org contact us local service.
	 *
	 * @return the s p org contact us local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalService getSPOrgContactUsLocalService() {
		return spOrgContactUsLocalService;
	}

	/**
	 * Sets the s p org contact us local service.
	 *
	 * @param spOrgContactUsLocalService the s p org contact us local service
	 */
	public void setSPOrgContactUsLocalService(
		com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalService spOrgContactUsLocalService) {
		this.spOrgContactUsLocalService = spOrgContactUsLocalService;
	}

	/**
	 * Returns the s p org contact us persistence.
	 *
	 * @return the s p org contact us persistence
	 */
	public SPOrgContactUsPersistence getSPOrgContactUsPersistence() {
		return spOrgContactUsPersistence;
	}

	/**
	 * Sets the s p org contact us persistence.
	 *
	 * @param spOrgContactUsPersistence the s p org contact us persistence
	 */
	public void setSPOrgContactUsPersistence(
		SPOrgContactUsPersistence spOrgContactUsPersistence) {
		this.spOrgContactUsPersistence = spOrgContactUsPersistence;
	}

	/**
	 * Returns the startup profile local service.
	 *
	 * @return the startup profile local service
	 */
	public com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalService getStartupProfileLocalService() {
		return startupProfileLocalService;
	}

	/**
	 * Sets the startup profile local service.
	 *
	 * @param startupProfileLocalService the startup profile local service
	 */
	public void setStartupProfileLocalService(
		com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalService startupProfileLocalService) {
		this.startupProfileLocalService = startupProfileLocalService;
	}

	/**
	 * Returns the startup profile remote service.
	 *
	 * @return the startup profile remote service
	 */
	public com.sambaash.platform.srv.startupprofile.service.StartupProfileService getStartupProfileService() {
		return startupProfileService;
	}

	/**
	 * Sets the startup profile remote service.
	 *
	 * @param startupProfileService the startup profile remote service
	 */
	public void setStartupProfileService(
		com.sambaash.platform.srv.startupprofile.service.StartupProfileService startupProfileService) {
		this.startupProfileService = startupProfileService;
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

	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.AccreditationLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.AccreditationLocalService accreditationLocalService;
	@BeanReference(type = AccreditationPersistence.class)
	protected AccreditationPersistence accreditationPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.AddressLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.AddressLocalService addressLocalService;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalService approvedMentorsLocalService;
	@BeanReference(type = ApprovedMentorsPersistence.class)
	protected ApprovedMentorsPersistence approvedMentorsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalService atoDocumentLocalService;
	@BeanReference(type = ATODocumentPersistence.class)
	protected ATODocumentPersistence atoDocumentPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalService employeeInfoLocalService;
	@BeanReference(type = EmployeeInfoPersistence.class)
	protected EmployeeInfoPersistence employeeInfoPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalService fundingRoundLocalService;
	@BeanReference(type = FundingRoundPersistence.class)
	protected FundingRoundPersistence fundingRoundPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalService guidelinesLocalService;
	@BeanReference(type = GuidelinesPersistence.class)
	protected GuidelinesPersistence guidelinesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalService organisationRemarksLocalService;
	@BeanReference(type = OrganisationRemarksPersistence.class)
	protected OrganisationRemarksPersistence organisationRemarksPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.OrganizationLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.OrganizationLocalService organizationLocalService;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.OrganizationService.class)
	protected com.sambaash.platform.srv.startupprofile.service.OrganizationService organizationService;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.PersonLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.PersonLocalService personLocalService;
	@BeanReference(type = PersonPersistence.class)
	protected PersonPersistence personPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalService principlesLocalService;
	@BeanReference(type = PrinciplesPersistence.class)
	protected PrinciplesPersistence principlesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalService questionnaireLocalService;
	@BeanReference(type = QuestionnairePersistence.class)
	protected QuestionnairePersistence questionnairePersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalService reAccreditationLocalService;
	@BeanReference(type = ReAccreditationPersistence.class)
	protected ReAccreditationPersistence reAccreditationPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.RelationshipLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.RelationshipLocalService relationshipLocalService;
	@BeanReference(type = RelationshipPersistence.class)
	protected RelationshipPersistence relationshipPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalService spatoContactsLocalService;
	@BeanReference(type = SPATOContactsPersistence.class)
	protected SPATOContactsPersistence spatoContactsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalService spOrgContactUsLocalService;
	@BeanReference(type = SPOrgContactUsPersistence.class)
	protected SPOrgContactUsPersistence spOrgContactUsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalService.class)
	protected com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalService startupProfileLocalService;
	@BeanReference(type = com.sambaash.platform.srv.startupprofile.service.StartupProfileService.class)
	protected com.sambaash.platform.srv.startupprofile.service.StartupProfileService startupProfileService;
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
	private StartupProfileLocalServiceClpInvoker _clpInvoker = new StartupProfileLocalServiceClpInvoker();
}