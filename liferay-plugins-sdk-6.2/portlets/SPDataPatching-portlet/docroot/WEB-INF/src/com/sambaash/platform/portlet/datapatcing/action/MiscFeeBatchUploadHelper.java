package com.sambaash.platform.portlet.datapatcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.srv.NoSuchMiscellaneousFeesException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class MiscFeeBatchUploadHelper {

	private PortletRequest request;
	private List<String> errors = new ArrayList<String>();
	private List<String> msgs = new ArrayList<String>();
	public MiscFeeBatchUploadHelper(PortletRequest request) {
		this.request = request;
	}

	public void bulkupload() throws FileNotFoundException, IOException, FileFormatException {
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
	   for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		   Row row = sheet.getRow(i);
		   if(row == null){
			   continue;
		   }
		   processRow(row);
	   }
		
	}
	
	public void processRow( Row row ){
		try {
			errorsExists = false;
			long courseId = getLongCellValue(row.getCell(0));
			
			String feeTypeStr = getCellValue(row.getCell(1));
			double amount = GetterUtil.getDouble(getCellValue(row.getCell(2)));
			String remarks = getCellValue(row.getCell(3));
			
			
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
			FeeType feeType = null;
			if(Validator.isNull(feeTypeStr)){
				addError("Fee Type is required. ", row);
			}else{
				try {
					  feeType = FeeTypeLocalServiceUtil.findByFeeType(feeTypeStr);
				} catch (Exception e) {
					_log.error(e);
					addError("Fee Type does not exits. Fee Type =" + feeTypeStr, row);
				}
			}
			
			if(Validator.isNull(remarks )){
				addError("Remarks  is required ", row);
			}
			
			
			
			
			if(!errorsExists){
				try {
					ThemeDisplay themeDisplay = (ThemeDisplay) request
							.getAttribute(WebKeys.THEME_DISPLAY);
					
					MiscellaneousFees fee = null;
					
					try {
						  fee = MiscellaneousFeesLocalServiceUtil.findByCourseIdFeeType(courseId, feeType.getSpFeeTypeId());
						  addMsg("Existing misc fee.", row);
					} catch (NoSuchMiscellaneousFeesException e) {
						fee = MiscellaneousFeesLocalServiceUtil.create();
						_log.error("Misc fee does not exist.. will create one");
						addMsg("New misc fee", row);
					}
					
					SambaashUtil.fillAudit(fee, themeDisplay, fee.isNew());
					
					fee.setSpCourseId(courseId);
					fee.setMiscFeeType(feeType.getSpFeeTypeId());
					fee.setAmount(amount);
					fee.setPayable(getPayable(remarks));
					
					MiscellaneousFeesLocalServiceUtil.updateMiscellaneousFees(fee);
					addMsg("Update success", row);
					 
				} catch (SystemException e) {
					_log.error(e);
					addError("Failed", row);
				}catch (Exception e) {
					_log.error(e);
					addError("Failed", row);
				}
			}
			
		} catch (UnsupportedOperationException e) {
			_log.error(e);
			addError("Cell Type not supported.Row=", row);
		} catch (Exception e) {
			_log.error(e);
			addError("Error while processing row", row);
		}
		
	}
	
	public long getPayable(String payable){
		payable = payable.trim();
		if("Payable upon approval of request".equalsIgnoreCase(payable)){
			return 444841;
		}else if("After the payment due date".equalsIgnoreCase(payable)){
			return 444840;
		}else if("Payable upon approval of module re-enrollment".equalsIgnoreCase(payable)){
			return 416671;
		}else if("Per Module Course Fee".equalsIgnoreCase(payable)){
			return 444905;
		}
		return 0;
	}
	
	
	

	
	boolean errorsExists = false;
	private void addError(String msg,Row row){
		errorsExists = true;
		getErrors().add("Row No = " + (row.getRowNum() +1 ) + "  " + msg );
	}
	
	private void addMsg(String msg, Row row){
		getMsgs().add("Row No = " + (row.getRowNum() +1 ) + "  " + msg );
	}
	
	public long getLongCellValue(Cell cell){
		String val = getCellValue(cell);
		long longVal = (long)GetterUtil.getDouble(val);
		return longVal;
	}
	
	public String getCellValue(Cell cell){
		if(cell == null || cell.getCellType() ==  HSSFCell.CELL_TYPE_BLANK){
			return StringPool.BLANK;
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
        	return "" + cell.getNumericCellValue();
        } else {
          throw new UnsupportedOperationException("Cell type not supported");
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

	private static final Log _log = LogFactoryUtil.getLog(MiscFeeBatchUploadHelper.class);
}
