package com.sambaash.platform.portlet.datapatcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.srv.NoSuchFeeDetailsException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class FeeFundingBatchUploadHelper {

	private PortletRequest request;
	private List<String> errors = new ArrayList<String>();
	private List<String> msgs = new ArrayList<String>();
	private Set<Long> courseIds_fee_cleared = new HashSet<Long>();
	public FeeFundingBatchUploadHelper(PortletRequest request) {
		this.request = request;
	}

	public void bulkuploadFeeFunding() throws FileNotFoundException, IOException, FileFormatException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		File[] files = uploadPortletRequest.getFiles("file");
		File file = files[0];
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL.EXTENSION)) {
			wb = readFileXlsx(new FileInputStream(file));
		} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
			wb = readFileXls(new FileInputStream(file));
		} else {
			throw new FileFormatException(FileFormatException.FILE_TYPE_EXCEPTION);
		}

		if (wb == null) {
			throw new FileFormatException(FileFormatException.METADATA_EXCEPTION);
		}
		
	   Sheet sheet = wb.getSheetAt(0);
	   for (int i = 2; i <= sheet.getLastRowNum(); i++) {
		   Row row = sheet.getRow(i);
		   if(row == null){
			   continue;
		   }
		   processRowFeeFunding(row);
	   }
		
	}
	
	public void processRowFeeFunding( Row row ){
		errorsExists = false;
		try {
			long courseId = getCellValueLongType(row.getCell(0));
			_log.debug("Processing Row = " + row.getRowNum() + "CourseId = " + courseId);
			String sponseredByStr = getCellValue(row.getCell(1));
			long sponserBy = getSponseredBy(sponseredByStr);
			String residenceStatus = getCellValue(row.getCell(2));
			String ageOperator="";
			try {
				ageOperator = getOperator(getCellValue(row.getCell(3)));
			} catch (Exception e1) {
				_log.error(e1);
				addError(e1.getMessage(), row);
				return;
			}
			String ageStr = getCellValue(row.getCell(4));
			long age = (long)GetterUtil.getDouble(ageStr);
			String salaryOperator;
			try {
				salaryOperator = getOperator(getCellValue(row.getCell(5)));
			} catch (Exception e1) {
				_log.error(e1);
				addError(e1.getMessage(), row);
				return;
			}
			String salaryStr = getCellValue(row.getCell(6));
			double salary = GetterUtil.getDouble(salaryStr);
			String notes = getCellValue(row.getCell(7));
			long evalOrder = getCellValueLongType(row.getCell(8));
			String fee = getCellValue(row.getCell(9));
			String feeAmountStr = getCellValue(row.getCell(10));
			//String feeAmount = GetterUtil.getString(feeAmountStr);
			String displayOrderStr  = getCellValue(row.getCell(11));
			int displayOrder  = (int)GetterUtil.getDouble(displayOrderStr);
			
			//Validate
			Course course = null;
			if(courseId == 0){
				addError("CourseId is required", row);
				return;
			}else{
				try {
					course = CourseLocalServiceUtil.getCourse(courseId);
				} catch (Exception e) {
					_log.error(e);
					addError("Error while finding course with courseId = " + courseId,row);
					return;
				}
			}
			
			if( (Validator.isNotNull(ageOperator) && Validator.isNull(ageStr) )|| (Validator.isNull(ageOperator) && Validator.isNotNull(ageStr)) ){
				addError("Provide values for both Age Operator and Age. Else Dont provide to any ", row);
			}
			if( (Validator.isNotNull(salaryOperator) && Validator.isNull(salaryStr) )|| (Validator.isNull(salaryOperator) && Validator.isNotNull(salaryStr)) ){
				addError("Provide values for both Salary Operator and Salary. Else Dont provide to any ", row);
			}
			
			FeeType feeType = null;
			if(Validator.isNull(fee)){
				addError("Fee Component is required. ", row);
			}else{
				try {
					feeType = FeeTypeLocalServiceUtil.findByFeeType(fee);
				} catch (Exception e) {
					_log.error(e);
					addError("Fee Type does not exits. Fee Type =" + fee, row);
				}
			}
			
			if(Validator.isNull(feeAmountStr)){
				addError("Fee Amount is required", row);
			}
			if(Validator.isNull(displayOrderStr )){
				addError("Display Order is required ", row);
			}
			
			if(!errorsExists){
				try {
					ThemeDisplay themeDisplay = (ThemeDisplay) request
							.getAttribute(WebKeys.THEME_DISPLAY);
					if(!courseIds_fee_cleared.contains(courseId)){
						
						List<FeeDetails> feeList = FeeDetailsLocalServiceUtil.findByCourseIdAndGroupId(courseId, themeDisplay.getScopeGroupId());
						for(FeeDetails feeDetail : feeList){
							FeeDetailsLocalServiceUtil.deleteFeeDetails(feeDetail);
						}
						
						List<Funding> fundingList = FundingLocalServiceUtil.findByCourseIdAndGroupId(courseId, themeDisplay.getScopeGroupId());
						for(Funding fund : fundingList){
							FundingLocalServiceUtil.deleteFunding(fund);
						}
					}
					
					courseIds_fee_cleared.add(courseId);
					
					// Some decimal values wont be represented correctly. Hence it has to be rounded correctly
					BigDecimal bg = new BigDecimal(feeAmountStr);
					bg = bg.setScale(2, BigDecimal.ROUND_HALF_DOWN);
					feeAmountStr = bg.toPlainString();

					FeeDetails feeDetails = null;
					long fundId = 0;
					if(Validator.isNull(sponseredByStr) && Validator.isNull(residenceStatus) &&
							Validator.isNull(ageOperator) && age < 1 &&
							Validator.isNull(salaryOperator) && salary < 1){
						fundId = 0;
						//Without funding
						try {
							feeDetails = FeeDetailsLocalServiceUtil.findByCourseIdFundIdFeeType(courseId, 0, feeType.getSpFeeTypeId());
						} catch (NoSuchFeeDetailsException e) {
							_log.error("Fee Details does not exist. It going to be created");
						}
						
						if(feeDetails == null){
							feeDetails = FeeDetailsLocalServiceUtil.create();
							feeDetails.setFundId(fundId);
						}
						
						SambaashUtil.fillAudit(feeDetails, themeDisplay, feeDetails.isNew());
						feeDetails.setDisplayOrder(displayOrder);
						feeDetails.setAmount(feeAmountStr);
						feeDetails.setFeeType(feeType.getSpFeeTypeId());
						feeDetails.setFeeDesc(feeType.getFeeTypeDesc());
						feeDetails.setSpCourseId(course.getSpCourseId());
						
						
						FeeDetailsLocalServiceUtil.updateFeeDetails(feeDetails);
						_log.debug("Fee details updated successfully FeeDetails Id= " + feeDetails.getSpFeeDetailsId() + "Course Id = " + feeDetails.getSpCourseId());
						addMsg("Success", row);
					}else{
						try {
							AssetCategory catg = AssetCategoryLocalServiceUtil.getAssetCategory(sponserBy);
						} catch (Exception e) {
							addError("Invalided Sponsored By. Category does not exist", row);
							return;
						}
						// With Funding
						
						Funding funding = getFundingObj(courseId, sponserBy, residenceStatus, ageOperator, age, salaryOperator, salary);
						if(funding == null){
							funding = FundingLocalServiceUtil.create();
						}
						SambaashUtil.fillAudit(funding, themeDisplay, funding.isNew());
						
						funding.setSpCourseId(courseId);
						funding.setSponsoredBy(sponserBy);
						funding.setResidenceStatus(getResidenceStatusIds(residenceStatus));
						funding.setAgeOperator(ageOperator);
						funding.setAge(age);
						funding.setSalaryOperator(salaryOperator);
						funding.setSalary(salary);
						if(evalOrder > 0){
							funding.setFundOrder(evalOrder);
						}
						if(Validator.isNotNull(notes)){
							funding.setFundingDesc(notes);
						}
						FundingLocalServiceUtil.updateFunding(funding);
						
						_log.debug("Funding details updated success fully id=" + funding.getSpFundingId() + " CourseId = " + funding.getSpCourseId());
						
						fundId = funding.getSpFundingId();
						feeDetails = null;
						try {
							feeDetails = FeeDetailsLocalServiceUtil.findByCourseIdFundIdFeeType(courseId, fundId, feeType.getSpFeeTypeId());
						} catch (NoSuchFeeDetailsException e) {
							
						}
						
						if(feeDetails == null){
							feeDetails = FeeDetailsLocalServiceUtil.create();
							feeDetails.setFundId(fundId);
						}
						
						SambaashUtil.fillAudit(feeDetails, themeDisplay, feeDetails.isNew());
						feeDetails.setDisplayOrder(displayOrder);
						feeDetails.setAmount(feeAmountStr);
						feeDetails.setFeeType(feeType.getSpFeeTypeId());
						feeDetails.setSpCourseId(course.getSpCourseId());
						feeDetails.setFeeDesc(feeType.getFeeTypeDesc());
						
						
						FeeDetailsLocalServiceUtil.updateFeeDetails(feeDetails);
						_log.debug("Fee details updated successfully FeeDetails Id= " + feeDetails.getSpFeeDetailsId() + "Course Id = " + feeDetails.getSpCourseId());
						
						addMsg("Success", row);
					}
					
					
					
				} catch (SystemException e) {
					_log.error(e);
					addError("Failed", row);
				}catch (Exception e) {
					_log.error(e);
					addError("Failed", row);
				}
			}
			
			
		} catch (UnsupportedOperationException e) {
			addError("Cell value is unsupported.", row);
		} catch (Exception e) {
			addError("Exception while processing", row);
		}
	}
	
	public long getSponseredBy(String sponseredBy){
		if("sme".equalsIgnoreCase(sponseredBy)){
			return 119901;
		}else if("non-sme".equalsIgnoreCase(sponseredBy)){
			return 116718;
		}else if("self".equalsIgnoreCase(sponseredBy)){
			return 119902;
		}
		return 0;
	}
	
	public long getResidenceStatusId(String residence){
		residence = residence.trim();
		if("Singapore pr".equalsIgnoreCase(residence)){
			return 119853;
		}else if("Singapore Citizen".equalsIgnoreCase(residence)){
			return 119854;
		}else if("Others".equalsIgnoreCase(residence)){
			return 326618;
		}
		return 0;
	}
	
	public String getOperator(String operatorStr) throws Exception{
		if(Validator.isNull(operatorStr)){
			return StringPool.BLANK;
		}
		if(operatorStr.contains(">=")) return SambaashConstants.GREATER_THAN_OR_EQUAL_CODE;
		if(operatorStr.contains(">")) return SambaashConstants.GREATER_THAN_CODE;
		if(operatorStr.contains("<=")) return SambaashConstants.LESS_THAN_OR_EQUAL_CODE;
		if(operatorStr.contains("<")) return SambaashConstants.LESS_THAN_CODE;
		if(operatorStr.contains("=")) return SambaashConstants.EQUAL_CODE;
		
		throw new Exception("Invalid Operator");
		
		
	}
	
	public String getResidenceStatusIds(String residenceStatus){
		String result = StringPool.BLANK;
		if(residenceStatus.indexOf('+') != -1){
			String str[] = residenceStatus.split("\\+");
			for (String string : str) {
				if(Validator.isNotNull(string)){
					long id = getResidenceStatusId(string);
					if(id > 0 && Validator.isNotNull(result)){
						result = result + "," + id;
					}else{
						result = String.valueOf(id);
					}
				}
			}
		}else{
			long id = getResidenceStatusId(residenceStatus);
			result = String.valueOf(id);
		}
		return result;
	}
	public Funding getFundingObj(long courseId, long sponsoredBy,String residenceStatus,String ageOperator,long age,String salaryOperator,double salary) throws SystemException{
		DynamicQuery query  = null;
		try {
			query = DynamicQueryFactoryUtil.forClass(Funding.class,PortletClassLoaderUtil.getClassLoader("Product_WAR_SPProductportlet"));
		} catch (Exception e) {
			_log.error("Error while getting dynamic query");
			query = DynamicQueryFactoryUtil.forClass(Funding.class,PortalClassLoaderUtil.getClassLoader());
		}
		query.add(RestrictionsFactoryUtil.eq("spCourseId", courseId));
		query.add(RestrictionsFactoryUtil.eq("sponsoredBy", sponsoredBy));
		
		if(Validator.isNotNull(residenceStatus)){
			String result =getResidenceStatusIds(residenceStatus);
			query.add(RestrictionsFactoryUtil.eq("residenceStatus", result));
		}
		
		if(Validator.isNotNull(ageOperator) && age > 0){
			query.add(RestrictionsFactoryUtil.eq("ageOperator", ageOperator));
			query.add(RestrictionsFactoryUtil.eq("age", (double)age));
		}
		if(Validator.isNotNull(salaryOperator) && salary > 0){
			query.add(RestrictionsFactoryUtil.eq("salaryOperator", salaryOperator));
			query.add(RestrictionsFactoryUtil.eq("salary", salary));
		}
		
		List<Funding> list = FundingLocalServiceUtil.dynamicQuery(query);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
		
		
	}
	
	boolean errorsExists = false;
	private void addError(String msg,Row row){
		errorsExists = true;
		getErrors().add("Row No = " + (row.getRowNum() +1 ) + "  " + msg );
	}
	
	private void addMsg(String msg, Row row){
		getMsgs().add("Row No = " + (row.getRowNum() +1 ) + "  " + msg );
	}
	
	public long getCellValueLongType(Cell cell){
		String val = getCellValue(cell);
		long longVal = (long)GetterUtil.getDouble(val);
		return longVal;
	}
	
	public String getCellValue(Cell cell) throws UnsupportedOperationException{
		if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
			return StringPool.BLANK;
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
        	return "" + cell.getNumericCellValue();
        } else {
          throw new UnsupportedOperationException("Unsupported cell value");
        }
	}

	public static HSSFWorkbook readFileXls(InputStream inputStream)
			throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	public static XSSFWorkbook readFileXlsx(InputStream inputStream)
			throws IOException {
		return new XSSFWorkbook(inputStream);
	}
	
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}

	private static final Log _log = LogFactoryUtil.getLog(FeeFundingBatchUploadHelper.class);
}
