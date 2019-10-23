package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;

import org.apache.commons.lang3.SerializationUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.NoSuchCourseCareerException;
import com.sambaash.platform.srv.NoSuchCourseDurationException;
import com.sambaash.platform.srv.NoSuchCourseLearningException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseCareer;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.CourseDuration;
import com.sambaash.platform.srv.model.CourseDurationType;
import com.sambaash.platform.srv.model.CourseLearning;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.CourseOutcome;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.GraduationCriteria;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.model.Persona;
import com.sambaash.platform.srv.model.StudyOption;
import com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;
import com.sambaash.platform.srv.service.StudyOptionLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

public class CopyCourseUtil {

	public static String COURSE_ID = "spCourseId";

	public static JSONObject copyCourse(RenderRequest renderRequest) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {


			long courseId = ParamUtil.getLong(renderRequest, COURSE_ID);
			Course course = CourseLocalServiceUtil.fetchCourse(courseId);

			// Course
			Course clonedCourse = SerializationUtils.clone(course);
			clonedCourse.setSpCourseId(CounterLocalServiceUtil.increment("Course.class"));
			clonedCourse.setCourseName("Copy of " + clonedCourse.getCourseName());
			clonedCourse.setCourseCode("Copy of " + clonedCourse.getCourseCode());

			SambaashUtil.fillAudit(clonedCourse, themeDisplay, true);

			clonedCourse = CourseLocalServiceUtil.updateCourse(clonedCourse);

			_log.error(" original courseId : " + course.getSpCourseId() + " : clonedCourseId : "
					+ clonedCourse.getSpCourseId());

			// Course Module
			List<CourseModule> courseModuleList = CourseModuleLocalServiceUtil.findByCourseIdAndGroupId(
					course.getSpCourseId(), themeDisplay.getScopeGroupId());

			for (CourseModule courseModule : courseModuleList) {
				CourseModule clonedCourseModule = SerializationUtils.clone(courseModule);
				clonedCourseModule.setSpCourseModuleId(CounterLocalServiceUtil.increment("CourseModule.class"));
				clonedCourseModule.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedCourseModule, themeDisplay, true);

				CourseModuleLocalServiceUtil.updateCourseModule(clonedCourseModule);
			}

			// Course Outcome
			List<CourseOutcome> courseOutcomeList = CourseOutcomeLocalServiceUtil.findByCourseIdAndGroupId(
					course.getSpCourseId(), themeDisplay.getScopeGroupId());

			for (CourseOutcome courseOutcome : courseOutcomeList) {
				CourseOutcome clonedCourseOutcome = SerializationUtils.clone(courseOutcome);

				clonedCourseOutcome.setSpCourseOutcomeId(CounterLocalServiceUtil.increment("CourseOutcome.class"));

				clonedCourseOutcome.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedCourseOutcome, themeDisplay, true);

