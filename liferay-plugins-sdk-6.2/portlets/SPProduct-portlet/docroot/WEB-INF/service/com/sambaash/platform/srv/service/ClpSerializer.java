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

package com.sambaash.platform.srv.service;

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

import com.sambaash.platform.srv.model.ActivityClp;
import com.sambaash.platform.srv.model.AssessmentClp;
import com.sambaash.platform.srv.model.CertificateClp;
import com.sambaash.platform.srv.model.CompetencyUnitClp;
import com.sambaash.platform.srv.model.CourseCareerClp;
import com.sambaash.platform.srv.model.CourseCertificateClp;
import com.sambaash.platform.srv.model.CourseClp;
import com.sambaash.platform.srv.model.CourseDurationClp;
import com.sambaash.platform.srv.model.CourseDurationTypeClp;
import com.sambaash.platform.srv.model.CourseEnrollContractClp;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfoClp;
import com.sambaash.platform.srv.model.CourseLearningClp;
import com.sambaash.platform.srv.model.CourseModuleClp;
import com.sambaash.platform.srv.model.CourseOutcomeClp;
import com.sambaash.platform.srv.model.FeeDetailsClp;
import com.sambaash.platform.srv.model.FeeTypeClp;
import com.sambaash.platform.srv.model.FrameworkClp;
import com.sambaash.platform.srv.model.FundingClp;
import com.sambaash.platform.srv.model.GraduationCriteriaClp;
import com.sambaash.platform.srv.model.MiscellaneousFeesClp;
import com.sambaash.platform.srv.model.ModuleCertificateClp;
import com.sambaash.platform.srv.model.ModuleClp;
import com.sambaash.platform.srv.model.ModuleCompetencyUnitClp;
import com.sambaash.platform.srv.model.ModuleFrameworkClp;
import com.sambaash.platform.srv.model.OutcomeClp;
import com.sambaash.platform.srv.model.OutlineClp;
import com.sambaash.platform.srv.model.PersonaAttendeeClp;
import com.sambaash.platform.srv.model.PersonaClp;
import com.sambaash.platform.srv.model.ProductClp;
import com.sambaash.platform.srv.model.ProductCourseClp;
import com.sambaash.platform.srv.model.ProductSupervisorClp;
import com.sambaash.platform.srv.model.ProgressionPathClp;
import com.sambaash.platform.srv.model.ScheduleClp;
import com.sambaash.platform.srv.model.StudentCourseFeeClp;
import com.sambaash.platform.srv.model.StudentCourseFeeInstmntClp;
import com.sambaash.platform.srv.model.StudyOptionClp;

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
						"SPProduct-portlet-deployment-context");

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
							"SPProduct-portlet-deployment-context");

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
				_servletContextName = "SPProduct-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ActivityClp.class.getName())) {
			return translateInputActivity(oldModel);
		}

		if (oldModelClassName.equals(AssessmentClp.class.getName())) {
			return translateInputAssessment(oldModel);
		}

		if (oldModelClassName.equals(CertificateClp.class.getName())) {
			return translateInputCertificate(oldModel);
		}

		if (oldModelClassName.equals(CompetencyUnitClp.class.getName())) {
			return translateInputCompetencyUnit(oldModel);
		}

		if (oldModelClassName.equals(CourseClp.class.getName())) {
			return translateInputCourse(oldModel);
		}

		if (oldModelClassName.equals(CourseCareerClp.class.getName())) {
			return translateInputCourseCareer(oldModel);
		}

		if (oldModelClassName.equals(CourseCertificateClp.class.getName())) {
			return translateInputCourseCertificate(oldModel);
		}

		if (oldModelClassName.equals(CourseDurationClp.class.getName())) {
			return translateInputCourseDuration(oldModel);
		}

		if (oldModelClassName.equals(CourseDurationTypeClp.class.getName())) {
			return translateInputCourseDurationType(oldModel);
		}

		if (oldModelClassName.equals(CourseEnrollContractClp.class.getName())) {
			return translateInputCourseEnrollContract(oldModel);
		}

		if (oldModelClassName.equals(CourseEnrollEsignInfoClp.class.getName())) {
			return translateInputCourseEnrollEsignInfo(oldModel);
		}

		if (oldModelClassName.equals(CourseLearningClp.class.getName())) {
			return translateInputCourseLearning(oldModel);
		}

		if (oldModelClassName.equals(CourseModuleClp.class.getName())) {
			return translateInputCourseModule(oldModel);
		}

		if (oldModelClassName.equals(CourseOutcomeClp.class.getName())) {
			return translateInputCourseOutcome(oldModel);
		}

		if (oldModelClassName.equals(FeeDetailsClp.class.getName())) {
			return translateInputFeeDetails(oldModel);
		}

		if (oldModelClassName.equals(FeeTypeClp.class.getName())) {
			return translateInputFeeType(oldModel);
		}

		if (oldModelClassName.equals(FrameworkClp.class.getName())) {
			return translateInputFramework(oldModel);
		}

		if (oldModelClassName.equals(FundingClp.class.getName())) {
			return translateInputFunding(oldModel);
		}

		if (oldModelClassName.equals(GraduationCriteriaClp.class.getName())) {
			return translateInputGraduationCriteria(oldModel);
		}

		if (oldModelClassName.equals(MiscellaneousFeesClp.class.getName())) {
			return translateInputMiscellaneousFees(oldModel);
		}

		if (oldModelClassName.equals(ModuleClp.class.getName())) {
			return translateInputModule(oldModel);
		}

		if (oldModelClassName.equals(ModuleCertificateClp.class.getName())) {
			return translateInputModuleCertificate(oldModel);
		}

		if (oldModelClassName.equals(ModuleCompetencyUnitClp.class.getName())) {
			return translateInputModuleCompetencyUnit(oldModel);
		}

		if (oldModelClassName.equals(ModuleFrameworkClp.class.getName())) {
			return translateInputModuleFramework(oldModel);
		}

		if (oldModelClassName.equals(OutcomeClp.class.getName())) {
			return translateInputOutcome(oldModel);
		}

		if (oldModelClassName.equals(OutlineClp.class.getName())) {
			return translateInputOutline(oldModel);
		}

		if (oldModelClassName.equals(PersonaClp.class.getName())) {
			return translateInputPersona(oldModel);
		}

		if (oldModelClassName.equals(PersonaAttendeeClp.class.getName())) {
			return translateInputPersonaAttendee(oldModel);
		}

		if (oldModelClassName.equals(ProductClp.class.getName())) {
			return translateInputProduct(oldModel);
		}

		if (oldModelClassName.equals(ProductCourseClp.class.getName())) {
			return translateInputProductCourse(oldModel);
		}

		if (oldModelClassName.equals(ProductSupervisorClp.class.getName())) {
			return translateInputProductSupervisor(oldModel);
		}

		if (oldModelClassName.equals(ProgressionPathClp.class.getName())) {
			return translateInputProgressionPath(oldModel);
		}

		if (oldModelClassName.equals(ScheduleClp.class.getName())) {
			return translateInputSchedule(oldModel);
		}

		if (oldModelClassName.equals(StudentCourseFeeClp.class.getName())) {
			return translateInputStudentCourseFee(oldModel);
		}

		if (oldModelClassName.equals(StudentCourseFeeInstmntClp.class.getName())) {
			return translateInputStudentCourseFeeInstmnt(oldModel);
		}

		if (oldModelClassName.equals(StudyOptionClp.class.getName())) {
			return translateInputStudyOption(oldModel);
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

	public static Object translateInputActivity(BaseModel<?> oldModel) {
		ActivityClp oldClpModel = (ActivityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getActivityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAssessment(BaseModel<?> oldModel) {
		AssessmentClp oldClpModel = (AssessmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAssessmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCertificate(BaseModel<?> oldModel) {
		CertificateClp oldClpModel = (CertificateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCertificateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCompetencyUnit(BaseModel<?> oldModel) {
		CompetencyUnitClp oldClpModel = (CompetencyUnitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCompetencyUnitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourse(BaseModel<?> oldModel) {
		CourseClp oldClpModel = (CourseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseCareer(BaseModel<?> oldModel) {
		CourseCareerClp oldClpModel = (CourseCareerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseCareerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseCertificate(BaseModel<?> oldModel) {
		CourseCertificateClp oldClpModel = (CourseCertificateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseCertificateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseDuration(BaseModel<?> oldModel) {
		CourseDurationClp oldClpModel = (CourseDurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseDurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseDurationType(BaseModel<?> oldModel) {
		CourseDurationTypeClp oldClpModel = (CourseDurationTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseDurationTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseEnrollContract(
		BaseModel<?> oldModel) {
		CourseEnrollContractClp oldClpModel = (CourseEnrollContractClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseEnrollContractRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseEnrollEsignInfo(
		BaseModel<?> oldModel) {
		CourseEnrollEsignInfoClp oldClpModel = (CourseEnrollEsignInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseEnrollEsignInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseLearning(BaseModel<?> oldModel) {
		CourseLearningClp oldClpModel = (CourseLearningClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseLearningRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseModule(BaseModel<?> oldModel) {
		CourseModuleClp oldClpModel = (CourseModuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseModuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseOutcome(BaseModel<?> oldModel) {
		CourseOutcomeClp oldClpModel = (CourseOutcomeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseOutcomeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFeeDetails(BaseModel<?> oldModel) {
		FeeDetailsClp oldClpModel = (FeeDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFeeDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFeeType(BaseModel<?> oldModel) {
		FeeTypeClp oldClpModel = (FeeTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFeeTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFramework(BaseModel<?> oldModel) {
		FrameworkClp oldClpModel = (FrameworkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFrameworkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFunding(BaseModel<?> oldModel) {
		FundingClp oldClpModel = (FundingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFundingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGraduationCriteria(BaseModel<?> oldModel) {
		GraduationCriteriaClp oldClpModel = (GraduationCriteriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGraduationCriteriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMiscellaneousFees(BaseModel<?> oldModel) {
		MiscellaneousFeesClp oldClpModel = (MiscellaneousFeesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMiscellaneousFeesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputModule(BaseModel<?> oldModel) {
		ModuleClp oldClpModel = (ModuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getModuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputModuleCertificate(BaseModel<?> oldModel) {
		ModuleCertificateClp oldClpModel = (ModuleCertificateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getModuleCertificateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputModuleCompetencyUnit(
		BaseModel<?> oldModel) {
		ModuleCompetencyUnitClp oldClpModel = (ModuleCompetencyUnitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getModuleCompetencyUnitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputModuleFramework(BaseModel<?> oldModel) {
		ModuleFrameworkClp oldClpModel = (ModuleFrameworkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getModuleFrameworkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOutcome(BaseModel<?> oldModel) {
		OutcomeClp oldClpModel = (OutcomeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOutcomeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOutline(BaseModel<?> oldModel) {
		OutlineClp oldClpModel = (OutlineClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOutlineRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPersona(BaseModel<?> oldModel) {
		PersonaClp oldClpModel = (PersonaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPersonaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPersonaAttendee(BaseModel<?> oldModel) {
		PersonaAttendeeClp oldClpModel = (PersonaAttendeeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPersonaAttendeeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProduct(BaseModel<?> oldModel) {
		ProductClp oldClpModel = (ProductClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductCourse(BaseModel<?> oldModel) {
		ProductCourseClp oldClpModel = (ProductCourseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductCourseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductSupervisor(BaseModel<?> oldModel) {
		ProductSupervisorClp oldClpModel = (ProductSupervisorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductSupervisorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProgressionPath(BaseModel<?> oldModel) {
		ProgressionPathClp oldClpModel = (ProgressionPathClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProgressionPathRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSchedule(BaseModel<?> oldModel) {
		ScheduleClp oldClpModel = (ScheduleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScheduleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStudentCourseFee(BaseModel<?> oldModel) {
		StudentCourseFeeClp oldClpModel = (StudentCourseFeeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStudentCourseFeeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStudentCourseFeeInstmnt(
		BaseModel<?> oldModel) {
		StudentCourseFeeInstmntClp oldClpModel = (StudentCourseFeeInstmntClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStudentCourseFeeInstmntRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStudyOption(BaseModel<?> oldModel) {
		StudyOptionClp oldClpModel = (StudyOptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStudyOptionRemoteModel();

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
					"com.sambaash.platform.srv.model.impl.ActivityImpl")) {
			return translateOutputActivity(oldModel);
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
					"com.sambaash.platform.srv.model.impl.AssessmentImpl")) {
			return translateOutputAssessment(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CertificateImpl")) {
			return translateOutputCertificate(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CompetencyUnitImpl")) {
			return translateOutputCompetencyUnit(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseImpl")) {
			return translateOutputCourse(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseCareerImpl")) {
			return translateOutputCourseCareer(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseCertificateImpl")) {
			return translateOutputCourseCertificate(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseDurationImpl")) {
			return translateOutputCourseDuration(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseDurationTypeImpl")) {
			return translateOutputCourseDurationType(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseEnrollContractImpl")) {
			return translateOutputCourseEnrollContract(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoImpl")) {
			return translateOutputCourseEnrollEsignInfo(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseLearningImpl")) {
			return translateOutputCourseLearning(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseModuleImpl")) {
			return translateOutputCourseModule(oldModel);
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
					"com.sambaash.platform.srv.model.impl.CourseOutcomeImpl")) {
			return translateOutputCourseOutcome(oldModel);
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
					"com.sambaash.platform.srv.model.impl.FeeDetailsImpl")) {
			return translateOutputFeeDetails(oldModel);
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
					"com.sambaash.platform.srv.model.impl.FeeTypeImpl")) {
			return translateOutputFeeType(oldModel);
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
					"com.sambaash.platform.srv.model.impl.FrameworkImpl")) {
			return translateOutputFramework(oldModel);
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
					"com.sambaash.platform.srv.model.impl.FundingImpl")) {
			return translateOutputFunding(oldModel);
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
					"com.sambaash.platform.srv.model.impl.GraduationCriteriaImpl")) {
			return translateOutputGraduationCriteria(oldModel);
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
					"com.sambaash.platform.srv.model.impl.MiscellaneousFeesImpl")) {
			return translateOutputMiscellaneousFees(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ModuleImpl")) {
			return translateOutputModule(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ModuleCertificateImpl")) {
			return translateOutputModuleCertificate(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitImpl")) {
			return translateOutputModuleCompetencyUnit(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ModuleFrameworkImpl")) {
			return translateOutputModuleFramework(oldModel);
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
					"com.sambaash.platform.srv.model.impl.OutcomeImpl")) {
			return translateOutputOutcome(oldModel);
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
					"com.sambaash.platform.srv.model.impl.OutlineImpl")) {
			return translateOutputOutline(oldModel);
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
					"com.sambaash.platform.srv.model.impl.PersonaImpl")) {
			return translateOutputPersona(oldModel);
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
					"com.sambaash.platform.srv.model.impl.PersonaAttendeeImpl")) {
			return translateOutputPersonaAttendee(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ProductImpl")) {
			return translateOutputProduct(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ProductCourseImpl")) {
			return translateOutputProductCourse(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ProductSupervisorImpl")) {
			return translateOutputProductSupervisor(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ProgressionPathImpl")) {
			return translateOutputProgressionPath(oldModel);
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
					"com.sambaash.platform.srv.model.impl.ScheduleImpl")) {
			return translateOutputSchedule(oldModel);
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
					"com.sambaash.platform.srv.model.impl.StudentCourseFeeImpl")) {
			return translateOutputStudentCourseFee(oldModel);
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
					"com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntImpl")) {
			return translateOutputStudentCourseFeeInstmnt(oldModel);
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
					"com.sambaash.platform.srv.model.impl.StudyOptionImpl")) {
			return translateOutputStudyOption(oldModel);
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
					"com.sambaash.platform.srv.NoSuchActivityException")) {
			return new com.sambaash.platform.srv.NoSuchActivityException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchAssessmentException")) {
			return new com.sambaash.platform.srv.NoSuchAssessmentException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCertificateException")) {
			return new com.sambaash.platform.srv.NoSuchCertificateException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCompetencyUnitException")) {
			return new com.sambaash.platform.srv.NoSuchCompetencyUnitException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchCourseException")) {
			return new com.sambaash.platform.srv.NoSuchCourseException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseCareerException")) {
			return new com.sambaash.platform.srv.NoSuchCourseCareerException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseCertificateException")) {
			return new com.sambaash.platform.srv.NoSuchCourseCertificateException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseDurationException")) {
			return new com.sambaash.platform.srv.NoSuchCourseDurationException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseDurationTypeException")) {
			return new com.sambaash.platform.srv.NoSuchCourseDurationTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseEnrollContractException")) {
			return new com.sambaash.platform.srv.NoSuchCourseEnrollContractException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException")) {
			return new com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseLearningException")) {
			return new com.sambaash.platform.srv.NoSuchCourseLearningException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseModuleException")) {
			return new com.sambaash.platform.srv.NoSuchCourseModuleException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchCourseOutcomeException")) {
			return new com.sambaash.platform.srv.NoSuchCourseOutcomeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchFeeDetailsException")) {
			return new com.sambaash.platform.srv.NoSuchFeeDetailsException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchFeeTypeException")) {
			return new com.sambaash.platform.srv.NoSuchFeeTypeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchFrameworkException")) {
			return new com.sambaash.platform.srv.NoSuchFrameworkException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchFundingException")) {
			return new com.sambaash.platform.srv.NoSuchFundingException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchGraduationCriteriaException")) {
			return new com.sambaash.platform.srv.NoSuchGraduationCriteriaException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchMiscellaneousFeesException")) {
			return new com.sambaash.platform.srv.NoSuchMiscellaneousFeesException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchModuleException")) {
			return new com.sambaash.platform.srv.NoSuchModuleException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchModuleCertificateException")) {
			return new com.sambaash.platform.srv.NoSuchModuleCertificateException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException")) {
			return new com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchModuleFrameworkException")) {
			return new com.sambaash.platform.srv.NoSuchModuleFrameworkException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchOutcomeException")) {
			return new com.sambaash.platform.srv.NoSuchOutcomeException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchOutlineException")) {
			return new com.sambaash.platform.srv.NoSuchOutlineException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchPersonaException")) {
			return new com.sambaash.platform.srv.NoSuchPersonaException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchPersonaAttendeeException")) {
			return new com.sambaash.platform.srv.NoSuchPersonaAttendeeException();
		}

		if (className.equals("com.sambaash.platform.srv.NoSuchProductException")) {
			return new com.sambaash.platform.srv.NoSuchProductException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchProductCourseException")) {
			return new com.sambaash.platform.srv.NoSuchProductCourseException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchProductSupervisorException")) {
			return new com.sambaash.platform.srv.NoSuchProductSupervisorException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchProgressionPathException")) {
			return new com.sambaash.platform.srv.NoSuchProgressionPathException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchScheduleException")) {
			return new com.sambaash.platform.srv.NoSuchScheduleException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchStudentCourseFeeException")) {
			return new com.sambaash.platform.srv.NoSuchStudentCourseFeeException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException")) {
			return new com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException();
		}

		if (className.equals(
					"com.sambaash.platform.srv.NoSuchStudyOptionException")) {
			return new com.sambaash.platform.srv.NoSuchStudyOptionException();
		}

		return throwable;
	}

	public static Object translateOutputActivity(BaseModel<?> oldModel) {
		ActivityClp newModel = new ActivityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setActivityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAssessment(BaseModel<?> oldModel) {
		AssessmentClp newModel = new AssessmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAssessmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCertificate(BaseModel<?> oldModel) {
		CertificateClp newModel = new CertificateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCertificateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCompetencyUnit(BaseModel<?> oldModel) {
		CompetencyUnitClp newModel = new CompetencyUnitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCompetencyUnitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourse(BaseModel<?> oldModel) {
		CourseClp newModel = new CourseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseCareer(BaseModel<?> oldModel) {
		CourseCareerClp newModel = new CourseCareerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseCareerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseCertificate(BaseModel<?> oldModel) {
		CourseCertificateClp newModel = new CourseCertificateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseCertificateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseDuration(BaseModel<?> oldModel) {
		CourseDurationClp newModel = new CourseDurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseDurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseDurationType(
		BaseModel<?> oldModel) {
		CourseDurationTypeClp newModel = new CourseDurationTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseDurationTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseEnrollContract(
		BaseModel<?> oldModel) {
		CourseEnrollContractClp newModel = new CourseEnrollContractClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseEnrollContractRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseEnrollEsignInfo(
		BaseModel<?> oldModel) {
		CourseEnrollEsignInfoClp newModel = new CourseEnrollEsignInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseEnrollEsignInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseLearning(BaseModel<?> oldModel) {
		CourseLearningClp newModel = new CourseLearningClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseLearningRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseModule(BaseModel<?> oldModel) {
		CourseModuleClp newModel = new CourseModuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseModuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseOutcome(BaseModel<?> oldModel) {
		CourseOutcomeClp newModel = new CourseOutcomeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseOutcomeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFeeDetails(BaseModel<?> oldModel) {
		FeeDetailsClp newModel = new FeeDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFeeDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFeeType(BaseModel<?> oldModel) {
		FeeTypeClp newModel = new FeeTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFeeTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFramework(BaseModel<?> oldModel) {
		FrameworkClp newModel = new FrameworkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFrameworkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFunding(BaseModel<?> oldModel) {
		FundingClp newModel = new FundingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFundingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGraduationCriteria(
		BaseModel<?> oldModel) {
		GraduationCriteriaClp newModel = new GraduationCriteriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGraduationCriteriaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMiscellaneousFees(BaseModel<?> oldModel) {
		MiscellaneousFeesClp newModel = new MiscellaneousFeesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMiscellaneousFeesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputModule(BaseModel<?> oldModel) {
		ModuleClp newModel = new ModuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setModuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputModuleCertificate(BaseModel<?> oldModel) {
		ModuleCertificateClp newModel = new ModuleCertificateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setModuleCertificateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputModuleCompetencyUnit(
		BaseModel<?> oldModel) {
		ModuleCompetencyUnitClp newModel = new ModuleCompetencyUnitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setModuleCompetencyUnitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputModuleFramework(BaseModel<?> oldModel) {
		ModuleFrameworkClp newModel = new ModuleFrameworkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setModuleFrameworkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOutcome(BaseModel<?> oldModel) {
		OutcomeClp newModel = new OutcomeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOutcomeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOutline(BaseModel<?> oldModel) {
		OutlineClp newModel = new OutlineClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOutlineRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPersona(BaseModel<?> oldModel) {
		PersonaClp newModel = new PersonaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPersonaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPersonaAttendee(BaseModel<?> oldModel) {
		PersonaAttendeeClp newModel = new PersonaAttendeeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPersonaAttendeeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProduct(BaseModel<?> oldModel) {
		ProductClp newModel = new ProductClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductCourse(BaseModel<?> oldModel) {
		ProductCourseClp newModel = new ProductCourseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductCourseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductSupervisor(BaseModel<?> oldModel) {
		ProductSupervisorClp newModel = new ProductSupervisorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductSupervisorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProgressionPath(BaseModel<?> oldModel) {
		ProgressionPathClp newModel = new ProgressionPathClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProgressionPathRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSchedule(BaseModel<?> oldModel) {
		ScheduleClp newModel = new ScheduleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScheduleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStudentCourseFee(BaseModel<?> oldModel) {
		StudentCourseFeeClp newModel = new StudentCourseFeeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStudentCourseFeeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStudentCourseFeeInstmnt(
		BaseModel<?> oldModel) {
		StudentCourseFeeInstmntClp newModel = new StudentCourseFeeInstmntClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStudentCourseFeeInstmntRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStudyOption(BaseModel<?> oldModel) {
		StudyOptionClp newModel = new StudyOptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStudyOptionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}