package com.sambaash.platform.pe.jsp;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.course.enroll.CourseEnrollEntranceTestJSPHelper;
import com.sambaash.platform.pe.course.enroll.CourseEnrollEsignEngine;
import com.sambaash.platform.pe.course.enroll.CourseEnrollFeeHelper;
import com.sambaash.platform.pe.course.enroll.CourseEnrollRegisterInterestJSPHelper;
import com.sambaash.platform.pe.course.enroll.ProductsWithInventoryHelper;
import com.sambaash.platform.pe.course.enroll.SubjectSelectionHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;

public class PEJSPRegistry {

	private static PEJSPRegistry instance = new PEJSPRegistry();


	public static PEJSPRegistry getRegistry(){
		return instance;
	}
	
	public PEJSPRegistry(){
		
	}

	// use this method if ruleset is in hand
	public PEJSPHelper getJspHelper(PERuleSet ruleset,PEDataSource ds, PEJSP jspNode){
		return getJspHelper(ruleset.getComponentId(), ds, jspNode);
	}
	// use this method if ruleset is in hand
	public PEJSPHelper getJspHelper(PEDataSource ds, PEJSP jspNode){
		return getJspHelper(jspNode.getJspName(), ds, jspNode);
	}
	// simple lookup
	public PEJSPHelper getJspHelper(String name,PEDataSource ds, PEJSP jspNode){
		PEJSPHelper jspHelper = null;
		if("esign".equalsIgnoreCase(name)){
			jspHelper = CourseEnrollEsignEngine.getInstance(ds,jspNode);
		}else if("feeDetails".equalsIgnoreCase(name)){
			jspHelper = CourseEnrollFeeHelper.getInstance(ds, jspNode);
		}else if("testlink".equalsIgnoreCase(name)){
			jspHelper = CourseEnrollEntranceTestJSPHelper.getInstance(ds, jspNode);
		}else if("participants".equalsIgnoreCase(name)){
			jspHelper = ProductsWithInventoryHelper.getInstance(ds, jspNode);
		}else if("inventoryPaymentMode".equalsIgnoreCase(name)){
			jspHelper = ProductsWithInventoryHelper.getInstance(ds, jspNode);
		}else if("paymentConfirmation".equalsIgnoreCase(name)){
			jspHelper = ProductsWithInventoryHelper.getInstance(ds, jspNode);
		}else if("subjectSelection".equalsIgnoreCase(name)){
			jspHelper = SubjectSelectionHelper.getInstance(ds, jspNode);
		}else if("registerInterest".equalsIgnoreCase(name)){
			jspHelper = CourseEnrollRegisterInterestJSPHelper.getInstance(ds, jspNode);
		}else{
			jspHelper = new PEJSPHelper(ds, jspNode);
		}
		
		
		return jspHelper;
	}
}
