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

package com.sambaash.platform.srv.rsvp.service;

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

import com.sambaash.platform.srv.rsvp.model.RsvpClp;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetailClp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetailClp;
import com.sambaash.platform.srv.rsvp.model.RsvpDiscountClp;
import com.sambaash.platform.srv.rsvp.model.RsvpPaymentClp;
import com.sambaash.platform.srv.rsvp.model.RsvpPromoCodeClp;
import com.sambaash.platform.srv.rsvp.model.RsvpTicketClp;

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
						"SPEvent-portlet-deployment-context");

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
							"SPEvent-portlet-deployment-context");

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
				_servletContextName = "SPEvent-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(RsvpClp.class.getName())) {
			return translateInputRsvp(oldModel);
		}

		if (oldModelClassName.equals(RsvpCoParticipantDetailClp.class.getName())) {
			return translateInputRsvpCoParticipantDetail(oldModel);
		}

		if (oldModelClassName.equals(RsvpDetailClp.class.getName())) {
			return translateInputRsvpDetail(oldModel);
		}

		if (oldModelClassName.equals(RsvpDiscountClp.class.getName())) {
			return translateInputRsvpDiscount(oldModel);
		}

		if (oldModelClassName.equals(RsvpPaymentClp.class.getName())) {
			return translateInputRsvpPayment(oldModel);
		}

		if (oldModelClassName.equals(RsvpPromoCodeClp.class.getName())) {
			return translateInputRsvpPromoCode(oldModel);
		}

		if (oldModelClassName.equals(RsvpTicketClp.class.getName())) {
			return translateInputRsvpTicket(oldModel);
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

	public static Object translateInputRsvp(BaseModel<?> oldModel) {
		RsvpClp oldClpModel = (RsvpClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRsvpCoParticipantDetail(
		BaseModel<?> oldModel) {
		RsvpCoParticipantDetailClp oldClpModel = (RsvpCoParticipantDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpCoParticipantDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRsvpDetail(BaseModel<?> oldModel) {
		RsvpDetailClp oldClpModel = (RsvpDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRsvpDiscount(BaseModel<?> oldModel) {
		RsvpDiscountClp oldClpModel = (RsvpDiscountClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpDiscountRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRsvpPayment(BaseModel<?> oldModel) {
		RsvpPaymentClp oldClpModel = (RsvpPaymentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpPaymentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRsvpPromoCode(BaseModel<?> oldModel) {
		RsvpPromoCodeClp oldClpModel = (RsvpPromoCodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpPromoCodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRsvpTicket(BaseModel<?> oldModel) {
		RsvpTicketClp oldClpModel = (RsvpTicketClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRsvpTicketRemoteModel();

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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpImpl")) {
			return translateOutputRsvp(oldModel);
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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailImpl")) {
			return translateOutputRsvpCoParticipantDetail(oldModel);
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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailImpl")) {
			return translateOutputRsvpDetail(oldModel);
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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountImpl")) {
			return translateOutputRsvpDiscount(oldModel);
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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentImpl")) {
			return translateOutputRsvpPayment(oldModel);
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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeImpl")) {
			return translateOutputRsvpPromoCode(oldModel);
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
					"com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketImpl")) {
			return translateOutputRsvpTicket(oldModel);
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
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException")) {
			return new com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException();
		}

		return throwable;
	}

	public static Object translateOutputRsvp(BaseModel<?> oldModel) {
		RsvpClp newModel = new RsvpClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRsvpCoParticipantDetail(
		BaseModel<?> oldModel) {
		RsvpCoParticipantDetailClp newModel = new RsvpCoParticipantDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpCoParticipantDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRsvpDetail(BaseModel<?> oldModel) {
		RsvpDetailClp newModel = new RsvpDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRsvpDiscount(BaseModel<?> oldModel) {
		RsvpDiscountClp newModel = new RsvpDiscountClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpDiscountRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRsvpPayment(BaseModel<?> oldModel) {
		RsvpPaymentClp newModel = new RsvpPaymentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpPaymentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRsvpPromoCode(BaseModel<?> oldModel) {
		RsvpPromoCodeClp newModel = new RsvpPromoCodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpPromoCodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRsvpTicket(BaseModel<?> oldModel) {
		RsvpTicketClp newModel = new RsvpTicketClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRsvpTicketRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}