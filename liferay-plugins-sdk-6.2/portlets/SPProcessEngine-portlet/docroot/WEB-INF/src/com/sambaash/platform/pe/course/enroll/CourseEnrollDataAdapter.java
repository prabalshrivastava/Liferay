package com.sambaash.platform.pe.course.enroll;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.helpers.PEHelper;

/**
 *  Class used to work as adapter between Form data and application.
 *  
 *  Responsible for returning the data requested by application.
 *  
 * 
 * @author nareshchebolu
 *
 */
public class CourseEnrollDataAdapter {

	private PEDataSource dataSource;
	private PEProcessStateDataAdapter processStateDataAdapter;
	
	private CourseEnrollDataAdapter(PEDataSource dataSource){
		this.dataSource = dataSource;
		this.processStateDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
	}
	
	public static CourseEnrollDataAdapter getCourseEnrollAdapter(PEDataSource dataSource){
		return new CourseEnrollDataAdapter(dataSource);
	}
	
	// categoryId
	public long getResidenceStatus(){
		return GetterUtil.getLong(getFieldSimpleValue("residenceStatus"));
	}
	// categoryId
	public String getResidenceStatusDisplayText(){
		return processStateDataAdapter.getSimpleDisplayText("residenceStatus");
	}
	//category Id SME, NOn-SME or Self
	public long getSponseredBy(){
		return GetterUtil.getLong(getFieldSimpleValue("sponsoredBy"));
	}
	//category Id SME, NOn-SME or Self
	public String getSponseredByDisplayText(){
		return processStateDataAdapter.getSimpleDisplayText("sponsoredBy");
	}
	
	public String getStudentIdentityDocType(){
		return getFieldSimpleValue("studentIdentityDocType");
	}
	public String getStudentIdentityDocNum(){
		return getFieldDisplayText("studentIdentityDocNum");
	}
	
	public String getStudentNricNum(){
		String docType = getStudentIdentityDocType();
		if("nric".equalsIgnoreCase(docType)){
			return getStudentIdentityDocNum();
		}
		return StringPool.BLANK;
	}
	public String getStudentPassportNum(){
		String docType = getStudentIdentityDocType();
		if("passport".equalsIgnoreCase(docType)){
			return getStudentIdentityDocNum();
		}
		return StringPool.BLANK;
	}

	public String getLinkedInProfile(){
		return processStateDataAdapter.getDataFromProcessState("linkedInProfile");
	}
	public String getGaurdIanFullName(){
		return processStateDataAdapter.getDataFromProcessState("gaurdianFullName");
	}
	public String getGaurdIanContactNumber(){
		return processStateDataAdapter.getDataFromProcessState("guardianContactNumber");
	}
	public String getGuardianEmail(){
		return processStateDataAdapter.getDataFromProcessState("guardianEmail");
	}
	public String getGaurdIanIdentityDocNum(){
		return processStateDataAdapter.getDataFromProcessState("gaurdianIdentityDocNum");
	}
	public String getSponsorCompany(){
		return processStateDataAdapter.getDataFromProcessState("sponsorCompanyName");
	}
	public String getStudentNameInIdentityDoc(){
		return processStateDataAdapter.getDataFromProcessState("nameInIdentityDoc");
	}
	public Date getStudeisCommencementDate(){
		String dateStr = processStateDataAdapter.getDataFromProcessState("studiesCommencementDate");;
		Date date = PEHelper.getDate4rDDMMYYYY(dateStr);
		return date;
	}
	public Date getCourseCommencementDate(){
		String dateStr = processStateDataAdapter.getDataFromProcessState("courseCommencementDate");
		Date date = PEHelper.getDate4rDDMMYYYY(dateStr);
		return date;
	}
	
	public boolean isUploadedSponsorCompanyLetter(){
		return  processStateDataAdapter.isAttachhmentExists("sponsorCompanyLetter");
	}
	public boolean isUploadedIdentityDoc(){
		return processStateDataAdapter.isAttachhmentExists("identityDocument");
	}
	public boolean isUploadedHighestQualificationCertificate(){
		return processStateDataAdapter.isAttachhmentExists("highestQualificationCertificate");
	}
	public boolean isUploadedResume(){
		return processStateDataAdapter.isAttachhmentExists("resume");
	}
	public boolean isUploadedRecentPhoto(){
		return processStateDataAdapter.isAttachhmentExists("recentPhoto");
	}
	public String getYesorNo(boolean flag){
		if(flag){
			return "Yes";
		}
		return "No";
	}

	public String getSalary(){
		String salaryStr = getFieldSimpleValue("monthlyIncome");
		return salaryStr;
	}
	public String getSalaryDisplayText(){
		String salaryStr = getFieldDisplayText("monthlyIncome");
		return salaryStr;
	}
	
	public boolean isFullTime(){
		String type = processStateDataAdapter.getDataFromProcessState("courseDurationType");
		return type.toLowerCase().contains("full");
	}
	
	public Date getDateOfBirth(){
		String dobstr =  GetterUtil.getString(processStateDataAdapter.getDataFromProcessState("dateOfBirth"));
		Date dob = PEHelper.getDate4rDDMMYYYY(dobstr);
		
		return dob;
	}
	
	public double getAge1(){
		Date dob = getDateOfBirth();
		long days = 0;
		if(dob != null){
			CalendarUtil.getAge(dob, Calendar.getInstance());
			days = DateUtil.getDaysBetween(dob, DateUtil.newDate());
		}
		//keep d
		return days/364d; 
	}
	public double getAgeYear(){
		Date dob = getDateOfBirth();
		int diffYears = 0;
		if(dob != null){
			Calendar today = Calendar.getInstance();
			Calendar birthday = Calendar.getInstance();

			birthday.setTime(dob);

			diffYears = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
		}
		return diffYears; 
	}

	public String getFieldValue(String fieldName){
		return processStateDataAdapter.getDataFromProcessState(fieldName);
	}
	public String getFieldDisplayText(String fieldName){
		return processStateDataAdapter.getSimpleDisplayText(fieldName);
	}
	
	public String getFieldSimpleValue(String fieldName){
		return processStateDataAdapter.getSimpleValue(fieldName);
	}
	
	public boolean isStudentMinor(){
		if(getAgeYear() < 18){
			return true;
		}
		return false;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollDataAdapter.class);
}
