package com.sambaash.platform.pe.course.enroll;

import java.util.Arrays;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jsp.PEJSPHelper;

public class SubjectSelectionHelper extends PEJSPHelper {
	private static final String SUBJECT = "subject";
	private static final String SITTING_TYPE = "sittingType";
	private static final String SELECTED_SUB_PRICING = "selectedSubPricing";
	private static final String OUTPUT_VALIDATION_STR = "outputValidationStr";
	//private static final String ENABLE_TEMP_STORAGE_VALIDATION = "enableTempStorageValidation";
	public static Log logger = LogFactoryUtil.getLog(SubjectSelectionHelper.class);
			
	public SubjectSelectionHelper(PEDataSource ds, PEJSP jspNode) {
		super(ds, jspNode);
	}

	public static SubjectSelectionHelper getInstance(PEDataSource dataSource,PEJSP jspNode){
		return new SubjectSelectionHelper(dataSource, jspNode);
	}
	
	public PESimpleOutput save() throws PEException{
		PESimpleOutput output = new PESimpleOutput();
		PERequestData requestData = ds.getRequestData();
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		
		String actionType = requestData.getParameter("action");
		boolean saveOk = true;
		switch (actionType) {
		
		case "subjectSelection":
			saveOk = saveSujectDetails(dataAdapter, requestData);			
			break;

		default:
			saveOk = false;
		}
		
		if (saveOk) {
			//Audit the save/submit
			audit();
			// Success message
			output.setSuccessMsg("Details saved successfully");
		} else {
			output.setError(new PEError("Unable to save the details"));	
		}
		
		return output;
	}

	

	private boolean saveSujectDetails(PEProcessStateDataAdapter dataAdapter,
			PERequestData requestData) {
		boolean saveResult = true;
		try{
			String sittingType = requestData.getParameter("sittingType_hidden");
			if (Validator.isNull(sittingType)){
				sittingType = requestData.getParameter("sittingType");
			}
		
			if (Validator.isNull(sittingType)){
				saveResult = false; 
				return saveResult;
			}
			
			String[] subject = requestData.getParameterValues("subject");
			
			if (subject == null || subject.length == 0){
				saveResult = false; 
				return saveResult;
			} 
			
			if (saveResult){
				
				dataAdapter.store(SITTING_TYPE, sittingType);
				
				StringBuilder sb = new StringBuilder();
				for (String str : subject)
					sb.append(str).append(",");
				
				dataAdapter.store(SUBJECT, sb.substring(0, sb.length() - 1));
				
				String selectedSubPricing = requestData.getParameter("selectedSubPricing");
				dataAdapter.store(SELECTED_SUB_PRICING, selectedSubPricing);
				
				String outputValidationStr = requestData.getParameter("outputValidationStr");
				dataAdapter.store(OUTPUT_VALIDATION_STR, outputValidationStr);		
				
				PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
			}
			return saveResult;
		} catch (Exception e){
			saveResult = false;
			return saveResult;
		}
	}
	
}
