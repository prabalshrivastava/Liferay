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

package com.sambaash.platform.srv.mail.service;

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

import com.sambaash.platform.srv.mail.model.SPEMailAuditClp;
import com.sambaash.platform.srv.mail.model.SPMailBlackListClp;
import com.sambaash.platform.srv.mail.model.SPMailCampaignClp;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDMClp;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribersClp;
import com.sambaash.platform.srv.mail.model.SPMailLinkTrackingClp;
import com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgentClp;
import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachmentClp;
import com.sambaash.platform.srv.mail.model.SPMailTemplateClp;
import com.sambaash.platform.srv.mail.model.SPMailUnsubscribeClp;

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
						"SPMail-portlet-deployment-context");

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
							"SPMail-portlet-deployment-context");

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
				_servletContextName = "SPMail-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SPEMailAuditClp.class.getName())) {
			return translateInputSPEMailAudit(oldModel);
		}

		if (oldModelClassName.equals(SPMailBlackListClp.class.getName())) {
			return translateInputSPMailBlackList(oldModel);
		}

		if (oldModelClassName.equals(SPMailCampaignClp.class.getName())) {
			return translateInputSPMailCampaign(oldModel);
		}

		if (oldModelClassName.equals(SPMailCampaignEDMClp.class.getName())) {
			return translateInputSPMailCampaignEDM(oldModel);
		}

		if (oldModelClassName.equals(
					SPMailCampaignSubscribersClp.class.getName())) {
			return translateInputSPMailCampaignSubscribers(oldModel);
		}

		if (oldModelClassName.equals(SPMailLinkTrackingClp.class.getName())) {
			return translateInputSPMailLinkTracking(oldModel);
		}

		if (oldModelClassName.equals(
					SPMailSubscriberUserAgentClp.class.getName())) {
			return translateInputSPMailSubscriberUserAgent(oldModel);
		}

		if (oldModelClassName.equals(SPMailTemplateClp.class.getName())) {
			return translateInputSPMailTemplate(oldModel);
		}

		if (oldModelClassName.equals(
					SPMailTemplateAttachmentClp.class.getName())) {
			return translateInputSPMailTemplateAttachment(oldModel);
		}

		if (oldModelClassName.equals(SPMailUnsubscribeClp.class.getName())) {
			return translateInputSPMailUnsubscribe(oldModel);
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

	public static Object translateInputSPEMailAudit(BaseModel<?> oldModel) {
		SPEMailAuditClp oldClpModel = (SPEMailAuditClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPEMailAuditRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailBlackList(BaseModel<?> oldModel) {
		SPMailBlackListClp oldClpModel = (SPMailBlackListClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailBlackListRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailCampaign(BaseModel<?> oldModel) {
		SPMailCampaignClp oldClpModel = (SPMailCampaignClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailCampaignRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailCampaignEDM(BaseModel<?> oldModel) {
		SPMailCampaignEDMClp oldClpModel = (SPMailCampaignEDMClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailCampaignEDMRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailCampaignSubscribers(
		BaseModel<?> oldModel) {
		SPMailCampaignSubscribersClp oldClpModel = (SPMailCampaignSubscribersClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailCampaignSubscribersRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailLinkTracking(BaseModel<?> oldModel) {
		SPMailLinkTrackingClp oldClpModel = (SPMailLinkTrackingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailLinkTrackingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailSubscriberUserAgent(
		BaseModel<?> oldModel) {
		SPMailSubscriberUserAgentClp oldClpModel = (SPMailSubscriberUserAgentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailSubscriberUserAgentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailTemplate(BaseModel<?> oldModel) {
		SPMailTemplateClp oldClpModel = (SPMailTemplateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailTemplateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailTemplateAttachment(
		BaseModel<?> oldModel) {
		SPMailTemplateAttachmentClp oldClpModel = (SPMailTemplateAttachmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailTemplateAttachmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPMailUnsubscribe(BaseModel<?> oldModel) {
		SPMailUnsubscribeClp oldClpModel = (SPMailUnsubscribeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPMailUnsubscribeRemoteModel();

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
					"com.sambaash.platform.srv.mail.model.impl.SPEMailAuditImpl")) {
			return translateOutputSPEMailAudit(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailBlackListImpl")) {
			return translateOutputSPMailBlackList(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailCampaignImpl")) {
			return translateOutputSPMailCampaign(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMImpl")) {
			return translateOutputSPMailCampaignEDM(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersImpl")) {
			return translateOutputSPMailCampaignSubscribers(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingImpl")) {
			return translateOutputSPMailLinkTracking(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentImpl")) {
			return translateOutputSPMailSubscriberUserAgent(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailTemplateImpl")) {
			return translateOutputSPMailTemplate(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentImpl")) {
			return translateOutputSPMailTemplateAttachment(oldModel);
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
					"com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeImpl")) {
			return translateOutputSPMailUnsubscribe(oldModel);
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
					"com.sambaash.platform.srv.mail.SPMailCampaignSubscribersEmailException")) {
			return new com.sambaash.platform.srv.mail.SPMailCampaignSubscribersEmailException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.SPMailCampaignSubscribersFirstNameException")) {
			return new com.sambaash.platform.srv.mail.SPMailCampaignSubscribersFirstNameException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.SPMailCampaignSubscribersLastNameException")) {
			return new com.sambaash.platform.srv.mail.SPMailCampaignSubscribersLastNameException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException")) {
			return new com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchBlackListException")) {
			return new com.sambaash.platform.srv.mail.NoSuchBlackListException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchCampaignException")) {
			return new com.sambaash.platform.srv.mail.NoSuchCampaignException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchCampaignEDMException")) {
			return new com.sambaash.platform.srv.mail.NoSuchCampaignEDMException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException")) {
			return new com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchLinkTrackingException")) {
			return new com.sambaash.platform.srv.mail.NoSuchLinkTrackingException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException")) {
			return new com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchTemplateException")) {
			return new com.sambaash.platform.srv.mail.NoSuchTemplateException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException")) {
			return new com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.mail.NoSuchUnsubscribeException")) {
			return new com.sambaash.platform.srv.mail.NoSuchUnsubscribeException();
		}

		return throwable;
	}

	public static Object translateOutputSPEMailAudit(BaseModel<?> oldModel) {
		SPEMailAuditClp newModel = new SPEMailAuditClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPEMailAuditRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailBlackList(BaseModel<?> oldModel) {
		SPMailBlackListClp newModel = new SPMailBlackListClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailBlackListRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailCampaign(BaseModel<?> oldModel) {
		SPMailCampaignClp newModel = new SPMailCampaignClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailCampaignRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailCampaignEDM(BaseModel<?> oldModel) {
		SPMailCampaignEDMClp newModel = new SPMailCampaignEDMClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailCampaignEDMRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailCampaignSubscribers(
		BaseModel<?> oldModel) {
		SPMailCampaignSubscribersClp newModel = new SPMailCampaignSubscribersClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailCampaignSubscribersRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailLinkTracking(
		BaseModel<?> oldModel) {
		SPMailLinkTrackingClp newModel = new SPMailLinkTrackingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailLinkTrackingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailSubscriberUserAgent(
		BaseModel<?> oldModel) {
		SPMailSubscriberUserAgentClp newModel = new SPMailSubscriberUserAgentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailSubscriberUserAgentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailTemplate(BaseModel<?> oldModel) {
		SPMailTemplateClp newModel = new SPMailTemplateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailTemplateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailTemplateAttachment(
		BaseModel<?> oldModel) {
		SPMailTemplateAttachmentClp newModel = new SPMailTemplateAttachmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailTemplateAttachmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPMailUnsubscribe(BaseModel<?> oldModel) {
		SPMailUnsubscribeClp newModel = new SPMailUnsubscribeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPMailUnsubscribeRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}