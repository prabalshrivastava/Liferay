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

import com.liferay.counter.service.CounterLocalServiceUtil;
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
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetVocabularyUtil;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class CourseDetailsBatchUploadHelper {

	private PortletRequest request;
	private List<String> errors = new ArrayList<String>();
	private List<String> msgs = new ArrayList<String>();

	public CourseDetailsBatchUploadHelper(PortletRequest request) {
		this.request = request;
	}

	public void bulkupload() throws FileNotFoundException, IOException,
			FileFormatException {
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(request);
		File[] files = uploadPortletRequest.getFiles("file");
		File file = files[0];
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL.EXTENSION)) {
			wb = readFileXlsx(new FileInputStream(file));
		} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
			wb = readFileXls(new FileInputStream(file));
		} else {
			throw new FileFormatException(
					FileFormatException.FILE_TYPE_EXCEPTION);
		}

		if (wb == null) {
			throw new FileFormatException(
					FileFormatException.METADATA_EXCEPTION);
		}

		Sheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			processRow(row);
		}

	}

	public void processRow(Row row) {
		try {
			errorsExists = false;
			long courseId = getLongCellValue(row.getCell(1));
			String courseTitle = getCellValue(row.getCell(2));
			String courseDeveloperName = getCellValue(row.getCell(4));
			String awardingBodyName = getCellValue(row.getCell(5));
			String courseDurationFullTime = getCellValue(row.getCell(6));
			String courseDurationPartTime = getCellValue(row.getCell(7));
			String personaDesc = getCellValue(row.getCell(8));
			String certificateName = getCellValue(row.getCell(9));

			// Validate
			Course course = null;
			if (courseId == 0) {
				addError("CourseId is required", row);
				return;
			} else {
				try {
					course = CourseLocalServiceUtil.getCourse(courseId);
				} catch (Exception e) {
					_log.error(e);
					addError("Error while finding course with courseId = "+ courseId, row);
					return;
				}
			}


			if (!errorsExists) {
				try {
					ThemeDisplay themeDisplay = (ThemeDisplay) request
							.getAttribute(WebKeys.THEME_DISPLAY);

					// setting the course title
					if (Validator.isNotNull(courseTitle)) {
						course.setCourseName(courseTitle);
					}

					
					// setting Course Developer 
					courseDeveloperName = courseDeveloperName.trim();
					courseDeveloperName = courseDeveloperName.replaceAll(String.valueOf((char)160),"");
					if (courseDeveloperName.length() > 0) {
						long courseDeveloperVocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Course Developer").getVocabularyId();
						long courseDeveloperId = getAssetCategoryId(courseDeveloperName, row, courseDeveloperVocabularyId);
						if(courseDeveloperId == 0){
							addError("Error while finding course developer with name = "+ courseDeveloperName, row);
							return;
						}else{
							course.setCourseDeveloperId(courseDeveloperId);
						}
					}

					// setting awarding body
					awardingBodyName = awardingBodyName.trim();
					awardingBodyName = awardingBodyName.replaceAll(String.valueOf((char)160),"");
					if (awardingBodyName.length() > 0) {
						long awardingBodyVocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Awarding Body").getVocabularyId();
						long awardingBodyId = getAssetCategoryId(awardingBodyName, row, awardingBodyVocabularyId);
						if(awardingBodyId == 0){
							addError("Error while finding awarding body with name = "+ awardingBodyName, row);
							return;
						}else{
						course.setAwardingBodyId(awardingBodyId);
						}
					}

					//setting course duration full time
					if (Validator.isNotNull(courseDurationFullTime)) {
						course.setCourseDurationFullTime(courseDurationFullTime);
					}

					//setting course duration part time
					if (Validator.isNotNull(courseDurationPartTime)) {
						course.setCourseDurationPartTime(courseDurationPartTime);
					}
					
					//setting persona description
					if (Validator.isNotNull(personaDesc)) {
						course.setPersonaDesc(personaDesc);
					}
					
					//setting certificate name
					certificateName = certificateName.trim();
					certificateName = certificateName.replaceAll(String.valueOf((char)160),"");
					if (certificateName.length() > 0) {
						try{
							
						Certificate ceritificate = CertificateLocalServiceUtil.findByCertificateNameAndGroupId(certificateName, course.getGroupId());
						List<CourseCertificate> courseCertificateList = CourseCertificateLocalServiceUtil.findByCourseIdAndGroupId(course.getSpCourseId(),course.getGroupId());
						for (CourseCertificate courseCertificate : courseCertificateList){
							CourseCertificateLocalServiceUtil.deleteCourseCertificate(courseCertificate);		
						}	
						
						long courseCertificateId = CounterLocalServiceUtil.increment("CourseCertificate.class");
						CourseCertificate courseCertificate = CourseCertificateLocalServiceUtil.createCourseCertificate(courseCertificateId);
						SambaashUtil.fillAudit(courseCertificate, themeDisplay, courseCertificate.isNew());
						courseCertificate.setGroupId(course.getGroupId());
						courseCertificate.setSpCourseId(course.getSpCourseId());
						courseCertificate.setSpCertificatetId(ceritificate.getSpCertificatetId());
						CourseCertificateLocalServiceUtil.updateCourseCertificate(courseCertificate);
						
						if (course.getCourseType() == 116704){ // course is modular
							for (CourseCertificate courseCertificateModular : courseCertificateList){
								ceritificate = CertificateLocalServiceUtil.fetchCertificate(courseCertificateModular.getSpCertificatetId());
								courseCertificateId = CounterLocalServiceUtil.increment("CourseCertificate.class");
								courseCertificate = CourseCertificateLocalServiceUtil.createCourseCertificate(courseCertificateId);
								SambaashUtil.fillAudit(courseCertificate, themeDisplay, courseCertificate.isNew());
								courseCertificate.setGroupId(course.getGroupId());
								courseCertificate.setSpCourseId(course.getSpCourseId());
								courseCertificate.setSpCertificatetId(ceritificate.getSpCertificatetId());
								CourseCertificateLocalServiceUtil.updateCourseCertificate(courseCertificate);	
							}
						}
						}
						catch (Exception e) {
							_log.error(e);
							addError("Error while finding certificate with name = "+ certificateName, row);
						}
					}

					SambaashUtil.fillAudit(course, themeDisplay, course.isNew());
					CourseLocalServiceUtil.updateCourse(course);
					

					addMsg("Update success", row);

				} catch (SystemException e) {
					_log.error(e);
					addError("Failed", row);
				} catch (Exception e) {
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

	public long getAssetCategoryId(String name, Row row, long vocabularyId) {
		try {
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(vocabularyId, -1, -1, null);
			for (AssetCategory assetCategory : assetCategories) {
				if (assetCategory.getName().equalsIgnoreCase(name))
					return assetCategory.getCategoryId();
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return 0;
	}
	
	boolean errorsExists = false;

	private void addError(String msg, Row row) {
		errorsExists = true;
		getErrors().add("Row No = " + (row.getRowNum() + 1) + "  " + msg);
	}

	private void addMsg(String msg, Row row) {
		getMsgs().add("Row No = " + (row.getRowNum() + 1) + "  " + msg);
	}

	public long getLongCellValue(Cell cell) {
		String val = getCellValue(cell);
		long longVal = (long) GetterUtil.getDouble(val);
		return longVal;
	}

	public String getCellValue(Cell cell) {
		if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
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

	private static final Log _log = LogFactoryUtil
			.getLog(CourseDetailsBatchUploadHelper.class);
}
