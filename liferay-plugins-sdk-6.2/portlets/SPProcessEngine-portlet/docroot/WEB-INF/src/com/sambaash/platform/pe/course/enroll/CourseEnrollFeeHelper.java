package com.sambaash.platform.pe.course.enroll;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.model.StudentCourseFee;
import com.sambaash.platform.srv.model.StudentCourseFeeInstmnt;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.StudentCourseFeeInstmntLocalServiceUtil;
import com.sambaash.platform.srv.service.StudentCourseFeeLocalServiceUtil;

public class CourseEnrollFeeHelper extends PEJSPHelper {

	
	private CourseEnrollFeeHelper(PEDataSource dataSource,PEJSP jspNode){
		super(dataSource,jspNode);
	}
	
	public static CourseEnrollFeeHelper getInstance(PEDataSource dataSource,PEJSP jspNode){
		return new CourseEnrollFeeHelper(dataSource,jspNode);
	}
	
	public boolean isFeeDetailsCompleted(){
		try {
			// check if fee details exist, if so consider as fee detaail step completed
			List<StudentCourseFee> list = StudentCourseFeeLocalServiceUtil.findByProcessStateId(ds.getProcessState().getSpPEProcessStateId());
			if(!list.isEmpty()){
				return true;
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return false;
	}
	
	/**
	 * Fee details are fetch from Fee & Funding screen of Course Page (Product APP).
	 * 
	 * There are multiple sets of Fee Details.Each set may have certial discuount based on some criteria (age,salary,citizenship etc..).
	 * 
	 * This method will get the appropriate fee details set and returns as json array
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONArray getCourseFeeDetails() throws Exception{
		Funding funding ;
		try {
			// check if the student is applicable for any funding listed in course screen
			 funding = getFundingApplicable();
		} catch (PortalException | SystemException e) {
			_log.error("Error while finding the funding applicable",e);
			throw e;
		}
		List<FeeDetails> feeList;

		Product product = ProductLocalServiceUtil.getProduct(ds.getProcessState().getEntityId());
		if(funding != null){
			_log.debug("Funding Id Applicable " + funding.getSpFundingId());
			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
			dataAdapter.store("fundingApplied", String.valueOf(funding.getSpFundingId()));
			PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
			// if student is eligible for funding
			feeList = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(funding.getSpFundingId(), product.getSpCourseId()); 
		}else{
			_log.debug("Funding Not Applicable. Hence taking default fees");
			// if no funding exists/not eligible, then default course fee will be applied
			feeList = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(0, product.getSpCourseId()); 
		}
		
		// convert to json
		JSONArray feeDetailArray = JSONFactoryUtil.createJSONArray();
		JSONObject feeJson;
		int feeLabel = 65; // char 'A'
		for (FeeDetails feeDetails : feeList) {
			feeJson = JSONFactoryUtil.createJSONObject();
			try {
				FeeType feeType = FeeTypeLocalServiceUtil.getFeeType(feeDetails
						.getFeeType());
				boolean disableEdit = false;
				if(CourseEnrollConstants.FEE_TYPE_COURSE_FEE.equalsIgnoreCase(feeType.getFeeType()) || CourseEnrollConstants.FEE_TYPE_WDA_GRANT.equalsIgnoreCase(feeType.getFeeType()) ){
					disableEdit = true; 
				}
				// round the value to two digits
				BigDecimal calculatedAmount = InFixExpressionEvaluator.getBigDecimalWithRounding(String.valueOf(feeDetails.getAmount()));
				feeDetailArray.put(createFeeJson(String.valueOf((char)feeLabel), feeType.getFeeType(), StringPool.BLANK,calculatedAmount.toPlainString() ,disableEdit));
				feeLabel = feeLabel + 1;
			} catch (Exception e) {
				_log.error(e);
			}
		}
		
		return feeDetailArray;
	}

	public static JSONArray getCourseFeeDetails(PEDataSource dataSource) throws Exception{
		Funding funding ;
		try {
			// check if the student is applicable for any funding listed in course screen
			 funding = getFundingApplicable(dataSource);
		} catch (PortalException | SystemException e) {
			_log.error("Error while finding the funding applicable",e);
			throw e;
		}
		List<FeeDetails>feeList;

		Product product = ProductLocalServiceUtil.getProduct(dataSource.getProcessState().getEntityId());
		if(funding != null){
			_log.debug("Funding Id Applicable " + funding.getSpFundingId());
			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
			dataAdapter.store("fundingApplied", String.valueOf(funding.getSpFundingId()));
			PEProcessStateHelper.updateProcessStateSafe(dataSource.getProcessState(), dataSource.getRequestData());
			// if student is eligible for funding
			feeList = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(funding.getSpFundingId(), product.getSpCourseId()); 
		}else{
			_log.debug("Funding Not Applicable. Hence taking default fees");
			// if no funding exists/not eligible, then default course fee will be applied
			feeList = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(0, product.getSpCourseId()); 
		}
		
		// convert to json
		JSONArray feeDetailArray = JSONFactoryUtil.createJSONArray();
		JSONObject feeJson;
		int feeLabel = 65; // char 'A'
		for (FeeDetails feeDetails : feeList) {
			feeJson = JSONFactoryUtil.createJSONObject();
			try {
				FeeType feeType = FeeTypeLocalServiceUtil.getFeeType(feeDetails
						.getFeeType());
				boolean disableEdit = false;
				if(CourseEnrollConstants.FEE_TYPE_COURSE_FEE.equalsIgnoreCase(feeType.getFeeType()) || CourseEnrollConstants.FEE_TYPE_WDA_GRANT.equalsIgnoreCase(feeType.getFeeType()) ){
					disableEdit = true; 
				}
				// round the value to two digits
				BigDecimal calculatedAmount = InFixExpressionEvaluator.getBigDecimalWithRounding(String.valueOf(feeDetails.getAmount()));
				feeDetailArray.put(createFeeJson(String.valueOf((char)feeLabel), feeType.getFeeType(), StringPool.BLANK,calculatedAmount.toPlainString() ,disableEdit));
				feeLabel = feeLabel + 1;
			} catch (Exception e) {
				_log.error(e);
			}
		}
		
		return feeDetailArray;
	}
	
	// If fee details already saved from Process engine screen, then those rows will be returned
	// Else fee details from product app will be returned.
	public JSONArray getExistingFeeDetails(){
		JSONArray defaultFeeRows = null;
		try {
			if(isFeeDetailsCompleted()){
				defaultFeeRows = JSONFactoryUtil.createJSONArray();
				List<StudentCourseFee>feeList = StudentCourseFeeLocalServiceUtil.findByProcessStateId(ds.getProcessState().getSpPEProcessStateId());
				for (StudentCourseFee fee : feeList) {
					defaultFeeRows.put(createFeeJson(fee.getLabel(), fee.getFeeType(), fee.getFormula(), fee.getAmount(),false));
				}
			}else{
				defaultFeeRows = getCourseFeeDetails();
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return defaultFeeRows;
	}
	public JSONArray getExistingInsmntDetails(){
		JSONArray instmntsJArray = JSONFactoryUtil.createJSONArray();
		try {
			List<StudentCourseFeeInstmnt>instmntList = StudentCourseFeeInstmntLocalServiceUtil.findByProcessStateId(ds.getProcessState().getSpPEProcessStateId());
			for (StudentCourseFeeInstmnt insmnt : instmntList) {
				JSONObject insmntJ = JSONFactoryUtil.createJSONObject();
				insmntJ.put("instmntAmount", insmnt.getAmount());
				insmntJ.put("date", getDateString(insmnt.getDate()));
				instmntsJArray.put(insmntJ);
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return instmntsJArray;
	}
	
	private static JSONObject createFeeJson(String feeLabel,String feeType,String formula,String feeAmount,boolean isDefault){
		JSONObject fee = JSONFactoryUtil.createJSONObject();
		fee.put("feeLabel",feeLabel );
		fee.put("feeType", feeType);
		fee.put("formula", formula);
		fee.put("feeAmount", feeAmount);
		fee.put("default", isDefault); // default will make feetype uneditable and remove button wont displayed
		return fee;
	}
	
	private Funding getFundingApplicable() throws PortalException, SystemException{
		return getFundingApplicable(ds);
	}
	
	public static Funding getFundingApplicable(PEDataSource dataSource) throws PortalException, SystemException{

		CourseEnrollDataAdapter data =  CourseEnrollDataAdapter.getCourseEnrollAdapter(dataSource);
		PEProcessState processState = dataSource.getProcessState();
		Funding applicable = null;
		Product product = ProductLocalServiceUtil.getProduct(processState.getEntityId());
		List<Funding>fundings = FundingLocalServiceUtil.findByCourseIdOrderByFundOrder(product.getSpCourseId());
		
		long sponseredBy = data.getSponseredBy();
		long residenceStatus = data.getResidenceStatus();
		double age = data.getAgeYear();
		String salary = data.getSalary();

		List<Funding>filtered1 = new ArrayList<Funding>();
		
		for (Funding funding : fundings) {
			if(isSponseredByMatched(sponseredBy, funding.getSponsoredBy())){
				filtered1.add(funding);
			}
		}
		
		List<Funding> filtered2 = new ArrayList<Funding>();
		for (Funding funding : filtered1) {
			if(isResidenceStatusMatched(residenceStatus, funding.getResidenceStatus())){
				filtered2.add(funding);
			}
		}
		
		//Collections.sort(filtered2, Collections.reverseOrder(new AgeSalaryComparator()));;
		
		for (Funding funding : filtered2) {
			if(isAgeMatched(age, funding.getAge(), funding.getAgeOperator())){
				if(isSalaryMatched(salary, funding.getSalary(), funding.getSalaryOperator())){
					applicable = funding;
					break;
				}
			}
		}
		return applicable;
	}
	
	private static boolean isSponseredByMatched(long sponseredBy1, long sponseredBy2){
		return sponseredBy1 == sponseredBy2;
	}
	
	private static boolean isResidenceStatusMatched(long residence1,String residence2){
		if(Validator.isNull(residence2)){
			//  residence status check is not required 
			return true;
		}
		String statuss[]  = GetterUtil.getString(residence2).trim().split(StringPool.COMMA);
		boolean dataExists = false;
		for (String status : statuss) {
			if(Validator.isNotNull(status) && GetterUtil.getLong(status)==0){
			//  residence status check is not required . Product app might have configured to not to have residence status
				return true;
			}
			if(GetterUtil.getLong(status) != 0){
			 	dataExists = true;
				if( residence1 == GetterUtil.getLong(status)){
					return true;
				}
			}
		}
		
		// if data does not exists means funding is independent of residence status
		return !dataExists;
	}

	private static boolean isAgeMatched(double studentAge, double allowedAge,String operator){
		switch (operator) {
		case SambaashConstants.GREATER_THAN_CODE: return studentAge > allowedAge;
		case SambaashConstants.GREATER_THAN_OR_EQUAL_CODE: return studentAge >= allowedAge;
		case SambaashConstants.LESS_THAN_CODE: return studentAge < allowedAge;
		case SambaashConstants.LESS_THAN_OR_EQUAL_CODE: return studentAge <= allowedAge;
		case SambaashConstants.EQUAL_CODE: return studentAge == allowedAge;
		default:
			// this case happens if age comparison is not required
			return true;
		}
	}
	private static boolean isSalaryMatched(String studentSalary, double allowedSalary,String operator){
		
		try{
			 String sals[] = studentSalary.split(StringPool.DASH);
			 if(sals.length > 1){
				 double lower = GetterUtil.getDouble(sals[0]);
				 double higher = 0d;
				 if(CourseEnrollConstants.SALARY_MAX.equalsIgnoreCase(sals[1])){
					 higher = Double.MAX_VALUE;
				 }else{
					 higher = GetterUtil.getDouble(sals[1]);
				 }
				 
				//student is unemployed and there is some salary criteria which is not applicable to unemployed
				if(allowedSalary > 0 && (lower == 0d || higher == 0)){
						return false;
				}
				
				switch (operator) {
				case SambaashConstants.GREATER_THAN_CODE: return higher > allowedSalary;
				case SambaashConstants.GREATER_THAN_OR_EQUAL_CODE: return higher >= allowedSalary;
				case SambaashConstants.LESS_THAN_CODE: return lower < allowedSalary;
				case SambaashConstants.LESS_THAN_OR_EQUAL_CODE: return lower <= allowedSalary;
				case SambaashConstants.EQUAL_CODE: return lower == allowedSalary || higher == allowedSalary;
				default:
					// this case happens if the salary comparison is not requried
					return true;
				}
				 
			 }
		}catch(Exception ex){
			_log.error("Error while matching salary component of student with funding salary range",ex);
		}
		return false;
	}
	
	
	private void clearExistingData() throws SystemException, PortalException{
		List<StudentCourseFee>feesList = StudentCourseFeeLocalServiceUtil.findByProcessStateId(ds.getProcessState().getSpPEProcessStateId());
		for (StudentCourseFee studentCourseFee : feesList) {
			StudentCourseFeeLocalServiceUtil.deleteStudentCourseFee(studentCourseFee.getSpStudentCourseFeeId());
		}
		
		List<StudentCourseFeeInstmnt>insmntList = StudentCourseFeeInstmntLocalServiceUtil.findByProcessStateId(ds.getProcessState().getSpPEProcessStateId());
		for (StudentCourseFeeInstmnt studentCourseFeeInstmnt : insmntList) {
			
			StudentCourseFeeInstmntLocalServiceUtil.deleteStudentCourseFeeInstmnt(studentCourseFeeInstmnt.getSpStudentCourseFeeInstmntId());
		}
	}
	public PESimpleOutput save() throws PEException{
		PESimpleOutput output = new PESimpleOutput();
		
		JSONObject obj;
		try {
			obj = JSONFactoryUtil.createJSONObject(ds.getFormJspData());
			clearExistingData();
			JSONArray feeArray = obj.getJSONArray("feeDetails");
			int feeCount = feeArray.length();
			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
			
			//saving course fee
			int order = 1;
			for (int i = 0; i < feeCount ; i++) {
				JSONObject fee = feeArray.getJSONObject(i);
				
				StudentCourseFee courseFee = StudentCourseFeeLocalServiceUtil.create();
				courseFee.setFeeType(fee.getString("feeType"));
				//TODO: Generat here
				courseFee.setOrder(order++);
				courseFee.setAmount(fee.getString("feeAmount"));
				courseFee.setLabel(fee.getString("feeLabel"));
				courseFee.setFormula(fee.getString("formula"));
				courseFee.setSpPEProcessStateId(ds.getProcessState().getSpPEProcessStateId());
				
				PEHelper.fillAudit(courseFee, ds.getRequestData(), courseFee.isNew());
				StudentCourseFeeLocalServiceUtil.updateStudentCourseFee(courseFee);
				if(CourseEnrollConstants.FEE_TYPE_COURSE_FEE.equalsIgnoreCase(courseFee.getFeeType())) {
					ds.getProcessState().setAmount(courseFee.getAmount());
				}
				dataAdapter.store(courseFee.getFeeType(), courseFee.getAmount());
			}
			JSONObject otherCourseFeeInfo = getOtherCourseFeeInfo();
			dataAdapter.store("ccy", otherCourseFeeInfo.getString("ccy"));
			dataAdapter.store("courseId", otherCourseFeeInfo.getString("courseId"));
			
			//installments data
			JSONArray insmntsArray = obj.getJSONArray("instmnts");
			if(insmntsArray != null){
				int insmntCount = insmntsArray.length();
				for(int i = 0 ; i < insmntCount ; i++){
					JSONObject fee = insmntsArray.getJSONObject(i);
					
					StudentCourseFeeInstmnt insmnt = StudentCourseFeeInstmntLocalServiceUtil.create();
					insmnt.setInsmntNo(fee.getInt("insmntNo"));
					insmnt.setAmount(fee.getString("instmntAmount"));
					insmnt.setDate(getDate(fee.getString("date")));
					insmnt.setSpPEProcessStateId(ds.getProcessState().getSpPEProcessStateId());
					StudentCourseFeeInstmntLocalServiceUtil.updateStudentCourseFeeInstmnt(insmnt);
				}
			}
		} catch (ParseException |SystemException | PortalException e) {
			_log.error(e);
			throw new PEException("Error while saving Fee Details");
		} 
		
		//Audit the save/submit
		audit();
		// Success message
		output.setSuccessMsg("Details saved successfully");

		return output;
	}
	
	private JSONObject getOtherCourseFeeInfo() {
		return getOtherCourseFeeInfo(ds);
	}

	public static JSONObject getOtherCourseFeeInfo(PEDataSource datasource) {
		String currencyCode = ""; long courseId = 0;
		JSONObject courseInfoJson = JSONFactoryUtil.createJSONObject();
		try {
		   Product product = ProductLocalServiceUtil.getProduct(datasource.getProcessState().getEntityId());
		   Course course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
		   Country country = CountryServiceUtil.getCountryByName(AssetCategoryLocalServiceUtil
		         .getAssetCategory(Long.parseLong(course.getCountryId())).getName().toLowerCase());
		   Locale localeTemp = new Locale("", country.getA2());
		   currencyCode = Currency.getInstance(localeTemp).getCurrencyCode();
		   courseId = course.getSpCourseId();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		courseInfoJson.put("ccy", currencyCode);
		courseInfoJson.put("courseId", String.valueOf(courseId));
		return courseInfoJson;
	}

	private static Date getDate(String dateStr) throws ParseException{
		if(Validator.isNotNull(dateStr)){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			return format.parse(dateStr);
		}
		return null;
	}
	public static String getDateString(Date date){
		if(date != null){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			return format.format(date);
		}
		return StringPool.BLANK;
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollFeeHelper.class);
}
