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

package com.sambaash.platform.srv.processbuilder.service;

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

import com.sambaash.platform.srv.processbuilder.model.PECustomActionInfoClp;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntityClp;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAuditClp;
import com.sambaash.platform.srv.processbuilder.model.PEProcessClp;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStageClp;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStateClp;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusTypeClp;
import com.sambaash.platform.srv.processbuilder.model.PERuleClp;
import com.sambaash.platform.srv.processbuilder.model.PERuleSetClp;
import com.sambaash.platform.srv.processbuilder.model.PESupervisorClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nareshchebolu
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
						"SPProcessEngine-portlet-deployment-context");

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
							"SPProcessEngine-portlet-deployment-context");

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
				_servletContextName = "SPProcessEngine-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(PECustomActionInfoClp.class.getName())) {
			return translateInputPECustomActionInfo(oldModel);
		}

		if (oldModelClassName.equals(PEDummyEntityClp.class.getName())) {
			return translateInputPEDummyEntity(oldModel);
		}

		if (oldModelClassName.equals(PEProcessClp.class.getName())) {
			return translateInputPEProcess(oldModel);
		}

		if (oldModelClassName.equals(PEProcessAuditClp.class.getName())) {
			return translateInputPEProcessAudit(oldModel);
		}

		if (oldModelClassName.equals(PEProcessStageClp.class.getName())) {
			return translateInputPEProcessStage(oldModel);
		}

		if (oldModelClassName.equals(PEProcessStateClp.class.getName())) {
			return translateInputPEProcessState(oldModel);
		}

		if (oldModelClassName.equals(PEProcessStatusTypeClp.class.getName())) {
			return translateInputPEProcessStatusType(oldModel);
		}

		if (oldModelClassName.equals(PERuleClp.class.getName())) {
			return translateInputPERule(oldModel);
		}

		if (oldModelClassName.equals(PERuleSetClp.class.getName())) {
			return translateInputPERuleSet(oldModel);
		}

		if (oldModelClassName.equals(PESupervisorClp.class.getName())) {
			return translateInputPESupervisor(oldModel);
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

	public static Object translateInputPECustomActionInfo(BaseModel<?> oldModel) {
		PECustomActionInfoClp oldClpModel = (PECustomActionInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPECustomActionInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPEDummyEntity(BaseModel<?> oldModel) {
		PEDummyEntityClp oldClpModel = (PEDummyEntityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPEDummyEntityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPEProcess(BaseModel<?> oldModel) {
		PEProcessClp oldClpModel = (PEProcessClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPEProcessRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPEProcessAudit(BaseModel<?> oldModel) {
		PEProcessAuditClp oldClpModel = (PEProcessAuditClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPEProcessAuditRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPEProcessStage(BaseModel<?> oldModel) {
		PEProcessStageClp oldClpModel = (PEProcessStageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPEProcessStageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPEProcessState(BaseModel<?> oldModel) {
		PEProcessStateClp oldClpModel = (PEProcessStateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPEProcessStateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPEProcessStatusType(
		BaseModel<?> oldModel) {
		PEProcessStatusTypeClp oldClpModel = (PEProcessStatusTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPEProcessStatusTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPERule(BaseModel<?> oldModel) {
		PERuleClp oldClpModel = (PERuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPERuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPERuleSet(BaseModel<?> oldModel) {
		PERuleSetClp oldClpModel = (PERuleSetClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPERuleSetRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPESupervisor(BaseModel<?> oldModel) {
		PESupervisorClp oldClpModel = (PESupervisorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPESupervisorRemoteModel();

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
					"com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionInfoImpl")) {
			return translateOutputPECustomActionInfo(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityImpl")) {
			return translateOutputPEDummyEntity(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PEProcessImpl")) {
			return translateOutputPEProcess(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditImpl")) {
			return translateOutputPEProcessAudit(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageImpl")) {
			return translateOutputPEProcessStage(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateImpl")) {
			return translateOutputPEProcessState(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeImpl")) {
			return translateOutputPEProcessStatusType(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PERuleImpl")) {
			return translateOutputPERule(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetImpl")) {
			return translateOutputPERuleSet(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorImpl")) {
			return translateOutputPESupervisor(oldModel);
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
					"com.sambaash.platform.srv.processbuilder.PERuleException")) {
			return new com.sambaash.platform.srv.processbuilder.PERuleException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.PERuleSetException")) {
			return new com.sambaash.platform.srv.processbuilder.PERuleSetException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionInfoException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionInfoException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPERuleException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPERuleException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException")) {
			return new com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException();
		}

		return throwable;
	}

	public static Object translateOutputPECustomActionInfo(
		BaseModel<?> oldModel) {
		PECustomActionInfoClp newModel = new PECustomActionInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPECustomActionInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPEDummyEntity(BaseModel<?> oldModel) {
		PEDummyEntityClp newModel = new PEDummyEntityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPEDummyEntityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPEProcess(BaseModel<?> oldModel) {
		PEProcessClp newModel = new PEProcessClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPEProcessRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPEProcessAudit(BaseModel<?> oldModel) {
		PEProcessAuditClp newModel = new PEProcessAuditClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPEProcessAuditRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPEProcessStage(BaseModel<?> oldModel) {
		PEProcessStageClp newModel = new PEProcessStageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPEProcessStageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPEProcessState(BaseModel<?> oldModel) {
		PEProcessStateClp newModel = new PEProcessStateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPEProcessStateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPEProcessStatusType(
		BaseModel<?> oldModel) {
		PEProcessStatusTypeClp newModel = new PEProcessStatusTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPEProcessStatusTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPERule(BaseModel<?> oldModel) {
		PERuleClp newModel = new PERuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPERuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPERuleSet(BaseModel<?> oldModel) {
		PERuleSetClp newModel = new PERuleSetClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPERuleSetRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPESupervisor(BaseModel<?> oldModel) {
		PESupervisorClp newModel = new PESupervisorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPESupervisorRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}