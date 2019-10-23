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

package com.sambaash.platform.srv.spservices.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sambaash.platform.srv.spservices.model.SPLikes;
import com.sambaash.platform.srv.spservices.service.SPLikesService;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageAddonServicesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageGrpServicesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageIndServicesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackagePersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackagePromotionCodePersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageServicesRolesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipSubscribedServicesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipSubscriptionAddonServicesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipSubscriptionPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPApiAuditLogsPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPIPGeoLocationPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPLdapMappingPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPLdapProfilePersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPLikesPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPListTypePersistence;
import com.sambaash.platform.srv.spservices.service.persistence.SPParameterFinder;
import com.sambaash.platform.srv.spservices.service.persistence.SPParameterPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.ServiceComponentGroupPersistence;
import com.sambaash.platform.srv.spservices.service.persistence.ServiceComponentsPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the s p likes remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sambaash.platform.srv.spservices.service.impl.SPLikesServiceImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.impl.SPLikesServiceImpl
 * @see com.sambaash.platform.srv.spservices.service.SPLikesServiceUtil
 * @generated
 */
public abstract class SPLikesServiceBaseImpl extends BaseServiceImpl
	implements SPLikesService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sambaash.platform.srv.spservices.service.SPLikesServiceUtil} to access the s p likes remote service.
	 */

	/**
	 * Returns the membership package local service.
	 *
	 * @return the membership package local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipPackageLocalService getMembershipPackageLocalService() {
		return membershipPackageLocalService;
	}

	/**
	 * Sets the membership package local service.
	 *
	 * @param membershipPackageLocalService the membership package local service
	 */
	public void setMembershipPackageLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipPackageLocalService membershipPackageLocalService) {
		this.membershipPackageLocalService = membershipPackageLocalService;
	}

	/**
	 * Returns the membership package persistence.
	 *
	 * @return the membership package persistence
	 */
	public MembershipPackagePersistence getMembershipPackagePersistence() {
		return membershipPackagePersistence;
	}

	/**
	 * Sets the membership package persistence.
	 *
	 * @param membershipPackagePersistence the membership package persistence
	 */
	public void setMembershipPackagePersistence(
		MembershipPackagePersistence membershipPackagePersistence) {
		this.membershipPackagePersistence = membershipPackagePersistence;
	}

	/**
	 * Returns the membership package addon services local service.
	 *
	 * @return the membership package addon services local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalService getMembershipPackageAddonServicesLocalService() {
		return membershipPackageAddonServicesLocalService;
	}

	/**
	 * Sets the membership package addon services local service.
	 *
	 * @param membershipPackageAddonServicesLocalService the membership package addon services local service
	 */
	public void setMembershipPackageAddonServicesLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalService membershipPackageAddonServicesLocalService) {
		this.membershipPackageAddonServicesLocalService = membershipPackageAddonServicesLocalService;
	}

	/**
	 * Returns the membership package addon services persistence.
	 *
	 * @return the membership package addon services persistence
	 */
	public MembershipPackageAddonServicesPersistence getMembershipPackageAddonServicesPersistence() {
		return membershipPackageAddonServicesPersistence;
	}

	/**
	 * Sets the membership package addon services persistence.
	 *
	 * @param membershipPackageAddonServicesPersistence the membership package addon services persistence
	 */
	public void setMembershipPackageAddonServicesPersistence(
		MembershipPackageAddonServicesPersistence membershipPackageAddonServicesPersistence) {
		this.membershipPackageAddonServicesPersistence = membershipPackageAddonServicesPersistence;
	}

	/**
	 * Returns the membership package grp services local service.
	 *
	 * @return the membership package grp services local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalService getMembershipPackageGrpServicesLocalService() {
		return membershipPackageGrpServicesLocalService;
	}

	/**
	 * Sets the membership package grp services local service.
	 *
	 * @param membershipPackageGrpServicesLocalService the membership package grp services local service
	 */
	public void setMembershipPackageGrpServicesLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalService membershipPackageGrpServicesLocalService) {
		this.membershipPackageGrpServicesLocalService = membershipPackageGrpServicesLocalService;
	}

	/**
	 * Returns the membership package grp services persistence.
	 *
	 * @return the membership package grp services persistence
	 */
	public MembershipPackageGrpServicesPersistence getMembershipPackageGrpServicesPersistence() {
		return membershipPackageGrpServicesPersistence;
	}

	/**
	 * Sets the membership package grp services persistence.
	 *
	 * @param membershipPackageGrpServicesPersistence the membership package grp services persistence
	 */
	public void setMembershipPackageGrpServicesPersistence(
		MembershipPackageGrpServicesPersistence membershipPackageGrpServicesPersistence) {
		this.membershipPackageGrpServicesPersistence = membershipPackageGrpServicesPersistence;
	}

	/**
	 * Returns the membership package ind services local service.
	 *
	 * @return the membership package ind services local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalService getMembershipPackageIndServicesLocalService() {
		return membershipPackageIndServicesLocalService;
	}

	/**
	 * Sets the membership package ind services local service.
	 *
	 * @param membershipPackageIndServicesLocalService the membership package ind services local service
	 */
	public void setMembershipPackageIndServicesLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalService membershipPackageIndServicesLocalService) {
		this.membershipPackageIndServicesLocalService = membershipPackageIndServicesLocalService;
	}

	/**
	 * Returns the membership package ind services persistence.
	 *
	 * @return the membership package ind services persistence
	 */
	public MembershipPackageIndServicesPersistence getMembershipPackageIndServicesPersistence() {
		return membershipPackageIndServicesPersistence;
	}

	/**
	 * Sets the membership package ind services persistence.
	 *
	 * @param membershipPackageIndServicesPersistence the membership package ind services persistence
	 */
	public void setMembershipPackageIndServicesPersistence(
		MembershipPackageIndServicesPersistence membershipPackageIndServicesPersistence) {
		this.membershipPackageIndServicesPersistence = membershipPackageIndServicesPersistence;
	}

	/**
	 * Returns the membership package promotion code local service.
	 *
	 * @return the membership package promotion code local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalService getMembershipPackagePromotionCodeLocalService() {
		return membershipPackagePromotionCodeLocalService;
	}

	/**
	 * Sets the membership package promotion code local service.
	 *
	 * @param membershipPackagePromotionCodeLocalService the membership package promotion code local service
	 */
	public void setMembershipPackagePromotionCodeLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalService membershipPackagePromotionCodeLocalService) {
		this.membershipPackagePromotionCodeLocalService = membershipPackagePromotionCodeLocalService;
	}

	/**
	 * Returns the membership package promotion code persistence.
	 *
	 * @return the membership package promotion code persistence
	 */
	public MembershipPackagePromotionCodePersistence getMembershipPackagePromotionCodePersistence() {
		return membershipPackagePromotionCodePersistence;
	}

	/**
	 * Sets the membership package promotion code persistence.
	 *
	 * @param membershipPackagePromotionCodePersistence the membership package promotion code persistence
	 */
	public void setMembershipPackagePromotionCodePersistence(
		MembershipPackagePromotionCodePersistence membershipPackagePromotionCodePersistence) {
		this.membershipPackagePromotionCodePersistence = membershipPackagePromotionCodePersistence;
	}

	/**
	 * Returns the membership package services roles local service.
	 *
	 * @return the membership package services roles local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalService getMembershipPackageServicesRolesLocalService() {
		return membershipPackageServicesRolesLocalService;
	}

	/**
	 * Sets the membership package services roles local service.
	 *
	 * @param membershipPackageServicesRolesLocalService the membership package services roles local service
	 */
	public void setMembershipPackageServicesRolesLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalService membershipPackageServicesRolesLocalService) {
		this.membershipPackageServicesRolesLocalService = membershipPackageServicesRolesLocalService;
	}

	/**
	 * Returns the membership package services roles persistence.
	 *
	 * @return the membership package services roles persistence
	 */
	public MembershipPackageServicesRolesPersistence getMembershipPackageServicesRolesPersistence() {
		return membershipPackageServicesRolesPersistence;
	}

	/**
	 * Sets the membership package services roles persistence.
	 *
	 * @param membershipPackageServicesRolesPersistence the membership package services roles persistence
	 */
	public void setMembershipPackageServicesRolesPersistence(
		MembershipPackageServicesRolesPersistence membershipPackageServicesRolesPersistence) {
		this.membershipPackageServicesRolesPersistence = membershipPackageServicesRolesPersistence;
	}

	/**
	 * Returns the membership subscribed services local service.
	 *
	 * @return the membership subscribed services local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipSubscribedServicesLocalService getMembershipSubscribedServicesLocalService() {
		return membershipSubscribedServicesLocalService;
	}

	/**
	 * Sets the membership subscribed services local service.
	 *
	 * @param membershipSubscribedServicesLocalService the membership subscribed services local service
	 */
	public void setMembershipSubscribedServicesLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipSubscribedServicesLocalService membershipSubscribedServicesLocalService) {
		this.membershipSubscribedServicesLocalService = membershipSubscribedServicesLocalService;
	}

	/**
	 * Returns the membership subscribed services persistence.
	 *
	 * @return the membership subscribed services persistence
	 */
	public MembershipSubscribedServicesPersistence getMembershipSubscribedServicesPersistence() {
		return membershipSubscribedServicesPersistence;
	}

	/**
	 * Sets the membership subscribed services persistence.
	 *
	 * @param membershipSubscribedServicesPersistence the membership subscribed services persistence
	 */
	public void setMembershipSubscribedServicesPersistence(
		MembershipSubscribedServicesPersistence membershipSubscribedServicesPersistence) {
		this.membershipSubscribedServicesPersistence = membershipSubscribedServicesPersistence;
	}

	/**
	 * Returns the membership subscription local service.
	 *
	 * @return the membership subscription local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalService getMembershipSubscriptionLocalService() {
		return membershipSubscriptionLocalService;
	}

	/**
	 * Sets the membership subscription local service.
	 *
	 * @param membershipSubscriptionLocalService the membership subscription local service
	 */
	public void setMembershipSubscriptionLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalService membershipSubscriptionLocalService) {
		this.membershipSubscriptionLocalService = membershipSubscriptionLocalService;
	}

	/**
	 * Returns the membership subscription persistence.
	 *
	 * @return the membership subscription persistence
	 */
	public MembershipSubscriptionPersistence getMembershipSubscriptionPersistence() {
		return membershipSubscriptionPersistence;
	}

	/**
	 * Sets the membership subscription persistence.
	 *
	 * @param membershipSubscriptionPersistence the membership subscription persistence
	 */
	public void setMembershipSubscriptionPersistence(
		MembershipSubscriptionPersistence membershipSubscriptionPersistence) {
		this.membershipSubscriptionPersistence = membershipSubscriptionPersistence;
	}

	/**
	 * Returns the membership subscription addon services local service.
	 *
	 * @return the membership subscription addon services local service
	 */
	public com.sambaash.platform.srv.spservices.service.MembershipSubscriptionAddonServicesLocalService getMembershipSubscriptionAddonServicesLocalService() {
		return membershipSubscriptionAddonServicesLocalService;
	}

	/**
	 * Sets the membership subscription addon services local service.
	 *
	 * @param membershipSubscriptionAddonServicesLocalService the membership subscription addon services local service
	 */
	public void setMembershipSubscriptionAddonServicesLocalService(
		com.sambaash.platform.srv.spservices.service.MembershipSubscriptionAddonServicesLocalService membershipSubscriptionAddonServicesLocalService) {
		this.membershipSubscriptionAddonServicesLocalService = membershipSubscriptionAddonServicesLocalService;
	}

	/**
	 * Returns the membership subscription addon services persistence.
	 *
	 * @return the membership subscription addon services persistence
	 */
	public MembershipSubscriptionAddonServicesPersistence getMembershipSubscriptionAddonServicesPersistence() {
		return membershipSubscriptionAddonServicesPersistence;
	}

	/**
	 * Sets the membership subscription addon services persistence.
	 *
	 * @param membershipSubscriptionAddonServicesPersistence the membership subscription addon services persistence
	 */
	public void setMembershipSubscriptionAddonServicesPersistence(
		MembershipSubscriptionAddonServicesPersistence membershipSubscriptionAddonServicesPersistence) {
		this.membershipSubscriptionAddonServicesPersistence = membershipSubscriptionAddonServicesPersistence;
	}

	/**
	 * Returns the service component group local service.
	 *
	 * @return the service component group local service
	 */
	public com.sambaash.platform.srv.spservices.service.ServiceComponentGroupLocalService getServiceComponentGroupLocalService() {
		return serviceComponentGroupLocalService;
	}

	/**
	 * Sets the service component group local service.
	 *
	 * @param serviceComponentGroupLocalService the service component group local service
	 */
	public void setServiceComponentGroupLocalService(
		com.sambaash.platform.srv.spservices.service.ServiceComponentGroupLocalService serviceComponentGroupLocalService) {
		this.serviceComponentGroupLocalService = serviceComponentGroupLocalService;
	}

	/**
	 * Returns the service component group persistence.
	 *
	 * @return the service component group persistence
	 */
	public ServiceComponentGroupPersistence getServiceComponentGroupPersistence() {
		return serviceComponentGroupPersistence;
	}

	/**
	 * Sets the service component group persistence.
	 *
	 * @param serviceComponentGroupPersistence the service component group persistence
	 */
	public void setServiceComponentGroupPersistence(
		ServiceComponentGroupPersistence serviceComponentGroupPersistence) {
		this.serviceComponentGroupPersistence = serviceComponentGroupPersistence;
	}

	/**
	 * Returns the service components local service.
	 *
	 * @return the service components local service
	 */
	public com.sambaash.platform.srv.spservices.service.ServiceComponentsLocalService getServiceComponentsLocalService() {
		return serviceComponentsLocalService;
	}

	/**
	 * Sets the service components local service.
	 *
	 * @param serviceComponentsLocalService the service components local service
	 */
	public void setServiceComponentsLocalService(
		com.sambaash.platform.srv.spservices.service.ServiceComponentsLocalService serviceComponentsLocalService) {
		this.serviceComponentsLocalService = serviceComponentsLocalService;
	}

	/**
	 * Returns the service components persistence.
	 *
	 * @return the service components persistence
	 */
	public ServiceComponentsPersistence getServiceComponentsPersistence() {
		return serviceComponentsPersistence;
	}

	/**
	 * Sets the service components persistence.
	 *
	 * @param serviceComponentsPersistence the service components persistence
	 */
	public void setServiceComponentsPersistence(
		ServiceComponentsPersistence serviceComponentsPersistence) {
		this.serviceComponentsPersistence = serviceComponentsPersistence;
	}

	/**
	 * Returns the s p api audit logs local service.
	 *
	 * @return the s p api audit logs local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalService getSPApiAuditLogsLocalService() {
		return spApiAuditLogsLocalService;
	}

	/**
	 * Sets the s p api audit logs local service.
	 *
	 * @param spApiAuditLogsLocalService the s p api audit logs local service
	 */
	public void setSPApiAuditLogsLocalService(
		com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalService spApiAuditLogsLocalService) {
		this.spApiAuditLogsLocalService = spApiAuditLogsLocalService;
	}

	/**
	 * Returns the s p api audit logs persistence.
	 *
	 * @return the s p api audit logs persistence
	 */
	public SPApiAuditLogsPersistence getSPApiAuditLogsPersistence() {
		return spApiAuditLogsPersistence;
	}

	/**
	 * Sets the s p api audit logs persistence.
	 *
	 * @param spApiAuditLogsPersistence the s p api audit logs persistence
	 */
	public void setSPApiAuditLogsPersistence(
		SPApiAuditLogsPersistence spApiAuditLogsPersistence) {
		this.spApiAuditLogsPersistence = spApiAuditLogsPersistence;
	}

	/**
	 * Returns the s p i p geo location local service.
	 *
	 * @return the s p i p geo location local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalService getSPIPGeoLocationLocalService() {
		return spipGeoLocationLocalService;
	}

	/**
	 * Sets the s p i p geo location local service.
	 *
	 * @param spipGeoLocationLocalService the s p i p geo location local service
	 */
	public void setSPIPGeoLocationLocalService(
		com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalService spipGeoLocationLocalService) {
		this.spipGeoLocationLocalService = spipGeoLocationLocalService;
	}

	/**
	 * Returns the s p i p geo location persistence.
	 *
	 * @return the s p i p geo location persistence
	 */
	public SPIPGeoLocationPersistence getSPIPGeoLocationPersistence() {
		return spipGeoLocationPersistence;
	}

	/**
	 * Sets the s p i p geo location persistence.
	 *
	 * @param spipGeoLocationPersistence the s p i p geo location persistence
	 */
	public void setSPIPGeoLocationPersistence(
		SPIPGeoLocationPersistence spipGeoLocationPersistence) {
		this.spipGeoLocationPersistence = spipGeoLocationPersistence;
	}

	/**
	 * Returns the s p ldap mapping local service.
	 *
	 * @return the s p ldap mapping local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalService getSPLdapMappingLocalService() {
		return spLdapMappingLocalService;
	}

	/**
	 * Sets the s p ldap mapping local service.
	 *
	 * @param spLdapMappingLocalService the s p ldap mapping local service
	 */
	public void setSPLdapMappingLocalService(
		com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalService spLdapMappingLocalService) {
		this.spLdapMappingLocalService = spLdapMappingLocalService;
	}

	/**
	 * Returns the s p ldap mapping persistence.
	 *
	 * @return the s p ldap mapping persistence
	 */
	public SPLdapMappingPersistence getSPLdapMappingPersistence() {
		return spLdapMappingPersistence;
	}

	/**
	 * Sets the s p ldap mapping persistence.
	 *
	 * @param spLdapMappingPersistence the s p ldap mapping persistence
	 */
	public void setSPLdapMappingPersistence(
		SPLdapMappingPersistence spLdapMappingPersistence) {
		this.spLdapMappingPersistence = spLdapMappingPersistence;
	}

	/**
	 * Returns the s p ldap profile local service.
	 *
	 * @return the s p ldap profile local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalService getSPLdapProfileLocalService() {
		return spLdapProfileLocalService;
	}

	/**
	 * Sets the s p ldap profile local service.
	 *
	 * @param spLdapProfileLocalService the s p ldap profile local service
	 */
	public void setSPLdapProfileLocalService(
		com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalService spLdapProfileLocalService) {
		this.spLdapProfileLocalService = spLdapProfileLocalService;
	}

	/**
	 * Returns the s p ldap profile persistence.
	 *
	 * @return the s p ldap profile persistence
	 */
	public SPLdapProfilePersistence getSPLdapProfilePersistence() {
		return spLdapProfilePersistence;
	}

	/**
	 * Sets the s p ldap profile persistence.
	 *
	 * @param spLdapProfilePersistence the s p ldap profile persistence
	 */
	public void setSPLdapProfilePersistence(
		SPLdapProfilePersistence spLdapProfilePersistence) {
		this.spLdapProfilePersistence = spLdapProfilePersistence;
	}

	/**
	 * Returns the s p likes local service.
	 *
	 * @return the s p likes local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPLikesLocalService getSPLikesLocalService() {
		return spLikesLocalService;
	}

	/**
	 * Sets the s p likes local service.
	 *
	 * @param spLikesLocalService the s p likes local service
	 */
	public void setSPLikesLocalService(
		com.sambaash.platform.srv.spservices.service.SPLikesLocalService spLikesLocalService) {
		this.spLikesLocalService = spLikesLocalService;
	}

	/**
	 * Returns the s p likes remote service.
	 *
	 * @return the s p likes remote service
	 */
	public com.sambaash.platform.srv.spservices.service.SPLikesService getSPLikesService() {
		return spLikesService;
	}

	/**
	 * Sets the s p likes remote service.
	 *
	 * @param spLikesService the s p likes remote service
	 */
	public void setSPLikesService(
		com.sambaash.platform.srv.spservices.service.SPLikesService spLikesService) {
		this.spLikesService = spLikesService;
	}

	/**
	 * Returns the s p likes persistence.
	 *
	 * @return the s p likes persistence
	 */
	public SPLikesPersistence getSPLikesPersistence() {
		return spLikesPersistence;
	}

	/**
	 * Sets the s p likes persistence.
	 *
	 * @param spLikesPersistence the s p likes persistence
	 */
	public void setSPLikesPersistence(SPLikesPersistence spLikesPersistence) {
		this.spLikesPersistence = spLikesPersistence;
	}

	/**
	 * Returns the s p list type local service.
	 *
	 * @return the s p list type local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPListTypeLocalService getSPListTypeLocalService() {
		return spListTypeLocalService;
	}

	/**
	 * Sets the s p list type local service.
	 *
	 * @param spListTypeLocalService the s p list type local service
	 */
	public void setSPListTypeLocalService(
		com.sambaash.platform.srv.spservices.service.SPListTypeLocalService spListTypeLocalService) {
		this.spListTypeLocalService = spListTypeLocalService;
	}

	/**
	 * Returns the s p list type persistence.
	 *
	 * @return the s p list type persistence
	 */
	public SPListTypePersistence getSPListTypePersistence() {
		return spListTypePersistence;
	}

	/**
	 * Sets the s p list type persistence.
	 *
	 * @param spListTypePersistence the s p list type persistence
	 */
	public void setSPListTypePersistence(
		SPListTypePersistence spListTypePersistence) {
		this.spListTypePersistence = spListTypePersistence;
	}

	/**
	 * Returns the s p parameter local service.
	 *
	 * @return the s p parameter local service
	 */
	public com.sambaash.platform.srv.spservices.service.SPParameterLocalService getSPParameterLocalService() {
		return spParameterLocalService;
	}

	/**
	 * Sets the s p parameter local service.
	 *
	 * @param spParameterLocalService the s p parameter local service
	 */
	public void setSPParameterLocalService(
		com.sambaash.platform.srv.spservices.service.SPParameterLocalService spParameterLocalService) {
		this.spParameterLocalService = spParameterLocalService;
	}

	/**
	 * Returns the s p parameter persistence.
	 *
	 * @return the s p parameter persistence
	 */
	public SPParameterPersistence getSPParameterPersistence() {
		return spParameterPersistence;
	}

	/**
	 * Sets the s p parameter persistence.
	 *
	 * @param spParameterPersistence the s p parameter persistence
	 */
	public void setSPParameterPersistence(
		SPParameterPersistence spParameterPersistence) {
		this.spParameterPersistence = spParameterPersistence;
	}

	/**
	 * Returns the s p parameter finder.
	 *
	 * @return the s p parameter finder
	 */
	public SPParameterFinder getSPParameterFinder() {
		return spParameterFinder;
	}

	/**
	 * Sets the s p parameter finder.
	 *
	 * @param spParameterFinder the s p parameter finder
	 */
	public void setSPParameterFinder(SPParameterFinder spParameterFinder) {
		this.spParameterFinder = spParameterFinder;
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

	protected Class<?> getModelClass() {
		return SPLikes.class;
	}

	protected String getModelClassName() {
		return SPLikes.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spLikesPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipPackageLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipPackageLocalService membershipPackageLocalService;
	@BeanReference(type = MembershipPackagePersistence.class)
	protected MembershipPackagePersistence membershipPackagePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalService membershipPackageAddonServicesLocalService;
	@BeanReference(type = MembershipPackageAddonServicesPersistence.class)
	protected MembershipPackageAddonServicesPersistence membershipPackageAddonServicesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalService membershipPackageGrpServicesLocalService;
	@BeanReference(type = MembershipPackageGrpServicesPersistence.class)
	protected MembershipPackageGrpServicesPersistence membershipPackageGrpServicesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalService membershipPackageIndServicesLocalService;
	@BeanReference(type = MembershipPackageIndServicesPersistence.class)
	protected MembershipPackageIndServicesPersistence membershipPackageIndServicesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalService membershipPackagePromotionCodeLocalService;
	@BeanReference(type = MembershipPackagePromotionCodePersistence.class)
	protected MembershipPackagePromotionCodePersistence membershipPackagePromotionCodePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalService membershipPackageServicesRolesLocalService;
	@BeanReference(type = MembershipPackageServicesRolesPersistence.class)
	protected MembershipPackageServicesRolesPersistence membershipPackageServicesRolesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipSubscribedServicesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipSubscribedServicesLocalService membershipSubscribedServicesLocalService;
	@BeanReference(type = MembershipSubscribedServicesPersistence.class)
	protected MembershipSubscribedServicesPersistence membershipSubscribedServicesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalService membershipSubscriptionLocalService;
	@BeanReference(type = MembershipSubscriptionPersistence.class)
	protected MembershipSubscriptionPersistence membershipSubscriptionPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.MembershipSubscriptionAddonServicesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.MembershipSubscriptionAddonServicesLocalService membershipSubscriptionAddonServicesLocalService;
	@BeanReference(type = MembershipSubscriptionAddonServicesPersistence.class)
	protected MembershipSubscriptionAddonServicesPersistence membershipSubscriptionAddonServicesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.ServiceComponentGroupLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.ServiceComponentGroupLocalService serviceComponentGroupLocalService;
	@BeanReference(type = ServiceComponentGroupPersistence.class)
	protected ServiceComponentGroupPersistence serviceComponentGroupPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.ServiceComponentsLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.ServiceComponentsLocalService serviceComponentsLocalService;
	@BeanReference(type = ServiceComponentsPersistence.class)
	protected ServiceComponentsPersistence serviceComponentsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalService spApiAuditLogsLocalService;
	@BeanReference(type = SPApiAuditLogsPersistence.class)
	protected SPApiAuditLogsPersistence spApiAuditLogsPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalService spipGeoLocationLocalService;
	@BeanReference(type = SPIPGeoLocationPersistence.class)
	protected SPIPGeoLocationPersistence spipGeoLocationPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalService spLdapMappingLocalService;
	@BeanReference(type = SPLdapMappingPersistence.class)
	protected SPLdapMappingPersistence spLdapMappingPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalService spLdapProfileLocalService;
	@BeanReference(type = SPLdapProfilePersistence.class)
	protected SPLdapProfilePersistence spLdapProfilePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPLikesLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPLikesLocalService spLikesLocalService;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPLikesService.class)
	protected com.sambaash.platform.srv.spservices.service.SPLikesService spLikesService;
	@BeanReference(type = SPLikesPersistence.class)
	protected SPLikesPersistence spLikesPersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPListTypeLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPListTypeLocalService spListTypeLocalService;
	@BeanReference(type = SPListTypePersistence.class)
	protected SPListTypePersistence spListTypePersistence;
	@BeanReference(type = com.sambaash.platform.srv.spservices.service.SPParameterLocalService.class)
	protected com.sambaash.platform.srv.spservices.service.SPParameterLocalService spParameterLocalService;
	@BeanReference(type = SPParameterPersistence.class)
	protected SPParameterPersistence spParameterPersistence;
	@BeanReference(type = SPParameterFinder.class)
	protected SPParameterFinder spParameterFinder;
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
	private SPLikesServiceClpInvoker _clpInvoker = new SPLikesServiceClpInvoker();
}