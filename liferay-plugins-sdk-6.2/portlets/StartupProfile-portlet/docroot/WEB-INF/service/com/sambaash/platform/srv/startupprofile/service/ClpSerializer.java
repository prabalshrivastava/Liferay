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

package com.sambaash.platform.srv.startupprofile.service;

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

import com.sambaash.platform.srv.startupprofile.model.ATODocumentClp;
import com.sambaash.platform.srv.startupprofile.model.AccreditationClp;
import com.sambaash.platform.srv.startupprofile.model.AddressClp;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentorsClp;
import com.sambaash.platform.srv.startupprofile.model.EmployeeInfoClp;
import com.sambaash.platform.srv.startupprofile.model.FundingRoundClp;
import com.sambaash.platform.srv.startupprofile.model.GuidelinesClp;
import com.sambaash.platform.srv.startupprofile.model.OrganisationRemarksClp;
import com.sambaash.platform.srv.startupprofile.model.OrganizationClp;
import com.sambaash.platform.srv.startupprofile.model.PersonClp;
import com.sambaash.platform.srv.startupprofile.model.PrinciplesClp;
import com.sambaash.platform.srv.startupprofile.model.QuestionnaireClp;
import com.sambaash.platform.srv.startupprofile.model.ReAccreditationClp;
import com.sambaash.platform.srv.startupprofile.model.RelationshipClp;
import com.sambaash.platform.srv.startupprofile.model.SPATOContactsClp;
import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUsClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pradeep
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
						"StartupProfile-portlet-deployment-context");

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
							"StartupProfile-portlet-deployment-context");

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
				_servletContextName = "StartupProfile-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AccreditationClp.class.getName())) {
			return translateInputAccreditation(oldModel);
		}

		if (oldModelClassName.equals(AddressClp.class.getName())) {
			return translateInputAddress(oldModel);
		}

		if (oldModelClassName.equals(ApprovedMentorsClp.class.getName())) {
			return translateInputApprovedMentors(oldModel);
		}

		if (oldModelClassName.equals(ATODocumentClp.class.getName())) {
			return translateInputATODocument(oldModel);
		}

		if (oldModelClassName.equals(EmployeeInfoClp.class.getName())) {
			return translateInputEmployeeInfo(oldModel);
		}

		if (oldModelClassName.equals(FundingRoundClp.class.getName())) {
			return translateInputFundingRound(oldModel);
		}

		if (oldModelClassName.equals(GuidelinesClp.class.getName())) {
			return translateInputGuidelines(oldModel);
		}

		if (oldModelClassName.equals(OrganisationRemarksClp.class.getName())) {
			return translateInputOrganisationRemarks(oldModel);
		}

		if (oldModelClassName.equals(OrganizationClp.class.getName())) {
			return translateInputOrganization(oldModel);
		}

		if (oldModelClassName.equals(PersonClp.class.getName())) {
			return translateInputPerson(oldModel);
		}

		if (oldModelClassName.equals(PrinciplesClp.class.getName())) {
			return translateInputPrinciples(oldModel);
		}

		if (oldModelClassName.equals(QuestionnaireClp.class.getName())) {
			return translateInputQuestionnaire(oldModel);
		}

		if (oldModelClassName.equals(ReAccreditationClp.class.getName())) {
			return translateInputReAccreditation(oldModel);
		}

		if (oldModelClassName.equals(RelationshipClp.class.getName())) {
			return translateInputRelationship(oldModel);
		}

		if (oldModelClassName.equals(SPATOContactsClp.class.getName())) {
			return translateInputSPATOContacts(oldModel);
		}

		if (oldModelClassName.equals(SPOrgContactUsClp.class.getName())) {
			return translateInputSPOrgContactUs(oldModel);
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

	public static Object translateInputAccreditation(BaseModel<?> oldModel) {
		AccreditationClp oldClpModel = (AccreditationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAccreditationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAddress(BaseModel<?> oldModel) {
		AddressClp oldClpModel = (AddressClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputApprovedMentors(BaseModel<?> oldModel) {
		ApprovedMentorsClp oldClpModel = (ApprovedMentorsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getApprovedMentorsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputATODocument(BaseModel<?> oldModel) {
		ATODocumentClp oldClpModel = (ATODocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getATODocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmployeeInfo(BaseModel<?> oldModel) {
		EmployeeInfoClp oldClpModel = (EmployeeInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmployeeInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFundingRound(BaseModel<?> oldModel) {
		FundingRoundClp oldClpModel = (FundingRoundClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFundingRoundRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGuidelines(BaseModel<?> oldModel) {
		GuidelinesClp oldClpModel = (GuidelinesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGuidelinesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganisationRemarks(
		BaseModel<?> oldModel) {
		OrganisationRemarksClp oldClpModel = (OrganisationRemarksClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganisationRemarksRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganization(BaseModel<?> oldModel) {
		OrganizationClp oldClpModel = (OrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPerson(BaseModel<?> oldModel) {
		PersonClp oldClpModel = (PersonClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPersonRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPrinciples(BaseModel<?> oldModel) {
		PrinciplesClp oldClpModel = (PrinciplesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPrinciplesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQuestionnaire(BaseModel<?> oldModel) {
		QuestionnaireClp oldClpModel = (QuestionnaireClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQuestionnaireRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReAccreditation(BaseModel<?> oldModel) {
		ReAccreditationClp oldClpModel = (ReAccreditationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReAccreditationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRelationship(BaseModel<?> oldModel) {
		RelationshipClp oldClpModel = (RelationshipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRelationshipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPATOContacts(BaseModel<?> oldModel) {
		SPATOContactsClp oldClpModel = (SPATOContactsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPATOContactsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPOrgContactUs(BaseModel<?> oldModel) {
		SPOrgContactUsClp oldClpModel = (SPOrgContactUsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPOrgContactUsRemoteModel();

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
					"com.sambaash.platform.srv.startupprofile.model.impl.AccreditationImpl")) {
			return translateOutputAccreditation(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.AddressImpl")) {
			return translateOutputAddress(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl")) {
			return translateOutputApprovedMentors(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentImpl")) {
			return translateOutputATODocument(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoImpl")) {
			return translateOutputEmployeeInfo(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.FundingRoundImpl")) {
			return translateOutputFundingRound(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesImpl")) {
			return translateOutputGuidelines(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksImpl")) {
			return translateOutputOrganisationRemarks(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.OrganizationImpl")) {
			return translateOutputOrganization(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.PersonImpl")) {
			return translateOutputPerson(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesImpl")) {
			return translateOutputPrinciples(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireImpl")) {
			return translateOutputQuestionnaire(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationImpl")) {
			return translateOutputReAccreditation(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.RelationshipImpl")) {
			return translateOutputRelationship(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl")) {
			return translateOutputSPATOContacts(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsImpl")) {
			return translateOutputSPOrgContactUs(oldModel);
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
					"com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchAddressException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchAddressException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchFundingRoundException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchFundingRoundException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchPersonException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchPersonException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException")) {
			return new com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException();
		}

		return throwable;
	}

	public static Object translateOutputAccreditation(BaseModel<?> oldModel) {
		AccreditationClp newModel = new AccreditationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAccreditationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAddress(BaseModel<?> oldModel) {
		AddressClp newModel = new AddressClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputApprovedMentors(BaseModel<?> oldModel) {
		ApprovedMentorsClp newModel = new ApprovedMentorsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setApprovedMentorsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputATODocument(BaseModel<?> oldModel) {
		ATODocumentClp newModel = new ATODocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setATODocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmployeeInfo(BaseModel<?> oldModel) {
		EmployeeInfoClp newModel = new EmployeeInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmployeeInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFundingRound(BaseModel<?> oldModel) {
		FundingRoundClp newModel = new FundingRoundClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFundingRoundRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGuidelines(BaseModel<?> oldModel) {
		GuidelinesClp newModel = new GuidelinesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGuidelinesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganisationRemarks(
		BaseModel<?> oldModel) {
		OrganisationRemarksClp newModel = new OrganisationRemarksClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganisationRemarksRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganization(BaseModel<?> oldModel) {
		OrganizationClp newModel = new OrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPerson(BaseModel<?> oldModel) {
		PersonClp newModel = new PersonClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPersonRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPrinciples(BaseModel<?> oldModel) {
		PrinciplesClp newModel = new PrinciplesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPrinciplesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQuestionnaire(BaseModel<?> oldModel) {
		QuestionnaireClp newModel = new QuestionnaireClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQuestionnaireRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReAccreditation(BaseModel<?> oldModel) {
		ReAccreditationClp newModel = new ReAccreditationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReAccreditationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRelationship(BaseModel<?> oldModel) {
		RelationshipClp newModel = new RelationshipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRelationshipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPATOContacts(BaseModel<?> oldModel) {
		SPATOContactsClp newModel = new SPATOContactsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPATOContactsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPOrgContactUs(BaseModel<?> oldModel) {
		SPOrgContactUsClp newModel = new SPOrgContactUsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPOrgContactUsRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}