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

package com.liferay.saml.service;

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

import com.liferay.saml.model.SamlIdpSpConnectionClp;
import com.liferay.saml.model.SamlIdpSpSessionClp;
import com.liferay.saml.model.SamlIdpSsoSessionClp;
import com.liferay.saml.model.SamlSpAuthRequestClp;
import com.liferay.saml.model.SamlSpIdpConnectionClp;
import com.liferay.saml.model.SamlSpMessageClp;
import com.liferay.saml.model.SamlSpSessionClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mika Koivisto, W. Berks
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
						"saml-portlet-deployment-context");

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
							"saml-portlet-deployment-context");

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
				_servletContextName = "saml-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SamlIdpSpConnectionClp.class.getName())) {
			return translateInputSamlIdpSpConnection(oldModel);
		}

		if (oldModelClassName.equals(SamlIdpSpSessionClp.class.getName())) {
			return translateInputSamlIdpSpSession(oldModel);
		}

		if (oldModelClassName.equals(SamlIdpSsoSessionClp.class.getName())) {
			return translateInputSamlIdpSsoSession(oldModel);
		}

		if (oldModelClassName.equals(SamlSpAuthRequestClp.class.getName())) {
			return translateInputSamlSpAuthRequest(oldModel);
		}

		if (oldModelClassName.equals(SamlSpIdpConnectionClp.class.getName())) {
			return translateInputSamlSpIdpConnection(oldModel);
		}

		if (oldModelClassName.equals(SamlSpMessageClp.class.getName())) {
			return translateInputSamlSpMessage(oldModel);
		}

		if (oldModelClassName.equals(SamlSpSessionClp.class.getName())) {
			return translateInputSamlSpSession(oldModel);
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

	public static Object translateInputSamlIdpSpConnection(
		BaseModel<?> oldModel) {
		SamlIdpSpConnectionClp oldClpModel = (SamlIdpSpConnectionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlIdpSpConnectionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSamlIdpSpSession(BaseModel<?> oldModel) {
		SamlIdpSpSessionClp oldClpModel = (SamlIdpSpSessionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlIdpSpSessionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSamlIdpSsoSession(BaseModel<?> oldModel) {
		SamlIdpSsoSessionClp oldClpModel = (SamlIdpSsoSessionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlIdpSsoSessionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSamlSpAuthRequest(BaseModel<?> oldModel) {
		SamlSpAuthRequestClp oldClpModel = (SamlSpAuthRequestClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlSpAuthRequestRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSamlSpIdpConnection(
		BaseModel<?> oldModel) {
		SamlSpIdpConnectionClp oldClpModel = (SamlSpIdpConnectionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlSpIdpConnectionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSamlSpMessage(BaseModel<?> oldModel) {
		SamlSpMessageClp oldClpModel = (SamlSpMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlSpMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSamlSpSession(BaseModel<?> oldModel) {
		SamlSpSessionClp oldClpModel = (SamlSpSessionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSamlSpSessionRemoteModel();

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
					"com.liferay.saml.model.impl.SamlIdpSpConnectionImpl")) {
			return translateOutputSamlIdpSpConnection(oldModel);
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
					"com.liferay.saml.model.impl.SamlIdpSpSessionImpl")) {
			return translateOutputSamlIdpSpSession(oldModel);
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
					"com.liferay.saml.model.impl.SamlIdpSsoSessionImpl")) {
			return translateOutputSamlIdpSsoSession(oldModel);
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
					"com.liferay.saml.model.impl.SamlSpAuthRequestImpl")) {
			return translateOutputSamlSpAuthRequest(oldModel);
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
					"com.liferay.saml.model.impl.SamlSpIdpConnectionImpl")) {
			return translateOutputSamlSpIdpConnection(oldModel);
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
					"com.liferay.saml.model.impl.SamlSpMessageImpl")) {
			return translateOutputSamlSpMessage(oldModel);
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
					"com.liferay.saml.model.impl.SamlSpSessionImpl")) {
			return translateOutputSamlSpSession(oldModel);
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

		if (className.equals("com.liferay.saml.AssertionException")) {
			return new com.liferay.saml.AssertionException();
		}

		if (className.equals("com.liferay.saml.AudienceException")) {
			return new com.liferay.saml.AudienceException();
		}

		if (className.equals("com.liferay.saml.CertificateKeyPasswordException")) {
			return new com.liferay.saml.CertificateKeyPasswordException();
		}

		if (className.equals("com.liferay.saml.CredentialException")) {
			return new com.liferay.saml.CredentialException();
		}

		if (className.equals("com.liferay.saml.DestinationException")) {
			return new com.liferay.saml.DestinationException();
		}

		if (className.equals(
					"com.liferay.saml.DuplicateSamlIdpSpConnectionSamlSpEntityIdException")) {
			return new com.liferay.saml.DuplicateSamlIdpSpConnectionSamlSpEntityIdException();
		}

		if (className.equals(
					"com.liferay.saml.DuplicateSamlIdpSpSessionException")) {
			return new com.liferay.saml.DuplicateSamlIdpSpSessionException();
		}

		if (className.equals(
					"com.liferay.saml.DuplicateSamlIdpSsoSessionException")) {
			return new com.liferay.saml.DuplicateSamlIdpSsoSessionException();
		}

		if (className.equals(
					"com.liferay.saml.DuplicateSamlSpIdpConnectionSamlIdpEntityIdException")) {
			return new com.liferay.saml.DuplicateSamlSpIdpConnectionSamlIdpEntityIdException();
		}

		if (className.equals("com.liferay.saml.EntityIdException")) {
			return new com.liferay.saml.EntityIdException();
		}

		if (className.equals("com.liferay.saml.ExpiredException")) {
			return new com.liferay.saml.ExpiredException();
		}

		if (className.equals("com.liferay.saml.InResponseToException")) {
			return new com.liferay.saml.InResponseToException();
		}

		if (className.equals("com.liferay.saml.IssuerException")) {
			return new com.liferay.saml.IssuerException();
		}

		if (className.equals("com.liferay.saml.ReplayException")) {
			return new com.liferay.saml.ReplayException();
		}

		if (className.equals(
					"com.liferay.saml.SamlIdpSpConnectionMetadataUrlException")) {
			return new com.liferay.saml.SamlIdpSpConnectionMetadataUrlException();
		}

		if (className.equals(
					"com.liferay.saml.SamlIdpSpConnectionMetadataXmlException")) {
			return new com.liferay.saml.SamlIdpSpConnectionMetadataXmlException();
		}

		if (className.equals(
					"com.liferay.saml.SamlIdpSpConnectionNameException")) {
			return new com.liferay.saml.SamlIdpSpConnectionNameException();
		}

		if (className.equals(
					"com.liferay.saml.SamlIdpSpConnectionSamlSpEntityIdException")) {
			return new com.liferay.saml.SamlIdpSpConnectionSamlSpEntityIdException();
		}

		if (className.equals(
					"com.liferay.saml.SamlSpIdpConnectionMetadataUrlException")) {
			return new com.liferay.saml.SamlSpIdpConnectionMetadataUrlException();
		}

		if (className.equals(
					"com.liferay.saml.SamlSpIdpConnectionMetadataXmlException")) {
			return new com.liferay.saml.SamlSpIdpConnectionMetadataXmlException();
		}

		if (className.equals(
					"com.liferay.saml.SamlSpIdpConnectionNameException")) {
			return new com.liferay.saml.SamlSpIdpConnectionNameException();
		}

		if (className.equals(
					"com.liferay.saml.SamlSpIdpConnectionSamlIdpEntityIdException")) {
			return new com.liferay.saml.SamlSpIdpConnectionSamlIdpEntityIdException();
		}

		if (className.equals("com.liferay.saml.SignatureException")) {
			return new com.liferay.saml.SignatureException();
		}

		if (className.equals("com.liferay.saml.StatusException")) {
			return new com.liferay.saml.StatusException();
		}

		if (className.equals("com.liferay.saml.SubjectException")) {
			return new com.liferay.saml.SubjectException();
		}

		if (className.equals(
					"com.liferay.saml.UnsolicitedLogoutResponseException")) {
			return new com.liferay.saml.UnsolicitedLogoutResponseException();
		}

		if (className.equals("com.liferay.saml.UnsupportedBindingException")) {
			return new com.liferay.saml.UnsupportedBindingException();
		}

		if (className.equals("com.liferay.saml.NoSuchIdpSpConnectionException")) {
			return new com.liferay.saml.NoSuchIdpSpConnectionException();
		}

		if (className.equals("com.liferay.saml.NoSuchIdpSpSessionException")) {
			return new com.liferay.saml.NoSuchIdpSpSessionException();
		}

		if (className.equals("com.liferay.saml.NoSuchIdpSsoSessionException")) {
			return new com.liferay.saml.NoSuchIdpSsoSessionException();
		}

		if (className.equals("com.liferay.saml.NoSuchSpAuthRequestException")) {
			return new com.liferay.saml.NoSuchSpAuthRequestException();
		}

		if (className.equals("com.liferay.saml.NoSuchSpIdpConnectionException")) {
			return new com.liferay.saml.NoSuchSpIdpConnectionException();
		}

		if (className.equals("com.liferay.saml.NoSuchSpMessageException")) {
			return new com.liferay.saml.NoSuchSpMessageException();
		}

		if (className.equals("com.liferay.saml.NoSuchSpSessionException")) {
			return new com.liferay.saml.NoSuchSpSessionException();
		}

		return throwable;
	}

	public static Object translateOutputSamlIdpSpConnection(
		BaseModel<?> oldModel) {
		SamlIdpSpConnectionClp newModel = new SamlIdpSpConnectionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlIdpSpConnectionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSamlIdpSpSession(BaseModel<?> oldModel) {
		SamlIdpSpSessionClp newModel = new SamlIdpSpSessionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlIdpSpSessionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSamlIdpSsoSession(BaseModel<?> oldModel) {
		SamlIdpSsoSessionClp newModel = new SamlIdpSsoSessionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlIdpSsoSessionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSamlSpAuthRequest(BaseModel<?> oldModel) {
		SamlSpAuthRequestClp newModel = new SamlSpAuthRequestClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlSpAuthRequestRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSamlSpIdpConnection(
		BaseModel<?> oldModel) {
		SamlSpIdpConnectionClp newModel = new SamlSpIdpConnectionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlSpIdpConnectionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSamlSpMessage(BaseModel<?> oldModel) {
		SamlSpMessageClp newModel = new SamlSpMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlSpMessageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSamlSpSession(BaseModel<?> oldModel) {
		SamlSpSessionClp newModel = new SamlSpSessionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSamlSpSessionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}