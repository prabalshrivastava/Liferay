package com.sambaash.platform.pe.helpers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.course.enroll.CourseEnrollEsignEngine;
import com.sambaash.platform.pe.course.enroll.CourseEnrollFeeHelper;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

public class PEJSPHelperOld {

	private PEDataSource dataSource;
	private PEJSP jspNode;

	private PEJSPHelperOld(PEDataSource dataSource, PEJSP jspNode) {
		this.dataSource = dataSource;
		this.jspNode = jspNode;
	}

	public static PEJSPHelperOld getJspHelper(PEDataSource dataSource, PEJSP jspNode) {
		return new PEJSPHelperOld(dataSource, jspNode);
	}

	public boolean canProceedToNextStep() throws PEException, SystemException, PortalException {
		boolean canProceed = true;
		PERuleSet ruleset = PERuleSetLocalServiceUtil.getPERuleSet(jspNode.getRuleSetId());
		if ("esign".equalsIgnoreCase(ruleset.getComponentId())) {

			CourseEnrollEsignEngine esignEngine = CourseEnrollEsignEngine.getInstance(dataSource, jspNode);
			canProceed = esignEngine.isSigningCompleted();
		} else if ("feeDetails".equalsIgnoreCase(ruleset.getComponentId())) {
			CourseEnrollFeeHelper feeHelper = CourseEnrollFeeHelper.getInstance(dataSource, jspNode);
			canProceed = feeHelper.isFeeDetailsCompleted();
		} else if ("testlink".equalsIgnoreCase(ruleset.getComponentId())) {
			canProceed = false;
		} /*
			 * else if("assignRole".equalsIgnoreCase(ruleset.getComponentId())){
			 * canProceed = false; }
			 */

		return canProceed;
	}

	public void handleDataSubmission() throws PEException, SystemException, PortalException {
		PERuleSet ruleset = PERuleSetLocalServiceUtil.getPERuleSet(jspNode.getRuleSetId());
		if ("feeDetails".equalsIgnoreCase(ruleset.getComponentId())) {
			CourseEnrollFeeHelper feeHelper = CourseEnrollFeeHelper.getInstance(dataSource, jspNode);
			feeHelper.save();
		}

	}
}
