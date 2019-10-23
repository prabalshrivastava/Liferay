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

package com.sambaash.platform.srv.spsocialprofile.service;

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

import com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUserClp;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileClp;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetailClp;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriendsClp;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLikeClp;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAuditClp;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAuditClp;
import com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendarClp;

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
						"UserProfile-portlet-deployment-context");

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
							"UserProfile-portlet-deployment-context");

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
				_servletContextName = "UserProfile-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ExamBodyUserClp.class.getName())) {
			return translateInputExamBodyUser(oldModel);
		}

		if (oldModelClassName.equals(SocialProfileClp.class.getName())) {
			return translateInputSocialProfile(oldModel);
		}

		if (oldModelClassName.equals(SocialProfileDetailClp.class.getName())) {
			return translateInputSocialProfileDetail(oldModel);
		}

		if (oldModelClassName.equals(SocialProfileFriendsClp.class.getName())) {
			return translateInputSocialProfileFriends(oldModel);
		}

		if (oldModelClassName.equals(SocialProfileLikeClp.class.getName())) {
			return translateInputSocialProfileLike(oldModel);
		}

		if (oldModelClassName.equals(SocialProfilePullAuditClp.class.getName())) {
			return translateInputSocialProfilePullAudit(oldModel);
		}

		if (oldModelClassName.equals(SocialProfileViewAuditClp.class.getName())) {
			return translateInputSocialProfileViewAudit(oldModel);
		}

		if (oldModelClassName.equals(
					UserAvailabilityCalendarClp.class.getName())) {
			return translateInputUserAvailabilityCalendar(oldModel);
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

	public static Object translateInputExamBodyUser(BaseModel<?> oldModel) {
		ExamBodyUserClp oldClpModel = (ExamBodyUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getExamBodyUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialProfile(BaseModel<?> oldModel) {
		SocialProfileClp oldClpModel = (SocialProfileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialProfileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialProfileDetail(
		BaseModel<?> oldModel) {
		SocialProfileDetailClp oldClpModel = (SocialProfileDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialProfileDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialProfileFriends(
		BaseModel<?> oldModel) {
		SocialProfileFriendsClp oldClpModel = (SocialProfileFriendsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialProfileFriendsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialProfileLike(BaseModel<?> oldModel) {
		SocialProfileLikeClp oldClpModel = (SocialProfileLikeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialProfileLikeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialProfilePullAudit(
		BaseModel<?> oldModel) {
		SocialProfilePullAuditClp oldClpModel = (SocialProfilePullAuditClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialProfilePullAuditRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialProfileViewAudit(
		BaseModel<?> oldModel) {
		SocialProfileViewAuditClp oldClpModel = (SocialProfileViewAuditClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialProfileViewAuditRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserAvailabilityCalendar(
		BaseModel<?> oldModel) {
		UserAvailabilityCalendarClp oldClpModel = (UserAvailabilityCalendarClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserAvailabilityCalendarRemoteModel();

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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserImpl")) {
			return translateOutputExamBodyUser(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileImpl")) {
			return translateOutputSocialProfile(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailImpl")) {
			return translateOutputSocialProfileDetail(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsImpl")) {
			return translateOutputSocialProfileFriends(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeImpl")) {
			return translateOutputSocialProfileLike(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditImpl")) {
			return translateOutputSocialProfilePullAudit(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditImpl")) {
			return translateOutputSocialProfileViewAudit(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarImpl")) {
			return translateOutputUserAvailabilityCalendar(oldModel);
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
					"com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException")) {
			return new com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException();
		}

		return throwable;
	}

	public static Object translateOutputExamBodyUser(BaseModel<?> oldModel) {
		ExamBodyUserClp newModel = new ExamBodyUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExamBodyUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialProfile(BaseModel<?> oldModel) {
		SocialProfileClp newModel = new SocialProfileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialProfileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialProfileDetail(
		BaseModel<?> oldModel) {
		SocialProfileDetailClp newModel = new SocialProfileDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialProfileDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialProfileFriends(
		BaseModel<?> oldModel) {
		SocialProfileFriendsClp newModel = new SocialProfileFriendsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialProfileFriendsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialProfileLike(BaseModel<?> oldModel) {
		SocialProfileLikeClp newModel = new SocialProfileLikeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialProfileLikeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialProfilePullAudit(
		BaseModel<?> oldModel) {
		SocialProfilePullAuditClp newModel = new SocialProfilePullAuditClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialProfilePullAuditRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialProfileViewAudit(
		BaseModel<?> oldModel) {
		SocialProfileViewAuditClp newModel = new SocialProfileViewAuditClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialProfileViewAuditRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserAvailabilityCalendar(
		BaseModel<?> oldModel) {
		UserAvailabilityCalendarClp newModel = new UserAvailabilityCalendarClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserAvailabilityCalendarRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}