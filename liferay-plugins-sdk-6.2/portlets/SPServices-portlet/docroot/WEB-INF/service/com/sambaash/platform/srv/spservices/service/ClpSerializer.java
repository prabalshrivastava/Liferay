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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServicesClp;
import com.sambaash.platform.srv.spservices.model.MembershipPackageClp;
import com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServicesClp;
import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServicesClp;
import com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCodeClp;
import com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRolesClp;
import com.sambaash.platform.srv.spservices.model.MembershipSubscribedServicesClp;
import com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServicesClp;
import com.sambaash.platform.srv.spservices.model.MembershipSubscriptionClp;
import com.sambaash.platform.srv.spservices.model.SPApiAuditLogsClp;
import com.sambaash.platform.srv.spservices.model.SPAuditClp;
import com.sambaash.platform.srv.spservices.model.SPIPGeoLocationClp;
import com.sambaash.platform.srv.spservices.model.SPLdapMappingClp;
import com.sambaash.platform.srv.spservices.model.SPLdapProfileClp;
import com.sambaash.platform.srv.spservices.model.SPLikesClp;
import com.sambaash.platform.srv.spservices.model.SPListTypeClp;
import com.sambaash.platform.srv.spservices.model.SPParameterClp;
import com.sambaash.platform.srv.spservices.model.SPSiteClp;
import com.sambaash.platform.srv.spservices.model.SPSiteSetupClp;
import com.sambaash.platform.srv.spservices.model.SPUserTypeClp;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfigClp;
import com.sambaash.platform.srv.spservices.model.ServiceComponentGroupClp;
import com.sambaash.platform.srv.spservices.model.ServiceComponentsClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gauravvijayvergia
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"SPServices-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"SPServices-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "SPServices-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(MembershipPackageClp.class.getName())) {
			return translateInputMembershipPackage(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipPackageAddonServicesClp.class.getName())) {
			return translateInputMembershipPackageAddonServices(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipPackageGrpServicesClp.class.getName())) {
			return translateInputMembershipPackageGrpServices(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipPackageIndServicesClp.class.getName())) {
			return translateInputMembershipPackageIndServices(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipPackagePromotionCodeClp.class.getName())) {
			return translateInputMembershipPackagePromotionCode(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipPackageServicesRolesClp.class.getName())) {
			return translateInputMembershipPackageServicesRoles(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipSubscribedServicesClp.class.getName())) {
			return translateInputMembershipSubscribedServices(oldModel);
		}

		if (oldModelClassName.equals(MembershipSubscriptionClp.class.getName())) {
			return translateInputMembershipSubscription(oldModel);
		}

		if (oldModelClassName.equals(
					MembershipSubscriptionAddonServicesClp.class.getName())) {
			return translateInputMembershipSubscriptionAddonServices(oldModel);
		}

		if (oldModelClassName.equals(ServiceComponentGroupClp.class.getName())) {
			return translateInputServiceComponentGroup(oldModel);
		}

		if (oldModelClassName.equals(ServiceComponentsClp.class.getName())) {
			return translateInputServiceComponents(oldModel);
		}

		if (oldModelClassName.equals(SPApiAuditLogsClp.class.getName())) {
			return translateInputSPApiAuditLogs(oldModel);
		}

		if (oldModelClassName.equals(SPAuditClp.class.getName())) {
			return translateInputSPAudit(oldModel);
		}

		if (oldModelClassName.equals(SPIPGeoLocationClp.class.getName())) {
			return translateInputSPIPGeoLocation(oldModel);
		}

		if (oldModelClassName.equals(SPLdapMappingClp.class.getName())) {
			return translateInputSPLdapMapping(oldModel);
		}

		if (oldModelClassName.equals(SPLdapProfileClp.class.getName())) {
			return translateInputSPLdapProfile(oldModel);
		}

		if (oldModelClassName.equals(SPLikesClp.class.getName())) {
			return translateInputSPLikes(oldModel);
		}

		if (oldModelClassName.equals(SPListTypeClp.class.getName())) {
			return translateInputSPListType(oldModel);
		}

		if (oldModelClassName.equals(SPParameterClp.class.getName())) {
			return translateInputSPParameter(oldModel);
		}

		if (oldModelClassName.equals(SPSiteClp.class.getName())) {
			return translateInputSPSite(oldModel);
		}

		if (oldModelClassName.equals(SPSiteSetupClp.class.getName())) {
			return translateInputSPSiteSetup(oldModel);
		}

		if (oldModelClassName.equals(SPUserTypeClp.class.getName())) {
			return translateInputSPUserType(oldModel);
		}

		if (oldModelClassName.equals(SPUserTypeConfigClp.class.getName())) {
			return translateInputSPUserTypeConfig(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputMembershipPackage(BaseModel<?> oldModel) {
		MembershipPackageClp oldClpModel = (MembershipPackageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipPackageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipPackageAddonServices(
		BaseModel<?> oldModel) {
		MembershipPackageAddonServicesClp oldClpModel = (MembershipPackageAddonServicesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipPackageAddonServicesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipPackageGrpServices(
		BaseModel<?> oldModel) {
		MembershipPackageGrpServicesClp oldClpModel = (MembershipPackageGrpServicesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipPackageGrpServicesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipPackageIndServices(
		BaseModel<?> oldModel) {
		MembershipPackageIndServicesClp oldClpModel = (MembershipPackageIndServicesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipPackageIndServicesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipPackagePromotionCode(
		BaseModel<?> oldModel) {
		MembershipPackagePromotionCodeClp oldClpModel = (MembershipPackagePromotionCodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipPackagePromotionCodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipPackageServicesRoles(
		BaseModel<?> oldModel) {
		MembershipPackageServicesRolesClp oldClpModel = (MembershipPackageServicesRolesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipPackageServicesRolesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipSubscribedServices(
		BaseModel<?> oldModel) {
		MembershipSubscribedServicesClp oldClpModel = (MembershipSubscribedServicesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipSubscribedServicesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipSubscription(
		BaseModel<?> oldModel) {
		MembershipSubscriptionClp oldClpModel = (MembershipSubscriptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipSubscriptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembershipSubscriptionAddonServices(
		BaseModel<?> oldModel) {
		MembershipSubscriptionAddonServicesClp oldClpModel = (MembershipSubscriptionAddonServicesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipSubscriptionAddonServicesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputServiceComponentGroup(
		BaseModel<?> oldModel) {
		ServiceComponentGroupClp oldClpModel = (ServiceComponentGroupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getServiceComponentGroupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputServiceComponents(BaseModel<?> oldModel) {
		ServiceComponentsClp oldClpModel = (ServiceComponentsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getServiceComponentsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPApiAuditLogs(BaseModel<?> oldModel) {
		SPApiAuditLogsClp oldClpModel = (SPApiAuditLogsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPApiAuditLogsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPAudit(BaseModel<?> oldModel) {
		SPAuditClp oldClpModel = (SPAuditClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPAuditRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPIPGeoLocation(BaseModel<?> oldModel) {
		SPIPGeoLocationClp oldClpModel = (SPIPGeoLocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPIPGeoLocationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPLdapMapping(BaseModel<?> oldModel) {
		SPLdapMappingClp oldClpModel = (SPLdapMappingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPLdapMappingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPLdapProfile(BaseModel<?> oldModel) {
		SPLdapProfileClp oldClpModel = (SPLdapProfileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPLdapProfileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPLikes(BaseModel<?> oldModel) {
		SPLikesClp oldClpModel = (SPLikesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPLikesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPListType(BaseModel<?> oldModel) {
		SPListTypeClp oldClpModel = (SPListTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPListTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPParameter(BaseModel<?> oldModel) {
		SPParameterClp oldClpModel = (SPParameterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPParameterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPSite(BaseModel<?> oldModel) {
		SPSiteClp oldClpModel = (SPSiteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPSiteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPSiteSetup(BaseModel<?> oldModel) {
		SPSiteSetupClp oldClpModel = (SPSiteSetupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPSiteSetupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPUserType(BaseModel<?> oldModel) {
		SPUserTypeClp oldClpModel = (SPUserTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPUserTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPUserTypeConfig(BaseModel<?> oldModel) {
		SPUserTypeConfigClp oldClpModel = (SPUserTypeConfigClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPUserTypeConfigRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipPackageImpl")) {
			return translateOutputMembershipPackage(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesImpl")) {
			return translateOutputMembershipPackageAddonServices(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesImpl")) {
			return translateOutputMembershipPackageGrpServices(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesImpl")) {
			return translateOutputMembershipPackageIndServices(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeImpl")) {
			return translateOutputMembershipPackagePromotionCode(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesImpl")) {
			return translateOutputMembershipPackageServicesRoles(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesImpl")) {
			return translateOutputMembershipSubscribedServices(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionImpl")) {
			return translateOutputMembershipSubscription(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesImpl")) {
			return translateOutputMembershipSubscriptionAddonServices(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupImpl")) {
			return translateOutputServiceComponentGroup(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsImpl")) {
			return translateOutputServiceComponents(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsImpl")) {
			return translateOutputSPApiAuditLogs(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPAuditImpl")) {
			return translateOutputSPAudit(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationImpl")) {
			return translateOutputSPIPGeoLocation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingImpl")) {
			return translateOutputSPLdapMapping(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileImpl")) {
			return translateOutputSPLdapProfile(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPLikesImpl")) {
			return translateOutputSPLikes(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPListTypeImpl")) {
			return translateOutputSPListType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPParameterImpl")) {
			return translateOutputSPParameter(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPSiteImpl")) {
			return translateOutputSPSite(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupImpl")) {
			return translateOutputSPSiteSetup(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPUserTypeImpl")) {
			return translateOutputSPUserType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigImpl")) {
			return translateOutputSPUserTypeConfig(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.KeyNotFoundException")) {
			return new com.sambaash.platform.srv.spservices.KeyNotFoundException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.MPGrpServiceExceptionException")) {
			return new com.sambaash.platform.srv.spservices.MPGrpServiceExceptionException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.MembershipSubscriptionExceptionException")) {
			return new com.sambaash.platform.srv.spservices.MembershipSubscriptionExceptionException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoPromotionCodeForMembershipException")) {
			return new com.sambaash.platform.srv.spservices.NoPromotionCodeForMembershipException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.PromotionCodeNotMatchException")) {
			return new com.sambaash.platform.srv.spservices.PromotionCodeNotMatchException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.PromotionCodePeriodException")) {
			return new com.sambaash.platform.srv.spservices.PromotionCodePeriodException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.ServiceComponentsExceptionException")) {
			return new com.sambaash.platform.srv.spservices.ServiceComponentsExceptionException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPAuditException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPAuditException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPLikesException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPLikesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPListTypeException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPListTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPParameterException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPParameterException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPSiteException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPSiteException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException")) {
			return new com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException();
		}

		return throwable;
	}

	public static Object translateOutputMembershipPackage(BaseModel<?> oldModel) {
		MembershipPackageClp newModel = new MembershipPackageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipPackageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipPackageAddonServices(
		BaseModel<?> oldModel) {
		MembershipPackageAddonServicesClp newModel = new MembershipPackageAddonServicesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipPackageAddonServicesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipPackageGrpServices(
		BaseModel<?> oldModel) {
		MembershipPackageGrpServicesClp newModel = new MembershipPackageGrpServicesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipPackageGrpServicesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipPackageIndServices(
		BaseModel<?> oldModel) {
		MembershipPackageIndServicesClp newModel = new MembershipPackageIndServicesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipPackageIndServicesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipPackagePromotionCode(
		BaseModel<?> oldModel) {
		MembershipPackagePromotionCodeClp newModel = new MembershipPackagePromotionCodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipPackagePromotionCodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipPackageServicesRoles(
		BaseModel<?> oldModel) {
		MembershipPackageServicesRolesClp newModel = new MembershipPackageServicesRolesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipPackageServicesRolesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipSubscribedServices(
		BaseModel<?> oldModel) {
		MembershipSubscribedServicesClp newModel = new MembershipSubscribedServicesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipSubscribedServicesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipSubscription(
		BaseModel<?> oldModel) {
		MembershipSubscriptionClp newModel = new MembershipSubscriptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipSubscriptionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembershipSubscriptionAddonServices(
		BaseModel<?> oldModel) {
		MembershipSubscriptionAddonServicesClp newModel = new MembershipSubscriptionAddonServicesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipSubscriptionAddonServicesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputServiceComponentGroup(
		BaseModel<?> oldModel) {
		ServiceComponentGroupClp newModel = new ServiceComponentGroupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setServiceComponentGroupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputServiceComponents(BaseModel<?> oldModel) {
		ServiceComponentsClp newModel = new ServiceComponentsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setServiceComponentsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPApiAuditLogs(BaseModel<?> oldModel) {
		SPApiAuditLogsClp newModel = new SPApiAuditLogsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPApiAuditLogsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPAudit(BaseModel<?> oldModel) {
		SPAuditClp newModel = new SPAuditClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPAuditRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPIPGeoLocation(BaseModel<?> oldModel) {
		SPIPGeoLocationClp newModel = new SPIPGeoLocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPIPGeoLocationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPLdapMapping(BaseModel<?> oldModel) {
		SPLdapMappingClp newModel = new SPLdapMappingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPLdapMappingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPLdapProfile(BaseModel<?> oldModel) {
		SPLdapProfileClp newModel = new SPLdapProfileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPLdapProfileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPLikes(BaseModel<?> oldModel) {
		SPLikesClp newModel = new SPLikesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPLikesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPListType(BaseModel<?> oldModel) {
		SPListTypeClp newModel = new SPListTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPListTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPParameter(BaseModel<?> oldModel) {
		SPParameterClp newModel = new SPParameterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPParameterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPSite(BaseModel<?> oldModel) {
		SPSiteClp newModel = new SPSiteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPSiteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPSiteSetup(BaseModel<?> oldModel) {
		SPSiteSetupClp newModel = new SPSiteSetupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPSiteSetupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPUserType(BaseModel<?> oldModel) {
		SPUserTypeClp newModel = new SPUserTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPUserTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPUserTypeConfig(BaseModel<?> oldModel) {
		SPUserTypeConfigClp newModel = new SPUserTypeConfigClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPUserTypeConfigRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}