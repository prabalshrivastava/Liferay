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

package com.sambaash.platform.srv.spshopping.service;

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

import com.sambaash.platform.srv.spshopping.model.SPCartClp;
import com.sambaash.platform.srv.spshopping.model.SPCartPackageClp;
import com.sambaash.platform.srv.spshopping.model.SPCartPackageItemClp;
import com.sambaash.platform.srv.spshopping.model.SPDiscountClp;
import com.sambaash.platform.srv.spshopping.model.SPPackageItemsClp;
import com.sambaash.platform.srv.spshopping.model.SPSellingItemClp;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackageClp;
import com.sambaash.platform.srv.spshopping.model.SPSellingPriceClp;
import com.sambaash.platform.srv.spshopping.model.SPTaxClp;

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
						"SPShopping-portlet-deployment-context");

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
							"SPShopping-portlet-deployment-context");

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
				_servletContextName = "SPShopping-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SPCartClp.class.getName())) {
			return translateInputSPCart(oldModel);
		}

		if (oldModelClassName.equals(SPCartPackageClp.class.getName())) {
			return translateInputSPCartPackage(oldModel);
		}

		if (oldModelClassName.equals(SPCartPackageItemClp.class.getName())) {
			return translateInputSPCartPackageItem(oldModel);
		}

		if (oldModelClassName.equals(SPDiscountClp.class.getName())) {
			return translateInputSPDiscount(oldModel);
		}

		if (oldModelClassName.equals(SPPackageItemsClp.class.getName())) {
			return translateInputSPPackageItems(oldModel);
		}

		if (oldModelClassName.equals(SPSellingItemClp.class.getName())) {
			return translateInputSPSellingItem(oldModel);
		}

		if (oldModelClassName.equals(SPSellingPackageClp.class.getName())) {
			return translateInputSPSellingPackage(oldModel);
		}

		if (oldModelClassName.equals(SPSellingPriceClp.class.getName())) {
			return translateInputSPSellingPrice(oldModel);
		}

		if (oldModelClassName.equals(SPTaxClp.class.getName())) {
			return translateInputSPTax(oldModel);
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

	public static Object translateInputSPCart(BaseModel<?> oldModel) {
		SPCartClp oldClpModel = (SPCartClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPCartRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPCartPackage(BaseModel<?> oldModel) {
		SPCartPackageClp oldClpModel = (SPCartPackageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPCartPackageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPCartPackageItem(BaseModel<?> oldModel) {
		SPCartPackageItemClp oldClpModel = (SPCartPackageItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPCartPackageItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPDiscount(BaseModel<?> oldModel) {
		SPDiscountClp oldClpModel = (SPDiscountClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPDiscountRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPPackageItems(BaseModel<?> oldModel) {
		SPPackageItemsClp oldClpModel = (SPPackageItemsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPPackageItemsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPSellingItem(BaseModel<?> oldModel) {
		SPSellingItemClp oldClpModel = (SPSellingItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPSellingItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPSellingPackage(BaseModel<?> oldModel) {
		SPSellingPackageClp oldClpModel = (SPSellingPackageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPSellingPackageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPSellingPrice(BaseModel<?> oldModel) {
		SPSellingPriceClp oldClpModel = (SPSellingPriceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPSellingPriceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSPTax(BaseModel<?> oldModel) {
		SPTaxClp oldClpModel = (SPTaxClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSPTaxRemoteModel();

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
					"com.sambaash.platform.srv.spshopping.model.impl.SPCartImpl")) {
			return translateOutputSPCart(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageImpl")) {
			return translateOutputSPCartPackage(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemImpl")) {
			return translateOutputSPCartPackageItem(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPDiscountImpl")) {
			return translateOutputSPDiscount(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsImpl")) {
			return translateOutputSPPackageItems(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemImpl")) {
			return translateOutputSPSellingItem(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageImpl")) {
			return translateOutputSPSellingPackage(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl")) {
			return translateOutputSPSellingPrice(oldModel);
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
					"com.sambaash.platform.srv.spshopping.model.impl.SPTaxImpl")) {
			return translateOutputSPTax(oldModel);
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
					"com.sambaash.platform.srv.spshopping.NoSuchSPCartException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPCartException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spshopping.NoSuchSPTaxException")) {
			return new com.sambaash.platform.srv.spshopping.NoSuchSPTaxException();
		}

		return throwable;
	}

	public static Object translateOutputSPCart(BaseModel<?> oldModel) {
		SPCartClp newModel = new SPCartClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPCartRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPCartPackage(BaseModel<?> oldModel) {
		SPCartPackageClp newModel = new SPCartPackageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPCartPackageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPCartPackageItem(BaseModel<?> oldModel) {
		SPCartPackageItemClp newModel = new SPCartPackageItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPCartPackageItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPDiscount(BaseModel<?> oldModel) {
		SPDiscountClp newModel = new SPDiscountClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPDiscountRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPPackageItems(BaseModel<?> oldModel) {
		SPPackageItemsClp newModel = new SPPackageItemsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPPackageItemsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPSellingItem(BaseModel<?> oldModel) {
		SPSellingItemClp newModel = new SPSellingItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPSellingItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPSellingPackage(BaseModel<?> oldModel) {
		SPSellingPackageClp newModel = new SPSellingPackageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPSellingPackageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPSellingPrice(BaseModel<?> oldModel) {
		SPSellingPriceClp newModel = new SPSellingPriceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPSellingPriceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSPTax(BaseModel<?> oldModel) {
		SPTaxClp newModel = new SPTaxClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSPTaxRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}