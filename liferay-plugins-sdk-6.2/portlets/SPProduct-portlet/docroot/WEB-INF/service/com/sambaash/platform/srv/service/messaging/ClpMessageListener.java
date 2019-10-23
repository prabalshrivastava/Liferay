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

package com.sambaash.platform.srv.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sambaash.platform.srv.service.ActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.AssessmentLocalServiceUtil;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseEnrollContractLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.OutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaAttendeeLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductCourseLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil;
import com.sambaash.platform.srv.service.ProgressionPathLocalServiceUtil;
import com.sambaash.platform.srv.service.ScheduleLocalServiceUtil;
import com.sambaash.platform.srv.service.StudentCourseFeeInstmntLocalServiceUtil;
import com.sambaash.platform.srv.service.StudentCourseFeeLocalServiceUtil;
import com.sambaash.platform.srv.service.StudyOptionLocalServiceUtil;

/**
 * @author gauravvijayvergia
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ActivityLocalServiceUtil.clearService();

			AssessmentLocalServiceUtil.clearService();

			CertificateLocalServiceUtil.clearService();

			CompetencyUnitLocalServiceUtil.clearService();

			CourseLocalServiceUtil.clearService();

			CourseCareerLocalServiceUtil.clearService();

			CourseCertificateLocalServiceUtil.clearService();

			CourseDurationLocalServiceUtil.clearService();

			CourseDurationTypeLocalServiceUtil.clearService();

			CourseEnrollContractLocalServiceUtil.clearService();

			CourseEnrollEsignInfoLocalServiceUtil.clearService();

			CourseLearningLocalServiceUtil.clearService();

			CourseModuleLocalServiceUtil.clearService();

			CourseOutcomeLocalServiceUtil.clearService();

			FeeDetailsLocalServiceUtil.clearService();

			FeeTypeLocalServiceUtil.clearService();

			FrameworkLocalServiceUtil.clearService();

			FundingLocalServiceUtil.clearService();

			GraduationCriteriaLocalServiceUtil.clearService();

			MiscellaneousFeesLocalServiceUtil.clearService();

			ModuleLocalServiceUtil.clearService();

			ModuleCertificateLocalServiceUtil.clearService();

			ModuleCompetencyUnitLocalServiceUtil.clearService();

			ModuleFrameworkLocalServiceUtil.clearService();

			OutcomeLocalServiceUtil.clearService();

			OutlineLocalServiceUtil.clearService();

			PersonaLocalServiceUtil.clearService();

			PersonaAttendeeLocalServiceUtil.clearService();

			ProductLocalServiceUtil.clearService();

			ProductCourseLocalServiceUtil.clearService();

			ProductSupervisorLocalServiceUtil.clearService();

			ProgressionPathLocalServiceUtil.clearService();

			ScheduleLocalServiceUtil.clearService();

			StudentCourseFeeLocalServiceUtil.clearService();

			StudentCourseFeeInstmntLocalServiceUtil.clearService();

			StudyOptionLocalServiceUtil.clearService();
		}
	}
}