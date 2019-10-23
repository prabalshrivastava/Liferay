package com.sambaash.platform.util;

import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;
import com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil;

public class CandidateValidator {
	
	public class Response{
		public boolean isValid = false;
		public String reason = "";
		
		public Response(boolean isValid,String reason)
		{
			this.isValid = isValid;
			this.reason = reason;
		}
	}
	
	public Response isValidCandidate(String[] candidate,long companyId,String uploadTransactId, long userId,long uploadedRecordId)
	{
		String sprCode = candidate[0];
        String title = candidate[1];
        String name = candidate[2];
        String gender = candidate[3];
        String dob = candidate[4];
        String IDtype = candidate[5];
        String IDNumber1 = candidate[6];
        String IDNumber2 = candidate[6];
        String addressLine1 = candidate[7];
        String addressLine2 = candidate[8];
        String addressLine3 = candidate[9];
        String addressLine4 = candidate[10];
        String country = candidate[11];
        String postalCode = candidate[12];
        String telephone1 = candidate[13];
        String telephone2 = candidate[14];
        String email = candidate[15];
        String programmeCode = candidate[16];
        String routeCode = candidate[17];
        String facultyCode = candidate[18];
        String moduleCode = candidate[19];
        String moduleOccurance = candidate[20];
        String academicYear = candidate[21];
        String period = candidate[22];
        String courseBlock = "";
        String courseWorkOnly = "";
        String entered = "";
        String[] combinedName = name.split("\\s+");
		
        String firstName = "",middleName = "",lastName = "";
        
        /*switch (combinedName.length) {
		case 1:
			firstName = combinedName[0];
			break;
		
		case 2:
			firstName = combinedName[0];
			lastName = combinedName[1];
			break;
			
		case 3:
			firstName = combinedName[0];
			middleName = combinedName[1];
			lastName = combinedName[2];
			break;*/
        try {
        	EmailValidatorUtil emailValidatorUtil = new EmailValidatorUtil();
            boolean isValidEmail = emailValidatorUtil.validate(email);
            if(!isValidEmail)
            {
            	EnrollBatchUpload enrollUploadStat = EnrollBatchUploadLocalServiceUtil
    					.addEnrollUploadStat(uploadTransactId, email, "Email address is not valid",
    							userId, uploadedRecordId);
            	
            	return new Response(false,"Email address is not valid");
            	//return "Email address is not valid";
            }
            
            if(name.isEmpty() || name == null)
            {
            	EnrollBatchUpload enrollUploadStat = EnrollBatchUploadLocalServiceUtil
    					.addEnrollUploadStat(uploadTransactId, name, "name cannot be empty",
    							userId, uploadedRecordId);
            	
            	return new Response(false,"Name cannot be empty");
            	//return "Name cannot be empty";
            }
            
            if(sprCode.isEmpty() || sprCode == null)
            {
            	EnrollBatchUpload enrollUploadStat = EnrollBatchUploadLocalServiceUtil
    					.addEnrollUploadStat(uploadTransactId, sprCode, "SPRCode cannot be null",
    							userId, uploadedRecordId);
            	
            	return new Response(false,"SPRCode cannot be null");
            	//return "SPRCode cannot be null";
            }
            
            if(IDtype.isEmpty() || IDtype == null)
            {
            	EnrollBatchUpload enrollUploadStat = EnrollBatchUploadLocalServiceUtil
    					.addEnrollUploadStat(uploadTransactId, IDtype, "IDtype cannot be null",
    							userId, uploadedRecordId);
            	
            	return new Response(false,"IDType cannot be null");
            	//return "IDType cannot be null";
            }
            
            if(IDNumber1.isEmpty() || IDNumber1 == null)
            {
            	EnrollBatchUpload enrollUploadStat = EnrollBatchUploadLocalServiceUtil
    					.addEnrollUploadStat(uploadTransactId, IDNumber1, "IDNumber1 cannot be null",
    							userId, uploadedRecordId);
            	
            	return new Response(false,"IDNumber1 cannot be null");
            	//return "IDNumber1 cannot be null";
            }
           
           
//    			if (UserLocalServiceUtil.fetchUserByEmailAddress(companyId,email) != null)
//    			{
//    				EnrollBatchUpload enrollUploadStat = EnrollBatchUploadLocalServiceUtil
//    						.addEnrollUploadStat(uploadTransactId, email, "Email already exist",
//    								userId, uploadedRecordId);
//    				return new Response(false,"Email already exists");
//    				//return "Email address already exists";
//    			}
            
		} catch (Exception e) {
			return new Response(false,"Exception");
			// TODO: handle exception
		}
        return new Response(true,"Student is valid");
	}
}
