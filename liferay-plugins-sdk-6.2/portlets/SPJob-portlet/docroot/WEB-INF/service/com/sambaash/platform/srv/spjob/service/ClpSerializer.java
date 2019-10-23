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

package com.sambaash.platform.srv.spjob.service;

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

import com.sambaash.platform.srv.spjob.model.SPJobApplicantsClp;
import com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolioClp;
import com.sambaash.platform.srv.spjob.model.SPJobClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harini
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
						"SPJob-portlet-deployment-context");

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
							"SPJob-portlet-deployment-context");

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
				_servletContextName = "SPJob-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SPJobClp.class.getName())) {
			return translateInputSPJob(oldModel);
		}

		if (oldModelClassName.equals(SPJobApplicantsClp.class.getName())) {
			return translateInputSPJobApplicants(oldModel);
		}

		if (oldModelClassName.equals(
					SPJobApplicantsPortfolioClp.class.getName())) {
			return translateInputSPJobApplicantsPortfolio(oldModel);
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

	public static Object translateInputSPJob(BaseModel<?> oldModel) {
		SPJobClp oldClpModel = (SPJobClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPJobRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPJobApplicants(BaseModel<?> oldModel) {
		SPJobApplicantsClp oldClpModel = (SPJobApplicantsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPJobApplicantsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPJobApplicantsPortfolio(
		BaseModel<?> oldModel) {
		SPJobApplicantsPortfolioClp oldClpModel = (SPJobApplicantsPortfolioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPJobApplicantsPortfolioRemoteModel();

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
					"com.sambaash.platform.srv.spjob.model.impl.SPJobImpl")) {
			return translateOutputSPJob(oldModel);
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
					"com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsImpl")) {
			return translateOutputSPJobApplicants(oldModel);
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
					"com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioImpl")) {
			return translateOutputSPJobApplicantsPortfolio(oldModel);
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
					"com.sambaash.platform.srv.spjob.SPJobCategoriesException")) {
			return new com.sambaash.platform.srv.spjob.SPJobCategoriesException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobDescriptionException")) {
			return new com.sambaash.platform.srv.spjob.SPJobDescriptionException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobImageNameException")) {
			return new com.sambaash.platform.srv.spjob.SPJobImageNameException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobImageSizeException")) {
			return new com.sambaash.platform.srv.spjob.SPJobImageSizeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobImageTypeException")) {
			return new com.sambaash.platform.srv.spjob.SPJobImageTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobLocationException")) {
			return new com.sambaash.platform.srv.spjob.SPJobLocationException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobNameException")) {
			return new com.sambaash.platform.srv.spjob.SPJobNameException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobTagsException")) {
			return new com.sambaash.platform.srv.spjob.SPJobTagsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.SPJobTypeException")) {
			return new com.sambaash.platform.srv.spjob.SPJobTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.NoSuchSPJobException")) {
			return new com.sambaash.platform.srv.spjob.NoSuchSPJobException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.NoSuchApplicantsException")) {
			return new com.sambaash.platform.srv.spjob.NoSuchApplicantsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException")) {
			return new com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException();
		}

		return throwable;
	}

	public static Object translateOutputSPJob(BaseModel<?> oldModel) {
		SPJobClp newModel = new SPJobClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPJobRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPJobApplicants(BaseModel<?> oldModel) {
		SPJobApplicantsClp newModel = new SPJobApplicantsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPJobApplicantsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPJobApplicantsPortfolio(
		BaseModel<?> oldModel) {
		SPJobApplicantsPortfolioClp newModel = new SPJobApplicantsPortfolioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPJobApplicantsPortfolioRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}