				CourseOutcomeLocalServiceUtil.updateCourseOutcome(clonedCourseOutcome);
			}

			// Course Certificate
			List<CourseCertificate> courseCertificateList = CourseCertificateLocalServiceUtil.findByCourseIdAndGroupId(
					course.getSpCourseId(), themeDisplay.getScopeGroupId());

			for (CourseCertificate courseCertificate : courseCertificateList) {
				CourseCertificate clonedCourseCertificate = SerializationUtils.clone(courseCertificate);
				clonedCourseCertificate.setSpCourseCertificateId(CounterLocalServiceUtil
						.increment("CourseCertificate.class"));

				clonedCourseCertificate.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedCourseCertificate, themeDisplay, true);

				CourseCertificateLocalServiceUtil.updateCourseCertificate(clonedCourseCertificate);

			}

			// Persona
			List<Persona> personaList = PersonaLocalServiceUtil.findByCourseIdAndGroupId(course.getSpCourseId(),
					themeDisplay.getScopeGroupId());
			for (Persona persona : personaList) {
				Persona clonedPersona = SerializationUtils.clone(persona);

				clonedPersona.setSpPersonaId(CounterLocalServiceUtil.increment("Persona.class"));
				clonedPersona.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedPersona, themeDisplay, true);

				PersonaLocalServiceUtil.updatePersona(clonedPersona);

			}

			// How you learn
			try {

				// Course Learning
				CourseLearning courseLearning = CourseLearningLocalServiceUtil.findByCourseId(course.getSpCourseId());
				CourseLearning clonedCourseLearning = SerializationUtils.clone(courseLearning);

				clonedCourseLearning.setSpCourseLearningId(CounterLocalServiceUtil.increment("CourseLearning"));
				clonedCourseLearning.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedCourseLearning, themeDisplay, true);

				clonedCourseLearning = CourseLearningLocalServiceUtil.updateCourseLearning(clonedCourseLearning);

				_log.error("clonedCourseLearning.getSpCourseLearningId() : "
						+ clonedCourseLearning.getSpCourseLearningId() + " : clonedCourseLearning.getSpCourseId() : "
						+ clonedCourseLearning.getSpCourseId() + " : course.getSpCourseId() : "
						+ course.getSpCourseId() + " : courseLearning.getSpCourseLearningId() : "
						+ courseLearning.getSpCourseLearningId());

				// Course Duration
				CourseDuration courseDuration = CourseDurationLocalServiceUtil.findByCourseId(course.getSpCourseId());

				CourseDuration clonedCourseDuration = SerializationUtils.clone(courseDuration);

				clonedCourseDuration.setSpCourseDurationId(CounterLocalServiceUtil.increment("CourseDuration"));

				clonedCourseDuration.setSpCourseLearningId(clonedCourseLearning.getSpCourseLearningId());
				clonedCourseDuration.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedCourseDuration, themeDisplay, true);

				clonedCourseDuration = CourseDurationLocalServiceUtil.updateCourseDuration(clonedCourseDuration);

				// Course Duration Type

				List<CourseDurationType> courseDurationTypeList = CourseDurationTypeLocalServiceUtil
						.findByCourseId(course.getSpCourseId());
				for (CourseDurationType courseDurationType : courseDurationTypeList) {

					CourseDurationType clonedCourseDurationType = SerializationUtils.clone(courseDurationType);
					clonedCourseDurationType.setSpCourseDurationTypeId(CounterLocalServiceUtil
							.increment("CourseDurationType"));

					clonedCourseDurationType.setSpCourseDurationId(clonedCourseDuration.getSpCourseDurationId());
					clonedCourseDurationType.setSpCourseId(clonedCourse.getSpCourseId());

					SambaashUtil.fillAudit(clonedCourseDurationType, themeDisplay, true);

					CourseDurationTypeLocalServiceUtil.updateCourseDurationType(clonedCourseDurationType);
				}

			} catch (NoSuchCourseLearningException | NoSuchCourseDurationException e) {
				_log.error(e);
			}

			// Advance Your Career
			try {
				CourseCareer courseCareer = CourseCareerLocalServiceUtil.findByCourseId(course.getSpCourseId());
				CourseCareer clonedCourseCareer = SerializationUtils.clone(courseCareer);
				clonedCourseCareer.setSpCourseCareerId(CounterLocalServiceUtil.increment("CourseCareer"));
				clonedCourseCareer.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedCourseCareer, themeDisplay, true);

				CourseCareerLocalServiceUtil.updateCourseCareer(clonedCourseCareer);

				// Study Option
				List<StudyOption> studyOptionList = StudyOptionLocalServiceUtil.findByCourseId(course.getSpCourseId());
				for (StudyOption studyOption : studyOptionList) {
					StudyOption clonedStudyOption = SerializationUtils.clone(studyOption);
					clonedStudyOption.setSpStudyOptionId(CounterLocalServiceUtil.increment("StudyOption"));
					clonedStudyOption.setSpCourseId(clonedCourse.getSpCourseId());

					SambaashUtil.fillAudit(clonedStudyOption, themeDisplay, true);

					StudyOptionLocalServiceUtil.updateStudyOption(clonedStudyOption);

				}

			} catch (NoSuchCourseCareerException e) {
				_log.error(e);
			}

			// Graduation Criteria
			List<GraduationCriteria> graduationCriteriaList = GraduationCriteriaLocalServiceUtil
					.findByCourseIdAndGroupId(course.getSpCourseId(), themeDisplay.getScopeGroupId());

			for (GraduationCriteria graduationCriteria : graduationCriteriaList) {

				GraduationCriteria clonedGraduationCriteria = SerializationUtils.clone(graduationCriteria);

				clonedGraduationCriteria.setSpGraduationCriteriaId(CounterLocalServiceUtil
						.increment("GraduationCriteria.class"));
				clonedGraduationCriteria.setSpCourseId(clonedCourse.getSpCourseId());

				SambaashUtil.fillAudit(clonedGraduationCriteria, themeDisplay, true);

				GraduationCriteriaLocalServiceUtil.updateGraduationCriteria(clonedGraduationCriteria);
			}

			// Course Funding
			List<Funding> fundingList = FundingLocalServiceUtil.findByCourseIdAndGroupId(course.getSpCourseId(),
					themeDisplay.getScopeGroupId());
			if(fundingList.isEmpty()){
				List<FeeDetails> feeDetailsList = FeeDetailsLocalServiceUtil.findByCourseIdAndGroupId(course.getSpCourseId(), themeDisplay.getScopeGroupId());
				for (FeeDetails feeDetails : feeDetailsList) {
					FeeDetails clonedFeeDetails = SerializationUtils.clone(feeDetails);
					clonedFeeDetails.setSpFeeDetailsId(CounterLocalServiceUtil.increment("FeeDetails.class"));
					clonedFeeDetails.setSpCourseId(clonedCourse.getSpCourseId());
	
					SambaashUtil.fillAudit(clonedFeeDetails, themeDisplay, true);
					FeeDetailsLocalServiceUtil.updateFeeDetails(clonedFeeDetails);
				}
			}else{
				for (Funding funding : fundingList) {
					Funding clonedFunding = SerializationUtils.clone(funding);
					long clonedFundingId = CounterLocalServiceUtil.increment("Funding.class");
					clonedFunding.setSpFundingId(clonedFundingId);
					clonedFunding.setSpCourseId(clonedCourse.getSpCourseId());
	
					SambaashUtil.fillAudit(clonedFunding, themeDisplay, true);
					FundingLocalServiceUtil.updateFunding(clonedFunding);
				
	
				// Course Fee
				List<FeeDetails> feeDetailsList = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(funding.getSpFundingId(),course.getSpCourseId());
				for (FeeDetails feeDetails : feeDetailsList) {
					FeeDetails clonedFeeDetails = SerializationUtils.clone(feeDetails);
					clonedFeeDetails.setSpFeeDetailsId(CounterLocalServiceUtil.increment("FeeDetails.class"));
					clonedFeeDetails.setSpCourseId(clonedCourse.getSpCourseId());
					clonedFeeDetails.setFundId(clonedFundingId);
	
					SambaashUtil.fillAudit(clonedFeeDetails, themeDisplay, true);
					FeeDetailsLocalServiceUtil.updateFeeDetails(clonedFeeDetails);
				}
				}
			}	
			
			// Miscellaneous Fee
						List<MiscellaneousFees> miscFeeList = MiscellaneousFeesLocalServiceUtil.findByCourseIdAndGroupId(
								course.getSpCourseId(), themeDisplay.getScopeGroupId());
						for (MiscellaneousFees miscFee : miscFeeList) {
							MiscellaneousFees clonedMiscFeeDetails = SerializationUtils.clone(miscFee);
							clonedMiscFeeDetails.setSpMiscFeesId(CounterLocalServiceUtil.increment("MiscellaneousFees.class"));
							clonedMiscFeeDetails.setSpCourseId(clonedCourse.getSpCourseId());

							SambaashUtil.fillAudit(clonedMiscFeeDetails, themeDisplay, true);
							MiscellaneousFeesLocalServiceUtil.updateMiscellaneousFees(clonedMiscFeeDetails);
						}

			CourseLocalServiceUtil.clearCache();

			response.put("copyFlag", "success");

		} catch (Exception e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.course.copy"));
		}

		return response;
	}

	private static Log _log = LogFactoryUtil.getLog(CopyCourseUtil.class);

}
